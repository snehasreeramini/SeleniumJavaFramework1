package pages;

import wrappers.GenericWrappers;

public class SignUpPage extends GenericWrappers {
	public SignUpPage enterCustomerName() {
		enterByXPath("//input[@name='name']","admin");
		return this;
	}
	public SignUpPage clickOngender() {
		clickByXPath("//input[@name='rad1']");
		return this;
	}
	public SignUpPage enterDate() {
		enterByXPath("//input[@name='rad1']","18-02-1970");
		return this;
	}
	public SignUpPage enterAddress() {
		enterByXPath("//textarea[@name='addr']","near checkpointcharlie");
		return this;
	}
	public SignUpPage enterCity() {
		enterByXPath("//input[@name='city']","Nizamabad");
		return this;
	}
	public SignUpPage enterState() {
		enterByXPath("//input[@name='state']","Telangana");
		return this;
	}
	public SignUpPage enterPincode() {
		enterByXPath("//input[@name='pinno']","503001");
		return this;
	}
    public SignUpPage enterMobile() {
    	enterByXPath("//input[@name='telephoneno']","9876543210");
    	return this;
    }
    public SignUpPage enterEmail() {
    	enterByXPath("//input[@name='emailid']","snehamacharla@gmail.com");
    	return this;
    }
    public SignUpPage enterPassword() {
    	enterByXPath("//input[@name='password']","admin@8");
    	return this;
    }
    public ConfirmPage clickSubmit() {
    	clickByXPath("//input[@name='sub']");
    	return new ConfirmPage();
    }
		// TODO Auto-generated method stub
	
}
