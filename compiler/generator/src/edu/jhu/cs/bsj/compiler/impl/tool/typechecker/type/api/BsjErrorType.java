package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.ErrorType;

/**
 * Represents an error type as seen by the BSJ typechecker.
 * @author Zachary Palmer
 */
public interface BsjErrorType extends ErrorType, BsjDeclaredType
{
}
