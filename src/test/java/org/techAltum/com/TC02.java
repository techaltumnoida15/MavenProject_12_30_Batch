package org.techAltum.com;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

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
		//wait.withTimeout(Duration.ofSeconds(10));
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500))
				.withMessage("Waiting for element");
				
		fluentWait.until(
				
				new Function<WebDriver, Boolean>() {

					@Override
					public Boolean apply(WebDriver driver) {
						try {
							if(driver.findElement(By.id("idMatrixRows")).findElements(By.tagName("th")).size() > 1) {
								return true;
							}
						}
						catch(Exception ex) {
							//return false;
						}
						return false;
					}
				});
		
		/*
		 * List<String> myL = new ArrayList<>(); ArrayList<String> myL1 = new
		 * ArrayList<>();
		 */
		
		/*
		 * WebDriver driver = new ChromeDriver(); ChromeDriver cDriver = new
		 * ChromeDriver();
		 */		//Thread.sleep(4000);
		
		//Press Tab Key
		origin.sendKeys(Keys.TAB);
	}
}
