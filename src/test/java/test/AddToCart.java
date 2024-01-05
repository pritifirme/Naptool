package test;

import org.openqa.selenium.WebDriver.Navigation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class AddToCart extends BaseTest {
	@BeforeMethod
	public void openApllication() {
		driver=LaunchBrowser.chrome();
	}
     @Test
     public void verifyIfUserIsAbleToAddToCartUsingQuickViewOption() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 0);
    	 
    	 ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
    	 productQuickViewPage.clickOnclickHereToBuy();
    	 
    	 CartPage cartPage=new CartPage(driver);
    	 Assert.assertEquals(cartPage.getNumberOfProductPresentInCart(driver),1);
    	 
     }
     @Test
     public void verifyIfUserAbleToAddMultipleProductToCart() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 0);
    	 
    	 ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
    	 productQuickViewPage.clickOnclickHereToBuy();
    	 
    	 CartPage cartPage=new CartPage(driver);
    	 Assert.assertEquals(cartPage.getNumberOfProductPresentInCart(driver),1);
    	 cartPage.clickOnContinueShopping();
    	 Navigation nav=driver.navigate();
    	 nav.forward();
    	 ProductResultPage productResult=new ProductResultPage(driver);
    	 productResult.clickOnQuickView(driver, 1);
    	 
    	  productQuickViewPage.clickOnclickHereToBuy();
    	  Assert.assertEquals(cartPage.getNumberOfProductPresentInCart(driver),2);
    	  
    	 
    }
     @Test
     public void verifyUserIsAbleToRemoveProductFromCart() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 0);
    	 
    	 ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
    	 productQuickViewPage.clickOnclickHereToBuy();
    	 
    	 CartPage cartPage=new CartPage(driver);
    	 Assert.assertEquals(cartPage.getNumberOfProductPresentInCart(driver),1);
    	 cartPage.clickOnRemove();
    	 
    	 
     }
     
     

}
