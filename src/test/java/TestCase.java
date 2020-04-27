

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase {
	
@Test(priority=2,enabled=false)
public void login() throws InterruptedException{

WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("http://magento.com");
driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
driver.findElement(By.id("email")).sendKeys("bhattmadhumita@gmail.com");
driver.findElement(By.id("pass")).clear();
driver.findElement(By.id("pass")).sendKeys("2345");
driver.findElement(By.id("send2")).click();

Thread.sleep(7000);
String error = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).getText();
System.out.println("Error: "+error);
Assert.assertEquals(error, "Invalid login or password.");
driver.quit();
}

@Test(priority=1)
public void register() {
}

}