package com.opencart.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCompare 
{
	
      WebDriver driver;
      
      public ProductCompare(WebDriver driver)
      {
    	  this.driver=driver;
    	  PageFactory.initElements(driver,this);
      }
      
      @FindBy(name="search")
		 WebElement searchtxt;
		
      @FindBy(xpath="(//button[@type='button'])[1]")
		WebElement searchbutton;
		
		@FindBy(xpath="(//i[@class='fa-solid fa-arrow-right-arrow-left'])[2]")
		WebElement compareProductBtn;//productcompare icon
				
        @FindBy(xpath="//a[@id='compare-total']")
         WebElement productCompareBtn;
        
        @FindBy(linkText="Continue")
        WebElement continuebtn;
		
        @FindBy(xpath="//h1[text()='Product Comparison']")
        WebElement messgeText;
        
		public void search_txt(String text)
	      {
	    	  searchtxt.sendKeys(text);
	      }
		
		public void search_button() 
		{
			searchbutton.click();
		}
		
		public void ClickOnCompareProduct()
		{
			compareProductBtn.click();
		}
		
		public void ClickOnproductCompare()
		{
			productCompareBtn.click();
		}
		
//		public void clickOnContinue() {
//			continuebtn.click();
//		}
		
		public boolean isPresent() {
			try {
				messgeText.getText();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		
      }
      

