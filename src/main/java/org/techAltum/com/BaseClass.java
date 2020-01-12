package org.techAltum.com;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {

	public WebDriver driver;
	public Properties prop = new Properties();
	public String failureScreenshotPath;
	String projectPath;
	
	public ExtentHtmlReporter htmlReporter ;    //for look and feel of report
	public ExtentReports extentReport ;         //To create entry of test in report
	public ExtentTest extentTest;               //To update status of test in report
	String currentDateTime;
	
	
	@BeforeMethod
	public void openBrowser() {
		currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		
		//Where to save report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extentReport/TestAutomationReport_" + currentDateTime + ".html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("HostName", System.getProperty("user.name"));
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Environment", "LIVE");
		
		
		//Open Browser
		projectPath = System.getProperty("user.dir");
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
	public void closeBrowser(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test is failed = " + result.getName());
			extentTest.log(Status.FAIL, "Error in Test is = " + result.getThrowable());
			
			String testMethodName = result.getMethod().getMethodName();
			currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
			
			String scrrenshotPath = System.getProperty("user.dir") + "\\failure_screenshot\\" + testMethodName  + "_" + currentDateTime + ".jpeg";
			
			Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
			ImageIO.write(fpScreenshot.getImage(),"JPEG",new File(scrrenshotPath));
			
			extentTest.addScreenCaptureFromPath(scrrenshotPath);
			extentTest.info("Test is fail.");
			
		}
		
		else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test case skiped is = " + result.getName());
			extentTest.info("Test is skiped.");
		}
		
		else {
			extentTest.log(Status.PASS, "Test case passed is = " + result.getName());
			extentTest.info("Test is pass.");
		}
		
		driver.quit();
		extentReport.flush();
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
