package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.metaannotations.utils.AbstractPropertyListMetaannotationMetaprogram;
import edu.jhu.cs.bsj.stdlib.utils.TypeDeclUtils;

/**
 * This meta-annotation metaprogram generates the toString method for a class. It generates this function
 * based on the getters for properties which exist on that class; that is, all methods of the form <code>getFoo()</code>
 * where <code>Foo</code> is an arbitrary name are invoked by the generated methods.
 * <p/>
 * If the optional "properties" property is specified, the getters for properties of the indicated names are called
 * instead.
 * 
 * @author Joseph Riley
 */
public class GenerateToString extends AbstractPropertyListMetaannotationMetaprogram
{

    public GenerateToString()
    {
        super(Arrays.asList("toString"), Arrays.asList("property"));
    }

    @Override
    public void execute(Context<MetaAnnotationMetaprogramAnchorNode> context, 
    		List<Pair<String, TypeNode>> getterDescriptions)
    {
        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);

       

        // create and add the actual toString method
        members.addLast(createToString(
                context, getterDescriptions, TypeDeclUtils.getEnclosingTypeName(context, this)));
    }

    /**
     * Create a toString method declaration based on our enclosing class.
     * @param context our context.
     * @param getters the getter names and types for our enclosing class.
     * @param classIdentifier the identifier of our enclosing class.
     * @return a method declaration for toString.
     */
    private MethodDeclarationNode createToString(
            Context<MetaAnnotationMetaprogramAnchorNode> context,
            List<Pair<String, TypeNode>> getters, IdentifierNode classIdentifier)
    {
        BsjNodeFactory factory = context.getFactory();        
        List<BlockStatementNode> statements = new ArrayList<BlockStatementNode>();
        
        // String ret = "ClassName [";
        statements.add(factory.makeLocalVariableDeclarationNode(
        		factory.makeUnparameterizedTypeNode(
                        factory.makeSimpleNameNode(
                        		factory.makeIdentifierNode("String"))),
                factory.makeVariableDeclaratorListNode(
                        factory.makeVariableDeclaratorNode( 
                                factory.makeIdentifierNode("ret"),
                factory.makeStringLiteralNode(classIdentifier.getIdentifier() + " [")))));

        // for each property, add its string form into our return value
        boolean first = true;
        for (Pair<String, TypeNode> getter : getters)
        {
            String getterName = getter.getFirst();
            String fieldName = getterName.substring(3);
            fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
            TypeNode type = getter.getSecond();
            ExpressionNode toStringValueNode;
            PrimaryExpressionNode getterCallNode = factory.makeMethodInvocationByNameNode(
                    factory.parseNameNode(getterName));
                
            if (type instanceof ArrayTypeNode)
            {
                // use Arrays.toString
                toStringValueNode = factory.makeMethodInvocationByNameNode(
                        factory.parseNameNode("java.util.Arrays.toString"),
                        factory.makeExpressionListNode(getterCallNode));
            } 
            else
            {
                // anything other than arrays can just be passed
                toStringValueNode = getterCallNode;
            }

            // now add our property's string representation to the whole
            statements.add(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                    factory.makeVariableAccessByNameNode(factory.parseNameNode("ret")), 
                    AssignmentOperator.PLUS_ASSIGNMENT, 
                    factory.makeBinaryExpressionNode(
                            factory.makeStringLiteralNode((first ? "" : ", ") + fieldName + "="), 
                            toStringValueNode, 
                            BinaryOperator.PLUS))));
            
            // allows us to skip a preceding comma for the first property
            first = false;
        }
        
        // ret += "]";
        statements.add(factory.makeExpressionStatementNode(factory.makeAssignmentNode(
                factory.makeVariableAccessByNameNode(factory.parseNameNode("ret")), 
                AssignmentOperator.PLUS_ASSIGNMENT, 
                factory.makeStringLiteralNode("]"))));
        
        // return ret;
        statements.add(factory.makeReturnNode(
                factory.makeVariableAccessByNameNode(
                        factory.makeSimpleNameNode(
                                factory.makeIdentifierNode("ret")))));
        
        // create a method declaration for toString()
        return factory.makeMethodDeclarationNode(
                factory.makeBlockStatementListNode(statements), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("toString"), 
                factory.makeVariableListNode(), 
                factory.makeUnparameterizedTypeNode(
                        factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("String"))), 
                factory.makeJavadocNode(
                        "Implementation of toString.\n" +
                		"@return a string representation of this object."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}
