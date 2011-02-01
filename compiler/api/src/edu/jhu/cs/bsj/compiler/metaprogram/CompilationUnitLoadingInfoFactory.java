package edu.jhu.cs.bsj.compiler.metaprogram;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * Objects meeting this interface are capable of producing {@link CompilationUnitLoadingInfo} units for use with the
 * associated toolkit.
 * @author Zachary Palmer
 */
public interface CompilationUnitLoadingInfoFactory
{
	/**
	 * Creates a {@link CompilationUnitLoadingInfo}.
	 * @param listener The {@link DiagnosticListener} to which messages will be reported when the loader is used.
	 * @return The resulting loader.
	 */
	public CompilationUnitLoadingInfo makeLoadingInfo(DiagnosticListener<BsjSourceLocation> diagnosticListener);
}
