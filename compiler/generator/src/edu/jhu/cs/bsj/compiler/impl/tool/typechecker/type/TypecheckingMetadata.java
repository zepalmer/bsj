package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * Represents information gathered during typechecking which does not directly affect the type which was produced but
 * which may be significant to the entity requesting the type. Typechecking metadata objects are always composable; as a
 * result, multiple metadata objects may be collected into a single object, allowing simple tree collection of metadata.
 * 
 * @author Zachary Palmer
 */
public class TypecheckingMetadata
{
	/** The mapping between raw code literal nodes and the values that they represent. */
	private Map<RawCodeLiteralNode, BsjType> rawCodeLiteralInContextTypes;
	/** The mapping between raw code literal nodes and the results of their parses. */
	private Map<RawCodeLiteralNode, RawCodeLiteralParseResult> rawCodeLiteralParseResults;

	/**
	 * The set of raw code literals for which the caller is responsible. These code literals do not have an in-context
	 * type. They must either be assigned an in-context type by the receiver or by one of the receiving ancestor calls.
	 */
	private Set<RawCodeLiteralNode> rawCodeLiteralsLackingContext;

	/**
	 * Creates an empty metadata object.
	 */
	public TypecheckingMetadata()
	{
		this.rawCodeLiteralInContextTypes = new HashMap<RawCodeLiteralNode, BsjType>();
		this.rawCodeLiteralParseResults = new HashMap<RawCodeLiteralNode, RawCodeLiteralParseResult>();
		this.rawCodeLiteralsLackingContext = new HashSet<RawCodeLiteralNode>();
	}

	/**
	 * Creates a metadata object which is the composition of the provided objects.
	 * 
	 * @param metadata The metadata objects to use.
	 */
	public TypecheckingMetadata(TypecheckingMetadata... metadata)
	{
		this();
		for (TypecheckingMetadata obj : metadata)
		{
			this.add(obj);
		}
	}

	/**
	 * Retrieves the type in context for the specified code literal.
	 * 
	 * @param rawCodeLiteralNode The code literal in question.
	 * @return The type in context for this code literal or <code>null</code> if no contextual type was established.
	 */
	public BsjType getInContextType(RawCodeLiteralNode rawCodeLiteralNode)
	{
		return this.rawCodeLiteralInContextTypes.get(rawCodeLiteralNode);
	}

	/**
	 * Retrieves the result of parsing a specified code literal.
	 * 
	 * @param rawCodeLiteralNode The code literal in question.
	 * @return The parse results for that code literal.
	 */
	public RawCodeLiteralParseResult getParseResult(RawCodeLiteralNode rawCodeLiteralNode)
	{
		return this.rawCodeLiteralParseResults.get(rawCodeLiteralNode);
	}

	public Set<RawCodeLiteralNode> getRawCodeLiteralsLackingContext()
	{
		return rawCodeLiteralsLackingContext;
	}

	/**
	 * Adds the data in the provided metadata object to this one.
	 */
	public void add(TypecheckingMetadata metadata)
	{
		this.rawCodeLiteralInContextTypes.putAll(metadata.rawCodeLiteralInContextTypes);
		this.rawCodeLiteralParseResults.putAll(metadata.rawCodeLiteralParseResults);
		this.rawCodeLiteralsLackingContext.addAll(metadata.rawCodeLiteralsLackingContext);
	}

	/**
	 * Adds an in-context type mapping to the metadata.  Removes the specified code literal from those lacking context.
	 */
	public void addRawCodeLiteralInContextType(RawCodeLiteralNode rawCodeLiteralNode, BsjType type)
	{
		this.rawCodeLiteralInContextTypes.put(rawCodeLiteralNode, type);
		this.rawCodeLiteralsLackingContext.remove(rawCodeLiteralNode);
	}

	/**
	 * Adds a code literal parse result to the metadata.
	 */
	public void addRawCodeLiteralParseResult(RawCodeLiteralNode rawCodeLiteralNode, RawCodeLiteralParseResult result)
	{
		this.rawCodeLiteralParseResults.put(rawCodeLiteralNode, result);
	}
	
	/**
	 * Adds a code literal to those lacking context.
	 */
	public void addRawCodeLiteralLackingContext(RawCodeLiteralNode node)
	{
		this.rawCodeLiteralsLackingContext.add(node);
	}
}
