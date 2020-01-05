package org.techAltum.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.techAltum.com.BaseClass;

public class TC01 extends BaseClass{
	
	@Test
	public void testCase01() throws Exception{
		//driver.get("http://www.ironpaper.com/webintel/articles/");
		driver.get("http://www.naukri.com");
		
		WebElement searchJobTextBox = driver.findElement(By.id("qsbClick"));
		searchJobTextBox.click();
		
		//Wait explicit - Skill Text Box
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("qp")));
		
		System.out.println("Skills text box is clickable.");
		
		driver.findElement(By.name("qp")).sendKeys("Java");
	}
}