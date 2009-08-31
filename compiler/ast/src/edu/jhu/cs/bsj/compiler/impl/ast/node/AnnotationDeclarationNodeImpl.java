package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;

public class AnnotationDeclarationNodeImpl extends TypeDeclarationNodeImpl implements AnnotationDeclarationNode
{
    /** This annotation's mbody. */
    private AnnotationBodyNode body;

    /** General constructor. */
    public AnnotationDeclarationNodeImpl(
            AnnotationBodyNode body,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        super(simpleName, modifiers);
        this.body = body;
    }

    /**
     * Gets this annotation's mbody.
     * @return This annotation's mbody.
     */
    public AnnotationBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes this annotation's mbody.
     * @param body This annotation's mbody.
     */
    public void setBody(AnnotationBodyNode body)
    {
        this.body = body;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
