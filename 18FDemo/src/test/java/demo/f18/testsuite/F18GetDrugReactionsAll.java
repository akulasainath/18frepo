package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.FrameworkConstants;
import demo.f18.testing.util.TestConfig;

public class F18GetDrugReactionsAll extends TestConfig {

	@Test(priority=0)
	
	public void DrugReactionsAll() {
		F18HomePage drugreactionsall = new F18HomePage(driver);
		
		drugreactionsall.verifyLandingPage();
		drugreactionsall.enterSearchDrug("Advil");
		drugreactionsall.selectSexTypeAll();
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		try {
		drugreactionsall.getDrugReactions();
		} catch (Exception e) {
			log("Reactions data is not displayed", FrameworkConstants.METHOD);	
			  throw new RuntimeException(e);	
		}
		
		drugreactionsall.closeBroswer();
	}
}
