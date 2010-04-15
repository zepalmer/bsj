package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.Arrays;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
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
    
    /** The explicitly-specified name of the event class. */
    private String eventName;

    /** The name of the List of listeners that will be used. */
    private final String listenerListName = "listeners";
    
    private String eventOccurredName;
    
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
    
    @BsjMetaAnnotationElementGetter
    public String getEventName()
    {
        return this.eventName;
    }

    @BsjMetaAnnotationElementSetter
    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // TODO generate interface, test listening

        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        
        // build the name of the event occurred method on the listener class
        String temp = eventName.replace(".", "");
        eventOccurredName = Character.toLowerCase(temp.charAt(0)) + temp.substring(1) + "Occurred";

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
                                factory.makeIdentifierNode(listenerListName), 
                                factory.makeUnqualifiedClassInstantiationNode(
                                        factory.makeParameterizedTypeNode(
                                                factory.makeUnparameterizedTypeNode(
                                                        factory.parseNameNode("java.util.HashSet")), 
                                                        factory.makeTypeArgumentListNode(
                                                                factory.makeUnparameterizedTypeNode(
                                                                        factory.parseNameNode(listenerName))))))),
                factory.makeJavadocNode("Set of listeners requesting updates.")));
        
        // add the methods
        members.add(generateAddListenerMethod(context, factory));
        members.add(generateRemoveListenerMethod(context, factory));
        members.add(generateFireEventMethod(context, factory));
    }

    private ClassMemberNode generateAddListenerMethod(
            Context<MetaAnnotationMetaprogramAnchorNode> context, BsjNodeFactory factory)
    {
        String paramName = "listener";
        
        // this.listeners.add(listener);
        BlockStatementListNode statement = factory.makeBlockStatementListNode(
                factory.makeExpressionStatementNode(
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeFieldAccessByExpressionNode(factory.makeThisNode(), 
                                factory.makeIdentifierNode(listenerListName)), 
                        factory.makeIdentifierNode("add"), 
                        factory.makeExpressionListNode(factory.makeFieldAccessByNameNode(factory.parseNameNode(paramName))), 
                        factory.makeReferenceTypeListNode())));
        
        // build the method declaration
        return factory.makeMethodDeclarationNode(
                factory.makeBlockNode(statement), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("add" + listenerName), 
                factory.makeVariableListNode(factory.makeVariableNode(
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(listenerName)),
                        factory.makeIdentifierNode(paramName))), 
                factory.makeVoidTypeNode(), 
                factory.makeJavadocNode("Adds a listener to this class.\n@param listener the listener to add."));
    }
    
    private ClassMemberNode generateRemoveListenerMethod(
            Context<MetaAnnotationMetaprogramAnchorNode> context, BsjNodeFactory factory)
    {
        String paramName = "listener";
        
        // this.listeners.remove(listener);
        BlockStatementListNode statement = factory.makeBlockStatementListNode(
                factory.makeExpressionStatementNode(
                factory.makeMethodInvocationByExpressionNode(
                        factory.makeFieldAccessByExpressionNode(factory.makeThisNode(), 
                                factory.makeIdentifierNode(listenerListName)), 
                        factory.makeIdentifierNode("remove"), 
                        factory.makeExpressionListNode(factory.makeFieldAccessByNameNode(factory.parseNameNode(paramName))), 
                        factory.makeReferenceTypeListNode())));
        
        // build the method declaration
        return factory.makeMethodDeclarationNode(
                factory.makeBlockNode(statement), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("remove" + listenerName), 
                factory.makeVariableListNode(factory.makeVariableNode(
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(listenerName)),
                        factory.makeIdentifierNode(paramName))), 
                factory.makeVoidTypeNode(), 
                factory.makeJavadocNode("Removes a listener from this class.\n@param listener the listener to remove."));

    }

    private ClassMemberNode generateFireEventMethod(
            Context<MetaAnnotationMetaprogramAnchorNode> context, BsjNodeFactory factory)
    {
        String paramName = "event";
        String varName = "listener";
        
        // listener.<:eventName:>Occurred(event);
        ExpressionStatementNode methodCall = factory.makeExpressionStatementNode(
            factory.makeMethodInvocationByExpressionNode(
                    factory.makeFieldAccessByNameNode(factory.parseNameNode(varName)), 
                    factory.makeIdentifierNode(eventOccurredName),
                    factory.makeExpressionListNode(factory.makeFieldAccessByNameNode(factory.parseNameNode(paramName))), 
                    factory.makeReferenceTypeListNode()));
        
        // for(<:listenerName:> listener : listeners){listener.<:eventName:>Occurred(event);}
        BlockStatementListNode statements = factory.makeBlockStatementListNode();
        statements.add(factory.makeEnhancedForLoopNode(
                factory.makeVariableNode(factory.makeUnparameterizedTypeNode(factory.parseNameNode(listenerName)), factory.makeIdentifierNode(varName)), 
                factory.makeFieldAccessByNameNode(factory.parseNameNode(listenerListName)), 
                factory.makeBlockNode(factory.makeBlockStatementListNode(methodCall))));
        
        // build the method declaration
        return factory.makeMethodDeclarationNode(
                factory.makeBlockNode(statements), 
                factory.makeMethodModifiersNode(AccessModifier.PROTECTED), 
                factory.makeIdentifierNode("fire" + eventName),
                factory.makeVariableListNode(factory.makeVariableNode(
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(eventName)),
                        factory.makeIdentifierNode(paramName))), 
                factory.makeVoidTypeNode(), 
                factory.makeJavadocNode("Notifies all listeners of an event.\n@param event the event that occurred."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
        if (this.listenerName == null || this.eventName == null)
        {
            throw new InvalidMetaAnnotationConfigurationException(this, "Missing properties value(s)");
        }
    }
}
