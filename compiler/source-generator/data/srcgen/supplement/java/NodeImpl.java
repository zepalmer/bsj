/* GEN:headerstart */
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.*;

import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;

import edu.jhu.cs.bsj.compiler.impl.utils.MultiMap;

/* GEN:headerstop */

public abstract class NodeImpl
{
    /* GEN:start */
    /**
     * The next globally unique UID to assign.
     */
    private static AtomicLong sUid = new AtomicLong(0);

    /**
     * The unique ID of this node.
     */
    private long uid = sUid.getAndIncrement();

    /**
     * Assigns this node a UID.
     */
    private BsjNodeProxyFactory proxyFactory;

    /**
     * The backing node over which to proxy (if one exists).
     */
    private Node backingNode;

    /**
     * The parent for this node.
     */
    private Node parent = null;
    /**
     * A variable indicating whether or not the <code>parent</code> variable has ever been populated from the backing
     * node. This field is meaningless if this node is not a proxy.
     */
    private boolean parentPopulated = false;

    public boolean equals(Object object)
    {
        if (object instanceof NodeImpl)
        {
            NodeImpl other = (NodeImpl) object;
            return (this.uid == other.uid);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return (int) this.uid;
    }

    public void receive(BsjNodeVisitor visitor)
    {
        visitor.visitStart(this);
        receiveToChildren(visitor);
        visitor.visitStop(this);
    }

    /**
     * Used to obtain an iterator of additional children of this node that visitors should visit. The default
     * implementation specifies no additional children.
     * 
     * @return An iterator of children that visitors to this node should visit. If <code>null</code>, no additional
     *         children are used.
     */
    protected Iterator<? extends Node> getHiddenVisitorChildren()
    {
        return new EmptyIterator<Node>();
    }

    public long getUid()
    {
        return this.uid;
    }

    protected BsjNodeProxyFactory getProxyFactory()
    {
        return this.proxyFactory;
    }

    protected Node getBackingNode()
    {
        return this.backingNode;
    }

    public Node getParent()
    {
        checkParentWrapped();
        return this.parent;
    }

    private void checkParentWrapped()
    {
        if (this.backingNode != null && !this.parentPopulated)
        {
            this.parentPopulated = true;
            this.parent = this.proxyFactory.makeNode(this.backingNode.getParent());
        }
    }

    /**
     * Changes the parent node reference object for this node.
     * 
     * @param node The parent node for this node.
     */
    public void setParent(Node node)
    {
        checkParentWrapped();
        if (this.parent != null && node != null && this.parent.getUid() != node.getUid())
        {
            throw new MultipleParentNodeExceptionImpl(node, this);
        }
        // Note: we don't need to record an edit to the parent property here. This is because the parent property is
        // only updated in accordance with other properties, so the edits that are recorded for them will suffice.
        this.parent = node;
    }

    protected void setAsChild(Node node, boolean child)
    {
        if (node instanceof NodeImpl)
        {
            ((NodeImpl) node).setParent(child ? this : null);
        } else if (node != null)
        {
            // TODO: throw an exception indicating a heterogeneous tree?
        }
    }

    public <N> N getNearestAncestorOfType(Class<N> nodeClass)
    {
        return getNearestAncestorOfType(nodeClass, null);
    }

    public <N> N getNearestAncestorOfType(Class<N> nodeClass, List<? super Node> list)
    {
        return this.getNearestAncestorOfTypes(Collections.<Class<? extends N>> singletonList(nodeClass), list);
    }

    public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses)
    {
        return getNearestAncestorOfTypes(nodeClasses, null);
    }

    public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses, List<? super Node> list)
    {
        List<Node> nodeList = new ArrayList<Node>();
        Node node = this.getParent();
        while (node != null)
        {
            Class<? extends N> nodeClass = null;
            for (Class<? extends N> candidateClass : nodeClasses)
            {
                if (candidateClass.isInstance(node))
                {
                    nodeClass = candidateClass;
                    break;
                }
            }
            if (nodeClass != null)
            {
                if (list != null)
                {
                    list.addAll(nodeList);
                }
                return nodeClass.cast(node);
            }
            nodeList.add(node);
            node = node.getParent();
        }
        return null;
    }

    public Node getFurthestAncestor()
    {
        Node node = this;
        while (node.getParent() != null)
        {
            node = node.getParent();
        }
        return node;
    }

    public PackageNode getRootPackage()
    {
        Node node = getFurthestAncestor();
        if (node instanceof PackageNode)
        {
            PackageNode packageNode = (PackageNode) node;
            if (packageNode.getName() == null)
            {
                return packageNode;
            }
        }
        return null;
    }

    public BsjNodeManager getManager()
    {
        return this.manager;
    }

    public boolean isBinary()
    {
        if (this.backingNode == null)
        {
            return this.binary;
        } else
        {
            return this.backingNode.isBinary();
        }
    }

    public String toSourceCode()
    {
        return this.executeOperation(new BsjSourceSerializerImpl(), null);
    }

    public Collection<? extends Node> getDeclarationsInScope(NameNode name)
    {
        return this.getManager().getDeclarationsInScope(this, name);
    }

    public Collection<? extends TypeNameBindingNode> getTypeDeclarationsInScope(String name)
    {
        return this.getManager().getTypeDeclarationsInScope(this, name);
    }

    public Collection<? extends InvokableNameBindingNode> getMethodDeclarationsInScope(String name)
    {
        return this.getManager().getMethodDeclarationsInScope(this, name);
    }

    public Collection<? extends VariableNameBindingNode> getVariableDeclarationsInScope(String name)
    {
        return this.getManager().getVariableDeclarationsInScope(this, name);
    }

    /**
     * Reports an edit script element. This method is invoked whenever a setter is called to record the change in a
     * change log.
     * 
     * @param element The edit script element in question.
     */
    protected void recordEdit(EditScriptElement element)
    {
        this.getManager().recordEdit(element);
    }

    /* GEN:stop */
}