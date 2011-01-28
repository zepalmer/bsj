package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractInvokableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeParameterElement;

// TODO: this didn't really work out the way we wanted; we should just have different methods for each element we build
// (probably in the modeling factory) to better ensure type safety rather than having an operation.  Eliminate this
// class.
public class ElementBuildingNodeOperation extends BsjDefaultNodeOperation<Void, BsjElement>
{
	public static final Collection<Class<? extends Node>> VALID_NODE_TYPES;
	static
	{
		Set<Class<? extends Node>> classes = new HashSet<Class<? extends Node>>();
		classes.add(NamedTypeDeclarationNode.class);
		classes.add(AnonymousClassBodyNode.class);
		classes.add(VariableDeclaratorNode.class);
		classes.add(VariableNode.class);
		classes.add(EnumConstantDeclarationNode.class);
		classes.add(MethodDeclarationNode.class);
		classes.add(ConstructorDeclarationNode.class);
		classes.add(AnnotationMethodDeclarationNode.class);
		classes.add(InitializerDeclarationNode.class);
		classes.add(PackageNode.class);
		classes.add(TypeParameterNode.class);
		VALID_NODE_TYPES = Collections.unmodifiableSet(classes);
	}

	private TypecheckerManager manager;

	public ElementBuildingNodeOperation(TypecheckerManager manager)
	{
		super();
		this.manager = manager;
	}

	private Node findImmediatelyEnclosingType(Node node)
	{
		return node.getNearestAncestorOfTypes(new TwoElementImmutableSet<Class<? extends Node>>(
				NamedTypeDeclarationNode.class, AnonymousClassBodyNode.class));
	}

	private Node findImmediatelyEnclosingElementNode(Node node)
	{
		return node.getNearestAncestorOfTypes(VALID_NODE_TYPES);
	}

	private BsjElement findImmediatelyEnclosingElement(Node node)
	{
		return findImmediatelyEnclosingElementNode(node).executeOperation(this, null);
	}

	@Override
	public BsjElement executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Void p)
	{
		return new DeclaredAnnotationTypeElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, Void p)
	{
		return new AnnotationMethodExecutableElementImpl(this.manager, node,
				(BsjDeclaredTypeElement) findImmediatelyEnclosingType(node).executeOperation(this, null));
	}

	@Override
	public BsjElement executeAnonymousClassBodyNode(AnonymousClassBodyNode node, Void p)
	{
		return new AnonymousClassTypeElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeClassDeclarationNode(ClassDeclarationNode node, Void p)
	{
		return new DeclaredClassTypeElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeConstructorDeclarationNode(ConstructorDeclarationNode node, Void p)
	{
		return new ConstructorExecutableElementImpl(this.manager, node, (BsjDeclaredTypeElement) findImmediatelyEnclosingType(
				node).executeOperation(this, null));
	}

	@Override
	public BsjElement executeDefault(Node node, Void p)
	{
		return null;
	}

	@Override
	public BsjElement executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, Void p)
	{
		return new EnumConstantVariableElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeEnumDeclarationNode(EnumDeclarationNode node, Void p)
	{
		return new DeclaredEnumTypeElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeInitializerDeclarationNode(InitializerDeclarationNode node, Void p)
	{
		return new InitializerExecutableElementImpl(this.manager, node, (BsjDeclaredTypeElement) findImmediatelyEnclosingType(
				node).executeOperation(this, null));
	}

	@Override
	public BsjElement executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Void p)
	{
		return new DeclaredInterfaceTypeElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeLocalClassDeclarationNode(LocalClassDeclarationNode node, Void p)
	{
		return new DeclaredLocalClassTypeElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeMethodDeclarationNode(MethodDeclarationNode node, Void p)
	{
		return new MethodExecutableElementImpl(this.manager, node, findImmediatelyEnclosingType(node).executeOperation(
				this, null));
	}

	@Override
	public BsjElement executePackageNode(PackageNode node, Void p)
	{
		return new PackageElementImpl(this.manager, node);
	}

	@Override
	public BsjTypeParameterElement executeTypeParameterNode(TypeParameterNode node, Void p)
	{
		return new TypeParameterElementImpl(this.manager, node, findImmediatelyEnclosingElement(node));
	}

	@Override
	public BsjElement executeVariableDeclaratorNode(VariableDeclaratorNode node, Void p)
	{
		VariableDeclaratorOwnerNode ownerNode = node.getNearestAncestorOfType(VariableDeclaratorOwnerNode.class);
		int index = ownerNode.getDeclarators().indexOf(node);
		if (ownerNode instanceof LocalVariableDeclarationNode)
		{
			return new LocalVariableElementImpl(this.manager, (LocalVariableDeclarationNode) ownerNode,
					findImmediatelyEnclosingElement(ownerNode), index);
		} else if (ownerNode instanceof FieldDeclarationNode)
		{
			return new FieldVariableElementImpl(this.manager, (FieldDeclarationNode) ownerNode,
					findImmediatelyEnclosingElement(ownerNode), index);
		} else if (ownerNode instanceof ConstantDeclarationNode)
		{
			return new ConstantVariableElementImpl(this.manager, (ConstantDeclarationNode) ownerNode,
					findImmediatelyEnclosingElement(ownerNode), index);
		} else
		{
			throw new IllegalStateException("Don't know how to handle variable declarator owner of type "
					+ ownerNode.getClass());
		}
	}

	@Override
	public BsjElement executeVariableNode(VariableNode node, Void p)
	{
		boolean isVarArgs = (node.getParent() instanceof AbstractInvokableDeclarationNode<?>)
				&& ((AbstractInvokableDeclarationNode<?>) node.getParent()).getVarargParameter().equals(node);
		return new ActualVariableElementImpl(this.manager, node, findImmediatelyEnclosingElement(node), isVarArgs);
	}
}
