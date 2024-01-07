package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.reactivex.rxjava3.functions.Action;

public class NaptoolHomePage {
	@FindBy(xpath="//a[text()='Log In / Register']")private WebElement login;
	@FindBy(xpath="//a[text()='Track Order']")private WebElement trackOrder;
	@FindBy(xpath="//span[@class='arrowNav']")private WebElement shoppingCategoriesDropdown;
	@FindBy(xpath="//ul[@id='mainMenu_UL']//li")private List<WebElement> categories;
	@FindBy(xpath="(//a[text()='Mobile Handsets'])[1]")private WebElement subCategories;
	@FindBy(xpath="//li[@class='head']//h1")private WebElement categoryHeadings;
	@FindBy(xpath="//input[@name='header_search_text']")private WebElement search;
	@FindBy(xpath="(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement searchButton;
	@FindBy(xpath="(//a[@href='#ShoppingCartBox'])[2]")private WebElement addtoCart;

	
    public NaptoolHomePage(WebDriver driver)
    {
    	
    		PageFactory.initElements(driver,this);
    }
    	public void clikonLogin()
    	{
    	 login.click();
    	}
    	
    	public void clickTrackorder()
    	{
    		trackOrder.click();
    	}
    	public void clickonshoppingCategoriesdropdown() {
    		shoppingCategoriesDropdown.click();
    	}
    	public void selectShoppingCategories(WebDriver driver,int index) {
    		Actions action=new Actions(driver);
    		action.moveToElement(categories.get(index));
    		action.perform();
    		subCategories.click();
    	}
    	public String getCategoryHeading() {
    		return categoryHeadings.getText();
    	}
    	public void enterproductName(String productName)
    	{
    	search.sendKeys(productName);
    	
    	}
    	
    	public void clickOnSearch()
    	{
    		searchButton.click();
    }
    	
    	public void clickonaddtocart()
    	{
    		addtoCart.click();
    	}
}
