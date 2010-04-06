package edu.jhu.cs.bsj.compiler.diagnostic.user;

/**
 * An interface provided to BSJ metaprograms in order to receive diagnostics from them.
 * @author Zachary Palmer
 */
public interface BsjUserDiagnosticListener
{
	/**
	 * Reports a diagnostic to this listener.
	 * @param diagnostic The diagnostic to report.
	 */
	public void report(BsjUserDiagnostic diagnostic);
}
