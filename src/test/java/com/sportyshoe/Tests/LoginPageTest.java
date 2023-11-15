package com.sportyshoe.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sportyshoe.SeleniumScripts.HomePage;
import com.sportyshoe.SeleniumScripts.LoginPage;
import com.sportyshoe.SeleniumScripts.RegisterPage;
import com.sportyshoe.SeleniumScripts.TestBase;
import com.sportyshoe.Utilities.Xls_DataProvider;

public class LoginPageTest extends TestBase {
	
	HomePage hp;
	RegisterPage rp;
	LoginPage lp;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
		lp = new LoginPage(driver);
	}

	
	@Test(priority='1', dataProvider="LoginDetails")
	public void test_login(String email, String password)
	{
		lp.user_login(email, password);
	}

	
	@Test(priority='2')
	public void test_getTitle_page()
	{
		String expected = "http://localhost:9010/login";
		String Actual = hp.getURL_page();
		Assert.assertEquals(Actual, expected);
		
	}
	
	@Test(priority='3')
	
	public void Test_validate_registration_Text()
	{
		String expected = "Hello vijay !";
		String actualText = rp.validate_registration_Text();
		Assert.assertEquals(actualText, expected);
	}


	@Test(priority='4')

	public void test_click_cart()
	{
		lp.click_cart();
	}
	
	@DataProvider(name="LoginDetails")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
	
		Object[] [] input = Xls_DataProvider.getTestData("Sheet2");
		return input;

	}
	@AfterTest
	public void close_browser()
	{
		driver.close();
	}

}
