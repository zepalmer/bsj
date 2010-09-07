package edu.jhu.cs.bsj.compiler.tool.parser.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;

/**
 * A BSJ-specific class which contains data providing a view of an ANTLR token.
 * 
 * @author Zachary Palmer
 */
public class BsjTokenImpl implements Token
{
	private final int channel;
	private final int charPositionInLine;
	private final int line;
	private final String text;
	private final int tokenIndex;
	private final int type;

	public BsjTokenImpl(Token token)
	{
		this(token.getChannel(), token.getCharPositionInLine(), token.getLine(), token.getText(),
				token.getTokenIndex(), token.getType());
	}

	public BsjTokenImpl(int channel, int charPositionInLine, int line, String text, int tokenIndex, int type)
	{
		super();
		this.channel = channel;
		this.charPositionInLine = charPositionInLine;
		this.line = line;
		this.text = text;
		this.tokenIndex = tokenIndex;
		this.type = type;
	}

	@Override
	public int getChannel()
	{
		return channel;
	}

	@Override
	public int getCharPositionInLine()
	{
		return charPositionInLine;
	}

	@Override
	public int getLine()
	{
		return line;
	}

	@Override
	public String getText()
	{
		return text;
	}

	@Override
	public int getTokenIndex()
	{
		return tokenIndex;
	}

	@Override
	public int getType()
	{
		return type;
	}

	@Override
	public CharStream getInputStream()
	{
		return null;
	}

	@Override
	public void setChannel(int arg0)
	{
		throw new IllegalStateException(this.getClass().getName() + " is immutable");
	}

	@Override
	public void setCharPositionInLine(int arg0)
	{
		throw new IllegalStateException(this.getClass().getName() + " is immutable");
	}

	@Override
	public void setInputStream(CharStream arg0)
	{
		throw new IllegalStateException(this.getClass().getName() + " is immutable");
	}

	@Override
	public void setLine(int arg0)
	{
		throw new IllegalStateException(this.getClass().getName() + " is immutable");
	}

	@Override
	public void setText(String arg0)
	{
		throw new IllegalStateException(this.getClass().getName() + " is immutable");
	}

	@Override
	public void setTokenIndex(int arg0)
	{
		throw new IllegalStateException(this.getClass().getName() + " is immutable");
	}

	@Override
	public void setType(int arg0)
	{
		throw new IllegalStateException(this.getClass().getName() + " is immutable");
	}
}
