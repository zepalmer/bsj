package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a declarator for a variable declaration.  For example, in
 * <pre>int x = 5, y;</pre>
 * this node either represents
 * <pre>x = 5</pre>
 * or
 * <pre>y</pre>
 * .  Note that variable multi-declaration syntax allows different types, as in
 * <pre>int x = 5, y[] = new int[2];</pre>
 * Hence, type exists on this node instead of its parent.  If the variable is not initialized, the
 * <tt>initializer</tt> field is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableDeclaratorNode extends Node
{
    /**
     * Gets the type of this variable.
     * @return The type of this variable.
     */
    public TypeNode getType();
    
    /**
     * Changes the type of this variable.
     * @param type The type of this variable.
     */
    public void setType(TypeNode type);
    
    /**
     * Gets the name of this variable.
     * @return The name of this variable.
     */
    public IdentifierNode getName();
    
    /**
     * Changes the name of this variable.
     * @param name The name of this variable.
     */
    public void setName(IdentifierNode name);
    
    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public VariableInitializerNode getInitializer();
    
    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(VariableInitializerNode initializer);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableDeclaratorNode deepCopy(BsjNodeFactory factory);
}
