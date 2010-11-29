package edu.jhu.cs.bsj.invasion;

import java.lang.reflect.Method;

public class InvasionRun {
	public static void main(String[] args) throws Throwable {
		Class<?> c = Class
				.forName("edu.jhu.cs.oose.fall2010.invasion.ui.StandardInvasionMain");
		Method m = c.getMethod("main", String[].class);
		m.invoke(null, new Object[]{new String[]{}});
	}
}
