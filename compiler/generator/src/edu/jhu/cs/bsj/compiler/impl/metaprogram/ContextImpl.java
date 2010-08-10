package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * Represents a standard context implementation.
 * @author Zachary Palmer
 *
 * @param <T> The type of anchor node held by this context.
 */
public class ContextImpl<T extends MetaprogramAnchorNode<?>> implements Context<T>
{
	/** The anchor for this context. */
	private T anchor;
	/** The factory for this context. */
	private BsjNodeFactory factory;
	/** The diagnostic listener for this context. */
	private BsjUserDiagnosticListener diagnosticListener;
	/** The compilation unit loader for this context. */
	private CompilationUnitLoader compilationUnitLoader;
	
	/**
	 * Creates a standard context implementation.
	 */
	public ContextImpl(T anchor, BsjNodeFactory factory, BsjUserDiagnosticListener diagnosticListener,
			CompilationUnitLoader compilationUnitLoader)
	{
		super();
		this.anchor = anchor;
		this.factory = factory;
		this.diagnosticListener = diagnosticListener;
		this.compilationUnitLoader = compilationUnitLoader;
	}

	@Override
	public T getAnchor()
	{
		return this.anchor;
	}

	@Override
	public BsjNodeFactory getFactory()
	{
		return this.factory;
	}

	@Override
	public BsjUserDiagnosticListener getDiagnosticListener()
	{
		return this.diagnosticListener;
	}

	@Override
	public CompilationUnitLoader getCompilationUnitLoader()
	{
		return compilationUnitLoader;
	}
	
}
