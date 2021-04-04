package webBrowsers;

import java.io.File;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import constants.Configurations;
import io.JsonReader;
import targets.WebTarget;

public class Firefox extends WebTarget{
	
	private static final String FFPROPERTY ="webdriver.gecko.driver";
	private static final String FIREFOXPATH =  Configurations.PROJECTPATH+"/drivers/geckodriver.exe";
	private static final String CAPABALITIESPATH = Configurations.PROJECTPATH+File.separator+"BrowserConfig"+File.separator+"Firefox.json";
	DesiredCapabilities capability = DesiredCapabilities.firefox();
  private FirefoxOptions options;
  
	@Override
	public void intialize() {		
		setConfig();
		driver = new FirefoxDriver(options);
	}
	
	@Override
	public void setConfig() {
		System.setProperty(FFPROPERTY,FIREFOXPATH);
		setCapabilities();				
	}
	
	private void setCapabilities() {
		 JSONObject cap= JsonReader.readJson(CAPABALITIESPATH);
		    options = new FirefoxOptions();
			capability = new DesiredCapabilities((Map<String, ?>) cap.get("desiredCapabilities"));
			options.merge(capability);
	}
	@Override
	public void start() {
	intialize();
		
	}
	
}

