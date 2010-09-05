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
	 * The type expected from an array initializer. This value is set by nodes entering contexts in which a
	 * variable initializer is legal and is used to discern the expected type of the initializer expressions.  For
	 * instance, this value would be <tt>int[]</tt> in the initializer context of <tt>int[] x = {1,2};</tt>.
	 */
	private BsjType arrayInitializerComponentType;
	
	/**
	 * Creates a new, empty typechecker environment.
	 */
	public TypecheckerEnvironment()
	{
		super();
		this.parseMap = Collections.emptyMap();
		this.arrayInitializerComponentType = null;
	}
	
	/**
	 * Creates a new typechecker environment configured with the provided parameters.
	 * @param parseMap The mapping from raw code literals to their parse map entries.
	 * @param arrayInitializerComponentType The expected type for an array initializer.
	 */
	public TypecheckerEnvironment(Map<RawCodeLiteralNode, ParseMapEntry> parseMap,
			BsjType arrayInitializerComponentType)
	{
		super();
		this.parseMap = parseMap;
		this.arrayInitializerComponentType = arrayInitializerComponentType;
	}

	public Map<RawCodeLiteralNode, ParseMapEntry> getParseMap()
	{
		return parseMap;
	}

	public BsjType getArrayInitializerType()
	{
		return arrayInitializerComponentType;
	}
	
	public TypecheckerEnvironment deriveWithArrayInitializerType(BsjType type)
	{
		return new TypecheckerEnvironment(this.parseMap, type);
	}
}
