package edu.jhu.cs.bsj.compiler.impl.tool.compiler.names;

import java.util.Collection;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

/**
 * This visitor categorizes <i>PackageOrTypeName</i>s as specified by &#xA7;6.5.3 of the JLS v3. To do so, it must have
 * access to a {@link BsjTypeManager} to ask questions about types. After the execution of this visitor, no
 * {@link NameNode} in the visited tree has a name category of {@link NameCategory#PACKAGE_OR_TYPE}.
 * 
 * @author Zachary Palmer
 */
public class PackageOrTypeNameCategorizer
{
	/** A singleton for this object. */
	public static final PackageOrTypeNameCategorizer SINGLETON = new PackageOrTypeNameCategorizer();

	/** The logger for this object. */
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/**
	 * This method categorizes names which fall into {@link NameCategory#PACKAGE_OR_TYPE} according to the rules of
	 * &#xA7;6.5.1.
	 * 
	 * @param name The name to categorize.
	 * @param info The {@link CompilationUnitLoadingInfo} to use if loading becomes necessary.
	 * @return An indication of whether the name is a package name or a type name.
	 */
	public NameCategory categorize(NameNode name, CompilationUnitLoadingInfo info)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Deciding package or type for " + name.getNameString() + " at " + name.getStartLocation());
		}

		NameCategory category;
		if (name instanceof SimpleNameNode)
		{
			// If a type is in scope which has the same name as this node, the node refers to a type. Otherwise, this
			// node refers to a package.
			Collection<? extends TypeNameBindingNode> declarations = name.getParent().getTypeDeclarationsInScope(name.getIdentifier().getIdentifier());
			if (declarations.size() == 0)
			{
				category = NameCategory.PACKAGE;
			} else
			{
				category = NameCategory.TYPE;
			}
		} else if (name instanceof QualifiedNameNode)
		{
			// If the base name of this node refers to a package or type containing a member type matching the name of
			// this node's identifier, then this node refers to a type. Otherwise, it refers to a package.
			QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) name;
			if (qualifiedNameNode.getBase().getCategory(info) == NameCategory.PACKAGE)
			{
				category = NameCategory.PACKAGE;
				PackageNode rootPackage = name.getRootPackage();
				if (rootPackage != null)
				{
					PackageNode packageNode = rootPackage.getSubpackage(qualifiedNameNode.getBase());
					if (packageNode != null)
					{
						if (packageNode.getTopLevelTypeDeclaration(name.getIdentifier().getIdentifier(), info) != null)
						{
							category = NameCategory.TYPE;
						}
					}
				}
			} else if (qualifiedNameNode.getBase().getCategory(info) == NameCategory.TYPE)
			{
				// If the qualified name is classified as a type, then this name either refers to an existing member
				// type of that type or it does not make sense. In light of this, we can just assume that it should
				// always be classified as a type. (The JLSv3 in §6.5.4.2 technically indicates that, if the member
				// type does not exist, this classification should produce PACKAGE as the name category. This will
				// inevitably produce an error later on anyway, so the particular category chosen does not matter.)
				category = NameCategory.TYPE;
			} else
			{
				throw new IllegalStateException(
						"Typing to disambiguate PACKAGE_OR_TYPE category for name with base of "
								+ name.getCategory(info));
			}
		} else
		{
			throw new IllegalStateException("Unrecognized node type: " + name.getClass().getName());
		}

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Categorized name " + name.getNameString() + " at " + name.getStartLocation() + " as "
					+ category);
		}
		return category;
	}
}
