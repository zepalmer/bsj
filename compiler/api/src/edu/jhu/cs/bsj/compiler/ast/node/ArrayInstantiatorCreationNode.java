package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;

/**
 * Represents the creation of an array with instantiator, as in
 * <pre>
 * new <i>type</i> [<i>expression</i>]... []...
 * </pre>
 * Levels for this array creator refer to square braces without initializers,
 * for example <code>new int[2][][]</code> would have two levels.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ArrayInstantiatorCreationNode extends ArrayCreationNode
{
    /**
     * Gets the dimension expressions for this array.
     * @return The dimension expressions for this array.
     */
    public ExpressionListNode getDimExpressions();
    
    /**
     * Changes the dimension expressions for this array.
     * @param dimExpressions The dimension expressions for this array.
     */
    public void setDimExpressions(ExpressionListNode dimExpressions);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayInstantiatorCreationNode deepCopy(BsjNodeFactory factory);
}
