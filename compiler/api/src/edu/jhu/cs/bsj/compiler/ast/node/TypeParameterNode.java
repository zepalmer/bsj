package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;

/**
 * A node for type parameters, as in:
 * <pre>
 * <i>ident</i>
 * </pre>
 * or
 * <pre>
 * <i>ident</i> extends <i>type</i>
 * </pre>
 * or
 * <pre>
 * <i>ident</i> extends <i>type</i> &amp; <i>type...</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TypeParameterNode extends Node
{
    /**
     * Gets the base type name for the parameter.
     * @return The base type name for the parameter.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the base type name for the parameter.
     * @param identifier The base type name for the parameter.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets the bounds over the base type.
     * @return The bounds over the base type.
     */
    public DeclaredTypeListNode getBounds();
    
    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setBounds(DeclaredTypeListNode bounds);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeParameterNode deepCopy(BsjNodeFactory factory);
    
}
