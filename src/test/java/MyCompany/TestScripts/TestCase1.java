package MyCompany.TestScripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.internal.BytecodeGen.Visibility;

public class TestCase1 {
	
	String homeDirectory = System.getProperty("user.dir");
	String dir = homeDirectory + "\\src\\test\\java\\MyCompany\\Dependecy\\chromedriver.exe";
	String appUrl = "https://the-internet.herokuapp.com/";
	WebDriver driver;
	
	@Before
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", dir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appUrl);		
	}

	@Test
	public void TC001_ClickFunction() throws Exception {
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//Explicit wait
		WebDriverWait eWait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//a[contains(text(), 'A/B Testing')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(), 'Elemental Selenium')]")).click();
		eWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//a[contains(text(), 'Elemental Selenium')]")));
		//driver.findElement(By.cssSelector("div>h1"));
		//boolean result = driver.findElement(By.cssSelector("[class='subheader']")).isDisplayed();
		//Assert.assertEquals("Validating Home page is displayed or not", true, result);
	}
	
	@Test
	public void TC002_TabularContent() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Challenging DOM')]")).click();
	}
	
	@After
	public void FinalSetup() {
		driver.quit();;		
	}
}
