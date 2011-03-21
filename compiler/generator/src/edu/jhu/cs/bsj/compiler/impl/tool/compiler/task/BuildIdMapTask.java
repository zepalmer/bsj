package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PackageNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilerUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

/**
 * This task is intended to construct a mapping between the UIDs of nodes which appear in the initial tree and the nodes
 * themselves.
 * 
 * @author Zachary Palmer
 */
public class BuildIdMapTask extends AbstractBsjCompilerTask
{
    /**
     * Performs a sanity check for the compiler.
     */
    public BuildIdMapTask()
    {
        super(TaskPriority.BUILD_ID_MAP);
    }

    @Override
    public void execute(final MetacompilationContext context) throws IOException
    {
        // Address the root package
        context.getIdMap().put(context.getRootPackage().getUid(), context.getRootPackage());
        // Address its recursive subpackages
        Iterator<PackageNode> pIt = ((PackageNodeImpl) context.getRootPackage()).getRecursivePackageIterator();
        while (pIt.hasNext())
        {
            PackageNode p = pIt.next();
            context.getIdMap().put(p.getUid(), p);
        }
        // Address the compilation units and onward
        Iterator<CompilationUnitNode> cIt = context.getRootPackage().getCompilationUnitIterator();
        while (cIt.hasNext())
        {
            context.getIdMap().putAll(CompilerUtilities.buildTreeIdMap(cIt.next()));
        }
    }
}
