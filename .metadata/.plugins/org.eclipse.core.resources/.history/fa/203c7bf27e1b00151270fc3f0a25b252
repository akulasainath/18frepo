package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.TestConfig;

public class F18GetDrugReactionsFemale extends TestConfig {

	@Test(priority=0)	
	public void drugReactionsForFemale() {		
		F18HomePage homePage = new F18HomePage(driver);		
		homePage.verifyLandingPage();
		homePage.enterSearchDrug("Advil");
		homePage.selectSexTypeFemale();
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		homePage.getDrugReactions();
		homePage.closeBroswer();
	}
}
