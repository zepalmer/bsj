package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.names.InitialNameCategorizationVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.names.PackageOrTypeNameCategorizationVisitor;

/**
 * This task performs name categorization for the provided compilation unit.
 * 
 * @author Zachary Palmer
 * 
 */
public class CategorizeNamesTask extends AbstractBsjCompilerTask
{
	/** The node for which name categorization should occur. */
	private Node node;
	/** The injection information for metaprograms found in this subtree. */
	private InjectionInfo injectionInfo;

	/**
	 * Creates a new task for name categorization of an AST subtree.
	 * 
	 * @param node The subtree to categorize.
	 * @param profile The metaprogram which was most recently responsible for creating or modifying that subtree or
	 *            <code>null</code> if no metaprogram has modified it.
	 */
	public CategorizeNamesTask(Node node, InjectionInfo injectionInfo)
	{
		super(TaskPriority.CATEGORIZE);
		this.node = node;
		this.injectionInfo = injectionInfo;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		// Assign initial name categories (JLS v3 §6.5.1)
		InitialNameCategorizationVisitor initialNameCategorizationVisitor = new InitialNameCategorizationVisitor();
		this.node.receiveTyped(initialNameCategorizationVisitor);

		// Disambiguate PACKAGE_OR_TYPE names (JLS v3 §6.5.3)
		PackageOrTypeNameCategorizationVisitor packageOrTypeNameCategorizationVisitor = new PackageOrTypeNameCategorizationVisitor(
				context.getToolkit().getNodeFactory());
		this.node.receiveTyped(packageOrTypeNameCategorizationVisitor);

		// TODO: now disambiguate AMBIGUOUS names (JLS v3 §6.5.2)

		// Now enqueue the compilation unit for meta-annotation object instantiation
		context.registerTask(new InstantiateMetaAnnotationObjectTask(this.node, this.injectionInfo));
	}
}
