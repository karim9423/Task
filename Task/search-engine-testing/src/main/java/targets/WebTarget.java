package targets;

import org.openqa.selenium.WebDriver;

public abstract class WebTarget {
	protected WebDriver driver;
	
	
	public abstract void intialize();
	
	public abstract void setConfig();
	
	public abstract void start();
	
	public void clearCoockies() {
		driver.manage().deleteAllCookies();
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void quit() {
		driver.quit();
	}
}