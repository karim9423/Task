package webBrowsers;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import constants.Configurations;
import io.JsonReader;
import targets.WebTarget;

public class Chrome extends WebTarget{
private static final String CHROMEPROPERTY ="webdriver.chrome.driver";
private static final String CHROMEPATH = Configurations.PROJECTPATH+"/drivers/chromedriver.exe";
private static final String CAPABALITIESPATH = Configurations.PROJECTPATH+"/BrowserConfig/Chrome.json";
private ChromeOptions options;
DesiredCapabilities capability = DesiredCapabilities.chrome();
@Override
public void intialize() {
	setConfig();
	driver = new ChromeDriver(options);
	
}

@Override
public void setConfig() {
	System.setProperty(CHROMEPROPERTY,CHROMEPATH);
	setCapabilities();
	
}

@Override
public void start() {
	intialize();
}

public void setCapabilities() {
	    JSONObject cap= JsonReader.readJson(CAPABALITIESPATH);
		options = new ChromeOptions();
		capability = new DesiredCapabilities((Map<String, ?>) cap.get("desiredCapabilities"));
		options.addArguments((List<String>) cap.get("chromeArguments"));
		options.merge(capability);
}
}