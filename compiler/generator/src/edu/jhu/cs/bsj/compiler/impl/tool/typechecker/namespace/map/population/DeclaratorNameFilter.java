package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;

public class DeclaratorNameFilter implements NodeFilter<VariableDeclaratorNode>
{
    private String name;

    public DeclaratorNameFilter(String name)
    {
        super();
        this.name = name;
    }

    @Override
    public boolean filter(VariableDeclaratorNode node)
    {
        return node.getIdentifier().getIdentifier().equals(this.name);
    }
}