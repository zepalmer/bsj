package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.INVARIANT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_LEADS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.METAPROG_PREFIX;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.BeforeInvariantKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

public class BeforeInvariantKnowledgeImpl<T extends Node> extends AbstractBinaryRelativeKnowledgeImpl<T> implements BeforeInvariantKnowledge<T>
{
	public BeforeInvariantKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource, SymbolicElement<T> first, SymbolicElement<T> second)
	{
		super(metaprogramId, metaprogramSourceLocation, knowledgeSource, first, second);
	}
	
	@Override
	public String toString()
	{
		return INVARIANT_LEFT + getRelative() + ELEMENT_LEADS + getAnchor() + INVARIANT_RIGHT + METAPROG_PREFIX + getMetaprogramId();
	}
}
