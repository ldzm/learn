package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class KthLargestElementTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KthLargestElementTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KthLargestElementTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testKthLargestElement()
    {
    	KthLargestElement kthLargestElement = new KthLargestElement();
    	int[] nums = {9,3,2,4,8,10};
        assertTrue( kthLargestElement.kthLargestElement(3, nums) == 8 );
    }
}
