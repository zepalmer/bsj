package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A utilities class for collection operations in the BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public class CollectionUtilities
{
	/**
	 * Prevent instantiation of utilities class.
	 */
	private CollectionUtilities()
	{
	}

	/**
	 * Creates a set containing pairs representing the key-value pairs in the provided map.
	 * 
	 * @param map The map containing the key-value pairs.
	 * @return The collection of pairs to use.
	 */
	public static <K, V> Set<Pair<K, V>> getPairSet(Map<K, V> map)
	{
		Set<Pair<K, V>> set = new HashSet<Pair<K, V>>();
		for (Map.Entry<K, V> entry : map.entrySet())
		{
			set.add(new Pair<K, V>(entry.getKey(), entry.getValue()));
		}
		return set;
	}

	/**
	 * Creates a list of exactly zero elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)}. Other variations have value in that they do not generate an unchecked warnings
	 * for parameterized element types (due to the fact that they accept a fixed number of arguments). This method is
	 * provided simply for the sake of completeness. The resulting collection is unique and mutable and guarantees O(1)
	 * indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf()
	{
		return new ArrayList<E>(0);
	}

	/**
	 * Creates a list of exactly one element. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1)
	{
		List<E> list = new ArrayList<E>(1);
		list.add(e1);
		return list;
	}

	/**
	 * Creates a list of exactly two elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2)
	{
		List<E> list = new ArrayList<E>(2);
		list.add(e1);
		list.add(e2);
		return list;
	}

	/**
	 * Creates a list of exactly three elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3)
	{
		List<E> list = new ArrayList<E>(3);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		return list;
	}

	/**
	 * Creates a list of exactly four elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4)
	{
		List<E> list = new ArrayList<E>(4);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		return list;
	}

	/**
	 * Creates a list of exactly five elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5)
	{
		List<E> list = new ArrayList<E>(5);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		return list;
	}

	/**
	 * Creates a list of exactly six elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6)
	{
		List<E> list = new ArrayList<E>(6);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		return list;
	}

	/**
	 * Creates a list of exactly seven elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7)
	{
		List<E> list = new ArrayList<E>(7);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		return list;
	}

	/**
	 * Creates a list of exactly eight elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8)
	{
		List<E> list = new ArrayList<E>(8);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		return list;
	}

	/**
	 * Creates a list of exactly nine elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9)
	{
		List<E> list = new ArrayList<E>(9);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		return list;
	}

	/**
	 * Creates a list of exactly ten elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10)
	{
		List<E> list = new ArrayList<E>(10);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		return list;
	}

	/**
	 * Creates a list of exactly eleven elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11)
	{
		List<E> list = new ArrayList<E>(11);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		list.add(e11);
		return list;
	}

	/**
	 * Creates a list of exactly twelve elements. This method is a convenience mechanism similar to
	 * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
	 * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
	 * guarantees O(1) indexing and amortized tail insertion times.
	 */
	public static <E> List<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12)
	{
		List<E> list = new ArrayList<E>(12);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		list.add(e11);
		list.add(e12);
		return list;
	}
}
