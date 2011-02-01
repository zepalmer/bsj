package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.EmptyNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.VariableNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.DeclaratorNameFilter;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.FilteredListNodeVariablePopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.LazyPopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationRecordImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy.PopulationRecord;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.SingleValuePopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.function.AbstractThunk;
import edu.jhu.cs.bsj.compiler.impl.utils.function.IdentityFunction;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

/**
 * Provides variable namespace modification.
 * 
 * @author Zachary Palmer
 */
public class VariableNamespaceModifyingOperation extends
        AbstractNamespaceModifyingOperation<String, BsjVariableElement>
{
    public VariableNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoadingInfo loader,
            DiagnosticListener<BsjSourceLocation> listener)
    {
        super(toolkit, loader, listener);
    }

    /**
     * Performs a default operation for nodes which do not affect the variable namespace.
     */
    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeDefault(Node node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeAnnotationBodyNode(AnnotationBodyNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // *** Populate elements inherited from java.lang.annotation.Annotation
        AnnotationDeclarationNode declarationNode = (AnnotationDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<String, BsjVariableElement> memberStrategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeAnonymousClassBodyNode(
            AnonymousClassBodyNode node, NamespaceMap<String, BsjVariableElement> map)
    {
        // *** Populate inherited members
        map = makeInheritedMapFor(node, map);

        // *** Create a new environment for declared members
        // * Populate declared members
        PopulationStrategy<String, BsjVariableElement> memberStrategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeCatchNode(final CatchNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // *** The scope of the parameter in a catch block is the body of that catch block
        Map<Node, NamespaceMap<String, BsjVariableElement>> namespaceMap;
        final NamespaceMap<String, BsjVariableElement> defaultMap = map;

        PopulationStrategy<String, BsjVariableElement> strategy = new SingleVariableNodePopulationStrategy(
                node.getParameter());
        map = makeMap(map, EnvType.STATEMENT, strategy);

        namespaceMap = Collections.<Node, NamespaceMap<String, BsjVariableElement>> singletonMap(node.getBody(), map);

        return new MappedChildNamespaceProducer<String, BsjVariableElement>(defaultMap, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeClassBodyNode(ClassBodyNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // *** Inherit member elements
        AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode = (AbstractlyUnmodifiedClassDeclarationNode<?>) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<String, BsjVariableElement> memberStrategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeCompilationUnitNode(CompilationUnitNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // Only the type declarations contained in a compilation unit benefit from the declarations contained within
        // it; import statements, for instance, do not apply to other import statements.
        NamespaceMap<String, BsjVariableElement> defaultMap = map;

        // *** Create a new scope for the on-demand imports
        // * Process on-demand static imports.
        PopulationStrategy<String, BsjVariableElement> strategy = populateOnDemandStaticImports(new ImportByTypeThunk<StaticImportOnDemandNode>(
                node, StaticImportOnDemandNode.class));
        // * Make the map
        map = makeMap(map, EnvType.ON_DEMAND_IMPORT, strategy);

        // *** Create a new scope for the single imports
        // * Process single static imports.
        strategy = populateSingleStaticImports(new ImportByTypeThunk<SingleStaticImportNode>(node,
                SingleStaticImportNode.class));
        // * Make the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        Map<Node, NamespaceMap<String, BsjVariableElement>> namespaceMap = Collections.<Node, NamespaceMap<String, BsjVariableElement>> singletonMap(
                node.getTypeDecls(), map);
        return new MappedChildNamespaceProducer<String, BsjVariableElement>(defaultMap, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeConstructorDeclarationNode(
            final ConstructorDeclarationNode node, NamespaceMap<String, BsjVariableElement> map)
    {
        NamespaceMap<String, BsjVariableElement> defaultMap = map;

        // *** Populate constructor parameters into constructor invocation and constructor body
        PopulationStrategy<String, BsjVariableElement> strategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getParameters();
            }
        }, AccessModifier.PRIVATE);
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        Map<Node, NamespaceMap<String, BsjVariableElement>> namespaceMap = Collections.<Node, NamespaceMap<String, BsjVariableElement>> singletonMap(
                node.getBody(), map);
        return new MappedChildNamespaceProducer<String, BsjVariableElement>(defaultMap, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeEnhancedForLoopNode(
            final EnhancedForLoopNode node, NamespaceMap<String, BsjVariableElement> map)
    {
        NamespaceMap<String, BsjVariableElement> defaultMap = map;

        // *** The scope of the parameter to the enhanced for loop is the body of that loop
        PopulationStrategy<String, BsjVariableElement> strategy = new SingleVariableNodePopulationStrategy(
                node.getVariable());
        map = makeMap(map, EnvType.STATEMENT, strategy);

        // *** Finished!
        Map<Node, NamespaceMap<String, BsjVariableElement>> namespaceMap = Collections.<Node, NamespaceMap<String, BsjVariableElement>> singletonMap(
                node.getStatement(), map);
        return new MappedChildNamespaceProducer<String, BsjVariableElement>(defaultMap, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeEnumBodyNode(final EnumBodyNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // *** Inherit member elements
        EnumDeclarationNode declarationNode = (EnumDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        PopulationStrategy<String, BsjVariableElement> constantsStrategy, membersStrategy;
        // * Populate enum constants
        constantsStrategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getConstants();
            }
        }, AccessModifier.PRIVATE);
        // * Populate member elements
        membersStrategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getMembers();
            }
        }, AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, CollectionUtilities.listOf(constantsStrategy, membersStrategy));

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeForLoopNode(final ForLoopNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // The initializer is addressed by its children. Either it's a statement expression list (in which case
        // no changes occur) or it's a local variable declaration (in which case the local variable declaration
        // handler will populate things properly).
        NamespaceMap<String, BsjVariableElement> initializerMap = map;

        // Populate all of the contents of the initializer
        PopulationStrategy<String, BsjVariableElement> strategy = new LazyPopulationStrategy<String, BsjVariableElement>(
                new AbstractThunk<PopulationStrategy<String, BsjVariableElement>>()
                {
                    @Override
                    protected PopulationStrategy<String, BsjVariableElement> calculate()
                    {
                        if (node.getInitializer() instanceof ForInitializerDeclarationNode)
                        {
                            ForInitializerDeclarationNode initializer = (ForInitializerDeclarationNode) node.getInitializer();
                            return new SingleDeclaratorOwnerNodePopulationStrategy(initializer.getDeclaration());
                        } else
                        {
                            return null;
                        }
                    }
                });
        map = makeMap(map, EnvType.STATEMENT, strategy);

        // *** Finished!
        Map<Node, NamespaceMap<String, BsjVariableElement>> namespaceMap = Collections.<Node, NamespaceMap<String, BsjVariableElement>> singletonMap(
                node.getInitializer(), initializerMap);
        return new MappedChildNamespaceProducer<String, BsjVariableElement>(map, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeInterfaceBodyNode(InterfaceBodyNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // *** Inherit member elements
        InterfaceDeclarationNode declarationNode = (InterfaceDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<String, BsjVariableElement> memberStrategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    /*
     * *** NOTE: local variable declaration is not handled here. This is because of the fashion in which the parent
     * environments are assigned. The structural children of the local variable declaration do not have a consistent
     * scope change based on the declaration node; for instance, each declarator has different variables in scope.
     * Furthermore, to prevent redundant diagnostic production, nodes immediately following a variable declaration are
     * environmental children of the last declarator in a local variable declaration. Thus, none of the nodes which are
     * affected by a local variable declaration node are the environmental children of the declaration node itself and
     * it does not need to be handled here.
     */

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeMetaprogramNode(MetaprogramNode node,
            NamespaceMap<String, BsjVariableElement> map)
    {
        // TODO: complete this section.
        /*
         * Properly implementing this code would require the following:
         * 
         * 1. Metaprogram imports both from the compilation unit as well as the preamble would need to apply to the
         * preamble's non-import section and the metaprogram body. Note that these imports would be coming from the
         * *metaprogram's* classpath, not the object program's classpath.
         * 
         * 2. The metaprogram body needs to have a local variable be defined of type Context<T>. Note that, to be a
         * correct implementation, the type of T must be properly filled out.
         * 
         * There is some question as to whether or not this method should ever be implemented; it probably wouldn't be
         * necessary for a metaprogram to do this kind of analysis and the modeling of the imported types would get
         * tedious at best. For now, we're just clearing out the environment to make clear the fact that none of the
         * object program logic applies.
         */
        map = EmptyNamespaceMap.instance();
        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeMethodDeclarationNode(
            final MethodDeclarationNode node, NamespaceMap<String, BsjVariableElement> map)
    {
        NamespaceMap<String, BsjVariableElement> defaultMap = map;

        // *** Populate method parameters into method body
        PopulationStrategy<String, BsjVariableElement> strategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getParameters();
            }
        }, AccessModifier.PRIVATE);
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        Map<Node, NamespaceMap<String, BsjVariableElement>> namespaceMap = Collections.<Node, NamespaceMap<String, BsjVariableElement>> singletonMap(
                node.getBody(), map);
        return new MappedChildNamespaceProducer<String, BsjVariableElement>(defaultMap, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<String, BsjVariableElement> executeVariableDeclaratorNode(
            final VariableDeclaratorNode node, NamespaceMap<String, BsjVariableElement> map)
    {
        // *** The scope of a variable declarator includes its own initializer.
        // We're also going to include the variable name here. This has no appreciable effect on the behavior of the
        // system except in that it encourages the generation of appropriate diagnostics which are otherwise not
        // generated when no initializer is present.
        PopulationStrategy<String, BsjVariableElement> strategy = new SingleValuePopulationStrategy<String, BsjVariableElement>(
                new AbstractThunk<PopulationRecord<String, BsjVariableElement>>()
                {
                    @Override
                    protected PopulationRecord<String, BsjVariableElement> calculate()
                    {
                        return new PopulationRecordImpl<String, BsjVariableElement>(
                                node.getIdentifier().getIdentifier(), (BsjVariableElement) getToolkit().makeElement(
                                        node), node);
                    }
                }, IdentityFunction.<String>instance());
        map = makeMap(map, EnvType.STATEMENT, strategy);

        return new ConsistentChildNamespaceProducer<String, BsjVariableElement>(map);
    }

    // ***** UTILITY METHODS **************************************************

    @Override
    protected NamespaceMap<String, BsjVariableElement> makeInheritanceMapFromSubmaps(
            Collection<NamespaceMap<String, BsjVariableElement>> submaps,
            Collection<? extends PopulationStrategy<String, BsjVariableElement>> strategies)
    {
        return new VariableNamespaceMap(submaps, getListener(), EnvType.INHERITED.isPassiveError(),
                EnvType.INHERITED.isProhibitsOverlap(), strategies);
    }

    @Override
    protected PopulationStrategy<String, BsjVariableElement> populateElements(Thunk<ListNode<?>> nodesThunk,
            AccessModifier access, boolean skipNonMembers, String name)
    {
        return new FilteredListNodeVariablePopulationStrategy(nodesThunk, access, name, getToolkit());
    }

    @Override
    protected NamespaceMap<String, BsjVariableElement> makeMap(NamespaceMap<String, BsjVariableElement> deferenceMap,
            EnvType envType, Collection<? extends PopulationStrategy<String, BsjVariableElement>> strategies)
    {
        return new VariableNamespaceMap(Collections.singleton(deferenceMap), getListener(),
                envType.isPassiveError(), envType.isProhibitsOverlap(), strategies);
    }

    private class SingleVariableNodePopulationStrategy extends
            SingleValuePopulationStrategy<String, BsjVariableElement>
    {
        public SingleVariableNodePopulationStrategy(final VariableNode variableNode)
        {
            super(new AbstractThunk<PopulationStrategy.PopulationRecord<String, BsjVariableElement>>()
            {
                @Override
                protected PopulationStrategy.PopulationRecord<String, BsjVariableElement> calculate()
                {
                    return new PopulationRecordImpl<String, BsjVariableElement>(
                            variableNode.getIdentifier().getIdentifier(),
                            (BsjVariableElement) getToolkit().makeElement(variableNode), variableNode);
                }
            }, IdentityFunction.<String>instance());
        }
    }

    private class SingleDeclaratorOwnerNodePopulationStrategy implements PopulationStrategy<String, BsjVariableElement>
    {
        private VariableDeclaratorOwnerNode node;

        public SingleDeclaratorOwnerNodePopulationStrategy(final VariableDeclaratorOwnerNode node)
        {
            this.node = node;
        }

        @Override
        public Collection<PopulationRecord<String, BsjVariableElement>> get(String key)
        {
            return calculate(new DeclaratorNameFilter(key));
        }

        @Override
        public Collection<PopulationRecord<String, BsjVariableElement>> getBySimpleName(String name)
        {
            return calculate(new DeclaratorNameFilter(name));
        }

        @Override
        public Collection<PopulationRecord<String, BsjVariableElement>> getAll()
        {
            return calculate(null);
        }

        private Collection<PopulationRecord<String, BsjVariableElement>> calculate(NodeFilter<? super VariableDeclaratorNode> filter)
        {
            Collection<VariableDeclaratorNode> decls;
            if (filter == null)
            {
                decls = node.getDeclarators();
            } else
            {
                decls = node.getDeclarators().filter(filter);
            }
            if (decls.size() == 0)
                return Collections.emptySet();
            Set<PopulationRecord<String, BsjVariableElement>> ret = new HashSet<PopulationRecord<String, BsjVariableElement>>(
                    decls.size());
            for (VariableDeclaratorNode decl : decls)
            {
                ret.add(new PopulationRecordImpl<String, BsjVariableElement>(decl.getIdentifier().getIdentifier(),
                        (BsjVariableElement) getToolkit().makeElement(decl), decl));
            }
            return ret;
        }
    }
}