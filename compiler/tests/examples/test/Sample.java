package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;


public class Sample
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
        // read the java file in
        FileInputStream input = new FileInputStream(file);        

        // parse it to an AST
        BsjParserImpl parser = new BsjParserImpl(new BsjNodeFactoryImpl());
        Node ast = parser.parse(input);

        // regenerate it once
        String regen1 = ast.executeOperation(new BsjSourceSerializerImpl(), null);
        
        // use the regenerated version to create another AST
        Node newAst = parser.parse(new ByteArrayInputStream(regen1.getBytes()));
                
        // regenerate it again from the new AST
        String regen2 = newAst.executeOperation(new BsjSourceSerializerImpl(), null);
        
        // the twice regenerated source should equal the once regenerated source
        return regen1.equals(regen2);
    }
}