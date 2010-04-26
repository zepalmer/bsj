package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
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
    
    private String tupleInstanceName;
    
    private String newMethodName;
    
    public Memoized()
    {
        super(
                Arrays.asList("memoized"), 
                Collections.<String> emptyList(), 
                Collections.<String> emptyList(), 
                MetaprogramLocalMode.MUTATE,
                MetaprogramPackageMode.READ_ONLY);
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
        
        // create a new method to hold the contents of the original method, which will become a wrapper
        members.add(generateNewMethod(method, factory));
        
        // generate the tuple class that will store method parameters
        members.add(generateTupleClassDeclaration(method, factory));
        
        // generate the hash map that will stored previous results of the method
        members.add(generateHashMapDeclaration(method, factory));
        
        // add memoization code to method body
        addMemoizationCode(method, factory);
    }

    private MethodDeclarationNode generateNewMethod(MethodDeclarationNode method, BsjNodeFactory factory)
    {
        newMethodName = method.getIdentifier().getIdentifier() + "Original";
        MethodModifiersNode modifiers = method.getModifiers().deepCopy(factory);
        modifiers.setAccess(AccessModifier.PRIVATE);
        modifiers.setMetaAnnotations(factory.makeMetaAnnotationListNode());
        return factory.makeMethodDeclarationNode(
                method.getBody().deepCopy(factory), 
                modifiers, 
                factory.makeIdentifierNode(newMethodName), 
                method.getParameters().deepCopy(factory), 
                method.getReturnType().deepCopy(factory), 
                method.getJavadoc() == null ? null : method.getJavadoc().deepCopy(factory));
    }

    private void addMemoizationCode(MethodDeclarationNode method, BsjNodeFactory factory)
    {
        BlockStatementListNode statements = method.getBody().getStatements();
        statements.clear();
        ExpressionListNode arguments = factory.makeExpressionListNode();
        tupleInstanceName = Character.toLowerCase(tupleClassName.charAt(0)) + tupleClassName.substring(1) + "Instance";
        
        // use parameters for arguments in tuple constructor
        for (VariableNode variable : method.getParameters())
        {
            arguments.add(factory.makeFieldAccessByNameNode(
                    factory.parseNameNode(variable.getIdentifier().getIdentifier())));
        }

        // FooParamTuple fooParamTupleInstance = new FooParamTuple(~:arguments:~);
        statements.add(factory.makeVariableDeclarationNode(
                factory.makeVariableDeclaratorListNode(
                        factory.makeVariableDeclaratorNode(
                                factory.makeUnparameterizedTypeNode(factory.parseNameNode(tupleClassName)), 
                                factory.makeIdentifierNode(tupleInstanceName), 
                                factory.makeUnqualifiedClassInstantiationNode(
                                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(tupleClassName)), 
                                        arguments.deepCopy(factory))))));
        
        // if (!hashMap.containsKey(fooParamTupleInstance)) {hashMap.put(fooParamTupleInstance, originalMethod(~:arguments:~));}
        statements.add(factory.makeIfNode(factory.makeUnaryExpressionNode(
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeFieldAccessByNameNode(factory.parseNameNode(hashMapName)), 
                        factory.makeIdentifierNode("containsKey"), 
                        factory.makeExpressionListNode(factory.makeFieldAccessByNameNode(factory.parseNameNode(tupleInstanceName)))), UnaryOperator.LOGICAL_COMPLEMENT), 
                factory.makeExpressionStatementNode(factory.makeMethodInvocationByExpressionNode(
                        factory.makeFieldAccessByNameNode(factory.parseNameNode(hashMapName)), 
                        factory.makeIdentifierNode("put"), 
                        factory.makeExpressionListNode(
                                factory.makeFieldAccessByNameNode(factory.parseNameNode(tupleInstanceName)),
                                factory.makeMethodInvocationByNameNode(
                                        factory.parseNameNode(newMethodName), 
                                        arguments.deepCopy(factory)))))));
        
        // return hashMap.get(fooParamTupleInstance);
        statements.add(factory.makeReturnNode(
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeFieldAccessByNameNode(factory.parseNameNode(hashMapName)), 
                        factory.makeIdentifierNode("get"), 
                        factory.makeExpressionListNode(factory.makeFieldAccessByNameNode(factory.parseNameNode(tupleInstanceName))))));
    }

    private ClassDeclarationNode generateTupleClassDeclaration(
            MethodDeclarationNode method, BsjNodeFactory factory)
    {
        String methodName = method.getIdentifier().getIdentifier();
        tupleClassName = Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1) + "ParamTuple";
        ClassMemberListNode members = factory.makeClassMemberListNode();
        
        // make fields in the tuple for each parameter in the memoized method
        for (VariableNode param : method.getParameters())
        {
            // adding @@Property to this field
            MetaAnnotationNode metaAnnotation = factory.makeNormalMetaAnnotationNode(
                    factory.makeMetaAnnotationElementListNode(), 
                    factory.makeUnparameterizedTypeNode(factory.parseNameNode("Property")));
            
            // add the actual field
            members.add(factory.makeFieldDeclarationNode(
                    factory.makeFieldModifiersNode(
                            AccessModifier.PRIVATE, false, false, false, false, 
                            factory.makeMetaAnnotationListNode(metaAnnotation), 
                            factory.makeAnnotationListNode()), 
                    factory.makeVariableDeclaratorListNode(
                            factory.makeVariableDeclaratorNode(
                                    param.getType().deepCopy(factory), 
                                    param.getIdentifier().deepCopy(factory), 
                                    null)), 
                    null));
        }
        
        // add @@GenerateConstructorFromProperties and @@GenerateEqualsAndHashCode
        List<MetaAnnotationNode> tupleMetaAnnotations = new ArrayList<MetaAnnotationNode>();
        tupleMetaAnnotations.add(factory.makeNormalMetaAnnotationNode(
                    factory.makeMetaAnnotationElementListNode(), 
                    factory.makeUnparameterizedTypeNode(factory.parseNameNode("GenerateConstructorFromProperties"))));
        tupleMetaAnnotations.add(factory.makeNormalMetaAnnotationNode(
                factory.makeMetaAnnotationElementListNode(), 
                factory.makeUnparameterizedTypeNode(factory.parseNameNode("GenerateEqualsAndHashCode"))));
        
        // return the entire class declaration
        return factory.makeClassDeclarationNode(
                factory.makeClassModifiersNode(
                        AccessModifier.PRIVATE, false, false, false, false, 
                        factory.makeMetaAnnotationListNode(tupleMetaAnnotations), 
                        factory.makeAnnotationListNode()),
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
        ReferenceTypeNode paramType = factory.makeUnparameterizedTypeNode(factory.parseNameNode(tupleClassName));

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
