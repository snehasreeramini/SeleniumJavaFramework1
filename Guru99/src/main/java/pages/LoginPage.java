package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {
	
	public LoginPage(RemoteWebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public LoginPage UserName() {
		enterByXPath("//input[@name='uid']","mngr196232");
		return this;
	}
	public LoginPage Password() {
		enterByXPath("//input[@name='password']","masEqyn");
        return this;
	}
	public Homepage1 Login() {
		clickByXPath("//input[@name='btnLogin']");
		return new Homepage1();
		
	}
	 

}
