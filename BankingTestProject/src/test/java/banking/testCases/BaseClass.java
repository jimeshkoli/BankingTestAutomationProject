package banking.testCases;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;


public class BaseClass {
	public String baseURL="http://demo.guru99.com/V1/index.php";
	public String username = "mngr136913";
	public String password = "abc321!";
	public static WebDriver driver;
	public static Logger logger;
	public ExtentReports extent;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {		
		logger = Logger.getLogger("banking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		//Time stamp for each report 
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//String repName = "Test Report-"+timeStamp+".html";
		
		
		//Report Method
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("MyReport.html");
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("Test Report");
		extent.attachReporter(spark);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
	
}
