package com.neo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neo.qa.base.TestbaseClass;

public class WatchlistPage extends TestbaseClass {
	boolean result;
	Actions action;;
	@FindBy (xpath="//input[@id='txt_instruments1']")
	WebElement stockssearchBX;
	
	@FindBy (xpath="//a[@class='label-dropdown']")
	List<WebElement> stklist;

	@FindBy (xpath="//div[@class='col-sm-6 text-nowrap ps-1']")
	List<WebElement> stkoptions;
	public WatchlistPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//add stock to the watchlist
		public void addStocksToWatchlist(String stockname)
		{
			stockssearchBX.sendKeys(stockname);
			for(WebElement stk:stkoptions)
			{
				String stock=stk.getText();
				if(stock.equalsIgnoreCase(stockname))
				{
					stk.click();
					break;
				}
				
			}
		}
		
		//get watchklist stocks 
	public boolean checkavaibilityStocksInWatchlist(String stockname)
	{ 
		for(WebElement stk:stklist)
		{
			if(stk.getText().equalsIgnoreCase(stockname))
			{
				result = true;
				break;
			}
		} 
		
		return result;
	}
	//delete stock from watchlist
	public void deletestocks(String stockname) throws InterruptedException
	{    action =new Actions(driver);
	
	for(WebElement stk:stkoptions)
	{
		String stock=stk.getText();
		if(stock.equalsIgnoreCase(stockname))
		{
			action.moveToElement(stk).perform();
			Thread.sleep(20000);
			break;
		}
		
	}
		WebElement deletBtn = driver.findElement(By.xpath("//div[contains(text(),'"+stockname+"')]"
				+ "//parent :: div[@class='d-flex px-2 pt-2 pb-0 bg-main'] "
				+ "//following-sibling :: div[@class='d-flex px-2 bg-main']//span[@title='Remove From Watchlist']"));
		deletBtn.click();
	}
	
	
	//click buy button on stock from watchlist
		public void buystock(String stockname) throws InterruptedException
		{    action =new Actions(driver);
		
		for(WebElement stk:stkoptions)
		{
			String stock=stk.getText();
			if(stock.equalsIgnoreCase(stockname))
			{
				action.moveToElement(stk).perform();
				Thread.sleep(20000);
				break;
			}
			
		}
			WebElement buyBtn = driver.findElement(By.xpath("//div[contains(text(),'"+stockname+"')]"
					+ "//parent :: div[@class='d-flex px-2 pt-2 pb-0 bg-main'] "
					+ "//following-sibling :: div[@class='d-flex px-2 bg-main']"
					+ "//span[@class='btn theme-bg btn-sm smallbutton']"));
			buyBtn.click();
		}
		//enter buy info
}
