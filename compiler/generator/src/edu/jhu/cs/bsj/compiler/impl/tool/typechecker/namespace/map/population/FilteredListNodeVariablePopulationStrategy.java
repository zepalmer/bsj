package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterable;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.FilterByNodeTypes;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;

/**
 * A population strategy for lists of nodes. This strategy is viable for member lists, variable lists, and other such
 * constructs. It should be observed that the population strategy that this class produces is suitable only for elements
 * for which <i>all</i> elements in the list are in scope; it is not suitable, for instance, to populate the namespace
 * of a multiple declaration's variable initializers (as in "<tt>int x = 0, y = x</tt>").
 * 
 * @author Zachary Palmer
 */
public class FilteredListNodeVariablePopulationStrategy extends
        AbstractFilteredListNodePopulationStrategy<String, BsjVariableElement>
{
    private TypecheckerToolkit toolkit;

    public FilteredListNodeVariablePopulationStrategy(Thunk<ListNode<?>> listNodeThunk, AccessModifier access,
            String name, TypecheckerToolkit toolkit)
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
                if (node instanceof VariableNode)
                {
                    if (name != null)
                    {
                        VariableNode variable = (VariableNode) node;
                        if (!variable.getIdentifier().getIdentifier().equals(name))
                        {
                            return false;
                        }
                    }
                } else if (node instanceof FieldDeclarationNode)
                {
                    FieldDeclarationNode field = (FieldDeclarationNode) node;
                    if (field.getModifiers().getAccess().compareTo(access) > 0)
                        return false;
                    if (name != null && field.getDeclarators().filter(new DeclaratorNameFilter(name)).size() == 0)
                        return false;
                } else if (node instanceof ConstantDeclarationNode)
                {
                    if (name != null)
                    {
                        ConstantDeclarationNode constant = (ConstantDeclarationNode) node;
                        if (constant.getDeclarators().filter(new DeclaratorNameFilter(name)).size() == 0)
                        {
                            return false;
                        }
                    }
                } else if (node instanceof EnumConstantDeclarationNode)
                {
                    if (name != null)
                    {
                        EnumConstantDeclarationNode constant = (EnumConstantDeclarationNode) node;
                        if (!constant.getIdentifier().getIdentifier().equals(name))
                        {
                            return false;
                        }
                    }
                } else if (node instanceof LocalVariableDeclarationNode)
                {
                    if (name != null)
                    {
                        LocalVariableDeclarationNode localVar = (LocalVariableDeclarationNode) node;
                        if (localVar.getDeclarators().filter(new DeclaratorNameFilter(name)).size() == 0)
                        {
                            return false;
                        }
                    }
                } else
                {
                    return false;
                }

                return true;
            }
        });
    }

    public FilteredListNodeVariablePopulationStrategy(Thunk<ListNode<?>> listNodeThunk,
            Iterable<NodeFilter<Node>> filters, TypecheckerToolkit toolkit)
    {
        super(listNodeThunk, new CompoundIterable<NodeFilter<Node>>(
                Collections.<NodeFilter<Node>> singleton(new FilterByNodeTypes<Node, Node>(
                        CollectionUtilities.<Class<? extends Node>> listOf(VariableNode.class,
                                FieldDeclarationNode.class, ConstantDeclarationNode.class,
                                EnumConstantDeclarationNode.class))), filters));
        this.toolkit = toolkit;
    }

    /**
     * Produces a node filter for the given key. This filter will only accept nodes which act as the root for relevant
     * information about the variable; thus, for instance, a {@link VariableDeclaratorNode} will never match this filter
     * but a {@link FieldDeclarationNode} will.
     */
    @Override
    protected NodeFilter<Node> getKeyFilter(final String key)
    {
        return new NodeFilter<Node>()
        {
            @Override
            public boolean filter(Node node)
            {
                if (node instanceof VariableNode)
                {
                    VariableNode variable = (VariableNode) node;
                    return (variable.getIdentifier().getIdentifier().equals(key));
                } else if (node instanceof VariableDeclaratorOwnerNode)
                {
                    VariableDeclaratorOwnerNode declOwner = (VariableDeclaratorOwnerNode) node;
                    return declOwner.getDeclarators().filter(new DeclaratorNameFilter(key)).size() > 0;
                } else if (node instanceof EnumConstantDeclarationNode)
                {
                    EnumConstantDeclarationNode constant = (EnumConstantDeclarationNode) node;
                    return constant.getIdentifier().getIdentifier().equals(key);
                } else
                {
                    return false;
                }
            }
        };
    }

    @Override
    protected Collection<String> getKeysBySimpleName(String name)
    {
        return Collections.singleton(name);
    }

    @Override
    protected Collection<? extends PopulationRecord<String, BsjVariableElement>> getPopulationRecordForNode(Node node,
            String key)
    {
        if (node instanceof VariableNode)
        {
            VariableNode variable = (VariableNode) node;
            if (key == null || key.equals(variable.getIdentifier().getIdentifier()))
            {
                return Collections.singleton(new PopulationRecordImpl<String, BsjVariableElement>(key,
                        (BsjVariableElement) this.toolkit.makeElement(variable), variable));
            } else
            {
                return Collections.emptySet();
            }
        } else if (node instanceof VariableDeclaratorOwnerNode)
        {
            VariableDeclaratorOwnerNode declOwner = (VariableDeclaratorOwnerNode) node;
            Collection<VariableDeclaratorNode> decls;
            if (key == null)
            {
                decls = declOwner.getDeclarators();
            } else
            {
                decls = declOwner.getDeclarators().filter(new DeclaratorNameFilter(key));
            }
            if (decls.size() == 0)
                return Collections.emptySet();
            Set<PopulationRecord<String, BsjVariableElement>> ret = new HashSet<PopulationRecord<String, BsjVariableElement>>(
                    decls.size());
            for (VariableDeclaratorNode decl : decls)
            {
                ret.add(new PopulationRecordImpl<String, BsjVariableElement>(decl.getIdentifier().getIdentifier(),
                        (BsjVariableElement) this.toolkit.makeElement(decl), decl));
            }
            return ret;
        } else if (node instanceof EnumConstantDeclarationNode)
        {
            EnumConstantDeclarationNode constant = (EnumConstantDeclarationNode) node;
            if (key == null || key.equals(constant.getIdentifier().getIdentifier()))
            {
                return Collections.singleton(new PopulationRecordImpl<String, BsjVariableElement>(key,
                        (BsjVariableElement) this.toolkit.makeElement(constant), constant));
            } else
            {
                return Collections.emptySet();
            }
        } else
        {
            return Collections.emptySet();
        }
    }
}
