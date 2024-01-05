package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.NaptoolHomePage;
import pom.ProductDescriptionPage;

public class AddCartFromProductDescription extends BaseTest {
	@BeforeMethod
	public void openApllication() {
		driver=LaunchBrowser.chrome();
	}
     @Test
     public void verifyIfUserIsAbleToAddToCartUsingQuickViewOption() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductDescriptionPage productDescriptionPage=new ProductDescriptionPage(driver);
    	 productDescriptionPage.clickOnProduct();
    	
    	 productDescriptionPage.clickOnclickHereToBuy();
    	 
	

}
}
