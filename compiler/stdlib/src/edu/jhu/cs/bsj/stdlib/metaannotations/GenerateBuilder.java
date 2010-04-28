package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram adds the Builder Pattern to a class.
 * 
 * TODO
 * 
 * @author Joseph Riley
 */
public class GenerateBuilder extends AbstractBsjMetaAnnotationMetaprogram
{
    private String builderName = "Builder";

    private String className;
    
    public GenerateBuilder()
    {
        super(
                Arrays.asList("builder"), 
                Collections.<String> emptyList(), 
                Arrays.asList("property"), 
                MetaprogramLocalMode.MUTATE,
                MetaprogramPackageMode.READ_ONLY);
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        BsjNodeFactory factory = context.getFactory();
        className = TypeDeclUtils.getEnclosingTypeName(context, this).getIdentifier();
        
        // find all the variables in this class
        List<VariableDeclaratorNode> variables = new ArrayList<VariableDeclaratorNode>();
        for (ClassMemberNode member : members)
        {
            if (member instanceof FieldDeclarationNode)
            {
                FieldDeclarationNode field = (FieldDeclarationNode)member;
                variables.addAll(field.getDeclarators());
            }
        }
        
        if (variables.isEmpty())
        {
            throw new MetaprogramExecutionFailureException("Builder classes require properties");
        }
        
        //TODO handle @@Property(s) by filtering variables
        
        // add private static Builder class
        members.add(generateBuilderClass(variables, factory));
        
        // add private constructor which takes a Builder as its only argument
        members.add(generateBuilderConstructor(variables, factory));
    }

    private ConstructorDeclarationNode generateBuilderConstructor(List<VariableDeclaratorNode> variables, BsjNodeFactory factory)
    {        
        // assign class fields from the builder's fields
        List<BlockStatementNode> statements = new ArrayList<BlockStatementNode>();
        for (VariableDeclaratorNode variable : variables)
        {
            statements.add(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                    factory.makeFieldAccessByNameNode(factory.parseNameNode(variable.getName().getIdentifier())), 
                    AssignmentOperator.ASSIGNMENT, 
                    factory.makeFieldAccessByExpressionNode(
                            factory.makeFieldAccessByNameNode(factory.parseNameNode("builder")), 
                            variable.getName().deepCopy(factory)))));
        }
        
        // create the private builder constructor
        return factory.makeConstructorDeclarationNode(
                factory.makeIdentifierNode(className), 
                factory.makeConstructorBodyNode(null, 
                        factory.makeBlockStatementListNode(statements)), 
                factory.makeConstructorModifiersNode(AccessModifier.PRIVATE), 
                factory.makeVariableListNode(
                        factory.makeVariableNode(factory.makeUnparameterizedTypeNode(
                                factory.parseNameNode(builderName)), factory.makeIdentifierNode("builder"))), 
                factory.makeJavadocNode("Constructor using Builder class.\n@param builder the builder to use in construction."));
    }

    private ClassDeclarationNode generateBuilderClass(List<VariableDeclaratorNode> variables, BsjNodeFactory factory)
    {
        List<ClassMemberNode> builderMembers = new ArrayList<ClassMemberNode>();
        
        for (VariableDeclaratorNode variable : variables)
        {
            builderMembers.add(factory.makeFieldDeclarationNode(
                    factory.makeFieldModifiersNode(AccessModifier.PRIVATE), 
                    factory.makeVariableDeclaratorListNode(variable.deepCopy(factory)), 
                    null));
            
            if (variable.getInitializer() == null)
            {
                //TODO required variable, add to constructor
            }
            else
            {
                // optional variable, add building method for it
                builderMembers.add(factory.makeMethodDeclarationNode(
                        factory.makeBlockNode(factory.makeBlockStatementListNode(
                                factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                                        factory.makeFieldAccessByNameNode(factory.parseNameNode(variable.getName().getIdentifier())), 
                                        AssignmentOperator.ASSIGNMENT, 
                                        factory.makeFieldAccessByNameNode(factory.parseNameNode("val")))), 
                                factory.makeReturnNode(factory.makeThisNode()))), 
                        factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                        variable.getName().deepCopy(factory), 
                        factory.makeVariableListNode(factory.makeVariableNode(variable.getType().deepCopy(factory), factory.makeIdentifierNode("val"))), 
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(builderName)), 
                        factory.makeJavadocNode("Builder parameter for " + variable.getName().getIdentifier() + ".")));
            }
        }
        
        //TODO constructor
        
        //TODO build method
        
        return factory.makeClassDeclarationNode(
                factory.makeClassModifiersNode(
                        AccessModifier.PUBLIC, false, true, false, false, 
                        factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode()), 
                null, 
                factory.makeDeclaredTypeListNode(), 
                factory.makeClassBodyNode(factory.makeClassMemberListNode(builderMembers)), 
                factory.makeTypeParameterListNode(), 
                factory.makeIdentifierNode(builderName), 
                factory.makeJavadocNode("Builder class."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}
