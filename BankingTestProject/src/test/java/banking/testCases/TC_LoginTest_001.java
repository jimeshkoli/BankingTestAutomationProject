package banking.testCases;
 
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import banking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	public TC_LoginTest_001() {
		
	}
	@Test
	public void loginTest() {
		
		ExtentTest test = extent.createTest("Login Test").assignAuthor("Jimeshk").assignCategory("Smoke Testing").assignDevice("Browser Testing");
		driver.get(baseURL);
		//logger.info("URL is opened");
		test.info("URL is opened");
		LoginPage lp = new LoginPage(driver); 
		
		lp.setUsername(username);
		//logger.info("Entered Username");
		test.info("Entered Username");
		
		lp.setPassword(password);
		//logger.info("Entered Password");
		test.info("Entered Password");
		
		lp.clickSubmit();
		
		
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			//logger.info("Login Test passed");
			test.pass("Login Test passed");
		}
		else {
			Assert.assertTrue(false);
			//logger.info("Login Test failed");
			test.fail("Login Test failed");
		}
	}	

}
