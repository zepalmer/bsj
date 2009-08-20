package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for the wildcard type argument, '?'.
 */
public interface WildcardNode extends Node
{
    Node getBound();
}
