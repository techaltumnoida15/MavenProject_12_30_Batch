package org.techAltum.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class UploadFile_Sikuli extends BaseClass{

	
	@Test
	public void uploadFile() throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		
		String fileNameTextBoxImgPath = projectPath + "\\sikuli_images\\FileNameTextBox.jpg";		
		String openButtonImgPath = projectPath + "\\sikuli_images\\OpenButton.jpg";
		String uploadFileName = projectPath + "\\uploadFiles_Docs\\git-cheatsheet.pdf";
		
		driver.get("https://convertonlinefree.com/PDFToWORDEN.aspx");
		
		//Click on Choose File button
		WebElement chooseFile = driver.findElement(By.id("MainContent_fuDOCX"));
		//chooseFile.click();
		
		Actions act = new Actions(driver);
		act.click(chooseFile);
		act.build().perform();
		
		Thread.sleep(2000);
		
		//Use Sikuli to upload files
		Screen screen = new Screen();
		
		//Typing file name in text box
		Pattern fileNameTextBoxImgPattern = new Pattern(fileNameTextBoxImgPath);
		screen.wait(fileNameTextBoxImgPattern, 2);
		screen.type(uploadFileName);
		
		//Click on Open button
		Pattern openButtonImgPattern = new Pattern(openButtonImgPath);
		screen.wait(openButtonImgPattern, 2);
		screen.click();
	}
}
