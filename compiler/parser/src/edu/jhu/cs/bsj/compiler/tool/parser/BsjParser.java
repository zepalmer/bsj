package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryOperatorNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.BooleanLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.BreakNode;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.CharLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ContinueNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.DoWhileLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.DoubleLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FloatLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InstanceOfNode;
import edu.jhu.cs.bsj.compiler.ast.node.IntLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LabeledStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.LongLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.StringLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.SwitchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThrowNode;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryOperatorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.WhileLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;

/**
 * This class contains the functionality necessary to parse BSJ source files into BSJ heterogeneous ASTs. It relies on a
 * generated ANTLR parser which produces BSJ homogeneous ASTs from an ANTLR grammar. These homogeneous ASTs are then
 * converted into heterogeneous ASTs using a recursive reconstruction of the tree.
 * 
 * @author Zachary Palmer
 */
public class BsjParser
{
	/**
	 * The factory that this parser will use to construct AST nodes.
	 */
	private BsjNodeFactory factory;

	/**
	 * General constructor.
	 * 
	 * @param factory The factory that this parser should use to construct AST nodes.
	 */
	public BsjParser(BsjNodeFactory factory)
	{
		super();
		this.factory = factory;
	}

	/**
	 * This method generates a BSJ heterogeneous AST from the provided source stream.
	 * 
	 * @throws IOException If an I/O error occurs.
	 * @throws RecognitionException If a recognition error occurs while parsing the provided stream.
	 */
	public CompilationUnitNode parse(InputStream is) throws IOException, RecognitionException
	{
		edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjLexer lexer = new edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjLexer(
				new ANTLRInputStream(is));
		edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjParser parser = new edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjParser(
				new TokenRewriteStream(lexer));

		CommonTree homogeneousAst = (CommonTree) (parser.compilationUnit().getTree());
		return rebuildCompilationUnit(homogeneousAst);
	}

	/*
	 * The following rebuild functions all convert the provided tree into a specific heterogeneous tree node. If the
	 * provided homogeneous tree does not match the method's structural expectations or other constraints, an
	 * IllegalArgumentException is thrown.
	 */

	private CompilationUnitNode rebuildCompilationUnit(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private AnnotationNode rebuildAnnotation(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ArrayAccessNode rebuildArrayAccess(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ArrayInstantiatonNode rebuildArrayInstantiaton(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ArrayInitializerNode rebuildArrayInitializer(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private AssignmentNode rebuildAssignment(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private BinaryOperatorNode rebuildBinaryOperator(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ClassInstantiationNode rebuildClassInstantiation(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private CompoundAssignmentNode rebuildCompoundAssignment(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ConditionalExpressionNode rebuildConditionalExpression(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private IdentifierNode rebuildIdentifier(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private InstanceOfNode rebuildInstanceOf(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private MemberSelectNode rebuildMemberSelect(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private MethodInvocationNode rebuildMethodInvocation(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private TypeCastNode rebuildTypeCast(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private UnaryOperatorNode rebuildUnaryOperator(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private BlockStatementNode rebuildBlockStatement(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private BreakNode rebuildBreak(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ContinueNode rebuildContinue(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private DoWhileLoopNode rebuildDoWhileLoop(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private EnhancedForLoopNode rebuildEnhancedForLoop(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ExpressionStatementNode rebuildExpressionStatement(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ForLoopNode rebuildForLoop(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private IfNode rebuildIf(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private LabeledStatementNode rebuildLabeledStatement(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private SwitchNode rebuildSwitch(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ThrowNode rebuildThrow(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private TryNode rebuildTry(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private VariableDeclarationNode rebuildVariableDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private WhileLoopNode rebuildWhileLoop(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ArrayTypeNode rebuildArrayType(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private DeclaredTypeNode rebuildDeclaredType(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ParameterizedTypeNode rebuildParameterizedType(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private PrimitiveTypeNode rebuildPrimitiveType(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private BooleanLiteralNode rebuildBooleanLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private CharLiteralNode rebuildCharLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private DoubleLiteralNode rebuildDoubleLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private FloatLiteralNode rebuildFloatLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private IntLiteralNode rebuildIntLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private LongLiteralNode rebuildLongLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private StringLiteralNode rebuildStringLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private AnnotationMethodDeclarationNode rebuildAnnotationMethodDeclaration(CommonTree tree)
			throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ConstructorDeclarationNode rebuildConstructorDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private EnumConstantDeclarationNode rebuildEnumConstantDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private FieldDeclarationNode rebuildFieldDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private InitializerDeclarationNode rebuildInitializerDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private MethodDeclarationNode rebuildMethodDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private AnnotationBodyNode rebuildAnnotationBody(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ClassBodyNode rebuildClassBody(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private EnumBodyNode rebuildEnumBody(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private InterfaceBodyNode rebuildInterfaceBody(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private AnnotationDeclarationNode rebuildAnnotationDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ClassDeclarationNode rebuildClassDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private EnumDeclarationNode rebuildEnumDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private InterfaceDeclarationNode rebuildInterfaceDeclaration(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private CaseNode rebuildCase(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private CatchNode rebuildCatch(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ImportNode rebuildImport(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private <T extends Node> ListNode<T> rebuildList(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private ModifiersNode rebuildModifiers(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private TypeParameterNode rebuildTypeParameter(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private VariableNode rebuildVariable(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private WildcardTypeNode rebuildWildcardType(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

	private CodeLiteralNode rebuildCodeLiteral(CommonTree tree) throws IllegalArgumentException
	{
		// TODO
		return null;
	}

}
