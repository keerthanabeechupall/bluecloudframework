package com.bluecloud.frameworkRU;

/**
 * The Reporters Data.
 *
 * @author Blue.Cloud Technologies
 */
public class Reporters extends Actiondriver {

	public static Property configProps = new Property("config.properties");

	/**
	 * 
	 * @throws Throwable
	 */
	public static void reportCreater() throws Throwable {
		HtmlReporters.htmlCreateReport();

	}

	/**
	 * 
	 * @param strStepName
	 * @param strStepDes
	 * @throws Throwable
	 */
	public static void successReport(String strStepName, String strStepDes) throws Throwable {
		java.util.Date today = new java.util.Date();
		String strTimeStamp = new java.sql.Timestamp(today.getTime()).toString();
		strTimeStamp = strTimeStamp.replace(" ", "_").replace(":", "_").replace(".", "_");
		String strValue = "";
		if (strStepName.length() > 50)
			strValue = strStepName.substring(0, 50);
		else
			strValue = strStepName;
		if (configProps.getProperty("sucessScreenShots").equalsIgnoreCase("true")) {
			Actiondriver.gf_ScreenShot(Base.filePath()
					+ strValue.replace(" ", "_").replace(":", "_").replace("</br>", "_").replace("-", "_") + "_"
					+ strTimeStamp + ".png");
		}
		HtmlReporters.onSuccess(strStepName, strStepDes, strTimeStamp);
	}

	/**
	 * 
	 * @param strStepName
	 * @param strStepDes
	 * @param blnFlag     TODO
	 * @throws Throwable
	 */
	public static void failureReport(String strStepName, String strStepDes) throws Throwable {
		java.util.Date today = new java.util.Date();
		String strTimeStamp = new java.sql.Timestamp(today.getTime()).toString();
		strTimeStamp = strTimeStamp.replace(" ", "_").replace(":", "_").replace(".", "_");
		String strValue = "";
		if (strStepName.length() > 50)
			strValue = strStepName.substring(0, 50);
		else
			strValue = strStepName;
		Actiondriver.gf_ScreenShot(
				Base.filePath() + strValue.replace("\n", "").replace(" ", "_").replace(":", "_").replace("</br>", "_")
						+ "_" + strTimeStamp + ".png");
		HtmlReporters.onFailure(strStepName, strStepDes, strTimeStamp);

	}

}
