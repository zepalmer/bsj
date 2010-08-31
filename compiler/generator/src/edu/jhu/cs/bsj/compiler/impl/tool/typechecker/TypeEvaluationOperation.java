package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.Collections;
import java.util.Map;

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
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPackagePseudoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypePseudoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

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
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeArrayInitializerNode(ArrayInitializerNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
}
