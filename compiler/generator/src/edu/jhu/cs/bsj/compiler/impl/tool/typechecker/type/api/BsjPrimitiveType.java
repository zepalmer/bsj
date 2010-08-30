package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.PrimitiveType;

/**
 * Represents a primitive type as seen by the BSJ typechecker.
 * @author Zachary Palmer
 */
public interface BsjPrimitiveType extends PrimitiveType, BsjType
{
	public edu.jhu.cs.bsj.compiler.ast.PrimitiveType getPrimitiveType();
}
