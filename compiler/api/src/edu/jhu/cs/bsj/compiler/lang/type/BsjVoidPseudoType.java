package edu.jhu.cs.bsj.compiler.lang.type;

/**
 * Represents the non-type <tt>void</tt> in the BSJ type checker.
 * @author Zachary Palmer
 */
public interface BsjVoidPseudoType extends BsjNoType
{
    /**
     * @see BsjType#evaluate()
     */
    public BsjVoidPseudoType evaluate();
}
