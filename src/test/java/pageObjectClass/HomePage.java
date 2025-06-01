package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver){
		super(driver);
	}
//	Locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")WebElement MyAccount_BTN;
	@FindBy(xpath = "//a[normalize-space()='Register']")WebElement Register_BTN;
	@FindBy(xpath = "//a[normalize-space()= 'Login']") WebElement Login_BTN;


	//actions methods
	public void clickMyAccount() {
		MyAccount_BTN.click();
	}

	public void clickRegister() {
		Register_BTN.click();
	}
	public void clickLogin() throws InterruptedException {
		Thread.sleep(4);
		Login_BTN.click();
	}
	

}
