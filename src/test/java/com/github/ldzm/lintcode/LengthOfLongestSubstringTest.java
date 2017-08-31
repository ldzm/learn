package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LengthOfLongestSubstringTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LengthOfLongestSubstringTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LengthOfLongestSubstringTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testengthOfLongestSubstring()
    {
        String src = "gehmbfqmozbpripibusbezagafqtypz";
        String src2 = "abccabd";

    	assertTrue(9 == LengthOfLongestSubstring.lengthOfLongestSubstring(src));
        assertTrue(4 == LengthOfLongestSubstring.lengthOfLongestSubstring(src2));
    }

}
