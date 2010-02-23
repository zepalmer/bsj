package edu.jhu.cs.bsj.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Assert;

/**
 * Represents a test class which assumes operations will be performed on a per-file basis.
 * @author Zachary Palmer
 */
public abstract class AbstractPerFileTest extends AbstractTest
{
	/**
	 * Recursively find and test all java files in a directory.
	 * 
	 * @param dir the directory to search.
	 */
	public void findAndTestJavaFiles(File dir)
	{
		for (File file : dir.listFiles())
		{
			if (file.isDirectory())
			{
				findAndTestJavaFiles(file);
			} else if (file.getName().endsWith(".java"))
			{
				System.out.println("Testing " + file.getAbsolutePath());
				try
				{
					assertTrue(doFileTest(file));
				} catch (Exception e)
				{
					e.printStackTrace();
					Assert.fail();
				}
			}
		}
	}
	
	/**
	 * Executes the test for one file.
	 * @param file The file to test.
	 * @return <code>true</code> if the test succeeded; <code>false</code> if it failed.
	 * @throws Exception If something goes wrong.
	 */
	protected abstract boolean doFileTest(File file) throws Exception;
}
