package edu.jhu.cs.bsj.compiler.impl.utils.diagnostic;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

public class DiagnosticPrintingListener<T> implements DiagnosticListener<T>
{
	/** The stream to which this listener reports its diagnostics. */
	private PrintStream printStream;
	
	public DiagnosticPrintingListener(OutputStream printStream)
	{
		super();
		if (printStream instanceof PrintStream)
		{
			this.printStream = (PrintStream)printStream;
		} else
		{
			this.printStream = new PrintStream(printStream);
		}
	}

	public DiagnosticPrintingListener(PrintStream printStream)
	{
		super();
		this.printStream = printStream;
	}

	@Override
	public void report(Diagnostic<? extends T> diagnostic)
	{
		this.printStream.println(diagnostic.getMessage(null));
	}
}
