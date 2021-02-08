package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory - OR:
	
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
	    @FindBy(xpath = "//input[@type='submit']")
	    WebElement LoginBtn;
	    
	    @FindBy(xpath = "//a[contains(@class,'navbar-brand')]/img")
	    WebElement crmLogo;
	    
	    //Initializing the page objects
	    public LoginPage() {
	    	PageFactory.initElements(driver,this);
	    }
	    
	    //Actions:
	    public String validateLoginPageTitle() {
	    	return driver.getTitle();
	    }
	    
	    public boolean validateCRMImage() {
	    	return crmLogo.isDisplayed();
	    }
	    
	     public HomePage login(String un,String pwd) {
	    	 username.sendKeys(un);
	    	 password.sendKeys(pwd);
	    	 LoginBtn.click();
	    	 return new HomePage();
	     }
	

}
