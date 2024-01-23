package test;

 
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.NaptoolHomePage;
import utility.Reports;

@org.testng.annotations.Listeners(test.Listeners.class)

public class VerifyShoppingCategoriesTest extends BaseTest {
	ExtentReports extentReports;
	ExtentTest test;
	@Parameters ({"browser"})
	@BeforeMethod
	public void openApllication(String browser) {
		 driver =LaunchBrowser.browser(browser);
		
	}
	@BeforeMethod
	public void configureReports() {
		extentReports=Reports.generateReports();
	}
	@Test
	   public void verifyIfUserIsAbleToAccessShoppingCategories() {
		test=extentReports.createTest("verifyIfUserIsAbleToAccessShoppingCategories");
		NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
		naptoolHomePage.clickonshoppingCategoriesdropdown();
		naptoolHomePage.selectShoppingCategories(driver,3);
	    String currentTitle=driver.getTitle();
	    Assert.assertTrue(currentTitle.contains("Mobile Handsets"));
	  Assert.assertEquals(naptoolHomePage.getCategoryHeading(), "Mobiles : Mobile Handsets");
	
	}
	@Test
	public void verifyIsDisplayEnterProductNameInSearch() {
		NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
		naptoolHomePage.enterproductName("cooker");
		naptoolHomePage.clickOnSearch();
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("cooker"));
		Assert.assertEquals(naptoolHomePage.getCategoryHeading(),"Search Results For : cooker");
		
		
	}
	 // @AfterMethod
	 // public void postTest() {
	 // driver.close();
	//}
	@AfterTest
	public void publishReport() {
		extentReports.flush();
	}

}
