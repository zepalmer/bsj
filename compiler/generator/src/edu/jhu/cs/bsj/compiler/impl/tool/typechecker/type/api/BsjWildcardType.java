package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.WildcardType;

/**
 * Represents a wildcard type in the BSJ typechecker.
 * @author Zachary Palmer
 */
public interface BsjWildcardType extends WildcardType, BsjType, BsjTypeArgument
{
    public BsjTypeArgument getExtendsBound();

    public BsjTypeArgument getSuperBound();
}
