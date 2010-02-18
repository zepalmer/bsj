/**
 * This source file is used to test the behavior of the BSJ compiler for ambiguous name categorization.
 * @author Zachary Palmer
 */
public class NameCategorizationTestCode
{
	public int x = (x=2) * 2;
	public void foo()
	{
		int x = (x=2) * 2; // thanks to the JLS for this crazy example
	}
	
	// The following allows us to test ambiguous name categorization with respect to this problem
	static class Foo
	{
		public Foo y = this;
		public Foo ident(Foo foo)
		{
			return foo;
		}
	}
	
	public Foo z = (z = new Foo()).ident(z.y);
	public void foo2()
	{
		Foo z = (z = new Foo()).ident(z.y);
		
		Foo a = new Foo(), b = (b = new Foo()).ident(a.y);
	}
	
	public void foo3()
	{
		Foo a = new Foo();
		{
			Foo b = a.y;
		}
	}
	
	public void foo4()
	{
		for (Foo a = new Foo(); a.y instanceof Foo; a = a.y)
		{
			System.out.println(a.y);
			break;
		}
	}
	
	public void foo5()
	{
		for (Foo z : new Foo[]{z.y, new Foo()})
		{
			System.out.println(z.y);
		}
	}
	
	public void foo6(Foo arg)
	{
		System.out.println(arg.y);
	}
	
	public NameCategorizationTestCode()
	{
	}
	
	public NameCategorizationTestCode(Foo f)
	{
		System.out.println(f.y);
	}
}