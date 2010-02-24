package edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This {@link AncestryExecutingNodeOperation} extension is designed to allow node operations to return a
 * <code>null</code> reference as a final answer if so desired. The outcome of this operation is contained inside of a
 * {@link NullableAncestryExecutingNodeOperation.Result} object. If that object is <code>null</code>, no definitive
 * answer was received from any of the ancestors. If the result is a
 * {@link NullableAncestryExecutingNodeOperation.Result} object, that object represents the first definitive answer
 * found. Because of this additional level of indirection, it is possible for the
 * <tt>NullableAncestryExecutingNodeOperation</tt> to return a {@link NullableAncestryExecutingNodeOperation.Result
 * Result} which contains a <code>null</code> reference.
 * 
 * @author Zachary Palmer
 */
public class NullableAncestryExecutingNodeOperation<R> extends
		AncestryExecutingNodeOperation<NullableAncestryExecutingNodeOperation.Result<R>>
{
	/**
	 * This class acts as a container for the result of this operation.
	 */
	static class Result<T>
	{
		private T value;

		/**
		 * Creates a new result.
		 * 
		 * @param value The value to store in the result.
		 */
		public Result(T value)
		{
			super();
			this.value = value;
		}

		/**
		 * Gets this result's value.
		 * 
		 * @return The value in this result.
		 */
		public T getValue()
		{
			return value;
		}
	}

	/**
	 * Creates a new ancestry operation.
	 * @param operation The operation to execute on each ancestor node.
	 */
	public NullableAncestryExecutingNodeOperation(BsjNodeOperation<List<Node>, Result<R>> operation)
	{
		super(operation);
	}
}
