package org.techAltum.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadFile_AutoIT extends BaseClass{

	
	@Test
	public void uploadFile() throws Exception {
		driver.get("https://convertonlinefree.com/PDFToWORDEN.aspx");
		String AutoITexePath = System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe";
		
		System.out.println(System.getProperty("user.name"));
		
		System.out.println(System.getProperty("os.arch"));
		
		System.out.println(System.getProperty("user.home"));
		
		//Click on Choose File button
		WebElement chooseFile = driver.findElement(By.id("MainContent_fuDOCX"));
		//chooseFile.click();
		
		//Execute JS
		//((JavascriptExecutor)driver).executeScript("document.getElementById('MainContent_fuDOCX').click();");
		//((JavascriptExecutor)driver).executeScript("document.getElementsByName('ctl00$MainContent$fuDOCX')[0].click();");
		
		Actions act = new Actions(driver);
		act.click(chooseFile);
		act.build().perform();
		
		Thread.sleep(2000);
		
		//Call .exe file to upload 
		Process pro = Runtime.getRuntime().exec(AutoITexePath);
	}
}
