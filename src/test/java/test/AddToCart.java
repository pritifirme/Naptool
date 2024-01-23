package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.ProductDescriptionPage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class AddToCart extends BaseTest {
	
	
	 ProductResultPage  productResultPage;
	 ProductQuickViewPage productQuickViewPage;
	 CartPage  cartPage;

	// @Parameters ({"browser"})
	@BeforeMethod
	public void openApllication() {
		driver=LaunchBrowser.browser("chrome");
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
    	 cartPage=new CartPage(driver);
    	 Assert.assertEquals(cartPage.getNumberOfProductPresentInCart(driver),1);
    	 
     }
     @Test
	public void verifyIfUserAbleToAddMultipleProductToCart() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 0);
    	 
    	 productQuickViewPage=new ProductQuickViewPage(driver);
    	 productQuickViewPage.clickOnclickHereToBuy();
    	 
    	 cartPage=new CartPage(driver);
    	 cartPage.clickOnContinueShopping();
    	
    	 productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 1);
    	 
    	  productQuickViewPage.clickOnclickHereToBuy();
    	  cartPage=new CartPage(driver);
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
    	 cartPage.clickOnRemove(driver);
    	  
    	 
    	 
     }
     @Test
	public void verifyIfUserIsAbleToAddToCartUsingProductDescription() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 String productTitle =productResultPage.getProductName(0);
    	 productResultPage.clickOnProduct(0);
    	 productResultPage.switchPage(driver, productTitle);
    	 
    	 ProductDescriptionPage productDescriptionPage =new ProductDescriptionPage(driver); 
    	 productDescriptionPage.clickOnclickHereToBuy(); 
     }
     @Test
     public void VerifyIfProductDetailsDisplayedInProductSearchResultSimilarToDetailDisplayedInQuickViewTab() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 String expectedProductName=productResultPage.getProductName(0);
    	 double expectedPrice=productResultPage.getPrice(0);
          productResultPage.clickOnQuickView(driver, 0);
          
         ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
     	 Assert.assertEquals(productQuickViewPage.getProductPrice(),expectedPrice);
          
    }
    	 @Test
    	 public void VerifyIfProductDetailOnShoppingCartAreSmiliarToProductAddedFromQuickViewTab() { 
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	  productResultPage=new ProductResultPage(driver);
     	 productResultPage.clickOnQuickView(driver, 0);
     	 
     	
    	productQuickViewPage=new ProductQuickViewPage(driver);
    	String expectedproductName=productQuickViewPage.getproductName();
    	System.out.println(expectedproductName);
        double expectedproductPrice=productQuickViewPage.getProductPrice();
        System.out.println(expectedproductPrice);
        
        double expectedshipping=productQuickViewPage.getShippingCharges();
        System.out.println(expectedshipping);
        productQuickViewPage.clickOnclickHereToBuy();
        
        cartPage=new CartPage(driver);
        Assert.assertEquals(cartPage.getProductName(0, driver),expectedproductName);
        Assert.assertEquals(cartPage.getunitPrice(0),expectedproductPrice);
        Assert.assertEquals(cartPage.getshippingPrice(0),expectedshipping);
      
      }
     @Test
     public void VerifyIfUnitPriceandShippingPriceIsEqualToOrderAmount(){
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 1);
    	 
    	 ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
    	 productQuickViewPage.clickOnclickHereToBuy();
        
    	 cartPage=new CartPage(driver);
    	 double unitPrice=cartPage.getunitPrice(0);
    	 System.out.println(unitPrice);
    	 double shippingPrice=cartPage.getshippingPrice(0);
    	 double orderAmount=cartPage.getorderAmount(driver,0);
    	 System.out.println(orderAmount);
    	 Assert.assertTrue(unitPrice+shippingPrice==orderAmount);
    	 
    	 
     }
     @Test
     public void AddTwoToCartAndVerifyIfUnitPriceShippingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 0);
    	 
    	 productQuickViewPage=new ProductQuickViewPage(driver);
    	 productQuickViewPage.clickOnclickHereToBuy();
    	 
    	 cartPage=new CartPage(driver);
    	 cartPage.clickOnContinueShopping();
    	
    	 productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 1);
    	 
    	 productQuickViewPage.clickOnclickHereToBuy();
    	 cartPage=new CartPage(driver);
   	    
           double orderAmount1=cartPage.getorderAmount(driver, 0);
    	 System.out.println(orderAmount1);
    	 double orderAmount2=cartPage.getorderAmount(driver, 1);
    	 System.out.println(orderAmount2);
    	 double expectedcartAmount=cartPage.getcartAmount();
    	 Assert.assertTrue(orderAmount1+orderAmount2==expectedcartAmount);
    	 
    	 
    	 
    	 
    
     }
     
}
     

