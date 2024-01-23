package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.LoginPage;
import pom.NaptoolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import pom.ShippingAddressPage;

public class AddressPage extends BaseTest {
	
	
	@BeforeMethod
	public void openApllication() {
		driver=LaunchBrowser.browser("chrome");

    }
	@Test
	public void verifyShippingAddressAndSave() throws InterruptedException {
		
		 NaptoolHomePage naptoolHomePage=new NaptoolHomePage(driver);
		 naptoolHomePage.enterproductName("Mobiles");
    	 naptoolHomePage.clickOnSearch();
    	 
    	 ProductResultPage productResultPage=new ProductResultPage(driver);
    	 productResultPage.clickOnQuickView(driver, 0);
    	 
    	 ProductQuickViewPage productQuickViewPage=new ProductQuickViewPage(driver);
    	 productQuickViewPage.clickOnclickHereToBuy();
    	 CartPage cartPage=new CartPage(driver);
    	 cartPage.ClickOnProceedToCheckOut();
    	 LoginPage loginPage=new LoginPage(driver);
	
    	 loginPage.enterMobileNumber("7972615937");
    	 loginPage.ClickOnContinue();
    	 Thread.sleep(50000);
    	 loginPage.enterOTP("");
    	 loginPage.clickOnsubmit();
    	 ShippingAddressPage shippingAddressPage=new ShippingAddressPage(driver);
		 shippingAddressPage.selectTitle("Mrs.");
		 shippingAddressPage.enterFirstName("Priti");
		 shippingAddressPage.enetrLastName("Firame");
		 shippingAddressPage.enterAddress("Pune");
		 shippingAddressPage.enterLandMark("Temple");
		 shippingAddressPage.enterPinCode("411046");
		 shippingAddressPage.selectCountryState("MAHARASHTRA");
		 shippingAddressPage.selectCity("Pune");
		 shippingAddressPage.enterMobileNo("7972615937");
		 shippingAddressPage.ClickSaveButton();
		// shippingAddressPage.clickPnAddNewAddress();
		 shippingAddressPage.clickShiptToThisAddress();
		 shippingAddressPage.clickOnHereToPlaceOrder();
		 
		
	}
	
}
