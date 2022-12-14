package com.tests;

import org.apache.commons.collections4.iterators.SkippingIterator;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Pages.LoginPage1;
import com.base.BaseClass;

public class LoginTest extends BaseClass {
	 LoginPage1 lp = null;
	@BeforeSuite
	public void setup() throws Exception {
		initialization();
		lp=new LoginPage1(driver);
		
	}
	@Test
	public void test01() {
		lp.loginToApplication("kiran@gmail.com", "123456");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void test02() {
	
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard1");
	}
	@Test
	public void test03() {
	  throw new SkipException("skipping testcase");
	  
	}
}
