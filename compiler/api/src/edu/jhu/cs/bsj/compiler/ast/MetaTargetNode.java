package edu.jhu.cs.bsj.compiler.ast;

/**
 * Interface for meta-program target.
 */
public interface MetaTargetNode extends Node
{
    /**
     * Gets the target name.
     * @return an Identifier.
     */
    Identifier getName();
}
