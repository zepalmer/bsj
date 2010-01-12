package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the creation of an array with initializer, as in
 * <pre>
 * new <i>type</i> []... {<i>initializer</i>,...}
 * </pre>
 */
public interface ArrayInitializerCreationNode extends ArrayCreationNode
{
    /**
     * Gets the initializer for this array.
     * @return The initializer for this array.
     */
    public ArrayInitializerNode getInitializer();

    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setInitializer(ArrayInitializerNode initializer);

}
