package demo.f18.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.FrameworkConstants;
import demo.f18.testing.util.TestConfig;

public class F18LandingPageTest extends TestConfig {
	
	
	@Test(priority=1)
	public void testLandingPage() {		
		F18HomePage landingPage= new F18HomePage(driver);			
		landingPage.clickSearchDrugButton();		
		log("Verify the [Title] of the page", FrameworkConstants.ASSERTS);
		fail("Title Verified",	landingPage.getWebDriver().getTitle(),	"Drug Reaction Research Report");	
		fail("Current Url Verified",landingPage.getWebDriver().getCurrentUrl(), "http://openfdatest.ventera.com/demo/#/drugs/");
		log("Verify Text on the Page", FrameworkConstants.TEST);
		//landingPage.verifyLandingPage();
		//landingPage.closeBroswer();
	
	}
	@Test(priority=2)
	public void enterDrugDetails () throws Exception {
		F18HomePage homePage = new F18HomePage(driver);
		//homePage.verifyLandingPage();
		homePage.enterSearchDrugFromExcelFile(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\DrugDetails.xls");
		homePage.closeBroswer();
	}	

		
				
	
	

}
