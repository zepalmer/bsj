package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.Collection;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.AccessibleTypeModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterable;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.FilterByNodeTypes;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeLikeElement;

public class FilteredListNodeTypePopulationStrategy extends
        AbstractFilteredListNodePopulationStrategy<String, BsjTypeLikeElement>
{
    private TypecheckerToolkit toolkit;

    public FilteredListNodeTypePopulationStrategy(Thunk<ListNode<?>> listNodeThunk, AccessModifier access, String name,
            TypecheckerToolkit toolkit)
    {
        this(listNodeThunk, makeCommonFilters(access, name), toolkit);
    }

    private static Iterable<NodeFilter<Node>> makeCommonFilters(final AccessModifier access, final String name)
    {
        return Collections.<NodeFilter<Node>> singleton(new NodeFilter<Node>()
        {
            @Override
            public boolean filter(Node node)
            {
                if (node instanceof NamedTypeDeclarationNode<?>)
                {
                    NamedTypeDeclarationNode<?> type = (NamedTypeDeclarationNode<?>) node;
                    if (type.getModifiers() instanceof AccessibleTypeModifiersNode)
                    {
                        if (((AccessibleTypeModifiersNode) type.getModifiers()).getAccess().compareTo(access) > 0)
                        {
                            return false;
                        }
                    }
                    if (name != null && !type.getIdentifier().getIdentifier().equals(name))
                    {
                        return false;
                    }
                    return true;
                } else if (node instanceof TypeParameterNode)
                {
                    TypeParameterNode param = (TypeParameterNode) node;
                    if (name != null && !param.getIdentifier().getIdentifier().equals(name))
                    {
                        return false;
                    }
                    return true;
                } else
                {
                    return false;
                }
            }
        });
    }

    public FilteredListNodeTypePopulationStrategy(Thunk<ListNode<?>> listNodeThunk, Iterable<NodeFilter<Node>> filters,
            TypecheckerToolkit toolkit)
    {
        super(listNodeThunk, new CompoundIterable<NodeFilter<Node>>(
                Collections.<NodeFilter<Node>> singleton(new FilterByNodeTypes<Node, Node>(
                        CollectionUtilities.<Class<? extends Node>> listOf(NamedTypeDeclarationNode.class,
                                TypeParameterNode.class))), filters));
        this.toolkit = toolkit;
    }

    @Override
    protected Collection<String> getKeysBySimpleName(String name)
    {
        return Collections.singleton(name);
    }

    @Override
    protected NodeFilter<Node> getKeyFilter(final String key)
    {
        return new NodeFilter<Node>()
        {
            @Override
            public boolean filter(Node node)
            {
                if (node instanceof NamedTypeDeclarationNode<?>)
                {
                    NamedTypeDeclarationNode<?> type = (NamedTypeDeclarationNode<?>) node;
                    if (type.getIdentifier().getIdentifier().equals(key))
                        return true;
                } else if (node instanceof TypeParameterNode)
                {
                    TypeParameterNode param = (TypeParameterNode) node;
                    if (param.getIdentifier().getIdentifier().equals(key))
                        return true;
                }
                return false;
            }
        };
    }

    @Override
    protected Collection<? extends PopulationRecord<String, BsjTypeLikeElement>> getPopulationRecordForNode(Node node,
            String key)
    {
        BsjElement bsjElement = toolkit.makeElement(node);
        if (bsjElement instanceof BsjTypeLikeElement)
        {
            BsjTypeLikeElement element = (BsjTypeLikeElement) bsjElement;
            return Collections.singleton(new PopulationRecordImpl<String, BsjTypeLikeElement>(
                    element.getSimpleName().toString(), element, node));
        } else
        {
            // The type filter should've caught this!
            throw new IllegalStateException("Invalid node type for population strategy: " + node.getClass().getName());
        }
    }
}
