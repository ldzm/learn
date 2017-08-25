package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class TwoSumTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TwoSumTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TwoSumTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testTwoSum()
    {
        int [] numbers = {2, 7, 11, 15};
        int [] expected = {1, 2};

    	TwoSum twoSum = new TwoSum();

    	assertTrue(Arrays.equals(expected, twoSum.twoSum(numbers, 9)));
    }

}
