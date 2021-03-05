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

import banking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	public ExtentReports extent;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {		
		//logger = Logger.getLogger("banking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",readconfig.getEdgepath());
			driver = new EdgeDriver();
		}
		
		//Time stamp for each report for Store the history of all the reports
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test Report-"+timeStamp+".html";
		
		
		//Report Method
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-outout/"+repName);
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
	
}
