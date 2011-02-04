package edu.jhu.cs.bsj.compiler.impl.ast.conflict.source;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.conflict.source.OperationKnowledgeSource;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities;

public class OperationKnowledgeSourceImpl extends AbstractKnowledgeSourceImpl implements OperationKnowledgeSource
{
    private List<StackTraceElement> trace;

    public OperationKnowledgeSourceImpl()
    {
        this(0);
    }
    
    public OperationKnowledgeSourceImpl(int extraRemoveCount)
    {
        this(reduceStackTrace(KnowledgeBaseUtilities.getStackTrace(), extraRemoveCount));        
    }

    /**
     * Removes the top element from the provided stack trace.  This is useful for the default constructor to remove the
     * constructor itself from the stack trace.
     * @param stackTrace The incoming stack trace.
     * @param extraRemoveCount The number of extra frames to remove (in case the caller knows of additional frames that
     *                         should be discarded).
     * @return The resulting stack trace.
     */
    private static List<StackTraceElement> reduceStackTrace(List<StackTraceElement> stackTrace, int extraRemoveCount)
    {
        final int removeCount = Math.min(extraRemoveCount + 1, stackTrace.size());
        return stackTrace.subList(removeCount, stackTrace.size());
    }

    public OperationKnowledgeSourceImpl(List<StackTraceElement> trace)
    {
        super();
        this.trace = trace;
    }

    @Override
    public List<StackTraceElement> getTrace()
    {
        return this.trace;
    }

}
