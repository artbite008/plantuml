package com.ebay.plantumlgen.random;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author denOfProgramming
 *
 */
public class DefaultRandomNumberGeneratorTest
{

    private RandomGenerator randomGenerator;

    @Before
    public void setUp()
    {
	randomGenerator = new DefaultRandomNumberGenerator();
    }

    @After
    public void after()
    {
	randomGenerator = null;
    }

    @Test
    public void testName()
    {
	Assert.assertSame("Name is not the same as expected: ", "Default Random Number Generator", randomGenerator.name());
    }

    @Ignore
    @Test
    public void testRandomGenerator()
    {
	int generatedInt = ((DefaultRandomNumberGenerator)randomGenerator).generateNumber();
	assertTrue("Generated int was not between 5 and 10: ", generatedInt >= 5 && generatedInt <= 10);
    }

}
