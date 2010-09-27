package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * This class represents a property definition.
 * 
 * @author Zachary Palmer
 */
public class PropertyDefinition extends ModalPropertyDefinition<PropertyDefinition>
{
	public PropertyDefinition(String name, String baseType, String typeArg, Mode mode, String description,
			String defaultExpression, boolean allowUnion)
	{
		super(name, baseType, typeArg, mode, description, defaultExpression, allowUnion);
	}

	@Override
	public PropertyDefinition deriveWithBaseType(String type)
	{
		PropertyDefinition def = new PropertyDefinition(getName(), type, getTypeArg(), getMode(), getDescription(),
				getDefaultExpression(), isAllowUnion());
		def.setParentDef(getParentDef());
		return def;
	}

	@Override
	public PropertyDefinition deriveWithTypeArg(String arg)
	{
		PropertyDefinition def = new PropertyDefinition(getName(), getBaseType(), arg, getMode(), getDescription(),
				getDefaultExpression(), isAllowUnion());
		def.setParentDef(getParentDef());
		return def;
	}

}
