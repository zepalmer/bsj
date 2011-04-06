package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram makes a class into a Singleton.  The static method
 * getInstance() is added for access to the single instance of the class.
 * 
 * @author Joseph Riley
 */
public class MakeSingleton extends AbstractBsjMetaprogramMetaAnnotation
{
    private final String singletonName = "INSTANCE";
    
    public MakeSingleton()
    {
        super(Arrays.asList("singleton"), Collections.<String> emptyList());
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context)
    {
        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        
        // get the name of this class
        String className = TypeDeclUtils.getEnclosingTypeName(context, this).getIdentifier();
        
        BsjNodeFactory factory = context.getFactory();   
        
        // private static final Singleton INSTANCE = new Singleton();
        members.add(generateSingletonField(className, factory));
        
        // TODO check for prior existence
        members.add(generatePrivateConstructor(className, factory));
        
        // public static Singleton getInstance() {return INSTANCE;}
        members.add(generateSingletonGetter(className, factory));
    }

    private MethodDeclarationNode generateSingletonGetter(String className,
            BsjNodeFactory factory)
    {
        return factory.makeMethodDeclarationNode(
                factory.makeBlockStatementListNode(
                        factory.makeReturnNode(factory.makeVariableAccessNode(
                                null, factory.makeIdentifierNode(singletonName)))), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC, false, true, false, false, false, false, factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode()), 
                factory.makeIdentifierNode("getInstance"), 
                factory.makeVariableListNode(), 
                factory.makeUnparameterizedTypeNode(factory.parseNameNode(className)), 
                factory.makeJavadocNode("Singleton getter.\n@return the singleton instance for this class."));
    }

    private ConstructorDeclarationNode generatePrivateConstructor(String className,
            BsjNodeFactory factory)
    {
        return factory.makeConstructorDeclarationNode(
                factory.makeIdentifierNode(className), 
                factory.makeConstructorBodyNode(null, factory.makeBlockStatementListNode()), 
                factory.makeConstructorModifiersNode(AccessModifier.PRIVATE), 
                factory.makeVariableListNode(), 
                factory.makeJavadocNode("Private constructor prevents direct instantiation."));
    }

    private FieldDeclarationNode generateSingletonField(String className,
            BsjNodeFactory factory)
    {
        return factory.makeFieldDeclarationNode(
                factory.makeFieldModifiersNode(AccessModifier.PRIVATE, true, true, false, false, factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode()),
                factory.makeUnparameterizedTypeNode(factory.parseNameNode(className)),
                factory.makeVariableDeclaratorListNode(
                        factory.makeVariableDeclaratorNode(
                                factory.makeIdentifierNode(singletonName), 
                                factory.makeUnqualifiedClassInstantiationNode(
                                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(className))))), 
                factory.makeJavadocNode("Singleton instance of this class."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}
