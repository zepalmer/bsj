package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;

public class BsjLiftedCodeVisitor extends BsjTypedNodeNoOpVisitor
{
    private List<MethodDeclarationNode> methods; 
    private int methodId;
    private BsjNodeFactory factory;
    
    public BsjLiftedCodeVisitor(List<MethodDeclarationNode> methods)
    {
        this.methods = methods;
        methodId = 0;
        factory = new BsjNodeFactoryImpl();
    }

    /**
     * @return the methods
     */
    public List<MethodDeclarationNode> getMethods()
    {
        return methods;
    }

    /**
     * @param methods the methods to set
     */
    public void setMethods(List<MethodDeclarationNode> methods)
    {
        this.methods = methods;
    }

    /**
     * Starts a visit for nodes of type MethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationNodeStart(MethodInvocationNode node)
    {
        
    }
    
    /**
     * Stops a visit for nodes of type MethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationNodeStop(MethodInvocationNode node)
    {
        List<ExpressionNode> newArgList = new ArrayList<ExpressionNode>();
        
        for (ExpressionNode argExpr : node.getArguments().getChildren())
        {
            MethodDeclarationNode newMethod = factory.makeMethodDeclarationNode(
                    factory.makeBlockNode(factory.makeBlockStatementListNode(factory.makeReturnNode(argExpr))), 
                    factory.makeMethodModifiersNode(
                            AccessModifier.PUBLIC, false, true, false, false, 
                            false, false, factory.makeAnnotationListNode()), 
                    factory.makeIdentifierNode("method" + methodId++), 
                    factory.makeVariableListNode(), 
                    factory.makeUnparameterizedTypeNode(
                            factory.makeSimpleNameNode(
                                    factory.makeIdentifierNode("ExpressionNode"), NameCategory.TYPE)), 
                    null);

            //TODO
//            newArgList.add(
//                    factory.makeMethodInvocationByNameNode(
//                            name, 
//                            arguments, 
//                            typeArguments));
            
            methods.add(newMethod);
        }        

        
        ExpressionListNode newArguments = factory.makeExpressionListNode(newArgList);
        node.setArguments(newArguments);
    }
}
