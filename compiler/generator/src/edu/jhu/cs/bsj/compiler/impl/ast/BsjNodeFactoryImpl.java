package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.UnaryStatementOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencySpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.node.*;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationElementListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnnotationValueListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.AnonymousClassMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.BlockStatementListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.CaseListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.CatchListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ClassMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.DeclaredTypeListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.EnumConstantDeclarationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ExpressionListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.IdentifierListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ImportListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.InterfaceMemberListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.ReferenceTypeListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.StatementExpressionListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.TypeArgumentListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.TypeDeclarationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.TypeParameterListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.UnparameterizedTypeListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.VariableDeclaratorListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.VariableInitializerListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.VariableListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.AnnotationMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.BlockStatementMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.ClassMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.CodeLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.InterfaceMemberMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationArrayValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationElementListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationElementNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationExpressionValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationMetaAnnotationValueNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaAnnotationValueListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyDeclarationListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyDeclarationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramDependencyNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramImportListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramImportNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramPreambleNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramTargetListNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.MetaprogramTargetNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.NormalMetaAnnotationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.RawCodeLiteralNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SingleElementMetaAnnotationNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.TypeDeclarationMetaprogramAnchorNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnnotationBodySpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnnotationElementSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnnotationMemberSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnnotationMethodModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnnotationModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnnotationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnnotationValueSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnonymousClassBodySpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.AnonymousClassMemberSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ArrayInitializerSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.BaseTypeSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.BlockStatementSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.CaseSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.CatchSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ClassBodySpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ClassMemberSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ClassModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ConstantModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ConstructorBodySpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ConstructorInvocationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ConstructorModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.DeclaredTypeSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.EnumBodySpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.EnumConstantDeclarationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.EnumConstantModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.EnumModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ExpressionSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.FieldModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ForInitializerSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.IdentifierSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ImportSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.InterfaceBodySpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.InterfaceMemberSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.InterfaceModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.JavadocSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.LiteralizableTypeSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.LocalClassModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.LocalVariableDeclarationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.MethodModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.NameSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.NonAssignmentExpressionSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.PackageDeclarationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ParameterizedTypeSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.PrimaryExpressionSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.ReferenceTypeSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.RestrictedPrimaryExpressionSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.StatementExpressionSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.StatementSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.TypeArgumentSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.TypeDeclarationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.TypeParameterSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.TypeSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.UnparameterizedTypeSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.VariableDeclaratorSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.VariableInitializerSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.VariableModifiersSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.VariableSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.AnnotationElementListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.AnnotationListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.AnnotationMemberListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.AnnotationValueListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.AnonymousClassMemberListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.BlockStatementListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.CaseListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.CatchListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.ClassMemberListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.DeclaredTypeListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.EnumConstantDeclarationListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.ExpressionListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.IdentifierListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.ImportListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.InterfaceMemberListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.ReferenceTypeListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.StatementExpressionListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.TypeArgumentListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.TypeDeclarationListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.TypeParameterListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.UnparameterizedTypeListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.VariableDeclaratorListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.VariableInitializerListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list.VariableListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaAnnotationElementListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaAnnotationElementSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaAnnotationListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaAnnotationMetaprogramAnchorSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaAnnotationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaAnnotationValueListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaAnnotationValueSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramDependencyDeclarationListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramDependencyDeclarationSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramDependencyListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramDependencySpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramImportListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramImportSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramPreambleSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramTargetListSpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.splicenode.meta.MetaprogramTargetSpliceNodeImpl;

/**
 * This class acts as a BSJ node factory for the standard BSJ compiler.
 * 
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BsjNodeFactoryImpl implements BsjNodeFactory
{
	/** The start location to use for new nodes. */
	private BsjSourceLocation startLocation;

	/** The stop location to use for new nodes. */
	private BsjSourceLocation stopLocation;

	/** The node manager to provide to all nodes. */
	private BsjNodeManager manager;
	
	/** Whether or not to mark created nodes as binary nodes. */
	private boolean binary;

	/**
	 * Creates a new node factory.
	 * 
	 * @param packageNodeCallback The callback module to provide to package nodes to allow them to incite operations
	 *            such as the loading of other compilation units.
	 * @param manager The node manager to provide to all nodes to allow them to obtain and report information to a
	 *            global authority.
	 */
	public BsjNodeFactoryImpl(BsjNodeManager manager)
	{
		this.manager = manager;
		this.binary = false;
	}

	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation()
	{
		return this.startLocation;
	}

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation()
	{
		return this.stopLocation;
	}

	/**
	 * Changes the starting source location used for new nodes.
	 * 
	 * @param startLocation The new start location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	@Override
	public void setStartSourceLocation(BsjSourceLocation startLocation)
	{
		this.startLocation = startLocation;
	}

	/**
	 * Changes the ending source location used for new nodes.
	 * 
	 * @param stopLocation The new stop location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	@Override
	public void setStopSourceLocation(BsjSourceLocation stopLocation)
	{
		this.stopLocation = stopLocation;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getBinary()
	{
		return this.binary;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBinary(boolean binary)
	{
		this.binary = binary;
	}

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////

	/**
	 * {@inheritDoc}
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name)
	{
		return makeSingleStaticImportNode(name.getBase().deepCopy(this), name.getIdentifier().deepCopy(this));
	}

	/**
	 * {@inheritDoc}
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name, BsjSourceLocation startLocation,
			BsjSourceLocation stopLocation)
	{
		return makeSingleStaticImportNode(name.getBase().deepCopy(this), name.getIdentifier().deepCopy(this),
				startLocation, stopLocation);
	}

	/**
	 * {@inheritDoc}
	 */
	public NameNode parseNameNode(String name)
	{
		String[] components = name.split("\\.");
		NameNode node = null;
		for (String component : components)
		{
			if (node == null)
			{
				node = makeSimpleNameNode(makeIdentifierNode(component));
			} else
			{
				node = makeQualifiedNameNode(node, makeIdentifierNode(component));
			}
		}
		return node;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ArrayTypeNode wrapArrayLevels(TypeNode type, int levels)
	{
		if (levels <= 0)
		{
			throw new IllegalArgumentException("Invalid level count: " + levels);
		}
		ArrayTypeNode ret = makeArrayTypeNode(type);
		for (int i=1;i<levels;i++)
		{
			ret = makeArrayTypeNode(ret);
		}
		return ret;
	}
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AlternateConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AlternateConstructorInvocationNode makeAlternateConstructorInvocationNode(
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AlternateConstructorInvocationNode ret = new AlternateConstructorInvocationNodeImpl(arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationAnnotationValueNode makeAnnotationAnnotationValueNode(
            AnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationAnnotationValueNode ret = new AnnotationAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            AnnotationValueListNode values)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationArrayValueNode makeAnnotationArrayValueNode(
            AnnotationValueListNode values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationArrayValueNode ret = new AnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            AnnotationMemberListNode members)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationBodyNode makeAnnotationBodyNode(
            AnnotationMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationBodyNode ret = new AnnotationBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationBodySpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationBodySpliceNode makeAnnotationBodySpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationBodySpliceNode ret = new AnnotationBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationBodySpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationBodySpliceNode makeAnnotationBodySpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationBodySpliceNode ret = new AnnotationBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(modifiers, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationDeclarationNode makeAnnotationDeclarationNode(
            AnnotationModifiersNode modifiers,
            AnnotationBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationDeclarationNode ret = new AnnotationDeclarationNodeImpl(modifiers, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            List<AnnotationElementNode> children)
    {
        AnnotationElementListNode ret = new AnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            AnnotationElementNode... childrenElements)
    {
        List<AnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeAnnotationElementListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            List<AnnotationElementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationElementListNode ret = new AnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementListNode makeAnnotationElementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationElementNode... childrenElements)
    {
        List<AnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeAnnotationElementListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationElementListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementListSpliceNode makeAnnotationElementListSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationElementListSpliceNode ret = new AnnotationElementListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementListSpliceNode makeAnnotationElementListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationElementListSpliceNode ret = new AnnotationElementListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value)
    {
        AnnotationElementNode ret = new AnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementNode makeAnnotationElementNode(
            IdentifierNode identifier,
            AnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationElementNode ret = new AnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationElementSpliceNode makeAnnotationElementSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationElementSpliceNode ret = new AnnotationElementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationElementSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationElementSpliceNode makeAnnotationElementSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationElementSpliceNode ret = new AnnotationElementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationExpressionValueNode makeAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationExpressionValueNode ret = new AnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            List<AnnotationNode> children)
    {
        AnnotationListNode ret = new AnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            AnnotationNode... childrenElements)
    {
        List<AnnotationNode> children = Arrays.asList(childrenElements);
        return makeAnnotationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            List<AnnotationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationListNode ret = new AnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationListNode makeAnnotationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationNode... childrenElements)
    {
        List<AnnotationNode> children = Arrays.asList(childrenElements);
        return makeAnnotationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationListSpliceNode makeAnnotationListSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationListSpliceNode ret = new AnnotationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationListSpliceNode makeAnnotationListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationListSpliceNode ret = new AnnotationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            List<AnnotationMemberNode> children)
    {
        AnnotationMemberListNode ret = new AnnotationMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            AnnotationMemberNode... childrenElements)
    {
        List<AnnotationMemberNode> children = Arrays.asList(childrenElements);
        return makeAnnotationMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            List<AnnotationMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMemberListNode ret = new AnnotationMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberListNode makeAnnotationMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationMemberNode... childrenElements)
    {
        List<AnnotationMemberNode> children = Arrays.asList(childrenElements);
        return makeAnnotationMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationMemberListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberListSpliceNode makeAnnotationMemberListSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationMemberListSpliceNode ret = new AnnotationMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberListSpliceNode makeAnnotationMemberListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMemberListSpliceNode ret = new AnnotationMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        AnnotationMemberMetaprogramAnchorNode ret = new AnnotationMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode makeAnnotationMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMemberMetaprogramAnchorNode ret = new AnnotationMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMemberSpliceNode makeAnnotationMemberSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationMemberSpliceNode ret = new AnnotationMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMemberSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMemberSpliceNode makeAnnotationMemberSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMemberSpliceNode ret = new AnnotationMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc)
    {
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodDeclarationNode makeAnnotationMethodDeclarationNode(
            AnnotationMethodModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            AnnotationValueNode defaultValue,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMethodDeclarationNode ret = new AnnotationMethodDeclarationNodeImpl(modifiers, type, identifier, defaultValue, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodModifiersNode makeAnnotationMethodModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMethodModifiersNode ret = new AnnotationMethodModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMethodModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationMethodModifiersSpliceNode makeAnnotationMethodModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationMethodModifiersSpliceNode ret = new AnnotationMethodModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationMethodModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationMethodModifiersSpliceNode makeAnnotationMethodModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationMethodModifiersSpliceNode ret = new AnnotationMethodModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access)
    {
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationModifiersNode makeAnnotationModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationModifiersNode ret = new AnnotationModifiersNodeImpl(access, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationModifiersSpliceNode makeAnnotationModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationModifiersSpliceNode ret = new AnnotationModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationModifiersSpliceNode makeAnnotationModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationModifiersSpliceNode ret = new AnnotationModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationSpliceNode makeAnnotationSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationSpliceNode ret = new AnnotationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationSpliceNode makeAnnotationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationSpliceNode ret = new AnnotationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            List<AnnotationValueNode> children)
    {
        AnnotationValueListNode ret = new AnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            AnnotationValueNode... childrenElements)
    {
        List<AnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeAnnotationValueListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            List<AnnotationValueNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationValueListNode ret = new AnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationValueListNode makeAnnotationValueListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnnotationValueNode... childrenElements)
    {
        List<AnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeAnnotationValueListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnnotationValueListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueListSpliceNode makeAnnotationValueListSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationValueListSpliceNode ret = new AnnotationValueListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationValueListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationValueListSpliceNode makeAnnotationValueListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationValueListSpliceNode ret = new AnnotationValueListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationValueSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnnotationValueSpliceNode makeAnnotationValueSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnnotationValueSpliceNode ret = new AnnotationValueSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnnotationValueSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnnotationValueSpliceNode makeAnnotationValueSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnnotationValueSpliceNode ret = new AnnotationValueSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            AnonymousClassMemberListNode members)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassBodyNode makeAnonymousClassBodyNode(
            AnonymousClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnonymousClassBodyNode ret = new AnonymousClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassBodySpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassBodySpliceNode makeAnonymousClassBodySpliceNode(
            ExpressionNode spliceExpression)
    {
        AnonymousClassBodySpliceNode ret = new AnonymousClassBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassBodySpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassBodySpliceNode makeAnonymousClassBodySpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnonymousClassBodySpliceNode ret = new AnonymousClassBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            List<AnonymousClassMemberNode> children)
    {
        AnonymousClassMemberListNode ret = new AnonymousClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            AnonymousClassMemberNode... childrenElements)
    {
        List<AnonymousClassMemberNode> children = Arrays.asList(childrenElements);
        return makeAnonymousClassMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            List<AnonymousClassMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnonymousClassMemberListNode ret = new AnonymousClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberListNode makeAnonymousClassMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            AnonymousClassMemberNode... childrenElements)
    {
        List<AnonymousClassMemberNode> children = Arrays.asList(childrenElements);
        return makeAnonymousClassMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a AnonymousClassMemberListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberListSpliceNode makeAnonymousClassMemberListSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnonymousClassMemberListSpliceNode ret = new AnonymousClassMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberListSpliceNode makeAnonymousClassMemberListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnonymousClassMemberListSpliceNode ret = new AnonymousClassMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        AnonymousClassMemberMetaprogramAnchorNode ret = new AnonymousClassMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode makeAnonymousClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnonymousClassMemberMetaprogramAnchorNode ret = new AnonymousClassMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AnonymousClassMemberSpliceNode makeAnonymousClassMemberSpliceNode(
            ExpressionNode spliceExpression)
    {
        AnonymousClassMemberSpliceNode ret = new AnonymousClassMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AnonymousClassMemberSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AnonymousClassMemberSpliceNode makeAnonymousClassMemberSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AnonymousClassMemberSpliceNode ret = new AnonymousClassMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression)
    {
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayAccessNode makeArrayAccessNode(
            RestrictedPrimaryExpressionNode arrayExpression,
            ExpressionNode indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayAccessNode ret = new ArrayAccessNodeImpl(arrayExpression, indexExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerCreationNode makeArrayInitializerCreationNode(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayInitializerCreationNode ret = new ArrayInitializerCreationNodeImpl(initializer, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            VariableInitializerListNode initializers)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerNode makeArrayInitializerNode(
            VariableInitializerListNode initializers,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayInitializerNode ret = new ArrayInitializerNodeImpl(initializers, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInitializerSpliceNode makeArrayInitializerSpliceNode(
            ExpressionNode spliceExpression)
    {
        ArrayInitializerSpliceNode ret = new ArrayInitializerSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInitializerSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInitializerSpliceNode makeArrayInitializerSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayInitializerSpliceNode ret = new ArrayInitializerSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ExpressionListNode dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayInstantiatorCreationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayInstantiatorCreationNode makeArrayInstantiatorCreationNode(
            ExpressionListNode dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayInstantiatorCreationNode ret = new ArrayInstantiatorCreationNodeImpl(dimExpressions, baseType, arrayLevels, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ArrayTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ArrayTypeNode makeArrayTypeNode(
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ArrayTypeNode ret = new ArrayTypeNodeImpl(type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            MetaAnnotationListNode metaAnnotations)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssertStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssertStatementNode makeAssertStatementNode(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AssertStatementNode ret = new AssertStatementNodeImpl(testExpression, messageExpression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssignmentNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression)
    {
        AssignmentNode ret = new AssignmentNodeImpl(variable, operator, expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a AssignmentNode.
     * The specified start and stop locations are used.
     */
    @Override
    public AssignmentNode makeAssignmentNode(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        AssignmentNode ret = new AssignmentNodeImpl(variable, operator, expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BaseTypeSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BaseTypeSpliceNode makeBaseTypeSpliceNode(
            ExpressionNode spliceExpression)
    {
        BaseTypeSpliceNode ret = new BaseTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BaseTypeSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BaseTypeSpliceNode makeBaseTypeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BaseTypeSpliceNode ret = new BaseTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BinaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator)
    {
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(leftOperand, rightOperand, operator, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BinaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BinaryExpressionNode makeBinaryExpressionNode(
            ExpressionNode leftOperand,
            ExpressionNode rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BinaryExpressionNode ret = new BinaryExpressionNodeImpl(leftOperand, rightOperand, operator, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            MetaAnnotationListNode metaAnnotations)
    {
        BlockNode ret = new BlockNodeImpl(statements, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockNode ret = new BlockNodeImpl(statements, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements)
    {
        BlockNode ret = new BlockNodeImpl(statements, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockNode makeBlockNode(
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockNode ret = new BlockNodeImpl(statements, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            List<BlockStatementNode> children)
    {
        BlockStatementListNode ret = new BlockStatementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            BlockStatementNode... childrenElements)
    {
        List<BlockStatementNode> children = Arrays.asList(childrenElements);
        return makeBlockStatementListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            List<BlockStatementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockStatementListNode ret = new BlockStatementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementListNode makeBlockStatementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BlockStatementNode... childrenElements)
    {
        List<BlockStatementNode> children = Arrays.asList(childrenElements);
        return makeBlockStatementListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a BlockStatementListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementListSpliceNode makeBlockStatementListSpliceNode(
            ExpressionNode spliceExpression)
    {
        BlockStatementListSpliceNode ret = new BlockStatementListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementListSpliceNode makeBlockStatementListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockStatementListSpliceNode ret = new BlockStatementListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode makeBlockStatementMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockStatementMetaprogramAnchorNode ret = new BlockStatementMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BlockStatementSpliceNode makeBlockStatementSpliceNode(
            ExpressionNode spliceExpression)
    {
        BlockStatementSpliceNode ret = new BlockStatementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BlockStatementSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BlockStatementSpliceNode makeBlockStatementSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BlockStatementSpliceNode ret = new BlockStatementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BooleanLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value)
    {
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BooleanLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BooleanLiteralNode makeBooleanLiteralNode(
            Boolean value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BooleanLiteralNode ret = new BooleanLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations)
    {
        BreakNode ret = new BreakNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BreakNode ret = new BreakNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode()
    {
        BreakNode ret = new BreakNodeImpl(null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BreakNode ret = new BreakNodeImpl(null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label)
    {
        BreakNode ret = new BreakNodeImpl(label, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a BreakNode.
     * The specified start and stop locations are used.
     */
    @Override
    public BreakNode makeBreakNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        BreakNode ret = new BreakNodeImpl(label, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            List<CaseNode> children)
    {
        CaseListNode ret = new CaseListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            CaseNode... childrenElements)
    {
        List<CaseNode> children = Arrays.asList(childrenElements);
        return makeCaseListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a CaseListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            List<CaseNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CaseListNode ret = new CaseListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseListNode makeCaseListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            CaseNode... childrenElements)
    {
        List<CaseNode> children = Arrays.asList(childrenElements);
        return makeCaseListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a CaseListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseListSpliceNode makeCaseListSpliceNode(
            ExpressionNode spliceExpression)
    {
        CaseListSpliceNode ret = new CaseListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseListSpliceNode makeCaseListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CaseListSpliceNode ret = new CaseListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            BlockStatementListNode statements)
    {
        CaseNode ret = new CaseNodeImpl(expression, statements, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseNode makeCaseNode(
            ExpressionNode expression,
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CaseNode ret = new CaseNodeImpl(expression, statements, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CaseSpliceNode makeCaseSpliceNode(
            ExpressionNode spliceExpression)
    {
        CaseSpliceNode ret = new CaseSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CaseSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CaseSpliceNode makeCaseSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CaseSpliceNode ret = new CaseSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            List<CatchNode> children)
    {
        CatchListNode ret = new CatchListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            CatchNode... childrenElements)
    {
        List<CatchNode> children = Arrays.asList(childrenElements);
        return makeCatchListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a CatchListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            List<CatchNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CatchListNode ret = new CatchListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchListNode makeCatchListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            CatchNode... childrenElements)
    {
        List<CatchNode> children = Arrays.asList(childrenElements);
        return makeCatchListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a CatchListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchListSpliceNode makeCatchListSpliceNode(
            ExpressionNode spliceExpression)
    {
        CatchListSpliceNode ret = new CatchListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchListSpliceNode makeCatchListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CatchListSpliceNode ret = new CatchListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockStatementListNode body,
            VariableNode parameter)
    {
        CatchNode ret = new CatchNodeImpl(body, parameter, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchNode makeCatchNode(
            BlockStatementListNode body,
            VariableNode parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CatchNode ret = new CatchNodeImpl(body, parameter, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CatchSpliceNode makeCatchSpliceNode(
            ExpressionNode spliceExpression)
    {
        CatchSpliceNode ret = new CatchSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CatchSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CatchSpliceNode makeCatchSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CatchSpliceNode ret = new CatchSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CharLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value)
    {
        CharLiteralNode ret = new CharLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CharLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CharLiteralNode makeCharLiteralNode(
            Character value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CharLiteralNode ret = new CharLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ClassMemberListNode members)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassBodyNode makeClassBodyNode(
            ClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassBodyNode ret = new ClassBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassBodySpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassBodySpliceNode makeClassBodySpliceNode(
            ExpressionNode spliceExpression)
    {
        ClassBodySpliceNode ret = new ClassBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassBodySpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassBodySpliceNode makeClassBodySpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassBodySpliceNode ret = new ClassBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassDeclarationNode makeClassDeclarationNode(
            ClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassDeclarationNode ret = new ClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassLiteralNode makeClassLiteralNode(
            LiteralizableTypeNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassLiteralNode ret = new ClassLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            List<ClassMemberNode> children)
    {
        ClassMemberListNode ret = new ClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            ClassMemberNode... childrenElements)
    {
        List<ClassMemberNode> children = Arrays.asList(childrenElements);
        return makeClassMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            List<ClassMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassMemberListNode ret = new ClassMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberListNode makeClassMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ClassMemberNode... childrenElements)
    {
        List<ClassMemberNode> children = Arrays.asList(childrenElements);
        return makeClassMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ClassMemberListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberListSpliceNode makeClassMemberListSpliceNode(
            ExpressionNode spliceExpression)
    {
        ClassMemberListSpliceNode ret = new ClassMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberListSpliceNode makeClassMemberListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassMemberListSpliceNode ret = new ClassMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        ClassMemberMetaprogramAnchorNode ret = new ClassMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberMetaprogramAnchorNode makeClassMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassMemberMetaprogramAnchorNode ret = new ClassMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassMemberSpliceNode makeClassMemberSpliceNode(
            ExpressionNode spliceExpression)
    {
        ClassMemberSpliceNode ret = new ClassMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassMemberSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassMemberSpliceNode makeClassMemberSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassMemberSpliceNode ret = new ClassMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access)
    {
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, false, false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassModifiersNode makeClassModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassModifiersNode ret = new ClassModifiersNodeImpl(access, false, false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ClassModifiersSpliceNode makeClassModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        ClassModifiersSpliceNode ret = new ClassModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ClassModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ClassModifiersSpliceNode makeClassModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ClassModifiersSpliceNode ret = new ClassModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CodeLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CodeLiteralNode makeCodeLiteralNode(
            Node value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CodeLiteralNode ret = new CodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            MetaprogramImportListNode metaimports,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls)
    {
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, packageDeclaration, metaimports, imports, typeDecls, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            MetaprogramImportListNode metaimports,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, packageDeclaration, metaimports, imports, typeDecls, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls)
    {
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, packageDeclaration, makeMetaprogramImportListNode(), imports, typeDecls, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a CompilationUnitNode.
     * The specified start and stop locations are used.
     */
    @Override
    public CompilationUnitNode makeCompilationUnitNode(
            String name,
            PackageDeclarationNode packageDeclaration,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        CompilationUnitNode ret = new CompilationUnitNodeImpl(name, packageDeclaration, makeMetaprogramImportListNode(), imports, typeDecls, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConditionalExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression)
    {
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConditionalExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConditionalExpressionNode makeConditionalExpressionNode(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConditionalExpressionNode ret = new ConditionalExpressionNodeImpl(condition, trueExpression, falseExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantDeclarationNode makeConstantDeclarationNode(
            ConstantModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc)
    {
        ConstantDeclarationNode ret = new ConstantDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantDeclarationNode makeConstantDeclarationNode(
            ConstantModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstantDeclarationNode ret = new ConstantDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
    )
    {
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantModifiersNode makeConstantModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstantModifiersNode ret = new ConstantModifiersNodeImpl(makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstantModifiersSpliceNode makeConstantModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        ConstantModifiersSpliceNode ret = new ConstantModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstantModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstantModifiersSpliceNode makeConstantModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstantModifiersSpliceNode ret = new ConstantModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            BlockStatementListNode statements)
    {
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorBodyNode makeConstructorBodyNode(
            ConstructorInvocationNode constructorInvocation,
            BlockStatementListNode statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorBodyNode ret = new ConstructorBodyNodeImpl(constructorInvocation, statements, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorBodySpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorBodySpliceNode makeConstructorBodySpliceNode(
            ExpressionNode spliceExpression)
    {
        ConstructorBodySpliceNode ret = new ConstructorBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorBodySpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorBodySpliceNode makeConstructorBodySpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorBodySpliceNode ret = new ConstructorBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            VariableNode varargParameter,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            VariableNode varargParameter,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, varargParameter, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            JavadocNode javadoc)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, null, makeUnparameterizedTypeListNode(), makeTypeParameterListNode(), javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorDeclarationNode makeConstructorDeclarationNode(
            IdentifierNode identifier,
            ConstructorBodyNode body,
            ConstructorModifiersNode modifiers,
            VariableListNode parameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorDeclarationNode ret = new ConstructorDeclarationNodeImpl(identifier, body, modifiers, parameters, null, makeUnparameterizedTypeListNode(), makeTypeParameterListNode(), javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorInvocationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorInvocationSpliceNode makeConstructorInvocationSpliceNode(
            ExpressionNode spliceExpression)
    {
        ConstructorInvocationSpliceNode ret = new ConstructorInvocationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorInvocationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorInvocationSpliceNode makeConstructorInvocationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorInvocationSpliceNode ret = new ConstructorInvocationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorModifiersNode makeConstructorModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorModifiersNode ret = new ConstructorModifiersNodeImpl(access, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ConstructorModifiersSpliceNode makeConstructorModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        ConstructorModifiersSpliceNode ret = new ConstructorModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ConstructorModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ConstructorModifiersSpliceNode makeConstructorModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ConstructorModifiersSpliceNode ret = new ConstructorModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations)
    {
        ContinueNode ret = new ContinueNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ContinueNode ret = new ContinueNodeImpl(label, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode()
    {
        ContinueNode ret = new ContinueNodeImpl(null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ContinueNode ret = new ContinueNodeImpl(null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label)
    {
        ContinueNode ret = new ContinueNodeImpl(label, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ContinueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ContinueNode makeContinueNode(
            IdentifierNode label,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ContinueNode ret = new ContinueNodeImpl(label, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            List<DeclaredTypeNode> children)
    {
        DeclaredTypeListNode ret = new DeclaredTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            DeclaredTypeNode... childrenElements)
    {
        List<DeclaredTypeNode> children = Arrays.asList(childrenElements);
        return makeDeclaredTypeListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            List<DeclaredTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DeclaredTypeListNode ret = new DeclaredTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DeclaredTypeListNode makeDeclaredTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            DeclaredTypeNode... childrenElements)
    {
        List<DeclaredTypeNode> children = Arrays.asList(childrenElements);
        return makeDeclaredTypeListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a DeclaredTypeListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeListSpliceNode makeDeclaredTypeListSpliceNode(
            ExpressionNode spliceExpression)
    {
        DeclaredTypeListSpliceNode ret = new DeclaredTypeListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DeclaredTypeListSpliceNode makeDeclaredTypeListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DeclaredTypeListSpliceNode ret = new DeclaredTypeListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DeclaredTypeSpliceNode makeDeclaredTypeSpliceNode(
            ExpressionNode spliceExpression)
    {
        DeclaredTypeSpliceNode ret = new DeclaredTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DeclaredTypeSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DeclaredTypeSpliceNode makeDeclaredTypeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DeclaredTypeSpliceNode ret = new DeclaredTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DoWhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoWhileLoopNode makeDoWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DoWhileLoopNode ret = new DoWhileLoopNodeImpl(condition, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DoubleLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value)
    {
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a DoubleLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public DoubleLiteralNode makeDoubleLiteralNode(
            Double value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        DoubleLiteralNode ret = new DoubleLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement)
    {
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnhancedForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnhancedForLoopNode makeEnhancedForLoopNode(
            VariableNode variable,
            ExpressionNode expression,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnhancedForLoopNode ret = new EnhancedForLoopNodeImpl(variable, expression, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNode(
            EnumConstantDeclarationListNode constants,
            ClassMemberListNode members)
    {
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumBodyNode makeEnumBodyNode(
            EnumConstantDeclarationListNode constants,
            ClassMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumBodyNode ret = new EnumBodyNodeImpl(constants, members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumBodySpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumBodySpliceNode makeEnumBodySpliceNode(
            ExpressionNode spliceExpression)
    {
        EnumBodySpliceNode ret = new EnumBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumBodySpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumBodySpliceNode makeEnumBodySpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumBodySpliceNode ret = new EnumBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            List<EnumConstantDeclarationNode> children)
    {
        EnumConstantDeclarationListNode ret = new EnumConstantDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            EnumConstantDeclarationNode... childrenElements)
    {
        List<EnumConstantDeclarationNode> children = Arrays.asList(childrenElements);
        return makeEnumConstantDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            List<EnumConstantDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantDeclarationListNode ret = new EnumConstantDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationListNode makeEnumConstantDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            EnumConstantDeclarationNode... childrenElements)
    {
        List<EnumConstantDeclarationNode> children = Arrays.asList(childrenElements);
        return makeEnumConstantDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a EnumConstantDeclarationListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationListSpliceNode makeEnumConstantDeclarationListSpliceNode(
            ExpressionNode spliceExpression)
    {
        EnumConstantDeclarationListSpliceNode ret = new EnumConstantDeclarationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationListSpliceNode makeEnumConstantDeclarationListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantDeclarationListSpliceNode ret = new EnumConstantDeclarationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc)
    {
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(modifiers, identifier, arguments, body, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(modifiers, identifier, arguments, body, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            JavadocNode javadoc)
    {
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(modifiers, identifier, arguments, null, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationNode makeEnumConstantDeclarationNode(
            EnumConstantModifiersNode modifiers,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantDeclarationNode ret = new EnumConstantDeclarationNodeImpl(modifiers, identifier, arguments, null, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantDeclarationSpliceNode makeEnumConstantDeclarationSpliceNode(
            ExpressionNode spliceExpression)
    {
        EnumConstantDeclarationSpliceNode ret = new EnumConstantDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantDeclarationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantDeclarationSpliceNode makeEnumConstantDeclarationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantDeclarationSpliceNode ret = new EnumConstantDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
    )
    {
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantModifiersNode makeEnumConstantModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantModifiersNode ret = new EnumConstantModifiersNodeImpl(makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumConstantModifiersSpliceNode makeEnumConstantModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        EnumConstantModifiersSpliceNode ret = new EnumConstantModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumConstantModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumConstantModifiersSpliceNode makeEnumConstantModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumConstantModifiersSpliceNode ret = new EnumConstantModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            DeclaredTypeListNode implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumDeclarationNode makeEnumDeclarationNode(
            EnumModifiersNode modifiers,
            DeclaredTypeListNode implementsClause,
            EnumBodyNode body,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumDeclarationNode ret = new EnumDeclarationNodeImpl(modifiers, implementsClause, body, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access)
    {
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumModifiersNode makeEnumModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumModifiersNode ret = new EnumModifiersNodeImpl(access, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public EnumModifiersSpliceNode makeEnumModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        EnumModifiersSpliceNode ret = new EnumModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a EnumModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public EnumModifiersSpliceNode makeEnumModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        EnumModifiersSpliceNode ret = new EnumModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            List<ExpressionNode> children)
    {
        ExpressionListNode ret = new ExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            ExpressionNode... childrenElements)
    {
        List<ExpressionNode> children = Arrays.asList(childrenElements);
        return makeExpressionListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            List<ExpressionNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ExpressionListNode ret = new ExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionListNode makeExpressionListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ExpressionNode... childrenElements)
    {
        List<ExpressionNode> children = Arrays.asList(childrenElements);
        return makeExpressionListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ExpressionListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionListSpliceNode makeExpressionListSpliceNode(
            ExpressionNode spliceExpression)
    {
        ExpressionListSpliceNode ret = new ExpressionListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionListSpliceNode makeExpressionListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ExpressionListSpliceNode ret = new ExpressionListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionSpliceNode makeExpressionSpliceNode(
            ExpressionNode spliceExpression)
    {
        ExpressionSpliceNode ret = new ExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionSpliceNode makeExpressionSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ExpressionSpliceNode ret = new ExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            MetaAnnotationListNode metaAnnotations)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ExpressionStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ExpressionStatementNode makeExpressionStatementNode(
            StatementExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ExpressionStatementNode ret = new ExpressionStatementNodeImpl(expression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc)
    {
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldDeclarationNode makeFieldDeclarationNode(
            FieldModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldDeclarationNode ret = new FieldDeclarationNodeImpl(modifiers, type, declarators, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean finalFlag,
            boolean transientFlag,
            boolean volatileFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, staticFlag, finalFlag, transientFlag, volatileFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access)
    {
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, false, false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldModifiersNode makeFieldModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldModifiersNode ret = new FieldModifiersNodeImpl(access, false, false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FieldModifiersSpliceNode makeFieldModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        FieldModifiersSpliceNode ret = new FieldModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FieldModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FieldModifiersSpliceNode makeFieldModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FieldModifiersSpliceNode ret = new FieldModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FloatLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value)
    {
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a FloatLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public FloatLiteralNode makeFloatLiteralNode(
            Float value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        FloatLiteralNode ret = new FloatLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            LocalVariableDeclarationNode declaration)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForInitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerDeclarationNode makeForInitializerDeclarationNode(
            LocalVariableDeclarationNode declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForInitializerDeclarationNode ret = new ForInitializerDeclarationNodeImpl(declaration, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            StatementExpressionListNode expressions)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForInitializerExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerExpressionNode makeForInitializerExpressionNode(
            StatementExpressionListNode expressions,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForInitializerExpressionNode ret = new ForInitializerExpressionNodeImpl(expressions, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForInitializerSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForInitializerSpliceNode makeForInitializerSpliceNode(
            ExpressionNode spliceExpression)
    {
        ForInitializerSpliceNode ret = new ForInitializerSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForInitializerSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForInitializerSpliceNode makeForInitializerSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForInitializerSpliceNode ret = new ForInitializerSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement)
    {
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ForLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ForLoopNode makeForLoopNode(
            ForInitializerNode initializer,
            ExpressionNode condition,
            StatementExpressionListNode update,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ForLoopNode ret = new ForLoopNodeImpl(initializer, condition, update, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            List<IdentifierNode> children)
    {
        IdentifierListNode ret = new IdentifierListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            IdentifierNode... childrenElements)
    {
        List<IdentifierNode> children = Arrays.asList(childrenElements);
        return makeIdentifierListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a IdentifierListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            List<IdentifierNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IdentifierListNode ret = new IdentifierListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierListNode makeIdentifierListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            IdentifierNode... childrenElements)
    {
        List<IdentifierNode> children = Arrays.asList(childrenElements);
        return makeIdentifierListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a IdentifierListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierListSpliceNode makeIdentifierListSpliceNode(
            ExpressionNode spliceExpression)
    {
        IdentifierListSpliceNode ret = new IdentifierListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierListSpliceNode makeIdentifierListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IdentifierListSpliceNode ret = new IdentifierListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier)
    {
        IdentifierNode ret = new IdentifierNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierNode makeIdentifierNode(
            String identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IdentifierNode ret = new IdentifierNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IdentifierSpliceNode makeIdentifierSpliceNode(
            ExpressionNode spliceExpression)
    {
        IdentifierSpliceNode ret = new IdentifierSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IdentifierSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IdentifierSpliceNode makeIdentifierSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IdentifierSpliceNode ret = new IdentifierSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            MetaAnnotationListNode metaAnnotations)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, elseStatement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IfNode makeIfNode(
            ExpressionNode condition,
            StatementNode thenStatement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IfNode ret = new IfNodeImpl(condition, thenStatement, null, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            List<ImportNode> children)
    {
        ImportListNode ret = new ImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            ImportNode... childrenElements)
    {
        List<ImportNode> children = Arrays.asList(childrenElements);
        return makeImportListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            List<ImportNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ImportListNode ret = new ImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportListNode makeImportListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ImportNode... childrenElements)
    {
        List<ImportNode> children = Arrays.asList(childrenElements);
        return makeImportListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ImportListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportListSpliceNode makeImportListSpliceNode(
            ExpressionNode spliceExpression)
    {
        ImportListSpliceNode ret = new ImportListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportListSpliceNode makeImportListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ImportListSpliceNode ret = new ImportListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportSpliceNode makeImportSpliceNode(
            ExpressionNode spliceExpression)
    {
        ImportSpliceNode ret = new ImportSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportSpliceNode makeImportSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ImportSpliceNode ret = new ImportSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportOnDemandNode makeImportOnDemandNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ImportOnDemandNode ret = new ImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name)
    {
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ImportSingleTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ImportSingleTypeNode makeImportSingleTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ImportSingleTypeNode ret = new ImportSingleTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InitializerDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InitializerDeclarationNode makeInitializerDeclarationNode(
            boolean staticInitializer,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InitializerDeclarationNode ret = new InitializerDeclarationNodeImpl(staticInitializer, body, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InstanceOfNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type)
    {
        InstanceOfNode ret = new InstanceOfNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InstanceOfNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InstanceOfNode makeInstanceOfNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InstanceOfNode ret = new InstanceOfNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IntLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a IntLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public IntLiteralNode makeIntLiteralNode(
            Integer value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        IntLiteralNode ret = new IntLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            InterfaceMemberListNode members)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceBodyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceBodyNode makeInterfaceBodyNode(
            InterfaceMemberListNode members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceBodyNode ret = new InterfaceBodyNodeImpl(members, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceBodySpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceBodySpliceNode makeInterfaceBodySpliceNode(
            ExpressionNode spliceExpression)
    {
        InterfaceBodySpliceNode ret = new InterfaceBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceBodySpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceBodySpliceNode makeInterfaceBodySpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceBodySpliceNode ret = new InterfaceBodySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            DeclaredTypeListNode extendsClause,
            InterfaceBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceDeclarationNode makeInterfaceDeclarationNode(
            InterfaceModifiersNode modifiers,
            DeclaredTypeListNode extendsClause,
            InterfaceBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceDeclarationNode ret = new InterfaceDeclarationNodeImpl(modifiers, extendsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            List<InterfaceMemberNode> children)
    {
        InterfaceMemberListNode ret = new InterfaceMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            InterfaceMemberNode... childrenElements)
    {
        List<InterfaceMemberNode> children = Arrays.asList(childrenElements);
        return makeInterfaceMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            List<InterfaceMemberNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceMemberListNode ret = new InterfaceMemberListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberListNode makeInterfaceMemberListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            InterfaceMemberNode... childrenElements)
    {
        List<InterfaceMemberNode> children = Arrays.asList(childrenElements);
        return makeInterfaceMemberListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a InterfaceMemberListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberListSpliceNode makeInterfaceMemberListSpliceNode(
            ExpressionNode spliceExpression)
    {
        InterfaceMemberListSpliceNode ret = new InterfaceMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberListSpliceNode makeInterfaceMemberListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceMemberListSpliceNode ret = new InterfaceMemberListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        InterfaceMemberMetaprogramAnchorNode ret = new InterfaceMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode makeInterfaceMemberMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceMemberMetaprogramAnchorNode ret = new InterfaceMemberMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceMemberSpliceNode makeInterfaceMemberSpliceNode(
            ExpressionNode spliceExpression)
    {
        InterfaceMemberSpliceNode ret = new InterfaceMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceMemberSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceMemberSpliceNode makeInterfaceMemberSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceMemberSpliceNode ret = new InterfaceMemberSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            boolean staticFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, staticFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access)
    {
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceModifiersNode makeInterfaceModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceModifiersNode ret = new InterfaceModifiersNodeImpl(access, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public InterfaceModifiersSpliceNode makeInterfaceModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        InterfaceModifiersSpliceNode ret = new InterfaceModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a InterfaceModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public InterfaceModifiersSpliceNode makeInterfaceModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        InterfaceModifiersSpliceNode ret = new InterfaceModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a JavadocNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text)
    {
        JavadocNode ret = new JavadocNodeImpl(text, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a JavadocNode.
     * The specified start and stop locations are used.
     */
    @Override
    public JavadocNode makeJavadocNode(
            String text,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        JavadocNode ret = new JavadocNodeImpl(text, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a JavadocSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public JavadocSpliceNode makeJavadocSpliceNode(
            ExpressionNode spliceExpression)
    {
        JavadocSpliceNode ret = new JavadocSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a JavadocSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public JavadocSpliceNode makeJavadocSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        JavadocSpliceNode ret = new JavadocSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement)
    {
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LabeledStatementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LabeledStatementNode makeLabeledStatementNode(
            IdentifierNode label,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LabeledStatementNode ret = new LabeledStatementNodeImpl(label, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LiteralizableTypeSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LiteralizableTypeSpliceNode makeLiteralizableTypeSpliceNode(
            ExpressionNode spliceExpression)
    {
        LiteralizableTypeSpliceNode ret = new LiteralizableTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LiteralizableTypeSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LiteralizableTypeSpliceNode makeLiteralizableTypeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LiteralizableTypeSpliceNode ret = new LiteralizableTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(
            LocalClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc)
    {
        LocalClassDeclarationNode ret = new LocalClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassDeclarationNode makeLocalClassDeclarationNode(
            LocalClassModifiersNode modifiers,
            DeclaredTypeNode extendsClause,
            DeclaredTypeListNode implementsClause,
            ClassBodyNode body,
            TypeParameterListNode typeParameters,
            IdentifierNode identifier,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LocalClassDeclarationNode ret = new LocalClassDeclarationNodeImpl(modifiers, extendsClause, implementsClause, body, typeParameters, identifier, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(abstractFlag, finalFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
    )
    {
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassModifiersNode makeLocalClassModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LocalClassModifiersNode ret = new LocalClassModifiersNodeImpl(false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalClassModifiersSpliceNode makeLocalClassModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        LocalClassModifiersSpliceNode ret = new LocalClassModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalClassModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalClassModifiersSpliceNode makeLocalClassModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LocalClassModifiersSpliceNode ret = new LocalClassModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators)
    {
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(modifiers, type, declarators, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            VariableDeclaratorListNode declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(modifiers, type, declarators, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            TypeNode type,
            VariableDeclaratorListNode declarators)
    {
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(makeVariableModifiersNode(), type, declarators, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalVariableDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalVariableDeclarationNode makeLocalVariableDeclarationNode(
            TypeNode type,
            VariableDeclaratorListNode declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LocalVariableDeclarationNode ret = new LocalVariableDeclarationNodeImpl(makeVariableModifiersNode(), type, declarators, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalVariableDeclarationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LocalVariableDeclarationSpliceNode makeLocalVariableDeclarationSpliceNode(
            ExpressionNode spliceExpression)
    {
        LocalVariableDeclarationSpliceNode ret = new LocalVariableDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LocalVariableDeclarationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LocalVariableDeclarationSpliceNode makeLocalVariableDeclarationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LocalVariableDeclarationSpliceNode ret = new LocalVariableDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LongLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a LongLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public LongLiteralNode makeLongLiteralNode(
            Long value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        LongLiteralNode ret = new LongLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(
            MetaAnnotationValueListNode values)
    {
        MetaAnnotationArrayValueNode ret = new MetaAnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationArrayValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationArrayValueNode makeMetaAnnotationArrayValueNode(
            MetaAnnotationValueListNode values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationArrayValueNode ret = new MetaAnnotationArrayValueNodeImpl(values, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            List<MetaAnnotationElementNode> children)
    {
        MetaAnnotationElementListNode ret = new MetaAnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            MetaAnnotationElementNode... childrenElements)
    {
        List<MetaAnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationElementListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            List<MetaAnnotationElementNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationElementListNode ret = new MetaAnnotationElementListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementListNode makeMetaAnnotationElementListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationElementNode... childrenElements)
    {
        List<MetaAnnotationElementNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationElementListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaAnnotationElementListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementListSpliceNode makeMetaAnnotationElementListSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaAnnotationElementListSpliceNode ret = new MetaAnnotationElementListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementListSpliceNode makeMetaAnnotationElementListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationElementListSpliceNode ret = new MetaAnnotationElementListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(
            IdentifierNode identifier,
            MetaAnnotationValueNode value)
    {
        MetaAnnotationElementNode ret = new MetaAnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementNode makeMetaAnnotationElementNode(
            IdentifierNode identifier,
            MetaAnnotationValueNode value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationElementNode ret = new MetaAnnotationElementNodeImpl(identifier, value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationElementSpliceNode makeMetaAnnotationElementSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaAnnotationElementSpliceNode ret = new MetaAnnotationElementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationElementSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationElementSpliceNode makeMetaAnnotationElementSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationElementSpliceNode ret = new MetaAnnotationElementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression)
    {
        MetaAnnotationExpressionValueNode ret = new MetaAnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationExpressionValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationExpressionValueNode makeMetaAnnotationExpressionValueNode(
            NonAssignmentExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationExpressionValueNode ret = new MetaAnnotationExpressionValueNodeImpl(expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            List<MetaAnnotationNode> children)
    {
        MetaAnnotationListNode ret = new MetaAnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            MetaAnnotationNode... childrenElements)
    {
        List<MetaAnnotationNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            List<MetaAnnotationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationListNode ret = new MetaAnnotationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationListNode makeMetaAnnotationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationNode... childrenElements)
    {
        List<MetaAnnotationNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaAnnotationListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationListSpliceNode makeMetaAnnotationListSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaAnnotationListSpliceNode ret = new MetaAnnotationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationListSpliceNode makeMetaAnnotationListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationListSpliceNode ret = new MetaAnnotationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(
            MetaAnnotationNode annotation)
    {
        MetaAnnotationMetaAnnotationValueNode ret = new MetaAnnotationMetaAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaAnnotationValueNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode makeMetaAnnotationMetaAnnotationValueNode(
            MetaAnnotationNode annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationMetaAnnotationValueNode ret = new MetaAnnotationMetaAnnotationValueNodeImpl(annotation, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(
    )
    {
        MetaAnnotationMetaprogramAnchorNode ret = new MetaAnnotationMetaprogramAnchorNodeImpl(null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorNode makeMetaAnnotationMetaprogramAnchorNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationMetaprogramAnchorNode ret = new MetaAnnotationMetaprogramAnchorNodeImpl(null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorSpliceNode makeMetaAnnotationMetaprogramAnchorSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaAnnotationMetaprogramAnchorSpliceNode ret = new MetaAnnotationMetaprogramAnchorSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationMetaprogramAnchorSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorSpliceNode makeMetaAnnotationMetaprogramAnchorSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationMetaprogramAnchorSpliceNode ret = new MetaAnnotationMetaprogramAnchorSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationSpliceNode makeMetaAnnotationSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaAnnotationSpliceNode ret = new MetaAnnotationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationSpliceNode makeMetaAnnotationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationSpliceNode ret = new MetaAnnotationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            List<MetaAnnotationValueNode> children)
    {
        MetaAnnotationValueListNode ret = new MetaAnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            MetaAnnotationValueNode... childrenElements)
    {
        List<MetaAnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationValueListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            List<MetaAnnotationValueNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationValueListNode ret = new MetaAnnotationValueListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationValueListNode makeMetaAnnotationValueListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaAnnotationValueNode... childrenElements)
    {
        List<MetaAnnotationValueNode> children = Arrays.asList(childrenElements);
        return makeMetaAnnotationValueListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaAnnotationValueListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueListSpliceNode makeMetaAnnotationValueListSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaAnnotationValueListSpliceNode ret = new MetaAnnotationValueListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationValueListSpliceNode makeMetaAnnotationValueListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationValueListSpliceNode ret = new MetaAnnotationValueListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaAnnotationValueSpliceNode makeMetaAnnotationValueSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaAnnotationValueSpliceNode ret = new MetaAnnotationValueSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaAnnotationValueSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaAnnotationValueSpliceNode makeMetaAnnotationValueSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaAnnotationValueSpliceNode ret = new MetaAnnotationValueSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            List<MetaprogramDependencyDeclarationNode> children)
    {
        MetaprogramDependencyDeclarationListNode ret = new MetaprogramDependencyDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            MetaprogramDependencyDeclarationNode... childrenElements)
    {
        List<MetaprogramDependencyDeclarationNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            List<MetaprogramDependencyDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyDeclarationListNode ret = new MetaprogramDependencyDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListNode makeMetaprogramDependencyDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramDependencyDeclarationNode... childrenElements)
    {
        List<MetaprogramDependencyDeclarationNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListSpliceNode makeMetaprogramDependencyDeclarationListSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramDependencyDeclarationListSpliceNode ret = new MetaprogramDependencyDeclarationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationListSpliceNode makeMetaprogramDependencyDeclarationListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyDeclarationListSpliceNode ret = new MetaprogramDependencyDeclarationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(
            MetaprogramDependencyListNode targets)
    {
        MetaprogramDependencyDeclarationNode ret = new MetaprogramDependencyDeclarationNodeImpl(targets, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationNode makeMetaprogramDependencyDeclarationNode(
            MetaprogramDependencyListNode targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyDeclarationNode ret = new MetaprogramDependencyDeclarationNodeImpl(targets, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyDeclarationSpliceNode makeMetaprogramDependencyDeclarationSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramDependencyDeclarationSpliceNode ret = new MetaprogramDependencyDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyDeclarationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyDeclarationSpliceNode makeMetaprogramDependencyDeclarationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyDeclarationSpliceNode ret = new MetaprogramDependencyDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            List<MetaprogramDependencyNode> children)
    {
        MetaprogramDependencyListNode ret = new MetaprogramDependencyListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            MetaprogramDependencyNode... childrenElements)
    {
        List<MetaprogramDependencyNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            List<MetaprogramDependencyNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyListNode ret = new MetaprogramDependencyListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyListNode makeMetaprogramDependencyListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramDependencyNode... childrenElements)
    {
        List<MetaprogramDependencyNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramDependencyListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramDependencyListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyListSpliceNode makeMetaprogramDependencyListSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramDependencyListSpliceNode ret = new MetaprogramDependencyListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyListSpliceNode makeMetaprogramDependencyListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyListSpliceNode ret = new MetaprogramDependencyListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            boolean weak)
    {
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(targetName, weak, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            boolean weak,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(targetName, weak, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName)
    {
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(targetName, false, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencyNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencyNode makeMetaprogramDependencyNode(
            NameNode targetName,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencyNode ret = new MetaprogramDependencyNodeImpl(targetName, false, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencySpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramDependencySpliceNode makeMetaprogramDependencySpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramDependencySpliceNode ret = new MetaprogramDependencySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramDependencySpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramDependencySpliceNode makeMetaprogramDependencySpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramDependencySpliceNode ret = new MetaprogramDependencySpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            List<MetaprogramImportNode> children)
    {
        MetaprogramImportListNode ret = new MetaprogramImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            MetaprogramImportNode... childrenElements)
    {
        List<MetaprogramImportNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramImportListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            List<MetaprogramImportNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramImportListNode ret = new MetaprogramImportListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportListNode makeMetaprogramImportListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramImportNode... childrenElements)
    {
        List<MetaprogramImportNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramImportListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramImportListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportListSpliceNode makeMetaprogramImportListSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramImportListSpliceNode ret = new MetaprogramImportListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportListSpliceNode makeMetaprogramImportListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramImportListSpliceNode ret = new MetaprogramImportListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNode(
            ImportNode importNode)
    {
        MetaprogramImportNode ret = new MetaprogramImportNodeImpl(importNode, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportNode makeMetaprogramImportNode(
            ImportNode importNode,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramImportNode ret = new MetaprogramImportNodeImpl(importNode, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramImportSpliceNode makeMetaprogramImportSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramImportSpliceNode ret = new MetaprogramImportSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramImportSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramImportSpliceNode makeMetaprogramImportSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramImportSpliceNode ret = new MetaprogramImportSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNode(
            MetaprogramPreambleNode preamble,
            BlockStatementListNode body)
    {
        MetaprogramNode ret = new MetaprogramNodeImpl(preamble, body, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramNode makeMetaprogramNode(
            MetaprogramPreambleNode preamble,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramNode ret = new MetaprogramNodeImpl(preamble, body, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramSpliceNode makeMetaprogramSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramSpliceNode ret = new MetaprogramSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramSpliceNode makeMetaprogramSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramSpliceNode ret = new MetaprogramSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies)
    {
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(imports, localMode, packageMode, targets, dependencies, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(imports, localMode, packageMode, targets, dependencies, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies)
    {
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(imports, MetaprogramLocalMode.INSERT, MetaprogramPackageMode.READ_ONLY, targets, dependencies, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramPreambleNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramPreambleNode makeMetaprogramPreambleNode(
            MetaprogramImportListNode imports,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramPreambleNode ret = new MetaprogramPreambleNodeImpl(imports, MetaprogramLocalMode.INSERT, MetaprogramPackageMode.READ_ONLY, targets, dependencies, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramPreambleSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramPreambleSpliceNode makeMetaprogramPreambleSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramPreambleSpliceNode ret = new MetaprogramPreambleSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramPreambleSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramPreambleSpliceNode makeMetaprogramPreambleSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramPreambleSpliceNode ret = new MetaprogramPreambleSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            List<MetaprogramTargetNode> children)
    {
        MetaprogramTargetListNode ret = new MetaprogramTargetListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            MetaprogramTargetNode... childrenElements)
    {
        List<MetaprogramTargetNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramTargetListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            List<MetaprogramTargetNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramTargetListNode ret = new MetaprogramTargetListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetListNode makeMetaprogramTargetListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            MetaprogramTargetNode... childrenElements)
    {
        List<MetaprogramTargetNode> children = Arrays.asList(childrenElements);
        return makeMetaprogramTargetListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a MetaprogramTargetListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetListSpliceNode makeMetaprogramTargetListSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramTargetListSpliceNode ret = new MetaprogramTargetListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetListSpliceNode makeMetaprogramTargetListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramTargetListSpliceNode ret = new MetaprogramTargetListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNode(
            IdentifierListNode targets)
    {
        MetaprogramTargetNode ret = new MetaprogramTargetNodeImpl(targets, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetNode makeMetaprogramTargetNode(
            IdentifierListNode targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramTargetNode ret = new MetaprogramTargetNodeImpl(targets, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MetaprogramTargetSpliceNode makeMetaprogramTargetSpliceNode(
            ExpressionNode spliceExpression)
    {
        MetaprogramTargetSpliceNode ret = new MetaprogramTargetSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MetaprogramTargetSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MetaprogramTargetSpliceNode makeMetaprogramTargetSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MetaprogramTargetSpliceNode ret = new MetaprogramTargetSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            VariableNode varargParameter,
            TypeNode returnType,
            UnparameterizedTypeListNode throwTypes,
            TypeParameterListNode typeParameters,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, varargParameter, returnType, throwTypes, typeParameters, javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            TypeNode returnType,
            JavadocNode javadoc)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, null, returnType, makeUnparameterizedTypeListNode(), makeTypeParameterListNode(), javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodDeclarationNode makeMethodDeclarationNode(
            BlockStatementListNode body,
            MethodModifiersNode modifiers,
            IdentifierNode identifier,
            VariableListNode parameters,
            TypeNode returnType,
            JavadocNode javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodDeclarationNode ret = new MethodDeclarationNodeImpl(body, modifiers, identifier, parameters, null, returnType, makeUnparameterizedTypeListNode(), makeTypeParameterListNode(), javadoc, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(null, identifier, makeExpressionListNode(), makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(null, identifier, makeExpressionListNode(), makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, makeExpressionListNode(), makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, makeExpressionListNode(), makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(null, identifier, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(null, identifier, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodInvocationNode makeMethodInvocationNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodInvocationNode ret = new MethodInvocationNodeImpl(expression, identifier, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, abstractFlag, staticFlag, finalFlag, synchronizedFlag, nativeFlag, strictfpFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access)
    {
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, false, false, false, false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodModifiersNode makeMethodModifiersNode(
            AccessModifier access,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodModifiersNode ret = new MethodModifiersNodeImpl(access, false, false, false, false, false, false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public MethodModifiersSpliceNode makeMethodModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        MethodModifiersSpliceNode ret = new MethodModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a MethodModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public MethodModifiersSpliceNode makeMethodModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        MethodModifiersSpliceNode ret = new MethodModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ModifiersSpliceNode makeModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        ModifiersSpliceNode ret = new ModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ModifiersSpliceNode makeModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ModifiersSpliceNode ret = new ModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NameSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NameSpliceNode makeNameSpliceNode(
            ExpressionNode spliceExpression)
    {
        NameSpliceNode ret = new NameSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NameSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NameSpliceNode makeNameSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NameSpliceNode ret = new NameSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
            MetaAnnotationListNode metaAnnotations)
    {
        NoOperationNode ret = new NoOperationNodeImpl(metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NoOperationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NoOperationNode ret = new NoOperationNodeImpl(metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NoOperationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
    )
    {
        NoOperationNode ret = new NoOperationNodeImpl(makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NoOperationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NoOperationNode makeNoOperationNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NoOperationNode ret = new NoOperationNodeImpl(makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NonAssignmentExpressionSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NonAssignmentExpressionSpliceNode makeNonAssignmentExpressionSpliceNode(
            ExpressionNode spliceExpression)
    {
        NonAssignmentExpressionSpliceNode ret = new NonAssignmentExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NonAssignmentExpressionSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NonAssignmentExpressionSpliceNode makeNonAssignmentExpressionSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NonAssignmentExpressionSpliceNode ret = new NonAssignmentExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NormalAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNode(
            AnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType)
    {
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NormalAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalAnnotationNode makeNormalAnnotationNode(
            AnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NormalAnnotationNode ret = new NormalAnnotationNodeImpl(arguments, annotationType, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType)
    {
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(arguments, annotationType, null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NormalMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NormalMetaAnnotationNode makeNormalMetaAnnotationNode(
            MetaAnnotationElementListNode arguments,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NormalMetaAnnotationNode ret = new NormalMetaAnnotationNodeImpl(arguments, annotationType, null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NullLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
    )
    {
        NullLiteralNode ret = new NullLiteralNodeImpl(null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a NullLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public NullLiteralNode makeNullLiteralNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        NullLiteralNode ret = new NullLiteralNodeImpl(null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageDeclarationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageDeclarationNode makePackageDeclarationNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PackageDeclarationNode ret = new PackageDeclarationNodeImpl(name, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageDeclarationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageDeclarationSpliceNode makePackageDeclarationSpliceNode(
            ExpressionNode spliceExpression)
    {
        PackageDeclarationSpliceNode ret = new PackageDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageDeclarationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageDeclarationSpliceNode makePackageDeclarationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PackageDeclarationSpliceNode ret = new PackageDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PackageNode makePackageNode(
            IdentifierNode name)
    {
        PackageNode ret = new PackageNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PackageNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PackageNode makePackageNode(
            IdentifierNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PackageNode ret = new PackageNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments)
    {
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(baseType, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeNode makeParameterizedTypeNode(
            UnparameterizedTypeNode baseType,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ParameterizedTypeNode ret = new ParameterizedTypeNodeImpl(baseType, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParameterizedTypeSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeSpliceNode makeParameterizedTypeSpliceNode(
            ExpressionNode spliceExpression)
    {
        ParameterizedTypeSpliceNode ret = new ParameterizedTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParameterizedTypeSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeSpliceNode makeParameterizedTypeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ParameterizedTypeSpliceNode ret = new ParameterizedTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select)
    {
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(base, select, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParameterizedTypeSelectNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParameterizedTypeSelectNode makeParameterizedTypeSelectNode(
            ParameterizedTypeNode base,
            DeclaredTypeNode select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ParameterizedTypeSelectNode ret = new ParameterizedTypeSelectNodeImpl(base, select, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ParenthesizedExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ParenthesizedExpressionNode makeParenthesizedExpressionNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ParenthesizedExpressionNode ret = new ParenthesizedExpressionNodeImpl(expression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PrimaryExpressionSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PrimaryExpressionSpliceNode makePrimaryExpressionSpliceNode(
            ExpressionNode spliceExpression)
    {
        PrimaryExpressionSpliceNode ret = new PrimaryExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PrimaryExpressionSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PrimaryExpressionSpliceNode makePrimaryExpressionSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PrimaryExpressionSpliceNode ret = new PrimaryExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PrimitiveTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType)
    {
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a PrimitiveTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public PrimitiveTypeNode makePrimitiveTypeNode(
            PrimitiveType primitiveType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        PrimitiveTypeNode ret = new PrimitiveTypeNodeImpl(primitiveType, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body)
    {
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments)
    {
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, makeTypeArgumentListNode(), makeExpressionListNode(), null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a QualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedClassInstantiationNode makeQualifiedClassInstantiationNode(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            TypeArgumentListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        QualifiedClassInstantiationNode ret = new QualifiedClassInstantiationNodeImpl(enclosingExpression, identifier, typeArguments, makeTypeArgumentListNode(), makeExpressionListNode(), null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a QualifiedNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier)
    {
        QualifiedNameNode ret = new QualifiedNameNodeImpl(base, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a QualifiedNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public QualifiedNameNode makeQualifiedNameNode(
            NameNode base,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        QualifiedNameNode ret = new QualifiedNameNodeImpl(base, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a RawCodeLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public RawCodeLiteralNode makeRawCodeLiteralNode(
            BsjRawCodeLiteralPayload value)
    {
        RawCodeLiteralNode ret = new RawCodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a RawCodeLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public RawCodeLiteralNode makeRawCodeLiteralNode(
            BsjRawCodeLiteralPayload value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        RawCodeLiteralNode ret = new RawCodeLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            List<ReferenceTypeNode> children)
    {
        ReferenceTypeListNode ret = new ReferenceTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            ReferenceTypeNode... childrenElements)
    {
        List<ReferenceTypeNode> children = Arrays.asList(childrenElements);
        return makeReferenceTypeListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            List<ReferenceTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ReferenceTypeListNode ret = new ReferenceTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReferenceTypeListNode makeReferenceTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            ReferenceTypeNode... childrenElements)
    {
        List<ReferenceTypeNode> children = Arrays.asList(childrenElements);
        return makeReferenceTypeListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a ReferenceTypeListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeListSpliceNode makeReferenceTypeListSpliceNode(
            ExpressionNode spliceExpression)
    {
        ReferenceTypeListSpliceNode ret = new ReferenceTypeListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReferenceTypeListSpliceNode makeReferenceTypeListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ReferenceTypeListSpliceNode ret = new ReferenceTypeListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReferenceTypeSpliceNode makeReferenceTypeSpliceNode(
            ExpressionNode spliceExpression)
    {
        ReferenceTypeSpliceNode ret = new ReferenceTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReferenceTypeSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReferenceTypeSpliceNode makeReferenceTypeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ReferenceTypeSpliceNode ret = new ReferenceTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a RestrictedPrimaryExpressionSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public RestrictedPrimaryExpressionSpliceNode makeRestrictedPrimaryExpressionSpliceNode(
            ExpressionNode spliceExpression)
    {
        RestrictedPrimaryExpressionSpliceNode ret = new RestrictedPrimaryExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a RestrictedPrimaryExpressionSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public RestrictedPrimaryExpressionSpliceNode makeRestrictedPrimaryExpressionSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        RestrictedPrimaryExpressionSpliceNode ret = new RestrictedPrimaryExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations)
    {
        ReturnNode ret = new ReturnNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ReturnNode ret = new ReturnNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReturnNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression)
    {
        ReturnNode ret = new ReturnNodeImpl(expression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ReturnNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ReturnNode makeReturnNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ReturnNode ret = new ReturnNodeImpl(expression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier)
    {
        SimpleNameNode ret = new SimpleNameNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SimpleNameNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SimpleNameNode makeSimpleNameNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SimpleNameNode ret = new SimpleNameNodeImpl(identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType)
    {
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SingleElementAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementAnnotationNode makeSingleElementAnnotationNode(
            AnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SingleElementAnnotationNode ret = new SingleElementAnnotationNodeImpl(value, annotationType, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType)
    {
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(value, annotationType, null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SingleElementMetaAnnotationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleElementMetaAnnotationNode makeSingleElementMetaAnnotationNode(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SingleElementMetaAnnotationNode ret = new SingleElementMetaAnnotationNodeImpl(value, annotationType, null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SingleStaticImportNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SingleStaticImportNode makeSingleStaticImportNode(
            NameNode name,
            IdentifierNode identifier)
    {
        SingleStaticImportNode ret = new SingleStaticImportNodeImpl(name, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SingleStaticImportNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SingleStaticImportNode makeSingleStaticImportNode(
            NameNode name,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SingleStaticImportNode ret = new SingleStaticImportNodeImpl(name, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SpliceNode makeSpliceNode(
            ExpressionNode spliceExpression)
    {
        SpliceNode ret = new SpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SpliceNode makeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SpliceNode ret = new SpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            List<StatementExpressionNode> children)
    {
        StatementExpressionListNode ret = new StatementExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            StatementExpressionNode... childrenElements)
    {
        List<StatementExpressionNode> children = Arrays.asList(childrenElements);
        return makeStatementExpressionListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            List<StatementExpressionNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        StatementExpressionListNode ret = new StatementExpressionListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementExpressionListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementExpressionListNode makeStatementExpressionListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            StatementExpressionNode... childrenElements)
    {
        List<StatementExpressionNode> children = Arrays.asList(childrenElements);
        return makeStatementExpressionListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a StatementExpressionListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionListSpliceNode makeStatementExpressionListSpliceNode(
            ExpressionNode spliceExpression)
    {
        StatementExpressionListSpliceNode ret = new StatementExpressionListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementExpressionListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementExpressionListSpliceNode makeStatementExpressionListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        StatementExpressionListSpliceNode ret = new StatementExpressionListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementExpressionSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementExpressionSpliceNode makeStatementExpressionSpliceNode(
            ExpressionNode spliceExpression)
    {
        StatementExpressionSpliceNode ret = new StatementExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementExpressionSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementExpressionSpliceNode makeStatementExpressionSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        StatementExpressionSpliceNode ret = new StatementExpressionSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StatementSpliceNode makeStatementSpliceNode(
            ExpressionNode spliceExpression)
    {
        StatementSpliceNode ret = new StatementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StatementSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StatementSpliceNode makeStatementSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        StatementSpliceNode ret = new StatementSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(
            NameNode name)
    {
        StaticImportOnDemandNode ret = new StaticImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StaticImportOnDemandNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StaticImportOnDemandNode makeStaticImportOnDemandNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        StaticImportOnDemandNode ret = new StaticImportOnDemandNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StringLiteralNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value)
    {
        StringLiteralNode ret = new StringLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a StringLiteralNode.
     * The specified start and stop locations are used.
     */
    @Override
    public StringLiteralNode makeStringLiteralNode(
            String value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        StringLiteralNode ret = new StringLiteralNodeImpl(value, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(type, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            IdentifierNode identifier)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(null, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperFieldAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperFieldAccessNode makeSuperFieldAccessNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperFieldAccessNode ret = new SuperFieldAccessNodeImpl(null, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(type, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(null, identifier, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(null, identifier, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(null, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperMethodInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperMethodInvocationNode makeSuperMethodInvocationNode(
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperMethodInvocationNode ret = new SuperMethodInvocationNodeImpl(null, identifier, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments)
    {
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            PrimaryExpressionNode qualifyingExpression,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(qualifyingExpression, arguments, typeArguments, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            ExpressionListNode arguments)
    {
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(null, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SuperclassConstructorInvocationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SuperclassConstructorInvocationNode makeSuperclassConstructorInvocationNode(
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SuperclassConstructorInvocationNode ret = new SuperclassConstructorInvocationNodeImpl(null, arguments, makeReferenceTypeListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            MetaAnnotationListNode metaAnnotations)
    {
        SwitchNode ret = new SwitchNodeImpl(expression, cases, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SwitchNode ret = new SwitchNodeImpl(expression, cases, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SwitchNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases)
    {
        SwitchNode ret = new SwitchNodeImpl(expression, cases, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SwitchNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SwitchNode makeSwitchNode(
            ExpressionNode expression,
            CaseListNode cases,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SwitchNode ret = new SwitchNodeImpl(expression, cases, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations)
    {
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, body, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body)
    {
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, body, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a SynchronizedNode.
     * The specified start and stop locations are used.
     */
    @Override
    public SynchronizedNode makeSynchronizedNode(
            ExpressionNode expression,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        SynchronizedNode ret = new SynchronizedNodeImpl(expression, body, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type)
    {
        ThisNode ret = new ThisNodeImpl(type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThisNode makeThisNode(
            UnparameterizedTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ThisNode ret = new ThisNodeImpl(type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThisNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThisNode makeThisNode()
    {
        ThisNode ret = new ThisNodeImpl(null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThisNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThisNode makeThisNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ThisNode ret = new ThisNodeImpl(null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations)
    {
        ThrowNode ret = new ThrowNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ThrowNode ret = new ThrowNodeImpl(expression, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThrowNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression)
    {
        ThrowNode ret = new ThrowNodeImpl(expression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a ThrowNode.
     * The specified start and stop locations are used.
     */
    @Override
    public ThrowNode makeThrowNode(
            ExpressionNode expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        ThrowNode ret = new ThrowNodeImpl(expression, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            MetaAnnotationListNode metaAnnotations)
    {
        TryNode ret = new TryNodeImpl(body, catches, finallyBlock, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TryNode ret = new TryNodeImpl(body, catches, finallyBlock, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            BlockStatementListNode finallyBlock)
    {
        TryNode ret = new TryNodeImpl(body, makeCatchListNode(), finallyBlock, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            BlockStatementListNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TryNode ret = new TryNodeImpl(body, makeCatchListNode(), finallyBlock, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches)
    {
        TryNode ret = new TryNodeImpl(body, catches, makeBlockStatementListNode(), makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TryNode ret = new TryNodeImpl(body, catches, makeBlockStatementListNode(), makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock)
    {
        TryNode ret = new TryNodeImpl(body, catches, finallyBlock, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TryNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TryNode makeTryNode(
            BlockStatementListNode body,
            CatchListNode catches,
            BlockStatementListNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TryNode ret = new TryNodeImpl(body, catches, finallyBlock, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            List<TypeArgumentNode> children)
    {
        TypeArgumentListNode ret = new TypeArgumentListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            TypeArgumentNode... childrenElements)
    {
        List<TypeArgumentNode> children = Arrays.asList(childrenElements);
        return makeTypeArgumentListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            List<TypeArgumentNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeArgumentListNode ret = new TypeArgumentListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeArgumentListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeArgumentListNode makeTypeArgumentListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeArgumentNode... childrenElements)
    {
        List<TypeArgumentNode> children = Arrays.asList(childrenElements);
        return makeTypeArgumentListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a TypeArgumentListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentListSpliceNode makeTypeArgumentListSpliceNode(
            ExpressionNode spliceExpression)
    {
        TypeArgumentListSpliceNode ret = new TypeArgumentListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeArgumentListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeArgumentListSpliceNode makeTypeArgumentListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeArgumentListSpliceNode ret = new TypeArgumentListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeArgumentSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeArgumentSpliceNode makeTypeArgumentSpliceNode(
            ExpressionNode spliceExpression)
    {
        TypeArgumentSpliceNode ret = new TypeArgumentSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeArgumentSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeArgumentSpliceNode makeTypeArgumentSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeArgumentSpliceNode ret = new TypeArgumentSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeCastNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type)
    {
        TypeCastNode ret = new TypeCastNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeCastNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeCastNode makeTypeCastNode(
            ExpressionNode expression,
            TypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeCastNode ret = new TypeCastNodeImpl(expression, type, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            List<TypeDeclarationNode> children)
    {
        TypeDeclarationListNode ret = new TypeDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            TypeDeclarationNode... childrenElements)
    {
        List<TypeDeclarationNode> children = Arrays.asList(childrenElements);
        return makeTypeDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            List<TypeDeclarationNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeDeclarationListNode ret = new TypeDeclarationListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationListNode makeTypeDeclarationListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeDeclarationNode... childrenElements)
    {
        List<TypeDeclarationNode> children = Arrays.asList(childrenElements);
        return makeTypeDeclarationListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a TypeDeclarationListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationListSpliceNode makeTypeDeclarationListSpliceNode(
            ExpressionNode spliceExpression)
    {
        TypeDeclarationListSpliceNode ret = new TypeDeclarationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationListSpliceNode makeTypeDeclarationListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeDeclarationListSpliceNode ret = new TypeDeclarationListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram)
    {
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationMetaprogramAnchorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode makeTypeDeclarationMetaprogramAnchorNode(
            MetaprogramNode metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeDeclarationMetaprogramAnchorNode ret = new TypeDeclarationMetaprogramAnchorNodeImpl(metaprogram, makeNoOperationNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeDeclarationSpliceNode makeTypeDeclarationSpliceNode(
            ExpressionNode spliceExpression)
    {
        TypeDeclarationSpliceNode ret = new TypeDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeDeclarationSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeDeclarationSpliceNode makeTypeDeclarationSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeDeclarationSpliceNode ret = new TypeDeclarationSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeSpliceNode makeTypeSpliceNode(
            ExpressionNode spliceExpression)
    {
        TypeSpliceNode ret = new TypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeSpliceNode makeTypeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeSpliceNode ret = new TypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            List<TypeParameterNode> children)
    {
        TypeParameterListNode ret = new TypeParameterListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            TypeParameterNode... childrenElements)
    {
        List<TypeParameterNode> children = Arrays.asList(childrenElements);
        return makeTypeParameterListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            List<TypeParameterNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeParameterListNode ret = new TypeParameterListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterListNode makeTypeParameterListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            TypeParameterNode... childrenElements)
    {
        List<TypeParameterNode> children = Arrays.asList(childrenElements);
        return makeTypeParameterListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a TypeParameterListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterListSpliceNode makeTypeParameterListSpliceNode(
            ExpressionNode spliceExpression)
    {
        TypeParameterListSpliceNode ret = new TypeParameterListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterListSpliceNode makeTypeParameterListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeParameterListSpliceNode ret = new TypeParameterListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            DeclaredTypeListNode bounds)
    {
        TypeParameterNode ret = new TypeParameterNodeImpl(identifier, bounds, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterNode makeTypeParameterNode(
            IdentifierNode identifier,
            DeclaredTypeListNode bounds,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeParameterNode ret = new TypeParameterNodeImpl(identifier, bounds, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public TypeParameterSpliceNode makeTypeParameterSpliceNode(
            ExpressionNode spliceExpression)
    {
        TypeParameterSpliceNode ret = new TypeParameterSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a TypeParameterSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public TypeParameterSpliceNode makeTypeParameterSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        TypeParameterSpliceNode ret = new TypeParameterSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnaryExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator)
    {
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnaryExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryExpressionNode makeUnaryExpressionNode(
            ExpressionNode expression,
            UnaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnaryExpressionNode ret = new UnaryExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator)
    {
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnaryStatementExpressionNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnaryStatementExpressionNode makeUnaryStatementExpressionNode(
            ExpressionNode expression,
            UnaryStatementOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnaryStatementExpressionNode ret = new UnaryStatementExpressionNodeImpl(expression, operator, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            List<UnparameterizedTypeNode> children)
    {
        UnparameterizedTypeListNode ret = new UnparameterizedTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            UnparameterizedTypeNode... childrenElements)
    {
        List<UnparameterizedTypeNode> children = Arrays.asList(childrenElements);
        return makeUnparameterizedTypeListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            List<UnparameterizedTypeNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnparameterizedTypeListNode ret = new UnparameterizedTypeListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeListNode makeUnparameterizedTypeListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            UnparameterizedTypeNode... childrenElements)
    {
        List<UnparameterizedTypeNode> children = Arrays.asList(childrenElements);
        return makeUnparameterizedTypeListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a UnparameterizedTypeListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeListSpliceNode makeUnparameterizedTypeListSpliceNode(
            ExpressionNode spliceExpression)
    {
        UnparameterizedTypeListSpliceNode ret = new UnparameterizedTypeListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeListSpliceNode makeUnparameterizedTypeListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnparameterizedTypeListSpliceNode ret = new UnparameterizedTypeListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name)
    {
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeNode makeUnparameterizedTypeNode(
            NameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnparameterizedTypeNode ret = new UnparameterizedTypeNodeImpl(name, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnparameterizedTypeSpliceNode makeUnparameterizedTypeSpliceNode(
            ExpressionNode spliceExpression)
    {
        UnparameterizedTypeSpliceNode ret = new UnparameterizedTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnparameterizedTypeSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnparameterizedTypeSpliceNode makeUnparameterizedTypeSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnparameterizedTypeSpliceNode ret = new UnparameterizedTypeSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, makeTypeArgumentListNode(), makeExpressionListNode(), null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, makeTypeArgumentListNode(), makeExpressionListNode(), null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ExpressionListNode arguments)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, makeTypeArgumentListNode(), arguments, null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a UnqualifiedClassInstantiationNode.
     * The specified start and stop locations are used.
     */
    @Override
    public UnqualifiedClassInstantiationNode makeUnqualifiedClassInstantiationNode(
            DeclaredTypeNode type,
            ExpressionListNode arguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        UnqualifiedClassInstantiationNode ret = new UnqualifiedClassInstantiationNodeImpl(type, makeTypeArgumentListNode(), arguments, null, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier)
    {
        VariableAccessNode ret = new VariableAccessNodeImpl(expression, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableAccessNode ret = new VariableAccessNodeImpl(expression, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            IdentifierNode identifier)
    {
        VariableAccessNode ret = new VariableAccessNodeImpl(null, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableAccessNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableAccessNode makeVariableAccessNode(
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableAccessNode ret = new VariableAccessNodeImpl(null, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            List<VariableDeclaratorNode> children)
    {
        VariableDeclaratorListNode ret = new VariableDeclaratorListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            VariableDeclaratorNode... childrenElements)
    {
        List<VariableDeclaratorNode> children = Arrays.asList(childrenElements);
        return makeVariableDeclaratorListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            List<VariableDeclaratorNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableDeclaratorListNode ret = new VariableDeclaratorListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorListNode makeVariableDeclaratorListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableDeclaratorNode... childrenElements)
    {
        List<VariableDeclaratorNode> children = Arrays.asList(childrenElements);
        return makeVariableDeclaratorListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a VariableDeclaratorListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorListSpliceNode makeVariableDeclaratorListSpliceNode(
            ExpressionNode spliceExpression)
    {
        VariableDeclaratorListSpliceNode ret = new VariableDeclaratorListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorListSpliceNode makeVariableDeclaratorListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableDeclaratorListSpliceNode ret = new VariableDeclaratorListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            int arrayLevels,
            VariableInitializerNode initializer)
    {
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(identifier, arrayLevels, initializer, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            int arrayLevels,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(identifier, arrayLevels, initializer, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            VariableInitializerNode initializer)
    {
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(identifier, 0, initializer, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorNode makeVariableDeclaratorNode(
            IdentifierNode identifier,
            VariableInitializerNode initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableDeclaratorNode ret = new VariableDeclaratorNodeImpl(identifier, 0, initializer, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableDeclaratorSpliceNode makeVariableDeclaratorSpliceNode(
            ExpressionNode spliceExpression)
    {
        VariableDeclaratorSpliceNode ret = new VariableDeclaratorSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableDeclaratorSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableDeclaratorSpliceNode makeVariableDeclaratorSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableDeclaratorSpliceNode ret = new VariableDeclaratorSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            List<VariableInitializerNode> children)
    {
        VariableInitializerListNode ret = new VariableInitializerListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            VariableInitializerNode... childrenElements)
    {
        List<VariableInitializerNode> children = Arrays.asList(childrenElements);
        return makeVariableInitializerListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            List<VariableInitializerNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableInitializerListNode ret = new VariableInitializerListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableInitializerListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableInitializerListNode makeVariableInitializerListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableInitializerNode... childrenElements)
    {
        List<VariableInitializerNode> children = Arrays.asList(childrenElements);
        return makeVariableInitializerListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a VariableInitializerListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerListSpliceNode makeVariableInitializerListSpliceNode(
            ExpressionNode spliceExpression)
    {
        VariableInitializerListSpliceNode ret = new VariableInitializerListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableInitializerListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableInitializerListSpliceNode makeVariableInitializerListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableInitializerListSpliceNode ret = new VariableInitializerListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableInitializerSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableInitializerSpliceNode makeVariableInitializerSpliceNode(
            ExpressionNode spliceExpression)
    {
        VariableInitializerSpliceNode ret = new VariableInitializerSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableInitializerSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableInitializerSpliceNode makeVariableInitializerSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableInitializerSpliceNode ret = new VariableInitializerSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            List<VariableNode> children)
    {
        VariableListNode ret = new VariableListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableListNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            VariableNode... childrenElements)
    {
        List<VariableNode> children = Arrays.asList(childrenElements);
        return makeVariableListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a VariableListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            List<VariableNode> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableListNode ret = new VariableListNodeImpl(children, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableListNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableListNode makeVariableListNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            VariableNode... childrenElements)
    {
        List<VariableNode> children = Arrays.asList(childrenElements);
        return makeVariableListNode(children, startLocation, stopLocation);
    }
    
    /**
     * Creates a VariableListSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableListSpliceNode makeVariableListSpliceNode(
            ExpressionNode spliceExpression)
    {
        VariableListSpliceNode ret = new VariableListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableListSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableListSpliceNode makeVariableListSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableListSpliceNode ret = new VariableListSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations)
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            boolean finalFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(finalFlag, metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode()
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableModifiersNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableModifiersNode makeVariableModifiersNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableModifiersNode ret = new VariableModifiersNodeImpl(false, makeMetaAnnotationListNode(), makeAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableModifiersSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableModifiersSpliceNode makeVariableModifiersSpliceNode(
            ExpressionNode spliceExpression)
    {
        VariableModifiersSpliceNode ret = new VariableModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableModifiersSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableModifiersSpliceNode makeVariableModifiersSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableModifiersSpliceNode ret = new VariableModifiersSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier)
    {
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableNode makeVariableNode(
            VariableModifiersNode modifiers,
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableNode ret = new VariableNodeImpl(modifiers, type, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode identifier)
    {
        VariableNode ret = new VariableNodeImpl(makeVariableModifiersNode(), type, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableNode makeVariableNode(
            TypeNode type,
            IdentifierNode identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableNode ret = new VariableNodeImpl(makeVariableModifiersNode(), type, identifier, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableSpliceNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VariableSpliceNode makeVariableSpliceNode(
            ExpressionNode spliceExpression)
    {
        VariableSpliceNode ret = new VariableSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VariableSpliceNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VariableSpliceNode makeVariableSpliceNode(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VariableSpliceNode ret = new VariableSpliceNodeImpl(spliceExpression, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VoidTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
    )
    {
        VoidTypeNode ret = new VoidTypeNodeImpl(startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a VoidTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public VoidTypeNode makeVoidTypeNode(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        VoidTypeNode ret = new VoidTypeNodeImpl(startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations)
    {
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, metaAnnotations, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement)
    {
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a WhileLoopNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WhileLoopNode makeWhileLoopNode(
            ExpressionNode condition,
            StatementNode statement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        WhileLoopNode ret = new WhileLoopNodeImpl(condition, statement, makeMetaAnnotationListNode(), startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a WildcardTypeNode.
     * The start and stop locations which have been set as properties of this factory are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound)
    {
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
    /**
     * Creates a WildcardTypeNode.
     * The specified start and stop locations are used.
     */
    @Override
    public WildcardTypeNode makeWildcardTypeNode(
            ReferenceTypeNode bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        WildcardTypeNode ret = new WildcardTypeNodeImpl(bound, upperBound, startLocation, stopLocation, manager, binary);
        return ret;
    }
    
}
