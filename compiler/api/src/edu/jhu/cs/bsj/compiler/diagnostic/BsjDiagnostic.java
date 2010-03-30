package edu.jhu.cs.bsj.compiler.diagnostic;

import javax.tools.Diagnostic;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;

/**
 * An interface implemented by all diagnostics produced by the BSJ compiler.
 * @author Zachary Palmer
 */
public interface BsjDiagnostic extends Diagnostic<BsjSourceLocation>
{

}
