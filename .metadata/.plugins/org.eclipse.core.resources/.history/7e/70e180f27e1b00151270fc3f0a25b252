package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.TestConfig;

public class F18GetDrugReactionsOutcomeSerious extends TestConfig {

	@Test(priority=0)	
	public void drugReactionForOutcomeSerious() {
		F18HomePage homePage = new F18HomePage(driver);		
		homePage.verifyLandingPage();
		homePage.enterSearchDrug("Advil");
		homePage.selectOutcomeSerious();		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		homePage.getDrugReactions();
		homePage.closeBroswer();
	}
}
