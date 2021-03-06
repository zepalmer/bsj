package edu.jhu.cs.bsj.compiler.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the identifier used in this name.
     * @return A union object representing The identifier used in this name.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier used in this name.
     * @param identifier The identifier used in this name.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier used in this name.
     * @param identifier The identifier used in this name.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NameNode deepCopy(BsjNodeFactory factory);
    
    /**
     * Retrieves the category for this node's name.
     * 
     * @param info The information used to load compilation units when determining the name category. This may be
     *            necessary if, for example, the meaning of the name is determined by an on-demand import.
     * @return The category into which this node falls.
     */
    public NameCategory getCategory(CompilationUnitLoadingInfo info);

    /**
     * Retrieves a qualified string representation of this name. For simple names, this is merely the text of the name;
     * for qualified names, this is a dot-separated name sequence.
     * 
     * @return The qualified representation of this name.
     */
    public String getNameString();
 
    /**
     * Retrieves a list of name components for this name.  The first element in the list is the root of the name; that
     * is, <tt>edu.jhu.bsj</tt> would produce <tt>["edu", "jhu", "bsj"]</tt>.
     * @return The name components for this name.
     */
    public List<String> getNameComponents();
}
