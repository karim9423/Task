package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import actions.WebActions;
import constants.Configurations;
import io.ExcelReader;


	public class HomePage {
		 WebActions actions;
		 private ExcelReader homePageobjectRepo;
		 
		 public HomePage(WebDriver driver,ExcelReader repo){
		        actions = new WebActions(driver);
		        homePageobjectRepo = repo;
		    }

		 public void verifySearchBox(){
			 actions.isElementVisible(homePageobjectRepo.getCellData(1,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(1,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public void search(String text){
			 actions.type(homePageobjectRepo.getCellData(1,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(1,2,Configurations.HOMEPAGE_OBJECTREPOSHEET),text);
		    }
		 
		 public void searchWithEnter(){
			 actions.type(homePageobjectRepo.getCellData(1,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(1,2,Configurations.HOMEPAGE_OBJECTREPOSHEET), Keys.ENTER);
		    }
	
		 
		 public void clickSearch(){
			 actions.click(homePageobjectRepo.getCellData(2,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(2,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public String verifyGoogleImage(){
			 return actions.getELementlocation(homePageobjectRepo.getCellData(3,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(3,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public String verifyGooglesize(){
			 return actions.getELementSize(homePageobjectRepo.getCellData(3,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(3,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public void clickSettings(){
			 actions.click(homePageobjectRepo.getCellData(4,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(4,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public void clickSearchSettings(){
			 actions.click(homePageobjectRepo.getCellData(5,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(5,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public void increaseResultssize(){
			 actions.click(homePageobjectRepo.getCellData(8,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(8,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public void clickRightKey(){
			 actions.type(homePageobjectRepo.getCellData(1,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(1,2,Configurations.HOMEPAGE_OBJECTREPOSHEET), Keys.ARROW_RIGHT);
		    }
		 
		 public void savePreference(){
			 actions.click(homePageobjectRepo.getCellData(9,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(9,2,Configurations.HOMEPAGE_OBJECTREPOSHEET));
		    }
		 
		 public void waitForSearchSettings(int timeout){
			 actions.waitForelement(homePageobjectRepo.getCellData(5,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(5,2,Configurations.HOMEPAGE_OBJECTREPOSHEET),timeout);
		    }
		 
		 public void confirmsave(){
			 actions.handlealertOK();
		    }
		 
		 public int getResultsNum(String customized){
			 return actions.getELementsCount(actions.customizeXPath(homePageobjectRepo.getCellData(6,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(6,2,Configurations.HOMEPAGE_OBJECTREPOSHEET),customized,true));
		    }
		 public int getResultsTextNum(String customized){
			 return actions.getELementsCount(actions.customizeXPath(homePageobjectRepo.getCellData(7,1,Configurations.HOMEPAGE_OBJECTREPOSHEET), homePageobjectRepo.getCellData(7,2,Configurations.HOMEPAGE_OBJECTREPOSHEET),customized,true));
		    }
	}

