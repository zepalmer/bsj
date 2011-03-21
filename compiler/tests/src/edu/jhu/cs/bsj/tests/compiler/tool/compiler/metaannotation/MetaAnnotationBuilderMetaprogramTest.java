package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation builder metaprograms.
 * @author Joseph Riley
 * @author Zachary Palmer
 */
public class MetaAnnotationBuilderMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBuilder() throws Exception
	{
	    BsjFileManager manager = performTest("Builder");
	    ClassLoader loader = manager.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT);
	    DynamicClass builderClass = new DynamicClass(loader, "BuilderClass$Builder");
	    DynamicObject builder = builderClass.newInstance(1,2);
	    builder = builder.call("x", 3);
	    builder = builder.call("y", 4);
	    builder = builder.call("s", "testing");
	    builder = builder.call("c", 'j');
	    final Object obj = new Object();
	    builder = builder.call("o", obj);
	    DynamicObject built = builder.call("build");
	    
	    Assert.assertEquals(built.field("a").unwrap(), 1);
	    Assert.assertEquals(built.field("b").unwrap(), 2);
	    Assert.assertEquals(built.field("x").unwrap(), 3);
	    Assert.assertEquals(built.field("y").unwrap(), 4);
	    Assert.assertEquals(built.field("s").unwrap(), "testing");
	    Assert.assertEquals(built.field("c").unwrap(), 'j');
	    Assert.assertEquals(built.field("o").unwrap(), obj);
	    

	    DynamicClass builderClassOther = new DynamicClass(loader, "BuilderClassOther$Builder");
	    DynamicObject builder2 = builderClassOther.newInstance();
	    builder2.call("x",3);
	    builder2.call("y",4);
	    DynamicObject built2 = builder2.call("build");
	    
        Assert.assertEquals(built2.field("x").unwrap(), 3);
        Assert.assertEquals(built2.field("y").unwrap(), 4);	    
	}
}
