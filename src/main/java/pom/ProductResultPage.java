package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductResultPage extends BasePage {
	
	@FindBy(xpath="//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy(xpath="//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement> quickView;
	@FindBy(xpath="//div[@class='item_title']")private List<WebElement> productName;
	@FindBy(xpath="//span[@class='offer-price'][1]")private WebElement price;

	
	 public ProductResultPage(WebDriver driver)
	 {
		 PageFactory.initElements( driver,this);
	 }
	 public int getNumberOfProduct() {
		return products.size();
	 }
	 public void clickOnQuickView(WebDriver driver,int product) {
		 Actions action=new Actions(driver);
		 action.moveToElement(products.get(product));
		 action.perform();
		 quickView.get(product).click();
	 }
	 public void clickOnProduct(int product) {
		 products.get(product).click();
	 }
	 public String getProductName(int product) {
		return productName.get(product).getText();
	 }
	 public double getPrice(int index)
	 {
		 return Double.parseDouble(price.getText());
	 }
	 
}


