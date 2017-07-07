package testCases;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility {

		static WebDriver driver;
		public static String captureScreenShot(WebDriver driver,String screenshotname) throws Exception
		{
		TakesScreenshot ts=(TakesScreenshot)driver;	
		File source=ts.getScreenshotAs(OutputType.FILE)	;
		String dest="./Screenshots/"+screenshotname+".png";
		File destination=new File(dest);
		FileUtils.copyFile(source,destination);
		return dest;
		}
		
	}


