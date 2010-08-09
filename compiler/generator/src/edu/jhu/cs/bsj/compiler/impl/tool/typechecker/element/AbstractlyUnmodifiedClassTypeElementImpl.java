package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuildingNodeOperation;

public abstract class AbstractlyUnmodifiedClassTypeElementImpl<T extends AbstractlyUnmodifiedClassDeclarationNode<?>>
		extends DeclaredTypeElementImpl<T>
{
	public AbstractlyUnmodifiedClassTypeElementImpl(TypecheckerModelManager manager, T backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.CLASS;
	}

	@Override
	public TypeMirror getSuperclass()
	{
		if (getBackingNode().getExtendsClause() != null)
		{
			return getBackingNode().getExtendsClause().executeOperation(new TypeBuildingNodeOperation(getManager()),
					null);
		} else
		{
			NamedTypeDeclarationNode<?> objectDeclaration = getManager().getToolkit().findTopLevelTypeByName("java", "lang", "Object");
			if (objectDeclaration.getUid() == getBackingNode().getUid())
			{
				return null;
			} else
			{
				return makeElement(objectDeclaration).asType();
			}
		}
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (DeclaredTypeNode declaredTypeNode : getBackingNode().getImplementsClause())
		{
			list.add(declaredTypeNode.executeOperation(new TypeBuildingNodeOperation(getManager()), null));
		}
		return list;
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		List<TypeParameterElement> list = new ArrayList<TypeParameterElement>();
		for (TypeParameterNode typeParameterNode : getBackingNode().getTypeParameters())
		{
			list.add((TypeParameterElement) makeElement(typeParameterNode));
		}
		return list;
	}
}