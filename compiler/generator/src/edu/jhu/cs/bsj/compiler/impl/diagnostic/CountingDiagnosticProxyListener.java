package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.Diagnostic.Kind;

/**
 * Acts as a proxy to an existing diagnostic listener. This listener counts the number of each type of diagnostic it
 * sees and then passes the diagnostic to the backing listener. These counts can be retrieved at a later time.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of source for the diagnostics handled by this listener.
 */
public class CountingDiagnosticProxyListener<T> implements DiagnosticListener<T>
{
	/**
	 * An array which is parallel to diagnostic kinds and which tracks the number of times a diagnostic of each kind has
	 * been seen.
	 */
	private int[] kindCounts = new int[Kind.values().length];
	/**
	 * The backing listener.
	 */
	private DiagnosticListener<T> listener;
	
	/**
	 * Creates a new counting proxy listener.
	 * @param listener The backing listener to which to report events.
	 */
	public CountingDiagnosticProxyListener(DiagnosticListener<T> listener)
	{
		super();
		this.listener = listener;
	}

	@Override
	public void report(Diagnostic<? extends T> diagnostic)
	{
		this.kindCounts[diagnostic.getKind().ordinal()]++;
		this.listener.report(diagnostic);
	}
	
	/**
	 * Retrieves the number of times a given kind of diagnostic has been observed.
	 * @param kind The kind of diagnostic to count.
	 * @return The number of times that kind has been observed.
	 */
	public int getCount(Kind kind)
	{
		return this.kindCounts[kind.ordinal()];
	}
}
