package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class AnnotationMethodExecutableElementImpl extends AbstractExecutableElementImpl<AnnotationMethodDeclarationNode>
{
	public AnnotationMethodExecutableElementImpl(TypecheckerModelManager manager,
			AnnotationMethodDeclarationNode backingNode, BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public BsjType asType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return makeAnnotationMirrors(getBackingNode().getModifiers().getAnnotations());
	}

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		return Collections.emptyList();
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.METHOD;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getBackingNode().getIdentifier().getIdentifier());
	}

	@Override
	public AnnotationValue getDefaultValue()
	{
		return AbstractAnnotationValueImpl.makeForNode(getManager(), getBackingNode().getDefaultValue());
	}

	@Override
	public List<? extends BsjVariableElement> getParameters()
	{
		return Collections.emptyList();
	}

	@Override
	public TypeMirror getReturnType()
	{
		return getTypeBuilder().makeType(getBackingNode().getType());
	}

	@Override
	public List<? extends TypeMirror> getThrownTypes()
	{
		return Collections.emptyList();
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		return Collections.emptyList();
	}

	@Override
	public boolean isVarArgs()
	{
		return false;
	}
}
