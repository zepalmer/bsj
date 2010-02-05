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
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
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
	public void execute(MetacompilationManager manager) throws IOException, BsjCompilerException
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
			throws IOException, BsjCompilerException
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
			Class<A> anchorClass) throws IOException, BsjCompilerException
	{
		Context<A> context = new ContextImpl<A>(anchor);
		BsjMetaprogram<A> metaprogram = compileMetaprogram(anchor.getMetaprogram(), context, anchorClass);

		return new MetaprogramProfile(metaprogram, getTracker());
	}

	private <A extends MetaprogramAnchorNode<? extends Node>> BsjMetaprogram<A> compileMetaprogram(
			MetaprogramNode metaprogramNode, Context<A> context, Class<A> anchorClass) throws IOException,
			BsjCompilerException
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
				factory.makeListNode(Collections.<AnnotationNode> emptyList()));

		// TODO: don't deep copy here (for efficiency)? this means we have to null out the list's parent first?
		BlockNode methodBlock = factory.makeBlockNode(metaprogramNode.getBody().deepCopy(factory));

		MethodDeclarationNode executeMethodImplementation = factory.makeMethodDeclarationNode(methodBlock,
				factory.makeMethodModifiersNode(AccessModifier.PUBLIC, false, false, true, false, false, false,
						factory.makeListNode(Collections.<AnnotationNode> emptyList())),
				factory.makeIdentifierNode("execute"), factory.makeListNode(Collections.<VariableNode> emptyList()),
				null, factory.makeVoidTypeNode(),
				factory.makeListNode(Collections.<UnparameterizedTypeNode> emptyList()),
				factory.makeListNode(Collections.<TypeParameterNode> emptyList()), null);

		ConstructorDeclarationNode constructorImplementation = factory.makeConstructorDeclarationNode(
				factory.makeIdentifierNode(metaprogramClassName),
				factory.makeConstructorBodyNode(
						factory.makeSuperclassConstructorInvocationNode(
								null,
								factory.makeListNode(Arrays.<ExpressionNode> asList(factory.makeFieldAccessByNameNode(parseNameNode(
										"context", NameCategory.EXPRESSION)))),
								factory.makeListNode(Collections.<TypeNode> emptyList())),
						factory.makeListNode(Collections.<BlockStatementNode> emptyList())),
				factory.makeConstructorModifiersNode(AccessModifier.PUBLIC,
						factory.makeListNode(Collections.<AnnotationNode> emptyList())),
				factory.makeListNode(Arrays.<VariableNode> asList(factory.makeVariableNode(
						factory.makeVariableModifiersNode(false,
								factory.makeListNode(Collections.<AnnotationNode> emptyList())),
						factory.makeParameterizedTypeNode(factory.makeUnparameterizedTypeNode(parseNameNode("Context",
								NameCategory.TYPE)), factory.makeListNode(Collections.<TypeArgumentNode> emptyList())),
						factory.makeIdentifierNode("context")))), null,
				factory.makeListNode(Collections.<UnparameterizedTypeNode> emptyList()),
				factory.makeListNode(Collections.<TypeParameterNode> emptyList()), null);

		ClassBodyNode body = factory.makeClassBodyNode(factory.makeListNode(Arrays.<ClassMemberNode> asList(
				executeMethodImplementation, constructorImplementation)));

		TypeDeclarationNode metaprogramClassNode = factory.makeClassDeclarationNode(
				factory.makeClassModifiersNode(AccessModifier.PUBLIC, false, false, false, false,
						factory.makeListNode(Collections.<AnnotationNode> emptyList())),
				factory.makeParameterizedTypeNode(
						factory.makeUnparameterizedTypeNode(parseNameNode("AbstractBsjMetaprogram", NameCategory.TYPE)),
						factory.makeListNode(Arrays.<TypeArgumentNode> asList(factory.makeUnparameterizedTypeNode(parseNameNode(
								anchorClass.getName(), NameCategory.AMBIGUOUS))))),
				factory.makeListNode(Collections.<TypeNode> emptyList()), body,
				factory.makeListNode(Collections.<TypeParameterNode> emptyList()),
				factory.makeIdentifierNode(metaprogramClassName), null);

		CompilationUnitNode metaprogramCompilationUnitNode = factory.makeCompilationUnitNode(packageDeclarationNode,
				factory.makeListNode(imports), factory.makeListNode(Collections.singletonList(metaprogramClassNode)));

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
		// TODO: remove local file management in favor of InMemoryLocationManager (and regression test!)
		// File tmpdir = new File("./local/compile-temp");
		// tmpdir.mkdirs();
		// LocationManager tmplm = new RegularFileLocationManager(null, tmpdir);

		// locationMap.put(BsjCompilerLocation.SOURCE_PATH, tmplm);
		// locationMap.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, tmplm);
		// locationMap.put(BsjCompilerLocation.CLASS_OUTPUT, tmplm);
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
		compiler.compile(Arrays.asList(metaprogramSourceFile));

		ClassLoader metaprogramClassLoader = fileManager.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT);
		Class<? extends BsjMetaprogram<A>> metaprogramClass;
		try
		{
			metaprogramClass = (Class<? extends BsjMetaprogram<A>>) metaprogramClassLoader.loadClass(fullyQualifiedMetaprogramClassName);
		} catch (ClassNotFoundException e)
		{
			throw new IllegalStateException("Class we just compiled is not found!", e);
		}
		Constructor<? extends BsjMetaprogram<A>> constructor;
		try
		{
			constructor = metaprogramClass.getConstructor(Context.class);
		} catch (NoSuchMethodException e)
		{
			throw new IllegalStateException("Class we just compiled does not have the right constructor!", e);
		}
		try
		{
			return constructor.newInstance(context);
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
	 * Utilitiy class for finding metaprogram anchors within an AST.
	 * 
	 * @author Zachary Palmer
	 */
	static class MetaprogramAnchorLocator extends BsjTypedNodeNoOpVisitor
	{
		private List<MetaprogramAnchorNode<?>> metaprogramAnchors = new ArrayList<MetaprogramAnchorNode<?>>();

		@Override
		public void visitMetaprogramAnchorNodeStop(MetaprogramAnchorNode<?> node)
		{
			// TODO: make sure this is actually a top-level metaprogram!
			this.metaprogramAnchors.add(node);
		}

		public List<MetaprogramAnchorNode<?>> getMetaprogramAnchors()
		{
			return metaprogramAnchors;
		}
	}
}
