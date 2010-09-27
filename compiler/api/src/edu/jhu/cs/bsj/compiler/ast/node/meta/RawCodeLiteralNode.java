package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * A node representing an unprocessed code literal.  This literal is not guaranteed to contain parseable
 * Java code and has not yet been assigned a type.  Metaprogrammers should never need to create a node of
 * this type; use {@link CodeLiteralNode} instead.  This node is meant exclusively for handling
 * syntactically ambiguous code literals.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface RawCodeLiteralNode extends Node, LiteralNode<BsjRawCodeLiteralPayload>, BsjSpecificNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public RawCodeLiteralNode deepCopy(BsjNodeFactory factory);
    
}
