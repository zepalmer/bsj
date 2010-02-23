package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjMetaprogram;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.ContextImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.StandardBsjCompiler;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

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
		this.factory = context.getFactory();
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

	private <A extends MetaprogramAnchorNode<? extends Node>> void handleAnchor(A anchor)
			throws IOException
	{
		// Build a metaprogram profile for this anchor
		MetaprogramProfile profile = buildProfile(anchor);
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

	private <A extends MetaprogramAnchorNode<? extends Node>> MetaprogramProfile buildProfile(A anchor) throws IOException
	{
		MetaprogramNode metaprogramNode = anchor.getMetaprogram();
		List<String> qualifiedTargetNames = new ArrayList<String>();
		List<String> dependencyNames = new ArrayList<String>();

		// if there's a preamble, deal with it
		if (metaprogramNode.getPreamble() != null)
		{
			MetaprogramPreambleNode metaprogramPreambleNode = metaprogramNode.getPreamble();
			if (metaprogramPreambleNode.getTarget() != null)
			{
				// determine qualifying prefix
				String qualifyingPrefix = getQualifyingPrefix(anchor);
				if (qualifyingPrefix.length() > 0)
					qualifyingPrefix = qualifyingPrefix + ".";

				for (IdentifierNode id : metaprogramPreambleNode.getTarget().getTargets().getChildren())
				{
					qualifiedTargetNames.add(qualifyingPrefix + id.getIdentifier());
				}
			}

			if (metaprogramPreambleNode.getDepends() != null)
			{
				for (NameNode dependsName : metaprogramPreambleNode.getDepends().getTargetNames().getChildren())
				{
					// TODO: what if the dependency name isn't fully qualified? (need type info)
					dependencyNames.add(dependsName.getNameString());
				}
			}
		}

		// now build the metaprogram itself
		Context<A> context = new ContextImpl<A>(anchor);
		BsjMetaprogram<A> metaprogram = compileMetaprogram(metaprogramNode, context, anchor.getClass().getName());

		return new MetaprogramProfile(metaprogram, anchor, dependencyNames, qualifiedTargetNames);
	}

	private <A extends MetaprogramAnchorNode<? extends Node>> BsjMetaprogram<A> compileMetaprogram(
			MetaprogramNode metaprogramNode, Context<A> context, String anchorClassName) throws IOException
	{
		String metaprogramDescription = null;
		if (LOGGER.isTraceEnabled())
		{
			metaprogramDescription = "metaprogram " + metaprogramNode.getUid() + " at " + metaprogramNode.getStartLocation();
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
		// TODO: get a unique identifier
		String metaprogramClassName = "BsjMetaprogram" + metaprogramNode.getUid();
		String fullyQualifiedMetaprogramClassName = metaprogramPackageName + "." + metaprogramClassName;

		// Create nodes for this metaprogram
		PackageDeclarationNode packageDeclarationNode = factory.makePackageDeclarationNode(parseNameNode(
				metaprogramPackageName, NameCategory.PACKAGE));

		// TODO: don't deep copy here (for efficiency)? this means we have to null out the list's parent first?
		BlockNode methodBlock = factory.makeBlockNode(metaprogramNode.getBody().deepCopy(factory));

		MethodDeclarationNode executeMethodImplementation = factory.makeMethodDeclarationNode(methodBlock,
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC), factory.makeIdentifierNode("execute"),
				factory.makeVariableListNode(), factory.makeVoidTypeNode(), null);

		ConstructorDeclarationNode constructorImplementation = factory.makeConstructorDeclarationNode(
				factory.makeIdentifierNode(metaprogramClassName), factory.makeConstructorBodyNode(
						factory.makeSuperclassConstructorInvocationNode(factory.makeExpressionListNode(
								factory.makeFieldAccessByNameNode(parseNameNode("context", NameCategory.EXPRESSION)),
								factory.makeFieldAccessByNameNode(parseNameNode("factory", NameCategory.EXPRESSION)))),
						factory.makeBlockStatementListNode()),
				factory.makeConstructorModifiersNode(AccessModifier.PUBLIC), factory.makeVariableListNode(
						factory.makeVariableNode(factory.makeVariableModifiersNode(),
								factory.makeParameterizedTypeNode(factory.makeUnparameterizedTypeNode(parseNameNode(
										"Context", NameCategory.TYPE)), factory.makeTypeArgumentListNode()),
								factory.makeIdentifierNode("context")), factory.makeVariableNode(
								factory.makeVariableModifiersNode(), factory.makeParameterizedTypeNode(
										factory.makeUnparameterizedTypeNode(parseNameNode("BsjNodeFactory",
												NameCategory.TYPE)), factory.makeTypeArgumentListNode()),
								factory.makeIdentifierNode("factory"))), null);

		ClassBodyNode body = factory.makeClassBodyNode(factory.makeClassMemberListNode(executeMethodImplementation,
				constructorImplementation));

		TypeDeclarationNode metaprogramClassNode = factory.makeClassDeclarationNode(
				factory.makeClassModifiersNode(AccessModifier.PUBLIC),
				factory.makeParameterizedTypeNode(factory.makeUnparameterizedTypeNode(parseNameNode(
						"AbstractBsjMetaprogram", NameCategory.TYPE)),
						factory.makeTypeArgumentListNode(factory.makeUnparameterizedTypeNode(parseNameNode(
								anchorClassName, NameCategory.AMBIGUOUS)))), factory.makeDeclaredTypeListNode(),
				body, factory.makeTypeParameterListNode(), factory.makeIdentifierNode(metaprogramClassName), null);

		CompilationUnitNode metaprogramCompilationUnitNode = factory.makeCompilationUnitNode(metaprogramClassName,
				packageDeclarationNode, factory.makeImportListNode(imports),
				factory.makeTypeDeclarationListNode(metaprogramClassNode));

		if (LOGGER.isTraceEnabled())
		{
			// TODO: get from SPI or toolkit
			BsjSourceSerializer serializer = new BsjSourceSerializerImpl();
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
		locationMap.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH,
				metacompilationContext.getFileManager().getLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH));
		locationMap.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH,
				metacompilationContext.getFileManager().getLocationManager(
						BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH));
		locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH,
				metacompilationContext.getFileManager().getLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH));
		locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
				metacompilationContext.getFileManager().getLocationManager(
						BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH));
		// TODO: annotation processors should be set to in-memory locations

		BsjFileManager fileManager = new LocationMappedFileManager(locationMap);
		BsjFileObject metaprogramSourceFile = fileManager.getFileForOutput(BsjCompilerLocation.SOURCE_PATH,
				metaprogramPackageName, metaprogramClassName + ".bsj", null);
		// TODO: get from SPI or toolkit or similar
		// TODO: we shouldn't need to reserialize just to parse again - add compile to API that takes trees
		BsjSourceSerializer serializer = new BsjSourceSerializerImpl();
		String source = serializer.executeCompilationUnitNode(metaprogramCompilationUnitNode, null);
		metaprogramSourceFile.setCharContent(source);

		// TODO: get from SPI or something
		// TODO: use BsjCompiler interface
		StandardBsjCompiler compiler = new StandardBsjCompiler(fileManager);
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
			throw new IllegalStateException("Class we just compiled is not found!", e);
		}
		Constructor<? extends BsjMetaprogram<A>> constructor;
		try
		{
			constructor = metaprogramClass.getConstructor(Context.class, BsjNodeFactory.class);
		} catch (NoSuchMethodException e)
		{
			throw new IllegalStateException("Class we just compiled does not have the right constructor!", e);
		}
		try
		{
			return constructor.newInstance(context, factory);
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

	/**
	 * Retrieves the qualifying prefix for the specified anchor.
	 * 
	 * @param <A> The type of anchor node used here.
	 * @param anchor The anchor node to use.
	 * @return The fully-qualified name of the type surrounding this anchor.
	 */
	// TODO: replace this with a general NodeOperation that can determine the fully qualified name of any node
	// TODO: what implications does this naming scheme have w.r.t. local and anonymous classes?
	private <A extends MetaprogramAnchorNode<? extends Node>> String getQualifyingPrefix(A anchor)
	{
		StringBuilder sb = new StringBuilder();
		Node node = anchor;
		while (!(node instanceof CompilationUnitNode))
		{
			if (node instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) node;
				if (sb.length() > 0)
					sb.insert(0, '.');
				sb.insert(0, namedTypeDeclarationNode.getIdentifier().getIdentifier());
			}
			node = node.getParent();
		}
		if (node != null)
		{
			CompilationUnitNode compilationUnitNode = (CompilationUnitNode) node;
			if (compilationUnitNode.getPackageDeclaration() != null)
			{
				NameNode nameNode = compilationUnitNode.getPackageDeclaration().getName();
				if (sb.length() > 0)
					sb.insert(0, ".");
				sb.insert(0, nameNode.getNameString());
			}
		}
		return sb.toString();
	}
}
