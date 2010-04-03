package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

/**
 * This diagnostic listener is used to produce no effect whatsoever when a diagnostic is observed.
 * @author Zachary Palmer
 */
public class NoOperationDiagnosticListener<T> implements DiagnosticListener<T>
{
	@Override
	public void report(Diagnostic<? extends T> diagnostic)
	{
	}
}
