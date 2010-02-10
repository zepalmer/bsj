package edu.jhu.cs.bsj.compiler.diagnostic;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * An interface implemented by all diagnostics produced by the BSJ compiler.
 * @author Zachary Palmer
 *
 * @param <T> The type of source object used to create this diagnostic.
 */
public interface BsjDiagnostic<T extends JavaFileObject> extends Diagnostic<T>
{

}
