package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
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
	/** The compilation unit for which name categorization should occur. */
	private CompilationUnitNode compilationUnitNode;

	public CategorizeNamesTask(CompilationUnitNode compilationUnitNode)
	{
		super(TaskPriority.CATEGORIZE);
		this.compilationUnitNode = compilationUnitNode;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		// Assign initial name categories (JLS v3 §6.5.1)
		InitialNameCategorizationVisitor initialNameCategorizationVisitor = new InitialNameCategorizationVisitor();
		this.compilationUnitNode.receiveTyped(initialNameCategorizationVisitor);

		// Disambiguate PACKAGE_OR_TYPE names (JLS v3 §6.5.3)
		PackageOrTypeNameCategorizationVisitor packageOrTypeNameCategorizationVisitor = new PackageOrTypeNameCategorizationVisitor(
				context.getToolkit().getNodeFactory());
		this.compilationUnitNode.receiveTyped(packageOrTypeNameCategorizationVisitor);

		// TODO: now disambiguate AMBIGUOUS names (JLS v3 §6.5.2)

		// Now enqueue the compilation unit for meta-annotation object instantiation
		context.registerTask(new InstantiateMetaAnnotationObjectTask(this.compilationUnitNode));
	}
}
