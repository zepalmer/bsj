package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;

/**
 * Represents the body of an anonymous class declaration.  This body is distinct from {@link ClassBodyNode} in that
 * it does not permit constructors.  There is no corresponding <tt>AnonymousClassDeclarationNode</tt> because the
 * expression which contains this body implicitly stands as the declaration of that type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnonymousClassBodyNode extends Node, TypeBodyNode<AnonymousClassMemberNode>
{
    /**
     * Gets the members of this anonymous class body.
     * @return The members of this anonymous class body.
     */
    public AnonymousClassMemberListNode getMembers();
    
    /**
     * Changes the members of this anonymous class body.
     * @param members The members of this anonymous class body.
     */
    public void setMembers(AnonymousClassMemberListNode members);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnonymousClassBodyNode deepCopy(BsjNodeFactory factory);
    
}
