package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class LocalClassDeclarationNodeImpl extends AbstractlyUnmodifiedClassDeclarationNodeImpl<LocalClassModifiersNode> implements LocalClassDeclarationNode
{
    /** General constructor. */
    public LocalClassDeclarationNodeImpl(
            LocalClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
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
        visitor.visitLocalClassDeclarationNodeStart(this, true);
        visitor.visitAbstractlyUnmodifiedClassDeclarationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitBlockStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitBlockStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAbstractlyUnmodifiedClassDeclarationNodeStop(this);
        visitor.visitLocalClassDeclarationNodeStop(this, true);
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
        return list;
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
        sb.append("modifiers=");
        sb.append(this.getModifiers() == null? "null" : this.getModifiers().getClass().getSimpleName());
        sb.append(',');
        sb.append("extendsClause=");
        sb.append(this.getExtendsClause() == null? "null" : this.getExtendsClause().getClass().getSimpleName());
        sb.append(',');
        sb.append("implementsClause=");
        sb.append(this.getImplementsClause() == null? "null" : this.getImplementsClause().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeParameters=");
        sb.append(this.getTypeParameters() == null? "null" : this.getTypeParameters().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
        sb.append(',');
        sb.append("javadoc=");
        sb.append(this.getJavadoc() == null? "null" : this.getJavadoc().getClass().getSimpleName());
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
        return operation.executeLocalClassDeclarationNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LocalClassDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeLocalClassDeclarationNode(
                getModifiers()==null?null:getModifiers().deepCopy(factory),
                getExtendsClause()==null?null:getExtendsClause().deepCopy(factory),
                getImplementsClause()==null?null:getImplementsClause().deepCopy(factory),
                getBody()==null?null:getBody().deepCopy(factory),
                getTypeParameters()==null?null:getTypeParameters().deepCopy(factory),
                getIdentifier()==null?null:getIdentifier().deepCopy(factory),
                getJavadoc()==null?null:getJavadoc().deepCopy(factory),
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
        
        if (before.equals(this.getModifiers()) && (after instanceof LocalClassModifiersNode))
        {
            setModifiers((LocalClassModifiersNode)after);
            return true;
        }
        if (before.equals(this.getExtendsClause()) && (after instanceof DeclaredTypeNode))
        {
            setExtendsClause((DeclaredTypeNode)after);
            return true;
        }
        if (before.equals(this.getImplementsClause()) && (after instanceof DeclaredTypeListNode))
        {
            setImplementsClause((DeclaredTypeListNode)after);
            return true;
        }
        if (before.equals(this.getBody()) && (after instanceof ClassBodyNode))
        {
            setBody((ClassBodyNode)after);
            return true;
        }
        if (before.equals(this.getTypeParameters()) && (after instanceof TypeParameterListNode))
        {
            setTypeParameters((TypeParameterListNode)after);
            return true;
        }
        if (before.equals(this.getIdentifier()) && (after instanceof IdentifierNode))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getJavadoc()) && (after instanceof JavadocNode))
        {
            setJavadoc((JavadocNode)after);
            return true;
        }
        return false;
    }
    
}
