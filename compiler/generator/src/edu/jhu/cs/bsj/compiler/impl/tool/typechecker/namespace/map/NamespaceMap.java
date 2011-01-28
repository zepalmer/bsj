package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * Represents a BSJ namespace map. This interface represents an object which can describe elements in a namespace from a
 * specific point in the AST. Such objects become invalid if the underlying AST is changed (to permit them to perform
 * caching operations).
 * <p/>
 * A namespace has two type parameters: the type of the key used to define entries in the namespace map and a type
 * representing the corresponding element. Additionally, all keys must be reducible to a {@link String} known as a
 * <i>simple name</i>. Elements may be queried by key or by simple name.
 * 
 * @author Zachary Palmer
 * 
 * @param <K> The type of names in this namespace.
 * @param <V> The type of element named by this namespace.
 */
public interface NamespaceMap<K, V extends BsjElement>
{
    /**
     * Retrieves a collection of all keys in this namespace map which are mapped to a value.
     * 
     * @return The keys for this namespace map.
     */
    public Collection<K> getKeys();

    /**
     * Retrieves a collection of all keys in this namespace map which have a given name and are mapped to a value.
     * 
     * @param name The name to use.
     * @return The keys with the given name for this namespace map.
     */
    public Collection<K> getKeysBySimpleName(String name);

    /**
     * Retrieves all values mapped to a given key in this namespace map.
     * 
     * @param key The key to use.
     * @return The values for the key.
     */
    public Collection<V> getValues(K key);

    /**
     * Retrieves all values mapped to a given key in this namespace map tupled with the nodes that indicated them.
     * 
     * @param key The key to use.
     * @return Pairings between the values for this key and those nodes which indicated them.
     */
    public Collection<Pair<V, Node>> getIndicatedValues(K key);

    /**
     * Retrieves all values mapped to a given simple name in this namespace map.
     * 
     * @param name The simple name to use.
     * @return The values for the name.
     */
    public Collection<V> getValuesBySimpleName(String name);

    /**
     * Retrieves all values mapped to a given simple name in this namespace map.
     * 
     * @param name The simple name to use.
     * @return The values for the name.
     */
    public Collection<Pair<V, Node>> getIndicatedValuesBySimpleName(String name);

    /**
     * Checks this namespace for ambiguities and produces appropriate diagnostics if they exist. This routine will fully
     * populate the namespace map.
     */
    public void checkAmbiguities();

    /**
     * Determines whether or not an entry for the given name exists in this map.
     * 
     * @param key The name of the entry.
     * @return <code>true</code> if that entry exists; <code>false</code> if it does not.
     */
    public boolean contains(K key);

    /**
     * Retrieves a type element based on a name in this namespace.
     * 
     * @param key The name to use.
     * @param sourceLocation The source location of the node which indicates this name.
     * @return The corresponding type element or <code>null</code> if the specified key is not mapped.
     */
    public V lookup(K key, BsjSourceLocation sourceLocation);

    /**
     * Determines whether or not this namespace map prohibits overlap. If a namespace map which prohibits overlap defers
     * to another namespace map which also prohibits overlap, requests for a value held by the upper lap will also
     * return values held by the lower map. This should be used in cases such as local variable mapping, where the
     * declaration of two variables named <tt>foo</tt> is an ambiguity (even if they are declared in different blocks).
     * 
     * @return <code>true</code> if this namespace map prohibits overlap; <code>false</code> if it does not.
     */
    public boolean prohibitsOverlap();

    /**
     * Obtains a string representation of this namespace map.
     */
    public String toString();

    /**
     * Obtains a collection of those keys which are already populated within this namespace map.
     */
    public Collection<K> getPopulatedKeys();

    /**
     * Determines whether or not this map has been fully populated.
     * 
     * @return <code>true</code> if this map is definitely fully populated; <code>false</code> if there may yet be some
     *         unknown values.
     */
    public boolean isFullyPopulated();
}