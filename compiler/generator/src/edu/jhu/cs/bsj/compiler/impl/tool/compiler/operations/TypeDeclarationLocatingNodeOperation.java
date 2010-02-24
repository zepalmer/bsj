package edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;

/**
 * This node operation locates the in-scope type declaration for the specified type name.
 * 
 * @author Zachary Palmer
 */
public class TypeDeclarationLocatingNodeOperation extends BsjDefaultNodeOperation<Void, NamedTypeDeclarationNode<?>>
{
	/** The logger for this object. */
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/** The name components of the name to find. */
	private List<String> components;
	/** The categories of the name to find. */
	private List<NameCategory> categories;

	/**
	 * Creates a new type declaration locating operation.
	 * 
	 * @param name The name of the type to locate.
	 */
	public TypeDeclarationLocatingNodeOperation(NameNode name)
	{
		super();
		if (name == null)
			throw new IllegalArgumentException("Cannot handle null name");
		/*
		 * if (name.getCategory() != NameCategory.TYPE && name.getCategory() != NameCategory.PACKAGE) throw new
		 * IllegalArgumentException("Must be a type name (category = " + name.getCategory() + ")");
		 */

		this.components = new LinkedList<String>();
		this.categories = new LinkedList<NameCategory>();

		NameNode node = name;
		while (node != null)
		{
			if (node instanceof SimpleNameNode)
			{
				SimpleNameNode simpleNameNode = (SimpleNameNode) node;
				components.add(0, simpleNameNode.getIdentifier().getIdentifier());
				categories.add(0, simpleNameNode.getCategory());
				node = null;
			} else
			{
				QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) node;
				components.add(0, qualifiedNameNode.getIdentifier().getIdentifier());
				categories.add(0, qualifiedNameNode.getCategory());
				node = qualifiedNameNode.getBase();
			}
		}
	}

	@Override
	public NamedTypeDeclarationNode<?> executeDefault(Node node, Void p)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Attempting to find type declaration for " + this.components + " categorized as "
					+ this.categories + " from " + node.getStartLocation());
		}
		if (this.categories.get(0) == NameCategory.TYPE)
		{
			// If the category is TYPE, the type is qualified.
			NamedTypeDeclarationNode<?> result = node.executeOperation(
					new AncestryExecutingNodeOperation<NamedTypeDeclarationNode<?>>(
							new TopLevelTypeDeclarationLocatingAncestorOperation(this.components.get(0))), null);
			return findTypeDeclarationChild(result, components.subList(1, components.size()));
		} else if (this.categories.get(0) == NameCategory.PACKAGE)
		{
			// If the category is PACKAGE, the type is not qualified. We can get to it directly.
			PackageNode rootPackage = node.getRootPackage();
			if (rootPackage == null)
			{
				// TODO: should this be an error?
				return null;
			}

			int index = 0;
			PackageNode packageNode = rootPackage;
			while (index < this.categories.size() && this.categories.get(index) == NameCategory.PACKAGE)
			{
				packageNode = packageNode.getSubpackage(this.components.get(index));
				index++;
				if (packageNode == null)
				{
					return null;
				}
			}

			// Find the top level type in the package
			return findTopLevelTypeDeclarationInPackage(packageNode, this.components.subList(index,
					this.components.size()));
		} else
		{
			throw new IllegalArgumentException("Cannot handle name with simple name category of "
					+ this.categories.get(0));
		}
	}

	// TODO: possibly generalize this function?
	private static NamedTypeDeclarationNode<?> findTopLevelTypeDeclarationInPackage(PackageNode packageNode,
			List<String> components)
	{
		CompilationUnitNode compilationUnitNode = packageNode.getCompilationUnit(components.get(0));
		if (compilationUnitNode != null)
		{
			NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(compilationUnitNode,
					components);
			if (namedTypeDeclarationNode != null)
			{
				return namedTypeDeclarationNode;
			}
		}

		// If we couldn't find it in its own compilation unit node, let's go find it by searching the package
		Iterator<CompilationUnitNode> it = packageNode.getCompilationUnitIterator();
		while (it.hasNext())
		{
			NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(it.next(), components);
			if (namedTypeDeclarationNode != null)
			{
				return namedTypeDeclarationNode;
			}
		}

		return null;
	}

	private static NamedTypeDeclarationNode<?> tryCompilationUnitNode(CompilationUnitNode compilationUnitNode,
			List<String> components)
	{
		for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
		{
			if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
				if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(components.get(0)))
				{
					return findTypeDeclarationChild(namedTypeDeclarationNode, components.subList(1, components.size()));
				}
			}
		}
		return null;
	}

	/**
	 * Determines whether or not the type declaration contains a type declaration matching the target name. If the
	 * target name is a single component (such as <tt>Foo</tt>), the provided type declaration is returned immediately.
	 * Otherwise, its children are examined to locate the appropriate declaration. For instance, the type name
	 * <tt>Foo.Bar</tt> would cause this method to search the specified type declaration for a child type declaration
	 * named <tt>Bar</tt>.
	 * 
	 * @param namedTypeDeclarationNode The starting declaration.
	 * @param components The list of components to use.
	 * @return A declaration which matches the specified name or <code>null</code> if no such type declaration exists.
	 */
	protected static NamedTypeDeclarationNode<?> findTypeDeclarationChild(
			NamedTypeDeclarationNode<?> namedTypeDeclarationNode, List<String> components)
	{
		// TODO: assert that each of these components is of category TYPE?
		int index = 0;
		outer: while (index < components.size())
		{
			for (Node node : namedTypeDeclarationNode.getBody().getMembers())
			{
				if (node instanceof NamedTypeDeclarationNode<?>)
				{
					NamedTypeDeclarationNode<?> candidate = (NamedTypeDeclarationNode<?>) node;
					if (candidate.getIdentifier().getIdentifier().equals(components.get(index)))
					{
						namedTypeDeclarationNode = candidate;
						index++;
						continue outer;
					}
				}
			}
			return null;
		}
		return namedTypeDeclarationNode;
	}

	/**
	 * This operation checks the ancestors of the given node for a type declaration of the specified simple name. It is
	 * meant to be used in conjunction with an {@link AncestryExecutingNodeOperation} to find a type declaration in
	 * scope for the visited node. This ancestor operation assumes that the simple name is a type category name.
	 */
	private static class TopLevelTypeDeclarationLocatingAncestorOperation extends
			BsjDefaultNodeOperation<List<Node>, NamedTypeDeclarationNode<?>>
	{
		private String name;
		/**
		 * Used to prevent this visitor from examining its own imports if the original node was not inside of a type
		 * declaration.
		 */
		private boolean seenTypeDeclaration = false;

		public TopLevelTypeDeclarationLocatingAncestorOperation(String name)
		{
			super();
			this.name = name;
		}

		// TODO: accommodate the import collision rules specified in JLS v3 §7.5.1
		// (perhaps get every type which we think fits? how do we accommodate shadowing?)
		// TODO: handle type parameters
		// TODO: handle local class declarations
		// TODO: handle default package classes

		@Override
		public NamedTypeDeclarationNode<?> executeAnnotationDeclarationNode(AnnotationDeclarationNode node, List<Node> p)
		{
			this.seenTypeDeclaration = true;
			return null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeClassDeclarationNode(ClassDeclarationNode node, List<Node> p)
		{
			this.seenTypeDeclaration = true;
			return null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeEnumDeclarationNode(EnumDeclarationNode node, List<Node> p)
		{
			this.seenTypeDeclaration = true;
			return null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeInterfaceDeclarationNode(InterfaceDeclarationNode node, List<Node> p)
		{
			this.seenTypeDeclaration = true;
			return null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeDefault(Node node, List<Node> p)
		{
			return null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeAnnotationBodyNode(AnnotationBodyNode node, List<Node> p)
		{
			return handleTypeBodyNode(node);
		}

		@Override
		public NamedTypeDeclarationNode<?> executeClassBodyNode(ClassBodyNode node, List<Node> p)
		{
			return handleTypeBodyNode(node);
		}

		@Override
		public NamedTypeDeclarationNode<?> executeEnumBodyNode(EnumBodyNode node, List<Node> p)
		{
			return handleTypeBodyNode(node);
		}

		@Override
		public NamedTypeDeclarationNode<?> executeInterfaceBodyNode(InterfaceBodyNode node, List<Node> p)
		{
			return handleTypeBodyNode(node);
		}

		protected NamedTypeDeclarationNode<?> handleTypeBodyNode(TypeBodyNode<?> typeBodyNode)
		{
			for (Node node : typeBodyNode.getMembers())
			{
				if (node instanceof NamedTypeDeclarationNode<?>)
				{
					NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) node;
					if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(this.name))
					{
						return namedTypeDeclarationNode;
					}
				}
			}
			return null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeCompilationUnitNode(CompilationUnitNode node, List<Node> p)
		{
			if (seenTypeDeclaration)
			{
				for (ImportNode importNode : node.getImports())
				{
					NamedTypeDeclarationNode<?> namedTypeDeclarationNode = importNode.executeOperation(
							new ImportHandlingNodeOperation(), null);
					if (namedTypeDeclarationNode != null)
					{
						return namedTypeDeclarationNode;
					}
				}
			}
			return null;
		}

		class ImportHandlingNodeOperation extends BsjDefaultNodeOperation<Void, NamedTypeDeclarationNode<?>>
		{
			@Override
			public NamedTypeDeclarationNode<?> executeDefault(Node node, Void p)
			{
				return null;
			}

			@Override
			public NamedTypeDeclarationNode<?> executeImportOnDemandNode(ImportOnDemandNode node, Void p)
			{
				if (node.getName().getCategory() == NameCategory.PACKAGE)
				{
					// Find the mentioned package
					PackageNode rootPackage = node.getRootPackage();
					if (rootPackage == null)
					{
						return null;
					}
					PackageNode packageNode = rootPackage.getSubpackageByQualifiedName(node.getName());
					return findTopLevelTypeDeclarationInPackage(packageNode,
							Arrays.asList(TopLevelTypeDeclarationLocatingAncestorOperation.this.name));
				} else if (node.getName().getCategory() == NameCategory.TYPE)
				{
					// Find the mentioned type
					NamedTypeDeclarationNode<?> result = node.executeOperation(
							new TypeDeclarationLocatingNodeOperation(node.getName()), null);
					if (result == null)
					{
						return null;
					}
					// Find our type declared within it
					return findTypeDeclarationChild(result,
							Arrays.asList(TopLevelTypeDeclarationLocatingAncestorOperation.this.name));
				} else
				{
					// Hard to imagine how this is legal.
					throw new IllegalArgumentException("Found ImportOnDemandNode with name " + node.getName()
							+ " categorized as " + node.getName().getCategory() + " (must be PACKAGE or TYPE)");
				}
			}

			@Override
			public NamedTypeDeclarationNode<?> executeImportSingleTypeNode(ImportSingleTypeNode node, Void p)
			{
				if (node.getName().getIdentifier().getIdentifier().equals(
						TopLevelTypeDeclarationLocatingAncestorOperation.this.name))
				{
					// Figure out to which type declaration this import node refers
					NamedTypeDeclarationNode<?> result = node.executeOperation(
							new TypeDeclarationLocatingNodeOperation(node.getName()), null);
					// Use that type
					return result;
				}
				// TODO: Does the JLS prohibit simple names from single type imports? Do we check for that anywhere? The
				// OpenJDK javac forbids it.
				return null;
			}

			@Override
			public NamedTypeDeclarationNode<?> executeSingleStaticImportNode(SingleStaticImportNode node, Void p)
			{
				if (node.getName().getIdentifier().getIdentifier().equals(
						TopLevelTypeDeclarationLocatingAncestorOperation.this.name))
				{
					// Figure out to which type declaration this import node refers
					NamedTypeDeclarationNode<?> result = node.executeOperation(
							new TypeDeclarationLocatingNodeOperation(node.getName()), null);
					if (result == null)
					{
						return null;
					}
					// Try to find a member type named by the identifier on that import
					result = result.getTypeDeclaration(node.getIdentifier().getIdentifier());
					// Use that type
					return result;
				}
				return null;
			}

			@Override
			public NamedTypeDeclarationNode<?> executeStaticImportOnDemandNode(StaticImportOnDemandNode node, Void p)
			{
				// Find the mentioned type
				NamedTypeDeclarationNode<?> result = node.executeOperation(new TypeDeclarationLocatingNodeOperation(
						node.getName()), null);
				if (result == null)
				{
					return null;
				}
				// Find our type declared within it
				return findTypeDeclarationChild(result,
						Arrays.asList(TopLevelTypeDeclarationLocatingAncestorOperation.this.name));
			}
		}
	}
}
