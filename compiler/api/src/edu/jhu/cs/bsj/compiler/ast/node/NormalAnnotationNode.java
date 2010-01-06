package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the usage of an annotation, as in:
 * <pre>@<i>type</i></pre>
 * or
 * <pre>@<i>type</i>(<i>key</i>=<i>value</i>,...)</pre>
 * Note that this node does not handle the single element annotation format (<pre>@Foo("bar")</pre>).  That is
 * handled by the {@link SingleElementAnnotationNode} class.
 */
public interface NormalAnnotationNode extends AnnotationNode
{
    /**
     * Gets the arguments.
     * @return The arguments.
     */
    public ListNode<? extends AnnotationElementNode> getArguments();

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<? extends AnnotationElementNode> arguments);

}
