package edu.jhu.cs.bsj.compiler;

public interface Identifier extends CharSequence
{
    boolean contentEquals(CharSequence cs);

    boolean equals(Object obj);

    int hashCode();
}
