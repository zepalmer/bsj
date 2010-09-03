package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AccessibleTypeModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Provides type namespace modification.
 * 
 * @author Zachary Palmer
 */
public class TypeNamespaceModifyingOperation extends
		AbstractNamespaceModifyingOperation<String, BsjTypeLikeElement, TypeNamespaceMap>
{
	/**
	 * Creates a type namespace modifier.
	 * 
	 * @param toolkit The typechecker toolkit to use to create elements.
	 * @param loader The compilation unit loader to use when loading of compilation units is necessary.
	 * @param listener The listener to which diagnostics will be reported.
	 */
	public TypeNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
			DiagnosticListener<BsjSourceLocation> listener)
	{
		super(toolkit, loader, listener);
	}

	/**
	 * Performs a default operation for nodes which do not affect the type namespace.
	 */
	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeDefault(Node node,
			TypeNamespaceMap map)
	{
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	/*
	 * Implementation notes:
	 * 
	 * 1. Nothing in the declaration of an enum or annotation affects the surrounding namespace (unlike classes, which
	 * have type parameters).
	 */

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeAnnotationBodyNode(
			AnnotationBodyNode node, TypeNamespaceMap map)
	{
		// *** Inherit elements from java.lang.annotation.Annotation
		AnnotationDeclarationNode declarationNode = (AnnotationDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeAnonymousClassBodyNode(
			AnonymousClassBodyNode node, TypeNamespaceMap map)
	{
		// *** Populate inherited members
		makeInheritedMapFor(node, map);

		// *** Create a new environment for declared members
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate declared members
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeClassBodyNode(
			ClassBodyNode node, TypeNamespaceMap map)
	{
		// *** Inherit member elements
		AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode = (AbstractlyUnmodifiedClassDeclarationNode<?>) node.getParent();
		makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeClassDeclarationNode(
			ClassDeclarationNode node, TypeNamespaceMap map)
	{
		// *** Create a new scope for type parameters
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(map, node.getTypeParameters());

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeCompilationUnitNode(
			CompilationUnitNode node, TypeNamespaceMap map)
	{
		// Only the type declarations contained in a compilation unit benefit from the declarations contained within
		// it; import statements, for instance, do not apply to other import statements.
		TypeNamespaceMap defaultNamespace = map; // used for everything other than the type declaration list

		// *** Create a new scope for the on-demand imports
		map = makeMap(map, EnvType.ON_DEMAND_IMPORT);

		// *** Process on-demand imports. This namespace has a lazy error policy, as ambiguities in on-demand
		// imports (such as "import java.util.*; import java.awt.*;" only matter if the ambiguous name is used
		// (such as in "List").
		populateOnDemandImports(map, node.getImports());

		// Automatic import of java.lang.* is treated as an on-demand import
		PackageNode javaLangPackage = node.getRootPackage().getSubpackageByQualifiedName("java.lang");
		getLoader().loadAll(javaLangPackage);
		populateNamespaceMapWithPackage(map, javaLangPackage, node, AccessModifier.PUBLIC);

		// *** Process on-demand static imports.
		populateOnDemandStaticImports(map, node.getImports());

		// *** Process top-level package peers. This namespace has an eager error policy as any duplication means
		// a name conflict in the local package.
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);
		populateNamespaceMapWithPackage(map, (PackageNode) node.getParent(),
				node.getPackageDeclaration() == null ? node : node.getPackageDeclaration(), AccessModifier.PACKAGE);

		// *** Process single-type imports. This namespace has a eager error policy, as ambiguities in single-type
		// imports cause the import statements to be useless in any context (such as
		// "import java.util.List; import java.awt.List;").
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);
		populateSingleTypeImports(map, node.getImports());

		// *** Process single-type static imports.
		populateSingleStaticImports(map, node.getImports());

		// *** Finished!
		Map<Node, TypeNamespaceMap> namespaceMap = Collections.<Node, TypeNamespaceMap> singletonMap(
				node.getTypeDecls(), map);
		return new MappedChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(defaultNamespace,
				namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeConstructorDeclarationNode(
			ConstructorDeclarationNode node, TypeNamespaceMap map)
	{
		// *** Create a new environment for type parameter population
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(map, node.getTypeParameters());

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeEnumBodyNode(EnumBodyNode node,
			TypeNamespaceMap map)
	{
		// *** Inherit member elements
		EnumDeclarationNode declarationNode = (EnumDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeInterfaceBodyNode(
			InterfaceBodyNode node, TypeNamespaceMap map)
	{
		// *** Inherit member elements
		InterfaceDeclarationNode declarationNode = (InterfaceDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeInterfaceDeclarationNode(
			InterfaceDeclarationNode node, TypeNamespaceMap map)
	{
		// *** Create a new scope for type parameters
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(map, node.getTypeParameters());

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeLocalClassDeclarationNode(
			LocalClassDeclarationNode node, TypeNamespaceMap map)
	{
		// *** Create a new environment to contain the declaration
		map = makeMap(map, EnvType.STATEMENT);

		// *** Populate the type itself into the namespace
		map.add(node.getIdentifier().getIdentifier(), this.getToolkit().makeElement(node), node);

		// *** Finished
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeMetaprogramNode(
			MetaprogramNode node, TypeNamespaceMap map)
	{
		// TODO: complete this section.
		/*
		 * Properly implementing this code would require the following:
		 * 
		 * 1. Metaprogram imports both from the compilation unit as well as the preamble would need to apply to the
		 * preamble's non-import section and the metaprogram body. Note that these imports would be coming from the
		 * *metaprogram's* classpath, not the object program's classpath.
		 * 
		 * 2. The metaprogram body needs to have a local variable be defined of type Context<T>. Note that, to be a
		 * correct implementation, the type of T must be properly filled out.
		 * 
		 * There is some question as to whether or not this method should ever be implemented; it probably wouldn't be
		 * necessary for a metaprogram to do this kind of analysis and the modeling of the imported types would get
		 * tedious at best. For now, we're just clearing out the environment to make clear the fact that none of the
		 * object program logic applies.
		 */
		map = new TypeNamespaceMap(Collections.<TypeNamespaceMap> emptySet(), getListener(), true, false);
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap> executeMethodDeclarationNode(
			MethodDeclarationNode node, TypeNamespaceMap map)
	{
		// *** Create a new environment for type parameter population
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(map, node.getTypeParameters());

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjTypeLikeElement, TypeNamespaceMap>(map);
	}

	// ***** UTILITY FUNCTIONS ************************************************

	protected TypeNamespaceMap makeMap(TypeNamespaceMap deferenceMap, EnvType envType)
	{
		return new TypeNamespaceMap(Collections.singleton(deferenceMap), this.getListener(), envType.isEager(),
				envType.isProhibitsOverlap());
	}

	/**
	 * Attempts to populate a member type into the provided type namespace map. This will succeed if and only if the
	 * type in question has an access modifier and that access modifier is less restrictive or equally restrictive to
	 * the level of access provided.
	 * 
	 * @param typeNamespaceMap The namespace into which to populate the type.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberType The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void tryPopulateMemberType(TypeNamespaceMap typeNamespaceMap, Node indicator,
			NamedTypeDeclarationNode<?> memberType, AccessModifier access, String name)
	{
		if (memberType.getModifiers() instanceof AccessibleTypeModifiersNode
				&& ((AccessibleTypeModifiersNode) memberType.getModifiers()).getAccess().compareTo(access) < 0
				&& (name == null || memberType.getIdentifier().getIdentifier().equals(name)))
		{
			typeNamespaceMap.add(memberType.getIdentifier().getIdentifier(),
					(BsjTypeElement) this.getToolkit().makeElement(memberType), indicator);
		}
	}

	/**
	 * Populates the specified type parameters into the current namespace.
	 * 
	 * @param typeNamespaceMap The namespace into which to populate the type parameters.
	 * @param typeParameters The type parameters to populate.
	 */
	private void populateTypeParameters(TypeNamespaceMap map, List<TypeParameterNode> typeParameters)
	{
		for (TypeParameterNode typeParameterNode : typeParameters)
		{
			map.add(typeParameterNode.getIdentifier().getIdentifier(),
					(BsjTypeLikeElement) this.getToolkit().makeElement(typeParameterNode), typeParameterNode);
		}
	}

	protected void populateOnDemandImports(TypeNamespaceMap typeNamespaceMap, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportOnDemandNode)
			{
				switch (importNode.getName().getCategory(getLoader()))
				{
					case PACKAGE:
						PackageNode packageNode = importNode.getRootPackage().getSubpackageByQualifiedName(
								importNode.getName());
						getLoader().loadAll(packageNode);
						populateNamespaceMapWithPackage(typeNamespaceMap, packageNode, importNode,
								AccessModifier.PUBLIC);
						break;
					case TYPE:
						NamedTypeDeclarationNode<?> type = this.getToolkit().getAccessibleTypeFromFullyQualifiedName(
								importNode.getName());
						if (type == null)
						{
							// TODO: emit an appropriate diagnostic - the type from which to import doesn't exist
							throw new NotImplementedYetException();
						} else
						{
							for (Node node : type.getBody().getMembers())
							{
								if (node instanceof NamedTypeDeclarationNode<?>)
								{
									tryPopulateMemberType(typeNamespaceMap, importNode,
											(NamedTypeDeclarationNode<?>) node, AccessModifier.PUBLIC, null);
								}
							}
						}
						break;
					default:
						// In this case, the name categorizer messed up
						throw new IllegalStateException(
								"Name categorizer gave non-package, non-type category to import name: "
										+ importNode.getName().getNameString() + " has category "
										+ importNode.getName().getCategory(getLoader()));
				}
			}
		}
	}

	private void populateSingleTypeImports(TypeNamespaceMap map, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportSingleTypeNode)
			{
				NamedTypeDeclarationNode<?> type = this.getToolkit().getAccessibleTypeFromFullyQualifiedName(
						importNode.getName());
				if (type == null)
				{
					// TODO: raise some kind of appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					map.add(type.getIdentifier().getIdentifier(), (BsjTypeElement) this.getToolkit().makeElement(type),
							importNode);
				}
			}
		}
	}

	/**
	 * Populates a type namespace map with a given package's top-level types.
	 * 
	 * @param map The map to populate.
	 * @param packageNode The package in question.
	 * @param indicator The indicator node to which each entry is to be attributed.
	 * @param access The level of access available.
	 */
	protected void populateNamespaceMapWithPackage(TypeNamespaceMap map, PackageNode packageNode, Node indicator,
			AccessModifier access)
	{
		Iterator<CompilationUnitNode> siblingIterator = packageNode.getCompilationUnitIterator();
		while (siblingIterator.hasNext())
		{
			CompilationUnitNode sibling = siblingIterator.next();
			for (TypeDeclarationNode typeDeclarationNode : sibling.getTypeDecls())
			{
				if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
				{
					NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
					ModifiersNode modifiersNode = namedTypeDeclarationNode.getModifiers();
					if (modifiersNode instanceof AccessibleTypeModifiersNode)
					{
						AccessibleTypeModifiersNode accessibleTypeModifiersNode = (AccessibleTypeModifiersNode) modifiersNode;
						if (accessibleTypeModifiersNode.getAccess().compareTo(access) <= 0)
						{
							// then this sibling is a publically accessible type and is available in the namespace
							// by default
							map.add(namedTypeDeclarationNode.getIdentifier().getIdentifier(),
									(BsjTypeElement) this.getToolkit().makeElement(namedTypeDeclarationNode), indicator);
						}
					}
				}
			}
		}
	}

	@Override
	public void populateElement(TypeNamespaceMap map, Node node, AccessModifier access, boolean skipNonMembers,
			String name)
	{
		if (node instanceof NamedTypeDeclarationNode<?>)
		{
			tryPopulateMemberType(map, node, (NamedTypeDeclarationNode<?>) node, access, name);
		}
	}

	@Override
	protected TypeNamespaceMap makeInheritanceMapFromSubmaps(Collection<TypeNamespaceMap> submaps)
	{
		return new TypeNamespaceMap(submaps, getListener(), EnvType.INHERITED.isEager(),
				EnvType.INHERITED.isProhibitsOverlap());
	}

	@Override
	public Iterable<? extends Class<? extends Node>> getPopulationTypes()
	{
		List<Class<? extends Node>> list = new ArrayList<Class<? extends Node>>();
		list.add(NamedTypeDeclarationNode.class);
		return list;
	}
}
