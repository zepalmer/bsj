package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

import java.util.List;

import javax.lang.model.element.TypeParameterElement;

import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * An interface representing a type parameter element in the BSJ language.
 * @author Zachary Palmer
 */
public interface BsjTypeParameterElement extends BsjTypeLikeElement, TypeParameterElement
{
	public TypeParameterNode getBackingNode();
	
	public List<? extends BsjType> getBounds();

}
