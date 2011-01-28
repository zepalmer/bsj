package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.ErasedMethodSignature;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterable;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.FilterByNodeTypes;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjExecutableElement;

public class FilteredListNodeMethodPopulationStrategy extends
        AbstractFilteredListNodePopulationStrategy<ErasedMethodSignature, BsjExecutableElement>
{
    private TypecheckerToolkit toolkit;

    /** A cache for filters by specific name. */
    private Map<String, NodeFilter<Node>> nameFilterCache = new HashMap<String, NodeFilter<Node>>();

    public FilteredListNodeMethodPopulationStrategy(Thunk<ListNode<?>> listNodeThunk, AccessModifier access,
            boolean skipNonMembers, String name, TypecheckerToolkit toolkit)
    {
        this(listNodeThunk, Collections.singleton(makeCommonFilter(access, skipNonMembers, name)), toolkit);
    }

    private static NodeFilter<Node> makeCommonFilter(final AccessModifier access,
            final boolean skipNonMembers, final String name)
    {
        return new NodeFilter<Node>()
        {
            @Override
            public boolean filter(Node node)
            {
                final String nodeName;
                final AccessModifier nodeAccess;
                final boolean isMember;
                if (node instanceof MethodDeclarationNode)
                {
                    MethodDeclarationNode method = (MethodDeclarationNode) node;
                    nodeName = method.getIdentifier().getIdentifier();
                    nodeAccess = method.getModifiers().getAccess();
                    isMember = true;
                } else if (node instanceof ConstructorDeclarationNode)
                {
                    ConstructorDeclarationNode constructor = (ConstructorDeclarationNode) node;
                    nodeName = null;
                    nodeAccess = constructor.getModifiers().getAccess();
                    isMember = false;
                } else if (node instanceof AnnotationMethodDeclarationNode)
                {
                    AnnotationMethodDeclarationNode method = (AnnotationMethodDeclarationNode) node;
                    nodeName = method.getIdentifier().getIdentifier();
                    nodeAccess = AccessModifier.PUBLIC;
                    isMember = true;
                } else
                {
                    return false;
                }
                if (access != null && nodeAccess.compareTo(access) > 0)
                    return false;
                if (skipNonMembers && !isMember)
                    return false;
                if (name != null && nodeName != null && !name.equals(nodeName))
                    return false;

                return true;
            }
        };
    }

    public FilteredListNodeMethodPopulationStrategy(Thunk<ListNode<?>> listNodeThunk,
            Iterable<NodeFilter<Node>> filters, TypecheckerToolkit toolkit)
    {
        super(listNodeThunk, new CompoundIterable<NodeFilter<Node>>(
                Collections.<NodeFilter<Node>> singleton(new FilterByNodeTypes<Node, Node>(
                        CollectionUtilities.<Class<? extends Node>> listOf(MethodDeclarationNode.class,
                                ClassDeclarationNode.class, AnnotationMethodDeclarationNode.class))), filters));
        this.toolkit = toolkit;
    }

    @Override
    protected NodeFilter<Node> getKeyFilter(final ErasedMethodSignature key)
    {
        return new NodeFilter<Node>()
        {
            @Override
            public boolean filter(Node node)
            {
                ErasedMethodSignature signature;
                BsjElement bsjElement = toolkit.makeElement(node);
                if (bsjElement instanceof BsjExecutableElement)
                {
                    BsjExecutableElement executableElement = (BsjExecutableElement) bsjElement;
                    signature = new ErasedMethodSignature(executableElement);
                    return (signature.equals(key));
                } else
                {
                    return false;
                }
            }
        };
    }

    private NodeFilter<Node> getFilterByName(String name)
    {
        if (!this.nameFilterCache.containsKey(name))
        {
            NodeFilter<Node> filter = makeCommonFilter(AccessModifier.PRIVATE, false, name);
            this.nameFilterCache.put(name, filter);                
        }
        return this.nameFilterCache.get(name);
    }

    @Override
    protected Collection<ErasedMethodSignature> getKeysBySimpleName(final String name)
    {
        Set<ErasedMethodSignature> ret = new HashSet<ErasedMethodSignature>();
        
        for (Node node : think().filter(getFilterByName(name)))
        {
            BsjElement bsjElement = toolkit.makeElement(node);
            if (bsjElement instanceof BsjExecutableElement)
            {
                BsjExecutableElement executableElement = (BsjExecutableElement) bsjElement;
                ErasedMethodSignature signature = new ErasedMethodSignature(executableElement);
                ret.add(signature);
            } else
            {
                // The filter should've caught this!
                throw new IllegalStateException("Invalid node type for population strategy: " + node.getClass().getName());
            }
        }
        
        return ret;
    }

    @Override
    protected Collection<? extends PopulationRecord<ErasedMethodSignature, BsjExecutableElement>> getPopulationRecordForNode(
            Node node, ErasedMethodSignature key)
    {
        ErasedMethodSignature signature;
        BsjElement bsjElement = toolkit.makeElement(node);
        if (bsjElement instanceof BsjExecutableElement)
        {
            BsjExecutableElement executableElement = (BsjExecutableElement) bsjElement;
            signature = new ErasedMethodSignature(executableElement);
            return Collections.singleton(new PopulationRecordImpl<ErasedMethodSignature, BsjExecutableElement>(
                    signature, executableElement, node));
        } else
        {
            // The type filter should've caught this!
            throw new IllegalStateException("Invalid node type for population strategy: " + node.getClass().getName());
        }
    }
}
