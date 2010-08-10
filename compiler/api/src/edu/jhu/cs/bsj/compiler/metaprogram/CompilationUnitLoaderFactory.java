package edu.jhu.cs.bsj.compiler.metaprogram;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * Objects meeting this interface are capable of producing {@link CompilationUnitLoader} units for use with the
 * associated toolkit.
 * @author Zachary Palmer
 */
public interface CompilationUnitLoaderFactory
{
	/**
	 * Creates a {@link CompilationUnitLoader}.
	 * @param listener The {@link DiagnosticListener} to which messages will be reported when the loader is used.
	 * @return The resulting loader.
	 */
	public CompilationUnitLoader makeLoader(DiagnosticListener<BsjSourceLocation> diagnosticListener);
}
