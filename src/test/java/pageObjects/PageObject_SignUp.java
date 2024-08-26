package pageObjects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

public class PageObject_SignUp extends BasePage {

    //Constructor
    public PageObject_SignUp(WebDriver driver) {
        super(driver);
    }

    // Selectors
    By selectorFirstname = By.xpath("//input[@id='textfield-:Rimkmm:']");
    By selectorLastname = By.id("textfield-:R12mkmm:");
    By selectorWorkEmail = By.id("textfield-:Rjmkmm:");
    By selectorPassword = By.cssSelector("input[id=\'textfield-:R2kmkmm:\']");
    By selectorCompany = By.id("textfield-:R14mkmm:");
    By selectorPhoneNumber = By.id("textfield-:R13mkmm:");
    By selectorCountryDropdown = By.id("registration-country-input");
    By selectorCountryList = By.cssSelector("[data-testid='autocomplete-menu-portal']");
    By selectorCountry = By.xpath("//li/div[text()='Sweden']");
    By selectorComment = By.id("textfield-:R6mkmm:");
    By selectorTermsAndConditions = By.cssSelector("[name='acceptTos']");
    By selectorNewsletter = By.cssSelector("[name='sendNewsletter']");
    By selectorCreateAccount = By.cssSelector(".sc-920edc59-0.geGaiv");
    
    
    // Error Selectors
    By selectorFirstnameError = By.cssSelector("label[for='textfield-:Rimkmm:'] div[class='sc-b4bf297b-0 jQHmRc']");
    By selectorLastnameError = By.cssSelector("label[for='textfield-:R12mkmm:'] div[class='sc-b4bf297b-0 jQHmRc']");
    By selectorCompanyError = By.cssSelector("label[for='textfield-:R14mkmm:'] div[class='sc-b4bf297b-0 jQHmRc']");
    By selectorWorkEmailError = By.cssSelector("label[for='textfield-:Rjmkmm:'] div[class='sc-b4bf297b-0 jQHmRc']");
    By selectorCommentError = By.cssSelector("label[for='textfield-:R6mkmm:'] div[class='sc-b4bf297b-0 jQHmRc']");

    
    // -------------- Action methods-------------------------------


    //  cookies method
    public void acceptCookies() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.cssSelector("#usercentrics-root"));
        SearchContext context = element.getShadowRoot();
        WebElement cookieAcceptAll = context.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
        cookieAcceptAll.click();
    }


    //  Enter first name
    public void setFirstname(String firstName) {
        driver.findElement(selectorFirstname).sendKeys(firstName);
    }

    //  Enter last name
    public void setLastname(String lastName) {
        driver.findElement(selectorLastname).sendKeys(lastName);
    }

    //  Enter work Email
    public void setworkEmail(String email) {
        driver.findElement(selectorWorkEmail).sendKeys(email);
    }

    //  Enter password	 
    public void setPassword(String password) {
        driver.findElement(selectorPassword).sendKeys(password);
    }

    //  Enter Company Name	 
    public void setCompany(String company) {
        driver.findElement(selectorCompany).sendKeys(company);
    }

    //  Set Sweden Country	 
    public void setCountry() {
    	// Click on input field to open dropdown
        driver.findElement(By.id("registration-country-input")).click();

        // We need to wait till div element is shown with list of countries
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorCountryList));

        // We need to move to li item which has Sweden text and then click on it
        WebElement LiElement = driver.findElement(selectorCountry);
        Actions actions = new Actions(driver);
        actions.moveToElement(LiElement);
        actions.perform();
        LiElement.click();
    }



    // Provide comment
    public void setComment(String comment) {
        driver.findElement(selectorComment).sendKeys(comment);
    }


    // Accept terms and conditions
    public void checkTermsAndConditions() throws InterruptedException {
        Thread.sleep(100);

        // select checkbox
        WebElement checkbox = driver.findElement(selectorTermsAndConditions);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", checkbox);
    }


    // Accept newsletter
    public void checkNewsletter() throws InterruptedException {
        Thread.sleep(100);

        // select checkbox
        WebElement checkbox = driver.findElement(selectorNewsletter);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", checkbox);
    }


    //  Enter phone number
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(selectorPhoneNumber).sendKeys(phoneNumber);
    }

    // Click on Create account button
    public void clickCreateAccount() {
        driver.findElement(selectorCreateAccount).click();
    }

    // Take screenshot of screen
    public void takeScreenshot(String fileName) throws IOException {
        try {
        	Path currentRelativePath = Paths.get("");
        	String pathToCreateFile = currentRelativePath.toAbsolutePath().toString();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(scrFile, new File(pathToCreateFile + "\\src\\test\\java\\screenshots\\" + fileName + ".png"));
        } catch (IOException e) {}
    }
    
    //  Get first name field error
    public String getFirstnameError() {
        return driver.findElement(selectorFirstnameError).getText();
    }

    //  Get last name field error
    public String getLastnameError() {
        return driver.findElement(selectorLastnameError).getText();
    }

    //  Get work email field error
    public String getWorkEmailError() {
        return driver.findElement(selectorWorkEmailError).getText();
    }

    //  Get Company Name field error 
    public String getCompanyError() {
        return driver.findElement(selectorCompanyError).getText();
    }
    
    //  Get Comment field error 
    public String getCommentError() {
        return driver.findElement(selectorCommentError).getText();
    }
    
}