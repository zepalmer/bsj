package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This tagging interface is used to denote AST nodes which can be used as members of an anonymous class's body.
 * Since the set of declarations which may appear in an anonymous class is a subset of that which may appear in a
 * named class, this type is a subtype of {@link ClassMemberNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnonymousClassMemberNode extends Node, ClassMemberNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnonymousClassMemberNode deepCopy(BsjNodeFactory factory);
}
