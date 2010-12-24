package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleStaticImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.StaticImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap.OverlapMode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.FilterByNodeTypes;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Applies the environment changes that a parent environment node has on its environment child. This operation operates
 * on the parent node. Its two arguments are the namespace provided to the parent and the child node for which a
 * namespace should be constructed. The returned value is that child node's namespace.  The actual node operation
 * methods on this class are left unimplemented with the expectation that subclasses will perform namespace-type-specific
 * modifications as necessary.
 * <p/>
 * Note that here, the terms "parent" and "child" refer to the environment effect relationship and not necessarily to an
 * AST connectivity relationship. A compilation unit is the environment parent of a top-level type declaration, but the
 * environment parent of a block statement is usually the block statement which appeared immediately before it.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractNamespaceModifyingOperation<K, V extends BsjElement, T extends NamespaceMap<K, V>>
		extends BsjDefaultNodeOperation<T, ChildNamespaceProducer<K, V, T>>
{
	private static Logger LOGGER = Logger.getLogger(AbstractNamespaceModifyingOperation.class);

	/** The typechecker toolkit to use. */
	private TypecheckerToolkit toolkit;
	/** The compilation unit loader to use. */
	private CompilationUnitLoader loader;
	/** The diagnostic listener to use. */
	private DiagnosticListener<BsjSourceLocation> listener;

	public AbstractNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
			DiagnosticListener<BsjSourceLocation> listener)
	{
		super();
		this.toolkit = toolkit;
		this.loader = loader;
		this.listener = listener;
	}

	protected TypecheckerToolkit getToolkit()
	{
		return toolkit;
	}

	protected CompilationUnitLoader getLoader()
	{
		return loader;
	}

	protected DiagnosticListener<BsjSourceLocation> getListener()
	{
		return listener;
	}

	protected void populateOnDemandStaticImports(T map, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof StaticImportOnDemandNode)
			{
				if (importNode.getName().getCategory(loader) != NameCategory.TYPE)
				{
					// On-demand static imports can only name types.
					// TODO: report an appropriate diagnostic
					throw new NotImplementedYetException();
				}

				// For each member of the type, import it if possible
				NamedTypeDeclarationNode<?> type = this.toolkit.getAccessibleTypeFromFullyQualifiedName(importNode.getName());
				if (type == null)
				{
					// TODO: emit an appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					populateElements(map, type.getBody().getMembers(), AccessModifier.PUBLIC);
				}
			}
		}
	}

	protected void populateSingleStaticImports(T map, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof SingleStaticImportNode)
			{
				if (importNode.getName().getCategory(loader) != NameCategory.TYPE)
				{
					// On-demand static imports can only name types.
					// TODO: report an appropriate diagnostic
					throw new NotImplementedYetException();
				}

				// Find all members of the type which have the specified name.
				NamedTypeDeclarationNode<?> type = this.toolkit.getAccessibleTypeFromFullyQualifiedName(importNode.getName());
				SingleStaticImportNode singleStaticImportNode = (SingleStaticImportNode) importNode;
				if (type == null)
				{
					// TODO: emit an appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					populateElements(map, type.getBody().getMembers(), AccessModifier.PUBLIC, false,
							singleStaticImportNode.getIdentifier().getIdentifier());
				}
			}
		}
	}

	protected abstract T makeInheritanceMapFromSubmaps(Collection<T> submaps);

	/**
	 * Populates an environment with the members inherited by the given type. This method populates a scope for
	 * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
	 * members or other elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method
	 * and <tt>Foo</tt> extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods. This
	 * method will also inherit the members of the specified type; as a result, this should not be used directly by the
	 * operation methods.
	 * 
	 * @param declarationNode The declaration to use.
	 * @param env The environment to use.
	 * @return The resulting environment.
	 */
	protected T makeInheritedMapWithDynamicDispatchFor(NamedTypeDeclarationNode<?> declarationNode, T map)
	{
		// First, dispatch to the node's parents.
		map = declarationNode.executeOperation(new BsjDefaultNodeOperation<T, T>()
		{
			@Override
			public T executeDefault(Node node, T map)
			{
				throw new IllegalStateException("Don't know how to handle inherited type from node type "
						+ node.getClass());
			}

			@Override
			public T executeAnnotationDeclarationNode(AnnotationDeclarationNode node, T map)
			{
				return makeInheritedMapFor(node, map);
			}

			@Override
			public T executeClassDeclarationNode(ClassDeclarationNode node, T map)
			{
				return makeInheritedMapFor(node, map);
			}

			@Override
			public T executeEnumDeclarationNode(EnumDeclarationNode node, T map)
			{
				return makeInheritedMapFor(node, map);
			}

			@Override
			public T executeInterfaceDeclarationNode(InterfaceDeclarationNode node, T map)
			{
				return makeInheritedMapFor(node, map);
			}
		}, map);

		// Next, populate this node's members.
		// TODO: PROTECTED or PACKAGE?
		populateElements(map, declarationNode.getBody().getMembers(), AccessModifier.PROTECTED, true, null);
		
		// Return the resulting map
		return map;
	}

	/**
	 * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
	 * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
	 * elements of the provided type. For instance, if the anonymous class is an implicit subtype of the <tt>Foo</tt>
	 * class, the members of <tt>Foo</tt> will be populated.
	 * 
	 * @param declarationNode The type for which the inherited map is desired.
	 * @param env The map to use as a base.
	 * @return The resulting map.
	 */
	protected T makeInheritedMapFor(AnonymousClassBodyNode declarationNode, T map)
	{
		if (declarationNode.getParent() instanceof ClassInstantiationNode)
		{
			if (declarationNode.getParent() instanceof QualifiedClassInstantiationNode)
			{
				// TODO: this relies on our ability to establish the type of the qualifying expression!
				throw new NotImplementedYetException();
			} else if (declarationNode.getParent() instanceof UnqualifiedClassInstantiationNode)
			{
				UnqualifiedClassInstantiationNode instantiationNode = (UnqualifiedClassInstantiationNode) declarationNode.getParent();
				BsjExplicitlyDeclaredType type = getExplicitlyDeclaredTypeFromNode(instantiationNode.getType());
				if (type != null)
				{
					return makeInheritedMapFromSupertypes(map,
							Collections.singleton(((BsjExplicitlyDeclaredType) type).asElement()));
				} else
				{
					// This indicates that the programmer tried to anonymously extend a type parameter.
					// TODO: raise an appropriate diagnostic
					throw new NotImplementedYetException();
				}
			} else
			{
				throw new IllegalStateException("Don't know how to handle class instantiation node of type "
						+ declarationNode.getParent().getClass());
			}
		} else if (declarationNode.getParent() instanceof EnumConstantDeclarationNode)
		{
			EnumDeclarationNode enumDeclarationNode = declarationNode.getNearestAncestorOfType(EnumDeclarationNode.class);
			BsjDeclaredTypeElement typeElement = getToolkit().makeElement(enumDeclarationNode);
			return makeInheritedMapFromSupertypes(map, Collections.singleton(typeElement));
		} else
		{
			throw new IllegalStateException("Don't know how to handle anonymous class body parent of type "
					+ declarationNode.getParent().getClass());
		}
	}

	/**
	 * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
	 * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
	 * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
	 * extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods.
	 * 
	 * @param declarationNode The type for which the inherited map is desired.
	 * @param map The map to populate.
	 * @return The resulting map.
	 */
	protected T makeInheritedMapFor(AnnotationDeclarationNode declarationNode, T map)
	{
		BsjDeclaredTypeElement annotationElement = toolkit.getAnnotationElement();
		return makeInheritedMapFromSupertypes(map, Collections.singleton(annotationElement));
	}

	/**
	 * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
	 * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
	 * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
	 * extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods but no <tt>Foo</tt>
	 * methods.
	 * 
	 * @param declarationNode The type for which the inherited map is desired.
	 * @param map The map to use as a base.
	 * @return The resulting map.
	 */
	protected T makeInheritedMapFor(AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode, T map)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Populating inherited members for " + declarationNode.getFullyQualifiedName());
		}

		BsjDeclaredTypeElement objectElement = toolkit.getObjectElement();
		if (objectElement.equals(toolkit.makeElement(declarationNode)))
		{
			// Then we're already done; Object inherits nothing.
			return makeMap(map, EnvType.INHERITED);
		}

		Set<BsjDeclaredTypeElement> supertypes = new HashSet<BsjDeclaredTypeElement>();

		// include the superclass
		if (declarationNode.getExtendsClause() != null)
		{
			BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declarationNode.getExtendsClause());
			if (explicitlyDeclaredType == null)
			{
				// TODO: report an appropriate diagnostic
				throw new NotImplementedYetException();
			} else
			{
				supertypes.add(explicitlyDeclaredType.asElement());
			}
		}

		// include the superinterfaces
		for (DeclaredTypeNode declaredTypeNode : declarationNode.getImplementsClause())
		{
			BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declaredTypeNode);
			if (explicitlyDeclaredType == null)
			{
				// TODO: report an appropriate diagnostic
				throw new NotImplementedYetException();
			} else
			{
				supertypes.add(explicitlyDeclaredType.asElement());
			}
		}

		return makeInheritedMapFromSupertypes(map, supertypes);
	}

	/**
	 * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
	 * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
	 * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
	 * implements <tt>Bar</tt>, the returned environment will contain all <tt>Bar</tt> methods.
	 * 
	 * @param declarationNode The type for which the inherited map is desired.
	 * @param env The base map.
	 * @return The resulting map.
	 */
	protected T makeInheritedMapFor(EnumDeclarationNode declarationNode, T map)
	{
		BsjDeclaredTypeElement enumElement = toolkit.getEnumElement();

		Set<BsjDeclaredTypeElement> supertypes = new HashSet<BsjDeclaredTypeElement>();
		supertypes.add(enumElement);

		if (declarationNode.getImplementsClause().size() > 0)
		{
			// then inherit from each superinterface
			for (DeclaredTypeNode declaredTypeNode : declarationNode.getImplementsClause())
			{
				BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declaredTypeNode);
				if (explicitlyDeclaredType == null)
				{
					// TODO: report an appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					supertypes.add(explicitlyDeclaredType.asElement());
				}
			}
		}

		return makeInheritedMapFromSupertypes(map, supertypes);
	}

	/**
	 * Creates a map with the members inherited by the given type. This method populates a scope for inherited members
	 * by recursively inheriting the parent members of this type. Note that it does not populate the members or other
	 * elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method and <tt>Foo</tt>
	 * extends <tt>Bar</tt>, the returned environment will contain all <tt>Bar</tt> methods but none of the <tt>Foo</tt>
	 * methods.
	 * 
	 * @param declarationNode The type for which the inherited map is desired.
	 * @param map The base map.
	 * @return The resulting map.
	 */
	protected T makeInheritedMapFor(InterfaceDeclarationNode declarationNode, T map)
	{
		Set<BsjDeclaredTypeElement> supertypes = new HashSet<BsjDeclaredTypeElement>();

		if (declarationNode.getExtendsClause().size() > 0)
		{
			// then inherit from each superinterface
			for (DeclaredTypeNode declaredTypeNode : declarationNode.getExtendsClause())
			{
				BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(declaredTypeNode);
				if (explicitlyDeclaredType == null)
				{
					// TODO: report an appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					supertypes.add(explicitlyDeclaredType.asElement());
				}
			}
		}

		return makeInheritedMapFromSupertypes(map, supertypes);
	}

	private T makeInheritedMapFromSupertypes(T map, Set<BsjDeclaredTypeElement> supertypes)
	{
		// ensure that there is at least one supertype
		if (supertypes.size() == 0)
		{
			BsjDeclaredTypeElement objectElement = (BsjDeclaredTypeElement) toolkit.getObjectElement();
			supertypes.add(objectElement);
		}

		// create an inherited map for each of these types
		List<T> inheritedMaps = new ArrayList<T>(supertypes.size());
		for (BsjDeclaredTypeElement element : supertypes)
		{
			inheritedMaps.add(makeInheritedMapWithDynamicDispatchFor(element.getDeclarationNode(), map));
		}

		// create a map representing those inheritance maps
		return makeInheritanceMapFromSubmaps(inheritedMaps);
	}

	/**
	 * Converts a {@link DeclaredTypeNode} into a {@link BsjExplicitlyDeclaredType} if possible. This will not be
	 * possible if the {@link DeclaredTypeNode} actually refers to a type parameter. If this is the case,
	 * <code>null</code> is returned instead.
	 * 
	 * @param node The node to convert.
	 * @return The resulting type or <code>null</code> if the node indicates a type parameter.
	 */
	private BsjExplicitlyDeclaredType getExplicitlyDeclaredTypeFromNode(DeclaredTypeNode node)
	{
		BsjNamedReferenceType referenceType = this.toolkit.getTypeBuilder().makeDeclaredType(node);
		if (referenceType instanceof BsjExplicitlyDeclaredType)
		{
			return (BsjExplicitlyDeclaredType) referenceType;
		} else
		{
			return null;
		}
	}

	/**
	 * Populates a map with the members in a given list. Members which are not applicable to the map are ignored.
	 * 
	 * @param map The map into which to populate.
	 * @param nodes The nodes to use.
	 * @param access The maximum level of access restriction to populate.
	 */
	public void populateElements(T map, ListNode<?> nodes, AccessModifier access)
	{
		populateElements(map, nodes, access, false, null);
	}

	/**
	 * Populates a map with the members in a given list. Members which are not applicable to the map are ignored.
	 * 
	 * @param map The map into which to populate.
	 * @param nodes The nodes to use.
	 * @param access The maximum level of access restriction to populate.
	 * @param skipNonMembers <code>true</code> if non-members (such as constructors) should be skipped.
	 * @param name The name the member must have, or <code>null</code> to skip this check.
	 */
	public <E extends Node> void populateElements(T map, ListNode<E> nodes, AccessModifier access, boolean skipNonMembers,
			String name)
	{
		List<Class<? extends E>> types = new ArrayList<Class<? extends E>>();
		for (Class<? extends Node> clazz : getPopulationTypes())
		{
			if (nodes.getElementType().isAssignableFrom(clazz))
			{
				types.add(clazz.asSubclass(nodes.getElementType()));
			}
		}
		for (Node node : nodes.filter(new FilterByNodeTypes<E, E>(types)))
		{
			populateElement(map, node, access, skipNonMembers, name);
		}
	}

	/**
	 * Populates a single element into the map if appropriate and possible.
	 * 
	 * @param map The map into which to populate.
	 * @param node The node to use.
	 * @param access The maximum level of access restriction to populate.
	 * @param skipNonMembers <code>true</code> if non-members (such as constructors) should be skipped.
	 * @param name The name the member must have, or <code>null</code> to skip this check.
	 */
	public abstract void populateElement(T map, Node node, AccessModifier access, boolean skipNonMembers, String name);
	
	/**
	 * Determines which types of nodes the element population elements should use.  This is used to filter unnecessary
	 * nodes in the event that the namespace is being constructed by a metaprogram.
	 * @return The types of nodes that this operation should consider when populating.
	 */
	public abstract Iterable<? extends Class<? extends Node>> getPopulationTypes();

	/**
	 * Creates a new map using a single deference map and an environment type.
	 * @param deferenceMap The deference map to use.
	 * @param envType The environment type.
	 * @return The new map.
	 */
	protected abstract T makeMap(T deferenceMap, EnvType envType);

	/**
	 * An enumeration which categorizes environments based on their usual behaviors.
	 */
	protected static enum EnvType
	{
		/** The category used for environments which handle on-demand imports. */
		ON_DEMAND_IMPORT(false, false, OverlapMode.BY_SIGNATURE),
		/** The category used for types and members. This is used for single imports as well. */
		TYPE_OR_MEMBER(true, false, OverlapMode.BY_NAME),
		/** The category used for inherited members. */
		INHERITED(false, false, OverlapMode.BY_SIGNATURE),
		/** The category used for sequential statements. */
		STATEMENT(true, true, OverlapMode.BY_NAME);

		private boolean eager;
		private boolean prohibitsOverlap;
		private OverlapMode overlapMode;

		private EnvType(boolean eager, boolean prohibitsOverlap, OverlapMode overlapMode)
		{
			this.eager = eager;
			this.prohibitsOverlap = prohibitsOverlap;
			this.overlapMode = overlapMode;
		}

		public boolean isEager()
		{
			return eager;
		}

		public boolean isProhibitsOverlap()
		{
			return prohibitsOverlap;
		}

		public OverlapMode getOverlapMode()
		{
			return overlapMode;
		}
	}
}
