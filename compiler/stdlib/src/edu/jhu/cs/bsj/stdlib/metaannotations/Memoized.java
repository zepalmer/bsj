package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JTable.PrintMode;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.MethodDeclUtils;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram adds memoization for a method.  
 * 
 * TODO finish
 * 
 * @author Joseph Riley
 */
public class Memoized extends AbstractBsjMetaAnnotationMetaprogram
{
    private String hashMapName;
    
    private String tupleClassName;    
    
    public Memoized()
    {
        super(Arrays.asList("memoized"), Collections.<String> emptyList());
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        MethodDeclarationNode method = MethodDeclUtils.getNearestMethodDeclaration(context, this);
        BsjNodeFactory factory = context.getFactory();
        
        // make sure we can memoize this method
        if (method.getParameters().isEmpty())
        {
            throw new MetaprogramExecutionFailureException("Memoized methods require parameters");
        }        
        else if (method.getReturnType() instanceof VoidTypeNode)
        {
            throw new MetaprogramExecutionFailureException("Memoized methods require return values");
        }
        
        // generate the tuple class that will store method parameters
        members.add(generateTupleClassDeclaration(method, factory));
        
        // generate the hash map that will stored previous results of the method
        members.add(generateHashMapDeclaration(method, factory));
        
        //TODO add memoization code to method body
    }

    private ClassDeclarationNode generateTupleClassDeclaration(
            MethodDeclarationNode method, BsjNodeFactory factory)
    {
        // TODO cleanup and use @@Property and @@GenerateEqualsAndHashCode
        
        String methodName = method.getIdentifier().getIdentifier();
        tupleClassName =  Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1) + "ParamTuple";
        ClassMemberListNode members = factory.makeClassMemberListNode();
        List<BlockStatementNode> constructorStatements = new ArrayList<BlockStatementNode>();
        List<BlockStatementNode> equalsStatements = new ArrayList<BlockStatementNode>();
        
        // if (this == o) return true;
        equalsStatements.add(factory.makeIfNode(factory.makeBinaryExpressionNode(factory.makeThisNode(),
                factory.makeFieldAccessByNameNode(factory.parseNameNode("o")), BinaryOperator.EQUAL),
                factory.makeReturnNode(factory.makeBooleanLiteralNode(true))));

        // if (obj == null) return false;
        equalsStatements.add(factory.makeIfNode(factory.makeBinaryExpressionNode(
                factory.makeFieldAccessByNameNode(factory.parseNameNode("o")), factory.makeNullLiteralNode(),
                BinaryOperator.EQUAL), factory.makeReturnNode(factory.makeBooleanLiteralNode(false))));

        // if (getClass() != obj.getClass()) return false;
        equalsStatements.add(factory.makeIfNode(factory.makeBinaryExpressionNode(
                factory.makeMethodInvocationByNameNode(factory.parseNameNode("getClass")),
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeFieldAccessByNameNode(factory.parseNameNode("o")),
                        factory.makeIdentifierNode("getClass")), BinaryOperator.NOT_EQUAL),
                factory.makeReturnNode(factory.makeBooleanLiteralNode(false))));
        
        // MyClass other = (MyClass) o;
        equalsStatements.add(factory.makeVariableDeclarationNode(factory.makeVariableDeclaratorListNode(factory.makeVariableDeclaratorNode(
                factory.makeUnparameterizedTypeNode(factory.parseNameNode(tupleClassName)),
                factory.makeIdentifierNode("other"),
                factory.makeTypeCastNode(
                        factory.makeFieldAccessByNameNode(factory.parseNameNode("o")),
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(tupleClassName)))))));
        
        // make fields in the tuple for each parameter in the memoized method
        for (VariableNode param : method.getParameters())
        {
            // build the constructor assignment statements as we go
            constructorStatements.add(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                    factory.makeFieldAccessByExpressionNode(
                            factory.makeThisNode(), param.getIdentifier().deepCopy(factory)), 
                    AssignmentOperator.ASSIGNMENT, 
                    factory.makeFieldAccessByNameNode(factory.parseNameNode(param.getIdentifier().getIdentifier())))));
            
            // build the equals method as we go
            equalsStatements.add(factory.makeIfNode(
                    factory.makeBinaryExpressionNode(factory.makeFieldAccessByExpressionNode(
                            factory.makeThisNode(), param.getIdentifier().deepCopy(factory)), factory.makeFieldAccessByExpressionNode(
                                    factory.makeFieldAccessByNameNode(factory.parseNameNode("other")), param.getIdentifier().deepCopy(factory)), BinaryOperator.NOT_EQUAL), 
                    factory.makeReturnNode(factory.makeBooleanLiteralNode(false))));
            
            //TODO how come adding @@Property doesn't work?
            MetaAnnotationNode metaAnnotation = factory.makeNormalMetaAnnotationNode(
                    factory.makeMetaAnnotationElementListNode(), 
                    factory.makeUnparameterizedTypeNode(factory.parseNameNode("Property")));
            
            members.add(factory.makeFieldDeclarationNode(
                    factory.makeFieldModifiersNode(AccessModifier.PRIVATE, false, false, false, false, factory.makeMetaAnnotationListNode(metaAnnotation), factory.makeAnnotationListNode()), 
                    factory.makeVariableDeclaratorListNode(
                            factory.makeVariableDeclaratorNode(
                                    param.getType().deepCopy(factory), 
                                    param.getIdentifier().deepCopy(factory), 
                                    null)), 
                    null));
        }
        
        // create the constructor for the tuple
        members.add(factory.makeConstructorDeclarationNode(
                factory.makeIdentifierNode(tupleClassName), 
                factory.makeConstructorBodyNode(null, factory.makeBlockStatementListNode(constructorStatements)), 
                factory.makeConstructorModifiersNode(AccessModifier.PUBLIC), 
                method.getParameters().deepCopy(factory), 
                null));
        
        // create a basic equals() for the tuple
        equalsStatements.add(factory.makeReturnNode(factory.makeBooleanLiteralNode(true)));
        members.add(factory.makeMethodDeclarationNode(
                factory.makeBlockNode(factory.makeBlockStatementListNode(equalsStatements)), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("equals"), 
                factory.makeVariableListNode(factory.makeVariableNode(
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode("java.lang.Object")),
                        factory.makeIdentifierNode("o"))), 
                factory.makePrimitiveTypeNode(PrimitiveType.BOOLEAN), 
                null));
        
        // return the entire class declaration
        return factory.makeClassDeclarationNode(
                factory.makeClassModifiersNode(AccessModifier.PRIVATE),
                null, 
                factory.makeDeclaredTypeListNode(), 
                factory.makeClassBodyNode(members), 
                factory.makeTypeParameterListNode(), 
                factory.makeIdentifierNode(tupleClassName), 
                factory.makeJavadocNode("Tuple class for storing memoized method parameters."));
    }

    private FieldDeclarationNode generateHashMapDeclaration(
            MethodDeclarationNode method, BsjNodeFactory factory)
    {        
        hashMapName = method.getIdentifier().getIdentifier() + "MemoizedMap";
        
        ReferenceTypeNode returnType = TypeDeclUtils.autoBoxPrimitives(method.getReturnType(), factory);        
        ReferenceTypeNode paramType = TypeDeclUtils.autoBoxPrimitives(method.getParameters().getFirst().getType(), factory);

       // private Map<paramType, returnType> ~:hashMapName:~ = new HashMap<paramType, returnType>();
       return factory.makeFieldDeclarationNode(
                factory.makeFieldModifiersNode(AccessModifier.PRIVATE), 
                factory.makeVariableDeclaratorListNode(
                        factory.makeVariableDeclaratorNode(
                                factory.makeParameterizedTypeNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.parseNameNode("java.util.Map")), 
                                        factory.makeTypeArgumentListNode(paramType, returnType)), 
                                factory.makeIdentifierNode(hashMapName), 
                                factory.makeUnqualifiedClassInstantiationNode(
                                        factory.makeParameterizedTypeNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.parseNameNode("java.util.HashMap")), 
                                                        factory.makeTypeArgumentListNode(paramType.deepCopy(factory), returnType.deepCopy(factory)))))),
                factory.makeJavadocNode("Map of previous results of method " + method.getIdentifier().getIdentifier() + "."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}
