package com.sportyshoe.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sportyshoe.SeleniumScripts.HomePage;
import com.sportyshoe.SeleniumScripts.LoginPage;
import com.sportyshoe.SeleniumScripts.OrderPage;
import com.sportyshoe.SeleniumScripts.RegisterPage;
import com.sportyshoe.SeleniumScripts.TestBase;
import com.sportyshoe.Utilities.Xls_DataProvider;

public class OrderPageTest extends TestBase {
	
	HomePage hp;
	RegisterPage rp;
	LoginPage lp;
	OrderPage op;
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
		lp = new LoginPage(driver);
		op = new OrderPage(driver);
	}

	
	@Test(priority='1', dataProvider="LoginDetails")
	public void test_login(String email, String password)
	{
		lp.user_login(email, password);
	}
	
	@Test(priority='2')

	public void test_click_orders()
	{
		op.click_orderPage();
	}

	
	@Test(priority='3')
	public void test_getTitle_page()
	{
		String expected = "http://localhost:9010/orders";
		String Actual = hp.getURL_page();
		Assert.assertEquals(Actual, expected);
		
	}
	@DataProvider(name="LoginDetails")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
	
		Object[] [] input = Xls_DataProvider.getTestData("Sheet2");
		return input;
	}
	

}
