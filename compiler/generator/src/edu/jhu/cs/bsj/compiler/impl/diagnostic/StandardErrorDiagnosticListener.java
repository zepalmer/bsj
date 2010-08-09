package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * This diagnostic listener is used to report every diagnostic it receives to standard error.  It is intended to be
 * used for debugging.
 * @author Zachary Palmer
 */
public class StandardErrorDiagnosticListener implements DiagnosticListener<BsjSourceLocation>
{
	@Override
	public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
	{
		System.err.println(diagnostic.getMessage(null));
	}
}
