package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy.PopulationRecord;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

public class PopulationRecordImpl<K,V extends BsjElement> implements PopulationRecord<K, V>
{
    private K key;
    private V value;
    private Node indicator;

    public PopulationRecordImpl(K key, V value, Node indicator)
    {
        super();
        this.key = key;
        this.value = value;
        this.indicator = indicator;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    public Node getIndicator()
    {
        return indicator;
    }
}