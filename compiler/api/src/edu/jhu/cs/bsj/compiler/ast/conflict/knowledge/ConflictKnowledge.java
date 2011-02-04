package edu.jhu.cs.bsj.compiler.ast.conflict.knowledge;

/**
 * Represents knowledge of a conflict in a knowledge base.
 * @author Zachary Palmer
 */
public interface ConflictKnowledge extends Knowledge
{
    /**
     * The ID of the first metaprogram involved in the conflict.
     * 
     * @return The first metaprogram's ID.
     */
    public int getFirstMetaprogramId();

    /**
     * The ID of the second metaprogram involved in the conflict.
     * 
     * @return The second metaprogram's ID.
     */
    public int getSecondMetaprogramId();
}
