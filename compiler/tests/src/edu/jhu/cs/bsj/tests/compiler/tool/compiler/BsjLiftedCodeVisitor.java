package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationByExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;

public class BsjLiftedCodeVisitor extends BsjTypedNodeNoOpVisitor
{
    private List<MethodDeclarationNode> methods; 
    private int methodId;
    private BsjNodeFactory factory;
    
    public BsjLiftedCodeVisitor(List<MethodDeclarationNode> methods, BsjNodeFactory factory)
    {
        this.methods = methods;
        this.methodId = 0;
        this.factory = factory; 
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
     * Counts the number of nodes beneath a node.
     */
    public class CountingVisitor implements BsjNodeVisitor
    {
    	private int count;
    	
		public CountingVisitor(int count)
		{
			this.count = count;
		}

		public int getCount()
		{
			return count;
		}

		public void setCount(int count)
		{
			this.count = count;
		}

		@Override
        public void visitStop(Node node)
        {
        }
        
        @Override
        public void visitStart(Node node)
        {
            count++;
        }
    }
    
    /**
     * Stops a visit for nodes of type MethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationNodeStop(MethodInvocationNode node)
    {
        List<ExpressionNode> newArgList = new ArrayList<ExpressionNode>();

        CountingVisitor countingVisitor = new CountingVisitor(0);
        node.receive(countingVisitor);
        
        if (countingVisitor.getCount() < 4000)
        {
        	return;
        }
        
        for (ExpressionNode argExpr : node.getArguments().getChildren())
        {
        	TypeNode returnType;
        	
        	//TODO clean this up
        	if (argExpr instanceof UnqualifiedClassInstantiationNode)
        	{
        	    returnType = ((UnqualifiedClassInstantiationNode)argExpr).getType().deepCopy(factory);
        	}
        	else if (argExpr instanceof MethodInvocationByExpressionNode)
            {
        	    String retName = ((MethodInvocationByExpressionNode)argExpr).getIdentifier().getIdentifier();
        	    if (retName.endsWith("asList"))
        	    {
                    newArgList.add(argExpr.deepCopy(factory));
                    continue;
        	    }
        	    else
                {
                    retName = retName.substring(4);
                    returnType = factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(factory
                            .makeIdentifierNode(retName), NameCategory.TYPE));
                }
            }
            else if (argExpr instanceof MethodInvocationByNameNode)
            {
                String retName = ((MethodInvocationByNameNode)argExpr).getName().getNameString();
                if (retName.endsWith("asList"))
                {
                    newArgList.add(argExpr.deepCopy(factory));
                    continue;
                }
                else
                {
                    retName = retName.substring(4);
                    returnType = factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(factory
                            .makeIdentifierNode(retName), NameCategory.TYPE));
                }
            }
        	else if (argExpr instanceof LiteralNode<?> || argExpr instanceof FieldAccessNode)
        	{
        	    // skip over the nodes we won't know how to handle
        	    newArgList.add(argExpr.deepCopy(factory));
        	    continue;
        	}
        	else
        	{
        	    throw new IllegalStateException("Unexpected class: " + argExpr.getClass().getName());
        	}
        	
        	// build a new method name
        	String methodName = "method" + methodId++;
        	
        	// build the new method declaration and add it to the list
            MethodDeclarationNode newMethod = factory.makeMethodDeclarationNode(
                    factory.makeBlockNode(
                    		factory.makeBlockStatementListNode(
                    				factory.makeReturnNode(argExpr.deepCopy(factory)))), 
                    factory.makeMethodModifiersNode(
                            AccessModifier.PUBLIC, false, false, false, false, 
                            false, false, factory.makeMetaAnnotationListNode(),
                            factory.makeAnnotationListNode()), 
                    factory.makeIdentifierNode(methodName), 
                    factory.makeVariableListNode(), 
                    returnType, 
                    null);            
            methods.add(newMethod);
            
            // add a call to the new method to the new argument list
            newArgList.add(
                    factory.makeMethodInvocationByNameNode(
                            factory.makeSimpleNameNode(
                            		factory.makeIdentifierNode(methodName), NameCategory.METHOD), 
                            factory.makeExpressionListNode(), 
                            factory.makeReferenceTypeListNode()));
        }        

        // replace the node's arguments with method calls
        ExpressionListNode newArguments = factory.makeExpressionListNode(newArgList);
        node.setArguments(newArguments);
    }
}
