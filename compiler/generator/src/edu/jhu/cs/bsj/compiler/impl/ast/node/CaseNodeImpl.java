package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CaseNodeImpl extends NodeImpl implements CaseNode
{
    /** The expression used in this case label. */
    private NodeUnion<? extends ExpressionNode> expression;
    
    /** The statements to execute in this case node. */
    private NodeUnion<? extends BlockStatementListNode> statements;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(CaseNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the expression property. */
        EXPRESSION,
        /** Attribute identifier for the statements property. */
        STATEMENTS,
    }
    
    /** General constructor. */
    public CaseNodeImpl(
            NodeUnion<? extends ExpressionNode> expression,
            NodeUnion<? extends BlockStatementListNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForExpression(expression, false);
        setUnionForStatements(statements, false);
    }
    
    /**
     * Gets the expression used in this case label.  This property's value is assumed to be a normal node.
     * @return The expression used in this case label.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getExpression()
    {
        getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.expression == null)
        {
            return null;
        } else
        {
            return this.expression.getNormalNode();
        }
    }
    
    /**
     * Gets the expression used in this case label.
     * @return The expression used in this case label.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression()
    {
        getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.expression == null)
        {
            this.expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.expression;
    }
    
    /**
     * Changes the expression used in this case label.
     * @param expression The expression used in this case label.
     */
    public void setExpression(ExpressionNode expression)
    {
            setExpression(expression, true);
            getManager().notifyChange(this);
    }
    
    private void setExpression(ExpressionNode expression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.expression != null)
        {
            setAsChild(this.expression.getNodeValue(), false);
        }
        this.expression = new NormalNodeUnion<ExpressionNode>(expression);
        setAsChild(expression, true);
    }
    
    /**
     * Changes the expression used in this case label.
     * @param expression The expression used in this case label.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression)
    {
            setUnionForExpression(expression, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (expression == null)
        {
            expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.expression != null)
        {
            setAsChild(this.expression.getNodeValue(), false);
        }
        this.expression = expression;
        setAsChild(expression.getNodeValue(), true);
    }
    
    /**
     * Gets the statements to execute in this case node.  This property's value is assumed to be a normal node.
     * @return The statements to execute in this case node.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BlockStatementListNode getStatements()
    {
        getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.statements == null)
        {
            return null;
        } else
        {
            return this.statements.getNormalNode();
        }
    }
    
    /**
     * Gets the statements to execute in this case node.
     * @return The statements to execute in this case node.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForStatements()
    {
        getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.statements == null)
        {
            this.statements = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        return this.statements;
    }
    
    /**
     * Changes the statements to execute in this case node.
     * @param statements The statements to execute in this case node.
     */
    public void setStatements(BlockStatementListNode statements)
    {
            setStatements(statements, true);
            getManager().notifyChange(this);
    }
    
    private void setStatements(BlockStatementListNode statements, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.statements != null)
        {
            setAsChild(this.statements.getNodeValue(), false);
        }
        this.statements = new NormalNodeUnion<BlockStatementListNode>(statements);
        setAsChild(statements, true);
    }
    
    /**
     * Changes the statements to execute in this case node.
     * @param statements The statements to execute in this case node.
     */
    public void setUnionForStatements(NodeUnion<? extends BlockStatementListNode> statements)
    {
            setUnionForStatements(statements, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForStatements(NodeUnion<? extends BlockStatementListNode> statements, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (statements == null)
        {
            statements = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        if (this.statements != null)
        {
            setAsChild(this.statements.getNodeValue(), false);
        }
        this.statements = statements;
        setAsChild(statements.getNodeValue(), true);
    }
    
    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        if (this.expression.getNodeValue() != null)
        {
            this.expression.getNodeValue().receive(visitor);
        }
        if (this.statements.getNodeValue() != null)
        {
            this.statements.getNodeValue().receive(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.expression.getNodeValue() != null)
        {
            this.expression.getNodeValue().receiveTyped(visitor);
        }
        if (this.statements.getNodeValue() != null)
        {
            this.statements.getNodeValue().receiveTyped(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitCaseNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitCaseNodeStop(this, true);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(getExpression());
        list.add(getStatements());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForExpression().getNodeValue(), getUnionForStatements().getNodeValue()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("expression=");
        sb.append(this.getUnionForExpression().getNodeValue() == null? "null" : this.getUnionForExpression().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("statements=");
        sb.append(this.getUnionForStatements().getNodeValue() == null? "null" : this.getUnionForStatements().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeCaseNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeCaseNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CaseNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionNode> expressionCopy;
        switch (getUnionForExpression().getType())
        {
            case NORMAL:
                if (getUnionForExpression().getNormalNode() == null)
                {
                    expressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    expressionCopy = factory.makeNormalNodeUnion(getUnionForExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForExpression().getSpliceNode() == null)
                {
                    expressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    expressionCopy = factory.makeSpliceNodeUnion(getUnionForExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForExpression().getType());
        }
        NodeUnion<? extends BlockStatementListNode> statementsCopy;
        switch (getUnionForStatements().getType())
        {
            case NORMAL:
                if (getUnionForStatements().getNormalNode() == null)
                {
                    statementsCopy = factory.<BlockStatementListNode>makeNormalNodeUnion(null);
                } else
                {
                    statementsCopy = factory.makeNormalNodeUnion(getUnionForStatements().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForStatements().getSpliceNode() == null)
                {
                    statementsCopy = factory.<BlockStatementListNode>makeSpliceNodeUnion(null);
                } else
                {
                    statementsCopy = factory.makeSpliceNodeUnion(getUnionForStatements().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForStatements().getType());
        }
        return factory.makeCaseNodeWithUnions(
                expressionCopy,
                statementsCopy,
                getStartLocation(),
                getStopLocation());
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public boolean replace(Node before, Node after)
    {
        if (before==null)
            throw new IllegalArgumentException("Cannot replace node with before value of null.");
        
        if (before.equals(this.getUnionForExpression().getNodeValue()))
        {
            setExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForStatements().getNodeValue()))
        {
            setStatements((BlockStatementListNode)after);
            return true;
        }
        return false;
    }
    
}
