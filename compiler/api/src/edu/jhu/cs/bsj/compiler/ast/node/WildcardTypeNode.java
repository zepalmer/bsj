package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

/**
 * A nore for wildcard type parameters, as in:
 * <pre>
 * ? extends <i>type</i>
 * </pre>
 * (in which case <tt>bound</tt> is non-<tt>null</tt> and <tt>upperBound</tt> is <tt>true</tt>) or
 * <pre>
 * ? super <i>type</i>
 * </pre>
 * (in which case <tt>bound</tt> is non-<tt>null</tt> and <tt>upperBound</tt> is <tt>false</tt>) or
 * <pre>
 * ?
 * </pre>
 * (in which case <tt>bound</tt> is <tt>null</tt>).
 */
public interface WildcardTypeNode extends Node, TypeArgument
{
    /**
     * Gets the wildcard's bound.
     * @return The wildcard's bound.
     */
    public TypeNode getBound();

    /**
     * Changes the wildcard's bound.
     * @param bound The wildcard's bound.
     */
    public void setBound(TypeNode bound);

    /**
     * Gets whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @return Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public boolean getUpperBound();

    /**
     * Changes whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @param upperBound Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public void setUpperBound(boolean upperBound);

}
