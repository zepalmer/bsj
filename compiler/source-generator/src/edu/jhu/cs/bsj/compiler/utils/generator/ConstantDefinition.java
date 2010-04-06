package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a constant method definition.
 * 
 * @author Zachary Palmer
 */
public class ConstantDefinition extends AbstractPropertyDefinition<ConstantDefinition>
{
	public ConstantDefinition(String name, String baseType, String typeArg, String description, String defaultExpression)
	{
		super(name, baseType, typeArg, description, defaultExpression);
	}

	@Override
	public ConstantDefinition deriveWithBaseType(String type)
	{
		return new ConstantDefinition(getName(), type, getTypeArg(), getDescription(), getDefaultExpression());
	}

	@Override
	public ConstantDefinition deriveWithTypeArg(String arg)
	{
		return new ConstantDefinition(getName(), getBaseType(), arg, getDescription(), getDefaultExpression());
	}
}
