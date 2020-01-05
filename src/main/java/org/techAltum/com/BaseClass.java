package org.techAltum.com;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public WebDriver driver;
	public Properties prop = new Properties();
	
	@BeforeMethod
	public void openBrowser() {
		//Open Browser
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		String browserName = "chrome";
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//Open Chrome
			String browserDriverEXE = projectPath + "\\browserDriverEXE\\chromedriver.exe";
			System.out.println(browserDriverEXE);
			
			System.setProperty("webdriver.chrome.driver", browserDriverEXE);
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			//Open Firefox
			String browserDriverEXE = projectPath + "\\browserDriverEXE\\geckodriver.exe";
			System.out.println(browserDriverEXE);
			
			System.setProperty("webdriver.gecko.driver", browserDriverEXE);
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			//Open Edge
			String browserDriverEXE = projectPath + "\\browserDriverEXE\\MicrosoftWebDriver.exe";
			System.out.println(browserDriverEXE);
			
			System.setProperty("webdriver.edge.driver", browserDriverEXE);
			driver = new EdgeDriver();
		}
		
		else {
			//Open IE
			String browserDriverEXE = projectPath + "\\browserDriverEXE\\IEDriverServer.exe";
			System.out.println(browserDriverEXE);
			
			System.setProperty("webdriver.ie.driver", browserDriverEXE);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(5, TimeUnit.MINUTES);
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public String getDataFromPropFile(String key) throws Exception{
		String projectPath = System.getProperty("user.dir");
		String propFilePath = projectPath + "\\data.properties";
		
		//File class Object - java.io package
		File file = new File(propFilePath);
		
		//Read - InputStream class
		FileInputStream fIp = new FileInputStream(file);
		
		//Properties class object
		prop.load(fIp);
		return prop.getProperty(key);
	}
}
