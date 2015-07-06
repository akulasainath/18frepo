package demo.f18.testsuite;

import org.testng.annotations.Test;

import demo.f18.testing.po.F18HomePage;
import demo.f18.testing.util.FrameworkConstants;
import demo.f18.testing.util.TestConfig;

public class EndtoEnd extends TestConfig{
	
	@Test(priority=0)
	public void testLandingPage() {
		F18HomePage landingPage= new F18HomePage(driver);
	    log("Verify the [Title] of the page", FrameworkConstants.ASSERTS);
		fail("Title Verified",	landingPage.getWebDriver().getTitle(),	"Open FDA Repo");	
		fail("Current Url Verified",landingPage.getWebDriver().getCurrentUrl(), "http://openfda.ventera.com/demo/#/");
		log("Verify Text on the Page", FrameworkConstants.TEST);
		landingPage.verifyLandingPage();
		//landingPage.closeBroswer();
				
	}
	
	@Test(priority=1)
	public void enterDrugDetails () throws Exception {
		F18HomePage enterdrugdetails = new F18HomePage(driver);		

		//enterdrugdetails.verifyLandingPage();
		enterdrugdetails.enterSearchDrugFromExcelFile(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\DrugDetails.xls");		
		//enterdrugdetails.closeBroswer();
	}
	
	@Test(priority=2)
	
	public void DrugReactionsAll() {
		F18HomePage drugreactionsall = new F18HomePage(driver);
		
		//drugreactionsall.verifyLandingPage();
		//drugreactionsall.enterSearchDrug("Advil");
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
		
		//drugreactionsall.closeBroswer();
	}

	@Test(priority=3)
	
	public void DrugReactionsInUS() {
		F18HomePage drugreactionsinUS = new F18HomePage(driver);
		
		//drugreactionsinUS.verifyLandingPage();
		//drugreactionsinUS.enterSearchDrug("Advil");
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
		//drugreactionsinUS.closeBroswer();
	}
	
	@Test(priority=4)
	
	public void DrugReactionsForFemale() {
		
		F18HomePage drugreactionsFemale = new F18HomePage(driver);
		
		//drugreactionsFemale.verifyLandingPage();
		//drugreactionsFemale.enterSearchDrug("Advil");
		drugreactionsFemale.selectSexTypeFemale();
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		try {
			drugreactionsFemale.getDrugReactions();
			} catch (Exception e) {
				log("Reactions data is not displayed", FrameworkConstants.METHOD);	
				  throw new RuntimeException(e);	
			}
		//drugreactionsFemale.closeBroswer();
	}

	@Test(priority=5)
	
	public void DrugReactionForMale() {
		F18HomePage drugreactionsMale = new F18HomePage(driver);
		
		//drugreactionsMale.verifyLandingPage();
		//drugreactionsMale.enterSearchDrug("Advil");
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
		//drugreactionsMale.closeBroswer();
	}
	
	@Test(priority=6)
	
	public void DrugReactionForOutcomeSerious() {
		F18HomePage drugreactionsoutcomeserious = new F18HomePage(driver);
		
		//drugreactionsoutcomeserious.verifyLandingPage();
		//drugreactionsoutcomeserious.enterSearchDrug("Advil");
		drugreactionsoutcomeserious.selectOutcomeSerious();
		
		
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		drugreactionsoutcomeserious.getDrugReactions();
		//drugreactionsoutcomeserious.closeBroswer();
	}
	
	@Test(priority=7)
	
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
