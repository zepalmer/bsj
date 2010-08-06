package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a meta-annotation element, as in
 * <pre>
 * <i>ident</i>=<i>value</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationElementNode extends Node, BsjSpecificNode
{
    /**
     * Gets the identifier.
     * @return The identifier.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the identifier.
     * @param identifier The identifier.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets the element's value.
     * @return The element's value.
     */
    public MetaAnnotationValueNode getValue();
    
    /**
     * Changes the element's value.
     * @param value The element's value.
     */
    public void setValue(MetaAnnotationValueNode value);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationElementNode deepCopy(BsjNodeFactory factory);
}
