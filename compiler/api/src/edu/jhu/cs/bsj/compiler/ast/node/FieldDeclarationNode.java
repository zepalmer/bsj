package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.AnnotationMember;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;

/**
 * A node representing a field declaration.  Constants are represented by this node as well.
 */
public interface FieldDeclarationNode extends Node, ClassMember,  InterfaceMember,  AnnotationMember
{
    /**
     * Gets the variable description of the field.
     * @return The variable description of the field.
     */
    public VariableNode getVariable();

    /**
     * Changes the variable description of the field.
     * @param variable The variable description of the field.
     */
    public void setVariable(VariableNode variable);

    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public ExpressionNode getInitializer();

    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(ExpressionNode initializer);

}
