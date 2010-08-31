package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidEnclosingTypeDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.metaannotations.utils.AbstractPropertyListMetaannotationMetaprogram;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram generates the compareTo method for a class, as well as forcing it to implement the
 * Comparable<T> interface. The "properties" property is used to determine the fields used in the comparison and their
 * order of importance.
 * 
 * @author Joseph Riley
 */
public class ComparedBy extends AbstractPropertyListMetaannotationMetaprogram
{
    /** The explicitly-specified list of properties. */
    public ComparedBy()
    {
        super(Arrays.asList("comparedBy"), Arrays.asList("property", "equalsAndHashCode"));
    }

    public void execute(Context<MetaAnnotationMetaprogramAnchorNode> context,
    		List<Pair<String, TypeNode>> getterDescriptions)
    {
        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);
        IdentifierNode className = TypeDeclUtils.getEnclosingTypeName(context, this);
        addComparableInterface(context, className);
        members.add(generateCompareTo(context, getterDescriptions, className));
    }

    private void addComparableInterface(
            Context<MetaAnnotationMetaprogramAnchorNode> context, 
            IdentifierNode className)
    {
        BsjNodeFactory factory = context.getFactory();  
        TypeDeclarationNode enclosingTypeDeclaration = context.getAnchor().getNearestAncestorOfType(
                TypeDeclarationNode.class);
        DeclaredTypeListNode implementsClause = null;
        
        if (enclosingTypeDeclaration instanceof ClassDeclarationNode)
        {
            ClassDeclarationNode classNode = ((ClassDeclarationNode) enclosingTypeDeclaration);
            implementsClause = classNode.getImplementsClause();

        } 
        else if (enclosingTypeDeclaration instanceof EnumDeclarationNode)
        {
            EnumDeclarationNode enumNode = ((EnumDeclarationNode) enclosingTypeDeclaration);
            implementsClause = enumNode.getImplementsClause();
        } 
        else
        {
            List<Class<? extends TypeDeclarationNode>> typeDeclarationList = new ArrayList<Class<? extends TypeDeclarationNode>>();
            typeDeclarationList.add(ClassDeclarationNode.class);
            typeDeclarationList.add(EnumDeclarationNode.class);
            context.getDiagnosticListener().report(
                    new InvalidEnclosingTypeDiagnosticImpl(getClass(), enclosingTypeDeclaration, typeDeclarationList));
            throw new MetaprogramExecutionFailureException();
        }
        
        // adding "implements Comparable<T>"
        implementsClause.add(factory.makeParameterizedTypeNode(
                factory.makeUnparameterizedTypeNode(factory.parseNameNode("Comparable")), 
                factory.makeTypeArgumentListNode(factory.makeUnparameterizedTypeNode(
                        factory.parseNameNode(className.getIdentifier())))));
    }

    private ClassMemberNode generateCompareTo(Context<MetaAnnotationMetaprogramAnchorNode> context,
            List<Pair<String, TypeNode>> getters, IdentifierNode className)
    {
        // TODO add support for Comparable non-primitive fields?
        
        BsjNodeFactory factory = context.getFactory();        
        List<BlockStatementNode> statements = new ArrayList<BlockStatementNode>();
        
        // if (o == null) {throw new NullPointerException();}        
        statements.add(factory.makeIfNode(
                factory.makeBinaryExpressionNode(
                        factory.makeVariableAccessNode(null, factory.makeIdentifierNode("o")), 
                        factory.makeNullLiteralNode(), 
                        BinaryOperator.EQUAL),
                factory.makeThrowNode(factory.makeUnqualifiedClassInstantiationNode(
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode("NullPointerException"))))));
        
        // if (this.equals(o)) {return 0;}        
        statements.add(factory.makeIfNode(
                factory.makeMethodInvocationNode(
                        factory.makeThisNode(), 
                        factory.makeIdentifierNode("equals"), 
                        factory.makeExpressionListNode(
                                factory.makeVariableAccessNode(null, factory.makeIdentifierNode("o")))), 
                factory.makeReturnNode(factory.makeIntLiteralNode(0))));
        
        // for each property, in order compare it to the other
        for (Pair<String, TypeNode> getter : getters)
        {
            String getterName = getter.getFirst();
            TypeNode type = getter.getSecond();
            ExpressionNode lessThanExpression = null;
            ExpressionNode greaterThanExpression = null;
            
            PrimaryExpressionNode thisGetterNode = factory.makeMethodInvocationNode(factory.makeIdentifierNode(getterName));
            PrimaryExpressionNode otherGetterNode = factory.makeMethodInvocationNode(
                    factory.makeVariableAccessNode(null, factory.makeIdentifierNode("o")),
                    factory.makeIdentifierNode(getterName));
            
            if (type instanceof PrimitiveTypeNode)
            {
                lessThanExpression = factory.makeBinaryExpressionNode(thisGetterNode, otherGetterNode,
                      BinaryOperator.LESS_THAN);
                greaterThanExpression = factory.makeBinaryExpressionNode(
                        thisGetterNode.deepCopy(factory), otherGetterNode.deepCopy(factory),
                        BinaryOperator.GREATER_THAN);
            }
            else if (type instanceof ArrayTypeNode)
            {
                // TODO better error handling
                throw new IllegalStateException("Arrays not supported by @@ComparedBy meta-annotation");
            } 
            else
            {
                throw new IllegalStateException();
            }
            
            // if (this.getX() < o.getX()) {return -1;}
            statements.add(factory.makeIfNode(lessThanExpression, 
                    factory.makeReturnNode(factory.makeIntLiteralNode(-1))));  
            
            // if (this.getX() > o.getX()) {return 1;}
            statements.add(factory.makeIfNode(greaterThanExpression, 
                    factory.makeReturnNode(factory.makeIntLiteralNode(1)))); 
        }
        
        // return 0;
        statements.add(factory.makeReturnNode(factory.makeIntLiteralNode(0)));
        
        // create a method declaration for compareTo(T o)
        return factory.makeMethodDeclarationNode(
                factory.makeBlockStatementListNode(statements), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("compareTo"), 
                factory.makeVariableListNode(factory.makeVariableNode(
                        factory.makeUnparameterizedTypeNode(factory.parseNameNode(className.getIdentifier())),
                        factory.makeIdentifierNode("o"))), 
                factory.makePrimitiveTypeNode(PrimitiveType.INT), 
                factory.makeJavadocNode(
                        "Implementation of compareTo.\n" +
                        "@param o the other object to compare to.\n" +
                        "@return -1, 0, or 1 if this object is less than, equal to, or greater than the other."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
        if (getProperties() == null)
        {
            throw new InvalidMetaAnnotationConfigurationException(this, "Missing properties value");
        }
    }



}
