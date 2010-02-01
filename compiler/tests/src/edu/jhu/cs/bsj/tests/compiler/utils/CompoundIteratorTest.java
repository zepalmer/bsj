package edu.jhu.cs.bsj.tests.compiler.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterator;

public class CompoundIteratorTest
{
	@Test
	public void test()
	{
		List<Iterator<? extends String>> strings = new ArrayList<Iterator<? extends String>>();
		strings.add(Arrays.asList("a", "b").iterator());
		strings.add(Collections.<String>emptyList().iterator());
		strings.add(Arrays.asList("c").iterator());
		
		CompoundIterator<String> compoundIterator = new CompoundIterator<String>(strings.iterator());
		Assert.assertEquals(true, compoundIterator.hasNext());
		Assert.assertEquals("a", compoundIterator.next());
		Assert.assertEquals(true, compoundIterator.hasNext());
		Assert.assertEquals("b", compoundIterator.next());
		Assert.assertEquals(true, compoundIterator.hasNext());
		Assert.assertEquals("c", compoundIterator.next());
		Assert.assertEquals(false, compoundIterator.hasNext());
	}
}
