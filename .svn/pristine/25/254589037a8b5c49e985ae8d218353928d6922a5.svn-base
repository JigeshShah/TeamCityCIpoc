package SupportLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DriverScript.StandaloneDriver;


public class TestNG_Configuration {
	String mainresultsFolder="";
	String resultsFolder = "";
	boolean flag = false;
 
	@BeforeSuite
	public void CheckGridSetupValue(){
		
		Util utilObject = new Util();
		if(!(utilObject.getValueFromConfigProperties("GridSetup").equalsIgnoreCase("Yes"))){
			JOptionPane.showMessageDialog(null,"Grid Setup is set to No, please execute Standalone Driver", "Configuration Error", JOptionPane.ERROR_MESSAGE);
		}else{
			try {
				ExecuteScripts.executionMode = "Parallel";
				ExecuteScripts testngDriver = new ExecuteScripts();
				POI_ReadExcel poiObject = new POI_ReadExcel();
				String homePath = new File (".").getCanonicalPath();
				
				String path = homePath+"\\TestCaseSelection_Modular.xlsx";
				FileInputStream file = new FileInputStream(new File(path));
				XSSFWorkbook workBook = new XSSFWorkbook(file);
				int numberOfSheets = workBook.getNumberOfSheets();
				workBook.close();
				
				int numberOfExecutedTCs = 0;
				
				for(int i=0;i<numberOfSheets;i++){
					List<String> whereClause1 = new ArrayList<String>();
					whereClause1.add("Execute::Yes");
					Map<String, List<String>> result1 = poiObject.fetchWithCondition(path, workBook.getSheetName(i), whereClause1);
					numberOfExecutedTCs = numberOfExecutedTCs+result1.get("Execute").size();
				}
				
				if(numberOfExecutedTCs!=0){
					Report reportObject = new Report();
					mainresultsFolder=testngDriver.CreateDateFolder(homePath);
					resultsFolder = testngDriver.CreateExecutionFolder(mainresultsFolder, "WebAutomation", true);
					//Creating the overall summary file inside the above created folder for the execution
					reportObject.CreateOverallSummaryFile(resultsFolder);
					
					flag = true;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@AfterSuite
	public void CloseSummary(){
		//if flag value is true then the close summary step is executed
		if(flag){
			Report reportObject = new Report();
			reportObject.CloseSummary(resultsFolder);

			//Method which writes the status and other details of the Web related test cases to Overall Summary report
			reportObject.AddRowToOverallSummary(resultsFolder, "WebAutomation", ExecuteScripts.browsersList);
		}
	}

	@Test
	  public void SanityTesting() {
		if(flag){
			ExecuteScripts driverObject = new ExecuteScripts();
			driverObject.ExecuteModule(Thread.currentThread().getStackTrace()[1].getMethodName(),resultsFolder);
		}
	}
	
	@Test
	  public void Regression() {
		if(flag){
			ExecuteScripts driverObject = new ExecuteScripts();
			driverObject.ExecuteModule(Thread.currentThread().getStackTrace()[1].getMethodName(),resultsFolder);
		}
	}	
}