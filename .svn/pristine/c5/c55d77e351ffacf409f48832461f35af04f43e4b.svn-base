package KeywordLibrary_Appium;

import java.awt.List;
import java.util.ArrayList;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import SupportLibraries.Report;
import SupportLibraries.Report.Status;

public class AppiumVerificationKeywords extends AppiumBasicActionsKeywords implements IAppiumVerificationKeywords {
	

	/*
	 * 
	 * 
	 * 
	 * Verification Related Keywords are below.
	 * 
	 * 
	 * 
	 * 
	 * */



	public void verifyElementPresent(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder){


		Report reportObject = new Report();
		if(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).isDisplayed())
		{

			reportObject.Log("Verify the Element present : "+objectID, "Verified the element", Report.Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}else
		{
			reportObject.Log("Verify the Element present : "+objectID, "Verified the element", Report.Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
	}

	public void verifyElementText(String homePath, String testCase, String scenario, String browser, String objectID, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, Integer currentIteration, Boolean errorValue, String browserFolder)
	{

		Report reportObject = new Report();
		if(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).getText().trim().equals(dataValue.trim()))
		{
			System.out.println("Value is Expected: "+ findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).getText().trim());
			reportObject.Log("Verifying the Text of the object "+objectName, "The element "+objectName+" has the text "+dataValue, Report.Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);

		}
		else
		{
			System.out.println("Value is NOT Expected: "+ findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).getText().trim());
			reportObject.Log("Verifying the Text of the object "+objectName, "The element "+objectName+" does not have the text "+dataValue, Report.Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
	}


	@Override
	public void verifyElementNotPresent(String homePath,
			String testCase, String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		if(findElementsByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).size()==0){
			if(!onPassLog.equalsIgnoreCase("")){
				reportObject.Log("Verifying that "+objectName+" Element is not present", onPassLog, Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}else{
				reportObject.Log("Verifying that "+objectName+" Element is not present", "The Element "+objectName+" is not present", Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}

		}else{
			if(!onFailLog.equalsIgnoreCase("")){
				reportObject.Log("Verifying that "+objectName+" Element is not present", onFailLog, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}else{
				reportObject.Log("Verifying that "+objectName+" Element is not present", "The Element "+objectName+" is  present", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}
		}

	}


	@Override
	public void verifyElementDisabled(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		if(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).getAttribute("disabled").equals("true")){
			reportObject.Log("Verifying the State of the object "+objectName, "The element "+objectName+" is in disabled state", Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}else{
			reportObject.Log("Verifying the State of the object "+objectName, "The element "+objectName+" is not in disabled state", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}	

	}

	@Override
	public void verifyCheckBoxChecked(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		Report reportObject = new Report();
		if(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).isSelected()){
			reportObject.Log("Verifying the State of the checkbox "+objectName, "The checkbox "+objectName+" is checked", Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}else{
			reportObject.Log("Verifying the State of the checkbox "+objectName, "The checkbox "+objectName+" is not checked", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}

	}

	@Override
	public void verifySelectedValue(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report report = new Report();

		Select selectBox = new Select(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder));
		if(selectBox.getFirstSelectedOption().getText().trim().equalsIgnoreCase(dataValue)){
			if(!onPassLog.equalsIgnoreCase("")){
				report.Log("Verifying the selected value in the dropdown "+objectName, onPassLog, Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}else{
				report.Log("Verifying the selected value in the dropdown "+objectName, "The dropdown "+objectName+" has the value "+dataValue+" selected", Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}                 
		}else{
			if(!onFailLog.equalsIgnoreCase("")){
				report.Log("Verifying the selected value in the dropdown "+objectName, onFailLog, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}else{
				report.Log("Verifying the selected value in the dropdown "+objectName, "The dropdown "+objectName+" does not have the value "+dataValue+" selected", Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}

		}
	}

	@Override
	public void verifyMandatoryElementHighlight(String homePath,
			String testCase, String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog,  AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		Report reportObject = new Report();
		if(findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).getAttribute("style").equals("background-color: rgb(255, 223, 223); border-width: 1px; border-color: rgb(255, 0, 0); border-style: solid;") )
		{
			reportObject.Log("Verify the highlight of the object"+objectName, "The field "+objectName+" is highlighted for mandatory validation"+dataValue, Status.PASS, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
		else{
			reportObject.Log("Highlight of the object failed "+objectName, "The element "+objectName+" does not have the highlight"+dataValue, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
			
		
	}

	@Override
	public void verifyDropDownValues(String homePath, String testCase,
			String scenario, String browser, String objectID,
			String objectName, String dataValue, String onPassLog,
			String onFailLog, AppiumDriver AndDriver, String passScreenshot,
			Integer currentIteration, Boolean errorValue, String browserFolder) {
		// TODO Auto-generated method stub
		
		boolean flag=true;
		Report reportObject = new Report();
		ArrayList<String> arraydata=new ArrayList<String>();
		String data[]=null;
		String dataNotPresent = null;
		
		if(dataValue.contains(";"))
		{
			data=dataValue.split(";");
			//for(int i=0;)
			
		}
		else
		{
			data[0]=dataValue;
		}
		
		java.util.List<WebElement> listOfOptions= findElementByType_Mobile(homePath,testCase,scenario,browser,objectID,objectName,dataValue,onPassLog,onFailLog,AndDriver,passScreenshot,currentIteration,errorValue,browserFolder).findElements(By.tagName("option"));
		
		outerloop:
		for(int i=0;i<=data.length;i++)
		{
			for(int j=0;j<=listOfOptions.size();i++)
			{
				if(!data[i].equalsIgnoreCase(listOfOptions.get(j).getText().trim()))
				{
					flag=false;
					dataNotPresent=data[i];
					break outerloop;
				}
			}
		}
		if(flag){
			reportObject.Log("Verifying the values in the dropdown "+objectName, "The expected values are present in the dropdown", Status.pass, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}else{
			reportObject.Log("Verifying the values in the dropdown "+objectName, "The expected values are not present in the dropdown"+dataNotPresent, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}
				
		
	}

}
