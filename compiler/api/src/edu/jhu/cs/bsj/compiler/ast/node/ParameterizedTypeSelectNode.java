package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a type selection from a parameterized type.  This node is used when a type is selected from
 * another type which is parameterized, such as in <tt>A&lt;X&gt;.B</tt>.  In that case, the root node is a
 * <tt>ParameterizedTypeSelectNode</tt>.  The <tt>select</tt> child is an <tt>UnparameterizedTypeNode</tt>
 * containing the name "B"; the <tt>base</tt> child is a {@link ParameterizedTypeNode}.  The <tt>base</tt> has
 * children of an {@link UnparameterizedTypeNode} containing the name "A" and a {@link TypeArgumentListNode} containing the
 * type argument with the name "X".
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ParameterizedTypeSelectNode extends Node, DeclaredTypeNode
{
    /**
     * Gets the parameterized type from which a type is selected.
     * @return The parameterized type from which a type is selected.
     */
    public ParameterizedTypeNode getBase();
    
    /**
     * Changes the parameterized type from which a type is selected.
     * @param base The parameterized type from which a type is selected.
     */
    public void setBase(ParameterizedTypeNode base);
    
    /**
     * Gets the type which is selected from the base.
     * @return The type which is selected from the base.
     */
    public DeclaredTypeNode getSelect();
    
    /**
     * Changes the type which is selected from the base.
     * @param select The type which is selected from the base.
     */
    public void setSelect(DeclaredTypeNode select);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParameterizedTypeSelectNode deepCopy(BsjNodeFactory factory);
}
