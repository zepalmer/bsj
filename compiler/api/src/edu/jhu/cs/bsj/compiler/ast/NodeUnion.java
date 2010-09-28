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
     * An enumeration listing the types of objects which can be contained in a {@link NodeUnion}.
     */
    public static enum Type
    {
    NORMAL,
    SPLICE,
    }
    
}
