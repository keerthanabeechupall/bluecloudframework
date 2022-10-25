package com.bluecloud.frameworkRU;

import java.io.File;

/**
 * The Constants.
 *
 * @author Blue.Cloud Technologies
 */

public class Constants {
//	//Browser Drivers path
//	public static final String CHROME_DRIVER_WIN32_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chrome"+File.separator+"chromedriver_win32"+File.separator+"chromedriver.exe";
//	public static final String CHROME_DRIVER_MAC32_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chrome"+File.separator+"chromedriver_mac32"+File.separator+"chromedriver.exe";
//	public static final String CHROME_DRIVER_LINUX32_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chrome"+File.separator+"chromedriver_linux32"+File.separator+"chromedriver.exe";
//	public static final String CHROME_DRIVER_LINUX64_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chrome"+File.separator+"chromedriver_linux64"+File.separator+"chromedriver.exe";	
//	public static final String IE_DRIVER_WIN32_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"iexplore"+File.separator+"IEDriverServer_win_32_X86.exe";
//	public static final String IE_DRIVER_WIN64_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"iexplore"+File.separator+"IEDriverServer_win_X64.exe";
//	public static final String FF_DRIVER_WIN64_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"firefox"+File.separator+"geckodriver_win64"+File.separator+"geckodriver.exe";
//	
	// Test Suite File Path
	public static final String TESTSUITE_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "TestSuites" + File.separator
			+ "SuiteRunner.xls";
	public static final String TESTSUITE_FILE_SHEETNAME = "TestSuites";
	public static final String SCREENSHOT_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "TestResults" + File.separator
			+ "Screenshots";
	public static final String REPORT_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "Reports";
	public static final String ENVIRONMENTS_CONFIG_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "Properties" + File.separator
			+ "Environments" + File.separator;
	public static final String TESTDATA_CONFIG_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "Properties" + File.separator
			+ "TestData";

	public static final String REPORT_DOWNLOAD_LOCATION = System.getProperty("user.dir") + File.separator
			+ "ReportDownloads";

	// Reports file path
	public static final String REPORTS_FILE_PATH = System.getProperty("user.dir") + File.separator + "Reports"
			+ File.separator + "DrCloudEMRAutomationReport.html";
	// Attachments file path
	public static final String ATTACHMENTS_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator + "Attachments" + File.separator;
	// Object Repository path
	public static final String OBJECT_REPOSITORY_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator + "ObjectRepo" + File.separator;
	public static final String LOG4j_PROPERTY_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "Properties" + File.separator
			+ "Log4j" + File.separator + "log4j.properties";
	public static final String SCREENSHOT_FILE_PATH = System.getProperty("user.dir") + File.separator + "Reports";
	public static final String EXECUTION_FILE_PATH = "ExecutionLog.txt";

}
