package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

public class CompilationUnitLoadingInfoImpl implements CompilationUnitLoadingInfo
{
    private DiagnosticListener<BsjSourceLocation> diagnosticListener;

    public CompilationUnitLoadingInfoImpl(DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        super();
        this.diagnosticListener = diagnosticListener;
    }

    public DiagnosticListener<BsjSourceLocation> getDiagnosticListener()
    {
        return diagnosticListener;
    }

}
