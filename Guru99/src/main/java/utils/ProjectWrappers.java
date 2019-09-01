package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import wrappers.GenericWrappers;

public class ProjectWrappers extends GenericWrappers{
	@BeforeMethod
	public void firstStep() {
		System.out.println("i'm in before method");
		invokeApp("chrome","http://demo.guru99.com/");
		//clickByLinkText("AGENT LOGIN");
	}
	
	@AfterMethod
	public void lastStep() {
		System.out.println("i'm in after method");
		closeAllWindows();
		
	}

}
