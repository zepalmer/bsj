package edu.jhu.cs.bsj.compiler.impl.tool.compiler.names;

import java.util.List;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations.AncestryExecutingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations.TypeDeclarationLocatingNodeOperation;

/**
 * This visitor categorizes <i>PackageOrTypeName</i>s as specified by &#xA7;6.5.3 of the JLS v3. To do so, it must have
 * access to a {@link BsjTypeManager} to ask questions about types. After the execution of this visitor, no
 * {@link NameNode} in the visited tree has a name category of {@link NameCategory#PACKAGE_OR_TYPE}.
 * 
 * @author Zachary Palmer
 */
public class PackageOrTypeNameCategorizationVisitor extends BsjTypedNodeNoOpVisitor
{
	/** The logger for this object. */
	private Logger LOGGER = Logger.getLogger(this.getClass());
	
	/** A factory for node duplication. */
	private BsjNodeFactory factory;
	
	public PackageOrTypeNameCategorizationVisitor(BsjNodeFactory factory)
	{
		super();
		this.factory = factory;
	}

	@Override
	public void visitNameNodeStop(NameNode name)
	{
		if (name.getCategory() != NameCategory.PACKAGE_OR_TYPE)
			return;

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Deciding package or type for " + name.getNameString() + " at " + name.getStartLocation());
		}

		NameCategory category;
		if (name instanceof SimpleNameNode)
		{
			// If a type is in scope which has the same name as this node, the node refers to a type. Otherwise, this
			// node refers to a package.
			TypeDeclarationNode typeDeclarationNode = name.executeOperation(new TypeDeclarationLocatingNodeOperation(
					factory.makeSimpleNameNode(name.getIdentifier().deepCopy(factory), NameCategory.TYPE)), null);
			if (typeDeclarationNode == null)
			{
				category = NameCategory.PACKAGE;
			} else
			{
				category = NameCategory.TYPE;
			}
		} else if (name instanceof QualifiedNameNode)
		{
			// If the base name of this node refers to a package or type containing a member type matching the name of
			// this node's identifier, then this node refers to a type. Otherwise, it refers to a package.
			QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) name;
			if (qualifiedNameNode.getBase().getCategory() == NameCategory.PACKAGE)
			{
				category = NameCategory.PACKAGE;
				PackageNode rootPackage = name.getRootPackage();
				if (rootPackage != null)
				{
					PackageNode packageNode = rootPackage.getSubpackageByQualifiedName(qualifiedNameNode.getBase());
					if (packageNode != null)
					{
						if (packageNode.getTopLevelTypeDeclaration(name.getIdentifier().getIdentifier()) != null)
						{
							category = NameCategory.TYPE;
						}
					}
				}
			} else if (qualifiedNameNode.getBase().getCategory() == NameCategory.TYPE)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = name.executeOperation(
						new TypeDeclarationLocatingNodeOperation(name), null);
				if (namedTypeDeclarationNode == null)
				{
					// TODO: this means that this is a type declaration which should contain another type declaration
					// but does not. This will cause problems; should we produce a diagnostic?
					category = NameCategory.PACKAGE;
				} else
				{
					if (namedTypeDeclarationNode.getTypeDeclaration(qualifiedNameNode.getIdentifier().getIdentifier()) == null)
					{
						category = NameCategory.PACKAGE;
					} else
					{
						category = NameCategory.TYPE;
					}
				}
			} else
			{
				throw new IllegalStateException(
						"Typing to disambiguate PACKAGE_OR_TYPE category for name with base of " + name.getCategory());
			}
		} else
		{
			throw new IllegalStateException("Unrecognized node type: " + name.getClass().getName());
		}

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Categorized name " + name.getNameString() + " at " + name.getStartLocation() + " as "
					+ category);
		}
		name.assertCategory(category);
	}

	/**
	 * This node operation determines whether or not the provided node is the ancestor of a node which is within the
	 * scope of a type declaration of the given name. It is intended to be used in conjunction with an
	 * {@link AncestryExecutingNodeOperation}. The return is either <code>null</code> if it is not or the node which
	 * creates the declaration of the type if it is.
	 * 
	 * @author Zachary Palmer
	 */
	static class TypeScopeCheckingOperation extends BsjDefaultNodeOperation<List<Node>, NamedTypeDeclarationNode<?>>
	{
		/** The name for which we are looking. */
		private String name;

		/**
		 * A flag which is flipped once we pass a type declaration. This is used to ensure that imports only influence
		 * the decision if the node in question is inside of a type declaration (as that is the only scope that imports
		 * have.
		 */
		private boolean nodeContainedWithinTypeDeclaration;

		/**
		 * Creates a new operation for checking whether or not a node is in a particular type scope.
		 */
		public TypeScopeCheckingOperation(String name)
		{
			super();
			this.name = name;
			this.nodeContainedWithinTypeDeclaration = false;
		}

		/**
		 * By default, we assume we haven't found anything.
		 */
		@Override
		public NamedTypeDeclarationNode<?> executeDefault(Node node, List<Node> p)
		{
			return null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeAnnotationDeclarationNode(AnnotationDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		@Override
		public NamedTypeDeclarationNode<?> executeClassDeclarationNode(ClassDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		@Override
		public NamedTypeDeclarationNode<?> executeEnumDeclarationNode(EnumDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		@Override
		public NamedTypeDeclarationNode<?> executeInterfaceDeclarationNode(InterfaceDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		protected NamedTypeDeclarationNode<?> evaluateNamedTypeDeclarationNode(NamedTypeDeclarationNode<?> node)
		{
			if (node.getIdentifier().equals(name))
				return node;

			this.nodeContainedWithinTypeDeclaration = true;
			return null;
		}

		/**
		 * Ensures that the provided name is comprised entirely of PACKAGE or TYPE category names.
		 * 
		 * @param nameNode The name to check.
		 * @return <code>true</code> if it is; <code>false</code> if it is not.
		 */
		protected boolean checkImportName(NameNode nameNode)
		{
			while (nameNode != null)
			{
				if (nameNode.getCategory() == NameCategory.PACKAGE || nameNode.getCategory() == NameCategory.TYPE)
				{
					if (nameNode instanceof QualifiedNameNode)
					{
						nameNode = ((QualifiedNameNode) nameNode).getBase();
					} else
					{
						nameNode = null;
					}
				} else
				{
					break;
				}
			}

			return nameNode == null;
		}

		@Override
		public NamedTypeDeclarationNode<?> executeCompilationUnitNode(CompilationUnitNode node, List<Node> p)
		{
			if (!this.nodeContainedWithinTypeDeclaration)
			{
				return null;
			}

			// Look over each of the import declarations and see if it affects us. Any import whose name contains a
			// PACKAGE_OR_TYPE_NAME category can be safely ignored since imports will be processed before type
			// declarations and imports do not affect other imports.
			for (ImportNode importNode : node.getImports())
			{
				checkImportName(importNode.getName());
				NamedTypeDeclarationNode<?> ret = importNode.executeOperation(
						new ExplicitImportNodeExaminationOperation(), null);
				if (ret != null)
				{
					return ret;
				}
			}
			// Check on-demand imports after explicit imports because explicit imports shadow on-demand imports.
			for (ImportNode importNode : node.getImports())
			{
				checkImportName(importNode.getName());
				NamedTypeDeclarationNode<?> ret = importNode.executeOperation(
						new OnDemandImportNodeExaminationOperation(), null);
				if (ret != null)
				{
					return ret;
				}
			}

			return null;
		}

		/**
		 * This node operation evaluates explicit imports on behalf of the
		 * {@link #executeCompilationUnitNode(CompilationUnitNode, List)} method.
		 * 
		 * @author Zachary Palmer
		 */
		class ExplicitImportNodeExaminationOperation extends BsjDefaultNodeOperation<Void, NamedTypeDeclarationNode<?>>
		{
			@Override
			public NamedTypeDeclarationNode<?> executeDefault(Node node, Void p)
			{
				return null;
			}

			@Override
			public NamedTypeDeclarationNode<?> executeImportSingleTypeNode(ImportSingleTypeNode node, Void p)
			{
				if (!node.getName().getIdentifier().getIdentifier().equals(name))
					return null;

				return node.executeOperation(new TypeDeclarationLocatingNodeOperation(node.getName()), null);
			}

			@Override
			public NamedTypeDeclarationNode<?> executeSingleStaticImportNode(SingleStaticImportNode node, Void p)
			{
				if (!node.getIdentifier().getIdentifier().equals(name))
					return null;

				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = node.executeOperation(
						new TypeDeclarationLocatingNodeOperation(node.getName()), null);
				if (namedTypeDeclarationNode == null)
				{
					return null;
				}

				return namedTypeDeclarationNode.getTypeDeclaration(node.getIdentifier().getIdentifier());
			}
		}

		/**
		 * This node operation evaluates explicit imports on behalf of the
		 * {@link #executeCompilationUnitNode(CompilationUnitNode, List)} method.
		 * 
		 * @author Zachary Palmer
		 */
		class OnDemandImportNodeExaminationOperation extends BsjDefaultNodeOperation<Void, NamedTypeDeclarationNode<?>>
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
					PackageNode rootPackage = node.getRootPackage();
					if (rootPackage != null)
					{
						PackageNode packageNode = rootPackage.getSubpackageByQualifiedName(node.getName());
						if (packageNode != null)
						{
							return packageNode.getTopLevelTypeDeclaration(name);
						}
					}
					return null;
				} else
				{
					NamedTypeDeclarationNode<?> namedTypeDeclarationNode = node.executeOperation(
							new TypeDeclarationLocatingNodeOperation(node.getName()), null);
					if (namedTypeDeclarationNode == null)
					{
						return null;
					}

					return namedTypeDeclarationNode.getTypeDeclaration(name);
				}
			}

			@Override
			public NamedTypeDeclarationNode<?> executeStaticImportOnDemandNode(StaticImportOnDemandNode node, Void p)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = node.executeOperation(
						new TypeDeclarationLocatingNodeOperation(node.getName()), null);
				if (namedTypeDeclarationNode == null)
				{
					return null;
				}

				return namedTypeDeclarationNode.getTypeDeclaration(name);
			}
		}
	}
}
