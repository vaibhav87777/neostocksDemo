package com.neo.qa.testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.neo.qa.base.TestbaseClass;
import com.neo.qa.pages.HomepageNeo;
import com.neo.qa.pages.LoginPageMobile_Neo;
import com.neo.qa.pages.LoginPagePIN_Neo;
import com.neo.qa.pages.MainPanelPage;
import com.neo.qa.util.TestutilityClass;

public class MainPanelTest extends TestbaseClass {
	LoginPageMobile_Neo loginpagemobile;
	TestutilityClass util;
	LoginPagePIN_Neo loginpagepin;
	HomepageNeo homepage;
	MainPanelPage mainpanelpage;
	public MainPanelTest()
	{
		super();
	}
	@BeforeClass
	public void setUp()
	{
		browserInitialization();
		
	}
	@BeforeMethod
	public void logIn() throws InterruptedException
	{
	loginpagemobile=new LoginPageMobile_Neo();
	util=new TestutilityClass();
	homepage=new HomepageNeo();
	homepage.clickOnSignInLink();
	loginpagemobile.enterMobileNumber(prop.getProperty("ID"));
	loginpagemobile.clickONsignInButton();
	loginpagepin=new LoginPagePIN_Neo();
	loginpagepin.enterPin(prop.getProperty("PASSWORD"));
	loginpagepin.clickOnsubmitButton();
	mainpanelpage=new MainPanelPage();
	mainpanelpage.clickOnOKNewFeaturePopUP();}
	
@Test(priority=2)
public void verifyLoginTest()
{   String exptprofilename="Hi "+prop.getProperty("USR");
    String actualprofilename=mainpanelpage.getProfileName();
	Assert.assertEquals(actualprofilename, exptprofilename, "profile name not matching");
	}



@Test(priority=1)
public void verifyMainPanelPageTLabelAndLogo()
{ 
	Assert.assertEquals(mainpanelpage.getLabelOnMainPanelPage(), "NIFTY 50","label not matched");
	Assert.assertTrue(mainpanelpage.ckeckAvaibilityOfNeoStocksLogo(),"Neo Stocks Logo is Not Available");
	}


@AfterMethod
public void LogOut()
{
	mainpanelpage.clicklogout();
	}
@AfterClass
public void TearDown()
{
	driver.close();
	}
}
