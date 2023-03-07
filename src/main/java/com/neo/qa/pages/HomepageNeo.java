package com.neo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neo.qa.base.TestbaseClass;

public class HomepageNeo extends TestbaseClass {
	@FindBy (xpath="(//a[contains(text(),'Sign In')])[1]") WebElement signInBtn;
	@FindBy (xpath="//img[@class='navbar-brand']") WebElement logo;
	
	
public HomepageNeo()
{
	PageFactory.initElements(driver, this);
	}
//available logo on homepage
public boolean avaibleNeoStocksLogoOnHomepage()
{
	return logo.isDisplayed();
	}
//validate home page Title
public String getHomepageTitle()
{
	return driver.getTitle();
	}
//click on sign in link
public LoginPageMobile_Neo clickOnSignInLink()
{     signInBtn.click();
      return new LoginPageMobile_Neo();
	}
//



}
