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
}
