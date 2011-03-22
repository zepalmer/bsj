package edu.jhu.cs.bsj.compiler.ast.node;

public interface DeclaredTypeNode extends Node, ReferenceTypeNode, BaseTypeNode
{
    /* GEN:start */
    /**
     * Retrieves the declaration of this type if possible. This operation may require the loading of other compilation
     * units depending on the location of the declaration to which this node refers.
     * 
     * @param info The compilation unit loading info to use during this operation.
     * @return The declarations of this type or <code>null</code> if no such declaration can be found.
     */
    public Collection<? extends TypeNameBindingNode> getDeclarations();
    /* GEN:stop */
}
