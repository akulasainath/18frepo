package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.TestConfig;

public class F18GetDrugReactionsAll extends TestConfig {

	@Test(priority=0)	
	public void drugReactionsAll() {
		F18HomePage homepage = new F18HomePage(driver);
		
		homepage.verifyLandingPage();
		homepage.enterSearchDrug("Advil");
		homepage.selectSexTypeAll();
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		homepage.getDrugReactions();
		homepage.closeBroswer();
	}
}
