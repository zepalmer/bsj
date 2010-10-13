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
		NONE(false,false,false,false),
		/** Indicates that the BSJ Language Specification v1 should be observed. */
		BLS1(true,true,true,true)
		;
		
		/** Indicates whether or not this BSJ version supports metaprograms of the [: :] variety. */
		private boolean metaprogramsSupported;
		/** Indicates whether or not this BSJ version supports meta-annotations. */
		private boolean metaAnnotationsSupported;
		/** Indicates whether or not this BSJ version supports code literals. */
		private boolean codeLiteralsSupported;
		/** Indicates whether or not this BSJ version supports code splicing. */
		private boolean codeSplicingSupported;

		private BsjVersion(boolean metaprogramsSupported, boolean metaAnnotationsSupported,
				boolean codeLiteralsSupported, boolean codeSplicingSupported)
		{
			this.metaprogramsSupported = metaprogramsSupported;
			this.metaAnnotationsSupported = metaAnnotationsSupported;
			this.codeLiteralsSupported = codeLiteralsSupported;
			this.codeSplicingSupported = codeSplicingSupported;
		}

		public boolean getMetaprogramsSupported()
		{
			return metaprogramsSupported;
		}

		public boolean getMetaAnnotationsSupported()
		{
			return metaAnnotationsSupported;
		}

		public boolean getCodeLiteralsSupported()
		{
			return codeLiteralsSupported;
		}

		public boolean getCodeSplicingSupported()
		{
			return codeSplicingSupported;
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

	/** Determines whether or not this configuration supports BSJ meta-annotations. */
	public boolean getMetaAnnotationsSupported()
	{
		return this.bsjVersion.getMetaAnnotationsSupported();
	}

	/** Determines whether or not this configuration supports BSJ code literals. */
	public boolean getCodeLiteralsSupported()
	{
		return this.bsjVersion.getCodeLiteralsSupported();
	}

	/** Determines whether or not this configuration supports BSJ code splicing. */
	public boolean getCodeSplicingSupported()
	{
		return this.bsjVersion.getCodeSplicingSupported();
	}
}
