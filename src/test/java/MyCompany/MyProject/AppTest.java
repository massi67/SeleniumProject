package MyCompany.MyProject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws Exception 
     */
    @Test
    public void SampleTest() throws Exception
    {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Roland\\eclipse-workspace\\MyProject\\chromedriver.exe");
        driver.get("http://www.google.co.in");
        Thread.sleep(2000);
        driver.close();
    }
}
