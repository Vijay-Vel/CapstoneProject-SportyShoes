package com.sportyshoe.SeleniumScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {
	
	@FindBy(xpath="//a[@id=\"shoe101\"]")
	WebElement viewShoeBTN;
	
	@FindBy(xpath = "//a[@id='cart101']")
	WebElement addtocartBTN;
	
	@FindBy(xpath="//div[@class='alert alert-success']/descendant::p[1]")
	WebElement successText;
	
	JavascriptExecutor executor;
	
	public AddtoCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor) driver;
		
	}
	
	public void add_product_to_cart() throws InterruptedException
	{
		
		
		executor.executeScript("arguments[0].click();", addtocartBTN);
	
	
	}
	
	public String validate_success_message()
	{
		
		String successtext = successText.getText();
		return successtext;
		
	}

}
