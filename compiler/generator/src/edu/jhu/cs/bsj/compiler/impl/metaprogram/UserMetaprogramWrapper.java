package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * This class acts as an adapter between the user-specifiable metaprogram interface ({@link BsjMetaprogram}) and the
 * internal compiler representation of metaprograms ({@link Metaprogram}).
 * @author Zachary Palmer
 */
public class UserMetaprogramWrapper<T extends MetaprogramAnchorNode<?>> extends AbstractMetaprogram<T>
{
	/** The user metaprogram object. */
	private BsjMetaprogram<T> metaprogram;

	public UserMetaprogramWrapper(BsjMetaprogram<T> metaprogram)
	{
		super();
		this.metaprogram = metaprogram;
	}

	@Override
	public void execute(Context<T> context)
	{
		this.metaprogram.execute(context);
	}
}
