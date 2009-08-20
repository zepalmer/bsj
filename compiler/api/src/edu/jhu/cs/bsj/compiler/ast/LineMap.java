package edu.jhu.cs.bsj.compiler.ast;

/**
 * Provides methods to convert between character 
 * positions and line numbers for a compilation unit. 
 */
public interface LineMap
{
    long getColumnNumber(long pos);

    long getLineNumber(long pos);

    long getPosition(long line, long column);

    long getStartPosition(long line);
}
