package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ClassDeclarationNodeImpl extends NodeImpl implements ClassDeclarationNode
{
    /** The modifiers for this type. */
    private ClassModifiersNode modifiers;

    /** The extends clause. */
    private DeclaredTypeNode extendsClause;

    /** The implements clause. */
    private DeclaredTypeListNode implementsClause;

    /** The body of this class. */
    private ClassBodyNode body;

    /** This class's type parameters. */
    private TypeParameterListNode typeParameters;

    /** The name of this declared type. */
    private IdentifierNode identifier;

    /** The associated javadoc comment for this node. */
    private JavadocNode javadoc;

    /** General constructor. */
    public ClassDeclarationNodeImpl(
            ClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        setModifiers(modifiers);
        setExtendsClause(extendsClause);
        setImplementsClause(implementsClause);
        setBody(body);
        setTypeParameters(typeParameters);
        setIdentifier(identifier);
        setJavadoc(javadoc);
    }

    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     */
    public ClassModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(ClassModifiersNode modifiers)
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
     * Gets the extends clause.
     * @return The extends clause.
     */
    public DeclaredTypeNode getExtendsClause()
    {
        return this.extendsClause;
    }

    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(DeclaredTypeNode extendsClause)
    {
        if (this.extendsClause != null)
        {
            getManager().removeParent(this, this.extendsClause);
        }
        this.extendsClause = extendsClause;
        if (this.extendsClause != null)
        {
            getManager().addParent(this, this.extendsClause);
        }
    }

    /**
     * Gets the implements clause.
     * @return The implements clause.
     */
    public DeclaredTypeListNode getImplementsClause()
    {
        return this.implementsClause;
    }

    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(DeclaredTypeListNode implementsClause)
    {
        if (this.implementsClause != null)
        {
            getManager().removeParent(this, this.implementsClause);
        }
        this.implementsClause = implementsClause;
        if (this.implementsClause != null)
        {
            getManager().addParent(this, this.implementsClause);
        }
    }

    /**
     * Gets the body of this class.
     * @return The body of this class.
     */
    public ClassBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of this class.
     * @param body The body of this class.
     */
    public void setBody(ClassBodyNode body)
    {
        if (this.body != null)
        {
            getManager().removeParent(this, this.body);
        }
        this.body = body;
        if (this.body != null)
        {
            getManager().addParent(this, this.body);
        }
    }

    /**
     * Gets this class's type parameters.
     * @return This class's type parameters.
     */
    public TypeParameterListNode getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters)
    {
        if (this.typeParameters != null)
        {
            getManager().removeParent(this, this.typeParameters);
        }
        this.typeParameters = typeParameters;
        if (this.typeParameters != null)
        {
            getManager().addParent(this, this.typeParameters);
        }
    }

    /**
     * Gets the name of this declared type.
     * @return The name of this declared type.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        if (this.identifier != null)
        {
            getManager().removeParent(this, this.identifier);
        }
        this.identifier = identifier;
        if (this.identifier != null)
        {
            getManager().addParent(this, this.identifier);
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
        if (this.extendsClause != null)
        {
            this.extendsClause.receive(visitor);
        }
        if (this.implementsClause != null)
        {
            this.implementsClause.receive(visitor);
        }
        if (this.body != null)
        {
            this.body.receive(visitor);
        }
        if (this.typeParameters != null)
        {
            this.typeParameters.receive(visitor);
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
        if (this.extendsClause != null)
        {
            this.extendsClause.receiveTyped(visitor);
        }
        if (this.implementsClause != null)
        {
            this.implementsClause.receiveTyped(visitor);
        }
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
        }
        if (this.typeParameters != null)
        {
            this.typeParameters.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitClassDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitInlineTypeDeclarableNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNamedTypeDeclarationNodeStop(this);
        visitor.visitInlineTypeDeclarableNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitClassDeclarationNodeStop(this, true);
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
        list.add(getExtendsClause());
        list.add(getImplementsClause());
        list.add(getBody());
        list.add(getTypeParameters());
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
        return operation.executeClassDeclarationNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeClassDeclarationNode(
                getModifiers().deepCopy(factory),
                getExtendsClause().deepCopy(factory),
                getImplementsClause().deepCopy(factory),
                getBody().deepCopy(factory),
                getTypeParameters().deepCopy(factory),
                getIdentifier().deepCopy(factory),
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
        
        if (before.equals(this.getModifiers()) && (after instanceof ClassModifiersNode))
        {
            setModifiers((ClassModifiersNode)after);
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
    
	/**
	 * Retrieves the specified member type declaration from this node.
	 * @param name The simple name of the member type declaration to retrieve.
	 * @return The declaration of that type or <code>null</code> if no such declaration exists.
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

}
