package edu.jhu.cs.bsj.compiler.impl.tool.compiler.names;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

/**
 * This tool is used to categorize names according to &#xA7;6.5 of the JLS v3. It is mostly separated from the
 * {@link NameNode} class itself solely for ease of editing as, at the time of this writing, adding complex members to
 * the AST node classes is tedious and uncomfortable due to the limited editing environment.
 * 
 * @author Zachary Palmer
 */
public class NameCategorizer
{
	/** A singleton for this object. */
	public static final NameCategorizer SINGLETON = new NameCategorizer();

	/** The logger for this object. */
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/**
	 * Categorizes the provided {@link NameNode}.
	 * 
	 * @param node The node to categorize.
	 * @return That node's category.
	 */
	public NameCategory categorize(NameNode name, CompilationUnitLoadingInfo info)
	{
		NameCategory category;

		category = InitialNameCategorizer.SINGLETON.categorize(name);
		if (category != null)
		{
			switch (category)
			{
				case PACKAGE_OR_TYPE:
					category = PackageOrTypeNameCategorizer.SINGLETON.categorize(name, info);
					break;
				case AMBIGUOUS:
					category = AmbiguousNameCategorizer.SINGLETON.categorize(name);
					break;
			}
		}

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("NameNode " + name.getNameString() + " categorized as " + category);
		}

		return category;
	}
}
