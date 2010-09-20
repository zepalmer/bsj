package edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta;

import javax.annotation.Generated;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.SpliceNodeAccessException;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationSpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationSpliceNodeImpl extends SpliceNodeImpl implements MetaAnnotationSpliceNode
{
    /** General constructor. */
    public MetaAnnotationSpliceNodeImpl(
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
    public MetaAnnotationMetaprogramAnchorNode getMetaprogramAnchor()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"metaprogramAnchor\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public UnparameterizedTypeNode getAnnotationType()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"annotationType\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setAnnotationType(UnparameterizedTypeNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"annotationType\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMetaAnnotationSpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
    /** Raises an exception. */
    public void instantiateMetaAnnotationObject(DiagnosticListener<BsjSourceLocation> listener)
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
    /** Raises an exception. */
    public BsjMetaAnnotation getMetaAnnotationObject()
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
}
