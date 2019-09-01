package pages;

import wrappers.GenericWrappers;

public class Homepage1 extends GenericWrappers {
	
	public Homepage1 clickOnSelenium() {
		mouseHover("//ul[@class='dropdown-menu']/li/a");
		return this;
	}
	public SignUpPage clickOnNewCustomer() {
		clickByLinkText("//ul[@class='menusubnav']/li[2]/a");
		return new SignUpPage();
	}
	

}
