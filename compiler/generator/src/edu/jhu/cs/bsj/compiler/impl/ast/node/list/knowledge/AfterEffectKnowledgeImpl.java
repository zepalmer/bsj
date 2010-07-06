package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.ELEMENT_FOLLOWS;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.METAPROG_PREFIX;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.AfterEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

public class AfterEffectKnowledgeImpl<T extends Node> extends AbstractBinaryRelativeKnowledgeImpl<T> implements
		AfterEffectKnowledge<T>
{
	public AfterEffectKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource, SymbolicElement<T> first, SymbolicElement<T> second)
	{
		super(metaprogramId, metaprogramSourceLocation, knowledgeSource, first, second);
	}

	@Override
	public String toString()
	{
		return EFFECT_LEFT + getAnchor() + ELEMENT_FOLLOWS + getRelative() + EFFECT_RIGHT + METAPROG_PREFIX
				+ getMetaprogramId();
	}
}
