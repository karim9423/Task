package ui;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



//Take screenshot of an execution step and generate the image in the project directory
public class Screenshots {
	
	private Screenshots(){		
	}
	 public static String capture(WebDriver driver,String screenShotName) throws IOException
	    {
	        TakesScreenshot screenShot = (TakesScreenshot)driver;
	        File source = screenShot.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"\\Screenshots\\"+screenShotName+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);        	                     
	        return dest;
	    }
}
