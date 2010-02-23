package edu.jhu.cs.bsj.tests;

import java.io.File;

import junit.framework.Assert;

/**
 * This test routine recursively searches the contents of the example source directory. Directories which are either
 * named "src" or contain Java files are treated as roots of compilation. This test will execute the test method once
 * for each directory root.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractPerDirectoryTest extends AbstractTest
{
	/**
	 * Searches the provided root and invokes {@link #doDirectoryTest(File)} on each candidate directory.
	 * 
	 * @param searchRoot The root to search.
	 * @throws Exception If something goes wrong in one of the tests.
	 */
	public void findAndTestJavaDirectories(File searchRoot) throws Exception
	{
		if (considerDir(searchRoot))
		{
			Assert.assertTrue(doDirectoryTest(searchRoot));
		} else
		{
			for (File f : searchRoot.listFiles())
			{
				findAndTestJavaDirectories(f);
			}
		}
	}

	/**
	 * Considers the provided directory as an example root.
	 * 
	 * @param dir The directory to consider.
	 * @return <code>true</code> to treat it as an example root; <code>false</code> if not.
	 */
	protected boolean considerDir(File dir)
	{
		if (dir.getName().equals("src"))
			return true;
		for (File f : dir.listFiles())
		{
			if (f.getName().endsWith(".java"))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Executes this test for the specified directory.
	 * 
	 * @param dir The directory in question.
	 * @return <code>true</code> if the test succeeded; <code>false</code> if it did not.
	 * @throws Exception If something goes wrong.
	 */
	protected abstract boolean doDirectoryTest(File dir) throws Exception;
}
