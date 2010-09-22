package edu.jhu.cs.bsj.tests.compiler.tool.typechecker.namespace;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.RecordingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.NamespaceBuilder;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.ErasedMethodSignature;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.VariableNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.tests.AbstractTest;

/**
 * Performs unit tests related to namespace construction.
 * 
 * @author Zachary Palmer
 */
public class NamespaceTest extends AbstractTest
{
	// only static because JUnit requires it
	private static NamespaceBuilder builder;
	private static PackageNode rootPackage;
	private static CompilationUnitNode compilationUnitNode;
	private static ClassDeclarationNode exampleNamespaceClassNode;
	private static RecordingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener;

	private static int errorCount = 0;

	@BeforeClass
	public static void makeNamespaceBuilder() throws Exception
	{
		builder = getNamespaceBuilder();
	}

	@AfterClass
	public static void cleanUpNamespaceBuilder() throws Exception
	{
		builder = null;
	}

	private static void assertNoNewErrorDiagnostics(String message) throws Exception
	{
		int oldErrorCount = errorCount;
		errorCount = diagnosticListener.getCount(Kind.ERROR);
		if (oldErrorCount != errorCount)
		{
			List<Diagnostic<? extends BsjSourceLocation>> list = diagnosticListener.getDiagnostics();
			Iterator<Diagnostic<? extends BsjSourceLocation>> it = list.iterator();
			while (it.hasNext())
			{
				if (it.next().getKind() != Kind.ERROR)
					it.remove();
			}
			list = list.subList(list.size() - (errorCount - oldErrorCount), list.size());
			StringBuilder sb = new StringBuilder();
			sb.append(message);
			sb.append('\n');
			for (Diagnostic<? extends BsjSourceLocation> diagnostic : list)
			{
				sb.append(diagnostic.getMessage(null));
				sb.append('\n');
			}
			Assert.fail(sb.toString());
		}
	}

	private static NamespaceBuilder getNamespaceBuilder() throws Exception
	{
		diagnosticListener = new RecordingDiagnosticProxyListener<BsjSourceLocation>(
				new DiagnosticPrintingListener<BsjSourceLocation>(System.err));

		BsjToolkit toolkit = getToolkit(SPECIFIC_SOURCE_DIR);
		final BsjNodeFactory factory = toolkit.getNodeFactory();
		rootPackage = factory.makePackageNode(null);
		final CompilationUnitLoader loader = toolkit.getCompilationUnitLoaderFactory().makeLoader(diagnosticListener);
		compilationUnitNode = loader.load(rootPackage, "ExampleNamespace");
		assertNoNewErrorDiagnostics("Error while loading ExampleNamespace.bsj");

		if (!(compilationUnitNode.getTypeDecls().getFirst() instanceof ClassDeclarationNode))
		{
			Assert.fail("ExampleNamespace.bsj does not start with a top-level class declaration for a class named ExampleNamespace");
		}
		exampleNamespaceClassNode = (ClassDeclarationNode) compilationUnitNode.getTypeDecls().getFirst();

		final TypecheckerManager typecheckerManager = new TypecheckerManager(rootPackage, toolkit.getParser(), loader, diagnosticListener);
		final NamespaceBuilder namespaceBuilder = new NamespaceBuilder(rootPackage, diagnosticListener, loader,
				new TypecheckerToolkit(typecheckerManager, loader));

		return namespaceBuilder;
	}

	private static <K, V extends BsjElement, T extends NamespaceMap<K, V>> V getUniqueMapping(T map, K key,
			BsjSourceLocation sourceLocation) throws Exception
	{
		V element = map.lookup(key, sourceLocation);
		assertNoNewErrorDiagnostics("Diagnostic occurred while getting element for " + key);
		if (element == null)
		{
			Assert.fail("Could not find element for " + key);
		}
		return element;
	}

	@Test
	public void testTopLevelTypeFromCompilationUnit() throws Exception
	{
		TypeNamespaceMap map = builder.getTypeNamespace(exampleNamespaceClassNode);

		getUniqueMapping(map, "ExampleNamespace", exampleNamespaceClassNode.getStartLocation());
	}

	@Test
	public void testAutoImportTypeFromCompilationUnit() throws Exception
	{
		TypeNamespaceMap map = builder.getTypeNamespace(exampleNamespaceClassNode);

		getUniqueMapping(map, "String", exampleNamespaceClassNode.getStartLocation());
	}

	@Test
	public void testPeerTopLevelType() throws Exception
	{
		TypeNamespaceMap map = builder.getTypeNamespace(exampleNamespaceClassNode);

		getUniqueMapping(map, "ExampleNamespace2", exampleNamespaceClassNode.getStartLocation());
	}

	@Test
	public void testMemberMethodFromClassMemberList() throws Exception
	{
		MethodNamespaceMap map = builder.getMethodNamespace(exampleNamespaceClassNode.getBody().getMembers());

		getUniqueMapping(map, new ErasedMethodSignature("test", Collections.<BsjType> emptyList()),
				exampleNamespaceClassNode.getStartLocation());
	}

	@Test
	public void testMemberFieldFromClassMemberList() throws Exception
	{
		VariableNamespaceMap map = builder.getVariableNamespace(exampleNamespaceClassNode.getBody().getMembers());
		
		getUniqueMapping(map, "x", exampleNamespaceClassNode.getStartLocation());
	}
}
