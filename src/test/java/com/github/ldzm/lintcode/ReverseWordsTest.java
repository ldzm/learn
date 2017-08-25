package com.github.ldzm.lintcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class ReverseWordsTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReverseWordsTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReverseWordsTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testReverseWords()
    {
        String data = "hello world";

        String expected = "olleh dlrow";

        ReverseWords reverseWords = new ReverseWords();
        String result = reverseWords.reverseWords(data).trim();
        System.out.println(result.toString());
        assertTrue(result.equals(expected));
    }

    public void testReverseWords2()
    {
        String data = "hello world";

        String expected = "world hello";

        ReverseWords reverseWords = new ReverseWords();
        String result = reverseWords.reverseWords2(data).trim();
        System.out.println(result.toString());
        assertTrue(result.equals(expected));
    }
}
