package edu.jhu.cs.bsj.compiler.metaprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementGetter;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotationElementSetter;

/**
 * This implementation of {@link BsjMetaprogramMetaAnnotation} provides basic functionality which is commonly necessary
 * for meta-annotations which define metaprograms. It provides an inner class for the implementation of the returned
 * metaprogram that depends upon the abstract methods of this class for its functionality. Specifically, execution of
 * the metaprogram can be defined in the {@link #execute(Context) execute} method.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractBsjMetaprogramMetaAnnotation implements BsjMetaprogramMetaAnnotation
{
    /** The permanent targets that this meta-annotation metaprogram always uses. */
    private List<String> permanentTargets;
    /** The permanent dependencies that this meta-annotation metaprogram always has. */
    private List<String> permanentDependencies;
    /** The permanent weak dependencies that this meta-annotation metaprogram always has. */
    private List<String> permanentWeakDependencies;

    /** The targets that this particular meta-annotation instance uses. */
    private IdentifierNode[] instanceTargets;
    /** The dependencies that this particular meta-annotation instance uses. */
    private NameNode[] instanceDependencies;

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
    public AbstractBsjMetaprogramMetaAnnotation(List<String> permanentTargets, List<String> permanentDependencies)
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
    public AbstractBsjMetaprogramMetaAnnotation(List<String> permanentTargets, List<String> permanentDependencies,
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
    public AbstractBsjMetaprogramMetaAnnotation(List<String> permanentTargets, List<String> permanentDependencies,
            List<String> permanentWeakDependencies, MetaprogramLocalMode localMode, MetaprogramPackageMode packageMode)
    {
        this.permanentTargets = permanentTargets;
        this.permanentDependencies = permanentDependencies;
        this.permanentWeakDependencies = permanentWeakDependencies;
        this.instanceTargets = new IdentifierNode[0];
        this.instanceDependencies = new NameNode[0];
        this.localMode = localMode;
        this.packageMode = packageMode;
    }

    @BsjMetaAnnotationElementGetter
    public IdentifierNode[] getTargets()
    {
        return this.instanceTargets;
    }

    @BsjMetaAnnotationElementSetter
    public void setTargets(IdentifierNode[] targets)
    {
        this.instanceTargets = targets;
    }

    @BsjMetaAnnotationElementGetter
    public NameNode[] getDepends()
    {
        return this.instanceDependencies;
    }

    @BsjMetaAnnotationElementSetter
    public void setDepends(NameNode[] depends)
    {
        this.instanceDependencies = depends;
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
     * This method is called by the metaprogram returned by this class when it is executed. Subclasses should implement
     * the logic of their specific metaprograms here.
     * 
     * @param context The context of the metaprogram's execution.
     */
    protected abstract void execute(
            Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context);

    @Override
    public BsjMetaAnnotationMetaprogram getMetaprogram()
    {
        final List<String> targets = new ArrayList<String>();
        targets.addAll(this.permanentTargets);
        for (IdentifierNode id : this.instanceTargets)
            targets.add(id.getIdentifier());

        final List<String> dependencies = new ArrayList<String>();
        dependencies.addAll(this.permanentDependencies);
        for (NameNode name : this.instanceDependencies)
            dependencies.add(name.getNameString());

        final List<String> weakDependencies = new ArrayList<String>();
        weakDependencies.addAll(this.permanentWeakDependencies);

        final MetaprogramLocalMode localMode = this.localMode;

        final MetaprogramPackageMode packageMode = this.packageMode;

        return new BsjMetaAnnotationMetaprogram()
        {

            @Override
            public void execute(MetaAnnotationContext context)
            {
                AbstractBsjMetaprogramMetaAnnotation.this.execute(context);
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
