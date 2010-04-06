package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a property definition.
 * 
 * @author Zachary Palmer
 */
public class PropertyDefinition extends ModalPropertyDefinition<PropertyDefinition>
{
	public PropertyDefinition(String name, String baseType, String typeArg, Mode mode, String description,
			String defaultExpression)
	{
		super(name, baseType, typeArg, mode, description, defaultExpression);
	}

	@Override
	public PropertyDefinition deriveWithBaseType(String type)
	{
		return new PropertyDefinition(getName(), type, getTypeArg(), getMode(), getDescription(), getDefaultExpression());
	}

	@Override
	public PropertyDefinition deriveWithTypeArg(String arg)
	{
		return new PropertyDefinition(getName(), getBaseType(), arg, getMode(), getDescription(), getDefaultExpression());
	}
	
	
}
