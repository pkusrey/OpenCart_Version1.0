	package pageObjectClass;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	
	public class LoginPage extends BasePage {
		
		public LoginPage(WebDriver driver){
			super(driver);
		}
		
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement loginpassword;
	@FindBy(xpath = "//input[@id='input-email']")WebElement loginemail;
	@FindBy(xpath = "//a[normalize-space()='Forgotten Password']")WebElement forgotpassword_link;
	@FindBy(xpath = "//input[@type='submit']") WebElement login_BTN;
	
	public void setloginEmail(String email) {
		loginemail.sendKeys(email);
	}
	public void setloginPassword(String password) {
		loginpassword.sendKeys(password);
	}
	public void clickLoginBTN() {
		login_BTN.click();
	}
	
	public void clickForgotPassword() {
		forgotpassword_link.click();
	}
	public Boolean ForgotPassword() {
		return forgotpassword_link.isDisplayed();
	}
	
	}
