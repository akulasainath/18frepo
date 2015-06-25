package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.FrameworkConstants;
import demo.f18.testing.util.TestConfig;

public class F18DeleteDrugs extends TestConfig{

	@Test(priority=0)
	
	public void DeleteDrug() {
		F18HomePage deletedrug= new F18HomePage(driver);
		
		deletedrug.verifyLandingPage();
		deletedrug.enterSearchDrug("Advil");
		try{
		   deletedrug.deleteSelectedDrug();
		} catch (Exception e) {
		  log("Could be a possible error to delete drug or drug not found", FrameworkConstants.METHOD);	
		  throw new RuntimeException(e);	
		}
		
		deletedrug.closeBroswer();
	}
}
