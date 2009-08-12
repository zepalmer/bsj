package edu.jhu.cs.bsj.compiler;

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
