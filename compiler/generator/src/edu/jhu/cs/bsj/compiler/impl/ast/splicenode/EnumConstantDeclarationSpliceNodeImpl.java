package edu.jhu.cs.bsj.compiler.impl.ast.splicenode;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.SpliceNodeAccessException;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumConstantDeclarationSpliceNodeImpl extends SpliceNodeImpl implements EnumConstantDeclarationSpliceNode
{
    /** General constructor. */
    public EnumConstantDeclarationSpliceNodeImpl(
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
    public AnonymousClassBodyNode getBody()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"body\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setBody(AnonymousClassBodyNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"body\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public IdentifierNode getIdentifier()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"identifier\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setIdentifier(IdentifierNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"identifier\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public JavadocNode getJavadoc()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"javadoc\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setJavadoc(JavadocNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"javadoc\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public ExpressionListNode getArguments()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"arguments\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setArguments(ExpressionListNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"arguments\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public EnumConstantModifiersNode getModifiers()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"modifiers\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setModifiers(EnumConstantModifiersNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"modifiers\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumConstantDeclarationSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeEnumConstantDeclarationSpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
}
