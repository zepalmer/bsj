package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.MetaprogramExecutionStack;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction.ExplicitMetaprogramCompilationCache;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction.MetaprogramExtractor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BsjCompilerTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BuildIdMapTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.ExecuteMetaprogramTask;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.CanonicalNodeInfo;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.InjectionInfo;
import edu.jhu.cs.bsj.compiler.impl.utils.BijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * This class represents the data structure which manages metacompilation from post-parsing up to and including source
 * generation. It tracks the progress which has been made on a given compilation unit and, indirectly, any data
 * specifically associated with it (such as its AST). The manager maintains work in the form of a priority queue and is
 * not finished until all of the work units in the priority queue have been exhausted. Once a compilation unit manager
 * reports that its work is complete, all compilation units have been meta-compiled; the resulting generated source must
 * still be compiled as Java source to finish BSJ compilation.
 * 
 * @author Zachary Palmer
 */
public class MetacompilationManager implements MetacompilationContext
{
    /** A counter for the UID of the next metacompilation manager. */
    private static final AtomicInteger NEXT_UID = new AtomicInteger(0);

    /** A logger for this metacompilation manager. */
    private static final Logger LOGGER = Logger.getLogger(MetacompilationManager.class);

    /**
     * The UID of this manager.
     */
    private int uid;

    /**
     * Represents the work queue. Work to be performed is enqueued here. The queue is prioritized to allow preemption of
     * more basic tasks (such as when the type checker or metacompiler brings in another source unit for parsing).
     */
    private Queue<BsjCompilerTask> priorityQueue;
    /**
     * The toolkit to use to satisfy tool requirements.
     */
    private BsjToolkit toolkit;
    /**
     * The node manager to use.
     */
    private BsjNodeManager nodeManager;
    /**
     * The package node listener we are using to notice new compilation units.
     */
    private PackageNodeListener packageNodeListener;
    /**
     * The listener to which we will report events.
     */
    private CountingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener;

    /**
     * Represents the metaprogram dependency manager.
     */
    private DependencyManager dependencyManager;
    /**
     * The root package used during this compilation process.
     */
    private PackageNode rootPackage;
    /**
     * The ID map from node UIDs to the nodes themselves in the initial tree.
     */
    private Map<Long, Node> nodeIdMap;

    /**
     * The list of source files that this metacompilation manager has serialized.
     */
    private List<BsjFileObject> serializedFiles;
    
    /**
     * A mapping from canonical anchor node IDs to the classes which were compiled for them.
     */
    private ExplicitMetaprogramCompilationCache explicitMetaprogramCompilationCache;

    /**
     * Creates a new compilation unit manager.
     * 
     * @param toolkit The toolkit to use.
     * @param nodeManager The node manager to use.
     * @param rootPackage The root package to use.
     * @param diagnosticListener The listener to which diagnostics will be reported. Must not be <code>null</code>.
     * @param random A random number generator used to select the order in which operations are performed. If
     *            <code>null</code>, operations are performed in an arbitrary order. This generator can be used to
     *            produce repeatable compilation passes over the same source code. This is intended for debugging
     *            purposes and reduces the performance of the metacompiler somewhat.
     */
    public MetacompilationManager(BsjToolkit toolkit, BsjNodeManager nodeManager, PackageNode rootPackage,
            DiagnosticListener<BsjSourceLocation> diagnosticListener, Random random)
    {
        this.uid = NEXT_UID.getAndIncrement();

        this.priorityQueue = new PriorityQueue<BsjCompilerTask>();
        this.dependencyManager = new DependencyManager(random);

        this.toolkit = toolkit;
        this.nodeManager = nodeManager;
        this.packageNodeListener = new PackageNodeListener();
        this.diagnosticListener = new CountingDiagnosticProxyListener<BsjSourceLocation>(diagnosticListener);

        this.rootPackage = rootPackage;
        this.serializedFiles = new ArrayList<BsjFileObject>();
        this.nodeIdMap = new HashMap<Long, Node>();
        
        this.explicitMetaprogramCompilationCache = new ExplicitMetaprogramCompilationCache();

        // Whenever a new compilation unit is parsed, ensure that it is handled correctly
        this.nodeManager.getPackageNodeManager().addListener(packageNodeListener);

        // Add some initial tasks to the task queue
        this.priorityQueue.offer(new BuildIdMapTask());
        this.priorityQueue.offer(new ExecuteMetaprogramTask());
    }

    /**
     * Adds a task to this manager.
     * 
     * @param task The task to add.
     */
    public void registerTask(BsjCompilerTask task)
    {
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("[MM#" + this.uid + "] Received compiler task " + task);
        }
        this.priorityQueue.offer(task);
    }

    /**
     * Determines whether or not work on this manager is finished.
     * 
     * @return <code>true</code> if work on this manager is finished; <code>false</code> if there is more work to do.
     */
    public boolean isFinished()
    {
        return this.priorityQueue.size() == 0;
    }

    /**
     * Instructs this compilation unit manager to do more work.
     * 
     * @throws IOException If an I/O error occurs.
     * @throws IllegalStateException If no more work exists to be done.
     */
    public void doWork() throws IOException, IllegalStateException
    {
        if (this.priorityQueue.size() == 0)
        {
            throw new IllegalStateException("No more work to do!");
        }

        BsjCompilerTask task = this.priorityQueue.poll();
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("[MM#" + this.uid + "] Executing next compilation task: " + task.toString());
        }

        task.execute(this);
        if (this.getDiagnosticListener().getCount(Kind.ERROR) > 0)
        {
            // TODO: more clever approach: continue executing unrelated tasks until we run out
            // Dump all remaining tasks from the queue
            this.priorityQueue.clear();
        }
    }

    /**
     * Retrieves the number of errors which have occurred during metacompilation.
     */
    public int getErrorCount()
    {
        return this.diagnosticListener.getCount(Kind.ERROR);
    }

    public BsjToolkit getToolkit()
    {
        return toolkit;
    }

    public BsjNodeManager getNodeManager()
    {
        return nodeManager;
    }

    public CountingDiagnosticProxyListener<BsjSourceLocation> getDiagnosticListener()
    {
        return diagnosticListener;
    }

    public PackageNode getRootPackage()
    {
        return rootPackage;
    }

    @Override
    public Map<Long, Node> getIdMap()
    {
        return this.nodeIdMap;
    }

    @Override
    public DependencyManager getDependencyManager()
    {
        return this.dependencyManager;
    }

    public List<BsjFileObject> getSerializedFiles()
    {
        return serializedFiles;
    }

    @Override
    public ExplicitMetaprogramCompilationCache getExplicitMetaprogramCompilationCache()
    {
        return explicitMetaprogramCompilationCache;
    }

    @Override
    public void addSerializedFile(BsjFileObject file)
    {
        this.serializedFiles.add(file);
    }

    /**
     * Detaches this metacompilation manager from any of the resources it is holding. This method should always be
     * called when the creator has finished with this manager, as it is necessary to prevent invasive listeners from
     * causing problems.
     */
    public void cleanup()
    {
        this.nodeManager.getPackageNodeManager().removeListener(packageNodeListener);
    }

    /**
     * Used to observe changes to packages in order to properly generate meta-annotation objects, extract metaprograms,
     * and so on.
     */
    private class PackageNodeListener implements edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeListener
    {
        @Override
        public void compilationUnitLoaded(PackageNode packageNode, CompilationUnitNode compilationUnitNode,
                BijectiveMap<Long, Long> canonicalLookupMap)
        {
            // If this is a binary, it didn't have any metaprograms in it anyway
            if (compilationUnitNode.isBinary())
                return;

            // Determine the canonical UID of this compilation unit
            long canonicalUid = compilationUnitNode.getUid();
            BsjNodeProxyFactory proxyFactory = MetacompilationManager.this.nodeManager.getMetaprogramExecutionStack().getProxyFactory();
            if (proxyFactory != null && proxyFactory.getProxyIdMapping().containsKey(canonicalUid))
            {
                canonicalUid = proxyFactory.getProxyIdMapping().get(canonicalUid);
            }

            // React to the addition of a new compilation unit by including it in the metacompilation process.
            CanonicalNodeInfo canonicalNodeInfo;
            if (canonicalLookupMap == null)
            {
                canonicalNodeInfo = null;
            } else
            {
                canonicalNodeInfo = new CanonicalNodeInfo(canonicalLookupMap,
                        MetacompilationManager.this.getNodeManager().getCompilationUnitLoader().getUidMap());
            }
            InjectionInfo injectionInfo = new InjectionInfo(
                    MetacompilationManager.this.getNodeManager().getCurrentMetaprogram(), false);
            MetaprogramExecutionStack.Element executionStackElement = new MetaprogramExecutionStack.Element(null, null,
                    null, null, null);
            MetacompilationManager.this.getNodeManager().getMetaprogramExecutionStack().push(executionStackElement);
            try
            {
                MetaprogramExtractor extractor = new MetaprogramExtractor(
                        MetacompilationManager.this, compilationUnitNode, injectionInfo, canonicalNodeInfo);
                Collection<MetaprogramAnchorNode<?>> anchors = extractor.extract();
                CompilerUtilities.postprocessExtractedAnchors(anchors);
            } catch (IOException e)
            {
                throw new NotImplementedYetException(e);
            } finally
            {
                MetacompilationManager.this.getNodeManager().getMetaprogramExecutionStack().pop(executionStackElement);
            }
        }
    }

}