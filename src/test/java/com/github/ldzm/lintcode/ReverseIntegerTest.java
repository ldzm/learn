package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class ReverseIntegerTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReverseIntegerTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReverseIntegerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testReverseInteger()
    {
        int data = 10;
        int expected = 1;

        ReverseInteger reverseInteger = new ReverseInteger();

    	assertTrue(expected == reverseInteger.reverseInteger(data));
    }

}
