package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjUserDiagnosticTranslatingListener;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.ContextImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.UserMetaprogramWrapper;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.Dependency;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

public class PrepareMetaAnnotationMetaprorgamTask extends
		AbstractMetaprogramProfileBuildingTask<MetaAnnotationMetaprogramAnchorNode>
{
	/** The meta-annotation metaprogram for which a profile should be constructed and registered. */
	private BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode> metaprogramObject;

	public PrepareMetaAnnotationMetaprorgamTask(MetaAnnotationMetaprogramAnchorNode anchor,
			MetaprogramProfile<?> profile, BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode> metaprogramObject)
	{
		super(TaskPriority.PREPARE_METAANNOTATION_METAPROGRAM, anchor, profile);
		this.metaprogramObject = metaprogramObject;
	}

	@Override
	protected MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode> buildProfile(
			MetacompilationContext metacompilationContext) throws IOException
	{
		Collection<String> targetNames = new ArrayList<String>(this.metaprogramObject.getTargets());

		List<Dependency> dependencies = new ArrayList<Dependency>();
		for (String depName : this.metaprogramObject.getDependencies())
		{
			dependencies.add(new Dependency(depName, false));
		}
		for (String depName : this.metaprogramObject.getWeakDependencies())
		{
			dependencies.add(new Dependency(depName, true));
		}

		// TODO: validate that the target names and dependency names are not bogus

		Context<MetaAnnotationMetaprogramAnchorNode> context = new ContextImpl<MetaAnnotationMetaprogramAnchorNode>(
				this.anchor, this.metacompilationContext.getToolkit().getNodeFactory(),
				new BsjUserDiagnosticTranslatingListener(this.metacompilationContext.getDiagnosticListener(),
						this.anchor.getStartLocation()));

		MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode> profile = new MetaprogramProfile<MetaAnnotationMetaprogramAnchorNode>(
				new UserMetaprogramWrapper<MetaAnnotationMetaprogramAnchorNode>(this.metaprogramObject), this.anchor,
				dependencies, targetNames, this.metaprogramObject.getLocalMode(),
				this.metaprogramObject.getPackageMode(), context);
		return profile;
	}
}
