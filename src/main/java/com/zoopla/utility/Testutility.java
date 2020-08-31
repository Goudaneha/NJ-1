package com.zoopla.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.zoopla.testbase.TestBase;

public class Testutility extends TestBase {
	
	public static long implicity_time = 30;
	public static long pageload_time = 30;

	public static void takeScreenshot_failedtestEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File("D:\\NJ\\TestAutomation-1" + "/screenshots/" + System.currentTimeMillis() + ".png") );
}
}
