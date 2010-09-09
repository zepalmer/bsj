package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * This class holds references to a series of objects of a given type.  When identical objects are created, they can be
 * quickly discarded by feeding them through this cache; if this cache has a reference to an equal object, it is
 * returned instead.  This is meant to allow frequently created objects to benefit from caching and other information
 * in a non-global way.
 * @author Zachary Palmer
 */
public class ObjectCache<T>
{
	private Map<T,T> map = new HashMap<T,T>();
	
	public <U extends T> U get(U value)
	{
		@SuppressWarnings("unchecked")
		U ret = (U)map.get(value); // known to be safe because we only map things to themselves
		if (ret == null)
		{
			map.put(value,value);
			ret = value;
		}
		return ret;
	}
}
