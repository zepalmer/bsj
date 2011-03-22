package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReturnNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.stdlib.diagnostic.impl.InvalidAnnotatedDeclarationDiagnosticImpl;
import edu.jhu.cs.bsj.stdlib.utils.FilterByFieldName;
import edu.jhu.cs.bsj.stdlib.utils.FilterByMethodName;

/**
 * This meta-annotation metaprogram generates method forwards to fields and methods that have private access. The
 * metaannotation is anchored around a field declaration, and takes two string arrays, the first is not optional, and is
 * the list of methods of the private field to forward. The second is a list of the names of the forwarded methods.
 * Forwarded methods are added to the class the metaannotation is anchored on, while methods to forward are methods of
 * the field type.
 * 
 * @author Uday Garikipati
 */
// TODO: replace all uses of strings for identifiers with IdentifierNode
// TODO: use an approach based on the type of the method to which we're delegating rather than its declaration AST
public class Delegate extends AbstractBsjMetaAnnotationMetaprogram
{

    private IdentifierNode method;
    private IdentifierNode as;
    private boolean onFieldDeclaration = false;
    BsjTypechecker typeChecker;
    private IdentifierNode field;

    public Delegate()
    {
        super(Arrays.asList("Delegate"), new ArrayList<String>(), Arrays.asList("property"));
    }

    @BsjMetaAnnotationElementGetter
    public IdentifierNode getMethod()
    {
        return this.method;
    }

    @BsjMetaAnnotationElementSetter
    public void setMethod(IdentifierNode method)
    {
        this.method = method;
    }

    @BsjMetaAnnotationElementGetter
    public IdentifierNode getField()
    {
        return this.field;
    }

    @BsjMetaAnnotationElementSetter
    public void setField(IdentifierNode field)
    {
        this.field = field;
    }

    @BsjMetaAnnotationElementGetter
    public IdentifierNode getAs()
    {
        return as;
    }

    @BsjMetaAnnotationElementSetter
    public void setAs(IdentifierNode forwardedMethodName)
    {
        this.as = forwardedMethodName;
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {
        // TODO: error checking - what if neither field nor method was specified
        if (this.as == null)
        {
            if (this.method != null)
            {
                this.as = this.method;
            } else
            {
                this.as = this.field;
            }
        }
    }

    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context)
    {
        /*
         * read the notebook you designed everything there
         */
        MetaAnnotationMetaprogramAnchorNode anchor = context.getAnchor();
        FieldDeclarationNode fieldNode = anchor.getNearestAncestorOfType(FieldDeclarationNode.class);
        String fieldName;
        TypeNode fieldType;
        /*
         * a delegate can be on a field or a method
         */
        if (fieldNode != null)
        {
            for (VariableDeclaratorNode variableDeclaration : fieldNode.getDeclarators().getChildren())
            {
                fieldName = variableDeclaration.getIdentifier().getIdentifier();
                if (variableDeclaration.getArrayLevels() > 0)
                {
                    // since we're not able to handle array types as it is, this
                    // would be an error anyway
                    // getEffectiveType won't cut it here because we need the
                    // type node to be connected
                    throw new NotImplementedYetException("Can't handle more than 0 array levels on declarator");
                } else
                {
                    fieldType = fieldNode.getType();
                    this.onFieldDeclaration = true;
                    createDelegate(
                            context,
                            fieldName,
                            variableDeclaration,
                            fieldType,
                            anchor.getNearestAncestorOfType(ClassDeclarationNode.class).getBody().getMembers().getChildren());
                }
            }

        } else
        {
            MethodDeclarationNode methodNode = anchor.getNearestAncestorOfType(MethodDeclarationNode.class);
            if (methodNode == null)
            {
                context.getDiagnosticListener().report(
                        new InvalidAnnotatedDeclarationDiagnosticImpl(getClass(), null,
                                Collections.<Class<? extends Node>> singletonList(FieldDeclarationNode.class)));
                throw new MetaprogramExecutionFailureException();
            } else
            {
                fieldType = methodNode.getReturnType();
                fieldName = methodNode.getIdentifier().getIdentifier();
                createDelegate(
                        context,
                        fieldName,
                        fieldType,
                        fieldType,
                        anchor.getNearestAncestorOfType(ClassDeclarationNode.class).getBody().getMembers().getChildren());

            }

        }
    }

    /*
     * a field or method can be delegated to either a field or a method based on the type that is delegated we create a
     * method or field
     */
    private void createDelegate(
            Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
            String fieldNameString, Node typeScopeNode, TypeNode fieldType, List<ClassMemberNode> classDeclarationList)
    {
        int i = 0;
        IdentifierNode fieldName = context.getFactory().makeIdentifierNode(fieldNameString);
        if (getMethod() != null)
        {
            String methodName = getMethod().getIdentifier();
            classDeclarationList.addAll(createDelegateMethodforMethods(context, typeScopeNode, fieldType, fieldName,
                    methodName, this.as.getIdentifier()));
        }
        i = 0;
        if (getField() != null)
        {
            String localFieldName = getField().getIdentifier();
            classDeclarationList.addAll(createDelegateMethodforFileds(context, typeScopeNode, fieldType, fieldName,
                    localFieldName, this.as.getIdentifier()));
            i++;
        }
    }

    /*
     * this method creates field delegates
     */
    private Collection<? extends ClassMemberNode> createDelegateMethodforFileds(
            Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
            Node typeScopeNode, TypeNode fieldType, IdentifierNode fieldName, String localFieldName,
            String forwardedMethodName)
    {
        List<MethodDeclarationNode> fieldsToAdd = new ArrayList<MethodDeclarationNode>();
        List<FieldDeclarationNode> fieldsList = getFieldToDelegate(typeScopeNode, fieldType, localFieldName);
        BsjNodeFactory factory = context.getFactory();
        if (fieldsList.size() == 0)
            throw new MetaprogramExecutionFailureException();
        for (FieldDeclarationNode fieldToAdd : fieldsList)
        {
            // break up the code in pieces and then start working on it
            IdentifierNode forwardedMethodNameIdentifier = factory.makeIdentifierNode(forwardedMethodName);
            JavadocNode javadoc = getJavaDoc(factory, fieldToAdd);
            TypeNode returnType = fieldToAdd.getType();
            MethodModifiersNode modifiers = factory.makeMethodModifiersNode(AccessModifier.PUBLIC);
            List<BlockStatementNode> listOfStatements = new ArrayList<BlockStatementNode>();
            // TODO: fix - a '.' is used below!
            ReturnNode returnNode = factory.makeReturnNode(factory.makeVariableAccessNode(factory.makeIdentifierNode(fieldName.getIdentifier()
                    + "." + fieldToAdd.getDeclarators().get(0).getIdentifier().getIdentifier())));
            listOfStatements.add(returnNode);
            BlockStatementListNode body = factory.makeBlockStatementListNode(listOfStatements);

            fieldsToAdd.add(factory.makeMethodDeclarationNode(body, modifiers, forwardedMethodNameIdentifier,
                    factory.makeVariableListNode(), null, returnType.deepCopy(factory), null, null, javadoc));
        }
        return fieldsToAdd;
    }

    private JavadocNode getJavaDoc(BsjNodeFactory factory, FieldDeclarationNode fieldToAdd)
    {
        JavadocNode javadocNode = fieldToAdd.getJavadoc();
        String javadocString;
        if (javadocNode == null)
        {
            javadocString = "";
        } else
        {
            javadocString = javadocNode.getText();
        }
        return factory.makeJavadocNode("Delegated: " + javadocString);
    }

    /*
     * this method delegates the methods
     */
    private Collection<? extends ClassMemberNode> createDelegateMethodforMethods(
            Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
            Node typeScopeNode, TypeNode variableType, IdentifierNode variableName, String methodName,
            String forwardedMethodName)
    {
        // Let fieldName be the name of the field
        BsjNodeFactory factory = context.getFactory();
        List<MethodDeclarationNode> methodsToAdd = new ArrayList<MethodDeclarationNode>();
        List<MethodDeclarationNode> methodsList = null;
        methodsList = getMethodsToDelegate(typeScopeNode, variableType, methodName);
        if (methodsList.size() == 0)
        {
            // TODO: actually report a diagnostic!
            throw new MetaprogramExecutionFailureException();
        }
        for (MethodDeclarationNode methodToAdd : methodsList)
        {
            // String forwardedMethodName = "";
            IdentifierNode forwardedMethodNameIdentifier = factory.makeIdentifierNode(forwardedMethodName == null ? methodToAdd.getIdentifier().getIdentifier()
                    : forwardedMethodName);
            VariableListNode parameters = methodToAdd.getParameters();
            /* return ~:fieldName:~.~:methodName:~(~:someArgs:~) */
            IdentifierNode fieldIdentifier = variableName.deepCopy(factory);
            PrimaryExpressionNode fieldExpression = makeAccessNode(context, fieldIdentifier);

            List<ExpressionNode> listOfArguments = new ArrayList<ExpressionNode>();
            for (VariableNode parameter : parameters.getChildren())
            {
                NameNode nameNode = getNameFromType(parameter.getType());
                if (nameNode != null)
                {
                    nameNode = getParameterizedType(variableType);
                    listOfArguments.add(factory.makeTypeCastNode(
                            factory.makeVariableAccessNode(parameter.getIdentifier().deepCopy(factory)),
                            (TypeNode) factory.makeUnparameterizedTypeNode(nameNode.deepCopy(factory))));
                } else
                    listOfArguments.add(factory.makeVariableAccessNode(null,
                            parameter.getIdentifier().deepCopy(factory)));

            }
            ExpressionListNode someArgs = factory.makeExpressionListNode(listOfArguments);
            ReturnNode returnNode = getReturnNode(factory, methodToAdd, fieldIdentifier, listOfArguments, methodName,
                    someArgs);
            List<BlockStatementNode> listOfStatements = new ArrayList<BlockStatementNode>();
            if (returnNode == null)
            {
                StatementNode node = factory.makeExpressionStatementNode(factory.makeMethodInvocationNode(
                        fieldExpression, factory.makeIdentifierNode(methodName), someArgs));
                listOfStatements.add(node);
            } else
            {
                listOfStatements.add(returnNode);
            }
            BlockStatementListNode body = factory.makeBlockStatementListNode(listOfStatements);

            MethodModifiersNode modifiers = factory.makeMethodModifiersNode(AccessModifier.PUBLIC);
            VariableNode varargParameter = methodToAdd.getVarargParameter();
            UnparameterizedTypeListNode throwTypes = methodToAdd.getThrowTypes();
            TypeParameterListNode typeParameters = methodToAdd.getTypeParameters();
            JavadocNode javadoc = getJavaDoc(factory, methodToAdd);
            TypeNode returnType = getNewreturnType(factory, methodToAdd.getReturnType().deepCopy(factory));
            parameters = getNewParams(factory, parameters);
            methodsToAdd.add(factory.makeMethodDeclarationNode(body, modifiers, forwardedMethodNameIdentifier,
                    parameters.deepCopy(factory), varargParameter, returnType.deepCopy(factory),
                    throwTypes.deepCopy(factory), typeParameters.deepCopy(factory), javadoc));
        }
        return methodsToAdd;
    }

    private JavadocNode getJavaDoc(BsjNodeFactory factory, MethodDeclarationNode methodToAdd)
    {
        JavadocNode javadocNode = methodToAdd.getJavadoc();
        String javadocString;
        if (javadocNode == null)
        {
            javadocString = "";
        } else
        {
            javadocString = javadocNode.getText();
        }
        return factory.makeJavadocNode("Delegated: " + javadocString);

    }

    private List<FieldDeclarationNode> getFieldToDelegate(Node typeScopeNode, TypeNode callerType, String fieldName)
    {

        List<FieldDeclarationNode> returnValue = new ArrayList<FieldDeclarationNode>();
        // TODO handle for name is null which means it its a primitive type
        NameNode name = getNameFromType(callerType);

        Collection<? extends Node> declarations = typeScopeNode.getDeclarationsInScope(name);
        if (declarations.size() != 1)
        {
            // then either the declaration isn't in scope or there is more than
            // one declaration in scope
            throw new NotImplementedYetException(declarations.size() + " declarations found for name "
                    + name.getNameString() + " at position " + callerType.getStartLocation());

        } else
        {
            Node declaration = declarations.iterator().next();
            if (!(declaration instanceof NamedTypeDeclarationNode<?>))
            {
                // then the type we want is obscured by a type or method
                // declaration
                // TODO: produce an appropriate diagnostic
                throw new NotImplementedYetException("got " + declaration.getClass().getCanonicalName());
            }
            NamedTypeDeclarationNode<?> type = (NamedTypeDeclarationNode<?>) declaration;
            TypeBodyNode<?> typeBody = type.getBody();
            ListNode<? extends Node> listOfMembers = typeBody.getMembers();
            for (Node node : listOfMembers.filter(new FilterByFieldName(fieldName)))
            {
                if (node instanceof FieldDeclarationNode)
                {
                    FieldDeclarationNode methodNode = (FieldDeclarationNode) node;
                    returnValue.add(methodNode);
                }
            }
        }
        return returnValue;
    }

    private TypeNode getNewreturnType(BsjNodeFactory factory, TypeNode parameter)
    {
        NameNode name = getNameFromType(parameter);
        if (name == null)
            return parameter;
        else
        {
            if (parameter.getRootPackage() != null)
            {
                Collection<? extends Node> decls = parameter.getTypeDeclarationsInScope(name.getNameString());
                if (decls.size() == 0)
                {
                    UnparameterizedTypeNode newParameter = (UnparameterizedTypeNode) parameter.deepCopy(factory);
                    newParameter.setName(factory.makeSimpleNameNode(factory.makeIdentifierNode("java.lang.Object")));
                    return newParameter;
                } else
                {
                    return parameter;
                }
            } else
            {
                return parameter;
            }
        }
    }

    private NameNode getParameterizedType(TypeNode type)
    {

        if (type instanceof UnparameterizedTypeNode)
        {
            return ((UnparameterizedTypeNode) type).getName();
        } else if (type instanceof ParameterizedTypeNode)
        {
            return ((UnparameterizedTypeNode) ((ParameterizedTypeNode) type).getTypeArguments().getFirst()).getName();
        } else
        {

            throw new NotImplementedYetException();
        }

    }

    private ReturnNode getReturnNode(BsjNodeFactory factory, MethodDeclarationNode methodToAdd,
            IdentifierNode fieldIdentifier, List<ExpressionNode> listOfArguments, String methodName,
            ExpressionListNode someArgs)
    {
        TypeNode temp = methodToAdd.getReturnType();
        if (temp instanceof VoidTypeNode)
        {
            return null;
        } else
        {
            return factory.makeReturnNode(factory.makeMethodInvocationNode(
                    factory.makeVariableAccessNode(factory.makeThisNode(),
                            factory.makeIdentifierNode(fieldIdentifier.getIdentifier())),
                    factory.makeIdentifierNode(methodName), someArgs));
        }
    }

    private VariableListNode getNewParams(BsjNodeFactory factory, VariableListNode parameters)
    {
        VariableListNode listNode = factory.makeVariableListNode();
        for (VariableNode parameter : parameters.getChildren())
        {
            NameNode type = getNameFromType(parameter.getType());
            if (type == null)
            {
                listNode.add(parameter.deepCopy(factory));
            } else
            {
                Collection<? extends Node> decls = parameter.getTypeDeclarationsInScope(parameter.getIdentifier().getIdentifier());
                if (decls.size() == 0)
                {
                    parameter = parameter.deepCopy(factory);
                    parameter.setType(factory.makeUnparameterizedTypeNode(factory.parseNameNode("java.lang.Object")));
                    listNode.add(parameter);
                } else
                {
                    listNode.add(parameter.deepCopy(factory));
                }
            }
        }

        return listNode;
    }

    private PrimaryExpressionNode makeAccessNode(
            Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context,
            IdentifierNode fieldIdentifier)
    {
        BsjNodeFactory factory = context.getFactory();
        PrimaryExpressionNode accessNode;
        if (onFieldDeclaration)
            // for fields
            accessNode = factory.makeVariableAccessNode(null, fieldIdentifier.deepCopy(factory));
        else
            // for methods
            accessNode = factory.makeMethodInvocationNode(fieldIdentifier.deepCopy(factory));

        return accessNode;
    }

    private List<MethodDeclarationNode> getMethodsToDelegate(Node typeScopeNode, TypeNode callerType, String methodName)
    {

        List<MethodDeclarationNode> returnValue = new ArrayList<MethodDeclarationNode>();
        // TODO handle for name is null which means it its a primitive type
        NameNode name = getNameFromType(callerType);

        Collection<? extends Node> declarations = typeScopeNode.getDeclarationsInScope(name);
        if (declarations.size() != 1)
        {
            // then either the declaration isn't in scope or there is more than
            // one declaration in scope
            throw new NotImplementedYetException(declarations.size() + " declarations found for name "
                    + name.getNameString() + " at position " + callerType.getStartLocation());

        } else
        {
            Node declaration = declarations.iterator().next();
            if (!(declaration instanceof NamedTypeDeclarationNode<?>))
            {
                // then the type we want is obscured by a type or method
                // declaration
                // TODO: produce an appropriate diagnostic
                throw new NotImplementedYetException("got " + declaration.getClass().getCanonicalName());
            }
            NamedTypeDeclarationNode<?> type = (NamedTypeDeclarationNode<?>) declaration;
            TypeBodyNode<?> typeBody = type.getBody();
            ListNode<? extends Node> listOfMembers = typeBody.getMembers();
            for (Node node : listOfMembers.filter(new FilterByMethodName(methodName)))
            {
                if (node instanceof MethodDeclarationNode)
                {
                    MethodDeclarationNode methodNode = (MethodDeclarationNode) node;
                    returnValue.add(methodNode);
                }
            }
        }
        return returnValue;
    }

    private NameNode getNameFromType(TypeNode type)
    {
        if (type instanceof UnparameterizedTypeNode)
        {
            return ((UnparameterizedTypeNode) type).getName();
        } else if (type instanceof ParameterizedTypeNode)
        {
            return ((ParameterizedTypeNode) type).getBaseType().getName();
        } else if (type instanceof PrimitiveTypeNode)
        {
            return null;
        } else if (type instanceof VoidTypeNode)
        {
            return null;
        } else
        {
            throw new NotImplementedYetException();
        }
    }
}
