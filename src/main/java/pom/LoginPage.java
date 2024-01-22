package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	@FindBy(xpath="//a[text()='Log In / Register']")private WebElement login;
	@FindBy(xpath="(//input[@class='input-new'])[4]")private WebElement mobileNo;
	 @FindBy(xpath="(//input[@value='Continue'])[2]")private WebElement Continue;
	 @FindBy(xpath="(//input[@class='input-new'])[4]")private WebElement OTP;
	 @FindBy(xpath="//input[@id='gc-registration-otp-panel-submit']")private WebElement submit;
	 
	 public LoginPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }
	 
	 public void  enterMobileNumber(String number) {
		 mobileNo.sendKeys(number);
	 }
	 public void ClickOnContinue() {
		Continue.click();
		 
	 }
	 public void enterOTP(String OTPno) {
		 OTP.sendKeys(OTPno);
	 }
	 public void clickOnsubmit() {
		 submit.click();
	 }
	 public void clickOnLogin() {
		 login.click();
	 }

}
