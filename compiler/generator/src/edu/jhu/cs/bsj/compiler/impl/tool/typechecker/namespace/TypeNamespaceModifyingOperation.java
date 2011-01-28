package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.EmptyNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.FilteredListNodeTypePopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationRecordImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy.PopulationRecord;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.SingleValuePopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.TranslationDelegatingPopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.function.AbstractThunk;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.impl.utils.function.IdentityFunction;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Provides type namespace modification.
 * 
 * @author Zachary Palmer
 */
public class TypeNamespaceModifyingOperation extends AbstractNamespaceModifyingOperation<String, BsjTypeLikeElement>
{
    private static Logger LOGGER = Logger.getLogger(TypeNamespaceModifyingOperation.class);

    /**
     * Creates a type namespace modifier.
     * 
     * @param toolkit The typechecker toolkit to use to create elements.
     * @param loader The compilation unit loader to use when loading of compilation units is necessary.
     * @param listener The listener to which diagnostics will be reported.
     */
    public TypeNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
            DiagnosticListener<BsjSourceLocation> listener)
    {
        super(toolkit, loader, listener);
    }

    /**
     * Performs a default operation for nodes which do not affect the type namespace.
     */
    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeDefault(Node node,
            NamespaceMap<String, BsjTypeLikeElement> map)
    {
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    /*
     * Implementation notes:
     * 
     * 1. Nothing in the declaration of an enum or annotation affects the surrounding namespace (unlike classes, which
     * have type parameters).
     */

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeAnnotationBodyNode(AnnotationBodyNode node,
            NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Inherit elements from java.lang.annotation.Annotation
        AnnotationDeclarationNode declarationNode = (AnnotationDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Make the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeAnonymousClassBodyNode(
            AnonymousClassBodyNode node, NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Populate inherited members
        map = makeInheritedMapFor(node, map);

        // *** Create a new environment for declared members
        // * Populate declared members
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeClassBodyNode(ClassBodyNode node,
            NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Inherit member elements
        AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode = (AbstractlyUnmodifiedClassDeclarationNode<?>) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeClassDeclarationNode(
            final ClassDeclarationNode node, NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Create a new scope for type parameters
        // * Populate type parameters (which are in scope of the entire declaration)
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getTypeParameters();
            }
        }, AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeCompilationUnitNode(
            final CompilationUnitNode node, final NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // Only the type declarations contained in a compilation unit benefit from the declarations contained within
        // it; import statements, for instance, do not apply to other import statements.
        NamespaceMap<String, BsjTypeLikeElement> defaultNamespace = map; // used for everything other than the type
                                                                         // declaration list

        // Create the scope for top-level type declarations lazily
        Thunk<NamespaceMap<String, BsjTypeLikeElement>> topLevelTypeDeclarationThunk = new AbstractThunk<NamespaceMap<String, BsjTypeLikeElement>>()
        {
            public NamespaceMap<String, BsjTypeLikeElement> calculate()
            {
                // *** Create a new scope for the on-demand imports
                Collection<PopulationStrategy<String, BsjTypeLikeElement>> strategies = new ArrayList<PopulationStrategy<String, BsjTypeLikeElement>>();

                // * Process on-demand imports. This namespace has a lazy error policy, as ambiguities in on-demand
                // imports (such as "import java.util.*; import java.awt.*;" only matter if the ambiguous name is used
                // (such as in "List").
                strategies.add(populateOnDemandImports(new ImportByTypeThunk<ImportOnDemandNode>(node,
                        ImportOnDemandNode.class)));

                // Automatic import of java.lang.* is treated as an on-demand import
                PackageNode javaLangPackage = node.getRootPackage().getSubpackageByQualifiedName("java.lang");
                getLoader().loadAll(javaLangPackage);
                strategies.add(createPackagePopulationStrategy(javaLangPackage, node, AccessModifier.PUBLIC));

                // * Process on-demand static imports.
                strategies.add(populateOnDemandStaticImports(new ImportByTypeThunk<StaticImportOnDemandNode>(node,
                        StaticImportOnDemandNode.class)));

                // * Create the on-demand import map
                NamespaceMap<String, BsjTypeLikeElement> namespaceMap = makeMap(map, EnvType.ON_DEMAND_IMPORT,
                        strategies);

                // *** Create a new scope for the top level package peers.
                strategies = new ArrayList<PopulationStrategy<String, BsjTypeLikeElement>>();

                // * Process top-level package peers. This namespace has an eager error policy as any duplication
                // means a name conflict in the local package.
                strategies.add(createPackagePopulationStrategy((PackageNode) node.getParent(),
                        node.getPackageDeclaration() == null ? node : node.getPackageDeclaration(),
                        AccessModifier.PACKAGE));

                // * Create the top-level package peer map
                namespaceMap = makeMap(namespaceMap, EnvType.TYPE_OR_MEMBER, strategies);

                // *** Create a new scope for the single-type imports
                strategies = new ArrayList<PopulationStrategy<String, BsjTypeLikeElement>>();

                // * Process single-type imports. This namespace has a eager error policy, as ambiguities in
                // single-type imports cause the import statements to be useless in any context (such as
                // "import java.util.List; import java.awt.List;").
                strategies.add(populateSingleTypeImports(new ImportByTypeThunk<ImportSingleTypeNode>(node,
                        ImportSingleTypeNode.class)));

                // * Process single-type static imports.
                strategies.add(populateSingleStaticImports(new ImportByTypeThunk<SingleStaticImportNode>(node,
                        SingleStaticImportNode.class)));

                // * Create the single-type import map
                namespaceMap = makeMap(namespaceMap, EnvType.TYPE_OR_MEMBER, strategies);

                // Finished!
                return namespaceMap;
            }
        };

        // *** Finished!
        Map<Node, Thunk<NamespaceMap<String, BsjTypeLikeElement>>> namespaceMap = Collections.<Node, Thunk<NamespaceMap<String, BsjTypeLikeElement>>> singletonMap(
                node.getTypeDecls(), topLevelTypeDeclarationThunk);
        return new LazilyMappedChildNamespaceProducer<String, BsjTypeLikeElement>(defaultNamespace, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeConstructorDeclarationNode(
            final ConstructorDeclarationNode node, NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Create a new environment for type parameter population
        // * Populate type parameters (which are in scope of the entire declaration)
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getTypeParameters();
            }
        }, AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeEnumBodyNode(EnumBodyNode node,
            NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Inherit member elements
        EnumDeclarationNode declarationNode = (EnumDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeInterfaceBodyNode(InterfaceBodyNode node,
            NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Inherit member elements
        InterfaceDeclarationNode declarationNode = (InterfaceDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new BodyMembersThunk(node),
                AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeInterfaceDeclarationNode(
            final InterfaceDeclarationNode node, NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Create a new scope for type parameters
        // * Populate type parameters (which are in scope of the entire declaration)
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getTypeParameters();
            }
        }, AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeLocalClassDeclarationNode(
            final LocalClassDeclarationNode node, NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Create a new environment to contain the declaration
        // * Populate the type itself into the namespace
        PopulationStrategy<String, BsjTypeLikeElement> strategy = new SingleValuePopulationStrategy<String, BsjTypeLikeElement>(
                new AbstractThunk<PopulationRecord<String, BsjTypeLikeElement>>()
                {
                    @Override
                    protected PopulationRecord<String, BsjTypeLikeElement> calculate()
                    {
                        return new PopulationRecordImpl<String, BsjTypeLikeElement>(
                                node.getIdentifier().getIdentifier(), getToolkit().makeElement(node), node);
                    }
                }, IdentityFunction.<String>instance());
        // * Create the map
        map = makeMap(map, EnvType.STATEMENT, strategy);

        // *** Finished
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeMetaprogramNode(MetaprogramNode node,
            NamespaceMap<String, BsjTypeLikeElement> map)
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
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(
                EmptyNamespaceMap.<String, BsjTypeLikeElement> instance());
    }

    @Override
    public ChildNamespaceProducer<String, BsjTypeLikeElement> executeMethodDeclarationNode(
            final MethodDeclarationNode node, NamespaceMap<String, BsjTypeLikeElement> map)
    {
        // *** Create a new environment for type parameter population
        // * Populate type parameters (which are in scope of the entire declaration)
        PopulationStrategy<String, BsjTypeLikeElement> strategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            @Override
            protected ListNode<?> calculate()
            {
                return node.getTypeParameters();
            }
        }, AccessModifier.PRIVATE);
        // * Create the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, strategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement>(map);
    }

    // ***** UTILITY FUNCTIONS ************************************************

    @Override
    protected NamespaceMap<String, BsjTypeLikeElement> makeMap(NamespaceMap<String, BsjTypeLikeElement> deferenceMap,
            EnvType envType, Collection<? extends PopulationStrategy<String, BsjTypeLikeElement>> strategies)
    {
        return new TypeNamespaceMap(Collections.singleton(deferenceMap), this.getListener(), envType.isPassiveError(),
                envType.isProhibitsOverlap(), strategies);
    }

    protected PopulationStrategy<String, BsjTypeLikeElement> populateOnDemandImports(
            Thunk<Iterable<ImportOnDemandNode>> importsThunk)
    {
        return new TranslationDelegatingPopulationStrategy<String, BsjTypeLikeElement, ImportOnDemandNode>(
                importsThunk, new Function<ImportOnDemandNode, PopulationStrategy<String, BsjTypeLikeElement>>()
                {
                    @Override
                    public PopulationStrategy<String, BsjTypeLikeElement> execute(ImportOnDemandNode importNode)
                    {
                        if (LOGGER.isTraceEnabled())
                        {
                            LOGGER.trace("Processing type namespace for ImportOnDemandNode for name "
                                    + importNode.getName().getNameString());
                        }
                        switch (importNode.getName().getCategory(getLoader()))
                        {
                            case PACKAGE:
                                PackageNode packageNode = importNode.getRootPackage().getSubpackageByQualifiedName(
                                        importNode.getName());
                                getLoader().loadAll(packageNode);
                                return createPackagePopulationStrategy(packageNode, importNode, AccessModifier.PUBLIC);
                            case TYPE:
                                NamedTypeDeclarationNode<?> type = getToolkit().getAccessibleTypeFromFullyQualifiedName(
                                        importNode.getName());
                                if (type == null)
                                {
                                    // TODO: emit an appropriate diagnostic - the type from which to import doesn't
                                    // exist
                                    throw new NotImplementedYetException();
                                } else
                                {
                                    // TODO: is PUBLIC always the right access modifier?
                                    return populateElements(new TypeMembersThunk(type), AccessModifier.PUBLIC);
                                }
                            default:
                                // In this case, the name categorizer messed up
                                throw new IllegalStateException(
                                        "Name categorizer gave non-package, non-type category to import name: "
                                                + importNode.getName().getNameString() + " has category "
                                                + importNode.getName().getCategory(getLoader()));
                        }
                    }
                });
    }

    private PopulationStrategy<String, BsjTypeLikeElement> populateSingleTypeImports(
            Thunk<Iterable<ImportSingleTypeNode>> importsThunk)
    {
        return new TranslationDelegatingPopulationStrategy<String, BsjTypeLikeElement, ImportSingleTypeNode>(
                importsThunk, new Function<ImportSingleTypeNode, PopulationStrategy<String, BsjTypeLikeElement>>()
                {
                    @Override
                    public PopulationStrategy<String, BsjTypeLikeElement> execute(ImportSingleTypeNode importNode)
                    {
                        final NamedTypeDeclarationNode<?> type = getToolkit().getAccessibleTypeFromFullyQualifiedName(
                                importNode.getName());
                        if (type == null)
                        {
                            // TODO: raise some kind of appropriate diagnostic
                            throw new NotImplementedYetException();
                        } else
                        {
                            return new SingleValuePopulationStrategy<String, BsjTypeLikeElement>(
                                    new AbstractThunk<PopulationRecord<String, BsjTypeLikeElement>>()
                                    {
                                        @Override
                                        protected PopulationRecord<String, BsjTypeLikeElement> calculate()
                                        {
                                            return new PopulationRecordImpl<String, BsjTypeLikeElement>(
                                                    type.getIdentifier().getIdentifier(),
                                                    getToolkit().makeElement(type), type);
                                        }
                                    }, IdentityFunction.<String>instance());
                        }
                    }
                });
    }

    /**
     * Populates a type namespace map with a given package's top-level types.
     * 
     * @param map The map to populate.
     * @param packageNode The package in question.
     * @param indicator The indicator node to which each entry is to be attributed.
     * @param access The level of access available.
     */
    protected PopulationStrategy<String, BsjTypeLikeElement> createPackagePopulationStrategy(
            final PackageNode packageNode, final Node indicator, final AccessModifier access)
    {
        return new TranslationDelegatingPopulationStrategy<String, BsjTypeLikeElement, CompilationUnitNode>(
                new AbstractThunk<Iterable<CompilationUnitNode>>()
                {
                    protected Iterable<CompilationUnitNode> calculate()
                    {
                        return new Iterable<CompilationUnitNode>()
                        {
                            public Iterator<CompilationUnitNode> iterator()
                            {
                                return packageNode.getCompilationUnitIterator();
                            }
                        };
                    };
                }, new Function<CompilationUnitNode, PopulationStrategy<String, BsjTypeLikeElement>>()
                {
                    @Override
                    public PopulationStrategy<String, BsjTypeLikeElement> execute(
                            final CompilationUnitNode compilationUnit)
                    {
                        return populateElements(new AbstractThunk<ListNode<?>>()
                        {
                            @Override
                            protected ListNode<?> calculate()
                            {
                                return compilationUnit.getTypeDecls();
                            }
                        }, access);
                    }
                });
    }

    @Override
    protected NamespaceMap<String, BsjTypeLikeElement> makeInheritanceMapFromSubmaps(
            Collection<NamespaceMap<String, BsjTypeLikeElement>> submaps,
            Collection<? extends PopulationStrategy<String, BsjTypeLikeElement>> strategies)
    {
        return new TypeNamespaceMap(submaps, getListener(), EnvType.INHERITED.isPassiveError(),
                EnvType.INHERITED.isProhibitsOverlap(), strategies);
    }

    @Override
    protected PopulationStrategy<String, BsjTypeLikeElement> populateElements(Thunk<ListNode<?>> nodesThunk,
            AccessModifier access, boolean skipNonMembers, String name)
    {
        return new FilteredListNodeTypePopulationStrategy(nodesThunk, access, name, getToolkit());
    }
}
