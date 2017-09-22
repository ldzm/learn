package com.github.ldzm.algorithm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class BaseConversionTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BaseConversionTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BaseConversionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testConversion()
    {
        assertTrue(arrayListEquals(BaseConversion.conversion(20, 8), 2, 4));
        assertTrue(arrayListEquals(BaseConversion.conversion(0, 8), 0));
        assertTrue(arrayListEquals(BaseConversion.conversion(1, 8), 1));
        assertTrue(arrayListEquals(BaseConversion.conversion(8, 8), 1, 0));
    }

    private boolean arrayListEquals(List<Integer> list, int ... args) {

        for(int i = 0; i < list.size(); i++) {
            if(list.get(list.size() - i - 1) != args[i]) {
                return false;
            }
        }
        return true;
    }
}
