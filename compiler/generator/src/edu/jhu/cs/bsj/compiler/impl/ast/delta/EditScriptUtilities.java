package edu.jhu.cs.bsj.compiler.impl.ast.delta;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This utilities class contains functionality related to edit scripts.
 * 
 * @author Zachary Palmer
 */
public class EditScriptUtilities
{
    private EditScriptUtilities()
    {
    }

    /**
     * Creates from a list of node unions a list of UIDs. Each node union's value's UID is extracted and put into a new
     * list.
     * 
     * @param list The list of node unions.
     * @return A list containing the UIDs of those unions.
     */
    public static <T extends NodeUnion<?>> List<Long> getNodeUnionUids(List<T> list)
    {
        List<Long> ret = new ArrayList<Long>(list.size());
        for (NodeUnion<?> nodeUnion : list)
        {
            ret.add(nodeUnion.getNodeValue().getUid());
        }
        return ret;
    }

    /**
     * Creates from a list of nodes a list of UIDs. Each node's UID is extracted and put into a new list.
     * 
     * @param list The list of nodes.
     * @return A list containing the UIDs of those nodes.
     */
    public static List<Long> getNodeUids(List<? extends Node> list)
    {
        List<Long> ret = new ArrayList<Long>(list.size());
        for (Node node : list)
        {
            ret.add(node.getUid());
        }
        return ret;
    }
}
