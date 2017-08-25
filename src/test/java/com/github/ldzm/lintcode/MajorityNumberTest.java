package com.github.ldzm.lintcode;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MajorityNumberTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MajorityNumberTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MajorityNumberTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMajorityNumber()
    {
    	MajorityNumber majorityNumber = new MajorityNumber();
    	
    	int [] nums = {1,1,1,1,2,2,2};
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		
    	assertTrue(majorityNumber.majorityNumber(list) == 1);
    }
}
