package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import java.util.Collection;
import java.util.Iterator;

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
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.operations.TypeDeclarationLocatingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.OnDemandImportAmbiguousTypeNameDiagnosticFactory;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.VoidDiagnosticFactory;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

/**
 * This module performs type checking as per the Java Language Specification v3. It also includes the modifications
 * indicated in the Backstage Java Language Specification, specifically with regard to code literals and parse mapping.
 * 
 * @author Zachary Palmer
 */
public class TypeChecker
{
	/** The toolkit to be used by this type checker. */
	private BsjToolkit toolkit;

	/**
	 * Creates a new type checker.
	 * 
	 * @param toolkit The toolkit to be used by this type checker.
	 */
	public TypeChecker(BsjToolkit toolkit)
	{
		super();
		this.toolkit = toolkit;
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
							map.add(namedTypeDeclarationNode.getIdentifier().getIdentifier(), namedTypeDeclarationNode,
									indicator);
						}
					}
				}
			}
		}
	}

	/**
	 * Performs a type checking operation on the provided {@link CompilationUnitNode}s. Type checking failures are
	 * reported to the provided {@link DiagnosticListener}.
	 * 
	 * @param compilationUnitNodes The {@link CompilationUnitNode}s which should be typechecked.
	 * @param diagnosticListener The {@link DiagnosticListener} to which diagnostic information should be reported.
	 * @throws IllegalStateException If any of the provided {@link CompilationUnitNode}s are not connected to a root
	 *             package.
	 */
	public void typecheck(Collection<CompilationUnitNode> compilationUnitNodes,
			DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		// Precondition: root package must be available
		for (CompilationUnitNode compilationUnitNode : compilationUnitNodes)
		{
			PackageNode rootPackage = compilationUnitNode.getRootPackage();
			if (rootPackage == null)
			{
				throw new IllegalStateException(
						"Cannot typecheck a compilation unit which is not connected to a package hierarchy.");
			}
		}
		
		/*

		TypeNamespaceMap typeNamespaceMap = populateTypeNamespaceMap(compilationUnitNodes, diagnosticListener,
				rootPackage);
		*/
		// TODO: continue working

	}

	private TypeNamespaceMap populateTypeNamespaceMap(CompilationUnitNode compilationUnitNode,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, PackageNode rootPackage)
	{
		TypeNamespaceMap typeNamespaceMap;

		// *** 1. On-demand imports
		// namespace error policy: lazy on-demand import errors
		typeNamespaceMap = new TypeNamespaceMap(diagnosticListener,
				new OnDemandImportAmbiguousTypeNameDiagnosticFactory(), false);
		for (ImportNode importNode : compilationUnitNode.getImports())
		{
			if (importNode instanceof ImportOnDemandNode)
			{
				// Get everything in the specified package or type
				if (importNode.getName().getCategory() == NameCategory.PACKAGE)
				{
					PackageNode packageNode = rootPackage.getSubpackageByQualifiedName(importNode.getName());
					populateNamespaceMapWithPackage(typeNamespaceMap, packageNode, importNode);
				} else
				{
					// TODO: import all declared types which exist on another type
				}
			}
		}

		// *** 2. Package peers
		// next error policy: none. Duplication would mean that at least one of the classes shouldn't be public, which
		// should produce an error message elsewhere.
		typeNamespaceMap = new TypeNamespaceMap(typeNamespaceMap, diagnosticListener, new VoidDiagnosticFactory(), true);
		Iterator<CompilationUnitNode> siblingIterator = ((PackageNode) compilationUnitNode.getParent()).getCompilationUnitIterator();
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
							typeNamespaceMap.add(namedTypeDeclarationNode.getIdentifier().getIdentifier(),
									namedTypeDeclarationNode, namedTypeDeclarationNode);
						}
					}
				}
			}
		}

		// *** 3. Single type imports
		// namespace error policy: eager single-type import errors
		typeNamespaceMap = new TypeNamespaceMap(diagnosticListener,
				new OnDemandImportAmbiguousTypeNameDiagnosticFactory(), true);
		for (ImportNode importNode : compilationUnitNode.getImports())
		{
			if (importNode instanceof ImportSingleTypeNode)
			{
				// Import just that one type
				TypeDeclarationLocatingNodeOperation op = new TypeDeclarationLocatingNodeOperation(importNode.getName());
				NamedTypeDeclarationNode<?> typeDeclaration = compilationUnitNode.executeOperation(op, null);
				if (typeDeclaration == null)
				{
					// TODO: single type import cannot be resolved - report an error
				} else
				{
					typeNamespaceMap.add(typeDeclaration.getIdentifier().getIdentifier(), typeDeclaration, importNode);
				}
			}
		}

		return typeNamespaceMap;
	}
}
