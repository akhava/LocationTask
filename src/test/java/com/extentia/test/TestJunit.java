package com.extentia.test;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TestJunit {

	@Test
	public void locationServiceTest() {
		assertNotNull(new LocationServiceTest().getLocationAddressTest("bavdhan"));
	}
	
	@Test
	public void locationTypeServiceTest() {
		assertNotNull(new LocationTypeServiceTest().getLocationTypeTest("18.5047", "73.7647", "bank"));
	}

}
