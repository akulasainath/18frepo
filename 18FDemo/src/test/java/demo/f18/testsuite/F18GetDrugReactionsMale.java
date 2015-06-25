package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.FrameworkConstants;
import demo.f18.testing.util.TestConfig;

public class F18GetDrugReactionsMale extends TestConfig {

	@Test(priority=0)
	
	public void DrugReactionForMale() {
		F18HomePage drugreactionsMale = new F18HomePage(driver);
		
		drugreactionsMale.verifyLandingPage();
		drugreactionsMale.enterSearchDrug("Advil");
		drugreactionsMale.selectSexTypeMale();
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		try {
			drugreactionsMale.getDrugReactions();
			} catch (Exception e) {
				log("Reactions data is not displayed", FrameworkConstants.METHOD);	
				  throw new RuntimeException(e);	
			}
		drugreactionsMale.closeBroswer();
	}
}
