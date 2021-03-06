/**
 * 
 */
package schooldomain.studentname.connecteddevices.labs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import neu.vishald.connecteddevices.labs.module01.SystemCpuUtilTask;

/**
 * Test class for all requisite Module01 functionality.
 * 
 * Instructions:
 * 1) Rename 'testSomething()' method such that 'Something' is specific to your needs; add others as needed, beginning each method with 'test...()'.
 * 2) Add the '@Test' annotation to each new 'test...()' method you add.
 * 3) Import the relevant modules and classes to support your tests.
 * 4) Run this class as unit test app
 * 5) Include a screen shot of the report when you submit your assignment
 */
public class Module01Test
{
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void testCPU()
	{
		SystemCpuUtilTask myobj = new SystemCpuUtilTask();
		assertTrue(myobj.getCPU() >= 0.0);
		assertTrue(myobj.getCPU() <= 100.0);
	}
	
	@Test
	public void testMem()
	{
		SystemCpuUtilTask myobj = new SystemCpuUtilTask();
		assertTrue(myobj.getCPU() >= 0.0);
		assertTrue(myobj.getCPU() <= 100.0);
	}
	
}
