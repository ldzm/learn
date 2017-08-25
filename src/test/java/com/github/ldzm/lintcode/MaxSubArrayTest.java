package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MaxSubArrayTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MaxSubArrayTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MaxSubArrayTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMedian()
    {
    	MaxSubArray maxSubArray = new MaxSubArray();
    	
		int[] nums = {-2,2,-3,4,-1,2,1,-5,3};

		
        assertTrue(maxSubArray.maxSubArray(nums) == 6 );
    }
}
