package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FindMinTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FindMinTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FindMinTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFindMin()
    {
        int [] data = {6,1,2,3,4,5};
        assertTrue(new FindMin().findMin(data) == 1);
    }
}
