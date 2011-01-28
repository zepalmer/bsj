package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.EmptyNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap.OverlapMode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.SequentiallyDeferredNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.TranslationDelegatingPopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.FilterByNodeType;
import edu.jhu.cs.bsj.compiler.impl.utils.function.AbstractThunk;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Applies the environment changes that a parent environment node has on its environment child. This operation operates
 * on the parent node. Its two arguments are the namespace provided to the parent and the child node for which a
 * namespace should be constructed. The returned value is that child node's namespace. The actual node operation methods
 * on this class are left unimplemented with the expectation that subclasses will perform namespace-type-specific
 * modifications as necessary.
 * <p/>
 * Note that here, the terms "parent" and "child" refer to the environment effect relationship and not necessarily to an
 * AST connectivity relationship. A compilation unit is the environment parent of a top-level type declaration, but the
 * environment parent of a block statement is usually the block statement which appeared immediately before it.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractNamespaceModifyingOperation<K, V extends BsjElement> extends
        BsjDefaultNodeOperation<NamespaceMap<K, V>, ChildNamespaceProducer<K, V>>
{
    private static Logger LOGGER = Logger.getLogger(AbstractNamespaceModifyingOperation.class);

    /** The typechecker toolkit to use. */
    private TypecheckerToolkit toolkit;
    /** The compilation unit loader to use. */
    private CompilationUnitLoader loader;
    /** The diagnostic listener to use. */
    private DiagnosticListener<BsjSourceLocation> listener;

    public AbstractNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
            DiagnosticListener<BsjSourceLocation> listener)
    {
        super();
        this.toolkit = toolkit;
        this.loader = loader;
        this.listener = listener;
    }

    protected TypecheckerToolkit getToolkit()
    {
        return toolkit;
    }

    protected CompilationUnitLoader getLoader()
    {
        return loader;
    }

    protected DiagnosticListener<BsjSourceLocation> getListener()
    {
        return listener;
    }

    protected PopulationStrategy<K, V> populateOnDemandStaticImports(
            Thunk<Iterable<StaticImportOnDemandNode>> importsThunk)
    {
        return new TranslationDelegatingPopulationStrategy<K, V, StaticImportOnDemandNode>(importsThunk,
                new Function<StaticImportOnDemandNode, PopulationStrategy<K, V>>()
                {
                    @Override
                    public PopulationStrategy<K, V> execute(StaticImportOnDemandNode importNode)
                    {
                        if (importNode.getName().getCategory(loader) != NameCategory.TYPE)
                        {
                            // On-demand static imports can only name types.
                            // TODO: report an appropriate diagnostic
                            throw new NotImplementedYetException();
                        }

                        // For each member of the type, import it if possible
                        NamedTypeDeclarationNode<?> type = getToolkit().getAccessibleTypeFromFullyQualifiedName(
                                importNode.getName());
                        if (type == null)
                        {
                            // TODO: emit an appropriate diagnostic
                            throw new NotImplementedYetException();
                        } else
                        {
                            return populateElements(new TypeMembersThunk(type), AccessModifier.PUBLIC);
                        }
                    }
                });
    }

    protected PopulationStrategy<K, V> populateSingleStaticImports(
            Thunk<Iterable<SingleStaticImportNode>> importsThunk)
    {
        return new TranslationDelegatingPopulationStrategy<K, V, SingleStaticImportNode>(importsThunk,
                new Function<SingleStaticImportNode, PopulationStrategy<K, V>>()
                {
                    @Override
                    public PopulationStrategy<K, V> execute(SingleStaticImportNode importNode)
                    {
                        if (importNode.getName().getCategory(loader) != NameCategory.TYPE)
                        {
                            // On-demand static imports can only name types.
                            // TODO: report an appropriate diagnostic
                            throw new NotImplementedYetException();
                        }

                        // Find all members of the type which have the specified name.
                        NamedTypeDeclarationNode<?> type = getToolkit().getAccessibleTypeFromFullyQualifiedName(
                                importNode.getName());
                        SingleStaticImportNode singleStaticImportNode = (SingleStaticImportNode) importNode;
                        if (type == null)
                        {
                            // TODO: emit an appropriate diagnostic
                            throw new NotImplementedYetException();
                        } else
                        {
                            return populateElements(new TypeMembersThunk(type), AccessModifier.PUBLIC, false,
                                    singleStaticImportNode.getIdentifier().getIdentifier());
                        }
                    }
                });
    }

    /**
     * Creates a namespace map from the provided backing maps.
     * 
     * @param submaps The backing maps to use.
     * @param strategies The population strategies that the new map uses to create elements.
     * @return The resulting map.
     */
    protected abstract NamespaceMap<K, V> makeInheritanceMapFromSubmaps(Collection<NamespaceMap<K, V>> submaps,
            Collection<? extends PopulationStrategy<K, V>> strategies);

    /**
     * Creates a namespace map representing the members inherited by a given type. This method populates a scope for
     * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
     * members or other elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method
     * and <tt>Foo</tt> extends <tt>Object</tt>, the returned map will contain all <tt>Object</tt> methods. This method
     * will also inherit the members of the specified type; as a result, this should not be used directly by the
     * operation methods.
     * 
     * @param declarationNode The declaration to use.
     * @return The resulting environment.
     */
    private NamespaceMap<K, V> makeInheritedMapWithDynamicDispatchFor(NamedTypeDeclarationNode<?> declarationNode)
    {
        // Get a strategy for populating the presented type
        // TODO: PROTECTED or PACKAGE? Should be based on whether the inheriting type is in the same package?
        PopulationStrategy<K, V> inheritancePopulationStrategy = populateElements(
                new TypeMembersThunk(declarationNode), AccessModifier.PROTECTED, true, null);

        // First, dispatch to the node's parents.
        NamespaceMap<K, V> map = declarationNode.executeOperation(
                new BsjDefaultNodeOperation<Void, NamespaceMap<K, V>>()
                {
                    @Override
                    public NamespaceMap<K, V> executeDefault(Node node, Void v)
                    {
                        throw new IllegalStateException("Don't know how to handle inherited type from node type "
                                + node.getClass());
                    }

                    @Override
                    public NamespaceMap<K, V> executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Void v)
                    {
                        return makeInheritedMapFor(node);
                    }

                    @Override
                    public NamespaceMap<K, V> executeClassDeclarationNode(ClassDeclarationNode node, Void v)
                    {
                        return makeInheritedMapFor(node);
                    }

                    @Override
                    public NamespaceMap<K, V> executeEnumDeclarationNode(EnumDeclarationNode node, Void v)
                    {
                        return makeInheritedMapFor(node);
                    }

                    @Override
                    public NamespaceMap<K, V> executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Void v)
                    {
                        return makeInheritedMapFor(node);
                    }
                }, null);

        // Return the resulting map
        return makeInheritanceMapFromSubmaps(Collections.singleton(map),
                Collections.singleton(inheritancePopulationStrategy));
    }

    /**
     * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
     * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
     * elements of the provided type. For instance, if the anonymous class is an implicit subtype of the <tt>Foo</tt>
     * class, the members of <tt>Foo</tt> will be populated.
     * 
     * @param declarationNode The type for which the inherited map is desired.
     * @return The resulting map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(AnonymousClassBodyNode declarationNode)
    {
        if (declarationNode.getParent() instanceof ClassInstantiationNode)
        {
            if (declarationNode.getParent() instanceof QualifiedClassInstantiationNode)
            {
                // TODO: this relies on our ability to establish the type of the qualifying expression!
                throw new NotImplementedYetException();
            } else if (declarationNode.getParent() instanceof UnqualifiedClassInstantiationNode)
            {
                UnqualifiedClassInstantiationNode instantiationNode = (UnqualifiedClassInstantiationNode) declarationNode.getParent();
                BsjExplicitlyDeclaredType type = getExplicitlyDeclaredTypeFromNode(instantiationNode.getType());
                if (type != null)
                {
                    return makeInheritedMapFromSupertypes(Collections.singleton(((BsjExplicitlyDeclaredType) type).asElement()));
                } else
                {
                    // This indicates that the programmer tried to anonymously extend a type parameter.
                    // TODO: raise an appropriate diagnostic
                    throw new NotImplementedYetException();
                }
            } else
            {
                throw new IllegalStateException("Don't know how to handle class instantiation node of type "
                        + declarationNode.getParent().getClass());
            }
        } else if (declarationNode.getParent() instanceof EnumConstantDeclarationNode)
        {
            EnumDeclarationNode enumDeclarationNode = declarationNode.getNearestAncestorOfType(EnumDeclarationNode.class);
            BsjDeclaredTypeElement typeElement = getToolkit().makeElement(enumDeclarationNode);
            return makeInheritedMapFromSupertypes(Collections.singleton(typeElement));
        } else
        {
            throw new IllegalStateException("Don't know how to handle anonymous class body parent of type "
                    + declarationNode.getParent().getClass());
        }
    }

    /**
     * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
     * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
     * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
     * extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods.
     * 
     * @param declarationNode The type for which the inherited map is desired.
     * @return The resulting map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(AnnotationDeclarationNode declarationNode)
    {
        BsjDeclaredTypeElement annotationElement = toolkit.getAnnotationElement();
        return makeInheritedMapFromSupertypes(Collections.singleton(annotationElement));
    }

    /**
     * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
     * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
     * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
     * extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods but no <tt>Foo</tt>
     * methods.
     * 
     * @param declarationNode The type for which the inherited map is desired.
     * @return The resulting map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode)
    {
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Populating inherited members for " + declarationNode.getFullyQualifiedName());
        }

        BsjDeclaredTypeElement objectElement = toolkit.getObjectElement();
        if (objectElement.equals(toolkit.makeElement(declarationNode)))
        {
            // Then we're already done; Object inherits nothing.
            return makeEmptyMap();
        }

        Set<BsjDeclaredTypeElement> supertypes = new HashSet<BsjDeclaredTypeElement>();

        // include the superclass
        if (declarationNode.getExtendsClause() != null)
        {
            BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declarationNode.getExtendsClause());
            if (explicitlyDeclaredType == null)
            {
                // TODO: report an appropriate diagnostic
                throw new NotImplementedYetException();
            } else
            {
                supertypes.add(explicitlyDeclaredType.asElement());
            }
        }

        // include the superinterfaces
        for (DeclaredTypeNode declaredTypeNode : declarationNode.getImplementsClause())
        {
            BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declaredTypeNode);
            if (explicitlyDeclaredType == null)
            {
                // TODO: report an appropriate diagnostic
                throw new NotImplementedYetException();
            } else
            {
                supertypes.add(explicitlyDeclaredType.asElement());
            }
        }

        return makeInheritedMapFromSupertypes(supertypes);
    }

    /**
     * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
     * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
     * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
     * implements <tt>Bar</tt>, the returned environment will contain all <tt>Bar</tt> methods.
     * 
     * @param declarationNode The type for which the inherited map is desired.
     * @return The resulting map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(EnumDeclarationNode declarationNode)
    {
        BsjDeclaredTypeElement enumElement = toolkit.getEnumElement();

        Set<BsjDeclaredTypeElement> supertypes = new HashSet<BsjDeclaredTypeElement>();
        supertypes.add(enumElement);

        if (declarationNode.getImplementsClause().size() > 0)
        {
            // then inherit from each superinterface
            for (DeclaredTypeNode declaredTypeNode : declarationNode.getImplementsClause())
            {
                BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declaredTypeNode);
                if (explicitlyDeclaredType == null)
                {
                    // TODO: report an appropriate diagnostic
                    throw new NotImplementedYetException();
                } else
                {
                    supertypes.add(explicitlyDeclaredType.asElement());
                }
            }
        }

        return makeInheritedMapFromSupertypes(supertypes);
    }

    /**
     * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
     * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
     * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
     * extends <tt>Bar</tt>, the returned environment will contain all <tt>Bar</tt> methods but none of the <tt>Foo</tt>
     * methods.
     * 
     * @param declarationNode The type for which the inherited map is desired.
     * @return The resulting map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(InterfaceDeclarationNode declarationNode)
    {
        Set<BsjDeclaredTypeElement> supertypes = new HashSet<BsjDeclaredTypeElement>();

        if (declarationNode.getExtendsClause().size() > 0)
        {
            // then inherit from each superinterface
            for (DeclaredTypeNode declaredTypeNode : declarationNode.getExtendsClause())
            {
                BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declaredTypeNode);
                if (explicitlyDeclaredType == null)
                {
                    // TODO: report an appropriate diagnostic
                    throw new NotImplementedYetException();
                } else
                {
                    supertypes.add(explicitlyDeclaredType.asElement());
                }
            }
        }

        return makeInheritedMapFromSupertypes(supertypes);
    }

    /**
     * Creates a map from the specified supertypes.
     * 
     * @param supertypes The supertypes in question.
     * @return The map which represents all of those supertypes' inheritable members.
     */
    private NamespaceMap<K, V> makeInheritedMapFromSupertypes(Set<BsjDeclaredTypeElement> supertypes)
    {
        // ensure that there is at least one supertype
        if (supertypes.size() == 0)
        {
            BsjDeclaredTypeElement objectElement = (BsjDeclaredTypeElement) toolkit.getObjectElement();
            supertypes.add(objectElement);
        }

        // create an inherited map for each of these types
        List<NamespaceMap<K, V>> inheritedMaps = new ArrayList<NamespaceMap<K, V>>(supertypes.size());
        for (BsjDeclaredTypeElement element : supertypes)
        {
            inheritedMaps.add(makeInheritedMapWithDynamicDispatchFor(element.getDeclarationNode()));
        }

        // create a map representing those inheritance maps
        return makeInheritanceMapFromSubmaps(inheritedMaps, Collections.<PopulationStrategy<K, V>> emptySet());
    }

    /**
     * A convenience method for making an inheritance map with a deference map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(AnonymousClassBodyNode declarationNode,
            NamespaceMap<K, V> deferenceMap)
    {
        return makeDeferenceMap(makeInheritedMapFor(declarationNode), deferenceMap);
    }

    /**
     * A convenience method for making an inheritance map with a deference map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(AnnotationDeclarationNode declarationNode,
            NamespaceMap<K, V> deferenceMap)
    {
        return makeDeferenceMap(makeInheritedMapFor(declarationNode), deferenceMap);
    }

    /**
     * A convenience method for making an inheritance map with a deference map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode,
            NamespaceMap<K, V> deferenceMap)
    {
        return makeDeferenceMap(makeInheritedMapFor(declarationNode), deferenceMap);
    }

    /**
     * A convenience method for making an inheritance map with a deference map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(EnumDeclarationNode declarationNode,
            NamespaceMap<K, V> deferenceMap)
    {
        return makeDeferenceMap(makeInheritedMapFor(declarationNode), deferenceMap);
    }

    /**
     * A convenience method for making an inheritance map with a deference map.
     */
    protected NamespaceMap<K, V> makeInheritedMapFor(InterfaceDeclarationNode declarationNode,
            NamespaceMap<K, V> deferenceMap)
    {
        return makeDeferenceMap(makeInheritedMapFor(declarationNode), deferenceMap);
    }

    /**
     * Converts a {@link DeclaredTypeNode} into a {@link BsjExplicitlyDeclaredType} if possible. This will not be
     * possible if the {@link DeclaredTypeNode} actually refers to a type parameter. If this is the case,
     * <code>null</code> is returned instead.
     * 
     * @param node The node to convert.
     * @return The resulting type or <code>null</code> if the node indicates a type parameter.
     */
    private BsjExplicitlyDeclaredType getExplicitlyDeclaredTypeFromNode(DeclaredTypeNode node)
    {
        BsjNamedReferenceType referenceType = this.toolkit.getTypeBuilder().makeDeclaredType(node);
        if (referenceType instanceof BsjExplicitlyDeclaredType)
        {
            return (BsjExplicitlyDeclaredType) referenceType;
        } else
        {
            return null;
        }
    }

    /**
     * Populates a map with the members in a given list. Members which are not applicable to the map are ignored.
     * 
     * @param map The map into which to populate.
     * @param nodesThunk The nodes to use.
     * @param access The maximum level of access restriction to populate.
     */
    protected PopulationStrategy<K, V> populateElements(Thunk<ListNode<?>> nodesThunk, AccessModifier access)
    {
        return populateElements(nodesThunk, access, false, null);
    }

    /**
     * Creates a population strategy for a list of elements using the specified thunk and other restrictions.
     * 
     * @param nodesThunk The nodes to use.
     * @param access The maximum level of access restriction to populate.
     * @param skipNonMembers <code>true</code> if non-members (such as constructors) should be skipped.
     * @param name The name the member must have, or <code>null</code> to skip this check.
     * @return The population strategy to use over the provided nodes.
     */
    protected abstract PopulationStrategy<K, V> populateElements(Thunk<ListNode<?>> nodesThunk,
            AccessModifier access, boolean skipNonMembers, String name);

    /**
     * Creates a new map using a single deference map and an environment type.
     * 
     * @param deferenceMap The deference map to use.
     * @param envType The environment type.
     * @param strategy The population strategy to use.
     * @return The new map.
     */
    protected NamespaceMap<K, V> makeMap(NamespaceMap<K, V> deferenceMap, EnvType envType,
            PopulationStrategy<K, V> strategy)
    {
        return makeMap(deferenceMap, envType, Collections.singleton(strategy));
    }

    /**
     * Creates a new map using a single deference map and an environment type.
     * 
     * @param deferenceMap The deference map to use.
     * @param envType The environment type.
     * @param strategy1 The first population strategy to use.
     * @param strategy2 The second population strategy to use.
     * @return The new map.
     */
    protected NamespaceMap<K, V> makeMap(NamespaceMap<K, V> deferenceMap, EnvType envType,
            PopulationStrategy<K, V> strategy1, PopulationStrategy<K, V> strategy2)
    {
        return makeMap(deferenceMap, envType, CollectionUtilities.listOf(strategy1, strategy2));
    }

    /**
     * Creates a new map using a single deference map and an environment type.
     * 
     * @param deferenceMap The deference map to use.
     * @param envType The environment type.
     * @param strategies The population strategies to use.
     * @return The new map.
     */
    protected abstract NamespaceMap<K, V> makeMap(NamespaceMap<K, V> deferenceMap, EnvType envType,
            Collection<? extends PopulationStrategy<K, V>> strategies);

    /**
     * A convenience routine which creates a deference map from two underlying maps.
     * 
     * @param map1 The first map.
     * @param map2 The second map.
     * @return The resulting map.
     */
    protected NamespaceMap<K, V> makeDeferenceMap(NamespaceMap<K, V> map1, NamespaceMap<K, V> map2)
    {
        return new SequentiallyDeferredNamespaceMap<K, V>(CollectionUtilities.listOf(map1, map2));
    }

    /**
     * Creates a map which merges multiple namespace maps in a sequential deference fashion. Every request is sent to
     * the first map; if that request returns no result (such as an empty set of values), the request is then sent to
     * the second map and so on until a value is received. If no map produces a value, a suitable no-value is used.
     * 
     * @param maps The collection of maps to which to defer.
     * @return The resulting map.
     */
    protected NamespaceMap<K, V> makeDeferenceMap(List<? extends NamespaceMap<K, V>> maps)
    {
        return new SequentiallyDeferredNamespaceMap<K, V>(maps);
    }

    /**
     * Obtains the empty namespace map.
     * 
     * @return The empty namespace map.
     */
    protected NamespaceMap<K, V> makeEmptyMap()
    {
        return EmptyNamespaceMap.instance();
    }

    /**
     * An enumeration which categorizes environments based on their usual behaviors.
     */
    protected static enum EnvType
    {
        /** The category used for environments which handle on-demand imports. */
        ON_DEMAND_IMPORT(false, false, OverlapMode.BY_SIGNATURE),
        /** The category used for types and members. This is used for single imports as well. */
        TYPE_OR_MEMBER(true, false, OverlapMode.BY_NAME),
        /** The category used for inherited members. */
        INHERITED(false, false, OverlapMode.BY_SIGNATURE),
        /** The category used for sequential statements. */
        STATEMENT(true, true, OverlapMode.BY_NAME);

        private boolean passiveError;
        private boolean prohibitsOverlap;
        private OverlapMode overlapMode;

        private EnvType(boolean eager, boolean prohibitsOverlap, OverlapMode overlapMode)
        {
            this.passiveError = eager;
            this.prohibitsOverlap = prohibitsOverlap;
            this.overlapMode = overlapMode;
        }

        public boolean isPassiveError()
        {
            return passiveError;
        }

        public boolean isProhibitsOverlap()
        {
            return prohibitsOverlap;
        }

        public OverlapMode getOverlapMode()
        {
            return overlapMode;
        }
    }

    /**
     * A thunk class for retrieving the members of a type declaration body node.
     */
    protected static class BodyMembersThunk extends AbstractThunk<ListNode<?>>
    {
        private final TypeBodyNode<?> node;

        public BodyMembersThunk(TypeBodyNode<?> node)
        {
            super();
            this.node = node;
        }

        @Override
        protected ListNode<?> calculate()
        {
            return node.getMembers();
        }
    }

    /**
     * A thunk class for retrieving the members of a type declaration body node.
     */
    protected static class TypeMembersThunk extends AbstractThunk<ListNode<?>>
    {
        private final NamedTypeDeclarationNode<?> node;

        public TypeMembersThunk(NamedTypeDeclarationNode<?> node)
        {
            super();
            this.node = node;
        }

        @Override
        protected ListNode<?> calculate()
        {
            return node.getBody().getMembers();
        }
    }

    /**
     * A thunk class for retrieving imports from a compilation unit based on type.
     */
    protected static class ImportByTypeThunk<T extends ImportNode> extends AbstractThunk<Iterable<T>>
    {
        private CompilationUnitNode compilationUnitNode;
        private Class<T> clazz;

        public ImportByTypeThunk(CompilationUnitNode compilationUnitNode, Class<T> clazz)
        {
            super();
            this.compilationUnitNode = compilationUnitNode;
            this.clazz = clazz;
        }

        @Override
        protected Iterable<T> calculate()
        {
            Set<ImportNode> results = this.compilationUnitNode.getImports().filter(
                    new FilterByNodeType<ImportNode, T>(this.clazz));
            // The following SuppressWarnings is safe because the set will only contain elements of type T; that is the
            // semantic meaning of the FilterByNodeType.
            @SuppressWarnings("unchecked")
            Iterable<T> ret = (Iterable<T>) results;
            return ret;
        }
    }
}
