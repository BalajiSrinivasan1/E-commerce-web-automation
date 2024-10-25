package com.opencart.testCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.opencart.pageObject.HomePage;
import com.opencart.pageObject.LoginPage;
import com.opencart.utilities.ReadConfig;


public class BaseClass {
public ReadConfig readconfig=new ReadConfig();
public String url=readconfig.getApplicationURL();
public String username=readconfig.getUserName();
public String password=readconfig.getPassword();
public WebDriver driver;
public Logger logger;




@Parameters("browser")
@BeforeClass
public void setup(String browser) {
	logger=Logger.getLogger("E-CommerceAutomationProject");
	DOMConfigurator.configure("log4j.xml");
	if(browser.equals("chrome")) {
	//WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}else if(browser.equals("firefox")) {
		//WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
}


public void set() {
	
	
	logger=Logger.getLogger("E-CommerceAutomationProject");
	DOMConfigurator.configure("log4j.xml");
	//WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	
}


@AfterClass
public void tearDown() {
	driver.quit();
}

public void login() {
	
	HomePage hp=new HomePage(driver);
    
    VisibleOfElement(hp.lnkMyaccount);
	hp.clickMyAccount();
	logger.info("Clicked on My Account ");
    VisibleOfElement(hp.linkLogin);
    hp.clickLogin();
	logger.info("Clicked on Login ");
	
	LoginPage lp=new LoginPage(driver);
	
	lp.setEmail(username);
	logger.info("Provided Email ");
	
	lp.setPassword(password);
	logger.info("Provided Password ");
	
	lp.clickLogin();
	logger.info("Clicked on Login");
	
	
	boolean targetpage=lp.isMyAccountPageExists();
	
	if(targetpage)
	{
		logger.info("Login Success ");
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Login is Failed ");
		captureScreen(driver, "test_Login"); //Capturing screenshot
		Assert.assertTrue(false);
	}
}	




public void elementToVisibleAndHover(WebElement ele) {
	try
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(35));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).perform();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
}
public boolean elementIsVisible_Or_Not(WebElement ele) {
	
	try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return true;
	} catch (Exception e) {
		return false;
	}
	

}

public void VisibleOfElement(WebElement ele) {
	
	try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void captureScreen(WebDriver driver,String SName) {
	
	try {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshort/"+SName+".png");
		FileHandler.copy(src, target);
		System.out.println(" screenshort is taken");
	} catch (IOException e) {
		System.out.println("while taking screen short: "+e.getMessage());
		
	}
	
}

public boolean isAlertPresent() {
	
	try {
		driver.switchTo().alert();
		return true;
	} catch (NoAlertPresentException e) {
		return false;
	}
}

public void ScreenshortOnParticularElement(WebElement ele,String sName) {
	File src = ele.getScreenshotAs(OutputType.FILE);
	File target=new File("./Screenshort/"+sName+".png");
	try {
		FileHandler.copy(src, target);
	} catch (IOException e) {
		
		System.out.println("while taking screen short: "+e.getMessage());
	}
	
}

public void clickOnDropDown(WebElement ele) {
	Select select =new Select(ele);
	//select.selectByVisibleText(text);
}

public void selectByValue(WebElement ele,String value) {
	Select select=new Select(ele);
	select.selectByValue(value);
	
}
}
