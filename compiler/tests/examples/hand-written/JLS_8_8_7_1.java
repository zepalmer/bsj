import Test.InSub;
import Test.Out;

/**
 * This class provides a simple demonstration of qualified superclass constructor invocation as witnessed in the JLS
 * &#xA7;8.8.7.1.
 * @author Zachary Palmer
 */
public class JLS_8_8_7_1
{
	static class Out
	{
		class In
		{
			In()
			{
			}
		}
	}
	
	static class InSub extends Out.In
	{
		public InSub(Out o)
		{
			o.super();
		}
	}
	
	public static void superclassConstructorInvocationTest()
	{
		new InSub(new Out());
	}
}