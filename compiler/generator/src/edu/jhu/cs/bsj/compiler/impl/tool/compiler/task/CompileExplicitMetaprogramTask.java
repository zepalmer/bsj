package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.LocationTranslatingDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramDependencyTypeNameResolutionDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjUserDiagnosticTranslatingListener;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.ContextImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.Metaprogram;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilerUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.Dependency;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.NodeMappingSerializationOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.SerializedNodeMap;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This compilation task compiles an explicit metaprogram using its anchor node.
 * 
 * @author Zachary Palmer
 */
public class CompileExplicitMetaprogramTask<R extends Node> extends
        AbstractMetaprogramProfileBuildingTask<ExplicitMetaprogramAnchorNode<R>, R>
{
    /** The packages which should be imported by metaprograms. */
    private static String[] IMPORT_PACKAGES = { "edu.jhu.cs.bsj.compiler.impl.metaprogram",
            "edu.jhu.cs.bsj.compiler.ast", "edu.jhu.cs.bsj.compiler.ast.exception",
            "edu.jhu.cs.bsj.compiler.diagnostic.user", "edu.jhu.cs.bsj.compiler.ast.node",
            "edu.jhu.cs.bsj.compiler.ast.node.list", "edu.jhu.cs.bsj.compiler.ast.node.meta",
            "edu.jhu.cs.bsj.compiler.metaprogram" };

    public CompileExplicitMetaprogramTask(ExplicitMetaprogramAnchorNode<R> anchor, InjectionInfo injectionInfo)
    {
        super(TaskPriority.COMPILE_EXPLICIT, anchor, injectionInfo);
    }

    @Override
    protected MetaprogramProfile<ExplicitMetaprogramAnchorNode<R>, R> buildProfile(
            MetacompilationContext metacompilationContext) throws IOException
    {
        // It is possible for this task to be added several times for a given metaprogram node before it is executed.
        // If true, all executions after the first are redundant; the metaprogram anchor will have a nullary metaprogram
        // node. So check that and bail if we're unnecessary.
        if (this.anchor.getMetaprogram() == null)
        {
            return null;
        }

        // TODO: this whole name building process relies on strings - fix it
        // this is a bit of a hack because it allows type and package name collision
        // suppose the existence of a package foo with subpackage bar and class Baz
        // suppose that package foo also has a class bar with inner class Baz
        // the string name foo.bar.Baz.a is now ambiguous even though the BLS specifically indicates that this should
        // not be a problem (fix by using binary names?)

        MetaprogramNode metaprogramNode = anchor.getMetaprogram();
        MetaprogramLocalMode localMode = MetaprogramLocalMode.INSERT;
        MetaprogramPackageMode packageMode = MetaprogramPackageMode.READ_ONLY;
        List<String> qualifiedTargetNames = new ArrayList<String>();
        List<Dependency> dependencies = new ArrayList<Dependency>();
        final String metaprogramTypeName = getMetaprogramTypeName();
        CompilationUnitLoader loader = this.metacompilationContext.getToolkit().getCompilationUnitLoaderFactory().makeLoader(
                this.metacompilationContext.getDiagnosticListener());

        // if there's a preamble, deal with it
        if (metaprogramNode.getPreamble() != null)
        {
            MetaprogramPreambleNode metaprogramPreambleNode = metaprogramNode.getPreamble();

            localMode = metaprogramPreambleNode.getLocalMode();
            packageMode = metaprogramPreambleNode.getPackageMode();

            for (MetaprogramTargetNode target : metaprogramPreambleNode.getTargets())
            {
                // determine qualifying prefix
                for (IdentifierNode id : target.getTargets().getChildren())
                {
                    String targetName = metaprogramTypeName + "." + id.getIdentifier();
                    if (LOGGER.isTraceEnabled())
                    {
                        LOGGER.trace("Metaprogram for anchor " + anchor.getUid() + " has target " + targetName);
                    }
                    qualifiedTargetNames.add(targetName);
                }
            }

            for (MetaprogramDependencyDeclarationNode dependencyDeclaration : metaprogramPreambleNode.getDependencies())
            {
                for (MetaprogramDependencyNode dependency : dependencyDeclaration.getTargets())
                {
                    NameNode dependsName = dependency.getTargetName();
                    boolean weak = dependency.getWeak();

                    // We need a fully-qualified name
                    String qualifiedDependsName;
                    if (dependsName instanceof SimpleNameNode)
                    {
                        // Then the base name is that of the enclosing type
                        qualifiedDependsName = metaprogramTypeName + "." + dependsName.getIdentifier().getIdentifier();
                    } else if (dependsName instanceof QualifiedNameNode)
                    {
                        // Then the base name is the fully qualified form of the specified base name
                        QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) dependsName;
                        NameNode base = qualifiedNameNode.getBase();
                        if (base.getCategory(loader) != NameCategory.TYPE)
                        {
                            // Not allowed!
                            // TODO: diagnostic
                            throw new NotImplementedYetException();
                        }
                        Collection<? extends Node> declarations = this.anchor.getDeclarationsInScope(qualifiedNameNode.getBase());
                        if (declarations.size() == 0)
                        {
                            // We could not find the type name contained in the dependency. This is an error; the
                            // metaprogram is referring to a type which does not exist in the object program namespace.
                            metacompilationContext.getDiagnosticListener().report(
                                    new MetaprogramDependencyTypeNameResolutionDiagnosticImpl(
                                            this.anchor.getStartLocation(), qualifiedNameNode.getBase().getNameString()));
                            return null;
                        } else if (declarations.size() > 1)
                        {
                            // The type which is named is ambiguous
                            // TODO: diagnostic
                            throw new NotImplementedYetException();
                        }
                        Node declaration = declarations.iterator().next();
                        if (!(declaration instanceof NamedTypeDeclarationNode<?>))
                        {
                            // How did this happen? The name refers to a type, so the declaration should name a type.
                            throw new IllegalStateException("Type declaration was not a NamedTypeDeclarationNode: "
                                    + declaration.getClass());
                        }

                        NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) declaration;
                        qualifiedDependsName = namedTypeDeclarationNode.getFullyQualifiedName() + "."
                                + dependsName.getIdentifier().getIdentifier();
                    } else
                    {
                        throw new IllegalStateException("Unrecognized name node type "
                                + dependsName.getClass().getName());
                    }

                    if (LOGGER.isTraceEnabled())
                    {
                        LOGGER.trace("Metaprogram at " + anchor.getStartLocation() + " has " + (weak ? "weak " : "")
                                + "dependency " + qualifiedDependsName);
                    }

                    dependencies.add(new Dependency(qualifiedDependsName, weak));
                }
            }
        }

        // Clear the metaprogram from the anchor (so it can't reflect on itself)
        anchor.setMetaprogram(null);

        // now build the metaprogram itself
        Context<ExplicitMetaprogramAnchorNode<R>, R> context = new ContextImpl<ExplicitMetaprogramAnchorNode<R>, R>(
                anchor, anchor.getDefaultReplacement(factory), factory, new BsjUserDiagnosticTranslatingListener(
                        this.metacompilationContext.getDiagnosticListener(), this.anchor.getStartLocation()), loader,
                this.metacompilationContext.getToolkit().getTypecheckerFactory());

        Metaprogram<ExplicitMetaprogramAnchorNode<R>, R> metaprogram = compileMetaprogram(metaprogramNode, anchor,
                anchor.getClass().getName(), anchor.getReplacementType().getName(),
                this.metacompilationContext.getDiagnosticListener());

        if (metaprogram == null)
        {
            return null;
        }

        return new MetaprogramProfile<ExplicitMetaprogramAnchorNode<R>, R>(metaprogram, anchor, dependencies,
                qualifiedTargetNames, localMode, packageMode, context, injectionInfo.isPurelyInjected());
    }

    private <A extends ExplicitMetaprogramAnchorNode<B>, B extends Node> Metaprogram<A, B> compileMetaprogram(
            MetaprogramNode metaprogramNode, A anchor, String anchorClassName, String replacementClassName,
            DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IOException
    {
        String metaprogramDescription = null;
        if (LOGGER.isTraceEnabled())
        {
            metaprogramDescription = "metaprogram " + metaprogramNode.getUid() + " at "
                    + metaprogramNode.getStartLocation();
            LOGGER.trace("Generating metaprogram class for " + metaprogramDescription);
        }

        // *** Start by building the metaprogram compilation unit
        // Process default imports
        List<ImportNode> imports = new ArrayList<ImportNode>();
        for (String packageString : IMPORT_PACKAGES)
        {
            imports.add(factory.makeImportOnDemandNode(factory.parseNameNode(packageString)));
        }

        // Find compilation unit
        CompilationUnitNode compilationUnitNode = anchor.getNearestAncestorOfType(CompilationUnitNode.class);

        // Get global imports
        if (compilationUnitNode != null)
        {
            for (MetaprogramImportNode metaprogramImportNode : compilationUnitNode.getMetaimports().getChildren())
            {
                imports.add(metaprogramImportNode.getImportNode().deepCopy(factory));
            }
        }

        // Process preamble imports
        for (MetaprogramImportNode importNode : metaprogramNode.getPreamble().getImports().getChildren())
        {
            imports.add(importNode.getImportNode());
        }

        // Get metaprogram class name
        String metaprogramClassName = "Metaprogram" + metaprogramNode.getUid();
        String fullyQualifiedMetaprogramClassName = CompilerUtilities.METAPROGRAM_PACKAGE_NAME + "."
                + metaprogramClassName;

        // Create nodes for this metaprogram
        PackageDeclarationNode packageDeclarationNode = factory.makePackageDeclarationNode(factory.parseNameNode(CompilerUtilities.METAPROGRAM_PACKAGE_NAME));

        // Steal the method body from the metaprogram node
        BlockStatementListNode metaprogramBody = metaprogramNode.getBody();
        metaprogramNode.setBody(null);

        // Build the contents of the metaprogram class
        MethodDeclarationNode executeMethodImplementation = factory.makeMethodDeclarationNode(
                metaprogramBody,
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC),
                factory.makeIdentifierNode("execute"),
                factory.makeVariableListNode(factory.makeVariableNode(
                        factory.makeVariableModifiersNode(),
                        factory.makeParameterizedTypeNode(
                                factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(factory.makeIdentifierNode("Context"))),
                                factory.makeTypeArgumentListNode(
                                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(anchorClassName)),
                                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(replacementClassName)))),
                        factory.makeIdentifierNode("context"))), factory.makeVoidTypeNode(), null);

        ClassBodyNode body = factory.makeClassBodyNode(factory.makeClassMemberListNode(executeMethodImplementation));

        TypeDeclarationNode metaprogramClassNode = factory.makeClassDeclarationNode(
                factory.makeClassModifiersNode(AccessModifier.PUBLIC),
                factory.makeParameterizedTypeNode(
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode("AbstractMetaprogram")),
                        factory.makeTypeArgumentListNode(
                                factory.makeUnparameterizedTypeNode(factory.parseNameNode(anchorClassName)),
                                factory.makeUnparameterizedTypeNode(factory.parseNameNode(replacementClassName)))),
                factory.makeDeclaredTypeListNode(), body, factory.makeTypeParameterListNode(),
                factory.makeIdentifierNode(metaprogramClassName), null);

        CompilationUnitNode metaprogramCompilationUnitNode = factory.makeCompilationUnitNode(metaprogramClassName,
                packageDeclarationNode, factory.makeImportListNode(imports),
                factory.makeTypeDeclarationListNode(metaprogramClassNode));

        if (LOGGER.isTraceEnabled())
        {
            BsjSourceSerializer serializer = metacompilationContext.getToolkit().getSerializer();
            String source = serializer.executeCompilationUnitNode(metaprogramCompilationUnitNode, null);
            LOGGER.trace("Generated metaprogram class " + fullyQualifiedMetaprogramClassName + " for "
                    + metaprogramDescription + "; source looks like this: \n" + source);
        }

        // *** Compile the metaprogram in memory
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Compiling metaprogram class " + fullyQualifiedMetaprogramClassName + " for "
                    + metaprogramDescription);
        }

        Map<BsjCompilerLocation, LocationManager> locationMap = new HashMap<BsjCompilerLocation, LocationManager>();
        locationMap.put(BsjCompilerLocation.SOURCE_PATH, new InMemoryLocationManager(null));
        locationMap.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, new InMemoryLocationManager(null));
        locationMap.put(BsjCompilerLocation.CLASS_OUTPUT, new InMemoryLocationManager(null));
        // use current metaprogram classpath for metaprogram's meta- and object classpaths
        BsjFileManager bsjFileManager = metacompilationContext.getToolkit().getFileManager();
        locationMap.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH,
                bsjFileManager.getLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH));
        locationMap.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH,
                bsjFileManager.getLocationManager(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH));
        locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH,
                bsjFileManager.getLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH));
        locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
                bsjFileManager.getLocationManager(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH));
        locationMap.put(BsjCompilerLocation.ANNOTATION_PROCESSOR_PATH, new InMemoryLocationManager(null));
        locationMap.put(BsjCompilerLocation.ANNOTATION_PROCESSOR_OUTPUT, new InMemoryLocationManager(null));

        BsjFileManager fileManager = new LocationMappedFileManager(locationMap);
        BsjFileObject metaprogramSourceFile = fileManager.getFileForOutput(BsjCompilerLocation.SOURCE_PATH,
                CompilerUtilities.METAPROGRAM_PACKAGE_NAME, metaprogramClassName + ".bsj", null);
        NodeMappingSerializationOperation serializer = NodeMappingSerializationOperation.make();
        Pair<String, SerializedNodeMap> serialized = serializer.executeCompilationUnitNode(
                metaprogramCompilationUnitNode, null);
        String source = serialized.getFirst();
        SerializedNodeMap nodeMap = serialized.getSecond();
        metaprogramSourceFile.setCharContent(source);

        BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
        toolkitFactory.setFileManager(fileManager);
        BsjToolkit toolkit = toolkitFactory.newToolkit();

        BsjCompiler compiler = toolkit.getCompiler();
        CountingDiagnosticProxyListener<BsjSourceLocation> wrappingDiagnosticListener = new CountingDiagnosticProxyListener<BsjSourceLocation>(
                new LocationTranslatingDiagnosticListener(diagnosticListener, nodeMap,
                        metaprogramNode.getStartLocation()));
        compiler.compile(Arrays.asList(metaprogramSourceFile), wrappingDiagnosticListener);
        if (wrappingDiagnosticListener.getCount(Kind.ERROR) > 0)
        {
            // A compilation error occurred; bail out
            return null;
        }

        // TODO: Consider: Leaving out the object program system classpath is good, right?  Otherwise, multiple versions
        // of java.lang.Object would show up?
        ClassLoader metaprogramClassLoader = fileManager.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT,
                BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH);
        Class<? extends Metaprogram<A, B>> metaprogramClass;
        try
        {
            @SuppressWarnings("unchecked")
            Class<? extends Metaprogram<A, B>> temp = (Class<? extends Metaprogram<A, B>>) metaprogramClassLoader.loadClass(fullyQualifiedMetaprogramClassName);
            metaprogramClass = temp;
        } catch (ClassNotFoundException e)
        {
            throw new IllegalStateException("Class " + fullyQualifiedMetaprogramClassName
                    + " that we just compiled is not found!", e);
        }
        Constructor<? extends Metaprogram<A, B>> constructor;
        try
        {
            constructor = metaprogramClass.getConstructor();
        } catch (NoSuchMethodException e)
        {
            throw new IllegalStateException("Class we just compiled does not have the right constructor!", e);
        }
        try
        {
            return constructor.newInstance();
        } catch (IllegalArgumentException e)
        {
            throw new IllegalStateException("Instantiation of BSJ metaprogram class failed!", e);
        } catch (InstantiationException e)
        {
            throw new IllegalStateException("Instantiation of BSJ metaprogram class failed!", e);
        } catch (IllegalAccessException e)
        {
            throw new IllegalStateException("Instantiation of BSJ metaprogram class failed!", e);
        } catch (InvocationTargetException e)
        {
            throw new IllegalStateException("Instantiation of BSJ metaprogram class failed!", e);
        }
    }
}
