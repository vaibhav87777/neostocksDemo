package com.neo.qa.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.neo.qa.base.TestbaseClass;
;

public class MainPanelPage extends TestbaseClass{
	Actions action;
	@FindBy(xpath="//a[contains(text(),'OK')and @class='btn btn-sm neobutton']") 
	WebElement OKBtnPopUp;
	
	@FindBy(xpath="//span[text()='Hi Vaibhav Thorat' and @id='lbl_username']") 
	WebElement profileNM;
	
	@FindBy(xpath="//div[text()='NIFTY 50' and @class='col-sm-4 ps-0 pe-0']")
	WebElement mainPagelabel;
	
	@FindBy(xpath="//img[@id='neostoxlogo']")
	WebElement neoStocksImg;
	
	@FindBy(xpath="//span[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//a[@id='navbarDropdown']")
	WebElement profileDropdown;
	
	@FindBy (xpath="//a[@id='tab_instrument']") 
	WebElement watcllistLink;
	
public MainPanelPage()
{ PageFactory.initElements(driver, this);
	}
	
//get Title Of Trade Panel Page
	public String getTitleOfMainPanelPage()
	{
		return driver.getTitle();
	}
// click On OK button of new feature Pop-up
	public void clickOnOKNewFeaturePopUP()
	{
		try {
			OKBtnPopUp.click();
		}
		catch(ElementNotInteractableException e){e.printStackTrace();}
		{}
	}
	//get profile name profile name
	public String getProfileName()
	{
		return profileNM.getText();
	}
	//get label on main page i.e. Nifty 50
	public String getLabelOnMainPanelPage()
	{
		return mainPagelabel.getText();
	}
	public boolean ckeckAvaibilityOfNeoStocksLogo()
	{
		return neoStocksImg.isDisplayed();
	}
	// logout application
	public void clicklogout()
	{
	action =new Actions(driver);
	action.moveToElement(profileDropdown).perform();
	logout.click();	
	}
	
	
	//click on watchlist link
		public WatchlistPage clickOnwatchlist()
		{
			watcllistLink.click();
			return new WatchlistPage();
		}
	
	
	
}
