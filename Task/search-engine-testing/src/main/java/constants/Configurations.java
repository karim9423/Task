package constants;

public class Configurations {
	private Configurations() {}
	public static final String PROJECTPATH = System.getProperty("user.dir");
	public static final String DATASHEETPATH = PROJECTPATH+"/TestData/TestData.xlsx";
	public static final String DATASHEET = "Data";
	public static final String REG_PAGE_REPOSHEETPATH = PROJECTPATH+"/ObjectRepo/RegisterationPage.xlsx";
	public static final String REG_PAGE_OBJECTREPOSHEET = "RegistrationPage";
	public static final String HOMEPAGE_REPOSHEETPATH = PROJECTPATH+"/ObjectRepo/HomePage.xlsx";
	public static final String HOMEPAGE_OBJECTREPOSHEET = "HomePage";
	public static final String [] browsers= {"Chrome","FireFox","InternetExplorer","Edge"};
}
