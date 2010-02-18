package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaFileObject.Kind;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.BsjTreeLifter;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.StandardBsjCompiler;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.RegularFileLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;
import edu.jhu.cs.bsj.tests.AbstractTest;

public class BsjCompilerTest extends AbstractTest
{
	private static File getTestDir(String suffix)
	{
		return new File("." + File.separator + "local" + File.separator + suffix);
	}

	private static LocationManager getTestLocationManager(String suffix)
	{
		File dir = getTestDir(suffix);
		dir.mkdirs();
		return new RegularFileLocationManager(null, dir);
	}

	@Test
	public void testBsjCompiler() throws Exception
	{
		log4jConfigure("trace", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager/debug",
				"edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug");

		Map<BsjCompilerLocation, LocationManager> map = new HashMap<BsjCompilerLocation, LocationManager>();

		File test = new File("." + File.separator + "local");
		test.mkdir();

		map.put(BsjCompilerLocation.SOURCE_PATH, getTestLocationManager("src"));
		map.put(BsjCompilerLocation.GENERATED_SOURCE_PATH, getTestLocationManager("gensrc"));
		map.put(BsjCompilerLocation.CLASS_OUTPUT, getTestLocationManager("bin"));

		map.put(BsjCompilerLocation.METAPROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.METAPROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));

		map.put(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("sun.boot.class.path")));
		map.put(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, new UnionLocationManager(null,
				System.getProperty("java.class.path")));

		BsjFileManager bfm = new LocationMappedFileManager(map);

		String typeDeclCodeStr = "enum E { A, B }";
		BsjNodeFactory factory = new BsjNodeFactoryImpl();
		BsjParserImpl parser = new BsjParserImpl(factory);
		CompilationUnitNode typeDeclCU = parser.parse(new StringReader(typeDeclCodeStr), null);
		TypeDeclarationNode typeDeclNode = typeDeclCU.getTypeDecls().getChildren().get(0);
		ExpressionNode factoryExpression = factory.makeMethodInvocationByNameNode(factory.makeSimpleNameNode(
				factory.makeIdentifierNode("getFactory"), NameCategory.METHOD), factory.makeExpressionListNode(),
				factory.makeReferenceTypeListNode());
		BsjTreeLifter lifter = new BsjTreeLifter(factory);
		ExpressionNode typeDeclCode = typeDeclNode.executeOperation(lifter, factoryExpression);
		BsjSourceSerializer serializer = new BsjSourceSerializerImpl();
		String typeDeclMakerCode = typeDeclCode.executeOperation(serializer, null);

		String metaCode = "[: #depends a; System.out.println(\"BETA\"); :]"
				+ "[: #target a; System.out.println(\"ALPHA\"); getContext().getAnchor().setReplacement("
				+ typeDeclMakerCode + "); :]";

		String codeStr = metaCode + " public class BsjClass {" + "public String toString(){"
				+ "return(\"Hello, metaworld!\");" + "}" + "}";

		System.out.println(codeStr);

		BsjFileObject bfo = bfm.getJavaFileForOutput(BsjCompilerLocation.SOURCE_PATH, "BsjClass", Kind.SOURCE, null);
		bfo.setCharContent(codeStr);

		StandardBsjCompiler compiler = new StandardBsjCompiler(bfm);
		compiler.compile(Arrays.asList(bfo), null);

		Object o = bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass("BsjClass").newInstance();
		System.out.println(o);
	}

}
