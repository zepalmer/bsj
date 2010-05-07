package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;

/**
 * Contains information about the manner in which a metaprogram was injected.
 * 
 * @author Zachary Palmer
 */
public class InjectionInfo
{
	/**
	 * A field containing the metaprogram which injected this new metaprogram into the AST. This field is
	 * <code>null</code> if the metaprogram was not injected (that is, if it existed in original source).
	 */
	private MetaprogramProfile<?> parentProfile;
	/**
	 * <code>true</code> if this metaprogram was injected directly by a metaprogram; <code>false</code> if it was
	 * sourced from a file.
	 */
	private boolean purelyInjected;

	public InjectionInfo(MetaprogramProfile<?> parentProfile, boolean purelyInjected)
	{
		super();
		this.parentProfile = parentProfile;
		this.purelyInjected = purelyInjected;
	}

	public MetaprogramProfile<?> getParentProfile()
	{
		return parentProfile;
	}

	public boolean isPurelyInjected()
	{
		return purelyInjected;
	}

}
