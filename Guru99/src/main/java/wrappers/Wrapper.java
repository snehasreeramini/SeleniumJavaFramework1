package wrappers;

public interface Wrapper {

	public void invokeApp(String browser,String url);
	
	public void enterById(String id, String text);
	
	public void enterByName(String name, String text);
	
	public void clickByClassName(String text);
	
	public void clickById(String id);
	
	public void selectVisibleTextById(String id,String visibleText);
	
	public void selectVisibleTextByName(String name,String visibleText);
	
	public void selectVisibleTextByXPath(String xpath,String visibleText);
	
	public void clickByLinkText(String linkText);
	
	public void clickByName(String Name);
	
	public void enterByXPath(String Name,String text);
	
	public void clickByXPath(String XPath);
	
	public void enterByLinkText(String LinkText,String text);
	
	public void takeSnap();
	
	public void switchToLastWindow();
	
	public void switchToFirstWindow();
	
	public void verifyTextContainsById(String id,String actualtext);
	
	public void mouseHover(String XPath);
	
	public void closeWindow();
	
	public void closeAllWindows();
	
	
}
