package edu.jhu.cs.bsj.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Assert;
import org.junit.Assume;

/**
 * Represents a test class which assumes operations will be performed on a series of Java source files.  Each file is
 * tested individually.
 * @author Zachary Palmer
 */
public abstract class AbstractPerFileTest extends AbstractTest
{
    public static final File PER_FILE_SOURCE_DIR = new File(EXAMPLES + File.separator + "projects");

    /**
	 * Recursively find and test all java files in a directory.
	 * 
	 * @param dir the directory to search.
	 */
	public void findAndTestJavaFiles(File dir)
	{
		Assume.assumeTrue(Boolean.getBoolean("bsj.tests.run.slow"));
		if (!dir.exists())
		{
			Assert.fail("Resource directory " + dir.getAbsolutePath() + " does not exist.");
		}
		for (File file : dir.listFiles())
		{
			if (file.isDirectory())
			{
				findAndTestJavaFiles(file);
			} else if (file.getName().endsWith(".java"))
			{
				LOGGER.info("Testing " + file.getAbsolutePath());
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
