package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class ImportNodeImpl extends NodeImpl implements ImportNode
{
    /** The name of the package to import. */
    private NameNode qualifiedName;

    /** The static-ness of the import. */
    private boolean staticImport;

    /** General constructor. */
    public ImportNodeImpl(
            NameNode qualifiedName,
            boolean staticImport)
    {
        super();
        this.qualifiedName = qualifiedName;
        this.staticImport = staticImport;
    }

    /**
     * Gets the name of the package to import.
     * @return The name of the package to import.
     */
    public NameNode getQualifiedName()
    {
        return this.qualifiedName;
    }

    /**
     * Changes the name of the package to import.
     * @param qualifiedName The name of the package to import.
     */
    public void setQualifiedName(NameNode qualifiedName)
    {
        if (this.qualifiedName instanceof NodeImpl)
        {
            ((NodeImpl)this.qualifiedName).setParent(null);
        }
        this.qualifiedName = qualifiedName;
        if (this.qualifiedName instanceof NodeImpl)
        {
            ((NodeImpl)this.qualifiedName).setParent(this);
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
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        this.qualifiedName.receive(visitor);
    }
}
