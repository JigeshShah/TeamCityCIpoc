package KeywordLibrary_Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;








import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SupportLibraries.KeywordLibrary;
import SupportLibraries.Report;
import SupportLibraries.Report.Status;
import SupportLibraries.Util;

public class AppiumBasicActionsKeywords extends KeywordLibrary implements IAppiumBasicActionsKeywords {


	public void openWebsite_Mobile(String homePath, String testCase, String scenario, String browser, String objectId, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder) throws NullPointerException
	{
		System.out.println("Inside Open Website");
		//this.AndDriver=AndDriver;
		System.out.println(AndDriver);
		AndDriver.get("http://"+objectId);
		AndDriver.navigate().refresh();
		Set<String> contextNames = AndDriver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextNames); //prints out something like [NATIVE_APP, WEBVIEW_<APP_PKG_NAME>]
		}
		String contexNameHere=(String) contextNames.toArray()[1];
		if (contexNameHere.contains("WEBVIEW_") )
		{
			AndDriver.context(contexNameHere);
		}
		else
		{
			AndDriver.context("NATIVE_APP");
		}


	}


	public WebElement findElementByType_Mobile(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		WebElement object = null;

		Util utilObject = new Util();
		String identifier,actualObjectID = "";
		identifier = objectID.split(":")[0].trim();

		actualObjectID = getActualObjecctIdFromObjectMap(objectID);

			switch (identifier.toLowerCase().trim())

			{
			case "name":
				object=AndDriver.findElement(By.name(actualObjectID));
				break;
			case "id":

				object=AndDriver.findElement(By.id(actualObjectID));
				break;
			case "classname":

				object=AndDriver.findElement(By.className(actualObjectID));
				break;
			case "linktext":

				object=AndDriver.findElement(By.linkText(actualObjectID));
				break;
			case "partiallinktext":

				object=AndDriver.findElement(By.partialLinkText(actualObjectID));
				break;
			case "cssselector":

				object=AndDriver.findElement(By.cssSelector(actualObjectID));
				break;
			case "xpath":

				object=AndDriver.findElement(By.xpath(actualObjectID));
				break;
			case "tagname":
				object=AndDriver.findElement(By.tagName(actualObjectID));
				break;
			}
			return object;
		}

		



	@SuppressWarnings("unchecked")
	public List<WebElement> findElementsByType_Mobile(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		//WebElement object = null;
		List<WebElement> object = null;
		//Utilities utilObject = new Utilities();
		String identifier,actualObjectID = "";
		identifier = objectID.split(":")[0].trim();

		actualObjectID = getActualObjecctIdFromObjectMap(objectID);

			switch (identifier.toLowerCase().trim())

			{
			case "name":
				object=AndDriver.findElements(By.name(actualObjectID));
				break;
			case "id":
				object=AndDriver.findElements(By.id(actualObjectID));
				break;
			case "classname":

				object=AndDriver.findElements(By.className(actualObjectID));
				break;
			case "linktext":

				object=AndDriver.findElements(By.linkText(actualObjectID));
				break;
			case "partiallinktext":

				object=AndDriver.findElements(By.partialLinkText(actualObjectID));
				break;
			case "cssselector":

				object=AndDriver.findElements(By.cssSelector(actualObjectID));
				break;
			case "xpath":

				object=AndDriver.findElements(By.xpath(actualObjectID));
				break;
			case "tagname":
				object=AndDriver.findElements(By.tagName(actualObjectID));
				break;
			}
		
		return object;
	}

	@Override
	public void click(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		Report reportObject = new Report();

			WebDriverWait wait = new WebDriverWait(AndDriver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder)));
			element.click();
			reportObject.Log("Clicking on the Element "+objectID, "Clicked on the object Successfully", Report.Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

	}

	public void enter_text(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		Report reportObject=new Report();
		try{
			findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).clear();
			findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).sendKeys(dataValue);
			reportObject.Log(dataValue+" was entered successfully.","Typing the "+dataValue+" in " +objectID, Report.Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

		}
		catch(Exception e)
		{
			reportObject.Log(dataValue+" was entered unsuccessfully.","Typing the "+dataValue+" in " +objectID, Report.Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
	}

	public void waitForPageToLoad(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder){
		long timeout=30;
		AndDriver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
	
	}
	public void NavigateBack(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		AndDriver.navigate().back();
	}

	public void waitForElementToBeVisible(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		WebDriverWait wait = new WebDriverWait(AndDriver, 15);
		wait.until(ExpectedConditions.visibilityOf(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder)));

		//findElementByType(element,identifier).getLocation();
		//System.out.print("element present in "+ findElementByType(element,identifier).getLocation());
	}

	public void sleep(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder) throws InterruptedException

	{
		long l=0;

		if (dataValue.equalsIgnoreCase(""))
		{
			Thread.sleep(5000);
		}
		else
		{
			l = Long.parseLong(Integer.toString(((int)Float.parseFloat(dataValue.trim()))));
			Thread.sleep(l);
		}
	}

	public void getAllData(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		System.out.println(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).getAttribute(objectID));
	}
	public static String getActualObjecctIdFromObjectMap(String objectID)
	{
		String actualObjectID = "";
		if(objectID.split(":").length>2){
			for(int z=1;z<(objectID.split(":").length);z++){
				if(z!=1){
					actualObjectID = actualObjectID+":"+objectID.split(":")[z].trim();
				}else if (z==1){
					actualObjectID = actualObjectID+objectID.split(":")[z].trim();
				}
			}
		}else{
			actualObjectID = objectID.split(":")[1].trim();
		}
		return actualObjectID;
	}




	@Override
	public void HandleAlert(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		Alert alert = AndDriver.switchTo().alert();
		if(dataValue.trim().equals("accept"))
		{
			alert.accept();
		}
		else
		{
			alert.dismiss();
		}
		reportObject.Log("Confirm Delete Message "+objectName, "Delete Message Confirmed ", Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

	}

	/**
	 * Author: Santosh Kumar Anupati
	 * Method Name: selectByVisibleText
	 * Return Type: Nothing
	 * Description: This method selects the visible text specified in KeyInData column of Test case in a select box
	 */
	public void selectByVisibleText(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder){
		Report reportObject = new Report();
		Select selectBox = new Select(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder));
		selectBox.selectByVisibleText(dataValue);
		reportObject.Log("Selecting by visible text in the dropdown "+objectName, "Selected the value "+dataValue+" in the select box ", Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
	}

	/**
	 * Author: Santosh Kumar Anupati
	 * Method Name: selectByIndex
	 * Return Type: Nothing
	 * Description: This method selects the visible text specified in KeyInData column of Test case in a select box
	 */
	public void selectByIndex(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		Report reportObject = new Report();
		Select selectBox = new Select(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder));
		selectBox.selectByIndex((int)Float.parseFloat(dataValue));
		reportObject.Log("Selecting by index in the dropdown "+objectName, "Selected the index "+(int)Float.parseFloat(dataValue)+" in the select box", Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
	}

	/**
	 * Author: Santosh Kumar Anupati
	 * Method Name: selectByValue
	 * Return Type: Nothing
	 * Description: This method selects the visible text specified in KeyInData column of Test case in a select box
	 */
	public  void selectByValue(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		Report reportObject = new Report();
		Select selectBox = new Select(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder));
		selectBox.selectByValue(dataValue);
		reportObject.Log("Selecting by value in the dropdown "+objectName, "Selected the value "+dataValue+" in the select box", Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
	}


	/**
	 * Author: Santosh Kumar Anupati
	 * Method Name: selectByoption
	 * Return Type: Nothing
	 * Description: This method selects the visible text specified in KeyInData column of Test case in a select box
	 */
	public  void selectByoption(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		Report reportObject = new Report();
		Select selectBox = new Select(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder));
		//selectBox.selectByValue(dataValue);


		List<WebElement> options = selectBox.getOptions();
		for (WebElement option : options) {
			if (option.getText().toString().trim().equalsIgnoreCase(dataValue.trim())) {
				System.out.println(option.getText().toString());
				option.click();
			}
		}
		reportObject.Log("Selecting by value in the dropdown "+objectName, "Selected the value "+dataValue+" in the select box", Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
	}


	@Override
	public void doubleClick(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		Actions ac1 = new Actions(AndDriver);
		ac1.doubleClick(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder)).perform();
		Report reportObject = new Report();
		reportObject.Log("Double Clicking on the Element "+objectName, "Double clicked on the object", Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
	}

	@Override
	public void clickByLinkText(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)throws NotImplementedException  {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitForXPath(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)throws NotImplementedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void waitForLinkText(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)throws NotImplementedException {
		// TODO Auto-generated method stub

	}



	/*	public void WriteDataToOutputFile_Mobile(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		String columnValue = dataValue;
		String data = columnValue.split(";")[0].trim();
		String key = columnValue.split(";")[1].trim();
		Util utilObject = new Util();

		if(data.startsWith("getData=")){
			try {
				data = utilObject.getData(data.split("getData=")[1].trim(), AndDriver, scenario, testCase, homePath, currentIteration, browser, passScreenshot, browserFolder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			utilObject.setDataINI(key, data, testCase, scenario);
		}else if(data.startsWith("ObjectText")){
			try {
				data = findElementByType(AndDriver, scenario, testCase, homePath, currentIteration.intValue(), objectID, browser, passScreenshot, browserFolder).getText().toString();
			System.out.println("The app no" +data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			utilObject.setDataINI(key, data, testCase, scenario);
		} else{
			utilObject.setDataINI(key, data, testCase, scenario);


	}*/


	public void highlight(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) throws InterruptedException{
		// TODO Auto-generated method stub

		//Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor)AndDriver;

		// Starting loop to highlight and then de-highlight the web element
		for (int iCnt = 0; iCnt < 2; iCnt++) {
			//Execute Javascript
			if(iCnt == 0){
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder) , "color: yellow; border: 10px solid yellow;");
				Report reportObject = new Report();
				reportObject.Log("Highilighting the Element "+objectName, "Highlighted successfully", Status.highlight, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
				Thread.sleep(3000);
			}else{
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder) , "");
			}            
		}

	}

	@Override
	public void captureScreenshot(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		reportObject.Log("Capturing screenshot", "Captured screenshot", Status.done, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

	}

	@Override
	public void CurrentMonth(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		Calendar rightNow = Calendar.getInstance();
		java.text.SimpleDateFormat df2 = new java.text.SimpleDateFormat("MM");
		dataValue=df2.format(rightNow.getTime());

		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).clear();;
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).sendKeys(dataValue);


		reportObject.Log("Entering text in the text box "+objectName, "Entered the text "+dataValue, Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

	}

	@Override
	public void CurrentYear(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		Calendar rightNow = Calendar.getInstance();
		java.text.SimpleDateFormat df2 = new java.text.SimpleDateFormat("YYYY");
		dataValue=df2.format(rightNow.getTime());

		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).clear();
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).sendKeys(dataValue);



		reportObject.Log("Entering text in the text box "+objectName, "Entered the text "+dataValue, Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

	}

	@Override
	public void custYear(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		Report reportObject = new Report();
		Calendar prev3Year = Calendar.getInstance();
		prev3Year.add(Calendar.YEAR, -3);
		dataValue=String.valueOf(prev3Year.get(Calendar.YEAR));
		System.out.println(dataValue);

		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).clear();
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).sendKeys(dataValue);



		reportObject.Log("Entering text in the text box "+objectName, "Entered the text "+dataValue, Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);// TODO Auto-generated method stub

	}

	@Override
	public void genRandom(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub

		Random rand=new Random();
		Report reportObject = new Report();
		int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
		dataValue=String.valueOf(randomNum);
		System.out.println(dataValue);
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).clear();
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).sendKeys(dataValue);

		reportObject.Log("Entering text in the text box "+objectName, "Entered the text "+dataValue, Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
	}

	@Override
	public void checkbox_value(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).click();
		reportObject.Log("selecting checkbox "+objectName, "The checkbox "+objectName+" is checked", Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);


	}

	@Override
	public void getTitle(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();

		System.out.println("The page title: "+AndDriver.getTitle());
		try{
			if((AndDriver.getPageSource().contains(objectName)) || (AndDriver.getTitle().contains(dataValue)))
			{
				reportObject.Log("Page Opened"+objectName, "The page "+objectName+" has successfully opened", Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}
			else
				reportObject.Log(""+objectName, "The page "+objectName+" has not opened", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

		}
		catch(Exception e){
			reportObject.Log(" "+objectName, ""+objectName+" exxception block", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}

	}

	@Override
	public void pickFromDatePicker(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)throws NotImplementedException {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		/*	driver.get("http://jqueryui.com/datepicker/");
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//Click on image so that datepicker will come
		 * 
		 */	
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).click();
		//driver.findElement(By.xpath(".//*[@id='dimg_applicationReceivedDate']")).click();
		AndDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Click on next so that we will be in next month
		//findElementByType(driver, scenario, testCase, homePath, currentIteration.intValue(), objectId, browser, passScreenshot, browserFolder).click();

		/*DatePicker is a table.So navigate to each cell 
		 * If a particular cell matches value 13 then select it
		 */
		WebElement dateWidget = AndDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']"));
		//List rows=dateWidget.findElements(By.tagName("tr"));

		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

		for(WebElement cell:columns){
			//Select 13th Date 
			if (cell.getText().equals(dataValue)){
				cell.findElement(By.linkText(dataValue)).click();
				break;
			}
		} 





		reportObject.Log("Entering text in the text box "+objectName, "Entered the text "+dataValue, Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);		



	}

	@Override
	public void pickLastDateFromDatePicker(String homePath,
			String testCase, String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) throws NotImplementedException{
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		/*	driver.get("http://jqueryui.com/datepicker/");
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//Click on image so that datepicker will come
		 * 
		 */	
		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).click();
		//driver.findElement(By.xpath(".//*[@id='dimg_applicationReceivedDate']")).click();
		AndDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Click on next so that we will be in next month
		//findElementByType(driver, scenario, testCase, homePath, currentIteration.intValue(), objectId, browser, passScreenshot, browserFolder).click();

		/*DatePicker is a table.So navigate to each cell 
		 * If a particular cell matches value 13 then select it
		 */
		WebElement dateWidget = AndDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']"));
		//List rows=dateWidget.findElements(By.tagName("tr"));

		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

		for (WebElement cell:columns){
			//Select 13th Date 
			if (cell.getText().equals("30")){
				cell.findElement(By.linkText("30")).click();
				break;
			}
		} 





		reportObject.Log("Entering text in the text box "+objectName, "Entered the text "+dataValue, Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);		


	}

	public void selectDatePickerMonth(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)
	{
		int counter = 0;
		String dateValues[]=new String[3];
		Report reportObject=new Report();

		for(String values:dataValue.split(";", 3))
		{	
			dateValues[counter]=values;
			counter++;
		} 

		findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).click();
		AndDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebElement dateWidget = AndDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']"));



		while(!dateValues[1].contains(AndDriver.findElement(By.className("ui-datepicker-month")).getText().trim()))
		{
			AndDriver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/a[2]")).click();
			if(dateValues[1].contains(AndDriver.findElement(By.className("ui-datepicker-month")).getText().trim()))
			{
				break;
			}
			long timeout=30;
			AndDriver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		}


		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		for(WebElement ele:columns)
		{
			if(ele.getText().equals(dateValues[0]))
			{
				ele.findElement(By.linkText(dateValues[0])).click();
				break;
			}
		}

		reportObject.Log("Entering the Date in :"+objectName, "Entered the text "+dataValue, Status.DONE, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

	}

	@Override
	public void delay(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)throws NotImplementedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void WriteDataToOutputFile(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)throws NotImplementedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EndOFScript(String homePath, String testCase, String scenario,
			String browser, String objectId, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)throws NotImplementedException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void dragAndDrop(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
						
					Util util=new Util();
					TouchAction action=new TouchAction((MobileDriver)AndDriver);
					Report reportObject=new Report();
					try
					{
						WebElement elementToBeDraged;
						WebElement elementwhereToBeDropped;
						elementToBeDraged=findElementByType_Mobile(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
						String objectIdForDropping=util.getObjectFromObjectMap(dataValue, scenario);
						elementwhereToBeDropped=findElementByType_Mobile(homePath, testCase, scenario, browser, objectIdForDropping, dataValue, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
						action.longPress(elementToBeDraged).moveTo(elementwhereToBeDropped).release().perform();	
						reportObject.Log("Dragging element "+objectName+" and dropping to position of: "+dataValue, "Dragged successfully element to the position of: "+dataValue, Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
					}
					catch(Exception e)
					{
						reportObject.Log("Dragging element "+objectName+" and dropping to position of: "+dataValue, "Dragged unsuccessfully element to the position of: "+dataValue, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
					}
					
	}
	
	
	public void swipeHorizontalElements(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		
	
		Report reportObject=new Report();
		//WebDriverWait wait = new WebDriverWait(AndDriver, 15);
		Dimension size;
		WebElement elementTobeSwiped=null;
		
		
		try
		{
			
			AndDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			waitForElementToBeVisible(homePath, testCase, scenario, browser, objectID,objectName, dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder);
			elementTobeSwiped=findElementByType_Mobile(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
			
			size=AndDriver.manage().window().getSize();
			int rightSideScreen=(int)(size.width*0.80);
			int elementXValue=elementTobeSwiped.getLocation().getX();
			int elementYValue=elementTobeSwiped.getLocation().getY();
			
			if (dataValue.equalsIgnoreCase("Right"))
			{
				AndDriver.context("NATIVE_APP");
				AndDriver.swipe(elementXValue, elementYValue,elementXValue+(rightSideScreen/2) ,elementYValue , 1000);
			}
			else 
			{
				AndDriver.context("NATIVE_APP");
				AndDriver.swipe(elementXValue+(rightSideScreen/2), elementYValue, elementXValue,elementYValue, 1000);
			}
			
			reportObject.Log("Swiping the element "+elementTobeSwiped+" in the "+dataValue+" direction", "Swiped successfully element to : "+dataValue+" direction", Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportObject.Log("Swiping the element "+elementTobeSwiped+" in the "+dataValue+" direction", "Swiped unsuccessfully element to : "+dataValue+" direction", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
	}
	
	
	public void swipeHorizontal(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		

		Report reportObject=new Report();
		Dimension size;
		WebElement elementTobeSwiped=null;
		size=AndDriver.manage().window().getSize();
		AndDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		try
		{
			int rightSideScreen=(int)(size.width*0.20);
			int leftSideScreen=(int)(size.width*0.80);
			int midscreen=(int)(size.height/2);	
			
			if (dataValue.equalsIgnoreCase("Right"))
			{
				AndDriver.context("NATIVE_APP");
				AndDriver.swipe(rightSideScreen, midscreen, leftSideScreen, midscreen, 1000);
				//AndDriver.swipe(leftSideScreen, midscreen, rightSideScreen, midscreen, 1000);
				
				
			}
			else
			{
				AndDriver.context("NATIVE_APP");
				AndDriver.swipe(leftSideScreen, midscreen, rightSideScreen, midscreen, 1000);
			}
			Thread.sleep(2000);
			reportObject.Log("Swiping the element "+elementTobeSwiped+" in the "+dataValue+" direction", "Swiped successfully element to : "+dataValue+" direction", Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportObject.Log("Swiping the element "+elementTobeSwiped+" in the "+dataValue+" direction", "Swiped unsuccessfully element to : "+dataValue+" direction", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
	}

	@Override
	public void swipeVerticalElement(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		
		Report reportObject=new Report();
		Dimension size;
		WebElement elementTobeSwiped=null;
		
		
		try
		{
			
			AndDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			waitForElementToBeVisible(homePath, testCase, scenario, browser, objectID,objectName, dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder);
			elementTobeSwiped=findElementByType_Mobile(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
			size=AndDriver.manage().window().getSize();
			int UpperSideOfScreen=(int)(size.height*0.05);
			int LowerSideOfScreen=(int)(size.height*0.95);
			
			int elementXValue=elementTobeSwiped.getLocation().getX();
			int elementYValue=elementTobeSwiped.getLocation().getY();
			
			
			if (dataValue.equalsIgnoreCase("Up"))
			{
				AndDriver.context("NATIVE_APP");
				AndDriver.swipe(elementXValue, elementYValue,elementXValue,elementYValue+(UpperSideOfScreen/2) , 1000);
			}
			else 
			{
				AndDriver.context("Down");
				AndDriver.swipe(elementXValue, elementYValue, elementXValue,elementYValue+LowerSideOfScreen, 1000);
				
			}
			
			reportObject.Log("Swiping the element "+elementTobeSwiped+" in the "+dataValue+" direction", "Swiped successfully element to : "+dataValue+" direction", Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportObject.Log("Swiping the element "+elementTobeSwiped+" in the "+dataValue+" direction", "Swiped unsuccessfully element to : "+dataValue+" direction", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
		
		
	}

	@Override
	public void longPress(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		
		Report reportObject=new Report();
		TouchAction action=new TouchAction(AndDriver);
		WebElement element=null;
		int duration=2000;
		try
		{
			waitForElementToBeVisible(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
			element=findElementByType_Mobile(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
			if(dataValue.isEmpty())
			{
				action.longPress(element, duration).perform();
			}
			
			else
			{
				duration=Integer.valueOf(dataValue);
				action.longPress(element, duration).perform();
				
			}
			
			reportObject.Log("Doing a Longpress on : "+objectID,"Long Press is successfully done on the element :"+objectID,Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			
		}
		catch(Exception e)
		{
			reportObject.Log("Doing a Longpress on : "+objectID,"Long Press is UN-successfully done on the element :"+objectID,Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
		
	}
	
	public void zoom(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
	
		
			Report report=new Report();
			WebElement element=null;
			
			try
			{
				waitForElementToBeVisible(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
				element=findElementByType_Mobile(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
				int leftX = element.getLocation().getX();
				int rightX = leftX + element.getSize().getWidth();
				int upperY = element.getLocation().getY();
				int lowerY = upperY + element.getSize().getHeight();
				int middleY = (upperY + lowerY) / 2;
				int middleX = (leftX + rightX) / 2;
				
				TouchAction action=new TouchAction(AndDriver);
				action.press(middleX, middleY).release().perform();
				AndDriver.zoom(middleX,middleY);
				
				report.Log("Doing a Zoom on : "+objectID,"Zoom is successfully done on the element :"+objectID,Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
				
			}
			
			catch (Exception e)
			{
				report.Log("Doing a Zoom on : "+objectID,"Zoom is Un-successfully done on the element :"+objectID,Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}
		
	
	}

	@Override
	public void scrollTo(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		
		Report report=new Report();
		
		try
		{
			waitForPageToLoad(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
			AndDriver.scrollTo(dataValue);
			report.Log("Scroll To the following element : "+dataValue,"Scroll was Successful for :"+dataValue,Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			
		}
		catch(Exception e)
		{
			report.Log("Scroll To the following element : "+dataValue,"Scroll was unsuccessful for :"+dataValue,Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
		
		
	}


	public void selectFromDropDown(String homePath, String testCase, String scenario,
			String browser, String objectID, String objectName,
			String dataValue, String onPassLog, String onFailLog,
			AppiumDriver<WebElement> AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder)
			{
		
			Report report= new Report();
			WebElement ele=null;
			
			try
			{
				ele=findElementByType_Mobile(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
				ele.click();
				
				scrollTo(homePath, testCase, scenario, browser, objectID, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, errorValue, browserFolder);
				AndDriver.findElementByName(dataValue).click();
				
				/*List<WebElement> listW=AndDriver.findElements(By.className("android.widget.CheckedTextView"));
				for(WebElement e:listW)
				{
					System.out.println(e.getText());
				}*/
				
				//AndDriver.scrollTo(dataValue);
				
			}
			
			catch(Exception e)
			{
				
			}
		
		
			}

}
