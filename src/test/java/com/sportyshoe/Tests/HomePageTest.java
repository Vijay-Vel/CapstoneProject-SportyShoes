package com.sportyshoe.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sportyshoe.SeleniumScripts.HomePage;
import com.sportyshoe.SeleniumScripts.TestBase;

public class HomePageTest extends TestBase {

	HomePage hp;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new HomePage(driver);
	}
	
	
	@Test(priority='1')
	public void test_getTitle_page()
	{
		String expected = "http://localhost:9010/";
		String Actual = hp.getURL_page();
		Assert.assertEquals(Actual, expected);
		
	}
	
	@Test(priority='2')
	
	public void Test_Validate_Text_On_Page()
	{
		String expected = "Powered By Simplilearn";
		String actualText = hp.Validate_Text_On_Page();
		Assert.assertEquals(actualText, expected);
	}

	@Test(priority='3')
	public void test_click_register_link() throws InterruptedException
	{
		Thread.sleep(1500);
		hp.click_register_link();
	}
	@AfterTest
	public void close_browser()
	{
		driver.close();
	}

}
