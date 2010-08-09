package edu.jhu.cs.bsj.compiler.ast.util;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
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
public abstract class JavaNodeOperation<P,R> implements BsjNodeOperation<P,R>
{
    /**
     * The default operation which all BSJ-specific node operation implementations will call.
     * 
     * @param node The node in question.
     * @param p The parameter to the execution method.
     */
    public abstract R handleBsjSpecificNode(BsjSpecificNode node, P p);
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeCodeLiteralNode(CodeLiteralNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationElementNode(MetaAnnotationElementNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationListNode(MetaAnnotationListNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramDependencyNode(MetaprogramDependencyNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramImportListNode(MetaprogramImportListNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramImportNode(MetaprogramImportNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramNode(MetaprogramNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramPreambleNode(MetaprogramPreambleNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramTargetListNode(MetaprogramTargetListNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeMetaprogramTargetNode(MetaprogramTargetNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeRawCodeLiteralNode(RawCodeLiteralNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
    /**
     * Executes the BSJ-specific operation for this node.
     * @param node The node in question.
     * @param p The parameter to this node operation.
     */
    public R executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node, P p)
    {
        return handleBsjSpecificNode(node, p);
    }
    
}
