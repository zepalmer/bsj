package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A common supertype for all nodes representing a name.  In Java, a name is either a simple name (a single
 * identifier) or a qualified name (a name, a dot, and an identifier).  The meaning of a name is context-sensitive
 * and is partially dependent upon type information; therefore, this node maintains information about the facts
 * currently known about this name.
 * <p/>
 * Note that some identifiers are not used as names; as a result, not all identifiers are children of this class
 * or one of its subclasses.  Examples of such cases include variable and type declarations, where the identifier
 * is not technically a name because it is being used to create a name which does not exist.  For more information,
 * please see the Java Language Specification v3.0 &
 */
public interface NameNode extends Node
{
}
