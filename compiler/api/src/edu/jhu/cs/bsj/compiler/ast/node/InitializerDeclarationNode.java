package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;

/**
 * Declares an initializer, whether static or otherwise, as in
 * <pre>
 * static {
 *     <i>statement...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InitializerDeclarationNode extends Node, ClassMemberNode, AnonymousClassMemberNode, MetaAnnotatableNode, DeclarationNode
{
    /**
     * Gets whether or not the initializer is static.
     * @return Whether or not the initializer is static.
     */
    public boolean getStaticInitializer();
    
    /**
     * Changes whether or not the initializer is static.
     * @param staticInitializer Whether or not the initializer is static.
     */
    public void setStaticInitializer(boolean staticInitializer);
    
    /**
     * Gets the body of the initializer.
     * @return The body of the initializer.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getBody() throws ClassCastException;
    
    /**
     * Gets the union object for the body of the initializer.
     * @return A union object representing The body of the initializer.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody();
    
    /**
     * Changes the body of the initializer.
     * @param body The body of the initializer.
     */
    public void setBody(BlockStatementListNode body);
    
    /**
     * Changes the body of the initializer.
     * @param body The body of the initializer.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InitializerDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
