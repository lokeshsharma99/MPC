package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Login2SF {
	static ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("C:\\Report.html");;
	static ExtentReports report=new ExtentReports();;
	static ExtentTest logger;
	static WebDriver driver;
	
	@BeforeTest

	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver","D:/Development_Avecto/workspace/webdriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://test.salesforce.com");
		report.attachReporter(htmlreporter);
		
	}	

	@Test
	public static void login() {

		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("lokesh.sharma2@cognizant.com.qa");;
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("kirti123#");;
		driver.findElement(By.xpath("//*[@id='Login']")).submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 
	
	@AfterMethod
	
	public void checking(ITestResult result) throws Exception
	{
		
		logger.log((Status.FAIL), "FaILeD");
		
		
	if(result.getStatus()==ITestResult.FAILURE)	{
	utility.captureScreenShot(driver,result.getName());
	logger.fail("Testcase Failed");	
	}else if(result.getStatus()==ITestResult.SKIP){
		utility.captureScreenShot(driver,result.getName());
		logger.skip("Testcase Skipped");
		
	}else{
		utility.captureScreenShot(driver,result.getName());
		logger.skip("Testcase Passesd");
	}
	}
	}
