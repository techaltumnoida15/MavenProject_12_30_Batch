package org.techAltum.com;

import java.io.IOException;

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
		

		
		
		//Call .exe file to upload 
		Process pro = Runtime.getRuntime().exec("AutoITexePath");
	}
}
