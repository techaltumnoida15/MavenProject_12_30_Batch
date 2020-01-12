package org.techAltum.com;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TC01 extends BaseClass{
	
	@Test
	public void testCase01() throws Exception{
		//driver.get("http://www.ironpaper.com/webintel/articles/");
		driver.get("http://www.naukri.com");
		
		WebElement searchJobTextBox = driver.findElement(By.id("qsbClick"));
		
		Screenshot specificElement = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver,searchJobTextBox); 
		String scrrenshotPath = System.getProperty("user.dir") + "\\failure_screenshot\\" + "Element_Name"  + "_" + ".jpeg";
		ImageIO.write(specificElement.getImage(),"JPEG",new File(scrrenshotPath));
		
		searchJobTextBox.click();
		
		//Wait explicit - Skill Text Box
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("qp")));
		
		System.out.println("Skills text box is clickable.");
		
		driver.findElement(By.name("qp")).sendKeys("Java");
	}
}