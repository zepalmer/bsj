package edu.jhu.cs.bsj.compiler.impl.ast.splicenode;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.SpliceNodeAccessException;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodModifiersSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AnnotationMethodModifiersSpliceNodeImpl extends SpliceNodeImpl implements AnnotationMethodModifiersSpliceNode
{
    /** General constructor. */
    public AnnotationMethodModifiersSpliceNodeImpl(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(spliceExpression, startLocation, stopLocation, manager, binary);
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public AnnotationListNode getAnnotations()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"annotations\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setAnnotations(AnnotationListNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"annotations\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"metaAnnotations\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setMetaAnnotations(MetaAnnotationListNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"metaAnnotations\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationMethodModifiersSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeAnnotationMethodModifiersSpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
}
