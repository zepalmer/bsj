package edu.jhu.cs.bsj.compiler.ast;

/**
 * Interface for attaching semantic meaning to a variable identifier.
 */
public interface Identifier extends CharSequence
{
    boolean contentEquals(CharSequence cs);

    boolean equals(Object obj);

    int hashCode();
}
