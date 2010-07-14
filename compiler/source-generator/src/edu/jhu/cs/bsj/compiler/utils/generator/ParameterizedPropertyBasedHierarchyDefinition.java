package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ParameterizedPropertyBasedHierarchyDefinition<T extends PropertyBasedHierarchyDefinition<T, U> & IParameterizedPropertyBasedHierarchyDefinition<T, U>, U extends AbstractPropertyDefinition<U>>
		extends PropertyBasedHierarchyDefinition<T, U> implements IParameterizedPropertyBasedHierarchyDefinition<T, U>
{
	private String baseName;
	private String typeParameter;
	private String superName;
	private String superTypeArg;
	private List<TagReferenceDefinition> tags;

	public ParameterizedPropertyBasedHierarchyDefinition(String baseName, String typeParameter, String superName,
			String superTypeArg, List<TagReferenceDefinition> tags)
	{
		super();
		this.baseName = baseName;
		this.typeParameter = typeParameter;
		this.superName = superName;
		this.superTypeArg = superTypeArg;
		this.tags = tags;
	}

	public String getFullName()
	{
		if (typeParameter == null)
		{
			return baseName;
		} else
		{
			return baseName + "<" + typeParameter + ">";
		}
	}

	public String getFullSuper()
	{
		if (superTypeArg == null)
		{
			return superName;
		} else
		{
			return superName + "<" + superTypeArg + ">";
		}
	}

	public String getUnboundedTypeParameter()
	{
		if (typeParameter == null)
		{
			return null;
		} else
		{
			if (typeParameter.indexOf(' ') != -1)
			{
				return typeParameter.substring(0, typeParameter.indexOf(' '));
			} else
			{
				return typeParameter;
			}
		}
	}

	public String getTypeParameterUpperBound()
	{
		if (typeParameter == null)
		{
			return null;
		}
		String[] s = typeParameter.trim().split("\\s+");
		if (s.length < 3)
		{
			return null;
		}
		if (!s[1].equals("extends"))
		{
			return null;
		}
		return s[2];
	}

	public String getUnboundedSuperTypeArg()
	{
		if (superTypeArg == null)
		{
			return null;
		} else
		{
			if (superTypeArg.indexOf(' ') != -1)
			{
				return superTypeArg.substring(0, superTypeArg.indexOf(' '));
			} else
			{
				return superTypeArg;
			}
		}
	}

	public String getTypeParameterWithDelimiters()
	{
		if (typeParameter == null)
		{
			return "";
		} else
		{
			return "<" + typeParameter + ">";
		}
	}

	public String getNameWithTypeParameters()
	{
		if (typeParameter == null)
		{
			return getBaseName();
		} else
		{
			return getBaseName() + "<" + getUnboundedTypeParameter() + ">";
		}
	}

	public String getBaseName()
	{
		return baseName;
	}

	public String getTypeParameter()
	{
		return typeParameter;
	}

	public String getBaseSuperName()
	{
		return superName;
	}

	public String getSuperTypeArg()
	{
		return superTypeArg;
	}

	public List<TagReferenceDefinition> getTags()
	{
		return tags;
	}

	public String getSuperName()
	{
		return superName;
	}

	@Override
	public List<U> getRecursiveProperties(boolean parentFirst)
	{
		List<U> props = super.getRecursiveProperties(parentFirst);
		Map<String, String> typeArgMap = new HashMap<String, String>();
		IParameterizedPropertyBasedHierarchyDefinition<T, U> def = this;
		while (def != null && def.getParent() != null)
		{
			if (def.getSuperTypeArg() != null && def.getParent().getTypeParameter() != null)
			{
				String typeParam = def.getParent().getTypeParameter();
				if (typeParam.indexOf(' ') != -1)
					typeParam = typeParam.substring(0, typeParam.indexOf(' '));
				// Hack to allow multiple levels of type arguments... as long as they're the same letter
				if (!typeParam.equals(def.getSuperTypeArg())) // avoid storing T=T
				{
					typeArgMap.put(typeParam, def.getSuperTypeArg());
				}
			}
			for (TagReferenceDefinition tag : def.getTags())
			{
				if (tag.getTypeArg() != null)
				{
					typeArgMap.put(getNamespaceMap().get(tag.getName()).getTypeParameter(), tag.getTypeArg());
				}
			}
			def = def.getParent();
		}

		for (int i = 0; i < props.size(); i++)
		{
			U propdef = props.get(i);
			if (typeArgMap.containsKey(propdef.getBaseType()))
			{
				propdef = propdef.deriveWithBaseType(typeArgMap.get(propdef.getBaseType()));
			}
			if (typeArgMap.containsKey(propdef.getTypeArg()))
			{
				propdef = propdef.deriveWithTypeArg(typeArgMap.get(propdef.getTypeArg()));
			}
			props.set(i, propdef);
		}

		return props;
	}
}
