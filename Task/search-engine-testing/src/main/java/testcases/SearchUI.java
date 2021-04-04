package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import constants.Configurations;
import io.ExcelReader;
import pages.HomePage;
import targets.TargetManger;
import ui.Screenshots;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class SearchUI {
	 HomePage home;
	 ExcelReader dataReader;
	  public static ExtentTest test;
	  static ExtentReports report;
  
  @BeforeClass
  public void beforeClass() {
	  report = new ExtentReports(Configurations.PROJECTPATH+"\\SearchUIReport.html");
	TargetManger.setTarget(ui.BrowserDialog.selectBroswer());
	 dataReader = new ExcelReader(Configurations.DATASHEETPATH,Configurations.DATASHEET);
  }

  @BeforeMethod
  public void reset() {
//	  TargetManger.getTarget().clearCoockies();
	  TargetManger.getTarget().open(dataReader.getCellData(1,1,Configurations.DATASHEET));
	
  } 
  @Test (priority=1)
  public void testUI() {
	  test = report.startTest("testUI");
	  home = new HomePage(TargetManger.getTarget().getDriver(), new ExcelReader(Configurations.HOMEPAGE_REPOSHEETPATH,Configurations.HOMEPAGE_OBJECTREPOSHEET));
	  home.verifySearchBox();
	  home.verifyGoogleImage();	
	  home.verifyGooglesize();
	  test.log(LogStatus.PASS,"Page Verified");
  }
  
  @Test (priority=3) 
  public void testBasicSearch() {
	  test = report.startTest("testBasicSearch");
	  home.search(dataReader.getCellData(2,1,Configurations.DATASHEET));
	  home.searchWithEnter();
	  int resultscount = home.getResultsNum(dataReader.getCellData(2,1,Configurations.DATASHEET));
	  resultscount+=home.getResultsTextNum(dataReader.getCellData(2,1,Configurations.DATASHEET));
	  test.log(LogStatus.PASS,resultscount+" Results found for" + dataReader.getCellData(2,1,Configurations.DATASHEET));
	  home.search(dataReader.getCellData(3,1,Configurations.DATASHEET));
	  home.searchWithEnter();
	  int resultPagesearchcount = home.getResultsNum(dataReader.getCellData(3,1,Configurations.DATASHEET));
	  resultPagesearchcount+=home.getResultsTextNum(dataReader.getCellData(3,1,Configurations.DATASHEET));
	  test.log(LogStatus.PASS,resultPagesearchcount+" Results found for" + dataReader.getCellData(3,1,Configurations.DATASHEET));
  }
  
  @Test (priority=2) 
  public void testAdvancedSearch() {
	  test = report.startTest("testAdvancedSearch");
	  home.clickSettings();
	  home.waitForSearchSettings(20);
	  home.clickSearchSettings();
	  home.increaseResultssize();
	  home.clickRightKey();
	  home.savePreference();
	  home.confirmsave();
	  test.log(LogStatus.PASS,"Advanced search performed");
  }
  @AfterClass
  public void afterClass() {
	  report.endTest(test);
	  report.flush();
	  try {
		Desktop.getDesktop().open(new File(Configurations.PROJECTPATH+"\\SearchUIReport.html"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	  TargetManger.getTarget().quit(); 
  }
  @AfterMethod
  public void getResult(ITestResult result) throws IOException
  {

      String screenShotPath = Screenshots.capture(TargetManger.getTarget().getDriver(), "screenShotName"+result.getEndMillis());
      if(result.getStatus() == ITestResult.FAILURE)  	  
      {
          test.log(LogStatus.FAIL, result.getThrowable());
          test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
      }
      else if(result.getStatus() == ITestResult.SUCCESS)
      {
    	  test.log(LogStatus.PASS, result.getTestName());
          test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));  
      }
      report.endTest(test);
  }
}
