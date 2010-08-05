package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.AccessibleTypeModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportOnDemandNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.DeclaredTypeElementImpl;

/**
 * This class manages the calculation and storage of environments in the type checker. An environment represents
 * namespace mappings on a per-node basis. This manager serves the function of a symbol table generator.
 * 
 * @author Zachary Palmer
 */
public class EnvironmentManager
{
	/** The root package. */
	private PackageNode rootPackage;
	/** The listener to which to report lookup errors. */
	private DiagnosticListener<BsjSourceLocation> listener;
	/** This manager's toolkit. */
	private TypecheckerToolkit toolkit;

	/**
	 * The mapping which relates nodes to their environments. More specifically, each node is mapped to the base
	 * environment which is applicable to their children. A compilation unit's environment, for instance, would include
	 * the type names introduced by its import nodes; a method body's environment would include the variable names
	 * introduced by its parameters but not the variable names introduced by its local variable declarations (because
	 * those declarations are children of the method body). Leaves will tend to use the same environment as their
	 * parents. If a name must be resolved, the node in which that name appears uses its own environment to resolve the
	 * name.
	 */
	private Map<Node, Environment> environmentMap;

	/**
	 * Creates a new environment manager.
	 * 
	 * @param rootPackage The root package in the AST.
	 * @param listener The listener to which lookup and declaration errors should be reported.
	 * @param toolkit The typechecker toolkit to use to build elements.
	 */
	public EnvironmentManager(PackageNode rootPackage, DiagnosticListener<BsjSourceLocation> listener,
			TypecheckerToolkit toolkit)
	{
		super();
		this.rootPackage = rootPackage;
		this.listener = listener;
		this.toolkit = toolkit;

		this.environmentMap = new HashMap<Node, Environment>();
	}

	/**
	 * Retrieves an environment corresponding to the specified node. Package nodes will never have a corresponding
	 * environment. If the environment for this node has not yet been calculated, this method will lazily construct it.
	 * 
	 * @param node The node in question.
	 * @return The environment to use (or <code>null</code> if the node is a package node).
	 */
	public Environment getEnvironment(Node node)
	{
		if (node instanceof PackageNode)
		{
			return null;
		}

		Environment ret = environmentMap.get(node);
		if (ret == null)
		{
			calculateEnvironment(node.getNearestAncestorOfType(CompilationUnitNode.class));
			ret = environmentMap.get(node);
		}
		return ret;
	}

	/**
	 * Performs environment calculations for all nodes which are children of the provided compilation unit. The results
	 * are stored in the environment map.
	 * 
	 * @param compilationUnitNode The compilation unit for which environments should be calculated.
	 */
	private void calculateEnvironment(CompilationUnitNode compilationUnitNode)
	{
		// Create variables for the symbol table
		TypeNamespaceMap typeNamespaceMap;

		// Step 1: Process on-demand imports. This namespace has a lazy error policy, as ambiguities in on-demand
		// imports (such as "import java.util.*; import java.awt.*;" only matter if the ambiguous name is used
		// (such as in "List").
		typeNamespaceMap = new TypeNamespaceMap(this.listener, new OnDemandImportAmbiguousTypeNameDiagnosticFactory(),
				false);
		populateOnDemandImports(typeNamespaceMap, compilationUnitNode.getImports());

		// Step 2: Process top-level package peers. This namespace has an eager error policy as any duplication means
		// a name conflict in the local package.
		// TODO: create a diagnostic policy - currently ignoring, which is safe because Java compiler will catch it
		typeNamespaceMap = new TypeNamespaceMap(this.listener, new NotImplementedYetAmbiguousDiagnosticFactory(), true);
		populateNamespaceMapWithPackage(typeNamespaceMap, (PackageNode) compilationUnitNode.getParent(),
				compilationUnitNode.getPackageDeclaration());

		// Step 3: Process single-type imports. This namespace has a eager error policy, as ambiguities in single-type
		// imports cause the import statements to be useless in any context (such as
		// "import java.util.List; import java.awt.List;").
		typeNamespaceMap = new TypeNamespaceMap(this.listener, new SingleImportAmbiguousTypeNameDiagnosticFactory(),
				true);
		populateSingleTypeImports(typeNamespaceMap, compilationUnitNode.getImports());

		// Step 4: Process top-level type declarations. The addition of the public top-level type declaration will, of
		// course, be redundant (because it was obtained in Step 2). The same typespace map is used, since a top-level
		// type named N in the same compilation unit and a single-static import of a type named N will conflict.
		populateTopLevelTypes(typeNamespaceMap, compilationUnitNode.getTypeDecls());

		// Step 5: Store this environment
		Environment environment = new Environment(typeNamespaceMap);
		this.environmentMap.put(compilationUnitNode, environment);
		
		// Step 6: Build the environments for each of the top-level types
		for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
		{
			calculateEnvironment(typeDeclarationNode, environment);
		}
	}
	
	private void calculateEnvironment(TypeDeclarationNode typeDeclarationNode, Environment baseEnvironment)
	{
		// TODO
	}

	private void populateTopLevelTypes(TypeNamespaceMap typeNamespaceMap, Iterable<TypeDeclarationNode> typeDecls)
	{
		for (TypeDeclarationNode typeDeclarationNode : typeDecls)
		{
			if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> type = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
				typeNamespaceMap.add(type.getIdentifier().getIdentifier(),
						(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(type), type);
			}
		}
	}

	private void populateOnDemandImports(TypeNamespaceMap typeNamespaceMap, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportOnDemandNode)
			{
				switch (importNode.getName().getCategory())
				{
					case PACKAGE:
						PackageNode packageNode = rootPackage.getSubpackageByQualifiedName(importNode.getName());
						populateNamespaceMapWithPackage(typeNamespaceMap, packageNode, importNode);
						break;
					case TYPE:
						NamedTypeDeclarationNode<?> type = getTypeFromCanonicalName(importNode.getName());
						for (Node node : type.getBody().getMembers())
						{
							if (node instanceof NamedTypeDeclarationNode<?>)
							{
								NamedTypeDeclarationNode<?> memberType = (NamedTypeDeclarationNode<?>) node;
								if (memberType.getModifiers() instanceof AccessibleTypeModifiersNode
										&& ((AccessibleTypeModifiersNode) memberType.getModifiers()).getAccess() == AccessModifier.PUBLIC)
								{
									typeNamespaceMap.add(memberType.getIdentifier().getIdentifier(),
											(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(memberType),
											importNode);
								}
							}
						}
						// TODO: import all declared types which exist on another type
						throw new NotImplementedYetException();
					default:
						// In this case, the name categorizer messed up
						throw new IllegalStateException(
								"Name categorizer gave non-package, non-type category to import name: "
										+ importNode.getName().getNameString() + " has category "
										+ importNode.getName().getCategory());
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
				NamedTypeDeclarationNode<?> type = getTypeFromCanonicalName(importNode.getName());
				if (type == null)
				{
					continue;
				}

				map.add(type.getIdentifier().getIdentifier(),
						(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(type), importNode);
			}
		}
	}

	private NamedTypeDeclarationNode<?> getTypeFromCanonicalName(NameNode name)
	{
		// Get the name of the package.
		List<String> typeNames = new ArrayList<String>();
		while (name != null && name.getCategory() != NameCategory.PACKAGE)
		{
			if (name.getCategory() != NameCategory.TYPE)
			{
				throw new IllegalStateException("Name categorizer gave non-package, non-type category to import name: "
						+ name.getNameString() + " has category " + name.getCategory());
			}
			typeNames.add(name.getIdentifier().getIdentifier());
			if (name instanceof SimpleNameNode)
			{
				name = null;
			} else
			{
				name = ((QualifiedNameNode) name).getBase();
			}
		}

		if (typeNames.size() == 0)
		{
			// We were provided with a package name, not a type name
			// TODO: raise an appropriate diagnostic
			throw new NotImplementedYetException();
		}

		// Ascertain the package in which the imported type lives
		PackageNode packageNode;
		if (name == null)
		{
			packageNode = this.rootPackage;
		} else
		{
			packageNode = this.rootPackage.getSubpackageByQualifiedName(name);
		}

		// Obtain the type from the package
		NamedTypeDeclarationNode<?> type = packageNode.getTopLevelTypeDeclaration(typeNames.get(0));
		if (type == null)
		{
			// The type does not exist
			// TODO: raise an appropriate diagnostic
			throw new NotImplementedYetException();
		}
		for (int index = 1; index < typeNames.size(); index++)
		{
			type = type.getTypeDeclaration(typeNames.get(index));
			if (type == null)
			{
				// The type does not exist
				// TODO: raise an appropriate diagnostic
				throw new NotImplementedYetException();
			}
		}

		return type;
	}

	/**
	 * Populates a type namespace map with a given package's top-level types.
	 * 
	 * @param map The map to populate.
	 * @param packageNode The package in question.
	 * @param indicator The indicator node to which each entry is to be attributed.
	 */
	private void populateNamespaceMapWithPackage(TypeNamespaceMap map, PackageNode packageNode, Node indicator)
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
						if (accessibleTypeModifiersNode.getAccess() == AccessModifier.PUBLIC)
						{
							// then this sibling is a publically accessible type and is available in the namespace
							// by default
							map.add(namedTypeDeclarationNode.getIdentifier().getIdentifier(),
									(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(namedTypeDeclarationNode),
									indicator);
						}
					}
				}
			}
		}
	}
}
