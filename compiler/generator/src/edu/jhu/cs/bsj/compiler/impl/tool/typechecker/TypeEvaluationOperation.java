package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
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
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.VariableNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ArrayTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.DeclaredTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ErrorTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NullTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.PackagePseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypePseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjArrayType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjErrorType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
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
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

/**
 * This node operation calculates the type of the provided AST node. All AST nodes are considered to have a type as
 * modeled by the <tt>type</tt> subpackage. TODO: description of non-expression cases such as statements, declarations,
 * type references, constructor invocations, etc.
 * 
 * @author Zachary Palmer
 */
public class TypeEvaluationOperation implements BsjNodeOperation<TypecheckerEnvironment, BsjType>
{
	/** The typechecker model managegr for this operation. */
	private TypecheckerManager manager;
	/**
	 * The node operation to use when a child node's type is needed. This is used to allow another node operation to
	 * proxy all internal calls to this node operation.
	 */
	private BsjNodeOperation<TypecheckerEnvironment, BsjType> thisOperation;

	public TypeEvaluationOperation(TypecheckerManager manager)
	{
		super();
		this.manager = manager;
		this.thisOperation = this;
	}

	public TypeEvaluationOperation(TypecheckerManager manager,
			BsjNodeOperation<TypecheckerEnvironment, BsjType> thisOperation)
	{
		super();
		this.manager = manager;
		this.thisOperation = thisOperation;
	}

	// TODO: handle rejection which comes as a result of lacking context (such as "<:x:>") differently
	// This could be accomplished by creating a second operation. The second operation calls this operation for all
	// requests. Whenever this operation returns an error type indicating failure due to insufficient context, however,
	// the second operation would then perform a parse map operation and call this operation again. Only in the cae of
	// a second failure would the second operation return the insufficient context error type. Note that this would
	// require ensuring that this operation never calls executeOperation(this,...); it should instead accept an argument
	// on construction indicating the "thisOperation" to use (to simulate proxy-like calls).

	// TODO: this typechecker does not currently handle considerations of the distinction between variables and values
	// (also often termed lvalues and rvalues, although variables and values are the terms used in the JLS). As a
	// result, the expression "5 += 5" will typecheck; this is because int += int : int. In order to fix this, the
	// typechecker should really return a tuple between a type and a set of type qualifiers. The only type qualifier
	// that currently seems relevant is the variable/value flag. Most rules would ignore the qualifiers for a given
	// evaluation and simply extract the type, but the qualifiers could be checked by rules such as assignment to
	// ensure correct behavior.

	// TODO: this typechecker does not explicitly handle accessibility in any way; this could lead to incorrect type
	// checking if an accessible member and an inaccessible member are competing. For instance, if a class has two
	// methods, public void foo(String s) and private void foo(Integer i), a caller from outside of the method should
	// be able to call foo(null) and expect to bind to the String method rather than receive an ambiguity error. This
	// implementation would be capable of handling accessibility considerations, but no such implementation has yet been
	// completed due to time and resource constraints.

	@Override
	public BsjType executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationArrayValueNode(AnnotationArrayValueNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationBodyNode(AnnotationBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationDeclarationNode(AnnotationDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationElementListNode(AnnotationElementListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationElementNode(AnnotationElementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationListNode(AnnotationListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationMemberListNode(AnnotationMemberListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationModifiersNode(AnnotationModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnnotationValueListNode(AnnotationValueListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnonymousClassBodyNode(AnonymousClassBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeArrayAccessNode(ArrayAccessNode node, TypecheckerEnvironment env)
	{
		BsjType arrayExpressionType = node.getArrayExpression().executeOperation(thisOperation, env);
		if (arrayExpressionType instanceof BsjErrorType)
			return arrayExpressionType;

		if (arrayExpressionType instanceof BsjArrayType)
		{
			BsjArrayType arrayType = (BsjArrayType) arrayExpressionType;
			BsjType indexExpressionType = node.getIndexExpression().executeOperation(thisOperation, env);
			if (indexExpressionType instanceof BsjErrorType)
				return indexExpressionType;
			indexExpressionType = indexExpressionType.unboxConvert();
			if (indexExpressionType.isIntegralPrimitive())
			{
				indexExpressionType = indexExpressionType.numericTypePromotion();
			}
			if (!indexExpressionType.equals(this.manager.getToolkit().getIntType()))
			{
				// You can't index using anything that doesn't promote to an int
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return arrayType.getComponentType().captureConvert();
		} else
		{
			// You can't dereference a non-array type.
			// TODO: diagnostic
			return new ErrorTypeImpl(this.manager);
		}
	}

	@Override
	public BsjType executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, TypecheckerEnvironment env)
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
			return new ErrorTypeImpl(this.manager);
		}

		TypecheckerEnvironment subEnv = env.deriveWithArrayInitializerType(arrayType);
		return node.getInitializer().executeOperation(thisOperation, subEnv);
	}

	@Override
	public BsjType executeArrayInitializerNode(ArrayInitializerNode node, TypecheckerEnvironment env)
	{
		BsjType arrayType = env.getArrayInitializerType();
		if (arrayType == null)
		{
			// Array initializer not expected here. This might happen in the following case:
			// int[] x = { { 1, 2 } };
			// The inner initializer is inappropriate because there is no viable expected component type.
			// TODO: raise diagnostic
			return new ErrorTypeImpl(this.manager);
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
		TypecheckerEnvironment subEnv = env.deriveWithArrayInitializerType(componentType);
		// Keep going even if we see an error
		BsjErrorType errorType = null;
		for (VariableInitializerNode initializer : node.getInitializers())
		{
			BsjType initializerType = initializer.executeOperation(thisOperation, subEnv);
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
		if (errorType != null)
		{
			return errorType;
		} else
		{
			return arrayType;
		}
	}

	@Override
	public BsjType executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, TypecheckerEnvironment env)
	{
		boolean dimensionError = false;
		for (ExpressionNode expr : node.getDimExpressions())
		{
			BsjType exprType = expr.executeOperation(thisOperation, env);
			if (exprType instanceof BsjErrorType)
				return exprType;

			exprType = exprType.unboxConvert();
			exprType = exprType.numericTypePromotion();
			if (!this.manager.getToolkit().getIntType().equals(exprType))
			{
				dimensionError = true;
				// TODO: produce a diagnostic
			}
		}
		if (dimensionError)
		{
			return new ErrorTypeImpl(this.manager);
		}

		BsjType baseType = this.manager.getToolkit().getTypeBuilder().makeType(node.getBaseType());
		for (int i = 0; i < node.getArrayLevels() + node.getDimExpressions().size(); i++)
		{
			baseType = new ArrayTypeImpl(this.manager, baseType);
		}
		return baseType;
	}

	@Override
	public BsjType executeArrayTypeNode(ArrayTypeNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAssertStatementNode(AssertStatementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeAssignmentNode(AssignmentNode node, TypecheckerEnvironment env)
	{
		BsjType variableType = node.getVariable().executeOperation(thisOperation, env);
		if (variableType instanceof BsjErrorType)
			return variableType;
		BsjType expressionType = node.getExpression().executeOperation(thisOperation, env);
		if (expressionType instanceof BsjErrorType)
			return expressionType;

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
			return new ErrorTypeImpl(this.manager);
		}

		return variableType.captureConvert();
	}

	@Override
	public BsjType executeBinaryExpressionNode(BinaryExpressionNode node, TypecheckerEnvironment env)
	{
		BsjType leftType = node.getLeftOperand().executeOperation(thisOperation, env);
		if (leftType instanceof BsjErrorType)
			return leftType;
		BsjType rightType = node.getRightOperand().executeOperation(thisOperation, env);
		if (rightType instanceof BsjErrorType)
			return rightType;

		BinaryOperator operator = node.getOperator();

		return determineBinaryExpressionType(leftType, rightType, operator);
	}

	@Override
	public BsjType executeBlockNode(BlockNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeBlockStatementListNode(BlockStatementListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeBooleanLiteralNode(BooleanLiteralNode node, TypecheckerEnvironment env)
	{
		return this.manager.getToolkit().getBooleanType();
	}

	@Override
	public BsjType executeBreakNode(BreakNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeCaseListNode(CaseListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeCaseNode(CaseNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeCatchListNode(CatchListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeCatchNode(CatchNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeCharLiteralNode(CharLiteralNode node, TypecheckerEnvironment env)
	{
		return this.manager.getToolkit().getCharType();
	}

	@Override
	public BsjType executeClassBodyNode(ClassBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeClassDeclarationNode(ClassDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeClassLiteralNode(ClassLiteralNode node, TypecheckerEnvironment env)
	{
		BsjType argumentType = this.manager.getToolkit().getTypeBuilder().makeType(node.getValue());
		BsjTypeArgument boxedType = argumentType.boxConvert();
		if (argumentType instanceof BsjTypeVariable)
		{
			// This is illegal; it is impossible to obtain a type parameter's class by use of T.class
			// TODO: diagnostic
			return new ErrorTypeImpl(this.manager);
		}
		return new DeclaredTypeImpl(this.manager, this.manager.getToolkit().getClassElement(),
				Collections.singletonList(boxedType), null);
	}

	@Override
	public BsjType executeClassMemberListNode(ClassMemberListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeClassModifiersNode(ClassModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeCodeLiteralNode(CodeLiteralNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeCompilationUnitNode(CompilationUnitNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeConditionalExpressionNode(ConditionalExpressionNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeConstantDeclarationNode(ConstantDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeConstantModifiersNode(ConstantModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeConstructorBodyNode(ConstructorBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeConstructorDeclarationNode(ConstructorDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeConstructorModifiersNode(ConstructorModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeContinueNode(ContinueNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeDeclaredTypeListNode(DeclaredTypeListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeDoWhileLoopNode(DoWhileLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeDoubleLiteralNode(DoubleLiteralNode node, TypecheckerEnvironment env)
	{
		return this.manager.getToolkit().getDoubleType();
	}

	@Override
	public BsjType executeEnhancedForLoopNode(EnhancedForLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeEnumBodyNode(EnumBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeEnumConstantModifiersNode(EnumConstantModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeEnumDeclarationNode(EnumDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeEnumModifiersNode(EnumModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeExpressionListNode(ExpressionListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeExpressionStatementNode(ExpressionStatementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeFieldDeclarationNode(FieldDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeFieldModifiersNode(FieldModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeFloatLiteralNode(FloatLiteralNode node, TypecheckerEnvironment env)
	{
		return this.manager.getToolkit().getFloatType();
	}

	@Override
	public BsjType executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeForInitializerExpressionNode(ForInitializerExpressionNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeForLoopNode(ForLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeIdentifierListNode(IdentifierListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeIdentifierNode(IdentifierNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeIfNode(IfNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeImportListNode(ImportListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeImportOnDemandNode(ImportOnDemandNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeImportSingleTypeNode(ImportSingleTypeNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeInitializerDeclarationNode(InitializerDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeInstanceOfNode(InstanceOfNode node, TypecheckerEnvironment env)
	{
		BsjType expressionType = node.getExpression().executeOperation(thisOperation, env);
		if (!(expressionType instanceof BsjReferenceType))
		{
			// TODO: report diagnostic
			return new ErrorTypeImpl(this.manager);
		}

		BsjType checkType = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());
		if (!(checkType instanceof BsjReferenceType))
		{
			// TODO: report diagnostic
			return new ErrorTypeImpl(this.manager);
		}
		if (!checkType.isReifiable())
		{
			// TODO: report diagnostic
			return new ErrorTypeImpl(this.manager);
		}

		// Note: we don't have to worry about compatible-with-warning scenarios here because the type must be reifiable
		if (expressionType.isCastCompatible(checkType) == CastCompatibility.INCOMPATIBLE)
		{
			// TODO: report diagnostic
			return new ErrorTypeImpl(this.manager);
		}

		return this.manager.getToolkit().getBooleanType();
	}

	@Override
	public BsjType executeIntLiteralNode(IntLiteralNode node, TypecheckerEnvironment env)
	{
		return this.manager.getToolkit().getIntType();
	}

	@Override
	public BsjType executeInterfaceBodyNode(InterfaceBodyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeInterfaceDeclarationNode(InterfaceDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeInterfaceMemberListNode(InterfaceMemberListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeInterfaceModifiersNode(InterfaceModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeJavadocNode(JavadocNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeLabeledStatementNode(LabeledStatementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeLocalClassDeclarationNode(LocalClassDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeLocalClassModifiersNode(LocalClassModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeLongLiteralNode(LongLiteralNode node, TypecheckerEnvironment env)
	{
		return this.manager.getToolkit().getLongType();
	}

	@Override
	public BsjType executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaAnnotationElementNode(MetaAnnotationElementNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaAnnotationListNode(MetaAnnotationListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramDependencyNode(MetaprogramDependencyNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramImportListNode(MetaprogramImportListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramImportNode(MetaprogramImportNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramNode(MetaprogramNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramPreambleNode(MetaprogramPreambleNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramTargetListNode(MetaprogramTargetListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMetaprogramTargetNode(MetaprogramTargetNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMethodDeclarationNode(MethodDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMethodInvocationNode(MethodInvocationNode node, TypecheckerEnvironment env)
	{
		// Evaluate the type of each of the arguments in the call
		List<BsjType> argumentTypes = new ArrayList<BsjType>();
		BsjErrorType errorType = null;
		for (ExpressionNode expr : node.getArguments())
		{
			BsjType argumentType = expr.executeOperation(thisOperation, env);
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
		boolean staticContext; // TODO: actually determine static context correctly by retrieving it from environment
		if (node.getExpression() == null)
		{
			// Just an identifier; use the enclosing type.
			searchType = this.manager.getToolkit().makeElement(
					node.getNearestAncestorOfType(NamedTypeDeclarationNode.class)).asType();
			// TODO: actually determine if we're in a static context (preferrably by use of the environment)
			staticContext = false;
		} else
		{
			// Establish the type of the qualifying expression and use that class.
			BsjType qualifyingType = node.getExpression().executeOperation(thisOperation, env);
			while (qualifyingType instanceof BsjTypeVariable)
			{
				qualifyingType = ((BsjTypeVariable) qualifyingType).getUpperBound();
			}
			if (qualifyingType instanceof BsjExplicitlyDeclaredType)
			{
				searchType = (BsjExplicitlyDeclaredType) qualifyingType;
				staticContext = false;
			} else if (qualifyingType instanceof BsjTypePseudoType)
			{
				searchType = this.manager.getToolkit().makeElement(
						((BsjTypePseudoType) qualifyingType).getDeclaration()).asType();
				staticContext = true;
			} else if (qualifyingType instanceof BsjPackagePseudoType)
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			} else if (qualifyingType instanceof BsjVoidPseudoType || qualifyingType instanceof BsjNullType
					|| qualifyingType instanceof BsjArrayType || qualifyingType instanceof BsjPrimitiveType)
			{
				// Cannot dereference this type for a method invocation
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
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
			// Note that this *does* mean that method calls providing generic type arguments can be made against methods
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
			return new ErrorTypeImpl(this.manager);
		}

		// For each potentially applicable method, generate its type variable substitution map and effective parameter
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
			return new ErrorTypeImpl(this.manager);
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
			return new ErrorTypeImpl(this.manager);
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
		// * If the invocation was made using the keyword super, the  method must not be abstract.
		// * If the invocation was made using a qualified keyword super, the method invocation must be enclosed by the
		//   specified class.
		
		// Finished!
		return returnType;
	}

	@Override
	public BsjType executeMethodModifiersNode(MethodModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeNoOperationNode(NoOperationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeNormalAnnotationNode(NormalAnnotationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeNullLiteralNode(NullLiteralNode node, TypecheckerEnvironment env)
	{
		return new NullTypeImpl(this.manager);
	}

	@Override
	public BsjType executePackageDeclarationNode(PackageDeclarationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executePackageNode(PackageNode node, TypecheckerEnvironment env)
	{
		return new PackagePseudoTypeImpl(this.manager, node);
	}

	@Override
	public BsjType executeParameterizedTypeNode(ParameterizedTypeNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, TypecheckerEnvironment env)
	{
		return node.getExpression().executeOperation(thisOperation, env);
	}

	@Override
	public BsjType executePrimitiveTypeNode(PrimitiveTypeNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeQualifiedNameNode(QualifiedNameNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeRawCodeLiteralNode(RawCodeLiteralNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeReferenceTypeListNode(ReferenceTypeListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeReturnNode(ReturnNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSimpleNameNode(SimpleNameNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSingleElementAnnotationNode(SingleElementAnnotationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSingleStaticImportNode(SingleStaticImportNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeStatementExpressionListNode(StatementExpressionListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeStaticImportOnDemandNode(StaticImportOnDemandNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeStringLiteralNode(StringLiteralNode node, TypecheckerEnvironment env)
	{
		return this.manager.getToolkit().getStringElement().asType();
	}

	@Override
	public BsjType executeSuperFieldAccessNode(SuperFieldAccessNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSuperMethodInvocationNode(SuperMethodInvocationNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSwitchNode(SwitchNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeSynchronizedNode(SynchronizedNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeThisNode(ThisNode node, TypecheckerEnvironment env)
	{
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
				return new ErrorTypeImpl(this.manager);
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
			return new ErrorTypeImpl(this.manager);
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
					return this.manager.getToolkit().makeElement(ancestor).asType();
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
			return new ErrorTypeImpl(this.manager);
		}
	}

	@Override
	public BsjType executeThrowNode(ThrowNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeTryNode(TryNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeTypeArgumentListNode(TypeArgumentListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeTypeCastNode(TypeCastNode node, TypecheckerEnvironment env)
	{
		BsjType expressionType = node.getExpression().executeOperation(thisOperation, env);
		if (expressionType instanceof BsjErrorType)
			return expressionType;

		BsjType castType = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());

		CastCompatibility castCompatibility = expressionType.isCastCompatible(castType);
		if (castCompatibility == CastCompatibility.INCOMPATIBLE)
		{
			// TODO: report diagnostic
			return new ErrorTypeImpl(this.manager);
		}
		if (castCompatibility == CastCompatibility.COMPATIBLE_WITH_WARNING)
		{
			// TODO: report warning
		}
		return castType.captureConvert();
	}

	@Override
	public BsjType executeTypeDeclarationListNode(TypeDeclarationListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeTypeParameterListNode(TypeParameterListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeTypeParameterNode(TypeParameterNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeUnaryExpressionNode(UnaryExpressionNode node, TypecheckerEnvironment env)
	{
		BsjType type = node.getExpression().executeOperation(thisOperation, env);
		if (type instanceof BsjErrorType)
			return type;

		switch (node.getOperator())
		{
			case BITWISE_COMPLEMENT:
				type = type.unboxConvert();
				if (!type.isIntegralPrimitive())
				{
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				} else
				{
					return type.numericTypePromotion();
				}
			case LOGICAL_COMPLEMENT:
				type = type.unboxConvert();
				if (type.equals(this.manager.getToolkit().getBooleanType()))
				{
					return type;
				} else
				{
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				}
			case UNARY_MINUS:
			case UNARY_PLUS:
				BsjPrimitiveType primitiveType = type.numericTypePromotion();
				if (primitiveType == null)
				{
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				} else
				{
					return primitiveType;
				}
			default:
				throw new IllegalStateException("Unrecognized unary expression operator");
		}
	}

	@Override
	public BsjType executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, TypecheckerEnvironment env)
	{
		// All unary statement expressions are numeric in nature (pre- and postfix increment and decrement). If the
		// expression has a numeric type, it preserves that type. Otherwise, the expression has an error type.
		BsjType expressionType = node.getExpression().executeOperation(thisOperation, env);
		if (expressionType instanceof BsjErrorType)
			return expressionType;

		expressionType = expressionType.unboxConvert();
		if (expressionType.isNumericPrimitive())
		{
			return expressionType;
		} else
		{
			// TODO: raise a diagnostic
			return new ErrorTypeImpl(this.manager);
		}
	}

	@Override
	public BsjType executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeUnparameterizedTypeNode(UnparameterizedTypeNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node,
			TypecheckerEnvironment env)
	{
		// Determine the type being instantiated.
		BsjNamedReferenceType targetType = this.manager.getToolkit().getTypeBuilder().makeDeclaredType(node.getType());
		if (targetType instanceof BsjTypeVariable)
		{
			// This is an error; it is illegal to attempt to instantiate a type variable.
			// TODO: diagnostic
			return new ErrorTypeImpl(this.manager);
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
				return new ErrorTypeImpl(this.manager);
			}
		}

		// Ensure that none of the instantiation type arguments are wildcard types.
		for (BsjTypeArgument typeArgument : instantiationType.getTypeArguments())
		{
			if (typeArgument instanceof BsjWildcardType)
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
		}

		// Ensure that we are not attempting to instantiate an enum type
		if (instantiationType.asElement().getDeclarationNode() instanceof EnumDeclarationNode)
		{
			// TODO: diagnostic
			return new ErrorTypeImpl(this.manager);
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
					return new ErrorTypeImpl(this.manager);
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
					return new ErrorTypeImpl(this.manager);
				}
			} else
			{
				// Cannot instantiate a non-class type
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
		}

		// "The type of the class instance creation expression is the class type being instantiated." (JLSv3 §15.9.1)
		return instantiationType;
	}

	@Override
	public BsjType executeVariableAccessNode(VariableAccessNode node, TypecheckerEnvironment env)
	{
		String id = node.getIdentifier().getIdentifier();

		if (node.getExpression() != null)
		{
			// This variable access is qualified on the provided type.
			BsjType expressionType = node.getExpression().executeOperation(thisOperation, env);
			if (expressionType instanceof BsjErrorType)
				return expressionType;

			if (expressionType instanceof BsjPackagePseudoType)
			{
				BsjPackagePseudoType packagePseudoType = (BsjPackagePseudoType) expressionType;
				// If there is a type in the package corresponding to the identifier, use it as the returned pseudo-type
				NamedTypeDeclarationNode<?> decl = packagePseudoType.getPackage().getTopLevelTypeDeclaration(id,
						this.manager.getLoader());
				if (decl == null)
				{
					// In this case, just use a subpackage of the given name
					return new PackagePseudoTypeImpl(this.manager, packagePseudoType.getPackage().getSubpackage(id));
				} else
				{
					return new TypePseudoTypeImpl(this.manager, decl);
				}
			} else if (expressionType instanceof BsjTypePseudoType)
			{
				BsjTypePseudoType typePseudoType = (BsjTypePseudoType) expressionType;
				// If there is a member field with this simple name, then that member field is selected and its
				// type is used.
				// TODO: this approach would also include statically imported fields in the target type's declaration
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
						return new ErrorTypeImpl(this.manager);
					}

					// TODO: are we ensuring at any point that the static variables are not bound to type parameters?

					return variableElement.asType();
				} else
				{
					// If there is a member type with this simple name, then that member type is selected and used as
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
							return new TypePseudoTypeImpl(this.manager, declaredTypeElement.getDeclarationNode());
						} else
						{
							// It is illegal to refer to a type variable in this way.
							// TODO: diagnostic
							return new ErrorTypeImpl(this.manager);
						}
					} else
					{
						// After dereferencing a type, only a type or a variable can result. We can't resolve the ID.
						// TODO: diagnostic
						return new ErrorTypeImpl(this.manager);
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
						return new ErrorTypeImpl(this.manager);
					}

					BsjType variableType = variableElement.asType();
					if (explicitlyDeclaredType.isRaw())
					{
						return variableType.calculateErasure();
					} else
					{
						Map<BsjTypeVariable, BsjTypeArgument> substitutionMap = explicitlyDeclaredType.calculateSubstitutionMap();
						variableType = variableType.performTypeSubstitution(substitutionMap);
						variableType = variableType.captureConvert();
						return variableType;
					}
				} else if (expressionType instanceof BsjWildcardType)
				{
					// TODO: consider: shouldn't this be impossible? Capture conversion should happen first.
					throw new IllegalStateException("Asked to dereference a wildcard type");
				} else if (expressionType instanceof BsjArrayType)
				{
					if (id.equals("length"))
					{
						return this.manager.getToolkit().getIntType();
					} else
					{
						// This dereference is meaningless.
						// TODO: diagnostic
						return new ErrorTypeImpl(this.manager);
					}
				} else
				{
					// This dereference is meaningless.
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
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
						return new TypePseudoTypeImpl(this.manager,
								(((BsjDeclaredTypeElement) typeLikeElement).getDeclarationNode()));
					} else
					{
						// It is not appropriate to access a type variable in this way.
						// TODO: diagnostic
						return new ErrorTypeImpl(this.manager);
					}
				} else
				{
					// No type or variable is available. Assume that the name refers to a package.
					return new PackagePseudoTypeImpl(this.manager, this.manager.getRootPackage().getSubpackage(id));
				}
			} else
			{
				// Then there exists a variable in scope with that name. Use its type.
				return variableElement.asType();
			}
		}
	}

	@Override
	public BsjType executeVariableDeclaratorListNode(VariableDeclaratorListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVariableDeclaratorNode(VariableDeclaratorNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVariableInitializerListNode(VariableInitializerListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVariableListNode(VariableListNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVariableModifiersNode(VariableModifiersNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVariableNode(VariableNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVoidTypeNode(VoidTypeNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeWhileLoopNode(WhileLoopNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeWildcardTypeNode(WildcardTypeNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
						// TODO: Produce an unchecked warning because of unchecked conversion? We don't want to do this
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

		throw new NotImplementedYetException();
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
	private static class GenericMethodData
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
}
