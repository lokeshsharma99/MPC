package testCases;

import java.io.BufferedReader;		
import java.io.File;		
import java.io.FileReader;		
import java.util.Date;		
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadCookiesData		
{		
    static WebDriver driver;					
    @SuppressWarnings("deprecation")
	public static void main(String[] args)					
    {        System.setProperty("webdriver.chrome.driver","D:/Development_Avecto/workspace/webdriver/chromedriver.exe");					
    driver=new ChromeDriver();					
    try{			
     
        File file = new File("Cookies.data");							
        FileReader fileReader = new FileReader(file);							
        @SuppressWarnings("resource")
		BufferedReader Buffreader = new BufferedReader(fileReader);							
        String strline;			
        while((strline=Buffreader.readLine())!=null){									
        	StringTokenizer token = new StringTokenizer(strline,";");
            while (token.hasMoreTokens()) {				
        String name = token.nextToken();					
        String value = token.nextToken();					
        String domain = token.nextToken();					
        String path = token.nextToken();					
        Date expiry = null;					
        		
        String val;			
        if(!(val=token.nextToken()).equals("null"))
		{		
        	expiry = new Date(val);					
        }		
        Boolean isSecure = new Boolean(token.nextToken()).								
        booleanValue();		
        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);																	
        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
        }		
        }		
        }catch(Exception ex){					
        ex.printStackTrace();			
        }		
        driver.get("https://test.salesforce.com");	
       // Login2SF.login();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("lokesh.sharma2@cognizant.com.qa");;
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("kirti123#");;
		driver.findElement(By.xpath("//*[@id='Login']")).submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
}
}
    