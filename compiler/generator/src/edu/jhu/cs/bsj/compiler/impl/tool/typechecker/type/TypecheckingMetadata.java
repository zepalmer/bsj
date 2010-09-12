package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;

/**
 * Represents information gathered during typechecking which does not directly affect the type which was produced but
 * which may be significant to the entity requesting the type.  Typechecking metadata objects are always composable; as
 * a result, multiple metadata objects may be collected into a single object, allowing simple tree collection of metadata.
 * @author Zachary Palmer
 */
public class TypecheckingMetadata
{
	/** The mapping between raw code literal nodes and the values that they represent. */
	private Map<RawCodeLiteralNode, RawCodeLiteralRecord> rawCodeLiteralRecordMap;
	
	/**
	 * Creates an empty metadata object.
	 */
	public TypecheckingMetadata()
	{
		this.rawCodeLiteralRecordMap = new HashMap<RawCodeLiteralNode, RawCodeLiteralRecord>();
	}
	
	/**
	 * Creates a metadata object which is the composition of the provided objects.
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
	
	public Map<RawCodeLiteralNode, RawCodeLiteralRecord> getRawCodeLiteralRecordMap()
	{
		return Collections.unmodifiableMap(rawCodeLiteralRecordMap);
	}

	/**
	 * Adds the data in the provided metadata object to this one.
	 */
	public void add(TypecheckingMetadata metadata)
	{
		this.rawCodeLiteralRecordMap.putAll(metadata.getRawCodeLiteralRecordMap());
	}
	
	/**
	 * Adds a raw code literal mapping to this metadata.
	 */
	public void addRawCodeLiteralRecord(RawCodeLiteralNode rawCodeLiteralNode, RawCodeLiteralRecord record)
	{
		this.rawCodeLiteralRecordMap.put(rawCodeLiteralNode, record);
	}
}
