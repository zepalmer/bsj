package edu.jhu.cs.bsj.compiler.metaprogram;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * Objects meeting this interface allow metaprograms to load compilation units from the underlying file manager and
 * include them in compilation.
 * 
 * @author Zachary Palmer
 */
public interface CompilationUnitLoadingInfo
{
    /**
     * Retrieves the diagnostic listener which should be used to report diagnostic information during loading operations.
     * @return The diagnostic listener to use.
     */
    public DiagnosticListener<BsjSourceLocation> getDiagnosticListener();
}
