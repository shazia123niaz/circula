package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	 public WebDriver driver;
	 public Properties p;
		@BeforeClass
		void setup() throws IOException
		{
			// loading config.properties file
			
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get(p.getProperty("appURL")); // Reading URL from config.properties file
			driver.manage().window().maximize();
		    driver.findElement(By.xpath("//a[normalize-space()='Start a free trial']")).click();
		}
		
		public String randomeString()
		{
			
			String generatestring=RandomStringUtils.randomAlphabetic(5); 
		    return generatestring;
		}
		
		public String randomeNumber()
		{
			
			String generatenumbers=RandomStringUtils.randomNumeric(13);
		    return generatenumbers;
		}
		public String randomeAlphaNumeric()
		{
			
			String generatestring=RandomStringUtils.randomAlphabetic(5); 
			String generatenumbers=RandomStringUtils.randomNumeric(4);
		    return (generatestring+"@"+generatenumbers);
		}
		
		@AfterClass
	    void tearDown()
	    {
	    	driver.quit();
	    	
	    }
	
	

}
