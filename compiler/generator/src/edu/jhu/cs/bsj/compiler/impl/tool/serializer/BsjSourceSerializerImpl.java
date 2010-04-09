package edu.jhu.cs.bsj.compiler.impl.tool.serializer;

import java.io.ByteArrayOutputStream;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.util.BsjNodeOperationProxy;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;

public class BsjSourceSerializerImpl extends BsjNodeOperationProxy<PrependablePrintStream, Void, Void, String>
		implements BsjSourceSerializer
{
	/** The current {@link PrependablePrintStream} being used.  This value is meaningless between calls.*/
	private PrependablePrintStream ps;
	/** The current buffer being used.  This value is meaningless between calls. */
	private ByteArrayOutputStream buffer;
	
	/**
	 * Creates a serializer using a default helper.
	 */
	public BsjSourceSerializerImpl()
	{
		this(new BsjSourceSerializerHelper());
	}
	
	/**
	 * Creates a serializer using the specified helper.
	 * @param helper The helper to use.
	 */
	public BsjSourceSerializerImpl(BsjNodeOperation<PrependablePrintStream, Void> helper)
	{
		super(helper);
	}

	@Override
	protected String after(Void r)
	{
		this.ps.close();
		String ret = this.buffer.toString();
		this.ps = null;
		this.buffer = null;
		return ret;
	}

	@Override
	protected PrependablePrintStream before(Void p)
	{
		this.buffer = new ByteArrayOutputStream();
		this.ps = new PrependablePrintStream(buffer, "    ", 0);
		return this.ps;
	}
}
