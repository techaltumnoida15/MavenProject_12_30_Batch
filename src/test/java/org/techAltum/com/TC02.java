package org.techAltum.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.techAltum.com.BaseClass;

public class TC02 extends BaseClass{

	@Test
	public void testCase02() throws Exception{
		driver.get("http://www.cheapoair.com");
		
		//Enter Origin
		WebElement origin = driver.findElement(By.xpath("//input[@class='form-control pr-4']"));
		origin.sendKeys("LAS");
		
		
		//Wait - Explicit till suggestion box appear
		
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='suggestion-box__list']")));
		 
		
		//Thread.sleep(4000);
		
		//Press Tab Key
		origin.sendKeys(Keys.TAB);
	}
}
