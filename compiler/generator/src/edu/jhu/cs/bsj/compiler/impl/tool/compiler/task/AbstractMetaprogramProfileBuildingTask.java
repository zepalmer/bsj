package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.operations.EnclosingNameNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;

public abstract class AbstractMetaprogramProfileBuildingTask<A extends MetaprogramAnchorNode<B>, B extends Node> extends
		AbstractBsjCompilerTask
{
	/** A field containing the factory which should be used as this task is executing. */
	protected BsjNodeFactory factory;
	/** A field containing the metacompilation context which should be used as this task is executing. */
	protected MetacompilationContext metacompilationContext;
	/** A field containing the anchor of the metaprogram to extract. */
	protected A anchor;
	/** A field containing the injection information for this metaprogram or <code>null</code> if it was not injected. */
	protected InjectionInfo injectionInfo;

	public AbstractMetaprogramProfileBuildingTask(TaskPriority priority, A anchor, InjectionInfo injectionInfo)
	{
		super(priority);
		this.anchor = anchor;
		this.injectionInfo = injectionInfo;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		this.factory = context.getToolkit().getNodeFactory();
		this.metacompilationContext = context;

		// Build a metaprogram profile for this anchor
		MetaprogramProfile<?,?> profile = buildProfile(context);
		if (profile == null)
		{
			return;
		}
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Metaprogram " + profile.getMetaprogram().getID() + " created with deps "
					+ profile.getDependencies() + " and targets " + profile.getTargetNames());
		}

		// Register the metaprogram profile with the metacompilation manager
		metacompilationContext.getDependencyManager().registerMetaprogramProfile(profile,
				this.injectionInfo.getParentProfile(), metacompilationContext.getDiagnosticListener());
	}

	/**
	 * Retrieves the name of the type surrounding the metaprogram.
	 * 
	 * @return The name of the type surrounding the metaprogram.
	 */
	protected String getMetaprogramTypeName()
	{
		NameNode nameNode = anchor.executeOperation(new EnclosingNameNodeOperation(factory), null);
		if (nameNode == null)
		{
			// TODO: handle anonymous inner classes correctly
			nameNode = factory.makeSimpleNameNode(factory.makeIdentifierNode(anchor.getNearestAncestorOfType(
					CompilationUnitNode.class).getName()));
		} else
		{
			Node node = anchor;
			while (node != null && !(node instanceof CompilationUnitNode) && !(node instanceof TypeDeclarationNode))
			{
				node = node.getParent();
			}
			boolean isTopLevelMetaprogram = (node instanceof CompilationUnitNode);
			if (isTopLevelMetaprogram)
			{
				nameNode = factory.makeQualifiedNameNode(
						nameNode,
						factory.makeIdentifierNode(anchor.getNearestAncestorOfType(CompilationUnitNode.class).getName()));
			}
		}
		return nameNode.getNameString();
	}

	/**
	 * This stub indicates to the subclass that it should use the anchor to create a metaprogram profile.
	 * 
	 * @param context The metacompilation context for this profile.
	 * @return The profile for the anchor that this task contains or <code>null</code> if some error prevented the
	 *         profile's construction.
	 * @throws IOException If an I/O error occurs.
	 */
	protected abstract MetaprogramProfile<A,B> buildProfile(MetacompilationContext context) throws IOException;
}
