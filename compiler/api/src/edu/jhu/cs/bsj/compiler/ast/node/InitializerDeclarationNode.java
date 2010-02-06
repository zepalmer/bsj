package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Declares an initializer, whether static or otherwise, as in
 * <pre>
 * static {
 *     <i>statement...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InitializerDeclarationNode extends Node, ClassMemberNode, AnonymousClassMemberNode
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
     */
    public BlockNode getBody();

    /**
     * Changes the body of the initializer.
     * @param body The body of the initializer.
     */
    public void setBody(BlockNode body);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InitializerDeclarationNode deepCopy(BsjNodeFactory factory);
}
