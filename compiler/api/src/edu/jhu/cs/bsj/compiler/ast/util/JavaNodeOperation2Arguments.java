package edu.jhu.cs.bsj.compiler.ast.util;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
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
 * This implementation of the BSJ node operation implements methods which correspond to BSJ-specific node types with a
 * call to a default operation method. The default operation method is left abstract for the overlying implementation.
 * This serves as a convenient mechanism for operating over trees which should be pure Java ASTs; the default method may
 * raise an exception or perform other error reporting operations.
 *
 * @author Zachary Palmer
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class JavaNodeOperation2Arguments<P1,P2,R> implements BsjNodeOperation2Arguments<P1,P2,R>
{
    /**
     * The default operation which all BSJ-specific node operation implementations will call.
     * 
     * @param node The node in question.
     * @param p1 The parameter to the execution method.
     * @param p2 The parameter to the execution method.
     */
    public abstract R handleBsjSpecificNode(BsjSpecificNode node, P1 p1, P2 p2);
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCodeLiteralNode(CodeLiteralNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationElementNode(MetaAnnotationElementNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationListNode(MetaAnnotationListNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyNode(MetaprogramDependencyNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramImportListNode(MetaprogramImportListNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramImportNode(MetaprogramImportNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramNode(MetaprogramNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramPreambleNode(MetaprogramPreambleNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramTargetListNode(MetaprogramTargetListNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramTargetNode(MetaprogramTargetNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeRawCodeLiteralNode(RawCodeLiteralNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, P1 p1, P2 p2)
    {
        return handleBsjSpecificNode(node, p1, p2);
    }
    
}
