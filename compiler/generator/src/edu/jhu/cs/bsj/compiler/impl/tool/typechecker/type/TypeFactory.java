package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;

/**
 * This factory is an indirection over the creation of {@link BsjType} implementation classes. It provides, among other
 * features, caching of type objects so that individual objects are not needlessly replicated. This is particularly
 * useful for caches and other such constructs on the type objects themselves, as it ensures that they are reused.
 * 
 * @author Zachary Palmer
 */
public class TypeFactory
{
	private TypecheckerManager manager;

	public TypeFactory(TypecheckerManager manager)
	{
		super();
		this.manager = manager;
	}
	
	// TODO: move all of the other type creation operations here as well

	private static class MakeExplicitlyDeclaredTypeCacheKey
	{
		private BsjTypeElement typeElement;
		private List<? extends BsjTypeArgument> typeArguments;
		private BsjExplicitlyDeclaredType enclosingType;

		public MakeExplicitlyDeclaredTypeCacheKey(BsjTypeElement typeElement,
				List<? extends BsjTypeArgument> typeArguments, BsjExplicitlyDeclaredType enclosingType)
		{
			super();
			this.typeElement = typeElement;
			this.typeArguments = typeArguments;
			this.enclosingType = enclosingType;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((enclosingType == null) ? 0 : enclosingType.hashCode());
			result = prime * result + ((typeArguments == null) ? 0 : typeArguments.hashCode());
			result = prime * result + ((typeElement == null) ? 0 : typeElement.hashCode());
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
			MakeExplicitlyDeclaredTypeCacheKey other = (MakeExplicitlyDeclaredTypeCacheKey) obj;
			if (enclosingType == null)
			{
				if (other.enclosingType != null)
					return false;
			} else if (!enclosingType.equals(other.enclosingType))
				return false;
			if (typeArguments == null)
			{
				if (other.typeArguments != null)
					return false;
			} else if (!typeArguments.equals(other.typeArguments))
				return false;
			if (typeElement == null)
			{
				if (other.typeElement != null)
					return false;
			} else if (!typeElement.equals(other.typeElement))
				return false;
			return true;
		}
	}

	private Map<MakeExplicitlyDeclaredTypeCacheKey, BsjExplicitlyDeclaredType> makeExplicitlyDeclaredTypeCache = new HashMap<TypeFactory.MakeExplicitlyDeclaredTypeCacheKey, BsjExplicitlyDeclaredType>();

	public BsjExplicitlyDeclaredType makeExplicitlyDeclaredType(BsjTypeElement typeElement,
			List<? extends BsjTypeArgument> typeArguments, BsjExplicitlyDeclaredType enclosingType)
	{
		MakeExplicitlyDeclaredTypeCacheKey key = new MakeExplicitlyDeclaredTypeCacheKey(typeElement, typeArguments,
				enclosingType);
		BsjExplicitlyDeclaredType type = makeExplicitlyDeclaredTypeCache.get(key);
		if (type == null)
		{
			type = new DeclaredTypeImpl(manager, typeElement, typeArguments, enclosingType);
			makeExplicitlyDeclaredTypeCache.put(key, type);
		}
		return type;
	}
}
