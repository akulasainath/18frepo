package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.FrameworkConstants;
import demo.f18.testing.util.TestConfig;

public class F18GetDrugReactionsCountryUS extends TestConfig {

	@Test(priority=0)
	
	public void DrugReactionsInUS() {
		F18HomePage drugreactionsinUS = new F18HomePage(driver);
		
		drugreactionsinUS.verifyLandingPage();
		drugreactionsinUS.enterSearchDrug("Advil");
		drugreactionsinUS.selectCountryFilters();
		
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		try {
			drugreactionsinUS.getDrugReactions();
			} catch (Exception e) {
				log("Reactions data is not displayed", FrameworkConstants.METHOD);	
				  throw new RuntimeException(e);	
			}
		drugreactionsinUS.closeBroswer();
	}
}
