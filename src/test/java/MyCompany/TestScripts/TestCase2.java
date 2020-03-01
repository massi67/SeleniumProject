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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.internal.BytecodeGen.Visibility;

public class TestCase2 {
	
	String homeDirectory = System.getProperty("user.dir");
	String dir = homeDirectory + "\\src\\test\\java\\MyCompany\\Dependecy\\chromedriver.exe";
	String appUrl = "https://the-internet.herokuapp.com/";
	WebDriver driver;
	
	@Before
	public void InitialSetup() {
		System.setProperty("webdriver.chrome.driver", dir);
		System.setProperty("webdriver.chrome.silentOutput", "true");
		//driver.manage().deleteAllCookies();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appUrl);		
	}

	@Ignore
	@Test
	public void TC006_DisappearingElementOnPageRefresh() throws Exception {
		try {
			driver.findElement(By.xpath("//a[contains(text(), 'Disappearing Elements')]")).click();
			Thread.sleep(2000);
			driver.findElements(By.xpath("//a[contains(text(), 'Gallery')]"));
			driver.findElement(By.xpath("//a[contains(text(), 'Gallery')]")).click();
		} catch(Exception e) {
			driver.navigate().refresh();
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("//a[contains(text(), 'Gallery')]"));
				driver.findElement(By.xpath("//a[contains(text(), 'Gallery')]")).click();
			} catch (Exception e1) {
				driver.navigate().refresh();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(), 'Gallery')]")).click();
			}
		}
		Thread.sleep(2000);
	}
	
	@Ignore
	@Test
	public void TC007_DragAndDrop() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(), 'Drag and Drop')]")).click();
		Thread.sleep(2000);
		//Element which needs to drag.    		
    	WebElement From = driver.findElement(By.xpath("//div[@id='column-a']"));	
    	//Element on which need to drop.		
    	WebElement To = driver.findElement(By.xpath("//div[@id='column-b']"));					
    	//Using Action class for drag and drop.		
    	Actions act = new Actions(driver);					
    	//Dragged and dropped.		
    	act.dragAndDrop(From, To).build().perform();
    	Thread.sleep(2000);
	}
	
	@Test
	public void TC008_DropDown() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(), 'Dropdown')]")).click();
		Thread.sleep(2000);
		Select drpCountry = new Select(driver.findElement(By.id("dropdown")));
		drpCountry.selectByVisibleText("Option 1");
		drpCountry.selectByIndex(2);
		List<WebElement> optionList = drpCountry.getOptions();
		System.out.println("optionList = "+optionList.size());
    	Thread.sleep(2000);
	}
	
	@After
	public void FinalSetup() {
		driver.quit();;		
	}
}
