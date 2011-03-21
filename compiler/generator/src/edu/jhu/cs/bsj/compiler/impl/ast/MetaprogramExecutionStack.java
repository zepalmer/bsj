package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.List;
import java.util.Stack;

import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;

/**
 * Represents a stack of information. Each layer of the stack represents a single set of metaprogram execution utilities
 * and information. When the stack is empty, no metaprograms are running. This stack is primary maintained to permit
 * non-values to be pushed to allow the compiler to prevent some operations from being recorded.
 * 
 * @author Zachary Palmer
 */
public class MetaprogramExecutionStack
{
    /**
     * The stack of information.
     */
    private Stack<Element> stack = new Stack<Element>();

    /**
     * Pushes a metaprogram execution element onto the stack.
     * 
     * @param e The element to push.
     */
    public void push(Element e)
    {
        this.stack.push(e);
    }

    /**
     * Pops a metaprogram execution element from the stack. The caller must provide the correct element to pop (for
     * debugging purposes).
     * 
     * @param e The element to pop.
     */
    public void pop(Element e)
    {
        Element popped = this.stack.pop();
        if (popped != e)
        {
            throw new IllegalStateException("Attempted to pop " + e + " when " + popped + " was on top of the stack!");
        }
    }

    public PermissionPolicyManager getPermissionPolicyManager()
    {
        if (this.stack.size() == 0)
        {
            return null;
        }
        return this.stack.peek().getPermissionPolicyManager();
    }

    public DependencyManager getDependencyManager()
    {
        if (this.stack.size() == 0)
        {
            return null;
        }
        return this.stack.peek().getDependencyManager();
    }

    public MetaprogramProfile<?, ?> getCurrentMetaprogram()
    {
        if (this.stack.size() == 0)
        {
            return null;
        }
        return this.stack.peek().getCurrentMetaprogram();
    }

    public boolean isRecordingEdits()
    {
        if (this.stack.size() == 0)
        {
            return false;
        }
        return this.stack.peek().getRecordedEdits() != null;
    }

    public void recordEdit(EditScriptElement element)
    {
        if (this.stack.size() == 0)
        {
            return;
        }
        List<EditScriptElement> edits = this.stack.peek().getRecordedEdits();
        if (edits != null)
            edits.add(element);
    }

    public List<EditScriptElement> getRecordedEdits()
    {
        if (this.stack.size() == 0)
        {
            return null;
        }
        return this.stack.peek().getRecordedEdits();
    }

    public BsjNodeProxyFactory getProxyFactory()
    {
        if (this.stack.size() == 0)
        {
            return null;
        }
        return this.stack.peek().getProxyFactory();
    }

    /**
     * An element for the metaprogram execution stack.
     */
    public static class Element
    {
        private DependencyManager dependencyManager;
        private PermissionPolicyManager permissionPolicyManager;
        private MetaprogramProfile<?, ?> currentMetaprogram;
        private List<EditScriptElement> recordedEdits;
        private BsjNodeProxyFactory proxyFactory;

        /**
         * Creates a new stack element.
         * 
         * @param dependencyManager The dependency manager to use or <code>null</code> for no conflict detection.
         * @param permissionPolicyManager The permission policy manager to use or <code>null</code> for no policy
         *            enforcement.
         * @param currentMetaprogram The profile of the currently-executing metaprogram or <code>null</code> no
         *            metaprogram is running.
         * @param recordedEdits The list into which edits will be recorded or <code>null</code> not to record edits.
         * @param proxyFactory The proxy factory to use when loading compilation units or <code>null</code> not to use
         *            such a proxy factory.
         */
        public Element(DependencyManager dependencyManager, PermissionPolicyManager permissionPolicyManager,
                MetaprogramProfile<?, ?> currentMetaprogram, List<EditScriptElement> recordedEdits,
                BsjNodeProxyFactory proxyFactory)
        {
            super();
            this.dependencyManager = dependencyManager;
            this.permissionPolicyManager = permissionPolicyManager;
            this.currentMetaprogram = currentMetaprogram;
            this.recordedEdits = recordedEdits;
            this.proxyFactory = proxyFactory;
        }

        public DependencyManager getDependencyManager()
        {
            return dependencyManager;
        }

        public PermissionPolicyManager getPermissionPolicyManager()
        {
            return permissionPolicyManager;
        }

        public MetaprogramProfile<?, ?> getCurrentMetaprogram()
        {
            return currentMetaprogram;
        }

        public List<EditScriptElement> getRecordedEdits()
        {
            return recordedEdits;
        }

        public BsjNodeProxyFactory getProxyFactory()
        {
            return proxyFactory;
        }

        @Override
        public String toString()
        {
            return "Element [dependencyManager=" + dependencyManager + ", permissionPolicyManager="
                    + permissionPolicyManager + ", currentMetaprogram=" + currentMetaprogram + ", recordedEdits="
                    + recordedEdits + ", proxyFactory=" + proxyFactory + "]";
        }
    }
}
