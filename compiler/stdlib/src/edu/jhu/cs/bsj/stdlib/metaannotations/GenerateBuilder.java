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
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.metaannotations.utils.Utility;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram adds the Builder Pattern to a class by scanning the field
 * declarations on the class and adding them all into an inner Builder class.  Fields without
 * initializers are assumed to be required, and those with initializers are assumed to be
 * optional.  If properties is available, then only fields named in properties will be used.
 * 
 * @author Joseph Riley
 */
public class GenerateBuilder extends AbstractBsjMetaAnnotationMetaprogram
{
    /** The explicitly-specified list of properties. */
    private String[] properties = null;
    
    /** The name of the inner Builder class. */
    private String builderName = "Builder";

    /** The name of the class for which a builder is being created. */
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
    
    @BsjMetaAnnotationElementGetter
    public String[] getProperties()
    {
        return this.properties;
    }

    @BsjMetaAnnotationElementSetter
    public void setProperties(String[] properties)
    {
        this.properties = properties;
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        BsjNodeFactory factory = context.getFactory();
        className = TypeDeclUtils.getEnclosingTypeName(context, this).getIdentifier();
        
        // all the variables in this class that we want to use 
        List<VariableDeclaratorNode> variables = new ArrayList<VariableDeclaratorNode>();
        
        // if properties wasn't specified, just use all fields
        List<FieldDeclarationNode> fieldDeclarations = Utility.filterByClass(members.getChildren(), FieldDeclarationNode.class);
        if (properties == null)
        {
        	for (FieldDeclarationNode field : fieldDeclarations) {
                variables.addAll(field.getDeclarators());
        	}
        }
        // otherwise, only use fields specifically noted in properties
        else
        {
            List<String> propsList = Arrays.asList(properties);
        	for (FieldDeclarationNode field : fieldDeclarations) {
        		 for (VariableDeclaratorNode var : field.getDeclarators())
                 {
                     if (propsList.contains(var.getIdentifier().getIdentifier()))
                     {
                         variables.add(var);
                     }
                 }
        	}
            
//            for (ClassMemberNode member : members)
//            {
//                if (member instanceof FieldDeclarationNode)
//                {
//                    FieldDeclarationNode field = (FieldDeclarationNode)member;
                   
//            }
        }
        
        // sanity check
        if (variables.isEmpty())
        {
            throw new MetaprogramExecutionFailureException("Builder classes require properties");
        }
                
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
                    factory.makeVariableAccessByNameNode(factory.parseNameNode(variable.getIdentifier().getIdentifier())), 
                    AssignmentOperator.ASSIGNMENT, 
                    factory.makeVariableAccessByExpressionNode(
                            factory.makeVariableAccessByNameNode(factory.parseNameNode("builder")), 
                            variable.getIdentifier().deepCopy(factory)))));
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
        BlockStatementListNode constructorStatements = factory.makeBlockStatementListNode();
        List<VariableNode> constructorVariables = new ArrayList<VariableNode>();
        StringBuilder javadoc = new StringBuilder();
        
        for (VariableDeclaratorNode variable : variables)
        {
            builderMembers.add(factory.makeFieldDeclarationNode(
                    factory.makeFieldModifiersNode(AccessModifier.PRIVATE),
                    variable.getEffectiveType(factory),
                    factory.makeVariableDeclaratorListNode(variable.deepCopy(factory)), 
                    null));
            
            if (variable.getInitializer() == null)
            {
                // required variable, add to constructor
                constructorVariables.add(factory.makeVariableNode(
                        variable.getEffectiveType(factory), 
                        variable.getIdentifier().deepCopy(factory)));
                javadoc.append("@param " + variable.getIdentifier().getIdentifier());
                constructorStatements.add(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                        factory.makeVariableAccessByExpressionNode(factory.makeThisNode(), variable.getIdentifier().deepCopy(factory)), 
                        AssignmentOperator.ASSIGNMENT, 
                        factory.makeVariableAccessByNameNode(factory.parseNameNode(variable.getIdentifier().getIdentifier())))));
            }
            else
            {
                // optional variable, add building method for it
                builderMembers.add(factory.makeMethodDeclarationNode(
                        factory.makeBlockStatementListNode(
                                factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                                        factory.makeVariableAccessByNameNode(factory.parseNameNode(variable.getIdentifier().getIdentifier())), 
                                        AssignmentOperator.ASSIGNMENT, 
                                        factory.makeVariableAccessByNameNode(factory.parseNameNode("val")))), 
                                factory.makeReturnNode(factory.makeThisNode())), 
                        factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                        variable.getIdentifier().deepCopy(factory), 
                        factory.makeVariableListNode(factory.makeVariableNode(variable.getEffectiveType(factory), factory.makeIdentifierNode("val"))), 
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(builderName)), 
                        factory.makeJavadocNode("Builder parameter for " + variable.getIdentifier().getIdentifier() + ".")));
            }
        }
        
        // public Builder (~:params:~) {...}
        builderMembers.add(factory.makeConstructorDeclarationNode(
                factory.makeIdentifierNode(builderName), 
                factory.makeConstructorBodyNode(null, constructorStatements), 
                factory.makeConstructorModifiersNode(AccessModifier.PUBLIC), 
                factory.makeVariableListNode(constructorVariables), 
                factory.makeJavadocNode("Builder constructor for required fields.\n" + javadoc.toString())));
        
        // public ~:className:~ build() {return new ~:className:~(this);}
        builderMembers.add(factory.makeMethodDeclarationNode(
                factory.makeBlockStatementListNode(
                        factory.makeReturnNode(factory.makeUnqualifiedClassInstantiationNode(
                                factory.makeUnparameterizedTypeNode(factory.parseNameNode(className)), 
                                factory.makeExpressionListNode(factory.makeThisNode())))), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("build"), 
                factory.makeVariableListNode(), 
                factory.makeUnparameterizedTypeNode(factory.parseNameNode(className)), 
                factory.makeJavadocNode("Builds the instance of the enclosing class.\n@return the built class.")));
        
        // put it all together
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
