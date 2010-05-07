package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
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
	/** The injection information to be passed to metaprograms which are extracted. */
	private InjectionInfo injectionInfo;

	/**
	 * Creates an instance of this task.
	 * @param root The node representing the root of the AST to walk.
	 * @param profile The metaprogram which was most recently responsible for modifying that subtree or
	 *            <code>null</code> if no metaprogram has modified it.
	 */
	public InstantiateMetaAnnotationObjectTask(Node root, InjectionInfo injectionInfo)
	{
		super(TaskPriority.CREATE_METAANNOTATION_OBJECT);
		this.root = root;
		this.injectionInfo = injectionInfo;
	}

	@Override
	public void execute(final MetacompilationContext context) throws IOException
	{
		this.root.receiveTyped(new BsjTypedNodeNoOpVisitor()
		{
			@Override
			public void visitMetaAnnotationNodeStop(MetaAnnotationNode node)
			{
				try
				{
					node.instantiateMetaAnnotationObject(context.getDiagnosticListener());
				} catch (MetaAnnotationInstantiationFailureException e)
				{
					// TODO: if this happens, the metacompilation manager needs to know that we failed
					// Do we need to do anything special or does the error in the diagnostic listener handle that?
				}
			}
		});
		
		// Now enqueue for metaprogram extraction
		context.registerTask(new ExtractMetaprogramsTask(this.root, this.injectionInfo));
	}
}
