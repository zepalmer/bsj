package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing the instantiation of a class, as in:
 * <pre>
 * new <i>type</i>(<i>arg...</i>)
 * </pre>
 * If this class is not anonymous, the <tt>body</tt> field is <tt>null</tt>.
 */
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