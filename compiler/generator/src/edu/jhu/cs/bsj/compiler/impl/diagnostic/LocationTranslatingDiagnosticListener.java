package edu.jhu.cs.bsj.compiler.impl.diagnostic;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramCompilationErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramCompilationErrorDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.SerializedNodeMap;

/**
 * This listener receives BSJ diagnostics and translates them using a serialized node translation map.
 * @author Zachary Palmer
 */
public class LocationTranslatingDiagnosticListener implements DiagnosticListener<BsjSourceLocation>
{
	/** The backing listener to which to report the diagnostic. */
	private DiagnosticListener<BsjSourceLocation> listener;
	/** The node map for translation. */
	private SerializedNodeMap nodeMap;

	public LocationTranslatingDiagnosticListener(DiagnosticListener<BsjSourceLocation> listener,
			SerializedNodeMap nodeMap)
	{
		super();
		this.listener = listener;
		this.nodeMap = nodeMap;
	}

	@Override
	public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
	{
		Node node = this.nodeMap.get((int)diagnostic.getLineNumber(), (int)diagnostic.getColumnNumber());
		BsjSourceLocation location = node.getStartLocation();
		this.listener.report(create(location, diagnostic));
	}

	private <T extends BsjSourceLocation> MetaprogramCompilationErrorDiagnostic<T> create(BsjSourceLocation location,
			Diagnostic<T> diagnostic)
	{
		return new MetaprogramCompilationErrorDiagnosticImpl<T>(location, diagnostic);
	}
}
