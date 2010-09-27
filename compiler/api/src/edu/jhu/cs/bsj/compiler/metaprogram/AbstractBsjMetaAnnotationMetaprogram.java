package edu.jhu.cs.bsj.compiler.metaprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;

/**
 * This implementation of {@link BsjMetaAnnotationMetaprogram} provides basic functionality which is commonly necessary
 * for meta-annotation metaprograms. It provides an inner class for the implementation of the returned metaprogram that
 * depends upon the abstract methods of this class for its functionality. Specifically, execution of the metaprogram can
 * be defined in the {@link #execute(Context) execute} method.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractBsjMetaAnnotationMetaprogram implements BsjMetaAnnotationMetaprogram
{
	/** The permanent targets that this meta-annotation metaprogram always uses. */
	private List<String> permanentTargets;
	/** The permanent dependencies that this meta-annotation metaprogram always has. */
	private List<String> permanentDependencies;
	/** The permanent weak dependencies that this meta-annotation metaprogram always has. */
	private List<String> permanentWeakDependencies;

	/** The targets that this particular meta-annotation instance uses. */
	private List<String> instanceTargets;
	/** The dependencies that this particular meta-annotation instance uses. */
	private List<String> instanceDependencies;
	/** The weak dependencies that this particular meta-annotation instance uses. */
	private List<String> instanceWeakDependencies;

	/** The local mode of the metaprogram represented by this meta-annotation. */
	private MetaprogramLocalMode localMode;
	/** The package mode of the metaprogram represented by this meta-annotation. */
	private MetaprogramPackageMode packageMode;

	/**
	 * Skeleton constructor. Assumes that local and package mode are {@link MetaprogramLocalMode#INSERT INSERT} and
	 * {@link MetaprogramPackageMode#READ_ONLY READ_ONLY}, respectively. Assumes no weak dependencies.
	 * 
	 * @param permanentTargets The targets that instances of this meta-annotation class always use.
	 * @param permanentDependencies The dependencies that instances of this meta-annotation class always use.
	 */
	public AbstractBsjMetaAnnotationMetaprogram(List<String> permanentTargets, List<String> permanentDependencies)
	{
		this(permanentTargets, permanentDependencies, Arrays.<String> asList(), MetaprogramLocalMode.INSERT,
				MetaprogramPackageMode.READ_ONLY);
	}

	/**
	 * Skeleton constructor. Assumes that local and package mode are {@link MetaprogramLocalMode#INSERT INSERT} and
	 * {@link MetaprogramPackageMode#READ_ONLY READ_ONLY}, respectively.
	 * 
	 * @param permanentTargets The targets that instances of this meta-annotation class always use.
	 * @param permanentDependencies The dependencies that instances of this meta-annotation class always use.
	 * @param permanentWeakDependencies The weak dependencies that instances of this meta-annotation class always use.
	 */
	public AbstractBsjMetaAnnotationMetaprogram(List<String> permanentTargets, List<String> permanentDependencies,
			List<String> permanentWeakDependencies)
	{
		this(permanentTargets, permanentDependencies, permanentWeakDependencies, MetaprogramLocalMode.INSERT,
				MetaprogramPackageMode.READ_ONLY);
	}

	/**
	 * General constructor.
	 * 
	 * @param permanentTargets The targets that instances of this meta-annotation class always use.
	 * @param permanentDependencies The dependencies that instances of this meta-annotation class always use.
	 * @param permanentWeakDependencies The weak dependencies that instances of this meta-annotation class always use.
	 * @param localMode The default local mode of this meta-annotation metaprogram.
	 * @param packageMode The default package mode of this meta-annotation metaprogram.
	 */
	public AbstractBsjMetaAnnotationMetaprogram(List<String> permanentTargets, List<String> permanentDependencies,
			List<String> permanentWeakDependencies, MetaprogramLocalMode localMode, MetaprogramPackageMode packageMode)
	{
		this.permanentTargets = permanentTargets;
		this.permanentDependencies = permanentDependencies;
		this.permanentWeakDependencies = permanentWeakDependencies;
		this.instanceTargets = Collections.emptyList();
		this.instanceDependencies = Collections.emptyList();
		this.instanceWeakDependencies = Collections.emptyList();
		this.localMode = localMode;
		this.packageMode = packageMode;
	}

	/**
	 * This method can be used by subclasses to retrieve the local mode of this meta-annotation instance's metaprogram.
	 * 
	 * @return The local mode.
	 */
	protected MetaprogramLocalMode retrieveLocalMode()
	{
		return this.localMode;
	}

	/**
	 * This method can be used by subclasses to change the local mode of this meta-annotation instance's metaprogram.
	 * 
	 * @param localMode The new local mode.
	 */
	protected void changeLocalMode(MetaprogramLocalMode localMode)
	{
		this.localMode = localMode;
	}

	/**
	 * This method can be used by subclasses to retrieve the package mode of this meta-annotation instance's
	 * metaprogram.
	 * 
	 * @return The package mode.
	 */
	protected MetaprogramPackageMode retrievePackageMode()
	{
		return this.packageMode;
	}

	/**
	 * This method can be used by subclasses to change the package mode of this meta-annotation instance's metaprogram.
	 * 
	 * @param packageMode The new package mode.
	 */
	protected void changePackageMode(MetaprogramPackageMode packageMode)
	{
		this.packageMode = packageMode;
	}

	/**
	 * This method can be used by subclasses to retrieve the list of supplementary targets in which this meta-annotation
	 * instance's metaprogram participates. This method is typically called by an annotation property getter of the
	 * subclass to wire that property to this functionality.
	 * 
	 * @return The list of instance targets that will be to used.
	 */
	protected List<String> retrieveInstanceTargets()
	{
		return this.instanceTargets;
	}

	/**
	 * This method can be used by subclasses to indicate a list of supplementary targets in which this meta-annotation
	 * instance's metaprogram participates. This method is typically called by an annotation property setter of the
	 * subclass to wire that property to this functionality.
	 * 
	 * @param list The list of instance targets to use.
	 */
	protected void changeInstanceTargets(List<String> list)
	{
		this.instanceTargets = list;
	}

	/**
	 * This method can be used by subclasses to retrieve the list of supplementary dependencies in which this
	 * meta-annotation instance's metaprogram participates. This method is typically called by an annotation property
	 * getter of the subclass to wire that property to this functionality.
	 * 
	 * @return The list of instance dependencies that will be to used.
	 */
	protected List<String> retrieveInstanceDependencies()
	{
		return this.instanceDependencies;
	}

	/**
	 * This method can be used by subclasses to indicate a list of supplementary dependencies in which this
	 * meta-annotation instance's metaprogram participates. This method is typically called by an annotation property
	 * setter of the subclass to wire that property to this functionality.
	 * 
	 * @param list The list of instance dependencies to use.
	 */
	protected void changeInstanceDependencies(List<String> list)
	{
		this.instanceDependencies = list;
	}

	/**
	 * This method can be used by subclasses to retrieve the list of supplementary weak dependencies in which this
	 * meta-annotation instance's metaprogram participates. This method is typically called by an annotation property
	 * getter of the subclass to wire that property to this functionality.
	 * 
	 * @return The list of instance weak dependencies that will be to used.
	 */
	protected List<String> retrieveInstanceWeakDependencies()
	{
		return this.instanceWeakDependencies;
	}

	/**
	 * This method can be used by subclasses to indicate a list of supplementary weak dependencies in which this
	 * meta-annotation instance's metaprogram participates. This method is typically called by an annotation property
	 * setter of the subclass to wire that property to this functionality.
	 * 
	 * @param list The list of instance weak dependencies to use.
	 */
	protected void changeInstanceWeakDependencies(List<String> list)
	{
		this.instanceWeakDependencies = list;
	}

	/**
	 * This method is called by the metaprogram returned by this class when it is executed. Subclasses should implement
	 * the logic of their specific metaprograms here.
	 * 
	 * @param context The context of the metaprogram's execution.
	 */
	protected abstract void execute(Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context);

	@Override
	public BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> getMetaprogram()
	{
		final List<String> targets = new ArrayList<String>();
		targets.addAll(this.permanentTargets);
		targets.addAll(this.instanceTargets);

		final List<String> dependencies = new ArrayList<String>();
		dependencies.addAll(this.permanentDependencies);
		dependencies.addAll(this.instanceDependencies);

		final List<String> weakDependencies = new ArrayList<String>();
		weakDependencies.addAll(this.permanentWeakDependencies);
		weakDependencies.addAll(this.instanceWeakDependencies);

		final MetaprogramLocalMode localMode = this.localMode;

		final MetaprogramPackageMode packageMode = this.packageMode;

		return new BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode>()
		{

			@Override
			public void execute(Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode> context)
			{
				AbstractBsjMetaAnnotationMetaprogram.this.execute(context);
			}

			@Override
			public List<String> getDependencies()
			{
				return dependencies;
			}

			@Override
			public List<String> getWeakDependencies()
			{
				return weakDependencies;
			}

			@Override
			public MetaprogramLocalMode getLocalMode()
			{
				return localMode;
			}

			@Override
			public MetaprogramPackageMode getPackageMode()
			{
				return packageMode;
			}

			@Override
			public List<String> getTargets()
			{
				return targets;
			}
		};
	}

}
