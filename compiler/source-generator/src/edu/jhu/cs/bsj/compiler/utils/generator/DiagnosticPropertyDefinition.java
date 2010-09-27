package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * Represents a property on a diagnostic definition.
 * 
 * @author Zachary Palmer
 */
public class DiagnosticPropertyDefinition extends ModalPropertyDefinition<DiagnosticPropertyDefinition>
{
	/**
	 * The expression which should be used in place of this property when generating the parameters to the diagnostic's
	 * message generation routine. <code>null</code> indicates that the property itself should be used. If not null, the
	 * character <code>$</code> is used to represent the name of this property.
	 */
	private String messageExpression;

	public DiagnosticPropertyDefinition(String name, String baseType, String typeArg, Mode mode, String description,
			String defaultExpression, String messageExpression)
	{
		super(name, baseType, typeArg, mode, description, defaultExpression, false);
		this.messageExpression = messageExpression;
	}

	public String getMessageExpression()
	{
		return messageExpression;
	}

	@Override
	public DiagnosticPropertyDefinition deriveWithBaseType(String type)
	{
		DiagnosticPropertyDefinition def = new DiagnosticPropertyDefinition(getName(), type, getTypeArg(), getMode(), getDescription(),
				getDefaultExpression(), getMessageExpression());
		def.setParentDef(getParentDef());
		return def;
	}

	@Override
	public DiagnosticPropertyDefinition deriveWithTypeArg(String arg)
	{
		DiagnosticPropertyDefinition def = new DiagnosticPropertyDefinition(getName(), getBaseType(), arg, getMode(), getDescription(),
				getDefaultExpression(), getMessageExpression());
		def.setParentDef(getParentDef());
		return def;
	}
}
