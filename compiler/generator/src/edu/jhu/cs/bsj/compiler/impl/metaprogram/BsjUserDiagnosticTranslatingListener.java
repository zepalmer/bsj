package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.UserDiagnosticImpl;

/**
 * This diagnostic listener serves as an adapter between BSJ user diagnostics and BSJ compiler diagnostics.
 * @author Zachary Palmer
 */
public class BsjUserDiagnosticTranslatingListener implements BsjUserDiagnosticListener
{
	/**
	 * The JSR-199 diagnostic listener to which to report the incoming diagnostics.
	 */
	private DiagnosticListener<BsjSourceLocation> listener;
	/**
	 * The source location to report for all incoming diagnostics.
	 */
	private BsjSourceLocation location;

	/**
	 * Creates a new translating listener.
	 * @param listener The backing listener to which to report BSJ compiler diagnostics.
	 * @param location The location to attach to the BSJ user diagnostics when reporting to the compiler.
	 */
	public BsjUserDiagnosticTranslatingListener(DiagnosticListener<BsjSourceLocation> listener,
			BsjSourceLocation location)
	{
		super();
		this.listener = listener;
		this.location = location;
	}

	/**
	 * Creates a new translating listener.
	 * @param listener The underlying listener.
	 */
	public BsjUserDiagnosticTranslatingListener(DiagnosticListener<BsjSourceLocation> listener)
	{
		super();
		this.listener = listener;
	}

	@Override
	public void report(BsjUserDiagnostic diagnostic)
	{
		this.listener.report(new UserDiagnosticImpl(this.location, diagnostic));
	}
}
