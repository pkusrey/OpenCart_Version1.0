package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}

	//locators
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txt_firstName;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txt_lastName;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txt_PhoneNumber;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txt_ConfirmPassword;
	@FindBy(xpath = "//input[@type='checkbox']") WebElement link_privacy;

	@FindBy(xpath = "//input[@value='Continue']") WebElement BTN_Continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;

	public void setfirstName(String firstname) {
		txt_firstName.sendKeys(firstname);
	}
	public void setlastName(String lastname) {
		txt_lastName.sendKeys(lastname);
	}
	public void setEmail(String email) {
		txt_Email.sendKeys(email);
	}
	public void setPhonenumber(String phonenumber) {
		txt_PhoneNumber.sendKeys(phonenumber);
	}
	public void setPassword(String password) {
		txt_Password.sendKeys(password);
	}
	public void setConfirmPassword(String password) {
		txt_ConfirmPassword.sendKeys(password);
	}
	public void checkbox_privacylink() {
		link_privacy.click();
	}
	public void clickContinue() {
		BTN_Continue.click();
	}
	public String msgConfirmation() {
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
	}
	


}
