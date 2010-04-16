package edu.jhu.cs.bsj.compiler.tool;

import java.io.IOException;
import java.util.Random;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
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
	public void compile(Iterable<BsjFileObject> units, DiagnosticListener<BsjSourceLocation> listener)
			throws IOException;

	/**
	 * Compiles the specified compilation units. These units must exist on the {@link BsjFileManager} provided to this
	 * compiler at construction. If this method terminates normally, compilation was successful.
	 * 
	 * @param units The compilation units to compile.
	 * @param listener The diagnostic listener to which events should be reported. If <code>null</code>, a default
	 *            listener is used which reports diagnostic messages to standard error.
	 * @param random A random number generator used to select the order of execution. If <code>null</code>, execution
	 *            order is uncontrolled and arbitrary. Using a generator which produces the same sequences to compile
	 *            the same code always produces the same order of execution. This is intended for debugging purposes.
	 * @throws IOException If an I/O error occurs.
	 */
	public void compile(Iterable<BsjFileObject> units, DiagnosticListener<BsjSourceLocation> listener, Random random)
			throws IOException;
}
