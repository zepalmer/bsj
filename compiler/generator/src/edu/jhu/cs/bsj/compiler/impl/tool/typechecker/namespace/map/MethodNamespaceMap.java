package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjExecutableElement;

/**
 * This class defines a namespace map for method elements. TODO
 * 
 * @author Zachary Palmer
 */
public class MethodNamespaceMap extends NamespaceMap<ErasedMethodSignature, BsjExecutableElement>
{
	public static enum OverlapMode
	{
		/**
		 * Indicates that, when a new entry is added, all old entries with the same name are shadowed. This mode is used
		 * for most scopes. Consider, for example, the following code:
		 * 
		 * <pre>
		 * class A
		 * {
		 * 	public void foo()
		 * 	{
		 * 	}
		 * 
		 * 	class B
		 * 	{
		 * 		public void foo(int a)
		 * 		{
		 * 		}
		 * 
		 * 		public void bar()
		 * 		{
		 * 			foo(); // failure here!
		 * 		}
		 * 	}
		 * }
		 * </pre>
		 * 
		 * The failure indicated by the comment is caused by the fact that the class <tt>B</tt> introduces a new method
		 * named <tt>foo</tt> (even though it has a different signature).
		 * <p/>
		 * From the <i>Java Language Specification, Third Edition</i> in &#xA7;6.3.1, <blockquote> A declaration
		 * <i>d</i> of a method named <i>n</i> shadows the declarations of any other methods named <i>n</i> that are in
		 * an enclosing scope at the point where <i>d</i> occurs throughout the scope of <i>d</i>. </blockquote> Observe
		 * that the shadowing here occurs on the basis of name alone and not on the basis of overload-compatible
		 * signatures.
		 */
		BY_NAME,
		/**
		 * Indicates that, when a new entry is added, it only shadows old entries with overload-compatible signatures.
		 * This mode is used in inheritance. For example, consider the following code:
		 * 
		 * <pre>
		 * class A
		 * {
		 * 	public void foo()
		 * 	{
		 * 	}
		 * 
		 * 	public void foo(int a)
		 * 	{
		 * 	}
		 * }
		 * 
		 * class B extends A
		 * {
		 * 	public void foo(int a)
		 * 	{
		 * 	}
		 * }
		 * 
		 * class C extends B
		 * {
		 * 	public void bar()
		 * 	{
		 * 		this.foo(); // works fine!
		 * 	}
		 * }
		 * </pre>
		 * 
		 * The commented line invokes the method which appears on the class <tt>A</tt> without difficulty. This is
		 * because the <tt>foo</tt> method of <tt>b</tt> shadows the overload of <tt>foo</tt> on <tt>A</tt> that takes a
		 * single <tt>int</tt> as a parameter but it does not shadow the no-arguments version.
		 */
		BY_SIGNATURE
	}

	private OverlapMode overlapMode;

	public MethodNamespaceMap(Collection<MethodNamespaceMap> deferenceMaps,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean eager, OverlapMode overlapMode)
	{
		super(SymbolType.METHOD, deferenceMaps, diagnosticListener, eager, false);
		this.overlapMode = overlapMode;
	}

	@Override
	protected void removeOld(ErasedMethodSignature name, Map<ErasedMethodSignature, Entry<BsjExecutableElement>> oldMap)
	{
		switch (this.overlapMode)
		{
			case BY_NAME:
				Iterator<ErasedMethodSignature> keyIterator = oldMap.keySet().iterator();
				while (keyIterator.hasNext())
				{
					ErasedMethodSignature key = keyIterator.next();
					if (key.getName().equals(name.getName()))
					{
						keyIterator.remove();
					}
				}
				break;
			case BY_SIGNATURE:
				super.removeOld(name, oldMap);
				break;
		}
	}

	@Override
	protected void considerAmbiguity(ErasedMethodSignature name, BsjSourceLocation sourceLocation)
	{
		// TODO: override to provide methods with their own notion of ambiguity
		// A method is only ambiguous if there is more than one method with that signature which has a body.
		// This should only be possible if, for example, multiple static imports bring in a method with the same
		// signature. It is also possible if two methods with the same signature are simply declared in the same place.
		// It is not possible through standard use of inheritance or nesting.
		super.considerAmbiguity(name, sourceLocation);
	}
}
