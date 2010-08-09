package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a for loop initializer which declares variables.  For example, in
 * <pre>for (int i=0;i&lt;n;i++)</pre>
 * this node represents
 * <pre>int i=0</pre>
 * Note that, due to the nature of {@link LocalVariableDeclarationNode}, this can be a variable
 * muilti-declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ForInitializerDeclarationNode extends Node, ForInitializerNode
{
    /**
     * Gets the variables declared in this initializer.
     * @return The variables declared in this initializer.
     */
    public LocalVariableDeclarationNode getDeclaration();
    
    /**
     * Changes the variables declared in this initializer.
     * @param declaration The variables declared in this initializer.
     */
    public void setDeclaration(LocalVariableDeclarationNode declaration);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForInitializerDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
