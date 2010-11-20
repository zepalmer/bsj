package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

public class StringName implements AttributeName
{
    private String name;
    public StringName(String name)
    {
        this.name = name;
    }
    public String toString()
    {
        return this.name;
    }
}
