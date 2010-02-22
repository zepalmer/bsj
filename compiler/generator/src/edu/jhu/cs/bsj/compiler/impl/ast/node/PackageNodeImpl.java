package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeCallback;
import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterator;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class PackageNodeImpl extends NodeImpl implements PackageNode
{
    /** The simple name of this package. */
    private IdentifierNode name;

    /** The callback module for this package node. */
    private PackageNodeCallback packageNodeCallback;

    /** General constructor. */
    public PackageNodeImpl(
            IdentifierNode name,
            PackageNodeCallback packageNodeCallback,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        this.name = name;
        this.packageNodeCallback = packageNodeCallback;
    }

    /**
     * Gets the simple name of this package.
     * @return The simple name of this package.
     */
    public IdentifierNode getName()
    {
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
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makePackageNode(
                getName().deepCopy(factory),
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
        
        return false;
    }
    
	/** The subpackages we are currently maintaining. */
	private Map<String, PackageNode> packageNodes = new HashMap<String, PackageNode>();
	/** The compilation units we are currently maintaining. */
	private Map<String, CompilationUnitNode> compilationUnitNodes = new HashMap<String, CompilationUnitNode>();

	/**
	 * Adds a new subpackage to this node. This subpackage cannot already be a member of another package.
	 * 
	 * @param packageNode The package node to add.
	 */
	public void addPackageNode(PackageNode packageNode)
	{
		this.packageNodes.put(packageNode.getName().getIdentifier(), packageNode);
	}

	/**
	 * Retrieves a subpackage of this package.
	 * 
	 * @param name The simple name of the subpackage to retrieve.
	 * @return The subpackage. If it does not exist, <code>null</code> is returned.
	 */
	public PackageNode getSubpackage(String name)
	{
		return packageNodes.get(name);
	}

	/**
	 * Adds a new compilation unit to this node. This compilation unit cannot already be a member of another package.
	 * 
	 * @param compilationUnit The compilation unit to add.
	 */
	// TODO: exception if the compilation unit already exists
	public void addCompilationUnitNode(CompilationUnitNode compilationUnit)
	{
		this.compilationUnitNodes.put(compilationUnit.getName(), compilationUnit);
	}

	/**
	 * Retrieves a compilation unit in this package.
	 * 
	 * @param name The simple name of the compilation unit to retrieve.
	 * @return The compilation unit. If it does not exist or has not yet been loaded, <code>null</code> is returned.
	 */
	public CompilationUnitNode getCompilationUnit(String name)
	{
		return this.compilationUnitNodes.get(name);
	}

	/**
	 * Retrieves an iterator over all loaded compilation units in this package.
	 * 
	 * @return An iterator over all loaded compilation units.
	 */
	public Iterator<CompilationUnitNode> getCompilationUnitIterator()
	{
		return Collections.unmodifiableMap(compilationUnitNodes).values().iterator();
	}

	/**
	 * Retrieves an iterator over all loaded compilation units in this package and its known subpackages.
	 * 
	 * @return A recursive iterator over all loaded compilation units.
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
	 * Retrieves a subpackage of this package by qualified name. This method is provided for convenience and is
	 * equivalent to calling {@link #getSubpackage} compositionally.
	 * 
	 * @param name The qualified name of the subpackage to retrieve. The name components are separated by '.'
	 *            characters.
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
	 * Retrieves the full name of this package node. This method only returns a valid result if the package is attached
	 * to the root package.
	 * 
	 * @return The fully-qualified name of this package node or <code>null</code> if the name could not be determined.
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
	 * Determines whether or not this package node contains a compilation unit which has the specified simple name. This
	 * may be the case under any of the following three circumstances:
	 * <ul>
	 * <li>When a precompiled binary exists on the object program's classpath which represents the compilation unit.</li>
	 * <li>When a source file exists on the source path which defines the compilation unit.</li>
	 * <li>When a node created by a metaprogram has been explicitly added to this package.</li>
	 * </ul>
	 * 
	 * @param name The name of the compilation unit to check.
	 * @return <code>true</code> if the compilation unit exists; <code>false</code> otherwise.
	 */
	public boolean contains(String name)
	{
		if (compilationUnitNodes.get(name) != null)
		{
			return true;
		}
		return this.packageNodeCallback.contains(this, name);
	}

	/**
	 * Starts to load the specified compilation unit in this package. A compilation unit must be loaded before it is
	 * visible in the package hierarchy. Typically, compilation units are loaded by explicit mention when compilation is
	 * started or by dependency inference (such as when a metaprorgam mentions a dependency on a target which is in a
	 * different file or when a type reference is found in an on-demand import). It is possible for metaprograms to
	 * explicitly load compilation units which are not possible to infer, such as when the name of a compilation unit is
	 * mentioned in metaprogram code but no object program code causes a direct reference.
	 * <p/>
	 * It should be noted that this method will return without completing the compilation unit loading operation. Due to
	 * the fact that parsing, name analysis, and other such steps are required before the compilation unit becomes
	 * visible in the tree, the compilation unit will not become available until the next metaprogram starts. For that
	 * reason, an asynchronous programming approach to loading compilation units is recommended. Consider the following
	 * example:
	 * 
	 * <pre>
	 * [:
	 *     #target load;
	 *     ...
	 *     packageNode.load(compilationUnitName);
	 * :]
	 * [:
	 *     #depends load;
	 *     // operations which depend on the loaded compilation unit
	 *     ...
	 * :]
	 * </pre>
	 * 
	 * @param name The simple name of the compilation unit to load. No file extension should be provided.
	 * @return <code>true</code> if the compilation unit was located and will be loaded; <code>false</code> if it has
	 *         already been loaded.
	 * @throws FileNotFoundException If the specified compilation unit does not exist.
	 */
	public boolean load(String name) throws FileNotFoundException
	{
		// TODO: if a compilation unit was explicitly added to this package node and overrides a source file, we should
		// scream.
		// If we've already loaded this compilation unit, bail out.
		if (compilationUnitNodes.get(name) != null)
		{
			return false;
		}
		if (this.packageNodeCallback.load(this, name))
		{
			return true;
		} else
		{
			String pname = getFullyQualifiedName();
			if (pname == null)
				pname = getName().getIdentifier();
			throw new FileNotFoundException("Could not find compilation unit named " + name + " in package " + pname);
		}
	}

	/**
	 * Performs the load of every compilation unit available in this package.
	 * 
	 * @return <code>true</code> if at least one new compilation unit will be loaded; <code>false</code> if the entire
	 *         package has already been loaded.
	 */
	public boolean loadAll()
	{
		boolean ret = false;
		for (String name : packageNodeCallback.listCompilationUnitNames(this))
		{
			try
			{
				ret |= load(name);
			} catch (FileNotFoundException fnfe)
			{
				// This only happens if a file was deleted from the file system.
				// Current policy: ignore that.
				// TODO: this indicates some kind of inconsistency of the file system during compilation. Scream?
			}
		}
		return ret;
	}
}
