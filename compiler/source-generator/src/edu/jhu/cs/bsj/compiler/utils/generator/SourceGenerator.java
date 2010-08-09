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

import edu.jhu.cs.bsj.compiler.impl.utils.NullOutputStream;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.utils.generator.TypeDefinition.Mode;

/**
 * This class generates some patternistic sources for the BSJ parser. The code is awful; it's not intended for long-term
 * maintenance, as it will become obsolete once the BSJ compiler has been reimplemented in BSJ.
 * 
 * @author Zachary Palmer
 */
public class SourceGenerator
{
	/**
	 * Defines the number of node operation variations that exist. Each variation takes a different number of arguments.
	 */
	private static final int NUMBER_OF_OPERATION_VARIATIONS = 2;

	private static final File CONTENTS_FILE = new File("data/srcgen/srcgen.xml");
	private static final File SUPPLEMENTS_DIR = new File("data/srcgen/supplement/");
	private static final File TARGET_DIR = new File("out/");

	private static final Set<String> PRIMITIVE_TYPES = new HashSet<String>(Arrays.asList("int", "long", "boolean",
			"float", "double", "short", "byte", "char"));
	private static final Set<String> PRIMITIVE_CONTAINER_TYPES = new HashSet<String>(Arrays.asList("Long", "Integer",
			"Short", "Byte", "Double", "Float", "Boolean", "String", "Character"));
	private static final Set<String> ENUM_TYPES = new HashSet<String>(Arrays.asList("AccessModifier",
			"AssignmentOperator", "BinaryOperator", "MetaprogramLocalMode", "MetaprogramPackageMode", "NameCategory",
			"PrimitiveType", "UnaryOperator", "UnaryStatementOperator"));
	/** Types which can be "deep copied" by reference copy because the instance is global to a compilation operation. */
	private static final Set<String> COMPILE_GLOBAL_TYPES = new HashSet<String>(Arrays.asList("PackageNodeCallback"));
	/** Immutable types which may be shared. */
	private static final Set<String> IMMUTABLE_TYPES = new HashSet<String>(Arrays.asList("BsjSourceLocation"));

	/** Names the types of objects which are "deep copied" by simply copying the reference. */
	private static final Set<String> DIRECT_COPY_NAMES;

	static
	{
		Set<String> directCopy = new HashSet<String>();
		directCopy.addAll(PRIMITIVE_TYPES);
		directCopy.addAll(PRIMITIVE_CONTAINER_TYPES);
		directCopy.addAll(ENUM_TYPES);
		directCopy.addAll(COMPILE_GLOBAL_TYPES);
		directCopy.addAll(IMMUTABLE_TYPES);
		DIRECT_COPY_NAMES = Collections.unmodifiableSet(directCopy);
	}

	/**
	 * Names the types of objects which are deep copied by passing them as a single argument to their constructor.
	 */
	private static final Set<String> CLONEABLE_NAMES = Collections.unmodifiableSet(new HashSet<String>(
			Arrays.<String> asList()));

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

		// For each user diagnostic, inform each handler
		for (UserDiagnosticDefinition userDiagnostic : data.getUserDiagnostics())
		{
			for (DefinitionHandler handler : handlers)
			{
				handler.handleUserDiagnosticDefinition(userDiagnostic);
			}
		}

		// Finish each handler
		for (DefinitionHandler handler : handlers)
			handler.finish();
	}

	public static File getTargetDir(Project p)
	{
		// Retrieves the base directory for files in the specified project.
		File f = new File(TARGET_DIR.getAbsolutePath() + File.separator + p.getResourceDirName());
		f.mkdirs();
		return f;
	}

	public static File getSupplementDir(Project p, SupplementCategory category)
	{
		File f = new File(SUPPLEMENTS_DIR.getAbsolutePath() + category.getSubdirSuffix() + File.separator
				+ p.getResourceDirName());
		return f;
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
	 * @param project The project where the includes are stored.
	 * @param category The category of includes to use.
	 */
	private static void includeAllBodies(PrintStream ps, Iterable<String> names, Project project,
			SupplementCategory category) throws IOException
	{
		for (String name : names)
		{
			File f = new File(getSupplementDir(project, category).getPath() + File.separator + name);
			includeBody(f, ps);
		}
	}

	/**
	 * Performs a source file body inclusion.
	 * 
	 * @param ps The {@link PrintStream} to which to write lines that need to be copied.
	 * @param names The names of the include files.
	 * @param project The project where the includes are stored.
	 * @param category The category of includes to use.
	 */
	private static void includeAllImports(PrintStream ps, Iterable<String> names, Project project,
			SupplementCategory category) throws IOException
	{
		for (String name : names)
		{
			File f = new File(getSupplementDir(project, category).getPath() + File.separator + name);
			includeImports(f, ps);
		}
	}

	/**
	 * Writes a list of parameters suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as parameters.
	 */
	private static void printParameterList(PrependablePrintStream ps, List<PropertyDefinition> props)
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
	private static void printParameterList(PrependablePrintStream ps, List<? extends ModalPropertyDefinition<?>> props,
			boolean skipMake)
	{
		boolean first = true;
		ps.print("(");
		if (props.size() > 0)
		{
			ps.println();
			ps.incPrependCount(2);
			for (ModalPropertyDefinition<?> p : props)
			{
				if (p.getMode() != ModalPropertyDefinition.Mode.SKIP || !skipMake)
				{
					if (!first)
					{
						ps.println(",");
					}
					first = false;

					ps.print(p.getFullType() + " " + p.getName());
				}
			}
			ps.decPrependCount(2);
		}
		ps.print(")");
	}

	/**
	 * Writes a list of arguments suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as arguments.
	 */
	private static void printArgumentList(PrintStream ps, List<? extends ModalPropertyDefinition<?>> props)
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
	private static void printArgumentList(PrintStream ps, List<? extends ModalPropertyDefinition<?>> props,
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
	private static void printArgumentList(PrintStream ps, List<? extends ModalPropertyDefinition<?>> props,
			boolean skipMake)
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
	private static void printArgumentList(PrintStream ps, List<? extends ModalPropertyDefinition<?>> props,
			Map<String, String> overrideMap, boolean skipMake)
	{
		boolean first = true;
		ps.print("(");
		for (ModalPropertyDefinition<?> p : props)
		{
			if (p.getMode() != ModalPropertyDefinition.Mode.SKIP || !skipMake)
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
	private static void printImports(PrintStream ps, Project project)
	{
		for (String importName : project.getImports())
		{
			ps.println("import " + importName + ";");
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

		public void handleUserDiagnosticDefinition(UserDiagnosticDefinition def) throws IOException;

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
			String pkg = def.getProfile().getProperty(GenerationProfile.GENERATED_INTERFACE_PACKAGE_NAME);
			if (pkg == null)
				pkg = "";
			Project project = def.getProfile().getProperty(GenerationProfile.INTERFACE_PROJECT);
			File classFile = new File(getTargetDir(project) + File.separator + pkg.replaceAll("\\.", File.separator)
					+ File.separator + def.getBaseName() + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrependablePrintStream ps = new PrependablePrintStream(fos, "    ", 0);
			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			// imports
			printImports(ps, project);
			includeAllImports(ps, def.getIncludes(), project, SupplementCategory.NODE);

			ps.println("/**");
			ps.println(" * " + def.getDocString().replaceAll("\n", "\n * "));
			ps.println(" */");

			StringBuilder extendsClause = new StringBuilder();
			if (def.getFullSuper() != null)
				extendsClause.append(def.getFullSuper());
			for (TagReferenceDefinition tag : def.getTags())
			{
				if (extendsClause.length() > 0)
					extendsClause.append(", ");
				extendsClause.append(tag.getName());
				if (tag.getTypeArg() != null)
				{
					extendsClause.append('<');
					extendsClause.append(tag.getTypeArg());
					extendsClause.append('>');
				}
			}
			for (String iface : def.getInterfaces())
			{
				if (extendsClause.length() > 0)
					extendsClause.append(", ");
				extendsClause.append(iface);
			}
			if (def.isBsjSpecific())
			{
				if (extendsClause.length() > 0)
					extendsClause.append(", ");
				extendsClause.append("BsjSpecificNode");
			}
			if (extendsClause.length() > 0)
				extendsClause.insert(0, " extends ");

			printGeneratedClause(ps);
			ps.println("public interface " + def.getFullName() + extendsClause.toString());
			ps.println("{");
			ps.incPrependCount();

			// gen getters and setters
			for (ModalPropertyDefinition<?> p : def.getProperties())
			{
				if (!p.isHide())
				{
					ps.println("/**");
					ps.println(" * Gets " + p.getDescription() + ".");
					ps.println(" * @return " + capFirst(p.getDescription()) + ".");
					ps.println(" */");
					ps.println("public " + p.getFullType() + " get" + capFirst(p.getName()) + "();");
					ps.println();
					if (!p.isReadOnly())
					{
						ps.println("/**");
						ps.println(" * Changes " + p.getDescription() + ".");
						ps.println(" * @param " + p.getName() + " " + capFirst(p.getDescription()) + ".");
						ps.println(" */");
						ps.println("public void set" + capFirst(p.getName()) + "(" + p.getFullType() + " "
								+ p.getName() + ");");
						ps.println();
					}
				}
			}

			// write deep copy interface
			ps.println("/**");
			ps.println(" * Generates a deep copy of this node.");
			ps.println(" * @param factory The node factory to use to create the deep copy.");
			ps.println(" * @return The resulting deep copy node.");
			ps.println(" */");
			if (def.getBaseSuperName() != null)
				ps.println("@Override");
			ps.println("public " + def.getNameWithTypeParameters() + " deepCopy(BsjNodeFactory factory);");
			ps.println();

			// write operation interface
			if (def.getBaseName().equals("Node"))
			{
				for (int i = 1; i <= NUMBER_OF_OPERATION_VARIATIONS; i++)
				{
					NodeOperationWriter.Strings strings = new NodeOperationWriter.Strings(i);
					ps.println("/**");
					ps.println(" * Executes an operation on this node.");
					ps.println(" * @param operation The operation to perform.");
					for (int j = 1; j <= i; j++)
					{
						ps.println(" * @param " + strings.getParameterName(j)
								+ " A parameter to pass to the operation.");
					}
					ps.println(" * @return The result of the operation.");
					ps.println(" */");
					ps.println("public <" + strings.inputTypeParams + ",R> R executeOperation(BsjNodeOperation"
							+ strings.suffix + "<" + strings.inputTypeParams + ",R> operation, " + strings.methodParams
							+ ");");
					ps.println();
				}
			}

			// write bodies
			ps.decPrependCount();
			includeAllBodies(ps, def.getIncludes(), project, SupplementCategory.NODE);
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
		 * A do-nothing user diagnostic definition handling method for backwards compatibility.
		 */
		@Override
		public void handleUserDiagnosticDefinition(UserDiagnosticDefinition def) throws IOException
		{
		}

		/**
		 * Creates a templated output file for a handler.
		 * 
		 * @param pkg The package for this file.
		 * @param mode The mode for this file: concrete class, abstract class, or interface.
		 * @param project The project in which to create the output file.
		 * @param category The category of supplements where imported files will be found.
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
		protected PrependablePrintStream createOutputFile(String pkg, TypeDefinition.Mode mode, Project project,
				SupplementCategory category, String type, boolean includes, String headerString, String extendsName,
				String... implementsNames) throws IOException
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

			File f = new File(getTargetDir(project).getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + name);
			f.getParentFile().mkdirs();
			PrependablePrintStream ret = new PrependablePrintStream(new FileOutputStream(f), "    ", 0);
			ret.println("package " + pkg + ";");
			ret.println();
			printImports(ret, project);
			if (includes)
			{
				includeAllImports(ret, Collections.singleton(name), project, SupplementCategory.GENERAL);
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
				includeAllBodies(ret, Collections.singleton(name), project, SupplementCategory.GENERAL);
			}
			return ret;
		}
	}

	// TODO: eliminate most of this functionality or at least reimplement on the TypeDefinition class
	static abstract class ClassHierarchyBuildingHandler extends AbstractDefinitionHandler
	{
		protected static enum ReviewMode
		{
			ALPHABETICAL,
			FILE_ORDER
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

		protected <T extends PropertyBasedHierarchyDefinition<T, U> & IParameterizedPropertyBasedHierarchyDefinition<T, U>, U extends AbstractPropertyDefinition<U>> boolean propInstanceOf(
				String propType, String classname, T def)
		{
			if (propType.contains("<"))
				propType = propType.substring(0, propType.indexOf('<')).trim();
			if (def != null && propType.equals(def.getUnboundedTypeParameter()))
			{
				if (def.getTypeParameterUpperBound() == null)
				{
					propType = "Object";
				} else
				{
					propType = def.getTypeParameterUpperBound();
				}
			}
			return defInstanceOf(map.get(propType), classname);
		}

		public abstract void useDefinition(TypeDefinition def) throws IOException;

		protected void propAbstract(PropertyTypeAbstractor abstractor, ModalPropertyDefinition<?> p,
				PrependablePrintStream ps, TypeDefinition def)
		{
			if (DIRECT_COPY_NAMES.contains(p.getBaseType()))
			{
				abstractor.directCopy(ps, p);
			} else if (propInstanceOf(p.getBaseType(), "Node", def))
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
			void directCopy(PrependablePrintStream ps, ModalPropertyDefinition<?> p);

			void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p);

			void cloneable(PrependablePrintStream ps, ModalPropertyDefinition<?> p);

			void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p);

			void voidType(PrependablePrintStream ps, ModalPropertyDefinition<?> p);
		}

		static class DefaultPropertyTypeAbstractor implements PropertyTypeAbstractor
		{

			@Override
			public void cloneable(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
			{
			}

			@Override
			public void directCopy(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
			{
			}

			@Override
			public void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
			{
			}

			@Override
			public void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
			{
			}

			@Override
			public void voidType(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
			{
			}
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

			String pkg = def.getProfile().getProperty(GenerationProfile.GENERATED_CLASS_PACKAGE_NAME);
			if (pkg == null)
				pkg = "";
			File classFile = new File(getTargetDir(Project.GENERATOR) + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + rawclassname + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrependablePrintStream ps = new PrependablePrintStream(fos, "    ", 0);

			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			printImports(ps, Project.GENERATOR);
			includeAllImports(ps, def.getIncludes(), Project.GENERATOR, SupplementCategory.NODE);
			for (TagReferenceDefinition tag : def.getTags())
			{
				includeAllImports(ps, def.getNamespaceMap().get(tag.getName()).getIncludes(), Project.GENERATOR,
						SupplementCategory.NODE);
			}

			printGeneratedClause(ps);
			ps.println("public " + (def.getMode() == TypeDefinition.Mode.CONCRETE ? "" : "abstract ") + "class "
					+ classname + (def.getBaseSuperName() == null ? "" : " extends " + superclassname) + " implements "
					+ def.getNameWithTypeParameters());
			ps.println("{");
			ps.incPrependCount();

			// precalculation
			final Boolean hasListAsProperty;
			{
				if (def.getMode() == Mode.CONCRETE)
				{
					final boolean[] found = new boolean[] { false };
					PropertyTypeAbstractor hasListAsPropertyAbstractor = new DefaultPropertyTypeAbstractor()
					{
						@Override
						public void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							found[0] = true;
						}
					};
					for (ModalPropertyDefinition<?> p : def.getRecursiveProperties())
					{
						if (p.isHide())
							continue;
						propAbstract(hasListAsPropertyAbstractor, p, null, def);
					}
					hasListAsProperty = found[0];
				} else
				{
					hasListAsProperty = null;
				}
			}

			// gen properties
			for (ModalPropertyDefinition<?> p : def.getResponsibleProperties(false))
			{
				ps.println("/** " + capFirst(p.getDescription()) + ". */");
				ps.println("private " + p.getFullType() + " " + p.getName() + ";");
				ps.println();
			}

			// gen attributes enum
			if (def.getResponsibleProperties(false).size() > 0)
			{
				ps.println("private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);");
				ps.println("private ReadWriteAttribute getAttribute(LocalAttribute attributeName)");
				ps.println("{");
				ps.println("    ReadWriteAttribute attribute = localAttributes.get(attributeName);");
				ps.println("    if (attribute == null)");
				ps.println("    {");
				ps.println("        attribute = new ReadWriteAttribute(" + rawclassname + ".this);");
				ps.println("        localAttributes.put(attributeName, attribute);");
				ps.println("    }");
				ps.println("    return attribute;");
				ps.println("}");
				ps.println("private static enum LocalAttribute");
				ps.println("{");
				ps.incPrependCount();
				for (ModalPropertyDefinition<?> p : def.getResponsibleProperties(false))
				{
					ps.println("/** Attribute identifier for the " + p.getName() + " property. */");
					ps.println(StringUtilities.convertCamelCaseToUpperCase(p.getName()) + ",");
				}
				ps.decPrependCount();
				ps.println("}");
				ps.println();
			}

			// gen constructor
			ps.println("/** General constructor. */");
			if (!def.isGenConstructor())
				ps.println("/* (not generating constructor)"); // nogen logic
			ps.print((def.getMode() == TypeDefinition.Mode.CONCRETE ? "public" : "protected") + " " + rawclassname);
			List<PropertyDefinition> recProps = def.getRecursiveProperties();
			printParameterList(ps, recProps);
			ps.println();
			ps.println("{");
			ps.incPrependCount();
			ps.print("super");
			List<PropertyDefinition> superProps = new ArrayList<PropertyDefinition>(recProps);
			superProps.removeAll(def.getResponsibleProperties(false));
			printArgumentList(ps, superProps, def.getConstructorOverrideMap());
			ps.println(";");
			for (ModalPropertyDefinition<?> p : def.getResponsibleProperties(false))
			{
				String expr;
				if (def.getConstructorOverrideMap().containsKey(p.getName()))
				{
					expr = def.getConstructorOverrideMap().get(p.getName());
				} else
				{
					expr = p.getName();
				}
				if (propInstanceOf(p.getBaseType(), "Node", def) && !p.isReadOnly())
				{
					ps.println("set" + capFirst(p.getName()) + "(" + expr + ", false);");
				} else
				{
					ps.println("this." + p.getName() + " = " + expr + ";");
				}
			}
			ps.decPrependCount();
			ps.println("}");
			if (!def.isGenConstructor())
				ps.print("*/"); // nogen logic
			ps.println();

			// gen constant methods
			for (ConstantDefinition c : def.getConstants())
			{
				ps.println("/**");
				ps.println(" * Gets " + c.getDescription() + ".");
				ps.println(" * @return " + capFirst(c.getDescription()) + ".");
				ps.println(" */");
				if (c.getDefaultExpression() != null)
				{
					ps.println("public " + c.getFullType() + " get" + capFirst(c.getName()) + "()");
					ps.println("{");
					ps.println("    return " + c.getDefaultExpression() + ";");
					ps.println("}");
				} else
				{
					ps.println("public abstract " + c.getFullType() + " get" + capFirst(c.getName()) + "();");
				}
				ps.println();
			}

			// gen getters and setters
			for (ModalPropertyDefinition<?> p : def.getResponsibleProperties(false))
			{
				if (!p.isHide())
				{
					ps.println("/**");
					ps.println(" * Gets " + p.getDescription() + ".");
					ps.println(" * @return " + capFirst(p.getDescription()) + ".");
					ps.println(" */");
					ps.println("public " + p.getFullType() + " get" + capFirst(p.getName()) + "()");
					ps.println("{");
					ps.println("    getAttribute(LocalAttribute."
							+ StringUtilities.convertCamelCaseToUpperCase(p.getName()) + ")"
							+ ".recordAccess(ReadWriteAttribute.AccessType.READ);");
					ps.println("    return this." + p.getName() + ";");
					ps.println("}");
					ps.println();
					if (!p.isReadOnly())
					{
						ps.println("/**");
						ps.println(" * Changes " + p.getDescription() + ".");
						ps.println(" * @param " + p.getName() + " " + capFirst(p.getDescription()) + ".");
						ps.println(" */");
						ps.println("public void set" + capFirst(p.getName()) + "(" + p.getFullType() + " "
								+ p.getName() + ")");
						ps.println("{");
						ps.incPrependCount();
						ps.println("    set" + capFirst(p.getName()) + "(" + p.getName() + ", true);");
						ps.decPrependCount();
						ps.println("}");
						ps.println();

						// this separation is necessary to allow the constructor to use every aspect of the setter
						// method except for the permission check
						ps.println("private void set" + capFirst(p.getName()) + "(" + p.getFullType() + " "
								+ p.getName() + ", boolean checkPermissions)");
						ps.println("{");
						ps.incPrependCount();
						ps.println("if (checkPermissions)");
						ps.println("{");
						ps.println("    getManager().assertMutatable(this);");
						ps.println("    getAttribute(LocalAttribute."
								+ StringUtilities.convertCamelCaseToUpperCase(p.getName()) + ")"
								+ ".recordAccess(ReadWriteAttribute.AccessType.WRITE);");
						ps.println("}");
						if (propInstanceOf(p.getBaseType(), "Node", def))
						{
							ps.println("setAsChild(" + p.getName() + ", false);");
						}
						ps.println("this." + p.getName() + " = " + p.getName() + ";");
						if (propInstanceOf(p.getBaseType(), "Node", def))
						{
							ps.println("setAsChild(" + p.getName() + ", true);");
						}
						ps.decPrependCount();
						ps.println("}");
						ps.println();
					}
				}
			}

			// add simple visitor implementation
			ps.println("/**");
			ps.println(" * Handles the visitation of this node's children for the provided visitor.  Each");
			ps.println(" * subclass should override this method, having the subclass implementation call this");
			ps.println(" * method first and then visit its subclass-specific children.");
			ps.println(" *");
			ps.println(" * @param visitor The visitor to visit this node's children.");
			ps.println(" */");
			if (def.getBaseSuperName() != null)
			{
				ps.println("@Override");
			}
			ps.println("protected void receiveToChildren(BsjNodeVisitor visitor)");
			ps.println("{");
			ps.incPrependCount();
			if (def.getBaseSuperName() != null)
			{
				ps.println("super.receiveToChildren(visitor);");
			}
			for (ModalPropertyDefinition<?> p : def.getProperties())
			{
				if (propInstanceOf(p.getBaseType(), "Node", def))
				{
					ps.println("if (this." + p.getName() + " != null)");
					ps.println("{");
					ps.println("    this." + p.getName() + ".receive(visitor);");
					ps.println("}");
				} else if (p.getBaseType().equals("List"))
				{
					// Let's assume that the list contains node objects!
					// TODO: this is pretty shoddy - can we improve on this?
					ps.println("if (this." + p.getName() + " != null)");
					ps.println("{");
					ps.println("    for (Node node : this." + p.getName() + ")");
					ps.println("    {");
					ps.println("        node.receive(visitor);");
					ps.println("    }");
					ps.println("}");
				}
			}
			ps.println("Iterator<? extends Node> extras = getHiddenVisitorChildren();");
			ps.println("if (extras != null)");
			ps.println("{");
			ps.incPrependCount();
			ps.println("while (extras.hasNext())");
			ps.println("{");
			ps.println("    extras.next().receive(visitor);");
			ps.println("}");
			ps.decPrependCount();
			ps.println("}");
			ps.decPrependCount();
			ps.println("}");
			ps.println();

			// add typed visitor implementation
			ps.println("/**");
			ps.println(" * Handles the visitation of this node's children for the provided typed visitor.  Each");
			ps.println(" * subclass should override this method, having the subclass implementation call this");
			ps.println(" * method first and then visit its subclass-specific children.");
			ps.println(" *");
			ps.println(" * @param visitor The visitor to visit this node's children.");
			ps.println(" */");
			if (def.getBaseSuperName() != null)
			{
				ps.println("@Override");
			}
			ps.println("protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)");
			ps.println("{");
			ps.incPrependCount();
			if (def.getBaseSuperName() != null)
			{
				ps.println("super.receiveTypedToChildren(visitor);");
			}
			for (ModalPropertyDefinition<?> p : def.getProperties())
			{
				if (propInstanceOf(p.getBaseType(), "Node", def))
				{
					ps.println("if (this." + p.getName() + " != null)");
					ps.println("{");
					ps.println("    this." + p.getName() + ".receiveTyped(visitor);");
					ps.println("}");
				} else if (p.getBaseType().equals("List"))
				{
					// Let's assume that the list contains node objects!
					// TODO: this is pretty shoddy - can we improve on this?
					ps.println("if (this." + p.getName() + " != null)");
					ps.println("{");
					ps.println("    for (Node node : this." + p.getName() + ")");
					ps.println("    {");
					ps.println("        node.receiveTyped(visitor);");
					ps.println("    }");
					ps.println("}");
				} else if (p.getBaseType().equals(def.getUnboundedTypeParameter()))
				{
					// Try to extract a type bound from the type parameter
					// TODO: abstract some of this logic somehow?
					String bound = def.getTypeParameterUpperBound();
					if (bound != null)
					{
						TypeDefinition tdef = def.getNamespaceMap().get(bound);
						boolean isNode = false;
						while (tdef != null)
						{
							if (tdef.getBaseName().equals("Node"))
							{
								isNode = true;
								break;
							}
							tdef = tdef.getParent();
						}
						if (isNode)
						{
							ps.println("if (this." + p.getName() + " != null)");
							ps.println("{");
							ps.println("    this." + p.getName() + ".receiveTyped(visitor);");
							ps.println("}");
						}
					}
				}
			}
			ps.println("Iterator<? extends Node> extras = getHiddenVisitorChildren();");
			ps.println("if (extras != null)");
			ps.println("{");
			ps.incPrependCount();
			ps.println("while (extras.hasNext())");
			ps.println("{");
			ps.println("    extras.next().receiveTyped(visitor);");
			ps.println("}");
			ps.decPrependCount();
			ps.println("}");
			ps.decPrependCount();
			ps.println("}");
			ps.println();
			if (def.getBaseSuperName() != null)
			{
				ps.println("@Override");
			}
			ps.println("public void receiveTyped(BsjTypedNodeVisitor visitor)");
			ps.println("{");
			ps.incPrependCount();
			ps.println("visitor.visitStartBegin(this);");
			TypeDefinition cur = def;
			List<TypeDefinition> backtrack = new LinkedList<TypeDefinition>();
			while (cur != null)
			{
				ps.print("visitor.visit" + cur.getBaseName() + "Start(this");
				if (cur.getMode() == TypeDefinition.Mode.CONCRETE)
				{
					ps.print(", ");
					ps.print(String.valueOf(cur == def));
				}
				ps.println(");");
				backtrack.add(0, cur);
				cur = this.map.get(cur.getBaseSuperName());
			}
			for (TagReferenceDefinition tag : def.getTags())
			{
				ps.println("visitor.visit" + tag.getName() + "Start(this);");
			}
			ps.println("visitor.visitStartEnd(this);");
			ps.println("receiveTypedToChildren(visitor);");
			ps.println("visitor.visitStopBegin(this);");
			for (TagReferenceDefinition tag : def.getTags())
			{
				ps.println("visitor.visit" + tag.getName() + "Stop(this);");
			}
			for (TypeDefinition edef : backtrack)
			{
				ps.print("visitor.visit" + edef.getBaseName() + "Stop(this");
				if (edef.getMode() == TypeDefinition.Mode.CONCRETE)
				{
					ps.print(", ");
					ps.print(String.valueOf(edef == def));
				}
				ps.println(");");
			}
			ps.println("visitor.visitStopEnd(this);");
			ps.decPrependCount();
			ps.println("}");
			ps.println();

			// add logic for getting list of children
			ps.println("/**");
			ps.println(" * Produces a mutable list of this node's children.  Modifying this list will have no");
			ps.println(" * effect on this node.");
			ps.println(" * @return A list of this node's children.");
			ps.println(" */");
			if (!def.isGenChildren())
				ps.println("/* // (not generating children)"); // nogen logic
			if (def.getBaseSuperName() != null)
			{
				ps.println("@Override");
			}
			ps.println("public List<Object> getChildObjects()");
			ps.println("{");
			ps.println("    List<Object> list = "
					+ (def.getBaseSuperName() == null ? "new ArrayList<Object>();" : "super.getChildObjects();"));
			for (ModalPropertyDefinition<?> p : def.getProperties())
			{
				// special handling for startLocation and stopLocation
				if (p.getName().equals("startLocation"))
				{
					ps.println("    list.add(getStartLocation().toString() + \" - \" + getStopLocation().toString());");
				} else if (p.getName().equals("stopLocation"))
				{
					// intentionally doing nothing - handling for startLocation covers this one as well
				} else if (!p.isHide())
				{
					ps.println("    list.add(get" + Character.toUpperCase(p.getName().charAt(0))
							+ p.getName().substring(1) + "());");
				}
			}
			ps.println("    return list;");
			ps.println("}");
			if (!def.isGenChildren())
				ps.print("*/"); // nogen logic
			ps.println();

			// add logic for child iterator
			if (def.getMode() == Mode.CONCRETE)
			{
				ps.println("/**");
				ps.println(" * Returns an iterator over the children of this node.");
				ps.println(" * @see Node#getChildIterator()");
				ps.println(" */");
				ps.println("@Override");
				ps.println("public Iterable<? extends Node> getChildIterable()");
				ps.println("{");
				ps.incPrependCount();
				if (hasListAsProperty)
				{
					ps.println("List<Node> ret = new ArrayList<Node>();");
					PropertyTypeAbstractor abstractor = new DefaultPropertyTypeAbstractor()
					{
						@Override
						public void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.println("ret.addAll(get" + capFirst(p.getName()) + "());");
						}

						@Override
						public void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.println("ret.add(get" + capFirst(p.getName()) + "());");
						}
					};
					for (PropertyDefinition p : def.getRecursiveProperties())
					{
						if (p.isHide())
							continue;
						propAbstract(abstractor, p, ps, def);
					}
					ps.println("return ret;");
				} else
				{
					ps.print("return Arrays.asList(new Node[]{");
					PropertyTypeAbstractor abstractor = new DefaultPropertyTypeAbstractor()
					{
						private boolean first = true;

						@Override
						public void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							if (!first)
								ps.print(", ");
							ps.print("get" + capFirst(p.getName()) + "()");
							first = false;
						}
					};
					for (PropertyDefinition p : def.getRecursiveProperties())
					{
						if (p.isHide())
							continue;
						propAbstract(abstractor, p, ps, def);
					}
					ps.println("});");
				}
				ps.decPrependCount();
				ps.println("}");
				ps.println();
			}

			// add logic for toString
			ps.println("/**");
			ps.println(" * Obtains a human-readable description of this node.");
			ps.println(" * @return A human-readable description of this node.");
			ps.println(" */");
			ps.println("public String toString()");
			ps.println("{");
			ps.println("    StringBuilder sb = new StringBuilder();");
			if (def.getToStringLines() == null || def.getToStringLines().size() == 0)
			{
				ps.println("    sb.append(this.getClass().getSimpleName());");
				ps.println("    sb.append('[');");
				boolean firstProp = true;
				for (ModalPropertyDefinition<?> p : recProps)
				{
					if (p.isHide())
						continue;
					if (firstProp)
					{
						firstProp = false;
					} else
					{
						ps.println("    sb.append(',');");
					}
					String capName = Character.toUpperCase(p.getName().charAt(0)) + p.getName().substring(1);
					ps.println("    sb.append(\"" + p.getName() + "=\");");
					if (propInstanceOf(p.getBaseType(), "Node", def))
					{
						ps.println("    sb.append(this.get" + capName + "() == null? \"null\" : this.get" + capName
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
						ps.println("    sb.append(String.valueOf(this.get" + capName + "()) + \":\" + (" + typeString
								+ "));");
					}
				}
				ps.println("    sb.append(']');");
			} else
			{
				for (String toStringLine : def.getToStringLines())
				{
					ps.println("    " + toStringLine);
				}
			}
			ps.println("    return sb.toString();");
			ps.println("}");
			ps.println();

			// add node operation implementation
			for (int i = 1; i <= NUMBER_OF_OPERATION_VARIATIONS; i++)
			{
				NodeOperationWriter.Strings strings = new NodeOperationWriter.Strings(i);
				if (def.getMode() == TypeDefinition.Mode.CONCRETE)
				{
					ps.println("/**");
					ps.println(" * Executes an operation on this node.");
					ps.println(" * @param operation The operation to perform.");
					for (int j = 1; j <= i; j++)
					{
						ps.println(" * @param " + strings.getParameterName(j)
								+ " The parameter to pass to the operation.");
					}
					ps.println(" * @return The result of the operation.");
					ps.println(" */");
					ps.println("@Override");
					ps.println("public <" + strings.inputTypeParams + ",R> R executeOperation(BsjNodeOperation"
							+ strings.suffix + "<" + strings.inputTypeParams + ",R> operation, " + strings.methodParams
							+ ")");
					ps.println("{");
					ps.println("    return operation.execute" + def.getBaseName() + "(this, " + strings.methodArgs
							+ ");");
					ps.println("}");
				}
				ps.println();
			}

			// add deep copy implementation
			// TODO: this doesn't properly deep copy hidden properties, for which the factory takes no arguments
			// how do we deal with that?
			if (def.getMode() == TypeDefinition.Mode.CONCRETE)
			{
				ps.println("/**");
				ps.println(" * Generates a deep copy of this node.");
				ps.println(" * @param factory The node factory to use to create the deep copy.");
				ps.println(" * @return The resulting deep copy node.");
				ps.println(" */");
				if (def.getBaseSuperName() != null)
					ps.println("@Override");
				ps.println("public " + def.getNameWithTypeParameters() + " deepCopy(BsjNodeFactory factory)");
				ps.println("{");
				ps.incPrependCount();
				for (ModalPropertyDefinition<?> p : recProps)
				{
					if (p.isHide())
						continue;
					if (def.getRecursiveFactoryOverrideMap().containsKey(p.getName()))
						continue;
					propAbstract(new PropertyTypeAbstractor()
					{
						@Override
						public void cloneable(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
						}

						@Override
						public void directCopy(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
						}

						@Override
						public void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.println(p.getFullType() + " " + p.getName() + "Copy = new Array" + p.getFullType()
									+ "(get" + capFirst(p.getName()) + "().size());");
							ps.println("for (" + p.getTypeArg() + " element : get" + capFirst(p.getName()) + "())");
							ps.println("{");
							ps.incPrependCount();
							ps.println(p.getName() + "Copy.add(element.deepCopy(factory));");
							ps.decPrependCount();
							ps.println("}");
							ps.println();
						}

						@Override
						public void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
						}

						@Override
						public void voidType(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
						}
					}, p, ps, def);
				}
				ps.println("return factory.make" + def.getBaseName() + "(");
				ps.incPrependCount(2);
				boolean first = true;
				for (ModalPropertyDefinition<?> p : recProps)
				{
					if (p.isHide())
						continue;
					if (def.getRecursiveFactoryOverrideMap().containsKey(p.getName()))
						continue;
					if (first)
					{
						first = false;
					} else
					{
						ps.println(",");
					}
					propAbstract(new PropertyTypeAbstractor()
					{
						public void directCopy(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.print("get" + capFirst(p.getName()) + "()");
						}

						public void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.print("get" + capFirst(p.getName()) + "()==null?null:get" + capFirst(p.getName())
									+ "().deepCopy(factory)");
						}

						public void cloneable(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.print("get" + capFirst(p.getName()) + "() == null ? null : (" + p.getFullType()
									+ ")(get" + capFirst(p.getName()) + "().clone())");
						}

						public void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.print(p.getName() + "Copy");
						}

						public void voidType(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
						{
							ps.print("null");
						}
					}, p, ps, def);
				}
				ps.println(");");
				ps.decPrependCount(3);
				ps.println("}");
			}

			// add logic for node replacement
			if (def.getMode() == TypeDefinition.Mode.CONCRETE)
			{
				ps.println("/**");
				ps.println(" * Performs replacement for this node.");
				ps.println(" * @param before The node to replace.");
				ps.println(" * @param after The node to replace the <tt>before</tt> node.");
				ps.println(" * @return <code>true</code> if the replacement was successful; <code>false</code> if the");
				ps.println(" *         specified <tt>before</tt> node is not a child of this node.");
				ps.println(" */");
				if (!def.isGenReplace())
				{
					ps.println("/* (not generating replace method)");
				}
				ps.println("public boolean replace(Node before, Node after)");
				ps.println("{");
				ps.incPrependCount();
				ps.println("if (before==null)");
				ps.println("    throw new IllegalArgumentException(\"Cannot replace node with before value of null.\");");
				ps.println();
				for (ModalPropertyDefinition<?> p : def.getRecursiveProperties())
				{
					if (propInstanceOf(p.getBaseType(), "Node", def))
					{
						if (p.isReadOnly())
							continue;
						if (p.getTypeArg() != null)
							throw new IllegalStateException(
									"Don't know how to handle replacement for parameterized node type "
											+ p.getBaseType() + "!");
						ps.println("if (before.equals(this.get" + capFirst(p.getName()) + "()) && (after instanceof "
								+ p.getBaseType() + "))");
						ps.println("{");
						ps.println("    set" + capFirst(p.getName()) + "((" + p.getFullType() + ")after);");
						ps.println("    return true;");
						ps.println("}");
					} else if (p.getBaseType().equals("List"))
					{
						String rawTypeArg;
						String typeArg = p.getTypeArg();
						boolean typeParamParam;
						if (typeArg.indexOf('<') == -1)
						{
							rawTypeArg = typeArg;
							typeParamParam = false;
						} else
						{
							rawTypeArg = typeArg.substring(typeArg.indexOf('<'));
							typeParamParam = true;
						}
						boolean nodeType = (propInstanceOf(rawTypeArg, "Node", def));

						if (typeParamParam && nodeType)
						{
							throw new IllegalStateException("Can't handle list of parameterized nodes!");
						}
						if (!nodeType)
						{
							// Uninteresting; it's not a node, so it can't be a replacement target.
							continue;
						}

						ps.println("if (after instanceof " + typeArg + ")");
						ps.println("{");
						ps.println("    int index = get" + capFirst(p.getName()) + "().indexOf(before);");
						ps.println("    if (index != -1)");
						ps.println("        get" + capFirst(p.getName()) + "().set(index, (" + typeArg + ")after);");
						ps.println("}");
					}
				}
				ps.println("return false;");
				ps.decPrependCount();
				ps.println("}");
				if (!def.isGenReplace())
				{
					ps.println("*/");
				}
				ps.println();
			}

			ps.decPrependCount();

			// add supplements
			includeAllBodies(ps, def.getIncludes(), Project.GENERATOR, SupplementCategory.NODE);
			for (TagReferenceDefinition tag : def.getTags())
			{
				includeAllBodies(ps, def.getNamespaceMap().get(tag.getName()).getIncludes(), Project.GENERATOR,
						SupplementCategory.NODE);
			}

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
			List<String> queue = new LinkedList<String>();
			queue.add("Node");
			while (queue.size() > 0)
			{
				String type = queue.remove(0);
				names.add(type);
				Set<String> subs = subtypeMap.get(type);
				if (subs != null)
					queue.addAll(subs);
			}

			Set<String> concreteTypeNameSet = new HashSet<String>(names);
			concreteTypeNameSet.removeAll(abstractTypes);
			List<String> sortedNames = new ArrayList<String>(names);
			Collections.sort(sortedNames);

			// Write interface
			PrintStream ps = createOutputFile("edu.jhu.cs.bsj.compiler.ast", TypeDefinition.Mode.INTERFACE,
					Project.API, SupplementCategory.GENERAL, "BsjTypedNodeVisitor", true, null, null);
			writeTypeBody(ps, false, sortedNames, concreteTypeNameSet);
			ps.println("}");
			ps.close();

			// Write default implementation
			ps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", TypeDefinition.Mode.CONCRETE, Project.API,
					SupplementCategory.GENERAL, "BsjTypedNodeNoOpVisitor", true, null, null, "BsjTypedNodeVisitor");
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
		/** A mapping from factory type names to their print streams. */
		private Map<String, PrependablePrintStream> mapping;

		@Override
		public void init() throws IOException
		{
			super.init();
			mapping = new HashMap<String, PrependablePrintStream>();
		}

		private void ensureStreams(GenerationProfile generationProfile) throws IOException
		{
			String interfaceName = generationProfile.getProperty(GenerationProfile.FACTORY_INTERFACE_NAME);
			if (interfaceName != null && !mapping.containsKey(interfaceName))
			{
				String typeName = StringUtilities.getSuffix(interfaceName, '.');
				String packageName = StringUtilities.removeSuffix(interfaceName, '.');
				PrependablePrintStream ips = createOutputFile(packageName, TypeDefinition.Mode.INTERFACE, Project.API,
						SupplementCategory.GENERAL, typeName, true, null, null);
				mapping.put(interfaceName, ips);
			}
			String className = generationProfile.getProperty(GenerationProfile.FACTORY_CLASS_NAME);
			if (className != null && !mapping.containsKey(className))
			{
				String typeName = StringUtilities.getSuffix(className, '.');
				String packageName = StringUtilities.removeSuffix(className, '.');
				String ifaceName = interfaceName != null ? StringUtilities.getSuffix(interfaceName, '.') : null;
				PrependablePrintStream cps = createOutputFile(packageName, TypeDefinition.Mode.CONCRETE,
						Project.GENERATOR, SupplementCategory.GENERAL, typeName, true, null, null, ifaceName);
				mapping.put(className, cps);
			}
			String decoratorClassName = generationProfile.getProperty(GenerationProfile.FACTORY_DECORATOR_CLASS_NAME);
			if (decoratorClassName != null && !mapping.containsKey(decoratorClassName))
			{
				String typeName = StringUtilities.getSuffix(decoratorClassName, '.');
				String packageName = StringUtilities.removeSuffix(decoratorClassName, '.');
				String ifaceName = interfaceName != null ? StringUtilities.getSuffix(interfaceName, '.') : null;
				PrependablePrintStream dps = createOutputFile(packageName, TypeDefinition.Mode.ABSTRACT, Project.API,
						SupplementCategory.GENERAL, typeName, true, null, null, ifaceName);
				mapping.put(decoratorClassName, dps);
			}
		}

		private PrependablePrintStream getStream(TypeDefinition def, GenerationProfile.Element<String> element)
		{
			PrependablePrintStream pps = mapping.get(def.getProfile().getProperty(element));
			if (pps == null)
			{
				pps = new PrependablePrintStream(new NullOutputStream());
			}
			return pps;
		}

		@Override
		public void useDefinition(TypeDefinition def) throws IOException
		{
			ensureStreams(def.getProfile());

			PrependablePrintStream ips = getStream(def, GenerationProfile.FACTORY_INTERFACE_NAME);
			PrependablePrintStream cps = getStream(def, GenerationProfile.FACTORY_CLASS_NAME);
			PrependablePrintStream dps = getStream(def, GenerationProfile.FACTORY_DECORATOR_CLASS_NAME);

			if (def.getMode() == TypeDefinition.Mode.CONCRETE)
			{
				List<PropertyDefinition> recProps = def.getRecursiveProperties();

				// Write normal factory method
				List<FactoryMethodPropertyDefinition> standardFactoryMethodProperties = new ArrayList<FactoryMethodPropertyDefinition>();
				for (ModalPropertyDefinition<?> p : recProps)
				{
					standardFactoryMethodProperties.add(new FactoryMethodPropertyDefinition(p.getName(), !p.isHide()));
				}
				FactoryMethodDefinition standardFactoryDefinition = new EnumeratedFactoryMethodDefinition(
						standardFactoryMethodProperties);
				for (boolean skipMake : new boolean[] { true, false })
				{
					writeFactoryMethod(ips, cps, dps, def, standardFactoryDefinition, skipMake);
				}

				// Write extra factory methods as instructed
				for (FactoryMethodDefinition methodDefinition : def.getFactoryMethods())
				{
					for (boolean skipMake : new boolean[] { true, false })
					{
						writeFactoryMethod(ips, cps, dps, def, methodDefinition, skipMake);
					}
				}
			}
		}

		@Override
		public void finish() throws IOException
		{
			super.finish();

			for (PrependablePrintStream pps : this.mapping.values())
			{
				pps.println("}");
				pps.close();
			}
		}

		private void writeFactoryMethod(PrependablePrintStream ips, PrependablePrintStream cps,
				PrependablePrintStream dps, TypeDefinition def, FactoryMethodDefinition methodDefinition,
				boolean skipMake)
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
			Map<String, String> factoryOverrideMap = def.getRecursiveFactoryOverrideMap();
			List<PropertyDefinition> recProps = def.getRecursiveProperties();
			List<PropertyDefinition> argProps = new ArrayList<PropertyDefinition>();
			for (PropertyDefinition recProp : recProps)
			{
				if ((methodDefinition.isVisible(recProp.getName()) || (recProp.isSkipMake() && !skipMake))
						&& !recProp.isHide() && !factoryOverrideMap.containsKey(recProp.getName()))
				{
					argProps.add(recProp);
				}
			}

			// Increase prepends
			for (PrependablePrintStream ps : new PrependablePrintStream[] { ips, cps, dps })
			{
				ps.incPrependCount();
			}

			// Write documentation
			for (PrependablePrintStream ps : new PrependablePrintStream[] { ips, cps, dps })
			{
				ps.println("/**");
				ps.println(" * Creates a " + def.getBaseName() + ".");
				if (!skipMake)
				{
					ps.println(" * The specified start and stop locations are used.");
				} else
				{
					ps.println(" * The start and stop locations which have been set as properties of this factory are used.");
				}
				ps.println(" */");
			}

			// Write interface method description
			ips.print("public " + typeParamS + typeName + " make" + def.getBaseName());
			printParameterList(ips, argProps, skipMake);
			ips.println(";");
			ips.println();

			// Write backing class implementation
			cps.println("@Override");
			cps.print("public " + typeParamS + typeName + " make" + def.getBaseName());
			printParameterList(cps, argProps, skipMake);
			cps.println();
			cps.println("{");
			cps.incPrependCount();
			String classname = def.getBaseName() + "Impl" + typeArg;
			cps.print(typeName + " ret = new " + classname);

			printFactoryArgumentList(cps, recProps, factoryOverrideMap, methodDefinition, def);

			cps.println(";");
			cps.println("return ret;");
			cps.decPrependCount();
			cps.println("}");
			cps.println();

			// Write decorator implementation
			dps.println("@Override");
			dps.print("public " + typeParamS + typeName + " make" + def.getBaseName());
			printParameterList(dps, argProps, skipMake);
			dps.println();
			dps.println("{");
			dps.incPrependCount();
			dps.println("this.before();");
			dps.print(typeName + " node = factory.make" + def.getBaseName());
			printArgumentList(dps, argProps, skipMake);
			dps.println(";");
			dps.println("this.after(node);");
			dps.println("return node;");
			dps.decPrependCount();
			dps.println("}");
			dps.println();

			// Special ListNode constructor
			if (this.<TypeDefinition, PropertyDefinition> propInstanceOf(def.getFullName(), "ListNode", null))
			{
				// Write documentation
				for (PrintStream ps : new PrintStream[] { ips, cps, dps })
				{
					ps.println("/**");
					ps.println(" * Creates a " + def.getBaseName() + ".");
					if (!skipMake)
					{
						ps.println(" * The specified start and stop locations are used.");
					} else
					{
						ps.println(" * The start and stop locations which have been set as properties of this factory are used.");
					}
					ps.println(" */");
				}

				// Create a list to fake the parameter list printer into printing a vararg
				List<PropertyDefinition> fakeProps = new ArrayList<PropertyDefinition>();
				ModalPropertyDefinition<?> listDef = null;
				for (PropertyDefinition propDef : argProps)
				{
					if (propDef.getBaseType().equals("List") && listDef == null)
					{
						listDef = propDef;
					} else
					{
						fakeProps.add(propDef);
					}
				}
				fakeProps.add(new PropertyDefinition(listDef.getName() + "Elements", listDef.getTypeArg() + "...",
						null, ModalPropertyDefinition.Mode.NORMAL, "", listDef.getDefaultExpression()));

				// Write interface method description
				ips.print("public " + typeName + " make" + def.getBaseName());
				printParameterList(ips, fakeProps, skipMake);
				ips.println(";");
				ips.println();

				// Write backing class implementation
				cps.println("@Override");
				cps.print("public " + typeName + " make" + def.getBaseName());
				printParameterList(cps, fakeProps, skipMake);
				cps.println();
				cps.println("{");
				cps.incPrependCount();
				cps.println("List<" + listDef.getTypeArg() + "> " + listDef.getName() + " = Arrays.asList("
						+ listDef.getName() + "Elements);");
				cps.print("return make" + def.getBaseName());
				printArgumentList(cps, argProps);
				cps.println(";");
				cps.decPrependCount();
				cps.println("}");
				cps.println();

				// Write decorator implementation
				dps.println("@Override");
				dps.print("public " + typeName + " make" + def.getBaseName());
				printParameterList(dps, fakeProps, skipMake);
				dps.println();
				dps.println("{");
				dps.println("    this.before();");
				dps.print("    " + typeName + " node = factory.make" + def.getBaseName());
				printArgumentList(dps, fakeProps, skipMake);
				dps.println(";");
				dps.println("    this.after(node);");
				dps.println("    return node;");
				dps.println("}");
				dps.println();
			}

			// Decrease prepends
			for (PrependablePrintStream ps : new PrependablePrintStream[] { ips, cps, dps })
			{
				ps.decPrependCount();
			}
		}

		private void printFactoryArgumentList(PrintStream ps, List<PropertyDefinition> props,
				Map<String, String> overrideMap, FactoryMethodDefinition methodDefinition, TypeDefinition def)
		{
			boolean first = true;
			ps.print("(");
			for (ModalPropertyDefinition<?> p : props)
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
					throw new IllegalStateException("Property " + p.getName() + " is invisible in factory method of "
							+ def.getBaseName() + " with no default.");
				}
			}
			ps.print(")");
		}
	}

	/**
	 * Writes the BSJ node operation interface and related classes.
	 */
	static class NodeOperationWriter extends ClassHierarchyBuildingHandler
	{
		static class Strings
		{
			final int argCount;
			final String suffix;
			final String inputTypeParams;
			final String methodParams;
			final String methodArgs;

			protected String getParameterName(int index)
			{
				if (index <= 0 || index > argCount)
				{
					throw new IndexOutOfBoundsException();
				}
				if (argCount == 1)
				{
					return "p";
				} else
				{
					return "p" + index;
				}
			}

			protected String getTypeParameterName(int index)
			{
				if (index <= 0 || index > argCount)
				{
					throw new IndexOutOfBoundsException();
				}
				if (argCount == 1)
				{
					return "P";
				} else
				{
					return "P" + index;
				}
			}

			protected Strings(int argCount)
			{
				this.argCount = argCount;
				if (argCount == 1)
				{
					suffix = "";
				} else
				{
					suffix = argCount + "Arguments";
				}
				StringBuilder inputTypeParamsBuilder = new StringBuilder();
				StringBuilder methodParamsBuilder = new StringBuilder();
				StringBuilder methodArgsBuilder = new StringBuilder();
				for (int i = 1; i <= argCount; i++)
				{
					if (i > 1)
					{
						inputTypeParamsBuilder.append(",");
						methodParamsBuilder.append(", ");
						methodArgsBuilder.append(", ");
					}
					inputTypeParamsBuilder.append(getTypeParameterName(i));
					methodParamsBuilder.append(getTypeParameterName(i) + " " + getParameterName(i));
					methodArgsBuilder.append(getParameterName(i));
				}
				inputTypeParams = inputTypeParamsBuilder.toString();
				methodParams = methodParamsBuilder.toString();
				methodArgs = methodArgsBuilder.toString();
			}
		}

		/** Print stream for the interface. */
		private List<PrependablePrintStream> ipsList;
		/** Print stream for the implementation. */
		private List<PrependablePrintStream> npsList;
		/** Print stream for all-methods proxy. */
		private List<PrependablePrintStream> ppsList;
		/** Print stream for default operation implementation. */
		private List<PrependablePrintStream> dpsList;
		/** Print stream for the Java node operation implementation. */
		private List<PrependablePrintStream> jpsList;

		protected Iterable<PrependablePrintStream> allStreams()
		{
			List<PrependablePrintStream> streams = new ArrayList<PrependablePrintStream>();
			streams.addAll(ipsList);
			streams.addAll(npsList);
			streams.addAll(ppsList);
			streams.addAll(dpsList);
			streams.addAll(jpsList);
			return streams;
		}

		@Override
		public void init() throws IOException
		{
			super.init();

			ipsList = new ArrayList<PrependablePrintStream>();
			npsList = new ArrayList<PrependablePrintStream>();
			ppsList = new ArrayList<PrependablePrintStream>();
			dpsList = new ArrayList<PrependablePrintStream>();
			jpsList = new ArrayList<PrependablePrintStream>();

			for (int index = 1; index <= NUMBER_OF_OPERATION_VARIATIONS; index++)
			{
				final int argCount = index;
				final Strings strings = new Strings(argCount);

				String inputTypeParams = strings.inputTypeParams;
				String typeParams = inputTypeParams + ",R";
				String typeParamDecl = "<" + typeParams + ">";

				String newTypeParams = typeParams.replace(",", "New,") + "New";
				String newTypeParamsDecl = "<" + newTypeParams + ">";
				String origTypeParams = typeParams.replaceAll(",", "Orig,") + "Orig";
				String proxyTypeParams = origTypeParams + "," + newTypeParams;
				String proxyTypeParamsDecl = "<" + proxyTypeParams + ">";

				String suffix = strings.suffix;

				// @formatter:off
				String bsjNodeOperationHeader =
					"/**\n" +
					" * This interface specifies an operation to be carried out on a node.  The purpose of this\n" +
					" * mechanism is effectively to allow the addition of operations to the node hierarchy\n"+
					" * requiring that the hierarchy itself be modified.  Note that while this interface is\n"+
					" * similar to that of the visitor pattern (see {@link BsjNodeVisitor}), it does not function\n"+
					" * the same way.  This mechanism does not abstract node traversal; the implementation is\n"+
					" * required to do that itself if it wishes to walk the tree.\n"+
					" *\n";
				for (int i=1;i<=argCount;i++)
				{
					bsjNodeOperationHeader += 
					" * @param <"+strings.getTypeParameterName(i)+"> A parameter type for all methods to accept.  If no return type is desired, use\n"+
					" * {@link java.lang.Void}.\n";
				}
				bsjNodeOperationHeader +=
					" * @param <R> A return type for all methods to return.  If no return type is desired, use\n"+
					" * {@link java.lang.Void}.\n"+
					" *\n"+
					" * @author Zachary Palmer\n"+
					" */\n";
				
				String bsjNoOpNodeOperationHeader =
					"/**\n" +
					" * This implementation of the BSJ node operation implements every method with a no-op.\n" +
					" *\n" +
					" * @author Zachary Palmer\n" +
					" */\n";
				
				String bsjNodeOperationProxyHeader =
					"/**\n" +
					" * This implementation of the BSJ node operation decorates every method of a backing\n" +
					" * operation with a uniform before and after call.  This permits allows proxying, adjusting\n" +
					" * or logging the parameters and results of calls, or adaptation of the backing operation\n" +
					" * to a different set of data types.  Note that only the first call is proxied; if the\n" +
					" * backing operation calls itself, those calls are not intercepted.\n" +
					" *\n";
				for (int i=1;i<=argCount;i++)
				{
					bsjNodeOperationProxyHeader +=
						" * @param <" + strings.getParameterName(i) + "Orig> A data parameter type for the original backing operation.\n";
				}
				bsjNodeOperationProxyHeader +=
					" * @param <ROrig> The return type for the original backing operation.\n";
				for (int i=1;i<=argCount;i++)
				{
					bsjNodeOperationProxyHeader +=
						" * @param <" + strings.getParameterName(i) + "New> A data parameter type for the new decorated operation.\n";
				}
				bsjNodeOperationProxyHeader +=
					" * @param <RNew> The return type for the decorated operation.\n" +
					" *\n" +
					" * @author Zachary Palmer\n" +
					" */\n";
				
				String bsjDefaultNodeOperationHeader =
					"/**\n" +
					" * This implementation of the BSJ node operation implements every method with a call to a default operation method.  The\n" +
					" * default operation method is left abstract for the overlying implementation.  This serves as a convenient mechanism\n" +
					" * for handling most nodes with a default case but labeling some with special handling.  For instance, a node operation\n" +
					" * which only recognizes a small subset of node types might use the default operation to raise a runtime exception.\n" +
					" *\n" +
					" * @author Zachary Palmer\n" +
					" */\n";
				
				String javaNodeOperationHeader =
					"/**\n" +
					" * This implementation of the BSJ node operation implements methods which correspond to BSJ-specific node types with a\n" +
					" * call to a default operation method. The default operation method is left abstract for the overlying implementation.\n" +
					" * This serves as a convenient mechanism for operating over trees which should be pure Java ASTs; the default method may\n" +
					" * raise an exception or perform other error reporting operations.\n" +
					" *\n" + 
					" * @author Zachary Palmer\n" +
					" */\n";
				// @formatter:on

				PrependablePrintStream ips = createOutputFile("edu.jhu.cs.bsj.compiler.ast",
						TypeDefinition.Mode.INTERFACE, Project.API, SupplementCategory.GENERAL, "BsjNodeOperation"
								+ suffix + typeParamDecl, false, bsjNodeOperationHeader, null);
				PrependablePrintStream nps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util",
						TypeDefinition.Mode.CONCRETE, Project.API, SupplementCategory.GENERAL, "BsjNodeNoOpOperation"
								+ suffix + typeParamDecl, false, bsjNoOpNodeOperationHeader, null, "BsjNodeOperation"
								+ suffix + typeParamDecl);
				PrependablePrintStream pps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util",
						TypeDefinition.Mode.ABSTRACT, Project.API, SupplementCategory.GENERAL, "BsjNodeOperationProxy"
								+ suffix + proxyTypeParamsDecl, false, bsjNodeOperationProxyHeader, null,
						"BsjNodeOperation" + suffix + newTypeParamsDecl);
				PrependablePrintStream dps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util",
						TypeDefinition.Mode.ABSTRACT, Project.API, SupplementCategory.GENERAL,
						"BsjDefaultNodeOperation" + suffix + typeParamDecl, false, bsjDefaultNodeOperationHeader, null,
						"BsjNodeOperation" + suffix + typeParamDecl);
				PrependablePrintStream jps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util",
						TypeDefinition.Mode.ABSTRACT, Project.API, SupplementCategory.GENERAL, "JavaNodeOperation"
								+ suffix + typeParamDecl, false, javaNodeOperationHeader, null, "BsjNodeOperation"
								+ suffix + typeParamDecl);

				ipsList.add(ips);
				npsList.add(nps);
				ppsList.add(pps);
				dpsList.add(dps);
				jpsList.add(jps);

				pps.incPrependCount();
				pps.println("/** The backing operation to proxy. */");
				pps.println("private BsjNodeOperation" + strings.suffix + "<" + origTypeParams + "> backingOp;");
				pps.println();
				pps.println("/**");
				pps.println(" * Creates a new node operation proxy.");
				pps.println(" * @param backingOp The backing operation to proxy.");
				pps.println(" */");
				pps.println("public BsjNodeOperationProxy" + strings.suffix + "(BsjNodeOperation" + strings.suffix
						+ "<" + origTypeParams + "> backingOp)");
				pps.println("{");
				pps.println("    this.backingOp = backingOp;");
				pps.println("}");
				pps.println();
				for (int i = 1; i <= argCount; i++)
				{
					pps.println("/**");
					pps.println(" * Called before every call to the backing operation.");
					pps.println(" * @param p The incoming parameter data (compatible with the proxy interface).");
					pps.println(" * @return The resulting parameter data (compatible with the backing interface).");
					pps.println(" */");
					pps.println("protected abstract " + strings.getTypeParameterName(i) + "Orig before"
							+ (argCount == 1 ? "" : String.valueOf(i)) + "(" + strings.getTypeParameterName(i) + "New "
							+ strings.getParameterName(i) + ");");
					pps.println();
				}
				pps.println("/**");
				pps.println(" * Called after every call to the backing operation.");
				pps.println(" * @param r The incoming return data (compatible with the backing interface).");
				pps.println(" * @return The resulting return data (compatible with the return interface).");
				pps.println(" */");
				pps.println("protected abstract RNew after(ROrig r);");
				pps.decPrependCount();

				dps.incPrependCount();
				dps.println("/**");
				dps.println(" * The default operation which all default node operation implementations will call.");
				dps.println(" * @param node The node in question.");
				for (int i = 1; i <= argCount; i++)
				{
					dps.println(" * @param " + strings.getParameterName(i) + " The parameter to the execution method.");
				}
				dps.println(" */");
				dps.println("public abstract R executeDefault(Node node, " + strings.methodParams + ");");
				dps.println();
				dps.decPrependCount();

				jps.incPrependCount();
				jps.println("/**");
				jps.println(" * The default operation which all BSJ-specific node operation implementations will call.");
				jps.println(" * ");
				jps.println(" * @param node The node in question.");
				for (int i = 1; i <= argCount; i++)
				{
					jps.println(" * @param " + strings.getParameterName(i) + " The parameter to the execution method.");
				}
				jps.println(" */");
				jps.println("public abstract R handleBsjSpecificNode(BsjSpecificNode node, " + strings.methodParams
						+ ");");
				jps.println();
				jps.decPrependCount();
			}
		}

		@Override
		public void useDefinition(TypeDefinition def) throws IOException
		{
			for (int index = 1; index <= NUMBER_OF_OPERATION_VARIATIONS; index++)
			{
				final int argCount = index;
				final Strings strings = new Strings(argCount);
				final PrependablePrintStream ips = ipsList.get(argCount - 1);
				final PrependablePrintStream nps = npsList.get(argCount - 1);
				final PrependablePrintStream pps = ppsList.get(argCount - 1);
				final PrependablePrintStream dps = dpsList.get(argCount - 1);
				final PrependablePrintStream jps = jpsList.get(argCount - 1);

				for (PrependablePrintStream ps : allStreams())
				{
					ps.incPrependCount();
				}

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

					String paramDecls = strings.methodParams;
					String methodArgs = strings.methodArgs;

					ips.println("/**");
					ips.println(" * Executes this operation against a " + def.getBaseName() + ".");
					ips.println(" * @param node The " + def.getBaseName() + " in question.");
					ips.println(" * @param p The parameter to use.");
					ips.println(" * @return The result of the operation.");
					ips.println(" */");
					ips.println("public " + typeParamS + "R execute" + def.getBaseName() + "(" + typeName + " node, "
							+ paramDecls + ");");
					ips.println();

					nps.println("/**");
					nps.println(" * Performs no operation.");
					nps.println(" * @param node Ignored.");
					nps.println(" * @param p Ignored.");
					nps.println(" * @return <code>null</code>, always.");
					nps.println(" */");
					nps.println("public " + typeParamS + "R execute" + def.getBaseName() + "(" + typeName + " node, "
							+ paramDecls + ")");
					nps.println("{");
					nps.println("    return null;");
					nps.println("}");
					nps.println();

					pps.println("/**");
					pps.println(" * Decorates this operation, turning it over to the backing operation.");
					pps.println(" * @param node The node to affect.");
					pps.println(" * @param p The value to pass through the proxy filter and into the backing operation.");
					pps.println(" * @return The result of this operation (after being passed through the proxy filter).");
					pps.println(" */");
					pps.println("public " + typeParamS + "RNew execute" + def.getBaseName() + "(" + typeName
							+ " node, " + paramDecls.replaceAll(" p", "New p") + ")");
					pps.println("{");
					if (argCount == 1)
					{
						pps.println("    POrig porig = before(p);");
						pps.println("    ROrig rorig = this.backingOp.execute" + def.getBaseName() + "(node, porig);");
					} else
					{
						for (int i = 1; i <= argCount; i++)
						{
							pps.println("    P" + i + "Orig p" + i + "orig = before" + i + "(p" + i + ");");
						}
						pps.print("    ROrig rorig = this.backingOp.execute" + def.getBaseName() + "(node");
						for (int i = 1; i <= argCount; i++)
						{
							pps.print(", p" + i + "orig");
						}
						pps.println(");");
					}
					pps.println("    return after(rorig);");
					pps.println("}");
					pps.println();

					dps.println("/**");
					dps.println(" * Executes the default operation for this node.");
					dps.println(" * @param node The node in question.");
					dps.println(" * @param p The parameter to this node operation.");
					dps.println(" */");
					dps.println("public " + typeParamS + "R execute" + def.getBaseName() + "(" + typeName + " node, "
							+ paramDecls + ")");
					dps.println("{");
					dps.println("    return executeDefault(node, " + methodArgs + ");");
					dps.println("}");
					dps.println();

					if (def.isBsjSpecific())
					{
						jps.println("/**");
						jps.println(" * Executes the BSJ-specific operation for this node.");
						jps.println(" * @param node The node in question.");
						jps.println(" * @param p The parameter to this node operation.");
						jps.println(" */");
						jps.println("public " + typeParamS + "R execute" + def.getBaseName() + "(" + typeName
								+ " node, " + paramDecls + ")");
						jps.println("{");
						jps.println("    return handleBsjSpecificNode(node, " + methodArgs + ");");
						jps.println("}");
						jps.println();
					}
				}

				for (PrependablePrintStream ps : allStreams())
				{
					ps.decPrependCount();
				}
			}
		}

		@Override
		public void finish() throws IOException
		{
			super.finish();

			for (PrependablePrintStream ps : allStreams())
			{
				ps.println("}");
				ps.close();
			}
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
			ps = createOutputFile("edu.jhu.cs.bsj.compiler.impl.tool.compiler", TypeDefinition.Mode.CONCRETE,
					Project.GENERATOR, SupplementCategory.GENERAL, "BsjTreeLifter", true, null, null,
					"BsjNodeOperation<ExpressionNode,ExpressionNode>");
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
				ps.incPrependCount();
				ps.println("if (x == null)");
				ps.println("{");
				ps.incPrependCount();
				ps.println("return factory.makeNullLiteralNode();");
				ps.decPrependCount();
				ps.println("} else");
				ps.println("{");
				ps.incPrependCount();
				ps.println("return factory.makeVariableAccessByNameNode(factory.makeQualifiedNameNode(");
				ps.println("        factory.makeSimpleNameNode(");
				ps.println("                factory.makeIdentifierNode(\"" + etype + "\")");
				ps.println("                ),");
				ps.println("        factory.makeIdentifierNode(x.name())));");
				ps.decPrependCount();
				ps.println("}");
				ps.decPrependCount();
				ps.println("}");
				ps.println();
			}
		}

		@Override
		public void useDefinition(TypeDefinition def) throws IOException
		{
			List<PropertyDefinition> recProp = def.getRecursiveProperties();
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
			for (ModalPropertyDefinition<?> p : recProp)
			{
				if (p.isSkipMake() && !p.getName().matches("st(art|op)Location"))
					continue;
				if (def.getRecursiveFactoryOverrideMap().containsKey(p.getName()))
					continue;

				propAbstract(new PropertyTypeAbstractor()
				{
					public void voidType(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
					{
						// Intentionally doing nothing. We'll just use "null" below.
					}

					public void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
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
						ps.println("factory.makeNullLiteralNode();");
						ps.decPrependCount(4);
						if (generic)
						{
							ps.println("argsFor" + rawName + "Stack.pop();");
						}
					}

					public void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
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

					public void directCopy(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
					{
						ps.println(p.getFullType() + " lift" + capFirst(p.getName()) + "Value = ");
						ps.println("        node.get" + capFirst(p.getName()) + "();");
					}

					public void cloneable(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
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
			for (ModalPropertyDefinition<?> p : recProp)
			{
				if (p.isSkipMake() && !p.getName().matches("st(art|op)Location"))
					continue;
				if (def.getRecursiveFactoryOverrideMap().containsKey(p.getName()))
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
					public void voidType(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
					{
						ps.print("factory.makeNullLiteralNode()");
					}

					public void node(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
					{
						ps.print("lift" + capFirst(p.getName()));
					}

					public void list(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
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
						ps.println("factory.makeIdentifierNode(\"java\")),");
						ps.decPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"util\")),");
						ps.decPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"Arrays\")),");
						ps.decPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"asList\")),");
						ps.decPrependCount(2);
						ps.println("factory.makeExpressionListNode(lift" + capFirst(p.getName()) + "List),");
						ps.println("factory.makeReferenceTypeListNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeUnparameterizedTypeNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeSimpleNameNode(");
						ps.incPrependCount(2);
						ps.println("factory.makeIdentifierNode(\"" + p.getTypeArg() + "\")))))");
						ps.decPrependCount(8);
					}

					public void directCopy(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
					{
						ps.print("expressionize" + capFirst(p.getBaseType()) + "(lift" + capFirst(p.getName())
								+ "Value)");
					}

					public void cloneable(PrependablePrintStream ps, ModalPropertyDefinition<?> p)
					{
						ps.print("lift" + capFirst(p.getName()) + "MetaClone");
					}
				}, p, ps, def);
			}
			ps.println("),");
			ps.decPrependCount(2);
			ps.println("factory.makeReferenceTypeListNode());");
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

	static abstract class AbstractDiagnosticDefinitionHandler<T extends AbstractDiagnosticDefinition<T>> extends
			AbstractDefinitionHandler
	{
		protected final String INTERFACE_IMPORTS = "import edu.jhu.cs.bsj.compiler.diagnostic.*;\n"
				+ "import edu.jhu.cs.bsj.compiler.metaannotation.*;\n"
				+ "import edu.jhu.cs.bsj.compiler.metaprogram.*;\n" + "import javax.tools.Diagnostic.Kind;\n"
				+ "import javax.tools.*\n;";
		protected final String CLASS_IMPORTS = INTERFACE_IMPORTS
				+ "import edu.jhu.cs.bsj.compiler.impl.diagnostic.*;\n"
				+ "import edu.jhu.cs.bsj.compiler.impl.utils.*;\n";

		protected void handleAbstractDiagnosticDefinition(T def) throws IOException
		{
			PrependablePrintStream classPs;
			PrependablePrintStream ifacePs;

			String interfacePackage = def.getProfile().getProperty(GenerationProfile.GENERATED_INTERFACE_PACKAGE_NAME);
			Project ifaceProject = def.getProfile().getProperty(GenerationProfile.INTERFACE_PROJECT);
			Project classProject = def.getProfile().getProperty(GenerationProfile.IMPLEMENTATION_PROJECT);
			ifacePs = createOutputFile(interfacePackage, Mode.INTERFACE, ifaceProject, SupplementCategory.GENERAL,
					def.getFullName(), false,
					INTERFACE_IMPORTS + "\n/**\n * " + def.getDocString().replaceAll("\n", "\n * ") + "\n */",
					def.getFullSuper());
			ifacePs.incPrependCount();

			String classPackage = def.getProfile().getProperty(GenerationProfile.GENERATED_CLASS_PACKAGE_NAME);
			classPs = createOutputFile(classPackage, def.getCode() == null ? Mode.ABSTRACT : Mode.CONCRETE,
					classProject, SupplementCategory.GENERAL,
					def.getName() + "Impl" + def.getTypeParameterWithDelimiters(), false, CLASS_IMPORTS + "import "
							+ interfacePackage + ".*;\n" + "\n\n/**\n * "
							+ def.getDocString().replaceAll("\n", "\n * ") + "\n */",
					def.getFullSuper().replaceAll(def.getSuperName(), def.getSuperName() + "Impl"),
					def.getNameWithTypeParameters());
			classPs.incPrependCount();

			if (def.getCode() != null)
			{
				ifacePs.println("/** The code for this diagnostic. */");
				ifacePs.println("public static final String CODE = \"" + def.getCode() + "\";");
				ifacePs.println();
			}

			for (DiagnosticPropertyDefinition prop : def.getProperties())
			{
				classPs.println("/** " + capFirst(prop.getDescription()) + ". */");
				classPs.println("private " + prop.getFullType() + " " + prop.getName() + ";");
				classPs.println();
			}

			// Create constructor definition
			List<DiagnosticPropertyDefinition> consParams = getDefaultConstructorParameters(def);
			consParams.addAll(def.getRecursiveProperties(true));

			List<DiagnosticPropertyDefinition> superParams = new ArrayList<DiagnosticPropertyDefinition>(consParams);
			superParams.removeAll(def.getProperties());

			// Write constructor
			classPs.print("public " + def.getName() + "Impl");
			printParameterList(classPs, consParams, true);
			classPs.println();
			classPs.println("{");
			classPs.incPrependCount();
			classPs.print("super");
			Map<String, String> overrideMap = new HashMap<String, String>();
			for (ModalPropertyDefinition<?> prop : superParams)
			{
				if (prop.getDefaultExpression() != null)
				{
					overrideMap.put(prop.getName(), prop.getDefaultExpression());
				}
			}
			printArgumentList(classPs, superParams, overrideMap);
			classPs.println(";");

			for (DiagnosticPropertyDefinition prop : def.getProperties())
			{
				classPs.println("this." + prop.getName() + " = " + prop.getName() + ";");
			}

			classPs.decPrependCount();
			classPs.println("}");
			classPs.println();

			// Write interface getters
			for (DiagnosticPropertyDefinition prop : def.getProperties())
			{
				ifacePs.println("/**");
				ifacePs.println(" * Retrieves " + prop.getDescription() + ".");
				ifacePs.println(" * @return " + capFirst(prop.getDescription()) + ".");
				ifacePs.println(" */");
				ifacePs.println("public " + prop.getFullType() + " get" + capFirst(prop.getName()) + "();");
				ifacePs.println();
			}

			// Write class getters
			for (DiagnosticPropertyDefinition prop : def.getProperties())
			{
				classPs.println("/**");
				classPs.println(" * {@inheritDoc}");
				classPs.println(" */");
				classPs.println("public " + prop.getFullType() + " get" + capFirst(prop.getName()) + "()");
				classPs.println("{");
				classPs.incPrependCount();
				classPs.println("return this." + prop.getName() + ";");
				classPs.decPrependCount();
				classPs.println("}");
				classPs.println();
			}

			// Write message argument implementation
			classPs.println("@Override");
			classPs.println("protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)");
			classPs.println("{");
			classPs.incPrependCount();
			classPs.print("Pair<List<Object>,Map<String,Integer>> args = ");
			if (def.getSuperName().equals(getTopAncestorName()))
			{
				classPs.println("new Pair<List<Object>,Map<String,Integer>>(new ArrayList<Object>(), new HashMap<String,Integer>());");
			} else
			{
				classPs.println("super.getMessageArgs(locale);");
			}
			for (DiagnosticPropertyDefinition prop : def.getProperties())
			{
				classPs.print("args.getFirst().add(");
				if (prop.getMessageExpression() != null)
				{
					classPs.print(prop.getMessageExpression().replaceAll("\\$", "this." + prop.getName()));
				} else
				{
					classPs.print("this." + prop.getName());
				}
				classPs.println(");");
				// NOTE: this is correct because arguments in the format string are 1-based
				classPs.println("args.getSecond().put(\"" + prop.getName() + "\", args.getFirst().size());");
			}
			for (MessagePropertyExpressionDefinition messagePropertyExpression : def.getMessagePropertyExpressions())
			{
				classPs.println("args.getFirst().add(" + messagePropertyExpression.getExpression() + ");");
				// NOTE: this is correct because arguments in the format string are 1-based
				classPs.println("args.getSecond().put(\"" + messagePropertyExpression.getName()
						+ "\", args.getFirst().size());");
			}
			classPs.println("return args;");
			classPs.decPrependCount();
			classPs.println("}");
			classPs.println();

			suffix(def, ifacePs, classPs);

			// Finish out
			ifacePs.decPrependCount();
			ifacePs.println("}");
			classPs.decPrependCount();
			classPs.println("}");
		}

		protected List<DiagnosticPropertyDefinition> getDefaultConstructorParameters(T def)
		{
			List<DiagnosticPropertyDefinition> consParams = new ArrayList<DiagnosticPropertyDefinition>();
			PropertyDefinition.Mode overrideMode = def.getCode() == null ? ModalPropertyDefinition.Mode.NORMAL
					: ModalPropertyDefinition.Mode.SKIP;
			consParams.add(new DiagnosticPropertyDefinition("code", "String", null, overrideMode, null,
					def.getCode() == null ? null : def.getName() + ".CODE", null));
			// TODO: parameterization of diagnostic kind
			consParams.add(new DiagnosticPropertyDefinition("kind", "javax.tools.Diagnostic.Kind", null, overrideMode,
					null, def.getCode() == null ? null : "Kind.ERROR", null));
			return consParams;
		}

		protected abstract String getTopAncestorName();

		protected abstract void suffix(T def, PrependablePrintStream ifacePs, PrependablePrintStream classPs)
				throws IOException;
	}

	static class UserDiagnosticDefinitionHandler extends AbstractDiagnosticDefinitionHandler<UserDiagnosticDefinition>
	{
		@Override
		public void init() throws IOException
		{
		}

		@Override
		protected void suffix(UserDiagnosticDefinition def, PrependablePrintStream classPs,
				PrependablePrintStream ifacePs) throws IOException
		{
		}

		@Override
		protected String getTopAncestorName()
		{
			return "BsjUtilDiagnostic";
		}

		@Override
		public void handleUserDiagnosticDefinition(UserDiagnosticDefinition def) throws IOException
		{
			handleAbstractDiagnosticDefinition(def);
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

	static class DiagnosticDefinitionHandler extends AbstractDiagnosticDefinitionHandler<DiagnosticDefinition>
	{
		private Set<String> generatedExceptionClasses;

		@Override
		public void init() throws IOException
		{
			generatedExceptionClasses = new HashSet<String>();
		}

		@Override
		public void handleDiagnosticDefinition(DiagnosticDefinition def) throws IOException
		{
			handleAbstractDiagnosticDefinition(def);
		}

		@Override
		protected String getTopAncestorName()
		{
			return "BsjDiagnostic";
		}

		@Override
		protected List<DiagnosticPropertyDefinition> getDefaultConstructorParameters(DiagnosticDefinition def)
		{
			List<DiagnosticPropertyDefinition> params = super.getDefaultConstructorParameters(def);
			params.add(0, new DiagnosticPropertyDefinition("source", "BsjSourceLocation", null,
					ModalPropertyDefinition.Mode.NORMAL, "", null, null));
			return params;
		}

		@Override
		protected void suffix(DiagnosticDefinition def, PrependablePrintStream ifacePs, PrependablePrintStream classPs)
				throws IOException
		{
			// If an exception should be created for this diagnostic...
			if (def.getException() != null)
			{
				// First make sure that the exception hierarchy exists
				ensureDiagnosticExceptions(def);

				// Then create a constructor for this type based on the exception's values
				if (def.getCode() != null)
				{
					classPs.println("public " + def.getName() + "Impl(" + "BsjSourceLocation source, "
							+ def.getName().replaceAll("Diagnostic", "Exception") + " exception)");
					classPs.println("{");
					classPs.incPrependCount();
					classPs.print("this(source, ");
					boolean first = true;
					for (ModalPropertyDefinition<?> prop : def.getRecursiveProperties(true))
					{
						if (first)
						{
							first = false;
						} else
						{
							classPs.print(", ");
						}
						if (prop.getName().equals(def.getException().getProperty()))
						{
							classPs.print("exception");
						} else
						{
							classPs.print("exception.get" + capFirst(prop.getName()) + "()");
						}
					}
					classPs.println(");");
					classPs.decPrependCount();
					classPs.println("}");
					classPs.println();
				}
			}
		}

		/**
		 * Creates a diagnostic exception for the provided definition. If necessary, creates exception types for the
		 * parents of this definition as well.
		 * 
		 * @param def The definition to use.
		 * @throws IOException If an I/O error occurs.
		 */
		private void ensureDiagnosticExceptions(DiagnosticDefinition def) throws IOException
		{
			if (def.getParent() != null && def.getParent().getException() != null)
			{
				ensureDiagnosticExceptions(def.getParent());
			}

			String typeName = def.getName().replaceAll("Diagnostic", "Exception");

			// Make sure we only do this once per exception class
			if (!this.generatedExceptionClasses.add(typeName))
			{
				return;
			}

			String supertypeName = def.getParent().getName().replaceAll("Diagnostic", "Exception");

			String imports = "import edu.jhu.cs.bsj.compiler.diagnostic.*;\n"
					+ "import edu.jhu.cs.bsj.compiler.metaannotation.*;\n"
					+ "import edu.jhu.cs.bsj.compiler.diagnostic.compiler.*;\n";
			String exceptionPackage = "edu.jhu.cs.bsj.compiler.ast.exception";
			String exceptionImplPackage = "edu.jhu.cs.bsj.compiler.impl.ast.exception";

			String docString = (def.getException().getDocString() == null) ? def.getDocString()
					: def.getException().getDocString();
			docString = "/**\n * " + docString.replaceAll("\n", "\n * ") + "\n */";

			Project ifaceProject = def.getProfile().getProperty(GenerationProfile.INTERFACE_PROJECT);
			Project classProject = def.getProfile().getProperty(GenerationProfile.IMPLEMENTATION_PROJECT);

			PrependablePrintStream ps = createOutputFile(exceptionPackage, Mode.ABSTRACT, ifaceProject,
					SupplementCategory.GENERAL, typeName, false, imports + "\n" + docString, supertypeName);
			ps.incPrependCount();

			ps.println("private static final long serialVersionUID = 1L;");
			ps.println();

			// Write properties
			for (DiagnosticPropertyDefinition prop : def.getProperties())
			{
				if (def.getException().getProperty().equals(prop.getName()))
				{
					continue;
				}
				ps.println("/** " + capFirst(prop.getDescription()) + ". */");
				ps.println("private " + prop.getFullType() + " " + prop.getName() + ";");
				ps.println();
			}

			// Prepare property lists
			List<DiagnosticPropertyDefinition> props = def.getRecursiveProperties(true);
			List<DiagnosticPropertyDefinition> ourProps = def.getResponsibleProperties(true);
			List<DiagnosticPropertyDefinition> superProps = new ArrayList<DiagnosticPropertyDefinition>(props);
			superProps.removeAll(ourProps);

			for (DiagnosticPropertyDefinition prop : props)
			{
				if (prop.getName().equals(def.getException().getProperty()))
				{
					props.remove(prop);
					ourProps.remove(prop);
					superProps.remove(prop);
					break;
				}
			}

			// Write constructor
			ps.print("public " + typeName);
			printParameterList(ps, props, true);
			ps.println();
			ps.println("{");
			ps.incPrependCount();
			ps.print("super");
			Map<String, String> overrideMap = new HashMap<String, String>();
			for (ModalPropertyDefinition<?> prop : superProps)
			{
				if (prop.getDefaultExpression() != null)
				{
					overrideMap.put(prop.getName(), prop.getDefaultExpression());
				}
			}
			printArgumentList(ps, superProps, overrideMap);
			ps.println(";");

			for (DiagnosticPropertyDefinition prop : ourProps)
			{
				ps.println("this." + prop.getName() + " = " + prop.getName() + ";");
			}

			ps.decPrependCount();
			ps.println("}");
			ps.println();

			// Write class getters
			for (DiagnosticPropertyDefinition prop : def.getProperties())
			{
				if (def.getException().getProperty().equals(prop.getName()))
				{
					continue;
				}
				ps.println("/**");
				ps.println(" * Retrieves " + prop.getDescription() + ".");
				ps.println(" * @return " + capFirst(prop.getDescription()) + ".");
				ps.println(" */");
				ps.println("public " + prop.getFullType() + " get" + capFirst(prop.getName()) + "()");
				ps.println("{");
				ps.incPrependCount();
				ps.println("return this." + prop.getName() + ";");
				ps.decPrependCount();
				ps.println("}");
				ps.println();
			}

			ps.println("/**");
			ps.println(" * Creates a {@link BsjDiagnostic} corresponding to this exception type.");
			ps.println(" * @param location The source location to report as the cause for the diagnostic.");
			ps.println(" * @return A suitable diagnostic.");
			ps.println(" */");
			ps.println("public abstract " + def.getName() + (def.getTypeParameter() != null ? "<?>" : "")
					+ " getDiagnostic(BsjSourceLocation location);");

			ps.decPrependCount();
			ps.println("}");
			ps.close();

			// Now create the compiler-side exception class
			String implImports = imports + "import edu.jhu.cs.bsj.compiler.impl.diagnostic.*;\n"
					+ "import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.*;\n";
			ps = createOutputFile(exceptionImplPackage, def.getCode() != null ? Mode.CONCRETE : Mode.ABSTRACT,
					classProject, SupplementCategory.GENERAL, typeName + "Impl", false, implImports
							+ "\n/*\n * {@inheritDoc}\n */\n", typeName);
			ps.incPrependCount();

			ps.println("private static final long serialVersionUID = 1L;");
			ps.println();

			// Create the constructor
			ps.print("public " + typeName + "Impl");
			printParameterList(ps, props, true);
			ps.println();
			ps.println("{");
			ps.incPrependCount();
			ps.print("super");
			printArgumentList(ps, props, Collections.<String, String> emptyMap());
			ps.println(";");
			ps.decPrependCount();
			ps.println("}");

			// Create the implementation of getDiagnostic
			if (def.getCode() != null)
			{
				ps.println("@Override");
				ps.println("public " + def.getName() + (def.getTypeParameter() != null ? "<?>" : "")
						+ " getDiagnostic(BsjSourceLocation source)");
				ps.println("{");
				ps.println("    return new " + def.getName() + "Impl(source, this);");
				ps.println("}");
				ps.println();
			}

			ps.decPrependCount();
			ps.println("}");
			ps.close();
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
