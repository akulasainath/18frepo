package demo.f18.testing.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;


public abstract class BaseTestUtil {
	
	protected Logger logger = Logger.getLogger( this.getClass() );
	
	protected static final String ROOT_DIR = System.getProperty("user.dir");
	protected static final String PATH_SEPARATOR = System.getProperty("file.separator");
	public static Properties config = new Properties();
	
	protected WebDriver driver;
	final int DRIVER_WAIT = 4;
	
	
	/*
	 * Constructor injecting the driver interface
	 * 
	 * @param driver
	 */
	public BaseTestUtil(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		waitForPageToLoad();
	}

	/**
	 * Returns current driver instance
	 * 
	 * @return
	 */
	

	public final String getCurrentUrl(){
		return getWebDriver().getCurrentUrl();
	}
	
	/**
	 * Returns current-page-title
	 * 
	 * @return
	 */
	public final String getTitle() {
		return driver.getTitle();
	}
	
	

	/**
	 * Pauses test execution for given mili-seconds
	 * 
	 * @param miliSeconds
	 */
	public static void pauseMilis(int miliSeconds){
		try { 
			Thread.sleep(miliSeconds); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * Returns first selected option for given by element
	 * 
	 * @param by
	 * @return
	 */
	public String getFirstSelectedOption(By by){
		Select select = new Select(driver.findElement(by));
		return select.getFirstSelectedOption().getText().trim();
	}
	
	/**
	 * Selects a given option from the-list-of-available-options
	 * 
	 * @param by
	 * 
	 */	
	public String getSelectedOption(By by){
		Select select = new Select(driver.findElement(by));
        List<WebElement> list = select.getOptions();
        for (WebElement option : list) {
        	if(option.isSelected()){
        		return option.getText();
        	}
        }
        return null;
	}
	
	/**
	 * Selects a given option from the-list-of-available-options
	 * 
	 * @param element
	 * 
	 */	
	public String getSelectedOption(WebElement element){
		Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        for (WebElement option : list) {
        	if(option.isSelected()){
        		return option.getText();
        	}
        }
        return list.get(0).getText();
	}
	
	
	/**
	 * Waits for given text to appear on page
	 * If given text is not found, throws an error
	 * 
	 * @param by
	 * @param text
	 */
	public final void waitForText(By by, String text){
		List<WebElement> _elements = driver.findElements(by);
		if(_elements==null){
			throw new Error("Element not found > " + by);
		} else {
			for(WebElement _ele:_elements){
				if(_ele.getText().equals(text)){
					return;
				}
			}
			new Error("Expected element > " + by + " having text [" + text + "] not found on page!");
		}
	}
	
	/**
	 * Wait for given element with given text to be displayed on page
	 * If given element is not found, throws an error
	 * 
	 * @param _eleElement
	 * @param text
	 */
	
	
	
	public final boolean isElementDisplayed(WebElement _eleElement, String text){
		if(_eleElement.isDisplayed()){
			//log("Element:" + _eleElement,ELogLevel.METHOD);
			//log("COntent:|" + _eleElement.getText()+"|",ELogLevel.METHOD);
			if(_eleElement.getText().trim().contains(text.trim())){ return true;}
			else{
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Prints given message on console
	 * 
	 * @param msg
	 */
	public final void debug(String msg) {
		System.out.println("---------------------------------DEBUG------------------------------------------");
		System.out.println(msg);
		System.out.println("--------------------------------------------------------------------------------");
		
	}
	
	/**
	 * Returns true if given element is being displayed on current page  
	 * Else returns false
	 * 
	 * @param by
	 * @param pageName
	 * @return
	 */
	public final String isDisplayed(By by, String pageName){
	    try{
	    	return isDisplayed(driver.findElement(by), pageName);
	    } catch(Exception e) {
	    	return "";
	    }
	}

	/**
	 * Returns "TRUE" if given element is being displayed on current page  
	 * Else returns message "[<GivenElement>]Element not displayed on <CurrentPageName>"
	 * 
	 * @param _ele
	 * @param pageName
	 * @return
	 */
	
	
	/**
	 * Returns true if given element on given page is not displayed on current page
	 * Else returns false
	 * 
	 * @param _ele
	 * @param pageName
	 * @return
	 */
	public final boolean isNotDisplayed(WebElement _ele, String pageName){
		//log("....Checking visibility of element["+_ele + "]", "DoNotLog");
		try{
			if(_ele.isDisplayed()){
				return false;
			}
		} catch(NoSuchElementException nse){}
		return true;
	}
	
	/**
	 * Returns current page name
	 * 
	 * @param obj
	 * @return
	 */
	public final String getPageName(Object obj){
		return obj.getClass().getSimpleName();
	}
		
	/**
	 * Return substring
	 * 
	 * @param from
	 * @param start
	 * @param end
	 * @return
	 */
	public final String subString(String from, String start, String end){
		return from.substring(from.indexOf(start)+start.length(), from.indexOf(end));
	}
	
	/**
	 * Returns base-url
	 * 
	 * @return
	 */
	public String getBaseUrl(){
		String pattern = "(.*com/)";
	    // Create a Pattern object
	    Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(this.driver.getCurrentUrl());
	      if (m.find( )) {
	    	  System.out.println("BASE_URL[" + m.group(0) + "]");
	    	  return m.group(0);
	      } else {
	         return "NO MATCH";
	      }
	}
	
	/**
	 * Returns webelement from by locator
	 * 
	 * @param by
	 * @return
	 */
	
	
	public String getValue(By by){
		return getValue( element(by) );
	}
	
	public String getValue(WebElement element){
		return element.getAttribute("value").trim();
	}
	
	
	/**
	 * Returns true if given tag is being displayed with given text on current page
	 * Else returns false
	 * 
	 * @param tagName
	 * @param text
	 * @return
	 */
	public boolean isTextDisplayed(String tagName, String text){
		List<WebElement> elements = driver.findElements(By.tagName(tagName));
		for(WebElement _ele: elements){
			if( _ele.getText().trim().contains( text.trim() )){
				return true;
			}
		}
		return false;
	}	
	
	public void refresh(){
		getWebDriver().navigate().refresh();
		waitForPageToLoad();
	}
	

	public static void log(String msg, String logLevel) {
		  
		  if(msg.endsWith(".")) {
		   
		   msg=msg.substring(0, msg.length()-1) + "|" ; 
		  
		  } else {
		   
		   msg=msg + "|"; 
		   
		  }
		  
		  System.out.println( FrameworkConstants.SPACES_THREE + "|" + msg );
		  
		  
		  if(logLevel==FrameworkConstants.PAGE){
		   
		   Reporter.log("<br/><b><font color='DarkRed'>" + msg + "</font></b>");
		   
		  } else if(logLevel==FrameworkConstants.TEST){
		   
		   Reporter.log("<br/>" + FrameworkConstants.HTML_SPACE + "<font color='Green'>" + msg + "</font>");
		   
		  } else if(logLevel==FrameworkConstants.METHOD){ // add 3 space indentation
		   
		   Reporter.log("<br/>" + FrameworkConstants.HTML_SPACE_THREE + "<font color='Green'>" + msg + "</font>" );
		  
		  } else if(logLevel == FrameworkConstants.QUESTION){
		   
		   Reporter.log("<br/>" + FrameworkConstants.HTML_SPACE + "<i><font color='Yellow'>" + msg + "</font></i>");
		   
		  } else if(logLevel == FrameworkConstants.TO_DO_STEPS){
		   
		   Reporter.log("<br/>" + FrameworkConstants.HTML_SPACE + "TODO: <i><font color='Megenta'>" + msg + "</font></i>");
		   
		  } else if(logLevel == FrameworkConstants.ASSERTS){
		   
		   Reporter.log("<br/><b>" + FrameworkConstants.HTML_SPACE + "CHECKPOINT: <font color='Green'>" + msg + "</font></b>");
		   
		  } else if(logLevel == FrameworkConstants.TESTCASE){
		   
		   Reporter.log("<br/> <b>TESTCASE:<font color='Green'>" + msg + "</font></b>");
		   
		  } else if(logLevel == FrameworkConstants.PRE_CONDITION){
		   
		   Reporter.log("<br/> PRECONDITION:<b><font color='Megenta'>[" + msg + "]</font></b>");
		   
		  } else if(logLevel == FrameworkConstants.BUG){
		   
		   Reporter.log("<br/><font color='Red' style='background-color: yellow;'><b> BUG: [" + msg + "]</font> </b>");
		   
		  } else if(logLevel == FrameworkConstants.MANUAL_TESTING_NOTE){
		   
		   Reporter.log("<br/><font color='Black' style='background-color: yellow;'><b> Note For Manual Testers: </b>[" + msg + "]</font>");
		  
		  } else if(logLevel == FrameworkConstants.BUG_GIT_HUB_LINK){
		   
		   msg = msg.replace("|", FrameworkConstants.SPACE ) ;
		   Reporter.log("<br/><font color='Blue' style='background-color: yellow;'><b> ISSUE_Link:  "
		     + "<a href='"+ msg + "'>"
		       + "[" + msg + "]"
		         + " </a></font> </b>");
		   //throw new Error("Force-fail-manually. Check Bug description and Issue link in log");
		  } else if(logLevel == FrameworkConstants.ERROR ){
		   
		   Reporter.log("<br/> <b> <font color='Red' style='background-color: white;'> [" + msg + "]</font> </b>");
		  
		  } else if(logLevel == FrameworkConstants.WARNING ){
		   
		   Reporter.log("<br/> <b> <font color='Yellow' style='background-color: gray;'> [" + msg + "]</font> </b>");
		  
		  } else if(logLevel == FrameworkConstants.FAILURE ){
		   
		   Reporter.log("<br/> <b> <font color='Red' size='3' > [" + msg + "]</font> </b>");
		  
		  }  
		  
		 }
	
	public final boolean waitForElementDisplayed(By by) {
		  for(int sec=1; sec<=30; sec++){
		   try{
		    if ( driver.findElement(by).isDisplayed() ) {
		     Thread.sleep(1000);
				
		     return true;
		    }
		   }catch(Exception e){}
		   try{
		   Thread.sleep(1000);
		   }catch(Exception e){}
		  }
		  analyzeBrowserLogs();
			
		  return false;
		 }
	/**
	 * Pauses for given number of mili-seconds
	 * 
	 * @param miliSeconds
	 */
	public final void pauseMilis(long miliSeconds){
		try { 
			Thread.sleep(miliSeconds); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Pauses for given number of seconds
	 * 
	 * @param seconds
	 */
	public final void pause(int seconds){
		pauseMilis(seconds*500);  
	}
	
	/**
	 * Returns page-element from given [by] element found on page
	 * else returns null
	 * 
	 * @param by
	 * 
	 * @return WebElement
	 */
	public final WebElement element(By by){
		try{
			return driver.findElement(by);
		} catch(NoSuchElementException nse){
			return null;
		}
	}
	
	/**
	 * Get warning message if warning log appears
	 * else Error message 
	 * 
	 */

	public void analyzeBrowserLogs() {
		  
        LogEntries logEntries = getWebDriver().manage().logs().get(LogType.BROWSER);
        int error_counter = 0 ;
        List<String> logs = new ArrayList<String>();
        for (LogEntry entry : logEntries) {
         
         if (  entry.getLevel().toString().contains( "WARNING" ) ) {
          
          logs.add( getWarningLog( "WARNING[BROWSER]:" + entry.getMessage()  ) );
         
         } else if ( entry.getLevel().toString().contains( "ERROR" ) ) {
          
          logs.add( getErrorLog( "ERROR[BROWSER]:" + entry.getMessage() ) );
          error_counter ++ ;
         
         }
         //System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
	}
	/**
	 * Returns true if given element is displayed on page
	 * else returns false
	 * 
	 * @param by
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed(By by) {
		try {
			return isDisplayed( driver.findElement(by) ) ;
		} catch ( Exception nse ) {
			System.out.println("EXCEPTION FROM IS_DISPLAYED:" + nse.getMessage() );
			return false ;
		}
	}
	/**
	 * Returns true if given element is displayed on page
	 * else returns false
	 * 
	 * @param element
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed(WebElement element){
		try{
			//System.out.println( "ELEMENT:" + element );
			if (  element.isDisplayed()  ) {
				return true ;
			} else { return false; }
		} catch (Exception e) {
			return false; 
		}
	}

	/**
	 * Returns "TRUE" if given element is displayed on current page
	 * else returns <Error message with element details>
	 * 
	 * @param _ele
	 * @param pageName
	 * 
	 * @return String
	 */
	public final String isDisplayed(WebElement _ele, String pageName){
		//log("....Checking visibility of element["+_ele + "]", "DoNotLog");
		if(_ele.isDisplayed()){
			return "TRUE";
		}
		return "["+_ele+"]Element not displayed on "+pageName;
	}
	
	/**
	 * Returns driver if getting WebDriver 
	 *
	 */
	public final WebDriver getWebDriver() {
		  return driver;
		 }
	
	public final String getErrorLog( String errorMessage  ){
		  return "<br/> <b> <font color='Red' style='background-color: white;'> [" + errorMessage + "]</font> </b>" ;
		 }
		 
		 public final String getWarningLog( String warningMessage ){
		  return "<br/> <b> <font color='Yellow' style='background-color: gray;'> [" + warningMessage + "]</font> </b>" ;
		 }
		 /**
			 * Waits for given text to be displayed on current page
			 * 
			 * @param _eleElement
			 * @param text
			 */

		 public final void waitForElementDisplayed(WebElement _eleElement, String text) {
			 
			if(_eleElement.isDisplayed()){
				
				if(_eleElement.getText().equals(text)){
					
				}
					else{
						throw new Error("Element with text["+text+"] not found.");
					}
				} else {
					throw new Error("Element not displayed.");
				}
			}	

			/**
			 * Moves mouse over given [by] element
			 * 
			 * @param by
			 */
			public final void mouseOver(By by){
				WebElement element = driver.findElement(by);
				mouseOver(element);
			}
				
			/**
			 * Moves mouse over given [element] element
			 * 
			 * @param element
			 */
			public final void mouseOver(WebElement element){
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
				pauseMilis(100);
			}
			/**
			 * Returns true if given two nodes have same value in them
			 * else false
			 *  
			 * @param rowCell1
			 * @param colCell1
			 * @param rowCell2
			 * @param colCell2
			 * @return boolean
			 */
			public final boolean compareTwoNodeValues(int rowCell1, int colCell1, int rowCell2, int colCell2){
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				String result = "false"; 
				try{
					result = js.executeScript(
							"return vGraph.getNodeWithCoords("+ rowCell1 + "," + colCell1 +").value == "
									+ "vGraph.getNodeWithCoords("+ rowCell2 + "," + colCell2 +").value").toString();
				} catch(Exception e){
					result ="false";
				}

				if(result.equals("true")){
					return true;
				} else {
					return false;
				}
			}

		//===========================================CLICK-EVENT=========================================================
			/**
			 * Clicks on given [by] element
			 * 
			 * @param by
			 */
			public final void click(By by){
				WebElement element = driver.findElement(by);
				click(element);
			}
			
			/*public final void enterKeys(By by){
				
				driver.findElement(by).sendKeys(TestCore.config.getProperty(null));
		
				
			}*/

			/**
			 * Clicks on given [element] element
			 * 
			 * @param element
			 */
			public final void click(WebElement element){
				pauseMilis(100);
				Actions action = new Actions(driver);
				action.moveToElement(element).click(element).build().perform();
				//--pause(1);
				pauseMilis(500);
			}

			/**
			 * Clicks on given [element] element [Special method]
			 * 
			 * @param element
			 */
			public final void clickSpecial(WebElement element){
				//--pause(1);
				pauseMilis(500);
				Actions action = new Actions(driver);
				int X = (element.getSize().width/4) ;
				int Y = (element.getSize().height/2) ;
				System.out.println("X:" + X + " Y:" + Y + 
						" Location(" + element.getLocation().getX() + " , " + element.getLocation().getY() );
				action.moveToElement(element, X, Y).click().build().perform();
				//--pause(1);
				pauseMilis(500);
			}

			/**
			 * Double-click on given [by] element
			 * 
			 * @param by
			 */
			public final void doubleClick(By by){
				WebElement element = driver.findElement(by);
				doubleClick(element);
			}

			/**
			 * Double-click on given [element] element
			 * 
			 * @param element
			 */
			public final void doubleClick(WebElement element){
				pause(2);
				Actions action = new Actions(driver);
				action.moveToElement(element).doubleClick().build().perform();
				pause(1);
			}
			/**
			 * Waits until page loads completely in browser
			 */
			public final void waitForPageToLoad(){
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				for(int seconds=1; seconds<=60; seconds++) {		
					try{				
						if ( js.executeScript("return document.readyState").equals("complete") ) {break;} 
					} catch(Exception e) {}
					pause(1);
				}
			}
		
			
			
			/**
			 * Switch to window with given name
			 */
			public void switchToWindow(String windowName){
				getWebDriver().switchTo().window(windowName);
			}

			/**
			 * switch to this window
			 */
			public void switchToWindow(){
				driver.switchTo().window(driver.getWindowHandle().toString());
			}


			/**
			 * Return today's date in given dateFormat
			 * 
			 * @param dateFormat
			 * @return
			 */
			public String getDateToday( String dateFormat){
				DateFormat _dateFormat= new SimpleDateFormat( dateFormat );
				Calendar c = Calendar.getInstance();    
				c.setTime(new Date());
				return _dateFormat.format( c.getTime() );
			}

			/**
			 * Returns true if Alert is being displayed
			 * Else returns false
			 * 
			 * @return
			 */
			public boolean isAlertWindowPopUps(){  
				pauseMilis(500);
				String alert = driver.switchTo().alert().getText();
				if(alert.length()>5){
					return true;
				}else {
					return false;
				}
			}

			/**
			 * Returns true if alert is present
			 * else returns false
			 * 
			 * @return
			 */
			public boolean isAlertPresent(){
				pauseMilis(500);
				try{
					driver.switchTo().alert();
					return true;
				} catch(NoAlertPresentException nep){
					return false;
				}
			}

			/**
			 * Get alert text
			 * 
			 * @return
			 */
			public String getAlertText(){
				pauseMilis(1000);
				return driver.switchTo().alert().getText();
			}

			/**
			 * Accepts alert.
			 */
			public void acceptAlert(){
				pause(1);
				driver.switchTo().alert().accept();
			}

			/**
			 * Dismiss alert
			 */
			public void dismissAlert(){
				pause(1);
				driver.switchTo().alert().dismiss();
			}

			/**
			 * Selects a given option from the-list-of-available-options
			 * 
			 * @param by
			 * @param optionText
			 */
			public void select(By by,String optionText){
				Select select = new Select(driver.findElement(by));
				List<WebElement> list = select.getOptions();
				for (WebElement option : list) {
					//System.out.println(option.getText());
					String fullText = option.getText();
					if (fullText.equals(optionText)) {
						select.selectByVisibleText(fullText);
					}
				}
			}
			
			
			
			/**
			 * Selects a given option from the-list-of-available-options by lazy comparison
			 * 
			 * @param by
			 * @param optionText
			 */
			public void selectLazy(By by,String optionText){
				Select select = new Select(driver.findElement(by));
				List<WebElement> list = select.getOptions();
				for (WebElement option : list) {
					//System.out.println(option.getText());
					String fullText = option.getText();
					if (fullText.contains(optionText)) {
						select.selectByVisibleText(fullText);
					}
				}
			}

			/**
			 * Selects a given option from the-list-of-available-options
			 * 
			 * @param element
			 * @param optionText
			 */
			public void select(WebElement element,String optionText){
				Select select = new Select(element);
				List<WebElement> list = select.getOptions();
				for (WebElement option : list) {
					//System.out.println(option.getText());
					String fullText = option.getText();
					if (fullText.equals(optionText)) {
						select.selectByVisibleText(fullText);
					}
				}
			}
			
			/**
			 * Selects a given option from the-list-of-available-options
			 * 
			 * @param element
			 * @param optionText
			 */
			public void selectLazy(WebElement element,String optionText){
				Select select = new Select(element);
				List<WebElement> list = select.getOptions();
				for (WebElement option : list) {
					//System.out.println(option.getText());
					String fullText = option.getText();
					if (fullText.contains(optionText)) {
						select.selectByVisibleText(fullText);
					}
				}
			}
			
			
			
			/**
			 * Refresh current page
			 */
			public void refreshPage(){
				driver.navigate().refresh();
				pause(1);
				try{
					// Handle alert in-case there is any
					acceptAlert();
					pause(3);
				} catch(Exception e){}
				waitForPageToLoad();
				return;
			}
			
			/**
			 * Set browser position to bottom-right-corner
			 */
			public void minimizeBrowser(){
				JavascriptExecutor executor= (JavascriptExecutor) driver;
				int screenWidth = Integer.parseInt(executor.executeScript("return screen.width").toString());
			    int screenHeight = Integer.parseInt(executor.executeScript("return screen.height").toString());
			    Point bottomRightCorner = new Point( screenWidth , screenHeight );			
				driver.manage().window().setPosition(bottomRightCorner);
				pause(1);
			}
			
			/**
			 * Reset browser position
			 */
			public void resetBrowserPosition(){
				maximizeBrowser();
				/*JavascriptExecutor executor= (JavascriptExecutor) page;
				Point topLeftCorner = new Point( 0 , 0 );			
				page.manage().window().setPosition(topLeftCorner);
				pause(1);*/
			}
			
			/**
			 * Warning message if assert is not matched
			 * 
			 * @param successMessage
			 * @param actual
			 * @param expected
			 */
			public final void warn( String successMessage , Object actual, Object expected  ){
				try{
					Assert.assertEquals(actual, expected, FrameworkConstants.EXPECTED_MATCH_NOT_FOUND );
					log( successMessage , FrameworkConstants.ASSERTS );
				} catch(Error e){
					log( successMessage + "<br/>ERROR: <br/>Expected[" + expected + "] <br/>Found[" + actual + "]", FrameworkConstants.WARNING );
				}
			}
			/**
			 * Maximize browser window
			 * 
			 */
			public void maximizeBrowser(){
				driver.manage().window().maximize();
				pauseMilis(500);
			}
			/**
			 * press end key
			 * 
			 */
			public void pressEndKey(){
				Actions action = new Actions(driver);
				action.sendKeys(Keys.END).build().perform();
			}
			/**
			 * press Home key
			 * 
			 */
			public void pressHomeKey(){
				Actions action = new Actions(driver);
				action.sendKeys(Keys.HOME).build().perform();
			}
			
			
			By erroneousToken = By.xpath("//div[contains(@class,'cellWarning') and contains(@class,'fast-show')]");
				
	
			/*
			 * To generate alpha numeric numbers
			 * */
			public String generateStringWithAllowedSplChars(int length,String allowdSplChrs){
				String allowedChars="abcd" +   //alphabets
						allowdSplChrs +   //numbers
						"123456789";
				return RandomStringUtils.random(length, allowedChars);
			}	

			
			/**
			 * Returns true if given by element is present 
			 * else returns false
			 * 
			 * @param by
			 * @return
			 */
			public boolean isElementPresent(By by) {
			    try {
					driver.findElement(by);
			        return true;
			    } catch (NoSuchElementException e) {
			        return false;
			    }
			}
			
			/**
			 * Returns list of values in the table
			 * 
			 * 
			 * @param tableId
			 * @return
			 */
			public List<List<String>> getTableValues(String tableId){
				List<WebElement> tables = driver.findElements(By.id(tableId));
				List<List<String>> rowValues = new ArrayList<List<String>>();
				for (WebElement table : tables) {
					List<WebElement> rows = table.findElements(By.tagName("tr"));
					for (WebElement row : rows) {
						List<WebElement> columns = row.findElements(By.tagName("td"));
						List<String> columnValues = new ArrayList<String>();
						for (WebElement column : columns) {
							columnValues.add(column.getText());
							System.out.println(column.getText());
						}
						rowValues.add(columnValues);
					}

				}
				return rowValues;
            }
			
			public void closeBroswer(){
				driver.quit();
			}
			
			public static String[][] getExcelData(String fileLocation){
				File excel = new File(fileLocation);
				FileInputStream fis = null;
				String[][] data = null;
				HSSFWorkbook wb;	

				try {
					fis = new FileInputStream(excel);								
					wb = new HSSFWorkbook(fis);				
					HSSFSheet ws = wb.getSheet("Sheet1");                    
					int rownum = ws.getLastRowNum();
					int colnum = ws.getRow(0).getLastCellNum();
					data = new String[rownum+1][colnum];

					for (int i = 0; i <= rownum; i++) {
						HSSFRow row = ws.getRow(i);
						for (int j = 0; j < colnum; j++) {
							HSSFCell cell = row.getCell(j);
							String value = cellToString(cell);
							data[i][j] = value;
							System.out.println("the value is " + value);
						}
					}
				} catch (FileNotFoundException fne) {					
					fne.printStackTrace();
				} catch (IOException ioe) {						
					ioe.printStackTrace();
				} finally {
					try {
						if(fis != null)	fis.close();
					} catch (IOException e) {						
						e.printStackTrace();
					}
				}
				return data;		

			}

			public static String cellToString(HSSFCell cell) {

				int type;
				Object result;
				type = cell.getCellType();

				switch (type) {

				case 0:
					result = cell.getNumericCellValue();
					break;
				case 1:
					result = cell.getStringCellValue();
					break;
				default:
					throw new RuntimeException(
							"there is no support to this type of cell");
				}
				return result.toString();
			}
			
}

