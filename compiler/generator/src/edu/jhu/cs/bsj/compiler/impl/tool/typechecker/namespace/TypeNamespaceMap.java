package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.BsjTypeCheckerDiagnostic;

/**
 * A mapping which is used to represent a type namespace. This is a mapping from simple names to the type declarations
 * to which they refer.  The intention of this class is to permit its use in tracking namespace scope.
 * <p/>
 * It is possible for a single key to be mapped to multiple declarations. In this case, the mapping itself is
 * ambiguous and a diagnostic message may be generated. Each map reports errors in either an <i>eager</i> map or a
 * <i>lazy</i> fashion; eager error reporting causes ambiguities to be raised immediately while lazy reporting causes
 * them to be raised whenever the corresponding key is accessed. In either event, an arbitrary but consistent value is
 * always returned in order to permit type-checking to continue.
 * <p/>
 * This namespace map may cascade its requests into other namespaces; that is, new namespaces may be built on top of
 * existing namespaces.  This allows, for example, on-demand imports to be overridden by single-type imports.  If a
 * type namespace map does not have a correct answer, it refers to some deference map.  If no deference map is present,
 * <code>null</code> is returned.
 * 
 * @author Zachary Palmer
 */
public class TypeNamespaceMap
{
	/** The backing data structure which acts as this map's data store. */
	private Map<String, TypeNamespaceEntry> backingMap;
	/** The deference map, or <code>null</code> if no deference map is available. */
	private TypeNamespaceMap deferenceMap;
	/** The diagnostic listener to which to report errors. */
	private DiagnosticListener<BsjSourceLocation> diagnosticListener;
	/** The factory used to create errors for ambiguous entries. */
	private AmbiguousDiagnosticFactory factory;
	/** Whether or not this map reports errors eagerly. */
	private boolean eager;
	
	public TypeNamespaceMap(DiagnosticListener<BsjSourceLocation> diagnosticListener, AmbiguousDiagnosticFactory factory, boolean eager)
	{
		this(null, diagnosticListener, factory, eager);
	}
	
	public TypeNamespaceMap(TypeNamespaceMap deferenceMap, DiagnosticListener<BsjSourceLocation> diagnosticListener, AmbiguousDiagnosticFactory factory, boolean eager)
	{
		super();
		this.backingMap = new HashMap<String, TypeNamespaceEntry>();
		this.deferenceMap = deferenceMap;
		this.diagnosticListener = diagnosticListener;
		this.factory = factory;
		this.eager = eager;
	}
	
	public void add(String name, NamedTypeDeclarationNode<?> typeDeclaration, Node indicator)
	{
		TypeNamespaceEntry entry = this.backingMap.get(name);
		if (entry==null)
		{
			entry = new TypeNamespaceEntry(typeDeclaration, indicator);
			this.backingMap.put(name, entry);
		} else
		{
			entry.add(typeDeclaration, indicator);
		}
		if (this.eager)
		{
			BsjTypeCheckerDiagnostic diagnostic = factory.makeDiagnostic(name, entry, indicator.getStartLocation());
			if (diagnostic != null)
			{
				this.diagnosticListener.report(diagnostic);
			}
		}
	}
	
	public NamedTypeDeclarationNode<?> lookup(String name, BsjSourceLocation sourceLocation)
	{
		if (this.backingMap.containsKey(name))
		{
			TypeNamespaceEntry entry = this.backingMap.get(name);
			if (!this.eager)
			{
				BsjTypeCheckerDiagnostic diagnostic = factory.makeDiagnostic(name, entry, sourceLocation);
				if (diagnostic != null)
				{
					this.diagnosticListener.report(diagnostic);
				}
			}
			return entry.getFirstType();
		} else if (this.deferenceMap != null)
		{
			return this.deferenceMap.lookup(name, sourceLocation);
		} else
		{
			return null;
		}
	}
}
