package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents the creation of an array with initializer, as in
 * <pre>
 * new <i>type</i> []... {<i>initializer</i>,...}
 * </pre>
 * Levels for this array creator refer to square brace pairs,
 * for example <code>new int[][][]</code> would have three levels.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ArrayInitializerCreationNode extends ArrayCreationNode
{
    /**
     * Gets the initializer for this array.
     * @return The initializer for this array.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ArrayInitializerNode getInitializer()throws ClassCastException;
    
    /**
     * Gets the union object for the initializer for this array.
     * @return A union object representing The initializer for this array.
     */
    public NodeUnion<? extends ArrayInitializerNode> getUnionForInitializer();
    
    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setInitializer(ArrayInitializerNode initializer);
    
    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForInitializer(NodeUnion<? extends ArrayInitializerNode> initializer) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayInitializerCreationNode deepCopy(BsjNodeFactory factory);
    
}
