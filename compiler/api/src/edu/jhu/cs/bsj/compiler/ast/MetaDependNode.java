package edu.jhu.cs.bsj.compiler.ast;

/**
 * Interface for meta-program dependency.
 */
public interface MetaDependNode extends Node
{
    /**
     * Gets the dependency name.
     * @return an Identifier.
     */
    Identifier getName();
}
