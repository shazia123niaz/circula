package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_SignUp extends BasePage{

	//Constructor
	public PageObject_SignUp(WebDriver driver)
	{
		super(driver);
		
	}
	
	// Locators
	 By txt_firstname=By.xpath("//input[@id='textfield-:Rimkmm:']");
	 By txt_lastname=By.id("textfield-:R12mkmm:");
	 By work_email=By.id("textfield-:Rjmkmm:");
	 By txt_password=By.cssSelector("input[id=\'textfield-:R2kmkmm:\']");
	 By txt_company=By.id("textfield-:R14mkmm:");
	 By txt_phone_number=By.id("textfield-:R13mkmm:");
	 By dropdown_country=By.id("registration-country-input");
	 By dropdown_list = By.cssSelector("[data-testid='autocomplete-menu-portal']");
//	 By select_country=By.cssSelector("#registration-country-item-11"); // Sweden
	 By select_country=By.xpath("//li/div[text()='Sweden']");
	 By txt_about_us_comment=By.id("textfield-:R6mkmm:");
	 By btn_create_account=By.cssSelector(".sc-920edc59-0.geGaiv");

	 // -------------- Action methods-------------------------------
	 
		 
	 //  Enter first name
	 public void acceptCookies() throws InterruptedException
	 {
		 Thread.sleep(1000);
		    WebElement element = driver.findElement(By.cssSelector("#usercentrics-root"));
		    SearchContext context = element.getShadowRoot();
		    WebElement cookieAcceptAll = context.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
		    cookieAcceptAll.click(); 
	 }
	 
	 
	//  Enter first name
		 public void setFirstname(String fname)
		 {
			 driver.findElement(txt_firstname).sendKeys(fname);
			 
		 }
	 
	//  Enter last name
		 public void setLastname(String lname)
		 {
			 driver.findElement(txt_lastname).sendKeys(lname);
			 
		 }
		
	 //  Enter work Email
		public void setworkEmail(String email)
			 {
	     		driver.findElement(work_email).sendKeys(email);
					 
			 }
			 
	//  Enter password	 
		public void setPassword(String pwd)
		 {
    		driver.findElement(txt_password).sendKeys(pwd);
				 
		 }
		
		//  Enter Company Name	 
		public void setCompany(String company)
		 {
    		driver.findElement(txt_company).sendKeys(company);
				 
		 }
		
		
	//  Set Sweden Country	 
			public void setCountry()
			 {
				driver.findElement(By.id("registration-country-input")).click();
				
				
				// We need to wait till div element is shown with list of countries
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 	
				wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown_list));
				

				WebElement LiElement = driver.findElement(select_country);
				Actions actions = new Actions(driver);
				actions.moveToElement(LiElement);
				actions.perform();
				LiElement.click();

					 
			 }
		
		

		// Provide comment
			public void setComment(String comment)
				 {
		   		driver.findElement(txt_about_us_comment).sendKeys(comment);
						 
				 }	
				
				
			// Check box???????????????????????
			public void checkTermsAndConditions() throws InterruptedException
			{
				Thread.sleep(100);
				
				// select checkbox
				WebElement checkbox = driver.findElement(By.cssSelector("[name='acceptTos']"));
				((JavascriptExecutor) driver).executeScript(
		                "arguments[0].click();", checkbox);
			}
			
			
			// Check box???????????????????????
						public void checkNewsletter() throws InterruptedException
						{
							Thread.sleep(100);
							
							// select checkbox
							WebElement checkbox = driver.findElement(By.cssSelector("[name='sendNewsletter']"));
							((JavascriptExecutor) driver).executeScript(
					                "arguments[0].click();", checkbox);
						}
			
			
		//  Enter last name
			 public void setPhoneNumber(String phoneNumber)
			 {
				 driver.findElement(txt_phone_number).sendKeys(phoneNumber);
				 
			 }
			
			// Click on Create account button
			public void clickCreateAccount()
			 {
	   		driver.findElement(btn_create_account).click();
					 
			 }		
			
			
			public void takeScreenshot() throws IOException
			{
				try {
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example copy somewhere
				FileHandler.copy(scrFile, new File("c:\\tmp\\screenshot.png"));
				}catch(IOException e) {}
			}

}


