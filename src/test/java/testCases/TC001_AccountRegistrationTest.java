package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectClass.AccountRegistrationPage;
import pageObjectClass.BasePage;
import pageObjectClass.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = "sanity")
	public void verify_account_registration() {
//		logger.info("Starting TC001");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
//		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
//		logger.info("Providing customer detail");
		regpage.setfirstName(randomstring().toUpperCase());
		regpage.setlastName(randomstring().toUpperCase());
		regpage.setEmail(randomstring()+"@gmail.com");
		
		String password = randomalphanumbericpass();
		regpage.setPhonenumber(randomnumber());
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.checkbox_privacylink();
		regpage.clickContinue();
//		logger.info("Validating expected message");
		String confirmmsg = regpage.msgConfirmation();
		Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
//			logger.error("Test Failed");
//			logger.debug("debug logs");
			Assert.fail();
		}
			
	}
	
	


}
