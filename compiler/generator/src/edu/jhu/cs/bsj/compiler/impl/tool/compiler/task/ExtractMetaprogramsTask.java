package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjMetaprogram;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.ContextImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitStatus;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;
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
 * This compilation task extracts all of the metaprograms from the provided tracker's AST. The metaprograms are compiled
 * and registered for execution.
 * 
 * @author Zachary Palmer
 */
public class ExtractMetaprogramsTask extends CompilationUnitTask
{
	/** The packages which should be imported by metaprograms. */
	private static String[] IMPORT_PACKAGES = { "edu.jhu.cs.bsj.compiler.impl.metaprogram",
			"edu.jhu.cs.bsj.compiler.ast", "edu.jhu.cs.bsj.compiler.ast.node", "edu.jhu.cs.bsj.compiler.ast.node.meta",
			"edu.jhu.cs.bsj.compiler.metaprogram" };

	/** A field containing the factory which should be used as this task is executing. */
	private BsjNodeFactory factory;
	/** A field containing the metacompilation manager which should be used as this task is executing. */
	private MetacompilationManager metacompilationManager;

	public ExtractMetaprogramsTask(CompilationUnitTracker tracker)
	{
		super(tracker, TaskPriority.EXTRACT);
	}

	@Override
	public void execute(MetacompilationManager manager) throws IOException
	{
		this.factory = manager.getFactory();
		this.metacompilationManager = manager;

		// Find all metaprogram anchors
		MetaprogramAnchorLocator locator = new MetaprogramAnchorLocator();
		getTracker().getAst().receiveTyped(locator);
		List<MetaprogramAnchorNode<?>> anchors = locator.getMetaprogramAnchors();

		// Handle each anchor in turn
		for (MetaprogramAnchorNode<?> anchor : anchors)
		{
			if (anchor instanceof BlockStatementMetaprogramAnchorNode)
			{
				handleAnchor((BlockStatementMetaprogramAnchorNode) anchor, BlockStatementMetaprogramAnchorNode.class);
			} else if (anchor instanceof TypeDeclarationMetaprogramAnchorNode)
			{
				handleAnchor((TypeDeclarationMetaprogramAnchorNode) anchor, TypeDeclarationMetaprogramAnchorNode.class);
			} else
			{
				throw new IllegalStateException("Don't know how to handle metaprogram anchor of type "
						+ anchor.getClass());
			}
		}

		// Adjust tracker status
		if (getTracker().getMetaprogramsOutstanding() > 0)
		{
			getTracker().setStatus(CompilationUnitStatus.METAPROGRAMS_EXTRACTED);
		} else
		{
			getTracker().setStatus(CompilationUnitStatus.METAPROGRAMS_EXECUTED);
		}
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

	private <A extends MetaprogramAnchorNode<? extends Node>> void handleAnchor(A anchor, Class<A> anchorClass)
			throws IOException
	{
		// Build a metaprogram profile for this anchor
		MetaprogramProfile profile = buildProfile(anchor, anchorClass);

		// Clear the metaprogram from the anchor (so it can't reflect on itself or anything messy like that)
		// TODO: is this necessary? has this already been done?
		anchor.setMetaprogram(null);

		// Register the metaprogram profile with the metacompilation manager
		metacompilationManager.registerMetaprogramProfile(profile);

		getTracker().setMetaprogramsOutstanding(getTracker().getMetaprogramsOutstanding() + 1);
	}

	private <A extends MetaprogramAnchorNode<? extends Node>> MetaprogramProfile buildProfile(A anchor,
			Class<A> anchorClass) throws IOException
	{
		Context<A> context = new ContextImpl<A>(anchor);
		BsjMetaprogram<A> metaprogram = compileMetaprogram(anchor.getMetaprogram(), context, anchorClass);

		return new MetaprogramProfile(metaprogram, anchor, getTracker());
	}

	private <A extends MetaprogramAnchorNode<? extends Node>> BsjMetaprogram<A> compileMetaprogram(
			MetaprogramNode metaprogramNode, Context<A> context, Class<A> anchorClass) throws IOException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Generating metaprogram class for " + getTracker().getName());
		}

		// *** Start by building the metaprogram compilation unit
		// TODO: what kind of package declaration should a metaprogram have?
		String metaprogramPackageName = "foo";

		List<ImportNode> imports = new ArrayList<ImportNode>();
		for (String packageString : IMPORT_PACKAGES)
		{
			imports.add(factory.makeImportOnDemandNode(parseNameNode(packageString, NameCategory.PACKAGE), false));
		}

		// Get metaprogram class name
		// TODO: get a unique identifier
		String metaprogramClassName = "BsjMetaprogram$$$";
		String fullyQualifiedMetaprogramClassName = metaprogramPackageName + "." + metaprogramClassName;

		// Create metaprogram nodes
		PackageDeclarationNode packageDeclarationNode = factory.makePackageDeclarationNode(parseNameNode(
				metaprogramPackageName, NameCategory.PACKAGE),
				factory.makeAnnotationListNode(Collections.<AnnotationNode> emptyList()));

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
								anchorClass.getName(), NameCategory.AMBIGUOUS)))), factory.makeTypeListNode(), body,
				factory.makeTypeParameterListNode(), factory.makeIdentifierNode(metaprogramClassName), null);

		CompilationUnitNode metaprogramCompilationUnitNode = factory.makeCompilationUnitNode(packageDeclarationNode,
				factory.makeImportListNode(imports), factory.makeTypeDeclarationListNode(metaprogramClassNode));

		if (LOGGER.isTraceEnabled())
		{
			// TODO: get from SPI or toolkit
			BsjSourceSerializer serializer = new BsjSourceSerializerImpl();
			String source = serializer.executeCompilationUnitNode(metaprogramCompilationUnitNode, null);
			LOGGER.trace("Generated metaprogram class " + fullyQualifiedMetaprogramClassName + " for "
					+ getTracker().getName() + "; source looks like this: \n" + source);
		}

		// *** Compile the metaprogram in memory
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Compiling metaprogram class " + fullyQualifiedMetaprogramClassName + " for "
					+ getTracker().getName());
		}

		Map<BsjCompilerLocation, LocationManager> locationMap = new HashMap<BsjCompilerLocation, LocationManager>();
		locationMap.put(BsjCompilerLocation.SOURCE_PATH, new InMemoryLocationManager(null));
		locationMap.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, new InMemoryLocationManager(null));
		locationMap.put(BsjCompilerLocation.CLASS_OUTPUT, new InMemoryLocationManager(null));
		// use current metaprogram classpath for metaprogram's meta- and object classpaths
		locationMap.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH,
				metacompilationManager.getFileManager().getLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH));
		locationMap.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH,
				metacompilationManager.getFileManager().getLocationManager(
						BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH));
		locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH,
				metacompilationManager.getFileManager().getLocationManager(BsjCompilerLocation.METAPROGRAM_CLASSPATH));
		locationMap.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
				metacompilationManager.getFileManager().getLocationManager(
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
		compiler.compile(Arrays.asList(metaprogramSourceFile), this.metacompilationManager.getDiagnosticListener());

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
	 * Utilitiy class for finding metaprogram anchors within an AST.
	 * 
	 * @author Zachary Palmer
	 */
	static class MetaprogramAnchorLocator extends BsjTypedNodeNoOpVisitor
	{
		private List<MetaprogramAnchorNode<?>> metaprogramAnchors = new ArrayList<MetaprogramAnchorNode<?>>();

		private int metaprogramLevels = 0;

		@Override
		public void visitMetaprogramAnchorNodeStart(MetaprogramAnchorNode<?> node)
		{
			this.metaprogramLevels++;
		}

		@Override
		public void visitMetaprogramAnchorNodeStop(MetaprogramAnchorNode<?> node)
		{
			this.metaprogramLevels--;
			if (this.metaprogramLevels == 0)
			{
				this.metaprogramAnchors.add(node);
			}
		}

		public List<MetaprogramAnchorNode<?>> getMetaprogramAnchors()
		{
			return metaprogramAnchors;
		}
	}
}