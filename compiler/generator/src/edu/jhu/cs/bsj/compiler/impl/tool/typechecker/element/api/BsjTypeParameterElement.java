package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

import java.util.List;

import javax.lang.model.element.TypeParameterElement;

import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

/**
 * An interface representing a type parameter element in the BSJ language.
 * @author Zachary Palmer
 */
public interface BsjTypeParameterElement extends BsjTypeLikeElement, TypeParameterElement
{
	public TypeParameterNode getBackingNode();
	
	public List<? extends BsjTypeArgument> getBounds();
	
	public BsjTypeVariable asType();
	
	/**
	 * Creates a type which represents the most general upper bound of this type parameter.  If the components of the
	 * upper bound contain type parameters, 
	 * @return
	 */
	public BsjTypeArgument createUpperBoundType();

}
