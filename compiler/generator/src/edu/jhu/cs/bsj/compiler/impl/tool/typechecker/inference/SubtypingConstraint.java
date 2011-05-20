package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.inference;

import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

/**
 * This class represents the subtyping constraints implied by an execution of the type argument inference algorithm.
 * 
 * @author Zachary Palmer
 */
public class SubtypingConstraint
{
    public static enum ConstraintKind
    {
        /** Represents the constraint <tt>&lt;:</tt>. */
        SUBTYPE_OF,
        /** Represents the constraint <tt>&gt;:</tt>. */
        SUPERTYPE_OF,
        /** Represents the constraint <tt>=</tt>. */
        EQUAL_TO
    }

    private BsjType constrainedType;
    private ConstraintKind constraintKind;
    private BsjType boundType;

    public SubtypingConstraint(BsjType constrainedType, ConstraintKind constraintKind, BsjType boundType)
    {
        super();
        this.constrainedType = constrainedType;
        this.constraintKind = constraintKind;
        this.boundType = boundType;
    }

    public BsjType getConstrainedType()
    {
        return constrainedType;
    }

    public ConstraintKind getConstraintKind()
    {
        return constraintKind;
    }

    public BsjType getBoundType()
    {
        return boundType;
    }

}
