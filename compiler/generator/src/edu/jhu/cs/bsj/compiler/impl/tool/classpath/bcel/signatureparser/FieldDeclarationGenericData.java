package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;

import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

/**
 * Contains the generic data obtained from a generic signature attached to a class declaration.
 * 
 * @author Zachary Palmer
 */
public class FieldDeclarationGenericData
{
	/** The type of the field. */
	private TypeNode type;

	public FieldDeclarationGenericData(TypeNode type)
	{
		super();
		this.type = type;
	}

	public TypeNode getType()
	{
		return type;
	}

	public String toString()
	{
		return this.type.toSourceCode();
	}
}
