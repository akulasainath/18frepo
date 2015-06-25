package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.TestConfig;

public class F18DeleteDrugs extends TestConfig{

	@Test(priority=0)
	
	public void deleteDrug() {
		F18HomePage homePage= new F18HomePage(driver);		
		homePage.verifyLandingPage();
		homePage.enterSearchDrug("Advil");
		homePage.deleteSelectedDrug();
		homePage.closeBroswer();
	}
}
