/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;

/**
 * Represents a union type between a normal AST node and the special quasi-node values (splice and error nodes).
 * @author Zachary Palmer
 * @param <T> The type of normal node that this union represents if it represents a normal node.
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NodeUnion<T extends Node>
{
    /**
     * Retrieves the node value from this union.  This method will retrieve whatever object is stored in this union,
     * regardless of its type.
     * @return The object stored in this union.
     */
    public Node getNodeValue();
    
    /**
     * Retrieves the normal node value from this union.  If this union does not represent a normal node value, an
     * exception is thrown.
     * @return The normal node value of this union.
     * @throws ClassCastException If this node union does not represent a normal node.
     */
    public T getNormalNode() throws ClassCastException;
    
    /**
     * Retrieves the splice node value from this union.  If this union does not represent a splice node value, an
     * exception is thrown.
     * @return The splice node value of this union.
     * @throws ClassCastException If this node union does not represent a splice node.
     */
    public SpliceNode getSpliceNode() throws ClassCastException;
    
    /**
     * Determines the type of object contained in this union.
     * @return An enum value describing the type of object contained in this union.
     */
    public Type getType();
    
    /**
     * Casts the type of the node contained within this union to another type.
     * @param factory The factory to use to create the new object.
     * @param type The type to which to cast.
     * @return The resulting union object.
     * @throws ClassCastException If that cast is not legal.
     */
    public <E extends Node> NodeUnion<E> castNodeType(BsjNodeFactory factory, Class<E> type);
    
    /**
     * An enumeration listing the types of objects which can be contained in a {@link NodeUnion}.
     */
    public static enum Type
    {
        NORMAL,
        SPLICE,
    }
    
}
