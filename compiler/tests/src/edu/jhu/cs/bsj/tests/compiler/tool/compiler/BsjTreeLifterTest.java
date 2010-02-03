package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.IntLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReturnNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
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
        BsjParserImpl parser = new BsjParserImpl(new BsjNodeFactoryImpl());
        
        String baseCode = 
                "public class BaseClass " + 
                "{" + 
                    "public int foo()" + 
                    "{return 666;}" + 
                "}";
        
        Node ast = null;
        try
        {
            ast = parser.parse(new InputStreamReader(new ByteArrayInputStream(baseCode.getBytes())));
        } catch (Exception e)
        {
            e.printStackTrace();
            fail(e.getMessage());
        }
        
        List<BlockStatementNode>list = new ArrayList<BlockStatementNode>();
        
        ExpressionNode metaFactory = factory.makeFieldAccessByNameNode(factory.makeSimpleNameNode(factory.makeIdentifierNode("factory"), NameCategory.TYPE));
        
        String varName = ast.executeOperation(treeLifter, new Pair<ExpressionNode, List<BlockStatementNode>>(metaFactory, list));
        System.out.println(varName);
        
        Node block = factory.makeBlockNode(factory.makeListNode(list));        
        String regen2 = block.executeOperation(new BsjSourceSerializerImpl(), null);
        System.out.println(regen2);

        //=============================================REMOVE
		List<ImportNode> v0 = new ArrayList<ImportNode>();
		ListNode<ImportNode> v1 = (factory).makeListNode(v0);
		List<TypeDeclarationNode> v2 = new ArrayList<TypeDeclarationNode>();
		List<AnnotationNode> v3 = new ArrayList<AnnotationNode>();
		ListNode<AnnotationNode> v4 = (factory).makeListNode(v3);
		ClassModifiersNode v5 = (factory).makeClassModifiersNode(
				AccessModifier.PUBLIC, false, false, false, false, v4);
		List<TypeNode> v6 = new ArrayList<TypeNode>();
		ListNode<TypeNode> v7 = (factory).makeListNode(v6);
		List<ClassMemberNode> v8 = new ArrayList<ClassMemberNode>();
		List<BlockStatementNode> v9 = new ArrayList<BlockStatementNode>();
		IntLiteralNode v10 = (factory).makeIntLiteralNode(666);
		ReturnNode v11 = (factory).makeReturnNode(v10);
		v9.add(v11);
		ListNode<BlockStatementNode> v12 = (factory).makeListNode(v9);
		BlockNode v13 = (factory).makeBlockNode(v12);
		List<AnnotationNode> v14 = new ArrayList<AnnotationNode>();
		ListNode<AnnotationNode> v15 = (factory).makeListNode(v14);
		MethodModifiersNode v16 = (factory).makeMethodModifiersNode(
				AccessModifier.PUBLIC, false, false, false, false, false,
				false, v15);
		IdentifierNode v17 = (factory).makeIdentifierNode("foo");
		List<VariableNode> v18 = new ArrayList<VariableNode>();
		ListNode<VariableNode> v19 = (factory).makeListNode(v18);
		PrimitiveTypeNode v20 = (factory)
				.makePrimitiveTypeNode(PrimitiveType.INT);
		List<UnparameterizedTypeNode> v21 = new ArrayList<UnparameterizedTypeNode>();
		ListNode<UnparameterizedTypeNode> v22 = (factory).makeListNode(v21);
		List<TypeParameterNode> v23 = new ArrayList<TypeParameterNode>();
		ListNode<TypeParameterNode> v24 = (factory).makeListNode(v23);
		MethodDeclarationNode v25 = (factory).makeMethodDeclarationNode(v13,
				v16, v17, v19, null, v20, v22, v24, null);
		v8.add(v25);
		ListNode<ClassMemberNode> v26 = (factory).makeListNode(v8);
		ClassBodyNode v27 = (factory).makeClassBodyNode(v26);
		List<TypeParameterNode> v28 = new ArrayList<TypeParameterNode>();
		ListNode<TypeParameterNode> v29 = (factory).makeListNode(v28);
		IdentifierNode v30 = (factory).makeIdentifierNode("BaseClass");
		ClassDeclarationNode v31 = (factory).makeClassDeclarationNode(v5, null,
				v7, v27, v29, v30, null);
		v2.add(v31);
		ListNode<TypeDeclarationNode> v32 = (factory).makeListNode(v2);
		CompilationUnitNode v33 = (factory).makeCompilationUnitNode(null, v1,
				v32);
		String blah = v33.executeOperation(new BsjSourceSerializerImpl(), null);
		System.out.println("===============================================");
        System.out.println(blah);
        //=============================================REMOVE
		
	}
    
    /**
     * Compiles and runs a block of code which generates a lifted AST.
     * @param varName
     * @param code
     * @return the lifted AST.
     */
    public CompilationUnitNode compileMeta(String varName, BlockNode code)
    {
        String wrapperCode = 
            "public class BaseClass " + 
            "{" + 
                "public int foo()" + 
                "{return 666;}" + 
            "}";
        
    	return null;
    }
    
    
    
    
    
    
    
    
    
    
}
