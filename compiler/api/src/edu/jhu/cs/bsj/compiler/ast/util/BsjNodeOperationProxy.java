/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast.util;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;

/**
 * This is a convenience class which assumes that no checked exceptions will be
 * raised by this operation.
 *
 * @author Zachary Palmer
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjNodeOperationProxy<POrig,ROrig,PNew,RNew> extends BsjAbortableNodeOperationProxy<POrig,ROrig,PNew,RNew,RuntimeException> implements BsjNodeOperation<PNew,RNew>
{
/**
 * Creates a new node operation proxy.
 * @param backingOp The backing operation to proxy.
 */
public BsjNodeOperationProxy(BsjNodeOperation<POrig,ROrig> backingOp)
{
    super(backingOp);
}

}
