package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.Element;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.BsjTypeCheckerDiagnostic;

/**
 * A mapping which is used to represent a namespace. This is a mapping from simple names to the declarations
 * to which they refer. In other words, instances of this class represent the symbol tables in a given scope.
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
 * 
 * @author Zachary Palmer
 */
public class NamespaceMap<T extends Element>
{
	/** The backing data structure which acts as this map's data store. */
	private Map<String, NamespaceEntry<T>> backingMap;
	/** The deference map, or <code>null</code> if no deference map is available. */
	private NamespaceMap<? extends T> deferenceMap;
	/** The diagnostic listener to which to report errors. */
	private DiagnosticListener<BsjSourceLocation> diagnosticListener;
	/** The factory used to create errors for ambiguous entries. */
	private AmbiguousDiagnosticFactory<? super T> ambiguousDiagnosticFactory;
	/** Whether or not this map reports errors eagerly. */
	private boolean eager;

	public NamespaceMap(DiagnosticListener<BsjSourceLocation> diagnosticListener,
			AmbiguousDiagnosticFactory<? super T> factory, boolean eager)
	{
		this(null, diagnosticListener, factory, eager);
	}

	public NamespaceMap(NamespaceMap<? extends T> deferenceMap, DiagnosticListener<BsjSourceLocation> diagnosticListener,
			AmbiguousDiagnosticFactory<? super T> factory, boolean eager)
	{
		super();
		this.backingMap = new HashMap<String, NamespaceEntry<T>>();
		this.deferenceMap = deferenceMap;
		this.diagnosticListener = diagnosticListener;
		this.ambiguousDiagnosticFactory = factory;
		this.eager = eager;
	}

	/**
	 * Adds a new name to this namespace map.
	 * 
	 * @param name The name to add.
	 * @param element The type element to which the name corresponds.
	 * @param indicator The node which was responsible for indicating this mapping.
	 */
	public void add(String name, T element, Node indicator)
	{
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
			BsjTypeCheckerDiagnostic diagnostic = ambiguousDiagnosticFactory.makeDiagnostic(name, entry, indicator.getStartLocation());
			if (diagnostic != null)
			{
				this.diagnosticListener.report(diagnostic);
			}
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
				BsjTypeCheckerDiagnostic diagnostic = ambiguousDiagnosticFactory.makeDiagnostic(name, entry, sourceLocation);
				if (diagnostic != null)
				{
					this.diagnosticListener.report(diagnostic);
				}
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
		if (this.deferenceMap == other && this.isTransparent())
			return true;

		return false;
	}
}
