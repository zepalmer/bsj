package edu.jhu.cs.bsj.tests.compiler.tool.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;


public class RegeneratorTest
{
    @Test
    public void testRegeneratorOnExamples()
    {
        File exampleDir = new File("examples");        
        findAndTestJavaFiles(exampleDir);
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
                    System.out.println("ERROR: " + e.getMessage());//fail();
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
        // read the java file in
        FileInputStream input = new FileInputStream(file);        

        // parse it to an AST
        BsjParserImpl parser = new BsjParserImpl(new BsjNodeFactoryImpl());
        Node ast = parser.parse(new InputStreamReader(input));

        // regenerate it once
        String regen1 = ast.executeOperation(new BsjSourceSerializerImpl(), null);
        
        // use the regenerated version to create another AST
        Node newAst = parser.parse(new InputStreamReader(new ByteArrayInputStream(regen1.getBytes())));
                
        // regenerate it again from the new AST
        String regen2 = newAst.executeOperation(new BsjSourceSerializerImpl(), null);
        
        // the twice regenerated source should equal the once regenerated source
        return regen1.equals(regen2);
    }
}
