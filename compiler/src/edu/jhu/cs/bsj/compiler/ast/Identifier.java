package edu.jhu.cs.bsj.compiler.ast;

public interface Identifier extends CharSequence
{
    boolean contentEquals(CharSequence cs);

    boolean equals(Object obj);

    int hashCode();
}
