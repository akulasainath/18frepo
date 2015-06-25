package demo.f18.testing.po;

import org.openqa.selenium.WebDriver;

import demo.f18.testing.util.BaseTestUtil;


public class F18LandingPage extends BaseTestUtil {

	public F18LandingPage(WebDriver driver) {
		super(driver);
	
	}

	void verifyLandingPage(){			
		isTextDisplayed("h5", "Search Drugs by Generic Name");
		isTextDisplayed("h5", "Search Drugs by Brand Name");		
		}		
	
}

