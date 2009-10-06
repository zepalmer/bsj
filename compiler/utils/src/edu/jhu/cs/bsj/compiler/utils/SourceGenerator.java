package edu.jhu.cs.bsj.compiler.utils;

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

// TODO: we are too aggressively assigning "? extends" to some of our types.  For example, we will need to modify
// the list of ClassMember objects returned by a ClassBodyNode; it probably shouldn't use the ? extends form.

/**
 * This class generates some patternistic sources for the BSJ parser. The code is awful; it's not intended for long-term
 * maintenance, as it will become obsolete once the BSJ compiler has been reimplemented in BSJ.
 * 
 * @author Zachary Palmer
 */
public class SourceGenerator
{
	private static final File CONTENTS_FILE = new File("data/srcgen/ast-contents.dat");
	private static final File VERBATIM_DIR = new File("data/srcgen/verbatim/");
	private static final File SUPPLEMENTS_DIR = new File("data/srcgen/supplement/");
	private static final File TARGET_DIR = new File("out/");
	private static final String[] IFACE_IMPORTS = new String[] { "edu.jhu.cs.bsj.compiler.ast.*",
			"edu.jhu.cs.bsj.compiler.ast.node.*", "edu.jhu.cs.bsj.compiler.ast.node.meta.*",
			"edu.jhu.cs.bsj.compiler.ast.tags.*", "java.util.*" };
	private static final String[] CLASS_IMPORTS = new String[] { "edu.jhu.cs.bsj.compiler.impl.ast.*",
			"edu.jhu.cs.bsj.compiler.impl.ast.node.*", "edu.jhu.cs.bsj.compiler.impl.ast.node.meta.*" };

	// private static final String[] DEFAULT_IMPORTS =

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
				s = s.substring(0, s.indexOf("#"));
				strings.set(i, s);
			}
		}

		List<Line> lines = Line.number(strings);

		// Process the contents file
		lines = new LinkedList<Line>(lines);

		process(lines);

		// Finish each handler
		for (ClassDefHandler handler : handlers)
			handler.finish();

		// Copy verbatim files to the appropriate locations
		copyVerbatims(VERBATIM_DIR, "");
	}

	private void copyVerbatims(File dir, String prefix) throws IOException
	{
		for (File f : dir.listFiles())
		{
			if (f.getName().startsWith("."))
				continue;
			if (f.isDirectory())
			{
				copyVerbatims(f, prefix.length() == 0 ? f.getName() : prefix + File.separator + f.getName());
			} else
			{
				String s = getFileAsString(f);
				String pkg = "";
				String pkgDecl = "";
				if (s.contains("\n"))
				{
					pkgDecl = s.substring(0, s.indexOf('\n'));
				} else
				{
					pkgDecl = s;
				}
				pkgDecl = pkgDecl.trim();
				if ((pkgDecl.startsWith("package")) && (pkgDecl.endsWith(";")))
				{
					pkg = pkgDecl.substring(7, pkgDecl.length() - 1).trim();
					File target = new File(TARGET_DIR.getPath() + File.separator + prefix + File.separator
							+ pkg.replaceAll("\\.", File.separator) + File.separator + f.getName());
					target.getParentFile().mkdirs();
					PrintStream ps = new PrintStream(new FileOutputStream(target));
					ps.print(s);
					ps.close();
				} else
				{
					System.err.println("warning: file " + f + " has bad package declaration");
				}
			}
		}
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

		Mode mode = null;
		List<Prop> props = new ArrayList<Prop>();
		while (lines.size() > 0 && lines.get(0).string.trim().length() > 0)
		{
			Line line = lines.remove(0);
			String errorPrefix = "#" + line.number + ": " + classname + ": ";
			String orig = line.string;
			String s = orig.trim();
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
				} else if (mode == null)
				{
					throw new IllegalArgumentException(errorPrefix + "Mode not set");
				} else
				{
					throw new IllegalStateException(errorPrefix + "Unknown mode " + mode);
				}
			}
		}

		boolean concrete = true;
		if (classname.endsWith("*"))
		{
			concrete = false;
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

		ClassDef def = new ClassDef(classname, supername, taggingInterfaces, props, includeFilenames, concrete,
				classDocBuilder.toString());

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
		PROP, DOC, INCLUDE;
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

	static class ClassDef
	{
		String name;
		String sname; // superclass name
		List<String> tags; // tagging interface names
		List<Prop> props;
		List<String> includeFilenames;
		boolean concrete;
		String classDoc;

		public ClassDef(String name, String sname, List<String> tags, List<Prop> props, List<String> includeFilenames,
				boolean concrete, String classDoc)
		{
			super();
			this.name = name;
			this.sname = sname;
			this.tags = tags;
			this.props = props;
			this.includeFilenames = includeFilenames;
			this.concrete = concrete;
			this.classDoc = classDoc;
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
			File f = new File(SUPPLEMENTS_DIR.getParent() + File.separator + "supplement" + File.separator
					+ dir + File.separator + name);
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
			File f = new File(SUPPLEMENTS_DIR.getParent() + File.separator + "supplement" + File.separator
					+ dir + File.separator + name);
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
		protected static Map<String, ClassDef> map;
		protected static Map<ClassDef, Map<String, String>> envs;

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
			while (def!=null)
			{
				if (def.getRawName().equals(classname)) return true;
				def = map.get(def.getRawSname());
			}
			return false;
		}
		
		protected boolean propInstanceOf(String propType, String classname)
		{
			if (propType.contains("<")) propType = propType.substring(0,propType.indexOf('<')).trim();
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
			
			ps.println("public " + (def.concrete ? "" : "abstract ") + "class " + classname
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
			ps.print("    " + (def.concrete ? "public" : "protected") + " " + rawclassname);
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
						ps.println("            ((NodeImpl)this."+p.name+").setParent(null);");
						ps.println("        }");
					}
					ps.println("        this." + p.name + " = " + p.name + ";");
					if (propInstanceOf(p.type, "Node"))
					{
						ps.println("        if (this." + p.name + " instanceof NodeImpl)");
						ps.println("        {");
						ps.println("            ((NodeImpl)this."+p.name+").setParent(this);");
						ps.println("        }");
					}
					ps.println("    }");
					ps.println();
				}
			}

			// add visitor implementation
			ps.println("    /**");
			ps.println("     * Handles the visitation of this node's children for the provided visitor.  Each");
			ps.println("     * subclass should override this method, having the subclass implementation call this");
			ps.println("     * method first and then visit its subclass-specific children.");
			ps.println("     *");
			ps.println("     * @param visitor The visitor to visit this node's children.");
			ps.println("     */");
			if (def.sname!=null)
			{
				ps.println("    @Override");
			}
			ps.println("    protected void receiveToChildren(BsjNodeVisitor visitor)");
			ps.println("    {");
			if (def.sname!=null)
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

			// add supplements
			includeAllBodies(ps, def.includeFilenames, "classes");

			ps.println("}");
		}
	}

	/**
	 * Writes the BsjTypedNodeVisitor abstract class.
	 */
	static class BsjTypedNodeVisitorWriter implements ClassDefHandler
	{
		private PrintStream ps;
		private Map<String, Set<String>> subtypeMap;
		private Map<String, String> supertypeMap;
		private List<String> abstractTypes;
		private Set<String> parameterizedTypes;

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
			if (!def.concrete)
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

			List<String> concreteTypeNames = new ArrayList<String>(names);
			concreteTypeNames.removeAll(abstractTypes);
			Collections.reverse(concreteTypeNames);

			// Write class header
			String pkg = "edu.jhu.cs.bsj.compiler.ast";
			ps = new PrintStream(new FileOutputStream(new File(TARGET_DIR.getPath() + File.separator + "ifaces"
					+ File.separator + pkg.replaceAll("\\.", File.separator) + File.separator
					+ "BsjTypedNodeVisitor.java")));
			ps.println("package " + pkg + ";");
			ps.println();
			printImports(ps, false);
			ps.println("/**");
			ps.println(" * This default implementation of the BsjNodeVisitor separates nodes based on type.  Each");
			ps.println(" * type of node is routed to a different method to be handled; the default implementation of");
			ps.println(" * each of the type-specific methods does nothing.");
			ps.println(" *");
			ps.println(" * @author Zachary Palmer");
			ps.println(" */");
			ps.println("public abstract class BsjTypedNodeVisitor implements BsjNodeVisitor");
			ps.println("{");

			// Write visitStart and visitStop methods
			for (String mode : new String[] { "Start", "Stop" })
			{
				// Write header
				ps.println("    /**");
				ps.println("     * " + mode + "s visiting the specified node.");
				ps.println("     * @param node The node to visit.");
				ps.println("     */");
				ps.println("    public void visit" + mode + "(Node node)");
				ps.println("    {");

				// Write body
				boolean first = true;
				for (String name : concreteTypeNames)
				{
					String pname = name + (parameterizedTypes.contains(name) ? "<?>" : "");
					ps.println((first ? "        " : " else ") + "if (node instanceof " + pname + ")");
					ps.println("        {");
					ps.println("            visit" + name + mode + "((" + pname + ")node);");
					ps.print("        }");
					first = false;
				}

				// Write footer
				ps.println(" else");
				ps.println("        {");
				ps
						.println("            throw new IllegalStateException(\"Unrecognized node type \" + node.getClass());");
				ps.println("        }");
				ps.println("    }");
				ps.println();
			}

			// Write type-specific visit methods.
			for (String mode : new String[] { "Start", "Stop" })
			{
				for (String name : concreteTypeNames)
				{
					ps.println("    /**");
					ps.println("     * " + mode + "s a visit for nodes of type " + name + ".");
					ps.println("     * @param node The node being visited.");
					ps.println("     */");
					ps.println("    public void visit" + name + mode + "(" + name
							+ (parameterizedTypes.contains(name) ? "<?>" : "") + " node)");
					ps.println("    {");
					ps.println("    }");
					ps.println();
				}
			}

			// Write class footer
			ps.println("}");

			// Complete write
			ps.close();
		}
	}

	/**
	 * Writes the BSJ AST node factory interface and implementation.
	 */
	static class FactoryWriter extends ClassHierarchyBuildingHandler
	{
		PrintStream ips;
		PrintStream cps;

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
			ips.println("* @author Zachary Palmer");
			ips.println(" */");
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
			cps.println("* @author Zachary Palmer");
			cps.println(" */");
			cps.println("public class BsjNodeFactoryImpl implements BsjNodeFactory");
			cps.println("{");
		}

		@Override
		public void useDefinition(ClassDef def) throws IOException
		{
			if (def.concrete)
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
		}
	}
}
