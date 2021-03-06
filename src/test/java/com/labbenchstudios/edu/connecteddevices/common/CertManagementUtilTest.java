/**
 * Copyright (c) 2018-2019. Andrew D. King. All Rights Reserved.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.labbenchstudios.edu.connecteddevices.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.net.ssl.SSLSocketFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Simple test class for
 * {@link com.labbenchstudios.edu.connecteddevices.common.CertManagementUtil}.
 * 
 * @author aking
 */
public class CertManagementUtilTest
{
	// static
	
	/**
	 * NOTE: Copy a valid cert into the given file name, and uncomment
	 * the @Test annotation before {@link #testImportOfCertFromValidFile}
	 * to test.
	 */
	public static final String DIR_PREFIX = "./src/test/java/com/labbenchstudios/edu/connecteddevices/common/";
	
	public static final String TEST_VALID_CERT_FILE = DIR_PREFIX + "test_cert_validA.pem";
	public static final String TEST_INVALID_CERT_FILEA = DIR_PREFIX + "test_cert_emptyA.pem";
	public static final String TEST_INVALID_CERT_FILEB = DIR_PREFIX + "test_cert_emptyB.pem";
	public static final String TEST_INVALID_CERT_FILEC = DIR_PREFIX + "test_cert_emptyC.pem";
	public static final String TEST_MISSING_CERT_FILE = DIR_PREFIX + "non_existent_file.pem";
	
	
	// test methods
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		// make sure test files exist
		File validTestFile = new File(TEST_VALID_CERT_FILE);
		File invalidTestFileA = new File(TEST_INVALID_CERT_FILEA);
		File invalidTestFileB = new File(TEST_INVALID_CERT_FILEB);
		File invalidTestFileC = new File(TEST_INVALID_CERT_FILEC);
		File missingTestFile = new File(TEST_MISSING_CERT_FILE);
		
		// TODO: uncomment next LOC after copying a valid PEM file
		//assertTrue(validTestFile.exists());
		
		assertTrue(invalidTestFileA.exists());
		assertTrue(invalidTestFileB.exists());
		assertTrue(invalidTestFileC.exists());
		assertFalse(missingTestFile.exists());
	}
	
	/**
	 * Tests {@link CertManagementUtil} with a certificate file
	 * containing one or more certificates.
	 * <p>
	 * NOTE: To include in JUnit tests, uncomment the @Test annotation.
	 * 
	 */
//	@Test
	public void testImportOfCertFromValidFile()
	{
		CertManagementUtil certMgr = CertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_VALID_CERT_FILE);
		
		org.junit.Assert.assertNotNull(factory);
	}
	
	/**
	 * Tests {@link CertManagementUtil} with a null certificate file.
	 * 
	 */
	@Test
	public void testImportOfCertFromNullFile()
	{
		CertManagementUtil certMgr = CertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(null);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link CertManagementUtil} with an invalid certificate file
	 * containing only the BEGIN / END entries.
	 * 
	 */
	@Test
	public void testImportOfCertFromEmptyFileA()
	{
		CertManagementUtil certMgr = CertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_INVALID_CERT_FILEA);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link CertManagementUtil} with an invalid certificate file
	 * containing invalid text.
	 * 
	 */
	@Test
	public void testImportOfCertFromEmptyFileB()
	{
		CertManagementUtil certMgr = CertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_INVALID_CERT_FILEB);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link CertManagementUtil} with an empty certificate file.
	 * 
	 */
	@Test
	public void testImportOfCertFromEmptyFileC()
	{
		CertManagementUtil certMgr = CertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_INVALID_CERT_FILEC);
		
		org.junit.Assert.assertNull(factory);
	}
	
	/**
	 * Tests {@link CertManagementUtil} with a non-existent certificate file.
	 * 
	 */
	@Test
	public void testImportOfCertFromNonExistentFile()
	{
		CertManagementUtil certMgr = CertManagementUtil.getInstance();
		SSLSocketFactory   factory = certMgr.loadCertificate(TEST_MISSING_CERT_FILE);
		
		org.junit.Assert.assertNull(factory);
	}
}
