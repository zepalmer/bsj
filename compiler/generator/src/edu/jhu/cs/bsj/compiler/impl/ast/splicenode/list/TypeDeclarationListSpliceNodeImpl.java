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
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListSpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class TypeDeclarationListSpliceNodeImpl extends SpliceNodeImpl implements TypeDeclarationListSpliceNode
{
    /** General constructor. */
    public TypeDeclarationListSpliceNodeImpl(
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
    public List<TypeDeclarationNode> getChildren()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"children\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeDeclarationListSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeTypeDeclarationListSpliceNode(
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
    	public Iterator<TypeDeclarationNode> iterator()
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
    	public boolean add(TypeDeclarationNode e)
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
    	public boolean addAll(Collection<? extends TypeDeclarationNode> c)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public boolean addAll(int index, Collection<? extends TypeDeclarationNode> c)
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
    	public TypeDeclarationNode get(int index)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public TypeDeclarationNode set(int index, TypeDeclarationNode element)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public void add(int index, TypeDeclarationNode element)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public TypeDeclarationNode remove(int index)
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
    	public ListIterator<TypeDeclarationNode> listIterator()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public ListIterator<TypeDeclarationNode> listIterator(int index)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }
    
    	@Override
    	public List<TypeDeclarationNode> subList(int fromIndex, int toIndex)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
        }	
    
    	@Override
    	public void addFirst(TypeDeclarationNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addLast(TypeDeclarationNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addBefore(TypeDeclarationNode member, TypeDeclarationNode node) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public void addAfter(TypeDeclarationNode member, TypeDeclarationNode node) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public boolean remove(TypeDeclarationNode node)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeDeclarationNode getFirst()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeDeclarationNode getLast()
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeDeclarationNode getBefore(TypeDeclarationNode member) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public TypeDeclarationNode getAfter(TypeDeclarationNode member) throws MetaprogramListMissingElementException
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    	@Override
    	public Set<TypeDeclarationNode> filter(NodeFilter<? super TypeDeclarationNode> filter)
    	{
            throw new SpliceNodeAccessException("Attempting to invoke List method on a splice node.");
    	}
    
    /** Raises an exception. */
    public Class<TypeDeclarationNode> getElementType()
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
}
