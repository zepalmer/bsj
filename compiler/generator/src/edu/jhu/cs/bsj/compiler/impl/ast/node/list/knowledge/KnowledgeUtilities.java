package edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.BinaryKnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.CannotRemoveEndClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.CannotRemoveStartClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.DualWriteAfterConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.DualWriteBeforeConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.DualWriteConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.EffectAfterIsArgInvariantInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.EffectAfterIsNewEffectInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.EffectBeforeIsArgInvariantInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.EffectBeforeIsNewEffectInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.InvariantAfterIsArgInvariantInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.InvariantAfterIsBeforeClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.InvariantAfterIsNewInvariantInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.InvariantBeforeIsAfterClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.InvariantBeforeIsArgInvariantInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.InvariantBeforeIsNewInvariantInClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.NothingAddedAfterEndClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.NothingAddedBeforeStartClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.NothingExistsAfterEndClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.NothingExistsBeforeStartClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.PredicateCannotChangeClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.ReadWriteAfterConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.ReadWriteBeforeConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.ReadWriteConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.UnaryKnowledgeClosureRule;

/**
 * This class acts as a container for common static utilities related to list knowledge.
 * 
 * @author Zachary Palmer
 */
public class KnowledgeUtilities
{
	/** The string we will use to represent the left delimiter of effects. */
	public static final String EFFECT_LEFT = "╓";
	/** The string we will use to represent the right delimiter of effects. */
	public static final String EFFECT_RIGHT = "╖";
	/** The string we will use to represent the left delimiter of invariants. */
	public static final String INVARIANT_LEFT = "╙";
	/** The string we will use to represent the right delimiter of invariants. */
	public static final String INVARIANT_RIGHT = "╜";

	/** The string we will use to represent the list start symbol. */
	public static final String LIST_START_SYMBOL = "▷";
	/** The string we will use to represent the list end symbol. */
	public static final String LIST_END_SYMBOL = "◁";

	/** The string we will use to represent the binary operator which positions an element to the right of another. */
	public static final String ELEMENT_FOLLOWS = "→";
	/** The string we will use to represent the binary operator which positions an element to the left of another. */
	public static final String ELEMENT_LEADS = "←";
	/** The string we will use to represent the unary operator which indicates a change in list containment. */
	public static final String CONTAINMENT = "∈*";

	/** The string we will use to represent logical conjunction. */
	public static final String AND = " ∧ ";
	/** The string we will use to represent implication. */
	public static final String IMPLIES = " ⇒ ";
	/** The string we will use to represent a contradiction. */
	public static final String CONTRADICTION = "⊥";

	/** A string used to describe the order dependence function's left delimiter. */
	public static final String ORDER_LEFT = "ω(";
	/** A string used to describe the order dependence function's separation delimiter. */
	public static final String ORDER_SEPARATOR = ",";
	/** A string used to describe the order dependence function's right delimiter. */
	public static final String ORDER_RIGHT = ")";

	/** A string used to describe an arbitrary expression. */
	public static final String EXPR = "e";
	/** A string used to describe another arbitrary expression. */
	public static final String EXPR_PRIME = "e'";
	/** A string used to describe another arbitrary expression. */
	public static final String EXPR1 = "e1";
	/** A string used to describe another arbitrary expression. */
	public static final String EXPR2 = "e2";

	/** A string used to prefix a metaprogram ID. */
	public static final String METAPROG_PREFIX = "^";
	/** A string used to describe an arbitrary metaprogram. */
	public static final String METAPROG = "^m";
	/** A string used to describe another arbitrary metaprogram. */
	public static final String METAPROG2 = "^n";

	/** A string used to describe an arbitrary predicate function. */
	public static final String PREDICATE = "P";

	/** A list containing an enumeration of all known closure rules. */
	public static final List<ClosureRule> CLOSURE_RULES = Collections.unmodifiableList(Arrays.<ClosureRule> asList(
			CannotRemoveEndClosureRuleImpl.SINGLETON, CannotRemoveStartClosureRuleImpl.SINGLETON,
			DualWriteAfterConflictClosureRuleImpl.SINGLETON, DualWriteBeforeConflictClosureRuleImpl.SINGLETON,
			DualWriteConflictClosureRuleImpl.SINGLETON, EffectAfterIsArgInvariantInClosureRuleImpl.SINGLETON,
			EffectAfterIsNewEffectInClosureRuleImpl.SINGLETON, EffectBeforeIsArgInvariantInClosureRuleImpl.SINGLETON,
			EffectBeforeIsNewEffectInClosureRuleImpl.SINGLETON,
			InvariantAfterIsArgInvariantInClosureRuleImpl.SINGLETON, InvariantAfterIsBeforeClosureRuleImpl.SINGLETON,
			InvariantAfterIsNewInvariantInClosureRuleImpl.SINGLETON, InvariantBeforeIsAfterClosureRuleImpl.SINGLETON,
			InvariantBeforeIsArgInvariantInClosureRuleImpl.SINGLETON,
			InvariantBeforeIsNewInvariantInClosureRuleImpl.SINGLETON, NothingAddedAfterEndClosureRuleImpl.SINGLETON,
			NothingAddedBeforeStartClosureRuleImpl.SINGLETON, NothingExistsAfterEndClosureRuleImpl.SINGLETON,
			NothingExistsBeforeStartClosureRuleImpl.SINGLETON, PredicateCannotChangeClosureRuleImpl.SINGLETON,
			ReadWriteAfterConflictClosureRuleImpl.SINGLETON, ReadWriteBeforeConflictClosureRuleImpl.SINGLETON,
			ReadWriteConflictClosureRuleImpl.SINGLETON));

	/** A list containing all of the unary closure rules. */
	public static final List<UnaryKnowledgeClosureRule> UNARY_CLOSURE_RULES;
	/** A list containing all of the binary closure rules. */
	public static final List<BinaryKnowledgeClosureRule> BINARY_CLOSURE_RULES;

	static
	{
		ArrayList<UnaryKnowledgeClosureRule> unary = new ArrayList<UnaryKnowledgeClosureRule>();
		ArrayList<BinaryKnowledgeClosureRule> binary = new ArrayList<BinaryKnowledgeClosureRule>();
		for (ClosureRule rule : CLOSURE_RULES)
		{
			if (rule instanceof UnaryKnowledgeClosureRule)
			{
				unary.add((UnaryKnowledgeClosureRule) rule);
			} else if (rule instanceof BinaryKnowledgeClosureRule)
			{
				binary.add((BinaryKnowledgeClosureRule) rule);
			} else
			{
				throw new IllegalStateException("Do not know how to handle rule of type " + rule.getClass()
						+ " in initializer");
			}
		}
		unary.trimToSize();
		binary.trimToSize();
		UNARY_CLOSURE_RULES = Collections.unmodifiableList(unary);
		BINARY_CLOSURE_RULES = Collections.unmodifiableList(binary);
	}

	private KnowledgeUtilities()
	{
	}

	/**
	 * Retrieves an immutable list representing a current stack trace.
	 * 
	 * @return The stack trace.
	 */
	public static List<StackTraceElement> getStackTrace()
	{
		List<StackTraceElement> list = new LinkedList<StackTraceElement>(
				Arrays.asList(Thread.currentThread().getStackTrace()));
		// Throw away the Thread.getStackTrace() frame as well as this one
		for (int i=0;i<2;i++)
		{
			if (list.size() > 0)
			{
				list.remove(0);
			}
		}
		return Collections.unmodifiableList(list);
	}
}
