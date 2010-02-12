package edu.jhu.cs.bsj.compiler.utils.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;
import edu.jhu.cs.bsj.compiler.utils.generator.TypeDefinition.Mode;

/**
 * This class generates some patternistic sources for the BSJ parser. The code is awful; it's not intended for long-term
 * maintenance, as it will become obsolete once the BSJ compiler has been reimplemented in BSJ.
 * 
 * @author Zachary Palmer
 */
public class SourceGenerator
{
	private static final File CONTENTS_FILE = new File("data/srcgen/ast.xml");
	private static final File SUPPLEMENTS_DIR = new File("data/srcgen/supplement/");
	private static final File TARGET_DIR = new File("out/");
	private static final File TARGET_IMPL_DIR = new File(TARGET_DIR.getAbsolutePath() + File.separator
			+ "implementation");
	private static final File TARGET_IFACE_DIR = new File(TARGET_DIR.getAbsolutePath() + File.separator + "interface");
	private static final String[] IFACE_IMPORTS = { "edu.jhu.cs.bsj.compiler.ast.*",
			"edu.jhu.cs.bsj.compiler.ast.node.*", "edu.jhu.cs.bsj.compiler.ast.node.meta.*", "java.util.*",
			"javax.annotation.Generated" };
	private static final String[] CLASS_IMPORTS = { "edu.jhu.cs.bsj.compiler.impl.ast.*",
			"edu.jhu.cs.bsj.compiler.impl.ast.node.*", "edu.jhu.cs.bsj.compiler.impl.ast.node.meta.*",
			"edu.jhu.cs.bsj.compiler.impl.utils.*", "javax.annotation.Generated" };
	private static final Set<String> PRIMITIVE_TYPES = new HashSet<String>(Arrays.asList(new String[] { "int", "long",
			"boolean", "float", "double", "short", "byte", "char" }));
	private static final Set<String> PRIMITIVE_CONTAINER_TYPES = new HashSet<String>(Arrays.asList(new String[] {
			"Long", "Integer", "Short", "Byte", "Double", "Float", "Boolean", "String", "Character" }));
	private static final Set<String> ENUM_TYPES = new HashSet<String>(Arrays.asList(new String[] { "AccessModifier",
			"AssignmentOperator", "BinaryOperator", "NameCategory", "PrimitiveType", "UnaryOperator",
			"UnaryStatementOperator" }));

	/** Names the types of objects which are "deep copied" by simply copying the reference. */
	private static final Set<String> DIRECT_COPY_NAMES;

	static
	{
		Set<String> directCopy = new HashSet<String>();
		directCopy.addAll(PRIMITIVE_TYPES);
		directCopy.addAll(PRIMITIVE_CONTAINER_TYPES);
		directCopy.addAll(ENUM_TYPES);
		DIRECT_COPY_NAMES = Collections.unmodifiableSet(directCopy);
	}

	/**
	 * Names the types of objects which are deep copied by passing them as a single argument to their constructor.
	 */
	private static final Set<String> CLONEABLE_NAMES = Collections.unmodifiableSet(new HashSet<String>(
			Arrays.asList(new String[] { "BsjSourceLocation", })));

	private Set<DefinitionHandler> handlers = new HashSet<DefinitionHandler>();

	public static void main(String[] arg) throws Exception
	{
		SourceGenerator sg = new SourceGenerator();
		for (Class<?> c : SourceGenerator.class.getDeclaredClasses())
		{
			Class<? extends DefinitionHandler> handlerClass;
			try
			{
				handlerClass = c.asSubclass(DefinitionHandler.class);
			} catch (ClassCastException cce)
			{
				// Not a ClassDefHandler
				continue;
			}

			try
			{
				DefinitionHandler handler = handlerClass.newInstance();
				sg.handlers.add(handler);
			} catch (InstantiationException ie)
			{
				// Doesn't have a nullary constructor or is an interface, etc.
			}
		}
		sg.run();
	}

	private static void rmrf(File f)
	{
		if (f.isDirectory())
		{
			for (File c : f.listFiles())
			{
				rmrf(c);
			}
		}
		f.delete();
	}

	private static String getFileAsString(File f) throws IOException
	{
		byte[] data = new byte[(int) f.length()];
		FileInputStream fis = new FileInputStream(f);
		int left = data.length;
		while (left > 0)
		{
			left -= fis.read(data, data.length - left, left);
		}
		fis.close();
		String contents = new String(data);
		return contents;
	}

	public void run() throws IOException, SAXException, ParserConfigurationException
	{
		// Clear the target directory
		rmrf(TARGET_DIR);
		TARGET_DIR.mkdirs();

		// Initialize each handler
		for (DefinitionHandler handler : handlers)
			handler.init();

		// Parse the XML file for definitions
		SourceGenerationData data = new SourceGeneratorParser().parse(CONTENTS_FILE);

		// For each type, inform each handler
		for (TypeDefinition type : data.getTypes())
		{
			for (DefinitionHandler handler : handlers)
			{
				handler.handleTypeDefinition(type);
			}
		}

		// For each diagnostic, inform each handler
		for (DiagnosticDefinition diagnostic : data.getDiagnostics())
		{
			for (DefinitionHandler handler : handlers)
			{
				handler.handleDiagnosticDefinition(diagnostic);
			}
		}

		// Finish each handler
		for (DefinitionHandler handler : handlers)
			handler.finish();
	}

	/**
	 * Capitalizes the first letter of a string.
	 * 
	 * @param s The string.
	 * @return The modified string.
	 */
	static String capFirst(String s)
	{
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

	static class StringGroup
	{
		String name;
		List<String> strings;

		public StringGroup(String name, List<String> strings)
		{
			super();
			this.name = name;
			this.strings = strings;
		}
	}

	/**
	 * Performs a generic source file inclusion.
	 * 
	 * @param f The {@link File} to include.
	 * @param ps The {@link PrintStream} to which to write lines that need to be copied.
	 * @param start The start string.
	 * @param stop The stop string.
	 */
	private static void includeFileParts(File f, PrintStream ps, String start, String stop) throws IOException
	{
		boolean copying = false;
		String[] lines = getFileAsString(f).split("\n");

		for (int i = 0; i < lines.length; i++)
		{
			String s = lines[i];
			String trimmed = s.trim();
			if (trimmed.startsWith("/*") && trimmed.endsWith("*/"))
			{
				String commentContent = trimmed.substring(2, trimmed.length() - 2).trim();
				if (commentContent.startsWith("GEN:"))
				{
					String mode = commentContent.substring(4);
					if (mode.equals(start))
					{
						copying = true;
					} else if (mode.equals(stop))
					{
						copying = false;
					}

					continue;
				}
			}
			if (copying)
				ps.println(s);
		}
	}

	/**
	 * Performs a source file body inclusion.
	 * 
	 * @param f The {@link File} to include.
	 * @param ps The {@link PrintStream} to which to write lines that need to be copied.
	 */
	private static void includeBody(File f, PrintStream ps) throws IOException
	{
		includeFileParts(f, ps, "start", "stop");
	}

	/**
	 * Performs a source file import inclusion.
	 * 
	 * @param f The {@link File} to include.
	 * @param ps The {@link PrintStream} to which to write lines that need to be copied.
	 */
	private static void includeImports(File f, PrintStream ps) throws IOException
	{
		includeFileParts(f, ps, "headerstart", "headerstop");
	}

	/**
	 * Performs a source file body inclusion.
	 * 
	 * @param ps The {@link PrintStream} to which to write lines that need to be copied.
	 * @param names The names of the include files.
	 * @param dir The directory from which to obtain the include files.
	 */
	private static void includeAllBodies(PrintStream ps, Iterable<String> names, String dir) throws IOException
	{
		for (String name : names)
		{
			File f = new File(SUPPLEMENTS_DIR.getParent() + File.separator + "supplement" + File.separator + dir
					+ File.separator + name);
			includeBody(f, ps);
		}
	}

	/**
	 * Performs a source file body inclusion.
	 * 
	 * @param ps The {@link PrintStream} to which to write lines that need to be copied.
	 * @param names The names of the include files.
	 * @param dir The directory from which to obtain the include files.
	 */
	private static void includeAllImports(PrintStream ps, Iterable<String> names, String dir) throws IOException
	{
		for (String name : names)
		{
			File f = new File(SUPPLEMENTS_DIR.getParent() + File.separator + "supplement" + File.separator + dir
					+ File.separator + name);
			includeImports(f, ps);
		}
	}

	/**
	 * Writes a list of parameters suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as parameters.
	 */
	private static void printParameterList(PrintStream ps, List<PropertyDefinition> props)
	{
		printParameterList(ps, props, false);
	}

	/**
	 * Writes a list of parameters suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as parameters.
	 * @param skipMake <code>true</code> to skip properties which are excluded from the factory's make call;
	 *            <code>false</code> otherwise.
	 */
	private static void printParameterList(PrintStream ps, List<PropertyDefinition> props, boolean skipMake)
	{
		boolean first = true;
		ps.print("(");
		if (props.size() > 0)
		{
			ps.println();
			for (PropertyDefinition p : props)
			{
				if (p.getMode() != PropertyDefinition.Mode.SKIP || !skipMake)
				{
					if (!first)
					{
						ps.println(",");
					}
					first = false;

					ps.print("            " + p.getFullType() + " " + p.getName());
				}
			}
		}
		ps.print(")");
	}

	/**
	 * Writes a list of arguments suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as arguments.
	 */
	private static void printArgumentList(PrintStream ps, List<PropertyDefinition> props)
	{
		printArgumentList(ps, props, Collections.<String, String> emptyMap(), false);
	}

	/**
	 * Writes a list of arguments suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as arguments.
	 * @param overrideMap The override map for this argument list.
	 */
	private static void printArgumentList(PrintStream ps, List<PropertyDefinition> props,
			Map<String, String> overrideMap)
	{
		printArgumentList(ps, props, overrideMap, false);
	}

	/**
	 * Writes a list of arguments suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as arguments.
	 * @param skipMake <code>true</code> to skip properties which are excluded from the factory's make call;
	 *            <code>false</code> otherwise.
	 */
	private static void printArgumentList(PrintStream ps, List<PropertyDefinition> props, boolean skipMake)
	{
		printArgumentList(ps, props, Collections.<String, String> emptyMap(), skipMake);
	}

	/**
	 * Writes a list of arguments suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as arguments.
	 * @param overrideMap The override map for this argument list.
	 * @param skipMake <code>true</code> to skip properties which are excluded from the factory's make call;
	 *            <code>false</code> otherwise.
	 */
	private static void printArgumentList(PrintStream ps, List<PropertyDefinition> props,
			Map<String, String> overrideMap, boolean skipMake)
	{
		boolean first = true;
		ps.print("(");
		for (PropertyDefinition p : props)
		{
			if (p.getMode() != PropertyDefinition.Mode.SKIP || !skipMake)
			{
				if (!first)
				{
					ps.print(", ");
				}
				first = false;
				if (overrideMap.containsKey(p.getName()))
				{
					ps.print(overrideMap.get(p.getName()).trim());
				} else
				{
					ps.print(p.getName());
				}
			}
		}
		ps.print(")");
	}

	/**
	 * Prints imports for a file.
	 * 
	 * @param ps The stream on which to print.
	 * @param classImp <code>true</code> to include class imports; <code>false</code> otherwise.
	 */
	private static void printImports(PrintStream ps, boolean classImp)
	{
		for (String s : IFACE_IMPORTS)
		{
			ps.println("import " + s + ";");
		}
		if (classImp)
		{
			for (String s : CLASS_IMPORTS)
			{
				ps.println("import " + s + ";");
			}
		}
		ps.println();
	}

	/**
	 * Prints an annotation line indicating that the specified element was generated by this source code generator.
	 * 
	 * @param ps The print stream to which to write the annotation.
	 */
	private static void printGeneratedClause(PrintStream ps)
	{
		ps.println("@Generated(value={\"" + SourceGenerator.class.getName() + "\"})");
	}

	/**
	 * An interface implemented by those modules that wish to handle class definitions.
	 */
	static interface DefinitionHandler
	{
		public void init() throws IOException;

		public void handleTypeDefinition(TypeDefinition def) throws IOException;

		public void handleDiagnosticDefinition(DiagnosticDefinition def) throws IOException;

		public void finish() throws IOException;
	}

	/**
	 * A module which allows the creation of AST interfaces.
	 */
	static class InterfaceWriter extends ClassHierarchyBuildingHandler
	{
		@Override
		public void useDefinition(TypeDefinition def) throws IOException
		{
			String pkg = def.getInterfacePackage();
			if (pkg == null)
				pkg = "";
			File classFile = new File(TARGET_IFACE_DIR.getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + def.getBaseName() + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);
			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			// imports
			printImports(ps, false);
			includeAllImports(ps, def.getIncludes(), "nodes" + File.separator + "interface");

			ps.println("/**");
			ps.println(" * " + def.getDocString().replaceAll("\n", "\n * "));
			ps.println(" */");

			StringBuilder extendsClause = new StringBuilder();
			if (def.getFullSuper() != null)
				extendsClause.append(def.getFullSuper());
			for (String tag : def.getTags())
			{
				if (extendsClause.length() > 0)
					extendsClause.append(", ");
				extendsClause.append(tag);
			}
			if (extendsClause.length() > 0)
				extendsClause.insert(0, " extends ");

			printGeneratedClause(ps);
			ps.println("public interface " + def.getFullName() + extendsClause.toString());
			ps.println("{");
			// gen getters and setters
			for (PropertyDefinition p : def.getProperties())
			{
				ps.println("    /**");
				ps.println("     * Gets " + p.getDescription() + ".");
				ps.println("     * @return " + capFirst(p.getDescription()) + ".");
				ps.println("     */");
				ps.println("    public " + p.getFullType() + " get" + capFirst(p.getName()) + "();");
				ps.println();
				if (p.getMode() == PropertyDefinition.Mode.NORMAL)
				{
					ps.println("    /**");
					ps.println("     * Changes " + p.getDescription() + ".");
					ps.println("     * @param " + p.getName() + " " + capFirst(p.getDescription()) + ".");
					ps.println("     */");
					ps.println("    public void set" + capFirst(p.getName()) + "(" + p.getFullType() + " "
							+ p.getName() + ");");
					ps.println();
				}
			}

			// write deep copy interface
			ps.println("    /**");
			ps.println("     * Generates a deep copy of this node.");
			ps.println("     * @param factory The node factory to use to create the deep copy.");
			ps.println("     * @return The resulting deep copy node.");
			ps.println("     */");
			if (def.getBaseSuperName() != null)
				ps.println("    @Override");
			ps.println("    public " + def.getNameWithTypeParameters() + " deepCopy(BsjNodeFactory factory);");

			// write bodies
			includeAllBodies(ps, def.getIncludes(), "nodes" + File.separator + "interface");
			ps.println("}");
		}
	}

	/**
	 * Contains some handy utilities.
	 * 
	 * @author Zachary Palmer
	 */
	static abstract class AbstractDefinitionHandler implements DefinitionHandler
	{
		/**
		 * A do-nothing diagnostic definition handling method for backwards compatibility.
		 */
		@Override
		public void handleDiagnosticDefinition(DiagnosticDefinition def) throws IOException
		{
		}

		/**
		 * Creates a templated output file for a handler.
		 * 
		 * @param pkg The package for this file.
		 * @param mode The mode for this file: concrete class, abstract class, or interface.
		 * @param implementation <code>true</code> if this is an implementation class; <code>false</code> if it's an
		 *            interface class.
		 * @param type The name of the type. No extension is permitted; type arguments are allowed.
		 * @param includes <code>true</code> if a supplemental include file should be expected.
		 * @param headerString A string to insert before the class definition header (for programmatic Javadocs and the
		 *            like as necessary) or <code>null</code> to avoid using this feature.
		 * @param extendsName The type to extend or <code>null</code> for no extends clause.
		 * @param implementsNames The types to implement or an empty array for no implements clause.
		 * @return The print stream writing to that file. The body will be written and ready to be closed with a
		 *         <code>}</code>.
		 * @throws IOException If an I/O error occurs.
		 */
		protected PrependablePrintStream createOutputFile(String pkg, TypeDefinition.Mode mode, boolean implementation,
				String type, boolean includes, String headerString, String extendsName, String... implementsNames)
				throws IOException
		{
			String name;
			if (type.indexOf('<') != -1)
			{
				name = type.substring(0, type.indexOf('<'));
			} else
			{
				name = type;
			}
			name = name + ".java";

			File f = new File((implementation ? TARGET_IMPL_DIR : TARGET_IFACE_DIR).getPath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + name);
			f.getParentFile().mkdirs();
			PrependablePrintStream ret = new PrependablePrintStream(new FileOutputStream(f), "    ", 0);
			ret.println("package " + pkg + ";");
			ret.println();
			printImports(ret, implementation);
			if (includes)
			{
				includeAllImports(ret, Collections.singleton(name), implementation ? "implementation" : "interface");
			}
			if (headerString != null)
			{
				ret.println(headerString);
			}
			printGeneratedClause(ret);
			ret.print("public ");
			if (mode == TypeDefinition.Mode.CONCRETE)
			{
				ret.print("class");
			} else if (mode == TypeDefinition.Mode.ABSTRACT)
			{
				ret.print("abstract class");
			} else if (mode == TypeDefinition.Mode.INTERFACE)
			{
				ret.print("interface");
			}
			ret.print(" " + type);
			if (extendsName != null)
				ret.print(" extends " + extendsName);
			if (implementsNames != null && implementsNames.length > 0)
			{
				ret.print(" implements " + implementsNames[0]);
				for (int i = 1; i < implementsNames.length; i++)
				{
					ret.print(", ");
					ret.print(implementsNames[i]);
				}
			}
			ret.println();
			ret.println("{");
			if (includes)
			{
				includeAllBodies(ret, Collections.singleton(name), implementation ? "implementation" : "interface");
			}
			return ret;
		}
	}

	// TODO: eliminate most of this functionality or at least reimplement on the TypeDefinition class
	static abstract class ClassHierarchyBuildingHandler extends AbstractDefinitionHandler
	{
		protected static enum ReviewMode
		{
			ALPHABETICAL, FILE_ORDER
		}

		protected Map<String, TypeDefinition> map;
		/** Contains the names of definitions in the order in which we saw them. */
		protected List<String> defNames;

		/** The mode of review for the definitions. */
		protected ReviewMode mode;

		protected ClassHierarchyBuildingHandler()
		{
			this(ReviewMode.ALPHABETICAL);
		}

		protected ClassHierarchyBuildingHandler(ReviewMode mode)
		{
			super();
			this.mode = mode;
		}

		public void init() throws IOException
		{
			map = new HashMap<String, TypeDefinition>();
			defNames = new ArrayList<String>();
		}

		public void handleTypeDefinition(TypeDefinition def) throws IOException
		{
			map.put(def.getBaseName(), def);
			defNames.add(def.getBaseName());
		}

		public void finish() throws IOException
		{
			List<TypeDefinition> defList;
			if (mode == ReviewMode.ALPHABETICAL)
			{
				defList = new ArrayList<TypeDefinition>(map.values());
				Collections.sort(defList, new Comparator<TypeDefinition>()
				{
					@Override
					public int compare(TypeDefinition a, TypeDefinition b)
					{
						return a.getBaseName().compareTo(b.getBaseName());
					}
				});
			} else if (mode == ReviewMode.FILE_ORDER)
			{
				defList = new ArrayList<TypeDefinition>();
				for (String name : defNames)
				{
					defList.add(map.get(name));
				}
			} else
			{
				throw new IllegalStateException("Unrecognized review mode: " + mode);
			}
			for (TypeDefinition def : defList)
			{
				useDefinition(def);
			}
		}

		protected boolean defInstanceOf(TypeDefinition def, String classname)
		{
			while (def != null)
			{
				if (def.getBaseName().equals(classname))
					return true;
				def = map.get(def.getBaseSuperName());
			}
			return false;
		}

		protected boolean propInstanceOf(String propType, String classname)
		{
			if (propType.contains("<"))
				propType = propType.substring(0, propType.indexOf('<')).trim();
			return defInstanceOf(map.get(propType), classname);
		}

		protected List<PropertyDefinition> getRecursiveProps(TypeDefinition def)
		{
			List<PropertyDefinition> list = new ArrayList<PropertyDefinition>();
			// maps type parameter names to their values
			Map<String, String> replacementMap = new HashMap<String, String>();
			while (def != null)
			{
				for (PropertyDefinition p : def.getProperties())
				{
					if (replacementMap.containsKey(p.getBaseType()))
					{
						p = new PropertyDefinition(p.getName(), replacementMap.get(p.getBaseType()), null, p.getMode(),
								p.getDescription(), p.getDefaultExpression());
					} else if (replacementMap.containsKey(p.getTypeArg()))
					{
						p = new PropertyDefinition(p.getName(), p.getBaseType(), replacementMap.get(p.getTypeArg()),
								p.getMode(), p.getDescription(), p.getDefaultExpression());
					}
					list.add(p);
				}

				if (def.getSuperTypeArg() == null || def.getSuperTypeArg().length() == 0)
				{
					def = map.get(def.getBaseSuperName());
				} else
				{
					String superparam = def.getSuperTypeArg();
					def = map.get(def.getBaseSuperName());

					String nameParamPart = def.getUnboundedTypeParameter();
					String[] param = nameParamPart.split(",");
					for (int i = 0; i < param.length; i++)
					{
						if (param[i].contains(" "))
							param[i] = param[i].substring(0, param[i].indexOf(' ')).trim();
					}
					String[] args = superparam.split(",");

					for (int i = 0; i < args.length; i++)
						replacementMap.put(param[i], args[i]);
				}
			}
			return list;
		}

		public abstract void useDefinition(TypeDefinition def) throws IOException;

		protected void propAbstract(PropertyTypeAbstractor abstractor, PropertyDefinition p, PrependablePrintStream ps,
				TypeDefinition def)
		{
			if (DIRECT_COPY_NAMES.contains(p.getBaseType()))
			{
				abstractor.directCopy(ps, p);
			} else if (propInstanceOf(p.getBaseType(), "Node"))
			{
				abstractor.node(ps, p);
			} else if (CLONEABLE_NAMES.contains(p.getBaseType()))
			{
				abstractor.cloneable(ps, p);
			} else if (p.getBaseType().equals("List"))
			{
				abstractor.list(ps, p);
			} else if (p.getBaseType().equals("Void"))
			{
				abstractor.voidType(ps, p);
			} else
			{
				throw new IllegalStateException("Don't know how to handle a value of type " + p.getFullType()
						+ " for definition " + def.getFullName());
			}
		}

		static interface PropertyTypeAbstractor
		{
			void directCopy(PrependablePrintStream ps, PropertyDefinition p);

			void node(PrependablePrintStream ps, PropertyDefinition p);

			void cloneable(PrependablePrintStream ps, PropertyDefinition p);

			void list(PrependablePrintStream ps, PropertyDefinition p);

			void voidType(PrependablePrintStream ps, PropertyDefinition p);
		}
	}

	/**
	 * A module which creates AST backing classes.
	 */
	static class BackingClassWriter extends ClassHierarchyBuildingHandler
	{
		public void useDefinition(TypeDefinition def) throws IOException
		{
			if (def.getMode() == TypeDefinition.Mode.INTERFACE)
			{
				return;
			}

			String rawclassname = def.getBaseName() + "Impl";
			String classname = rawclassname
					+ (def.getTypeParameter() == null ? "" : "<" + def.getTypeParameter() + ">");
			String superclassname = def.getBaseSuperName() + "Impl"
					+ (def.getUnboundedSuperTypeArg() == null ? "" : "<" + def.getUnboundedSuperTypeArg() + ">");

			String pkg = def.getClassPackage();
			if (pkg == null)
				pkg = "";
			File classFile = new File(TARGET_IMPL_DIR.getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + rawclassname + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrependablePrintStream ps = new PrependablePrintStream(fos, "    ", 0);

			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			printImports(ps, true);
			includeAllImports(ps, def.getIncludes(), "nodes" + File.separator + "implementation");

			printGeneratedClause(ps);
			ps.println("public " + (def.getMode() == TypeDefinition.Mode.CONCRETE ? "" : "abstract ") + "class "
					+ classname + (def.getBaseSuperName() == null ? "" : " extends " + superclassname) + " implements "
					+ def.getNameWithTypeParameters());
			ps.println("{");

			// gen properties
			for (PropertyDefinition p : def.getProperties())
			{
				ps.println("    /** " + capFirst(p.getDescription()) + ". */");
				ps.println("    private " + p.getFullType() + " " + p.getName() + ";");
				ps.println();
			}

			// gen constructor
			ps.println("    /** General constructor. */");
			if (!def.isGenConstructor())
				ps.println("/* (not generating constructor)"); // nogen logic
			ps.print("    " + (def.getMode() == TypeDefinition.Mode.CONCRETE ? "public" : "protected") + " "
					+ rawclassname);
			List<PropertyDefinition> recProps = getRecursiveProps(def);
			printParameterList(ps, recProps);
			ps.println();
			ps.println("    {");
			ps.print("        super");
			List<PropertyDefinition> superProps = new ArrayList<PropertyDefinition>(recProps);
			superProps.removeAll(def.getProperties());
			printArgumentList(ps, superProps, def.getConstructorOverrideMap());
			ps.println(";");
			for (PropertyDefinition p : def.getProperties())
			{
				String expr;
				if (def.getConstructorOverrideMap().containsKey(p.getName()))
				{
					expr = def.getConstructorOverrideMap().get(p.getName());
				} else
				{
					expr = p.getName();
				}
				if (propInstanceOf(p.getBaseType(), "Node"))
				{
					ps.println("        set" + capFirst(p.getName()) + "(" + expr + ");");
				} else
				{
					ps.println("        this." + p.getName() + " = " + expr + ";");
				}
			}
			ps.println("    }");
			if (!def.isGenConstructor())
				ps.print("*/"); // nogen logic
			ps.println();

			// gen getters and setters
			for (PropertyDefinition p : def.getProperties())
			{
				ps.println("    /**");
				ps.println("     * Gets " + p.getDescription() + ".");
				ps.println("     * @return " + capFirst(p.getDescription()) + ".");
				ps.println("     */");
				ps.println("    public " + p.getFullType() + " get" + capFirst(p.getName()) + "()");
				ps.println("    {");
				ps.println("        return this." + p.getName() + ";");
				ps.println("    }");
				ps.println();
				if (p.getMode() == PropertyDefinition.Mode.NORMAL)
				{
					ps.println("    /**");
					ps.println("     * Changes " + p.getDescription() + ".");
					ps.println("     * @param " + p.getName() + " " + capFirst(p.getDescription()) + ".");
					ps.println("     */");
					ps.println("    public void set" + capFirst(p.getName()) + "(" + p.getFullType() + " "
							+ p.getName() + ")");
					ps.println("    {");
					if (propInstanceOf(p.getBaseType(), "Node"))
					{
						ps.println("        if (this." + p.getName() + " instanceof NodeImpl)");
						ps.println("        {");
						ps.println("            ((NodeImpl)this." + p.getName() + ").setParent(null);");
						ps.println("        }");
					}
					ps.println("        this." + p.getName() + " = " + p.getName() + ";");
					if (propInstanceOf(p.getBaseType(), "Node"))
					{
						ps.println("        if (this." + p.getName() + " instanceof NodeImpl)");
						ps.println("        {");
						ps.println("            ((NodeImpl)this." + p.getName() + ").setParent(this);");
						ps.println("        }");
					}
					ps.println("    }");
					ps.println();
				}
			}

			// add simple visitor implementation
			ps.println("    /**");
			ps.println("     * Handles the visitation of this node's children for the provided visitor.  Each");
			ps.println("     * subclass should override this method, having the subclass implementation call this");
			ps.println("     * method first and then visit its subclass-specific children.");
			ps.println("     *");
			ps.println("     * @param visitor The visitor to visit this node's children.");
			ps.println("     */");
			if (def.getBaseSuperName() != null)
			{
				ps.println("    @Override");
			}
			ps.println("    protected void receiveToChildren(BsjNodeVisitor visitor)");
			ps.println("    {");
			if (def.getBaseSuperName() != null)
			{
				ps.println("        super.receiveToChildren(visitor);");
			}
			for (PropertyDefinition p : def.getProperties())
			{
				if (propInstanceOf(p.getBaseType(), "Node"))
				{
					ps.println("        if (this." + p.getName() + " != null)");
					ps.println("        {");
					ps.println("            this." + p.getName() + ".receive(visitor);");
					ps.println("        }");
				} else if (p.getBaseType().equals("List"))
				{
					// Let's assume that the list contains node objects!
					// TODO: this is pretty shoddy - can we improve on this?
					ps.println("        if (this." + p.getName() + " != null)");
					ps.println("        {");
					ps.println("            for (Node node : this." + p.getName() + ")");
					ps.println("            {");
					ps.println("                node.receive(visitor);");
					ps.println("            }");
					ps.println("        }");
				}
			}
			ps.println("    }");
			ps.println();

			// add typed visitor implementation
			ps.println("    /**");
			ps.println("     * Handles the visitation of this node's children for the provided typed visitor.  Each");
			ps.println("     * subclass should override this method, having the subclass implementation call this");
			ps.println("     * method first and then visit its subclass-specific children.");
			ps.println("     *");
			ps.println("     * @param visitor The visitor to visit this node's children.");
			ps.println("     */");
			if (def.getBaseSuperName() != null)
			{
				ps.println("    @Override");
			}
			ps.println("    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)");
			ps.println("    {");
			if (def.getBaseSuperName() != null)
			{
				ps.println("        super.receiveTypedToChildren(visitor);");
			}
			for (PropertyDefinition p : def.getProperties())
			{
				if (propInstanceOf(p.getBaseType(), "Node"))
				{
					ps.println("        if (this." + p.getName() + " != null)");
					ps.println("        {");
					ps.println("            this." + p.getName() + ".receiveTyped(visitor);");
					ps.println("        }");
				} else if (p.getBaseType().equals("List"))
				{
					// Let's assume that the list contains node objects!
					// TODO: this is pretty shoddy - can we improve on this?
					ps.println("        if (this." + p.getName() + " != null)");
					ps.println("        {");
					ps.println("            for (Node node : this." + p.getName() + ")");
					ps.println("            {");
					ps.println("                node.receiveTyped(visitor);");
					ps.println("            }");
					ps.println("        }");
				}
			}
			ps.println("    }");
			ps.println();
			if (def.getBaseSuperName() != null)
			{
				ps.println("    @Override");
			}
			ps.println("    public void receiveTyped(BsjTypedNodeVisitor visitor)");
			ps.println("    {");
			ps.println("        visitor.visitStartBegin(this);");
			TypeDefinition cur = def;
			List<TypeDefinition> backtrack = new LinkedList<TypeDefinition>();
			while (cur != null)
			{
				ps.print("        visitor.visit" + cur.getBaseName() + "Start(this");
				if (cur.getMode() == TypeDefinition.Mode.CONCRETE)
				{
					ps.print(", ");
					ps.print(String.valueOf(cur == def));
				}
				ps.println(");");
				backtrack.add(0, cur);
				cur = this.map.get(cur.getBaseSuperName());
			}
			for (String tag : def.getTags())
			{
				ps.println("        visitor.visit" + tag.trim() + "Start(this);");
			}
			ps.println("        visitor.visitStartEnd(this);");
			ps.println("        receiveTypedToChildren(visitor);");
			ps.println("        visitor.visitStopBegin(this);");
			for (String tag : def.getTags())
			{
				ps.println("        visitor.visit" + tag.trim() + "Stop(this);");
			}
			for (TypeDefinition edef : backtrack)
			{
				ps.print("        visitor.visit" + edef.getBaseName() + "Stop(this");
				if (edef.getMode() == TypeDefinition.Mode.CONCRETE)
				{
					ps.print(", ");
					ps.print(String.valueOf(edef == def));
				}
				ps.println(");");
			}
			ps.println("        visitor.visitStopEnd(this);");
			ps.println("    }");
			ps.println();

			// add logic for getting list of children
			ps.println("    /**");
			ps.println("     * Produces a mutable list of this node's children.  Modifying this list will have no");
			ps.println("     * effect on this node.");
			ps.println("     * @return A list of this node's children.");
			ps.println("     */");
			if (!def.isGenChildren())
				ps.println("/* // (not generating children)"); // nogen logic
			if (def.getBaseSuperName() != null)
			{
				ps.println("    @Override");
			}
			ps.println("    public List<Object> getChildObjects()");
			ps.println("    {");
			ps.println("        List<Object> list = "
					+ (def.getBaseSuperName() == null ? "new ArrayList<Object>();" : "super.getChildObjects();"));
			for (PropertyDefinition p : def.getProperties())
			{
				// special handling for startLocation and stopLocation
				if (p.getName().equals("startLocation"))
				{
					ps.println("        list.add(getStartLocation().toString() + \" - \" + getStopLocation().toString());");
				} else if (p.getName().equals("stopLocation"))
				{
					// intentionally doing nothing - handling for startLocation covers this one as well
				} else
				{
					ps.println("        list.add(get" + Character.toUpperCase(p.getName().charAt(0))
							+ p.getName().substring(1) + "());");
				}
			}
			ps.println("        return list;");
			ps.println("    }");
			if (!def.isGenChildren())
				ps.print("*/"); // nogen logic
			ps.println();

			// add logic for toString
			ps.println("    /**");
			ps.println("     * Obtains a human-readable description of this node.");
			ps.println("     * @return A human-readable description of this node.");
			ps.println("     */");
			ps.println("    public String toString()");
			ps.println("    {");
			ps.println("        StringBuilder sb = new StringBuilder();");
			if (def.getToStringLines() == null || def.getToStringLines().size() == 0)
			{
				ps.println("        sb.append(this.getClass().getSimpleName());");
				ps.println("        sb.append('[');");
				boolean firstProp = true;
				for (PropertyDefinition p : recProps)
				{
					if (firstProp)
					{
						firstProp = false;
					} else
					{
						ps.println("        sb.append(',');");
					}
					String capName = Character.toUpperCase(p.getName().charAt(0)) + p.getName().substring(1);
					ps.println("        sb.append(\"" + p.getName() + "=\");");
					if (propInstanceOf(p.getBaseType(), "Node"))
					{
						ps.println("        sb.append(this.get" + capName + "() == null? \"null\" : this.get" + capName
								+ "().getClass().getSimpleName());");
					} else
					{
						String typeString;
						if (PRIMITIVE_TYPES.contains(p.getBaseType()))
						{
							typeString = "\"" + p.getBaseType() + "\"";
						} else
						{
							typeString = "this.get" + capName + "() != null ? this.get" + capName
									+ "().getClass().getSimpleName() : \"null\"";
						}
						ps.println("        sb.append(String.valueOf(this.get" + capName + "()) + \":\" + ("
								+ typeString + "));");
					}
				}
				ps.println("        sb.append(']');");
			} else
			{
				for (String toStringLine : def.getToStringLines())
				{
					ps.println("        " + toStringLine);
				}
			}
			ps.println("        return sb.toString();");
			ps.println("    }");
			ps.println();

			// add node operation implementation
			if (def.getMode() == TypeDefinition.Mode.CONCRETE)
			{
				ps.println("    /**");
				ps.println("     * Executes an operation on this node.");
				ps.println("     * @param operation The operation to perform.");
				ps.println("     * @param p The parameter to pass to the operation.");
				ps.println("     * @return The result of the operation.");
				ps.println("     */");
				ps.println("    @Override");
				ps.println("    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)");
				ps.println("    {");
				ps.println("        return operation.execute" + def.getBaseName() + "(this, p);");
				ps.println("    }");
			}
			ps.println();

			// add deep copy implementation
			if (def.getMode() == TypeDefinition.Mode.CONCRETE)
			{
				ps.println("    /**");
				ps.println("     * Generates a deep copy of this node.");
				ps.println("     * @param factory The node factory to use to create the deep copy.");
				ps.println("     * @return The resulting deep copy node.");
				ps.println("     */");
				if (def.getBaseSuperName() != null)
					ps.println("    @Override");
				ps.println("    public " + def.getNameWithTypeParameters() + " deepCopy(BsjNodeFactory factory)");
				ps.println("    {");
				ps.println("        return factory.make" + def.getBaseName() + "(");
				boolean first = true;
				for (PropertyDefinition p : recProps)
				{
					if (p.getMode() == PropertyDefinition.Mode.SKIP)
						continue;
					if (first)
					{
						first = false;
					} else
					{
						ps.println(",");
					}
					ps.print("                ");

					propAbstract(new PropertyTypeAbstractor()
					{
						public void directCopy(PrependablePrintStream ps, PropertyDefinition p)
						{
							ps.print("get" + capFirst(p.getName()) + "()");
						}

						public void node(PrependablePrintStream ps, PropertyDefinition p)
						{
							ps.print("get" + capFirst(p.getName()) + "().deepCopy(factory)");
						}

						public void cloneable(PrependablePrintStream ps, PropertyDefinition p)
						{
							ps.print("(" + p.getFullType() + ")(get" + capFirst(p.getName()) + "().clone())");
						}

						public void list(PrependablePrintStream ps, PropertyDefinition p)
						{
							ps.print("new Array" + p.getFullType() + "(get" + capFirst(p.getName()) + "())");
						}

						public void voidType(PrependablePrintStream ps, PropertyDefinition p)
						{
							ps.print("null");
						}
					}, p, ps, def);
				}
				ps.println(");");
				ps.println("    }");
			}

			// add logic for node replacement
			ps.println("    /**");
			ps.println("     * Performs replacement for this node.");
			ps.println("     * @param before The node to replace.");
			ps.println("     * @param after The node to replace the <tt>before</tt> node.");
			ps.println("     * @return <code>true</code> if the replacement was successful; <code>false</code> if the");
			ps.println("     *         specified <tt>before</tt> node is not a child of this node.");
			ps.println("     */");
			boolean suppress = false;
			for (PropertyDefinition p : def.getProperties())
			{
				if (p.getTypeArg() != null)
				{
					suppress = true;
					break;
				}
			}
			if (suppress)
			{
				ps.println("    @SuppressWarnings(\"unchecked\")");
			}
			ps.println("    public <N extends Node> boolean replace(N before, N after)");
			ps.println("    {");
			if (def.getBaseSuperName() != null)
			{
				ps.println("        if (super.replace(before,after))");
				ps.println("            return true;");
			} else
			{
				ps.println("        if (before==null)");
				ps.println("            throw new IllegalArgumentException(\"Cannot replace node with before value of null.\");");
			}
			ps.println();
			for (PropertyDefinition p : def.getProperties())
			{
				if (propInstanceOf(p.getBaseType(), "Node"))
				{
					String propClass = p.getBaseType();
					boolean generic = false;
					String typeArg = "";
					if (p.getTypeArg() != null)
					{
						propClass = propClass + "<?>";
						generic = true;
						typeArg = p.getTypeArg();
						if (typeArg.contains(" "))
						{
							typeArg = typeArg.substring(0, typeArg.indexOf(" "));
						}
					}
					ps.println("        if (before.equals(this." + p.getName() + ") && (after instanceof " + propClass
							+ "))");
					ps.println("        {");
					if (generic)
					{
						if (p.getBaseType().equals("ListNode"))
						{
							ps.println("            for (Object listval : ((ListNode<?>)after).getChildren())");
							ps.println("            {");
							ps.println("                " + typeArg + ".class.cast(listval);");
							ps.println("            }");
						} else
						{
							throw new IllegalStateException("Don't know how to assert type safety for type "
									+ p.getFullType());
						}
					}
					ps.println("            set" + capFirst(p.getName()) + "((" + p.getFullType() + ")after);");
					ps.println("            return true;");
					ps.println("        }");
				} else if (p.getBaseType().equals("List"))
				{
					String typeArg = p.getTypeArg();
					// block to scope out index
					ps.println("        {");
					ps.println("            int index = " + p.getName() + ".indexOf(before);");
					ps.println("            if (index != -1)");
					// TODO: YUCK YUCK YUCK - this compels me further to make different types for each list node!
					ps.println("                " + p.getName() + ".set(index, (" + typeArg + ")after);");
					ps.println("        }");
				}
			}
			ps.println("        return false;");
			ps.println("    }");
			ps.println();

			// add supplements
			includeAllBodies(ps, def.getIncludes(), "nodes" + File.separator + "implementation");

			ps.println("}");
		}
	}

	/**
	 * Writes the BsjTypedNodeVisitor interface.
	 */
	static class BsjTypedNodeVisitorWriter extends AbstractDefinitionHandler
	{
		private Map<String, Set<String>> subtypeMap;
		private Map<String, String> supertypeMap;
		private List<String> abstractTypes;
		private Set<String> parameterizedTypes;
		private static final String[] MODES = { "Start", "Stop" };

		@Override
		public void init() throws IOException
		{
			subtypeMap = new HashMap<String, Set<String>>();
			supertypeMap = new HashMap<String, String>();
			abstractTypes = new ArrayList<String>();
			parameterizedTypes = new HashSet<String>();
		}

		@Override
		public void handleTypeDefinition(TypeDefinition def) throws IOException
		{
			String tname = def.getBaseName();
			String sname = def.getBaseSuperName();

			if (def.getTypeParameter() != null)
				parameterizedTypes.add(tname);

			if (!subtypeMap.containsKey(sname))
				subtypeMap.put(sname, new HashSet<String>());
			subtypeMap.get(sname).add(tname);
			supertypeMap.put(tname, sname);
			if (def.getMode() != TypeDefinition.Mode.CONCRETE)
				abstractTypes.add(tname);
		}

		@Override
		public void finish() throws IOException
		{
			// Generate name list in breadth-first order starting with root type
			List<String> names = new ArrayList<String>();
			for (String root : subtypeMap.get(null))
			{
				// Breadth-first addition to the list
				List<String> queue = new LinkedList<String>();
				queue.add(root);
				while (queue.size() > 0)
				{
					String type = queue.remove(0);
					names.add(type);
					Set<String> subs = subtypeMap.get(type);
					if (subs != null)
						queue.addAll(subs);
				}
			}

			Set<String> concreteTypeNameSet = new HashSet<String>(names);
			concreteTypeNameSet.removeAll(abstractTypes);
			List<String> sortedNames = new ArrayList<String>(names);
			Collections.sort(sortedNames);

			// Write interface
			PrintStream ps = createOutputFile("edu.jhu.cs.bsj.compiler.ast", TypeDefinition.Mode.INTERFACE, false,
					"BsjTypedNodeVisitor", true, null, null);
			writeTypeBody(ps, false, sortedNames, concreteTypeNameSet);
			ps.println("}");
			ps.close();

			// Write default implementation
			ps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", TypeDefinition.Mode.CONCRETE, false,
					"BsjTypedNodeNoOpVisitor", true, null, null, "BsjTypedNodeVisitor");
			writeTypeBody(ps, true, sortedNames, concreteTypeNameSet);
			ps.println("}");
			ps.close();
		}

		private void writeTypeBody(PrintStream ps, boolean concreteType, List<String> sortedNames,
				Set<String> concreteTypeNameSet)
		{
			String methodSuffix = concreteType ? "\n    {\n    }" : ";";

			// write visit{Start,Stop}{Begin,End} methods
			for (String mode : MODES)
			{
				for (String event : new String[] { "Begin", "End" })
				{
					ps.println("    /**");
					ps.println("     * " + event + "s a sequence of visit " + mode.toLowerCase() + " calls on a node.");
					ps.println("     * @param node The node in question.");
					ps.println("     */");
					ps.println("    public void visit" + mode + event + "(Node node)" + methodSuffix);
					ps.println();
				}
			}

			// Write type-specific visit methods.
			for (String mode : MODES)
			{
				for (String name : sortedNames)
				{
					boolean concrete = concreteTypeNameSet.contains(name);
					ps.println("    /**");
					ps.println("     * " + mode + "s a visit for nodes of type " + name + ".");
					ps.println("     * @param node The node being visited.");
					if (concrete)
					{
						ps.println("     * @param mostSpecific <code>true</code> if this is the most specific call");
						ps.println("     *                     which can be made for this node; <code>false</code>");
						ps.println("     *                     otherwise.");
					}
					ps.println("     */");
					ps.print("    public void visit" + name + mode + "(" + name
							+ (parameterizedTypes.contains(name) ? "<?>" : "") + " node");
					if (concrete)
					{
						ps.print(", boolean mostSpecific");
					}
					ps.print(")");
					ps.println(methodSuffix);
					ps.println();
				}
			}
		}
	}

	/**
	 * Writes the BSJ AST node factory interface and implementation.
	 */
	static class FactoryWriter extends ClassHierarchyBuildingHandler
	{
		/** Print stream for the interface. */
		PrintStream ips;
		/** Print stream for the implementation. */
		PrintStream cps;
		/** Print stream for the decorator utility class. */
		PrintStream dps;

		@Override
		public void init() throws IOException
		{
			super.init();

			this.ips = createOutputFile("edu.jhu.cs.bsj.compiler.ast", TypeDefinition.Mode.INTERFACE, false,
					"BsjNodeFactory", true, null, null);
			this.cps = createOutputFile("edu.jhu.cs.bsj.compiler.impl.ast", TypeDefinition.Mode.CONCRETE, true,
					"BsjNodeFactoryImpl", true, null, null, "BsjNodeFactory");
			this.dps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", TypeDefinition.Mode.ABSTRACT, false,
					"BsjNodeFactoryDecorator", true, null, null, "BsjNodeFactory");
		}

		@Override
		public void useDefinition(TypeDefinition def) throws IOException
		{
			if (def.getMode() == TypeDefinition.Mode.CONCRETE)
			{
				List<PropertyDefinition> recProps = getRecursiveProps(def);

				// Write normal factory method
				List<FactoryMethodPropertyDefinition> standardFactoryMethodProperties = new ArrayList<FactoryMethodPropertyDefinition>();
				for (PropertyDefinition p : recProps)
				{
					standardFactoryMethodProperties.add(new FactoryMethodPropertyDefinition(p.getName(), true));
				}
				FactoryMethodDefinition standardFactoryDefinition = new EnumeratedFactoryMethodDefinition(
						standardFactoryMethodProperties);
				for (boolean skipMake : new boolean[] { true, false })
				{
					writeFactoryMethod(def, standardFactoryDefinition, skipMake);
				}

				// Write extra factory methods as instructed
				for (FactoryMethodDefinition methodDefinition : def.getFactoryMethods())
				{
					for (boolean skipMake : new boolean[] { true, false })
					{
						writeFactoryMethod(def, methodDefinition, skipMake);
					}
				}
			}
		}

		@Override
		public void finish() throws IOException
		{
			super.finish();

			ips.println("}");
			ips.close();

			cps.println("}");
			cps.close();

			dps.println("}");
			dps.close();
		}

		private void writeFactoryMethod(TypeDefinition def, FactoryMethodDefinition methodDefinition, boolean skipMake)
		{
			String typeParam;
			String typeName;
			String typeArg;
			if (def.getTypeParameter() != null)
			{
				typeParam = def.getTypeParameter();
				String[] args = typeParam.split(",");
				for (int i = 0; i < args.length; i++)
				{
					if (args[i].contains(" "))
						args[i] = args[i].substring(0, args[i].indexOf(' ')).trim();
				}
				StringBuilder sb = new StringBuilder();
				for (String s : args)
				{
					if (sb.length() > 0)
						sb.append(",");
					sb.append(s);
				}
				sb.insert(0, "<");
				sb.append(">");
				typeArg = sb.toString();
			} else
			{
				typeParam = null;
				typeArg = "";
			}
			typeName = def.getBaseName() + typeArg;
			String typeParamS = typeParam == null ? "" : ("<" + typeParam + "> ");

			// Property analysis: what is required as input?
			List<PropertyDefinition> recProps = getRecursiveProps(def);
			List<PropertyDefinition> argProps = new ArrayList<PropertyDefinition>();
			for (PropertyDefinition recProp : recProps)
			{
				if (methodDefinition.isVisible(recProp.getName()) || recProp.isSkipMake() && !skipMake)
				{
					argProps.add(recProp);
				}
			}

			// Write documentation
			for (PrintStream ps : new PrintStream[] { ips, cps, dps })
			{
				ps.println("    /**");
				ps.println("     * Creates a " + def.getBaseName() + ".");
				if (!skipMake)
				{
					ps.println("     * The specified start and stop locations are used.");
				} else
				{
					ps.println("     * The start and stop locations which have been set as properties of this factory are used.");
				}
				ps.println("     */");
			}

			// Write interface method description
			ips.print("    public " + typeParamS + typeName + " make" + def.getBaseName());
			printParameterList(ips, argProps, skipMake);
			ips.println(";");
			ips.println();

			// Write backing class implementation
			cps.println("    @Override");
			cps.print("    public " + typeParamS + typeName + " make" + def.getBaseName());
			printParameterList(cps, argProps, skipMake);
			cps.println();
			cps.println("    {");
			String classname = def.getBaseName() + "Impl" + typeArg;
			cps.print("        " + typeName + " ret = new " + classname);

			printFactoryArgumentList(cps, recProps, def.getFactoryOverrideMap(), methodDefinition);

			cps.println(";");
			// TODO: later, this is where we register created nodes with the central dependency validation
			// authority
			cps.println("        return ret;");
			cps.println("    }");
			cps.println();

			// Write decorator implementation
			dps.println("    @Override");
			dps.print("    public " + typeParamS + typeName + " make" + def.getBaseName());
			printParameterList(dps, argProps, skipMake);
			dps.println();
			dps.println("    {");
			dps.println("        this.before();");
			dps.print("        " + typeName + " node = factory.make" + def.getBaseName());
			printArgumentList(dps, argProps, skipMake);
			dps.println(";");
			dps.println("        this.after(node);");
			dps.println("        return node;");
			dps.println("    }");
			dps.println();

			// Special ListNode constructor
			if (propInstanceOf(def.getFullName(), "ListNode"))
			{
				// Write documentation
				for (PrintStream ps : new PrintStream[] { ips, cps, dps })
				{
					ps.println("    /**");
					ps.println("     * Creates a " + def.getBaseName() + ".");
					if (!skipMake)
					{
						ps.println("     * The specified start and stop locations are used.");
					} else
					{
						ps.println("     * The start and stop locations which have been set as properties of this factory are used.");
					}
					ps.println("     */");
				}

				// Create a list to fake the parameter list printer into printing a vararg
				List<PropertyDefinition> fakeProps = new ArrayList<PropertyDefinition>();
				PropertyDefinition listDef = null;
				for (PropertyDefinition recProp : recProps)
				{
					if (recProp.getBaseType().equals("List") && listDef == null)
					{
						listDef = recProp;
					} else
					{
						fakeProps.add(recProp);
					}
				}
				fakeProps.add(new PropertyDefinition(listDef.getName() + "Elements", listDef.getTypeArg() + "...",
						null, PropertyDefinition.Mode.NORMAL, "", listDef.getDefaultExpression()));

				// Write interface method description
				ips.print("    public " + typeName + " make" + def.getBaseName());
				printParameterList(ips, fakeProps, skipMake);
				ips.println(";");
				ips.println();

				// Write backing class implementation
				cps.println("    @Override");
				cps.print("    public " + typeName + " make" + def.getBaseName());
				printParameterList(cps, fakeProps, skipMake);
				cps.println();
				cps.println("    {");
				cps.println("        List<" + listDef.getTypeArg() + "> " + listDef.getName() + " = Arrays.asList("
						+ listDef.getName() + "Elements);");
				cps.print("        return make" + def.getBaseName());
				printArgumentList(cps, recProps);
				cps.println(";");
				cps.println("    }");
				cps.println();

				// Write decorator implementation
				dps.println("    @Override");
				dps.print("    public " + typeName + " make" + def.getBaseName());
				printParameterList(dps, fakeProps, skipMake);
				dps.println();
				dps.println("    {");
				dps.println("        this.before();");
				dps.print("        " + typeName + " node = factory.make" + def.getBaseName());
				printArgumentList(dps, fakeProps, skipMake);
				dps.println(";");
				dps.println("        this.after(node);");
				dps.println("        return node;");
				dps.println("    }");
				dps.println();
			}
		}

		private void printFactoryArgumentList(PrintStream ps, List<PropertyDefinition> props,
				Map<String, String> overrideMap, FactoryMethodDefinition methodDefinition)
		{
			boolean first = true;
			ps.print("(");
			for (PropertyDefinition p : props)
			{
				if (!first)
				{
					ps.print(", ");
				}
				first = false;
				if (overrideMap.containsKey(p.getName()))
				{
					ps.print(overrideMap.get(p.getName()).trim());
				} else if (methodDefinition.isVisible(p.getName()))
				{
					ps.print(p.getName());
				} else if (p.getDefaultExpression() != null)
				{
					ps.print(p.getDefaultExpression());
				} else if (p.isSkipMake())
				{
					// If the property is skip make, assume it will be supplied anyway
					ps.print(p.getName());
				} else
				{
					throw new IllegalStateException("Property " + p.getName()
							+ " is invisible in factory method with no default.");
				}
			}
			ps.print(")");
		}
	}

	/**
	 * Writes the BSJ node operation interface and no-op class.
	 */
	static class NodeOperationWriter extends ClassHierarchyBuildingHandler
	{
		/** Print stream for the interface. */
		PrintStream ips;
		/** Print stream for the implementation. */
		PrintStream nps;
		/** Print stream for all-methods proxy. */
		PrintStream pps;
		/** Print stream for default operation implementation. */
		PrintStream dps;

		@Override
		public void init() throws IOException
		{
			super.init();

			ips = createOutputFile("edu.jhu.cs.bsj.compiler.ast", TypeDefinition.Mode.INTERFACE, false,
					"BsjNodeOperation<P,R>", true, null, null);
			nps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", TypeDefinition.Mode.CONCRETE, false,
					"BsjNodeNoOpOperation<P,R>", true, null, null, "BsjNodeOperation<P,R>");
			pps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", TypeDefinition.Mode.ABSTRACT, false,
					"BsjNodeOperationProxy<POrig,ROrig,PNew,RNew>", true, null, null, "BsjNodeOperation<PNew,RNew>");
			dps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", TypeDefinition.Mode.ABSTRACT, false,
					"BsjDefaultNodeOperation<P,R>", true, null, null, "BsjNodeOperation<P,R>");
		}

		@Override
		public void useDefinition(TypeDefinition def) throws IOException
		{
			if (def.getMode() == TypeDefinition.Mode.CONCRETE)
			{
				String typeName;
				String typeArg;
				if (def.getTypeParameter() != null)
				{
					String[] args = def.getTypeParameter().split(",");
					for (int i = 0; i < args.length; i++)
					{
						if (args[i].contains(" "))
							args[i] = args[i].substring(0, args[i].indexOf(' ')).trim();
					}
					StringBuilder sb = new StringBuilder();
					for (String s : args)
					{
						if (sb.length() > 0)
							sb.append(",");
						sb.append(s);
					}
					sb.insert(0, "<");
					sb.append(">");
					typeArg = sb.toString();
				} else
				{
					typeArg = "";
				}
				typeName = def.getBaseName() + typeArg;
				String typeParamS = def.getTypeParameter() == null ? "" : ("<" + def.getTypeParameter() + "> ");

				ips.println("    /**");
				ips.println("     * Executes this operation against a " + def.getBaseName() + ".");
				ips.println("     * @param node The " + def.getBaseName() + " in question.");
				ips.println("     * @param p The parameter to use.");
				ips.println("     * @return The result of the operation.");
				ips.println("     */");
				ips.println("    public " + typeParamS + "R execute" + def.getBaseName() + "(" + typeName
						+ " node, P p);");
				ips.println();

				nps.println("    /**");
				nps.println("     * Performs no operation.");
				nps.println("     * @param node Ignored.");
				nps.println("     * @param p Ignored.");
				nps.println("     * @return <code>null</code>, always.");
				nps.println("     */");
				nps.println("    public " + typeParamS + "R execute" + def.getBaseName() + "(" + typeName
						+ " node, P p)");
				nps.println("    {");
				nps.println("        return null;");
				nps.println("    }");
				nps.println();

				pps.println("    /**");
				pps.println("     * Decorates this operation, turning it over to the backing operation.");
				pps.println("     * @param node The node to affect.");
				pps.println("     * @param p The value to pass through the proxy filter and into the backing operation.");
				pps.println("     * @return The result of this operation (after being passed through the proxy filter).");
				pps.println("     */");
				pps.println("    public " + typeParamS + "RNew execute" + def.getBaseName() + "(" + typeName
						+ " node, PNew p)");
				pps.println("    {");
				pps.println("        POrig porig = before(p);");
				pps.println("        ROrig rorig = this.backingOp.execute" + def.getBaseName() + "(node, porig);");
				pps.println("        return after(rorig);");
				pps.println("    }");
				pps.println();

				dps.println("    /**");
				dps.println("     * Executes the default operation for this node.");
				dps.println("     * @param node The node in question.");
				dps.println("     * @param p The parameter to this node operation.");
				dps.println("     */");
				dps.println("    public " + typeParamS + "R execute" + def.getBaseName() + "(" + typeName
						+ " node, P p)");
				dps.println("    {");
				dps.println("        return executeDefault(node, p);");
				dps.println("    }");
				dps.println();
			}
		}

		@Override
		public void finish() throws IOException
		{
			super.finish();

			ips.println("}");
			ips.close();

			nps.println("}");
			nps.close();

			pps.println("}");
			pps.close();

			dps.println("}");
			dps.close();
		}
	}

	/**
	 * Writes the BSJ tree lifter class.
	 */
	static class TreeLifterWriter extends ClassHierarchyBuildingHandler
	{
		/** The stream to which the file's content is written. */
		private PrependablePrintStream ps;

		@Override
		public void init() throws IOException
		{
			super.init();
			ps = createOutputFile("edu.jhu.cs.bsj.compiler.impl.tool.compiler", TypeDefinition.Mode.CONCRETE, true,
					"BsjTreeLifter", true, null, null, "BsjNodeOperation<ExpressionNode,ExpressionNode>");
			ps.incPrependCount();
			ps.println("private BsjNodeFactory factory;");
			ps.println();
			ps.println("public BsjTreeLifter(BsjNodeFactory factory)");
			ps.println("{");
			ps.println("    this.factory = factory;");
			ps.println("}");
			ps.println();
			for (String ptype : PRIMITIVE_TYPES)
			{
				if (ptype.equals("short") || ptype.equals("byte"))
					continue;
				ps.println("protected ExpressionNode expressionize" + capFirst(ptype) + "(" + ptype + " x)");
				ps.println("{");
				ps.println("    return factory.make" + capFirst(ptype) + "LiteralNode(x);");
				ps.println("}");
				ps.println();
			}
			for (String etype : ENUM_TYPES)
			{
				ps.println("protected ExpressionNode expressionize" + etype + "(" + etype + " x)");
				ps.println("{");
				ps.println("    return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(");
				ps.println("            factory.makeSimpleNameNode(");
				ps.println("                    factory.makeIdentifierNode(\"" + etype + "\"),");
				ps.println("                    NameCategory.EXPRESSION");
				ps.println("                    ),");
				ps.println("            factory.makeIdentifierNode(x.name()),");
				ps.println("            NameCategory.EXPRESSION));");
				ps.println("}");
				ps.println();
			}
		}

		@Override
		public void useDefinition(TypeDefinition def) throws IOException
		{
			List<PropertyDefinition> recProp = this.getRecursiveProps(def);
			if (def.getMode() != TypeDefinition.Mode.CONCRETE)
				return;

			ps.println("@Override");
			String typeargString = "";
			if (def.getTypeParameter() != null)
				typeargString = "<" + def.getTypeParameter() + "> ";
			ps.println("public " + typeargString + "ExpressionNode execute" + def.getBaseName() + "("
					+ def.getBaseName()
					+ (def.getUnboundedTypeParameter() == null ? "" : "<" + def.getUnboundedTypeParameter() + ">")
					+ " node, ExpressionNode factoryNode)");
			if (def.getTypeParameter() != null)
			{
				// defer this to a method which accepts the type argument as a parameter - default to our type arg
				ps.println("{");
				ps.println("    String typeName;");
				ps.println("    if (argsFor" + def.getBaseName() + "Stack.size() == 0)");
				ps.println("    {");
				ps.println("        typeName = \"" + def.getUnboundedTypeParameter() + "\";");
				ps.println("    } else");
				ps.println("    {");
				ps.println("        typeName = argsFor" + def.getBaseName() + "Stack.peek();");
				ps.println("    }");
				ps.println("    return execute" + def.getBaseName() + "(node, factoryNode, typeName);");
				ps.println("}");
				ps.println();
				ps.println("protected " + typeargString + "ExpressionNode execute" + def.getBaseName() + "("
						+ def.getBaseName()
						+ (def.getTypeParameter() == null ? "" : "<" + def.getUnboundedTypeParameter() + ">")
						+ " node, ExpressionNode factoryNode, String argName)");
			}
			ps.println("{");
			ps.incPrependCount();
			for (PropertyDefinition p : recProp)
			{
				if (p.isSkipMake() && !p.getName().matches("st(art|op)Location"))
					continue;

				propAbstract(new PropertyTypeAbstractor()
				{
					public void voidType(PrependablePrintStream ps, PropertyDefinition p)
					{
						// Intentionally doing nothing. We'll just use "null" below.
					}

					public void node(PrependablePrintStream ps, PropertyDefinition p)
					{
						boolean generic = (p.getTypeArg() != null);
						String rawName = null;
						if (generic)
						{
							rawName = p.getBaseType();
							String typeArg = p.getTypeArg();
							ps.println("argsFor" + rawName + "Stack.push(\"" + typeArg + "\");");
						}
						ps.println("ExpressionNode lift" + capFirst(p.getName()) + " = ");
						ps.incPrependCount(2);
						ps.println("node.get" + capFirst(p.getName()) + "() != null ?");
						ps.incPrependCount(2);
						ps.println("node.get" + capFirst(p.getName()) + "().executeOperation(this,factoryNode) :");
						ps.println("factory.makeNullLiteralNode(null);");
						ps.decPrependCount(4);
						if (generic)
						{
							ps.println("argsFor" + rawName + "Stack.pop();");
						}
					}

					public void list(PrependablePrintStream ps, PropertyDefinition p)
					{
						String typeArg = p.getTypeArg();
						ps.println("List<ExpressionNode> lift" + capFirst(p.getName())
								+ "List = new ArrayList<ExpressionNode>();");
						ps.println("for (" + typeArg + " listval : node.get" + capFirst(p.getName()) + "())");
						ps.println("{");
						ps.println("    lift" + capFirst(p.getName()) + "List.add(");
						ps.println("            listval != null ? ");
						ps.println("			        listval.executeOperation(this,factoryNode) :");
						ps.println("                    null);");
						ps.println("}");
					}

					public void directCopy(PrependablePrintStream ps, PropertyDefinition p)
					{
						ps.println(p.getFullType() + " lift" + capFirst(p.getName()) + "Value = ");
						ps.println("        node.get" + capFirst(p.getName()) + "();");
					}

					public void cloneable(PrependablePrintStream ps, PropertyDefinition p)
					{
						ps.println("ExpressionNode lift" + capFirst(p.getName()) + "MetaClone = ");
						ps.println("        expressionize" + p.getBaseType() + "(node.get" + capFirst(p.getName())
								+ "());");
					}
				}, p, ps, def);
			}
			ps.println();

			// Generate resulting expression
			ps.println("ExpressionNode ret =");
			ps.incPrependCount(2);
			ps.println("factory.makeMethodInvocationByExpressionNode(");
			ps.incPrependCount(2);
			ps.println("factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),");
			ps.println("factory.makeIdentifierNode(\"make" + def.getBaseName() + "\"),");
			ps.print("factory.makeExpressionListNode(");
			ps.incPrependCount(2);
			boolean first = true;
			for (PropertyDefinition p : recProp)
			{
				if (p.isSkipMake() && !p.getName().matches("st(art|op)Location"))
					continue;
				if (first)
				{
					first = false;
				} else
				{
					ps.print(",");
				}
				ps.println();
				propAbstract(new PropertyTypeAbstractor()
				{
					public void voidType(PrependablePrintStream ps, PropertyDefinition p)
					{
						ps.print("factory.makeNullLiteralNode(null)");
					}

					public void node(PrependablePrintStream ps, PropertyDefinition p)
					{
						ps.print("lift" + capFirst(p.getName()));
					}

					public void list(PrependablePrintStream ps, PropertyDefinition p)
					{
						ps.println("factory.makeMethodInvocationByNameNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeQualifiedNameNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeQualifiedNameNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeQualifiedNameNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeSimpleNameNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"java\"),");
						ps.println("NameCategory.PACKAGE),");
						ps.decPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"util\"),");
						ps.println("NameCategory.PACKAGE),");
						ps.decPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"Arrays\"),");
						ps.println("NameCategory.TYPE),");
						ps.decPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"asList\"),");
						ps.println("NameCategory.METHOD),");
						ps.decPrependCount(2);
						ps.println("factory.makeExpressionListNode(lift" + capFirst(p.getName()) + "List),");
						ps.println("factory.makeTypeListNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeUnparameterizedTypeNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeSimpleNameNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"" + p.getTypeArg() + "\"),");
						ps.print("NameCategory.TYPE))))");
						ps.decPrependCount(8);
					}

					public void directCopy(PrependablePrintStream ps, PropertyDefinition p)
					{
						ps.print("expressionize" + capFirst(p.getBaseType()) + "(lift" + capFirst(p.getName())
								+ "Value)");
					}

					public void cloneable(PrependablePrintStream ps, PropertyDefinition p)
					{
						ps.print("lift" + capFirst(p.getName()) + "MetaClone");
					}
				}, p, ps, def);
			}
			ps.println("),");
			ps.decPrependCount(2);
			ps.println("factory.makeTypeListNode());");
			ps.decPrependCount(4);
			ps.println();
			ps.println("return ret;");
			ps.decPrependCount();
			ps.println("}");
			ps.println();
		}

		@Override
		public void finish() throws IOException
		{
			super.finish();
			ps.decPrependCount();
			ps.println("}");
			ps.close();
		}

	}

	static class DiagnosticDefinitionHandler extends AbstractDefinitionHandler
	{
		private PrependablePrintStream dps;

		@Override
		public void init() throws IOException
		{
		}

		@Override
		public void handleDiagnosticDefinition(DiagnosticDefinition def) throws IOException
		{
			dps = createOutputFile(def.getClassPackage(), def.getCode() == null ? Mode.ABSTRACT : Mode.CONCRETE, false,
					def.getName() + "<T extends javax.tools.JavaFileObject>", false,
					"import edu.jhu.cs.bsj.compiler.diagnostic.*;\n\n/**\n * "
							+ def.getDocString().replaceAll("\n", "\n * ") + "\n */", def.getSuperName() + "<T>");
			dps.incPrependCount();

			if (def.getCode() != null)
			{
				dps.println("/** The code for this diagnostic. */");
				dps.println("public static final String CODE = \"" + def.getCode() + "\";");
				dps.println();
			}

			for (PropertyDefinition prop : def.getProperties())
			{
				dps.println("/** " + capFirst(prop.getDescription()) + ". */");
				dps.println("private " + prop.getFullType() + " " + prop.getName() + ";");
				dps.println();
			}

			List<PropertyDefinition> consParams = new ArrayList<PropertyDefinition>();
			consParams.add(new PropertyDefinition("lineNumber", "long", null, PropertyDefinition.Mode.NORMAL, "", null));
			consParams.add(new PropertyDefinition("columnNumber", "long", null, PropertyDefinition.Mode.NORMAL, "",
					null));
			consParams.add(new PropertyDefinition("source", "T", null, PropertyDefinition.Mode.NORMAL, "", null));
			PropertyDefinition.Mode overrideMode = def.getCode() == null ? PropertyDefinition.Mode.NORMAL
					: PropertyDefinition.Mode.SKIP;
			consParams.add(new PropertyDefinition("code", "String", null, overrideMode, null,
					def.getCode() == null ? null : "CODE"));
			// TODO: parameterization of diagnostic kind
			consParams.add(new PropertyDefinition("kind", "javax.tools.Diagnostic.Kind", null, overrideMode, null,
					def.getCode() == null ? null : "Kind.ERROR"));
			consParams.addAll(def.getRecursiveProperties(true));

			List<PropertyDefinition> superParams = new ArrayList<PropertyDefinition>(consParams);
			superParams.removeAll(def.getProperties());

			dps.print("public " + def.getName());
			printParameterList(dps, consParams, true);
			dps.println();
			dps.println("{");
			dps.incPrependCount();
			dps.print("super");
			// TODO: override map
			Map<String, String> overrideMap = new HashMap<String, String>();
			for (PropertyDefinition prop : superParams)
			{
				if (prop.getDefaultExpression() != null)
				{
					overrideMap.put(prop.getName(), prop.getDefaultExpression());
				}
			}
			printArgumentList(dps, superParams, overrideMap);
			dps.println(";");

			for (PropertyDefinition prop : def.getProperties())
			{
				dps.println("this." + prop.getName() + " = " + prop.getName() + ";");
			}

			dps.decPrependCount();
			dps.println("}");
			dps.println();

			for (PropertyDefinition prop : def.getProperties())
			{
				dps.println("/**");
				dps.println(" * Retrieves " + prop.getDescription() + ".");
				dps.println(" * @return " + capFirst(prop.getDescription()) + ".");
				dps.println(" */");
				dps.println("public " + prop.getFullType() + " get" + capFirst(prop.getName()) + "()");
				dps.println("{");
				dps.incPrependCount();
				dps.println("return this." + prop.getName() + ";");
				dps.decPrependCount();
				dps.println("}");
				dps.println();
			}

			dps.println("@Override");
			dps.println("protected List<Object> getMessageArgs()");
			dps.println("{");
			dps.incPrependCount();
			dps.print("List<Object> args = ");
			if (def.getSuperName().equals("AbstractBsjDiagnostic"))
			{
				dps.println("new ArrayList<Object>();");
			} else
			{
				dps.println("super.getMessageArgs();");
			}
			for (PropertyDefinition prop : def.getProperties())
			{
				dps.println("args.add(this." + prop.getName() + ");");
			}
			dps.println("return args;");
			dps.decPrependCount();
			dps.println("}");

			dps.decPrependCount();
			dps.println("}");
		}

		@Override
		public void handleTypeDefinition(TypeDefinition def) throws IOException
		{
		}

		@Override
		public void finish() throws IOException
		{
		}

	}
}
