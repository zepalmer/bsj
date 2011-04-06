package edu.jhu.cs.bsj.stdlib.metaannotations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InvokableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryStatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.type.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.metaannotation.InvalidMetaAnnotationConfigurationException;
import edu.jhu.cs.bsj.compiler.metaprogram.AbstractBsjMetaprogramMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckingException;

/**
 * Rewrites the annotated AST to implement BigInteger operator overloading. Instances of class are not thread-safe.
 * 
 * @author Zachary Palmer
 * @author Uday Garikipati
 */
public class BigIntegerOperatorOverloading extends AbstractBsjMetaprogramMetaAnnotation
{

    private Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context;
    private BsjTypechecker typechecker;
    private BsjNodeFactory factory;

    public BigIntegerOperatorOverloading()
    {
        super(Arrays.asList("operatorOverloading"), Collections.<String> emptyList(), Collections.<String> emptyList(),
                MetaprogramLocalMode.MUTATE, MetaprogramPackageMode.READ_ONLY);
    }

    @Override
    public void complete() throws InvalidMetaAnnotationConfigurationException
    {

    }

    @Override
    protected void execute(Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context)
    {

        this.context = context;
        this.factory = this.context.getFactory();
        this.typechecker = null;

        BlockStatementNode statementNode = context.getAnchor().getNearestAncestorOfType(BlockStatementNode.class);
        if (statementNode == null)
        {
            MethodDeclarationNode methodDeclNode = context.getAnchor().getNearestAncestorOfType(
                    MethodDeclarationNode.class);
            processTree(methodDeclNode, context);
        } else
        {
            processTree(statementNode, context);
        }

    }

    private void processTree(Node node,
            final Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context)
    {
        final Map<ExpressionNode, ExpressionNode> replacementMap = new HashMap<ExpressionNode, ExpressionNode>();

        boolean anyChanges;
        do
        {
            this.typechecker = context.getTypecheckerFactory().makeTypechecker(
                    this.context.getAnchor().getRootPackage(), new DiagnosticListener<BsjSourceLocation>()
                    {
                        @Override
                        public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
                        {
                            // Not much we can do about it.
                        }
                    });
            anyChanges = false;
            node.receiveTyped(new BsjTypedNodeNoOpVisitor()
            {
                /*
                 * The algo: Go down the entire tree and check if a node statement is type checked if it type checks
                 * convert it into the corresponding code else put the expression in a list to see if an expression type
                 * checks once the list is done finish the execution
                 */
                @Override
                public void visitBinaryExpressionNodeStop(BinaryExpressionNode node, boolean mostSpecific)
                {
                    ExpressionNode leftExpNode = node.getLeftOperand();
                    ExpressionNode rightExpNode = node.getRightOperand();
                    if (isBigIntegerType(leftExpNode) || isBigIntegerType(rightExpNode))
                    {
                        ExpressionNode afterNode = convertNodes(node);
                        if (afterNode != null)
                            replacementMap.put(node, afterNode);
                    }
                }

                private ExpressionNode convertNodes(BinaryExpressionNode node)
                {
                    BinaryOperator operator = node.getOperator();
                    ExpressionNode rightExpNode = node.getRightOperand();
                    ExpressionNode leftExpNode = node.getLeftOperand();

                    leftExpNode = convertExpressionToBigInteger(leftExpNode);
                    if (leftExpNode == null)
                        return null;
                    rightExpNode = convertExpressionToBigInteger(rightExpNode);
                    if (rightExpNode == null)
                        return null;

                    ExpressionNode afterNode = makeReplacementNode(leftExpNode, rightExpNode, operator);

                    return afterNode;

                }

                @Override
                public void visitUnaryExpressionNodeStop(UnaryExpressionNode node, boolean mostSpecific)
                {
                    if (isBigIntegerType(node.getExpression()))
                    {
                        // TODO: non-statement unary expressions like "~b"?
                        throw new NotImplementedYetException("Can't yet handle unary expressions (operator "
                                + node.getOperator() + " at " + node.getStartLocation() + ")");
                    }
                }

                @Override
                public void visitUnaryStatementExpressionNodeStop(UnaryStatementExpressionNode node,
                        boolean mostSpecific)
                {
                    ExpressionNode expNode = node.getExpression();
                    if (isBigIntegerType(expNode))
                    {
                        ExpressionNode afterNode = convertUnaryStatementExpression(node);
                        replacementMap.put(node, afterNode);
                    }
                }

                @Override
                public void visitMethodInvocationNodeStop(MethodInvocationNode node, boolean mostSpecific)
                {
                    // If the method is invoked with arguments which can be converted to BigInteger and the method's
                    // parameter type is BigInteger, we need to do the conversion ourselves.
                    // TODO: this is very sloppy - we need to be able to ask questions like "to which method declaration
                    // will this call be tied"?
                    MethodInvocationNode replacement = convertMethodInvocationExpression(node);
                    if (replacement != null)
                        replacementMap.put(node, replacement);
                }
            });
            Iterator<ExpressionNode> keySet = replacementMap.keySet().iterator();
            while (keySet.hasNext())
            {
                ExpressionNode beforeNode = (ExpressionNode) keySet.next();
                ExpressionNode afterNode = replacementMap.get(beforeNode);
                beforeNode.getParent().replace(beforeNode, afterNode);
                anyChanges = true;
            }
            replacementMap.clear();
        } while (anyChanges);

    }

    // Create an enum mapping between BinaryOperators and BigInteger method names
    private static final Map<BinaryOperator, String> BIG_INTEGER_METHOD_NAMES;
    static
    {
        Map<BinaryOperator, String> map = new EnumMap<BinaryOperator, String>(BinaryOperator.class);
        map.put(BinaryOperator.PLUS, "add");
        map.put(BinaryOperator.MINUS, "subtract");
        map.put(BinaryOperator.MULTIPLY, "multiply");
        map.put(BinaryOperator.DIVIDE, "divide");
        map.put(BinaryOperator.MODULUS, "mod");
        BIG_INTEGER_METHOD_NAMES = Collections.unmodifiableMap(map);
    }
    // Create an enum set of the binary operators which work if we use them on BigInteger.compareTo results
    private static final Set<BinaryOperator> BIG_INTEGER_COMPARISON_OPS = Collections.unmodifiableSet(EnumSet.of(
            BinaryOperator.LESS_THAN, BinaryOperator.LESS_THAN_EQUAL, BinaryOperator.GREATER_THAN,
            BinaryOperator.GREATER_THAN_EQUAL, BinaryOperator.EQUAL, BinaryOperator.NOT_EQUAL));

    /**
     * Given two expressions which are of type {@link BigInteger}, produces a Java expression which will perform the
     * operation specified by the given operator.
     * 
     * @param context The metaprogram context.
     * @param leftExpNode The left operand expression.
     * @param rightExpNode The right operand expression.
     * @param operator The operator.
     * @return The expression to use in its replacement.
     */
    private ExpressionNode makeReplacementNode(ExpressionNode leftExpNode, ExpressionNode rightExpNode,
            BinaryOperator operator)
    {
        if (BIG_INTEGER_COMPARISON_OPS.contains(operator))
        {
            ExpressionNode compareToOperand = makeCompareToNode(leftExpNode, rightExpNode);
            return factory.makeBinaryExpressionNode(compareToOperand, factory.makeIntLiteralNode(0), operator);
        } else if (BIG_INTEGER_METHOD_NAMES.containsKey(operator))
        {
            IdentifierNode identifierNode = context.getFactory().makeIdentifierNode(
                    BIG_INTEGER_METHOD_NAMES.get(operator));
            MethodInvocationNode afterNode = context.getFactory().makeMethodInvocationNode(
                    factory.makeParenthesizedExpressionNode(leftExpNode.deepCopy(context.getFactory())),
                    identifierNode,
                    context.getFactory().makeExpressionListNode(rightExpNode.deepCopy(context.getFactory())));
            return afterNode;
        } else
        {
            throw new NotImplementedYetException();
        }
    }

    private ExpressionNode makeCompareToNode(ExpressionNode leftExpNode, ExpressionNode rightExpNode)
    {

        final BsjNodeFactory factory = context.getFactory();
        ExpressionNode afterNode = factory.makeMethodInvocationNode(
                (PrimaryExpressionNode) leftExpNode.deepCopy(factory), factory.makeIdentifierNode("compareTo"),
                context.getFactory().makeExpressionListNode(rightExpNode.deepCopy(context.getFactory())));
        return afterNode;
    }

    private ExpressionNode convertUnaryStatementExpression(UnaryStatementExpressionNode expr)
    {
        ExpressionNode expNode = null;
        UnaryStatementOperator operator = expr.getOperator();
        if (operator.equals(UnaryStatementOperator.POSTFIX_INCREMENT)
                || operator.equals(UnaryStatementOperator.PREFIX_INCREMENT))
        {
            expNode = getPlusOneExpression(expr);
            if (operator.equals(UnaryStatementOperator.PREFIX_INCREMENT))
            {
                BsjNodeFactory factory = context.getFactory();
                return factory.makeMethodInvocationNode(factory.makeParenthesizedExpressionNode(expNode),
                        factory.makeIdentifierNode("add"),
                        factory.makeExpressionListNode(factory.makeLongLiteralNode(-1L)));
            }
        } else
        {
            throw new NotImplementedYetException();
        }

        return expNode;
    }

    private PrimaryExpressionNode makeBigIntegerOne()
    {
        return factory.makeVariableAccessNode(
                factory.makeVariableAccessNode(
                        factory.makeVariableAccessNode(
                                factory.makeVariableAccessNode(factory.makeIdentifierNode("java")),
                                factory.makeIdentifierNode("math")), factory.makeIdentifierNode("BigInteger")),
                factory.makeIdentifierNode("ONE"));

    }

    private AssignmentNode getPlusOneExpression(UnaryStatementExpressionNode unaryNode)
    {
        final BsjNodeFactory factory = context.getFactory();
        PrimaryExpressionNode one = makeBigIntegerOne();
        return factory.makeAssignmentNode(
                unaryNode.getExpression().deepCopy(factory),
                AssignmentOperator.ASSIGNMENT,
                factory.makeMethodInvocationNode(
                        factory.makeParenthesizedExpressionNode(unaryNode.getExpression().deepCopy(factory)).deepCopy(
                                factory), factory.makeIdentifierNode("add"), factory.makeExpressionListNode(one)));
    }

    /*
     * this method converts a node to java.math.biginteger, it asks a node if its
     */
    public ExpressionNode convertExpressionToBigInteger(ExpressionNode expr)
    {
        final BsjType type;
        try
        {
            type = typechecker.getType(expr);
        } catch (TypecheckingException e)
        {
            return null;
        }
        if (isBigIntegerType(type))
        {
            return expr.deepCopy(factory);
        }
        if (isClassType(type, "java.lang.Long") || isPrimitiveType(type, PrimitiveType.LONG)
                || isPrimitiveType(type, PrimitiveType.INT) || isPrimitiveType(type, PrimitiveType.SHORT)
                || isPrimitiveType(type, PrimitiveType.BYTE) || isPrimitiveType(type, PrimitiveType.CHAR))
        {
            return factory.makeMethodInvocationNode(
                    factory.makeVariableAccessNode(
                            factory.makeVariableAccessNode(
                                    factory.makeVariableAccessNode(factory.makeIdentifierNode("java")),
                                    factory.makeIdentifierNode("math")), factory.makeIdentifierNode("BigInteger")),
                    factory.makeIdentifierNode("valueOf"), factory.makeExpressionListNode(expr.deepCopy(factory)));
        }
        return null;

    }

    private MethodInvocationNode convertMethodInvocationExpression(MethodInvocationNode node)
    {
        if (node.getExpression() == null)
        {
            Collection<? extends InvokableNameBindingNode> invokableDecls = node.getMethodDeclarationsInScope(node.getIdentifier().getIdentifier());
            if (invokableDecls.size() != 1)
            {
                throw new NotImplementedYetException();
            }
            InvokableNameBindingNode invokableDecl = invokableDecls.iterator().next();
            if (invokableDecl instanceof MethodDeclarationNode)
            {
                boolean needsReplaced = false;
                MethodDeclarationNode methodDecl = (MethodDeclarationNode) invokableDecl;
                List<ExpressionNode> exprs = new ArrayList<ExpressionNode>();
                Iterator<VariableNode> varIt = methodDecl.getParameters().iterator();
                Iterator<ExpressionNode> argIt = node.getArguments().iterator();
                while (varIt.hasNext())
                {
                    VariableNode varDecl = varIt.next();
                    ExpressionNode arg = argIt.next();
                    if (isBigIntegerType(arg))
                    {
                        // Then no conversion work needs to be done regardless.
                        exprs.add(arg.deepCopy(factory));
                    } else
                    {
                        if (varDecl.getType() instanceof UnparameterizedTypeNode)
                        {
                            UnparameterizedTypeNode unparameterizedTypeNode = (UnparameterizedTypeNode) varDecl.getType();
                            // TODO: again, this is sloppy - need better metaprogramming tools
                            ExpressionNode expr;
                            if (unparameterizedTypeNode.getName().getNameString().equals("BigInteger")
                                    || unparameterizedTypeNode.getName().getNameString().equals("java.lang.BigInteger"))
                            {
                                expr = convertExpressionToBigInteger(arg);
                                if (expr == null)
                                {
                                    expr = arg.deepCopy(factory);
                                } else
                                {
                                    needsReplaced = true;
                                }
                            } else
                            {
                                expr = arg.deepCopy(factory);
                            }
                            exprs.add(expr);
                        }
                    }
                }
                while (argIt.hasNext())
                {
                    exprs.add(argIt.next().deepCopy(factory));
                }
                if (needsReplaced)
                {
                    return factory.makeMethodInvocationNode(node.getExpression() == null ? null
                            : node.getExpression().deepCopy(factory), node.getIdentifier().deepCopy(factory),
                            factory.makeExpressionListNode(exprs), node.getTypeArguments().deepCopy(factory));
                } else
                {
                    return null;
                }
            } else
            {
                // TODO
                return null;
            }
        } else
        {
            // TODO
            return null;
        }
    }

    /**
     * Determines if a given expression has type BigInteger.
     * 
     * @param expr The expression.
     * @return <code>true</code> if the type is BigInteger; <code>false</code> if it is not.
     */
    private boolean isBigIntegerType(ExpressionNode expr)
    {
        try
        {
            final BsjType type = typechecker.typecheck(expr).getType();
            return isBigIntegerType(type);
        } catch (TypecheckingException e)
        {
            return false;
        }
    }

    private boolean isBigIntegerType(BsjType type)
    {
        return isClassType(type, "java.math.BigInteger");
    }

    private boolean isClassType(BsjType type, String fullyQualifiedName)
    {
        if (type instanceof BsjDeclaredType)
        {
            final BsjDeclaredType declaredType = (BsjDeclaredType) type;
            final TypeNameBindingNode bindingNode = declaredType.asElement().getDeclarationNode();
            if (bindingNode instanceof ClassDeclarationNode)
            {
                final ClassDeclarationNode classDeclarationNode = (ClassDeclarationNode) bindingNode;
                if (classDeclarationNode.getFullyQualifiedName().equals(fullyQualifiedName))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPrimitiveType(BsjType type, PrimitiveType primitiveType)
    {
        if (type instanceof BsjPrimitiveType)
        {
            final BsjPrimitiveType pType = (BsjPrimitiveType) type;
            return pType.getPrimitiveType().equals(primitiveType);
        }
        return false;
    }
}
