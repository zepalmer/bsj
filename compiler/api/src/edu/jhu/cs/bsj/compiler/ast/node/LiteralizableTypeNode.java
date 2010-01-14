package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * This tagging interface is used to denote AST nodes which refer to a type which can be used to define a class
 * literal (such as <tt>String.class</tt>, <tt>int.class</tt>, or <tt>String[].class</tt>).  Note that
 * parameterized types may not be used to create literals; that is, <tt>Set&lt;String&gt;.class</tt> is illegal.
 */
public interface LiteralizableTypeNode extends Node, TypeNode
{
}
