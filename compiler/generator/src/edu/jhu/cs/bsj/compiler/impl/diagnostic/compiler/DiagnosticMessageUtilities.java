package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.OperationKnowledgeSource;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.RuleKnowledgeSource;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DependencyCycleDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;
import edu.jhu.cs.bsj.compiler.impl.utils.i18n.InternationalizationUtilities;

/**
 * This class contains functions which are convenient for the generated source of diagnostic messages.
 * 
 * @author Zachary Palmer
 */
public class DiagnosticMessageUtilities
{
    /**
     * Prevent instantiation of utilities class.
     */
    private DiagnosticMessageUtilities()
    {
    }

    /**
     * Creates a diagnostic message for the {@link DependencyCycleDiagnostic} class based on the cycle it contains. The
     * list of metaprograms must be exactly one larger than the list of targets.
     * 
     * @param metaprograms The metaprograms in the cycle.
     * @param targets The targets in the cycle.
     * @return The appropriate message.
     */
    public static String getDependencyString(List<BsjSourceLocation> metaprograms, List<String> targets)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targets.size(); i++)
        {
            sb.append(metaprograms.get(i));
            sb.append(" -> ");
            sb.append(targets.get(i));
            sb.append(" -> ");
        }
        sb.append(metaprograms.get(metaprograms.size() - 1));
        return sb.toString();
    }

    /**
     * Creates a string containing an indented version of the stack trace of the provided exception.
     * 
     * @param exception The exception to use.
     * @param locale The locale to use (or <code>null</code> for the default locale).
     * @return The resulting string.
     */
    public static String getExceptionString(Throwable e, Locale locale)
    {
        return e.getMessage() + "\n"
                + getIdentedStackTraceString(Arrays.asList(e.getStackTrace()), locale).replaceAll("\n", "\n    ");
    }

    /**
     * Creates a string containing an indented version of the provided stack a result of previous operationstrace.
     * 
     * @param stackTrace The trace to use.
     * @param locale The locale to use (or <code>null</code> for the default locale).
     * @return The resulting string.
     */
    public static String getIdentedStackTraceString(List<StackTraceElement> stackTrace, Locale locale)
    {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement e : stackTrace)
        {
            if (sb.length() > 0)
            {
                sb.append('\n');
            }
            String message = InternationalizationUtilities.MESSAGE_REPOSITORY.getFormattedMessage(locale,
                    "bsj.string.stackTrace.element", Arrays.<Object> asList(e.toString()),
                    Collections.singletonMap("element", 1));
            sb.append(message);
        }
        return sb.toString();
    }

    /**
     * Creates a description of the provided conflicts set.
     * 
     * @param conflicts The conflicts to describe.
     * @param locale The locale to use (or <code>null</code> for the default locale).
     * @return The resulting message.
     */
    public static String getConflictsDescription(Set<? extends ConflictKnowledge<?>> conflicts, Locale locale)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrependablePrintStream ps = new PrependablePrintStream(baos, "    ", 0);
        for (ConflictKnowledge<?> conflict : conflicts)
        {
            generateKnowledgeDescription(conflict, ps, locale);
        }
        ps.close();
        return baos.toString();
    }

    private static final Map<String, Integer> RULE_KNOWLEDGE_SOURCE_HEADER_POSITION_MAP = Collections.unmodifiableMap(CollectionUtilities.mapOf(
            "knowledge", 1, "rule", 2));

    protected static void generateKnowledgeDescription(ListKnowledge<?> knowledge, PrependablePrintStream ps,
            Locale locale)
    {
        if (knowledge.getKnowledgeSource() instanceof RuleKnowledgeSource<?>)
        {
            RuleKnowledgeSource<?> ruleKnowledgeSource = (RuleKnowledgeSource<?>) knowledge.getKnowledgeSource();
            ps.println(InternationalizationUtilities.MESSAGE_REPOSITORY.getFormattedMessage(locale,
                    "bsj.string.part.metaprogram.failure.conflict.list.ruleKnowledgeSourceHeader",
                    Arrays.<Object> asList(knowledge, ruleKnowledgeSource.getRule()),
                    RULE_KNOWLEDGE_SOURCE_HEADER_POSITION_MAP));
            ps.incPrependCount();
            for (ListKnowledge<?> precondition : ruleKnowledgeSource.getKnowledge())
            {
                generateKnowledgeDescription(precondition, ps, locale);
            }
            ps.decPrependCount();
        } else if (knowledge.getKnowledgeSource() instanceof OperationKnowledgeSource<?>)
        {
            OperationKnowledgeSource<?> operationKnowledgeSource = (OperationKnowledgeSource<?>) knowledge.getKnowledgeSource();
            ps.println(InternationalizationUtilities.MESSAGE_REPOSITORY.getFormattedMessage(locale,
                    "bsj.string.part.metaprogram.failure.conflict.list.operationKnowledgeSourceHeader",
                    Arrays.<Object> asList(knowledge), Collections.singletonMap("knowledge", 1)));
            ps.incPrependCount();
            ps.println(getIdentedStackTraceString(operationKnowledgeSource.getStackTrace(), locale));
            ps.decPrependCount();
        } else
        {
            throw new IllegalStateException("Do not know how to handle knowledge source of type "
                    + knowledge.getKnowledgeSource().getClass());
        }
    }

    public static String getDescriptionForConflicts(
            Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> conflicts, Locale locale)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrependablePrintStream ps = new PrependablePrintStream(baos, "    ", 0);
        for (edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge conflict : conflicts)
        {
            generateDescriptionForKnowledge(conflict, ps, locale);
        }
        ps.close();
        return baos.toString();
    }

    private static void generateDescriptionForKnowledge(Knowledge knowledge, PrependablePrintStream ps, Locale locale)
    {
        if (knowledge.getSource() instanceof edu.jhu.cs.bsj.compiler.ast.conflict.source.RuleKnowledgeSource)
        {
            edu.jhu.cs.bsj.compiler.ast.conflict.source.RuleKnowledgeSource<?> ruleKnowledgeSource = (edu.jhu.cs.bsj.compiler.ast.conflict.source.RuleKnowledgeSource<?>) knowledge.getSource();
            ps.println(InternationalizationUtilities.MESSAGE_REPOSITORY.getFormattedMessage(locale,
                    "bsj.string.part.metaprogram.failure.conflict.package.ruleKnowledgeSourceHeader",
                    Arrays.<Object> asList(knowledge, ruleKnowledgeSource.getRule()),
                    RULE_KNOWLEDGE_SOURCE_HEADER_POSITION_MAP));
            ps.incPrependCount();
            for (Knowledge precondition : ruleKnowledgeSource.getKnowledge())
            {
                generateDescriptionForKnowledge(precondition, ps, locale);
            }
            ps.decPrependCount();
        } else if (knowledge.getSource() instanceof edu.jhu.cs.bsj.compiler.ast.conflict.source.OperationKnowledgeSource)
        {
            edu.jhu.cs.bsj.compiler.ast.conflict.source.OperationKnowledgeSource operationKnowledgeSource = (edu.jhu.cs.bsj.compiler.ast.conflict.source.OperationKnowledgeSource) knowledge.getSource();
            ps.println(InternationalizationUtilities.MESSAGE_REPOSITORY.getFormattedMessage(locale,
                    "bsj.string.part.metaprogram.failure.conflict.package.operationKnowledgeSourceHeader",
                    Arrays.<Object> asList(knowledge), Collections.singletonMap("knowledge", 1)));
            ps.incPrependCount();
            ps.println(getIdentedStackTraceString(operationKnowledgeSource.getTrace(), locale));
            ps.decPrependCount();
        } else
        {
            throw new IllegalStateException("Do not know how to handle knowledge source of type "
                    + knowledge.getSource().getClass());
        }
    }
}
