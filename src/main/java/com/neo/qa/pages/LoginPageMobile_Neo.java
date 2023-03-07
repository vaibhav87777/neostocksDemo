package com.neo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neo.qa.base.TestbaseClass;

public class LoginPageMobile_Neo extends TestbaseClass {
	@FindBy(xpath="//input[@id='MainContent_signinsignup_txt_mobilenumber']") WebElement mobNum;
	@FindBy (xpath="//a[contains(text(),'Sign In')and @id='lnk_signup1']") WebElement signInBtn;
	
	public LoginPageMobile_Neo ()
	{
		PageFactory.initElements(driver, this);
	}
	//verify Title of sign in page
	public String getTitleSignInPage()
	{
		return driver.getTitle();
	}
	//enter Mobile Number to signin
	public void enterMobileNumber(String MN)
	{
		mobNum.sendKeys(MN);
		
	}
	//click on sign in button on sign in page
	public LoginPagePIN_Neo clickONsignInButton()
	{
		signInBtn.click();
		return new LoginPagePIN_Neo();
	}
	



}
