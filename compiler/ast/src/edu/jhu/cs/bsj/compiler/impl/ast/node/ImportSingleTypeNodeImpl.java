package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class ImportSingleTypeNodeImpl extends NodeImpl implements ImportSingleTypeNode
{
    /** The name of the type to import. */
    private NameNode name;

    /** The static-ness of the import. */
    private boolean staticImport;

    /** General constructor. */
    public ImportSingleTypeNodeImpl(
            NameNode name,
            boolean staticImport)
    {
        super();
        this.name = name;
        this.staticImport = staticImport;
    }

    /**
     * Gets the name of the type to import.
     * @return The name of the type to import.
     */
    public NameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of the type to import.
     * @param name The name of the type to import.
     */
    public void setName(NameNode name)
    {
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(null);
        }
        this.name = name;
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(this);
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
        this.name.receive(visitor);
    }

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.name);
        list.add(this.staticImport);
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("name=");
        sb.append(this.name == null? "null" : this.name.getClass().getSimpleName());
        sb.append(',');
        sb.append("staticImport=");
        sb.append(String.valueOf(this.staticImport) + ":" + "boolean");
        return sb.toString();
    }
}
