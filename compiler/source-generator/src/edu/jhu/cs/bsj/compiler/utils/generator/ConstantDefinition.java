package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a constant method definition.
 * 
 * @author Zachary Palmer
 */
public class ConstantDefinition extends AbstractPropertyDefinition
{
	public ConstantDefinition(String name, String baseType, String typeArg, String description, String defaultExpression)
	{
		super(name, baseType, typeArg, description, defaultExpression);
	}
}
