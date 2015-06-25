package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.TestConfig;

public class F18GetDrugReactionsOutcomeSerious extends TestConfig {

	@Test(priority=0)
	
	public void DrugReactionForOutcomeSerious() {
		F18HomePage drugreactionsoutcomeserious = new F18HomePage(driver);
		
		drugreactionsoutcomeserious.verifyLandingPage();
		drugreactionsoutcomeserious.enterSearchDrug("Advil");
		drugreactionsoutcomeserious.selectOutcomeSerious();
		
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		drugreactionsoutcomeserious.getDrugReactions();
		drugreactionsoutcomeserious.closeBroswer();
	}
}
