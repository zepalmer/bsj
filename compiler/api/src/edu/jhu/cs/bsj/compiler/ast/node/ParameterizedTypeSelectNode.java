package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;

/**
 * A node representing a type selection from a parameterized type.  This node is used when a type is selected from
 * another type which is parameterized, such as in <tt>A&lt;X&gt;.B</tt>.  In that case, the root node is a
 * <tt>ParameterizedTypeSelectNode</tt>.  The <tt>select</tt> child is an <tt>UnparameterizedTypeNode</tt>
 * containing the name "B"; the <tt>base</tt> child is a {@link ParameterizedTypeNode}.  The <tt>base</tt> has
 * children of an {@link UnparameterizedTypeNode} containing the name "A" and a {@link TypeArgumentListNode} containing the
 * type argument with the name "X".
 * <p/>
 * As a point of note, <tt>ParameterizedTypeSelectNode</tt>s lead to the right (unlike <tt>NameNode<tt/>s,
 * which lead to the left).  That is, if there are multiple levels of <tt>ParameterizedTypeSelectNode</tt>,
 * the root node's <tt>base</tt> value is the leftmost part of the type (whereas the <tt>identifier</tt>
 * in the root <tt>NameNode</tt> is the rightmost part of the name).
 * <p/>
 * For example, consider the somewhat complex type <tt>A&lt;X,Y&gt;.B.C&lt;Z&gt;.D</tt>.  The root node is
 * a <tt>ParameterizedTypeSelectNode</tt>.  The <tt>base</tt> child for the root is a
 * {@link ParameterizedTypeNode} with an {@link UnparameterizedTypeNode} containing the name "A" and a
 * {@link TypeArgumentListNode} containing type arguments for "X" and "Y".
 * <p/>
 * The <tt>select</tt> child of the root is another <tt>ParameterizedTypeSelectNode</tt>.  It has a
 * <tt>base</tt> child which, in turn, has an {@link UnparameterizedTypeNode} containing the name "B.C" and
 * a {@link TypeArgumentListNode} containing a type argument for "Z".  Finally, the last <tt>select</tt>
 * child is an {@link UnparameterizedTypeNode} containing the name "D".
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
