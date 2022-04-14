package com.revature.revspace.cucumberupload;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.messages.types.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;



/**
 * Unit test for simple App.
 */
public class AppTest 
extends TestCase
{
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
public AppTest( String testN )
{
    super( );
}

/**
 * @return the suite of tests being tested
 */
public static Test suite()
{
    return new TestSuite( AppTest.class );
}

/**
 * Rigourous Test :-)
 */
public void testApp()
{
    assertTrue( true );
}
}