package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Map;
import java.util.Map.Entry;

/**
 * This converter converts map entries to pairs.
 * @author Zachary Palmer
 */
public class MapEntryToPairConverter<K,V> implements Converter<Map.Entry<K,V>, Pair<K,V>>
{

	@Override
	public Pair<K, V> convert(Entry<K, V> t)
	{
		return new Pair<K, V>(t.getKey(), t.getValue());
	}
}
