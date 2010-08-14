package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * A class representing the erased method signature of a method. This is used as the key value in the method namespace
 * map.
 * 
 * @author Zachary Palmer
 */
public class ErasedMethodSignature
{
	/** The name of the method. */
	private String name;
	/** The elements representing the erased types of the method's arguments. */
	private List<BsjType> erasedTypes;

	public ErasedMethodSignature(String name, List<BsjType> erasedTypes)
	{
		super();
		this.name = name;
		this.erasedTypes = erasedTypes;
	}

	/**
	 * Creates a new signature using the provided element. If a namespace map is provided, it is used to resolve the
	 * types of the element's parameters. Otherwise, the element's backing manager is used.
	 * 
	 * @param element The element for which a signature is desired.
	 */
	public ErasedMethodSignature(BsjExecutableElement element)
	{
		super();
		this.name = element.getSimpleName().toString();
		this.erasedTypes = new ArrayList<BsjType>();
		for (BsjVariableElement variable : element.getParameters())
		{
			BsjType type = variable.asType();
			this.erasedTypes.add(type.calculateErasure());
		}
	}

	public String getName()
	{
		return name;
	}

	public List<BsjType> getErasedTypes()
	{
		return Collections.unmodifiableList(erasedTypes);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append("(");
		boolean first = true;
		for (BsjType type : this.erasedTypes)
		{
			if (!first)
				sb.append(",");
			sb.append(type.toString());
			first = false;
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((erasedTypes == null) ? 0 : erasedTypes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErasedMethodSignature other = (ErasedMethodSignature) obj;
		if (erasedTypes == null)
		{
			if (other.erasedTypes != null)
				return false;
		} else if (!erasedTypes.equals(other.erasedTypes))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
