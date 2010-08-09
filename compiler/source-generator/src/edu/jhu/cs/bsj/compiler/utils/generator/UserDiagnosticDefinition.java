package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.List;

/**
 * This class represents the definition for a BSJ diagnostic.
 * 
 * @author Zachary Palmer
 */
public class UserDiagnosticDefinition extends AbstractDiagnosticDefinition<UserDiagnosticDefinition>
{
	public UserDiagnosticDefinition(String baseName, String typeParameter, String superName, String superTypeArg,
			String constructorFooter, GenerationProfile profile, List<DiagnosticPropertyDefinition> properties,
			List<MessagePropertyExpressionDefinition> messagePropertyExpressions, String docString, String code)
	{
		super(baseName, typeParameter, superName, superTypeArg, constructorFooter, profile, properties,
				messagePropertyExpressions, docString, code);
	}
}
