package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralNode;

/**
 * A node representing an unprocessed code literal.  This literal is not guaranteed to contain parseable
 * Java code and has not yet been assigned a type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface RawCodeLiteralNode extends LiteralNode<String>
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public RawCodeLiteralNode deepCopy(BsjNodeFactory factory);
}
