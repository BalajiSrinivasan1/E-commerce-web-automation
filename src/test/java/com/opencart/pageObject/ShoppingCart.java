package com.opencart.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCart 
{
     WebDriver driver;
     public ShoppingCart(WebDriver driver)
     {
    	 
    	 PageFactory.initElements(driver,this);
         }
     
     
     public @FindBy(name="search")
	 WebElement searchtxt;
	
     public @FindBy(xpath="(//button[@type='button'])[1]")
	 WebElement searchbutton;
	
     public @FindBy(xpath="(//button[@type='submit'])[3]")
	WebElement addcart;
	
     public @FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement shopingcart;
	
     public @FindBy(linkText="Continue")
	WebElement continueBtn;
	
     public @FindBy(xpath="//button[text()='Use Coupon Code']")
	WebElement drpselect;
	
     public @FindBy(xpath="//input[@id='input-coupon']")
	WebElement textbox;
	//drowpdown2
     public @FindBy(xpath="//button[text() ='Estimate Shipping & Taxes']")
    WebElement shiping;
    
     public @FindBy(id="input-country")
    WebElement selectCountry;
    
     public @FindBy(id="input-zone")
    WebElement selectState;
    
     public @FindBy(id="input-postcode")
    WebElement postcode;
    
     public @FindBy(xpath="//button[@id='button-quote']")
    WebElement getquote;
    
    public @FindBy(id="shipping-addresses")
    WebElement shippingAddressd;
    
    public @FindBy(id="input-shipping-address")
    WebElement shippingAddressdDropDown;

    public @FindBy(id="button-shipping-methods")
    WebElement shippingMethodeChoose;
    
     public @FindBy(id="input-shipping-method-flat-flat")
    WebElement radioshipping;
    
     public @FindBy(id="button-shipping-method")
    WebElement shippingMethodeContinue;

public @FindBy(id="button-payment-methods")
WebElement paymentMethodeChoose;

public @FindBy(id="input-payment-method-cod-cod")
WebElement radioPayment;

public @FindBy(id="button-payment-method")
WebElement paymentMethodeContinue;

public @FindBy(id="input-comment")
WebElement addComment;

public @FindBy(id="content")
WebElement orderMessage;

public @FindBy(id="Continue")
WebElement linkContinue;
    
 //dropdown3
     public @FindBy(xpath="//a[text()='Use Gift Certificate ']")
	WebElement gift;
	
     public @FindBy(xpath="//input[@id='input-voucher']")
	WebElement giftcerti;
	
     public @FindBy(xpath="//input[@value='Apply Gift Certificate']")
	WebElement applygc;
	
   public  @FindBy(linkText="Checkout")
	  WebElement checkout;
   
   
   
   public @FindBy(id="button-confirm")
   WebElement confirmOrder;
   
//	//continue button
//	@FindBy(xpath="//a[normalize-space()='Continue Shopping']")
//	WebElement con_button;
	
	public void searchtxt(String text)
    {
  	  searchtxt.sendKeys(text);
    }
	
	public void searchbutton() 
	{
		searchbutton.click();
	}
	
	public void addtocart()
	{
		addcart.click();
	}
     
	public void shop_cart()
	{
		shopingcart.click();
	}
	
	public void dropdown()
	{
		drpselect.click();
		
		}
	
	public void drptext(String text)
	{
		textbox.sendKeys(text);
	}

	public void shipping()
	{
		shiping.click();
	}

	public void  select_list()
	{
	      Select coun= new Select(driver.findElement(By.id("input-country")));
      coun.selectByVisibleText("Togo");
		}

	public void  select_list2()
	{
	      Select zone= new Select(driver.findElement(By.id("input-zone")));
      zone.selectByVisibleText("Kara");
		}
	
	public void  select_text(String text)
	{
	      postcode.sendKeys(text);
			}
	
	
	
	public void select_buttongc() 
	{
		applygc.click();
	}
	
	public void clickOnCheckOut() {
		checkout.click();
	}
	public void click_continue()
	{
		continueBtn.click();
	}
	
	public void clickOnShippingMethod() {
		shippingMethodeChoose.click();
		radioshipping.click();
		shippingMethodeContinue.click();
	}
	
	public void clickOnPaymentMethode() {
		 paymentMethodeChoose.click();
         radioPayment.click();
        paymentMethodeContinue.click();
	}
	
	
}