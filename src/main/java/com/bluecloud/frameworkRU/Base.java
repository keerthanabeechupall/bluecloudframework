package com.bluecloud.frameworkRU;

import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.Maps;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base class used to trigger the reports and browser initialisations
 *
 * @author Blue.Cloud Technologies
 */

public class Base {
	public static Property configProps = new Property("config.properties");
	public static WebDriverWait wait;


	public static String method = "";
	public static WebDriver driver;
	public static int count = 1;
	public static int x = 0;
	public static String sBrowserType = "";
	public static String sTestResult;
	public static String testresultPath;
	public static int iStepNo = 0;
	public static String sBrowser;
	ITestContext itc;
	public static long timeStampBeforeExecution;
	public static Map<String, String[]> ResourceData = Maps.newHashMap();

	public static Logger logger = Logger.getLogger("Static_Log");
	public static FileHandler fh;

	public static String timeStamp = Accessories.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	public static String timeStampBeforeSutie = Accessories.timeStamp().replace(" ", "_").replace(":", "_").replace(".",
			"_");

	/**
	 * Used to setup the test suite
	 * 
	 * @throws Throwable
	 */
	@BeforeSuite(alwaysRun = true)
	public void setupSuite(ITestContext ctx) throws Throwable {

		itc = ctx;
		if (sBrowserType.equalsIgnoreCase("") || sBrowserType == null)
			Accessories.calculateSuiteStartTime();
		timeStampBeforeExecution = System.currentTimeMillis();
		Reporters.reportCreater();
		HtmlReporters.currentSuit = ctx.getCurrentXmlTest().getSuite().getName();
	}

	/**
	 * Quits the browser after running the test
	 */
	@AfterTest
	public static void quitBrowser() {
		driver.quit();
	}

	/**
	 * Used for opening the browser before running the tests
	 */
	@BeforeTest

	public static void openBrowser() {
		try {
////			if (sBrowserType.equalsIgnoreCase("") || sBrowserType == null)
//				sBrowser = configProps.getProperty("browserType");
//			//else
//				sBrowser = sBrowserType;
//			//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
//			if (sBrowser.equalsIgnoreCase("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				wait = new WebDriverWait(driver, 20);
//				driver.manage().window().maximize();
//			} else if (sBrowser.equalsIgnoreCase("ie")) {
//				WebDriverManager.iedriver().setup();
//				driver = new InternetExplorerDriver();
//				wait = new WebDriverWait(driver, 20);
//				driver.manage().window().maximize();
//			} else if (sBrowser.equalsIgnoreCase("chrome")) {
//				// System.setProperty("org.apache.commons.logging.Log",
//				// "org.apache.commons.logging.impl.Jdk14Logger");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, 20);
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Quits the browser after running the test
	 */
	@AfterSuite
	public static void tearDown() throws Throwable {
		Accessories.calculateSuiteExecutionTime();
		HtmlReporters.createHtmlSummaryReport();
		// open the result file
		String dir = configProps.getProperty("openResult"); // path to your new file
		File fl = new File(dir);
		File[] folders = fl.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		});
		long lastMod = Long.MIN_VALUE;
		File choise = null;
		for (File folder : folders) {
			if (folder.lastModified() > lastMod) {
				choise = folder;
				lastMod = folder.lastModified();
			}
		}
		dir = "" + choise;
		fl = new File(dir);
		File[] files = fl.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		});
		lastMod = Long.MIN_VALUE;
		choise = null;
		for (File file : files) {
			if (file.lastModified() > lastMod) {
				choise = file;
				lastMod = file.lastModified();
			}
		}
		dir = "" + choise;
		File htmlFile = new File(dir);
		Desktop.getDesktop().browse(htmlFile.toURI());
		driver.quit();
		/*
		 * if (configProps.getProperty("MailTransfer").equalsIgnoreCase("True"))
		 * SendEmail.sendEmailReport(1,2,3,4,"","","");
		 */
	}

	/**
	 * **************************************************************************************************************************
	 * Function Name : LaunchUrl() Description : To launch URL.
	 *
	 * @param strURL the str URL
	 * @throws Throwable *************************************************************************************************************************
	 */
	public static void launchUrl(String strURL) throws Throwable {

		try {
			driver.get(strURL);
			Reporters.successReport("Launch Application URL", "Successfully launched URL : " + strURL);
		} catch (Exception e) {
			e.printStackTrace();
			Reporters.failureReport("Launch Application URL", "Failed to launch URL.");
		}
	}

	public static String filePath() {
		String strDirectoy = "ResultFile";
		new File(configProps.getProperty("screenShotPath") + strDirectoy + "_" + timeStamp).mkdirs();
		return configProps.getProperty("screenShotPath") + strDirectoy + "_" + timeStamp + "//";
	}

	@BeforeMethod(alwaysRun = true)
	public void reportHeader(Method method) {
		iStepNo = 0;
		Accessories.calculateTestCaseStartTime();
		HtmlReporters.tc_name = method.getName().toString() + "," + sBrowser + "," + Base.timeStampBeforeSutie;
		String[] ts_Name = this.getClass().getName().toString().split("\\.");
		// HtmlReporters.packageName = ts_Name[0] + "." + ts_Name[1] + "." + ts_Name[2];
		HtmlReporters.packageName = ts_Name[0] + "." + ts_Name[1];

		HtmlReporters.reportHeader("Script Name : " + method.getName().toString());

		Accessories.calculateStepStartTime();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownAfterMethod() {
		Accessories.calculateTestCaseExecutionTime();
		HtmlReporters.executionTime.put(HtmlReporters.tc_name, HtmlReporters.iTestExecutionTime);
		HtmlReporters.testCaseExecutionTime();
	}

	// @BeforeSuite(alwaysRun = true)
	/***
	 * This Method runs before suite runs
	 */
	public static void LogFileCreation() throws IOException {
		logger.setUseParentHandlers(false);
		try {
			String strDateTime = Actiondriver.gf_CurrentDate("dd/MM/yyyy") + "_"
					+ Actiondriver.gf_CurrentDate("hh:mm:ss");
			String strFile = configProps.getProperty("LogFileName");
			strFile = strFile.replace(".", "_" + strDateTime + ".");
			fh = new FileHandler(strFile.replace("/", "").replace(":", "")); // Object of the log file
			logger.addHandler(fh);
			/*
			 * LogFormatter formatter = new LogFormatter(); fh.setFormatter(formatter);
			 */ // Format
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}