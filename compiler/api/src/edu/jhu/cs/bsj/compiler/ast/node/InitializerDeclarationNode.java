package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.AnonymousClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;

/**
 * 
 */
public interface InitializerDeclarationNode extends Node, ClassMember,  AnonymousClassMember
{
    /**
     * Gets whether or not the initializer is static.
     * @return Whether or not the initializer is static.
     */
    public boolean getStaticInitializer();

    /**
     * Changes whether or not the initializer is static.
     * @param staticInitializer Whether or not the initializer is static.
     */
    public void setStaticInitializer(boolean staticInitializer);

    /**
     * Gets the body of the initializer.
     * @return The body of the initializer.
     */
    public BlockStatementNode getBody();

    /**
     * Changes the body of the initializer.
     * @param body The body of the initializer.
     */
    public void setBody(BlockStatementNode body);

}
