package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;

/**
 * A common supertype for all nodes representing a name.  In Java, a name is either a simple name (a single
 * identifier) or a qualified name (a name, a dot, and an identifier).  The meaning of a name is context-sensitive
 * and is partially dependent upon type information; therefore, this node maintains information about the facts
 * currently known about this name.
 * <p/>
 * Note that some identifiers are not used as names; as a result, not all identifiers are children of this class
 * or one of its subclasses.  Examples of such cases include variable and type declarations, where the identifier
 * is not technically a name because it is being used to create a name which does not exist.  For more information,
 * please see the Java Language Specification v3.0 &#167;6.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NameNode extends Node
{
    /**
     * Gets the identifier used in this name.
     * @return The identifier used in this name.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the identifier used in this name.
     * @param identifier The identifier used in this name.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NameNode deepCopy(BsjNodeFactory factory);
	/**
	 * Retrieves the category for this node's name.
	 * @return The category into which this node falls.
	 */
	public NameCategory getCategory();
	
	/**
	 * Retrieves a qualified string representation of this name.  For simple names, this is merely the text of the name;
	 * for qualified names, this is a dot-separated name sequence.
	 * @return The qualified representation of this name.
	 */
	public String getNameString();
}
