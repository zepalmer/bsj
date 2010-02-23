package edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;

public class EnclosingTypeNamingNodeOperation extends BsjDefaultNodeOperation<Void, NameNode>
{
	/** The node factory to use when creating the name. */
	private BsjNodeFactory factory;
	
	public EnclosingTypeNamingNodeOperation(BsjNodeFactory factory)
	{
		super();
		this.factory = factory;
	}

	@Override
	public NameNode executeDefault(Node node, Void p)
	{
		EnclosingTypeNameBuildingAncestorOperation op = new EnclosingTypeNameBuildingAncestorOperation();
		node.executeOperation(new AncestryExecutingNodeOperation<Void>(op), null);
		return op.getNode();
	}

	private final class EnclosingTypeNameBuildingAncestorOperation extends BsjDefaultNodeOperation<List<Node>, Void>
	{
		// TODO: handle anonymous inner classes correctly
		private NameNode node = null;
		private boolean seenTypeDeclarationYet = false;

		@Override
		public Void executeDefault(Node node, List<Node> p)
		{
			return null;
		}

		private void addComponent(String component, NameCategory category)
		{
			if (node == null)
			{
				node = factory.makeSimpleNameNode(factory.makeIdentifierNode(component), category);
			} else
			{
				node = factory.makeQualifiedNameNode(node, factory.makeIdentifierNode(component), category);
			}
		}

		public NameNode getNode()
		{
			return node;
		}

		@Override
		public Void executeAnnotationDeclarationNode(AnnotationDeclarationNode node, List<Node> p)
		{
			handleNamedTypeDeclarationNode(node);
			return null;
		}

		@Override
		public Void executeClassDeclarationNode(ClassDeclarationNode node, List<Node> p)
		{
			handleNamedTypeDeclarationNode(node);
			return null;
		}

		@Override
		public Void executeEnumDeclarationNode(EnumDeclarationNode node, List<Node> p)
		{
			handleNamedTypeDeclarationNode(node);
			return null;
		}

		@Override
		public Void executeInterfaceDeclarationNode(InterfaceDeclarationNode node, List<Node> p)
		{
			handleNamedTypeDeclarationNode(node);
			return null;
		}

		private void handleNamedTypeDeclarationNode(NamedTypeDeclarationNode<?> node)
		{
			seenTypeDeclarationYet = true;
			addComponent(node.getIdentifier().getIdentifier(), NameCategory.TYPE);
		}

		@Override
		public Void executeCompilationUnitNode(CompilationUnitNode node, List<Node> p)
		{
			if (!seenTypeDeclarationYet)
				addComponent(node.getName(), NameCategory.TYPE);
			return null;
		}

		@Override
		public Void executePackageNode(PackageNode node, List<Node> p)
		{
			addComponent(node.getName().getIdentifier(), NameCategory.PACKAGE);
			return null;
		}
	}

}
