package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.ElementBuildingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuildingNodeOperation;

public class TypecheckerToolkit
{
	private TypecheckerModelManager manager;

	public TypecheckerToolkit(TypecheckerModelManager manager)
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
	public Element makeElement(Node node)
	{
		return node.executeOperation(new ElementBuildingNodeOperation(getManager()), null);
	}
	
	/**
	 * Creates an appropriate {@link TypeMirror} for the provided node (if possible).
	 * @param node The node for which to create a type.
	 * @return  The resulting type.
	 */
	public TypeMirror makeType(TypeNode node)
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
	
	/**
	 * Finds a top-level type declaration by name.
	 * @param name The components of the name.  All but the last are assumed to be package names.
	 * @return The resulting type.
	 */
	public NamedTypeDeclarationNode<?> findTopLevelTypeByName(String... name)
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
		return packageNode.getTopLevelTypeDeclaration(name[name.length-1]);
	}
}
