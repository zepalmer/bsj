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
 * 
 * @author Zachary Palmer
 */
public class LocationTranslatingDiagnosticListener implements DiagnosticListener<BsjSourceLocation>
{
	/** The backing listener to which to report the diagnostic. */
	private DiagnosticListener<BsjSourceLocation> listener;
	/** The node map for translation. */
	private SerializedNodeMap nodeMap;
	/** The default location for no-position diagnostics. */
	private BsjSourceLocation defaultLocation;

	public LocationTranslatingDiagnosticListener(DiagnosticListener<BsjSourceLocation> listener,
			SerializedNodeMap nodeMap, BsjSourceLocation defaultLocation)
	{
		super();
		this.listener = listener;
		this.nodeMap = nodeMap;
		this.defaultLocation = defaultLocation;
	}

	@Override
	public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
	{
		int line = (int) diagnostic.getLineNumber();
		int column = (int) diagnostic.getColumnNumber();
		final BsjSourceLocation location;
		if (line == -1 || column == -1)
		{
			location = this.defaultLocation;
		} else
		{
			Node node = this.nodeMap.get(line, column);
			location = node.getStartLocation();
		}
		this.listener.report(create(location, diagnostic));
	}

	private <T extends BsjSourceLocation> MetaprogramCompilationErrorDiagnostic<T> create(BsjSourceLocation location,
			Diagnostic<T> diagnostic)
	{
		return new MetaprogramCompilationErrorDiagnosticImpl<T>(location, diagnostic);
	}
}
