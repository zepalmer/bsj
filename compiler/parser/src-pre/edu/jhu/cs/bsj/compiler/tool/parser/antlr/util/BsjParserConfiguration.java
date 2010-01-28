package edu.jhu.cs.bsj.compiler.tool.parser.antlr.util;

/**
 * Represents a configuration for a BSJ parser.  An instance of this class dictates which syntax elements are legal
 * and which are not.
 * @author Zachary Palmer
 */
public enum BsjParserConfiguration
{
	PLAIN_JAVA_1_6(JavaVersion.JLS3, BsjVersion.NONE),
	BSJ_1_0(JavaVersion.JLS3, BsjVersion.BLS1)
	;
	
	/** An enumeration of the versions of Java supported by the BSJ parser. */
	public static enum JavaVersion
	{
		/** Indicates that the Java Language Specification v3 should be observed. */
		JLS3
	}
	
	/** An enumeration of the versions of BSJ supported by the BSJ parser. */
	public static enum BsjVersion
	{
		/** Indicates that BSJ should not be used in any form.  This causes a BSJ parser to behave like a normal Java
		 *  parser. */
		NONE(false),
		/** Indicates that the BSJ Language Specification v1 should be observed. */
		BLS1(true)
		;
		
		/** Indicates whether or not this BSJ version supports metaprograms of the [: :] variety. */
		private boolean metaprogramsSupported;

		private BsjVersion(boolean metaprogramsSupported)
		{
			this.metaprogramsSupported = metaprogramsSupported;
		}

		public boolean getMetaprogramsSupported()
		{
			return metaprogramsSupported;
		}
	}
	
	/** The version of Java this configuration uses. */
	private JavaVersion javaVersion;
	/** The version of BSJ this configuration uses. */
	private BsjVersion bsjVersion;
	
	private BsjParserConfiguration(JavaVersion javaVersion, BsjVersion bsjVersion)
	{
		this.javaVersion = javaVersion;
		this.bsjVersion = bsjVersion;
	}

	public JavaVersion getJavaVersion()
	{
		return javaVersion;
	}

	public BsjVersion getBsjVersion()
	{
		return bsjVersion;
	}
	
	/** Determines whether or not this configuration supports BSJ metaprograms. */
	public boolean getMetaprogramsSupported()
	{
		return this.bsjVersion.getMetaprogramsSupported();
	}
}
