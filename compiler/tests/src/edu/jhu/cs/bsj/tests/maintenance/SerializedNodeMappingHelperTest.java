package edu.jhu.cs.bsj.tests.maintenance;

import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.NodeMappingSerializationOperation;

/**
 * This unit test is designed to ensure that the source code pertaining to the serialized node mapper's helper has been
 * properly maintained.
 * 
 * @author Zachary Palmer
 */
public class SerializedNodeMappingHelperTest
{
	/**
	 * Performs the maintenance test.
	 */
	@Test
	public void test()
	{
		Class<NodeMappingSerializationOperation.MapBuildingHelper> helperClass = NodeMappingSerializationOperation.MapBuildingHelper.class;

		Class<?> operationClass = BsjNodeOperation.class;

		// For each method on the BsjNodeOperation interface, make sure it has been overridden by the helper class
		for (Method m : operationClass.getMethods())
		{
			// We can't search by name and parameter types because the subclass declares more specific types due to
			// the generics.
			boolean found = false;
			for (Method m2 : helperClass.getDeclaredMethods())
			{
				if (m.getName().equals(m2.getName()))
				{
					found = true;
					break;
				}
			}
			Assert.assertTrue("Could not find method " + m.getName() + " on class " + helperClass, found);
		}
	}
}
