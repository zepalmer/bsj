package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.util.ClassPath;
import org.apache.bcel.util.Repository;
import org.apache.bcel.util.SyntheticRepository;

/**
 * This BCEL {@link Repository} implementation is used to allow the BSJ compiler to examine the object program's
 * classpath. This allows the BSJ compiler to reflectively analyze the types which are available to the BSJ code which
 * is being compiled without loading those binaries into the JVM. This repository implementation is distinct from the
 * {@link SyntheticRepository} in that it does not first consult the classpath of this JVM when attempting to load a
 * class. For instance, if this JVM and the object program's classpath both contained a .class file with the name
 * "a.b.C", then the {@link SyntheticRepository} would provide information about the JVM's a.b.C; this repository would
 * provide information about the object program's "a.b.C". This is a particularly important trait when writing later
 * versions of BSJ in earlier versions of BSJ.
 * 
 * @author Zachary Palmer
 */
public class BsjBcelRepository implements Repository
{
	private static final long serialVersionUID = 1L;

	/** The {@link ClassPath} to use in this repository. */
	private ClassPath classPath;
	/** The cache mapping class names to their corresponding {@link JavaClass} objects. */
	private Map<String, JavaClass> cache;
	/** The cache of names which have been searched and have not turned up valid Java classes. */
	private Set<String> nonexistentClassNames;

	/**
	 * Creates a new repository which draws its information from the provided classpath.
	 * 
	 * @param classPath The classpath to use.
	 */
	public BsjBcelRepository(ClassPath classPath)
	{
		super();
		this.classPath = classPath;
		this.cache = new HashMap<String, JavaClass>();
		this.nonexistentClassNames = new HashSet<String>();
	}

	@Override
	public void clear()
	{
		this.cache.clear();
		this.nonexistentClassNames.clear();
	}

	@Override
	public JavaClass findClass(String name)
	{
		if (this.nonexistentClassNames.contains(name))
		{
			return null;
		}
		if (this.cache.containsKey(name))
		{
			return this.cache.get(name);
		}
		try
		{
			JavaClass jc = loadClass(name);
			this.cache.put(name, jc);
			return jc;
		} catch (ClassNotFoundException e)
		{
			this.nonexistentClassNames.add(name);
			return null;
		}
	}

	@Override
	public ClassPath getClassPath()
	{
		return this.classPath;
	}

	@Override
	public JavaClass loadClass(@SuppressWarnings("rawtypes") Class c) throws ClassNotFoundException
	{
		return loadClass(c.getName());
	}

	@Override
	public JavaClass loadClass(String name) throws ClassNotFoundException
	{
		String filename = name;
		if (filename.indexOf('.')!=-1)
		{
			filename = filename.substring(filename.indexOf('.') + 1);
		}
		
		try
		{
			InputStream is = this.classPath.getClassFile(name).getInputStream();
			ClassParser parser = new ClassParser(is, filename);
			return parser.parse();
		} catch (ClassFormatException e)
		{
			throw new ClassNotFoundException("Failed to read class " + name + ": bad format", e);
		} catch (IOException e)
		{
			throw new ClassNotFoundException("Failed to read class " + name + ": I/O error", e);
		}
	}

	@Override
	public void removeClass(JavaClass jc)
	{
		if (this.cache.get(jc.getClassName()) != null)
		{
			this.cache.remove(jc);
		}
	}

	@Override
	public void storeClass(JavaClass jc)
	{
		this.cache.put(jc.getClassName(), jc);
	}

}
