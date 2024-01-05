package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.LaunchBrowser;
import pom.NaptoolHomePage;
import pom.ProductResultPage;

public class ProductSearchTest extends BaseTest {
	@BeforeMethod
	public void openApllication() {
		driver=LaunchBrowser.chrome();
	}
     @Test
     public void verifyProductAreDisplayOnSearchValidSearch() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	naptoolHomePage.clickonshoppingCategoriesdropdown();
 		 naptoolHomePage.selectShoppingCategories(driver, 3);
 	     String currentTitle=driver.getTitle();
 	     SoftAssert softAssert=new  SoftAssert();
    	 softAssert.assertTrue(currentTitle.contains("Mobiles"));
    	softAssert.assertEquals( naptoolHomePage.getCategoryHeading(), "Mobiles : Mobile Handsets");
    	
    	
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 softAssert.assertTrue(productResultPage.getNumberOfProduct()>0);
    	 
    	 softAssert.assertAll();
    	 
    	 
    	 
     }
     @Test
     public void verifyProductAreNotDisplayOnSearchValidSearch() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 String title=driver.getTitle();
    	 SoftAssert softAssert=new  SoftAssert();
    	 softAssert.assertTrue(title.contains(" mobiles"));
    	 softAssert.assertEquals(naptoolHomePage.getCategoryHeading()," Mobiles : Mobile Handsets");
    	
 		
    	
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 Assert.assertTrue(productResultPage.getNumberOfProduct()==0);
    	 
    	 
    	 
     }
}
