package webBrowsers;

import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import constants.Configurations;
import io.JsonReader;
import targets.WebTarget;

public class InternetExplorer extends WebTarget{
	
	    private static final String IEPROPERTY ="webdriver.ie.driver";
		private static final String IEPATH =  Configurations.PROJECTPATH+"/drivers/IEDriverServer.exe";
		private static final String CAPABALITIESPATH = Configurations.PROJECTPATH+"/BrowserConfig/IExplorer.json";
		private DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
	    private InternetExplorerOptions options;
		
	  
		@Override
		public void intialize() {		
			setConfig();
			driver = new InternetExplorerDriver(options);
		}
		
		@Override
		public void setConfig() {
			System.setProperty(IEPROPERTY,IEPATH);
			setCapabilities();				
		}
		
		private void setCapabilities() {
			 JSONObject cap= JsonReader.readJson(CAPABALITIESPATH);
			    options = new InternetExplorerOptions();
				capability = new DesiredCapabilities((Map<String, ?>) cap.get("desiredCapabilities"));
				options.merge(capability);
		}
		@Override
		public void start() {
		intialize();
			
		}

}
