package KeywordLibrary_Appium;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import SupportLibraries.ExecuteScripts;
import SupportLibraries.POI_ReadExcel;
import SupportLibraries.Report;
import SupportLibraries.Report.Status;
import SupportLibraries.Util;

public class ExecuteKeywordAndMethods implements IExecuteKeywordAndMethods {
	/**
	 * Author: Prashant Thakuri
	 * Method Name: ExecuteMethod_Appium
	 * Description: This method is to execute the method that matches with the Method name given in the Input sheet for a particular test case in the Scenario
	 * Return Type: Nothing
	 */

	Util utilObject=new Util();
	ExecuteScripts execScr=new ExecuteScripts();

	public void executeMethod_Appium(String homePath, String testCase, String scenario, String browser, String objectId, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, int currentIteration, boolean errorValue, String browserFolder,String methodName){
		Report reportObject = new Report();
		ExecuteScripts exeObj=new ExecuteScripts();
		try{
			Class<?> cls = Class.forName("ReusableFunctions.ReusableFunctions_Appium");
			Object obj = cls.newInstance();

			Class<?>[] cArg = new Class[14];
			cArg[0] = String.class;
			cArg[1] = String.class;
			cArg[2] = String.class;
			cArg[3] = String.class;
			cArg[4] = String.class;
			cArg[5] = String.class;
			cArg[6] = String.class;
			cArg[7] = String.class;
			cArg[8] = String.class;
			cArg[9] = AppiumDriver.class;
			cArg[10] = String.class;
			cArg[11] = Integer.class;
			cArg[12] = Boolean.class;
			cArg[13] = String.class;

			Method method = cls.getDeclaredMethod(methodName, cArg);
			List<Object> strArr = new ArrayList<Object>();
			strArr.add(homePath);
			strArr.add(testCase);
			strArr.add(scenario);
			strArr.add(browser);
			strArr.add(objectId);
			strArr.add(objectName);
			strArr.add(dataValue);
			strArr.add(onPassLog);
			strArr.add(onFailLog);
			strArr.add(AndDriver);
			strArr.add(passScreenshot);
			strArr.add(currentIteration);
			strArr.add(errorValue);
			strArr.add(browserFolder);
			method.invoke(obj, strArr.toArray());


		}catch(Exception e){
			e.printStackTrace();
			//Setting the error flag to true indicating an exception has occurred
			if(utilObject.getValueFromConfigProperties("FailAndExit").equalsIgnoreCase("Yes")){
				execScr.errorExit.put("FailAndExit",true);
			}
			exeObj.error.put(scenario+"_"+testCase, true);
			reportObject.Log("Unhandled Exception", "There was an Unhandled Exception while executing the method "+exeObj.methodName+". Exception: "+e, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
		}

	}

	/**
	 * Author: Prashant Thakuri
	 * Method Name: ExecuteKeyword_Appium
	 * Description: This method is to execute the method that matches with the Keyword given in the Input sheet for a particular test case in the Scenario
	 * Return Type: Void
	 */
	public void executeKeywords_Appium(String homePath, String testCase, String scenario, String browser, String objectId, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, int currentIteration, boolean errorValue, String browserFolder,String keyword,String ClassName){
		Report reportObject = new Report();
		ExecuteScripts exeObj=new ExecuteScripts();

		try
		{
			Class<?> cls = Class.forName(ClassName);
			Object obj = cls.newInstance();

			Class<?>[] cArg = new Class[14];
			cArg[0] = String.class;
			cArg[1] = String.class;
			cArg[2] = String.class;
			cArg[3] = String.class;
			cArg[4] = String.class;
			cArg[5] = String.class;
			cArg[6] = String.class;
			cArg[7] = String.class;
			cArg[8] = String.class;
			cArg[9] = AppiumDriver.class;
			cArg[10] = String.class;
			cArg[11] = Integer.class;
			cArg[12] = Boolean.class;
			cArg[13] = String.class;

			Method method = cls.getDeclaredMethod(keyword, cArg);
			List<Object> strArr = new ArrayList<Object>();
			strArr.add(homePath);
			strArr.add(testCase);
			strArr.add(scenario);
			strArr.add(browser);
			strArr.add(objectId);
			strArr.add(objectName);
			strArr.add(dataValue);
			strArr.add(onPassLog);
			strArr.add(onFailLog);
			strArr.add(AndDriver);
			strArr.add(passScreenshot);
			strArr.add(currentIteration);
			strArr.add(errorValue);
			strArr.add(browserFolder);
			method.invoke(obj, strArr.toArray());

		}
		catch(Exception e){
			e.printStackTrace();
			//Setting the error flag to true indicating an exception has occurred
			exeObj.error.put(scenario+"_"+testCase, true);
			//System.out.println("Inside Catch:"+scenario+"_"+testCase+" "+exeObj.error.get(scenario+"_"+testCase));

			if((!objectName.equalsIgnoreCase("")) || (!objectName.equalsIgnoreCase(null)))
			{
				reportObject.Log("Unhandled Exception while performing action on Object "+objectName, "There was an Unhandled Exception while executing the keyword "+exeObj.keyword+". Exception: "+e, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}
			else
			{
				reportObject.Log("Unhandled Exception", "There was an Unhandled Exception while executing the keyword "+exeObj.keyword+". Exception: "+e, Status.FAIL, AndDriver, testCase, scenario, browser, passScreenshot, browserFolder);
			}

			if(utilObject.getValueFromConfigProperties("FailAndExit").equalsIgnoreCase("Yes")){

				execScr.errorExit.put("FailAndExit",true);

			}
			//Executing the method in case of exception in a keyword so that next test case can start fresh
			//exeObj.methodName = "Logout";
			//exeObj.ExecuteMethod(homePath, testCase, scenario, browser, objectId, objectName, dataValue, onPassLog, onFailLog, AndDriver, passScreenshot, currentIteration, exeObj.error.get(scenario+"_"+testCase), browserFolder);

		}
	}


	/**
	 * Author: Prashant Thakuri
	 * Method Name: executeLinkedSheets
	 * Description: This method is to execute the Linked sheets when the keyword has value as Link="ModuleName"
	 * Return Type: Void
	 */
	public void executeLinkedSheets(String scenario,String moduleToBeExecuted,String testCase,AppiumDriver andDriver,Integer currentIteration, String browser, String passScreenshot, String browserFolder,String onPassLog, String onFailLog) {
		// TODO Auto-generated method stub

		POI_ReadExcel poiObject=new POI_ReadExcel();
		Util util=new Util();
		Report reportObject = new Report();
		ExecuteScripts exeObj=new ExecuteScripts();

		Map<String,List<String>> result=new HashMap<String,List<String>>();
		Map<String,List<String>> resultOfTestData=new HashMap<String,List<String>>();

		String keyword="";
		String objectID="";
		String dataValue="";
		String methodName="";
		String objectName="";




		try {

			String homepath=new File(".").getCanonicalPath();
			String dataPath=homepath+"\\TestScripts-TestData\\LinkedSheetDataMobile\\"+moduleToBeExecuted+"_Mobile.xlsx";
			System.out.println(dataPath);

			List<String> whereClause1=new ArrayList<String>();
			whereClause1.add("TestScript::"+moduleToBeExecuted);
			result=poiObject.fetchWithCondition(dataPath,"TestSteps", whereClause1);

			List<String> whereClause2=new ArrayList<String>();
			whereClause2.add("TestScript::"+moduleToBeExecuted);
			resultOfTestData=poiObject.fetchWithCondition(dataPath,"TestData", whereClause2);


			List<String> iterationValues=new ArrayList<String>();

			iterationValues=resultOfTestData.get("Iteration");


			for(int i=0;i<result.get("TestScript").size();i++)
			{
				if(!iterationValues.contains(Integer.toString(currentIteration)))

				{
					currentIteration=1;
				}

				System.out.println("currentIteration :"+currentIteration);


				keyword=result.get("Keyword").get(i);

				try{
					objectName=result.get("ObjectID").get(i);
					objectID=util.getObjectFromObjectMap(objectName,moduleToBeExecuted);
				}
				catch(Exception e)
				{

				}

				try
				{
					dataValue=result.get("KeyInData").get(i);
					if(dataValue.startsWith("getData="))
					{
						dataValue=util.getDataValueForAppiumTC(dataValue.split("getData=")[1], andDriver, moduleToBeExecuted, moduleToBeExecuted, dataPath,currentIteration,browser,passScreenshot,browserFolder);
					}
					else if(dataValue.startsWith("getDataINI=")){
						String parameters = dataValue.split("getDataINI=")[1].trim();
						dataValue = utilObject.getDataINI(parameters.split(";")[0].trim(),parameters.split(";")[1].trim());
					}
				}
				catch(Exception e)
				{

				}

				if(exeObj.error.get(scenario+"_"+testCase)==false){
					if(!keyword.endsWith("#")){
						//Checking if keyword starts with "function=". If it starts with "function=", then framework searches for matching method in ReusableFunctions.ReusableFunctions.java and invokes that method
						if(keyword.startsWith("function=")){
							methodName = keyword.split("function=")[1].trim();

							executeMethod_Appium(homepath, testCase, moduleToBeExecuted, browser, objectID, objectName, dataValue, onPassLog, onFailLog, andDriver, passScreenshot, currentIteration, exeObj.error.get(moduleToBeExecuted+"_"+testCase), browserFolder,methodName);
						}
						else if(keyword.toLowerCase().trim().startsWith("Link"))
						{
							keyword=keyword.split("Link=")[1].trim();
							executeLinkedSheets(scenario,keyword, testCase, andDriver, currentIteration,browser,passScreenshot,browserFolder,onPassLog,onFailLog);
						}
						else{
							//If keyword does not start with "verify", then framework searches for matching method in KeywordLibrary_Appium.AppiumVerificationKeywords.java and invokes that method
							if(keyword.toLowerCase().trim().contains("verify"))
							{
								String ClassName="KeywordLibrary_Appium.AppiumVerificationKeywords";
								executeKeywords_Appium(homepath, testCase, moduleToBeExecuted, browser, objectID, objectName, dataValue, onPassLog, onFailLog, andDriver, passScreenshot, currentIteration, exeObj.error.get(moduleToBeExecuted+"_"+testCase), browserFolder,keyword,ClassName);
							}

							else
							{
								String ClassName="KeywordLibrary_Appium.AppiumBasicActionsKeywords";
								executeKeywords_Appium(homepath, testCase, moduleToBeExecuted, browser, objectID, objectName, dataValue, onPassLog, onFailLog, andDriver, passScreenshot, currentIteration, exeObj.error.get(moduleToBeExecuted+"_"+testCase), browserFolder,keyword,ClassName);
							}
						}

					}


				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			exeObj.error.put(scenario+"_"+testCase, true);

			if((!objectName.equalsIgnoreCase("")) || (!objectName.equalsIgnoreCase(null)))
			{
				reportObject.Log("Unhandled Exception while performing action on Object "+objectName, "There was an Unhandled Exception while executing the keyword "+exeObj.keyword+". Exception: "+e, Status.FAIL, andDriver, testCase, moduleToBeExecuted, browser, passScreenshot, browserFolder);
			}
			else
			{
				reportObject.Log("Unhandled Exception", "There was an Unhandled Exception while executing the keyword "+exeObj.keyword+". Exception: "+e, Status.FAIL, andDriver, testCase, moduleToBeExecuted, browser, passScreenshot, browserFolder);
			}

			if(util.getValueFromConfigProperties("FailAndExit").equalsIgnoreCase("Yes")){

				execScr.errorExit.put("FailAndExit",true);

			}
		}



	}


}
