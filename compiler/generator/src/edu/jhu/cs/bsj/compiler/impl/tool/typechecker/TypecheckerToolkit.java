package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.ElementBuildingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuilder;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

// TODO: consider renaming to, for example, EnvironmentToolkit
public class TypecheckerToolkit
{
	private TypecheckerModelManager manager;
	private CompilationUnitLoader loader;

	private ElementBuildingNodeOperation elementBuilder;
	private TypeBuilder typeBuilder;

	private Logger LOGGER = Logger.getLogger(TypecheckerToolkit.class);

	public TypecheckerToolkit(TypecheckerModelManager manager, CompilationUnitLoader loader)
	{
		super();
		this.manager = manager;
		// TODO: what does it mean if we need to load compilation units during type-checking? what if they contain
		// metaprograms?
		this.loader = loader;
		this.elementBuilder = new ElementBuildingNodeOperation(getManager());
		this.typeBuilder = new TypeBuilder(getManager());
	}

	protected TypecheckerModelManager getManager()
	{
		return this.manager;
	}

	public TypeBuilder getTypeBuilder()
	{
		return typeBuilder;
	}

	/**
	 * Creates an appropriate {@link Element} for the provided node (if possible).
	 * 
	 * @param node The node for which to create an element.
	 * @return The resulting element.
	 */
	public BsjElement makeElement(Node node)
	{
		return node.executeOperation(this.elementBuilder, null);
	}

	/**
	 * Creates an appropriate {@link Element} for the provided node (if possible).
	 * 
	 * @param node The node for which to create an element.
	 * @return The resulting element.
	 */
	public BsjDeclaredTypeElement makeElement(NamedTypeDeclarationNode<?> node)
	{
		return (BsjDeclaredTypeElement) node.executeOperation(this.elementBuilder, null);
	}

	/**
	 * Retrieves an element for the top-level type named by the provided name components. All but the last are assumed
	 * to represent package names.
	 * 
	 * @param name The name of the top-level type to obtain.
	 * @return An element for that top-level type.
	 */
	public BsjTypeElement getTypeElementByName(String... name)
	{
		return (BsjTypeElement) makeElement(findTopLevelTypeByName(name));
	}

	/**
	 * Finds a top-level type declaration by name.
	 * 
	 * @param name The components of the name. All but the last are assumed to be package names.
	 * @return The resulting type.
	 */
	public NamedTypeDeclarationNode<?> findTopLevelTypeByName(String... name)
	{
		if (name.length == 0)
		{
			throw new IllegalArgumentException("Cannot handle empty name");
		}
		PackageNode packageNode = getManager().getRootPackage();
		for (int i = 0; i < name.length - 1; i++)
		{
			packageNode = packageNode.getSubpackage(name[i]);
		}
		return packageNode.getTopLevelTypeDeclaration(name[name.length - 1], loader);
	}

	/**
	 * Given a type or package name, this method breaks the name into two pieces: a sequence of strings representing the
	 * type portion of the name (which are added to the provided list) and a node representing the package name's root
	 * (which is returned). The components are added to the list in reverse order; that is, if the name is
	 * <tt>com.example.Foo.Bar</tt> (using standard naming conventions) and an empty list is provided, the list will
	 * contain <tt>["Bar","Foo"]</tt> upon the termination of this call.
	 * 
	 * @param name The type or package name.
	 * @param typeNames The list to which to add the type name components.
	 * @return The package name, or <code>null</code> if no part of the name indicated a package.
	 */
	private NameNode extractTypePortionOfName(NameNode name, List<NameNode> typeNames)
	{
		while (name != null && name.getCategory(loader) != NameCategory.PACKAGE)
		{
			if (name.getCategory(loader) != NameCategory.TYPE)
			{
				throw new IllegalStateException("Name categorizer gave non-package, non-type category to type name: "
						+ name.getNameString() + " has category " + name.getCategory(loader));
			}
			typeNames.add(name);
			if (name instanceof SimpleNameNode)
			{
				name = null;
			} else
			{
				name = ((QualifiedNameNode) name).getBase();
			}
		}
		return name;
	}

	/**
	 * Obtains a named type-like element from the specified name. If the name is fully-qualified, it is obtained by
	 * advancing from the root package. If the name is not fully qualified, the declaration is obtained by reading from
	 * the provided type namespace. As a result, the provided type namespace must be populated at least as far as is
	 * necessary to resolve the provided name.
	 * 
	 * @param name The name in question.
	 * @param typeNamespaceMap The namespace map from which to obtain types.
	 * @return The resulting type-like element or <code>null</code> if no such element could be found.
	 */
	public BsjTypeLikeElement getAccessibleTypeFromName(NameNode name, TypeNamespaceMap typeNamespaceMap)
	{
		List<NameNode> typeNames = new ArrayList<NameNode>();
		NameNode packageName = extractTypePortionOfName(name, typeNames);

		if (packageName == null)
		{
			// ...then the name was referring to either (1) a top level type or (2) a type which is in the symbol table.
			// Let's see if the last name component (which represents the first identifier) is in the symbol table.
			Collections.reverse(typeNames);
			if (typeNamespaceMap.contains(typeNames.get(0).getIdentifier().getIdentifier()))
			{
				// Then we've found the first component of the name in our symbol table. No turning back now; we expect
				// to find the type element there.
				BsjTypeLikeElement element = typeNamespaceMap.lookup(name.getIdentifier().getIdentifier(),
						typeNames.get(0).getStartLocation());
				Iterator<NameNode> it = typeNames.iterator();
				it.next();
				// If the name has multiple components, keep iterating until we get to the last one or until we fail
				// due to a missing type definition.
				while (it.hasNext())
				{
					NameNode nextName = it.next();
					TypeNamespaceMap nextNamespace;
					if (element.getDeclarationNode() instanceof NamedTypeDeclarationNode<?>)
					{
						NamedTypeDeclarationNode<?> typeDeclarationNode = (NamedTypeDeclarationNode<?>) element.getDeclarationNode();
						nextNamespace = this.getManager().getEnvironmentManager().getTypeNamespace(
								typeDeclarationNode.getBody().getMembers());
						element = nextNamespace.lookup(nextName.getIdentifier().getIdentifier(),
								nextName.getStartLocation());
						if (element == null)
						{
							// Then this qualification failed.
							// TODO: Report an appropriate diagnostic using this name node
							throw new NotImplementedYetException();
						}
					} else
					{
						// It isn't legal to qualify a type parameter.
						// TODO: report an appropriate diagnostic and return null
						throw new NotImplementedYetException();
					}
				}
				return element;
			} else
			{
				// It looks like we can't find that type. We'll treat it like a fully-qualified name and hope that
				// the caller intended a type in the root package.
				return makeElement(getAccessibleTypeFromFullyQualifiedName(name));
			}
		} else
		{
			// The name includes a package; this means that it is fully qualified.
			return makeElement(getAccessibleTypeFromFullyQualifiedName(name));
		}
	}

	/**
	 * Obtains a named type declaration from the specified canonical name. The type declaration must be accessible from
	 * the name in question. For instance, if the type declaration has private access, the name must be in a subtree of
	 * the enclosing type inside of which the named type is declared.
	 * 
	 * @param name The name of the type declaration to locate.
	 * @return The resulting type declaration, or <code>null</code> if no such accessible type declaration exists.
	 */
	public NamedTypeDeclarationNode<?> getAccessibleTypeFromFullyQualifiedName(NameNode name)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Attempting to load accessible type " + name.getNameString());
		}

		// Get the name of the package.
		List<NameNode> typeNames = new ArrayList<NameNode>();
		name = extractTypePortionOfName(name, typeNames);

		if (typeNames.size() == 0)
		{
			// We were provided with a package name, not a type name
			// TODO: raise an appropriate diagnostic
			throw new NotImplementedYetException();
		}

		// Ascertain the package in which the imported type lives
		PackageNode packageNode = this.manager.getRootPackage();
		if (name != null)
		{
			packageNode = packageNode.getSubpackageByQualifiedName(name);
		}

		// Obtain the type from the package
		NamedTypeDeclarationNode<?> type = packageNode.getTopLevelTypeDeclaration(
				typeNames.get(0).getIdentifier().getIdentifier(), loader);
		if (type == null)
		{
			// The type does not exist
			// TODO: raise an appropriate diagnostic
			throw new NotImplementedYetException();
		}
		for (int index = 1; index < typeNames.size(); index++)
		{
			type = type.getTypeDeclaration(typeNames.get(index).getIdentifier().getIdentifier());
			if (type == null)
			{
				// The type does not exist
				// TODO: raise an appropriate diagnostic
				throw new NotImplementedYetException();
			}
		}

		// TODO: verify that the requested type is accessible from the provided NameNode

		return type;
	}
}
