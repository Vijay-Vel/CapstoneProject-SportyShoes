package com.sportyshoe.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sportyshoe.SeleniumScripts.AddtoCartPage;
import com.sportyshoe.SeleniumScripts.HomePage;
import com.sportyshoe.SeleniumScripts.LoginPage;
import com.sportyshoe.SeleniumScripts.RegisterPage;
import com.sportyshoe.SeleniumScripts.TestBase;
import com.sportyshoe.Utilities.Xls_DataProvider;

public class AddtoCartPageTest extends TestBase{

	HomePage hp;
	RegisterPage rp;
	LoginPage lp;
	AddtoCartPage ac;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
		lp = new LoginPage(driver);
		ac = new AddtoCartPage(driver);
	}
	
	@Test(priority='1', dataProvider="LoginDetails")
	public void test_login(String email, String password)
	{
		lp.user_login(email, password);
	}
	

	@Test(priority='2')
	public void test_add_product_to_cart() throws InterruptedException
	{
		ac.add_product_to_cart();
	}
	
	@Test(priority='3')
	public void test_validate_success_message()
	{
		String expected = "Message:Shoe BlueWave Running Shoes Added Successfully to Cart";
	String actualText=	ac.validate_success_message();
	Assert.assertEquals(actualText, expected);
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
