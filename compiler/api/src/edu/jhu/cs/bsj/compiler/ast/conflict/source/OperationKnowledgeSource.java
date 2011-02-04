package edu.jhu.cs.bsj.compiler.ast.conflict.source;

import java.util.List;

/**
 * Represents knowledge gained from a specific method invocation or other such operation.
 * @author Zachary Palmer
 */
public interface OperationKnowledgeSource extends KnowledgeSource
{
    /**
     * Produces a list of stack trace elements describing the point at which the knowledge was gained.
     * @return The stack trace element list.
     */
    public List<StackTraceElement> getTrace();
}
