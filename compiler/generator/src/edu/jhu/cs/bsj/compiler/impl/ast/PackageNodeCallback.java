package edu.jhu.cs.bsj.compiler.impl.ast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;

/**
 * A callback module for package nodes. This allows package nodes to request the load of specific compilation units into
 * the compiler.
 * 
 * @author Zachary Palmer
 */
public class PackageNodeCallback
{
	/** The file manager to use in this callback. */
	private BsjFileManager fileManager;
	/** The metacompilation manager to notify of new file additions. */
	private MetacompilationManager metacompilationManager;

	public void setFileManager(BsjFileManager fileManager)
	{
		this.fileManager = fileManager;
	}

	public void setMetacompilationManager(MetacompilationManager metacompilationManager)
	{
		this.metacompilationManager = metacompilationManager;
	}

	/**
	 * Determines the compilation unit name of the specified BSJ file object.
	 * 
	 * @param bsjFileObject The object to process.
	 * @return The compilation unit name of that object.
	 */
	protected String getCompilationUnitName(BsjFileObject bsjFileObject)
	{
		return StringUtilities.getSuffix(bsjFileObject.inferBinaryName(), '.');
	}

	/**
	 * Creates an iterable object which moves over {@link BsjFileObject}s which represent compilation units in the
	 * current package.
	 */
	protected Iterable<BsjFileObject> findCompilationUnits(String pname)
	{
		List<BsjFileObject> files = new ArrayList<BsjFileObject>();
		Set<String> names = new HashSet<String>();
		try
		{
			for (BsjFileObject file : this.fileManager.listFiles(BsjCompilerLocation.SOURCE_PATH, pname,
					Arrays.asList(Kind.OTHER), false))
			{
				if (StringUtilities.getSuffix(file.getName(), '.').equals("bsj"))
				{
					if (names.add(getCompilationUnitName(file)))
					{
						files.add(file);
					}
				}
			}

			for (BsjFileObject file : this.fileManager.listFiles(BsjCompilerLocation.SOURCE_PATH, pname,
					Arrays.asList(Kind.SOURCE), false))
			{
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}

			for (BsjFileObject file : this.fileManager.listFiles(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, pname,
					Arrays.asList(Kind.CLASS), false))
			{
				// TODO: exclude class files which represent inner classes, etc.
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}
		} catch (IOException ioe)
		{
			// TODO: how do we handle this?
		}
		
		return files;
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

		for (BsjFileObject file : findCompilationUnits(pname))
		{
			if (StringUtilities.getSuffix(file.inferBinaryName(), '.').equals(name))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Requests the load of a single compilation unit.
	 * 
	 * @param packageNode The package node making the request.
	 * @param name The name of the compilation unit.
	 * @return <code>true</code> if the compilation unit was found and will be loaded; <code>false</code> if it does not
	 *         appear to exist.
	 */
	public boolean load(PackageNode packageNode, String name)
	{
		String pname = packageNode.getFullyQualifiedName();
		if (pname == null)
		{
			return false;
		}

		for (BsjFileObject file : findCompilationUnits(pname))
		{
			if (getCompilationUnitName(file).equals(name))
			{
				return this.metacompilationManager.addCompilationUnit(file);
			}
		}

		return false;
	}

	/**
	 * Lists all of the compilation units which appear to be in the specified package.
	 * 
	 * @param packageNode The package node making the request.
	 * @return An iterator over the names of the compilation units in the package.
	 */
	public Iterable<String> listCompilationUnitNames(PackageNode packageNode)
	{
		String pname = packageNode.getFullyQualifiedName();
		if (pname == null)
		{
			return Collections.<String> emptySet();
		}

		List<String> names = new ArrayList<String>();
		for (BsjFileObject file : findCompilationUnits(pname))
		{
			names.add(getCompilationUnitName(file));
		}
		return names;
	}
}
