package com.amazon.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	WebDriver ldriver;
	public homePage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='hm-icon nav-sprite']")
	public  WebElement all;

	@FindBy(xpath="//a[@data-csa-c-content-id='nav_cs_gb']")
	public  WebElement todayDeales;

	@FindBy(xpath="//a[@data-csa-c-content-id='nav_cs_customerservice']")
	public  WebElement customerService;

	@FindBy(linkText="Registry")
	public  WebElement  Registry;

	@FindBy(linkText="Gift Cards")
	public  WebElement GiftCards;

	@FindBy(linkText="Sell")
	public  WebElement Sell;

	@FindBy(id="searchDropdownBox")
	public  WebElement searchDropdown;

	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;

	@FindBy(id="nav-global-location-popover-link")
	public WebElement locationBtn;

	@FindBy(className="icp-nav-link-inner")
	public  WebElement languageBtn;

	@FindBy(id="nav-cart")
	public WebElement cartBtn;

	@FindBy(id="nav-search-submit-button")
	public  WebElement searchbtn;
	
	@FindBy(id="nav-link-accountList")
	public  WebElement accountList;
	

}
