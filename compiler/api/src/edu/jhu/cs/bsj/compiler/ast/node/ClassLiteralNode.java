package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A note representing a class literal, such as <tt>String.class</tt>.  Note that the BSJ compiler API includes a
 * {@link VoidTypeNode}.  This is technically a violation (as Java does not treat <tt>void</tt> as a type) but
 * allows this node to represent <tt>void.class</tt>.
 */
public interface ClassLiteralNode extends LiteralNode<TypeNode>
{
}
