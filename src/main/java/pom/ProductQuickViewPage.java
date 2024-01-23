package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuickViewPage {
	   
	
	      @FindBy(xpath="//div[@id='square_Details']//h1")private WebElement productName;
	      @FindBy(xpath="//span[@class='offer-price']")private WebElement price;
	      @FindBy(xpath="//span[@class='ship-price']")private WebElement shippingCharges;   
	      @FindBy(xpath="//a[@title='Buy online']")private WebElement clickHereToBuy;
	      
	   


            public ProductQuickViewPage(WebDriver driver)
            {
            	PageFactory.initElements(driver,this);
            }
            public String getproductName() {
               return productName.getText();
            	
            }
            public double getProductPrice()
            {
            	return Double.parseDouble(price.getText());
            
            }
            public void clickOnclickHereToBuy()
            {
            	clickHereToBuy.click();
            }
            public double getShippingCharges()
            {
            	String charges=shippingCharges.getText();
            	String [] charge=charges.split(" ");
            	
            	return Double.parseDouble(charge[1]);
            }
           
         
            }
