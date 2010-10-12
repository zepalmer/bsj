package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationElementListNode getArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the arguments.
     * @return A union object representing The arguments.
     */
    public NodeUnion<? extends AnnotationElementListNode> getUnionForArguments();
    
    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(AnnotationElementListNode arguments);
    
    /**
     * Changes the arguments.
     * @param arguments The arguments.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForArguments(NodeUnion<? extends AnnotationElementListNode> arguments) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NormalAnnotationNode deepCopy(BsjNodeFactory factory);
    
}
