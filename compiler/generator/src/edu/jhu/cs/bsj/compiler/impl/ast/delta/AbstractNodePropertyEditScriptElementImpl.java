package edu.jhu.cs.bsj.compiler.impl.ast.delta;



/**
 * Represents an edit script element which sets the value of a specific node-typed property.  The node itself is
 * represented as a UID for the same reasons that the target node is.
 * @author Zachary Palmer
 */
public abstract class AbstractNodePropertyEditScriptElementImpl extends AbstractPropertyEditScriptElementImpl
{
    private Long valueId;

    public AbstractNodePropertyEditScriptElementImpl(int metaprogramId, long targetId, Long valueId)
    {
        super(metaprogramId, targetId);
        this.valueId = valueId;
    }

    public Long getValueId()
    {
        return valueId;
    }
}
