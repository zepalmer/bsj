package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker.AmbiguousSymbolNameDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

/**
 * A mapping which is used to represent a namespace. This is a mapping from simple names to the declarations to which
 * they refer. In other words, instances of this class represent the symbol tables in a given scope.
 * <p/>
 * It is possible for a single key to be mapped to multiple declarations. In this case, the mapping itself is ambiguous
 * and a diagnostic message may be generated. Each map reports errors in either an <i>eager</i> map or a <i>lazy</i>
 * fashion; eager error reporting causes ambiguities to be raised immediately while lazy reporting causes them to be
 * raised whenever the corresponding key is accessed. In either event, an arbitrary but consistent value is always
 * returned in order to permit type-checking to continue.
 * <p/>
 * This namespace map may cascade its requests into other namespaces; that is, new namespaces may be built on top of
 * existing namespaces. This allows, for example, on-demand imports to be overridden by single-type imports. If a
 * namespace map does not have a mapping, it refers to some deference map. If no deference map is present,
 * <code>null</code> is returned.
 * <p/>
 * Because of internal error reporting requirements, {@link NamespaceMap} is not instantiated directly. Instead, the
 * static methods beginning with <code>make</code> on this class should be used.
 * 
 * @author Zachary Palmer
 */
public class NamespaceMap<T extends BsjElement>
{
	/** The symbol type for this map. */
	private SymbolType symbolType;
	/** The backing data structure which acts as this map's data store. */
	private Map<String, NamespaceEntry<T>> backingMap;
	/** The deference map, or <code>null</code> if no deference map is available. */
	private NamespaceMap<? extends T> deferenceMap;
	/** The diagnostic listener to which to report errors. */
	private DiagnosticListener<BsjSourceLocation> diagnosticListener;
	/** Whether or not this map reports errors eagerly. */
	private boolean eager;
	/** Whether or not this environment is locked. */
	private boolean locked;

	protected NamespaceMap(SymbolType symbolType, NamespaceMap<? extends T> deferenceMap,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean eager)
	{
		super();
		this.symbolType = symbolType;
		this.backingMap = new HashMap<String, NamespaceEntry<T>>();
		this.deferenceMap = deferenceMap;
		this.diagnosticListener = diagnosticListener;
		this.eager = eager;
		this.locked = false;
	}
	
	/**
	 * Locks this namespace.  A locked namespace cannot be modified; any attempts to do so produce a runtime error.
	 */
	public void lock()
	{
		this.locked = true;
		if (this.deferenceMap != null && !this.deferenceMap.locked)
			this.deferenceMap.lock();
	}

	/**
	 * Adds a new name to this namespace map.
	 * 
	 * @param name The name to add.
	 * @param element The type element to which the name corresponds.
	 * @param indicator The node which was responsible for indicating this mapping.
	 * @throws IllegalStateException If this environment has been locked.
	 */
	public void add(String name, T element, Node indicator)
	{
		if (this.locked)
			throw new IllegalStateException("Attempted to modify locked namespace map");
		
		NamespaceEntry<T> entry = this.backingMap.get(name);
		if (entry == null)
		{
			entry = new NamespaceEntry<T>(element, indicator);
			this.backingMap.put(name, entry);
		} else
		{
			entry.add(element, indicator);
		}
		if (this.eager && entry.getValues().size() > 1)
		{
			this.diagnosticListener.report(new AmbiguousSymbolNameDiagnosticImpl(indicator.getStartLocation(), name,
					this.symbolType, entry.getIndicatorNodeMap().keySet()));
		}
	}

	/**
	 * Retrieves a type element based on a name in this namespace.
	 * 
	 * @param name The name to use.
	 * @param sourceLocation The source location of the node which indicates this name.
	 * @return The corresponding type element.
	 */
	public T lookup(String name, BsjSourceLocation sourceLocation)
	{
		if (this.backingMap.containsKey(name))
		{
			NamespaceEntry<T> entry = this.backingMap.get(name);
			if (!this.eager && entry.getValues().size() > 1)
			{
				this.diagnosticListener.report(new AmbiguousSymbolNameDiagnosticImpl(sourceLocation, name,
						this.symbolType, entry.getIndicatorNodeMap().keySet()));
			}
			return entry.getFirstValue();
		} else if (this.deferenceMap != null)
		{
			return this.deferenceMap.lookup(name, sourceLocation);
		} else
		{
			return null;
		}
	}

	/**
	 * Determines whether or not this type namespace is transparent. A transparent type namespace does not add any
	 * information over its backing namespace. This is a relatively trivial property which indicates that no name
	 * mappings have been added. This may happen if, for example, the body of a method does not declare any local
	 * classes; in that case, the type namespace created for the method body would be transparent (and thus
	 * discardable).
	 * 
	 * @return <code>true</code> if this namespace is transparent; <code>false</code> if it is not.
	 */
	public boolean isTransparent()
	{
		return this.backingMap.size() == 0;
	}

	/**
	 * This method implements a high-performance, low-assurance check to determine whether or not this map and the
	 * provided map are equivalent. If this method returns <code>true</code>, such an action is always legal; if this
	 * method returns <code>false</code>, such an action <i>might</i> not be. That is, this method does not define an
	 * equivalence relation because it may return <code>false</code> for equivalent values. It is not necessarily
	 * transitive or symmetric. It is written to execute using few CPU resources by capturing the most common cases of
	 * equivalence in this type checker.
	 */
	public boolean definitelyReplacableBy(NamespaceMap<T> other)
	{
		if (this.deferenceMap == other && this.isTransparent() && this.deferenceMap.locked && this.locked)
			return true;

		return false;
	}
	
	/**
	 * Creates a string representation of this namespace.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		NamespaceMap<? extends T> map = this;
		while (map != null)
		{
			renderString(map, sb);
			map = map.deferenceMap;
		}
		sb.insert(0, '{');
		sb.append('}');
		return sb.toString();
	}

	private static <E extends BsjElement> void renderString(NamespaceMap<E> map, StringBuilder sb)
	{
		for (Map.Entry<String, NamespaceEntry<E>> entry : map.backingMap.entrySet())
		{
			if (sb.length()>0)
			{
				sb.append(", ");
			}
			sb.append(entry.getKey());
			sb.append(" -> ");
			if (entry.getValue().getValues().size()>1)
			{
				sb.append("{");
				boolean first = true;
				for (BsjElement element : entry.getValue().getValues())
				{
					if (!first)
						sb.append(", ");
					sb.append(element.getDeclarationNode().getStartLocation());
					first = false;
				}
				sb.append("}");
			} else
			{
				sb.append(entry.getValue().getValues().iterator().next().getDeclarationNode().getStartLocation());
			}
		}
	}
}
