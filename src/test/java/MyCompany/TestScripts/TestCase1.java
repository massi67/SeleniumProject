package MyCompany.TestScripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

	@Ignore
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
	
	@Ignore
	@Test
	public void TC002_TabularContent() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Challenging DOM')]")).click();
		List<WebElement> tableRow = driver.findElements(By.xpath("//tbody/tr[5]"));
		Thread.sleep(2000);
		System.out.println("tableRow = "+tableRow.size());
		for(int i=0; i<tableRow.size(); i++) {
			System.out.println(driver.findElement(By.xpath("//tbody/tr[5]/tr["+i+"]")).getText());
		}
	}
	
	@Ignore
	@Test
	public void TC003_CheckBox() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(), 'Checkboxes')]")).click();
		Thread.sleep(2000);
		boolean enabled = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isEnabled();
		if(enabled)
			driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		else
			Assert.assertFalse("Checkbox is not clickale!", 1==1);
		Thread.sleep(2000);
	}
	
	@Ignore
	@Test
	public void TC004_MouseAction() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(), 'Context Menu')]")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id("hot-spot"));
		actions.contextClick(elementLocator).perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}
	
	@Test
	public void TC005_WindowsPopupHandles() throws Exception{
		driver.findElement(By.xpath("//a[contains(text(), 'Digest Authentication')]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A); 
		robot.keyPress(KeyEvent.VK_D); 
		robot.keyPress(KeyEvent.VK_M); 
		robot.keyPress(KeyEvent.VK_I); 
		robot.keyPress(KeyEvent.VK_N); 
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_P); 
		robot.keyPress(KeyEvent.VK_A); 
		robot.keyPress(KeyEvent.VK_S); 
		robot.keyPress(KeyEvent.VK_S); 
		robot.keyPress(KeyEvent.VK_W);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_D);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	@After
	public void FinalSetup() {
		driver.quit();;		
	}
}
