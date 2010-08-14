package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.TypeMirror;

/**
 * A BSJ representation of a type value.
 * @author Zachary Palmer
 */
public interface BsjType extends TypeMirror
{
	/**
	 * Calculates the erasure of this type.
	 * @return The resulting type.
	 */
	public BsjType calculateErasure();
}
