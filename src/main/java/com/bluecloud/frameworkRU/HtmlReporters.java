package com.bluecloud.frameworkRU;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;

/**
 * The HtmlReports.
 *
 * @author Blue.Cloud Technologies
 */
public class HtmlReporters {

	public static long iStepStartTime = 0;
	public static long iStepEndTime = 0;
	public static long iStepExecutionTime = 0;
	public static long iTestStartTime = 0;
	public static long iTestEndTime = 0;
	public static long iTestExecutionTime = 0;
	public static long iSuiteStartTime = 0;
	public static long iSuiteEndTime = 0;
	public static double iSuiteExecutionTime = 0;
	public static ArrayList<Double> list = new ArrayList<Double>();
	public static long startStepTime = 0;
	public static long endStepTime = 0;
	public static double stepExecutionTime = 0;

	static String startedAt = "";
	public static String strTestName = "";
	public static String tc_name = "";
	public static String packageName = "";
	public static Map<String, String> map = new LinkedHashMap<String, String>();
	public static Map<String, Long> executionTime = new LinkedHashMap<String, Long>();
	static Property config = new Property("config.properties");
	public static String currentSuit = "";
	public static int pCount = 0;
	public static int fCount = 0;
	public static int intPassNum;
	public static int intFailNum;
	public static String[] key;

	public static long tcStartTime = 0;
	public static long tcEndTime = 0;
	public static double tcExecutionTime = 0;
	public static List<Long> currentTimeList = Lists.newArrayList();
	static String workingDir = System.getProperty("user.dir").replace(File.separator, "/");

	/**
	 * Calculate Start Time
	 */
	public static void startTime() {
		tcStartTime = System.currentTimeMillis(); // For Step End time
	}

	/**
	 * Used to create results.html
	 * 
	 * @throws Exception
	 */
	public static void htmlCreateReport() throws Exception {
		File file = new File(Base.filePath() + "Results_" + Base.timeStampBeforeSutie + ".html");
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * Used to create summary report
	 * 
	 * @throws Exception
	 */
	public static void createHtmlSummaryReport() throws Exception {
		File file = new File(Base.filePath() + "/" + "SummaryResults_" + Base.timeStamp + ".html");
		Writer writer = null;
		if (file.exists()) {
			file.delete();
		}
		writer = new FileWriter(file, true);
		try {
			writer.write("<!DOCTYPE html>");
			writer.write("<html> ");
			writer.write("<head> ");
			writer.write("<meta> ");
			writer.write("<title>BlueNetTech - Automation Execution Results Summary</title>");
			writer.write("<style type='text/css'>");
			writer.write("body {");
			writer.write("background-color: #fff; ");
			writer.write("font-family: arial; ");
			writer.write("text-align: center; ");
			writer.write("} ");
			writer.write("small { ");
			writer.write("font-size: 0.7em; ");
			writer.write("} ");
			writer.write("table { ");
			writer.write("box-shadow: 9px 9px 10px 4px #BDBDBD;");
			writer.write("border: 0px solid #4D7C7B;");
			writer.write("border-collapse: collapse; ");
			writer.write("border-spacing: 0px; ");
			writer.write("width: 1000px; ");
			writer.write("margin-left: auto; ");
			writer.write("margin-right: auto; ");
			writer.write("} ");
			writer.write("tr.heading { ");
			writer.write("background-color: #004688;");
			writer.write("color: #FFFFFF; ");
			writer.write("font-size: 0.9em; ");
			writer.write("font-weight: bold; ");
			writer.write(
					"background:-o-linear-gradient(bottom, #328dc6 5%, #004688 100%);	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #328dc6), color-stop(1, #004688));");
			writer.write("background:-moz-linear-gradient(center top, #328dc6 5%, #004688 100%);");
			writer.write(
					"filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#328dc6, endColorstr=#004688);	background: -o-linear-gradient(top, #328dc6, #004688)");
			writer.write("} ");

			writer.write("tr.heading1 {");
			writer.write("font-size: 0.9em; ");
			writer.write("} ");

			writer.write("tr.subheading { ");
			writer.write("background-color: #e4f2fb;");
			writer.write("color: #000000; ");
			writer.write("font-weight: bold; ");
			writer.write("font-size: 0.9em; ");
			writer.write("text-align: justify; ");
			writer.write("} ");
			writer.write("tr.section { ");
			writer.write("background-color: #A4A4A4; ");
			writer.write("color: #333300; ");
			writer.write("cursor: pointer; ");
			writer.write("font-weight: bold;");
			writer.write("font-size: 0.8em; ");
			writer.write("text-align: justify;");
			writer.write(
					"background:-o-linear-gradient(bottom, #56aaff 5%, #e5e5e5 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #56aaff), color-stop(1, #e5e5e5) );");
			writer.write("background:-moz-linear-gradient( center top, #56aaff 5%, #e5e5e5 100% );");
			writer.write(
					"filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#56aaff, endColorstr=#e5e5e5);	background: -o-linear-gradient(top,#56aaff,e5e5e5);");
			writer.write("} ");
			writer.write("tr.subsection { ");
			writer.write("cursor: pointer; ");
			writer.write("} ");
			writer.write("tr.content { ");
			writer.write("background-color: #FFFFFF; ");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.7em; ");
			writer.write("display: table-row; ");
			writer.write("} ");
			writer.write("tr.content2 { ");
			writer.write("background-color:#e4f2fb");
			writer.write("border: 1px solid #4D7C7B;");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.7em; ");
			writer.write("display: table-row; ");
			writer.write("} ");
			writer.write("td, th { ");
			writer.write("padding: 5px; ");
			writer.write("border: 1px solid #4D7C7B; ");
			writer.write("text-align: inherit\0/; ");
			writer.write("} ");
			writer.write("th.Logos { ");
			writer.write("padding: 5px; ");
			writer.write("border: 0px solid #4D7C7B; ");
			writer.write("text-align: inherit /;");
			writer.write("} ");
			writer.write("td.justified { ");
			writer.write("text-align: justify; ");
			writer.write("} ");
			writer.write("td.pass {");
			writer.write("font-weight: bold; ");
			writer.write("color: green; ");
			writer.write("} ");
			writer.write("td.fail { ");
			writer.write("font-weight: bold; ");
			writer.write("color: red; ");
			writer.write("} ");
			writer.write("td.done, td.screenshot { ");
			writer.write("font-weight: bold; ");
			writer.write("color: black; ");
			writer.write("} ");
			writer.write("td.debug { ");
			writer.write("font-weight: bold; ");
			writer.write("color: blue; ");
			writer.write("} ");
			writer.write("td.warning { ");
			writer.write("font-weight: bold; ");
			writer.write("color: orange; ");
			writer.write("} ");
			writer.write("</style> ");
			writer.write("<script> ");
			writer.write("function toggleMenu(objID) { ");
			writer.write(" if (!document.getElementById) return;");
			writer.write(" var ob = document.getElementById(objID).style; ");
			writer.write("if(ob.display === 'none') { ");
			writer.write(" try { ");
			writer.write(" ob.display='table-row-group';");
			writer.write("} catch(ex) { ");
			writer.write("	 ob.display='block'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("else { ");
			writer.write(" ob.display='none'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("function toggleSubMenu(objId) { ");
			writer.write("for(i=1; i<10000; i++) { ");
			writer.write("var ob = document.getElementById(objId.concat(i)); ");
			writer.write("if(ob === null) { ");
			writer.write("break; ");
			writer.write("} ");
			writer.write("if(ob.style.display === 'none') { ");
			writer.write("try { ");
			writer.write(" ob.style.display='table-row'; ");
			writer.write("} catch(ex) { ");
			writer.write("ob.style.display='block'; ");
			writer.write("} ");
			writer.write(" } ");
			writer.write("else { ");
			writer.write("ob.style.display='none'; ");
			writer.write("} ");
			writer.write(" } ");
			writer.write("} ");
			writer.write("</script> ");
			writer.write("</head> ");

			writer.write("<body> ");
			writer.write("</br>");

			writer.write("<table id='Logos'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("</colgroup> ");
			writer.write("<thead> ");

			writer.write("<tr class='content'>");
			writer.write("<th class ='Logos' colspan='2' align='left'>");
			writer.write("<img src='file:///" + workingDir + "//Logos//" + config.getProperty("Client_logo")
					+ ".png' height='60%'>");
			writer.write("</th>");
			writer.write("<th class = 'Logos' colspan='2' align='right'> ");
			writer.write("</th> ");
			writer.write("</tr> ");

			writer.write("</thead> ");
			writer.write("</table> ");

			writer.write("<table id='header'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 40%' /> ");
			writer.write("<col style='width: 60%' /> ");
			writer.write("</colgroup> ");

			writer.write("<thead> ");

			writer.write("<tr class='heading'> ");
			writer.write("<th colspan='2' style='font-family:arial; font-size:1.4em; padding: 10px 0;'> ");
			writer.write("Fast PoC - Automation Execution Result Summary");
			writer.write("</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Build Version&nbsp;&nbsp;</th> ");
			writer.write("<th> &nbsp;" + config.getProperty("BuildVersion") + "&nbsp;</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Date&nbsp;&&nbsp;Time&nbsp;&nbsp;</th> ");
			writer.write("<th> &nbsp;" + Accessories.timeStamp() + "&nbsp;</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;OS Name&nbsp;&nbsp;</th> ");
			writer.write("<th> &nbsp;" + System.getProperty("os.name") + "&nbsp;</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Suite Executed&nbsp;&nbsp;</th> ");
			writer.write("<th> &nbsp;Proof of Concept&nbsp;</th> ");
			writer.write("</tr> ");
			/*
			 * writer.write("<tr class='subheading'> ");
			 * writer.write("<th>&nbsp;Suite Name&nbsp;</th> "); writer.write("<th> &nbsp;"
			 * + currentSuit + "&nbsp;</th> "); writer.write("</tr> ");
			 */

			/*
			 * --------------- UPDATE TO ADD ENVIRONMENT FROM CONFIG.PROPERTIES
			 * -----------------------
			 */

			/*
			 * writer.write("<tr class='subheading'> ");
			 * writer.write("<th colspan='2' align='left'> ");
			 * writer.write("&nbsp;Environment -  CliamSecure.com"); writer.write("</th> ");
			 * writer.write("</tr> ");
			 */

			writer.write("</thead> ");
			writer.write("</table> ");
			writer.write("<table id='main'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 5%' /> ");
			writer.write("<col style='width: 47%' /> ");
			writer.write("<col style='width: 30%' /> ");
			writer.write("<col style='width: 10%' /> ");
			writer.write("<col style='width: 8%' /> ");
			writer.write("</colgroup> ");
			writer.write("<thead> ");
			writer.write("<tr class='heading'> ");
			writer.write("<th>S.NO</th> ");
			writer.write("<th>Test Case</th> ");
			writer.write("<th>Browser</th> ");
			writer.write("<th>Time</th> ");
			writer.write("<th>Status</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");
			Iterator<Entry<String, String>> iterator1 = map.entrySet().iterator();
			int serialNo = 1;
			while (iterator1.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map.Entry mapEntry1 = (Map.Entry) iterator1.next();
				key = mapEntry1.getKey().toString().split(":");
				String b1 = (String) key[1];
				String sBrowser = b1.toString().split(",")[1];
				String timeStamp = b1.toString().split(",")[2];
				String value = (String) mapEntry1.getValue();

				writer.write("<tbody style='font-size:18px'> ");
				writer.write("<tr class='content2' > ");
				writer.write("<td align='center'>" + serialNo + "</td>");
				if (value.equalsIgnoreCase("pass")) {
					writer.write("<td><a href='Results_" + timeStamp + ".html#" + b1.toString().split(",")[0] + "'>"
							+ b1.toString().split(",")[0] + "</a>" + "</td>");
				} else if (value.equalsIgnoreCase("fail")) {
					writer.write("<td><a href='Results_" + timeStamp + ".html#" + b1.toString().split(",")[0] + "'>"
							+ b1.toString().split(",")[0] + "</a>" + "</td>");
				} else
					writer.write("<td>" + b1.toString().split(",")[0] + "</td>");
				writer.write("<td>" + sBrowser + "</td>");
				writer.write("<td>" + executionTime.get(b1) + " Seconds</td>");
				if (value.equals("PASS")) {
					writer.write("<td class='pass'>" + value + "</td> ");
					pCount++;
				} else if (value.equals("FAIL")) {
					writer.write("<td class='fail'>" + value + "</td> ");
					fCount++;
				} else {
					writer.write("<td class='fail'>Not Executed</td> ");
					fCount++;
				}
				writer.write("</tr>");

				writer.write("</tbody> ");
				serialNo = serialNo + 1;
			}
			writer.flush();
			writer.close();
			closeSummaryReport(serialNo);
		} catch (Exception e) {
			writer.flush();
			writer.close();
			e.printStackTrace();
		}

	}

	/**
	 * Used to create report header for results.html
	 * 
	 * @param testName: Test name
	 */
	public static void reportHeader(String testName) {
		Writer writer = null;
		try {
			strTestName = testName;
			File file = new File(Base.filePath() + "Results_" + Base.timeStampBeforeSutie + ".html");
			writer = new FileWriter(file, true);

			writer.write("<!DOCTYPE html> ");
			writer.write("<html>");
			writer.write("<head> ");
			writer.write("<meta> ");
			writer.write("<title>" + strTestName + " Execution Results</title> ");

			writer.write("<style type='text/css'> ");
			writer.write("body { ");
			writer.write("background-color: #fff; ");
			writer.write("font-family: arial; ");
			writer.write("text-align: center; ");
			writer.write("} ");

			writer.write("small { ");
			writer.write("font-size: 0.7em; ");
			writer.write("} ");

			writer.write("table { ");
			writer.write("box-shadow: 9px 9px 10px 4px #BDBDBD;");
			writer.write("border: 0px solid #4D7C7B; ");
			writer.write("border-collapse: collapse; ");
			writer.write("border-spacing: 0px; ");
			writer.write("width: 1000px; ");
			writer.write("margin-left: auto; ");
			writer.write("margin-right: auto; ");
			writer.write("} ");

			writer.write("tr.heading { ");
			writer.write("background-color: #004688; ");
			writer.write("color: #FFFFFF; ");
			writer.write("font-size: 0.9em; ");
			writer.write("font-weight: bold; ");
			writer.write(
					"background:-o-linear-gradient(bottom, #328dc6 5%, #004688 100%);	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #328dc6), color-stop(1, #004688));");
			writer.write("background:-moz-linear-gradient(center top, #328dc6 5%, #004688 100%);");
			writer.write(
					"filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#328dc6, endColorstr=#004688);	background: -o-linear-gradient(top, #328dc6, #004688);");
			writer.write("} ");

			/* added by Naresh for uplifting the UI */

			writer.write("tr.heading1{");
			writer.write("font-size: 0.9em;");
			writer.write("} ");

			writer.write("tr.subheading { ");
			writer.write("background-color: #FFFFFF; ");
			writer.write("color: #000000; ");
			writer.write("font-weight: bold; ");
			writer.write("font-size: 0.9em; ");
			writer.write("text-align: justify; ");
			writer.write("} ");

			writer.write("tr.section { ");
			writer.write("background-color: #A4A4A4; ");
			writer.write("color: #333300; ");
			writer.write("cursor: pointer; ");
			writer.write("font-weight: bold; ");
			writer.write("font-size: 0.7em; ");
			writer.write("text-align: justify; ");
			writer.write(
					"background:-o-linear-gradient(bottom, #56aaff 5%, #e5e5e5 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #56aaff), color-stop(1, #e5e5e5) );");
			writer.write("background:-moz-linear-gradient( center top, #56aaff 5%, #e5e5e5 100% );");
			writer.write(
					"filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#56aaff, endColorstr=#e5e5e5);	background: -o-linear-gradient(top,#56aaff,e5e5e5);");
			writer.write("} ");

			writer.write("tr.subsection { ");
			writer.write("cursor: pointer; ");
			writer.write("} ");

			writer.write("tr.content { ");
			writer.write("background-color: #FFFFFF; ");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.7em; ");
			writer.write("display: table-row; ");
			writer.write("} ");

			writer.write("tr.content2 { ");
			writer.write("background-color: #e4f2fb; ");
			writer.write("border: 1px solid #4D7C7B;");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.9em; ");
			writer.write("display: table-row; ");
			writer.write("} ");

			writer.write("td, th { ");
			writer.write("padding: 5px; ");
			writer.write("border: 1px solid #4D7C7B; ");
			writer.write("text-align: inherit/; ");
			writer.write("} ");

			writer.write("th.Logos { ");
			writer.write("padding: 5px; ");
			writer.write("border: 0px solid #4D7C7B; ");
			writer.write("text-align: inherit /;");
			writer.write("} ");

			writer.write("td.justified { ");
			writer.write("text-align: justify; ");
			writer.write("} ");

			writer.write("td.pass { ");
			writer.write("font-weight: bold; ");
			writer.write("color: green; ");
			writer.write("} ");

			writer.write("td.fail { ");
			writer.write("font-weight: bold; ");
			writer.write("color: red; ");
			writer.write("} ");

			writer.write("td.done, td.screenshot { ");
			writer.write("font-weight: bold; ");
			writer.write("color: black; ");
			writer.write("} ");

			writer.write("td.debug { ");
			writer.write("font-weight: bold;");
			writer.write("color: blue; ");
			writer.write("} ");

			writer.write("td.warning { ");
			writer.write("font-weight: bold; ");
			writer.write("color: orange; ");
			writer.write("} ");
			writer.write("</style> ");

			writer.write("<script> ");
			writer.write("function toggleMenu(objID) { ");
			writer.write("if (!document.getElementById) return; ");
			writer.write("var ob = document.getElementById(objID).style; ");
			writer.write("if(ob.display === 'none') { ");
			writer.write("try { ");
			writer.write("ob.display='table-row-group'; ");
			writer.write("} catch(ex) { ");
			writer.write("ob.display='block'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("else { ");
			writer.write("ob.display='none'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("function toggleSubMenu(objId) { ");
			writer.write("for(i=1; i<10000; i++) { ");
			writer.write("var ob = document.getElementById(objId.concat(i)); ");
			writer.write("if(ob === null) { ");
			writer.write("break; ");
			writer.write("} ");
			writer.write("if(ob.style.display === 'none') { ");
			writer.write("try { ");
			writer.write("ob.style.display='table-row'; ");
			writer.write("} catch(ex) { ");
			writer.write("ob.style.display='block'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("else { ");
			writer.write("ob.style.display='none'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("} ");
			writer.write("</script> ");
			writer.write("</head> ");

			writer.write(" <body> ");
			writer.write("</br>");

			writer.write("<table id='Logos'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("</colgroup> ");
			writer.write("<thead> ");

			writer.write("<tr class='content'>");
			writer.write("<th class ='Logos' colspan='2' align='left'>");
			writer.write("<img src='file:///" + workingDir + "/Logos/" + config.getProperty("Client_logo")
					+ ".png' height='60%'>");
			writer.write("</th>");
			writer.write("<th class = 'Logos' colspan='2' align='right'> ");
			writer.write("</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");
			writer.write("</table> ");

			writer.write("<table id='header'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("</colgroup> ");

			writer.write(" <thead> ");

			writer.write("<tr class='heading'> ");
			writer.write("<th colspan='4' style='font-family:arial; font-size:1.1em; padding: 10px 0;'> ");
			writer.write(strTestName + " Execution Results");
			writer.write("</th> ");
			writer.write("</tr> ");

			writer.write("<tr class='subheading'> ");
			writer.write("<th align='left' colspan='2' width='50%'>&nbsp;Date & Time : " + Accessories.timeStamp()
					+ "</th> ");

			// writer.write("<th>" + Accessories.timeStamp() + "</th> ");
			writer.write(
					"<th align='left' colspan='2' width='50%'>&nbsp;Browser: " + (tc_name.split(",")[1]) + "</th> ");

			// writer.write("<th>" + (tc_name.split(",")[1]) + "</th> ");
			writer.write("</tr> ");

			writer.write("</thead> ");
			writer.write("</table> ");

			writer.write("<table id='main'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 5%' /> ");
			writer.write("<col style='width: 26%' /> ");
			writer.write("<col style='width: 51%' /> ");
			writer.write("<col style='width: 8%' /> ");
			writer.write("<col style='width: 10%' /> ");
			writer.write("</colgroup> ");
			writer.write("<thead> ");
			writer.write("<tr class='heading'> ");
			writer.write("<th>S.NO</th> ");
			writer.write("<th>Steps</th> ");
			writer.write("<th>Description</th> ");
			writer.write("<th>Status</th> ");
			writer.write("<th>Time in sec</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");
			writer.flush();
			writer.close();
			map.put(packageName + ":" + tc_name, "status");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Used to update results.html on success
	 * 
	 * @param strStepName:  Step name to update in the report
	 * @param strStepDes:   Steps description to update in the report
	 * @param strTimeStamp: time stamp to be used in the report
	 */
	public static void onSuccess(String strStepName, String strStepDes, String strTimeStamp) {
		File file = new File(Base.filePath() + "//" + "Results_" + Base.timeStampBeforeSutie + ".html");
		Writer writer = null;
		Base.iStepNo = Base.iStepNo + 1;
		try {
			String strValue = "";
			if (strStepName.length() > 50)
				strValue = strStepName.substring(0, 50);
			else
				strValue = strStepName;
			if (!map.get(packageName + ":" + tc_name).equals("FAIL")) {
				map.put(packageName + ":" + tc_name, "PASS");
			}
			writer = new FileWriter(file, true);
			writer.write("<table id='main'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 5%' /> ");
			writer.write("<col style='width: 26%' /> ");
			writer.write("<col style='width: 51%' /> ");
			writer.write("<col style='width: 8%' /> ");
			writer.write("<col style='width: 10%' /> ");
			writer.write("</colgroup> ");
			writer.write("<tr class='content2' >");
			writer.write("<td>" + Base.iStepNo + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes + "</td> ");
			if (config.getProperty("sucessScreenShots").equalsIgnoreCase("true"))
				writer.write("<td class='Pass' align='center'><a  href="
						+ strValue.replace(" ", "_").replace(":", "_").replace("</br>", "_") + "_" + strTimeStamp
						+ ".png>" + "<img  src='file:///" + workingDir
						+ "//Logos//passed.ico' width='18' height='18'/></a></td> ");
			else
				writer.write("<td class='Pass' align='center'><img  src='file:///" + workingDir
						+ "//Logos//passed.ico' width='18' height='18'/></td> ");
			intPassNum = intPassNum + 1;
			Accessories.calculateStepExecutionTime();
			writer.write("<td>" + iStepExecutionTime + "</td> ");
			writer.write("</tr> ");
			writer.close();
			Accessories.calculateStepStartTime();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Used to update results.html on failure
	 * 
	 * @param strStepName:  Step name to update in the report
	 * @param strStepDes:   Steps description to update in the report
	 * @param strTimeStamp: time stamp to be used in the report
	 */
	public static void onFailure(String strStepName, String strStepDes, String strTimeStamp) {
		Writer writer = null;
		try {
			String strValue = "";
			if (strStepName.length() > 50)
				strValue = strStepName.substring(0, 50);
			else
				strValue = strStepName;
			File file = new File(Base.filePath() + "/" + "Results_" + Base.timeStampBeforeSutie + ".html");// "SummaryReport.html"
			Base.iStepNo = Base.iStepNo + 1;

			writer = new FileWriter(file, true);
			writer.write("<table id='main'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 5%' /> ");
			writer.write("<col style='width: 26%' /> ");
			writer.write("<col style='width: 51%' /> ");
			writer.write("<col style='width: 8%' /> ");
			writer.write("<col style='width: 10%' /> ");
			writer.write("</colgroup> ");
			writer.write("<tr class='content2' >");
			writer.write("<td>" + Base.iStepNo + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes + "</td> ");
			intFailNum = intFailNum + 1;
			System.out.println("intFailNum: " + intFailNum);

			writer.write("<td class='Fail' align='center'><a  href="
					+ strValue.replace(" ", "_").replace(":", "_").replace("</br>", "_") + "_" + strTimeStamp + ".png>"
					+ "<img  src='file:///" + workingDir + "//Logos//failed.ico' width='18' height='18'/></a></td>");
			Accessories.calculateStepExecutionTime();
			writer.write("<td>" + iStepExecutionTime + "</td> ");
			writer.write("</tr> ");
			writer.close();
			Accessories.calculateStepStartTime();
			map.put(packageName + ":" + tc_name, "FAIL");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Used to calculate testcase execution time
	 */
	public static void testCaseExecutionTime() {
		File file = new File(Base.filePath() + "/" + "Results_" + Base.timeStampBeforeSutie + ".html");
		Writer writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write("</table>");
			writer.write("<table id='footer'>");
			writer.write("<tfoot>");
			writer.write("<tr class='heading heading1'> ");
			writer.write("<th colspan='6'>Total steps execution time in seconds : " + executionTime.get(tc_name)
					+ "&nbsp;</th> ");
			writer.write("</tr> ");
			writer.close();
			intPassNum = 0;
			intFailNum = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Used to update the test summary in the summary report
	 * 
	 * @param: iSerialNo: used to update the serial number in the report
	 */
	public static void closeSummaryReport(int iSerialNo) {
		File file = new File(Base.filePath() + "/" + "SummaryResults_" + Base.timeStamp + ".html");
		Writer writer = null;
		try {
			writer = new FileWriter(file, true);

			writer.write("<table id='footer'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 20%' />");
			writer.write("<col style='width: 14%' />");
			writer.write("<col style='width: 20%' />");
			writer.write("<col style='width: 13%' />");
			writer.write("<col style='width: 20%' /> ");
			writer.write("<col style='width: 13%' /> ");
			writer.write("</colgroup> ");
			writer.write("<tfoot>");
			writer.write("<tr class='heading heading1'>");
			writer.write("<th colspan='6'>Total Duration  In Seconds (Including Report Creation) : "
					+ ((int) iSuiteExecutionTime) + "</th>");
			writer.write("</tr>");
			writer.write("<tr class='content' style='font-size:12px'>");
			writer.write("<td class='pass'>&nbsp;Total TestCases&nbsp;</td>");
			writer.write("<td class='pass'> " + (iSerialNo - 1) + "</td> ");
			writer.write("<td class='pass'>&nbsp;Tests Passed&nbsp;</td>");
			writer.write("<td class='pass'> " + pCount + "</td> ");
			writer.write("<td class='fail'>&nbsp;Tests Failed&nbsp;</td>");
			writer.write("<td class='fail'> " + fCount + "</td> ");
			writer.write("</tr>");
			writer.write("</tfoot>");
			writer.write("</table> ");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
