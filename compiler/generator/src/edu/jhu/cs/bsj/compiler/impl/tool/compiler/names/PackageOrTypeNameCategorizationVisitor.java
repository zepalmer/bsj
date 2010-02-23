package edu.jhu.cs.bsj.compiler.impl.tool.compiler.names;

import java.util.List;

import org.apache.log4j.Logger;

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

	@Override
	public void visitNameNodeStop(NameNode node)
	{
		if (node instanceof SimpleNameNode)
		{
			// If a type is in scope which has the same name as this node, the node refers to a type. Otherwise, this
			// node refers to a package.
			// TODO
		} else if (node instanceof QualifiedNameNode)
		{
			// If the base name of this node refers to a package or type containing a member type matching the name of
			// this node's identifier, then this node refers to a type. Otherwise, it refers to a package.
			// TODO
		} else
		{
			throw new IllegalStateException("Unrecognized node type: " + node.getClass().getName());
		}
	}

	/**
	 * This node operation determines whether or not the provided node is the ancestor of a node which is within the
	 * scope of a type declaration of the given name. It is intended to be used in conjunction with an
	 * {@link AncestryExecutingNodeOperation}. The return is either <code>null</code> if it is not or the node which
	 * creates the declaration of the type if it is.
	 * 
	 * @author Zachary Palmer
	 */
	static class TypeScopeCheckingOperation extends BsjDefaultNodeOperation<List<Node>, Node>
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
		public Node executeDefault(Node node, List<Node> p)
		{
			return null;
		}

		@Override
		public Node executeAnnotationDeclarationNode(AnnotationDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		@Override
		public Node executeClassDeclarationNode(ClassDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		@Override
		public Node executeEnumDeclarationNode(EnumDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		@Override
		public Node executeInterfaceDeclarationNode(InterfaceDeclarationNode node, List<Node> p)
		{
			return evaluateNamedTypeDeclarationNode(node);
		}

		protected Node evaluateNamedTypeDeclarationNode(NamedTypeDeclarationNode<?> node)
		{
			if (node.getIdentifier().equals(name))
				return node;

			this.nodeContainedWithinTypeDeclaration = true;
			return null;
		}

		@Override
		public Node executeCompilationUnitNode(CompilationUnitNode node, List<Node> p)
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
				NameNode nameNode = importNode.getName();
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
				if (nameNode != null)
				{
					// We found an import with a name that does not yet apply
					continue;
				}

				Node ret = importNode.executeOperation(new ImportNodeExaminationOperation(), null);
				if (ret != null)
				{
					return ret;
				}
			}

			return null;
		}

		/**
		 * This node operation evaluates imports on behalf of the
		 * {@link #executeCompilationUnitNode(CompilationUnitNode, List)} method.
		 * 
		 * @author Zachary Palmer
		 */
		class ImportNodeExaminationOperation extends BsjDefaultNodeOperation<Void, Node>
		{
			@Override
			public Node executeDefault(Node node, Void p)
			{
				return null;
			}

			private PackageNode getPackageForNameNode(NameNode name)
			{
				if (name.getCategory() != NameCategory.PACKAGE)
				{
					return null;
				}
				// Get the root package from the name
				Node node = name;
				while (node.getParent() != null)
				{
					node = node.getParent();
				}
				if (!(node instanceof PackageNode) || (((PackageNode) node).getName() != null))
				{
					return null;
				} else
				{
					return ((PackageNode) node).getSubpackageByQualifiedName(name.getNameString());
				}
			}

			private NamedTypeDeclarationNode<?> getTypeDeclForNameNode(NameNode name)
			{
				if (name.getCategory() != NameCategory.TYPE)
				{
					return null;
				}

				if (name instanceof SimpleNameNode)
				{
					SimpleNameNode simpleNameNode = (SimpleNameNode) name;
					// Find the first package above our name
					Node node = name;
					while (node != null && !(node instanceof PackageNode))
					{
						node = node.getParent();
					}
					if (node == null)
					{
						// If there is no common package, the name doesn't refer to anything
						return null;
					}
					PackageNode packageNode = (PackageNode) node;
					// Get the compilation unit for that type
					CompilationUnitNode compilationUnitNode = packageNode.getCompilationUnit(simpleNameNode.getIdentifier().getIdentifier());
					for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
					{
						if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
						{
							NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
							if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(
									simpleNameNode.getIdentifier().getIdentifier()))
							{
								return namedTypeDeclarationNode;
							}
						}
					}
					return null;
				} else if (name instanceof QualifiedNameNode)
				{
					QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) name;
					NamedTypeDeclarationNode<?> namedTypeDeclarationNode = getTypeDeclForNameNode(qualifiedNameNode.getBase());
					if (namedTypeDeclarationNode == null)
						return null;
					// Now qualify that type declaration (such as Map.Entry)
					for (Node member : namedTypeDeclarationNode.getBody().getMembers())
					{
						if (member instanceof NamedTypeDeclarationNode<?>)
						{
							NamedTypeDeclarationNode<?> memberDecl = (NamedTypeDeclarationNode<?>) member;
							if (memberDecl.getIdentifier().getIdentifier().equals(
									qualifiedNameNode.getIdentifier().getIdentifier()))
							{
								return memberDecl;
							}
						}
					}
					return null;
				} else
				{
					throw new IllegalArgumentException("Unknown name node type: " + name.getClass());
				}
			}

			@Override
			public Node executeImportOnDemandNode(ImportOnDemandNode node, Void p)
			{
				// TODO Auto-generated method stub
				return super.executeImportOnDemandNode(node, p);
			}

			@Override
			public Node executeImportSingleTypeNode(ImportSingleTypeNode node, Void p)
			{
				// TODO Auto-generated method stub
				return super.executeImportSingleTypeNode(node, p);
			}

			@Override
			public Node executeSingleStaticImportNode(SingleStaticImportNode node, Void p)
			{
				// TODO Auto-generated method stub
				return super.executeSingleStaticImportNode(node, p);
			}

			@Override
			public Node executeStaticImportOnDemandNode(StaticImportOnDemandNode node, Void p)
			{
				// TODO Auto-generated method stub
				return super.executeStaticImportOnDemandNode(node, p);
			}
		}
	}
}
