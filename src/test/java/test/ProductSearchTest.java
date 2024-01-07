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
    	 String currentTitle=driver.getTitle();
    	 SoftAssert softAssert=new  SoftAssert();
    	 softAssert.assertTrue(currentTitle.contains("Mobiles"));
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 softAssert.assertTrue(productResultPage.getNumberOfProduct()>0);
    	 softAssert.assertAll();
    	 
    	 
    	 
     }
     @Test
     public void verifyProductAreNotDisplayOnSearchValidSearch() {
    	 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
    	 naptoolHomePage.enterproductName("iphones");
    	 naptoolHomePage.clickOnSearch();
    	 String title=driver.getTitle();
    	 Assert.assertTrue(title.contains("iphones"));
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 Assert.assertTrue(productResultPage.getNumberOfProduct()==0);
    	 
    	 
    	 
    	  
     }
}
