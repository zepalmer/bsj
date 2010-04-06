package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnostic;

/**
 * This compiler diagnostic is reported when a BSJ metaprogram issues a diagnostic.
 * 
 * @author Zachary Palmer
 */
public interface UserDiagnostic extends BsjCompilerDiagnostic
{
	/**
	 * Retrieves the diagnostic emitted by the metaprogram.
	 */
	public BsjUserDiagnostic getUserDiagnostic();
}
