package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.CONTAINMENT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.EFFECT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities.METAPROG_PREFIX;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ContainmentEffectKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;

public class ContainmentEffectKnowledgeImpl<T extends Node> extends AbstractUnaryKnowledgeImpl<T> implements ContainmentEffectKnowledge<T>
{
	public ContainmentEffectKnowledgeImpl(int metaprogramId, BsjSourceLocation metaprogramSourceLocation,
			KnowledgeSource<T> knowledgeSource, SymbolicElement<T> element)
	{
		super(metaprogramId, metaprogramSourceLocation, knowledgeSource, element);
	}

	@Override
	public String toString()
	{
		return EFFECT_LEFT + getElement().toString() + CONTAINMENT + EFFECT_RIGHT + METAPROG_PREFIX + getMetaprogramId();
	}
}
