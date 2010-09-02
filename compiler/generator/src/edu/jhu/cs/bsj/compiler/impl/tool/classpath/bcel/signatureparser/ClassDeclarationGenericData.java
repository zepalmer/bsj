package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;

/**
 * Contains the generic data obtained from a generic signature attached to a class declaration.
 * 
 * @author Zachary Palmer
 */
public class ClassDeclarationGenericData
{
	/** The list of type parameters associated with this class or interface declaration. */
	private TypeParameterListNode typeParams;
	/**
	 * The direct supertype of this node. For class declarations, this is the supertype of the class (if defined). For
	 * interfaces, this is always <code>null</code>.
	 */
	private DeclaredTypeNode directSupertype;
	/**
	 * The supertypes of this node. For class declarations, this is the implements clause. For interface declarations,
	 * this is the extends clause.
	 */
	private DeclaredTypeListNode supertypes;

	public ClassDeclarationGenericData(TypeParameterListNode typeParams, DeclaredTypeNode directSupertype,
			DeclaredTypeListNode supertypes)
	{
		super();
		this.typeParams = typeParams;
		this.directSupertype = directSupertype;
		this.supertypes = supertypes;
	}

	public TypeParameterListNode getTypeParams()
	{
		return typeParams;
	}

	public DeclaredTypeNode getDirectSupertype()
	{
		return directSupertype;
	}

	public DeclaredTypeListNode getSupertypes()
	{
		return supertypes;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("(<");
		boolean first = true;
		for (TypeParameterNode parameter : typeParams)
		{
			if (!first)
				sb.append(',');
			sb.append(parameter.toSourceCode());
			first = false;
		}
		sb.append(">;");
		if (directSupertype != null)
		{
			sb.append(directSupertype.toSourceCode());
		}
		sb.append(";");
		first = true;
		for (DeclaredTypeNode type : supertypes)
		{
			if (!first)
				sb.append(',');
			sb.append(type.toSourceCode());
			first = false;
		}
		sb.append(")");
		return sb.toString();
	}
}
