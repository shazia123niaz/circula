package testCases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import pageObjects.PageObject_SignUp;


public class Tc001_SignUpTest extends BaseClass{
   
	@Test
	void testURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(),"https://app.circula.com/users/sign_up");
	}
	
	@Test (groups={"functional"})
	void testSignUp() throws InterruptedException, IOException
	{
		//-- Create Object of SignUp page to interact and perform actions
	    PageObject_SignUp ps=new PageObject_SignUp(driver);
        
	    
	    // accept cookies
	    ps.acceptCookies();
	    
	    // Fill form
	    ps.setFirstname(randomeString().toUpperCase());
	    ps.setLastname(randomeString().toUpperCase()); 
	    ps.setworkEmail(randomeString()+"@ndiety.com");
	    ps.setPassword(randomeAlphaNumeric());
	    ps.setCompany(randomeString().toUpperCase());
	    ps.setPhoneNumber(randomeNumber());
	    ps.setCountry();
	    ps.setComment(randomeString().toUpperCase());
	    ps.checkTermsAndConditions();
	    ps.checkNewsletter();
	    
	    Thread.sleep(100);
	    ps.clickCreateAccount();

	    Thread.sleep(100);
	    ps.takeScreenshot();
	}
	
	}
