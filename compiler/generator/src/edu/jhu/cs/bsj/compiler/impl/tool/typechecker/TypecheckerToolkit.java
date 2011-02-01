package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.ElementBuildingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.PrimitiveTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuilder;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

public class TypecheckerToolkit
{
	private static Logger LOGGER = Logger.getLogger(TypecheckerToolkit.class);

	private TypecheckerManager manager;
	private CompilationUnitLoadingInfo loader;

	private ElementBuildingNodeOperation elementBuilder;
	private TypeBuilder typeBuilder;

	/** A field to hold the element for {@link Object java.lang.Object}. */
	private BsjDeclaredTypeElement objectElement;
	/** A field to hold the element for {@link String java.lang.String}. */
	private BsjDeclaredTypeElement stringElement;
	/** A field to hold the element for {@link Class java.lang.Class}. */
	private BsjDeclaredTypeElement classElement;
	/** A field to hold the element for {@link Enum java.lang.Enum}. */
	private BsjDeclaredTypeElement enumElement;
	/** A field to hold the element for {@link Annotation java.lang.annotation.Annotation}. */
	private BsjDeclaredTypeElement annotationElement;
	/** A field to hold the element for {@link Cloneable java.lang.Cloneable}. */
	private BsjDeclaredTypeElement cloneableElement;
	/** A field to hold the element for {@link Serializable java.io.Serializable}. */
	private BsjDeclaredTypeElement serializableElement;

	/** A field to hold the element for {@link Node edu.jhu.cs.bsj.compiler.ast.node.Node}. */
	private BsjDeclaredTypeElement nodeElement;

	/** A field to hold the element for the primitive <tt>byte</tt> type. */
	private BsjPrimitiveType byteType;
	/** A field to hold the element for the primitive <tt>short</tt> type. */
	private BsjPrimitiveType shortType;
	/** A field to hold the element for the primitive <tt>char</tt> type. */
	private BsjPrimitiveType charType;
	/** A field to hold the element for the primitive <tt>int</tt> type. */
	private BsjPrimitiveType intType;
	/** A field to hold the element for the primitive <tt>long</tt> type. */
	private BsjPrimitiveType longType;
	/** A field to hold the element for the primitive <tt>float</tt> type. */
	private BsjPrimitiveType floatType;
	/** A field to hold the element for the primitive <tt>double</tt> type. */
	private BsjPrimitiveType doubleType;
	/** A field to hold the element for the primitive <tt>boolean</tt> type. */
	private BsjPrimitiveType booleanType;

	/** A field to hold the element for the <tt>Byte</tt> wrapper type. */
	private BsjExplicitlyDeclaredType byteWrapperType;
	/** A field to hold the element for the <tt>Short</tt> wrapper type. */
	private BsjExplicitlyDeclaredType shortWrapperType;
	/** A field to hold the element for the <tt>Character</tt> wrapper type. */
	private BsjExplicitlyDeclaredType characterWrapperType;
	/** A field to hold the element for the <tt>Integer</tt> wrapper type. */
	private BsjExplicitlyDeclaredType integerWrapperType;
	/** A field to hold the element for the <tt>Long</tt> wrapper type. */
	private BsjExplicitlyDeclaredType longWrapperType;
	/** A field to hold the element for the <tt>Float</tt> wrapper type. */
	private BsjExplicitlyDeclaredType floatWrapperType;
	/** A field to hold the element for the <tt>Double</tt> wrapper type. */
	private BsjExplicitlyDeclaredType doubleWrapperType;
	/** A field to hold the element for the <tt>Boolean</tt> wrapper type. */
	private BsjExplicitlyDeclaredType booleanWrapperType;

	/** A field to hold the element for the <tt>Void</tt> wrapper type. */
	private BsjExplicitlyDeclaredType voidWrapperType;

	public TypecheckerToolkit(TypecheckerManager manager, CompilationUnitLoadingInfo loader)
	{
		super();
		this.manager = manager;
		// TODO: what does it mean if we need to load compilation units during type-checking? what if they contain
		// metaprograms?
		this.loader = loader;
		this.elementBuilder = new ElementBuildingNodeOperation(getManager());
		this.typeBuilder = new TypeBuilder(getManager());
	}

	protected TypecheckerManager getManager()
	{
		return this.manager;
	}

	public TypeBuilder getTypeBuilder()
	{
		return typeBuilder;
	}

	public BsjDeclaredTypeElement getObjectElement()
	{
		if (this.objectElement == null)
		{
			this.objectElement = getTypeElementByName("java", "lang", "Object");
		}
		return objectElement;
	}

	public BsjDeclaredTypeElement getStringElement()
	{
		if (this.stringElement == null)
		{
			this.stringElement = getTypeElementByName("java", "lang", "String");
		}
		return this.stringElement;
	}

	public BsjDeclaredTypeElement getClassElement()
	{
		if (this.classElement == null)
		{
			this.classElement = getTypeElementByName("java", "lang", "Class");
		}
		return this.classElement;
	}

	public BsjDeclaredTypeElement getEnumElement()
	{
		if (this.enumElement == null)
		{
			this.enumElement = getTypeElementByName("java", "lang", "Enum");
		}
		return this.enumElement;
	}

	public BsjDeclaredTypeElement getAnnotationElement()
	{
		if (this.annotationElement == null)
		{
			this.annotationElement = getTypeElementByName("java", "lang", "annotation", "Annotation");
		}
		return this.annotationElement;
	}

	public BsjDeclaredTypeElement getCloneableElement()
	{
		if (this.cloneableElement == null)
		{
			this.cloneableElement = getTypeElementByName("java", "lang", "Cloneable");
		}
		return this.cloneableElement;
	}

	public BsjDeclaredTypeElement getSerializableElement()
	{
		if (this.serializableElement == null)
		{
			this.serializableElement = getTypeElementByName("java", "lang", "Serializable");
		}
		return this.serializableElement;
	}

	public BsjDeclaredTypeElement getNodeElement()
	{
		if (this.nodeElement == null)
		{
			this.nodeElement = getTypeElementByName("edu", "jhu", "cs", "bsj", "compiler", "ast", "node", "Node");
		}
		return this.nodeElement;
	}

	public BsjPrimitiveType getByteType()
	{
		if (this.byteType == null)
		{
			this.byteType = new PrimitiveTypeImpl(getManager(), PrimitiveType.BYTE);
		}
		return this.byteType;
	}

	public BsjPrimitiveType getShortType()
	{
		if (this.shortType == null)
		{
			this.shortType = new PrimitiveTypeImpl(getManager(), PrimitiveType.SHORT);
		}
		return this.shortType;
	}

	public BsjPrimitiveType getCharType()
	{
		if (this.charType == null)
		{
			this.charType = new PrimitiveTypeImpl(getManager(), PrimitiveType.CHAR);
		}
		return this.charType;
	}

	public BsjPrimitiveType getIntType()
	{
		if (this.intType == null)
		{
			this.intType = new PrimitiveTypeImpl(getManager(), PrimitiveType.INT);
		}
		return this.intType;
	}

	public BsjPrimitiveType getLongType()
	{
		if (this.longType == null)
		{
			this.longType = new PrimitiveTypeImpl(getManager(), PrimitiveType.LONG);
		}
		return this.longType;
	}

	public BsjPrimitiveType getFloatType()
	{
		if (this.floatType == null)
		{
			this.floatType = new PrimitiveTypeImpl(getManager(), PrimitiveType.FLOAT);
		}
		return this.floatType;
	}

	public BsjPrimitiveType getDoubleType()
	{
		if (this.doubleType == null)
		{
			this.doubleType = new PrimitiveTypeImpl(getManager(), PrimitiveType.DOUBLE);
		}
		return this.doubleType;
	}

	public BsjPrimitiveType getBooleanType()
	{
		if (this.booleanType == null)
		{
			this.booleanType = new PrimitiveTypeImpl(getManager(), PrimitiveType.BOOLEAN);
		}
		return this.booleanType;
	}

	public BsjExplicitlyDeclaredType getByteWrapperType()
	{
		if (this.byteWrapperType == null)
		{
			this.byteWrapperType = getTypeElementByName("java", "lang", "Byte").asType();
		}
		return this.byteWrapperType;
	}

	public BsjExplicitlyDeclaredType getShortWrapperType()
	{
		if (this.shortWrapperType == null)
		{
			this.shortWrapperType = getTypeElementByName("java", "lang", "Short").asType();
		}
		return this.shortWrapperType;
	}

	public BsjExplicitlyDeclaredType getCharacterWrapperType()
	{
		if (this.characterWrapperType == null)
		{
			this.characterWrapperType = getTypeElementByName("java", "lang", "Character").asType();
		}
		return this.characterWrapperType;
	}

	public BsjExplicitlyDeclaredType getIntegerWrapperType()
	{
		if (this.integerWrapperType == null)
		{
			this.integerWrapperType = getTypeElementByName("java", "lang", "Integer").asType();
		}
		return this.integerWrapperType;
	}

	public BsjExplicitlyDeclaredType getLongWrapperType()
	{
		if (this.longWrapperType == null)
		{
			this.longWrapperType = getTypeElementByName("java", "lang", "Long").asType();
		}
		return this.longWrapperType;
	}

	public BsjExplicitlyDeclaredType getFloatWrapperType()
	{
		if (this.floatWrapperType == null)
		{
			this.floatWrapperType = getTypeElementByName("java", "lang", "Float").asType();
		}
		return this.floatWrapperType;
	}

	public BsjExplicitlyDeclaredType getDoubleWrapperType()
	{
		if (this.doubleWrapperType == null)
		{
			this.doubleWrapperType = getTypeElementByName("java", "lang", "Double").asType();
		}
		return this.doubleWrapperType;
	}

	public BsjExplicitlyDeclaredType getBooleanWrapperType()
	{
		if (this.booleanWrapperType == null)
		{
			this.booleanWrapperType = getTypeElementByName("java", "lang", "Boolean").asType();
		}
		return this.booleanWrapperType;
	}

	public BsjExplicitlyDeclaredType getVoidWrapperType()
	{
		if (this.voidWrapperType == null)
		{
			this.voidWrapperType = getTypeElementByName("java", "lang", "Void").asType();
		}
		return this.voidWrapperType;
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
	 * @return An element for that top-level type or <code>null</code> if that top level type does not exist.
	 */
	public BsjDeclaredTypeElement getTypeElementByName(String... name)
	{
		NamedTypeDeclarationNode<?> declaration = findTopLevelTypeDeclarationByName(name);
		if (declaration == null)
		{
			return null;
		} else
		{
			return makeElement(declaration);
		}
	}

	/**
	 * Finds a top-level type declaration by name.
	 * 
	 * @param name The components of the name. All but the last are assumed to be package names.
	 * @return The resulting type or <code>null</code> if no such type exists.
	 */
	public NamedTypeDeclarationNode<?> findTopLevelTypeDeclarationByName(String... name)
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
	public BsjTypeLikeElement getAccessibleTypeFromName(NameNode name, NamespaceMap<String,BsjTypeLikeElement> typeNamespaceMap)
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
					NamespaceMap<String,BsjTypeLikeElement> nextNamespace;
					if (element.getDeclarationNode() instanceof NamedTypeDeclarationNode<?>)
					{
						NamedTypeDeclarationNode<?> typeDeclarationNode = (NamedTypeDeclarationNode<?>) element.getDeclarationNode();
						nextNamespace = this.getManager().getNamespaceBuilder().getTypeNamespace(
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
	    final NameNode originalName = name;
	    
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
			throw new NotImplementedYetException("The type " + originalName.getNameString() + " could not be resolved; this case is not yet handled.");
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
