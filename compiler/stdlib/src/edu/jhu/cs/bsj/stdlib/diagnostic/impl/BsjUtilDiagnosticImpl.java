package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.impl.utils.i18n.InternationalizationUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.i18n.PropertyBasedStringRepository;
import edu.jhu.cs.bsj.stdlib.diagnostic.BsjUtilDiagnostic;

public abstract class BsjUtilDiagnosticImpl implements BsjUtilDiagnostic
{
	/** The code used to describe the event. */
	private String code;
	/** The kind of event which occurred. */
	private javax.tools.Diagnostic.Kind kind;

	/**
	 * Creates a new diagnostic. The provided position is used for the start and end positions.
	 * 
	 * @param location The location of the event.
	 * @param code The code used to describe the event.
	 * @param kind The kind of event which occurred.
	 */
	public BsjUtilDiagnosticImpl(String code, Kind kind)
	{
		this.code = code;
		this.kind = kind;
	}

	/**
	 * Retrieves the code used to describe this diagnostic.
	 * 
	 * @return The code used to describe this diagnostic.
	 */
	@Override
	public String getCode()
	{
		return this.code;
	}

	/**
	 * Retrieves the kind of event which occurred.
	 * 
	 * @return The kind of event which occurred.
	 */
	@Override
	public javax.tools.Diagnostic.Kind getKind()
	{
		return this.kind;
	}

	/**
	 * Retrieves a message for this diagnostic. The message is generated from a classpath properties file's format
	 * string (see {@link PropertyBasedStringRepository}) using this diagnostic's code. The format strings make use of
	 * positional format arguments where necessary to ensure that the appropriate information is used.
	 * @param locale The locale for which to format the message.
	 * @return The resulting message.
	 */
	@Override
	public String getMessage(Locale locale)
	{
		return InternationalizationUtilities.MESSAGE_REPOSITORY.getFormattedMessage(locale, getCode(), getMessageArgs(locale));
	}

	/**
	 * Retrieves arguments which should be used to format the message for this diagnostic.
	 * 
	 * @param locale The locale for which to prepare these arguments (for recursive formatting if necessary).
	 * @return The arguments to use.
	 */
	protected abstract List<Object> getMessageArgs(Locale locale);
}
