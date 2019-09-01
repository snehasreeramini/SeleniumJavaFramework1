package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {
	
	public static ExtentReports report;
	public ExtentTest test;
	public String testCatseName,testCaseDescription,category,author;
	
	public ExtentReports startReport() {
		report=new ExtentReports("./reports/report.html",false);
		return report;
	}
	public ExtentTest startTestCase(String testCaseName,String testCaseDescription) 
	{
		test=report.startTest(testCaseName,testCaseDescription);
		return test;
		
	}
	
	public void reportSetep(String status,String description)
	{
		if(status.toUpperCase().equals("PASS")) {
			test.log(LogStatus.PASS,description+test.addScreenCapture(""));
		}
		else if(status.toUpperCase().equals("PASS")) {
			test.log(LogStatus.FAIL,description+test.addScreenCapture(""));
	}
		else if(status.toUpperCase().equals("PASS")) {
			test.log(LogStatus.SKIP,description+test.addScreenCapture(""));	
 }
}
public void endTestCase() {
	report.endTest(test);
}
public void endReport() {
	report.flush();
}
}