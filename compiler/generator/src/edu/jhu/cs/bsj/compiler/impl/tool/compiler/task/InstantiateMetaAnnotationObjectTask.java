package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

/**
 * This task performs annotation object creation for a given AST.
 * @author Zachary Palmer
 */
public class InstantiateMetaAnnotationObjectTask extends AbstractBsjCompilerTask
{
	/** The node this task will use. */
	private Node root;
	
	/**
	 * Creates an instance of this task.
	 * @param root The node representing the root of the AST to walk.
	 */
	public InstantiateMetaAnnotationObjectTask(Node root)
	{
		super(TaskPriority.CREATE_METAANNOTATION_OBJECT);
		this.root = root;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		this.root.receiveTyped(new BsjTypedNodeNoOpVisitor()
		{
			@Override
			public void visitMetaAnnotationNodeStop(MetaAnnotationNode node)
			{
				node.instantiateMetaAnnotationObject();
			}
		});
		
		// Now enqueue for metaprogram extraction
		context.registerTask(new ExtractMetaprogramsTask(this.root));
	}
}
