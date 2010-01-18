package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * This tagging interface is used to denote AST nodes which can be used as members of an anonymous class's body.
 * Since the set of declarations which may appear in an anonymous class is a subset of that which may appear in a
 * named class, this type is a subtype of {@link ClassMember}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnonymousClassMemberNode extends Node, ClassMemberNode
{
}
