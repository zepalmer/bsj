package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.ErasedMethodSignature;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap.OverlapMode;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Provides method namespace modification.
 * 
 * @author Zachary Palmer
 */
public class MethodNamespaceModifyingOperation extends
		AbstractNamespaceModifyingOperation<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>
{
	/**
	 * Creates a type namespace modifier.
	 * 
	 * @param toolkit The typechecker toolkit to use to create elements.
	 * @param loader The compilation unit loader to use when loading of compilation units is necessary.
	 * @param listener The listener to which diagnostics will be reported.
	 */
	public MethodNamespaceModifyingOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
			DiagnosticListener<BsjSourceLocation> listener)
	{
		super(toolkit, loader, listener);
	}

	/**
	 * Performs a default operation for nodes which do not affect the method namespace.
	 */
	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeDefault(
			Node node, MethodNamespaceMap map)
	{
		return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				map);
	}

	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeAnnotationBodyNode(
			AnnotationBodyNode node, MethodNamespaceMap map)
	{
		// *** Populate elements inherited from java.lang.annotation.Annotation
		AnnotationDeclarationNode declarationNode = (AnnotationDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				map);
	}

	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeAnonymousClassBodyNode(
			AnonymousClassBodyNode node, MethodNamespaceMap map)
	{
		// *** Populate inherited members
		map = makeInheritedMapFor(node, map);

		// *** Create a new environment for declared members
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate declared members
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				map);
	}

	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeClassBodyNode(
			ClassBodyNode node, MethodNamespaceMap map)
	{
		// *** Inherit member elements
		ClassDeclarationNode declarationNode = (ClassDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				map);
	}

	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeCompilationUnitNode(
			CompilationUnitNode node, MethodNamespaceMap map)
	{
		// Only the type declarations contained in a compilation unit benefit from the declarations contained within
		// it; import statements, for instance, do not apply to other import statements.
		MethodNamespaceMap defaultMap = map;

		// *** Create a new scope for the on-demand imports
		map = makeMap(map, EnvType.ON_DEMAND_IMPORT);

		// *** Process on-demand static imports.
		populateOnDemandStaticImports(map, node.getImports());

		// *** Create a new scope for single static imports
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Process single-type static imports.
		populateSingleStaticImports(map, node.getImports());

		// *** Process top-level type declarations. The addition of the public top-level type declaration will, of
		// course, be redundant (because it was obtained in from package peers above). The same typespace map is used,
		// since a top-level type named N in the same compilation unit and a single-static import of a type named N will
		// conflict.
		populateElements(map, node.getTypeDecls(), AccessModifier.PUBLIC);

		// *** Finished!
		Map<Node, MethodNamespaceMap> namespaceMap = Collections.<Node, MethodNamespaceMap> singletonMap(
				node.getTypeDecls(), map);
		return new MappedChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				defaultMap, namespaceMap);
	}

	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeEnumBodyNode(
			EnumBodyNode node, MethodNamespaceMap map)
	{
		// *** Inherit member elements
		EnumDeclarationNode declarationNode = (EnumDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Add hard-coded elements as specified in JLS v3 S8.9
		// TODO: how do we create elements which are not backed by AST nodes?
		// public static E[] values();
		// public static E valueOf(String);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				map);
	}

	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeInterfaceBodyNode(
			InterfaceBodyNode node, MethodNamespaceMap map)
	{
		// *** Inherit member elements
		InterfaceDeclarationNode declarationNode = (InterfaceDeclarationNode) node.getParent();
		map = makeInheritedMapFor(declarationNode, map);

		// *** Create a new scope for declared member elements
		map = makeMap(map, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(map, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				map);
	}

	@Override
	public ChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap> executeMetaprogramNode(
			MetaprogramNode node, MethodNamespaceMap map)
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
		map = new MethodNamespaceMap(Collections.<MethodNamespaceMap> emptySet(), getListener(), true,
				OverlapMode.BY_SIGNATURE);
		return new ConsistentChildNamespaceProducer<ErasedMethodSignature, BsjExecutableElement, MethodNamespaceMap>(
				map);
	}

	// ***** UTILITY METHODS **************************************************

	/**
	 * Attempts to populate a member method into the provided method namespace map. This will succeed if and only if the
	 * method's access modifier is less restrictive or equally restrictive to the level of access provided.
	 * 
	 * @param methodNamespaceMap The namespace into which to populate the method.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberMethod The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	protected void tryPopulateMemberMethod(MethodNamespaceMap methodNamespaceMap, Node indicator,
			MethodDeclarationNode memberMethod, AccessModifier access, String name)
	{
		if ((memberMethod.getModifiers()).getAccess().compareTo(access) < 0
				&& (name == null || memberMethod.getIdentifier().getIdentifier().equals(name)))
		{
			BsjExecutableElement element = (BsjExecutableElement) this.getToolkit().makeElement(memberMethod);
			methodNamespaceMap.add(new ErasedMethodSignature(element), element, indicator);
		}
	}

	/**
	 * Attempts to populate a constructor into the provided method namespace map. This will succeed if and only if the
	 * constructor's access modifier is less restrictive or equally restrictive to the level of access provided.
	 * 
	 * @param methodNamespaceMap The namespace into which to populate the constructor.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param constructor The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 */
	protected void tryPopulateMemberConstructor(MethodNamespaceMap methodNamespaceMap, Node indicator,
			ConstructorDeclarationNode constructor, AccessModifier access)
	{
		if ((constructor.getModifiers()).getAccess().compareTo(access) < 0)
		{
			BsjExecutableElement element = (BsjExecutableElement) this.getToolkit().makeElement(constructor);
			methodNamespaceMap.add(new ErasedMethodSignature(element), element, indicator);
		}
	}

	/**
	 * Attempts to populate an annotation member method into the provided method namespace map.
	 * 
	 * @param methodNamespaceMap The namespace into which to populate the method.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberMethod The declaration which is being populated.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	protected void tryPopulateAnnotationMemberMethod(MethodNamespaceMap methodNamespaceMap, Node indicator,
			AnnotationMethodDeclarationNode memberMethod, String name)
	{
		if (name == null || name.equals(memberMethod.getIdentifier().getIdentifier()))
		{
			BsjExecutableElement element = (BsjExecutableElement) this.getToolkit().makeElement(memberMethod);
			methodNamespaceMap.add(new ErasedMethodSignature(element), element, indicator);
		}
	}

	@Override
	protected MethodNamespaceMap makeInheritanceMapFromSubmaps(Collection<MethodNamespaceMap> submaps)
	{
		return new MethodNamespaceMap(submaps, getListener(), EnvType.INHERITED.isEager(),
				EnvType.INHERITED.getOverlapMode());
	}

	@Override
	protected MethodNamespaceMap makeMap(MethodNamespaceMap deferenceMap, EnvType envType)
	{
		return new MethodNamespaceMap(Collections.singletonList(deferenceMap), getListener(), envType.isEager(),
				envType.getOverlapMode());
	}

	@Override
	public void populateElement(MethodNamespaceMap map, Node node, AccessModifier access, boolean skipNonMembers,
			String name)
	{
		if (node instanceof MethodDeclarationNode)
		{
			tryPopulateMemberMethod(map, node, (MethodDeclarationNode) node, access, name);
		} else if (node instanceof AnnotationMethodDeclarationNode)
		{
			tryPopulateAnnotationMemberMethod(map, node, (AnnotationMethodDeclarationNode) node, name);
		} else if (!skipNonMembers)
		{
			if (node instanceof ConstructorDeclarationNode && name == null)
			{
				tryPopulateMemberConstructor(map, node, (ConstructorDeclarationNode) node, access);
			}
		}
	}
}
