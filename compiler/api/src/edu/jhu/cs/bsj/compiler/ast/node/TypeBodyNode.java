package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;

/**
 * This interface is implemented by any node which represents the body of a type definition.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TypeBodyNode<T extends Node> extends Node
{
    /**
     * Gets the members of this type declaration body.
     * @return The members of this type declaration body.
     */
    public ListNode<? extends T> getMembers();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeBodyNode<T> deepCopy(BsjNodeFactory factory);
}
