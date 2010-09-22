package edu.jhu.cs.bsj.compiler.tool.typechecker;

import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

/**
 * This data structure contains the result of a typechecking operation.
 * 
 * @author Zachary Palmer
 */
public interface TypecheckerResult
{
	/**
	 * The type which was produced.
	 * @return The type of the processed AST.
	 */
	public BsjType getType();

	/**
	 * The metadata which was gathered.
	 * @return The metadata which was obtained during typechecking.
	 */
	public TypecheckerMetadata getMetadata();

}