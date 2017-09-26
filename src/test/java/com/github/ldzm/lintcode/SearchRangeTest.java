package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class SearchRangeTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SearchRangeTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SearchRangeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSearchRange()
    {
        int[] data = {5, 7, 7, 8, 8, 10};
        int target = 8;
        assertTrue(Arrays.equals(SearchRange.searchRange(data, target), new int[] {3, 4}));
    }

    public void testSearchRangeException()
    {
        int[] data = {5, 5, 5};
        int target = 5;
        assertTrue(Arrays.equals(SearchRange.searchRange(data, target), new int[] {0, 2}));
    }
}
