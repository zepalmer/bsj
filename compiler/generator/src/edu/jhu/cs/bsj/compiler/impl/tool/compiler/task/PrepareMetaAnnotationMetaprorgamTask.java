package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramDependencyTypeNameResolutionDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjUserDiagnosticTranslatingListener;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.ContextImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.UserMetaprogramWrapper;
import edu.jhu.cs.bsj.compiler.impl.operations.TypeDeclarationLocatingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.Dependency;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

public class PrepareMetaAnnotationMetaprorgamTask extends
		AbstractMetaprogramProfileBuildingTask<MetaAnnotationMetaprogramAnchorNode>
{
	/** The meta-annotation metaprogram for which a profile should be constructed and registered. */
	private BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode> metaprogramObject;

	public PrepareMetaAnnotationMetaprorgamTask(MetaAnnotationMetaprogramAnchorNode anchor,
			InjectionInfo injectionInfo, BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode> metaprogramObject)
	{
		super(TaskPriority.PREPARE_METAANNOTATION_METAPROGRAM, anchor, injectionInfo);
		this.metaprogramObject = metaprogramObject;
	}

	@Override
	protected MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode> buildProfile(
			MetacompilationContext metacompilationContext) throws IOException
	{
		Collection<String> targetNames = new ArrayList<String>();
		for (String targetName : this.metaprogramObject.getTargets())
		{
			targetNames.add(getMetaprogramTypeName() + "." + targetName);
		}

		List<Dependency> dependencies = new ArrayList<Dependency>();
		boolean ok = true;
		ok &= addDependencies(dependencies, this.metaprogramObject.getDependencies(), false);
		ok &= addDependencies(dependencies, this.metaprogramObject.getWeakDependencies(), true);
		if (!ok)
			return null;

		// TODO: validate that the target names and dependency names are not bogus
		CompilationUnitLoader loader = this.metacompilationContext.getToolkit().getCompilationUnitLoaderFactory().makeLoader(
				this.metacompilationContext.getDiagnosticListener());
		Context<MetaAnnotationMetaprogramAnchorNode> context = new ContextImpl<MetaAnnotationMetaprogramAnchorNode>(
				this.anchor, this.metacompilationContext.getToolkit().getNodeFactory(),
				new BsjUserDiagnosticTranslatingListener(this.metacompilationContext.getDiagnosticListener(),
						this.anchor.getStartLocation()), loader);

		MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode> profile = new MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode>(
				new UserMetaprogramWrapper<MetaAnnotationMetaprogramAnchorNode>(this.metaprogramObject), this.anchor,
				dependencies, targetNames, this.metaprogramObject.getLocalMode(),
				this.metaprogramObject.getPackageMode(), context, injectionInfo.isPurelyInjected());
		return profile;
	}

	private boolean addDependencies(List<Dependency> list, Collection<String> depNames, boolean weak)
	{
		for (String depName : depNames)
		{
			String qualifiedDepName;
			// TODO: clean this up; using raw strings is a bit dangerous
			if (!depName.contains("."))
			{
				// Then the dependency name is simple. Qualify it with the enclosing type
				qualifiedDepName = getMetaprogramTypeName() + "." + depName;
			} else
			{
				// Then the name is at least partially qualified
				CompilationUnitLoader loader = this.metacompilationContext.getToolkit().getCompilationUnitLoaderFactory().makeLoader(
						this.metacompilationContext.getDiagnosticListener());
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = this.anchor.executeOperation(
						new TypeDeclarationLocatingNodeOperation(
								this.metacompilationContext.getToolkit().getNodeFactory().parseNameNode(depName),
								loader), null);
				if (namedTypeDeclarationNode == null)
				{
					// We could not find the type name contained in the dependency. This is an error; the
					// metaprogram is referring to a type which does not exist in the object program namespace.
					String typeName = depName.substring(0, depName.lastIndexOf('.'));
					metacompilationContext.getDiagnosticListener().report(
							new MetaprogramDependencyTypeNameResolutionDiagnosticImpl(this.anchor.getStartLocation(),
									typeName));
					return false;
				} else
				{
					qualifiedDepName = namedTypeDeclarationNode.getFullyQualifiedName() + "."
							+ depName.substring(depName.lastIndexOf('.') + 1);
				}
			}
			list.add(new Dependency(qualifiedDepName, weak));
		}
		return true;
	}
}
