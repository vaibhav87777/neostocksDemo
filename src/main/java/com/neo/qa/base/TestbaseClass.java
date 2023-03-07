package com.neo.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.html.HTMLUListElement;

public class TestbaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
    public static String testData_PATH="C:\\Users\\user\\eclipse-workspace\\NeoStocks\\testData\\neoStock_testData.xlsx";
	
	public TestbaseClass()
	{
		//data from properties file
		try {	FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\neoStocks\\src\\main\\java\\com\\neo\\qa\\config\\neoProperties.properties");
		  prop=new Properties();  //Properties prop=new Properties();
			prop.load(file);}
			catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e1) {e1.printStackTrace();}
	}

		
	
		//brower initialization
		public static void browserInitialization()  
		{
			
		  String browsername = prop.getProperty("BROWSER");
		

			//---pass options object in chromedriver consructor 
			if(browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\neoStocks\\browsers\\chromedriver.exe");
				 driver=new ChromeDriver();
				 
			}
			else if(browsername.equalsIgnoreCase("headlessChrome"))
			{
				//code for headless browser  
			    ChromeOptions options= new ChromeOptions(); 
				options.addArguments("window-size=1400,800");
				//options.addArguments("headless");
				options.setHeadless(true);
				 driver=new ChromeDriver(options);
			}
			else if(browsername.equalsIgnoreCase("incognito")) {
				
				ChromeOptions options1= new ChromeOptions(); 
				 // add Incognito parameter
				options1.addArguments("--incognito");
//			      // DesiredCapabilities object
//			      DesiredCapabilities c = DesiredCapabilities.chrome();
//			      //set capability to browser
//			      c.setCapability(ChromeOptions.CAPABILITY, options1);
			      driver=new ChromeDriver(options1);
			}
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(prop.getProperty("URL"));
			}
		
		   
			
		}
		

		
		
		



