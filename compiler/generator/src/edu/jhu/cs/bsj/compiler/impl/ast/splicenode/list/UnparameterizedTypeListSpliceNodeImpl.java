package edu.jhu.cs.bsj.compiler.impl.ast.splicenode.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.ast.exception.SpliceNodeAccessException;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListSpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnparameterizedTypeListSpliceNodeImpl extends SpliceNodeImpl implements UnparameterizedTypeListSpliceNode
{
    /** General constructor. */
    public UnparameterizedTypeListSpliceNodeImpl(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(spliceExpression, startLocation, stopLocation, manager, binary);
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public boolean getAlwaysOrdered()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"alwaysOrdered\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public List<UnparameterizedTypeNode> getChildren()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"children\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public UnparameterizedTypeListSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeUnparameterizedTypeListSpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
    	@Override
    	public int size()
    	{
    		throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public boolean isEmpty()
    	{
    		throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public boolean contains(Object o)
    	{
    		throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public Iterator<UnparameterizedTypeNode> iterator()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public Object[] toArray()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public <E> E[] toArray(E[] a)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean add(UnparameterizedTypeNode e)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean remove(Object o)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean containsAll(Collection<?> c)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean addAll(Collection<? extends UnparameterizedTypeNode> c)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean addAll(int index, Collection<? extends UnparameterizedTypeNode> c)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean removeAll(Collection<?> c)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean retainAll(Collection<?> c)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public void clear()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public UnparameterizedTypeNode get(int index)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public UnparameterizedTypeNode set(int index, UnparameterizedTypeNode element)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public void add(int index, UnparameterizedTypeNode element)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public UnparameterizedTypeNode remove(int index)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public int indexOf(Object o)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public int lastIndexOf(Object o)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public ListIterator<UnparameterizedTypeNode> listIterator()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public ListIterator<UnparameterizedTypeNode> listIterator(int index)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public List<UnparameterizedTypeNode> subList(int fromIndex, int toIndex)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }	
    
    	@Override
    	public void addFirst(UnparameterizedTypeNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addLast(UnparameterizedTypeNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addBefore(UnparameterizedTypeNode member, UnparameterizedTypeNode node) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addAfter(UnparameterizedTypeNode member, UnparameterizedTypeNode node) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public boolean remove(UnparameterizedTypeNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public UnparameterizedTypeNode getFirst()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public UnparameterizedTypeNode getLast()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public UnparameterizedTypeNode getBefore(UnparameterizedTypeNode member) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public UnparameterizedTypeNode getAfter(UnparameterizedTypeNode member) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public Set<UnparameterizedTypeNode> filter(NodeFilter<? super UnparameterizedTypeNode> filter)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    /** Raises an exception. */
    public Class<UnparameterizedTypeNode> getElementType()
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
}
