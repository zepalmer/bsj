package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the usage of an annotation, as in:
 * <pre>@<i>type</i></pre>
 * or
 * <pre>@<i>type</i>(<i>key</i>=<i>value</i>,...)</pre>
 * Note that this node does not handle the single element annotation format (<pre>@Foo("bar")</pre>).  That is
 * handled by the {@link SingleElementAnnotationNode} class.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NormalAnnotationNode extends AnnotationNode
{
    /**
     * Gets the arguments.
     * @return The arguments.
     */
    public ListNode<AnnotationElementNode> getArguments();

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<AnnotationElementNode> arguments);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NormalAnnotationNode deepCopy(BsjNodeFactory factory);
}
