package MyCompany.TestScripts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class SampleTest {

	@Test
	public void Sample_Test() {
		try {
			String homeDirectory = System.getProperty("user.dir");
			String dir = homeDirectory + "\\src\\test\\java\\MyCompany\\Dependecy\\chromedriver.exe";
			System.out.println("dir = "+dir);
			System.setProperty("webdriver.chrome.driver", dir);
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.google.co.in");
			driver.findElement(By.cssSelector("[title='Search']")).sendKeys("Gold Fish");
			driver.findElement(By.cssSelector("[title='Search']")).sendKeys(Keys.ENTER);
			boolean result = driver.findElement(By.xpath("//h3[contains(text(),'Goldfish - Wikipedia')]")).isDisplayed();
			if(result==true)
				System.out.println("Test case Passed.");
			else
				System.out.println("Test case Failed.");
			Thread.sleep(2000);
			driver.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
