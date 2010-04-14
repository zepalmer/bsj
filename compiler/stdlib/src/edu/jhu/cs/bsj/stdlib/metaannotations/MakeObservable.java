package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

public class MakeObservable extends AbstractBsjMetaAnnotationMetaprogram
{
    /** The explicitly-specified name of the listener class. */
    private String listenerName;

    public MakeObservable()
    {
        super(Arrays.asList("observable"), Collections.<String> emptyList());
    }
    
    @BsjMetaAnnotationElementGetter
    public String getListenerName()
    {
        return this.listenerName;
    }

    @BsjMetaAnnotationElementSetter
    public void setListenerName(String listenerName)
    {
        this.listenerName = listenerName;
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO finish

        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        
        BsjNodeFactory factory = context.getFactory();    
        
        // private Set<FooListener> fooListeners;
        members.add(factory.makeFieldDeclarationNode(
                factory.makeFieldModifiersNode(AccessModifier.PRIVATE), 
                factory.makeVariableDeclaratorListNode(
                        factory.makeVariableDeclaratorNode(
                                factory.makeParameterizedTypeNode(
                                        factory.makeUnparameterizedTypeNode(
                                                factory.parseNameNode("java.util.Set")), 
                                        factory.makeTypeArgumentListNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.parseNameNode(listenerName)))), 
                                factory.makeIdentifierNode("listeners"), 
                                null)),//TODO initializer 
                factory.makeJavadocNode("Set of listeners requesting updates.")));
        
        // add the methods
        members.add(generateAddListenerMethod(context));
        members.add(generateRemoveListenerMethod(context));
        members.add(generateFireEventMethod(context));
    }

    private ClassMemberNode generateFireEventMethod(
            Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private ClassMemberNode generateRemoveListenerMethod(
            Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private ClassMemberNode generateAddListenerMethod(
            Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
        if (this.listenerName == null)
        {
            throw new InvalidMetaAnnotationConfigurationException(this, "Missing properties value");
        }
    }
}
