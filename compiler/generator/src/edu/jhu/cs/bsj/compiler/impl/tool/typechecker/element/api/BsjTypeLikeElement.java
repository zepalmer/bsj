package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

/**
 * This interface is implemented by element types which represent type declarations either directly or indirectly.  A
 * type-like element is an element which may be used as a type, such as in the type reference of a variable declaration.
 * In terms of use, type-like elements are those which constitute the type namespace.  Type elements and type parameter
 * elements are type-like.
 * @author Zachary Palmer
 */
public interface BsjTypeLikeElement extends BsjElement
{
}