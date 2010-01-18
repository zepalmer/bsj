package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

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
     */
    public ArrayInitializerNode getInitializer();

    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setInitializer(ArrayInitializerNode initializer);

}
