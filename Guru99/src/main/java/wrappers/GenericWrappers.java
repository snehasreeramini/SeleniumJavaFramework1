package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrapper  {
	RemoteWebDriver driver;
	
	protected static Properties prop;
	
	public void loadObjects()
	{
		try {
			prop.load(new FileInputStream(new File("./src/test/java/object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void unLoadObjects()
	{
		prop=null;
	}
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
try {
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			 driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", " ");
			 driver=new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			reportSetep("PASS", "The browser "+browser+" is launched and loaded with the url "+url);
			//System.out.println("The browser "+browser+" is launched and loaded with the url "+url);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
	        reportSetep("FAIL","Browser is not responding");
		}
finally {
	takeSnap();
}
	}

	/*public void reportSetep(String status, String description) {
		// TODO Auto-generated method stub
		
	}

	private void reportSetep(String status, String description) {
		// TODO Auto-generated method stub
		
	}*/

	public void enterById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).sendKeys(text);
			reportSetep("PASS","The Element with the id value \"+id+\" is found and entered as "+text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportSetep("FAIL","The element with the id value "+id+ " is not found");
		}
		catch(ElementNotVisibleException e)
		{
			reportSetep("FAIL","The element with the id value "+id+" is not visible");
		}
		catch(WebDriverException e)
		{
			reportSetep("FAIL","Browser is not responding");
		}
		finally {
			takeSnap();
		}
	}

	public void enterByName(String name, String text) {
            try {
				driver.findElementByName(name).sendKeys(text);
				reportSetep("PASS","The element the the name value "+name+" is found and entered as "+text);
			} catch (NoSuchElementException e) {
				reportSetep("FAIL","The element with the name value "+name+" is not found");
			}
            catch(ElementNotVisibleException e) {
            	reportSetep("FAIL","The element with the name value "+name+" is not found");
            }
            catch(WebDriverException e) {
            	reportSetep("FAIL","Browser is not responding");
            }
            finally {
            	takeSnap();
            }
	}

	public void clickById(String id) {
           try {
			driver.findElementById(id).click();
			   reportSetep("PASS","The element with the id value \"+id+\" has found and clicked");
		} catch(ElementNotVisibleException e) {
			reportSetep("FAIL","The element with the id value \"+id+\" is not found");
		}catch(ElementNotInteractableException e) {
			reportSetep("FAIL","The element with the id value \"+id+\" is not responding");
		} catch(NoSuchElementException e) {
			reportSetep("FAIL","The Element with the id value \"+id+\" is not found");
		}
           catch (WebDriverException e) {
			reportSetep("FAIL","Browser is not responding");
		}
           finally {
        	   takeSnap();
           }
	}

	public void selectVisibleTextById(String id, String visibleText) {
            try {
				WebElement text1=driver.findElementById(id);	
				Select select=new Select(text1);
				select.selectByVisibleText(visibleText);
				reportSetep("PASS","The Element with the id value "+id+" is found and the text value "+ visibleText+ "is selected");
			} catch (ElementNotVisibleException e) {
				reportSetep("FAIL","The Element with the id value "+id+" is not visible");
			}catch(NoSuchElementException e) {
				reportSetep("FAIL","The Element with the id value "+id+" is not found");
			}catch(ElementNotSelectableException e) {
				reportSetep("FAIL","The Text with the  value "+visibleText+" is not selectable");
			}
            catch(WebDriverException e) {
				reportSetep("FAIL","Browser is not responding");
			}
            finally {
            	takeSnap();
            }
	}

	public void clickByLinkText(String linkText) {
         try {
			driver.findElementByLinkText(linkText).click();
			 reportSetep("PASS","The Element with the linkText value "+linkText+"  is found and clicked");
		} catch (ElementNotInteractableException e) {
			reportSetep("FAIL","The Element with the linkText value "+linkText+" is not interactable");
		} catch (NoSuchElementException e) {
			reportSetep("FAIL","The Element with the linkText value "+linkText+" is not found");
		} catch(WebDriverException e) {
			reportSetep("FAIL","Browser not responding");
		}
         
         finally {
        	 takeSnap();
         }
	}

	public void clickByName(String Name) {
		try {
			driver.findElementByName(Name).click();
			reportSetep("TRUE","The Element with the Name value "+Name+" is found and clicked");
		} catch (ElementNotVisibleException e) {
			reportSetep("FAIL","The Element with the name value "+Name+" is found and not visible");
		} catch (NoSuchElementException e) {
			reportSetep("FAIL","The Element with the name value "+Name+" is not found");
		} catch (WebDriverException e) {
			reportSetep("FAIL","browser is not responding");
		}
		
		finally {
			takeSnap();
		}	
	}
	public void enterByLinkText(String LinkText,String text) {
		try {
			driver.findElementByLinkText(LinkText).sendKeys(text);
			reportSetep("PASS","The Element with the Linktext value "+LinkText+" is found and entered as "+text);
		} catch (NoSuchElementException e) {
                 reportSetep("FAIL","The Element with the LinkText value "+LinkText+" is not found");
		}catch(ElementNotVisibleException e) {
			      reportSetep("FAIL","The Element with the linktext value "+LinkText+" is not found");
		}catch(WebDriverException e) {
			     reportSetep("FAIL","Browser is not responding");
		}
		finally {
			takeSnap();
		}
	}

	

	public void clickByClassName(String Name) {
		try {
			driver.findElementByClassName(Name).click();
			reportSetep("PASS","The Element with the ClassName value "+Name+" is found and clicked");
		} catch (ElementNotVisibleException e) {
			  reportSetep("PASS","The Element with the ClassName value "+Name+" is found");
		} catch (NoSuchElementException e) {
			  reportSetep("FAIL","The Element with the ClassName value "+Name+" is found");
		} catch(WebDriverException e) {
			 reportSetep("FAIL","Browser is not responding");
		}
		finally {
			takeSnap();
		}
	}

	public  void enterByXPath(String Xpath, String text) {
              try {
				driver.findElementByXPath(Xpath).sendKeys(text);
				  reportSetep("PASS","The element with the Xpath value "+Xpath+" is found and entered as "+text);
			} catch (ElementNotVisibleException e) {
				reportSetep("FAIL","The element with the Xpath value "+Xpath+ "is not visible");
			} catch (NoSuchElementException e) {
				reportSetep("FAIL","The element with the Xpath value "+Xpath+ "is not found");
			} catch(WebDriverException e) {
				reportSetep("FAIL","Browser is not responding");
			}
              finally {
      			takeSnap();
      		}
	}
	
	int i=0;
	public void takeSnap() {
          try {
			File source= driver.getScreenshotAs(OutputType.FILE);
			   File  destination=new File("./snaps/screenshot"+i+".jpg");
			   FileUtils.copyFile(source, destination);
		} catch (WebDriverException e) {
			reportSetep("FAIL","browser is not responding");
		} catch (IOException e) {
			reportSetep("FAIL","There is no input file to do an output file operation");
		}
          i++;
	}
	public void clickByXPath(String XPath) {
          try {
			driver.findElementByXPath(XPath).click();
			  reportSetep("PASS","The Element with the XPath value "+XPath+" is found and clicked");
		} catch (NoSuchElementException e) {
			   reportSetep("FAIL","The element with the Xpath value "+XPath+" is not found");
		}catch (ElementNotVisibleException e) {
			   reportSetep("FAIL","The element with the Xpath value "+XPath+" is not visible");
		}catch (WebDriverException e) {
			   reportSetep("FAIL","Browser is not responding");
		}
	}
	public void switchToLastWindow() {
              try {
				Set<String> window=driver.getWindowHandles(); 
				  for(String all:window) {
					  driver.switchTo().window(all);
					  reportSetep("PASS","The window has been switched successfully");
				  }
			} catch (NoSuchWindowException e) {		
				reportSetep("FAIL","The window  is not found");
			} catch(NoSuchSessionException e) {
			reportSetep("FAIL","The window with the given session id is not found");
			} catch(WebDriverException e) {
				reportSetep("FAIL","The browser is not responding");
			}
	}

	public void switchToFirstWindow() {
          try {
			Set<String> swan =driver.getWindowHandles();
			  for(String s2:swan) {
			  driver.switchTo().window(s2);
			  }
		} catch (NoSuchWindowException e) {
			reportSetep("FAIL","The window is not found");
		} catch(NoSuchSessionException e) {
			reportSetep("FAIL","The window with the given session id is not found");
		} catch(WebDriverException e) {
			reportSetep("FAIL","The browser is not responding");
		}
          
	}
	
	public void verifyTextContainsById(String id, String actualtext) {
          try{
        	  String s1=driver.findElementById(id).getText();
          
			if(s1.contains(actualtext)) {
				  reportSetep("PASS","The text "+s1+" contains the given text "+actualtext);
			  }else {
				  reportSetep("PASS","The text "+s1+" does not contains the given text "+actualtext);
			  }
		} catch (ElementNotVisibleException e) {
			         reportSetep("FAIL","The element with the id value "+id+" is not visible");
		}catch (NoSuchElementException e) {
	         reportSetep("FAIL","The element with the id value "+id+" is not found");
		} catch(WebDriverException e){
			reportSetep("FAIL","Browser is not responding");
		}
          
	}
	public void selectVisibleTextByClassName(String Name,String text){
		try {
			WebElement set = driver.findElementByClassName(Name);
			Select sel = new Select(set);
			sel.selectByVisibleText(text);
			reportSetep("PASS","The element with the value "+Name+" is found and eneted as "+text+" is selected");
		} catch (NoSuchElementException e) {
			   reportSetep("FAIL","The element with the value of "+Name+" is not found");
		} catch(ElementNotSelectableException e) {
		      reportSetep("FAIL","The element with the value of "+Name+" is not selectable");
	    }catch(WebDriverException e) {
	    	   reportSetep("FAIL","Browser is not responding");
	    }
		
		
	}
	

	public void closeWindow() {
		
		try {
			driver.close();
			System.out.println("window is closed");
		} catch (WebDriverException e) {
			System.err.println("Browser is not responding");
		}
		
	}

	public void closeAllWindows() {
		try {
			driver.quit();
			System.out.println("Browser is closed");
		} catch (WebDriverException e) {
                   System.err.println("Browser is not responding");
		}
	}

	public void selectVisibleTextByName(String name, String visibleText) {
		try {
			WebElement set = driver.findElementByClassName(name);
			Select sel = new Select(set);
			sel.selectByVisibleText(visibleText);
			reportSetep("PASS","The element with the value "+name+" is found and the text value "+visibleText+" is selected");
		} catch (NoSuchElementException e) {
			   reportSetep("FAIL","The element with the value of "+name+" is not found");
		} catch(ElementNotSelectableException e) {
		      reportSetep("FAIL","The element with the value of "+name+" is not selectable");
	    }catch(WebDriverException e) {
	    	   reportSetep("FAIL","Browser is not responding");
	    }		
	}

	public void selectVisibleTextByXPath(String xpath, String visibleText) {
		try {
			WebElement set = driver.findElementByClassName(xpath);
			Select sel = new Select(set);
			sel.selectByVisibleText(visibleText);
			reportSetep("PASS","The element with the value "+xpath+" is found and the text value "+visibleText+" is selected");
		} catch (NoSuchElementException e) {
			   reportSetep("FAIL","The element with the value of "+xpath+" is not found");
		} catch(ElementNotSelectableException e) {
		      reportSetep("FAIL","The element with the value of "+xpath+" is not selectable");
	    }catch(WebDriverException e) {
	    	   reportSetep("FAIL","Browser is not responding");
	    }		
	}

	public void mouseHover(String XPath) {
           try {
			Actions action =new Actions(driver);
			   WebElement act=driver.findElementByXPath(XPath);
			   action.moveToElement(act).click().build().perform();
			   reportSetep("PASS","The element with the value "+XPath+" is found and clicked");
		} catch (NoSuchElementException e) {
			   reportSetep("FAIL","The element with the value of "+XPath+" is not found");
		} catch(ElementNotSelectableException e) {
			   reportSetep("FAIL","The element with the value of "+XPath+ " is not selectable");
		} catch(WebDriverException e) {
			    reportSetep("FAIL","Browser not responding");
		}
		
	}		
	}


	

