package edu.jhu.cs.bsj.compiler.impl.ast.conflict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.conflict.KnowledgeBase;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.rule.KnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule.FilterAndMatchingSuccessfulLoadConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule.GetAndPutConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule.LoadAndPutConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule.PutAndFilterConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule.PutAndPutConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule.UnloadedGetAndSuccessfulLoadConflictClosureRuleImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilerUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;

/**
 * Contains a number of constants for representing the knowledge and rules used by the conflict detection system.
 * 
 * @author Zachary Palmer
 */
public class KnowledgeBaseUtilities
{
    /** The string we will use to represent the left delimiter of effects. */
    public static final String EFFECT_LEFT = "╓";
    /** The string we will use to represent the right delimiter of effects. */
    public static final String EFFECT_RIGHT = "╖";
    /** The string we will use to represent the left delimiter of invariants. */
    public static final String INVARIANT_LEFT = "╙";
    /** The string we will use to represent the right delimiter of invariants. */
    public static final String INVARIANT_RIGHT = "╜";
    /** The string we will use to represent the left delimiter of load operations. */
    public static final String LOAD_LEFT = "«";
    /** The string we will use to represent the right delimiter of load operations. */
    public static final String LOAD_RIGHT = "»";

    /** The string we will use to represent a mapping relationship. */
    public static final String MAPS_TO = "↦";
    /** The string we use to represent a successful load. */
    public static final String LOAD_SUCCESS = "+";
    /** The string we use to represent a failed load. */
    public static final String LOAD_FAILURE = "-";
    /** The string we use to represent a loaded get. */
    public static final String GET_LOADED = "[L]";
    /** The string we use to represent an unloaded get. */
    public static final String GET_UNLOADED = "[U]";

    /** The string we will use to represent the list start symbol. */
    public static final String LIST_START_SYMBOL = "▷";
    /** The string we will use to represent the list end symbol. */
    public static final String LIST_END_SYMBOL = "◁";

    /** The string we will use to represent the binary operator which positions an element to the right of another. */
    public static final String ELEMENT_FOLLOWS = "↬";
    /** The string we will use to represent the binary operator which positions an element to the left of another. */
    public static final String ELEMENT_LEADS = "↫";
    /** The string we will use to represent the unary operator which indicates a change in list containment. */
    public static final String LIST_CONTAINMENT = "∈*";

    /** The string we will use to represent logical conjunction. */
    public static final String AND = " ∧ ";
    /** The string we will use to represent implication. */
    public static final String IMPLIES = " ⇒ ";
    /** The string we will use to represent a contradiction. */
    public static final String CONTRADICTION = "⊥";

    /** The string we will use to represent set containment. */
    public static final String SET_CONTAINMENT = "∈";
    /** The string we will use to represent set non-containment. */
    public static final String SET_NONCONTAINMENT = "∉";

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

    /** A string used to describe an arbitrary simple name. */
    public static final String SIMPLE_NAME = "s";
    /** A string used to describe a set of simple names. */
    public static final String SIMPLE_NAME_SET = "S";

    /** A string used to prefix a metaprogram ID. */
    public static final String METAPROG_PREFIX = "^";
    /** A string used to describe an arbitrary metaprogram. */
    public static final String METAPROG = METAPROG_PREFIX + "m";
    /** A string used to describe another arbitrary metaprogram. */
    public static final String METAPROG2 = METAPROG_PREFIX + "n";

    /** A string used to describe an arbitrary predicate function. */
    public static final String PREDICATE = "P";

    /** A string used to describe a tupling operation. */
    public static final String TUPLER = ",";

    /** A collection containing an enumeration of all known package closure rules. */
    private static final Set<KnowledgeClosureRule<PackageKnowledge>> PACKAGE_CLOSURE_RULES = CollectionUtilities.<KnowledgeClosureRule<PackageKnowledge>> setOf(
            FilterAndMatchingSuccessfulLoadConflictClosureRuleImpl.SINGLETON,
            GetAndPutConflictClosureRuleImpl.SINGLETON, LoadAndPutConflictClosureRuleImpl.SINGLETON,
            PutAndFilterConflictClosureRuleImpl.SINGLETON, PutAndPutConflictClosureRuleImpl.SINGLETON,
            UnloadedGetAndSuccessfulLoadConflictClosureRuleImpl.SINGLETON);

    // /** A list containing an enumeration of all known closure rules. */
    // public static final List<ClosureRule> CLOSURE_RULES = Collections.unmodifiableList(Arrays.<ClosureRule> asList(
    // CannotRemoveEndClosureRuleImpl.SINGLETON, CannotRemoveStartClosureRuleImpl.SINGLETON,
    // DualWriteAfterConflictClosureRuleImpl.SINGLETON, DualWriteBeforeConflictClosureRuleImpl.SINGLETON,
    // DualWriteConflictClosureRuleImpl.SINGLETON, EffectAfterIsArgInvariantInClosureRuleImpl.SINGLETON,
    // EffectAfterIsNewEffectInClosureRuleImpl.SINGLETON, EffectBeforeIsArgInvariantInClosureRuleImpl.SINGLETON,
    // EffectBeforeIsNewEffectInClosureRuleImpl.SINGLETON,
    // InvariantAfterIsArgInvariantInClosureRuleImpl.SINGLETON, InvariantAfterIsBeforeClosureRuleImpl.SINGLETON,
    // InvariantAfterIsNewInvariantInClosureRuleImpl.SINGLETON, InvariantBeforeIsAfterClosureRuleImpl.SINGLETON,
    // InvariantBeforeIsArgInvariantInClosureRuleImpl.SINGLETON,
    // InvariantBeforeIsNewInvariantInClosureRuleImpl.SINGLETON, NothingAddedAfterEndClosureRuleImpl.SINGLETON,
    // NothingAddedBeforeStartClosureRuleImpl.SINGLETON, NothingExistsAfterEndClosureRuleImpl.SINGLETON,
    // NothingExistsBeforeStartClosureRuleImpl.SINGLETON, PredicateCannotChangeClosureRuleImpl.SINGLETON,
    // ReadWriteAfterConflictClosureRuleImpl.SINGLETON, ReadWriteBeforeConflictClosureRuleImpl.SINGLETON,
    // ReadWriteConflictClosureRuleImpl.SINGLETON));
    //
    // /** A list containing all of the unary closure rules. */
    // public static final List<UnaryKnowledgeClosureRule> UNARY_CLOSURE_RULES;
    // /** A list containing all of the binary closure rules. */
    // public static final List<BinaryKnowledgeClosureRule> BINARY_CLOSURE_RULES;
    //
    // static
    // {
    // ArrayList<UnaryKnowledgeClosureRule> unary = new ArrayList<UnaryKnowledgeClosureRule>();
    // ArrayList<BinaryKnowledgeClosureRule> binary = new ArrayList<BinaryKnowledgeClosureRule>();
    // for (ClosureRule rule : CLOSURE_RULES)
    // {
    // if (rule instanceof UnaryKnowledgeClosureRule)
    // {
    // unary.add((UnaryKnowledgeClosureRule) rule);
    // } else if (rule instanceof BinaryKnowledgeClosureRule)
    // {
    // binary.add((BinaryKnowledgeClosureRule) rule);
    // } else
    // {
    // throw new IllegalStateException("Do not know how to handle rule of type " + rule.getClass()
    // + " in initializer");
    // }
    // }
    // unary.trimToSize();
    // binary.trimToSize();
    // UNARY_CLOSURE_RULES = Collections.unmodifiableList(unary);
    // BINARY_CLOSURE_RULES = Collections.unmodifiableList(binary);
    // }

    private KnowledgeBaseUtilities()
    {
    }

    /**
     * Creates a new package knowledge base.
     * 
     * @param metaprogramOrderingRecord The ordering record to use to query about order of metaprograms.
     * @return A new package knowledge base.
     */
    public static KnowledgeBase<PackageKnowledge> createPackageKnowledgeBase(
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        return new KnowledgeBaseImpl<PackageKnowledge>(PACKAGE_CLOSURE_RULES, metaprogramOrderingRecord);

    }

    /**
     * Retrieves an immutable list representing a current stack trace.
     * 
     * @return The stack trace.
     */
    public static List<StackTraceElement> getStackTrace()
    {
        List<StackTraceElement> list = Arrays.asList(Thread.currentThread().getStackTrace());
        // Trim out resulting trace. Throw away first two elements (Thread.getStackTrace() and this one) and anything
        // which appears after an element in the BSJ generated package.
        ArrayList<StackTraceElement> ret = new ArrayList<StackTraceElement>();
        if (list.size() > 2)
        {
            Iterator<StackTraceElement> it = list.iterator();
            it.next();
            it.next();
            while (it.hasNext())
            {
                StackTraceElement element = it.next();
                ret.add(element);
                if (element.getClassName().startsWith(CompilerUtilities.METAPROGRAM_PACKAGE_NAME))
                {
                    break;
                }
            }
        }
        ret.trimToSize();
        return Collections.unmodifiableList(ret);
    }
}
