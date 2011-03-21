package edu.jhu.cs.bsj.compiler.impl.ast;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;

/**
 * A utilities class for operations related to lists.
 * 
 * @author Zachary Palmer
 */
public class ListNodeUtilities
{
    private ListNodeUtilities()
    {        
    }

    /**
     * Determines whether or not a given element is ordered in a given list.
     * 
     * @param <T> The type of element contained in the list.
     * @param element The element in question.
     * @param list The list in question.
     * @return <code>true</code> if that element's order is significant; <code>false</code> if it is not.
     */
    public static <T extends Node> boolean isOrderedElement(NodeUnion<? extends T> element, ListNode<T> list)
    {
        return list.getAlwaysOrdered() || (element.getNodeValue() instanceof InitializerDeclarationNode);
    }
}
