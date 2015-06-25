package demo.f18.testing.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import demo.f18.testing.util.BaseTestUtil;


public class F18HomePage extends BaseTestUtil {

	public F18HomePage(WebDriver driver) {
		super(driver);
	
	}
	
	By SearchDrugs= By.id("suggestGeneric");
	By ButtonOk = By.className("input-group-addon");
	By USCheckBox = By.xpath("html/body/div[2]/div/div/div/div[3]/div[2]/label/input");
	By OutcomeSeriousCheckbox = By.xpath("html/body/div[2]/div/div/div/div[3]/div[1]/label/input");

	By SelectedDrug1 = By.xpath("html/body/div[2]/div/div/div[1]/div[2]/div/div[1]");
	By Delete1 = By.xpath("html/body/div[2]/div/div/div[1]/div[2]/div/div[2]/span");
	By SelectedDrug2 = By.xpath("//*[@id='map']/div[1]/div[3]/div[2]/div[1]/span");
	By Delete2 = By.xpath("//*[@id='map']/div[1]/div[3]/div[2]/div[2]/span");
	
	By SelectSexAll = By.xpath("//input[@name='sex' and @value='']");
	By SelectSexMale = By.xpath("//input[@name='sex' and @value='1']");
	By SelectSexFemale = By.xpath("//input[@name='sex' and @value='2']");
	By ButtonSearchDrug = By.xpath("html/body/div[2]/div/div/div/div/div/div[3]/div/a/button");

	
	public void clickSearchDrugButton(){	
		//System.out.println("src" + driver.getPageSource());
		WebElement element= driver.findElement(ButtonSearchDrug);		
		mouseOver(element);		
		click(ButtonSearchDrug);

	}
	//method to verify the landing page
	public void verifyLandingPage(){	

		isTextDisplayed("h5", "Search Drugs by Generic Name");
		isTextDisplayed("h5", "Search Drugs by Brand Name");	
				
		}	
	
	//method to search for a drug name
	public void enterSearchDrug(String drugName) {
		waitForElementDisplayed(SearchDrugs);
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
		
		WebElement element= driver.findElement(USCheckBox);
		
		mouseOver(element);
		
		click(USCheckBox);
	}
	
	//to delete the selected drug
	public void deleteSelectedDrug() {
		isElementPresent (SelectedDrug1);
		waitForElementDisplayed(Delete1);
		click(Delete1);
	}
	
	//to get reactions for the drugs, all table values
	public void getDrugReactions() {
		getTableValues ("tablePrimary");
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

