package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.GetterFilter;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram creates a constructor for a class from its properties.  
 * 
 * TODO finish
 * 
 * @author Joseph Riley
 */
public class GenerateConstructorFromProperties extends
        AbstractBsjMetaAnnotationMetaprogram
{
    public GenerateConstructorFromProperties()
    {
        super(Arrays.asList("constructorFromProperties"), Arrays.asList("property"));
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        BsjNodeFactory factory = context.getFactory();  
        
        // extract field names and types
        List<Pair<String, TypeNode>> fieldDescriptions = new ArrayList<Pair<String, TypeNode>>();
        for (ClassMemberNode member : members.filter(new GetterFilter()))
        {
            MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
            String fieldName = methodDecl.getIdentifier().getIdentifier().substring(3);
            fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
            fieldDescriptions.add(new Pair<String, TypeNode>(fieldName, methodDecl.getReturnType()));
        }
        
        String className = TypeDeclUtils.getEnclosingTypeName(context, this).getIdentifier();
        members.add(generateConstructor(className, fieldDescriptions, factory));
    }

    private ClassMemberNode generateConstructor(String className,
            List<Pair<String, TypeNode>> fieldDescriptions,
            BsjNodeFactory factory)
    {
    	// TODO: superclass properties via constructor arguments?
        StringBuilder javadoc = new StringBuilder("Constructor.\n");        
        List<BlockStatementNode> constructorStatements = new ArrayList<BlockStatementNode>();
        VariableListNode parameters = factory.makeVariableListNode();
        
        for (Pair<String, TypeNode> field : fieldDescriptions)
        {
            String fieldName = field.getFirst();
            TypeNode fieldType = field.getSecond();
            
            // build the list of constructor parameters
            parameters.add(factory.makeVariableNode(
                    fieldType.deepCopy(factory), factory.makeIdentifierNode(fieldName)));
            
            // initialize the parameters
            constructorStatements.add(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                    factory.makeFieldAccessByExpressionNode(
                            factory.makeThisNode(), factory.makeIdentifierNode(fieldName)), 
                    AssignmentOperator.ASSIGNMENT, 
                    factory.makeFieldAccessByNameNode(factory.parseNameNode(fieldName)))));

            // add the parameters to the javadoc
            javadoc.append("@param " + fieldName + " the value for " + fieldName + ".\n");
        }
        
        return factory.makeConstructorDeclarationNode(
                factory.makeIdentifierNode(className), 
                factory.makeConstructorBodyNode(null, factory.makeBlockStatementListNode(constructorStatements)), 
                factory.makeConstructorModifiersNode(AccessModifier.PUBLIC), 
                parameters, 
                factory.makeJavadocNode(javadoc.toString()));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}