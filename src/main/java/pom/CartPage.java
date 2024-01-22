package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	@FindBy(xpath="//ul[@id='cartData']")private List<WebElement> product;
	@FindBy(xpath="(//a[@onclick='cart.submitOrder()'])[1]")private WebElement proceedToCheckOut;
	@FindBy(xpath="(//a[@onclick='cart.continueShopping()'])[1]")private WebElement continueShopping;
	@FindBy(xpath="//a[text()='Remove']")private  WebElement remove;
	@FindBy(xpath="//div[@id='cartItems']//h2//a")private List<WebElement> productName;
	@FindBy(xpath="//div[@id='cartItems']//li[@class='head_UPrice']")private List<WebElement> unitPrice;
	@FindBy(xpath="//div[@id='cartItems']//li[@class='head_ship']")private List<WebElement> shippingPrice;
	@FindBy(xpath="//div[@id='cartItems']//li[@class='head_Amount']")private List<WebElement> orderAmount;
	@FindBy(xpath="//ul[@id='cartTotal']//label")private WebElement cartAmount;
	//@FindBy(xpath="//a[text()='Proceed to Checkout']")private WebElement proceedToCheckOut;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
     public int getNumberOfProductPresentInCart(WebDriver driver ) {
    	 WebDriverWait wait=new  WebDriverWait(driver,Duration.ofMillis(5000));
    	 wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
    	return product.size();
    	 
     }
     public void clickOnContinueShopping() {
    	 continueShopping.click();
     }
          
     public void clickOnRemove(WebDriver driver) {
    	  
      WebDriverWait wait=new  WebDriverWait(driver,Duration.ofMillis(5000));
      wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
      remove.click();
     }
        public String getProductName(int index,WebDriver driver) {
        	WebDriverWait wait=new  WebDriverWait(driver,Duration.ofMillis(5000));
        	wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
          return productName.get(index).getText();
        }
        public double getunitPrice(int index) {
        	return Double.parseDouble(unitPrice.get(index).getText().substring(3));
       }
        
        public double getshippingPrice(int index) {
    	  return Double.parseDouble(shippingPrice.get(index).getText().substring(3));    
    	}
        public double getorderAmount(WebDriver driver,int index) {
        	WebDriverWait wait=new  WebDriverWait(driver,Duration.ofMillis(5000));
        	wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
        	return Double.parseDouble(orderAmount.get(index).getText());
        }
        public double getcartAmount() {
        	return Double.parseDouble(cartAmount.getText().substring(3));
        }
        public void ClickOnProceedToCheckOut() {
        	proceedToCheckOut.click();
        }
		
}
   
    	 
     

