package edu.jhu.cs.bsj.compiler.ast;

public interface ImportNode extends Node
{
    Node getQualifiedIdentifier();
    
    boolean isStatic();
}
