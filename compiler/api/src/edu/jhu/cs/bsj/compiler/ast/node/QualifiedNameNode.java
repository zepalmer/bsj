package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a qualified name, as in
 * <pre>
 * <i>name.ident</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface QualifiedNameNode extends NameNode
{
    /**
     * Gets the name being qualified.
     * @return The name being qualified.
     */
    public NameNode getBase();
    
    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setBase(NameNode base);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedNameNode deepCopy(BsjNodeFactory factory);
    
}
