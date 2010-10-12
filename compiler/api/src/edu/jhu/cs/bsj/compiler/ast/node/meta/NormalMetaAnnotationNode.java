package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;

/**
 * Represents the usage of a meta-annotation, as in:
 * <pre>@@<i>type</i></pre>
 * or
 * <pre>@@<i>type</i>(<i>key</i>=<i>value</i>,...)</pre>
 * Note that this node does not handle the single element meta-annotation format (<pre>@@Foo("bar")</pre>).
 * That is handled by the {@link SingleElementMetaAnnotationNode} class.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NormalMetaAnnotationNode extends MetaAnnotationNode, BsjSpecificNode
{
    /**
     * Gets the arguments.
     * @return The arguments.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaAnnotationElementListNode getArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the arguments.
     * @return A union object representing The arguments.
     */
    public NodeUnion<? extends MetaAnnotationElementListNode> getUnionForArguments();
    
    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(MetaAnnotationElementListNode arguments);
    
    /**
     * Changes the arguments.
     * @param arguments The arguments.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForArguments(NodeUnion<? extends MetaAnnotationElementListNode> arguments) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NormalMetaAnnotationNode deepCopy(BsjNodeFactory factory);
    
}
