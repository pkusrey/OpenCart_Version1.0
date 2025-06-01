package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver){
		super(driver);
	}
	


@FindBy(xpath = "//h2[normalize-space()='My Account']")WebElement MyAccount_heading;

@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement Logout_BTN;

public Boolean isMyAccountHeading() {
	try {
		return (MyAccount_heading.isDisplayed());
	}catch(Exception e) {
		return false;
	}
	
}
public void clickLogout() {
	Logout_BTN.click();
}
	
}
