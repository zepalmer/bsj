package edu.jhu.cs.bsj.compiler.utils.generator;

public abstract class ModalPropertyDefinition<T extends ModalPropertyDefinition<T>> extends AbstractPropertyDefinition<T>
{

	public static enum Mode
	{
		/** A normal property. */
		NORMAL,
		/** A read-only property; no getter is generated. */
		READ_ONLY,
		/**
		 * A "skip-make" property. No getter is generated. A variant of each factory method appears without this
		 * property as a parameter.
		 */
		SKIP,
		/** A hidden property. No getter is generated. Factory methods never accept this as a parameter. */
		HIDE;
	}

	private Mode mode;

	public ModalPropertyDefinition(String name, String baseType, String typeArg, Mode mode, String description,
			String defaultExpression, boolean allowUnion)
	{
		super(name, baseType, typeArg, description, defaultExpression, allowUnion);
		this.mode = mode;
	}

	public boolean isSkipMake()
	{
		return this.mode == Mode.SKIP || this.mode == Mode.HIDE;
	}

	public boolean isReadOnly()
	{
		return this.mode != Mode.NORMAL;
	}

	public boolean isHide()
	{
		return this.mode == Mode.HIDE;
	}

	public Mode getMode()
	{
		return mode;
	}

	public String toString()
	{
		return "PropDef:" + getName() + ":" + getFullType();
	}
}