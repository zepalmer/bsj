package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

/**
 * This diagnostic listener not only counts each diagnostic as it is heard but saves it in a list for later use.
 * @author Zachary Palmer
 * @param <T> The type of source for the diagnostics observed by this listener.
 */
public class RecordingDiagnosticProxyListener<T> extends CountingDiagnosticProxyListener<T>
{
	/** The list of diagnostics observed by this listener. */
	private List<Diagnostic<? extends T>> diagnosticList;
	
	/**
	 * Creates a new recording diagnostic proxy listener.
	 * @param listener The backing listener.
	 */
	public RecordingDiagnosticProxyListener(DiagnosticListener<T> listener)
	{
		super(listener);
		this.diagnosticList = new ArrayList<Diagnostic<? extends T>>();
	}

	@Override
	public void report(Diagnostic<? extends T> diagnostic)
	{
		this.diagnosticList.add(diagnostic);
		super.report(diagnostic);
	}
	
	/**
	 * Retrieves the complete list of diagnostics that this listener has observed.
	 * @return An unmodifiable list containing this listener's diagnostics.
	 */
	public List<Diagnostic<? extends T>> getDiagnostics()
	{
		return Collections.unmodifiableList(this.diagnosticList);
	}
	
}
