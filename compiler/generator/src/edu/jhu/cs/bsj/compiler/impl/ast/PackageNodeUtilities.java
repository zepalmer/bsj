package edu.jhu.cs.bsj.compiler.impl.ast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * Creates a class containing utilities for package nodes.
 * 
 * @author Zachary Palmer
 */
public final class PackageNodeUtilities
{
	private PackageNodeUtilities()
	{
	}

	/**
	 * Creates an iterable object which moves over {@link BsjFileObject}s which represent compilation units in the
	 * current package.
	 * 
	 * @param fileManager The file manager to use.
	 * @param pname The name of the package.
	 * @param binaryOnly <code>true</code> if only binaries should be listed; <code>false</code> if sources should be
	 *            listed as well.
	 */
	public static List<BsjFileObject> findCompilationUnits(BsjFileManager fileManager, String pname, boolean binaryOnly)
	{
		List<BsjFileObject> files = new ArrayList<BsjFileObject>();
		Set<String> names = new HashSet<String>();
		try
		{
			if (!binaryOnly)
			{
				for (BsjFileObject file : fileManager.listFiles(BsjCompilerLocation.SOURCE_PATH, pname,
						Arrays.asList(Kind.OTHER), false))
				{
					if (StringUtilities.getSuffix(file.getName(), '.').equals("bsj"))
					{
						if (names.add(getCompilationUnitName(file)) && !binaryOnly)
						{
							files.add(file);
						}
					}
				}

				for (BsjFileObject file : fileManager.listFiles(BsjCompilerLocation.SOURCE_PATH, pname,
						Arrays.asList(Kind.SOURCE), false))
				{
					if (names.add(getCompilationUnitName(file)) && !binaryOnly)
					{
						files.add(file);
					}
				}
			}

			for (BsjFileObject file : fileManager.listFiles(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, pname,
					Arrays.asList(Kind.CLASS), false))
			{
				// TODO: exclude class files which represent inner classes, etc. (instead ensuring that they are
			    // properly represented as members of their enclosing class)
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}

			for (BsjFileObject file : fileManager.listFiles(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, pname,
					Arrays.asList(Kind.CLASS), false))
			{
                // TODO: exclude class files which represent inner classes, etc. (instead ensuring that they are
                // properly represented as members of their enclosing class)
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}
		} catch (IOException ioe)
		{
			// TODO: how do we handle this?
			throw new NotImplementedYetException(ioe);
		}

		return files;
	}

	/**
	 * Determines the compilation unit name of the specified BSJ file object.
	 * 
	 * @param bsjFileObject The object to process.
	 * @return The compilation unit name of that object.
	 */
	public static String getCompilationUnitName(BsjFileObject bsjFileObject)
	{
		return StringUtilities.getSuffix(bsjFileObject.inferBinaryName(), '.');
	}
}
