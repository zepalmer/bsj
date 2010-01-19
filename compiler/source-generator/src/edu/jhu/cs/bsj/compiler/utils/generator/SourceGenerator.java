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
	private static final File CONTENTS_FILE = new File("data/srcgen/ast-contents.dat");
	private static final File SUPPLEMENTS_DIR = new File("data/srcgen/supplement/");
	private static final File TARGET_DIR = new File("out/");
	private static final String[] IFACE_IMPORTS = { "edu.jhu.cs.bsj.compiler.ast.*",
			"edu.jhu.cs.bsj.compiler.ast.node.*", "edu.jhu.cs.bsj.compiler.ast.node.meta.*", "java.util.*",
			"javax.annotation.Generated"};
	private static final String[] CLASS_IMPORTS = { "edu.jhu.cs.bsj.compiler.impl.ast.*",
			"edu.jhu.cs.bsj.compiler.impl.ast.node.*", "edu.jhu.cs.bsj.compiler.impl.ast.node.meta.*",
			"javax.annotation.Generated"};
	private static final Set<String> PRIMITIVE_TYPES = new HashSet<String>(Arrays.asList(new String[] { "int", "long",
			"boolean", "float", "double", "short", "byte", "char" }));

	private Set<ClassDefHandler> handlers = new HashSet<ClassDefHandler>();
	private Map<String, String> envMap = new HashMap<String, String>();

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
		public int number;

		public Line(String string, int number)
		{
			super();
			this.string = string;
			this.number = number;
		}

		public static List<Line> number(List<String> list)
		{
			List<Line> ret = new ArrayList<Line>();
			int n = 0;
			for (String s : list)
			{
				ret.add(new Line(s, ++n));
			}
			return ret;
		}
	}

	public void run() throws IOException
	{
		// Clear the target directory
		rmrf(TARGET_DIR);

		// Initialize each handler
		for (ClassDefHandler handler : handlers)
			handler.init();

		// Obtain the contents file
		TARGET_DIR.mkdirs();
		String contents = getFileAsString(CONTENTS_FILE);
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
					if (index == 0 || s.charAt(index-1) != '&')
					{
						s = s.substring(0, s.indexOf("#"));
						strings.set(i, s);
						break;
					}
					index = s.indexOf('#', index+1);
				}
			}
		}

		List<Line> lines = Line.number(strings);

		// Process the contents file
		lines = new LinkedList<Line>(lines);

		process(lines);

		// Finish each handler
		for (ClassDefHandler handler : handlers)
			handler.finish();
	}

	private void process(List<Line> lines) throws IOException
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
					String[] pieces = arg.split("=");
					if ((pieces.length == 1) && (arg.endsWith("=")))
					{
						pieces = new String[] { pieces[0], "" };
					}
					if (pieces.length != 2)
					{
						throw new IllegalArgumentException("Malformed set command " + command);
					}
					envMap.put(pieces[0], pieces[1]);
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
				classDocBuilder.toString(), toStringLines);

		for (ClassDefHandler handler : handlers)
		{
			handler.handleDefinition(def, envMap);
		}
	}

	private Prop parseProp(String s)
	{
		boolean readOnly = false;

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
		}

		return new Prop(name, type, comment, readOnly);
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
		boolean readOnly;

		public Prop(String name, String type, String desc, boolean readOnly)
		{
			super();
			this.name = name;
			this.type = type;
			this.desc = desc;
			this.readOnly = readOnly;
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

		public ClassDef(String name, String sname, List<String> tags, List<Prop> props, List<String> includeFilenames,
				ClassMode mode, String classDoc, List<String> toStringLines)
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
		includeFileParts(f, ps, "importstart", "importstop");
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
		boolean first = true;
		ps.print("(");
		if (props.size() > 0)
		{
			ps.println();
			for (Prop p : props)
			{
				if (!first)
				{
					ps.println(",");
				}
				first = false;

				ps.print("            " + p.type + " " + p.name);
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
		boolean first = true;
		ps.print("(");
		for (Prop p : props)
		{
			if (!first)
			{
				ps.print(", ");
			}
			first = false;
			ps.print(p.name);
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
	 * @param ps The print stream to which to write the annotation.
	 */
	private static void printGeneratedClause(PrintStream ps)
	{
		ps.println("@Generated(value={\"" + SourceGenerator.class.getName()+ "\"})");
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
	static class InterfaceWriter implements ClassDefHandler
	{
		private static File ifaceTargetDir = new File(TARGET_DIR.getAbsolutePath() + File.separator + "ifaces");

		public void init()
		{
		}

		public void handleDefinition(ClassDef def, Map<String, String> env) throws IOException
		{
			String pkg = env.get("iPackage");
			if (pkg == null)
				pkg = "";
			File classFile = new File(ifaceTargetDir.getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + def.getRawName() + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);
			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			// imports
			printImports(ps, false);
			includeAllImports(ps, def.includeFilenames, "ifaces");

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

			includeAllBodies(ps, def.includeFilenames, "ifaces");
			ps.println("}");
		}

		public void finish()
		{
		}
	}

	static abstract class ClassHierarchyBuildingHandler implements ClassDefHandler
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
						p = new Prop(p.name, replacementMap.get(p.type), p.desc, p.readOnly);
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

	}

	/**
	 * A module which creates AST backing classes.
	 */
	static class BackingClassWriter extends ClassHierarchyBuildingHandler
	{
		private static File classTargetDir = new File(TARGET_DIR.getAbsolutePath() + File.separator + "classes");

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
			File classFile = new File(classTargetDir.getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + rawclassname + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);

			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");

			printImports(ps, true);
			includeAllImports(ps, def.includeFilenames, "classes");

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
					ps.print(String.valueOf(cur==def));
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
					ps.print(String.valueOf(edef==def));
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
			for (Prop p : recProps)
			{
				ps.println("        list.add(get" + Character.toUpperCase(p.name.charAt(0)) + p.name.substring(1) +
						"());");
			}
			ps.println("        return list;");
			ps.println("    }");
			if (stopGen.contains("children"))
				ps.print("*/"); // stopGen logic
			ps.println();

			// add logic for toString
			// TODO: this only uses immediate properties - we need to include properties for superclasses as well
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
				for (Prop p : def.props)
				{
					if (firstProp)
					{
						firstProp = false;
					} else
					{
						ps.println("        sb.append(',');");
					}
					ps.println("        sb.append(\"" + p.name + "=\");");
					if (propInstanceOf(p.type, "Node"))
					{
						ps.println("        sb.append(this." + p.name + " == null? \"null\" : this." + p.name
								+ ".getClass().getSimpleName());");
					} else
					{
						ps.println("        sb.append(String.valueOf(this."
								+ p.name
								+ ") + \":\" + "
								+ ((PRIMITIVE_TYPES.contains(p.type)) ? "\"" + p.type + "\"" : "this." + p.name
										+ ".getClass().getSimpleName()") + ");");
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
				ps.println("    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)");
				ps.println("    {");
				ps.println("        return operation.execute" + def.getRawName() + "(this, p);");
				ps.println("    }");
			}

			// add supplements
			includeAllBodies(ps, def.includeFilenames, "classes");

			ps.println("}");
		}
	}

	/**
	 * Writes the BsjTypedNodeVisitor interface.
	 */
	static class BsjTypedNodeVisitorWriter implements ClassDefHandler
	{
		private Map<String, Set<String>> subtypeMap;
		private Map<String, String> supertypeMap;
		private List<String> abstractTypes;
		private Set<String> parameterizedTypes;
		private static final String[] MODES = {"Start","Stop"};

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
			String pkg = "edu.jhu.cs.bsj.compiler.ast";
			PrintStream ps;
			ps = new PrintStream(new FileOutputStream(new File(TARGET_DIR.getPath() + File.separator + "ifaces"
					+ File.separator + pkg.replaceAll("\\.", File.separator) + File.separator
					+ "BsjTypedNodeVisitor.java")));
			ps.println("package " + pkg + ";");
			ps.println();
			printImports(ps, false);
			ps.println("/**");
			ps.println(" * This interface is implemented by those classes which wish to perform visitation operations");
			ps.println(" * over a BSJ AST.  Each node visits a method for its own class as well as all of its");
			ps.println(" * superclasses in order from most specific type to least specific type (when the visit");
			ps.println(" * starts) or from least specific type to most specific type (when the visit ends).  Each");
			ps.println(" * method representing a concrete type also accepts a boolean argument from the node");
			ps.println(" * indicating whether or not that type is the most specific type for that node.  A method is");
			ps.println(" * also called (after or before the previous calls for start and stop, respectively) for each");
			ps.println(" * interface the node implements.  Finally, each node's sequence of starting calls begins");
			ps.println(" * with a call to <tt>visitStartBegin</tt> and ends with a call to <tt>visitStartEnd</tt>;");
			ps.println(" * likewise, each sequence of ending calls begins with a call to <tt>visitStopBegin</tt> and");
			ps.println(" * ends with a call to <tt>visitStopEnd</tt>.");
			ps.println(" * <p/>");
			ps.println(" * For example, imagine a simple type hierarchy in which <tt>C</tt> extends from <tt>B</tt>");
			ps.println(" * and <tt>B</tt> extends from <tt>A</tt>.  Assume that <tt>C</tt> and <tt>B</tt> are");
			ps.println(" * concrete classes while <tt>A</tt> is not.  In that case, the following sequence of methods");
			ps.println(" * would be called if an instance this visitor interface were to visit an instance of node");
			ps.println(" * <tt>C</tt>:");
			ps.println(" * <ul>");
			ps.println(" * <li><tt>visitStartBegin(node)</tt></li>");
			ps.println(" * <li><tt>visitCStart(node,true)</tt></li>");
			ps.println(" * <li><tt>visitBStart(node,false)</tt></li>");
			ps.println(" * <li><tt>visitAStart(node)</tt></li>");
			ps.println(" * <li><tt>visitStartEnd(node)</tt></li>");
			ps.println(" * <li><tt>visitStopBegin(node)</tt></li>");
			ps.println(" * <li><tt>visitAStop(node)</tt></li>");
			ps.println(" * <li><tt>visitBStop(node,false)</tt></li>");
			ps.println(" * <li><tt>visitCStop(node,true)</tt></li>");
			ps.println(" * <li><tt>visitStopEnd(node)</tt></li>");
			ps.println(" * </ul>");
			ps.println(" * As usual for a tree visitor pattern, each node is visited around their child visits.  If");
			ps.println(" * <tt>node</tt> above had a <tt>child</tt> of type <tt>B</tt>, the executed sequence of");
			ps.println(" * calls would be extended as shown below.");
			ps.println(" * <ul>");
			ps.println(" * <li><tt>visitStartBegin(node)</tt></li>");
			ps.println(" * <li><tt>visitCStart(node,true)</tt></li>");
			ps.println(" * <li><tt>visitBStart(node,false)</tt></li>");
			ps.println(" * <li><tt>visitAStart(node)</tt></li>");
			ps.println(" * <li><tt>visitStartEnd(node)</tt></li>");
			ps.println(" * <li><tt>visitStartBegin(child)</tt></li>");
			ps.println(" * <li><tt>visitBStart(child,true)</tt></li>");
			ps.println(" * <li><tt>visitAStart(child)</tt></li>");
			ps.println(" * <li><tt>visitStartEnd(child)</tt></li>");
			ps.println(" * <li><tt>visitStopBegin(child)</tt></li>");
			ps.println(" * <li><tt>visitAStop(child)</tt></li>");
			ps.println(" * <li><tt>visitBStop(child,true)</tt></li>");
			ps.println(" * <li><tt>visitStopEnd(child)</tt></li>");
			ps.println(" * <li><tt>visitStopBegin(node)</tt></li>");
			ps.println(" * <li><tt>visitAStop(node)</tt></li>");
			ps.println(" * <li><tt>visitBStop(node,false)</tt></li>");
			ps.println(" * <li><tt>visitCStop(node,true)</tt></li>");
			ps.println(" * <li><tt>visitStopEnd(node)</tt></li>");
			ps.println(" * </ul>");
			ps.println(" * This interface is very efficient at providing for the needs of visitors which regularly");
			ps.println(" * need to condition behavior based on node type and have a number of types to service.  If");
			ps.println(" * a simpler traversal of the nodes in the tree is desired, {@link BsjNodeVisitor} may be");
			ps.println(" * more suitable.");
			ps.println(" *");
			ps.println(" * @author Zachary Palmer");
			ps.println(" */");
			printGeneratedClause(ps);
			ps.println("public interface BsjTypedNodeVisitor");
			ps.println("{");
			writeTypeBody(ps, false, sortedNames, concreteTypeNameSet);
			ps.println("}");
			ps.close();
			
			// Write default implementation
			pkg = "edu.jhu.cs.bsj.compiler.ast.util";
			ps = new PrintStream(new FileOutputStream(new File(TARGET_DIR.getPath() + File.separator + "ifaces"
					+ File.separator + pkg.replaceAll("\\.", File.separator) + File.separator
					+ "BsjTypedNodeNoOpVisitor.java")));
			ps.println("package " + pkg + ";");
			ps.println();
			printImports(ps, false);
			ps.println("/**");
			ps.println(" * This default implementation of {@link BsjTypedNodeVisitor} provides no-op versions of each");
			ps.println(" * of the interface's methods.  This is meant for convenience; implementations (especially");
			ps.println(" * anonymous classes) can make use of this class to reduce lines of code.");
			ps.println(" *");
			ps.println(" * @author Zachary Palmer");
			ps.println(" */");
			printGeneratedClause(ps);
			ps.println("public class BsjTypedNodeNoOpVisitor");
			ps.println("{");
			writeTypeBody(ps, true, sortedNames, concreteTypeNameSet);
			ps.println("}");
			ps.close();
		}
		
		private void writeTypeBody(PrintStream ps, boolean concreteType, List<String> sortedNames, Set<String> concreteTypeNameSet)
		{
			String methodSuffix = concreteType ? "\n    {\n    }" : ";";
			
			// write visit{Start,Stop}{Begin,End} methods
			for (String mode : MODES)
			{
				for (String event : new String[]{"Begin","End"})
				{
					ps.println("    /**");
					ps.println("     * " + event +"s a sequence of visit " + mode.toLowerCase() + " calls on a node.");
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
			String pkg = "edu.jhu.cs.bsj.compiler.ast";
			File f = new File(TARGET_DIR.getPath() + File.separator + "ifaces" + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + "BsjNodeFactory.java");
			f.getParentFile().mkdirs();
			ips = new PrintStream(new FileOutputStream(f));
			ips.println("package " + pkg + ";");
			ips.println();
			printImports(ips, false);
			ips.println("/**");
			ips.println(" * This interface is implemented by any object which can act as a factory for BSJ nodes.  It");
			ips.println(" * is strongly advisable to ensure that all nodes in a given AST are produced from the same");
			ips.println(" * factory, although the urgency of this restriction is implementation-dependent.");
			ips.println(" *");
			ips.println(" * @author Zachary Palmer");
			ips.println(" */");
			printGeneratedClause(ips);
			ips.println("public interface BsjNodeFactory");
			ips.println("{");

			pkg = "edu.jhu.cs.bsj.compiler.impl.ast";
			f = new File(TARGET_DIR.getPath() + File.separator + "classes" + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + "BsjNodeFactoryImpl.java");
			f.getParentFile().mkdirs();
			cps = new PrintStream(new FileOutputStream(f));
			cps.println("package " + pkg + ";");
			cps.println();
			printImports(cps, true);
			cps.println("/**");
			cps.println(" * This class acts as a BSJ node factory for the standard BSJ compiler.");
			cps.println(" *");
			cps.println(" * @author Zachary Palmer");
			cps.println(" */");
			printGeneratedClause(cps);
			cps.println("public class BsjNodeFactoryImpl implements BsjNodeFactory");
			cps.println("{");
			
			pkg = "edu.jhu.cs.bsj.compiler.ast.util";
			f = new File(TARGET_DIR.getPath() + File.separator + "ifaces" + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + "BsjNodeFactoryDecorator.java");
			f.getParentFile().mkdirs();
			dps = new PrintStream(new FileOutputStream(f));
			dps.println("package " + pkg + ";");
			dps.println();
			printImports(dps, false);
			dps.println("/**");
			dps.println(" * This class allows simple decoration of all node construction methods on a node factory.");
			dps.println(" *");
			dps.println(" * @author Zachary Palmer");
			dps.println(" */");
			printGeneratedClause(dps);
			dps.println("public abstract class BsjNodeFactoryDecorator implements BsjNodeFactory");
			dps.println("{");
			dps.println("    /** The backing factory. */");
			dps.println("    BsjNodeFactory factory;");
			dps.println();
			dps.println("    /**");
			dps.println("     * Creates a new decorating factory.");
			dps.println("     * @param factory The backing factory.");
			dps.println("     */");
			dps.println("    public BsjNodeFactoryDecorator(BsjNodeFactory factory)");
			dps.println("    {");
			dps.println("        this.factory = factory;");
			dps.println("    }");
			dps.println();
			dps.println("    /**");
			dps.println("     * The decoration method.  This method is called after every node creation.");
			dps.println("     * @param node The node that was just created.");
			dps.println("     */");
			dps.println("    protected abstract void decorate(Node node);");
			dps.println();
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

				ips.println("    /**");
				ips.println("     * Creates a " + def.getRawName() + ".");
				ips.println("     */");
				ips.print("    public " + typeParamS + typeName + " make" + def.getRawName());
				printParameterList(ips, recProps);
				ips.println(";");
				ips.println();

				cps.println("    /**");
				cps.println("     * Creates a " + def.getRawName() + ".");
				cps.println("     */");
				cps.println("    @Override");
				cps.print("    public " + typeParamS + typeName + " make" + def.getRawName());
				printParameterList(cps, recProps);
				cps.println();
				cps.println("    {");
				String classname = def.getRawName() + "Impl" + typeArg;
				cps.print("        " + typeName + " ret = new " + classname);
				printArgumentList(cps, recProps);
				cps.println(";");
				// TODO: later, this is where we register created nodes with the central dependency validation authority
				cps.println("        return ret;");
				cps.println("    }");
				cps.println();

				dps.println("    /**");
				dps.println("     * Creates a " + def.getRawName() + ".");
				dps.println("     */");
				dps.println("    @Override");
				dps.print("    public " + typeParamS + typeName + " make" + def.getRawName());
				printParameterList(dps, recProps);
				dps.println();
				dps.println("    {");
				dps.print("        " + typeName + " node = factory.make" + def.getRawName());
				printArgumentList(dps, recProps);
				dps.println(";");
				dps.println("        this.decorate(node);");
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

		@Override
		public void init() throws IOException
		{
			super.init();
			String pkg = "edu.jhu.cs.bsj.compiler.ast";
			File f = new File(TARGET_DIR.getPath() + File.separator + "ifaces" + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + "BsjNodeOperation.java");
			f.getParentFile().mkdirs();
			ips = new PrintStream(new FileOutputStream(f));
			ips.println("package " + pkg + ";");
			ips.println();
			printImports(ips, false);
			ips.println("/**");
			ips.println(" * This interface specifies an operation to be carried out on a node.  The purpose of this");
			ips.println(" * mechanism is effectively to allow the addition of operations to the node hierarchy");
			ips.println(" * requiring that the hierarchy itself be modified.  Note that while this interface is");
			ips.println(" * similar to that of the visitor pattern (see {@link BsjNodeVisitor}), it does not function");
			ips.println(" * the same way.  This mechanism does not abstract node traversal; the implementation is");
			ips.println(" * required to do that itself if it wishes to walk the tree.");
			ips.println(" *");
			ips.println(" * @param <P> A parameter type for all methods to accept.  If no return type is desired, use");
			ips.println(" * {@link java.lang.Void}.");
			ips.println(" * @param <R> A return type for all methods to return.  If no return type is desired, use");
			ips.println(" * {@link java.lang.Void}.");
			ips.println(" *");
			ips.println(" * @author Zachary Palmer");
			ips.println(" */");
			printGeneratedClause(ips);
			ips.println("public interface BsjNodeOperation<P,R>");
			ips.println("{");

			pkg = "edu.jhu.cs.bsj.compiler.ast.util";
			f = new File(TARGET_DIR.getPath() + File.separator + "ifaces" + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + "BsjNodeNoOpOperation.java");
			f.getParentFile().mkdirs();
			nps = new PrintStream(new FileOutputStream(f));
			nps.println("package " + pkg + ";");
			nps.println();
			printImports(nps, false);
			nps.println("/**");
			nps.println(" * This implementation of the BSJ node operation implements every method with a no-op.");
			nps.println(" *");
			nps.println(" * @author Zachary Palmer");
			nps.println(" */");
			printGeneratedClause(nps);
			nps.println("public class BsjNodeNoOpOperation<P,R> implements BsjNodeOperation<P,R>");
			nps.println("{");
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
				ips.println("    public " + typeParamS + "R execute" + def.getRawName() + "(" + typeName +
						" node, P p);");
				ips.println();
				
				nps.println("    /**");
				nps.println("     * Performs no operation.");
				nps.println("     * @param node Ignored.");
				nps.println("     * @param p Ignored.");
				nps.println("     * @return <code>null</code>, always.");
				nps.println("     */");
				nps.println("    public " + typeParamS + "R execute" + def.getRawName() + "(" + typeName +
						" node, P p)");
				nps.println("    {");
				nps.println("        return null;");
				nps.println("    }");
				nps.println();
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
		}
	}
}
