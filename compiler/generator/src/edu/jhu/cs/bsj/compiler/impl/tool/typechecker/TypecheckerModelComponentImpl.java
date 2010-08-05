package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.ElementBuildingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuildingNodeOperation;

/**
 * This class is intended to represent a typechecker model component.  It contains functionality which is useful to
 * the modeling classes for both types and elements.
 * @author Zachary Palmer
 */
public class TypecheckerModelComponentImpl
{
	private TypecheckerModelManager manager;

	public TypecheckerModelComponentImpl(TypecheckerModelManager manager)
	{
		super();
		this.manager = manager;
	}
	
	protected TypecheckerModelManager getManager()
	{
		return this.manager;
	}
	
	/**
	 * Creates an appropriate {@link Element} for the provided node (if possible).
	 * @param node The node for which to create an element.
	 * @return The resulting element.
	 */
	protected Element makeElement(Node node)
	{
		return node.executeOperation(new ElementBuildingNodeOperation(getManager()), null);
	}
	
	/**
	 * Creates an appropriate {@link TypeMirror} for the provided node (if possible).
	 * @param node The node for which to create a type.
	 * @return  The resulting type.
	 */
	protected TypeMirror makeType(TypeNode node)
	{
		return node.executeOperation(new TypeBuildingNodeOperation(getManager()), null);
	}
	
	/**
	 * Retrieves an element for the top-level type named by the provided name components.  All but the last are assumed
	 * to represent package names.
	 * @param name The name of the top-level type to obtain.
	 * @return An element for that top-level type.
	 */
	public Element getElementByName(String... name)
	{
		return makeElement(findTopLevelTypeByName(name));
	}
	
	protected NamedTypeDeclarationNode<?> findTopLevelTypeByName(String... name)
	{
		if (name.length == 0)
		{
			throw new IllegalArgumentException("Cannot handle empty name");
		}
		PackageNode packageNode = getManager().getRootPackage();
		for (int i=0;i<name.length-1;i++)
		{
			packageNode = packageNode.getSubpackage(name[i]);
			if (packageNode == null)
			{
				throw new IllegalArgumentException("No such package exists: " + name[i]);
			}
		}
		CompilationUnitNode compilationUnitNode = packageNode.getCompilationUnit(name[name.length-1]);
		if (compilationUnitNode==null)
		{
			throw new IllegalArgumentException("No such compilation unit exists: " + name[name.length-1]);
		}
		// note: assuming that there is exactly one top-level type declared that matches the name
		for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
		{
			if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>)typeDeclarationNode;
				if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(name[name.length-1]))
				{
					return namedTypeDeclarationNode;
				}
			}
		}
		throw new IllegalArgumentException("No such top-level type exists: " + name[name.length-1]);
	}
}
