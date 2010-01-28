package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a complete javadoc comment, as in:
 * <pre>
 * /** 
 *  * Methodname.
 *  * @param x parameter x.
 *  * @returns a value.
 *  *&#47;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface JavadocNode extends Node
{
    /**
     * Gets the parsed text of this Javadoc comment.
     * @return The parsed text of this Javadoc comment.
     */
    public String getText();

    /**
     * Changes the parsed text of this Javadoc comment.
     * @param text The parsed text of this Javadoc comment.
     */
    public void setText(String text);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public JavadocNode deepCopy(BsjNodeFactory factory);
}
