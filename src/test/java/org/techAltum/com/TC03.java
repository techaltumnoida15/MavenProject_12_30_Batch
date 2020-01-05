package org.techAltum.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC03 extends BaseClass{

	@Test
	public void testNaukri() throws Exception{
		//click on search job text box
		//driver.findElement(By.id("qsbClick")).click();
		
		WebElement searchJobTextBox = driver.findElement(By.id("qsbClick"));
		searchJobTextBox.click();
		System.out.println("Click on Search job text box.");
		
		//enter skills
		WebElement skills = driver.findElement(By.name("qp"));
		skills.clear();
		skills.sendKeys("Java");
		System.out.println("Skill is entered.");
		
		//enter location
		driver.findElement(By.name("ql")).clear();
		driver.findElement(By.name("ql")).sendKeys("Noida");
		System.out.println("Location is entered");
		
		//CLick on Search
		WebElement searchButton = driver.findElement(By.id("qsbFormBtn"));
		searchButton.click();
		System.out.println("Click on search button box");
		
		//Verify total no. of jobs on nect page based on Skill and location
		Thread.sleep(2000);
		
		WebElement totalJobs = driver.findElement(By.xpath("//div[@class='small_title']"));
		System.out.println(totalJobs);
		String jobs = totalJobs.getText();
		System.out.println(jobs);
	}
}
