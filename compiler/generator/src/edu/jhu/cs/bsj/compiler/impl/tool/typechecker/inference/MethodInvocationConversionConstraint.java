package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.inference;

import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;

/**
 * This class implements method invocation conversions used by the type argument inference system. system.
 * 
 * @author Zachary Palmer
 */
public class MethodInvocationConversionConstraint
{
    public static enum ConstraintKind
    {
        /** Represents the constraint type <tt>&lt;&lt;</tt>. */
        TO,
        /** Represents the constraint type <tt>&gt;&gt;</tt>. */
        FROM,
        /** Represents the constraint type <tt>=</tt>. */
        EQUAL
    }

    private BsjActualType actualType;
    private ConstraintKind constraintKind;
    private BsjActualType formalType;

    public MethodInvocationConversionConstraint(BsjActualType actualType, ConstraintKind constraintKind, BsjActualType formalType)
    {
        super();
        this.actualType = actualType;
        this.constraintKind = constraintKind;
        this.formalType = formalType;
    }

    public BsjActualType getActualType()
    {
        return actualType;
    }

    public ConstraintKind getConstraintKind()
    {
        return constraintKind;
    }

    public BsjActualType getFormalType()
    {
        return formalType;
    }
}
