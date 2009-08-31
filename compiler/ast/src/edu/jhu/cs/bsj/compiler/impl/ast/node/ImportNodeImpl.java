package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class ImportNodeImpl extends NodeImpl implements ImportNode
{
    /** The identifier to import. */
    private NameNode qualifiedIdentifier;

    /** The static-ness of the import. */
    private boolean staticImport;

    /** General constructor. */
    public ImportNodeImpl(
            NameNode qualifiedIdentifier,
            boolean staticImport)
    {
        super();
        this.qualifiedIdentifier = qualifiedIdentifier;
        this.staticImport = staticImport;
    }

    /**
     * Gets the identifier to import.
     * @return The identifier to import.
     */
    public NameNode getQualifiedIdentifier()
    {
        return this.qualifiedIdentifier;
    }

    /**
     * Changes the identifier to import.
     * @param qualifiedIdentifier The identifier to import.
     */
    public void setQualifiedIdentifier(NameNode qualifiedIdentifier)
    {
        if (this.qualifiedIdentifier instanceof NodeImpl)
        {
            ((NodeImpl)this.qualifiedIdentifier).setParent(null);
        }
        this.qualifiedIdentifier = qualifiedIdentifier;
        if (this.qualifiedIdentifier instanceof NodeImpl)
        {
            ((NodeImpl)this.qualifiedIdentifier).setParent(this);
        }
    }

    /**
     * Gets the static-ness of the import.
     * @return The static-ness of the import.
     */
    public boolean getStaticImport()
    {
        return this.staticImport;
    }

    /**
     * Changes the static-ness of the import.
     * @param staticImport The static-ness of the import.
     */
    public void setStaticImport(boolean staticImport)
    {
        this.staticImport = staticImport;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
