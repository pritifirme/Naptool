package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
	
	@FindBy(xpath="(//td//p)[2]")private WebElement productName;
	@FindBy(xpath="//td[text()='699']")private WebElement productPrice;
	@FindBy(xpath="(//td[@align='center'])[4]")private WebElement shipping;
	@FindBy(xpath="(//td[@align='center'])[8]")private WebElement totalAmount;
	
	public OrderSummaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public String getProductName() {
		return productName.getText();
	}

	public String getProductPrice() {
	    String product=productPrice.getText();
		return product;
		}
	public void getShipping() {
		shipping.getText();
	}
	public double getTotalAmount() {
		String amount=totalAmount.getText();
		String [] totalAmount=amount.split("");
		return Double.parseDouble(totalAmount[0]);
	}
	
}
