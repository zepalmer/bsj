package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a property definition.
 * 
 * @author Zachary Palmer
 */
public class PropertyDefinition extends ModalPropertyDefinition
{
	public PropertyDefinition(String name, String baseType, String typeArg, Mode mode, String description,
			String defaultExpression)
	{
		super(name, baseType, typeArg, mode, description, defaultExpression);
	}
}
