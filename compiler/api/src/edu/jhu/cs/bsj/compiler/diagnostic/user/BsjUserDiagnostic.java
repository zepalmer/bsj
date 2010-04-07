package edu.jhu.cs.bsj.compiler.diagnostic.user;

import java.util.Locale;

import javax.tools.Diagnostic.Kind;

/**
 * This interface is implemented by objects which provide diagnostic information from a metaprogram to the BSJ compiler.
 * The purpose of user diagnostics is to allow metaprograms to provide messages to the invoker of the compiler which are
 * specific to the functionality of the metaprogram in question.
 * @author Zachary Palmer
 */
public interface BsjUserDiagnostic
{
	/**
	 * Retrieves a message which describes this diagnostic.
	 * @param locale The locale for which to format the message or <code>null</code> to use the default system locale.
	 */
	public String getMessage(Locale locale);
	
	/**
	 * Retrieves a string describing the category for this diagnostic.  The meaning of this code is implementation
	 * specific but should be used to distinguish between semantically different diagnostics.
	 * @return The code for this diagnostic.
	 */
	public String getCode();
	
	/**
	 * Retrieves the kind of this diagnostic.  This allows programs to distinguish between warnings, errors, and other
	 * kinds of diagnostic messages.
	 * @return The kind of this diagnostic.
	 */
	public Kind getKind();
}
