package com.neo.qa.testClasses;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neo.qa.base.TestbaseClass;
import com.neo.qa.pages.HomepageNeo;
import com.neo.qa.pages.LoginPageMobile_Neo;
import com.neo.qa.pages.LoginPagePIN_Neo;
import com.neo.qa.pages.MainPanelPage;
import com.neo.qa.pages.WatchlistPage;
import com.neo.qa.util.TestutilityClass;

public class WatchlistTest extends TestbaseClass {
	
	LoginPageMobile_Neo loginpagemobile;
	TestutilityClass util;
	LoginPagePIN_Neo loginpagepin;
	HomepageNeo homepage;
	MainPanelPage mainpanelpage;
	WatchlistPage watchlistpage;
	public WatchlistTest()
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
	mainpanelpage.clickOnOKNewFeaturePopUP();
	watchlistpage=new WatchlistPage();
	mainpanelpage.clickOnwatchlist();
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcell()
	{ 
		Object sharelist [][] = TestutilityClass.getMultiTestDataCredentials("sharelist");;         
		return sharelist;
	}
	
	// verify stock added successfully in watchlist
	@Test(priority=1, dataProvider ="getTestDataFromExcell")
	public void verifyAddStocksInWatchlist(String stkNM)
	{
		watchlistpage.addStocksToWatchlist(stkNM);
		boolean flag = watchlistpage.checkavaibilityStocksInWatchlist(stkNM);
		Assert.assertTrue(flag);
		}
	
	//verify stock added in watchlist
    @Test(priority=2,dataProvider="getTestDataFromExcell", dependsOnMethods = "verifyAddStocksInWatchlist")
    public void verifyStockAvailableInWatchlist(String stkNM)
    {
	boolean flag = watchlistpage.checkavaibilityStocksInWatchlist(stkNM);
	Assert.assertTrue(flag,"stock not available");
    }
    
    //remove stock from watchlist
    @Test(priority=3,dataProvider="getTestDataFromExcell",dependsOnMethods ={"verifyAddStocksInWatchlist","verifyStockAvailableInWatchlist"})//
    public void verifyDeleteStocFromWatchlidst(String stkNM) throws InterruptedException
    {
    	watchlistpage.deletestocks(stkNM);
    	boolean flag = watchlistpage.checkavaibilityStocksInWatchlist(stkNM);
    	Assert.assertFalse(flag,"stock stiil present in watchlist");
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
