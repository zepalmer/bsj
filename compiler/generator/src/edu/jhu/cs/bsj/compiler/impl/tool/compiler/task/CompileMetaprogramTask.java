package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjMetaprogram;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.ContextImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations.EnclosingNameNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations.TypeDeclarationLocatingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This compilation task compiles a metaprogram using its anchor node.
 * 
 * @author Zachary Palmer
 */
public class CompileMetaprogramTask extends AbstractBsjCompilerTask
{
	/** The packages which should be imported by metaprograms. */
	private static String[] IMPORT_PACKAGES = { "edu.jhu.cs.bsj.compiler.impl.metaprogram",
			"edu.jhu.cs.bsj.compiler.ast", "edu.jhu.cs.bsj.compiler.ast.node", "edu.jhu.cs.bsj.compiler.ast.node.meta",
			"edu.jhu.cs.bsj.compiler.metaprogram" };

	/** A field containing the factory which should be used as this task is executing. */
	private BsjNodeFactory factory;
	/** A field containing the metacompilation context which should be used as this task is executing. */
	private MetacompilationContext metacompilationContext;
	/** A field containing the anchor of the metaprogram to extract. */
	private MetaprogramAnchorNode<?> anchor;

	public CompileMetaprogramTask(MetaprogramAnchorNode<?> anchor)
	{
		super(TaskPriority.COMPILE);
		this.anchor = anchor;
	}

	@Override
	public void execute(MetacompilationContext context) throws IOException
	{
		this.factory = context.getToolkit().getNodeFactory();
		this.metacompilationContext = context;
		handleAnchor(anchor);
	}

	/**
	 * A convenience method for creating a name node given the provided string.
	 * 
	 * @param name The name of the node to create.
	 * @param category The category to assign to all of the components in the name.
	 * @return The created name.
	 */
	private NameNode parseNameNode(String name, NameCategory category)
	{
		if (name.indexOf('.') == -1)
		{
			return factory.makeSimpleNameNode(factory.makeIdentifierNode(name), category);
		} else
		{
			int index = name.lastIndexOf('.');
			return factory.makeQualifiedNameNode(parseNameNode(name.substring(0, index), category),
					factory.makeIdentifierNode(name.substring(index + 1)), category);
		}
	}

	private <A extends MetaprogramAnchorNode<? extends Node>> void handleAnchor(A anchor) throws IOException
	{
		// Build a metaprogram profile for this anchor
		MetaprogramProfile<A> profile = buildProfile(anchor);
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Metaprogram " + profile.getMetaprogram().getID() + " created with deps "
					+ profile.getDependencyNames() + " and targets " + profile.getTargetNames());
		}

		// Clear the metaprogram from the anchor (so it can't reflect on itself or anything messy like that)
		// TODO: is this necessary? has this already been done?
		anchor.setMetaprogram(null);

		// Register the metaprogram profile with the metacompilation manager
		metacompilationContext.getDependencyManager().registerMetaprogramProfile(profile);
	}

	private String getMetaprogramTypeName(MetaprogramAnchorNode<? extends Node> anchor)
	{
		NameNode nameNode = anchor.executeOperation(new EnclosingNameNodeOperation(factory), null);
		if (nameNode == null)
		{
			// TODO: handle anonymous inner classes correctly
			nameNode = factory.makeSimpleNameNode(factory.makeIdentifierNode(anchor.getNearestAncestorOfType(
					CompilationUnitNode.class).getName()), NameCategory.TYPE);
		} else if (nameNode.getCategory() == NameCategory.PACKAGE)
		{
			nameNode = factory.makeQualifiedNameNode(nameNode,
					factory.makeIdentifierNode(anchor.getNearestAncestorOfType(CompilationUnitNode.class).getName()),
					NameCategory.TYPE);
		}
		return nameNode.getNameString();
	}

	private <A extends MetaprogramAnchorNode<? extends Node>> MetaprogramProfile<A> buildProfile(A anchor)
			throws IOException
	{
		MetaprogramNode metaprogramNode = anchor.getMetaprogram();
		MetaprogramLocalMode localMode = MetaprogramLocalMode.INSERT;
		MetaprogramPackageMode packageMode = MetaprogramPackageMode.READ_ONLY;
		List<String> qualifiedTargetNames = new ArrayList<String>();
		List<String> dependencyNames = new ArrayList<String>();

		// if there's a preamble, deal with it
		if (metaprogramNode.getPreamble() != null)
		{
			MetaprogramPreambleNode metaprogramPreambleNode = metaprogramNode.getPreamble();

			localMode = metaprogramPreambleNode.getLocalMode();
			packageMode = metaprogramPreambleNode.getPackageMode();

			if (metaprogramPreambleNode.getTarget() != null)
			{
				// determine qualifying prefix
				String prefix = getMetaprogramTypeName(anchor);

				for (IdentifierNode id : metaprogramPreambleNode.getTarget().getTargets().getChildren())
				{
					String targetName = prefix + "." + id.getIdentifier();
					if (LOGGER.isTraceEnabled())
					{
						LOGGER.trace("Metaprogram for anchor " + anchor.getUid() + " has target " + targetName);
					}
					qualifiedTargetNames.add(targetName);
				}
			}

			if (metaprogramPreambleNode.getDepends() != null)
			{
				for (NameNode dependsName : metaprogramPreambleNode.getDepends().getTargetNames().getChildren())
				{
					// We need a fully-qualified name
					String qualifiedDependsName;
					if (dependsName instanceof SimpleNameNode)
					{
						// Then the base name is that of the enclosing type
						String prefix = getMetaprogramTypeName(anchor);
						qualifiedDependsName = prefix + "." + dependsName.getIdentifier().getIdentifier();
					} else if (dependsName instanceof QualifiedNameNode)
					{
						// Then the base name is the fully qualified form of the specified base name
						QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) dependsName;
						NamedTypeDeclarationNode<?> namedTypeDeclarationNode = dependsName.executeOperation(
								new TypeDeclarationLocatingNodeOperation(qualifiedNameNode.getBase()), null);
						if (namedTypeDeclarationNode == null)
						{
							// TODO: this is an error - produce a diagnostic
							continue;
						} else
						{
							String prefix = getMetaprogramTypeName(anchor);
							qualifiedDependsName = prefix + "." + dependsName.getIdentifier().getIdentifier();
						}
					} else
					{
						throw new IllegalStateException("Unrecognized name node type "
								+ dependsName.getClass().getName());
					}

					if (LOGGER.isTraceEnabled())
					{
						LOGGER.trace("Metaprogram for anchor " + anchor.getUid() + " has dependency "
								+ qualifiedDependsName);
					}
					dependencyNames.add(qualifiedDependsName);
				}
			}
		}

		// now build the metaprogram itself
		Context<A> context = new ContextImpl<A>(anchor, factory);
		BsjMetaprogram<A> metaprogram = compileMetaprogram(metaprogramNode, anchor.getClass().getName());

		return new MetaprogramProfile<A>(metaprogram, anchor, dependencyNames, qualifiedTargetNames, localMode,
				packageMode, context);
	}

	private <A extends MetaprogramAnchorNode<? extends Node>> BsjMetaprogram<A> compileMetaprogram(
			MetaprogramNode metaprogramNode, String anchorClassName) throws IOException
	{
		String metaprogramDescription = null;
		if (LOGGER.isTraceEnabled())
		{
			metaprogramDescription = "metaprogram " + metaprogramNode.getUid() + " at "
					+ metaprogramNode.getStartLocation();
			LOGGER.trace("Generating metaprogram class for " + metaprogramDescription);
		}

		// *** Start by building the metaprogram compilation unit
		// TODO: what kind of package declaration should a metaprogram have?
		String metaprogramPackageName = "foo";

		// Process default imports
		List<ImportNode> imports = new ArrayList<ImportNode>();
		for (String packageString : IMPORT_PACKAGES)
		{
			imports.add(factory.makeImportOnDemandNode(parseNameNode(packageString, NameCategory.PACKAGE)));
		}

		// Find compilation unit
		CompilationUnitNode compilationUnitNode = null;
		{
			Node node = metaprogramNode;
			while (node != null && !(node instanceof CompilationUnitNode))
			{
				node = node.getParent();
			}
			if (node != null)
			{
				compilationUnitNode = (CompilationUnitNode) node;
			}
		}

		// Get global imports
		if (compilationUnitNode != null)
		{
			for (MetaprogramImportNode metaprogramImportNode : compilationUnitNode.getMetaimports().getChildren())
			{
				imports.add(metaprogramImportNode.getImportNode());
			}
		}

		// Process preamble imports
		for (MetaprogramImportNode importNode : metaprogramNode.getPreamble().getImports().getChildren())
		{
			imports.add(importNode.getImportNode());
		}

		// Get metaprogram class name
		String metaprogramClassName = "BsjMetaprogram" + metaprogramNode.getUid();
		String fullyQualifiedMetaprogramClassName = metaprogramPackageName + "." + metaprogramClassName;

		// Create nodes for this metaprogram
		PackageDeclarationNode packageDeclarationNode = factory.makePackageDeclarationNode(parseNameNode(
				metaprogramPackageName, NameCategory.PACKAGE));

		// TODO: don't deep copy here (for efficiency)? this means we have to null out the list's parent first?
		BlockNode methodBlock = factory.makeBlockNode(metaprogramNode.getBody().deepCopy(factory));

		MethodDeclarationNode executeMethodImplementation = factory.makeMethodDeclarationNode(methodBlock,
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), factory.makeIdentifierNode("execute"),
				factory.makeVariableListNode(
						factory.makeVariableNode(factory.makeVariableModifiersNode(),
								factory.makeParameterizedTypeNode(
										factory.makeUnparameterizedTypeNode(
												factory.makeSimpleNameNode(
														factory.makeIdentifierNode("Context"),
														NameCategory.TYPE)),
										factory.makeTypeArgumentListNode(
												factory.makeUnparameterizedTypeNode(parseNameNode(
														anchorClassName, NameCategory.AMBIGUOUS))
												)),
										factory.makeIdentifierNode("context"))
						), factory.makeVoidTypeNode(), null);

		ClassBodyNode body = factory.makeClassBodyNode(factory.makeClassMemberListNode(executeMethodImplementation));

		TypeDeclarationNode metaprogramClassNode = factory.makeClassDeclarationNode(
				factory.makeClassModifiersNode(AccessModifier.PUBLIC),
				factory.makeParameterizedTypeNode(factory.makeUnparameterizedTypeNode(parseNameNode(
						"AbstractBsjMetaprogram", NameCategory.TYPE)),
						factory.makeTypeArgumentListNode(factory.makeUnparameterizedTypeNode(parseNameNode(
								anchorClassName, NameCategory.AMBIGUOUS)))), factory.makeDeclaredTypeListNode(), body,
				factory.makeTypeParameterListNode(), factory.makeIdentifierNode(metaprogramClassName), null);

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
		// TODO: annotation processors should be set to in-memory locations

		BsjFileManager fileManager = new LocationMappedFileManager(locationMap);
		BsjFileObject metaprogramSourceFile = fileManager.getFileForOutput(BsjCompilerLocation.SOURCE_PATH,
				metaprogramPackageName, metaprogramClassName + ".bsj", null);
		BsjSourceSerializer serializer = metacompilationContext.getToolkit().getSerializer();
		String source = serializer.executeCompilationUnitNode(metaprogramCompilationUnitNode, null);
		metaprogramSourceFile.setCharContent(source);

		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(fileManager);
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		// TODO: if this compilation fails, the resulting exception won't make much sense; we need to translate it back
		// to the file from which it originated
		// TODO: perhaps we want to surround the diagnostics that this compilation subprocess produces in a wrapper?
		compiler.compile(Arrays.asList(metaprogramSourceFile), this.metacompilationContext.getDiagnosticListener());

		ClassLoader metaprogramClassLoader = fileManager.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT);
		Class<? extends BsjMetaprogram<A>> metaprogramClass;
		try
		{
			metaprogramClass = metaprogramClassCast(metaprogramClassLoader.loadClass(fullyQualifiedMetaprogramClassName));
		} catch (ClassNotFoundException e)
		{
			throw new IllegalStateException("Class " + fullyQualifiedMetaprogramClassName
					+ " that we just compiled is not found!", e);
		}
		Constructor<? extends BsjMetaprogram<A>> constructor;
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

	/**
	 * A convenience casting method. This method performs a casting operation from the specified class to that of a
	 * metaprogram using the parameterized anchor type. This method is <i>type unsafe</i>; it does not actually ensure
	 * that the class in question has this property. However, forcing the class cast operation into a seperate method
	 * allows the {@link SuppressWarnings} annotation to target only this cast and none of the rest of the method from
	 * which it is called.
	 * 
	 * @param <A> The type of anchor node used by the metaprogram class.
	 * @param loadClass The class to cast.
	 * @return The casted result.
	 */
	@SuppressWarnings("unchecked")
	private <A extends MetaprogramAnchorNode<? extends Node>> Class<? extends BsjMetaprogram<A>> metaprogramClassCast(
			Class<?> loadClass)
	{
		return (Class<? extends BsjMetaprogram<A>>) loadClass;
	}
}
