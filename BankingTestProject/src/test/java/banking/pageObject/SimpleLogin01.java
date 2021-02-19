package banking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SimpleLogin01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.guru99.com/V1/index.php");
		
		driver.findElement(By.name("uid")).sendKeys("mngr136913");
		driver.findElement(By.name("password")).sendKeys("abc321!");
		driver.findElement(By.name("btnLogin")).click();
		
		//String hometext = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/h2[1]")).getText();
		//System.out.println("Page Title is : " +driver.getTitle());
		String hometext = driver.getTitle();
		Assert.assertTrue(hometext.contains("GTPL Bank Manager HomePage"));
		System.out.println("Login Suceesful");
		
		driver.close();
	}
}
