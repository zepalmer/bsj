package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;


public abstract class AbstractInputSource implements InputSource
{

	@Override
	public void demand(char expected) throws ParseException
	{
		char got = peek();
		if (got != expected)
		{
			throw new ParseException("Expected " + expected + ", got " + got);
		}
		consume();
	}

}
