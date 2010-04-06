package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.i18n.InternationalizationUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.i18n.PropertyBasedStringRepository;

/**
 * An abstract base class used for convenient creation of BSJ diagnostics.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of source represented by this diagnostic.
 */
public abstract class BsjDiagnosticImpl implements BsjDiagnostic
{
	/** The location of the event. */
	private BsjSourceLocation location;
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
	public BsjDiagnosticImpl(BsjSourceLocation location, String code, Kind kind)
	{
		this.location = location;
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
	 * Retrieves the column number at which the event occurred.
	 * 
	 * @return The column number of the event or {@link Diagnostic#NOPOS} if this information is not available.
	 */
	@Override
	public long getColumnNumber()
	{
		return this.location != null ? this.location.getColumn() : Diagnostic.NOPOS;
	}

	/**
	 * Retrieves the last character index from the beginning of the resource which is involved in the event.
	 * 
	 * @return The last character index of the event or {@link Diagnostic#NOPOS} if this information is not available.
	 */
	@Override
	public long getEndPosition()
	{
		return Diagnostic.NOPOS;
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
	 * Retrieves the line number of the event.
	 * 
	 * @return The line number of the event or {@link Diagnostic#NOPOS} if this information is not available.
	 */
	@Override
	public long getLineNumber()
	{
		return this.location != null ? this.location.getLine() : Diagnostic.NOPOS;
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
		String formatString = InternationalizationUtilities.MESSAGE_REPOSITORY.lookup(locale, getCode());
		if (formatString == null)
		{
			// try to produce a default message in English with a warning
			formatString = InternationalizationUtilities.MESSAGE_REPOSITORY.lookup(Locale.US, getCode());
			if (formatString == null)
			{
				// no hope! no hope!
				StringBuilder sb = new StringBuilder("(could not get string for key " + getCode() + "; [");
				boolean first = true;
				for (Object arg : getMessageArgs(locale))
				{
					if (first)
					{
						first = false;
					} else
					{
						sb.append(',');
					}
					sb.append(arg);
				}
				sb.append("])");
				return sb.toString();
			}
			// 
			formatString = "(no strings found for language=" + locale.getDisplayLanguage() + ") " + formatString;
		}

		List<Object> args = getMessageArgs(locale);
		String message = String.format(locale, formatString, args.toArray());

		StringBuilder sb = new StringBuilder();
		if (this.location == null)
		{
			sb.append("<unknown>");
		} else
		{
			sb.append(this.location.toString());
		}
		sb.append(": ");
		sb.append(message);
		return sb.toString();
	}

	/**
	 * Retrieves arguments which should be used to format the message for this diagnostic.
	 * 
	 * @param locale The locale for which to prepare these arguments (for recursive formatting if necessary).
	 * @return The arguments to use.
	 */
	protected abstract List<Object> getMessageArgs(Locale locale);

	/**
	 * Retrieves the character index from the beginning of the file at which the event occurred.
	 * 
	 * @return The character index of the event or {@link Diagnostic#NOPOS} if this information is not available.
	 */
	@Override
	public long getPosition()
	{
		return Diagnostic.NOPOS;
	}

	/**
	 * Retrieves the source of the event.
	 * 
	 * @return The source of the event.
	 */
	@Override
	public BsjSourceLocation getSource()
	{
		return this.location;
	}

	/**
	 * Retrieves the index of the first character from the beginning of the resource which is involved in this event.
	 * 
	 * @return The first character index of the event or {@link Diagnostic#NOPOS} if this information is not available.
	 */
	@Override
	public long getStartPosition()
	{
		return Diagnostic.NOPOS;
	}
}
