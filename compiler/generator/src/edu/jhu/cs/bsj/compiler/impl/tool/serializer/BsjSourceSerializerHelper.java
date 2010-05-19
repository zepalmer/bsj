package edu.jhu.cs.bsj.compiler.impl.tool.serializer;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.node.*;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;

public class BsjSourceSerializerHelper implements BsjNodeOperation<PrependablePrintStream, Void>
{
	@Override
	public Void executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node,
			PrependablePrintStream p)
	{
		handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
		p.print("this");
		handleListNode(node.getArguments(), "(", ", ", ")", p, false);
		return null;
	}

	@Override
	public Void executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, PrependablePrintStream p)
	{
		node.getAnnotation().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeAnnotationArrayValueNode(AnnotationArrayValueNode node, PrependablePrintStream p)
	{
		handleListNode(node.getValues(), "{", ", ", "}", p, true);
		return null;
	}

	@Override
	public Void executeAnnotationBodyNode(AnnotationBodyNode node, PrependablePrintStream p)
	{
		p.incPrependCount();
		handleListNode(node.getMembers(), "", ";\n", ";\n", p, true);
		p.decPrependCount();
		return null;
	}

	@Override
	public Void executeAnnotationDeclarationNode(AnnotationDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		node.getModifiers().executeOperation(this, p);
		p.print("@interface ");
		node.getIdentifier().executeOperation(this, p);
		p.print("\n{\n");
		if (node.getBody() != null)
		{
			node.getBody().executeOperation(this, p);
		}
		p.print("}");
		return null;
	}

	@Override
	public Void executeAnnotationElementListNode(AnnotationElementListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeAnnotationElementNode(AnnotationElementNode node, PrependablePrintStream p)
	{
		node.getIdentifier().executeOperation(this, p);
		p.print(" = ");
		node.getValue().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, PrependablePrintStream p)
	{
		node.getExpression().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeAnnotationListNode(AnnotationListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		node.getModifiers().executeOperation(this, p);
		node.getType().executeOperation(this, p);
		p.print(" ");
		node.getIdentifier().executeOperation(this, p);
		p.print("()");
		if (node.getDefaultValue() != null)
		{
			p.print(" default ");
			node.getDefaultValue().executeOperation(this, p);
		}
		return null;
	}

	@Override
	public Void executeAnnotationMemberListNode(AnnotationMemberListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		return null;
	}

	@Override
	public Void executeAnnotationModifiersNode(AnnotationModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print(accessModifierToString(node.getAccess()));

		if (node.getStaticFlag())
		{
			p.print("static ");
		}

		if (node.getStrictfpFlag())
		{
			p.print("strictfp ");
		}

		return null;
	}

	@Override
	public Void executeAnnotationValueListNode(AnnotationValueListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeAnonymousClassBodyNode(AnonymousClassBodyNode node, PrependablePrintStream p)
	{
		p.print("{\n");
		p.incPrependCount();
		handleListNode(node.getMembers(), "", "\n", "", p, true);
		p.decPrependCount();
		p.print("}\n");
		return null;
	}

	@Override
	public Void executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeArrayAccessNode(ArrayAccessNode node, PrependablePrintStream p)
	{
		node.getArrayExpression().executeOperation(this, p);
		p.print("[");
		if (node.getIndexExpression() != null)
		{
			node.getIndexExpression().executeOperation(this, p);
		}
		p.print("]");
		return null;
	}

	@Override
	public Void executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, PrependablePrintStream p)
	{
		p.print("new ");
		node.getBaseType().executeOperation(this, p);
		for (int i = 0; i < node.getArrayLevels(); i++)
		{
			p.print("[]");
		}
		if (node.getInitializer() != null)
		{
			node.getInitializer().executeOperation(this, p);
		}
		return null;
	}

	@Override
	public Void executeArrayInitializerNode(ArrayInitializerNode node, PrependablePrintStream p)
	{
		handleListNode(node.getInitializers(), "{", ", ", "}", p, false);
		return null;
	}

	@Override
	public Void executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, PrependablePrintStream p)
	{
		p.print("new ");
		node.getBaseType().executeOperation(this, p);
		for (ExpressionNode exp : node.getDimExpressions().getChildren())
		{
			p.print("[");
			exp.executeOperation(this, p);
			p.print("]");
		}
		for (int i = 0; i < node.getArrayLevels(); i++)
		{
			p.print("[]");
		}
		return null;
	}

	@Override
	public Void executeArrayTypeNode(ArrayTypeNode node, PrependablePrintStream p)
	{
		node.getType().executeOperation(this, p);
		p.print("[]");
		return null;
	}

	@Override
	public Void executeAssertStatementNode(AssertStatementNode node, PrependablePrintStream p)
	{
		p.print("assert ");
		node.getTestExpression().executeOperation(this, p);
		if (node.getMessageExpression() != null)
		{
			p.print(": ");
			node.getMessageExpression().executeOperation(this, p);
		}
		p.print(";");
		return null;
	}

	@Override
	public Void executeAssignmentNode(AssignmentNode node, PrependablePrintStream p)
	{
		node.getVariable().executeOperation(this, p);
		p.print(" ");
		p.print(assignmentOperatorToString(node.getOperator()));
		p.print(" ");
		node.getExpression().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeBinaryExpressionNode(BinaryExpressionNode node, PrependablePrintStream p)
	{
		boolean parenLeft = checkForLowerPrecedence(node.getLeftOperand(), node.getOperator());
		boolean parenRight = checkForLowerPrecedence(node.getRightOperand(), node.getOperator());
		;

		// parenthesize left expression if needed
		if (parenLeft)
		{
			p.print("(");
		}
		node.getLeftOperand().executeOperation(this, p);
		if (parenLeft)
		{
			p.print(")");
		}

		// display operator
		p.print(" ");
		p.print(binaryOperatorToString(node.getOperator()));
		p.print(" ");

		// parenthesize right expression if needed
		if (parenRight)
		{
			p.print("(");
		}
		node.getRightOperand().executeOperation(this, p);
		if (parenRight)
		{
			p.print(")");
		}
		return null;
	}

	@Override
	public Void executeBlockNode(BlockNode node, PrependablePrintStream p)
	{
		p.print("{\n");
		p.incPrependCount();
		node.getStatements().executeOperation(this, p);
		p.decPrependCount();
		p.print("}");
		return null;
	}

	@Override
	public Void executeBlockStatementListNode(BlockStatementListNode node, PrependablePrintStream p)
	{
		handleListNode(node, "", "\n", "\n", p, true);
		return null;
	}

	@Override
	public Void executeBooleanLiteralNode(BooleanLiteralNode node, PrependablePrintStream p)
	{
		p.print(node.getValue() ? "true" : "false");
		return null;
	}

	@Override
	public Void executeBreakNode(BreakNode node, PrependablePrintStream p)
	{
		p.print("break");
		if (node.getLabel() != null)
		{
			p.print(" ");
			node.getLabel().executeOperation(this, p);
		}
		p.print(";");
		return null;
	}

	@Override
	public Void executeCaseListNode(CaseListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeCaseNode(CaseNode node, PrependablePrintStream p)
	{
		if (node.getExpression() == null)
		{
			p.print("default:\n");
		} else
		{
			p.print("case ");
			node.getExpression().executeOperation(this, p);
			p.print(":\n");
		}
		p.incPrependCount();
		handleListNode(node.getStatements(), "", "\n", "\n", p, true);
		p.decPrependCount();
		return null;
	}

	@Override
	public Void executeCatchListNode(CatchListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeCatchNode(CatchNode node, PrependablePrintStream p)
	{
		p.print(" catch (");
		node.getParameter().executeOperation(this, p);
		p.print(")\n");
		p.print("{\n");
		p.incPrependCount();
		node.getBody().executeOperation(this, p);
		p.decPrependCount();
		p.print("}");
		return null;
	}

	@Override
	public Void executeCharLiteralNode(CharLiteralNode node, PrependablePrintStream p)
	{
		p.print("'");
		p.print(escape(node.getValue().toString()));
		p.print("'");
		return null;
	}

	@Override
	public Void executeClassBodyNode(ClassBodyNode node, PrependablePrintStream p)
	{
		p.print("{\n");
		p.incPrependCount();
		handleListNode(node.getMembers(), "", "\n", "\n", p, true);
		p.decPrependCount();
		p.print("}\n");
		return null;
	}

	@Override
	public Void executeClassDeclarationNode(ClassDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		node.getModifiers().executeOperation(this, p);
		p.print("class ");
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getTypeParameters(), "<", ", ", ">", p, true);
		if (node.getExtendsClause() != null)
		{
			p.print(" extends ");
			node.getExtendsClause().executeOperation(this, p);
		}
		handleListNode(node.getImplementsClause(), " implements ", ", ", "", p, true);
		p.print("\n");
		node.getBody().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeClassLiteralNode(ClassLiteralNode node, PrependablePrintStream p)
	{
		node.getValue().executeOperation(this, p);
		p.print(".class");
		return null;
	}

	@Override
	public Void executeClassMemberListNode(ClassMemberListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeClassModifiersNode(ClassModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print(accessModifierToString(node.getAccess()));

		if (node.getAbstractFlag())
		{
			p.print("abstract ");
		}

		if (node.getFinalFlag())
		{
			p.print("final ");
		}

		if (node.getStaticFlag())
		{
			p.print("static ");
		}

		if (node.getStrictfpFlag())
		{
			p.print("strictfp ");
		}

		return null;
	}

	@Override
	public Void executeCodeLiteralNode(CodeLiteralNode node, PrependablePrintStream p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void executeCompilationUnitNode(CompilationUnitNode node, PrependablePrintStream p)
	{
		if (node.getPackageDeclaration() != null)
		{
			node.getPackageDeclaration().executeOperation(this, p);
			p.print("\n\n");
		}
		handleListNode(node.getImports(), "", "\n", "\n", p, true);
		p.print("\n");
		handleListNode(node.getTypeDecls(), "", "\n\n", "\n", p, true);
		return null;
	}

	@Override
	public Void executeConditionalExpressionNode(ConditionalExpressionNode node, PrependablePrintStream p)
	{
		// only assignment operations have a lower precedence than conditionals
		boolean parenCondition = (node.getCondition() instanceof AssignmentNode);
		boolean parenTrue = (node.getTrueExpression() instanceof AssignmentNode);
		boolean parenFalse = (node.getFalseExpression() instanceof AssignmentNode);

		if (parenCondition)
		{
			p.print("(");
		}
		node.getCondition().executeOperation(this, p);
		if (parenCondition)
		{
			p.print(")");
		}

		p.print(" ? ");

		if (parenTrue)
		{
			p.print("(");
		}
		node.getTrueExpression().executeOperation(this, p);
		if (parenTrue)
		{
			p.print(")");
		}

		p.print(" : ");

		if (parenFalse)
		{
			p.print("(");
		}
		node.getFalseExpression().executeOperation(this, p);
		if (parenFalse)
		{
			p.print(")");
		}

		return null;
	}

	@Override
	public Void executeConstructorBodyNode(ConstructorBodyNode node, PrependablePrintStream p)
	{
		p.print("{\n");
		p.incPrependCount();
		if (node.getConstructorInvocation() != null)
		{
			node.getConstructorInvocation().executeOperation(this, p);
			p.print(";\n");
		}
		handleListNode(node.getStatements(), "", "\n", "\n", p, true);
		p.decPrependCount();
		p.print("}");
		return null;
	}

	@Override
	public Void executeConstructorDeclarationNode(ConstructorDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		node.getModifiers().executeOperation(this, p);
		handleListNode(node.getTypeParameters(), "<", ", ", "> ", p, true);
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getParameters(), "(", ", ", "", p, false);
		if (node.getVarargParameter() != null)
		{
			// note this section is performed manually due to the formatting
			// of variable arguments parameters
			p.print(", ");
			node.getVarargParameter().getModifiers().executeOperation(this, p);
			node.getVarargParameter().getType().executeOperation(this, p);
			p.print("... ");
			node.getVarargParameter().getIdentifier().executeOperation(this, p);
		}
		p.print(")");
		handleListNode(node.getThrowTypes(), " throws ", ", ", "", p, true);
		if (node.getBody() != null)
		{
			p.print("\n");
			node.getBody().executeOperation(this, p);
		} else
		{
			p.print(";");
		}
		return null;
	}

	@Override
	public Void executeConstructorModifiersNode(ConstructorModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print(accessModifierToString(node.getAccess()));
		return null;
	}

	@Override
	public Void executeContinueNode(ContinueNode node, PrependablePrintStream p)
	{
		p.print("continue");
		if (node.getLabel() != null)
		{
			p.print(" ");
			node.getLabel().executeOperation(this, p);
		}
		p.print(";");
		return null;
	}

	@Override
	public Void executeDeclaredTypeListNode(DeclaredTypeListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeDoWhileLoopNode(DoWhileLoopNode node, PrependablePrintStream p)
	{
		p.print("do\n");
		node.getStatement().executeOperation(this, p);
		p.print("while (");
		node.getCondition().executeOperation(this, p);
		p.print(");");
		return null;
	}

	@Override
	public Void executeDoubleLiteralNode(DoubleLiteralNode node, PrependablePrintStream p)
	{
		p.print(node.getValue().toString());
		return null;
	}

	@Override
	public Void executeEnhancedForLoopNode(EnhancedForLoopNode node, PrependablePrintStream p)
	{
		p.print("for (");
		node.getVariable().executeOperation(this, p);
		p.print(" : ");
		node.getExpression().executeOperation(this, p);
		p.print(")\n");
		node.getStatement().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeEnumBodyNode(EnumBodyNode node, PrependablePrintStream p)
	{
		p.print("{\n");
		p.incPrependCount();
		handleListNode(node.getConstants(), "", ",\n", ";\n", p, true);
		handleListNode(node.getMembers(), "\n", "\n", "\n", p, true);
		p.decPrependCount();
		p.print("}\n");
		return null;
	}

	@Override
	public Void executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getArguments(), "(", ", ", ")", p, true);
		if (node.getBody() != null)
		{
			p.print("\n");
			node.getBody().executeOperation(this, p);
		}
		return null;
	}

	@Override
	public Void executeEnumDeclarationNode(EnumDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		node.getModifiers().executeOperation(this, p);
		p.print("enum ");
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getImplementsClause(), " implements ", ", ", "", p, true);
		p.print("\n");
		node.getBody().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeEnumModifiersNode(EnumModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print(accessModifierToString(node.getAccess()));
		if (node.getStrictfpFlag())
		{
			p.print("strictfp ");
		}
		return null;
	}

	@Override
	public Void executeExpressionListNode(ExpressionListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeExpressionStatementNode(ExpressionStatementNode node, PrependablePrintStream p)
	{
		if (node.getExpression() != null)
		{
			node.getExpression().executeOperation(this, p);
		}
		p.print(";");
		return null;
	}

	@Override
	public Void executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, PrependablePrintStream p)
	{
		node.getExpression().executeOperation(this, p);
		p.print(".");
		node.getIdentifier().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeFieldAccessByNameNode(FieldAccessByNameNode node, PrependablePrintStream p)
	{
		node.getName().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeFieldDeclarationNode(FieldDeclarationNode node, PrependablePrintStream p)
	{
		Node item = null;
		for (int i = 0; i < node.getDeclarators().getChildren().size(); i++)
		{
			item = node.getDeclarators().getChildren().get(i);
			if (node.getJavadoc() != null)
			{
				node.getJavadoc().executeOperation(this, p);
				p.print("\n");
			}
			node.getModifiers().executeOperation(this, p);
			item.executeOperation(this, p);
			p.print(";");
			if (i != node.getDeclarators().getChildren().size() - 1)
			{
				p.print("\n");
			}
		}
		return null;
	}

	@Override
	public Void executeFieldModifiersNode(FieldModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print(accessModifierToString(node.getAccess()));

		if (node.getFinalFlag())
		{
			p.print("final ");
		}

		if (node.getStaticFlag())
		{
			p.print("static ");
		}

		if (node.getTransientFlag())
		{
			p.print("transient ");
		}

		if (node.getVolatileFlag())
		{
			p.print("volatile ");
		}

		return null;
	}

	@Override
	public Void executeFloatLiteralNode(FloatLiteralNode node, PrependablePrintStream p)
	{
		p.print(node.getValue().toString()+"f");
		return null;
	}

	@Override
	public Void executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, PrependablePrintStream p)
	{
		boolean first = true;
		node.getDeclaration().getModifiers().executeOperation(this, p);
		
		for (VariableDeclaratorNode item : node.getDeclaration().getDeclarators().getChildren())
		{
			if (first)
			{
				first = false;
				item.getType().executeOperation(this, p);
				p.print(" ");
			} else
			{
				p.print(", ");
			}

			item.getName().executeOperation(this, p);
			if (item.getInitializer() != null)
			{
				p.print(" = ");
				item.getInitializer().executeOperation(this, p);
			}
		}
		
		return null;
	}

	@Override
	public Void executeForInitializerExpressionNode(ForInitializerExpressionNode node, PrependablePrintStream p)
	{
		handleListNode(node.getExpressions(), "", ", ", "", p, true);
		return null;
	}

	@Override
	public Void executeForLoopNode(ForLoopNode node, PrependablePrintStream p)
	{
		p.print("for (");
		if (node.getInitializer() != null)
		{
			node.getInitializer().executeOperation(this, p);
		}
		p.print("; ");
		if (node.getCondition() != null)
		{
			node.getCondition().executeOperation(this, p);
		}
		p.print("; ");
		handleListNode(node.getUpdate(), "", ", ", "", p, true);
		p.print(")\n");
		node.getStatement().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeIdentifierListNode(IdentifierListNode node, PrependablePrintStream p)
	{
		handleListNode(node, "", ",", "", p, true);
		return null;
	}

	@Override
	public Void executeIdentifierNode(IdentifierNode node, PrependablePrintStream p)
	{
		p.print(node.getIdentifier());
		return null;
	}

	@Override
	public Void executeIfNode(IfNode node, PrependablePrintStream p)
	{
		p.print("if (");
		node.getCondition().executeOperation(this, p);
		p.print(")\n");
		// Special grouping case - if the immediate child statement is also an if node, the child does not have an
		// else clause, and we do then we must introduce a block to make sure that the dangling else works correctly
		boolean dangingElse = (node.getElseStatement() != null && node.getThenStatement() instanceof IfNode &&
				((IfNode)(node.getThenStatement())).getElseStatement() == null);
		if (dangingElse)
		{
			p.println("{");
			p.incPrependCount();
		}
		if (!dangingElse && !(node.getThenStatement() instanceof BlockNode))
		{
			p.incPrependCount();
		}
		node.getThenStatement().executeOperation(this, p);
		if (!dangingElse && !(node.getThenStatement() instanceof BlockNode))
		{
			p.decPrependCount();
		}
		if (dangingElse)
		{
			p.decPrependCount();
			p.println("}");
		}
		if (node.getElseStatement() != null)
		{
			p.print(" else\n");
			node.getElseStatement().executeOperation(this, p);
		}
		return null;
	}

	@Override
	public Void executeImportListNode(ImportListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeImportOnDemandNode(ImportOnDemandNode node, PrependablePrintStream p)
	{
		p.print("import ");
		node.getName().executeOperation(this, p);
		p.print(".*;");
		return null;
	}

	@Override
	public Void executeImportSingleTypeNode(ImportSingleTypeNode node, PrependablePrintStream p)
	{
		p.print("import ");
		node.getName().executeOperation(this, p);
		p.print(";");
		return null;
	}

	@Override
	public Void executeInitializerDeclarationNode(InitializerDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getStaticInitializer())
		{
			p.print("static ");
		}
		node.getBody().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, PrependablePrintStream p)
	{
		node.getDeclaration().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeInstanceOfNode(InstanceOfNode node, PrependablePrintStream p)
	{
		node.getExpression().executeOperation(this, p);
		p.print(" instanceof ");
		node.getType().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeIntLiteralNode(IntLiteralNode node, PrependablePrintStream p)
	{
		p.print(node.getValue().toString());
		return null;
	}

	@Override
	public Void executeInterfaceBodyNode(InterfaceBodyNode node, PrependablePrintStream p)
	{
		p.print("{\n");
		p.incPrependCount();
		handleListNode(node.getMembers(), "", "\n", "", p, true);
		p.decPrependCount();
		p.print("}\n");
		return null;
	}

	@Override
	public Void executeInterfaceDeclarationNode(InterfaceDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		node.getModifiers().executeOperation(this, p);
		p.print("interface ");
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getTypeParameters(), "<", ", ", ">", p, true);
		handleListNode(node.getExtendsClause(), " extends ", ", ", "", p, true);
		p.print("\n");
		node.getBody().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeInterfaceMemberListNode(InterfaceMemberListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeInterfaceModifiersNode(InterfaceModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print(accessModifierToString(node.getAccess()));

		if (node.getStaticFlag())
		{
			p.print("static ");
		}

		if (node.getStrictfpFlag())
		{
			p.print("strictfp ");
		}
		return null;
	}

	@Override
	public Void executeJavadocNode(JavadocNode node, PrependablePrintStream p)
	{
		p.print(buildJavadoc(node.getText()));
		return null;
	}

	@Override
	public Void executeLabeledStatementNode(LabeledStatementNode node, PrependablePrintStream p)
	{
		node.getLabel().executeOperation(this, p);
		p.print(": ");
		node.getStatement().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeLongLiteralNode(LongLiteralNode node, PrependablePrintStream p)
	{
		p.print(node.getValue().toString()+"L");
		return null;
	}

	@Override
	public Void executeMethodDeclarationNode(MethodDeclarationNode node, PrependablePrintStream p)
	{
		if (node.getJavadoc() != null)
		{
			node.getJavadoc().executeOperation(this, p);
			p.print("\n");
		}
		node.getModifiers().executeOperation(this, p);
		handleListNode(node.getTypeParameters(), "<", ", ", "> ", p, true);
		node.getReturnType().executeOperation(this, p);
		p.print(" ");
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getParameters(), "(", ", ", "", p, false);
		if (node.getVarargParameter() != null)
		{
			// note this section is performed manually due to the formatting
			// of variable arguments parameters
			p.print(", ");
			node.getVarargParameter().getModifiers().executeOperation(this, p);
			node.getVarargParameter().getType().executeOperation(this, p);
			p.print("... ");
			node.getVarargParameter().getIdentifier().executeOperation(this, p);
		}
		p.print(")");
		handleListNode(node.getThrowTypes(), " throws ", ", ", "", p, true);
		if (node.getBody() != null)
		{
			p.print("\n");
			p.println("{");
			p.incPrependCount();
			node.getBody().executeOperation(this, p);
			p.decPrependCount();
			p.println("}");
		} else
		{
			p.print(";");
		}
		p.print("\n");
		return null;
	}

	@Override
	public Void executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, PrependablePrintStream p)
	{
		node.getExpression().executeOperation(this, p);
		p.print(".");
		handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getArguments(), "(", ", ", ")", p, false);
		return null;
	}

	@Override
	public Void executeMethodInvocationByNameNode(MethodInvocationByNameNode node, PrependablePrintStream p)
	{
		// check for need to insert typeArgs inside of name (ie <code>x.<T>foo();</code>)
		if (node.getName() instanceof QualifiedNameNode)
		{
			((QualifiedNameNode) node.getName()).getBase().executeOperation(this, p);
			p.print('.');
			handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
			((QualifiedNameNode) node.getName()).getIdentifier().executeOperation(this, p);
		} else
		{
			handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
			node.getName().executeOperation(this, p);
		}
		handleListNode(node.getArguments(), "(", ", ", ")", p, false);
		return null;
	}

	@Override
	public Void executeMethodModifiersNode(MethodModifiersNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print(accessModifierToString(node.getAccess()));

		if (node.getAbstractFlag())
		{
			p.print("abstract ");
		}

		if (node.getFinalFlag())
		{
			p.print("final ");
		}

		if (node.getNativeFlag())
		{
			p.print("native ");
		}

		if (node.getStaticFlag())
		{
			p.print("static ");
		}

		if (node.getStrictfpFlag())
		{
			p.print("strictfp ");
		}

		if (node.getSynchronizedFlag())
		{
			p.print("synchronized ");
		}

		return null;
	}

	@Override
	public Void executeNameListNode(NameListNode node, PrependablePrintStream p)
	{
		handleListNode(node, "", ",", "", p, true);
		return null;
	}

	@Override
	public Void executeNoOperationNode(NoOperationNode node, PrependablePrintStream p)
	{
		p.print(";");
		return null;
	}

	@Override
	public Void executeNormalAnnotationNode(NormalAnnotationNode node, PrependablePrintStream p)
	{
		p.print("@");
		node.getAnnotationType().executeOperation(this, p);
		if (!(node.getArguments().getChildren().isEmpty()))
		{
			p.print("(\n");
			boolean first = true;
			p.incPrependCount();
			for (Node item : node.getArguments().getChildren())
			{
				if (first)
				{
					first = false;
				} else
				{
					p.print(",\n");
				}
				item.executeOperation(this, p);
			}
			p.decPrependCount();
			p.print("\n)");
		}
		return null;
	}

	@Override
	public Void executeNullLiteralNode(NullLiteralNode node, PrependablePrintStream p)
	{
		p.print("null");
		return null;
	}

	@Override
	public Void executePackageDeclarationNode(PackageDeclarationNode node, PrependablePrintStream p)
	{
		handleListNode(node.getMetaAnnotations(), "", "\n", "\n", p, true);
		handleListNode(node.getAnnotations(), "", "\n", "\n", p, true);
		p.print("package ");
		node.getName().executeOperation(this, p);
		p.print(";");
		return null;
	}

	@Override
	public Void executePackageNode(PackageNode node, PrependablePrintStream p)
	{
		// TODO: What to do?
		return null;
	}

	@Override
	public Void executeParameterizedTypeNode(ParameterizedTypeNode node, PrependablePrintStream p)
	{
		node.getBaseType().executeOperation(this, p);
		handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
		return null;
	}

	@Override
	public Void executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, PrependablePrintStream p)
	{
		node.getBase().executeOperation(this, p);
		p.print(".");
		node.getSelect().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, PrependablePrintStream p)
	{
		p.print("(");
		node.getExpression().executeOperation(this, p);
		p.print(")");
		return null;
	}

	@Override
	public Void executePrimitiveTypeNode(PrimitiveTypeNode node, PrependablePrintStream p)
	{
		p.print(primitiveTypeToString(node.getPrimitiveType()));
		return null;
	}

	@Override
	public Void executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, PrependablePrintStream p)
	{
		node.getEnclosingExpression().executeOperation(this, p);
		p.print(".new ");
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
		handleListNode(node.getArguments(), "(", ", ", ")", p, false);
		if (node.getBody() != null)
		{
			node.getBody().executeOperation(this, p);
		}
		return null;
	}

	@Override
	public Void executeQualifiedNameNode(QualifiedNameNode node, PrependablePrintStream p)
	{
		node.getBase().executeOperation(this, p);
		p.print('.');
		executeIdentifierNode(node.getIdentifier(), p);
		return null;
	}

	@Override
	public Void executeReferenceTypeListNode(ReferenceTypeListNode node, PrependablePrintStream p)
	{
		handleListNode(node, "", ",", "", p, false);
		return null;
	}

	@Override
	public Void executeReturnNode(ReturnNode node, PrependablePrintStream p)
	{
		p.print("return");
		if (node.getExpression() != null)
		{
			p.print(" ");
			node.getExpression().executeOperation(this, p);
		}
		p.print(";");
		return null;
	}

	@Override
	public Void executeSimpleNameNode(SimpleNameNode node, PrependablePrintStream p)
	{
		executeIdentifierNode(node.getIdentifier(), p);
		return null;
	}

	@Override
	public Void executeSingleElementAnnotationNode(SingleElementAnnotationNode node, PrependablePrintStream p)
	{
		p.print("@");
		node.getAnnotationType().executeOperation(this, p);
		p.print("(");
		node.getValue().executeOperation(this, p);
		p.print(")");
		return null;
	}

	@Override
	public Void executeSingleStaticImportNode(SingleStaticImportNode node, PrependablePrintStream p)
	{
		p.print("import static ");
		node.getName().executeOperation(this, p);
		p.print(".");
		node.getIdentifier().executeOperation(this, p);
		p.print(";");
		return null;
	}

	@Override
	public Void executeStatementExpressionListNode(StatementExpressionListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeStaticImportOnDemandNode(StaticImportOnDemandNode node, PrependablePrintStream p)
	{
		p.print("import static ");
		node.getName().executeOperation(this, p);
		p.print(".*;");
		return null;
	}

	@Override
	public Void executeStringLiteralNode(StringLiteralNode node, PrependablePrintStream p)
	{
		p.print("\"");
		p.print(escape(node.getValue()));
		p.print("\"");
		return null;
	}

	@Override
	public Void executeSuperFieldAccessNode(SuperFieldAccessNode node, PrependablePrintStream p)
	{
		if (node.getType() != null)
		{
			node.getType().executeOperation(this, p);
			p.print(".");
		}
		p.print("super.");
		node.getIdentifier().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeSuperMethodInvocationNode(SuperMethodInvocationNode node, PrependablePrintStream p)
	{
		if (node.getType() != null)
		{
			node.getType().executeOperation(this, p);
			p.print(".");
		}
		p.print("super.");
		handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
		node.getIdentifier().executeOperation(this, p);
		handleListNode(node.getArguments(), "(", ", ", ")", p, false);
		return null;
	}

	@Override
	public Void executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node,
			PrependablePrintStream p)
	{
		if (node.getQualifyingExpression() != null)
		{
			node.getQualifyingExpression().executeOperation(this, p);
			p.print(".");
		}
		handleListNode(node.getTypeArguments(), "<", ", ", ">", p, true);
		p.print("super");
		handleListNode(node.getArguments(), "(", ", ", ")", p, false);
		return null;
	}

	@Override
	public Void executeSwitchNode(SwitchNode node, PrependablePrintStream p)
	{
		p.print("switch (");
		node.getExpression().executeOperation(this, p);
		p.print(")\n{\n");
		p.incPrependCount();
		handleListNode(node.getCases(), "", "", "", p, true);
		p.decPrependCount();
		p.print("}");
		return null;
	}

	@Override
	public Void executeSynchronizedNode(SynchronizedNode node, PrependablePrintStream p)
	{
		p.print("synchronized (");
		node.getExpression().executeOperation(this, p);
		p.print(")\n");
		node.getBody().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeThisNode(ThisNode node, PrependablePrintStream p)
	{
		if (node.getType() != null)
		{
			node.getType().executeOperation(this, p);
			p.print(".");
		}
		p.print("this");
		return null;
	}

	@Override
	public Void executeThrowNode(ThrowNode node, PrependablePrintStream p)
	{
		p.print("throw ");
		node.getExpression().executeOperation(this, p);
		p.print(";");
		return null;
	}

	@Override
	public Void executeTryNode(TryNode node, PrependablePrintStream p)
	{
		p.print("try\n");
		p.print("{\n");
		p.incPrependCount();
		node.getBody().executeOperation(this, p);
		p.decPrependCount();
		p.print("} ");
		handleListNode(node.getCatches(), "", "", "", p, true);
		if (node.getFinallyBlock() != null)
		{
			p.print("finally\n");
			p.print("{\n");
			p.incPrependCount();
			node.getFinallyBlock().executeOperation(this, p);
			p.decPrependCount();
			p.print("}\n");
		}
		return null;
	}

	@Override
	public Void executeTypeArgumentListNode(TypeArgumentListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeTypeCastNode(TypeCastNode node, PrependablePrintStream p)
	{
		p.print("(");
		node.getType().executeOperation(this, p);
		p.print(") ");
		node.getExpression().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeTypeDeclarationListNode(TypeDeclarationListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeTypeParameterListNode(TypeParameterListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeTypeParameterNode(TypeParameterNode node, PrependablePrintStream p)
	{
		node.getIdentifier().executeOperation(this, p);
		if (!node.getBounds().getChildren().isEmpty())
		{
			p.print(" extends ");
			handleListNode(node.getBounds(), "", " & ", "", p, true);
		}
		return null;
	}

	@Override
	public Void executeUnaryExpressionNode(UnaryExpressionNode node, PrependablePrintStream p)
	{
		p.print(unaryOperatorToString(node.getOperator()));
		node.getExpression().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, PrependablePrintStream p)
	{
		if (node.getOperator() == null)
		{
			throw new IllegalStateException("Invalid UnaryStatementOperator");
		}

		switch (node.getOperator())
		{
			case POSTFIX_DECREMENT: // x--
				node.getExpression().executeOperation(this, p);
				p.print("--");
				break;
			case POSTFIX_INCREMENT: // x++
				node.getExpression().executeOperation(this, p);
				p.print("++");
				break;
			case PREFIX_DECREMENT: // --x
				p.print("--");
				node.getExpression().executeOperation(this, p);
				break;
			case PREFIX_INCREMENT: // ++x
				p.print("++");
				node.getExpression().executeOperation(this, p);
				break;
		}
		return null;
	}

	@Override
	public Void executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeUnparameterizedTypeNode(UnparameterizedTypeNode node, PrependablePrintStream p)
	{
		node.getName().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node,
			PrependablePrintStream p)
	{
		p.print("new ");
		node.getType().executeOperation(this, p);
		handleListNode(node.getArguments(), "(", ", ", ")", p, false);
		if (node.getBody() != null)
		{
			node.getBody().executeOperation(this, p);
		}
		return null;
	}

	@Override
	public Void executeVariableDeclarationNode(VariableDeclarationNode node, PrependablePrintStream p)
	{
		boolean first = true;

		for (Node item : node.getDeclarators().getChildren())
		{
			if (first)
			{
				first = false;
			} else
			{
				p.print(";\n");
			}
			node.getModifiers().executeOperation(this, p);
			item.executeOperation(this, p);
		}
		p.print(";");
		return null;
	}

	@Override
	public Void executeVariableDeclaratorListNode(VariableDeclaratorListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeVariableDeclaratorNode(VariableDeclaratorNode node, PrependablePrintStream p)
	{
		node.getType().executeOperation(this, p);
		p.print(" ");
		node.getName().executeOperation(this, p);
		if (node.getInitializer() != null)
		{
			p.print(" = ");
			node.getInitializer().executeOperation(this, p);
		}
		return null;
	}

	@Override
	public Void executeVariableInitializerListNode(VariableInitializerListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeVariableListNode(VariableListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeVariableModifiersNode(VariableModifiersNode node, PrependablePrintStream p)
	{
		if (node.getFinalFlag())
		{
			p.print("final ");
		}
		return null;
	}

	@Override
	public Void executeVariableNode(VariableNode node, PrependablePrintStream p)
	{
		node.getModifiers().executeOperation(this, p);
		node.getType().executeOperation(this, p);
		p.print(" ");
		node.getIdentifier().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeVoidTypeNode(VoidTypeNode node, PrependablePrintStream p)
	{
		p.print("void");
		return null;
	}

	@Override
	public Void executeWhileLoopNode(WhileLoopNode node, PrependablePrintStream p)
	{
		p.print("while (");
		node.getCondition().executeOperation(this, p);
		p.print(")\n");
		node.getStatement().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeWildcardTypeNode(WildcardTypeNode node, PrependablePrintStream p)
	{
		p.print("?");
		if (node.getBound() != null)
		{
			if (node.getUpperBound())
			{
				p.print(" extends ");
			} else
			{
				p.print(" super ");
			}
			node.getBound().executeOperation(this, p);
		}
		return null;
	}

	// ========================================================================
	// =========================== Metaprogram Nodes ==========================
	// ========================================================================

	
	@Override
	public Void executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node,
			PrependablePrintStream p)
	{
		executeMetaprogramNode(node.getMetaprogram(), p);
		return null;
	}

	@Override
	public Void executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node,
			PrependablePrintStream p)
	{
		executeMetaprogramNode(node.getMetaprogram(), p);
		return null;
	}

	@Override
	public Void executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node,
			PrependablePrintStream p)
	{
		executeMetaprogramNode(node.getMetaprogram(), p);
		return null;
	}

	@Override
	public Void executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, PrependablePrintStream p)
	{
		executeMetaprogramNode(node.getMetaprogram(), p);
		return null;
	}

	@Override
	public Void executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node,
			PrependablePrintStream p)
	{
		executeMetaprogramNode(node.getMetaprogram(), p);
		return null;
	}

	@Override
	public Void executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, PrependablePrintStream p)
	{
		handleListNode(node.getValues(), "{", ", ", "}", p, true);
		return null;
	}

	@Override
	public Void executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeMetaAnnotationElementNode(MetaAnnotationElementNode node, PrependablePrintStream p)
	{
		node.getIdentifier().executeOperation(this, p);
		p.print(" = ");
		node.getValue().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeMetaAnnotationListNode(MetaAnnotationListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node,
			PrependablePrintStream p)
	{
		node.getAnnotation().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node,
			PrependablePrintStream p)
	{
		// meta-annotation metaprogram anchors are invisible and have no contents
		return null;
	}

	@Override
	public Void executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, PrependablePrintStream p)
	{
		executeListNode(node, p);
		return null;
	}

	@Override
	public Void executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node,
			PrependablePrintStream p)
	{
		node.getExpression().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, PrependablePrintStream p)
	{
		this.handleListNode(node, "", "\n", "\n", p, true);
		return null;
	}

	@Override
	public Void executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, PrependablePrintStream p)
	{
		p.print("#depends ");
		node.getTargets().executeOperation(this, p);
		p.println(";");
		return null;
	}

	@Override
	public Void executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, PrependablePrintStream p)
	{
		this.handleListNode(node, "", ",", "", p, true);
		return null;
	}

	@Override
	public Void executeMetaprogramDependencyNode(MetaprogramDependencyNode node, PrependablePrintStream p)
	{
		if (node.getWeak())
		{
			p.print("#weak ");
		}
		node.getTargetName().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeMetaprogramImportListNode(MetaprogramImportListNode node, PrependablePrintStream p)
	{
		handleListNode(node, "", "\n", "\n\n", p, true);
		return null;
	}

	@Override
	public Void executeMetaprogramImportNode(MetaprogramImportNode node, PrependablePrintStream p)
	{
		p.print("#");
		node.getImportNode().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeMetaprogramNode(MetaprogramNode node, PrependablePrintStream p)
	{
		p.println("[:");
		p.incPrependCount();
		if (node != null && node.getBody() != null)
		{
			for (BlockStatementNode blockStatementNode : node.getBody().getChildren())
			{
				blockStatementNode.executeOperation(this, p);
			}
		}
		p.decPrependCount();
		p.println(":]");
		return null;
	}

	@Override
	public Void executeMetaprogramPreambleNode(MetaprogramPreambleNode node, PrependablePrintStream p)
	{
		handleListNode(node.getImports(), "", "\n", "\n", p, true);
		node.getTargets().executeOperation(this, p);
		node.getDependencies().executeOperation(this, p);
		return null;
	}

	@Override
	public Void executeMetaprogramTargetListNode(MetaprogramTargetListNode node, PrependablePrintStream p)
	{
		this.handleListNode(node, "", "\n", "\n", p, true);
		return null;
	}

	@Override
	public Void executeMetaprogramTargetNode(MetaprogramTargetNode node, PrependablePrintStream p)
	{
		p.print("#target ");
		this.handleListNode(node.getTargets(), "", ",", "", p, true);
		p.println(";");
		return null;
	}

	@Override
	public Void executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, PrependablePrintStream p)
	{
		p.print("@@");
		node.getAnnotationType().executeOperation(this, p);
		if (!(node.getArguments().getChildren().isEmpty()))
		{
			p.print("(\n");
			boolean first = true;
			p.incPrependCount();
			for (Node item : node.getArguments().getChildren())
			{
				if (first)
				{
					first = false;
				} else
				{
					p.print(",\n");
				}
				item.executeOperation(this, p);
			}
			p.decPrependCount();
			p.print("\n)");
		}
		return null;
	}

	@Override
	public Void executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, PrependablePrintStream p)
	{
		p.print("@");
		node.getAnnotationType().executeOperation(this, p);
		p.print("(");
		node.getValue().executeOperation(this, p);
		p.print(")");
		return null;
	}

	@Override
	public Void executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node,
			PrependablePrintStream p)
	{
		executeMetaprogramNode(node.getMetaprogram(), p);
		return null;
	}

	// ========================================================================
	// ============================ Utility Methods ===========================
	// ========================================================================

	protected <T extends Node> Void executeListNode(ListNode<T> node, PrependablePrintStream p)
	{
		// just call the utility method with some defaults
		handleListNode(node, "", ",", "\n", p, false);
		return null;
	}

	protected void handleListNode(ListNode<? extends Node> node, String begin, String separator, String end,
			PrependablePrintStream p, boolean doNothingIfEmpty)
	{
		if (node == null || (doNothingIfEmpty && node.getChildren().isEmpty()))
		{
			return;
		}

		p.print(begin);
		boolean first = true;

		for (Node item : node.getChildren())
		{
			if (first == true)
			{
				first = false;
			} else
			{
				p.print(separator);
			}
			item.executeOperation(this, p);
		}

		p.print(end);
	}

	protected String accessModifierToString(AccessModifier modifier)
	{
		if (modifier == null)
		{
			throw new IllegalStateException("Null AccessModifier");
		}

		switch (modifier)
		{
			case PACKAGE:
				return "";
			case PRIVATE:
				return "private ";
			case PROTECTED:
				return "protected ";
			case PUBLIC:
				return "public ";
			default:
				throw new IllegalStateException("Invalid AccessModifier");
		}
	}

	protected String assignmentOperatorToString(AssignmentOperator operator)
	{
		if (operator == null)
		{
			throw new IllegalStateException("Null AssignmentOperator");
		}

		switch (operator)
		{
			case ASSIGNMENT:
				return "=";
			case PLUS_ASSIGNMENT:
				return "+=";
			case MINUS_ASSIGNMENT:
				return "-=";
			case MULTIPLY_ASSIGNMENT:
				return "*=";
			case DIVIDE_ASSIGNMENT:
				return "/=";
			case AND_ASSIGNMENT:
				return "&=";
			case OR_ASSIGNMENT:
				return "|=";
			case XOR_ASSIGNMENT:
				return "^=";
			case MODULUS_ASSIGNMENT:
				return "%=";
			case LEFT_SHIFT_ASSIGNMENT:
				return "<<=";
			case RIGHT_SHIFT_ASSIGNMENT:
				return ">>=";
			case UNSIGNED_RIGHT_SHIFT_ASSIGNMENT:
				return ">>>=";
			default:
				throw new IllegalStateException("Invalid AssignmentOperator");
		}
	}

	protected String primitiveTypeToString(PrimitiveType type)
	{
		if (type == null)
		{
			throw new IllegalStateException("Null PrimitiveType");
		}

		switch (type)
		{
			case BOOLEAN:
				return "boolean";
			case BYTE:
				return "byte";
			case CHAR:
				return "char";
			case DOUBLE:
				return "double";
			case FLOAT:
				return "float";
			case INT:
				return "int";
			case LONG:
				return "long";
			case SHORT:
				return "short";
			case VOID:
				return "void";
			default:
				throw new IllegalStateException("Invalid PrimitiveType");
		}
	}

	protected String unaryOperatorToString(UnaryOperator operator)
	{
		if (operator == null)
		{
			throw new IllegalStateException("Null PrimitiveType");
		}

		switch (operator)
		{
			case BITWISE_COMPLEMENT:
				return "~";
			case LOGICAL_COMPLEMENT:
				return "!";
			case UNARY_MINUS:
				return "-";
			case UNARY_PLUS:
				return "+";
			default:
				throw new IllegalStateException("Invalid UnaryOperator");
		}
	}

	protected String binaryOperatorToString(BinaryOperator operator)
	{
		if (operator == null)
		{
			throw new IllegalStateException("Null BinaryOperator");
		}

		switch (operator)
		{
			case LOGICAL_AND:
				return "&";
			case LOGICAL_OR:
				return "|";
			case XOR:
				return "^";
			case CONDITIONAL_AND:
				return "&&";
			case CONDITIONAL_OR:
				return "||";
			case DIVIDE:
				return "/";
			case MINUS:
				return "-";
			case MODULUS:
				return "%";
			case MULTIPLY:
				return "*";
			case PLUS:
				return "+";
			case EQUAL:
				return "==";
			case NOT_EQUAL:
				return "!=";
			case GREATER_THAN:
				return ">";
			case GREATER_THAN_EQUAL:
				return ">=";
			case LESS_THAN:
				return "<";
			case LESS_THAN_EQUAL:
				return "<=";

			case LEFT_SHIFT:
				return "<<";
			case RIGHT_SHIFT:
				return ">>";
			case UNSIGNED_RIGHT_SHIFT:
				return ">>>";
			default:
				throw new IllegalStateException("Invalid BinaryOperator");
		}
	}

	public boolean checkForLowerPrecedence(ExpressionNode childNode, BinaryOperator operator)
	{
		// assignment and conditionals have a lower precedence than binary operations
		if (childNode instanceof AssignmentNode || childNode instanceof ConditionalExpressionNode)
		{
			return true;
		}

		if (!(childNode instanceof BinaryExpressionNode))
		{
			return false;
		}

		BinaryOperator.PrecedenceComparator comparator = new BinaryOperator.PrecedenceComparator();
		BinaryExpressionNode child = (BinaryExpressionNode) childNode;

		// if the child has a lower precedence than the parent, it must be parenthesized
		if (comparator.compare(child.getOperator(), operator) < 0)
		{
			return true;
		}

		return false;
	}

	/**
	 * Builds a formatted javadoc comment from a stored javadoc.
	 * 
	 * @param input the stored javadoc, lines separated by returns.
	 * @return the formatted javadoc.
	 */
	public static String buildJavadoc(String input)
	{
		// rebuild formatting from individual lines
		String tokens[] = input.split("\n");
		StringBuilder ret = new StringBuilder("/**\n");
		for (String temp : tokens)
		{
			ret.append(" * ");
			ret.append(temp).append("\n");
		}
		ret.append(" */");
		return ret.toString();
	}
	
	/**
	 * Escapes the provided string.
	 * 
	 * @param string The string to escape.
	 * @return The escaped string.
	 */
	public static final String escape(String string)
	{
		StringBuilder sb = new StringBuilder();
		for (char c : string.toCharArray())
		{
			switch (c)
			{
				case '\\':
					sb.append("\\\\");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\b':
					sb.append("\\b");
					break;
				case '\t':
					sb.append("\\t");
					break;
				case '\r':
					sb.append("\\r");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\"':
					sb.append("\\\"");
					break;
				case '\'':
					sb.append("\\\'");
					break;
				default:
					sb.append(c);
					break;
			}
		}
		return sb.toString();
	}
}
