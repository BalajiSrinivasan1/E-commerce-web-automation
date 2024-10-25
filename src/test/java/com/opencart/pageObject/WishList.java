package com.opencart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishList 
{
   WebDriver driver;
   
   public WishList(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
	   @FindBy(name="search")
	   public WebElement searchtxt;
		
	   @FindBy(xpath="(//button[@type='button'])[1]")
	   public WebElement searchbutton;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")//(//div[@class='content']//button[@type='submit'])[2]
		public WebElement wlist;
		
		//@FindBy(xpath="//a[@title='Wish List (1)']")
		@FindBy(xpath="(//span[@class='d-none d-md-inline'])[4]")
		//@FindBy(xpath="//i[@class='fa fa-heart']")
		public WebElement wlisticon;
		
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		public WebElement addToCart;//https://demo.opencart.com/en-gb?route=account/wishlist&customer_token=a931403418aa09666fee44bf83

	    @FindBy(xpath="(//*[@type='submit'])[2]")
	    public WebElement removeWishList;
		
		
		public void search_txt(String text)
	      {
	    	  searchtxt.sendKeys(text);
	      }
		
		public void search_button() 
		{
			searchbutton.click();
		}
		
		public void wlist_button()
		{
			wlist.click();
		}
		
		public void wlist_icon()
		{
			wlisticon.click();
		}
		public boolean isPageExists()
		{
			try
			{
			
			return (addToCart.isDisplayed());
			}
			catch(Exception e)
			{
				return(false);
			}
		}
		
   }  
   
       
   

