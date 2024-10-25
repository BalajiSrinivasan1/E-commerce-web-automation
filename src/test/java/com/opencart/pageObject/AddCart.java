package com.opencart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCart 
{
   WebDriver driver;
   
   public AddCart(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   } 
	   @FindBy(name="search")
		public WebElement searchtxt;
		
		@FindBy(xpath="(//button[@type='button'])[1]")
		public WebElement searchbutton;
		
		@FindBy(xpath="//div[@class='content']//button[1]")
		public WebElement addcart;
		
		@FindBy(xpath="//span[text()='Shopping Cart']")
		public WebElement shoppingCart;
		
		@FindBy(xpath="//strong[normalize-space()='View Cart']")
		public WebElement view;
		
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
		public WebElement msgconfm;
		
		
		public void search_txt(String text)
	      {
	    	  searchtxt.sendKeys(text);
	      }
		
		public void search_button() 
		{
			searchbutton.click();
		}
	
		public void addcart()
		{
			addcart.click();
		}
      
		public void clickOnShoppingCart()
		{
			shoppingCart.click();
			}
		
		public void view()
		{
			view.click();
		}
		
		 public String getConfirmationMsg()
	      {
	    	  try
	    	  {
	    		  return (msgconfm.getText());
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  return(e.getMessage());
	    			  
	    	  }

		
	      }
}
