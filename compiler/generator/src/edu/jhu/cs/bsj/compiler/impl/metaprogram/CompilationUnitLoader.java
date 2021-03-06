package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject.Kind;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.MetaprogramExecutionStack;
import edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeUtilities;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PackageNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.BsjBinaryNodeLoader;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilerUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * This utility class is used by {@link PackageNodeImpl} solely because the nuances of code generation are a pain. The
 * complex logic of compilation unit loading is kept here to allow its manipulation in an IDE.
 * 
 * @author Zachary Palmer
 */
public class CompilationUnitLoader
{
    private static final Logger LOGGER = Logger.getLogger(CompilationUnitLoader.class);

    /** The toolkit to back the requested operations. */
    private BsjToolkit toolkit;
    /** The node manager which controls the nodes. */
    private BsjNodeManager nodeManager;
    /** A mapping from the UIDs of loaded compilation units and their children to the nodes themselves. */
    private Map<Long, Node> loadNodeMap = new HashMap<Long, Node>();
    /** A returnable version of the <tt>loadNodeMap</tt>. */
    private Map<Long, Node> returnableLoadNodeMap = Collections.unmodifiableMap(this.loadNodeMap);

    public CompilationUnitLoader(BsjToolkit toolkit, BsjNodeManager nodeManager)
    {
        super();
        this.toolkit = toolkit;
        this.nodeManager = nodeManager;
    }

    private static class LoadCacheKey
    {
        private String fullyQualifiedPackageName;
        private String name;

        public LoadCacheKey(String fullyQualifiedPackageName, String name)
        {
            super();
            this.fullyQualifiedPackageName = fullyQualifiedPackageName;
            this.name = name;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((fullyQualifiedPackageName == null) ? 0 : fullyQualifiedPackageName.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            LoadCacheKey other = (LoadCacheKey) obj;
            if (name == null)
            {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (fullyQualifiedPackageName == null)
            {
                if (other.fullyQualifiedPackageName != null)
                    return false;
            } else if (!fullyQualifiedPackageName.equals(other.fullyQualifiedPackageName))
                return false;
            return true;
        }

        @Override
        public String toString()
        {
            return "(" + fullyQualifiedPackageName + "," + name + ")";
        }
    }

    private Map<LoadCacheKey, CompilationUnitNode> loadCache = new HashMap<LoadCacheKey, CompilationUnitNode>();

    public CompilationUnitNode load(String fullyQualifiedPackageName, String name, CompilationUnitLoadingInfo info)
    {
        MetaprogramExecutionStack.Element executionStackElement = new MetaprogramExecutionStack.Element(null, null,
                null, null, null);
        this.nodeManager.getMetaprogramExecutionStack().push(executionStackElement);
        try
        {
            return innerLoad(fullyQualifiedPackageName, name, info);
        } finally
        {
            this.nodeManager.getMetaprogramExecutionStack().pop(executionStackElement);
        }
    }

    private CompilationUnitNode innerLoad(String fullyQualifiedPackageName, String name, CompilationUnitLoadingInfo info)
    {
        if (fullyQualifiedPackageName == null)
        {
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("Ignoring request to load for a disconnected package.");
            }
            return null;
        }

        CompilationUnitNode compilationUnitNode = null;

        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Loading compilation unit " + name + " in package node \"" + fullyQualifiedPackageName + "\"");
        }

        // Check the loading cache
        LoadCacheKey key = new LoadCacheKey(fullyQualifiedPackageName, name);
        if (!this.loadCache.containsKey(key))
        {
            // Otherwise, we have to go searching
            for (BsjFileObject file : PackageNodeUtilities.findCompilationUnits(this.toolkit.getFileManager(),
                    fullyQualifiedPackageName, false))
            {
                if (PackageNodeUtilities.getCompilationUnitName(file).equals(name))
                {
                    compilationUnitNode = actualLoad(name, info.getDiagnosticListener(), file);
                    break;
                }
            }
            this.loadCache.put(key, compilationUnitNode);
            if (compilationUnitNode != null)
            {
                // set up the node map for this unit
                Map<Long, Node> uidMap = CompilerUtilities.buildTreeIdMap(compilationUnitNode);
                this.loadNodeMap.putAll(uidMap);
            }
        } else
        {
            compilationUnitNode = this.loadCache.get(key);
        }

        if (compilationUnitNode == null)
        {
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("No such compilation unit " + name + " exists in package node \""
                        + fullyQualifiedPackageName + "\"");
            }
        } else
        {
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("Completed load of compilation unit " + name + " in package node "
                        + fullyQualifiedPackageName);
            }
        }

        return compilationUnitNode;
    }

    /**
     * Requests the load of a single compilation unit.
     * 
     * @param name The name of the compilation unit.
     * @param diagnosticListener The listener to which errors will be reported.
     * @param file The file from which to load the compilation unit.
     * @return The compilation unit if it was loaded; <code>null</code> if it could not be loaded.
     */
    private CompilationUnitNode actualLoad(String name, DiagnosticListener<BsjSourceLocation> diagnosticListener,
            BsjFileObject file)
    {
        // Try to load the compilation unit.
        MetaprogramExecutionStack.Element executionStackElement = new MetaprogramExecutionStack.Element(null, null,
                null,  null, null);
        try
        {
            this.nodeManager.getMetaprogramExecutionStack().push(executionStackElement);
            CompilationUnitNode compilationUnitNode;
            if (file.getKind() == Kind.CLASS)
            {
                BsjBinaryNodeLoader loader = new BsjBinaryNodeLoader(this.toolkit.getNodeFactory());
                compilationUnitNode = loader.loadNodesFromBinary(file);
            } else
            {
                compilationUnitNode = this.toolkit.getParser().parse(name, file.openReader(true), diagnosticListener);
            }

            return compilationUnitNode;
        } catch (IOException e)
        {
            // TODO: how to handle this?
            throw new NotImplementedYetException(e);
        } finally
        {
            this.nodeManager.getMetaprogramExecutionStack().pop(executionStackElement);
        }
    }

    /**
     * Lists all of the compilation units which appear to be in the specified package.
     * 
     * @param packageNode The package node making the request.
     * @param binaryOnly <code>true</code> if only binaries should be listed; <code>false</code> if sources should be
     *            listed as well.
     * @return An iterator over the names of the compilation units in the package.
     */
    public List<String> listCompilationUnitNames(PackageNode packageNode, boolean binaryOnly)
    {
        String pname = packageNode.getFullyQualifiedName();
        if (pname == null)
        {
            return Collections.<String> emptyList();
        }

        List<String> names = new ArrayList<String>();
        for (BsjFileObject file : PackageNodeUtilities.findCompilationUnits(toolkit.getFileManager(), pname, binaryOnly))
        {
            names.add(PackageNodeUtilities.getCompilationUnitName(file));
        }
        return names;
    }

    /**
     * Obtains the UID map for a given compilation unit node by that node's UID.
     * 
     * @param uid The UID of the compilation unit.
     * @return The mapping in question or <code>null</code> if no such mapping exists.
     */
    public Map<Long, Node> getUidMap()
    {
        return this.returnableLoadNodeMap;
    }

    /**
     * An interface for callback objects to implement when they wish to receive notification of loaded compilation
     * units.
     */
    public static interface Listener
    {
        /**
         * Indicates that a compilation unit was loaded.
         */
        public void compilationUnitLoaded(String fullyQualifiedPackageName, CompilationUnitNode node);
    }
}
