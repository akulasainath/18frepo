package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.TestConfig;

public class F18EnterDrug extends TestConfig {

	@Test(priority=0)
	public void enterDrugDetails () throws Exception {
		F18HomePage enterdrugdetails = new F18HomePage(driver);		

		enterdrugdetails.verifyLandingPage();
		enterdrugdetails.enterSearchDrugFromExcelFile(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\DrugDetails.xls");
		enterdrugdetails.closeBroswer();
	}
	
	
}
 