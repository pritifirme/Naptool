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
	@FindBy(xpath="(//a[@onclick='cart.continueShopping()'][1])")private WebElement continueShopping;
	@FindBy(xpath="////a[text()='Remove']")private  WebElement remove;
	
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
   
    	 
     }

