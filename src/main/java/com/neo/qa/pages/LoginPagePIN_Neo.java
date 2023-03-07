package com.neo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neo.qa.base.TestbaseClass;

public class LoginPagePIN_Neo extends TestbaseClass {
	@FindBy (xpath="//input[@id='txt_accesspin']") WebElement pin;
	@FindBy (xpath="//a[contains(text(),'Submit')]") WebElement submitBtn;
	public LoginPagePIN_Neo()
	{
		PageFactory.initElements(driver ,this);
	}
	//get title of password /Pin Page
	public String getTitleOfPIN_Page()
	{
		return driver.getTitle();
	}
	//enter PIN
	public void enterPin(String PIN)
	{
		pin.sendKeys(PIN);
	}
	//Click On submit
	public MainPanelPage clickOnsubmitButton() throws InterruptedException
	{
		Thread.sleep(2000);
		submitBtn.click();
		return new MainPanelPage();
	}
}
