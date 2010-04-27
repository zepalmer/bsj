package edu.jhu.cs.bsj.compiler.utils.generator;

public class MessagePropertyExpressionDefinition
{
	/** The name of this expression. */
	private String name;
	/** The expression. */
	private String expression;

	public MessagePropertyExpressionDefinition(String name, String expression)
	{
		super();
		this.name = name;
		this.expression = expression;
	}

	public String getName()
	{
		return name;
	}

	public String getExpression()
	{
		return expression;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessagePropertyExpressionDefinition other = (MessagePropertyExpressionDefinition) obj;
		if (expression == null)
		{
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
