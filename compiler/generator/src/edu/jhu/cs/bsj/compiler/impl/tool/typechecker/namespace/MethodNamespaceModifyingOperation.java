package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.ErasedMethodSignature;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.FilteredListNodeMethodPopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.utils.function.AbstractThunk;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

/**
 * Provides method namespace modification.
 * 
 * @author Zachary Palmer
 */
public class MethodNamespaceModifyingOperation extends
        AbstractNamespaceModifyingOperation<ErasedMethodSignature, BsjExecutableElement>
{
    /**
     * Creates a type namespace modifier.
     * 
     * @param toolkit The typechecker toolkit to use to create elements.
     * @param loader The compilation unit loader to use when loading of compilation units is necessary.
     * @param listener The listener to which diagnostics will be reported.
     */
    public MethodNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoadingInfo loader,
            DiagnosticListener<BsjSourceLocation> listener)
    {
        super(toolkit, loader, listener);
    }

    /**
     * Performs a default operation for nodes which do not affect the method namespace.
     */
    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeDefault(
            Node node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
    {
        return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                map);
    }

    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeAnnotationBodyNode(
            final AnnotationBodyNode node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
    {
        // *** Populate elements inherited from java.lang.annotation.Annotation
        AnnotationDeclarationNode declarationNode = (AnnotationDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> memberStrategy;
        memberStrategy = populateElements(new BodyMembersThunk(node), AccessModifier.PRIVATE);
        // * Build the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                map);
    }

    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeAnonymousClassBodyNode(
            final AnonymousClassBodyNode node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
    {
        // *** Populate inherited members
        map = makeInheritedMapFor(node, map);

        // *** Create a new environment for declared members
        // * Populate declared members
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> memberStrategy;
        memberStrategy = populateElements(new BodyMembersThunk(node), AccessModifier.PRIVATE);
        // * Build the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                map);
    }

    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeClassBodyNode(
            ClassBodyNode node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
    {
        // *** Inherit member elements
        AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode = (AbstractlyUnmodifiedClassDeclarationNode<?>) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> memberStrategy;
        memberStrategy = populateElements(new BodyMembersThunk(node), AccessModifier.PRIVATE);
        // * Build the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                map);
    }

    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeCompilationUnitNode(
            final CompilationUnitNode node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
    {
        // Only the type declarations contained in a compilation unit benefit from the declarations contained within
        // it; import statements, for instance, do not apply to other import statements.
        NamespaceMap<ErasedMethodSignature, BsjExecutableElement> defaultMap = map;

        // *** Create a new scope for the on-demand imports
        // * Process on-demand static imports.
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> onDemandStaticImportStrategy;
        onDemandStaticImportStrategy = populateOnDemandStaticImports(new ImportByTypeThunk<StaticImportOnDemandNode>(
                node, StaticImportOnDemandNode.class));
        // * Build the map
        map = makeMap(map, EnvType.ON_DEMAND_IMPORT, onDemandStaticImportStrategy);

        // *** Create a new scope for single static imports and top-level type declarations
        // * Process single-type static imports.
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> singleStaticImportStrategy;
        singleStaticImportStrategy = populateSingleStaticImports(new ImportByTypeThunk<SingleStaticImportNode>(node,
                SingleStaticImportNode.class));
        // * Process top-level type declarations. The addition of the public top-level type declaration will, of
        // course, be redundant (because it was obtained in from package peers above). The same typespace map is used,
        // since a top-level type named N in the same compilation unit and a single-static import of a type named N will
        // conflict.
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> topLevelDeclarationStrategy;
        topLevelDeclarationStrategy = populateElements(new AbstractThunk<ListNode<?>>()
        {
            protected ListNode<?> calculate()
            {
                return node.getTypeDecls();
            }
        }, AccessModifier.PUBLIC);
        // * Build the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, singleStaticImportStrategy, topLevelDeclarationStrategy);

        // *** Finished!
        Map<Node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement>> namespaceMap = Collections.<Node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement>> singletonMap(
                node.getTypeDecls(), map);
        return new MappedChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                defaultMap, namespaceMap);
    }

    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeEnumBodyNode(
            EnumBodyNode node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
    {
        // *** Inherit member elements
        EnumDeclarationNode declarationNode = (EnumDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Add hard-coded elements as specified in JLS v3 S8.9
        // TODO: how do we create elements which are not backed by AST nodes?
        // public static E[] values();
        // public static E valueOf(String);

        // * Populate member elements
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> memberStrategy;
        memberStrategy = populateElements(new BodyMembersThunk(node), AccessModifier.PRIVATE);
        // * Build the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                map);
    }

    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeInterfaceBodyNode(
            InterfaceBodyNode node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
    {
        // *** Inherit member elements
        InterfaceDeclarationNode declarationNode = (InterfaceDeclarationNode) node.getParent();
        map = makeInheritedMapFor(declarationNode, map);

        // *** Create a new scope for declared member elements
        // * Populate member elements
        PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> memberStrategy;
        memberStrategy = populateElements(new BodyMembersThunk(node), AccessModifier.PRIVATE);
        // * Build the map
        map = makeMap(map, EnvType.TYPE_OR_MEMBER, memberStrategy);

        // *** Finished!
        return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                map);
    }

    @Override
    public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement> executeMetaprogramNode(
            MetaprogramNode node, NamespaceMap<ErasedMethodSignature, BsjExecutableElement> map)
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
        map = makeEmptyMap();
        return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement>(
                map);
    }

    // ***** UTILITY METHODS **************************************************

    @Override
    protected NamespaceMap<ErasedMethodSignature, BsjExecutableElement> makeInheritanceMapFromSubmaps(Collection<NamespaceMap<ErasedMethodSignature, BsjExecutableElement>> submaps,
            Collection<? extends PopulationStrategy<ErasedMethodSignature, BsjExecutableElement>> strategies)
    {
        return new MethodNamespaceMap(submaps, getListener(), EnvType.INHERITED.isPassiveError(),
                EnvType.INHERITED.isProhibitsOverlap(), strategies, EnvType.INHERITED.getOverlapMode());
    }

    @Override
    protected NamespaceMap<ErasedMethodSignature, BsjExecutableElement> makeMap(NamespaceMap<ErasedMethodSignature, BsjExecutableElement> deferenceMap, EnvType envType,
            Collection<? extends PopulationStrategy<ErasedMethodSignature, BsjExecutableElement>> strategies)
    {
        return new MethodNamespaceMap(Collections.singletonList(deferenceMap), getListener(), envType.isPassiveError(),
                envType.isProhibitsOverlap(), strategies, envType.getOverlapMode());
    }

    @Override
    protected PopulationStrategy<ErasedMethodSignature, BsjExecutableElement> populateElements(
            Thunk<ListNode<?>> nodesThunk, AccessModifier access, boolean skipNonMembers, String name)
    {
        return new FilteredListNodeMethodPopulationStrategy(nodesThunk, access, skipNonMembers, name, getToolkit());
    }
}
