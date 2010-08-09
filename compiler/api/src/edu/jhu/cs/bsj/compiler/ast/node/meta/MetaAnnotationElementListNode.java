package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;

/**
 * Represents a list of {@link MetaAnnotationElementNode}s.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationElementListNode extends ListNode<MetaAnnotationElementNode>, BsjSpecificNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationElementListNode deepCopy(BsjNodeFactory factory);
    
}
