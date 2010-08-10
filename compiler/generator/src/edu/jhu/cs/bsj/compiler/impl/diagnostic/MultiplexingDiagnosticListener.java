package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import java.util.Collection;
import java.util.Collections;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;

/**
 * This listener multiplexes messages to a number of underlying targets.
 * 
 * @author Zachary Palmer
 */
public class MultiplexingDiagnosticListener implements DiagnosticListener<BsjSourceLocation>
{
	private Collection<? extends DiagnosticListener<BsjSourceLocation>> underlyingListeners;

	public MultiplexingDiagnosticListener(DiagnosticListener<BsjSourceLocation> listener)
	{
		this(Collections.singleton(listener));
	}

	public MultiplexingDiagnosticListener(DiagnosticListener<BsjSourceLocation> listener1,
			DiagnosticListener<BsjSourceLocation> listener2)
	{
		this(new TwoElementImmutableSet<DiagnosticListener<BsjSourceLocation>>(listener1, listener2));
	}

	public MultiplexingDiagnosticListener(
			Collection<? extends DiagnosticListener<BsjSourceLocation>> underlyingListeners)
	{
		super();
		this.underlyingListeners = underlyingListeners;
	}

	@Override
	public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
	{
		for (DiagnosticListener<BsjSourceLocation> listener : this.underlyingListeners)
		{
			listener.report(diagnostic);
		}
	}

}
