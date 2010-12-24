package edu.jhu.cs.bsj.compiler.lang.type;

import javax.lang.model.type.WildcardType;

/**
 * Represents a wildcard type in the BSJ typechecker.
 * @author Zachary Palmer
 */
public interface BsjWildcardType extends WildcardType, BsjActualType, BsjTypeArgument
{
    public BsjTypeArgument getExtendsBound();

    public BsjTypeArgument getSuperBound();
    
    /**
     * Creates a new wildcard type which is equivalent to this type upper-bounded by an additional type.  This bound
     * type is added to the upper bound of this wildcard type.  Thus, narrowing the upper bound of <tt>?</tt> using
     * <tt>Foo</tt> would create <tt>? extends Foo</tt>.  If this type already contains an upper bound, an intersection
     * type is created for the bound.
     * @param type The type to use in narrowing the upper bound.
     * @return The resulting type.
     */
    public BsjWildcardType narrowUpperBound(BsjTypeArgument type);
    
    /**
     * Creates a new wildcard type which is equivalent to this type lower-bounded by an additional type.  This bound
     * type is added to the lower bound of this wildcard type.  Thus, narrowing the lower bound of <tt>?</tt> using
     * <tt>Foo</tt> would create <tt>? super Foo</tt>.  If this type already contains a lower bound, an intersection
     * type is created for the bound.
     * @param type The type to use in narrowing the lower bound.
     * @return The resulting type.
     */
    public BsjWildcardType narrowLowerBound(BsjTypeArgument type);
    
    /**
     * @see BsjType#evaluate()
     */
    public BsjWildcardType evaluate();
}
