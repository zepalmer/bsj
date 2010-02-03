package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.BsjTreeLifter;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParserImpl;


public class BsjTreeLifterTest
{
    //TODO
    //1. get AST nodes
    //2. pass nodes into lifter
    //3. make lifted stuff into source
    //4. compile
    //5. verify output is the same as original
    
    @Test
    public void testMetaGeneration()
    {
        BsjNodeFactory factory = new BsjNodeFactoryImpl();
        BsjTreeLifter treeLifter = new BsjTreeLifter(factory);       
        
        String baseCode = 
                "public class BaseClass " + 
                "{" + 
                    "public void foo()" + 
                    "{int x;}" + 
                "}";

        BsjParserImpl parser = new BsjParserImpl(new BsjNodeFactoryImpl());
        Node ast = null;
        try
        {
            ast = parser.parse(new InputStreamReader(new ByteArrayInputStream(baseCode.getBytes())));
        } catch (Exception e)
        {
            e.printStackTrace();
            fail(e.getMessage());
        }
        
        Node metaNode = factory.makeContinueNode(factory.makeIdentifierNode("testing"));
        List<BlockStatementNode>list = new ArrayList<BlockStatementNode>();
        
        ExpressionNode metaFactory = factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode("factory"), NameCategory.TYPE));
        ast.executeOperation(treeLifter, new Pair<ExpressionNode, List<BlockStatementNode>>(metaFactory, list));
        
        Node block = factory.makeBlockNode(factory.makeListNode(list));
        
        String regen2 = block.executeOperation(new BsjSourceSerializerImpl(), null);
        System.out.println(regen2);

    }
}
