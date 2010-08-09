package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.lang.model.element.NestingKind;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;

public class TypeBuildingNodeOperation extends BsjDefaultNodeOperation<Void, TypeMirror>
{
	private TypecheckerModelManager manager;

	public TypeBuildingNodeOperation(TypecheckerModelManager manager)
	{
		super();
		this.manager = manager;
	}

	@Override
	public TypeMirror executeArrayTypeNode(ArrayTypeNode node, Void p)
	{
		return new ArrayTypeImpl(this.manager, node.getType().executeOperation(this, p));
	}

	@Override
	public TypeMirror executeDefault(Node node, Void p)
	{
		return null;
	}

	@Override
	public TypeMirror executeParameterizedTypeNode(ParameterizedTypeNode node, Void p)
	{
		NamedTypeDeclarationNode<?> typeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
				node.getBaseType().getName(),
				this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
		return makeDeclarationTypeFromDeclaration(typeDeclaration, node.getTypeArguments(), null);
	}

	@Override
	public TypeMirror executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Void p)
	{
		TypeMirror accumulatedType = null;
		DeclaredTypeNode iterativeNode = node;

		// Each iteration of this loop will handle the left-hand branch and then descend recursively into the right
		// branch
		while (iterativeNode instanceof ParameterizedTypeSelectNode)
		{
			// Add the current iterator value onto our accumulator
			ParameterizedTypeSelectNode parameterizedSelectNode = (ParameterizedTypeSelectNode) iterativeNode;
			NamedTypeDeclarationNode<?> typeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
					parameterizedSelectNode.getBase().getBaseType().getName(),
					this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
			accumulatedType = makeDeclarationTypeFromDeclaration(typeDeclaration,
					parameterizedSelectNode.getBase().getTypeArguments(), accumulatedType);
			
			// Move iteration forward
			iterativeNode = parameterizedSelectNode.getSelect();
		}
		
		// At this point, we know the selectNode is not a ParameterizedSelectNode because we have exited the loop.  We
		// just need to handle the last selection and we're done.
		if (iterativeNode instanceof UnparameterizedTypeNode)
		{
			UnparameterizedTypeNode nextSelect = (UnparameterizedTypeNode) iterativeNode;
			NamedTypeDeclarationNode<?> nextTypeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
					nextSelect.getName(),
					this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
			accumulatedType = makeDeclarationTypeFromDeclaration(nextTypeDeclaration,
					Collections.<TypeArgumentNode> emptySet(), accumulatedType);
		} else if (iterativeNode instanceof ParameterizedTypeNode)
		{
			ParameterizedTypeNode nextSelect = (ParameterizedTypeNode) iterativeNode;
			NamedTypeDeclarationNode<?> nextTypeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
					nextSelect.getBaseType().getName(),
					this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
			accumulatedType = makeDeclarationTypeFromDeclaration(nextTypeDeclaration, nextSelect.getTypeArguments(),
					accumulatedType);
		} else
		{
			throw new IllegalStateException("Don't know how to handle select type of " + iterativeNode.getClass());
		}
		
		return accumulatedType;
	}

	@Override
	public TypeMirror executePrimitiveTypeNode(PrimitiveTypeNode node, Void p)
	{
		return new PrimitiveTypeImpl(this.manager, node.getPrimitiveType());
	}

	@Override
	public TypeMirror executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Void p)
	{
		NamedTypeDeclarationNode<?> typeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
				node.getName(), this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
		return makeDeclarationTypeFromDeclaration(typeDeclaration, Collections.<TypeArgumentNode> emptySet(), null);
	}

	@Override
	public TypeMirror executeVoidTypeNode(VoidTypeNode node, Void p)
	{
		return NoTypeImpl.makeVoid(this.manager);
	}

	private TypeMirror makeDeclarationTypeFromDeclaration(NamedTypeDeclarationNode<?> typeDeclaration,
			Collection<? extends TypeArgumentNode> typeArgumentNodes, TypeMirror providedEnclosingType)
	{
		BsjTypeElement typeElement = (BsjTypeElement) this.manager.getToolkit().makeElement(
				typeDeclaration);
		TypeMirror enclosingType;
		if (providedEnclosingType != null)
		{
			enclosingType = providedEnclosingType;
		} else if (typeElement.getNestingKind() == NestingKind.MEMBER)
		{
			enclosingType = typeDeclaration.getNearestAncestorOfType(NamedTypeDeclarationNode.class).executeOperation(
					this, null);
		} else
		{
			enclosingType = null;
		}

		List<TypeMirror> typeArguments;
		if (typeArgumentNodes.size() > 0)
		{
			typeArguments = new ArrayList<TypeMirror>();
			for (TypeArgumentNode argument : typeArgumentNodes)
			{
				typeArguments.add(argument.executeOperation(this, null));
			}
		} else
		{
			typeArguments = Collections.<TypeMirror> emptyList();
		}

		return new DeclaredTypeImpl(this.manager, typeElement, typeArguments, enclosingType);
	}

	@Override
	public TypeMirror executeWildcardTypeNode(WildcardTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return super.executeWildcardTypeNode(node, p);
	}
}
