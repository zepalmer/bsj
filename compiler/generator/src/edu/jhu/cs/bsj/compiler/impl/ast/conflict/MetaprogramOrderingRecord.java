package edu.jhu.cs.bsj.compiler.impl.ast.conflict;

/**
 * Specifies a mechanism by which metaprogram order can be checked.
 * @author Zachary Palmer
 */
public interface MetaprogramOrderingRecord
{
    /**
     * Determines whether or not two metaprograms are ordered.
     * @param a The ID of the first metaprogram.
     * @param b The ID of the second metaprogram.
     * @return <code>true</code> if these metaprograms have an explicit order of execution; <code>false</code> if they
     * do not.
     */
    public boolean checkOrdering(int a, int b);
}
