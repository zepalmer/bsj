package edu.jhu.cs.bsj.compiler.ast.conflict;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;

/**
 * Represents a generic base of knowledge. All knowledge elements in this knowledge base share some underlying type.
 * Rules for the knowledge base are expected to operate on that type.
 * 
 * @param <K> The type of knowledge used by the knowledge base.
 * 
 * @author Zachary Palmer
 */
public interface KnowledgeBase<K extends Knowledge>
{
    /**
     * Adds knowledge to this knowledge base. Afterwards, computes the logical closure of that knowledge.
     * 
     * @param knowledge The knowledge to add.
     * @return The conflict knowledge in the knowledge base or an empty set if no conflict knowledge yet exists.  This
     * conflict knowledge will be a subtype of <tt>K</tt> as well.
     */
    public Set<ConflictKnowledge> addKnowledge(K knowledge);

    /**
     * Retrieves all knowledge from this knowledge base.
     * 
     * @return A complete set of all knowledge contained in this knowledge base.
     */
    public Set<K> getKnowledge();
}
