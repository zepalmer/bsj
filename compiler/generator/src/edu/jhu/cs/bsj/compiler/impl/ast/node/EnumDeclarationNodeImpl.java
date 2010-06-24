package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumDeclarationNodeImpl extends NodeImpl implements EnumDeclarationNode
{
    /** The modifiers for this type. */
    private EnumModifiersNode modifiers;
    
    /** The implements clause. */
    private DeclaredTypeListNode implementsClause;
    
    /** This enum's body. */
    private EnumBodyNode body;
    
    /** The name of this declared type. */
    private IdentifierNode identifier;
    
    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the modifiers property. */
        MODIFIERS,
        /** Attribute for the implementsClause property. */
        IMPLEMENTS_CLAUSE,
        /** Attribute for the body property. */
        BODY,
        /** Attribute for the identifier property. */
        IDENTIFIER,
        /** Attribute for the javadoc property. */
        JAVADOC,
    }
    
    /** General constructor. */
    public EnumDeclarationNodeImpl(
            EnumModifiersNode modifiers,
            DeclaredTypeListNode implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setModifiers(modifiers, false);
        setImplementsClause(implementsClause, false);
        setBody(body, false);
        setIdentifier(identifier, false);
        setJavadoc(javadoc, false);
    }
    
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     */
    public EnumModifiersNode getModifiers()
    {
        recordAccess(LocalAttribute.MODIFIERS, Attribute.AccessType.READ);
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(EnumModifiersNode modifiers)
    {
            setModifiers(modifiers, true);
    }
    
    private void setModifiers(EnumModifiersNode modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.MODIFIERS, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(modifiers, false);
        this.modifiers = modifiers;
        setAsChild(modifiers, true);
    }
    
    /**
     * Gets the implements clause.
     * @return The implements clause.
     */
    public DeclaredTypeListNode getImplementsClause()
    {
        recordAccess(LocalAttribute.IMPLEMENTS_CLAUSE, Attribute.AccessType.READ);
        return this.implementsClause;
    }
    
    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(DeclaredTypeListNode implementsClause)
    {
            setImplementsClause(implementsClause, true);
    }
    
    private void setImplementsClause(DeclaredTypeListNode implementsClause, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.IMPLEMENTS_CLAUSE, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(implementsClause, false);
        this.implementsClause = implementsClause;
        setAsChild(implementsClause, true);
    }
    
    /**
     * Gets this enum's body.
     * @return This enum's body.
     */
    public EnumBodyNode getBody()
    {
        recordAccess(LocalAttribute.BODY, Attribute.AccessType.READ);
        return this.body;
    }
    
    /**
     * Changes this enum's body.
     * @param body This enum's body.
     */
    public void setBody(EnumBodyNode body)
    {
            setBody(body, true);
    }
    
    private void setBody(EnumBodyNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.BODY, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(body, false);
        this.body = body;
        setAsChild(body, true);
    }
    
    /**
     * Gets the name of this declared type.
     * @return The name of this declared type.
     */
    public IdentifierNode getIdentifier()
    {
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(identifier, false);
        this.identifier = identifier;
        setAsChild(identifier, true);
    }
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc()
    {
        recordAccess(LocalAttribute.JAVADOC, Attribute.AccessType.READ);
        return this.javadoc;
    }
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc)
    {
            setJavadoc(javadoc, true);
    }
    
    private void setJavadoc(JavadocNode javadoc, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.JAVADOC, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(javadoc, false);
        this.javadoc = javadoc;
        setAsChild(javadoc, true);
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
        if (this.implementsClause != null)
        {
            this.implementsClause.receive(visitor);
        }
        if (this.body != null)
        {
            this.body.receive(visitor);
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
        if (this.modifiers != null)
        {
            this.modifiers.receiveTyped(visitor);
        }
        if (this.implementsClause != null)
        {
            this.implementsClause.receiveTyped(visitor);
        }
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
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
        visitor.visitEnumDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitInlineTypeDeclarableNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNamedTypeDeclarationNodeStop(this);
        visitor.visitInlineTypeDeclarableNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitEnumDeclarationNodeStop(this, true);
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
        list.add(getImplementsClause());
        list.add(getBody());
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
        sb.append("implementsClause=");
        sb.append(this.getImplementsClause() == null? "null" : this.getImplementsClause().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
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
        return operation.executeEnumDeclarationNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeEnumDeclarationNode(
                getModifiers()==null?null:getModifiers().deepCopy(factory),
                getImplementsClause()==null?null:getImplementsClause().deepCopy(factory),
                getBody()==null?null:getBody().deepCopy(factory),
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
        
        if (before.equals(this.getModifiers()) && (after instanceof EnumModifiersNode))
        {
            setModifiers((EnumModifiersNode)after);
            return true;
        }
        if (before.equals(this.getImplementsClause()) && (after instanceof DeclaredTypeListNode))
        {
            setImplementsClause((DeclaredTypeListNode)after);
            return true;
        }
        if (before.equals(this.getBody()) && (after instanceof EnumBodyNode))
        {
            setBody((EnumBodyNode)after);
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
    
	/**
	 * {@inheritDoc}
	 */
	public NamedTypeDeclarationNode<?> getTypeDeclaration(String name)
	{
		for (Node node : getBody().getMembers())
		{
			if (node instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>)node;
				if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(name))
				{
					return namedTypeDeclarationNode;
				}
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getFullyQualifiedName()
	{
		String id = this.getIdentifier().getIdentifier();
		
		NamedTypeDeclarationNode<?> enclosingType = this.getNearestAncestorOfType(NamedTypeDeclarationNode.class);
		if (enclosingType != null)
		{
			return enclosingType.getFullyQualifiedName() + "." + id;
		}
		
		PackageNode enclosingPackage = this.getNearestAncestorOfType(PackageNode.class);
		if (enclosingPackage != null)
		{
			String packageName = ((PackageNode)enclosingPackage).getFullyQualifiedName();
			if (packageName.length()>0)
			{
				return packageName + "." + id;
			} else
			{
				return id;
			}
		}

		return null;
	}
}
