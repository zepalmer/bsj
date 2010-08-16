package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.ParseMapEntry;

/**
 * Objects of this class act as an environment for the BSJ type checker.  They contain information which is not
 * available to the typechecking operation through the {@link TypecheckerManager}.
 * 
 * @author Zachary Palmer
 */
public class TypecheckerEnvironment
{
	/** The parse map to use. */
	private Map<RawCodeLiteralNode, ParseMapEntry> parseMap;

	public TypecheckerEnvironment(Map<RawCodeLiteralNode, ParseMapEntry> parseMap)
	{
		super();
		this.parseMap = parseMap;
	}

	public Map<RawCodeLiteralNode, ParseMapEntry> getParseMap()
	{
		return parseMap;
	}
}
