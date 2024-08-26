package testCases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import pageObjects.PageObject_SignUp;

public class Tc002_SignUpTest_Validations extends BaseClass{
   
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
	    
	    // Try to submit empty form to see all errors
	    ps.clickCreateAccount();
	    
	    // Check errors in form
	    Assert.assertEquals(ps.getFirstnameError(), "First name is required.");
	    Assert.assertEquals(ps.getLastnameError(), "Last name is required.");
	    Assert.assertEquals(ps.getWorkEmailError(), "Work e-mail is required.");
	    Assert.assertEquals(ps.getCompanyError(), "Company name is required.");
	    Assert.assertEquals(ps.getCommentError(), "Please explain, how you discovered Circula.");

	    Thread.sleep(100);
	    ps.takeScreenshot("validation");
	}
	
}