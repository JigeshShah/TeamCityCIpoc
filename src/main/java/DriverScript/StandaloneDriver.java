package DriverScript;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import configuration.DefectLogger;
import SupportLibraries.AppiumHelper;
import SupportLibraries.POI_ReadExcel;
import SupportLibraries.Report;
import SupportLibraries.ExecuteScripts;
import SupportLibraries.Util;
import SupportLibraries.Report.Status;

public class StandaloneDriver {
	private static final Logger logger = Logger.getLogger(DefectLogger.class.getName());
	static String resultsFolder = "";
	static String mainresultsFolder="";
	public static String executionType="";

	/**
	 * @param args
	 * Author: Santosh Kumar Anupati
	 * Description: Execute for Standalone execution when Grid Setup is marked No in Config.properties file
	 */
	public static void main(String[] args) {
		 JFrame frame = new JFrame();
		// TODO Auto-generated method stub
		Util util = new Util();
		//Reading the value of the key "GridSetup" in Config.properties file. If it is Yes, then framework is for parallel execution
		String gridSetup = util.getValueFromConfigProperties("GridSetup");
   
		ExecuteScripts exec=new ExecuteScripts();
		Report reportObject = new Report();

		String homePath = "";
		String path = "";

		Boolean webExecution = false;
		//result1 is a map that contains the rows that are returned from the excel sheet specified satisfying the particular condition
		Map<String, List<String>> result1=null;

		//Workbook object that is used to connect to the workbook in scope
		XSSFWorkbook workBook = null;
		int numberOfSheets=0;
		int numberOfExecutedTCs=0;
		int	numberOfExecutedTCs_web=0;
		int	numberOfExecutedTCs_mobile=0;
		try {
			homePath = new File (".").getCanonicalPath();

			//Storing the configuration related to the format of the Test Case Selection sheet (Single sheet/modular sheet)
			if(util.getValueFromConfigProperties("TestCaseSelection_Format").equalsIgnoreCase("SingleSheet")){
				path = homePath+"\\src\\test\\resources\\TestCaseSelection_Singlesheet.xlsx";
			}else if (util.getValueFromConfigProperties("TestCaseSelection_Format").equalsIgnoreCase("Modular")){
				path = homePath+"\\src\\test\\resources\\TestCaseSelection_Modular.xlsx";
			}

			//Creating an object of the class POI_ReadExcel which is for reading excel and retrieving data using column header
			POI_ReadExcel poiObject = new POI_ReadExcel();
			FileInputStream file = new FileInputStream(new File(path));
			workBook = new XSSFWorkbook(file);
			numberOfSheets = workBook.getNumberOfSheets();
			workBook.close();

			numberOfExecutedTCs = 0;

			for(int j=0;j<numberOfSheets;j++){
				List<String> whereClause1 = new ArrayList<String>();
				//Adding the conditions that Execute column should be "Yes" to pick up only those rows from the TestCaseSelection sheet
				whereClause1.add("Execute::Yes");
				result1 = poiObject.fetchWithCondition(path, workBook.getSheetName(j), whereClause1);
				numberOfExecutedTCs = numberOfExecutedTCs+result1.get("Execute").size();
			}

			if(numberOfExecutedTCs!=0){
				//Creating the daily results folder (1 folder per each day)
				mainresultsFolder=exec.CreateDateFolder(homePath);

				//Checking if the flag "RunWebAutomation" is set to Yes in Config.properties
				if(util.getValueFromConfigProperties("RunWebAutomation").equalsIgnoreCase("Yes")){
					//Setting the value of the variable executionType to WebAutomation. This variable is used later in framework for reporting purpose to create folders in respective folders (Web/Mobile)
					executionType = "WebAutomation";
					//Checking if the value of Grid setup is "Yes" in Config.properties. If so then user should not be running StandaloneDriver.java
					if(gridSetup.equalsIgnoreCase("Yes")){
						JOptionPane.showMessageDialog(null,"Grid Setup is Set to Yes in Config file, please execute testNG.xml", "Configuration Error", JOptionPane.ERROR_MESSAGE);
					}else{
						
						
						//If the value of Grid setup is "No" in Config.properties, which means user wants to run Standalone mode
						
						//Checking if there are any web tests to execute:
						for(int j=0;j<numberOfSheets;j++){
							List<String> whereClause1 = new ArrayList<String>();
							whereClause1.add("ExecutionType::Web");
							whereClause1.add("Execute::Yes");
							Map<String, List<String>> result1_web = poiObject.fetchWithCondition(path, workBook.getSheetName(j), whereClause1);
						numberOfExecutedTCs_web = numberOfExecutedTCs_web+result1_web.get("Execute").size();
						
						}
						
						if(numberOfExecutedTCs_web!=0){
						//Creating an execution folder within the date folder in Results for every execution that is triggered
						webExecution = true;
						//Creating the current execution folder with timestamp within the main date folder for the day
						resultsFolder = exec.CreateExecutionFolder(mainresultsFolder, executionType, webExecution);

						//Creating the overall summary file inside the above created folder for the execution
						reportObject.CreateOverallSummaryFile(resultsFolder);

						//Calling the method which executes the test cases related to Web Automation

						try {
							runWebAutomation(util,gridSetup);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						//Method which writes the status and other details of the Web related test cases to Overall Summary report
						reportObject.AddRowToOverallSummary(resultsFolder, executionType, ExecuteScripts.browsersList);

						//Resetting the parameters to 0
						ExecuteScripts.totalTestCases = 0;
						ExecuteScripts.totalTestCasesExecuted = 0;
						exec.startTime = 0;
						exec.endTime = 0;
						ExecuteScripts.browsersList = "";
						ExecuteScripts.overallDuration = 0;
					}
					
					else
					{
						System.out.println("Web Test cases in Test case selection sheet marked as No, though config set up is marked Yes");
					}
					}		
				}else{
					//Displaying a Java pop-up saying Web Automation flag is set to No in Config.properties, hence it wont be executed
					JOptionPane.showMessageDialog(null,"RunWebAutomation is set to No, hence Web based test will not execute.", "Configuration Information", JOptionPane.INFORMATION_MESSAGE);
				}
								

				//Checking if the flag "RunMobileAutomation" is set to Yes in Config.properties
				if(util.getValueFromConfigProperties("RunMobileAutomation").equalsIgnoreCase("Yes")){
					
					//Checking if there are any mobile tests marked as Yes in the Test case Selection sheet
					
					for(int j=0;j<numberOfSheets;j++){
						List<String> whereClause1 = new ArrayList<String>();
						whereClause1.add("ExecutionType::Mobile");
						whereClause1.add("Execute::Yes");
						Map<String, List<String>> result1_mobile = poiObject.fetchWithCondition(path, workBook.getSheetName(j), whereClause1);
						numberOfExecutedTCs_mobile = numberOfExecutedTCs_mobile+result1_mobile.get("Execute").size();
						//System.out.println(result1.get(j));
					}
					
					if(numberOfExecutedTCs_mobile!=0){
					executionType = "MobileAutomation";
					//Creating an execution folder within the date folder in Results for every execution that is triggered
					resultsFolder = exec.CreateExecutionFolder(mainresultsFolder, executionType, webExecution);

					//Creating the overall summary file inside the above created folder for the execution
					reportObject.CreateOverallSummaryFile(resultsFolder);

					//Calling the method which executes the test cases related to Mobile Automation
					try {
						runMobileAutomation();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//Method which writes the status and other details of the Mobile related test cases to Overall Summary report
					reportObject.AddRowToOverallSummary(resultsFolder, executionType, ExecuteScripts.browsersList);
					}
					else{
						System.out.println("Mobile Test cases in Test case selection sheet marked as No, though config set up is marked Yes");
					}
				}else{
					//Displaying a Java pop-up saying Mobile Automation flag is set to No in Config.properties, hence it wont be executed
					
					System.out.println("Mobile Automation is set to No");
				//	JOptionPane.showMessageDialog(frame,"RunMobileAutomation is set to No, hence Mobile based test will not execute.", "Configuration Information", JOptionPane.INFORMATION_MESSAGE);
				
				
				
				}
				
			}

		} catch (Exception e){
			e.printStackTrace();

		}
	}

	/**
	 *
	 * @param util
	 * @param gridSetup
	 * Method Name: runWebAutomation
	 * Method Description: This method is to trigger the Web automation execution when WebExecution flag is marked Yes in Config.properties
	 */
	public static void runWebAutomation(Util util,String gridSetup){
		String port="";
		String homePath="";
		String path = "";
		//result1 is a map that contains the rows that are returned from the excel sheet specified satisfying the particular condition
		Map<String, List<String>> result1=null;
		//Workbook object that is used to connect to the workbook in scope
		XSSFWorkbook workBook = null;

		int numberOfSheets=0;
		int numberOfExecutedTCs=0;
		try {
			homePath = new File (".").getCanonicalPath();
			if(util.getValueFromConfigProperties("TestCaseSelection_Format").equalsIgnoreCase("SingleSheet")){
				path = homePath+"\\src\\test\\resources\\TestCaseSelection_Singlesheet.xlsx";
			}else if (util.getValueFromConfigProperties("TestCaseSelection_Format").equalsIgnoreCase("Modular")){
				path = homePath+"\\src\\test\\resources\\TestCaseSelection_Modular.xlsx";
			}
			POI_ReadExcel poiObject = new POI_ReadExcel();
			FileInputStream file = new FileInputStream(new File(path));
			workBook = new XSSFWorkbook(file);
			numberOfSheets = workBook.getNumberOfSheets();
			workBook.close();

			numberOfExecutedTCs = 0;

			for(int j=0;j<numberOfSheets;j++){
				List<String> whereClause1 = new ArrayList<String>();
				//Adding the conditions that Execution Type should be "Web" and Execute column should be "Yes" to pick up only those rows from
				//TestCaseSelection_SingleSheet.xlsx sheet
				if(util.getValueFromConfigProperties("TestCaseSelection_Format").equalsIgnoreCase("SingleSheet")){
					whereClause1.add("ExecutionType::Web");
				}
				whereClause1.add("Execute::Yes");
				result1 = poiObject.fetchWithCondition(path, workBook.getSheetName(j), whereClause1);
				numberOfExecutedTCs = numberOfExecutedTCs+result1.get("Execute").size();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Reading the Config.properties file to read the value stored for the key Browser and splitting them by (,) in case of multiple browsers
		String[] ListOfBrowsers = null;
		ListOfBrowsers = util.getValueFromConfigProperties("Browser").split(",");

		ExecuteScripts driverObject = new ExecuteScripts();
		WebDriver driver = null;
		//For loop which will iterate for each browser that is specified in Browser key in Config.properties separated by comma (,)
		for(int i=0;i<ListOfBrowsers.length;i++){
			ExecuteScripts testngDriver = new ExecuteScripts();
			//Storing the list of browsers specified in Config.properties file separated by (,) for reporting purpose
			ExecuteScripts.browsersList = ExecuteScripts.browsersList+", "+ListOfBrowsers[i];

			if(numberOfExecutedTCs!=0){
				driver = driverObject.SelectDriver(ListOfBrowsers[i].trim(),port);
				driver.manage().window().maximize();

				for(int k=0;k<numberOfSheets;k++){
					if(util.getValueFromConfigProperties("TestCaseSelection_Format").equalsIgnoreCase("SingleSheet")){
						//If format is selected as SingleSheet, the call the method "ExecuteDriver" from ExecuteScripts class
						driverObject.ExecuteDriver(driver,workBook.getSheetName(k),ListOfBrowsers[i].trim(),resultsFolder);
					}else if(util.getValueFromConfigProperties("TestCaseSelection_Format").equalsIgnoreCase("Modular")){
						//If format is selected as Modular, the call the method "ExecuteModularDriver" from ExecuteScripts class
						driverObject.ExecuteModularDriver(driver,workBook.getSheetName(k),ListOfBrowsers[i].trim(),resultsFolder);
					}
				}
			}

			if(!(ListOfBrowsers[i].equalsIgnoreCase("IE"))){
				driver.manage().deleteAllCookies();
			}

			logger.info("Execution is complete, check results for further details");

			try {
				driver.close();
				driver.quit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Report reportObject = new Report();
		//Closing the summary file at the end of execution
		reportObject.CloseSummary(resultsFolder);

		//Killing the IEDriverServer.exe file at the end of execution
		try {
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method Name: runMobileAutomation
	 * Method Description: This method is to trigger the Mobile automation execution when MobileExecution flag is marked Yes in Config.properties
	 */
	public static void runMobileAutomation(){
		AppiumDriver AndDriver=null;

		// TODO Auto-generated method stub
		Util util = new Util();
		String gridSetup = util.getValueFromConfigProperties("GridSetup");
		String mobileExecution=util.getValueFromConfigProperties("MobileExecution");
		if(gridSetup.equalsIgnoreCase("Yes")){
			JOptionPane.showMessageDialog(null,"Grid Setup is Set to Yes in Config file, please execute testNG.xml", "Configuration Error", JOptionPane.ERROR_MESSAGE);
		}else{
			String homePath="";
			XSSFWorkbook workBook = null;
			int numberOfSheets=0;
			int numberOfExecutedTCs=0;
			try {
				homePath = new File (".").getCanonicalPath();
				String path = homePath+"\\src\\test\\resources\\TestCaseSelection_Singlesheet.xlsx";
				POI_ReadExcel poiObject = new POI_ReadExcel();
				FileInputStream file = new FileInputStream(new File(path));
				workBook = new XSSFWorkbook(file);
				numberOfSheets = workBook.getNumberOfSheets();
				workBook.close();

				numberOfExecutedTCs = 0;

				for(int j=0;j<numberOfSheets;j++){
					List<String> whereClause1 = new ArrayList<String>();
					whereClause1.add("ExecutionType::Mobile");
					whereClause1.add("Execute::Yes");
					Map<String, List<String>> result1 = poiObject.fetchWithCondition(path, workBook.getSheetName(j), whereClause1);
					numberOfExecutedTCs = numberOfExecutedTCs+result1.get("Execute").size();
					//System.out.println(result1.get(j));
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String[] ListOfBrowsers = null;
			AppiumHelper helper=new AppiumHelper();

			/*Properties prop = new Properties();
			FileInputStream propFile = null;
			propFile= new FileInputStream(homePath+"\\CapabalitiesConfig\\"+propertiesConfig+".properties");
			prop.load(propFile);*/

			ListOfBrowsers = util.getValueFromConfigProperties("MobileBrowser").split(",");
			ExecuteScripts driverObject = new ExecuteScripts();

			for(int i=0;i<ListOfBrowsers.length;i++){
				ExecuteScripts testngDriver = new ExecuteScripts();
				ExecuteScripts.browsersList = ExecuteScripts.browsersList+", "+ListOfBrowsers[i];
				if(numberOfExecutedTCs!=0){

					for(int k=0;k<numberOfSheets;k++){
						driverObject.ExecuteDriver_Appium(AndDriver, workBook.getSheetName(k),ListOfBrowsers[i].trim(),resultsFolder);
					}
				}
			}
			Report reportObject = new Report();
			reportObject.CloseSummary(resultsFolder);

		}
	}
}