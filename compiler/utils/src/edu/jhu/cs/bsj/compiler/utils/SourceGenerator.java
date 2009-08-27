package edu.jhu.cs.bsj.compiler.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
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
	private static final File contentsFile = new File("data/srcgen/ast-contents.dat");
	private static final File verbatimDir = new File("data/srcgen/verbatim/");
	private static final File supplementsDir = new File("data/srcgen/supplement/");
	private static final File targetDir = new File("out/");

	private Set<ClassDefHandler> handlers = new HashSet<ClassDefHandler>();
	private Map<String, String> envMap = new HashMap<String, String>();

	public static void main(String[] arg) throws Exception
	{
		SourceGenerator sg = new SourceGenerator();
		sg.handlers.add(new InterfaceWriter());
		sg.handlers.add(new BackingClassWriter());
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
		// Initialize each handler
		for (ClassDefHandler handler : handlers)
			handler.init();

		// Clear the target directory
		rmrf(targetDir);

		// Obtain the contents file
		targetDir.mkdirs();
		String contents = getFileAsString(contentsFile);
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
		copyVerbatims(verbatimDir, "");
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
					File target = new File(targetDir.getPath() + File.separator + prefix + File.separator
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

		return new Prop(name, type, comment);
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

		public Prop(String name, String type, String desc)
		{
			super();
			this.name = name;
			this.type = type;
			this.desc = desc;
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
	}

	/* handles the definition for an AST class */
	/**
	 * Capitalizes the first letter of a string.
	 * 
	 * @param s
	 *            The string.
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
	 * Performs a source file inclusion.
	 * @param f The {@link File} to include.
	 * @param ps The {@link PrintStream} to which to write lines that need to be copied.
	 */
	private static void includeFile(File f, PrintStream ps)
		throws IOException
	{
		boolean copying = false;
		String[] lines = getFileAsString(f).split("\n");
		
		for (int i=0;i<lines.length;i++)
		{
			String s = lines[i];
			String trimmed = s.trim();
			if (trimmed.startsWith("/*") && trimmed.endsWith("*/"))
			{
				String commentContent = trimmed.substring(2, trimmed.length()-2).trim();
				if (commentContent.startsWith("GEN:"))
				{
					String mode = commentContent.substring(4);
					if (mode.equals("start"))
					{
						copying = true;
					} else if (mode.equals("stop"))
					{
						copying = false;
					} else
					{
						System.err.println(f + ":" + (i+1) + ": Invalid GEN mode: " + mode);
					}

					continue;
				}
			}
			ps.println(s);
		}
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
		private static File ifaceTargetDir = new File(targetDir.getAbsolutePath() + File.separator + "ifaces");

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

			ps.println("public class " + def.name + extendsClause.toString());
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
				ps.println("    /**");
				ps.println("     * Changes " + p.desc + ".");
				ps.println("     * @param " + p.name + " " + capFirst(p.desc) + ".");
				ps.println("     */");
				ps.println("    public void set" + capFirst(p.name) + "(" + p.type + " " + p.name + ");");
				ps.println();
			}
			// add supplements
			for (String name : def.includeFilenames)
			{
				File f = new File(supplementsDir.getParent() + File.separator + "ifaces" + File.separator + name);
				includeFile(f, ps);
			}
			ps.println("}");
		}

		public void finish()
		{
		}
	}

	/**
	 * A module which creates AST backing classes.
	 */
	static class BackingClassWriter implements ClassDefHandler
	{
		private static File classTargetDir = new File(targetDir.getAbsolutePath() + File.separator + "classes");

		private static Map<String, ClassDef> map;
		private static Map<ClassDef, Map<String, String>> envs;

		public void init() throws IOException
		{
			map = new HashMap<String, ClassDef>();
			envs = new HashMap<ClassDef, Map<String, String>>();
		}

		public void handleDefinition(ClassDef def, Map<String, String> env) throws IOException
		{
			map.put(def.name, def);
			envs.put(def, new HashMap<String, String>(env));
		}

		public void finish() throws IOException
		{
			for (ClassDef def : map.values())
			{
				useDefinition(def);
			}
		}

		private List<Prop> getRecursiveProps(ClassDef def)
		{
			List<Prop> list = new ArrayList<Prop>();
			while (def != null)
			{
				list.addAll(0, def.props);
				def = map.get(def.sname);
			}
			return list;
		}

		private void useDefinition(ClassDef def) throws IOException
		{
			String classname = def.getRawName() + "Impl" + def.getNameParam();
			String superclassname = def.getRawSname() + "Impl" + def.getSnameParam();

			String pkg = envs.get(def).get("cPackage");
			if (pkg == null)
				pkg = "";
			File classFile = new File(classTargetDir.getAbsolutePath() + File.separator
					+ pkg.replaceAll("\\.", File.separator) + File.separator + def.getRawName() + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);

			if (pkg.length() > 0)
				ps.println("package " + pkg + ";");
			ps.println("");
			ps.println("public class " + classname + (def.sname == null ? "" : " extends " + superclassname)
					+ " implements " + def.name);
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
			ps.print("    " + (def.concrete ? "public" : "protected") + " " + classname + "(");
			boolean first = true;
			List<Prop> recProps = getRecursiveProps(def);
			if (recProps.size() > 0)
			{
				ps.println();
				for (Prop p : recProps)
				{
					if (!first)
					{
						ps.println(",");
					}
					first = false;

					ps.print("            " + p.type + " " + p.name);
				}
			}
			ps.println(")");
			ps.println("    {");
			ps.print("        super(");
			first = true;
			for (Prop p : recProps)
			{
				if (!def.props.contains(p))
				{
					if (!first)
					{
						ps.print(", ");
						first = false;
					}
					ps.print(p.name);
				}
			}
			ps.println(");");
			for (Prop p : def.props)
			{
				ps.println("        this." + p.name + " = " + p.name + ";");
			}
			ps.println("    }");
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
				ps.println("    /**");
				ps.println("     * Changes " + p.desc + ".");
				ps.println("     * @param " + p.name + " " + capFirst(p.desc) + ".");
				ps.println("     */");
				ps.println("    public void set" + capFirst(p.name) + "(" + p.type + " " + p.name + ")");
				ps.println("    {");
				ps.println("        this." + p.name + " = " + p.name + ";");
				ps.println("    }");
				ps.println();
			}
			
			// add visitor implementation
			// TODO
			
			// add supplements
			for (String name : def.includeFilenames)
			{
				File f = new File(supplementsDir.getParent() + File.separator + "ifaces" + File.separator + name);
				includeFile(f, ps);
			}
			
			ps.println("}");
		}
	}
}
