package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.Collections;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.ParseMapEntry;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * Objects of this class act as an environment for the BSJ type checker. They contain information which is not available
 * to the typechecking operation through the {@link TypecheckerManager}.
 * 
 * @author Zachary Palmer
 */
public class TypecheckerEnvironment
{
	/** The parse map to use. */
	private Map<RawCodeLiteralNode, ParseMapEntry> parseMap;
	/**
	 * The type expected in context from the surrounding nodes.  This is used to check the type of values which are
	 * stored in variable declaration initializers and other such structures.
	 */
	private BsjType expectedType;
	
	/**
	 * Creates a new, empty typechecker environment.
	 */
	public TypecheckerEnvironment()
	{
		super();
		this.parseMap = Collections.emptyMap();
		this.expectedType = null;
	}
	
	/**
	 * Creates a new typechecker environment configured with the provided parameters.
	 * @param parseMap The mapping from raw code literals to their parse map entries.
	 * @param expectedType The expected type defined by context.
	 */
	public TypecheckerEnvironment(Map<RawCodeLiteralNode, ParseMapEntry> parseMap,
			BsjType expectedType)
	{
		super();
		this.parseMap = parseMap;
		this.expectedType = expectedType;
	}

	public Map<RawCodeLiteralNode, ParseMapEntry> getParseMap()
	{
		return parseMap;
	}

	public BsjType getExpectedType()
	{
		return expectedType;
	}
	
	public TypecheckerEnvironment deriveWithParseMap(Map<RawCodeLiteralNode, ParseMapEntry> parseMap)
	{
		return new TypecheckerEnvironment(parseMap, this.expectedType);
	}
	
	public TypecheckerEnvironment deriveWithExpectedType(BsjType type)
	{
		return new TypecheckerEnvironment(this.parseMap, type);
	}

	@Override
	public String toString()
	{
		return "TypecheckerEnvironment [parseMap=" + parseMap + ", expectedType=" + expectedType + "]";
	}
}
