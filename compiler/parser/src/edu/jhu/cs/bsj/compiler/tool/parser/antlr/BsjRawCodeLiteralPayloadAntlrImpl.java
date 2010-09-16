package edu.jhu.cs.bsj.compiler.tool.parser.antlr;

import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;

/**
 * Represents the type of raw code literal payload used in the standard BSJ compiler implementation. Specifically, this
 * payload contains ANTLR tokens.
 * 
 * @author Zachary Palmer
 */
public class BsjRawCodeLiteralPayloadAntlrImpl implements BsjRawCodeLiteralPayload
{
	private String resourceName;
	private List<BsjTokenImpl> tokens;

	public BsjRawCodeLiteralPayloadAntlrImpl(String resourceName, List<BsjTokenImpl> tokens)
	{
		super();
		this.resourceName = resourceName;
		this.tokens = Collections.unmodifiableList(tokens);
	}

	public String getResourceName()
	{
		return resourceName;
	}

	public List<BsjTokenImpl> getTokens()
	{
		return tokens;
	}

	@Override
	public String toString()
	{
		if (this.tokens.size() == 0)
		{
			return "";
		}
		// reconstruct the code from tokens!
		int line = this.tokens.get(0).getLine();
		int col = this.tokens.get(0).getCharPositionInLine() + 1;
		StringBuffer sb = new StringBuffer();
		for (BsjTokenImpl token : this.tokens)
		{
			while (line < token.getLine())
			{
				sb.append('\n');
				line++;
				col = 1;
			}
			
			while (col < token.getCharPositionInLine() + 1)
			{
				sb.append(' ');
				col++;
			}
			
			sb.append(token.getText());
			col += token.getText().length();
		}
		
		return sb.toString();
	}
}
