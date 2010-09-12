package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * This class contains information pertaining to a raw code literal in typechecking. After the raw code literal is
 * processed, information is recorded regarding the values which were parsed from its token sequence and which values
 * were valid candidates for the selection conversion.
 * 
 * @author Zachary Palmer
 */
public class RawCodeLiteralRecord
{
	/** A mapping between BSJ node types and the values which were produced for them. */
	private Map<BsjType, Node> typeToValueMap;
	/** The set of values which were appropriate in context. */
	private Set<Node> inContextValues;
	/** The in-context type at the code literal. */
	private BsjType inContextType;

	public RawCodeLiteralRecord(Map<BsjType, Node> typeToValueMap, Set<Node> inContextValues, BsjType inContextType)
	{
		super();
		this.typeToValueMap = Collections.unmodifiableMap(typeToValueMap);
		this.inContextValues = inContextValues;
		this.inContextType = inContextType;
	}

	public Map<BsjType, Node> getTypeToValueMap()
	{
		return typeToValueMap;
	}

	public Set<Node> getInContextValues()
	{
		return inContextValues;
	}

	public BsjType getInContextType()
	{
		return inContextType;
	}

}
