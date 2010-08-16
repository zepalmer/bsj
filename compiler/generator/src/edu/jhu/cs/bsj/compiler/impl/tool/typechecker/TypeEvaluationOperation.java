package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
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
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NullTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.PrimitiveTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * This node operation calculates the type of the provided AST node. All AST nodes are considered to have a type as
 * modeled by the <tt>type</tt> subpackage. TODO: description of non-expression cases such as statements, declarations,
 * type references, constructor invocations, etc.
 * 
 * @author Zachary Palmer
 */
public class TypeEvaluationOperation implements BsjNodeOperation<BsjEnvironment, BsjType>
{
	/** The typechecker model managegr for this operation. */
	private TypecheckerModelManager manager;

	public TypeEvaluationOperation(TypecheckerModelManager manager)
	{
		super();
		this.manager = manager;
	}

	@Override
	public BsjType executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationArrayValueNode(AnnotationArrayValueNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationBodyNode(AnnotationBodyNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationDeclarationNode(AnnotationDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationElementListNode(AnnotationElementListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationElementNode(AnnotationElementNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationListNode(AnnotationListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationMemberListNode(AnnotationMemberListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationModifiersNode(AnnotationModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnnotationValueListNode(AnnotationValueListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnonymousClassBodyNode(AnonymousClassBodyNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeArrayAccessNode(ArrayAccessNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeArrayInitializerNode(ArrayInitializerNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeArrayTypeNode(ArrayTypeNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAssertStatementNode(AssertStatementNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeAssignmentNode(AssignmentNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeBinaryExpressionNode(BinaryExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeBlockNode(BlockNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeBlockStatementListNode(BlockStatementListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeBooleanLiteralNode(BooleanLiteralNode node, BsjEnvironment env)
	{
		return new PrimitiveTypeImpl(this.manager, PrimitiveType.BOOLEAN);
	}

	@Override
	public BsjType executeBreakNode(BreakNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeCaseListNode(CaseListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeCaseNode(CaseNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeCatchListNode(CatchListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeCatchNode(CatchNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeCharLiteralNode(CharLiteralNode node, BsjEnvironment env)
	{
		return new PrimitiveTypeImpl(this.manager, PrimitiveType.CHAR);
	}

	@Override
	public BsjType executeClassBodyNode(ClassBodyNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeClassDeclarationNode(ClassDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeClassLiteralNode(ClassLiteralNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeClassMemberListNode(ClassMemberListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeClassModifiersNode(ClassModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeCodeLiteralNode(CodeLiteralNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeCompilationUnitNode(CompilationUnitNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeConditionalExpressionNode(ConditionalExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeConstantDeclarationNode(ConstantDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeConstantModifiersNode(ConstantModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeConstructorBodyNode(ConstructorBodyNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeConstructorDeclarationNode(ConstructorDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeConstructorModifiersNode(ConstructorModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeContinueNode(ContinueNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeDeclaredTypeListNode(DeclaredTypeListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeDoWhileLoopNode(DoWhileLoopNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeDoubleLiteralNode(DoubleLiteralNode node, BsjEnvironment env)
	{
		return new PrimitiveTypeImpl(this.manager, PrimitiveType.DOUBLE);
	}

	@Override
	public BsjType executeEnhancedForLoopNode(EnhancedForLoopNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeEnumBodyNode(EnumBodyNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeEnumConstantModifiersNode(EnumConstantModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeEnumDeclarationNode(EnumDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeEnumModifiersNode(EnumModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeExpressionListNode(ExpressionListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeExpressionStatementNode(ExpressionStatementNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeFieldDeclarationNode(FieldDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeFieldModifiersNode(FieldModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeFloatLiteralNode(FloatLiteralNode node, BsjEnvironment env)
	{
		return new PrimitiveTypeImpl(this.manager, PrimitiveType.FLOAT);
	}

	@Override
	public BsjType executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeForInitializerExpressionNode(ForInitializerExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeForLoopNode(ForLoopNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeIdentifierListNode(IdentifierListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeIdentifierNode(IdentifierNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeIfNode(IfNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeImportListNode(ImportListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeImportOnDemandNode(ImportOnDemandNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeImportSingleTypeNode(ImportSingleTypeNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeInitializerDeclarationNode(InitializerDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeInstanceOfNode(InstanceOfNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeIntLiteralNode(IntLiteralNode node, BsjEnvironment env)
	{
		return new PrimitiveTypeImpl(this.manager, PrimitiveType.INT);
	}

	@Override
	public BsjType executeInterfaceBodyNode(InterfaceBodyNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeInterfaceDeclarationNode(InterfaceDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeInterfaceMemberListNode(InterfaceMemberListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeInterfaceModifiersNode(InterfaceModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeJavadocNode(JavadocNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeLabeledStatementNode(LabeledStatementNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeLocalClassDeclarationNode(LocalClassDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeLocalClassModifiersNode(LocalClassModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeLongLiteralNode(LongLiteralNode node, BsjEnvironment env)
	{
		return new PrimitiveTypeImpl(this.manager, PrimitiveType.LONG);
	}

	@Override
	public BsjType executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaAnnotationElementNode(MetaAnnotationElementNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaAnnotationListNode(MetaAnnotationListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramDependencyNode(MetaprogramDependencyNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramImportListNode(MetaprogramImportListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramImportNode(MetaprogramImportNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramNode(MetaprogramNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramPreambleNode(MetaprogramPreambleNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramTargetListNode(MetaprogramTargetListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMetaprogramTargetNode(MetaprogramTargetNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMethodDeclarationNode(MethodDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMethodInvocationByNameNode(MethodInvocationByNameNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeMethodModifiersNode(MethodModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeNoOperationNode(NoOperationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeNormalAnnotationNode(NormalAnnotationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeNullLiteralNode(NullLiteralNode node, BsjEnvironment env)
	{
		return new NullTypeImpl(this.manager);
	}

	@Override
	public BsjType executePackageDeclarationNode(PackageDeclarationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executePackageNode(PackageNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeParameterizedTypeNode(ParameterizedTypeNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executePrimitiveTypeNode(PrimitiveTypeNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeQualifiedNameNode(QualifiedNameNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeRawCodeLiteralNode(RawCodeLiteralNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeReferenceTypeListNode(ReferenceTypeListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeReturnNode(ReturnNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSimpleNameNode(SimpleNameNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSingleElementAnnotationNode(SingleElementAnnotationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSingleStaticImportNode(SingleStaticImportNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeStatementExpressionListNode(StatementExpressionListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeStaticImportOnDemandNode(StaticImportOnDemandNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeStringLiteralNode(StringLiteralNode node, BsjEnvironment env)
	{
		return this.manager.getToolkit().getTypeElementByName("java", "lang", "String").asType();
	}

	@Override
	public BsjType executeSuperFieldAccessNode(SuperFieldAccessNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSuperMethodInvocationNode(SuperMethodInvocationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSwitchNode(SwitchNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeSynchronizedNode(SynchronizedNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeThisNode(ThisNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeThrowNode(ThrowNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeTryNode(TryNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeTypeArgumentListNode(TypeArgumentListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeTypeCastNode(TypeCastNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeTypeDeclarationListNode(TypeDeclarationListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node,
			BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeTypeParameterListNode(TypeParameterListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeTypeParameterNode(TypeParameterNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeUnaryExpressionNode(UnaryExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeUnparameterizedTypeNode(UnparameterizedTypeNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableAccessByExpressionNode(VariableAccessByExpressionNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableAccessByNameNode(VariableAccessByNameNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableDeclaratorListNode(VariableDeclaratorListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableDeclaratorNode(VariableDeclaratorNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableInitializerListNode(VariableInitializerListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableListNode(VariableListNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableModifiersNode(VariableModifiersNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVariableNode(VariableNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeVoidTypeNode(VoidTypeNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeWhileLoopNode(WhileLoopNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType executeWildcardTypeNode(WildcardTypeNode node, BsjEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
