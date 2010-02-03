package edu.jhu.cs.bsj.compiler.utils.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class generates some patternistic sources for the BSJ parser. The code is awful; it's not intended for long-term
 * maintenance, as it will become obsolete once the BSJ compiler has been reimplemented in BSJ.
 * 
 * @author Zachary Palmer
 */
public class SourceGenerator
{
	private static final File CONTENTS_FILE = new File("data/srcgen/main.srcgen");
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
			"edu.jhu.cs.bsj.compiler.impl.utils.Pair", "javax.annotation.Generated" };

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
	private static final Set<String> CONSTRUCTOR_COPY_NAMES = Collections.unmodifiableSet(new HashSet<String>(
			Arrays.asList(new String[] { "BsjSourceLocation", })));

	private Set<ClassDefHandler> handlers = new HashSet<ClassDefHandler>();
	private Map<String, String> envMap = new HashMap<String, String>();
	private Map<String, String> argMap = new HashMap<String, String>();

	public static void main(String[] arg) throws Exception
	{
		SourceGenerator sg = new SourceGenerator();
		for (Class<?> c : SourceGenerator.class.getDeclaredClasses())
		{
			Class<? extends ClassDefHandler> handlerClass;
			try
			{
				handlerClass = c.asSubclass(ClassDefHandler.class);
			} catch (ClassCastException cce)
			{
				// Not a ClassDefHandler
				continue;
			}

			try
			{
				ClassDefHandler handler = handlerClass.newInstance();
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

	static class Line
	{
		public String string;
		public String filename;
		public int number;

		public Line(String string, String filename, int number)
		{
			super();
			this.string = string;
			this.filename = filename;
			this.number = number;
		}

		public static List<Line> tag(List<String> list, String filename)
		{
			List<Line> ret = new ArrayList<Line>();
			int n = 0;
			for (String s : list)
			{
				ret.add(new Line(s, filename, ++n));
			}
			return ret;
		}
	}

	public void run() throws IOException
	{
		// Clear the target directory
		rmrf(TARGET_DIR);
		TARGET_DIR.mkdirs();

		// Initialize each handler
		for (ClassDefHandler handler : handlers)
			handler.init();

		// Parse contents file
		List<Line> lines = parse(CONTENTS_FILE);

		// Process the contents file
		lines = new LinkedList<Line>(lines);

		process(lines, CONTENTS_FILE.getParentFile());

		// Finish each handler
		for (ClassDefHandler handler : handlers)
			handler.finish();
	}

	private List<Line> parse(File file) throws IOException
	{
		String contents = getFileAsString(file);
		List<String> strings = new ArrayList<String>(Arrays.asList(contents.split("\n")));

		// Strip comments
		for (int i = 0; i < strings.size(); i++)
		{
			String s = strings.get(i);
			if (s.contains("#"))
			{
				int index = s.indexOf("#");
				while (index != -1)
				{
					if (index == 0 || s.charAt(index - 1) != '&')
					{
						s = s.substring(0, s.indexOf("#"));
						strings.set(i, s);
						break;
					}
					index = s.indexOf('#', index + 1);
				}
			}
		}

		return Line.tag(strings, file.getName());
	}

	private void process(List<Line> lines, File relDir) throws IOException
	{
		while (lines.size() > 0 && lines.get(0).string.trim().length() == 0)
		{
			lines.remove(0);
		}
		while (lines.size() > 0)
		{
			if (lines.get(0).string.trim().startsWith("!"))
			{
				Line line = lines.remove(0);
				String command = line.string.trim();
				String op = command.substring(0, command.indexOf(' '));
				String arg = command.substring(op.length()).trim();

				if (op.equals("!set"))
				{
					parseMapLine("set", this.envMap, arg, command);
				} else if (op.equals("!arg"))
				{
					parseMapLine("arg", this.argMap, arg, command);
				} else if (op.equals("!include"))
				{
					String path = arg;
					File f = new File(relDir.getPath() + File.separator + path).getCanonicalFile();
					List<Line> includeLines = parse(f);
					process(includeLines, f.getParentFile());
				} else
				{
					throw new IllegalArgumentException("Unknown command " + command);
				}
			} else
			{
				processEntry(lines);
			}
			while (lines.size() > 0 && lines.get(0).string.trim().length() == 0)
			{
				lines.remove(0);
			}
		}
	}

	private void parseMapLine(String name, Map<String, String> map, String arg, String command)
	{
		String[] pieces = arg.split("=");
		if ((pieces.length == 1) && (arg.endsWith("=")))
		{
			pieces = new String[] { pieces[0], "" };
		}
		if (pieces.length != 2)
		{
			throw new IllegalArgumentException("Malformed " + name + " command " + command);
		}
		map.put(pieces[0], pieces[1]);
	}

	private void processEntry(List<Line> lines) throws IOException
	{
		Line classdef = lines.remove(0);
		String classname, supername;
		List<String> taggingInterfaces = new ArrayList<String>();
		if (classdef.string.contains("::"))
		{
			String[] data = classdef.string.split("::");
			assert (data.length == 2);
			classname = data[0].trim();
			supername = data[1].trim();
			if (supername.contains("+"))
			{
				String[] supersplit = supername.split("\\+");
				supername = supersplit[0].trim();
				taggingInterfaces.addAll(Arrays.asList(supersplit[1].trim().split(",")));
			}
		} else
		{
			classname = classdef.string.trim();
			supername = null;
		}

		List<String> docStrings = new ArrayList<String>();
		List<String> includeFilenames = new ArrayList<String>();
		List<String> toStringLines = null;

		Mode mode = null;
		List<Prop> props = new ArrayList<Prop>();
		while (lines.size() > 0 && lines.get(0).string.trim().length() > 0)
		{
			Line line = lines.remove(0);
			String errorPrefix = "#" + line.number + ": " + classname + ": ";
			String orig = line.string;
			String s = orig.trim();
			s = s.replaceAll("\\s", " ");
			if (s.startsWith("@"))
			{
				if (s.equals("@props"))
				{
					mode = Mode.PROP;
				} else if (s.equals("@docs"))
				{
					mode = Mode.DOC;
				} else if (s.equals("@include"))
				{
					mode = Mode.INCLUDE;
				} else if (s.equals("@toString"))
				{
					mode = Mode.TOSTRING;
				} else
				{
					throw new IllegalArgumentException(errorPrefix + "Unknown mode " + s);
				}
			} else
			{
				if (mode == Mode.PROP)
				{
					props.add(parseProp(s));
				} else if (mode == Mode.DOC)
				{
					docStrings.add(orig);
				} else if (mode == Mode.INCLUDE)
				{
					includeFilenames.add(s);
				} else if (mode == Mode.TOSTRING)
				{
					if (toStringLines == null)
					{
						toStringLines = new ArrayList<String>();
					}
					toStringLines.add(s);
				} else if (mode == null)
				{
					throw new IllegalArgumentException(errorPrefix + "Mode not set");
				} else
				{
					throw new IllegalStateException(errorPrefix + "Unknown mode " + mode);
				}
			}
		}

		ClassMode classMode = ClassMode.CONCRETE;
		if (classname.endsWith("*"))
		{
			classMode = ClassMode.ABSTRACT;
			classname = classname.substring(0, classname.length() - 1);
		} else if (classname.endsWith("+"))
		{
			classMode = ClassMode.INTERFACE;
			classname = classname.substring(0, classname.length() - 1);
		}

		StringBuilder classDocBuilder = new StringBuilder();
		if (docStrings.size() > 0)
		{
			int minIndent = Integer.MAX_VALUE;
			for (String s : docStrings)
			{
				int count = 0;
				while (count < s.length() && Character.isWhitespace(s.charAt(count)))
					count++;
				minIndent = Math.min(count, minIndent);
			}
			for (String s : docStrings)
			{
				if (classDocBuilder.length() > 0)
					classDocBuilder.append('\n');
				classDocBuilder.append(s.substring(minIndent));
			}
		}

		ClassDef def = new ClassDef(classname, supername, taggingInterfaces, props, includeFilenames, classMode,
				classDocBuilder.toString(), toStringLines, this.argMap);

		for (ClassDefHandler handler : handlers)
		{
			handler.handleDefinition(def, envMap);
		}
	}

	private Prop parseProp(String s)
	{
		boolean readOnly = false;
		boolean skipMake = false;

		s = s.trim();
		String name, type, comment;
		if (s.contains("|"))
		{
			comment = s.substring(s.lastIndexOf('|') + 1).trim();
			s = s.substring(0, s.lastIndexOf('|')).trim();
		} else
		{
			comment = null;
		}

		name = s.substring(0, s.indexOf(' ')).trim();
		type = s.substring(s.indexOf(' ')).trim();

		if (name.endsWith("*"))
		{
			name = name.substring(0, name.length() - 1);
			readOnly = true;
		} else if (name.endsWith("+"))
		{
			name = name.substring(0, name.length() - 1);
			readOnly = true;
			skipMake = true;
		}

		return new Prop(name, type, comment, readOnly, skipMake);
	}

	static enum Mode
	{
		PROP, DOC, INCLUDE, TOSTRING
	}

	static class Prop
	{
		String name;
		String type;
		String desc;
		/** If true, no setter should be generated. */
		boolean readOnly;
		/**
		 * If true, no parameter will be provided in the make call (meaning that the factory has to figure things out
		 * for itself).
		 */
		boolean skipMake;

		public Prop(String name, String type, String desc, boolean readOnly, boolean skipMake)
		{
			super();
			this.name = name;
			this.type = type;
			this.desc = desc;
			this.readOnly = readOnly;
			this.skipMake = skipMake;
		}
	}

	static enum ClassMode
	{
		CONCRETE, ABSTRACT, INTERFACE
	}

	static class ClassDef
	{
		String name;
		String sname; // superclass name
		List<String> tags; // tagging interface names
		List<Prop> props;
		List<String> includeFilenames;
		ClassMode mode;
		String classDoc;
		List<String> toStringLines;
		Map<String, String> argMap;

		public ClassDef(String name, String sname, List<String> tags, List<Prop> props, List<String> includeFilenames,
				ClassMode mode, String classDoc, List<String> toStringLines, Map<String, String> argMap)
		{
			super();
			this.name = name;
			this.sname = sname;
			this.tags = tags;
			this.props = props;
			this.includeFilenames = includeFilenames;
			this.mode = mode;
			this.classDoc = classDoc;
			this.toStringLines = toStringLines;
			this.argMap = new HashMap<String, String>(argMap);
		}

		public String getRawName()
		{
			if (name.contains("<"))
			{
				return name.substring(0, name.indexOf('<'));
			} else
			{
				return name;
			}
		}

		public String getRawSname()
		{
			if (sname == null)
				return null;
			if (sname.contains("<"))
			{
				return sname.substring(0, sname.indexOf('<'));
			} else
			{
				return sname;
			}
		}

		public String getNameParam()
		{
			if (name.contains("<"))
			{
				return name.substring(name.indexOf('<'));
			} else
			{
				return "";
			}
		}

		public String getSnameParam()
		{
			if (sname == null)
				return null;
			if (sname.contains("<"))
			{
				return sname.substring(sname.indexOf('<'));
			} else
			{
				return "";
			}
		}

		public String getNameArg()
		{
			String nameParam = getNameParam();
			if (nameParam.length() > 0)
			{
				String[] pieces = nameParam.substring(1, nameParam.length() - 1).split(",");
				StringBuilder sb = new StringBuilder("<");
				for (int i = 0; i < pieces.length; i++)
				{
					if (i > 0)
						sb.append(',');
					if (pieces[i].contains(" "))
					{
						pieces[i] = pieces[i].substring(0, pieces[i].indexOf(' ')).trim();
					}
					sb.append(pieces[i]);
				}
				sb.append(">");
				return sb.toString();
			} else
			{
				return "";
			}
		}
	}

	/* handles the definition for an AST class */
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
	private static void printParameterList(PrintStream ps, List<Prop> props)
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
	private static void printParameterList(PrintStream ps, List<Prop> props, boolean skipMake)
	{
		boolean first = true;
		ps.print("(");
		if (props.size() > 0)
		{
			ps.println();
			for (Prop p : props)
			{
				if (!p.skipMake || !skipMake)
				{
					if (!first)
					{
						ps.println(",");
					}
					first = false;

					ps.print("            " + p.type + " " + p.name);
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
	private static void printArgumentList(PrintStream ps, List<Prop> props)
	{
		printArgumentList(ps, props, false);
	}

	/**
	 * Writes a list of arguments suitable for the provided properties.
	 * 
	 * @param ps The stream to which to write the text.
	 * @param props The properties to use as arguments.
	 * @param skipMake <code>true</code> to skip properties which are excluded from the factory's make call;
	 *            <code>false</code> otherwise.
	 */
	private static void printArgumentList(PrintStream ps, List<Prop> props, boolean skipMake)
	{
		boolean first = true;
		ps.print("(");
		for (Prop p : props)
		{
			if (!p.skipMake || !skipMake)
			{
				if (!first)
				{
					ps.print(", ");
				}
				first = false;
				ps.print(p.name);
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
	static interface ClassDefHandler
	{
		public void init() throws IOException;

		public void handleDefinition(ClassDef def, Map<String, String> env) throws IOException;

		public void finish() throws IOException;
	}

	/**
	 * A module which allows the creation of AST interfaces.
	 */
	static class InterfaceWriter extends ClassHierarchyBuildingHandler
	{
		@Override
		public void useDefinition(ClassDef def) throws IOException
		{
			String pkg = envs.get(def).get("iPackage");
			if (pkg == null)
				pkg = "";
			File classFile = new File(TARGET_IFACE_DIR.getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + def.getRawName() + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);
			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			// imports
			printImports(ps, false);
			includeAllImports(ps, def.includeFilenames, "nodes" + File.separator + "interface");

			ps.println("/**");
			ps.println(" * " + def.classDoc.replaceAll("\n", "\n * "));
			ps.println(" */");

			StringBuilder extendsClause = new StringBuilder();
			if (def.sname != null)
				extendsClause.append(def.sname);
			for (String tag : def.tags)
			{
				if (extendsClause.length() > 0)
					extendsClause.append(", ");
				extendsClause.append(tag);
			}
			if (extendsClause.length() > 0)
				extendsClause.insert(0, " extends ");

			printGeneratedClause(ps);
			ps.println("public interface " + def.name + extendsClause.toString());
			ps.println("{");
			// gen getters and setters
			for (Prop p : def.props)
			{
				ps.println("    /**");
				ps.println("     * Gets " + p.desc + ".");
				ps.println("     * @return " + capFirst(p.desc) + ".");
				ps.println("     */");
				ps.println("    public " + p.type + " get" + capFirst(p.name) + "();");
				ps.println();
				if (!p.readOnly)
				{
					ps.println("    /**");
					ps.println("     * Changes " + p.desc + ".");
					ps.println("     * @param " + p.name + " " + capFirst(p.desc) + ".");
					ps.println("     */");
					ps.println("    public void set" + capFirst(p.name) + "(" + p.type + " " + p.name + ");");
					ps.println();
				}
			}

			// write deep copy interface
			ps.println("    /**");
			ps.println("     * Generates a deep copy of this node.");
			ps.println("     * @param factory The node factory to use to create the deep copy.");
			ps.println("     * @return The resulting deep copy node.");
			ps.println("     */");
			if (def.sname != null)
				ps.println("    @Override");
			ps.println("    public " + def.getRawName() + def.getNameArg() + " deepCopy(BsjNodeFactory factory);");

			// write bodies
			includeAllBodies(ps, def.includeFilenames, "nodes" + File.separator + "interface");
			ps.println("}");
		}
	}

	/**
	 * Contains some handy utilities.
	 * 
	 * @author Zachary Palmer
	 */
	static abstract class AbstractClassDefHandler implements ClassDefHandler
	{
		/**
		 * Creates a templated output file for a handler.
		 * 
		 * @param pkg The package for this file.
		 * @param mode The mode for this file: concrete class, abstract class, or interface.
		 * @param implementation <code>true</code> if this is an implementation class; <code>false</code> if it's an
		 *            interface class.
		 * @param type The name of the type. No extension is permitted; type arguments are allowed.
		 * @param includes <code>true</code> if a supplemental include file should be expected.
		 * @param extendsName The type to extend or <code>null</code> for no extends clause.
		 * @param implementsNames The types to implement or an empty array for no implements clause.
		 * @return The print stream writing to that file. The body will be written and ready to be closed with a
		 *         <code>}</code>.
		 * @throws IOException If an I/O error occurs.
		 */
		protected PrintStream createOutputFile(String pkg, ClassMode mode, boolean implementation, String type,
				boolean includes, String extendsName, String... implementsNames) throws IOException
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
			PrintStream ret = new PrintStream(new FileOutputStream(f));
			ret.println("package " + pkg + ";");
			ret.println();
			printImports(ret, implementation);
			if (includes)
			{
				includeAllImports(ret, Collections.singleton(name), implementation ? "implementation" : "interface");
			}
			printGeneratedClause(ret);
			ret.print("public ");
			if (mode == ClassMode.CONCRETE)
			{
				ret.print("class");
			} else if (mode == ClassMode.ABSTRACT)
			{
				ret.print("abstract class");
			} else if (mode == ClassMode.INTERFACE)
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

	static abstract class ClassHierarchyBuildingHandler extends AbstractClassDefHandler
	{
		protected Map<String, ClassDef> map;
		protected Map<ClassDef, Map<String, String>> envs;

		public void init() throws IOException
		{
			map = new HashMap<String, ClassDef>();
			envs = new HashMap<ClassDef, Map<String, String>>();
		}

		public void handleDefinition(ClassDef def, Map<String, String> env) throws IOException
		{
			map.put(def.getRawName(), def);
			envs.put(def, new HashMap<String, String>(env));
		}

		public void finish() throws IOException
		{
			for (ClassDef def : map.values())
			{
				useDefinition(def);
			}
		}

		protected boolean defInstanceOf(ClassDef def, String classname)
		{
			while (def != null)
			{
				if (def.getRawName().equals(classname))
					return true;
				def = map.get(def.getRawSname());
			}
			return false;
		}

		protected boolean propInstanceOf(String propType, String classname)
		{
			if (propType.contains("<"))
				propType = propType.substring(0, propType.indexOf('<')).trim();
			return defInstanceOf(map.get(propType), classname);
		}

		protected List<Prop> getRecursiveProps(ClassDef def)
		{
			List<Prop> list = new ArrayList<Prop>();
			// maps type parameter names to their values
			Map<String, String> replacementMap = new HashMap<String, String>();
			while (def != null)
			{
				for (Prop p : def.props)
				{
					if (replacementMap.containsKey(p.type))
					{
						p = new Prop(p.name, replacementMap.get(p.type), p.desc, p.readOnly, p.skipMake);
					}
					list.add(p);
				}

				if (def.getSnameParam() == null || def.getSnameParam().length() == 0)
				{
					def = map.get(def.getRawSname());
				} else
				{
					String superparam = def.getSnameParam();
					superparam = superparam.substring(1, superparam.length() - 1);
					def = map.get(def.getRawSname());

					String nameParamPart = def.getNameParam().substring(1, def.getNameParam().length() - 1);
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

		public abstract void useDefinition(ClassDef def) throws IOException;

		protected void propAbstract(PropertyTypeAbstractor abstractor, Prop p, PrintStream ps, ClassDef def)
		{
			if (DIRECT_COPY_NAMES.contains(p.type))
			{
				abstractor.directCopy(ps, p);
			} else if (propInstanceOf(p.type, "Node"))
			{
				abstractor.node(ps, p);
			} else if (CONSTRUCTOR_COPY_NAMES.contains(p.type))
			{
				abstractor.constructorCopy(ps, p);
			} else if (p.type.startsWith("List<"))
			{
				abstractor.list(ps, p);
			} else if (p.type.equals("Void"))
			{
				abstractor.voidType(ps, p);
			} else
			{
				throw new IllegalStateException("Don't know how to handle a value of type " + p.type
						+ " for definition " + def.name);
			}
		}

		static interface PropertyTypeAbstractor
		{
			void directCopy(PrintStream ps, Prop p);

			void node(PrintStream ps, Prop p);

			void constructorCopy(PrintStream ps, Prop p);

			void list(PrintStream ps, Prop p);

			void voidType(PrintStream ps, Prop p);
		}
	}

	/**
	 * A module which creates AST backing classes.
	 */
	static class BackingClassWriter extends ClassHierarchyBuildingHandler
	{
		public void useDefinition(ClassDef def) throws IOException
		{
			if (def.mode == ClassMode.INTERFACE)
			{
				return;
			}

			String rawclassname = def.getRawName() + "Impl";
			String classname = rawclassname + def.getNameParam();
			String superclassname = def.getRawSname() + "Impl" + def.getSnameParam();

			String stopGenStr = envs.get(def).get("stopGen");
			if (stopGenStr == null)
				stopGenStr = "";
			Set<String> stopGen = new HashSet<String>(Arrays.asList(stopGenStr.split(",")));

			String pkg = envs.get(def).get("cPackage");
			if (pkg == null)
				pkg = "";
			File classFile = new File(TARGET_IMPL_DIR.getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + rawclassname + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);

			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			printImports(ps, true);
			includeAllImports(ps, def.includeFilenames, "nodes" + File.separator + "implementation");

			printGeneratedClause(ps);
			ps.println("public " + (def.mode == ClassMode.CONCRETE ? "" : "abstract ") + "class " + classname
					+ (def.sname == null ? "" : " extends " + superclassname) + " implements " + def.getRawName()
					+ def.getNameArg());
			ps.println("{");

			// gen properties
			for (Prop p : def.props)
			{
				ps.println("    /** " + capFirst(p.desc) + ". */");
				ps.println("    private " + p.type + " " + p.name + ";");
				ps.println();
			}

			// gen constructor
			ps.println("    /** General constructor. */");
			if (stopGen.contains("cons"))
				ps.println("/* // stopGen=" + stopGenStr); // stopGen logic
			ps.print("    " + (def.mode == ClassMode.CONCRETE ? "public" : "protected") + " " + rawclassname);
			List<Prop> recProps = getRecursiveProps(def);
			printParameterList(ps, recProps);
			ps.println();
			ps.println("    {");
			ps.print("        super");
			List<Prop> superProps = new ArrayList<Prop>(recProps);
			superProps.removeAll(def.props);
			printArgumentList(ps, superProps);
			ps.println(";");
			for (Prop p : def.props)
			{
				ps.println("        this." + p.name + " = " + p.name + ";");
			}
			ps.println("    }");
			if (stopGen.contains("cons"))
				ps.print("*/"); // stopGen logic
			ps.println();

			// gen getters and setters
			for (Prop p : def.props)
			{
				ps.println("    /**");
				ps.println("     * Gets " + p.desc + ".");
				ps.println("     * @return " + capFirst(p.desc) + ".");
				ps.println("     */");
				ps.println("    public " + p.type + " get" + capFirst(p.name) + "()");
				ps.println("    {");
				ps.println("        return this." + p.name + ";");
				ps.println("    }");
				ps.println();
				if (!p.readOnly)
				{
					ps.println("    /**");
					ps.println("     * Changes " + p.desc + ".");
					ps.println("     * @param " + p.name + " " + capFirst(p.desc) + ".");
					ps.println("     */");
					ps.println("    public void set" + capFirst(p.name) + "(" + p.type + " " + p.name + ")");
					ps.println("    {");
					if (propInstanceOf(p.type, "Node"))
					{
						ps.println("        if (this." + p.name + " instanceof NodeImpl)");
						ps.println("        {");
						ps.println("            ((NodeImpl)this." + p.name + ").setParent(null);");
						ps.println("        }");
					}
					ps.println("        this." + p.name + " = " + p.name + ";");
					if (propInstanceOf(p.type, "Node"))
					{
						ps.println("        if (this." + p.name + " instanceof NodeImpl)");
						ps.println("        {");
						ps.println("            ((NodeImpl)this." + p.name + ").setParent(this);");
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
			if (def.sname != null)
			{
				ps.println("    @Override");
			}
			ps.println("    protected void receiveToChildren(BsjNodeVisitor visitor)");
			ps.println("    {");
			if (def.sname != null)
			{
				ps.println("        super.receiveToChildren(visitor);");
			}
			for (Prop p : def.props)
			{
				if (propInstanceOf(p.type, "Node"))
				{
					ps.println("        this." + p.name + ".receive(visitor);");
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
			if (def.sname != null)
			{
				ps.println("    @Override");
			}
			ps.println("    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)");
			ps.println("    {");
			if (def.sname != null)
			{
				ps.println("        super.receiveTypedToChildren(visitor);");
			}
			for (Prop p : def.props)
			{
				if (propInstanceOf(p.type, "Node"))
				{
					ps.println("        this." + p.name + ".receiveTyped(visitor);");
				}
			}
			ps.println("    }");
			ps.println();
			if (def.sname != null)
			{
				ps.println("    @Override");
			}
			ps.println("    public void receiveTyped(BsjTypedNodeVisitor visitor)");
			ps.println("    {");
			ps.println("        visitor.visitStartBegin(this);");
			ClassDef cur = def;
			List<ClassDef> backtrack = new LinkedList<ClassDef>();
			while (cur != null)
			{
				ps.print("        visitor.visit" + cur.getRawName() + "Start(this");
				if (cur.mode == ClassMode.CONCRETE)
				{
					ps.print(", ");
					ps.print(String.valueOf(cur == def));
				}
				ps.println(");");
				backtrack.add(0, cur);
				cur = this.map.get(cur.getRawSname());
			}
			for (String tag : def.tags)
			{
				ps.println("        visitor.visit" + tag.trim() + "Start(this);");
			}
			ps.println("        visitor.visitStartEnd(this);");
			ps.println("        receiveTypedToChildren(visitor);");
			ps.println("        visitor.visitStopBegin(this);");
			for (String tag : def.tags)
			{
				ps.println("        visitor.visit" + tag.trim() + "Stop(this);");
			}
			for (ClassDef edef : backtrack)
			{
				ps.print("        visitor.visit" + edef.getRawName() + "Start(this");
				if (edef.mode == ClassMode.CONCRETE)
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
			if (stopGen.contains("children"))
				ps.println("/* // stopGen=" + stopGenStr); // stopGen logic
			if (def.sname != null)
			{
				ps.println("    @Override");
			}
			ps.println("    public List<Object> getChildObjects()");
			ps.println("    {");
			ps.println("        List<Object> list = "
					+ (def.sname == null ? "new ArrayList<Object>();" : "super.getChildObjects();"));
			for (Prop p : def.props)
			{
				ps.println("        list.add(get" + Character.toUpperCase(p.name.charAt(0)) + p.name.substring(1)
						+ "());");
			}
			ps.println("        return list;");
			ps.println("    }");
			if (stopGen.contains("children"))
				ps.print("*/"); // stopGen logic
			ps.println();

			// add logic for toString
			ps.println("    /**");
			ps.println("     * Obtains a human-readable description of this node.");
			ps.println("     * @return A human-readable description of this node.");
			ps.println("     */");
			ps.println("    public String toString()");
			ps.println("    {");
			ps.println("        StringBuilder sb = new StringBuilder();");
			if (def.toStringLines == null)
			{
				ps.println("        sb.append(this.getClass().getSimpleName());");
				ps.println("        sb.append('[');");
				boolean firstProp = true;
				for (Prop p : recProps)
				{
					if (firstProp)
					{
						firstProp = false;
					} else
					{
						ps.println("        sb.append(',');");
					}
					String capName = Character.toUpperCase(p.name.charAt(0)) + p.name.substring(1);
					ps.println("        sb.append(\"" + p.name + "=\");");
					if (propInstanceOf(p.type, "Node"))
					{
						ps.println("        sb.append(this.get" + capName + "() == null? \"null\" : this.get" + capName
								+ "().getClass().getSimpleName());");
					} else
					{
						String typeString;
						if (PRIMITIVE_TYPES.contains(p.type))
						{
							typeString = "\"" + p.type + "\"";
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
				for (String toStringLine : def.toStringLines)
				{
					ps.println("        " + toStringLine);
				}
			}
			ps.println("        return sb.toString();");
			ps.println("    }");
			ps.println();

			// add node operation implementation
			if (def.mode == ClassMode.CONCRETE)
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
				ps.println("        return operation.execute" + def.getRawName() + "(this, p);");
				ps.println("    }");
			}
			ps.println();

			// add deep copy implementation
			if (def.mode == ClassMode.CONCRETE)
			{
				ps.println("    /**");
				ps.println("     * Generates a deep copy of this node.");
				ps.println("     * @param factory The node factory to use to create the deep copy.");
				ps.println("     * @return The resulting deep copy node.");
				ps.println("     */");
				if (def.sname != null)
					ps.println("    @Override");
				ps.println("    public " + def.getRawName() + def.getNameArg() + " deepCopy(BsjNodeFactory factory)");
				ps.println("    {");
				ps.println("        return factory.make" + def.getRawName() + "(");
				boolean first = true;
				for (Prop p : recProps)
				{
					if (p.skipMake)
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
						public void directCopy(PrintStream ps, Prop p)
						{
							ps.print("get" + capFirst(p.name) + "()");
						}

						public void node(PrintStream ps, Prop p)
						{
							ps.print("get" + capFirst(p.name) + "().deepCopy(factory)");
						}

						public void constructorCopy(PrintStream ps, Prop p)
						{
							ps.print("new " + p.type + "(get" + capFirst(p.name) + "())");
						}

						public void list(PrintStream ps, Prop p)
						{
							ps.print("new Array" + p.type + "(get" + capFirst(p.name) + "())");
						}

						public void voidType(PrintStream ps, Prop p)
						{
							ps.print("null");
						}
					}, p, ps, def);
				}
				ps.println(");");
				ps.println("    }");
			}

			// add supplements
			includeAllBodies(ps, def.includeFilenames, "nodes" + File.separator + "implementation");

			ps.println("}");
		}
	}

	/**
	 * Writes the BsjTypedNodeVisitor interface.
	 */
	static class BsjTypedNodeVisitorWriter extends AbstractClassDefHandler
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
		public void handleDefinition(ClassDef def, Map<String, String> env) throws IOException
		{
			String tname = def.getRawName();
			String sname = def.getRawSname();

			if (def.getNameParam().length() > 0)
				parameterizedTypes.add(tname);

			if (!subtypeMap.containsKey(sname))
				subtypeMap.put(sname, new HashSet<String>());
			subtypeMap.get(sname).add(tname);
			supertypeMap.put(tname, sname);
			if (def.mode != ClassMode.CONCRETE)
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
			PrintStream ps = createOutputFile("edu.jhu.cs.bsj.compiler.ast", ClassMode.INTERFACE, false,
					"BsjTypedNodeVisitor", true, null);
			writeTypeBody(ps, false, sortedNames, concreteTypeNameSet);
			ps.println("}");
			ps.close();

			// Write default implementation
			ps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", ClassMode.CONCRETE, false,
					"BsjTypedNodeNoOpVisitor", true, null, "BsjTypedNodeVisitor");
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

			this.ips = createOutputFile("edu.jhu.cs.bsj.compiler.ast", ClassMode.INTERFACE, false, "BsjNodeFactory",
					true, null);
			this.cps = createOutputFile("edu.jhu.cs.bsj.compiler.impl.ast", ClassMode.CONCRETE, true,
					"BsjNodeFactoryImpl", true, null, "BsjNodeFactory");
			this.dps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", ClassMode.ABSTRACT, false,
					"BsjNodeFactoryDecorator", true, null, "BsjNodeFactory");
		}

		@Override
		public void useDefinition(ClassDef def) throws IOException
		{
			if (def.mode == ClassMode.CONCRETE)
			{
				List<Prop> recProps = getRecursiveProps(def);
				String typeParam;
				String typeName;
				String typeArg;
				if (def.getNameParam().length() > 0)
				{
					typeParam = def.getNameParam();
					String[] args = typeParam.substring(1, typeParam.length() - 1).split(",");
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
				typeName = def.getRawName() + typeArg;
				String typeParamS = typeParam == null ? "" : (typeParam + " ");

				// Write interface method description
				ips.println("    /**");
				ips.println("     * Creates a " + def.getRawName() + ".");
				ips.println("     */");
				ips.print("    public " + typeParamS + typeName + " make" + def.getRawName());
				printParameterList(ips, recProps, true);
				ips.println(";");
				ips.println();

				// Write backing class implementation
				cps.println("    /**");
				cps.println("     * Creates a " + def.getRawName() + ".");
				cps.println("     */");
				cps.println("    @Override");
				cps.print("    public " + typeParamS + typeName + " make" + def.getRawName());
				printParameterList(cps, recProps, true);
				cps.println();
				cps.println("    {");
				String classname = def.getRawName() + "Impl" + typeArg;
				cps.print("        " + typeName + " ret = new " + classname);

				// print constructor arguments - this is special because of the argMap
				cps.print('(');
				boolean first = true;
				for (Prop p : recProps)
				{
					if (first)
					{
						first = false;
					} else
					{
						cps.print(", ");
					}
					String override = "";
					if (def.argMap.containsKey(p.name))
					{
						override = def.argMap.get(p.name).trim();
					}
					if (override.length() > 0)
					{
						cps.print(override);
					} else
					{
						cps.print(p.name);
					}
				}
				cps.print(')');

				cps.println(";");
				// TODO: later, this is where we register created nodes with the central dependency validation authority
				cps.println("        return ret;");
				cps.println("    }");
				cps.println();

				// Write decorator implementation
				dps.println("    /**");
				dps.println("     * Creates a " + def.getRawName() + ".");
				dps.println("     */");
				dps.println("    @Override");
				dps.print("    public " + typeParamS + typeName + " make" + def.getRawName());
				printParameterList(dps, recProps, true);
				dps.println();
				dps.println("    {");
				dps.println("        this.before();");
				dps.print("        " + typeName + " node = factory.make" + def.getRawName());
				printArgumentList(dps, recProps, true);
				dps.println(";");
				dps.println("        this.after(node);");
				dps.println("        return node;");
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

			cps.println("}");
			cps.close();

			dps.println("}");
			dps.close();
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

		@Override
		public void init() throws IOException
		{
			super.init();

			ips = createOutputFile("edu.jhu.cs.bsj.compiler.ast", ClassMode.INTERFACE, false, "BsjNodeOperation<P,R>",
					true, null);
			nps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", ClassMode.CONCRETE, false,
					"BsjNodeNoOpOperation<P,R>", true, null, "BsjNodeOperation<P,R>");
			pps = createOutputFile("edu.jhu.cs.bsj.compiler.ast.util", ClassMode.ABSTRACT, false,
					"BsjNodeOperationProxy<POrig,ROrig,PNew,RNew>", true, null, "BsjNodeOperation<PNew,RNew>");
		}

		@Override
		public void useDefinition(ClassDef def) throws IOException
		{
			if (def.mode == ClassMode.CONCRETE)
			{
				String typeParam;
				String typeName;
				String typeArg;
				if (def.getNameParam().length() > 0)
				{
					typeParam = def.getNameParam();
					String[] args = typeParam.substring(1, typeParam.length() - 1).split(",");
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
				typeName = def.getRawName() + typeArg;
				String typeParamS = typeParam == null ? "" : (typeParam + " ");

				ips.println("    /**");
				ips.println("     * Executes this operation against a " + def.getRawName() + ".");
				ips.println("     * @param node The " + def.getRawName() + " in question.");
				ips.println("     * @param p The parameter to use.");
				ips.println("     * @return The result of the operation.");
				ips.println("     */");
				ips.println("    public " + typeParamS + "R execute" + def.getRawName() + "(" + typeName
						+ " node, P p);");
				ips.println();

				nps.println("    /**");
				nps.println("     * Performs no operation.");
				nps.println("     * @param node Ignored.");
				nps.println("     * @param p Ignored.");
				nps.println("     * @return <code>null</code>, always.");
				nps.println("     */");
				nps.println("    public " + typeParamS + "R execute" + def.getRawName() + "(" + typeName
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
				pps.println("    public " + typeParamS + "RNew execute" + def.getRawName() + "(" + typeName
						+ " node, PNew p)");
				pps.println("    {");
				pps.println("        POrig porig = before(p);");
				pps.println("        ROrig rorig = this.backingOp.execute" + def.getRawName() + "(node, porig);");
				pps.println("        return after(rorig);");
				pps.println("    }");
				pps.println();
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
		}
	}

	/**
	 * Writes the BSJ tree lifter class.
	 */
	static class TreeLifterWriter extends ClassHierarchyBuildingHandler
	{
		/** The stream to which the file's content is written. */
		private PrintStream ps;

		@Override
		public void init() throws IOException
		{
			super.init();
			ps = createOutputFile("edu.jhu.cs.bsj.compiler.impl.tool.compiler", ClassMode.CONCRETE, true,
					"BsjTreeLifter", true, null,
					"BsjNodeOperation<Pair<ExpressionNode,List<BlockStatementNode>>,String>");
			ps.println("    private BsjNodeFactory factory;");
			ps.println();
			ps.println("    public BsjTreeLifter(BsjNodeFactory factory)");
			ps.println("    {");
			ps.println("        this.factory = factory;");
			ps.println("    }");
			ps.println();
			for (String ptype : PRIMITIVE_TYPES)
			{
				if (ptype.equals("short") || ptype.equals("byte"))
					continue;
				ps.println("    protected ExpressionNode expressionize" + capFirst(ptype) + "(" + ptype + " x)");
				ps.println("    {");
				ps.println("        return factory.make" + capFirst(ptype) + "LiteralNode(x);");
				ps.println("    }");
				ps.println();
			}
			for (String etype : ENUM_TYPES)
			{
				ps.println("    protected ExpressionNode expressionize" + etype + "(" + etype + " x)");
				ps.println("    {");
				ps.println("        return factory.makeFieldAccessByNameNode(factory.makeQualifiedNameNode(");
				ps.println("                factory.makeSimpleNameNode(");
				ps.println("                        factory.makeIdentifierNode(\"" + etype + "\"),");
				ps.println("                        NameCategory.EXPRESSION");
				ps.println("                        ),");
				ps.println("                factory.makeIdentifierNode(x.name()),");
				ps.println("                NameCategory.EXPRESSION));");
				ps.println("    }");
				ps.println();
			}
		}

		@Override
		public void useDefinition(ClassDef def) throws IOException
		{
			List<Prop> recProp = this.getRecursiveProps(def);
			if (def.mode != ClassMode.CONCRETE)
				return;
			// TODO: preserve start/stop location in the META world!

			ps.println("    @Override");
			String typeargString = "";
			if (def.getNameParam().length() > 0)
				typeargString = def.getNameParam() + " ";
			ps.println("    public " + typeargString + "String execute" + def.getRawName() + "(" + def.getRawName()
					+ def.getNameArg() + " node, Pair<ExpressionNode,List<BlockStatementNode>> p)");
			ps.println("    {");
			ps.println("        ExpressionNode factoryNode = p.getFirst();");
			ps.println("        List<BlockStatementNode> statements = p.getSecond();");
			ps.println();
			for (Prop p : recProp)
			{
				if (p.skipMake)
					continue;

				propAbstract(new PropertyTypeAbstractor()
				{
					public void voidType(PrintStream ps, Prop p)
					{
						// Intentionally doing nothing. We'll just use "null" below.
					}

					public void node(PrintStream ps, Prop p)
					{
						ps.println("        String lift" + capFirst(p.name) + "VarName = ");
						ps.println("                node.get" + capFirst(p.name) + "() != null ?");
						ps.println("                node.get" + capFirst(p.name) + "().executeOperation(this,p) :");
						ps.println("                null;");
					}

					public void list(PrintStream ps, Prop p)
					{
						ps.println("        // TODO: " + p.name);
					}

					public void directCopy(PrintStream ps, Prop p)
					{
						ps.println("        " + p.type + " lift" + capFirst(p.name) + "Value = ");
						ps.println("                node.get" + capFirst(p.name) + "();");
					}

					public void constructorCopy(PrintStream ps, Prop p)
					{
						ps.println("        // TODO: " + p.name);
					}
				}, p, ps, def);
			}
			ps.println();
			ps.println("        String myVarName = getUniqueName();");
			ps.println("        statements.add(");
			ps.println("                factory.makeVariableDeclarationNode(");
			ps.println("                        factory.makeVariableModifiersNode(");
			ps.println("                                false,");
			ps.println("                                factory.makeListNode(Collections.<AnnotationNode>emptyList())),");
			ps.println("                factory.makeListNode(");
			ps.println("                        Collections.singletonList(");
			ps.println("                                factory.makeVariableDeclaratorNode(");
			if (def.getNameArg().length() > 0)
			{
				ps.println("                                    factory.makeParameterizedTypeNode(");
			}
			ps.println("                                        factory.makeUnparameterizedTypeNode(");
			ps.println("                                                factory.makeSimpleNameNode(");
			ps.println("                                                        factory.makeIdentifierNode(\""
					+ def.getRawName() + "\"),");
			ps.println("                                                        NameCategory.TYPE)),");
			if (def.getNameArg().length() > 0)
			{
				// TODO: fix this assumption: nodes only have one type parameter on them
				ps.println("                                        factory.makeListNode(");
				ps.println("                                            Arrays.<TypeArgumentNode>asList(");
				ps.println("                                                factory.makeUnparameterizedTypeNode(");
				ps.println("                                                        factory.makeSimpleNameNode(");
				ps.println("                                                                factory.makeIdentifierNode(");
				ps.println("                                                                        \"" + def.getNameArg().substring(1,def.getNameArg().length()-1) + "\"");
				ps.println("                                                                ),");
				ps.println("                                                                NameCategory.TYPE");
				ps.println("                                                        )");
				ps.println("                                                )");
				ps.println("                                            )");
				ps.println("                                        )");
				ps.println("                                    ),");
			}
			ps.println("                                        factory.makeIdentifierNode(myVarName),");
			ps.println("                                        factory.makeMethodInvocationByExpressionNode(");
			ps.println("                                                factory.makeParenthesizedExpressionNode(factoryNode.deepCopy(factory)),");
			ps.println("                                                factory.makeIdentifierNode(\"make"
					+ def.getRawName() + "\"),");
			ps.println("                                                factory.makeListNode(");
			ps.print("                                                        Arrays.<ExpressionNode>asList(");
			boolean first = true;
			for (Prop p : recProp)
			{
				if (p.skipMake)
					continue;
				if (first)
				{
					first = false;
				} else
				{
					ps.print(",");
				}
				ps.println();
				ps.print("                                                                ");
				propAbstract(new PropertyTypeAbstractor()
				{
					public void voidType(PrintStream ps, Prop p)
					{
						ps.print("factory.makeNullLiteralNode(null)");
					}

					public void node(PrintStream ps, Prop p)
					{
						String varNameName = "lift" + capFirst(p.name) + "VarName";
						ps.println(varNameName + " != null ? ");
						ps.print("                                                                        ");
						ps.println("factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode(");
						ps.print("                                                                                ");
						ps.print("lift" + capFirst(p.name) + "VarName),NameCategory.EXPRESSION");
						ps.print(")) : factory.makeNullLiteralNode(null)");
					}

					public void list(PrintStream ps, Prop p)
					{
						ps.print("/* TODO */ factory.makeBooleanLiteralNode(true)");
					}

					public void directCopy(PrintStream ps, Prop p)
					{
						ps.print("expressionize" + capFirst(p.type) + "(lift" + capFirst(p.name) + "Value)");
					}

					public void constructorCopy(PrintStream ps, Prop p)
					{
						ps.println("        // TODO: " + p.name);
					}
				}, p, ps, def);
			}
			ps.println();
			ps.println("                                                                )),");
			ps.println("                                                factory.makeListNode(Collections.<TypeNode>emptyList()))");
			ps.println("            )))));");
			ps.println();
			ps.println("        return myVarName;");
			ps.println("    }");
			ps.println();

		}

		@Override
		public void finish() throws IOException
		{
			super.finish();
			ps.println("}");
			ps.close();
		}

	}
}
