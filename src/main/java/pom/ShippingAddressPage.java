package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
	
	@FindBy(xpath="//select[@name='fktitle_id']")private WebElement title;
	@FindBy(xpath="//input[@name='firstName']")private WebElement firstName;
	@FindBy(xpath="//input[@name='lastName']")private WebElement lastName;
	@FindBy(xpath="//textarea[@name='address']")private WebElement address;
	@FindBy(xpath="//input[@name='landmark']")private WebElement landMark;
	@FindBy(xpath="//input[@name='pincode']")private WebElement pinCode;
	@FindBy(xpath="//select[@name='state']")private WebElement countryState;
	@FindBy(xpath="//select[@name='city']")private WebElement city;
	@FindBy(xpath="//input[@name='mobile']")private WebElement mobileNumber;
	//@FindBy(xpath="//input[@name='landline']")private WebElement landline;
	@FindBy(xpath="//a[@onclick='myAddressBook.validateForm()']")private WebElement addNewAddress;
	@FindBy(xpath="//a[text()='Save & Proceed']")private WebElement saveButton;
	@FindBy(xpath=" //span[text()='Ship to This Address'] ")private WebElement shiptToThisAddress;
	@FindBy(xpath="//label[text()='	Cash On Delivery']")private WebElement cashOnDelivery;
	@FindBy(xpath="//a[text()='Click here to Place Order']")private WebElement clickHereToPlaceOrder;
	
	
	
	public ShippingAddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void selectTitle(String Title) {
		Select select=new Select(title);
		select.selectByVisibleText(Title);
		
	}
	public void enterFirstName(String firstname) {
	    firstName.sendKeys(firstname);
		
	}
	public void enetrLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	public void enterAddress(String addr) {
		address.sendKeys(addr);
	}
	public void enterLandMark(String landmark) {
		landMark.sendKeys(landmark);
	}
	public void enterPinCode(String pincode) {
		pinCode.sendKeys(pincode);
	}
	public void selectCountryState(String state) {
		Select select=new Select(countryState);
		select.selectByVisibleText(state);
		
	}
	public void selectCity(String City)
	{
		
			Select select=new Select(city);
			select.selectByVisibleText(City);
	}
	public void enterMobileNo(String number) {
		mobileNumber.sendKeys(number);
	}
	public void ClickSaveButton() {
	    saveButton.click();
	}
	public void clickShiptToThisAddress() {
		shiptToThisAddress.click();
	}
	public void clickPnAddNewAddress() {
		addNewAddress.click();
	}
    public void clickOnHereToPlaceOrder() {
    	clickHereToPlaceOrder.click();
    }
}
 