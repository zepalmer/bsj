package edu.jhu.cs.bsj.compiler.lang.type;

import java.util.Map;

import javax.lang.model.type.TypeMirror;

/**
 * A BSJ representation of a type value.
 * 
 * @author Zachary Palmer
 */
public interface BsjType extends TypeMirror
{
	/**
	 * Calculates the erasure of this type.
	 * 
	 * @return The resulting type.
	 */
	public BsjType calculateErasure();

	/**
	 * Determines whether or not this type is a subtype of another type.
	 * 
	 * @return The resulting type.
	 */
	public boolean isSubtypeOf(BsjType type);

	/**
	 * Determines whether or not this type is a supertype of another type.
	 * 
	 * @return The resulting type.
	 */
	public boolean isSupertypeOf(BsjType type);

	/**
	 * Performs the boxing conversion (JLSv3 §5.1.7) on this type if possible. The resulting type is the boxed version
	 * of this type (if appropriate) or the same type (if boxing was not possible). If this type should never be boxed
	 * (because it is representative of a non-type such as a package, for example), <code>null</code> is returned.
	 */
	public BsjTypeArgument boxConvert();

	/**
	 * Performs the unboxing conversion (JLSv3 §5.1.8) on this type if possible. The resulting type is the unboxed
	 * version of this type (if appropriate) or the same type (if unboxing was not possible).
	 */
	public BsjType unboxConvert();

	/**
	 * Performs the capture conversion (JLSv3 §5.1.10) on this type. Note that the capture conversion introduces new
	 * type variables; as a result, <tt>type.captureConvert().equals(type.captureConvert())</tt> may not be
	 * <tt>true</tt>. This is by necessity, as capture conversion against the same type may occur twice in a given
	 * context and infer a different value for the captured type each time.
	 * 
	 * @return The resulting type.
	 */
	public BsjType captureConvert();

	/**
	 * Determines whether or not this type is a numeric primitive type.
	 */
	public boolean isNumericPrimitive();

	/**
	 * Determines whether or not this type is an integral primitive type.
	 */
	public boolean isIntegralPrimitive();

	/**
	 * Performs numeric type promotion on this type. This is equivalent to both unary numeric conversion (JLSv3 §5.6.1)
	 * and binary numeric conversion (JLSv3 §5.6.2) because those conversions have different effects on the values that
	 * are converted but not on the types. If the this type is not a numeric type, <code>null</code> is returned.
	 */
	public BsjPrimitiveType numericTypePromotion();

	/**
	 * Determines whether or not this type is assignment-compatible with another type according to the rules of the
	 * assignment conversion context (JLSv3 §5.2).
	 * 
	 * @param type The type to which to compare this type.
	 * @return <code>true</code> if this type is assignment-compatible with the other type; <code>false</code> if it is
	 *         not.
	 */
	public boolean isAssignmentCompatibleWith(BsjType type);

	/**
	 * Determines whether or not this type is method-invocation-compatible with another type according to the rules of
	 * the method invocation conversion context (JLSv3 §5.3).
	 * 
	 * @param type The type to which to compare this type.
	 * @return <code>true</code> if this type is method-invocation-compatible with the other type; <code>false</code> if
	 *         it is not.
	 */
	public boolean isMethodInvocationCompatibleWith(BsjType type);

	/**
	 * Performs type argument substitution for this type. The resulting type is identical to this type except in that
	 * any instances of any specified type parameter that appear within this type are replaced with the corresponding
	 * type argument.
	 * 
	 * @param map The substitution map which relates type parameters to the arguments that substitute for them.
	 * @return The resulting type.
	 */
	public BsjType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap);

	/**
	 * Determines whether or not this type is reifiable. (JLSv3 §4.7)
	 * 
	 * @return <code>true</code> if this type is reifiable; <code>false</code> if it is not.
	 */
	public boolean isReifiable();

	/**
	 * Determines whether or not this type is cast-compatible with another type according to the casting conversion
	 * (JLSv3 §5.5). This is true if and only if a cast from this type to the other type is potentially valid.
	 * 
	 * @param type The other type.
	 * @return A corresponding {@link CastCompatibility}.
	 */
	public CastCompatibility isCastCompatible(BsjType type);

	/**
	 * Determines if there is a narrowing primitive conversion (JLSv3 §5.1.3) from this type to the given type.
	 * 
	 * @param type The other type.
	 * @return <code>true</code> if the conversion exists; <code>false</code> if it does not.
	 */
	public boolean isNarrowingPrimitiveConversionTo(BsjType type);

	/**
	 * Determines if there is a narrowing primitive conversion (JLSv3 §5.1.2) from this type to the given type.
	 * 
	 * @param type The other type.
	 * @return <code>true</code> if the conversion exists; <code>false</code> if it does not.
	 */
	public boolean isWideningPrimitiveConversionTo(BsjType type);

	/**
	 * Determines if there is a widening-and-narrowing primitive conversion (JLSv3 §5.1.4) from this type to the given
	 * type.
	 * 
	 * @param type The other type.
	 * @return <code>true</code> if the conversion exists; <code>false</code> if it does not.
	 */
	public boolean isWideningAndNarrowingPrimitiveConversionTo(BsjType type);

	/**
	 * Determines whether or not there exists a narrowing reference conversion (JLSv3 §5.1.6) from this type to another
	 * type.  If this type and the other type represent the same type, this method returns <code>true</code>.
	 * 
	 * @param type The other type.
	 * @return <code>true</code> if a narrowing reference conversion exists; <code>false</code> if not.
	 */
	public boolean isNarrowingReferenceConversionTo(BsjType type);

	/**
	 * Determines whether or not there exists a widening reference conversion (JLSv3 §5.1.5) from this type to another
	 * type.  If this type and the other type represent the same type, this method returns <code>true</code>.
	 * 
	 * @param type The other type.
	 * @return <code>true</code> if a widening reference conversion exists; <code>false</code> if not.
	 */
	public boolean isWideningReferenceConversionTo(BsjType type);
	
	/**
	 * Determines whether or not there exists a selection conversion from this type to another type.
	 * @param type The target type.
	 * @return <code>true</code> if a selection conversion exists; <code>false</code> if not.
	 */
	public boolean isSelectionConversionTo(BsjType type);

}
