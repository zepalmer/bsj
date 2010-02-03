package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

/**
 * Testing.
 * @author Testing.
 *
 */
public class Sample
{
	/** JAVADOC */
    @Test
    public void testRegeneratorOnExamples()
    {
        File exampleDir = new File("examples");        
        findAndTestJavaFiles(exampleDir);
        
        class Blah<T> extends Object
        {
        	@SuppressWarnings("hiding")
			public <T>Blah()
        	{
        		this.<Integer>foo();
        	}
        	@SuppressWarnings("hiding")
			public <T> void foo()
        	{
        		
        	}
        }
        
        Blah<Integer> blah = new Blah<Integer>();
        blah.foo();        
        
        int[][] x = new int[2][];
        int y[][] = new int[][] {{2},{2}};
        
		int z = 1 + 2 - 3 * 4 / 5 % 6 - (x[1][0] == y[0][0] ? x[1][0] : 7);
		int a = (z == y[0][0] ? x[1][0] : 7);
        
        System.out.println(a);
    }

    /**
     * Recursively find and test all java files in a directory.
     * @param dir the directory to search.
     */
    private void findAndTestJavaFiles(File dir)
    {
        for (File file : dir.listFiles())
        {
            if (file.isDirectory())
            {
                findAndTestJavaFiles(file);
            }
            else if (file.getName().endsWith(".java"))
            {
                System.out.println("Testing " + file.getAbsolutePath());
                try
                {
                    assertTrue(regenerateJavaFile(file));
                } 
                catch (Exception e)
                {
                    e.printStackTrace();
                    fail();
                }
            }            
        }
    }

    /**
     * Regenerate a Java file once, then again using the regenerated source as input.
     * Verify the two regenerated copies of the source are the same.
     * @param file the Java file to test.
     * @return true on success, false on failure.
     * @throws Exception on error.
     */
    private boolean regenerateJavaFile(File file) throws Exception
    {

        return false;
    }
}
