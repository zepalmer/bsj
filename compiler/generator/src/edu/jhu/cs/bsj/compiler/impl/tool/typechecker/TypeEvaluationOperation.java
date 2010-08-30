package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ArrayTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.CapturedTypeVariableImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.DeclaredTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ErrorTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.IntersectionTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NullTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjArrayType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
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
	
	// TODO: the current flavor of error handling will produce a slew of diagnostics up a recursive call stack when an
	// error occurs.  For instance, consider the statement "String[] x = new String[true];".  This is clearly in error;
	// the array index is not unary promotable to int.  But the current implementation will return an ErrorType for the
	// array initializer, causing the assignment to generate its own new ErrorType.  Because each error type creation is
	// associated with the creation of a diagnostic object, two diagnostics will be reported for what amounts to a
	// single error.
	//     Rather than this, the desirable approach would be to have each parent typechecker consider the errors it
	// gets from its child nodes and return that error without a further diagnostic as necessary.  However, it may be
	// desirable in some cases to be able to ascertain what the type of the expression *would* be if the error were
	// resolved; this is not always deterministic, but it may be.  Above, for instance, the type would always be
	// String[] regardless of how the existing error was fixed.  Should this be a mode on the type evaluation operation
	// or simply a field on the ErrorType?  Either way, deal with this.

	// TODO: handle rejection which comes as a result of lacking context (such as "<:x:>") differently
	// This could be accomplished by creating a second operation. The second operation calls this operation for all
	// requests. Whenever this operation returns an error type indicating failure due to insufficient context, however,
	// the second operation would then perform a parse map operation and call this operation again. Only in the cae of
	// a second failure would the second operation return the insufficient context error type. Note that this would
	// require ensuring that this operation never calls executeOperation(this,...); it should instead accept an argument
	// on construction indicating the "thisOperation" to use (to simulate proxy-like calls).

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
		if (arrayExpressionType instanceof BsjArrayType)
		{
			BsjArrayType arrayType = (BsjArrayType) arrayExpressionType;
			BsjType indexExpressionType = node.getIndexExpression().executeOperation(thisOperation, env);
			indexExpressionType = autoUnboxType(indexExpressionType);
			if (isIntegralPrimitive(indexExpressionType))
			{
				indexExpressionType = numericTypePromotion(indexExpressionType);
			}
			if (!indexExpressionType.equals(this.manager.getToolkit().getIntType()))
			{
				// You can't index using anything that doesn't promote to an int
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return captureConversion(arrayType.getComponentType());
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
			exprType = autoUnboxType(exprType);
			exprType = numericTypePromotion(exprType);
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
		BsjType expressionType = node.getExpression().executeOperation(thisOperation, env);
		
		AssignmentOperator assignmentOperator = node.getOperator();
		BinaryOperator binaryOperator = assignmentOperator.getBinaryOperator();
		
		if (binaryOperator != null)
		{
			expressionType = determineBinaryExpressionType(variableType, expressionType, binaryOperator);
		}
		
		// TODO: check variable convertability
		return expressionType;
	}

	@Override
	public BsjType executeBinaryExpressionNode(BinaryExpressionNode node, TypecheckerEnvironment env)
	{
		BsjType leftType = node.getLeftOperand().executeOperation(thisOperation, env);
		BsjType rightType = node.getRightOperand().executeOperation(thisOperation, env);
		
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
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
	public BsjType executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node,
			TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeMethodInvocationByNameNode(MethodInvocationByNameNode node, TypecheckerEnvironment env)
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
		return NoTypeImpl.makePackage(this.manager);
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
		switch (node.getOperator())
		{
			case BITWISE_COMPLEMENT:
				type = autoUnboxType(type);
				if (!isIntegralPrimitive(type))
				{
					// TODO: diagnostic
					return new ErrorTypeImpl(this.manager);
				} else
				{
					return numericTypePromotion(type);
				}
			case LOGICAL_COMPLEMENT:
				type = autoUnboxType(type);
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
				BsjPrimitiveType primitiveType = numericTypePromotion(type);
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
		expressionType = autoUnboxType(expressionType);
		if (isNumericPrimitive(expressionType))
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
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVariableAccessByExpressionNode(VariableAccessByExpressionNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public BsjType executeVariableAccessByNameNode(VariableAccessByNameNode node, TypecheckerEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
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
	 * Boxes the specified type.
	 */
	private BsjExplicitlyDeclaredType boxType(BsjPrimitiveType type)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();
		if (type.equals(toolkit.getByteType()))
			return toolkit.getByteWrapperType();
		if (type.equals(toolkit.getCharType()))
			return toolkit.getCharacterWrapperType();
		if (type.equals(toolkit.getIntType()))
			return toolkit.getIntegerWrapperType();
		if (type.equals(toolkit.getLongType()))
			return toolkit.getLongWrapperType();
		if (type.equals(toolkit.getShortType()))
			return toolkit.getShortWrapperType();
		if (type.equals(toolkit.getDoubleType()))
			return toolkit.getDoubleWrapperType();
		if (type.equals(toolkit.getFloatType()))
			return toolkit.getFloatWrapperType();
		if (type.equals(toolkit.getBooleanType()))
			return toolkit.getBooleanWrapperType();
		throw new IllegalStateException("Unrecognized primitive type: " + type);
	}

	/**
	 * Auto-boxes the specified type. If the specified type cannot be auto-boxed (because it is not boxable or is
	 * already boxed), it is returned as it was provided.
	 */
	private BsjReferenceType autoboxType(BsjType type)
	{
		if (type instanceof BsjPrimitiveType)
		{
			return boxType((BsjPrimitiveType) type);
		} else
		{
			return (BsjReferenceType) type;
		}
	}

	/**
	 * Unboxes the specified type. If no unboxing is possible, an exception is raised.
	 */
	private BsjPrimitiveType unboxType(BsjExplicitlyDeclaredType type)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();
		if (type.equals(toolkit.getByteWrapperType()))
			return toolkit.getByteType();
		if (type.equals(toolkit.getCharacterWrapperType()))
			return toolkit.getCharType();
		if (type.equals(toolkit.getIntegerWrapperType()))
			return toolkit.getIntType();
		if (type.equals(toolkit.getLongWrapperType()))
			return toolkit.getLongType();
		if (type.equals(toolkit.getShortWrapperType()))
			return toolkit.getShortType();
		if (type.equals(toolkit.getDoubleWrapperType()))
			return toolkit.getDoubleType();
		if (type.equals(toolkit.getFloatWrapperType()))
			return toolkit.getFloatType();
		if (type.equals(toolkit.getBooleanWrapperType()))
			return toolkit.getBooleanType();
		throw new IllegalArgumentException("Provided non-box type " + type);
	}

	/**
	 * Auto-unboxes the specified type. If no auto-unboxing is possible, the type is returned in the form in which it
	 * was provided.
	 */
	private BsjType autoUnboxType(BsjType type)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();
		if (type.equals(toolkit.getByteWrapperType()))
			return toolkit.getByteType();
		if (type.equals(toolkit.getCharacterWrapperType()))
			return toolkit.getCharType();
		if (type.equals(toolkit.getIntegerWrapperType()))
			return toolkit.getIntType();
		if (type.equals(toolkit.getLongWrapperType()))
			return toolkit.getLongType();
		if (type.equals(toolkit.getShortWrapperType()))
			return toolkit.getShortType();
		if (type.equals(toolkit.getDoubleWrapperType()))
			return toolkit.getDoubleType();
		if (type.equals(toolkit.getFloatWrapperType()))
			return toolkit.getFloatType();
		if (type.equals(toolkit.getBooleanWrapperType()))
			return toolkit.getBooleanType();
		return type;
	}

	/**
	 * Determines whether or not the specified type is a numeric primitive type.
	 */
	private boolean isNumericPrimitive(BsjType type)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();
		return (isIntegralPrimitive(type) || (type.equals(toolkit.getDoubleType())) || (type.equals(toolkit.getFloatType())));
	}

	/**
	 * Determines whether or not the specified type is an integral primitive type.
	 */
	private boolean isIntegralPrimitive(BsjType type)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();
		return (type.equals(toolkit.getByteType())) || (type.equals(toolkit.getCharType()))
				|| (type.equals(toolkit.getIntType())) || (type.equals(toolkit.getLongType()))
				|| (type.equals(toolkit.getShortType())) || (type.equals(toolkit.getDoubleType()))
				|| (type.equals(toolkit.getFloatType()));
	}

	/**
	 * Performs numeric type promotion on the specified type. This is equivalent to both unary numeric conversion (JLSv3
	 * §5.6.1) and binary numeric conversion (JLSv3 §5.6.2) because those conversions have different effects on the
	 * values that are converted but not on the types. If the specified type is not a numeric type, <code>null</code> is
	 * returned.
	 */
	private BsjPrimitiveType numericTypePromotion(BsjType type)
	{
		BsjType unboxedType = autoUnboxType(type);
		if (!isNumericPrimitive(unboxedType))
		{
			return null;
		}
		TypecheckerToolkit toolkit = this.manager.getToolkit();
		if ((type.equals(toolkit.getByteType())) || (type.equals(toolkit.getCharType()))
				|| (type.equals(toolkit.getShortType())))
		{
			return toolkit.getIntType();
		} else
		{
			return (BsjPrimitiveType) unboxedType;
		}
	}

	/**
	 * Performs a binary type promotion as specified in JLSv3 §5.6.2. This is a convenience method which calls
	 * {@link #numericTypePromotion(BsjType) on both arguments and then returns the type to which either types will be
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
		leftType = numericTypePromotion(leftType);
		rightType = numericTypePromotion(rightType);
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

	/**
	 * Performs the capturing conversion (JLSv3 §5.1.10) on the specified type.
	 * 
	 * @param type The type in question.
	 * @return The capture-converted type.
	 */
	private BsjType captureConversion(BsjType type)
	{
		if (type instanceof BsjExplicitlyDeclaredType)
		{
			BsjExplicitlyDeclaredType explicitType = (BsjExplicitlyDeclaredType) type;
			List<BsjTypeArgument> captureConversionArguments = new ArrayList<BsjTypeArgument>();
			// for each type argument, perform the argument capture
			Iterator<? extends BsjTypeArgument> typeArgIt = explicitType.getTypeArguments().iterator();
			Iterator<? extends BsjTypeParameterElement> paramIt = explicitType.asElement().getTypeParameters().iterator();
			while (typeArgIt.hasNext() && paramIt.hasNext())
			{
				BsjTypeArgument typeArgument = typeArgIt.next();
				BsjTypeParameterElement parameterElement = paramIt.next();

				if (typeArgument instanceof BsjWildcardType)
				{
					BsjWildcardType wildcardType = (BsjWildcardType) typeArgument;
					if (wildcardType.getSuperBound() == null)
					{
						if (wildcardType.getExtendsBound() == null)
						{
							// handle: ?
							// the argument to add to the list is a fresh type variable bounded from above by the
							// bound of the corresponding type parameter
							captureConversionArguments.add(new CapturedTypeVariableImpl(this.manager, null,
									getParameterBoundAsType(parameterElement)));
						} else
						{
							// handle: ? extends Foo
							// the argument to add to the list is a fresh type variable bounded from above by the
							// intersection between the corresponding type parameter and the wildcard bound
							List<BsjTypeArgument> bounds = new ArrayList<BsjTypeArgument>(parameterElement.getBounds());
							bounds.add(wildcardType.getExtendsBound());
							captureConversionArguments.add(new CapturedTypeVariableImpl(this.manager, null,
									getBoundListAsType(bounds)));
						}
					} else
					{
						// then extends bound, by definition of WildcardTypeNode, must be null
						// handle: ? super Foo
						// the argument to add to the list is a fresh type variable bounded from above by the
						// bound of the corresponding type parameter and from below by the wildcard bound
						captureConversionArguments.add(new CapturedTypeVariableImpl(this.manager,
								wildcardType.getSuperBound(), getParameterBoundAsType(parameterElement)));
					}
				} else
				{
					captureConversionArguments.add(typeArgument);
				}
			}
			return new DeclaredTypeImpl(this.manager, explicitType.asElement(), captureConversionArguments,
					explicitType.getEnclosingType());
		} else
		{
			return type;
		}
	}

	/**
	 * Calculates, given a specified type parameter element, a single type representing that type parameter's bound.
	 * 
	 * @param typeParameterElement The element in question.
	 * @return The upper bound of the type parameter represented by that element.
	 */
	private BsjTypeArgument getParameterBoundAsType(BsjTypeParameterElement parameter)
	{
		List<? extends BsjTypeArgument> bounds = parameter.getBounds();
		return getBoundListAsType(bounds);
	}

	private BsjTypeArgument getBoundListAsType(List<? extends BsjTypeArgument> bounds)
	{
		if (bounds.size() == 0)
		{
			return this.manager.getToolkit().getObjectElement().asType();
		} else if (bounds.size() == 1)
		{
			return bounds.iterator().next();
		} else
		{
			return new IntersectionTypeImpl(this.manager, bounds);
		}
	}

	private BsjType determineBinaryExpressionType(BsjType leftType, BsjType rightType, BinaryOperator operator)
	{
		TypecheckerToolkit toolkit = this.manager.getToolkit();

		BsjType unboxedLeftType;
		BsjType unboxedRightType;

		if (operator == BinaryOperator.CONDITIONAL_AND || operator == BinaryOperator.CONDITIONAL_OR)
		{
			unboxedLeftType = autoUnboxType(leftType);
			unboxedRightType = autoUnboxType(rightType);
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

			unboxedLeftType = autoUnboxType(leftType);
			unboxedRightType = autoUnboxType(rightType);
			if (!isNumericPrimitive(unboxedLeftType))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			if (!isNumericPrimitive(unboxedRightType))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return binaryNumericTypePromotion(unboxedLeftType, unboxedRightType);
		} else if (operator == BinaryOperator.EQUAL || operator == BinaryOperator.NOT_EQUAL)
		{
			unboxedLeftType = autoUnboxType(leftType);
			unboxedRightType = autoUnboxType(rightType);

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
			} else if (isNumericPrimitive(unboxedLeftType))
			{
				if (isNumericPrimitive(unboxedRightType))
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
		} else if (operator == BinaryOperator.GREATER_THAN
				|| operator == BinaryOperator.GREATER_THAN_EQUAL
				|| operator == BinaryOperator.LESS_THAN
				|| operator == BinaryOperator.LESS_THAN_EQUAL)
		{
			unboxedLeftType = autoUnboxType(leftType);
			unboxedRightType = autoUnboxType(rightType);
			if (!isNumericPrimitive(unboxedLeftType))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			if (!isNumericPrimitive(unboxedRightType))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return toolkit.getBooleanType();
		} else if (operator == BinaryOperator.LEFT_SHIFT || operator == BinaryOperator.RIGHT_SHIFT
				|| operator == BinaryOperator.UNSIGNED_RIGHT_SHIFT)
		{
			unboxedLeftType = autoUnboxType(leftType);
			unboxedRightType = autoUnboxType(rightType);
			if (!isIntegralPrimitive(unboxedLeftType))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			if (!isIntegralPrimitive(unboxedRightType))
			{
				// TODO: diagnostic
				return new ErrorTypeImpl(this.manager);
			}
			return numericTypePromotion(unboxedLeftType);
		} else if (operator == BinaryOperator.LOGICAL_AND || operator == BinaryOperator.LOGICAL_OR
				|| operator == BinaryOperator.XOR)
		{
			unboxedLeftType = autoUnboxType(leftType);
			unboxedRightType = autoUnboxType(rightType);
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
			} else if (isIntegralPrimitive(unboxedLeftType))
			{
				if (isIntegralPrimitive(unboxedRightType))
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
}
