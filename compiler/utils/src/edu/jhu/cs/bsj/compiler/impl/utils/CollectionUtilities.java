package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    /**
     * Creates a set of exactly zero elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf()
    {
        return new HashSet<E>(0);
    }

    /**
     * Creates a set of exactly one elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1)
    {
        Set<E> set = new HashSet<E>(1);
        set.add(e1);
        return set;
    }

    /**
     * Creates a set of exactly two elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2)
    {
        Set<E> set = new HashSet<E>(2);
        set.add(e1);
        set.add(e2);
        return set;
    }

    /**
     * Creates a set of exactly three elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3)
    {
        Set<E> set = new HashSet<E>(3);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        return set;
    }

    /**
     * Creates a set of exactly four elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4)
    {
        Set<E> set = new HashSet<E>(4);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        return set;
    }

    /**
     * Creates a set of exactly five elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5)
    {
        Set<E> set = new HashSet<E>(5);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        return set;
    }

    /**
     * Creates a set of exactly six elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5, E e6)
    {
        Set<E> set = new HashSet<E>(6);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        return set;
    }

    /**
     * Creates a set of exactly seven elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7)
    {
        Set<E> set = new HashSet<E>(7);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        return set;
    }

    /**
     * Creates a set of exactly eight elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8)
    {
        Set<E> set = new HashSet<E>(8);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        set.add(e8);
        return set;
    }

    /**
     * Creates a set of exactly nine elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9)
    {
        Set<E> set = new HashSet<E>(9);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        set.add(e8);
        set.add(e9);
        return set;
    }

    /**
     * Creates a set of exactly ten elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10)
    {
        Set<E> set = new HashSet<E>(10);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        set.add(e8);
        set.add(e9);
        set.add(e10);
        return set;
    }

    /**
     * Creates a set of exactly eleven elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11)
    {
        Set<E> set = new HashSet<E>(11);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        set.add(e8);
        set.add(e9);
        set.add(e10);
        set.add(e11);
        return set;
    }

    /**
     * Creates a set of exactly twelve elements. This method is a convenience mechanism similar to
     * {@link Arrays#asList(Object...)} but does not generate an unchecked warning for parameterized element types (due
     * to the fact that it accepts a fixed number of arguments). The resulting collection is unique and mutable and
     * guarantees O(1) addition, removal, and containment-checking times. All provided elements must be hashable.
     */
    public static <E> Set<E> setOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12)
    {
        Set<E> set = new HashSet<E>(12);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        set.add(e8);
        set.add(e9);
        set.add(e10);
        set.add(e11);
        set.add(e12);
        return set;
    }

    /**
     * Creates a map of exactly zero mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf()
    {
        return new HashMap<K,V>(0);
    }

    /**
     * Creates a map of exactly one mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1)
    {
        Map<K,V> map = new HashMap<K,V>(1);
        map.put(k1, v1);
        return map;
    }

    /**
     * Creates a map of exactly two mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2)
    {
        Map<K,V> map = new HashMap<K,V>(2);
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    /**
     * Creates a map of exactly three mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3)
    {
        Map<K,V> map = new HashMap<K,V>(3);                                                                                                                                                   
        map.put(k1, v1);                                                                                                                                                                      
        map.put(k2, v2);                                                                                                                                                                      
        map.put(k3, v3);                                                                                                                                                                      
        return map;                                                                                                                                                                           
    }                                                                                                                                                                                         
                                                                                                                                                                                              
    /**                                                                                                                                                                                       
     * Creates a map of exactly four mappings.  The resulting map is unique and mutable and guarantees O(1) addition,                                                                         
     * removal, and containment-checking times.  All provided keys must be hashable.                                                                                                          
     */                                                                                                                                                                                       
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4)                                                                                                        
    {                                                                                                                                                                                         
        Map<K,V> map = new HashMap<K,V>(4);                                                                                                                                                   
        map.put(k1, v1);                                                                                                                                                                      
        map.put(k2, v2);                                                                                                                                                                      
        map.put(k3, v3);                                                                                                                                                                      
        map.put(k4, v4);
        return map;
    }

    /**
     * Creates a map of exactly five mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5)
    {
        Map<K,V> map = new HashMap<K,V>(5);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    /**
     * Creates a map of exactly six mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6)
    {
        Map<K,V> map = new HashMap<K,V>(6);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return map;
    }

    /**
     * Creates a map of exactly seven mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7)
    {
        Map<K,V> map = new HashMap<K,V>(7);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        return map;
    }

    /**
     * Creates a map of exactly eight mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8)
    {
        Map<K,V> map = new HashMap<K,V>(8);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        return map;
    }

    /**
     * Creates a map of exactly nine mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9)
    {
        Map<K,V> map = new HashMap<K,V>(9);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        return map;
    }

    /**
     * Creates a map of exactly ten mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10)
    {
        Map<K,V> map = new HashMap<K,V>(10);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        return map;
    }

    /**
     * Creates a map of exactly eleven mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11)
    {
        Map<K,V> map = new HashMap<K,V>(11);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        return map;
    }

    /**
     * Creates a map of exactly twelve mappings.  The resulting map is unique and mutable and guarantees O(1) addition,
     * removal, and containment-checking times.  All provided keys must be hashable.
     */
    public static <K,V> Map<K,V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11, K k12, V v12)
    {
        Map<K,V> map = new HashMap<K,V>(12);
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);
        map.put(k8, v8);
        map.put(k9, v9);
        map.put(k10, v10);
        map.put(k11, v11);
        map.put(k12, v12);
        return map;
    }
}
