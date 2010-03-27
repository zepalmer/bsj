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

import javax.tools.JavaCompiler;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.BooleanLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.CharLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.DoubleLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldAccessByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.FloatLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IntLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.LongLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NonAssignmentExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParenthesizedExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.StringLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.metaannotation.MetaAnnotationProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.metaannotation.MetaAnnotationProfileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * The node manager is used to provide a common, central interface for all nodes created by a given factory. Nodes call
 * against the manager to discover information such as the current modification policy or to report information such as
 * the modification of properties.
 * 
 * @author Zachary Palmer
 */
public class BsjNodeManager
{
	/** A UID number for the next expression class to create. */
	private static AtomicLong expressionClassUID = new AtomicLong(0);

	/** A logger for this object. */
	@SuppressWarnings("unused")
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/**
	 * The meta-annotation profile manager used to cache meta-annotation analysis.
	 */
	private MetaAnnotationProfileManager metaAnnotationProfileManager = new MetaAnnotationProfileManager();

	/** The current permission policy manager for nodes. If this manager is null, any mutation is permitted. */
	private PermissionPolicyManager permissionPolicyManager;
	/**
	 * The current dependency manager for metaprogram dependency analysis. If null, all metaprograms are assumed to
	 * cooperate.
	 */
	private DependencyManager dependencyManager;
	/**
	 * The toolkit for this node manager to use.
	 */
	private BsjToolkit toolkit;

	/**
	 * The ID of the currently-running metaprogram. If null, no metaprogram is currently running and no dependency
	 * restrictions are active.
	 */
	private Integer currentMetaprogramId;

	/**
	 * Creates a new node manager.
	 */
	public BsjNodeManager()
	{
		this.permissionPolicyManager = null;
	}

	public PermissionPolicyManager getPermissionPolicyManager()
	{
		return permissionPolicyManager;
	}

	public void setPermissionPolicyManager(PermissionPolicyManager permissionPolicyManager)
	{
		this.permissionPolicyManager = permissionPolicyManager;
	}

	public DependencyManager getDependencyManager()
	{
		return dependencyManager;
	}

	public void setDependencyManager(DependencyManager dependencyManager)
	{
		this.dependencyManager = dependencyManager;
	}

	public Integer getCurrentMetaprogramId()
	{
		return currentMetaprogramId;
	}

	public void setCurrentMetaprogramId(Integer currentMetaprogramId)
	{
		this.currentMetaprogramId = currentMetaprogramId;
	}

	/**
	 * Determines the currently available permission to the specified node.
	 * 
	 * @param node The node in question.
	 * @return The current permission to that node.
	 */
	public NodePermission getPermission(Node node)
	{
		if (node.isBinary())
		{
			return NodePermission.READ;
		} else if (this.permissionPolicyManager == null)
		{
			return NodePermission.MUTATE;
		} else
		{
			return this.permissionPolicyManager.getPermission(node);
		}
	}

	/**
	 * Asserts that permission to the specified node includes the ability to read.
	 * 
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not readable.
	 */
	public void assertReadable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isReadable())
		{
			throw new InsufficientPermissionException(node, NodePermission.READ, permission);
		}
	}

	/**
	 * Asserts that permission to the specified node includes the ability to insert.
	 * 
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not insertable.
	 */
	public void assertInsertable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isInsertable())
		{
			throw new InsufficientPermissionException(node, NodePermission.INSERT, permission);
		}
	}

	/**
	 * Asserts that permission to the specified node includes the ability to mutate.
	 * 
	 * @param node The node in question.
	 * @throws InsufficientPermissionException If the node is not mutatable.
	 */
	public void assertMutatable(Node node) throws InsufficientPermissionException
	{
		NodePermission permission = getPermission(node);
		if (!permission.isMutatable())
		{
			throw new InsufficientPermissionException(node, NodePermission.MUTATE, permission);
		}
	}

	/**
	 * Asserts that the metaprogram with the specified ID cooperates with the current metaprogram.
	 * 
	 * @param id The ID of the metaprogram to check.
	 * @param node The node that the two metaprograms are modifying.
	 * @throws MetaprogramConflictException If the metaprogram with the specified ID does not cooperate with the current
	 *             metaprogram.
	 */
	public void assertCooperation(int id, Node node) throws MetaprogramConflictException
	{
		if (this.dependencyManager == null || this.currentMetaprogramId == null)
			return;

		if (this.dependencyManager.checkCooperation(this.currentMetaprogramId, id))
			return;

		throw new MetaprogramConflictException(this.dependencyManager.getMetaprogramProfileByID(id).getAnchor(),
				this.dependencyManager.getMetaprogramProfileByID(this.currentMetaprogramId).getAnchor(), node);
	}

	/**
	 * Instantiates a meta-annotation object for a meta-annotation node. This method is separated from the
	 * {@link MetaAnnotationNode} implementation to allow multiple invocations of the same meta-annotation class to
	 * share information about the structure of that meta-annotation declaration.
	 * 
	 * @param node The meta-annotation node for which to instantiate an object.
	 * @return The resulting meta-annotation object.
	 * @throws IllegalArgumentException If the meta-annotation object cannot be instantiated or configured.
	 */
	// TODO: better error handling
	public BsjMetaAnnotation instantiateMetaAnnotationObject(MetaAnnotationNode node)
	{
		// Attempt to resolve the meta-annotation class
		Class<? extends BsjMetaAnnotation> clazz = resolveMetaAnnotationClass(node);

		// Obtain the meta-annotation profile for this class
		MetaAnnotationProfile profile = metaAnnotationProfileManager.getProfile(clazz);

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
				// TODO: distinguish between the getter/setter not existing and the getter/setter not having any
				// annotations
				throw new IllegalArgumentException("Invalid property " + propertyName);
			}
			Object value = evaluateValueNode(valueNode, propertyType);

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
	 * @return The class for that meta-annotation.
	 * @throws IllegalArgumentException If no such class can be found.
	 */
	// TODO: better error handling than IllegalArgumentException
	private Class<? extends BsjMetaAnnotation> resolveMetaAnnotationClass(MetaAnnotationNode node)
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
		String baseName;
		NameNode baseNameNode = node.getAnnotationType().getName();
		String suffix = "";
		while (baseNameNode instanceof QualifiedNameNode)
		{
			suffix = "." + baseNameNode.getIdentifier().getIdentifier() + suffix;
			baseNameNode = ((QualifiedNameNode) baseNameNode).getBase();
		}
		baseName = baseNameNode.getIdentifier().getIdentifier();

		Class<?> clazz = null;

		// Next, see if we can find a suitable class using a single type import
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportSingleTypeNode || importNode instanceof SingleStaticImportNode)
			{
				if (importNode.getName().getIdentifier().getIdentifier().equals(baseName))
				{
					String className = importNode.getName().getNameString() + suffix;
					clazz = tryClass(className);
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
					String className = importNode.getName().getNameString() + "."
							+ node.getAnnotationType().getName().getNameString();
					clazz = tryClass(className);
					if (clazz != null)
						break;
				}
			}
		}

		if (clazz == null)
		{
			// The imports were no help. Does the class exist in the base package?
			clazz = tryClass(node.getAnnotationType().getName().getNameString());
		}

		// If we don't have a class yet, it doesn't exist.
		if (clazz == null)
		{
			throw new IllegalArgumentException("Class " + node.getAnnotationType().getName().getNameString()
					+ " does not exist or is not in scope.");
		}

		// If this class represents a BSJ meta-annotation, we're home-free!
		try
		{
			return clazz.asSubclass(BsjMetaAnnotation.class);
		} catch (ClassCastException e)
		{
			// Apparently, it doesn't.
			throw new IllegalArgumentException("Class " + clazz.getName() + " does not implement BsjMetaAnnotation");
		}
	}

	/**
	 * Attempts to obtain a class on the metaprogram classpath of the specified name.
	 * 
	 * @param name The name of the class.
	 * @return The class if it is found; <code>null</code> if it is not.
	 */
	private Class<?> tryClass(String name)
	{
		// TODO: this is assuming that the name terminates in a single type (foo.bar.Baz) rather than an inner class
		// (foo.Bar.Baz). The correct binary name for the latter case is "foo.Bar$Baz" and it's our job to make sure
		// that we translate for the classloader. That means we have to know what parts of this name are package and
		// what parts are class...
		try
		{
			ClassLoader loader = this.toolkit.getFileManager().getLocationManager(
					BsjCompilerLocation.METAPROGRAM_CLASSPATH).getClassLoader();
			return loader.loadClass(name);
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
	 * @throws IllegalArgumentException If something goes wrong.
	 */
	// TODO: better error handling
	private Object evaluateValueNode(MetaAnnotationValueNode value, Class<?> type)
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
				throw new IllegalArgumentException("Array initializer used for non-array type " + type.getName());
			}

			MetaAnnotationArrayValueNode node = (MetaAnnotationArrayValueNode) value;
			Object array = Array.newInstance(type.getComponentType(), node.getValues().size());
			int index = 0;
			for (MetaAnnotationValueNode childNode : node.getValues())
			{
				Object childValue = evaluateValueNode(childNode, type.getComponentType());
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
			Object result = evaluate(expressionNode, imports);
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
	 * @param node The expression node to evaluate.
	 * @param imports The metaprogram imports to use in this environment.
	 * @return The object which was produced by evaluating that expression.
	 */
	private Object evaluate(NonAssignmentExpressionNode node, Collection<MetaprogramImportNode> imports)
	{
		// TODO: write a far more efficient implementation of this!
		// Using the compiler here is just a hack. There really should just be a node operation which operates over
		// any NonAssignmentExpression to produce its value.

		// TODO: replace the exception handling in this method and the call to the validator below with better
		// diagnostic-oriented exceptions. If something goes wrong, the diagnostic exception bubbles up until it is
		// caught by the compiler, which then reports the diagnostic
		// Walk the node and make sure it contains only those nodes which would produce a valid meta-annotation
		// assignment.
		MetaAnnotationElementValueValidator validator = new MetaAnnotationElementValueValidator();
		node.executeOperation(validator, null);

		// Create a copy of the node
		BsjNodeFactory factory = this.toolkit.getNodeFactory();
		node = node.deepCopy(factory);
		// TODO: return type of the parameterized type specified by the meta-annotation declaration
		// This will enforce generic type safety
		MethodDeclarationNode methodNode = factory.makeMethodDeclarationNode(
				factory.makeBlockNode(factory.makeBlockStatementListNode(factory.makeReturnNode(node))),
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
	 * Sets the toolkit that this node manager should use.
	 * 
	 * @param toolkit The toolkit to use.
	 */
	public void setToolkit(BsjToolkit toolkit)
	{
		this.toolkit = toolkit;
	}

	/**
	 * This validator raises an exception whenever it sees a meta-annotation value which contains nodes that are not
	 * valid.
	 * 
	 * @author Zachary Palmer
	 */
	private static class MetaAnnotationElementValueValidator extends BsjDefaultNodeOperation<Void, Void>
	{
		/**
		 * A method used to abstract error handling in this validator. This method is called whenever an error occurs
		 * and raises an appropriate exception.
		 * 
		 * @param node The offending node.
		 */
		private void error(Node node)
		{
			// TODO: better error handling
			throw new IllegalStateException("Invalid node for element value validator: " + node.getClass());
		}

		@Override
		public Void executeDefault(Node node, Void p)
		{
			error(node);
			return null;
		}

		@Override
		public Void executeBooleanLiteralNode(BooleanLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeClassLiteralNode(ClassLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeCharLiteralNode(CharLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeDoubleLiteralNode(DoubleLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeFloatLiteralNode(FloatLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeIntLiteralNode(IntLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeLongLiteralNode(LongLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeStringLiteralNode(StringLiteralNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeTypeCastNode(TypeCastNode node, Void p)
		{
			TypeNode type = node.getType();
			if (type instanceof PrimitiveTypeNode)
			{
				return null;
			}
			if (type instanceof UnparameterizedTypeNode)
			{
				UnparameterizedTypeNode unparameterizedTypeNode = (UnparameterizedTypeNode) node;
				String nameString = unparameterizedTypeNode.getName().getNameString();
				if (nameString.equals("String") || nameString.equals("java.lang.String"))
				{
					return null;
				}
			}

			error(node);
			return null;
		}

		@Override
		public Void executeUnaryExpressionNode(UnaryExpressionNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeBinaryExpressionNode(BinaryExpressionNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeConditionalExpressionNode(ConditionalExpressionNode node, Void p)
		{
			return null;
		}

		@Override
		public Void executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, Void p)
		{
			return node.getExpression().executeOperation(this, p);
		}

		@Override
		public Void executeFieldAccessByNameNode(FieldAccessByNameNode node, Void p)
		{
			// TODO: Ensure that the field being accessed is final or an enum-constant (and therefore final)
			return null;
		}
	}
}
