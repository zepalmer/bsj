package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
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
        // TODO finish

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
        String methodName = method.getIdentifier().getIdentifier();
        tupleClassName =  Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1) + "ParamTuple";
        
        ClassMemberListNode members = factory.makeClassMemberListNode();
        
        // TODO finish (create tuple class for parameters)
        
        // make fields in the tuple for each parameter in the memoized method
        for (VariableNode param : method.getParameters())
        {
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
                factory.makeConstructorBodyNode(null, factory.makeBlockStatementListNode()), 
                factory.makeConstructorModifiersNode(AccessModifier.PUBLIC), 
                method.getParameters().deepCopy(factory), 
                null));
        
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
