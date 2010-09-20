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
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListSpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class TypeArgumentListSpliceNodeImpl extends SpliceNodeImpl implements TypeArgumentListSpliceNode
{
    /** General constructor. */
    public TypeArgumentListSpliceNodeImpl(
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
    public List<TypeArgumentNode> getChildren()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"children\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeArgumentListSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeTypeArgumentListSpliceNode(
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
    	public Iterator<TypeArgumentNode> iterator()
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
    	public boolean add(TypeArgumentNode e)
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
    	public boolean addAll(Collection<? extends TypeArgumentNode> c)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean addAll(int index, Collection<? extends TypeArgumentNode> c)
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
    	public TypeArgumentNode get(int index)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public TypeArgumentNode set(int index, TypeArgumentNode element)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public void add(int index, TypeArgumentNode element)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public TypeArgumentNode remove(int index)
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
    	public ListIterator<TypeArgumentNode> listIterator()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public ListIterator<TypeArgumentNode> listIterator(int index)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public List<TypeArgumentNode> subList(int fromIndex, int toIndex)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }	
    
    	@Override
    	public void addFirst(TypeArgumentNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addLast(TypeArgumentNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addBefore(TypeArgumentNode member, TypeArgumentNode node) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addAfter(TypeArgumentNode member, TypeArgumentNode node) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public boolean remove(TypeArgumentNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeArgumentNode getFirst()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeArgumentNode getLast()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeArgumentNode getBefore(TypeArgumentNode member) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeArgumentNode getAfter(TypeArgumentNode member) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public Set<TypeArgumentNode> filter(NodeFilter<? super TypeArgumentNode> filter)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    /** Raises an exception. */
    public Class<TypeArgumentNode> getElementType()
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
}
