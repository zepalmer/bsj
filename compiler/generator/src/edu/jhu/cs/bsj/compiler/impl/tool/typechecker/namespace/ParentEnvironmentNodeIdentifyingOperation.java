package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

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

/**
 * This BSJ node operation ascertains for a given node which node dictates its parent environment.  The parent
 * environment node is the node whose environment acts as a base for the given node's environment.
 * @author Zachary Palmer
 */
public class ParentEnvironmentNodeIdentifyingOperation implements BsjNodeOperation<Void, Node>
{
	@Override
	public Node executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationArrayValueNode(AnnotationArrayValueNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationBodyNode(AnnotationBodyNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationElementListNode(AnnotationElementListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationElementNode(AnnotationElementNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationListNode(AnnotationListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationMemberListNode(AnnotationMemberListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationModifiersNode(AnnotationModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnnotationValueListNode(AnnotationValueListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnonymousClassBodyNode(AnonymousClassBodyNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeArrayAccessNode(ArrayAccessNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeArrayInitializerNode(ArrayInitializerNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeArrayTypeNode(ArrayTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAssertStatementNode(AssertStatementNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeAssignmentNode(AssignmentNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeBinaryExpressionNode(BinaryExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeBlockNode(BlockNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeBlockStatementListNode(BlockStatementListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeBooleanLiteralNode(BooleanLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeBreakNode(BreakNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeCaseListNode(CaseListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeCaseNode(CaseNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeCatchListNode(CatchListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeCatchNode(CatchNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeCharLiteralNode(CharLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeClassBodyNode(ClassBodyNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeClassDeclarationNode(ClassDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeClassLiteralNode(ClassLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeClassMemberListNode(ClassMemberListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeClassModifiersNode(ClassModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeCodeLiteralNode(CodeLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeCompilationUnitNode(CompilationUnitNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeConditionalExpressionNode(ConditionalExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeConstantDeclarationNode(ConstantDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeConstantModifiersNode(ConstantModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeConstructorBodyNode(ConstructorBodyNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeConstructorDeclarationNode(ConstructorDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeConstructorModifiersNode(ConstructorModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeContinueNode(ContinueNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeDeclaredTypeListNode(DeclaredTypeListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeDoubleLiteralNode(DoubleLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeDoWhileLoopNode(DoWhileLoopNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeEnhancedForLoopNode(EnhancedForLoopNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeEnumBodyNode(EnumBodyNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeEnumConstantModifiersNode(EnumConstantModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeEnumDeclarationNode(EnumDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeEnumModifiersNode(EnumModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeExpressionListNode(ExpressionListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeExpressionStatementNode(ExpressionStatementNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeFieldDeclarationNode(FieldDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeFieldModifiersNode(FieldModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeFloatLiteralNode(FloatLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeForInitializerExpressionNode(ForInitializerExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeForLoopNode(ForLoopNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeIdentifierListNode(IdentifierListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeIdentifierNode(IdentifierNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeIfNode(IfNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeImportListNode(ImportListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeImportOnDemandNode(ImportOnDemandNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeImportSingleTypeNode(ImportSingleTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeInitializerDeclarationNode(InitializerDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeInstanceOfNode(InstanceOfNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeInterfaceBodyNode(InterfaceBodyNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeInterfaceMemberListNode(InterfaceMemberListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeInterfaceModifiersNode(InterfaceModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeIntLiteralNode(IntLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeJavadocNode(JavadocNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeLabeledStatementNode(LabeledStatementNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeLocalClassDeclarationNode(LocalClassDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeLocalClassModifiersNode(LocalClassModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeLongLiteralNode(LongLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationElementNode(MetaAnnotationElementNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationListNode(MetaAnnotationListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramDependencyNode(MetaprogramDependencyNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramImportListNode(MetaprogramImportListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramImportNode(MetaprogramImportNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramNode(MetaprogramNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramPreambleNode(MetaprogramPreambleNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramTargetListNode(MetaprogramTargetListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMetaprogramTargetNode(MetaprogramTargetNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMethodDeclarationNode(MethodDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMethodInvocationByNameNode(MethodInvocationByNameNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeMethodModifiersNode(MethodModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeNoOperationNode(NoOperationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeNormalAnnotationNode(NormalAnnotationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeNullLiteralNode(NullLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executePackageDeclarationNode(PackageDeclarationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executePackageNode(PackageNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeParameterizedTypeNode(ParameterizedTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executePrimitiveTypeNode(PrimitiveTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeQualifiedNameNode(QualifiedNameNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeRawCodeLiteralNode(RawCodeLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeReferenceTypeListNode(ReferenceTypeListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeReturnNode(ReturnNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSimpleNameNode(SimpleNameNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSingleElementAnnotationNode(SingleElementAnnotationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSingleStaticImportNode(SingleStaticImportNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeStatementExpressionListNode(StatementExpressionListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeStaticImportOnDemandNode(StaticImportOnDemandNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeStringLiteralNode(StringLiteralNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSuperFieldAccessNode(SuperFieldAccessNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSuperMethodInvocationNode(SuperMethodInvocationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSwitchNode(SwitchNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeSynchronizedNode(SynchronizedNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeThisNode(ThisNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeThrowNode(ThrowNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTryNode(TryNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTypeArgumentListNode(TypeArgumentListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTypeCastNode(TypeCastNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTypeDeclarationListNode(TypeDeclarationListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTypeParameterListNode(TypeParameterListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTypeParameterNode(TypeParameterNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeUnaryExpressionNode(UnaryExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableAccessByExpressionNode(VariableAccessByExpressionNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableAccessByNameNode(VariableAccessByNameNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableDeclaratorListNode(VariableDeclaratorListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableDeclaratorNode(VariableDeclaratorNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableInitializerListNode(VariableInitializerListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableListNode(VariableListNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableModifiersNode(VariableModifiersNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVariableNode(VariableNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeVoidTypeNode(VoidTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeWhileLoopNode(WhileLoopNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeWildcardTypeNode(WildcardTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
