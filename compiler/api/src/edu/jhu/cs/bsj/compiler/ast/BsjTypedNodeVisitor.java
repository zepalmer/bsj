package edu.jhu.cs.bsj.compiler.ast;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;

/**
 * This interface is implemented by those classes which wish to perform visitation operations
 * over a BSJ AST.  Each node visits a method for its own class as well as all of its
 * superclasses in order from most specific type to least specific type (when the visit
 * starts) or from least specific type to most specific type (when the visit ends).  Each
 * method representing a concrete type also accepts a boolean argument from the node
 * indicating whether or not that type is the most specific type for that node.  A method is
 * also called (after or before the previous calls for start and stop, respectively) for each
 * interface the node implements.  Finally, each node's sequence of starting calls begins
 * with a call to <tt>visitStartBegin</tt> and ends with a call to <tt>visitStartEnd</tt>;
 * likewise, each sequence of ending calls begins with a call to <tt>visitStopBegin</tt> and
 * ends with a call to <tt>visitStopEnd</tt>.
 * <p/>
 * For example, imagine a simple type hierarchy in which <tt>C</tt> extends from <tt>B</tt>
 * and <tt>B</tt> extends from <tt>A</tt>.  Assume that <tt>C</tt> and <tt>B</tt> are
 * concrete classes while <tt>A</tt> is not.  In that case, the following sequence of methods
 * would be called if an instance this visitor interface were to visit an instance of node
 * <tt>C</tt>:
 * <ul>
 * <li><tt>visitStartBegin(node)</tt></li>
 * <li><tt>visitCStart(node,true)</tt></li>
 * <li><tt>visitBStart(node,false)</tt></li>
 * <li><tt>visitAStart(node)</tt></li>
 * <li><tt>visitStartEnd(node)</tt></li>
 * <li><tt>visitStopBegin(node)</tt></li>
 * <li><tt>visitAStop(node)</tt></li>
 * <li><tt>visitBStop(node,false)</tt></li>
 * <li><tt>visitCStop(node,true)</tt></li>
 * <li><tt>visitStopEnd(node)</tt></li>
 * </ul>
 * As usual for a tree visitor pattern, each node is visited around their child visits.  If
 * <tt>node</tt> above had a <tt>child</tt> of type <tt>B</tt>, the executed sequence of
 * calls would be extended as shown below.
 * <ul>
 * <li><tt>visitStartBegin(node)</tt></li>
 * <li><tt>visitCStart(node,true)</tt></li>
 * <li><tt>visitBStart(node,false)</tt></li>
 * <li><tt>visitAStart(node)</tt></li>
 * <li><tt>visitStartEnd(node)</tt></li>
 * <li><tt>visitStartBegin(child)</tt></li>
 * <li><tt>visitBStart(child,true)</tt></li>
 * <li><tt>visitAStart(child)</tt></li>
 * <li><tt>visitStartEnd(child)</tt></li>
 * <li><tt>visitStopBegin(child)</tt></li>
 * <li><tt>visitAStop(child)</tt></li>
 * <li><tt>visitBStop(child,true)</tt></li>
 * <li><tt>visitStopEnd(child)</tt></li>
 * <li><tt>visitStopBegin(node)</tt></li>
 * <li><tt>visitAStop(node)</tt></li>
 * <li><tt>visitBStop(node,false)</tt></li>
 * <li><tt>visitCStop(node,true)</tt></li>
 * <li><tt>visitStopEnd(node)</tt></li>
 * </ul>
 * This interface is very efficient at providing for the needs of visitors which regularly
 * need to condition behavior based on node type and have a number of types to service.  If
 * a simpler traversal of the nodes in the tree is desired, {@link BsjNodeVisitor} may be
 * more suitable.
 *
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjTypedNodeVisitor
{
    /**
     * Begins a sequence of visit start calls on a node.
     * @param node The node in question.
     */
    public void visitStartBegin(Node node);

    /**
     * Ends a sequence of visit start calls on a node.
     * @param node The node in question.
     */
    public void visitStartEnd(Node node);

    /**
     * Begins a sequence of visit stop calls on a node.
     * @param node The node in question.
     */
    public void visitStopBegin(Node node);

    /**
     * Ends a sequence of visit stop calls on a node.
     * @param node The node in question.
     */
    public void visitStopEnd(Node node);

    /**
     * Starts a visit for nodes of type AlternateConstructorInvocationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAlternateConstructorInvocationNodeStart(AlternateConstructorInvocationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationAnnotationValueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationAnnotationValueNodeStart(AnnotationAnnotationValueNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationArrayValueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationArrayValueNodeStart(AnnotationArrayValueNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationBodyNodeStart(AnnotationBodyNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationDeclarationNodeStart(AnnotationDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationElementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationElementNodeStart(AnnotationElementNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationExpressionValueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationExpressionValueNodeStart(AnnotationExpressionValueNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationMemberNode.
     * @param node The node being visited.
     */
    public void visitAnnotationMemberNodeStart(AnnotationMemberNode node);

    /**
     * Starts a visit for nodes of type AnnotationMethodDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationMethodDeclarationNodeStart(AnnotationMethodDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationMethodModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationMethodModifiersNodeStart(AnnotationMethodModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationModifiersNodeStart(AnnotationModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnnotationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationNodeStart(AnnotationNode node);

    /**
     * Starts a visit for nodes of type AnnotationValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationValueNodeStart(AnnotationValueNode node);

    /**
     * Starts a visit for nodes of type AnonymousClassBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnonymousClassBodyNodeStart(AnonymousClassBodyNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AnonymousClassMemberNode.
     * @param node The node being visited.
     */
    public void visitAnonymousClassMemberNodeStart(AnonymousClassMemberNode node);

    /**
     * Starts a visit for nodes of type ArrayAccessNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayAccessNodeStart(ArrayAccessNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ArrayCreationNode.
     * @param node The node being visited.
     */
    public void visitArrayCreationNodeStart(ArrayCreationNode node);

    /**
     * Starts a visit for nodes of type ArrayInitializerCreationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayInitializerCreationNodeStart(ArrayInitializerCreationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ArrayInitializerNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayInitializerNodeStart(ArrayInitializerNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ArrayInstantiatorCreationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayInstantiatorCreationNodeStart(ArrayInstantiatorCreationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ArrayTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayTypeNodeStart(ArrayTypeNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AssertStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAssertStatementNodeStart(AssertStatementNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type AssignmentNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAssignmentNodeStart(AssignmentNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type BaseTypeNode.
     * @param node The node being visited.
     */
    public void visitBaseTypeNodeStart(BaseTypeNode node);

    /**
     * Starts a visit for nodes of type BinaryExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBinaryExpressionNodeStart(BinaryExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type BlockNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBlockNodeStart(BlockNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type BlockStatementMetaprogramAnchorNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBlockStatementMetaprogramAnchorNodeStart(BlockStatementMetaprogramAnchorNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type BlockStatementNode.
     * @param node The node being visited.
     */
    public void visitBlockStatementNodeStart(BlockStatementNode node);

    /**
     * Starts a visit for nodes of type BooleanLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBooleanLiteralNodeStart(BooleanLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type BreakNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBreakNodeStart(BreakNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type CaseNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCaseNodeStart(CaseNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type CatchNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCatchNodeStart(CatchNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type CharLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCharLiteralNodeStart(CharLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ClassBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassBodyNodeStart(ClassBodyNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ClassDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassDeclarationNodeStart(ClassDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitClassInstantiationNodeStart(ClassInstantiationNode node);

    /**
     * Starts a visit for nodes of type ClassLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassLiteralNodeStart(ClassLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ClassMemberNode.
     * @param node The node being visited.
     */
    public void visitClassMemberNodeStart(ClassMemberNode node);

    /**
     * Starts a visit for nodes of type ClassModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassModifiersNodeStart(ClassModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type CodeLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCodeLiteralNodeStart(CodeLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type CompilationUnitNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCompilationUnitNodeStart(CompilationUnitNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ConditionalExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConditionalExpressionNodeStart(ConditionalExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ConstructorBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConstructorBodyNodeStart(ConstructorBodyNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ConstructorDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConstructorDeclarationNodeStart(ConstructorDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ConstructorInvocationNode.
     * @param node The node being visited.
     */
    public void visitConstructorInvocationNodeStart(ConstructorInvocationNode node);

    /**
     * Starts a visit for nodes of type ConstructorModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConstructorModifiersNodeStart(ConstructorModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ContinueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitContinueNodeStart(ContinueNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type DeclaredTypeNode.
     * @param node The node being visited.
     */
    public void visitDeclaredTypeNodeStart(DeclaredTypeNode node);

    /**
     * Starts a visit for nodes of type DoWhileLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitDoWhileLoopNodeStart(DoWhileLoopNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type DoubleLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitDoubleLiteralNodeStart(DoubleLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type EnhancedForLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnhancedForLoopNodeStart(EnhancedForLoopNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type EnumBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumBodyNodeStart(EnumBodyNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type EnumConstantDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumConstantDeclarationNodeStart(EnumConstantDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type EnumDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumDeclarationNodeStart(EnumDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type EnumModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumModifiersNodeStart(EnumModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ExpressionNode.
     * @param node The node being visited.
     */
    public void visitExpressionNodeStart(ExpressionNode node);

    /**
     * Starts a visit for nodes of type ExpressionStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitExpressionStatementNodeStart(ExpressionStatementNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type FieldAccessByExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldAccessByExpressionNodeStart(FieldAccessByExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type FieldAccessByNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldAccessByNameNodeStart(FieldAccessByNameNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type FieldAccessNode.
     * @param node The node being visited.
     */
    public void visitFieldAccessNodeStart(FieldAccessNode node);

    /**
     * Starts a visit for nodes of type FieldDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldDeclarationNodeStart(FieldDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type FieldModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldModifiersNodeStart(FieldModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type FloatLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFloatLiteralNodeStart(FloatLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ForInitializerDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitForInitializerDeclarationNodeStart(ForInitializerDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ForInitializerExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitForInitializerExpressionNodeStart(ForInitializerExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ForInitializerNode.
     * @param node The node being visited.
     */
    public void visitForInitializerNodeStart(ForInitializerNode node);

    /**
     * Starts a visit for nodes of type ForLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitForLoopNodeStart(ForLoopNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type IdentifierNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitIdentifierNodeStart(IdentifierNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type IfNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitIfNodeStart(IfNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ImportNode.
     * @param node The node being visited.
     */
    public void visitImportNodeStart(ImportNode node);

    /**
     * Starts a visit for nodes of type ImportOnDemandNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitImportOnDemandNodeStart(ImportOnDemandNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ImportSingleTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitImportSingleTypeNodeStart(ImportSingleTypeNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type InitializerDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInitializerDeclarationNodeStart(InitializerDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type InlineTypeDeclarableNode.
     * @param node The node being visited.
     */
    public void visitInlineTypeDeclarableNodeStart(InlineTypeDeclarableNode node);

    /**
     * Starts a visit for nodes of type InlineTypeDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInlineTypeDeclarationNodeStart(InlineTypeDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type InstanceOfNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInstanceOfNodeStart(InstanceOfNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type IntLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitIntLiteralNodeStart(IntLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type InterfaceBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInterfaceBodyNodeStart(InterfaceBodyNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type InterfaceDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInterfaceDeclarationNodeStart(InterfaceDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type InterfaceMemberNode.
     * @param node The node being visited.
     */
    public void visitInterfaceMemberNodeStart(InterfaceMemberNode node);

    /**
     * Starts a visit for nodes of type InterfaceModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInterfaceModifiersNodeStart(InterfaceModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type JavadocNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitJavadocNodeStart(JavadocNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type LabeledStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitLabeledStatementNodeStart(LabeledStatementNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ListNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitListNodeStart(ListNode<?> node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type LiteralNode.
     * @param node The node being visited.
     */
    public void visitLiteralNodeStart(LiteralNode<?> node);

    /**
     * Starts a visit for nodes of type LiteralizableTypeNode.
     * @param node The node being visited.
     */
    public void visitLiteralizableTypeNodeStart(LiteralizableTypeNode node);

    /**
     * Starts a visit for nodes of type LongLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitLongLiteralNodeStart(LongLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type MetaprogramAnchorNode.
     * @param node The node being visited.
     */
    public void visitMetaprogramAnchorNodeStart(MetaprogramAnchorNode<?> node);

    /**
     * Starts a visit for nodes of type MetaprogramNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMetaprogramNodeStart(MetaprogramNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type MethodDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodDeclarationNodeStart(MethodDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type MethodInvocationByExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodInvocationByExpressionNodeStart(MethodInvocationByExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type MethodInvocationByNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodInvocationByNameNodeStart(MethodInvocationByNameNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type MethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationNodeStart(MethodInvocationNode node);

    /**
     * Starts a visit for nodes of type MethodModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodModifiersNodeStart(MethodModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ModifiersNode.
     * @param node The node being visited.
     */
    public void visitModifiersNodeStart(ModifiersNode node);

    /**
     * Starts a visit for nodes of type NameNode.
     * @param node The node being visited.
     */
    public void visitNameNodeStart(NameNode node);

    /**
     * Starts a visit for nodes of type NamedTypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitNamedTypeDeclarationNodeStart(NamedTypeDeclarationNode node);

    /**
     * Starts a visit for nodes of type Node.
     * @param node The node being visited.
     */
    public void visitNodeStart(Node node);

    /**
     * Starts a visit for nodes of type NonAssignmentExpressionNode.
     * @param node The node being visited.
     */
    public void visitNonAssignmentExpressionNodeStart(NonAssignmentExpressionNode node);

    /**
     * Starts a visit for nodes of type NormalAnnotationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitNormalAnnotationNodeStart(NormalAnnotationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type NullLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitNullLiteralNodeStart(NullLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type PackageDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitPackageDeclarationNodeStart(PackageDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ParameterizedTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitParameterizedTypeNodeStart(ParameterizedTypeNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ParameterizedTypeSelectNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitParameterizedTypeSelectNodeStart(ParameterizedTypeSelectNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ParenthesizedExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitParenthesizedExpressionNodeStart(ParenthesizedExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type PrimaryExpressionNode.
     * @param node The node being visited.
     */
    public void visitPrimaryExpressionNodeStart(PrimaryExpressionNode node);

    /**
     * Starts a visit for nodes of type PrimitiveTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitPrimitiveTypeNodeStart(PrimitiveTypeNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type QualifiedClassInstantiationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitQualifiedClassInstantiationNodeStart(QualifiedClassInstantiationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type QualifiedNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitQualifiedNameNodeStart(QualifiedNameNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ReferenceTypeNode.
     * @param node The node being visited.
     */
    public void visitReferenceTypeNodeStart(ReferenceTypeNode node);

    /**
     * Starts a visit for nodes of type RestrictedPrimaryExpressionNode.
     * @param node The node being visited.
     */
    public void visitRestrictedPrimaryExpressionNodeStart(RestrictedPrimaryExpressionNode node);

    /**
     * Starts a visit for nodes of type ReturnNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitReturnNodeStart(ReturnNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type SimpleNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSimpleNameNodeStart(SimpleNameNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type SingleElementAnnotationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSingleElementAnnotationNodeStart(SingleElementAnnotationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type StatementExpressionNode.
     * @param node The node being visited.
     */
    public void visitStatementExpressionNodeStart(StatementExpressionNode node);

    /**
     * Starts a visit for nodes of type StatementNode.
     * @param node The node being visited.
     */
    public void visitStatementNodeStart(StatementNode node);

    /**
     * Starts a visit for nodes of type StringLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitStringLiteralNodeStart(StringLiteralNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type SuperFieldAccessNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSuperFieldAccessNodeStart(SuperFieldAccessNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type SuperMethodInvocationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSuperMethodInvocationNodeStart(SuperMethodInvocationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type SuperclassConstructorInvocationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSuperclassConstructorInvocationNodeStart(SuperclassConstructorInvocationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type SwitchNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSwitchNodeStart(SwitchNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type SynchronizedNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSynchronizedNodeStart(SynchronizedNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ThisNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitThisNodeStart(ThisNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type ThrowNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitThrowNodeStart(ThrowNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type TryNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTryNodeStart(TryNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type TypeArgumentNode.
     * @param node The node being visited.
     */
    public void visitTypeArgumentNodeStart(TypeArgumentNode node);

    /**
     * Starts a visit for nodes of type TypeCastNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTypeCastNodeStart(TypeCastNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type TypeDeclarationMetaprogramAnchorNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTypeDeclarationMetaprogramAnchorNodeStart(TypeDeclarationMetaprogramAnchorNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type TypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitTypeDeclarationNodeStart(TypeDeclarationNode node);

    /**
     * Starts a visit for nodes of type TypeNode.
     * @param node The node being visited.
     */
    public void visitTypeNodeStart(TypeNode node);

    /**
     * Starts a visit for nodes of type TypeParameterNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTypeParameterNodeStart(TypeParameterNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type UnaryExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnaryExpressionNodeStart(UnaryExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type UnaryStatementExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnaryStatementExpressionNodeStart(UnaryStatementExpressionNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type UnparameterizedTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnparameterizedTypeNodeStart(UnparameterizedTypeNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type UnqualifiedClassInstantiationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnqualifiedClassInstantiationNodeStart(UnqualifiedClassInstantiationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type VariableDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableDeclarationNodeStart(VariableDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type VariableDeclaratorNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableDeclaratorNodeStart(VariableDeclaratorNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type VariableInitializerNode.
     * @param node The node being visited.
     */
    public void visitVariableInitializerNodeStart(VariableInitializerNode node);

    /**
     * Starts a visit for nodes of type VariableModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableModifiersNodeStart(VariableModifiersNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type VariableNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableNodeStart(VariableNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type VoidStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVoidStatementNodeStart(VoidStatementNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type VoidTypeDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVoidTypeDeclarationNodeStart(VoidTypeDeclarationNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type VoidTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVoidTypeNodeStart(VoidTypeNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type WhileLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitWhileLoopNodeStart(WhileLoopNode node, boolean mostSpecific);

    /**
     * Starts a visit for nodes of type WildcardTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitWildcardTypeNodeStart(WildcardTypeNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AlternateConstructorInvocationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAlternateConstructorInvocationNodeStop(AlternateConstructorInvocationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationAnnotationValueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationAnnotationValueNodeStop(AnnotationAnnotationValueNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationArrayValueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationArrayValueNodeStop(AnnotationArrayValueNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationBodyNodeStop(AnnotationBodyNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationDeclarationNodeStop(AnnotationDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationElementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationElementNodeStop(AnnotationElementNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationExpressionValueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationExpressionValueNodeStop(AnnotationExpressionValueNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationMemberNode.
     * @param node The node being visited.
     */
    public void visitAnnotationMemberNodeStop(AnnotationMemberNode node);

    /**
     * Stops a visit for nodes of type AnnotationMethodDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationMethodDeclarationNodeStop(AnnotationMethodDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationMethodModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationMethodModifiersNodeStop(AnnotationMethodModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnnotationModifiersNodeStop(AnnotationModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnnotationNode.
     * @param node The node being visited.
     */
    public void visitAnnotationNodeStop(AnnotationNode node);

    /**
     * Stops a visit for nodes of type AnnotationValueNode.
     * @param node The node being visited.
     */
    public void visitAnnotationValueNodeStop(AnnotationValueNode node);

    /**
     * Stops a visit for nodes of type AnonymousClassBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAnonymousClassBodyNodeStop(AnonymousClassBodyNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AnonymousClassMemberNode.
     * @param node The node being visited.
     */
    public void visitAnonymousClassMemberNodeStop(AnonymousClassMemberNode node);

    /**
     * Stops a visit for nodes of type ArrayAccessNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayAccessNodeStop(ArrayAccessNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ArrayCreationNode.
     * @param node The node being visited.
     */
    public void visitArrayCreationNodeStop(ArrayCreationNode node);

    /**
     * Stops a visit for nodes of type ArrayInitializerCreationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayInitializerCreationNodeStop(ArrayInitializerCreationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ArrayInitializerNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayInitializerNodeStop(ArrayInitializerNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ArrayInstantiatorCreationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayInstantiatorCreationNodeStop(ArrayInstantiatorCreationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ArrayTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitArrayTypeNodeStop(ArrayTypeNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AssertStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAssertStatementNodeStop(AssertStatementNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type AssignmentNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitAssignmentNodeStop(AssignmentNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type BaseTypeNode.
     * @param node The node being visited.
     */
    public void visitBaseTypeNodeStop(BaseTypeNode node);

    /**
     * Stops a visit for nodes of type BinaryExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBinaryExpressionNodeStop(BinaryExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type BlockNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBlockNodeStop(BlockNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type BlockStatementMetaprogramAnchorNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBlockStatementMetaprogramAnchorNodeStop(BlockStatementMetaprogramAnchorNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type BlockStatementNode.
     * @param node The node being visited.
     */
    public void visitBlockStatementNodeStop(BlockStatementNode node);

    /**
     * Stops a visit for nodes of type BooleanLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBooleanLiteralNodeStop(BooleanLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type BreakNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitBreakNodeStop(BreakNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type CaseNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCaseNodeStop(CaseNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type CatchNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCatchNodeStop(CatchNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type CharLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCharLiteralNodeStop(CharLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ClassBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassBodyNodeStop(ClassBodyNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ClassDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassDeclarationNodeStop(ClassDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ClassInstantiationNode.
     * @param node The node being visited.
     */
    public void visitClassInstantiationNodeStop(ClassInstantiationNode node);

    /**
     * Stops a visit for nodes of type ClassLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassLiteralNodeStop(ClassLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ClassMemberNode.
     * @param node The node being visited.
     */
    public void visitClassMemberNodeStop(ClassMemberNode node);

    /**
     * Stops a visit for nodes of type ClassModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitClassModifiersNodeStop(ClassModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type CodeLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCodeLiteralNodeStop(CodeLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type CompilationUnitNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitCompilationUnitNodeStop(CompilationUnitNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ConditionalExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConditionalExpressionNodeStop(ConditionalExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ConstructorBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConstructorBodyNodeStop(ConstructorBodyNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ConstructorDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConstructorDeclarationNodeStop(ConstructorDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ConstructorInvocationNode.
     * @param node The node being visited.
     */
    public void visitConstructorInvocationNodeStop(ConstructorInvocationNode node);

    /**
     * Stops a visit for nodes of type ConstructorModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitConstructorModifiersNodeStop(ConstructorModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ContinueNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitContinueNodeStop(ContinueNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type DeclaredTypeNode.
     * @param node The node being visited.
     */
    public void visitDeclaredTypeNodeStop(DeclaredTypeNode node);

    /**
     * Stops a visit for nodes of type DoWhileLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitDoWhileLoopNodeStop(DoWhileLoopNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type DoubleLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitDoubleLiteralNodeStop(DoubleLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type EnhancedForLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnhancedForLoopNodeStop(EnhancedForLoopNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type EnumBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumBodyNodeStop(EnumBodyNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type EnumConstantDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumConstantDeclarationNodeStop(EnumConstantDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type EnumDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumDeclarationNodeStop(EnumDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type EnumModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitEnumModifiersNodeStop(EnumModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ExpressionNode.
     * @param node The node being visited.
     */
    public void visitExpressionNodeStop(ExpressionNode node);

    /**
     * Stops a visit for nodes of type ExpressionStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitExpressionStatementNodeStop(ExpressionStatementNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type FieldAccessByExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldAccessByExpressionNodeStop(FieldAccessByExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type FieldAccessByNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldAccessByNameNodeStop(FieldAccessByNameNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type FieldAccessNode.
     * @param node The node being visited.
     */
    public void visitFieldAccessNodeStop(FieldAccessNode node);

    /**
     * Stops a visit for nodes of type FieldDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldDeclarationNodeStop(FieldDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type FieldModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFieldModifiersNodeStop(FieldModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type FloatLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitFloatLiteralNodeStop(FloatLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ForInitializerDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitForInitializerDeclarationNodeStop(ForInitializerDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ForInitializerExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitForInitializerExpressionNodeStop(ForInitializerExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ForInitializerNode.
     * @param node The node being visited.
     */
    public void visitForInitializerNodeStop(ForInitializerNode node);

    /**
     * Stops a visit for nodes of type ForLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitForLoopNodeStop(ForLoopNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type IdentifierNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitIdentifierNodeStop(IdentifierNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type IfNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitIfNodeStop(IfNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ImportNode.
     * @param node The node being visited.
     */
    public void visitImportNodeStop(ImportNode node);

    /**
     * Stops a visit for nodes of type ImportOnDemandNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitImportOnDemandNodeStop(ImportOnDemandNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ImportSingleTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitImportSingleTypeNodeStop(ImportSingleTypeNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type InitializerDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInitializerDeclarationNodeStop(InitializerDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type InlineTypeDeclarableNode.
     * @param node The node being visited.
     */
    public void visitInlineTypeDeclarableNodeStop(InlineTypeDeclarableNode node);

    /**
     * Stops a visit for nodes of type InlineTypeDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInlineTypeDeclarationNodeStop(InlineTypeDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type InstanceOfNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInstanceOfNodeStop(InstanceOfNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type IntLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitIntLiteralNodeStop(IntLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type InterfaceBodyNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInterfaceBodyNodeStop(InterfaceBodyNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type InterfaceDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInterfaceDeclarationNodeStop(InterfaceDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type InterfaceMemberNode.
     * @param node The node being visited.
     */
    public void visitInterfaceMemberNodeStop(InterfaceMemberNode node);

    /**
     * Stops a visit for nodes of type InterfaceModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitInterfaceModifiersNodeStop(InterfaceModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type JavadocNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitJavadocNodeStop(JavadocNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type LabeledStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitLabeledStatementNodeStop(LabeledStatementNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ListNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitListNodeStop(ListNode<?> node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type LiteralNode.
     * @param node The node being visited.
     */
    public void visitLiteralNodeStop(LiteralNode<?> node);

    /**
     * Stops a visit for nodes of type LiteralizableTypeNode.
     * @param node The node being visited.
     */
    public void visitLiteralizableTypeNodeStop(LiteralizableTypeNode node);

    /**
     * Stops a visit for nodes of type LongLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitLongLiteralNodeStop(LongLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type MetaprogramAnchorNode.
     * @param node The node being visited.
     */
    public void visitMetaprogramAnchorNodeStop(MetaprogramAnchorNode<?> node);

    /**
     * Stops a visit for nodes of type MetaprogramNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMetaprogramNodeStop(MetaprogramNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type MethodDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodDeclarationNodeStop(MethodDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type MethodInvocationByExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodInvocationByExpressionNodeStop(MethodInvocationByExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type MethodInvocationByNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodInvocationByNameNodeStop(MethodInvocationByNameNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type MethodInvocationNode.
     * @param node The node being visited.
     */
    public void visitMethodInvocationNodeStop(MethodInvocationNode node);

    /**
     * Stops a visit for nodes of type MethodModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitMethodModifiersNodeStop(MethodModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ModifiersNode.
     * @param node The node being visited.
     */
    public void visitModifiersNodeStop(ModifiersNode node);

    /**
     * Stops a visit for nodes of type NameNode.
     * @param node The node being visited.
     */
    public void visitNameNodeStop(NameNode node);

    /**
     * Stops a visit for nodes of type NamedTypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitNamedTypeDeclarationNodeStop(NamedTypeDeclarationNode node);

    /**
     * Stops a visit for nodes of type Node.
     * @param node The node being visited.
     */
    public void visitNodeStop(Node node);

    /**
     * Stops a visit for nodes of type NonAssignmentExpressionNode.
     * @param node The node being visited.
     */
    public void visitNonAssignmentExpressionNodeStop(NonAssignmentExpressionNode node);

    /**
     * Stops a visit for nodes of type NormalAnnotationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitNormalAnnotationNodeStop(NormalAnnotationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type NullLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitNullLiteralNodeStop(NullLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type PackageDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitPackageDeclarationNodeStop(PackageDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ParameterizedTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitParameterizedTypeNodeStop(ParameterizedTypeNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ParameterizedTypeSelectNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitParameterizedTypeSelectNodeStop(ParameterizedTypeSelectNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ParenthesizedExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitParenthesizedExpressionNodeStop(ParenthesizedExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type PrimaryExpressionNode.
     * @param node The node being visited.
     */
    public void visitPrimaryExpressionNodeStop(PrimaryExpressionNode node);

    /**
     * Stops a visit for nodes of type PrimitiveTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitPrimitiveTypeNodeStop(PrimitiveTypeNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type QualifiedClassInstantiationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitQualifiedClassInstantiationNodeStop(QualifiedClassInstantiationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type QualifiedNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitQualifiedNameNodeStop(QualifiedNameNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ReferenceTypeNode.
     * @param node The node being visited.
     */
    public void visitReferenceTypeNodeStop(ReferenceTypeNode node);

    /**
     * Stops a visit for nodes of type RestrictedPrimaryExpressionNode.
     * @param node The node being visited.
     */
    public void visitRestrictedPrimaryExpressionNodeStop(RestrictedPrimaryExpressionNode node);

    /**
     * Stops a visit for nodes of type ReturnNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitReturnNodeStop(ReturnNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type SimpleNameNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSimpleNameNodeStop(SimpleNameNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type SingleElementAnnotationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSingleElementAnnotationNodeStop(SingleElementAnnotationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type StatementExpressionNode.
     * @param node The node being visited.
     */
    public void visitStatementExpressionNodeStop(StatementExpressionNode node);

    /**
     * Stops a visit for nodes of type StatementNode.
     * @param node The node being visited.
     */
    public void visitStatementNodeStop(StatementNode node);

    /**
     * Stops a visit for nodes of type StringLiteralNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitStringLiteralNodeStop(StringLiteralNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type SuperFieldAccessNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSuperFieldAccessNodeStop(SuperFieldAccessNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type SuperMethodInvocationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSuperMethodInvocationNodeStop(SuperMethodInvocationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type SuperclassConstructorInvocationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSuperclassConstructorInvocationNodeStop(SuperclassConstructorInvocationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type SwitchNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSwitchNodeStop(SwitchNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type SynchronizedNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitSynchronizedNodeStop(SynchronizedNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ThisNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitThisNodeStop(ThisNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type ThrowNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitThrowNodeStop(ThrowNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type TryNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTryNodeStop(TryNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type TypeArgumentNode.
     * @param node The node being visited.
     */
    public void visitTypeArgumentNodeStop(TypeArgumentNode node);

    /**
     * Stops a visit for nodes of type TypeCastNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTypeCastNodeStop(TypeCastNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type TypeDeclarationMetaprogramAnchorNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTypeDeclarationMetaprogramAnchorNodeStop(TypeDeclarationMetaprogramAnchorNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type TypeDeclarationNode.
     * @param node The node being visited.
     */
    public void visitTypeDeclarationNodeStop(TypeDeclarationNode node);

    /**
     * Stops a visit for nodes of type TypeNode.
     * @param node The node being visited.
     */
    public void visitTypeNodeStop(TypeNode node);

    /**
     * Stops a visit for nodes of type TypeParameterNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitTypeParameterNodeStop(TypeParameterNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type UnaryExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnaryExpressionNodeStop(UnaryExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type UnaryStatementExpressionNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnaryStatementExpressionNodeStop(UnaryStatementExpressionNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type UnparameterizedTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnparameterizedTypeNodeStop(UnparameterizedTypeNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type UnqualifiedClassInstantiationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitUnqualifiedClassInstantiationNodeStop(UnqualifiedClassInstantiationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type VariableDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableDeclarationNodeStop(VariableDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type VariableDeclaratorNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableDeclaratorNodeStop(VariableDeclaratorNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type VariableInitializerNode.
     * @param node The node being visited.
     */
    public void visitVariableInitializerNodeStop(VariableInitializerNode node);

    /**
     * Stops a visit for nodes of type VariableModifiersNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableModifiersNodeStop(VariableModifiersNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type VariableNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVariableNodeStop(VariableNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type VoidStatementNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVoidStatementNodeStop(VoidStatementNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type VoidTypeDeclarationNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVoidTypeDeclarationNodeStop(VoidTypeDeclarationNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type VoidTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitVoidTypeNodeStop(VoidTypeNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type WhileLoopNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitWhileLoopNodeStop(WhileLoopNode node, boolean mostSpecific);

    /**
     * Stops a visit for nodes of type WildcardTypeNode.
     * @param node The node being visited.
     * @param mostSpecific <code>true</code> if this is the most specific call
     *                     which can be made for this node; <code>false</code>
     *                     otherwise.
     */
    public void visitWildcardTypeNodeStop(WildcardTypeNode node, boolean mostSpecific);

}
