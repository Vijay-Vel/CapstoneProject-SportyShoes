package com.sportyshoe.Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sportyshoe.SeleniumScripts.HomePage;
import com.sportyshoe.SeleniumScripts.RegisterPage;
import com.sportyshoe.SeleniumScripts.TestBase;
import com.sportyshoe.Utilities.Xls_DataProvider;

public class RegisterPageTest extends TestBase {
	
	HomePage hp;
	RegisterPage rp;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
	}

	
	@Test(priority='1')
	public void test_click_register_link() throws InterruptedException
	{
		Thread.sleep(1500);
		hp.click_register_link();
	}
	
	@Test(priority='2')
	public void test_getTitle_page()
	{
		String expected = "http://localhost:9010/register";
		String Actual = hp.getURL_page();
		Assert.assertEquals(Actual, expected);
		
	}
	
	@Test(priority='3', dataProvider="LoginDetails")
	public void Test_register_user(String name, String email, String password)
	{
		rp.register_user(name, email, password);
	}
	
	@Test(priority='4')
	public void Test_validate_registration_URL()
	{
		String expected = "http://localhost:9010/register-user";
		String Actual = rp.validate_registration_URL();
		assertEquals(Actual, expected);
	}
	
@Test(priority='5')
	
	public void Test_validate_registration_Text()
	{
		String expected = "Hello vijay !";
		String actualText = rp.validate_registration_Text();
		Assert.assertEquals(actualText, expected);
	}
	@DataProvider(name="LoginDetails")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
	
		Object[] [] input = Xls_DataProvider.getTestData("Sheet1");
		return input;
	
	}

}
