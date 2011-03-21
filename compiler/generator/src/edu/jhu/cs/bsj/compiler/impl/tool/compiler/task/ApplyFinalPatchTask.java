package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScript;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilerUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;

/**
 * This task applies the final patch using all of the deltas from all metaprograms that executed.
 * 
 * @author Zachary Palmer
 */
public class ApplyFinalPatchTask extends AbstractBsjCompilerTask
{
    private static final Logger LOGGER = Logger.getLogger(ApplyFinalPatchTask.class);

    /**
     * Performs a sanity check for the compiler.
     */
    public ApplyFinalPatchTask()
    {
        super(TaskPriority.BUILD_ID_MAP);
    }

    @Override
    public void execute(final MetacompilationContext context) throws IOException
    {
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Applying final patch to proxy of initial tree.");
        }

        final BsjNodeProxyFactory proxyFactory = new BsjNodeProxyFactoryImpl(context.getNodeManager());
        List<EditScript> editScripts = context.getDependencyManager().getFinalEditScriptDependencies();
        CompilerUtilities.patchTree(editScripts, context.getDependencyManager(), context.getToolkit().getNodeFactory(),
                proxyFactory, context.getIdMap(), context.getNodeManager().getMetaprogramExecutionStack(),
                context.getNodeManager().getCompilationUnitLoader(), context.getDiagnosticListener());

        PackageNode rootPackage = proxyFactory.makePackageNode(context.getRootPackage());

        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Final patch complete.  Code for each source unit is as follows:");
            Iterator<CompilationUnitNode> it = rootPackage.getRecursiveCompilationUnitIterator();
            while (it.hasNext())
            {
                CompilationUnitNode c = it.next();
                if (c.isBinary())
                    continue;
                final String fqn = ((PackageNode) c.getParent()).getFullyQualifiedName();
                LOGGER.trace("    " + (fqn.length() == 0 ? "" : (fqn + ".")) + c.getName() + ":");
                for (String s : c.toSourceCode().split("\n"))
                {
                    LOGGER.trace("        " + s);
                }
            }
            LOGGER.trace("Queuing cleanup tasks.");
        }

        Iterator<CompilationUnitNode> it = rootPackage.getRecursiveCompilationUnitIterator();
        while (it.hasNext())
        {
            CompilationUnitNode node = it.next();
            if (!node.isBinary())
            {
                context.registerTask(new ReplaceCodeLiteralsTask(node));
                context.registerTask(new StripBsjNodesTask(node));
                context.registerTask(new SourceSerializationTask(node));
            }
        }
        context.registerTask(new SanityCheckTask(rootPackage));
    }
}
