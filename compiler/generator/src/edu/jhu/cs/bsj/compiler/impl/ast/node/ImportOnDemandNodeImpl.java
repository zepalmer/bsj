package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ImportOnDemandNodeImpl extends NodeImpl implements ImportOnDemandNode
{
    /** The name of the package to import. */
    private NameNode name;

    /** The static-ness of the import. */
    private boolean staticImport;

    /** General constructor. */
    public ImportOnDemandNodeImpl(
            NameNode name,
            boolean staticImport,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setName(name);
        this.staticImport = staticImport;
    }

    /**
     * Gets the name of the package to import.
     * @return The name of the package to import.
     */
    public NameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of the package to import.
     * @param name The name of the package to import.
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
        if (this.name != null)
        {
            this.name.receive(visitor);
        }
    }

    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.name != null)
        {
            this.name.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitImportOnDemandNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitImportNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitImportNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitImportOnDemandNodeStop(this, true);
        visitor.visitStopEnd(this);
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
        list.add(getName());
        list.add(getStaticImport());
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
        sb.append(this.getName() == null? "null" : this.getName().getClass().getSimpleName());
        sb.append(',');
        sb.append("staticImport=");
        sb.append(String.valueOf(this.getStaticImport()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }

    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeImportOnDemandNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ImportOnDemandNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeImportOnDemandNode(
                getName().deepCopy(factory),
                getStaticImport());
    }
}
