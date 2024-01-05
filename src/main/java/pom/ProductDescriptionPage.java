package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage {
	@FindBy(xpath="//img[@class='square']")private WebElement product;
	@FindBy(xpath="//div[@class='display_none']//h1")private WebElement productName;
	@FindBy(xpath="//span[@class='offer-price']")private WebElement price;
    @FindBy(xpath="////span[@class=\"ship-price\"]")private WebElement shippingCharges;   
    @FindBy(xpath="//a[@title=\"Buy online\"]")private WebElement clickHereToBuy;
    
	
	
	public ProductDescriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clickOnProduct() {
		product.click();
		
	}
	  public String getproductName() {
        return productName.getText();
     	
     }
	  public void getProductPrice()
      {
      	price.getText();
      
      }
      public void clickOnclickHereToBuy()
      {
    	
      	clickHereToBuy.click();
      }
      public String getShippingCharges()
      {
      	String charges=shippingCharges.getText();
      	String [] charge=charges.split(" ");
      	return charge[1];
      }
     

}
