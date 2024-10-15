package com.amazon.testCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.amazon.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
public ReadConfig readconfig=new ReadConfig();
public String url=readconfig.getApplicationURL();
public String username=readconfig.getUserName();
public String password=readconfig.getPassword();
public WebDriver driver;
public Logger logger;



@Parameters("browser")
@BeforeClass
public void setup(String browser) {
	ChromeOptions opt=new ChromeOptions();
	logger=Logger.getLogger("E-CommerceAutomationProject");
	DOMConfigurator.configure("log4j.xml");
	if(browser.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
}


public void set() {
	
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--incognito");
	//opt.addArguments("--headless");
	//opt.addArguments("--disable-gpu");
	//opt.addArguments("--no-sandbox");
	logger=Logger.getLogger("E-CommerceAutomationProject");
	DOMConfigurator.configure("log4j.xml");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	logger.info("url is open");
}


@AfterClass
public void tearDown() {
	driver.quit();
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

public void VisibleOfElementAndClick(WebElement ele) {
	
	try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		
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
}
