package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import testcases.SearchUI;

public class WebActions {
	private WebDriver driver;
	
	public WebActions(WebDriver driver) {
		this.driver = driver;
	}
	
	/**This method is used to return web element directly with the input values
	 * 
	 * @param identifier : the identifier used to locate the element
	 * @param identificationValue : the identifier value to retrieve element
	 * @return WebElement retrieved through the arguments values
	 */
	public WebElement getelement(String identifier,String identificationValue)  {
			WebElement webelement = null;
			By by = getIdentifierType(identifier, identificationValue);
				try {
					webelement = driver.findElement(by);
				} catch (IllegalArgumentException e) {
					System.out.println("The selected locator is invalid");
				}
				return webelement;
		}
	
	/**This method is used to navigate to the given url
	 * @param url : the target url vlaue
	 */
	public void open (String url)
	{
		try
	{
	driver.get(url);
	
	SearchUI.test.log(LogStatus.PASS,"(" +url+")"+" opened");
	}
	catch (Exception e)
	{
		SearchUI.test.log(LogStatus.FAIL, "Failed to open "+"("+url+")");
	}
	}
	
	/**This method is used to click on  webelement directly with the input values
	 * 
	 * @param identifier : the idenitifier used to locate the element
	 * @param Value : the identifier value to retrieve element
	 */
	public void click (String identifier,String value)
	{
		try {
			getelement(identifier,value).click();
			SearchUI.test.log(LogStatus.PASS, "Element with "+identifier+":"+value+" clicked");
			}catch(Exception e)
			{
				SearchUI.test.log(LogStatus.FAIL, "Failed to Click element with "+identifier+":"+value);	
			}

	}

	
	public List<WebElement> getElements(String identifier,String identificationValue)
	{
		return driver.findElements(getIdentifierType(identifier, identificationValue));
	}
	
	public By getIdentifierType(String identifier,String identificationValue)
	{
		By by = null;
		if (identifier.equalsIgnoreCase("Id")) {
			by = By.id(identificationValue);
		} else if (identifier.equalsIgnoreCase("Name")) {
			by = By.name(identificationValue);
		} else if (identifier.equalsIgnoreCase("Xpath")) {
			by = By.xpath(identificationValue);
		} else if (identifier.equalsIgnoreCase("CSS Selector")) {
			by = By.cssSelector(identificationValue);
		} else if (identifier.equalsIgnoreCase("Tag Name")) {
			by = By.tagName(identificationValue);
		} else if (identifier.equalsIgnoreCase("Link Text")) {
			by = By.linkText(identificationValue);
		} else if (identifier.equalsIgnoreCase("Partial Link Text")) {
			by = By.partialLinkText(identificationValue);
		}	
		return by;
	}
	/**This method is used to type to a webelement directly with the input values
	 * 
	 * @param identifier : the idenitifier used to locate the element
	 * @param Value : the identifier value to retrieve element
	 * @param Value : the text to be written
	 */
	public void type (String identifier,String value,CharSequence text)
	{
		try 
		{
		getelement(identifier,value).clear();
		getelement(identifier,value).sendKeys(text);
		SearchUI.test.log(LogStatus.PASS, "Type performed on element "+identifier+":"+value);
		}catch (Exception e)
		{
			SearchUI.test.log(LogStatus.FAIL, "Type failed on element"+identifier+":"+value);	
		}
	}
	
	/**This method is used to wait for a webelement to be clickable directly with the input values for the specified amount of time
	 * 
	 * @param identifier : the idenitifier used to locate the element
	 * @param Value : the identifier value to retrieve element
	 * @param timeout : the time to wait for the element to be clickable
	 */
	public void waitForelement(String identifier,String value,int timeout)
	{
		try 
		{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(getelement(identifier,value)));
		SearchUI.test.log(LogStatus.PASS, "Waited For Element with" +identifier+":"+value +"For "+timeout + "sec");
		}
		catch (Exception e)
		{
			SearchUI.test.log(LogStatus.FAIL, "Failed to find element with"+identifier+":"+value);
		}
	}
	
	
	/**This method is used to wait for a webelement to become visible directly with the input values for the specified amount of time
	 * 
	 * @param identifier : the idenitifier used to locate the element
	 * @param Value : the identifier value to retrieve element
	 * @param timeout : the time to wait for the element to be visible.
	 */
	public boolean isElementVisible(String identifier,String value)
	{
		if (getelement(identifier, value).isDisplayed())
		{
			SearchUI.test.log(LogStatus.PASS, "Element with "+identifier+":"+value+" is visisble");	
			return true;
		}
		else
		{
			SearchUI.test.log(LogStatus.FAIL, "Element with "+identifier+":"+value+" is not displayed");	
		return false;
		}	
		
	}
	public String getELementlocation(String identifier,String value)
	{
		try
		{
		String location= getelement(identifier, value).getLocation().toString();
		SearchUI.test.log(LogStatus.PASS, "Element with "+identifier+":"+value+" location is"+location);	
		return location;
		}
		catch (Exception e)
		{
			SearchUI.test.log(LogStatus.FAIL, "Element with "+identifier+":"+value+" is not displayed");
			return null;
		}
		
	}
	public String getELementSize(String identifier,String value)
	{
		try
		{
		String size= getelement(identifier, value).getSize().toString();
		SearchUI.test.log(LogStatus.PASS, "Element with "+identifier+":"+value+" Size is"+size);	
		return size;
		}
		catch (Exception e)
		{
			SearchUI.test.log(LogStatus.FAIL, "Element with "+identifier+":"+value+" is not displayed");
			return null;
		}
	}
	public WebElement customizeXPath(String identifier,String value,String desiredvalue)
	{
		String customeized=value.replace("CustomizedPath",desiredvalue);
		return getelement(identifier, customeized);
	}
	public List<WebElement> customizeXPath(String identifier,String value,String desiredvalue,boolean isGroup)
	{
		String customeized=value.replace("CustomizedPath",desiredvalue);
		return getElements(identifier, customeized);
	}
	
	public int getELementsCount(List<WebElement> elements)
	{
		return elements.size();
		
	}
	public void handlealertOK() {
		driver.switchTo().alert().accept();
	}
}
