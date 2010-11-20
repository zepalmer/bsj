package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeBodyNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.lang.element.BsjExecutableElement;

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
			DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean eager,
			boolean prohibitsOverlap, OverlapMode overlapMode)
	{
		super(SymbolType.METHOD, deferenceMaps, diagnosticListener, eager, prohibitsOverlap);
		this.overlapMode = overlapMode;
	}

	@Override
	protected void notifyNewKey(ErasedMethodSignature key)
	{
		super.notifyNewKey(key);
		if (this.overlapMode == OverlapMode.BY_NAME)
		{
		    // TODO: this is incorrect 
		    // 1. it's breaking method overloading
		    // 2. it's inefficient
		    // Instead, a scheme by which the name itself is recorded in this class should be used; the superclass
		    // should have a template method for ascertaining whether or not a missing key should be found in the
		    // deference map.  By default, that template method returns true; for MethodNamespaceMap, it returns true
		    // if and only if the key in question has a name which is not in the blocked name set.  That set would be
		    // updated here.
		    // For now, this is commented out as it only really serves to fix code of the form:
		    //    public class C {
		    //        public void foo() { }
		    //        public class D {
		    //            public void foo(int i) { }
		    //            public void bar() { foo(); }
		    //        }
		    //    }
		    // According to the JLS, bar() should not compile because it refers to a foo() which has been hidden by
		    // the nearer foo even though their signatures differ.
		    
		    // Below: the broken mechanism
//			for (ErasedMethodSignature signature : this.getKeys())
//			{
//				if (!signature.equals(key) && signature.getName().equals(key.getName()))
//				{
//					// Same name but different signature.  Block it.
//					getBlockedKeySet().add(signature);
//				}
//			}
		}
	}

	@Override
	protected boolean isAmbiguous(ErasedMethodSignature key, Collection<? extends BsjExecutableElement> values)
	{
		// A method is only ambiguous if there is more than one method with that signature which *has a body*.
		// This should only be possible if, for example, multiple static imports bring in a method with the same
		// signature. It is also possible if two methods with the same signature are simply declared in the same place.
		// It is not possible through standard use of inheritance or nesting.
		return values.size() > 1 && hasBody(values.iterator().next().getDeclarationNode());
	}
	
	private boolean hasBody(Node decl)
	{
		if (decl instanceof InitializerDeclarationNode)
		{
			return true;
		} else if (decl instanceof ConstructorDeclarationNode)
		{
			return true;
		} else if (decl instanceof MethodDeclarationNode)
		{
			MethodDeclarationNode methodDeclarationNode = (MethodDeclarationNode)decl;
			if (methodDeclarationNode.getNearestAncestorOfType(TypeBodyNode.class) instanceof ClassBodyNode &&
					!methodDeclarationNode.getModifiers().getAbstractFlag())
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retrieves all elements of a given signature.  This method overrides the default implementation in order to
	 * provide disambiguating behavior.  If multiple elements exist in the namespace and at least one of those elements
	 * has a body, only those elements with a body are considered to be in the namespace.
	 */
	@Override
	public Collection<BsjExecutableElement> getValues(ErasedMethodSignature key)
	{
		Collection<BsjExecutableElement> result = super.getValues(key);
		Collection<BsjExecutableElement> resultWithBodies = new ArrayList<BsjExecutableElement>();
		for (BsjExecutableElement element : result)
		{
			if (hasBody(element.getDeclarationNode()))
			{
				resultWithBodies.add(element);
			}
		}
		if (resultWithBodies.size() > 0)
		{
			return resultWithBodies;
		} else
		{
			return result;
		}
	}

	/**
	 * Retrieves all elements of a given name.
	 * @param name The name of the elements to retrieve.
	 * @return The resulting elements.
	 */
	public Collection<BsjExecutableElement> getValues(String name)
	{
		Set<BsjExecutableElement> ret = new HashSet<BsjExecutableElement>();
		for (ErasedMethodSignature signature : this.getKeys())
		{
			if (signature.getName().equals(name))
			{
				ret.addAll(getValues(signature));
			}
		}
		return ret;
	}
	
	
}
