package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.FrameworkConstants;
import demo.f18.testing.util.TestConfig;

public class F18LandingPageTest extends TestConfig {
	
	@Test(priority=0)
	public void testLandingPage() {		
		F18HomePage landingPage= new F18HomePage(driver);		
		log("Verify the [Title] of the page", FrameworkConstants.ASSERTS);
		fail("Title Verified",	landingPage.getWebDriver().getTitle(),	"Drug Reaction Research Report");	
		fail("Current Url Verified",landingPage.getWebDriver().getCurrentUrl(), "http://openfda.ventera.com/demo/#/");
		log("Verify Text on the Page", FrameworkConstants.TEST);
		landingPage.verifyLandingPage();
		landingPage.closeBroswer();
				
	}
	

}
