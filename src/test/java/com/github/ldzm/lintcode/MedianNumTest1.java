package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MedianNumTest1 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MedianNumTest1( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MedianNumTest1.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMedian()
    {
    	MedianNum medianNum = new MedianNum();
    	int[] nums = {4, 5, 1, 2, 3};
    	int[] nums2 = {7, 9, 4, 5};
        assertTrue( medianNum.median(nums) == 3 );
        assertTrue( medianNum.median(nums2) == 5 );
    }
}
