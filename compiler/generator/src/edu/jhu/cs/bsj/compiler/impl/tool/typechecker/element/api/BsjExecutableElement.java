package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

import java.util.List;

import javax.lang.model.element.ExecutableElement;

/**
 * An interface representing an executable element in the BSJ language.
 * @author Zachary Palmer
 */
public interface BsjExecutableElement extends BsjElement, ExecutableElement
{
	public List<? extends BsjVariableElement> getParameters();
}
