package edu.jhu.cs.bsj.compiler;

public interface ImportNode extends Node
{
    Node getQualifiedIdentifier();
    
    boolean isStatic();
}
