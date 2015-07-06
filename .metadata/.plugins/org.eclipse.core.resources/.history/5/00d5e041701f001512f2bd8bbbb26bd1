package demo.f18.testing.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import demo.f18.testing.util.BaseTestUtil;


public class F18HomePage extends BaseTestUtil {

	public F18HomePage(WebDriver driver) {
		super(driver);
	
	}
	By clickSearchDrugReaction = By.xpath("html/body/data-ng-view/div/div/div/div/div/div[2]/div/div/div[3]/div/a/button");
	By SearchDrugs= By.id("suggestGeneric");
	By ButtonOk = By.id("addDrug");
	By USCheckBox = By.id("countryUS");
	By OutcomeSeriousCheckbox = By.id("seriousOutcome");

	By selectedDrug1 = By.id("selectedDrugs0");
	By Delete1 = By.id("removeDrug0");
	By SelectedDrug2 = By.id("selectedDrugs1");
	By Delete2 = By.id("removeDrug1");
	
	By SelectSexAll = By.id("genderAll");
	By SelectSexMale = By.id("genderMale");
	By SelectSexFemale = By.id("genderFemale");
	
	//method to verify the landing page
	public void verifyLandingPage(){	
		
		waitForElementDisplayed(clickSearchDrugReaction);
		Assert.assertEquals(isElementPresent(clickSearchDrugReaction), true);
		WebElement element= driver.findElement(clickSearchDrugReaction);
		
		mouseOver(element);
		
		click(clickSearchDrugReaction);
		
		isTextDisplayed("h5", "Search Drugs by Generic Name");
		isTextDisplayed("h5", "Search Drugs by Brand Name");	
				
		}	
	
	//method to search for a drug name
	public void enterSearchDrug(String drugName) {
		waitForElementDisplayed(SearchDrugs);
		
		Assert.assertEquals(isElementPresent(SearchDrugs), true);
		
		driver.findElement(SearchDrugs).sendKeys(drugName);
		
		WebElement element= driver.findElement(ButtonOk);
		
		mouseOver(element);
		
		click(ButtonOk);
		
	}
	
	public void enterSearchDrugFromExcelFile(String fileName) throws Exception{
		String[][] drugData = getExcelData(fileName);
		int rowCount = 0;
		for(String[] drugRow : drugData) {
			if(rowCount > 0) {
				String drugName = drugRow[0];
				String useThisDrug = drugRow[1] ;
				if(useThisDrug.equals("Y")) {
					enterSearchDrug(drugName);
				} else {
					System.out.println("Skipping drug "+drugName);
				}
			}
			rowCount++ ;
		}
	}
	
	//to choose filters currently "US"
	public void selectCountryFilters() {
		waitForElementDisplayed(USCheckBox);
		Assert.assertEquals(isElementPresent(USCheckBox), true);
		WebElement element= driver.findElement(USCheckBox);
		
		mouseOver(element);
		
		click(USCheckBox);
	}
	
	//to delete the selected drug
	public void deleteSelectedDrug() {
		waitForElementDisplayed (selectedDrug1);
		Assert.assertEquals(isElementPresent(selectedDrug1), true);
		waitForElementDisplayed(Delete1);
		click(Delete1);
	}
	
	//to get reactions for the drugs, all table values
	public void getDrugReactions() {
		List<List<String>> reactionValues = getTableValues ("tablePrimary");
		Assert.assertEquals(isElementPresent(By.id("tablePrimary")), true);

	}

	//to check sex type as all
	public void selectSexTypeAll() {
		waitForElementDisplayed(SelectSexAll);
		
		WebElement element= driver.findElement(SelectSexAll);
		
		mouseOver(element);
		
		click(SelectSexAll);
	}
	
	//to check sex type as male
	public void selectSexTypeMale() {
		waitForElementDisplayed(SelectSexMale);
		
		WebElement element= driver.findElement(SelectSexMale);
		
		mouseOver(element);
		
		click(SelectSexMale);
	}
	
	//to check sex type as female
	public void selectSexTypeFemale() {
		waitForElementDisplayed(SelectSexFemale);
		
		WebElement element= driver.findElement(SelectSexFemale);
		
		mouseOver(element);
		
		click(SelectSexFemale);	
	}
	
	//to check outcome checkbox: serious
	
	public void selectOutcomeSerious() {
		waitForElementDisplayed(OutcomeSeriousCheckbox);
		
		WebElement element= driver.findElement(OutcomeSeriousCheckbox);
		
		mouseOver(element);
		
		click(OutcomeSeriousCheckbox);	
	}
	
	//public void closeBroswer(){
		//driver.quit();
	//}
}

