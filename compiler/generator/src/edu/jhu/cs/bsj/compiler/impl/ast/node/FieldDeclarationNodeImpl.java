package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class FieldDeclarationNodeImpl extends NodeImpl implements FieldDeclarationNode
{
    /** The modifiers for this field. */
    private FieldModifiersNode modifiers;

    /** The variable declarators for this node. */
    private VariableDeclaratorListNode declarators;

    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;

    /** General constructor. */
    public FieldDeclarationNodeImpl(
            FieldModifiersNode modifiers,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        setModifiers(modifiers);
        setDeclarators(declarators);
        setJavadoc(javadoc);
    }

    /**
     * Gets the modifiers for this field.
     * @return The modifiers for this field.
     */
    public FieldModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this field.
     * @param modifiers The modifiers for this field.
     */
    public void setModifiers(FieldModifiersNode modifiers)
    {
        if (this.modifiers != null)
        {
            getManager().removeParent(this, this.modifiers);
        }
        this.modifiers = modifiers;
        if (this.modifiers != null)
        {
            getManager().addParent(this, this.modifiers);
        }
    }

    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public VariableDeclaratorListNode getDeclarators()
    {
        return this.declarators;
    }

    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(VariableDeclaratorListNode declarators)
    {
        if (this.declarators != null)
        {
            getManager().removeParent(this, this.declarators);
        }
        this.declarators = declarators;
        if (this.declarators != null)
        {
            getManager().addParent(this, this.declarators);
        }
    }

    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc()
    {
        return this.javadoc;
    }

    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc)
    {
        if (this.javadoc != null)
        {
            getManager().removeParent(this, this.javadoc);
        }
        this.javadoc = javadoc;
        if (this.javadoc != null)
        {
            getManager().addParent(this, this.javadoc);
        }
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
        if (this.modifiers != null)
        {
            this.modifiers.receive(visitor);
        }
        if (this.declarators != null)
        {
            this.declarators.receive(visitor);
        }
        if (this.javadoc != null)
        {
            this.javadoc.receive(visitor);
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
        if (this.modifiers != null)
        {
            this.modifiers.receiveTyped(visitor);
        }
        if (this.declarators != null)
        {
            this.declarators.receiveTyped(visitor);
        }
        if (this.javadoc != null)
        {
            this.javadoc.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitFieldDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitClassMemberNodeStart(this);
        visitor.visitInterfaceMemberNodeStart(this);
        visitor.visitAnnotationMemberNodeStart(this);
        visitor.visitAnonymousClassMemberNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitClassMemberNodeStop(this);
        visitor.visitInterfaceMemberNodeStop(this);
        visitor.visitAnnotationMemberNodeStop(this);
        visitor.visitAnonymousClassMemberNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitFieldDeclarationNodeStop(this, true);
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
        list.add(getModifiers());
        list.add(getDeclarators());
        list.add(getJavadoc());
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
        sb.append("declarators=");
        sb.append(this.getDeclarators() == null? "null" : this.getDeclarators().getClass().getSimpleName());
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
        return operation.executeFieldDeclarationNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public FieldDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeFieldDeclarationNode(
                getModifiers().deepCopy(factory),
                getDeclarators().deepCopy(factory),
                getJavadoc().deepCopy(factory),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
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
        
        if (before.equals(this.getModifiers()) && (after instanceof FieldModifiersNode))
        {
            setModifiers((FieldModifiersNode)after);
            return true;
        }
        if (before.equals(this.getDeclarators()) && (after instanceof VariableDeclaratorListNode))
        {
            setDeclarators((VariableDeclaratorListNode)after);
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
