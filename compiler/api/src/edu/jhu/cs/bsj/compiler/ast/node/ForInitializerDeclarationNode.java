package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents a for loop initializer which declares variables.  For example, in
 * <pre>for (int i=0;i<n;i++)</pre>
 * this node represents
 * <pre>int i=0</pre>
 * Note that, due to the nature of {@link VariableDeclarationNode}, this can be a variable muilti-declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface ForInitializerDeclarationNode extends Node, ForInitializerNode
{
    /**
     * Gets the variables declared in this initializer.
     * @return The variables declared in this initializer.
     */
    public VariableDeclarationNode getDeclaration();

    /**
     * Changes the variables declared in this initializer.
     * @param declaration The variables declared in this initializer.
     */
    public void setDeclaration(VariableDeclarationNode declaration);

}
