package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents the modifiers which can be associated with a variable.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableModifiersNode extends ModifiersNode
{
    /**
     * Gets whether or not the associated variable is final.
     * @return Whether or not the associated variable is final.
     */
    public boolean getFinalFlag();

    /**
     * Changes whether or not the associated variable is final.
     * @param finalFlag Whether or not the associated variable is final.
     */
    public void setFinalFlag(boolean finalFlag);

}
