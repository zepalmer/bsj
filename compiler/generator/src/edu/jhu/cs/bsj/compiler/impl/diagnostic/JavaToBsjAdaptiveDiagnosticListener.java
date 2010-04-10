package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.JavaCompilationErrorDiagnosticImpl;

/**
 * This listener converts Java compiler diagnostics to BSJ compiler diagnostics.
 * 
 * @author Zachary Palmer
 */
public class JavaToBsjAdaptiveDiagnosticListener implements DiagnosticListener<JavaFileObject>
{
	/** The backing listener. */
	private DiagnosticListener<? super BsjSourceLocation> listener;

	public JavaToBsjAdaptiveDiagnosticListener(DiagnosticListener<? super BsjSourceLocation> listener)
	{
		super();
		this.listener = listener;
	}

	@Override
	public void report(Diagnostic<? extends JavaFileObject> diagnostic)
	{
		this.listener.report(convert(diagnostic));
	}

	private <T extends JavaFileObject> Diagnostic<BsjSourceLocation> convert(Diagnostic<T> diagnostic)
	{
		return new JavaCompilationErrorDiagnosticImpl<T>(new BsjSourceLocation(diagnostic.getSource().getName(),
				(int)diagnostic.getLineNumber(), (int)diagnostic.getColumnNumber()), diagnostic);
	}
}
