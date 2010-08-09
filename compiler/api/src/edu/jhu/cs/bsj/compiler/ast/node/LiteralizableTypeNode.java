package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This tagging interface is used to denote AST nodes which refer to a type which can be used to define a class
 * literal (such as <tt>String.class</tt>, <tt>int.class</tt>, or <tt>String[].class</tt>).  Note that
 * parameterized types may not be used to create literals; that is, <tt>Set&lt;String&gt;.class</tt> is illegal.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface LiteralizableTypeNode extends Node, TypeNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LiteralizableTypeNode deepCopy(BsjNodeFactory factory);
    
}
