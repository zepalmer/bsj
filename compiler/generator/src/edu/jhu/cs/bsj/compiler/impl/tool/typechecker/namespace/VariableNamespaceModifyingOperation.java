package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.VariableNamespaceMap;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Provides variable namespace modification.
 * 
 * @author Zachary Palmer
 */
public class VariableNamespaceModifyingOperation extends
		AbstractNamespaceModifyingOperation<String, BsjVariableElement, VariableNamespaceMap>
{
	public VariableNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
			DiagnosticListener<BsjSourceLocation> listener)
	{
		super(toolkit, loader, listener);
	}

	/**
	 * Performs a default operation for nodes which do not affect the variable namespace.
	 */
	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeDefault(Node node,
			VariableNamespaceMap map)
	{
		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeAnnotationBodyNode(
			AnnotationBodyNode node, VariableNamespaceMap map)
	{
		// *** Populate elements inherited from java.lang.annotation.Annotation
		AnnotationDeclarationNode declarationNode = (AnnotationDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeAnonymousClassBodyNode(
			AnonymousClassBodyNode node, VariableNamespaceMap map)
	{
		// *** Populate inherited members
		map = makeInheritedMapFor(node, map);

		// *** Create a new environment for declared members
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate declared members
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeCatchNode(CatchNode node,
			VariableNamespaceMap map)
	{
		// *** The scope of the parameter in a catch block is the body of that catch block
		Map<Node, VariableNamespaceMap> namespaceMap;
		VariableNamespaceMap defaultMap = map;

		map = makeMap(map, EnvType.STATEMENT);
		populateParameters(map, Collections.singletonList(node.getParameter()));

		namespaceMap = Collections.<Node, VariableNamespaceMap> singletonMap(node.getBody(), map);

		return new MappedChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(defaultMap,
				namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeClassBodyNode(
			ClassBodyNode node, VariableNamespaceMap map)
	{
		// *** Inherit member elements
		AbstractlyUnmodifiedClassDeclarationNode<?> declarationNode = (AbstractlyUnmodifiedClassDeclarationNode<?>) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeCompilationUnitNode(
			CompilationUnitNode node, VariableNamespaceMap map)
	{
		// Only the type declarations contained in a compilation unit benefit from the declarations contained within
		// it; import statements, for instance, do not apply to other import statements.
		VariableNamespaceMap defaultMap = map;

		// *** Create a new scope for the on-demand imports
		map = makeMap(map, EnvType.ON_DEMAND_IMPORT);

		// *** Process on-demand static imports.
		populateOnDemandStaticImports(map, node.getImports());

		// *** Create a new scope for the single imports
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Process single static imports.
		populateSingleStaticImports(map, node.getImports());

		// *** Finished!
		Map<Node, VariableNamespaceMap> namespaceMap = Collections.<Node, VariableNamespaceMap> singletonMap(
				node.getTypeDecls(), map);
		return new MappedChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(defaultMap,
				namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeConstructorDeclarationNode(
			ConstructorDeclarationNode node, VariableNamespaceMap map)
	{
		VariableNamespaceMap defaultMap = map;

		// *** Populate constructor parameters into constructor invocation and constructor body
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);
		populateParameters(map, node.getParameters());

		// *** Finished!
		Map<Node, VariableNamespaceMap> namespaceMap = Collections.<Node, VariableNamespaceMap> singletonMap(
				node.getBody(), map);
		return new MappedChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(defaultMap,
				namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeEnhancedForLoopNode(
			EnhancedForLoopNode node, VariableNamespaceMap map)
	{
		VariableNamespaceMap defaultMap = map;

		// *** The scope of the parameter to the enhanced for loop is the body of that loop
		map = makeMap(map, EnvType.STATEMENT);
		populateParameters(map, Collections.singletonList(node.getVariable()));

		// *** Finished!
		Map<Node, VariableNamespaceMap> namespaceMap = Collections.<Node, VariableNamespaceMap> singletonMap(
				node.getStatement(), map);
		return new MappedChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(defaultMap,
				namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeEnumBodyNode(
			EnumBodyNode node, VariableNamespaceMap map)
	{
		// *** Create a new scope for inherited member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Inherit member elements
		EnumDeclarationNode declarationNode = (EnumDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate enum constants
		populateElements(map, node.getConstants(), AccessModifier.PRIVATE);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeForLoopNode(
			ForLoopNode node, VariableNamespaceMap map)
	{
		// The initializer is addressed by its children. Either it's a statement expression list (in which case
		// no changes occur) or it's a local variable declaration (in which case the local variable declaration
		// handler will populate things properly).
		VariableNamespaceMap initializerMap = map;

		// Populate all of the contents of the initializer
		if (node.getInitializer() instanceof ForInitializerDeclarationNode)
		{
			map = makeMap(map, EnvType.STATEMENT);
			tryPopulateLocalVariable(map, ((ForInitializerDeclarationNode) node.getInitializer()).getDeclaration());
		}

		// *** Finished!
		Map<Node, VariableNamespaceMap> namespaceMap = Collections.<Node, VariableNamespaceMap> singletonMap(
				node.getInitializer(), initializerMap);
		return new MappedChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map, namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeInterfaceBodyNode(
			InterfaceBodyNode node, VariableNamespaceMap map)
	{
		// *** Create a new scope for inherited member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Inherit member elements
		InterfaceDeclarationNode declarationNode = (InterfaceDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	/*
	 * *** NOTE: local variable declaration is not handled here. This is because of the fashion in which the parent
	 * environments are assigned. The structural children of the local variable declaration do not have a consistent
	 * scope change based on the declaration node; for instance, each declarator has different variables in scope.
	 * Furthermore, to prevent redundant diagnostic production, nodes immediately following a variable declaration are
	 * environmental children of the last declarator in a local variable declaration. Thus, none of the nodes which are
	 * affected by a local variable declaration node are the environmental children of the declaration node itself and
	 * it does not need to be handled here.
	 */

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeMetaprogramNode(
			MetaprogramNode node, VariableNamespaceMap map)
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
		map = new VariableNamespaceMap(Collections.<VariableNamespaceMap> emptySet(), getListener(), true, false);
		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeMethodDeclarationNode(
			MethodDeclarationNode node, VariableNamespaceMap map)
	{
		VariableNamespaceMap defaultMap = map;

		// *** Populate method parameters into method body
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);
		populateParameters(map, node.getParameters());

		// *** Finished!
		Map<Node, VariableNamespaceMap> namespaceMap = Collections.<Node, VariableNamespaceMap> singletonMap(
				node.getBody(), map);
		return new MappedChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(defaultMap,
				namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap> executeVariableDeclaratorNode(
			VariableDeclaratorNode node, VariableNamespaceMap map)
	{
		// *** The scope of a variable declarator includes its own initializer.
		// We're also going to include the variable name here. This has no appreciable effect on the behavior of the
		// system except in that it encourages the generation of diagnostics when no initializer exists.
		map = makeMap(map, EnvType.STATEMENT);
		tryPopulateVariableDeclarator(map, node);

		return new ConsistentChildNamespaceProducer<String, BsjVariableElement, VariableNamespaceMap>(map);
	}

	// ***** UTILITY METHODS **************************************************

	protected VariableNamespaceMap makeMap(VariableNamespaceMap deferenceMap, EnvType envType)
	{
		return new VariableNamespaceMap(Collections.singleton(deferenceMap), this.getListener(), envType.isEager(),
				envType.isProhibitsOverlap());
	}

	@Override
	protected VariableNamespaceMap makeInheritanceMapFromSubmaps(Collection<VariableNamespaceMap> submaps)
	{
		return new VariableNamespaceMap(submaps, getListener(), EnvType.INHERITED.isEager(),
				EnvType.INHERITED.isProhibitsOverlap());
	}

	@Override
	public void populateElement(VariableNamespaceMap map, Node node, AccessModifier access, boolean skipNonMembers,
			String name)
	{
		if (node instanceof FieldDeclarationNode)
		{
			tryPopulateMemberField(map, node, (FieldDeclarationNode) node, access, name);
		} else if (node instanceof ConstantDeclarationNode)
		{
			tryPopulateMemberConstant(map, node, (ConstantDeclarationNode) node, name);
		} else if (node instanceof EnumConstantDeclarationNode)
		{
			tryPopulateMemberEnumConstant(map, node, (EnumConstantDeclarationNode) node, name);
		}
	}

	@Override
	public Iterable<? extends Class<? extends Node>> getPopulationTypes()
	{
		List<Class<? extends Node>> list = new ArrayList<Class<? extends Node>>();
		list.add(FieldDeclarationNode.class);
		list.add(ConstantDeclarationNode.class);
		list.add(EnumConstantDeclarationNode.class);
		return list;
	}

	/**
	 * Populates the specified parameters into the current namespace.
	 */
	protected void populateParameters(VariableNamespaceMap map, List<VariableNode> parameters)
	{
		for (VariableNode parameter : parameters)
		{
			map.add(parameter.getIdentifier().getIdentifier(),
					(BsjVariableElement) this.getToolkit().makeElement(parameter), parameter);
		}
	}

	/**
	 * Attempts to populate a member variable into the provided method namespace map. This will succeed if and only if
	 * the variable's access modifier is less restrictive or equally restrictive to the level of access provided.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberField The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	protected void tryPopulateMemberField(VariableNamespaceMap variableNamespaceMap, Node indicator,
			FieldDeclarationNode memberField, AccessModifier access, String name)
	{
		if ((memberField.getModifiers()).getAccess().compareTo(access) <= 0)
		{
			for (VariableDeclaratorNode declaratorNode : memberField.getDeclarators())
			{
				if (name == null || declaratorNode.getIdentifier().getIdentifier().equals(name))
				{
					variableNamespaceMap.add(declaratorNode.getIdentifier().getIdentifier(),
							(BsjVariableElement) this.getToolkit().makeElement(declaratorNode), declaratorNode);
				}
			}
		}
	}

	/**
	 * Populates a member constant into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberConstant The declaration which is being populated.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	protected void tryPopulateMemberConstant(VariableNamespaceMap variableNamespaceMap, Node indicator,
			ConstantDeclarationNode memberConstant, String name)
	{
		for (VariableDeclaratorNode declaratorNode : memberConstant.getDeclarators())
		{
			if ((name == null || declaratorNode.getIdentifier().getIdentifier().equals(name)))
			{
				variableNamespaceMap.add(declaratorNode.getIdentifier().getIdentifier(),
						(BsjVariableElement) this.getToolkit().makeElement(declaratorNode), declaratorNode);
			}
		}
	}

	/**
	 * Populates a local variable into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param memberConstant The declaration which is being populated.
	 */
	protected void tryPopulateLocalVariable(VariableNamespaceMap variableNamespaceMap,
			LocalVariableDeclarationNode declarationNode)
	{
		for (VariableDeclaratorNode declaratorNode : declarationNode.getDeclarators())
		{
			variableNamespaceMap.add(declaratorNode.getIdentifier().getIdentifier(),
					(BsjVariableElement) this.getToolkit().makeElement(declaratorNode), declaratorNode);
		}
	}

	/**
	 * Populates a local variable into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param memberConstant The declaration which is being populated.
	 */
	protected void tryPopulateVariableDeclarator(VariableNamespaceMap variableNamespaceMap,
			VariableDeclaratorNode declaratorNode)
	{
		variableNamespaceMap.add(declaratorNode.getIdentifier().getIdentifier(),
				(BsjVariableElement) this.getToolkit().makeElement(declaratorNode), declaratorNode);
	}

	/**
	 * Populates a member constant into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberConstant The declaration which is being populated.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	protected void tryPopulateMemberEnumConstant(VariableNamespaceMap variableNamespaceMap, Node indicator,
			EnumConstantDeclarationNode memberConstant, String name)
	{
		if ((name == null || memberConstant.getIdentifier().getIdentifier().equals(name)))
		{
			variableNamespaceMap.add(memberConstant.getIdentifier().getIdentifier(),
					(BsjVariableElement) this.getToolkit().makeElement(memberConstant), memberConstant);
		}
	}
}