package edu.jhu.cs.bsj.compiler;

public interface LineMap
{
    long getColumnNumber(long pos);

    long getLineNumber(long pos);

    long getPosition(long line, long column);

    long getStartPosition(long line);
}
