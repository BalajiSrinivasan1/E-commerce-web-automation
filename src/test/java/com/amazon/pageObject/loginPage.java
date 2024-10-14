package com.amazon.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver ldriver;
	public loginPage(WebDriver driver){
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//span[text()='Sign in'])[1]")
	public  WebElement siginbtn;

	@FindBy(id="ap_email")
	public  WebElement emailTextField;
	 
	@FindBy(id="ap_password")
	public WebElement passwordTextField;


	@FindBy(id="continue")
	public  WebElement continueBtn;   

	@FindBy(id="signInSubmit")
	public WebElement signinSubmitBtn;

     @FindBy(xpath="//span[text()='Sign Out']")
	 public WebElement signoutBtn;
     
     @FindBy(xpath="//div[text()[normalize-space()='Enter a valid email address or phone number']]")
     public WebElement usenameInCorrect;
     
     @FindBy(xpath="//span[text()[normalize-space()='Your password is incorrect']]")
     public WebElement passwordInCorrect;
     
     public void clickOnSiginBtn() {
    	 siginbtn.click();
     }
	public void setUserName(String username) {
		emailTextField.sendKeys(username);
	}
	
	public void clickOnContinue() {
		continueBtn.click();
	}
	public void setPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	public void clickOnSiginSubmit() {
		signinSubmitBtn.click();
	}
      public void clickSignoutBtn(){
                signoutBtn.click();
}
}
