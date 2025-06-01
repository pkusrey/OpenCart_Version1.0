package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClass.AccountPage;
import pageObjectClass.HomePage;
import pageObjectClass.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups = "sanity")
	public void verify_login() {
//		logger.info("------TC002 starting-------");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
//		logger.info("------Click on login button-------");
		LoginPage lp = new LoginPage(driver);
		lp.setloginEmail(p.getProperty("email"));
		lp.setloginPassword(p.getProperty("password"));
		lp.ForgotPassword();
		lp.clickLoginBTN();
		
//		logger.info("------Account created-------");
		AccountPage ap = new AccountPage(driver);
		Boolean heading = ap.isMyAccountHeading();
		Assert.assertTrue(heading);
//		logger.info("------TC002 finish-------");
		}catch(Exception e) {
			Assert.fail();
		}
		
	}
}
