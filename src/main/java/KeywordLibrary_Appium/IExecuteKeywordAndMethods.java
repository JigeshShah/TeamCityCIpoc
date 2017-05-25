package KeywordLibrary_Appium;

import io.appium.java_client.AppiumDriver;

public interface IExecuteKeywordAndMethods {

	public void executeMethod_Appium(String homePath, String testCase, String scenario, String browser, String objectId, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, int currentIteration, boolean errorValue, String browserFolder,String keyword);
	public void executeKeywords_Appium(String homePath, String testCase, String scenario, String browser, String objectId, String objectName, String dataValue, String onPassLog, String onFailLog, AppiumDriver AndDriver, String passScreenshot, int currentIteration, boolean errorValue, String browserFolder,String keyword,String ClassName);
	public void executeLinkedSheets(String scenario,String moduleToBeExecuted,String testCase,AppiumDriver andDriver,Integer currentIteration, String browser, String passScreenshot, String browserFolder,String onPassLog, String onFailLog);
}
