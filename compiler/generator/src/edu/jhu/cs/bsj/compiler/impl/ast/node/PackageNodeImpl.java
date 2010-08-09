package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeCallback;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.NonConflictingReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.PackageCompilationUnitAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.DuplicatePackageMemberExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterator;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class PackageNodeImpl extends NodeImpl implements PackageNode
{
    /** The simple name of this package. */
    private IdentifierNode name;
    
    /** The callback module for this package node. */
    private PackageNodeCallback packageNodeCallback;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(PackageNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the name property. */
        NAME,
        /** Attribute identifier for the packageNodeCallback property. */
        PACKAGE_NODE_CALLBACK,
    }
    
    /** General constructor. */
    public PackageNodeImpl(
            IdentifierNode name,
            PackageNodeCallback packageNodeCallback,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.name = name;
        this.packageNodeCallback = packageNodeCallback;
    }
    
    /**
     * Gets the simple name of this package.
     * @return The simple name of this package.
     */
    public IdentifierNode getName()
    {
        getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.name;
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
        if (this.name != null)
        {
            this.name.receive(visitor);
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
        if (this.name != null)
        {
            this.name.receiveTyped(visitor);
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
        visitor.visitPackageNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitPackageNodeStop(this, true);
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
        list.add(getName());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getName()});
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
        sb.append("name=");
        sb.append(this.getName() == null? "null" : this.getName().getClass().getSimpleName());
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
        return operation.executePackageNode(this, p);
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
        return operation.executePackageNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makePackageNode(
                getName()==null?null:getName().deepCopy(factory),
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
        
        return false;
    }
    
	/** The subpackages we are currently maintaining. */
	private Map<String, PackageNode> packageNodes = new HashMap<String, PackageNode>();
	/** The compilation units we are currently maintaining. */
	private Map<String, CompilationUnitNode> compilationUnitNodes = new HashMap<String, CompilationUnitNode>();
	/**
	 * The compilation units which cannot be loaded.  Requests to load these compilation units will result in
	 * <code>null</code> returns.  This set is used primarily to cache failed loads but is also used to prevent the
	 * call to {@link #addPackageNode(PackageNode)} which is caused by {@link #load(String)} from causing a loop.
	 */
	private Set<String> unloadableCompilationUnitNames = new HashSet<String>();
	/**
	 * The attributes which are tracking access to compilation units.
	 */
	private Map<String, PackageCompilationUnitAttribute> compilationUnitAttributes =
			new HashMap<String, PackageCompilationUnitAttribute>();
	/**
	 * An attribute to track the iterator for this node.
	 */
	private NonConflictingReadWriteAttribute iteratorAttribute = new NonConflictingReadWriteAttribute(this);
	
	/**
	 * Lazily creates compilation unit attributes.
	 */
	private PackageCompilationUnitAttribute getPackageCompilationUnitAttribute(String compilationUnitName)
	{
		PackageCompilationUnitAttribute ret = this.compilationUnitAttributes.get(compilationUnitName);
		if (ret==null)
		{
			ret = new PackageCompilationUnitAttribute(this);
			this.compilationUnitAttributes.put(compilationUnitName, ret);
		}
		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addPackage(PackageNode packageNode)
	{
		if (this.packageNodes.containsKey(packageNode.getName().getIdentifier()))
		{
			throw new DuplicatePackageMemberExceptionImpl(this, packageNode, packageNode.getName().getIdentifier());
		}
		getManager().assertInsertable(this);
		this.packageNodes.put(packageNode.getName().getIdentifier(), packageNode);
		setAsChild(packageNode, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public PackageNode getSubpackage(String name)
	{
		PackageNode packageNode = this.packageNodes.get(name);
		if (packageNode == null)
		{
			BsjNodeFactory factory = packageNodeCallback.getFactory();
			packageNode = factory.makePackageNode(factory.makeIdentifierNode(name));
			setAsChild(packageNode, true);
			this.packageNodes.put(name, packageNode);
		}
		return packageNode;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addCompilationUnit(CompilationUnitNode compilationUnit)
	{
		getManager().assertInsertable(this);
		getPackageCompilationUnitAttribute(compilationUnit.getName()).recordAccess(
				PackageCompilationUnitAttribute.AccessType.WRITE);
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.WRITE);
		if (this.load(compilationUnit.getName()) != null)
		{
			throw new DuplicatePackageMemberExceptionImpl(this, compilationUnit, compilationUnit.getName());
		}
		this.compilationUnitNodes.put(compilationUnit.getName(), compilationUnit);
		setAsChild(compilationUnit, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public CompilationUnitNode getCompilationUnit(String name)
	{
		getPackageCompilationUnitAttribute(name).recordAccess(PackageCompilationUnitAttribute.AccessType.READ);
		return this.compilationUnitNodes.get(name);
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<CompilationUnitNode> getCompilationUnitIterator()
	{
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.READ);
		return Collections.unmodifiableMap(compilationUnitNodes).values().iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<CompilationUnitNode> getRecursiveCompilationUnitIterator()
	{
		List<Iterator<? extends CompilationUnitNode>> iterators = new ArrayList<Iterator<? extends CompilationUnitNode>>();
		iterators.add(getCompilationUnitIterator());
		for (PackageNode p : packageNodes.values())
		{
			iterators.add(p.getRecursiveCompilationUnitIterator());
		}
		return new CompoundIterator<CompilationUnitNode>(iterators.iterator());
	}

	/**
	 * Used to allow visitation over the children of this package.
	 * @return An iterator which iterates over the compilation units in this package and all of its subpackages.
	 */
	protected Iterator<? extends Node> getHiddenVisitorChildren()
	{
		List<Iterator<? extends Node>> iterators = new ArrayList<Iterator<? extends Node>>();
		iterators.add(super.getHiddenVisitorChildren());
		iterators.add(getRecursiveCompilationUnitIterator());
		return new CompoundIterator<Node>(iterators.iterator());
	}

	/**
	 * {@inheritDoc}
	 */
	public PackageNode getSubpackageByQualifiedName(String name)
	{
		String[] nameComponents = name.split("\\.");
		PackageNode p = this;
		for (String component : nameComponents)
		{
			p = p.getSubpackage(component);
			if (p == null)
			{
				break;
			}
		}
		return p;
	}

	/**
	 * {@inheritDoc}
	 */
	public PackageNode getSubpackageByQualifiedName(NameNode name)
	{
		if (name instanceof QualifiedNameNode)
		{
			QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) name;
			PackageNode packageNode = getSubpackageByQualifiedName(qualifiedNameNode.getBase());
			return packageNode.getSubpackage(name.getIdentifier().getIdentifier());
		} else if (name instanceof SimpleNameNode)
		{
			return getSubpackage(name.getIdentifier().getIdentifier());
		} else
		{
			throw new IllegalStateException("Unrecognized name node type " + name.getClass().getName());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name)
	{
		CompilationUnitNode compilationUnitNode = getCompilationUnit(name);
		if (compilationUnitNode != null)
		{
			NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(compilationUnitNode, name);
			if (namedTypeDeclarationNode != null)
			{
				return namedTypeDeclarationNode;
			}
		}

		// If we couldn't find it in its own compilation unit node, let's go find it by searching the package
		Iterator<CompilationUnitNode> it = getCompilationUnitIterator();
		while (it.hasNext())
		{
			NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(it.next(), name);
			if (namedTypeDeclarationNode != null)
			{
				return namedTypeDeclarationNode;
			}
		}

		return null;
	}

	// TODO: consider generalizing this to a public function of CompilationUnitNode
	/**
	 * Searches the specified child for a top-level type declaration of the specified name.
	 * 
	 * @param compilationUnitNode The child in question.
	 * @param name The name of the type declaration.
	 * @return The resulting top-level type declaration.
	 */
	private static NamedTypeDeclarationNode<?> tryCompilationUnitNode(CompilationUnitNode compilationUnitNode,
			String name)
	{
		for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
		{
			if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
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
		StringBuilder sb = new StringBuilder();
		PackageNode node = this;
		while (true)
		{
			if (node.getName() == null)
			{
				return sb.toString();
			}
			if (sb.length() > 0)
			{
				sb.insert(0, '.');
			}
			sb.insert(0, node.getName().getIdentifier());
			if (node.getParent() instanceof PackageNode)
			{
				node = (PackageNode) node.getParent();
			} else
			{
				return null;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(String name)
	{
		getPackageCompilationUnitAttribute(name).recordAccess(PackageCompilationUnitAttribute.AccessType.READ);
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.READ);
		if (compilationUnitNodes.get(name) != null)
		{
			return true;
		}
		return this.packageNodeCallback.contains(this, name);
	}

	/**
	 * {@inheritDoc}
	 */
	public CompilationUnitNode load(String name)
	{
		getPackageCompilationUnitAttribute(name).recordAccess(PackageCompilationUnitAttribute.AccessType.LOAD);
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.WRITE);
		
		CompilationUnitNode compilationUnitNode;

		if (compilationUnitNodes.get(name) != null)
		{
			compilationUnitNode = compilationUnitNodes.get(name);
		} else if (unloadableCompilationUnitNames.contains(name))
		{
			return null;
		} else
		{
			// Try to load the compilation unit.  Temporarily add it to the unloadable names set to prevent a loop.
			unloadableCompilationUnitNames.add(name);
			compilationUnitNode = this.packageNodeCallback.load(this, name);
			unloadableCompilationUnitNames.remove(name);
			
			if (compilationUnitNode == null)
			{
				unloadableCompilationUnitNames.add(name);
				return null;
			}
			this.compilationUnitNodes.put(compilationUnitNode.getName(), compilationUnitNode);
		}

		this.packageNodeCallback.registerAsInjectorOf(compilationUnitNode);

		return compilationUnitNode;
	}

	/**
	 * {@inheritDoc}
	 */
	public void loadAll()
	{
		for (String name : packageNodeCallback.listCompilationUnitNames(this))
		{
			load(name);
		}
	}
}
