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
 * This class generates some patternistic sources for the BSJ parser.  The code is awful; it's not intended for
 * long-term maintenance, as it will become obsolete once the BSJ compiler has been reimplemented in BSJ.
 * 
 * @author Zachary Palmer
 */
public class SourceGenerator
{
	private static final File contentsFile = new File("data/ast-contents.dat");
	private static final File targetDir = new File("out/");
	
	private Set<ClassDefHandler> handlers = new HashSet<ClassDefHandler>();
	private Map<String,String> envMap = new HashMap<String,String>();

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
	
	public void run()
		throws IOException
	{
		for (ClassDefHandler handler : handlers) handler.init();
		
		rmrf(targetDir);
		
		targetDir.mkdirs();
		byte[] data = new byte[(int) contentsFile.length()];
		FileInputStream fis = new FileInputStream(contentsFile);
		int left = data.length;
		while (left > 0)
		{
			left -= fis.read(data, data.length - left, left);
		}
		fis.close();
		String contents = new String(data);
		List<String> strings = new ArrayList<String>(Arrays.asList(contents.split("\n")));

		for (int i = 0; i < strings.size(); i++)
		{
			String s = strings.get(i);
			if (s.contains("#"))
			{
				s = s.substring(0, s.indexOf("#"));
				strings.set(i, s);
			}
		}

		strings = new LinkedList<String>(strings);

		process(strings);
		
		for (ClassDefHandler handler : handlers) handler.finish();
	}

	private void process(List<String> strings) throws IOException
	{
		while (strings.size() > 0 && strings.get(0).trim().length() == 0)
		{
			strings.remove(0);
		}
		while (strings.size() > 0)
		{
			if (strings.get(0).trim().startsWith("!"))
			{
				String command = strings.remove(0).trim();
				String op = command.substring(0, command.indexOf(' '));
				String arg = command.substring(op.length()).trim();
				
				if (op.equals("!set"))
				{
					String[] pieces = arg.split("=");
					if (pieces.length!=2)
					{
						throw new IllegalArgumentException("Malformed set command " + command);
					}
					envMap.put(pieces[0],pieces[1]);
				} else
				{
					throw new IllegalArgumentException("Unknown command " + command);
				}
			} else
			{
				processEntry(strings);
			}
			while (strings.size() > 0 && strings.get(0).trim().length() == 0)
			{
				strings.remove(0);
			}
		}
	}

	private void processEntry(List<String> strings) throws IOException
	{
		String classdef = strings.remove(0);
		String classname, supername;
		if (classdef.contains("::"))
		{
			String[] data = classdef.split("::");
			assert (data.length == 2);
			classname = data[0].trim();
			supername = data[1].trim();
		} else
		{
			classname = classdef.trim();
			supername = null;
		}
		
		List<String> docStrings = new ArrayList<String>();

		Mode mode = null;
		List<Prop> props = new ArrayList<Prop>();
		while (strings.size() > 0 && strings.get(0).trim().length() > 0)
		{
			String orig = strings.remove(0);
			String s = orig.trim();
			if (s.startsWith("@"))
			{
				if (s.equals("@props"))
				{
					mode = Mode.PROP;
				} else if (s.equals("@docs"))
				{
					mode = Mode.DOC;
				} else
				{
					throw new IllegalArgumentException("Unknown mode " + s);
				}
			} else
			{
				if (mode == Mode.PROP)
				{
					props.add(parseProp(s));
				} else if (mode == Mode.DOC)
				{
					docStrings.add(orig);
				} else if (mode == null)
				{
					throw new IllegalArgumentException(classname + ": Mode not set");
				} else
				{
					throw new IllegalStateException(classname + ": Unknown mode " + mode);
				}
			}
		}
		
		boolean concrete = true;
		if (classname.endsWith("*"))
		{
			concrete = false;
			classname.substring(0,classname.length()-1);
		}
		
		StringBuilder classDocBuilder = new StringBuilder();
		if (docStrings.size()>0)
		{
			int minIndent = Integer.MAX_VALUE;
			for (String s : docStrings)
			{
				int count = 0;
				while (count<s.length() && Character.isWhitespace(s.charAt(count))) count++;
				minIndent = Math.min(count, minIndent);
			}
			for (String s : docStrings)
			{
				if (classDocBuilder.length()>0) classDocBuilder.append('\n');
				classDocBuilder.append(s.substring(minIndent));
			}
		}
		ClassDef def = new ClassDef(classname, supername, props, concrete, classDocBuilder.toString());

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
		PROP,
		DOC;
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
		List<Prop> props;
		boolean concrete;
		String classDoc;
		
		public ClassDef(String name, String sname, List<Prop> props, boolean concrete, String classDoc)
		{
			super();
			this.name = name;
			this.sname = sname;
			this.props = props;
			this.concrete = concrete;
			this.classDoc = classDoc;
		}
		
		public String getRawName()
		{
			if (name.contains("<"))
			{
				return name.substring(0,name.indexOf('<'));
			} else
			{
				return name;
			}
		}
		
		public String getRawSname()
		{
			if (sname==null) return null;
			if (sname.contains("<"))
			{
				return sname.substring(0,sname.indexOf('<'));
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
			if (sname==null) return null;
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

	/**
	 * An interface implemented by those modules that wish to handle class definitions.
	 */
	static interface ClassDefHandler
	{
		public void init() throws IOException;
		public void handleDefinition(ClassDef def, Map<String,String> env) throws IOException;
		public void finish() throws IOException;
	}

	/**
	 * A module which allows the creation of AST interfaces.
	 */
	static class InterfaceWriter implements ClassDefHandler
	{
		private static File ifaceTargetDir = new File(
				targetDir.getAbsolutePath() + File.separator + "ifaces");
		
		public void init()
		{
		}
		
		public void handleDefinition(ClassDef def, Map<String,String> env) throws IOException
		{
			String pkg = env.get("iPackage");
			if (pkg==null) pkg = "";
			File classFile = new File(ifaceTargetDir.getAbsolutePath() + File.separator +
					pkg.replaceAll("\\.",File.separator) + File.separator + def.getRawName() + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);
			if (pkg.length()>0) ps.println("package " + pkg + ";");
			ps.println("");
			ps.println("/**");
			ps.println(" * " + def.classDoc.replaceAll("\n", "\n * "));
			ps.println(" */");
			ps.println("public class " + def.name + (def.sname == null ? "" : " extends " + def.sname));
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
		private static File classTargetDir = new File(
				targetDir.getAbsolutePath() + File.separator + "classes");
		
		private static Map<String,ClassDef> map;
		private static Map<ClassDef,Map<String,String>> envs;
		
		public void init() throws IOException
		{
			map = new HashMap<String,ClassDef>();
			envs = new HashMap<ClassDef, Map<String,String>>();
		}
		
		public void handleDefinition(ClassDef def, Map<String,String> env) throws IOException
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
			while (def!=null)
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
			if (pkg==null) pkg="";
			File classFile = new File(classTargetDir.getAbsolutePath() + File.separator +
					pkg.replaceAll("\\.",File.separator) + File.separator + def.getRawName() + ".java");
			classFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(classFile);
			PrintStream ps = new PrintStream(fos);
			
			if (pkg.length()>0) ps.println("package " + pkg + ";");
			ps.println("");
			ps.println("public class " + classname +
					(def.sname == null ? "" : " extends " + superclassname) +
					" implements " + def.name);
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
			ps.print("    " + (def.concrete?"public":"protected") + " " + classname + "(");
			boolean first = true;
			List<Prop> recProps = getRecursiveProps(def);
			if (recProps.size()>0)
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
			ps.println("}");
		}
	}
}
