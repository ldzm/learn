package com.github.ldzm.lintcode;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class QuickSortTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuickSortTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( QuickSortTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testQuickSort()
    {
    	QuickSort quickSort = new QuickSort();
    	
		int[] nums = {5, 4, 3, 2};
		int [] expected = {2, 3, 4, 5};
		
		quickSort.sortIntegers2(nums);
		
        assertTrue( Arrays.equals(nums, expected) );
    }
}
