package edu.jhu.cs.bsj.compiler.lang.type;


/**
 * This type interface is implemented by those types which are actually types in the Java language (as opposed to
 * pseudo-types).
 * @author Zachary Palmer
 */
public interface BsjActualType extends BsjType
{
    /**
     * @see BsjType#evaluate()
     */
    public BsjActualType evaluate();
}
