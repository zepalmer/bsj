package edu.jhu.cs.bsj.compiler.error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This type of BSJ error indicates that multiple errors may have occurred.  This is particularly useful when throwing
 * an exception in a compiler or other environment where as many errors as possible should be provided.  The errors
 * stored in this object are listed in the order in which they were detected.
 * @author Zachary Palmer
 */
public class BsjCompositeCompilerError extends BsjCompilerError
{
	private static final long serialVersionUID = 1L;
	
	/** The errors which were detected. */
	private List<BsjCompilerError> errors;
	
	public BsjCompositeCompilerError(BsjCompilerError... errors)
	{
		this(new ArrayList<BsjCompilerError>(Arrays.asList(errors)));
	}

	public BsjCompositeCompilerError(List<BsjCompilerError> errors)
	{
		super();
		this.errors = errors;
	}

	public List<BsjCompilerError> getErrors()
	{
		return errors;
	}
}
