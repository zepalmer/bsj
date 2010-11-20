package edu.jhu.cs.bsj.compiler.impl.ast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NonAssignmentExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParenthesizedExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.NoOperationDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.InvalidMetaAnnotationArrayInitializerDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaAnnotationClassTypeMismatchDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaAnnotationMissingPropertyDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaAnnotationNonConstantPropertyValueDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MissingMetaAnnotationClassDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.codeliteral.CodeLiteralEvaluator;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.metaannotation.MetaAnnotationProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.metaannotation.MetaAnnotationProfileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.value.SelectionBag;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;

/**
 * This module is designed to perform the operations necessary to instantiate meta-annotation objects.
 * 
 * @author Zachary Palmer
 */
public class MetaAnnotationObjectInstantiator
{
    /** A UID number for the next expression class to create. */
    private static AtomicLong expressionClassUID = new AtomicLong(0);

    /**
     * The toolkit for this module to use.
     */
    private BsjToolkit toolkit;

    /**
     * The meta-annotation profile manager used to cache meta-annotation analysis.
     */
    private MetaAnnotationProfileManager metaAnnotationProfileManager = new MetaAnnotationProfileManager();

    /**
     * Creates a new {@link MetaAnnotationObjectInstantiator}.
     */
    public MetaAnnotationObjectInstantiator(BsjToolkit toolkit)
    {
        this.toolkit = toolkit;
    }

    /**
     * Creates a new meta-annotation metaprogram anchor. This functionality is provided here to prevent nodes from
     * needing access to a factory. It is intended to be used by the {@link MetaAnnotationNode} when an anchor is
     * required to support its annotation object.
     * 
     * @param node The node for which the anchor is being created.
     * @return A new meta-annotation metaprogram anchor.
     */
    public MetaAnnotationMetaprogramAnchorNode instantiateMetaAnnotationMetaprogramAnchor(Node node)
    {
        return this.toolkit.getNodeFactory().makeMetaAnnotationMetaprogramAnchorNode(node.getStartLocation(),
                node.getStopLocation());
    }

    /**
     * Instantiates a meta-annotation object for a meta-annotation node. This method is separated from the
     * {@link MetaAnnotationNode} implementation to allow multiple invocations of the same meta-annotation class to
     * share information about the structure of that meta-annotation declaration.
     * 
     * @param node The meta-annotation node for which to instantiate an object.
     * @param listener The diagnostic listener to which to report errors.
     * @return The resulting meta-annotation object.
     * @throws MetaAnnotationInstantiationFailureException If the meta-annotation object cannot be instantiated or
     *             configured correctly.
     */
    // TODO: fix error handling (currently using IllegalArgumentException)
    public BsjMetaAnnotation instantiateMetaAnnotationObject(MetaAnnotationNode node,
            DiagnosticListener<BsjSourceLocation> listener) throws MetaAnnotationInstantiationFailureException
    {
        // Attempt to resolve the meta-annotation class
        Class<? extends BsjMetaAnnotation> clazz = resolveMetaAnnotationClass(node, listener);

        // Obtain the meta-annotation profile for this class
        MetaAnnotationProfile profile = metaAnnotationProfileManager.getProfile(clazz, listener,
                node.getStartLocation());
        if (profile == null)
        {
            throw new MetaAnnotationInstantiationFailureException();
        }

        // Instantiate the meta-annotation class
        BsjMetaAnnotation metaAnnotationObject;
        try
        {
            metaAnnotationObject = clazz.newInstance();
        } catch (InstantiationException e)
        {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e)
        {
            throw new IllegalArgumentException(e);
        }

        // Extract a mapping from property names to annotation element values
        Map<String, MetaAnnotationValueNode> valueNodeMap = new HashMap<String, MetaAnnotationValueNode>();
        if (node instanceof SingleElementMetaAnnotationNode)
        {
            valueNodeMap.put("value", ((SingleElementMetaAnnotationNode) node).getValue());
        } else if (node instanceof NormalMetaAnnotationNode)
        {
            NormalMetaAnnotationNode normalMetaAnnotationNode = (NormalMetaAnnotationNode) node;
            for (MetaAnnotationElementNode element : normalMetaAnnotationNode.getArguments())
            {
                valueNodeMap.put(element.getIdentifier().getIdentifier(), element.getValue());
            }
        } else
        {
            throw new IllegalStateException("Unrecognized subtype of MetaAnnotationNode: " + node.getClass());
        }

        // For each specified property, evaluate it and call the setter
        for (Map.Entry<String, MetaAnnotationValueNode> entry : valueNodeMap.entrySet())
        {
            String propertyName = entry.getKey();
            MetaAnnotationValueNode valueNode = entry.getValue();
            Class<?> propertyType = profile.getPropertyType(propertyName);
            if (propertyType == null)
            {
                listener.report(new MetaAnnotationMissingPropertyDiagnosticImpl(valueNode.getStartLocation(), clazz,
                        propertyName));
                throw new MetaAnnotationInstantiationFailureException();
            }
            Object value = evaluateValueNode(valueNode, propertyType, clazz, listener, propertyName);

            Method setter = profile.getSetterMap().get(propertyName);
            try
            {
                setter.invoke(metaAnnotationObject, value);
            } catch (IllegalArgumentException e)
            {
                throw new IllegalArgumentException("Value for property " + propertyName + " is an incorrect type", e);
            } catch (IllegalAccessException e)
            {
                throw new IllegalArgumentException("Setter for property " + propertyName
                        + " does not have correct permissions", e);
            } catch (InvocationTargetException e)
            {
                throw new IllegalArgumentException("Setter for property " + propertyName + " raised an exception", e);
            }
        }

        // Now indicate completion
        try
        {
            metaAnnotationObject.complete();
        } catch (InvalidMetaAnnotationConfigurationException e)
        {
            // TODO: Something much more reasonable
            throw new IllegalArgumentException(e);
        }

        // And return the object
        return metaAnnotationObject;
    }

    /**
     * This method locates the meta-annotation class indicated by the provided node. It will use the meta-imports of the
     * compilation unit in which the node is placed (if any) to assist in finding the class.
     * 
     * @param node The node for which a class is desired.
     * @param listener The listener to which to report errors.
     * @return The class for that meta-annotation.
     * @throws MetaAnnotationInstantiationFailureException If no such class can be found.
     */
    private Class<? extends BsjMetaAnnotation> resolveMetaAnnotationClass(MetaAnnotationNode node,
            DiagnosticListener<BsjSourceLocation> listener) throws MetaAnnotationInstantiationFailureException
    {
        // First, establish meta-import set
        Set<ImportNode> imports = new HashSet<ImportNode>();
        CompilationUnitNode compilationUnitNode = node.getNearestAncestorOfType(CompilationUnitNode.class);
        if (compilationUnitNode != null)
        {
            for (MetaprogramImportNode metaprogramImportNode : compilationUnitNode.getMetaimports())
            {
                imports.add(metaprogramImportNode.getImportNode());
            }
        }

        // Find most base name of meta-annotation's type
        NameNode nameNode = node.getAnnotationType().getName();
        NameNode baseNameNode = node.getAnnotationType().getName();
        while (baseNameNode instanceof QualifiedNameNode)
        {
            baseNameNode = ((QualifiedNameNode) baseNameNode).getBase();
        }

        Class<?> clazz = null;

        // If the base name is a type, then an import might apply
        CompilationUnitLoader loader = this.toolkit.getCompilationUnitLoaderFactory().makeLoader(listener);
        if (baseNameNode.getCategory(loader).equals(NameCategory.TYPE))
        {
            // Next, see if we can find a suitable class using a single type import
            for (ImportNode importNode : imports)
            {
                if (importNode instanceof ImportSingleTypeNode || importNode instanceof SingleStaticImportNode)
                {
                    if (importNode.getName().getIdentifier().getIdentifier().equals(
                            baseNameNode.getIdentifier().getIdentifier()))
                    {
                        clazz = tryClass(importNode.getName(), nameNode, true, listener);
                        if (clazz != null)
                            break;
                    }
                }
            }

            if (clazz == null)
            {
                // Didn't find anything direct. Let's look at the on-demand imports
                for (ImportNode importNode : imports)
                {
                    if (importNode instanceof ImportOnDemandNode || importNode instanceof StaticImportOnDemandNode)
                    {
                        clazz = tryClass(importNode.getName(), nameNode, false, listener);
                        if (clazz != null)
                            break;
                    }
                }
            }
        }

        if (clazz == null)
        {
            // The imports were no help. Does the class exist in the base package?
            clazz = tryClass(null, node.getAnnotationType().getName(), false, listener);
        }

        BsjSourceLocation location = node.getStartLocation();
        // If we don't have a class yet, it doesn't exist.
        if (clazz == null)
        {
            listener.report(new MissingMetaAnnotationClassDiagnosticImpl(location, null,
                    node.getAnnotationType().getName().getNameString()));
            throw new MetaAnnotationInstantiationFailureException();
        }

        // If this class represents a BSJ meta-annotation, we're home-free!
        try
        {
            return clazz.asSubclass(BsjMetaAnnotation.class);
        } catch (ClassCastException e)
        {
            // Apparently, it doesn't.
            listener.report(new MetaAnnotationClassTypeMismatchDiagnosticImpl(location, null, clazz.getCanonicalName()));
            throw new MetaAnnotationInstantiationFailureException();
        }
    }

    /**
     * Attempts to obtain a class on the metaprogram classpath of the specified name.
     * 
     * @param importNode The import name to consider or <code>null</code> for no import name.
     * @param name The name of the type to consider.
     * @param ignoreLast <code>true</code> to ignore the last component of the import's name.
     * @param listener The listener to use to report any problems.
     * @return The class if it is found; <code>null</code> if it is not.
     */
    private Class<?> tryClass(NameNode importName, NameNode name, boolean ignoreLast,
            DiagnosticListener<BsjSourceLocation> listener)
    {
        // Create a list of names to consider in order from right to left in the name string
        List<NameNode> names;
        if (importName == null)
        {
            names = Arrays.asList(name);
        } else
        {
            if (ignoreLast)
            {
                if (importName instanceof QualifiedNameNode)
                {
                    names = Arrays.asList(name, ((QualifiedNameNode) importName).getBase());
                } else
                {
                    names = Arrays.asList(name);
                }
            } else
            {
                names = Arrays.asList(name, importName);
            }
        }

        // Set up loop variables
        StringBuilder sb = new StringBuilder();

        // For each name, remove the components and build the binary name appropriately
        CompilationUnitLoader loader = this.toolkit.getCompilationUnitLoaderFactory().makeLoader(listener);
        for (NameNode nameNode : names)
        {
            while (nameNode != null)
            {
                if (sb.length() > 0)
                {
                    if (nameNode.getCategory(loader) == NameCategory.TYPE)
                    {
                        sb.insert(0, '$');
                    } else
                    {
                        sb.insert(0, '.');
                    }
                }

                sb.insert(0, nameNode.getIdentifier().getIdentifier());

                if (nameNode instanceof QualifiedNameNode)
                {
                    nameNode = ((QualifiedNameNode) nameNode).getBase();
                } else
                {
                    nameNode = null;
                }
            }
        }

        // Get the binary name
        String binaryName = sb.toString();

        // Load the class by that name
        try
        {
            ClassLoader classLoader = this.toolkit.getFileManager().getLocationManager(
                    BsjCompilerLocation.METAPROGRAM_CLASSPATH).getClassLoader();
            return classLoader.loadClass(binaryName);
        } catch (ClassNotFoundException e)
        {
            return null;
        }
    }

    /**
     * Evaluates the specified value node.
     * 
     * @param value The node which represents the value.
     * @param type The type of return value expected by the caller.
     * @param annotationClass The class of meta-annotation being processed.
     * @param listener The listener to which to report problems.
     * @param propertyName The name of the property for which this evaluation is occurring.
     * @return The value object for this value node.
     */
    private Object evaluateValueNode(MetaAnnotationValueNode value, Class<?> type,
            Class<? extends BsjMetaAnnotation> annotationClass, DiagnosticListener<BsjSourceLocation> listener,
            String propertyName)
    {
        if (value instanceof MetaAnnotationMetaAnnotationValueNode)
        {
            MetaAnnotationMetaAnnotationValueNode node = (MetaAnnotationMetaAnnotationValueNode) value;
            Object metaAnnotationObject = node.getAnnotation().getMetaAnnotationObject();
            if (type.getComponentType() != null && type.getComponentType().isInstance(metaAnnotationObject))
            {
                // Create a single-element array
                Object array = Array.newInstance(type.getComponentType(), 1);
                Array.set(array, 0, metaAnnotationObject);
                return array;
            } else
            {
                // Return the value
                return metaAnnotationObject;
            }
        } else if (value instanceof MetaAnnotationArrayValueNode)
        {
            // If the type is not an array, bail
            if (type.getComponentType() == null)
            {
                listener.report(new InvalidMetaAnnotationArrayInitializerDiagnosticImpl(value.getStartLocation()));
                return null;
            }

            MetaAnnotationArrayValueNode node = (MetaAnnotationArrayValueNode) value;
            Object array = Array.newInstance(type.getComponentType(), node.getValues().size());
            int index = 0;
            for (MetaAnnotationValueNode childNode : node.getValues())
            {
                Object childValue = evaluateValueNode(childNode, type.getComponentType(), annotationClass, listener,
                        propertyName);
                Array.set(array, index++, childValue);
            }
            return array;
        } else if (value instanceof MetaAnnotationExpressionValueNode)
        {
            MetaAnnotationExpressionValueNode node = (MetaAnnotationExpressionValueNode) value;
            NonAssignmentExpressionNode expressionNode = node.getExpression();
            CompilationUnitNode compilationUnitNode = node.getNearestAncestorOfType(CompilationUnitNode.class);
            Collection<MetaprogramImportNode> imports;
            if (compilationUnitNode != null)
            {
                imports = compilationUnitNode.getMetaimports();
            } else
            {
                imports = Collections.emptySet();
            }
            Object result = evaluate(expressionNode, imports, type, annotationClass, listener, propertyName);
            // TODO: this does not properly handle primitives - component type might be int
            // and int.class.isInstance(5) fails because 5 is autoboxed to an Integer
            if (type.getComponentType() != null && type.getComponentType().isInstance(result))
            {
                // Create a single-element array
                Object array = Array.newInstance(type.getComponentType(), 1);
                Array.set(array, 0, result);
                return array;
            } else
            {
                // Return the value
                return result;
            }
        } else
        {
            throw new IllegalStateException("Unrecognized MetaAnnotationValueNode subtype " + value.getClass());
        }
    }

    /**
     * Evaluates the provided expression.
     * 
     * @param expression The expression node to evaluate.
     * @param imports The metaprogram imports to use in this environment.
     * @param type The type of value expected by the context.
     * @param annotationClass The class of meta-annotation being processed.
     * @param listener The listener to use to report errors.
     * @param propertyName The name of the property for which this evaluation is occurring.
     * @return The object which was produced by evaluating that expression.
     */
    private Object evaluate(NonAssignmentExpressionNode expression, Collection<MetaprogramImportNode> imports,
            Class<?> type, Class<? extends BsjMetaAnnotation> annotationClass,
            DiagnosticListener<BsjSourceLocation> listener, String propertyName)
    {
        // TODO: what about CodeLiteralNode?
        if (expression instanceof RawCodeLiteralNode)
        {
            // must not use the cheap compiler hack on raw code literals - this would cause the resulting node to use
            // a different node manager and thus break the toolkit contract
            // TODO: does it make sense for us to bitbucket diagnostics here
            BsjTypechecker typechecker = this.toolkit.getTypecheckerFactory().makeTypechecker(
                    expression.getRootPackage(), new NoOperationDiagnosticListener<BsjSourceLocation>());
            CodeLiteralEvaluator evaluator = new CodeLiteralEvaluator(typechecker, this.toolkit.getParser());
            SelectionBag<Node> selectionBag = typechecker.getModelingFactory().makeSelectionBag(
                    evaluator.evaluateRawCodeLiteral((RawCodeLiteralNode) expression));
            BsjType expectedType = typechecker.getModelingFactory().makeMetaprogramClasspathType(type);

            Node result = selectionBag.select(expectedType);
            if (result == null)
            {
                // TODO: diagnostic
                throw new NotImplementedYetException("can't yet handle code literal at "
                        + expression.getStartLocation() + " which is ambiguous in context of " + expectedType
                        + " with type " + selectionBag.getType());
            }
            // TODO: verify that it contains no splices and explode if it doesn't
            return result;
        }

        // TODO: write a far more efficient implementation of this!
        // Using the compiler here is just a hack. There really should just be a node operation which operates over
        // any NonAssignmentExpression to produce its value.

        // TODO: replace the exception handling in this method and the call to the validator below with better
        // diagnostic-oriented exceptions. If something goes wrong, the diagnostic exception bubbles up until it is
        // caught by the compiler, which then reports the diagnostic
        // Walk the node and make sure it contains only those nodes which would produce a valid meta-annotation
        // assignment.
        CountingDiagnosticProxyListener<BsjSourceLocation> listenerWrapper = new CountingDiagnosticProxyListener<BsjSourceLocation>(
                listener);
        MetaAnnotationElementValueValidator validator = new MetaAnnotationElementValueValidator(listenerWrapper,
                annotationClass, propertyName, expression);
        expression.receive(validator);
        if (listenerWrapper.getCount(Diagnostic.Kind.ERROR) > 0)
        {
            return null;
        }

        // Create a copy of the node
        BsjNodeFactory factory = this.toolkit.getNodeFactory();
        expression = expression.deepCopy(factory);
        // TODO: return type of the parameterized type specified by the meta-annotation declaration
        // This will enforce generic type safety
        MethodDeclarationNode methodNode = factory.makeMethodDeclarationNode(
                factory.makeBlockStatementListNode(factory.makeReturnNode(expression)),
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC, false, true, true, false, false, false,
                        factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode()),
                factory.makeIdentifierNode("evaluate"), factory.makeVariableListNode(),
                factory.makeUnparameterizedTypeNode(factory.parseNameNode("java.lang.Object")), null);
        String className = "ExpressionClass" + expressionClassUID.getAndIncrement();
        ClassDeclarationNode classNode = factory.makeClassDeclarationNode(
                factory.makeClassModifiersNode(AccessModifier.PUBLIC), null, factory.makeDeclaredTypeListNode(),
                factory.makeClassBodyNode(factory.makeClassMemberListNode(methodNode)),
                factory.makeTypeParameterListNode(), factory.makeIdentifierNode(className), null);
        List<ImportNode> list = new ArrayList<ImportNode>();
        for (MetaprogramImportNode importNode : imports)
        {
            list.add(importNode.getImportNode().deepCopy(factory));
        }

        String packageName = "edu.jhu.cs.bsj.compiler.impl.ast.generated.expressions";
        CompilationUnitNode compilationUnitNode = factory.makeCompilationUnitNode(className,
                factory.makePackageDeclarationNode(factory.parseNameNode(packageName)),
                factory.makeImportListNode(list), factory.makeTypeDeclarationListNode(classNode));

        // Create the file manager that we will use during compilation
        BsjFileManager metaCompilerFileManager = this.toolkit.getFileManager();
        Map<StandardLocation, LocationManager> locationMap = new HashMap<StandardLocation, LocationManager>();
        locationMap.put(StandardLocation.ANNOTATION_PROCESSOR_PATH, new InMemoryLocationManager(null));
        locationMap.put(StandardLocation.CLASS_OUTPUT, new InMemoryLocationManager(null));
        locationMap.put(StandardLocation.CLASS_PATH,
                metaCompilerFileManager.getLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH));
        locationMap.put(StandardLocation.PLATFORM_CLASS_PATH,
                metaCompilerFileManager.getLocationManager(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH));
        locationMap.put(StandardLocation.SOURCE_OUTPUT, new InMemoryLocationManager(null));
        locationMap.put(StandardLocation.SOURCE_PATH, new InMemoryLocationManager(null));
        BsjFileManager manager = new LocationMappedFileManager(locationMap);

        // Put our file in place
        String expressionClassCode = BsjServiceRegistry.newToolkitFactory().newToolkit().getSerializer().executeCompilationUnitNode(
                compilationUnitNode, null);
        BsjFileObject fileObject = null;
        try
        {
            fileObject = manager.getLocationManager(StandardLocation.SOURCE_PATH).getFile(packageName,
                    className + ".java", true);
            fileObject.setCharContent(expressionClassCode);
        } catch (IOException e)
        {
            // Everything's an in-memory file manager so this shouldn't happen
            throw new IllegalStateException(e);
        }

        // Compile!
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // TODO: some kind of sensible error handling!
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, Arrays.asList(fileObject));
        if (!task.call())
        {
            throw new IllegalStateException("Could not compile meta-annotation element value expression!");
        }

        // Retrieve the compiled class
        Class<?> c;
        try
        {
            c = manager.getLocationManager(StandardLocation.CLASS_OUTPUT).getClassLoader().loadClass(
                    packageName + "." + className);
        } catch (ClassNotFoundException e)
        {
            throw new IllegalStateException("Could not find just-compiled class: " + className, e);
        }
        // Execute the evaluation method
        Method evalMethod;
        try
        {
            evalMethod = c.getMethod("evaluate");
        } catch (SecurityException e)
        {
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e)
        {
            throw new IllegalStateException("Just-compiled class lacks the method we just put there!", e);
        }
        Object ret;
        try
        {
            ret = evalMethod.invoke(null);
        } catch (IllegalArgumentException e)
        {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e)
        {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e)
        {
            throw new IllegalStateException(e);
        }

        return ret;
    }

    /**
     * This validator determines whether or not any nodes exist in a subtree which are not constant expressions. This is
     * used to ensure that meta-annotation values are constant expressions.
     * 
     * @author Zachary Palmer
     */
    private static class MetaAnnotationElementValueValidator implements BsjNodeVisitor
    {
        /** The diagnostic listener to which to report errors. */
        private DiagnosticListener<BsjSourceLocation> listener;
        /** The class of meta-annotation which was used. */
        private Class<? extends BsjMetaAnnotation> clazz;
        /** The name of the property we are checking. */
        private String name;
        /** The node which represents the top level value we are checking. */
        private Node top;

        /**
         * The most recently reported problem which is an ancestor of the current node or <code>null</code> if no such
         * problem node exists.
         */
        private Node problemNode;

        public MetaAnnotationElementValueValidator(DiagnosticListener<BsjSourceLocation> listener,
                Class<? extends BsjMetaAnnotation> clazz, String name, Node top)
        {
            super();
            this.listener = listener;
            this.clazz = clazz;
            this.name = name;
            this.top = top;
        }

        @Override
        public void visitStart(Node node)
        {
            if (this.problemNode != null)
                return;

            if (node instanceof LiteralNode<?>)
                return;
            if (node instanceof TypeCastNode)
            {
                TypeNode type = ((TypeCastNode) node).getType();
                if (type instanceof PrimitiveTypeNode)
                {
                    return;
                }
                if (type instanceof UnparameterizedTypeNode)
                {
                    UnparameterizedTypeNode unparameterizedTypeNode = (UnparameterizedTypeNode) node;
                    String nameString = unparameterizedTypeNode.getName().getNameString();
                    if (nameString.equals("String") || nameString.equals("java.lang.String"))
                    {
                        return;
                    }
                }
            }

            if (node instanceof UnaryExpressionNode)
                return;
            if (node instanceof BinaryExpressionNode)
                return;
            if (node instanceof ConditionalExpressionNode)
                return;
            if (node instanceof ParenthesizedExpressionNode)
                return;

            if (node instanceof VariableAccessNode)
            {
                // TODO: Ensure that the field being accessed is final or an enum-constant (and therefore final)
                return;
            }

            // Non-constant node found. Issue a complaint.
            this.problemNode = node;
            this.listener.report(new MetaAnnotationNonConstantPropertyValueDiagnosticImpl(top.getStartLocation(),
                    clazz, name, top, node));
        }

        @Override
        public void visitStop(Node node)
        {
            if (node == this.problemNode)
            {
                this.problemNode = null;
            }
        }
    }

}
