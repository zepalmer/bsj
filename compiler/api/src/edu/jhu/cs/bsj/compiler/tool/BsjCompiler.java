package edu.jhu.cs.bsj.compiler.tool;

import java.io.IOException;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * This interface is implemented by any class which can serve as a BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public interface BsjCompiler
{
	/**
	 * Compiles the specified compilation units. These units must exist on the {@link BsjFileManager} provided to this
	 * compiler at construction. If this method terminates normally, compilation was successful.
	 * 
	 * @param units The compilation units to compile.
	 * @param listener The diagnostic listener to which events should be reported. If <code>null</code>, a default
	 *            listener is used which reports diagnostic messages to standard error.
	 * @throws IOException If an I/O error occurs.
	 */
	public void compile(Iterable<BsjFileObject> units, DiagnosticListener<? super JavaFileObject> listener)
			throws IOException;
}
