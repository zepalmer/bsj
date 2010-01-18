package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

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

}
