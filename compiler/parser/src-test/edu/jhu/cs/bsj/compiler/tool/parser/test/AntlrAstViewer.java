package edu.jhu.cs.bsj.compiler.tool.parser.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjLexer;
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjParser;

public class AntlrAstViewer
{
	private static final File MEMORY_FILE =
		new File(System.getProperty("user.home") + File.separator + ".AntlrAstViewer");
	
	static class SwingCommonTreeNode implements TreeNode
	{
		private java.util.List<SwingCommonTreeNode> children;
		private SwingCommonTreeNode parent;
		private String string;
		public SwingCommonTreeNode(SwingCommonTreeNode parent, Tree backer)
		{
			this.parent = parent;
			this.children = new ArrayList<SwingCommonTreeNode>();
			for (int i=0;i<backer.getChildCount();i++)
			{
				this.children.add(
					new SwingCommonTreeNode(this, (Tree)backer.getChild(i)));
			}
			this.string = backer.toString();
		}
		public Enumeration<SwingCommonTreeNode> children()
		{
			return new IterationEnumerator<SwingCommonTreeNode>(
				this.children.iterator());
		}
		public boolean getAllowsChildren() { return true; }
		public TreeNode getChildAt(int i) { return this.children.get(i); }
		public int getChildCount() { return this.children.size(); }
		public int getIndex(TreeNode n) { return this.children.indexOf(n); }
		public TreeNode getParent() { return this.parent; }
		public boolean isLeaf () { return this.children.size()==0; }
		public String toString() { return this.string; }
	}
	static class IterationEnumerator<T> implements Enumeration<T>
	{
		private Iterator<T> it;
		public IterationEnumerator(Iterator<T> it)
		{
			this.it = it;
		}
		public boolean hasMoreElements()
		{
			return it.hasNext();
		}
		public T nextElement()
		{
			return it.next();
		}
	}

	public static void printTree(CommonTree t, int indent)
	{
		if (t==null)
		{
			System.out.println("null");
		} else
		{
			StringBuffer sb = new StringBuffer();
			for (int i=0;i<indent;i++) sb.append("    ");
			String indentString = sb.toString();
				
			System.out.println(indentString + t.toString());
			if (t.getChildCount()>0)
			{
				System.out.println(indentString + "{");
				for (int i=0;i<t.getChildCount();i++)
				{
					printTree((CommonTree)t.getChild(i), indent+1);
				}
				System.out.println(indentString + "}");
			}
		}
	}
	
	public static void showTree(CommonTree t)
	{
		SwingCommonTreeNode node = new SwingCommonTreeNode(null, t);
		JFrame frame = new JFrame("Tree");
		JTree tree = new JTree(node);
		JScrollPane sp = new JScrollPane(tree);
		sp.setPreferredSize(new Dimension(600,450));
		frame.setContentPane(sp);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static Tree stringToAst(String s) throws Exception
	{
		BsjLexer lexer = new BsjLexer(new ANTLRStringStream(s));
		BsjParser parser = new BsjParser(new TokenRewriteStream(lexer));
		return (Tree)parser.compilationUnit().getTree();
	}
	
	private static Properties properties = new Properties();
	
	public static void loadProperties()
	{
		try
		{
			FileInputStream fis = new FileInputStream(MEMORY_FILE);
			properties.load(fis);
			fis.close();
		} catch (IOException e)
		{
			// If an I/O exception occurs, we don't care - just proceed with defaults
			properties.clear();
		}
	}
	
	public static void saveProperties()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(MEMORY_FILE);
			properties.store(fos, "");
			fos.close();
		} catch (IOException e)
		{
			// If an I/O error occurs, we don't really care that much.
			MEMORY_FILE.delete();
		}
	}
	
	public static String getSource()
	{
		return properties.getProperty("source","");
	}
	public static void setSource(String source)
	{
		properties.setProperty("source", source);
	}
	public static Dimension getSize()
	{
		String size = properties.getProperty("size","");
		if (size.contains(","))
		{
			String[] dims = size.split(",");
			if (dims.length==2)
			{
				try
				{
					int x = Integer.parseInt(dims[0]);
					int y = Integer.parseInt(dims[1]);
					return new Dimension(x,y);
				} catch (NumberFormatException nfe)
				{
					// Fall out to default return value.
				}
			}
		}
		return null;
	}
	public static void setSize(Dimension d)
	{
		properties.setProperty("size", ((int)(d.getWidth()))+","+((int)(d.getHeight())));
	}

	public static void main(String arg[]) throws Exception
	{
		loadProperties();
		String defaultText = getSource();
		
		final JFrame frame = new JFrame("AST Viewer");
		final JTree tree = new JTree(
			new DefaultTreeModel(new DefaultMutableTreeNode()));
		final JTextArea error = new JTextArea(6, 40);
		error.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Error"));
		error.setEditable(false);
		final JTextArea source = new JTextArea(8, 40);
		source.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Source"));
		JButton parse = new JButton("Parse");
		source.setText(defaultText);
		
		JScrollPane sp = new JScrollPane(tree);
		sp.setPreferredSize(new Dimension(200,600));
		JPanel treePanel = new JPanel(new BorderLayout());
		treePanel.add(sp, BorderLayout.CENTER);
		treePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "AST"));

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.add(new JScrollPane(error));
		leftPanel.add(new JScrollPane(source));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(treePanel, BorderLayout.CENTER);
		rightPanel.add(parse, BorderLayout.SOUTH);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftPanel, rightPanel);
		frame.setContentPane(splitPane);
		
		frame.pack();
		if (getSize()!=null) frame.setSize(getSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		parse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					setSource(source.getText());
					saveProperties();
					
					Tree t = stringToAst(getSource());
					tree.setModel(new DefaultTreeModel(
						new SwingCommonTreeNode(null, t)));
					error.setText("(no error)");
				} catch (Exception e)
				{
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(baos);
					e.printStackTrace(ps);
					ps.close();
					String stackTrace = new String(baos.toByteArray());
					error.setText(stackTrace);
					tree.setModel(new DefaultTreeModel(
						new DefaultMutableTreeNode()));
				}
			}
		});
		frame.addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				setSize(frame.getSize());
				saveProperties();
			}
		});
		
		frame.setVisible(true);
	}
}
