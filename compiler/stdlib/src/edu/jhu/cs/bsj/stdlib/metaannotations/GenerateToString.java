package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.MissingMethodDeclarationDiagnosticImpl;
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
public class GenerateToString extends AbstractBsjMetaAnnotationMetaprogram
{
    /** The explicitly-specified list of properties. */
    private String[] properties = null;

    public GenerateToString()
    {
        //TODO remove dependency on equalsAndHashCode
        super(Arrays.asList("toString"), Arrays.asList("property", "equalsAndHashCode"));
    }

    @BsjMetaAnnotationElementGetter
    public String[] getProperties()
    {
        return this.properties;
    }

    @BsjMetaAnnotationElementSetter
    public void setProperties(String[] properties)
    {
        this.properties = properties;
    }
    
    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode> context)
    {
        // get all the members of our enclosing class
        ClassMemberListNode members = TypeDeclUtils.getClassMembers(context, this);

        //TODO roll into utilities class?
        // establish the list of properties we will be using
        List<Pair<String, TypeNode>> getterDescriptions = new ArrayList<Pair<String, TypeNode>>();
        if (this.properties == null)
        {
            for (ClassMemberNode member : members)
            {
                if (member instanceof MethodDeclarationNode)
                {
                    MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
                    if (methodDecl.getIdentifier().getIdentifier().startsWith("get")
                            && methodDecl.getParameters().size() == 0
                            && (!(methodDecl.getReturnType() instanceof PrimitiveTypeNode) || (((PrimitiveTypeNode) (methodDecl.getReturnType())).getPrimitiveType() != PrimitiveType.VOID)))
                    {
                        getterDescriptions.add(new Pair<String, TypeNode>(methodDecl.getIdentifier().getIdentifier(),
                                methodDecl.getReturnType()));
                    }
                }
            }
        } else
        {
            Map<String, MethodDeclarationNode> methodMap = new HashMap<String, MethodDeclarationNode>();
            for (ClassMemberNode member : members)
            {
                if (member instanceof MethodDeclarationNode)
                {
                    MethodDeclarationNode methodDecl = (MethodDeclarationNode) member;
                    methodMap.put(methodDecl.getIdentifier().getIdentifier(), methodDecl);
                }
            }
            for (String propName : this.properties)
            {
                String getterName = "get" + Character.toUpperCase(propName.charAt(0)) + propName.substring(1);
                MethodDeclarationNode getterDeclaration = methodMap.get(getterName);
                if (getterDeclaration == null)
                {
                    context.getDiagnosticListener().report(
                            new MissingMethodDeclarationDiagnosticImpl(members, getterName));
                    throw new MetaprogramExecutionFailureException();
                }
                getterDescriptions.add(new Pair<String, TypeNode>(getterName, getterDeclaration.getReturnType()));
            }
        }

        // create and add the actual toString method
        members.add(createToString(
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
        statements.add(factory.makeVariableDeclarationNode(
                factory.makeVariableDeclaratorListNode(
                        factory.makeVariableDeclaratorNode(
                        factory.makeUnparameterizedTypeNode(
                                factory.makeSimpleNameNode(
                                factory.makeIdentifierNode("String"), 
                                NameCategory.TYPE)), 
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
                    factory.makeFieldAccessByNameNode(factory.parseNameNode("ret")), 
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
                factory.makeFieldAccessByNameNode(factory.parseNameNode("ret")), 
                AssignmentOperator.PLUS_ASSIGNMENT, 
                factory.makeStringLiteralNode("]"))));
        
        // return ret;
        statements.add(factory.makeReturnNode(
                factory.makeFieldAccessByNameNode(
                        factory.makeSimpleNameNode(
                                factory.makeIdentifierNode("ret"), NameCategory.EXPRESSION))));
        
        // create a method declaration for toString()
        return factory.makeMethodDeclarationNode(
                factory.makeBlockNode(factory.makeBlockStatementListNode(statements)), 
                factory.makeMethodModifiersNode(AccessModifier.PUBLIC), 
                factory.makeIdentifierNode("toString"), 
                factory.makeVariableListNode(), 
                factory.makeUnparameterizedTypeNode(
                        factory.makeSimpleNameNode(
                        factory.makeIdentifierNode("String"), NameCategory.TYPE)), 
                factory.makeJavadocNode(
                        "Implementation of toString.\n" +
                		"@return a string representation of this object."));
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
    }
}
