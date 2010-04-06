package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;
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
	
	/**
	 * Creates a standard context implementation.
	 * @param anchor The anchor to use.
	 * @param factory The node factory to use.
	 */
	public ContextImpl(T anchor, BsjNodeFactory factory, BsjUserDiagnosticListener diagnosticListener)
	{
		super();
		this.anchor = anchor;
		this.factory = factory;
		this.diagnosticListener = diagnosticListener;
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
}
