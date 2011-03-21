package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation observable metaprograms.
 * @author Joseph Riley
 * @author Zachary Palmer
 */
public class MetaAnnotationObservableMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
	    BsjFileManager fileManager = performTest("Observable");
	    ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
	    
	    DynamicClass observableClass = new DynamicClass(loader, "ObservableClass");
	    DynamicClass listenerClass = new DynamicClass(loader, "Listener");
	    DynamicClass myEventClass = new DynamicClass(loader, "MyEvent");
	    
	    DynamicObject observableObj = observableClass.newInstance();
	    DynamicObject listenerObj = listenerClass.newInstance();
	    observableObj.call("addMyListener", listenerObj.unwrap());
	    observableObj.call("fireMyEvent", myEventClass.newInstance(7).unwrap());
	    
	    Assert.assertEquals(1, listenerClass.field("calls").unwrap());
	    
	    observableObj.call("removeMyListener", listenerObj.unwrap());
	    observableObj.call("fireMyEvent", myEventClass.newInstance(6).unwrap());
	    
	    Assert.assertEquals(1, listenerClass.field("calls").unwrap());
	}
}
