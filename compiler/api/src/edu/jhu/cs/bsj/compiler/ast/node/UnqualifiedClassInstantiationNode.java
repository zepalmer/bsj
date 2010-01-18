package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing the instantiation of a class, as in:
 * <pre>
 * new <i>type</i>(<i>arg...</i>)
 * </pre>
 * If this class is not anonymous, the <tt>body</tt> field is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UnqualifiedClassInstantiationNode extends ClassInstantiationNode
{
    /**
     * Gets the type being instantiated.
     * @return The type being instantiated.
     */
    public DeclaredTypeNode getType();

    /**
     * Changes the type being instantiated.
     * @param type The type being instantiated.
     */
    public void setType(DeclaredTypeNode type);

}
