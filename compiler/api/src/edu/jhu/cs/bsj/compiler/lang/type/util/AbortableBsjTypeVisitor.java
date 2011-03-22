package edu.jhu.cs.bsj.compiler.lang.type.util;

import edu.jhu.cs.bsj.compiler.lang.type.BsjArrayType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjIntersectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNonePseudoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNullType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPackagePseudoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjSelectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypePseudoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.lang.type.BsjVoidPseudoType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjWildcardType;

/**
 * Provides a visitor pattern over BSJ types.
 * 
 * @author Zachary Palmer
 * @param <P> The type of parameter for the visitor to receive.
 * @param <R> The type of return value for the visitor to produce.
 * @param <X> The type of exception which is thrown by the visitor.
 */
public interface AbortableBsjTypeVisitor<P, R, X extends Exception>
{
    /**
     * Called by visited {@link BsjArrayType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjArrayType(BsjArrayType type, P param) throws X;

    /**
     * Called by visited {@link BsjExecutableType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjExecutableType(BsjExecutableType type, P param) throws X;

    /**
     * Called by visited {@link BsjExplicitlyDeclaredType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjExplicitlyDeclaredType(BsjExplicitlyDeclaredType type, P param) throws X;

    /**
     * Called by visited {@link BsjIntersectionType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjIntersectionType(BsjIntersectionType type, P param) throws X;

    /**
     * Called by visited {@link BsjNonePseudoType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjNonePseudoType(BsjNonePseudoType type, P param) throws X;

    /**
     * Called by visited {@link BsjNullType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjNullType(BsjNullType type, P param) throws X;

    /**
     * Called by visited {@link BsjPackagePseudoType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjPackagePseudoType(BsjPackagePseudoType type, P param) throws X;

    /**
     * Called by visited {@link BsjPrimitiveType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjPrimitiveType(BsjPrimitiveType type, P param) throws X;

    /**
     * Called by visited {@link BsjSelectionType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjSelectionType(BsjSelectionType type, P param) throws X;

    /**
     * Called by visited {@link BsjTypePseudoType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjTypePseudoType(BsjTypePseudoType type, P param) throws X;

    /**
     * Called by visited {@link BsjTypeVariable} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjTypeVariable(BsjTypeVariable type, P param) throws X;

    /**
     * Called by visited {@link BsjVoidPseudoType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjVoidPseudoType(BsjVoidPseudoType type, P param) throws X;

    /**
     * Called by visited {@link BsjWildcardType} objects.
     * 
     * @param type The type over which to operate.
     * @param param The parameter provided.
     * @return The resulting value.
     * @throws X If an error occurs.
     */
    public R visitBsjWildcardType(BsjWildcardType type, P param) throws X;
}
