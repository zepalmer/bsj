package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

public class MakeSingleton extends AbstractBsjMetaAnnotationMetaprogram
{
    private final String singletonName = "INSTANCE";
    
    public MakeSingleton()
    {
        super(Arrays.asList("singleton"), Collections.<String> emptyList());
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        
        // get the name of this class
        String className = TypeDeclUtils.getEnclosingTypeName(context, this).getIdentifier();
        
        // private static final Singleton INSTANCE = new Singleton();
        members.add(generateSingletonField(className, context));
        
        // TODO check for prior existence
        members.add(generatePrivateConstructor(className, context));
        
        // public static Singleton getInstance() {return INSTANCE;}
        members.add(generateSingletonGetter(className, context));
    }

    private MethodDeclarationNode generateSingletonGetter(String className,
            Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private ConstructorDeclarationNode generatePrivateConstructor(String className,
            Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private FieldDeclarationNode generateSingletonField(String className,
            Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}
