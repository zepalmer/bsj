package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
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
        
        // generate the hash map that will stored previous results of the method
        members.add(generateHashMapDeclaration(method, factory));
        
        //TODO add memoization code to method body
    }

    private FieldDeclarationNode generateHashMapDeclaration(
            MethodDeclarationNode method, BsjNodeFactory factory)
    {
        // TODO finish (create tuple class for parameters)
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
