package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations.EnclosingNameNodeOperation;

public abstract class AbstractMetaprogramProfileBuildingTask<A extends MetaprogramAnchorNode<?>> extends
		AbstractBsjCompilerTask
{
	/** A field containing the factory which should be used as this task is executing. */
	protected BsjNodeFactory factory;
	/** A field containing the metacompilation context which should be used as this task is executing. */
	protected MetacompilationContext metacompilationContext;
	/** A field containing the anchor of the metaprogram to extract. */
	protected A anchor;

	public AbstractMetaprogramProfileBuildingTask(TaskPriority priority, A anchor)
	{
		super(priority);
		this.anchor = anchor;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		this.factory = context.getToolkit().getNodeFactory();
		this.metacompilationContext = context;

		// Build a metaprogram profile for this anchor
		MetaprogramProfile<?> profile = buildProfile();
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Metaprogram " + profile.getMetaprogram().getID() + " created with deps "
					+ profile.getDependencyNames() + " and targets " + profile.getTargetNames());
		}

		// Register the metaprogram profile with the metacompilation manager
		metacompilationContext.getDependencyManager().registerMetaprogramProfile(profile);
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
					CompilationUnitNode.class).getName()), NameCategory.TYPE);
		} else if (nameNode.getCategory() == NameCategory.PACKAGE)
		{
			nameNode = factory.makeQualifiedNameNode(nameNode,
					factory.makeIdentifierNode(anchor.getNearestAncestorOfType(CompilationUnitNode.class).getName()),
					NameCategory.TYPE);
		}
		return nameNode.getNameString();
	}

	/**
	 * This stub indicates to the subclass that it should use the anchor to create a metaprogram profile.
	 * @return The profile for the anchor that this task contains.
	 * @throws IOException If an I/O error occurs.
	 */
	protected abstract MetaprogramProfile<A> buildProfile() throws IOException;
}