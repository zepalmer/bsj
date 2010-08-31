package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

/**
 * Represents the type value for entities in the BSJ language which typecheck correctly but do not have a type
 * themselves, such as import statements or meta-annotation anchors.
 * @author Zachary Palmer
 */
public interface BsjNoneNoType extends BsjNoType
{
}
