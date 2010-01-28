package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A note representing a class literal, such as <tt>String.class</tt>.  Note that the BSJ compiler API includes a
 * {@link VoidTypeNode}.  This is technically a violation (as Java does not treat <tt>void</tt> as a type) but
 * allows this node to represent <tt>void.class</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassLiteralNode extends LiteralNode<LiteralizableTypeNode>
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassLiteralNode deepCopy(BsjNodeFactory factory);
}
