package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a package in a BSJ object program's namespace.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjPackage
{
    /**
     * Gets the simple name of this package.
     * @return The simple name of this package.
     */
    public String getName();

    /**
     * Gets the subpackages of this package.
     * @return The subpackages of this package.
     */
    public List<BsjPackage> getSubpackages();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjPackage deepCopy(BsjNodeFactory factory);
}
