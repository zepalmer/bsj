package edu.jhu.cs.bsj.compiler.utils.parser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.tools.JavaFileObject;

import org.apache.log4j.PropertyConfigurator;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;

public class AntlrAstViewer
{
	private static final File MEMORY_FILE = new File(System.getProperty("user.home") + File.separator
			+ ".AntlrAstViewer");

	static class SwingCommonTreeNode implements TreeNode
	{
		private java.util.List<SwingCommonTreeNode> children;
		private SwingCommonTreeNode parent;
		private String string;

		public SwingCommonTreeNode(SwingCommonTreeNode parent, Object backer)
		{
			this.parent = parent;
			this.children = new ArrayList<SwingCommonTreeNode>();
			if (backer instanceof Node)
			{
				List<Object> nodeChildren = ((Node) backer).getChildObjects();
				for (Object child : nodeChildren)
				{
					this.children.add(new SwingCommonTreeNode(this, child));
				}
			}
			this.string = String.valueOf(backer);
		}

		public Enumeration<SwingCommonTreeNode> children()
		{
			return new IterationEnumerator<SwingCommonTreeNode>(this.children.iterator());
		}

		public boolean getAllowsChildren()
		{
			return true;
		}

		public TreeNode getChildAt(int i)
		{
			return this.children.get(i);
		}

		public int getChildCount()
		{
			return this.children.size();
		}

		public int getIndex(TreeNode n)
		{
			return this.children.indexOf(n);
		}

		public TreeNode getParent()
		{
			return this.parent;
		}

		public boolean isLeaf()
		{
			return this.children.size() == 0;
		}

		public String toString()
		{
			return this.string;
		}
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

	public static void printTree(Object element, int indent)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < indent; i++)
			sb.append("    ");
		String indentString = sb.toString();

		if (element == null)
		{
			System.out.println(indentString + "null");
		} else
		{
			System.out.println(indentString + element.toString());
			if (element instanceof Node)
			{
				Node node = (Node) element;
				List<Object> childObjects = node.getChildObjects();
				if (childObjects.size() > 0)
				{
					System.out.println(indentString + "{");
					for (Object childObject : childObjects)
					{
						printTree(childObject, indent + 1);
					}
					System.out.println(indentString + "}");
				}
			}
		}
	}

	public static void showTree(Node root)
	{
		SwingCommonTreeNode node = new SwingCommonTreeNode(null, root);
		JFrame frame = new JFrame("Tree");
		JTree tree = new JTree(node);
		JScrollPane sp = new JScrollPane(tree);
		sp.setPreferredSize(new Dimension(600, 450));
		frame.setContentPane(sp);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public static Node stringToAst(String s, PrintStream ps) throws Exception
	{
		BsjParserImpl parser = new BsjParserImpl(new BsjNodeFactoryImpl(null));
		return parser.parse(null, new InputStreamReader(new ByteArrayInputStream(s.getBytes())),
				new DiagnosticPrintingListener<JavaFileObject>(ps));
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
		return properties.getProperty("source", "");
	}

	public static void setSource(String source)
	{
		properties.setProperty("source", source);
	}

	public static Dimension getSize()
	{
		String size = properties.getProperty("size", "");
		if (size.contains(","))
		{
			String[] dims = size.split(",");
			if (dims.length == 2)
			{
				try
				{
					int x = Integer.parseInt(dims[0]);
					int y = Integer.parseInt(dims[1]);
					return new Dimension(x, y);
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
		properties.setProperty("size", ((int) (d.getWidth())) + "," + ((int) (d.getHeight())));
	}

	private static void log4jConfigure(String level)
	{
		Properties loggingProperties = new Properties();
		loggingProperties.setProperty("log4j.rootLogger", level + ", stdout");
		loggingProperties.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
		loggingProperties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
		loggingProperties.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%5p [%t] (%F:%L) - %m%n");
		PropertyConfigurator.configure(loggingProperties);
	}

	public static void main(String arg[]) throws Exception
	{
		loadProperties();
		String defaultText = getSource();

		final JFrame frame = new JFrame("AST Viewer");
		final JTree tree = new JTree(new DefaultTreeModel(new DefaultMutableTreeNode()));
		final JTextArea error = new JTextArea(6, 40);
		error.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Error"));
		error.setEditable(false);
		final JComboBox logLevel = new JComboBox(new Object[] { "trace", "debug" });
		logLevel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Log4J Level"));
		logLevel.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (logLevel.getSelectedItem() != null)
				{
					log4jConfigure(logLevel.getSelectedItem().toString());
				}
			}
		});
		logLevel.setSelectedItem("debug");

		final JTextArea source = new JTextArea(8, 40);
		source.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Source"));
		JButton parse = new JButton("Parse");
		source.setText(defaultText);

		JScrollPane sp = new JScrollPane(tree);
		sp.setPreferredSize(new Dimension(200, 600));
		JPanel treePanel = new JPanel(new BorderLayout());
		treePanel.add(sp, BorderLayout.CENTER);
		treePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "AST"));

		final JTextArea serializedSource = new JTextArea(13, 40);
		serializedSource.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Serialized Source"));
		serializedSource.setEditable(false);
		JScrollPane serializedSourceScrollPane = new JScrollPane(serializedSource);

		JPanel leftMainPanel = new JPanel();
		leftMainPanel.setLayout(new BoxLayout(leftMainPanel, BoxLayout.Y_AXIS));
		leftMainPanel.add(new JScrollPane(error));
		leftMainPanel.add(new JScrollPane(source));

		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.add(leftMainPanel, BorderLayout.CENTER);
		leftPanel.add(logLevel, BorderLayout.SOUTH);

		JTabbedPane tabPanel = new JTabbedPane();
		tabPanel.addTab("AST", treePanel);
		tabPanel.addTab("Source", serializedSourceScrollPane);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(tabPanel, BorderLayout.CENTER);
		rightPanel.add(parse, BorderLayout.SOUTH);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftPanel, rightPanel);
		frame.setContentPane(splitPane);

		frame.pack();
		if (getSize() != null)
			frame.setSize(getSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		parse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode()));
				ByteArrayOutputStream errorBuffer = new ByteArrayOutputStream();
				PrependablePrintStream errorps = new PrependablePrintStream(errorBuffer, "    ", 0);
				setSource(source.getText());
				saveProperties();

				Node node = null;
				try
				{
					node = stringToAst(getSource(), errorps);
				} catch (Exception e)
				{
					e.printStackTrace(errorps);
				}
				if (node != null)
				{
					try
					{
						String serializedSourceStr = node.executeOperation(new BsjSourceSerializerImpl(), null);
						serializedSource.setText(serializedSourceStr);
					} catch (Throwable t)
					{
						t.printStackTrace(errorps);
					}
				} else
				{
					serializedSource.setText("");
				}

				tree.setModel(new DefaultTreeModel(new SwingCommonTreeNode(null, node)));
				errorps.close();
				String errorString = errorBuffer.toString();
				if (errorString.length() == 0)
				{
					errorString = "(no error)";
				}
				error.setText(errorString);
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
