package edu.jhu.cs.bsj.compiler.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This type of BSJ error indicates that multiple errors may have occurred.  This is particularly useful when throwing
 * an exception in a compiler or other environment where as many errors as possible should be provided.  The errors
 * stored in this object are listed in the order in which they were detected.
 * @author Zachary Palmer
 */
public class BsjCompositeCompilerException extends BsjCompilerException
{
	private static final long serialVersionUID = 1L;
	
	/** The errors which were detected. */
	private List<BsjCompilerException> errors;
	
	public BsjCompositeCompilerException(BsjCompilerException... errors)
	{
		this(new ArrayList<BsjCompilerException>(Arrays.asList(errors)));
	}

	public BsjCompositeCompilerException(List<BsjCompilerException> errors)
	{
		super(null);
		this.errors = errors;
	}

	public List<BsjCompilerException> getErrors()
	{
		return errors;
	}

	@Override
	public String getMessage()
	{
		return errors.size() + " error" + (errors.size()!=1?"s":"");
	}
}
