package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents the usage of an annotation, as in:
 * <pre>@<i>type</i></pre>
 * or
 * <pre>@<i>type</i>(<i>key</i>=<i>value</i>,...)</pre>
 * Note that this node does not handle the single element annotation format (<pre>@Foo("bar")</pre>).  That is
 * handled by the {@link SingleElementAnnotationNode} class.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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

}
