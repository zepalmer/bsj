package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.HashSet;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * A callback module for package nodes. This allows package nodes to request the load of specific compilation units into
 * the compiler.
 * 
 * @author Zachary Palmer
 */
public class PackageNodeManager
{
	/** The toolkit to use during callback operations. */
	private BsjToolkit toolkit;

	/** A set of event listeners. */
	private Set<PackageNodeListener> listeners = new HashSet<PackageNodeListener>(1);

	public PackageNodeManager(BsjToolkit toolkit)
	{
		super();
		this.toolkit = toolkit;
	}

	public void addListener(PackageNodeListener listener)
	{
		this.listeners.add(listener);
	}

	public void removeListener(PackageNodeListener listener)
	{
		this.listeners.remove(listener);
	}

	public void fireCompilationUnitAdded(PackageNode packageNode, CompilationUnitNode compilationUnitNode,
			boolean purelyInjected)
	{
		for (PackageNodeListener listener : this.listeners)
		{
			listener.compilationUnitAdded(packageNode, compilationUnitNode, purelyInjected);
		}
	}

	public void fireSubpackageAdded(PackageNode packageNode, PackageNode subPackageNode)
	{
		for (PackageNodeListener listener : this.listeners)
		{
			listener.subpackageAdded(packageNode, subPackageNode);
		}
	}

	public void fireRegisterAsInjector(CompilationUnitNode compilationUnitNode)
	{
		for (PackageNodeListener listener : this.listeners)
		{
			listener.compilationUnitInjected(compilationUnitNode);
		}
	}

	/**
	 * Retrieves a factory to use to create nodes.
	 */
	public BsjNodeFactory getFactory()
	{
		return this.toolkit.getNodeFactory();
	}

	/**
	 * Asks whether or not a compilation unit of the specified name exists.
	 * 
	 * @param packageNode The package node making the request.
	 * @param name The name of the compilation unit.
	 * @return <code>true</code> if the compilation unit exists; <code>false</code> otherwise.
	 */
	public boolean contains(PackageNode packageNode, String name)
	{
		String pname = packageNode.getFullyQualifiedName();
		if (pname == null)
		{
			return false;
		}

		for (BsjFileObject file : PackageNodeUtilities.findCompilationUnits(this.toolkit.getFileManager(), pname, false))
		{
			if (StringUtilities.getSuffix(file.inferBinaryName(), '.').equals(name))
			{
				return true;
			}
		}
		return false;
	}

}
