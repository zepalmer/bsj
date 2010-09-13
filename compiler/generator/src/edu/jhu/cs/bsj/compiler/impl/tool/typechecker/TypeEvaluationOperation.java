package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.NoOperationDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.VariableNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ArrayTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ErrorTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.IntersectionTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NonePseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NullTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.PackagePseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.RawCodeLiteralRecord;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.SelectionTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypePseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypecheckerResult;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypecheckingMetadata;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.VoidPseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjActualType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjArrayType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjErrorType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNonePseudoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNullType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPackagePseudoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypePseudoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjVoidPseudoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.CastCompatibility;
import edu.jhu.cs.bsj.compiler.impl.utils.Bag;
import edu.jhu.cs.bsj.compiler.impl.utils.HashBag;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;

/**
 * This node operation calculates the type of the provided AST node. All AST nodes are considered to have a type as
 * modeled by the <tt>type</tt> subpackage. Expressions evaluate to the type of the expression as specified in the
 * <i>Java Language Specification, Third Edition</i>. All statements evaluate to a {@link BsjVoidPseudoType}. All other
 * nodes evaluate to {@link BsjNonePseudoType} which the exception of packages, which evaluate to
 * {@link BsjPackagePseudoType}. Any AST node which is not well formed (including statements, type declarations, and so
 * forth) will evaluate to a {@link BsjErrorType}.
 * 
 * @author Zachary Palmer
 */
public class TypeEvaluationOperation implements BsjNodeOperation<TypecheckerEnvironment, TypecheckerResult>
{
	/** The typechecker model managegr for this operation. */
	private TypecheckerManager manager;
	/** The parser to use when evaluating raw code literal types. */
	private BsjParser parser;

	public TypeEvaluationOperation(TypecheckerManager manager, BsjParser parser)
	{
		super();
		this.manager = manager;
		this.parser = parser;
	}

	/*
	 * TODO: handle rejection which comes as a result of lacking context (such as "<:x:>") differently This could be
	 * accomplished by creating a second operation. The second operation calls this operation for all requests. Whenever
	 * this operation returns an error type indicating failure due to insufficient context, however, the second
	 * operation would then perform a parse map operation and call this operation again. Only in the cae of a second
	 * failure would the second operation return the insufficient context error type. Note that this would require
	 * ensuring that this operation never calls executeOperation(this,...); it should instead accept an argument on
	 * construction indicating the "this" to use (to simulate proxy-like calls).
	 */

	/*
	 * TODO: this typechecker does not currently handle considerations of the distinction between variables and values
	 * (also often termed lvalues and rvalues, although variables and values are the terms used in the JLS). As a
	 * result, the expression "5 += 5" will typecheck; this is because int += int : int. In order to fix this, the
	 * typechecker should really return a tuple between a type and a set of type qualifiers. The only type qualifier
	 * that currently seems relevant is the variable/value flag. Most rules would ignore the qualifiers for a given
	 * evaluation and simply extract the type, but the qualifiers could be checked by rules such as assignment to ensure
	 * correct behavior.
	 */

	/*
	 * TODO: this typechecker does not explicitly handle accessibility in any way; this could lead to incorrect type
	 * checking if an accessible member and an inaccessible member are competing. For instance, if a class has two
	 * methods, public void foo(String s) and private void foo(Integer i), a caller from outside of the method should be
	 * able to call foo(null) and expect to bind to the String method rather than receive an ambiguity error. This
	 * implementation would be capable of handling accessibility considerations, but no such implementation has yet been
	 * completed due to time and resource constraints.
	 */

	/*
	 * TODO: currently, type nodes always typecheck to the BsjNoneType. We could overload this such that they type to
	 * the type that they name. Is this appropriate? If so, it would allow us to capture type nodes which name
	 * non-existent types. A similar concept could be applied to variable nodes and variable declaration nodes to ensure
	 * that they name existent types.
	 */

	/*
	 * TODO: this typechecker does not currently check the correctness of exception handling or statement labeling. An
	 * appropriate implementation would observe the types of exceptions which may be thrown by an expression and ensure
	 * that no disallowed checked exceptions are thrown. Those which are allowed would be stored in the typechecker
	 * environment. Additionally, such an implementation would use a similar technique to ensure that all labeled break
	 * and continue statements are breaking or continuing to valid labels.
	 */

	@Override
	public TypecheckerResult executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AlternateConstructorInvocationNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationAnnotationValueNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationArrayValueNode(AnnotationArrayValueNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationArrayValueNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationBodyNode(AnnotationBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationBodyNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationDeclarationNode(AnnotationDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationElementListNode(AnnotationElementListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeAnnotationElementNode(AnnotationElementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationElementNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationExpressionValueNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationListNode(AnnotationListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeAnnotationMemberListNode(AnnotationMemberListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationMemberMetaprogramAnchorNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationMethodDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node,
			TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeAnnotationModifiersNode(AnnotationModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeAnnotationValueListNode(AnnotationValueListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnnotationValueListNode.");
	}

	@Override
	public TypecheckerResult executeAnonymousClassBodyNode(AnonymousClassBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnonymousClassBodyNode.");
	}

	@Override
	public TypecheckerResult executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node,
			TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeAnonymousClassMemberMetaprogramAnchorNode(
			AnonymousClassMemberMetaprogramAnchorNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AnonymousClassMemberMetaprogramAnchorNode.");
	}

	@Override
	public TypecheckerResult executeArrayAccessNode(ArrayAccessNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		BsjType arrayExpressionType = executeComposingMetadata(node.getArrayExpression(), env, metadata);
		if (arrayExpressionType instanceof BsjErrorType)
		{
			return new TypecheckerResult(arrayExpressionType, metadata);
		}

		if (arrayExpressionType instanceof BsjArrayType)
		{
			BsjArrayType arrayType = (BsjArrayType) arrayExpressionType;
			BsjType indexExpressionType = executeComposingMetadata(node.getIndexExpression(), env, metadata);
			if (indexExpressionType instanceof BsjErrorType)
			{
				return new TypecheckerResult(indexExpressionType, metadata);
			}
			indexExpressionType = indexExpressionType.unboxConvert();
			if (indexExpressionType.isIntegralPrimitive())
			{
				indexExpressionType = indexExpressionType.numericTypePromotion();
			}
			if (!indexExpressionType.equals(this.manager.getToolkit().getIntType()))
			{
				// You can't index using anything that doesn't promote to an int
				// TODO: diagnostic
				return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
			}
			return new TypecheckerResult(arrayType.getComponentType().captureConvert(), metadata);
		} else
		{
			// You can't dereference a non-array type.
			// TODO: diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}
	}

	@Override
	public TypecheckerResult executeArrayInitializerCreationNode(ArrayInitializerCreationNode node,
			TypecheckerEnvironment env)
	{
		BsjType arrayType = this.manager.getToolkit().getTypeBuilder().makeType(node.getBaseType());
		for (int i = 0; i < node.getArrayLevels(); i++)
		{
			arrayType = new ArrayTypeImpl(this.manager, arrayType);
		}

		if (!arrayType.isReifiable())
		{
			// Cannot create an array of a non-reifiable type
			// TODO: raise diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), new TypecheckingMetadata());
		}

		TypecheckerEnvironment subEnv = env.deriveWithExpectedType(arrayType);
		return node.getInitializer().executeOperation(this, subEnv);
	}

	@Override
	public TypecheckerResult executeArrayInitializerNode(ArrayInitializerNode node, TypecheckerEnvironment env)
	{
		BsjType arrayType = env.getExpectedType();
		if (arrayType == null)
		{
			// Array initializer not expected here. This might happen in the following case:
			// int[] x = { { 1, 2 } };
			// The inner initializer is inappropriate because there is no viable expected component type.
			// TODO: raise diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), new TypecheckingMetadata());
		}

		// Begin checking the inner initializers
		BsjType componentType;
		if (arrayType instanceof BsjArrayType)
		{
			componentType = ((BsjArrayType) arrayType).getComponentType();
		} else
		{
			componentType = null;
		}
		TypecheckerEnvironment subEnv = env.deriveWithExpectedType(componentType);
		// Keep going even if we see an error
		BsjErrorType errorType = null;
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		for (VariableInitializerNode initializer : node.getInitializers())
		{
			TypecheckerResult initializerResult = initializer.executeOperation(this, subEnv);
			metadata.add(initializerResult.getMetadata());
			BsjType initializerType = initializerResult.getType();
			// If we couldn't type the initializer, don't generate a redundant error here
			if (initializerType instanceof BsjErrorType)
			{
				if (errorType != null)
				{
					errorType = (BsjErrorType) initializerType;
				}
				continue;
			}
			if (!initializerType.isAssignmentCompatibleWith(componentType))
			{
				// This expression can't go in the initializer
				// TODO: raise diagnostic
				if (errorType != null)
				{
					errorType = new ErrorTypeImpl(this.manager);
				}
			}
		}
		return new TypecheckerResult(errorType != null ? errorType : arrayType, metadata);
	}

	@Override
	public TypecheckerResult executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node,
			TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		BsjErrorType errorType = null;
		for (ExpressionNode expr : node.getDimExpressions())
		{
			BsjType exprType = executeComposingMetadata(expr, env, metadata);
			if (exprType instanceof BsjErrorType && errorType == null)
			{
				errorType = (BsjErrorType) exprType;
			} else
			{

				exprType = exprType.unboxConvert();
				exprType = exprType.numericTypePromotion();
				if (!this.manager.getToolkit().getIntType().equals(exprType))
				{
					// TODO: produce a diagnostic
					if (errorType == null)
					{
						errorType = new ErrorTypeImpl(this.manager);
					}
				}
			}
		}
		if (errorType != null)
		{
			return new TypecheckerResult(errorType, metadata);
		}

		BsjType baseType = this.manager.getToolkit().getTypeBuilder().makeType(node.getBaseType());
		for (int i = 0; i < node.getArrayLevels() + node.getDimExpressions().size(); i++)
		{
			baseType = new ArrayTypeImpl(this.manager, baseType);
		}
		return new TypecheckerResult(baseType, metadata);
	}

	@Override
	public TypecheckerResult executeArrayTypeNode(ArrayTypeNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeAssertStatementNode(AssertStatementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled AssertStatementNode.");
	}

	@Override
	public TypecheckerResult executeAssignmentNode(AssignmentNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		BsjType variableType = executeComposingMetadata(node.getVariable(), env, metadata);
		if (variableType instanceof BsjErrorType)
			return new TypecheckerResult(variableType, metadata);

		BsjType expressionType = executeComposingMetadata(node.getExpression(), env, metadata);
		if (expressionType instanceof BsjErrorType)
			return new TypecheckerResult(expressionType, metadata);

		AssignmentOperator assignmentOperator = node.getOperator();
		BinaryOperator binaryOperator = assignmentOperator.getBinaryOperator();

		if (binaryOperator != null)
		{
			expressionType = determineBinaryExpressionType(variableType, expressionType, binaryOperator);
		}

		if (!expressionType.isAssignmentCompatibleWith(variableType))
		{
			// The assignment is illegal due to a typing error.
			// TODO: raise a diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		return new TypecheckerResult(variableType.captureConvert(), metadata);
	}

	@Override
	public TypecheckerResult executeBinaryExpressionNode(BinaryExpressionNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		BsjType leftType = executeComposingMetadata(node.getLeftOperand(), env, metadata);
		if (leftType instanceof BsjErrorType)
			return new TypecheckerResult(leftType, metadata);

		BsjType rightType = executeComposingMetadata(node.getRightOperand(), env, metadata);
		if (rightType instanceof BsjErrorType)
			return new TypecheckerResult(rightType, metadata);

		BinaryOperator operator = node.getOperator();

		return new TypecheckerResult(determineBinaryExpressionType(leftType, rightType, operator), metadata);
	}

	@Override
	public TypecheckerResult executeBlockNode(BlockNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getMetaAnnotations(), node.getStatements());
	}

	@Override
	public TypecheckerResult executeBlockStatementListNode(BlockStatementListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildren());
	}

	@Override
	public TypecheckerResult executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled BlockStatementMetaprogramAnchorNode.");
	}

	@Override
	public TypecheckerResult executeBooleanLiteralNode(BooleanLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(this.manager.getToolkit().getBooleanType(), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeBreakNode(BreakNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new VoidPseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeCaseListNode(CaseListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled CaseListNode.");
	}

	@Override
	public TypecheckerResult executeCaseNode(CaseNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled CaseNode.");
	}

	@Override
	public TypecheckerResult executeCatchListNode(CatchListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildren());
	}

	@Override
	public TypecheckerResult executeCatchNode(CatchNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled CatchNode.");
	}

	@Override
	public TypecheckerResult executeCharLiteralNode(CharLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(this.manager.getToolkit().getCharType(), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeClassBodyNode(ClassBodyNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildIterable());
	}

	@Override
	public TypecheckerResult executeClassDeclarationNode(ClassDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO: validate the extends clause, implements clause, etc.
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildIterable());
	}

	@Override
	public TypecheckerResult executeClassLiteralNode(ClassLiteralNode node, TypecheckerEnvironment env)
	{
		BsjType argumentType = this.manager.getToolkit().getTypeBuilder().makeType(node.getValue());
		BsjTypeArgument boxedType = argumentType.boxConvert();
		if (argumentType instanceof BsjTypeVariable)
		{
			// This is illegal; it is impossible to obtain a type parameter's class by use of T.class
			// TODO: diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), new TypecheckingMetadata());
		}
		BsjType ret = this.manager.getTypeFactory().makeExplicitlyDeclaredType(
				this.manager.getToolkit().getClassElement(), Collections.singletonList(boxedType), null);
		return new TypecheckerResult(ret, new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeClassMemberListNode(ClassMemberListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ClassMemberMetaprogramAnchorNode.");
	}

	@Override
	public TypecheckerResult executeClassModifiersNode(ClassModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeCodeLiteralNode(CodeLiteralNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled CodeLiteralNode.");
	}

	@Override
	public TypecheckerResult executeCompilationUnitNode(CompilationUnitNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildIterable());
	}

	@Override
	public TypecheckerResult executeConditionalExpressionNode(ConditionalExpressionNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		TypecheckerResult conditionResult = node.getCondition().executeOperation(this, env);
		metadata.add(conditionResult.getMetadata());
		BsjType conditionType = conditionResult.getType();
		if (conditionType instanceof BsjErrorType)
		{
			return new TypecheckerResult(conditionType, metadata);
		}

		TypecheckerResult thenResult = node.getTrueExpression().executeOperation(this, env);
		metadata.add(thenResult.getMetadata());
		BsjType thenType = thenResult.getType();
		if (thenType instanceof BsjErrorType)
		{
			return new TypecheckerResult(thenType, metadata);
		}

		TypecheckerResult elseResult = node.getFalseExpression().executeOperation(this, env);
		metadata.add(elseResult.getMetadata());
		BsjType elseType = elseResult.getType();
		if (elseType instanceof BsjErrorType)
		{
			return new TypecheckerResult(elseType, metadata);
		}

		// Condition must be a boolean
		if (!conditionType.equals(this.manager.getToolkit().getBooleanType())
				&& !conditionType.equals(this.manager.getToolkit().getBooleanWrapperType()))
		{
			// TODO: diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		// If the then type matches the else type, return that type
		if (thenType.equals(elseType))
		{
			return new TypecheckerResult(thenType, metadata);
		}

		// If both types are convertable to boolean, the type is boolean
		if (thenType.unboxConvert().equals(this.manager.getToolkit().getBooleanType())
				&& elseType.unboxConvert().equals(this.manager.getToolkit().getBooleanType()))
		{
			return new TypecheckerResult(this.manager.getToolkit().getBooleanType(), metadata);
		}

		// If one type is the null type and another type is the reference type, use the reference type.
		if (thenType instanceof BsjNullType && elseType instanceof BsjReferenceType)
		{
			return new TypecheckerResult(elseType, metadata);
		} else if (elseType instanceof BsjNullType && thenType instanceof BsjReferenceType)
		{
			return new TypecheckerResult(thenType, metadata);
		}

		// If both types are convertible to numeric types...
		BsjType numericThenType = thenType.unboxConvert();
		BsjType numericElseType = elseType.unboxConvert();
		if (numericThenType.isNumericPrimitive() && numericElseType.isNumericPrimitive())
		{
			PrimitiveType primitiveThenType = ((BsjPrimitiveType) numericThenType).getPrimitiveType();
			PrimitiveType primitiveElseType = ((BsjPrimitiveType) numericElseType).getPrimitiveType();

			// If one type is byte and the other is short, the result type is short
			if ((primitiveThenType == PrimitiveType.BYTE && primitiveElseType == PrimitiveType.SHORT)
					|| (primitiveThenType == PrimitiveType.SHORT && primitiveElseType == PrimitiveType.BYTE))
			{
				return new TypecheckerResult(this.manager.getToolkit().getShortType(), metadata);
			}

			// TODO: if one type is byte, short, or char and the other type is an int which is representable as the
			// other type, then the result type is the smaller primitive type

			// Otherwise, the type is the result of binary numeric promotion.
			return new TypecheckerResult(binaryNumericTypePromotion(thenType, elseType), metadata);
		}

		// Otherwise, the type is the result of applying capture conversion to the least upper bound of the boxed
		// version of both types. Calculation of the least upper bound is defined as part of type argument inference
		// in JLSv3 §15.12.2.7.
		throw new NotImplementedYetException();
	}

	@Override
	public TypecheckerResult executeConstantDeclarationNode(ConstantDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO: this is not actually this simple; there are interesting rules defining when constants may or
		// may not be used and in what order in the intializers of other constants (JLSv3 §9.3.1).
		return handleVariableDeclaratorOwnerNode(node, new NonePseudoTypeImpl(this.manager), env);
	}

	@Override
	public TypecheckerResult executeConstantModifiersNode(ConstantModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeConstructorBodyNode(ConstructorBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ConstructorBodyNode.");
	}

	@Override
	public TypecheckerResult executeConstructorDeclarationNode(ConstructorDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ConstructorDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeConstructorModifiersNode(ConstructorModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeContinueNode(ContinueNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new VoidPseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeDeclaredTypeListNode(DeclaredTypeListNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeDoWhileLoopNode(DoWhileLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled DoWhileLoopNode.");
	}

	@Override
	public TypecheckerResult executeDoubleLiteralNode(DoubleLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(this.manager.getToolkit().getDoubleType(), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeEnhancedForLoopNode(EnhancedForLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled EnhancedForLoopNode.");
	}

	@Override
	public TypecheckerResult executeEnumBodyNode(EnumBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled EnumBodyNode.");
	}

	@Override
	public TypecheckerResult executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node,
			TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled EnumConstantDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeEnumConstantModifiersNode(EnumConstantModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeEnumDeclarationNode(EnumDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled EnumDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeEnumModifiersNode(EnumModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeExpressionListNode(ExpressionListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ExpressionListNode.");
	}

	@Override
	public TypecheckerResult executeExpressionStatementNode(ExpressionStatementNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildIterable());
	}

	@Override
	public TypecheckerResult executeFieldDeclarationNode(FieldDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO: this is not actually this simple; there are interesting rules defining when static fields may or
		// may not be used and in what order in the intializers of other static fields (JLSv3 §8.3.2.3).
		return handleVariableDeclaratorOwnerNode(node, new NonePseudoTypeImpl(this.manager), env);
	}

	@Override
	public TypecheckerResult executeFieldModifiersNode(FieldModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeFloatLiteralNode(FloatLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(this.manager.getToolkit().getFloatType(), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeForInitializerDeclarationNode(ForInitializerDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ForInitializerDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeForInitializerExpressionNode(ForInitializerExpressionNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ForInitializerExpressionNode.");
	}

	@Override
	public TypecheckerResult executeForLoopNode(ForLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ForLoopNode.");
	}

	@Override
	public TypecheckerResult executeIdentifierListNode(IdentifierListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeIdentifierNode(IdentifierNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeIfNode(IfNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled IfNode.");
	}

	@Override
	public TypecheckerResult executeImportListNode(ImportListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeImportOnDemandNode(ImportOnDemandNode node, TypecheckerEnvironment env)
	{
		// TODO: should we somehow validate that the package contains something to import?
		// If we do, it could ask for too much information and cause calling metaprograms to conflict.
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeImportSingleTypeNode(ImportSingleTypeNode node, TypecheckerEnvironment env)
	{
		// Validate that the named type exists.
		Collection<? extends Node> declarations = node.getDeclarationsInScope(node.getName());
		BsjType resultType;
		if (declarations.size() == 1 && declarations.iterator().next() instanceof NamedTypeDeclarationNode<?>)
		{
			resultType = new NonePseudoTypeImpl(this.manager);
		} else
		{
			resultType = new ErrorTypeImpl(this.manager);
		}
		return new TypecheckerResult(resultType, new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeInitializerDeclarationNode(InitializerDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled InitializerDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeInstanceOfNode(InstanceOfNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		BsjType expressionType = executeComposingMetadata(node.getExpression(), env, metadata);
		if (!(expressionType instanceof BsjReferenceType))
		{
			// TODO: report diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		BsjType checkType = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());
		if (!(checkType instanceof BsjReferenceType))
		{
			// TODO: report diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}
		if (!checkType.isReifiable())
		{
			// TODO: report diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		// Note: we don't have to worry about compatible-with-warning scenarios here because the type must be
		// reifiable
		if (expressionType.isCastCompatible(checkType) == CastCompatibility.INCOMPATIBLE)
		{
			// TODO: report diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		return new TypecheckerResult(this.manager.getToolkit().getBooleanType(), metadata);
	}

	@Override
	public TypecheckerResult executeIntLiteralNode(IntLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(this.manager.getToolkit().getIntType(), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeInterfaceBodyNode(InterfaceBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled InterfaceBodyNode.");
	}

	@Override
	public TypecheckerResult executeInterfaceDeclarationNode(InterfaceDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled InterfaceDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeInterfaceMemberListNode(InterfaceMemberListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled InterfaceMemberMetaprogramAnchorNode.");
	}

	@Override
	public TypecheckerResult executeInterfaceModifiersNode(InterfaceModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeJavadocNode(JavadocNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeLabeledStatementNode(LabeledStatementNode node, TypecheckerEnvironment env)
	{
		return node.getStatement().executeOperation(this, env);
	}

	@Override
	public TypecheckerResult executeLocalClassDeclarationNode(LocalClassDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled LocalClassDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeLocalClassModifiersNode(LocalClassModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node,
			TypecheckerEnvironment env)
	{
		return handleVariableDeclaratorOwnerNode(node, new VoidPseudoTypeImpl(this.manager), env);
	}

	@Override
	public TypecheckerResult executeLongLiteralNode(LongLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(this.manager.getToolkit().getLongType(), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaAnnotationArrayValueNode.");
	}

	@Override
	public TypecheckerResult executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node,
			TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeMetaAnnotationElementNode(MetaAnnotationElementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaAnnotationElementNode.");
	}

	@Override
	public TypecheckerResult executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaAnnotationExpressionValueNode.");
	}

	@Override
	public TypecheckerResult executeMetaAnnotationListNode(MetaAnnotationListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaAnnotationMetaAnnotationValueNode.");
	}

	@Override
	public TypecheckerResult executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaAnnotationMetaprogramAnchorNode.");
	}

	@Override
	public TypecheckerResult executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaAnnotationValueListNode.");
	}

	@Override
	public TypecheckerResult executeMetaprogramDependencyDeclarationListNode(
			MetaprogramDependencyDeclarationListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildren());
	}

	@Override
	public TypecheckerResult executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaprogramDependencyDeclarationNode.");
	}

	@Override
	public TypecheckerResult executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node,
			TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildren());
	}

	@Override
	public TypecheckerResult executeMetaprogramDependencyNode(MetaprogramDependencyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaprogramDependencyNode.");
	}

	@Override
	public TypecheckerResult executeMetaprogramImportListNode(MetaprogramImportListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeMetaprogramImportNode(MetaprogramImportNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaprogramImportNode.");
	}

	@Override
	public TypecheckerResult executeMetaprogramNode(MetaprogramNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaprogramNode.");
	}

	@Override
	public TypecheckerResult executeMetaprogramPreambleNode(MetaprogramPreambleNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaprogramPreambleNode.");
	}

	@Override
	public TypecheckerResult executeMetaprogramTargetListNode(MetaprogramTargetListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildren());
	}

	@Override
	public TypecheckerResult executeMetaprogramTargetNode(MetaprogramTargetNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled MetaprogramTargetNode.");
	}

	@Override
	public TypecheckerResult executeMethodDeclarationNode(MethodDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO: validate return type, throws types, etc. 
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildIterable());
	}

	@Override
	public TypecheckerResult executeMethodInvocationNode(MethodInvocationNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		// Evaluate the type of each of the arguments in the call
		List<BsjType> argumentTypes = new ArrayList<BsjType>();
		BsjErrorType errorType = null;
		for (ExpressionNode expr : node.getArguments())
		{
			BsjType argumentType = executeComposingMetadata(expr, env, metadata);
			if (argumentType instanceof BsjErrorType)
			{
				// TODO: raise a diagnostic
				if (errorType == null)
				{
					errorType = (BsjErrorType) argumentType;
				}
			}
			argumentTypes.add(argumentType);
		}

		// §15.12.1: determine class or interface to search
		BsjExplicitlyDeclaredType searchType;
		if (node.getExpression() == null)
		{
			// Just an identifier; use the enclosing type.
			searchType = this.manager.getToolkit().makeElement(
					node.getNearestAncestorOfType(NamedTypeDeclarationNode.class)).asType();
		} else
		{
			// Establish the type of the qualifying expression and use that class.
			BsjType qualifyingType = executeComposingMetadata(node.getExpression(), env, metadata);
			while (qualifyingType instanceof BsjTypeVariable)
			{
				qualifyingType = ((BsjTypeVariable) qualifyingType).getUpperBound();
			}
			if (qualifyingType instanceof BsjExplicitlyDeclaredType)
			{
				searchType = (BsjExplicitlyDeclaredType) qualifyingType;
			} else if (qualifyingType instanceof BsjTypePseudoType)
			{
				searchType = this.manager.getToolkit().makeElement(
						((BsjTypePseudoType) qualifyingType).getDeclaration()).asType();
			} else if (qualifyingType instanceof BsjPackagePseudoType)
			{
				// TODO: diagnostic
				return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
			} else if (qualifyingType instanceof BsjVoidPseudoType || qualifyingType instanceof BsjNullType
					|| qualifyingType instanceof BsjArrayType || qualifyingType instanceof BsjPrimitiveType)
			{
				// Cannot dereference this type for a method invocation
				// TODO: diagnostic
				return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
			} else
			{
				throw new IllegalStateException("Don't know how to handle method qualification expression of type "
						+ qualifyingType);
			}
		}

		// §15.12.2: determine method signature

		// §15.12.2.1: determine potentially applicable methods
		Collection<? extends BsjExecutableType> potentiallyApplicableMethods = searchType.getExecutableTypesOfName(node.getIdentifier().getIdentifier());
		Iterator<? extends BsjExecutableType> methodIterator = potentiallyApplicableMethods.iterator();
		while (methodIterator.hasNext())
		{
			BsjExecutableType type = methodIterator.next();

			boolean applicable = true;

			// Must be accessible
			// TODO

			// Arity must be less than or equal to the arity of the invocation
			if (type.getParameterTypes().size() > node.getArguments().size())
			{
				applicable = false;
			}

			// If this is a varargs method with arity n, the arity of the call must be n-1 or greater
			if (type.isVarargs() && type.getParameterTypes().size() - 1 > node.getArguments().size())
			{
				applicable = false;
			}

			// If this is not a varargs method, the arity of the method must match the arity of the call
			if (!type.isVarargs() && type.getParameterTypes().size() != node.getArguments().size())
			{
				applicable = false;
			}

			// If the call includes type arguments and the method declares type parameters, their lengths must match
			// Note that this *does* mean that method calls providing generic type arguments can be made against
			// methods
			// which do not have type arguments; this is in accordance with JLSv3 §15.12.2.1.
			if (type.getTypeVariables().size() > 0 && node.getTypeArguments().size() > 0
					&& type.getTypeVariables().size() != node.getTypeArguments().size())
			{
				applicable = false;
			}

			if (!applicable)
				methodIterator.remove();
		}

		if (potentiallyApplicableMethods.size() == 0)
		{
			// TODO: raise a diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		// For each potentially applicable method, generate its type variable substitution map and effective
		// parameter
		// types.
		Map<BsjExecutableType, GenericMethodData> genericMethodDataMap = extractGenericMethodData(node,
				potentiallyApplicableMethods);

		// §15.12.2.2: Identify matching arity methods applicable by subtyping.
		Set<BsjExecutableType> applicableMethods;
		applicableMethods = identifyMatchingArityMethods(node, argumentTypes, potentiallyApplicableMethods,
				genericMethodDataMap, false);

		// If we have found at least one applicable method, we can carry on at this point. Otherwise, we must try
		// again with method invocation conversion.
		if (applicableMethods.size() == 0)
		{
			// §15.12.2.3: Identify matching arity methods applicable by the method invocation conversion.
			applicableMethods = identifyMatchingArityMethods(node, argumentTypes, potentiallyApplicableMethods,
					genericMethodDataMap, true);
		}

		// If we still haven't found at least one applicable method, we must now try the last option: varargs.
		if (applicableMethods.size() == 0)
		{
			// §15.12.2.4: Identify applicable variable arity methods.
			throw new NotImplementedYetException();
		}

		if (applicableMethods.size() == 0)
		{
			// No methods are applicable for these arguments
			// TODO: raise diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		// §15.12.2.5: Determine the most specific method from those which are applicable
		BsjExecutableType mostSpecificMethod = null;
		outer: for (BsjExecutableType candidateMethod : applicableMethods)
		{
			for (BsjExecutableType competitorMethod : applicableMethods)
			{
				if (!isMoreSpecific(candidateMethod, competitorMethod))
				{
					break outer;
				}
			}
			mostSpecificMethod = candidateMethod;
			break;
		}

		if (mostSpecificMethod == null)
		{
			// Then there is no single most specific method to invoke.
			// TODO: raise diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		// §15.12.2.6: Determine method return and throws types
		BsjType returnType = mostSpecificMethod.getReturnType();
		// TODO: if an unchecked conversion was necessary for applicability, then the return type should be erased
		returnType = returnType.performTypeSubstitution(genericMethodDataMap.get(mostSpecificMethod).getSubstitutionMap());
		returnType = returnType.captureConvert();

		// §15.12.2.13: Is the chosen method appropriate?
		// TODO: depending on the form of the method used, a compile-time error may be appropriate
		// * If the invocation is made in a static context and the method is not static, we should fail.
		// * If the invocation was made using a type name, it must be static.
		// * If the invocation was made using the keyword super, the method must not be abstract.
		// * If the invocation was made using a qualified keyword super, the method invocation must be enclosed by
		// the
		// specified class.

		// Finished!
		return new TypecheckerResult(returnType, metadata);
	}

	@Override
	public TypecheckerResult executeMethodModifiersNode(MethodModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeNoOperationNode(NoOperationNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new VoidPseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeNormalAnnotationNode(NormalAnnotationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled NormalAnnotationNode.");
	}

	@Override
	public TypecheckerResult executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled NormalMetaAnnotationNode.");
	}

	@Override
	public TypecheckerResult executeNullLiteralNode(NullLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NullTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executePackageDeclarationNode(PackageDeclarationNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getAnnotations(),
				node.getMetaAnnotations(), node.getName());
	}

	@Override
	public TypecheckerResult executePackageNode(PackageNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new PackagePseudoTypeImpl(this.manager, node), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeParameterizedTypeNode(ParameterizedTypeNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node,
			TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeParenthesizedExpressionNode(ParenthesizedExpressionNode node,
			TypecheckerEnvironment env)
	{
		return node.getExpression().executeOperation(this, env);
	}

	@Override
	public TypecheckerResult executePrimitiveTypeNode(PrimitiveTypeNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled QualifiedClassInstantiationNode.");
	}

	@Override
	public TypecheckerResult executeQualifiedNameNode(QualifiedNameNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeRawCodeLiteralNode(RawCodeLiteralNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		// TODO: perform these parsing operations lazily; create a specialized type which will only evaluate these
		// parse values on demand

		Map<BsjType, Node> typeToValueMap = new HashMap<BsjType, Node>();
		Set<Node> inContextValues = new HashSet<Node>();

		Bag<BsjActualType> componentTypes = new HashBag<BsjActualType>();
		for (ParseRule<?> rule : ParseRule.values())
		{
			CountingDiagnosticProxyListener<BsjSourceLocation> listener = new CountingDiagnosticProxyListener<BsjSourceLocation>(
					new NoOperationDiagnosticListener<BsjSourceLocation>());
			Node result = this.parser.parse(node.getValue(), rule, listener);
			if (listener.getCount(Kind.ERROR) > 0)
			{
				// TODO: perhaps preserve these diagnostics for use later?
				continue;
			}

			// Establish component type
			List<BsjTypeArgument> baseTypes = new ArrayList<BsjTypeArgument>();
			for (Class<?> clazz : rule.getBottomMostClasses())
			{
				BsjType type = this.manager.getToolkit().getTypeBuilder().makeMetaprogramClasspathType(clazz);
				if (type instanceof BsjTypeArgument)
				{
					baseTypes.add((BsjTypeArgument) type);
				} else
				{
					throw new IllegalStateException("Code literal bottom-most type is not usable as a type argument: "
							+ clazz);
				}
			}
			BsjTypeArgument resultType = codeLiteralTypeReduction(
					this.manager.getToolkit().getTypeBuilder().makeMetaprogramClasspathType(result.getClass()),
					baseTypes);
			componentTypes.add(resultType);

			// Aggregate data for the raw code literal record
			typeToValueMap.put(resultType, result);
			if (env.getExpectedType() == null || env.getExpectedType().isSupertypeOf(resultType))
			{
				inContextValues.add(result);
			}
		}

		metadata.addRawCodeLiteralRecord(node,
				new RawCodeLiteralRecord(typeToValueMap, inContextValues, env.getExpectedType()));

		return new TypecheckerResult(new SelectionTypeImpl(this.manager, componentTypes), metadata);
	}

	@Override
	public TypecheckerResult executeReferenceTypeListNode(ReferenceTypeListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeReturnNode(ReturnNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ReturnNode.");
	}

	@Override
	public TypecheckerResult executeSimpleNameNode(SimpleNameNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeSingleElementAnnotationNode(SingleElementAnnotationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled SingleElementAnnotationNode.");
	}

	@Override
	public TypecheckerResult executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled SingleElementMetaAnnotationNode.");
	}

	@Override
	public TypecheckerResult executeSingleStaticImportNode(SingleStaticImportNode node, TypecheckerEnvironment env)
	{
		// TODO: Validate that the named type exists.
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeStatementExpressionListNode(StatementExpressionListNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled StatementExpressionListNode.");
	}

	@Override
	public TypecheckerResult executeStaticImportOnDemandNode(StaticImportOnDemandNode node, TypecheckerEnvironment env)
	{
		// Validate that the named type exists.
		Collection<? extends Node> declarations = node.getDeclarationsInScope(node.getName());
		BsjType resultType;
		if (declarations.size() == 1 && declarations.iterator().next() instanceof NamedTypeDeclarationNode<?>)
		{
			resultType = new NonePseudoTypeImpl(this.manager);
		} else
		{
			resultType = new ErrorTypeImpl(this.manager);
		}
		return new TypecheckerResult(resultType, new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeStringLiteralNode(StringLiteralNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(this.manager.getToolkit().getStringElement().asType(), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeSuperFieldAccessNode(SuperFieldAccessNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled SuperFieldAccessNode.");
	}

	@Override
	public TypecheckerResult executeSuperMethodInvocationNode(SuperMethodInvocationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled SuperMethodInvocationNode.");
	}

	@Override
	public TypecheckerResult executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled SuperclassConstructorInvocationNode.");
	}

	@Override
	public TypecheckerResult executeSwitchNode(SwitchNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled SwitchNode.");
	}

	@Override
	public TypecheckerResult executeSynchronizedNode(SynchronizedNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled SynchronizedNode.");
	}

	@Override
	public TypecheckerResult executeThisNode(ThisNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		// Ensure that the named type is not a type parameter
		BsjExplicitlyDeclaredType qualifyingType = null;
		if (node.getType() != null)
		{
			BsjNamedReferenceType type = this.manager.getToolkit().getTypeBuilder().makeUnparameterizedType(
					node.getType());
			if (!(type instanceof BsjExplicitlyDeclaredType))
			{
				// It's illegal to name a type parameter such as in "T.this"
				// TODO: diagnostic
				return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
			}
			qualifyingType = (BsjExplicitlyDeclaredType) type;
		}

		// Determine if 'this' is used in a static context
		// TODO: this should really be handed to us by the typechecking environment, not calculated here
		// TODO: also, calculate lexically-enclosing classes in the typechecking environment
		Node ancestor = node;
		boolean validUsage = false;
		while (ancestor != null && !(ancestor instanceof NamedTypeDeclarationNode<?>))
		{
			if (ancestor instanceof FieldDeclarationNode)
			{
				FieldDeclarationNode fieldDeclarationNode = (FieldDeclarationNode) ancestor;
				if (!fieldDeclarationNode.getModifiers().getStaticFlag())
				{
					validUsage = true;
				}
			} else if (ancestor instanceof MethodDeclarationNode)
			{
				MethodDeclarationNode methodDeclarationNode = (MethodDeclarationNode) ancestor;
				if (!methodDeclarationNode.getModifiers().getStaticFlag())
				{
					validUsage = true;
				}
			} else if (ancestor instanceof ConstructorDeclarationNode)
			{
				validUsage = true;
			} else if (ancestor instanceof InitializerDeclarationNode)
			{
				InitializerDeclarationNode initializerDeclarationNode = (InitializerDeclarationNode) ancestor;
				if (!initializerDeclarationNode.getStaticInitializer())
				{
					validUsage = true;
				}
			}

			ancestor = ancestor.getParent();
		}

		if (!validUsage)
		{
			// TODO: diagnostic - cannot use keyword 'this' in a static context
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		// Look for the matching qualifier - a this keyword with no qualifier always matches
		while (ancestor != null && !(ancestor instanceof CompilationUnitNode))
		{
			boolean match;
			if (qualifyingType == null)
			{
				match = true;
			} else
			{
				match = qualifyingType.asElement().getDeclarationNode().equals(ancestor);
			}

			if (match)
			{
				if (ancestor instanceof NamedTypeDeclarationNode<?>)
				{
					return new TypecheckerResult(this.manager.getToolkit().makeElement(ancestor).asType(), metadata);
				} else
				{
					throw new IllegalStateException("Unrecognized ancestor type of 'this' keyword: "
							+ ancestor.getClass());
				}
			}
			ancestor = ancestor.getNearestAncestorOfTypes(new TwoElementImmutableSet<Class<? extends Node>>(
					NamedTypeDeclarationNode.class, CompilationUnitNode.class));
		}

		if (ancestor == null)
		{
			throw new IllegalStateException("Cannot type 'this' node; not fully connected to its surrounding type");
		} else
		{
			// TODO: diagnostic - no enclosing class is named by the qualifier
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}
	}

	@Override
	public TypecheckerResult executeThrowNode(ThrowNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled ThrowNode.");
	}

	@Override
	public TypecheckerResult executeTryNode(TryNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled TryNode.");
	}

	@Override
	public TypecheckerResult executeTypeArgumentListNode(TypeArgumentListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled TypeArgumentListNode.");
	}

	@Override
	public TypecheckerResult executeTypeCastNode(TypeCastNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		BsjType expressionType = executeComposingMetadata(node.getExpression(), env, metadata);
		if (expressionType instanceof BsjErrorType)
			return new TypecheckerResult(expressionType, metadata);

		BsjType castType = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());

		CastCompatibility castCompatibility = expressionType.isCastCompatible(castType);
		if (castCompatibility == CastCompatibility.INCOMPATIBLE)
		{
			// TODO: report diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}
		if (castCompatibility == CastCompatibility.COMPATIBLE_WITH_WARNING)
		{
			// TODO: report warning
		}
		return new TypecheckerResult(castType.captureConvert(), metadata);
	}

	@Override
	public TypecheckerResult executeTypeDeclarationListNode(TypeDeclarationListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled TypeDeclarationMetaprogramAnchorNode.");
	}

	@Override
	public TypecheckerResult executeTypeParameterListNode(TypeParameterListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeTypeParameterNode(TypeParameterNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled TypeParameterNode.");
	}

	@Override
	public TypecheckerResult executeUnaryExpressionNode(UnaryExpressionNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		BsjType type = executeComposingMetadata(node.getExpression(), env, metadata);
		if (type instanceof BsjErrorType)
			return new TypecheckerResult(type, metadata);

		switch (node.getOperator())
		{
			case BITWISE_COMPLEMENT:
				type = type.unboxConvert();
				if (!type.isIntegralPrimitive())
				{
					// TODO: diagnostic
					return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
				} else
				{
					return new TypecheckerResult(type.numericTypePromotion(), metadata);
				}
			case LOGICAL_COMPLEMENT:
				type = type.unboxConvert();
				if (type.equals(this.manager.getToolkit().getBooleanType()))
				{
					return new TypecheckerResult(type, metadata);
				} else
				{
					// TODO: diagnostic
					return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
				}
			case UNARY_MINUS:
			case UNARY_PLUS:
				BsjPrimitiveType primitiveType = type.numericTypePromotion();
				if (primitiveType == null)
				{
					// TODO: diagnostic
					return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
				} else
				{
					return new TypecheckerResult(primitiveType, metadata);
				}
			default:
				throw new IllegalStateException("Unrecognized unary expression operator");
		}
	}

	@Override
	public TypecheckerResult executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node,
			TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		// All unary statement expressions are numeric in nature (pre- and postfix increment and decrement). If the
		// expression has a numeric type, it preserves that type. Otherwise, the expression has an error type.
		BsjType expressionType = executeComposingMetadata(node.getExpression(), env, metadata);
		if (expressionType instanceof BsjErrorType)
			return new TypecheckerResult(expressionType, metadata);

		expressionType = expressionType.unboxConvert();
		if (expressionType.isNumericPrimitive())
		{
			return new TypecheckerResult(expressionType, metadata);
		} else
		{
			// TODO: raise a diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}
	}

	@Override
	public TypecheckerResult executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node,
			TypecheckerEnvironment env)
	{
		return expectNoError(env, new NonePseudoTypeImpl(this.manager), node.getChildren());
	}

	@Override
	public TypecheckerResult executeUnparameterizedTypeNode(UnparameterizedTypeNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node,
			TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		// Determine the type being instantiated.
		BsjNamedReferenceType targetType = this.manager.getToolkit().getTypeBuilder().makeDeclaredType(node.getType());
		if (targetType instanceof BsjTypeVariable)
		{
			// This is an error; it is illegal to attempt to instantiate a type variable.
			// TODO: diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		} else if (!(targetType instanceof BsjExplicitlyDeclaredType))
		{
			throw new IllegalStateException("Unrecognized BsjNamedReferenceType: " + targetType.getClass());
		}

		BsjExplicitlyDeclaredType instantiationType = (BsjExplicitlyDeclaredType) targetType;

		// Ensure that none of the constructor type arguments are wildcard types.
		for (TypeArgumentNode typeArgumentNode : node.getConstructorTypeArguments())
		{
			if (typeArgumentNode instanceof WildcardTypeNode)
			{
				// TODO: diagnostic
				return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
			}
		}

		// Ensure that none of the instantiation type arguments are wildcard types.
		for (BsjTypeArgument typeArgument : instantiationType.getTypeArguments())
		{
			if (typeArgument instanceof BsjWildcardType)
			{
				// TODO: diagnostic
				return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
			}
		}

		// Ensure that we are not attempting to instantiate an enum type
		if (instantiationType.asElement().getDeclarationNode() instanceof EnumDeclarationNode)
		{
			// TODO: diagnostic
			return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
		}

		// If we are instantiating an anonymous inner class, then the base type must be non-final. Otherwise, the
		// base type must be a non-abstract class.
		NamedTypeDeclarationNode<?> namedTypeDeclarationNode = instantiationType.asElement().getDeclarationNode();
		if (node.getBody() != null)
		{
			if (namedTypeDeclarationNode instanceof ClassDeclarationNode)
			{
				if (((ClassDeclarationNode) namedTypeDeclarationNode).getModifiers().getFinalFlag())
				{
					// Cannot extend a final type
					// TODO: diagnostic
					return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
				}
			}
		} else
		{
			if (namedTypeDeclarationNode instanceof ClassDeclarationNode)
			{
				if (((ClassDeclarationNode) namedTypeDeclarationNode).getModifiers().getAbstractFlag())
				{
					// Cannot instantiate an abstract type
					// TODO: diagnostic
					return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
				}
			} else
			{
				// Cannot instantiate a non-class type
				// TODO: diagnostic
				return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
			}
		}

		// "The type of the class instance creation expression is the class type being instantiated." (JLSv3
		// §15.9.1)
		return new TypecheckerResult(instantiationType, metadata);
	}

	@Override
	public TypecheckerResult executeVariableAccessNode(VariableAccessNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();

		String id = node.getIdentifier().getIdentifier();

		if (node.getExpression() != null)
		{
			// This variable access is qualified on the provided type.
			BsjType expressionType = executeComposingMetadata(node.getExpression(), env, metadata);
			if (expressionType instanceof BsjErrorType)
				return new TypecheckerResult(expressionType, metadata);

			if (expressionType instanceof BsjPackagePseudoType)
			{
				BsjPackagePseudoType packagePseudoType = (BsjPackagePseudoType) expressionType;
				// If there is a type in the package corresponding to the identifier, use it as the returned
				// pseudo-type
				NamedTypeDeclarationNode<?> decl = packagePseudoType.getPackage().getTopLevelTypeDeclaration(id,
						this.manager.getLoader());
				if (decl == null)
				{
					// In this case, just use a subpackage of the given name
					return new TypecheckerResult(new PackagePseudoTypeImpl(this.manager,
							packagePseudoType.getPackage().getSubpackage(id)), metadata);
				} else
				{
					return new TypecheckerResult(new TypePseudoTypeImpl(this.manager, decl), metadata);
				}
			} else if (expressionType instanceof BsjTypePseudoType)
			{
				BsjTypePseudoType typePseudoType = (BsjTypePseudoType) expressionType;
				// If there is a member field with this simple name, then that member field is selected and its
				// type is used.
				// TODO: this approach would also include statically imported fields in the target type's
				// declaration
				// as if they were members. Fix that.
				VariableNamespaceMap variableNamespaceMap = this.manager.getNamespaceBuilder().getVariableNamespace(
						typePseudoType.getDeclaration().getBody().getMembers());
				BsjVariableElement variableElement = variableNamespaceMap.lookup(id, node.getStartLocation());
				if (variableElement != null)
				{
					if (!isStaticVariable(variableElement))
					{
						// Cannot access a member field from a static context
						// TODO: diagnostic
						return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
					}

					// TODO: are we ensuring at any point that the static variables are not bound to type
					// parameters?

					return new TypecheckerResult(variableElement.asType(), metadata);
				} else
				{
					// If there is a member type with this simple name, then that member type is selected and used
					// as
					// a pseudo-type.
					// TODO: this approach would also include imported types (static and otherwise) in the target
					// type's declaration as if they were members. Fix that.
					TypeNamespaceMap typeNamespaceMap = this.manager.getNamespaceBuilder().getTypeNamespace(
							typePseudoType.getDeclaration().getBody().getMembers());
					BsjTypeLikeElement typeLikeElement = typeNamespaceMap.lookup(id, node.getStartLocation());
					if (typeLikeElement != null)
					{
						if (typeLikeElement instanceof BsjDeclaredTypeElement)
						{
							// Use this member type
							BsjDeclaredTypeElement declaredTypeElement = (BsjDeclaredTypeElement) typeLikeElement;
							return new TypecheckerResult(new TypePseudoTypeImpl(this.manager,
									declaredTypeElement.getDeclarationNode()), metadata);
						} else
						{
							// It is illegal to refer to a type variable in this way.
							// TODO: diagnostic
							return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
						}
					} else
					{
						// After dereferencing a type, only a type or a variable can result. We can't resolve the
						// ID.
						// TODO: diagnostic
						return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
					}
				}
			} else
			{
				// The qualifying expression names a variable. The identifier must name a variable which is a member
				// of the object in the qualifying expression; the result is the type of the latter variable after
				// type variable substitution and capture conversion.

				if (expressionType instanceof BsjTypeVariable)
				{
					// Type variables are only dereferencable as their upper bounds.
					expressionType = ((BsjTypeVariable) expressionType).getUpperBound();
				}

				if (expressionType instanceof BsjExplicitlyDeclaredType)
				{
					BsjExplicitlyDeclaredType explicitlyDeclaredType = (BsjExplicitlyDeclaredType) expressionType;
					NamedTypeDeclarationNode<?> declarationNode = explicitlyDeclaredType.asElement().getDeclarationNode();
					VariableNamespaceMap variableNamespaceMap = this.manager.getNamespaceBuilder().getVariableNamespace(
							declarationNode.getBody().getMembers());
					BsjVariableElement variableElement = variableNamespaceMap.lookup(id, node.getStartLocation());
					if (variableElement == null)
					{
						// Then the id does not exist or is not accessible
						// TODO: diagnostic
						return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
					}

					BsjType variableType = variableElement.asType();
					if (explicitlyDeclaredType.isRaw())
					{
						return new TypecheckerResult(variableType.calculateErasure(), metadata);
					} else
					{
						Map<BsjTypeVariable, BsjTypeArgument> substitutionMap = explicitlyDeclaredType.calculateSubstitutionMap();
						variableType = variableType.performTypeSubstitution(substitutionMap);
						variableType = variableType.captureConvert();
						return new TypecheckerResult(variableType, metadata);
					}
				} else if (expressionType instanceof BsjWildcardType)
				{
					// TODO: consider: shouldn't this be impossible? Capture conversion should happen first.
					throw new IllegalStateException("Asked to dereference a wildcard type");
				} else if (expressionType instanceof BsjArrayType)
				{
					if (id.equals("length"))
					{
						return new TypecheckerResult(this.manager.getToolkit().getIntType(), metadata);
					} else
					{
						// This dereference is meaningless.
						// TODO: diagnostic
						return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
					}
				} else
				{
					// This dereference is meaningless.
					// TODO: diagnostic
					return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
				}
			}
		} else
		{
			// This variable access is qualified by the existing context.
			VariableNamespaceMap variableNamespaceMap = this.manager.getNamespaceBuilder().getVariableNamespace(node);
			BsjVariableElement variableElement = variableNamespaceMap.lookup(id,
					node.getIdentifier().getStartLocation());
			if (variableElement == null)
			{
				// Then there is no variable with that name in scope. Is there a type?
				TypeNamespaceMap typeNamespaceMap = this.manager.getNamespaceBuilder().getTypeNamespace(node);
				BsjTypeLikeElement typeLikeElement = typeNamespaceMap.lookup(id,
						node.getIdentifier().getStartLocation());
				if (typeLikeElement != null)
				{
					// Then use the type in question as the pseudo-type to return
					if (typeLikeElement instanceof BsjDeclaredTypeElement)
					{
						return new TypecheckerResult(new TypePseudoTypeImpl(this.manager,
								(((BsjDeclaredTypeElement) typeLikeElement).getDeclarationNode())), metadata);
					} else
					{
						// It is not appropriate to access a type variable in this way.
						// TODO: diagnostic
						return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
					}
				} else
				{
					// No type or variable is available. Assume that the name refers to a package.
					return new TypecheckerResult(new PackagePseudoTypeImpl(this.manager,
							this.manager.getRootPackage().getSubpackage(id)), metadata);
				}
			} else
			{
				// Then there exists a variable in scope with that name. Use its type.
				return new TypecheckerResult(variableElement.asType(), metadata);
			}
		}
	}

	@Override
	public TypecheckerResult executeVariableDeclaratorListNode(VariableDeclaratorListNode node,
			TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildren());
	}

	@Override
	public TypecheckerResult executeVariableDeclaratorNode(VariableDeclaratorNode node, TypecheckerEnvironment env)
	{
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		if (node.getInitializer() != null)
		{
			BsjType initializerType = executeComposingMetadata(node.getInitializer(), env, metadata);
			if (initializerType instanceof BsjErrorType)
			{
				return new TypecheckerResult(initializerType, metadata);
			}

			BsjType expectedType = env.getExpectedType();
			// If the expected type is null, this means that we don't have an expected type in context - nothing we
			// can really validate except that the initializer types to something.
			if (expectedType != null)
			{
				if (node.getArrayLevels() > 0)
				{
					for (int i = 0; i < node.getArrayLevels(); i++)
					{
						expectedType = new ArrayTypeImpl(this.manager, expectedType);
					}
				}

				if (!initializerType.isAssignmentCompatibleWith(expectedType))
				{
					// TODO: diagnostic
					return new TypecheckerResult(new ErrorTypeImpl(this.manager), metadata);
				}
			}
		}
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), metadata);
	}

	@Override
	public TypecheckerResult executeVariableInitializerListNode(VariableInitializerListNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled VariableInitializerListNode.");
	}

	@Override
	public TypecheckerResult executeVariableListNode(VariableListNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildren());
	}

	@Override
	public TypecheckerResult executeVariableModifiersNode(VariableModifiersNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeVariableNode(VariableNode node, TypecheckerEnvironment env)
	{
		return expectNoError(env, node.getChildIterable());
	}

	@Override
	public TypecheckerResult executeVoidTypeNode(VoidTypeNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	@Override
	public TypecheckerResult executeWhileLoopNode(WhileLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException("Have not yet handled WhileLoopNode.");
	}

	@Override
	public TypecheckerResult executeWildcardTypeNode(WildcardTypeNode node, TypecheckerEnvironment env)
	{
		return new TypecheckerResult(new NonePseudoTypeImpl(this.manager), new TypecheckingMetadata());
	}

	private TypecheckerResult handleVariableDeclaratorOwnerNode(VariableDeclaratorOwnerNode node, BsjType successType,
			TypecheckerEnvironment env)
	{
		BsjType variableType = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());
		if (variableType instanceof BsjErrorType)
		{
			return new TypecheckerResult(variableType, new TypecheckingMetadata());
		}
		return expectNoError(env.deriveWithExpectedType(variableType), successType, node.getDeclarators().getChildren());
	}

	/**
	 * Performs a binary type promotion as specified in JLSv3 §5.6.2. This is a convenience method which calls
	 * {@link BsjType#numericTypePromotion()} on both arguments and then returns the type to which either types will be
	 * upcast (if such a type exists) or which is equal to both types (if not). The arguments to this method <i>must</i>
	 * be known to be numeric primitive types; if they are not, an {@link IllegalStateException} is thrown.
	 * 
	 * @param leftType The left type.
	 * @param rightType The right type.
	 * @return The promoted type.
	 */
	private BsjType binaryNumericTypePromotion(BsjType leftType, BsjType rightType)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();
		leftType = leftType.numericTypePromotion();
		rightType = leftType.numericTypePromotion();
		for (BsjPrimitiveType type : new BsjPrimitiveType[] { toolkit.getDoubleType(), toolkit.getFloatType(),
				toolkit.getLongType(), toolkit.getIntType() })
		{
			if (leftType.equals(type) || rightType.equals(type))
			{
				return type;
			}
		}
		// Anything else should've been upcast to an int. How did we get here?
		throw new IllegalStateException("Don't know how to handle types " + leftType + " and " + rightType);
	}

	private BsjType determineBinaryExpressionType(BsjType leftType, BsjType rightType, BinaryOperator operator)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();

		BsjType unboxedLeftType;
		BsjType unboxedRightType;

		if (operator == BinaryOperator.CONDITIONAL_AND || operator == BinaryOperator.CONDITIONAL_OR)
		{
			unboxedLeftType = leftType.unboxConvert();
			unboxedRightType = rightType.unboxConvert();
			if (!unboxedLeftType.equals(toolkit.getBooleanType()))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			if (!unboxedRightType.equals(toolkit.getBooleanType()))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return unboxedLeftType;
		} else if (operator == BinaryOperator.MINUS || operator == BinaryOperator.PLUS
				|| operator == BinaryOperator.DIVIDE || operator == BinaryOperator.MODULUS
				|| operator == BinaryOperator.MULTIPLY)
		{
			if (operator == BinaryOperator.PLUS
					&& (leftType.equals(toolkit.getStringElement().asType()) || rightType.equals(toolkit.getStringElement().asType())))
			{
				// if it's a + operator and either side is a string, the result is string concatenation
				return toolkit.getStringElement().asType();
			}

			unboxedLeftType = leftType.unboxConvert();
			unboxedRightType = rightType.unboxConvert();
			if (!unboxedLeftType.isNumericPrimitive())
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			if (!unboxedRightType.isNumericPrimitive())
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return binaryNumericTypePromotion(unboxedLeftType, unboxedRightType);
		} else if (operator == BinaryOperator.EQUAL || operator == BinaryOperator.NOT_EQUAL)
		{
			unboxedLeftType = leftType.unboxConvert();
			unboxedRightType = rightType.unboxConvert();

			if (unboxedLeftType.equals(toolkit.getBooleanType()))
			{
				if (unboxedRightType.equals(toolkit.getBooleanType()))
				{
					return toolkit.getBooleanType();
				} else
				{
					// Equality on a boolean type must always be between two boolean types.
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				}
			} else if (unboxedLeftType.isNumericPrimitive())
			{
				if (unboxedRightType.isNumericPrimitive())
				{
					return toolkit.getBooleanType();
				} else
				{
					// Equality on a numeric type must always be between two numeric types.
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				}
			} else
			{
				// TODO: if either operand is assignable to the other, a compile-time error occurs
				return toolkit.getBooleanType();
			}
		} else if (operator == BinaryOperator.GREATER_THAN || operator == BinaryOperator.GREATER_THAN_EQUAL
				|| operator == BinaryOperator.LESS_THAN || operator == BinaryOperator.LESS_THAN_EQUAL)
		{
			unboxedLeftType = leftType.unboxConvert();
			unboxedRightType = rightType.unboxConvert();
			if (!unboxedLeftType.isNumericPrimitive())
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			if (!unboxedRightType.isNumericPrimitive())
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return toolkit.getBooleanType();
		} else if (operator == BinaryOperator.LEFT_SHIFT || operator == BinaryOperator.RIGHT_SHIFT
				|| operator == BinaryOperator.UNSIGNED_RIGHT_SHIFT)
		{
			unboxedLeftType = leftType.unboxConvert();
			unboxedRightType = rightType.unboxConvert();
			if (!unboxedLeftType.isIntegralPrimitive())
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			if (!unboxedRightType.isIntegralPrimitive())
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return unboxedLeftType.numericTypePromotion();
		} else if (operator == BinaryOperator.LOGICAL_AND || operator == BinaryOperator.LOGICAL_OR
				|| operator == BinaryOperator.XOR)
		{
			unboxedLeftType = leftType.unboxConvert();
			unboxedRightType = rightType.unboxConvert();
			if (unboxedLeftType.equals(toolkit.getBooleanType()))
			{
				if (unboxedRightType.equals(toolkit.getBooleanType()))
				{
					return toolkit.getBooleanType();
				} else
				{
					// Equality on a boolean type must always be between two boolean types.
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				}
			} else if (unboxedLeftType.isIntegralPrimitive())
			{
				if (unboxedRightType.isIntegralPrimitive())
				{
					return binaryNumericTypePromotion(unboxedLeftType, unboxedRightType);
				} else
				{
					// Equality on a numeric type must always be between two numeric types.
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				}
			} else
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
		} else
		{
			throw new IllegalStateException("Unrecognized binary operator " + operator);
		}
	}

	private boolean isStaticVariable(BsjVariableElement variableElement)
	{
		VariableNameBindingNode bindingNode = variableElement.getDeclarationNode();
		if (bindingNode instanceof VariableDeclaratorNode)
		{
			VariableDeclaratorNode declaratorNode = (VariableDeclaratorNode) bindingNode;
			VariableDeclaratorOwnerNode owner = (VariableDeclaratorOwnerNode) declaratorNode.getParent().getParent();
			if (owner instanceof LocalVariableDeclarationNode)
			{
				throw new IllegalStateException(
						"Managed to directly name a local variable declaration from a static type reference");
			} else if (owner instanceof ConstantDeclarationNode)
			{
				return true;
			} else if (owner instanceof FieldDeclarationNode)
			{
				FieldDeclarationNode declarationNode = (FieldDeclarationNode) owner;
				return declarationNode.getModifiers().getStaticFlag();
			} else
			{
				throw new IllegalStateException("Unrecognized variable declarator owner type: " + owner.getClass());
			}
		} else if (bindingNode instanceof EnumConstantDeclarationNode)
		{
			return true;
		} else if (bindingNode instanceof VariableNode)
		{
			throw new IllegalStateException(
					"Managed to directly name a non-member variable from a static type reference");
		} else
		{
			throw new IllegalStateException("Unrecognized variable binding node type: " + bindingNode.getClass());
		}
	}

	/**
	 * Used to identify matching arity methods from a set of potentially applicable methods. This method can use either
	 * the method invocation conversion (§15.12.2.3) or the subtyping conversion (§15.12.2.2) approach to this task.
	 * 
	 * @param node The method invocation node.
	 * @param argumentTypes The types of the arguments being examined.
	 * @param potentiallyApplicableMethods A set of potentially applicable methods.
	 * @param genericMethodDataMap The precalculated data about the generic method data to use.
	 * @param methodInvocationConversion <code>true</code> to use the method invocation conversion; <code>false</code>
	 *            to use the subtyping conversion.
	 * @return A set of applicable methods based on the above information.
	 */
	private Set<BsjExecutableType> identifyMatchingArityMethods(MethodInvocationNode node, List<BsjType> argumentTypes,
			Collection<? extends BsjExecutableType> potentiallyApplicableMethods,
			Map<BsjExecutableType, GenericMethodData> genericMethodDataMap, boolean methodInvocationConversion)
	{
		Set<BsjExecutableType> applicableMethods;
		applicableMethods = new HashSet<BsjExecutableType>();
		for (BsjExecutableType executableType : potentiallyApplicableMethods)
		{
			if (executableType.getParameterTypes().size() != node.getArguments().size())
			{
				// Variable arity is forbidden in this phase.
				continue;
			}

			GenericMethodData genericMethodData = genericMethodDataMap.get(executableType);

			// Create the effective list of parameter types
			List<BsjType> parameterTypes = new ArrayList<BsjType>();
			for (BsjType parameterType : executableType.getParameterTypes())
			{
				parameterTypes.add(parameterType.performTypeSubstitution(genericMethodData.getSubstitutionMap()));
			}

			// Determine if the method is applicable by subtyping
			boolean applicable = true;

			for (int i = 0; i < parameterTypes.size(); i++)
			{
				BsjType parameterType = parameterTypes.get(i);
				BsjType argumentType = argumentTypes.get(i);

				if (methodInvocationConversion)
				{
					if (!argumentType.isMethodInvocationCompatibleWith(parameterType))
					{
						applicable = false;
					}
				} else
				{
					if (argumentType.isSubtypeOf(parameterType))
					{
						// Then this parameter is okay
					} else if (argumentType.isSubtypeOf(parameterType.calculateErasure()))
					{
						// TODO: Produce an unchecked warning because of unchecked conversion? We don't want to do
						// this
						// all the time, do we? Just when this is the method which is selected?
					} else
					{
						applicable = false;
					}
				}
			}

			// For all generic methods, the values provided as type arguments must be subtypes of the original
			// type parameter bounds after substitution.
			if (executableType.getTypeVariables().size() > 0)
			{
				for (int i = 0; i < executableType.getParameterTypes().size(); i++)
				{
					BsjTypeArgument typeArgument = genericMethodData.getTypeArguments().get(i);
					BsjTypeVariable typeVariable = executableType.getTypeVariables().get(i);
					BsjType boundType = typeVariable.performTypeSubstitution(genericMethodData.getSubstitutionMap());
					if (boundType instanceof BsjTypeVariable)
					{
						boundType = ((BsjTypeVariable) boundType).getUpperBound();
					}
					if (!typeArgument.isSubtypeOf(boundType))
					{
						applicable = false;
					}
				}
			}

			if (applicable)
			{
				applicableMethods.add(executableType);
			}
		}
		return applicableMethods;
	}

	/**
	 * Determines if one method is more specific than another as per the rules in JLSv3 §15.12.2.5.
	 * 
	 * @param candidateMethod The candidate to check.
	 * @param competitorMethod The method to which the candidate is being compared.
	 * @return <code>true</code> if the candidate is more specific than the competitor; <code>false</code> if it is not.
	 */
	private boolean isMoreSpecific(BsjExecutableType candidateMethod, BsjExecutableType competitorMethod)
	{
		if (candidateMethod.equals(competitorMethod))
			return true;

		throw new NotImplementedYetException("Have not yet implemented isMoreSpecific for methods");
	}

	private Map<BsjExecutableType, GenericMethodData> extractGenericMethodData(MethodInvocationNode node,
			Collection<? extends BsjExecutableType> potentiallyApplicableMethods)
	{
		Map<BsjExecutableType, GenericMethodData> genericMethodDataMap = new HashMap<BsjExecutableType, GenericMethodData>();
		for (BsjExecutableType executableType : potentiallyApplicableMethods)
		{
			// Create a substitution map for type variables
			Map<BsjTypeVariable, BsjTypeArgument> substitutionMap;
			List<BsjTypeArgument> typeArguments;
			if (executableType.getTypeVariables().size() > 0)
			{
				// For a generic method, consider inferring type arguments
				if (node.getTypeArguments().size() == 0)
				{
					// Infer type arguments as per §15.12.2.7
					throw new NotImplementedYetException();
				} else
				{
					typeArguments = new ArrayList<BsjTypeArgument>();
					for (TypeArgumentNode typeArgumentNode : node.getTypeArguments())
					{
						typeArguments.add(this.manager.getToolkit().getTypeBuilder().makeArgumentType(typeArgumentNode));
					}
				}

				substitutionMap = new HashMap<BsjTypeVariable, BsjTypeArgument>();
				for (int i = 0; i < typeArguments.size(); i++)
				{
					substitutionMap.put(executableType.getTypeVariables().get(i), typeArguments.get(i));
				}
			} else
			{
				substitutionMap = Collections.emptyMap();
				typeArguments = Collections.emptyList();
			}

			genericMethodDataMap.put(executableType, new GenericMethodData(substitutionMap, typeArguments));
		}
		return genericMethodDataMap;
	}

	/**
	 * A data structure which maintains data about a generic method for a given method invocation.
	 */
	private class GenericMethodData
	{
		private Map<BsjTypeVariable, BsjTypeArgument> substitutionMap;
		private List<BsjTypeArgument> typeArguments;

		public GenericMethodData(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap,
				List<BsjTypeArgument> typeArguments)
		{
			super();
			this.substitutionMap = substitutionMap;
			this.typeArguments = typeArguments;
		}

		public Map<BsjTypeVariable, BsjTypeArgument> getSubstitutionMap()
		{
			return substitutionMap;
		}

		public List<BsjTypeArgument> getTypeArguments()
		{
			return typeArguments;
		}

	}

	/**
	 * Performs recursive typechecking on the provided nodes, expecting a non-error type from each of them. If this
	 * occurs, the specified type is returned; otherwise, the first error is returned. All of the provided nodes are
	 * evaluated regardless of whether or not an error occurs.
	 * 
	 * @param env The environment to use.
	 * @param successType The type to return on success.
	 * @param nodes The nodes to check.
	 * @return The resulting type value.
	 */
	private TypecheckerResult expectNoError(TypecheckerEnvironment env, BsjType successType,
			Iterable<? extends Node> nodes)
	{
		BsjErrorType errorType = null;
		TypecheckingMetadata metadata = new TypecheckingMetadata();
		for (Node node : nodes)
		{
			if (node == null)
			{
				continue;
			}
			TypecheckerResult result = node.executeOperation(this, env);
			if (result.getType() instanceof BsjErrorType)
			{
				errorType = (BsjErrorType) result.getType();
			}
			metadata.add(result.getMetadata());
		}
		return new TypecheckerResult(errorType == null ? successType : errorType, metadata);
	}

	private TypecheckerResult expectNoError(TypecheckerEnvironment env, BsjType successType, Node... nodes)
	{
		return expectNoError(env, successType, Arrays.asList(nodes));
	}

	private TypecheckerResult expectNoError(TypecheckerEnvironment env, Iterable<? extends Node> nodes)
	{
		return expectNoError(env, new VoidPseudoTypeImpl(this.manager), nodes);
	}

	private TypecheckerResult expectNoError(TypecheckerEnvironment env, Node... nodes)
	{
		return expectNoError(env, Arrays.asList(nodes));
	}

	/**
	 * Calculates a collection of parse rules which have at least one output type which is a subtype of the specified
	 * type.
	 * 
	 * @param type The type in question.
	 * @return The parse rules for that type.
	 */
	private Collection<ParseRule<?>> calculateParseRulesForType(BsjType type)
	{
		Set<ParseRule<?>> rules = new HashSet<ParseRule<?>>();
		for (ParseRule<?> rule : ParseRule.values())
		{
			boolean applicable = false;
			for (Class<?> clazz : rule.getBottomMostClasses())
			{
				BsjType bottomType = this.manager.getToolkit().getTypeBuilder().makeMetaprogramClasspathType(clazz);
				if (type.isSupertypeOf(bottomType))
				{
					// Then this rule has an output which matches the provided one.
					applicable = true;
					break;
				}
			}
			if (applicable)
			{
				rules.add(rule);
			}
		}
		return rules;
	}

	/**
	 * Reduces the specified type based on the provided collection of types. The resulting type will be either a type
	 * from that collection (if the specified type is a subtype of exactly one of the types in the collection) or an
	 * intersection of several of the collection types (if the type is a subtype of multiple types in the collection).
	 * If the provided type is not a subtype of any of the types in the collection, an exception is raised.
	 * 
	 * @param type The starting type.
	 * @param types The base types.
	 * @return The resulting reduced type.
	 */
	private BsjTypeArgument codeLiteralTypeReduction(BsjType type, Collection<? extends BsjTypeArgument> types)
	{
		List<BsjTypeArgument> supertypes = new ArrayList<BsjTypeArgument>();
		for (BsjTypeArgument baseType : types)
		{
			if (type.isSubtypeOf(baseType))
			{
				supertypes.add(baseType);
			}
		}
		if (supertypes.size() == 0)
		{
			throw new IllegalStateException("Cannot reduce: no subtypes apply.");
		} else if (supertypes.size() == 1)
		{
			return supertypes.get(0);
		} else
		{
			return new IntersectionTypeImpl(this.manager, supertypes);
		}
	}

	/**
	 * Executes this operation on a given node, adding the metadata of the result to a provided metadata object and
	 * returning the resulting type. This is an abbreviation mechanism.
	 */
	private BsjType executeComposingMetadata(Node node, TypecheckerEnvironment env, TypecheckingMetadata metadata)
	{
		TypecheckerResult result = node.executeOperation(this, env);
		metadata.add(result.getMetadata());
		return result.getType();
	}
}
