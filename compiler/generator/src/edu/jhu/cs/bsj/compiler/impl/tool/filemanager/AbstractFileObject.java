package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.JavaFileManagerUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.IOUtilities;

/**
 * Acts as a base class for file objects, containing the most common functionality.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractFileObject extends IORegistry implements BsjFileObject
{
	/** The character set that this file object uses. */
	private Charset characterSet;

	/**
	 * Creates an abstract file object.
	 * 
	 * @param encodingName The name of the file encoding to use when reading files or <code>null</code> to use the
	 *            platform's default encoding.
	 */
	protected AbstractFileObject(String encodingName)
	{
		super();
		if (encodingName == null)
		{
			characterSet = Charset.defaultCharset();
		} else
		{
			characterSet = Charset.forName(encodingName);
		}
	}

	/**
	 * Retrieves a character set decoder for this file object.
	 * 
	 * @param ignoreEncodingErrors <code>true</code> to ignore decoding errors; <code>false</code> otherwise.
	 * @return The character set decoder for this abstract file object to use.
	 */
	protected CharsetDecoder getDecoder(boolean ignoreEncodingErrors)
	{
		CharsetDecoder decoder = this.characterSet.newDecoder();
		CodingErrorAction action = ignoreEncodingErrors ? CodingErrorAction.REPLACE : CodingErrorAction.REPORT;
		decoder.onMalformedInput(action);
		decoder.onUnmappableCharacter(action);
		return decoder;
	}

	/**
	 * Retrieves a character set encoder for this file object.
	 * 
	 * @return The character set encoder for this abstract file object to use.
	 */
	protected CharsetEncoder getEncoder()
	{
		CharsetEncoder encoder = this.characterSet.newEncoder();
		return encoder;
	}

	/**
	 * Retrieves an access level hint for this file object. This implementation's hint is always <code>null</code>.
	 * 
	 * @return A hint for this file object's access level.
	 */
	@Override
	public Modifier getAccessLevel()
	{
		return null;
	}

	/**
	 * Determines this file object's kind.
	 * 
	 * @return The kind of file this object represents.
	 */
	@Override
	public Kind getKind()
	{
		return JavaFileManagerUtilities.getKindFor(getName());
	}

	/**
	 * Determines a nesting kind hint for this file object. This implementation's hint is always <code>null</code>.
	 * 
	 * @return A hint for this file object's nesting kind.
	 */
	@Override
	public NestingKind getNestingKind()
	{
		return null;
	}

	/**
	 * Retrieves the contents of this file as a character sequence.
	 * 
	 * @return The contents of this file.
	 */
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException
	{
		InputStream is = this.openInputStream();
		ByteBuffer bb = ByteBuffer.wrap(IOUtilities.readAll(is));
		is.close();
		CharBuffer cb = getDecoder(ignoreEncodingErrors).decode(bb);
		return cb.toString();
	}

	@Override
	public Reader openReader(boolean ignoreEncodingErrors) throws IOException
	{
		InputStream is = this.openInputStream();
		InputStreamReader reader = new InputStreamReader(is, getDecoder(ignoreEncodingErrors));
		return reader;
	}

	@Override
	public Writer openWriter() throws IOException
	{
		OutputStream os = this.openOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(os, getEncoder());
		return writer;
	}

	@Override
	public void setCharContent(CharSequence charSequence) throws IOException
	{
		Writer writer = openWriter();
		writer.append(charSequence);
		writer.close();
	}

	@Override
	public boolean isNameCompatible(String simpleName, Kind kind)
	{
		return getName().endsWith(simpleName + kind.extension);
	}
}
