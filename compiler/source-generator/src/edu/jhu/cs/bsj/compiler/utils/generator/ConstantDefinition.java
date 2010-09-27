package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a constant method definition.
 * 
 * @author Zachary Palmer
 */
public class ConstantDefinition extends AbstractPropertyDefinition<ConstantDefinition>
{
	public ConstantDefinition(String name, String baseType, String typeArg, String description, String defaultExpression,
			boolean allowUnion)
	{
		super(name, baseType, typeArg, description, defaultExpression, allowUnion);
	}

	@Override
	public ConstantDefinition deriveWithBaseType(String type)
	{
		ConstantDefinition def = new ConstantDefinition(getName(), type, getTypeArg(), getDescription(),
				getDefaultExpression(), isAllowUnion());
		def.setParentDef(getParentDef());
		return def;
	}

	@Override
	public ConstantDefinition deriveWithTypeArg(String arg)
	{
		ConstantDefinition def = new ConstantDefinition(getName(), getBaseType(), arg, getDescription(),
				getDefaultExpression(), isAllowUnion());
		def.setParentDef(getParentDef());
		return def;
	}
}
