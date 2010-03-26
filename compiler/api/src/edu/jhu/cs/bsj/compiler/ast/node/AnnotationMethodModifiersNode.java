package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with an annotation method.  As all annotation methods
 * are implicitly <tt>public</tt> and <tt>abstract</tt> and these are the only legal modifiers, no flags
 * exist for annotation methods.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationMethodModifiersNode extends ModifiersNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationMethodModifiersNode deepCopy(BsjNodeFactory factory);
}
