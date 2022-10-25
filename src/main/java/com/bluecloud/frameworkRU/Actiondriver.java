package com.bluecloud.frameworkRU;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * All customised/ Generic functions
 * 
 * @author Blue.Cloud Technologies
 */
public class Actiondriver extends Base {
	
	// Synchronisation data
	public static long lWait_Medium = Long.valueOf(configProps.getProperty("Wait_Medium").toString());
	//public static JavascriptExecutor js = (JavascriptExecutor) driver;
	public static Duration explicitwait1m = Duration.ofSeconds(60);
	public static Duration explicitwait2Sec = Duration.ofSeconds(2);
	public static String testDataFile = System.getProperty("user.dir") + "/fast.xlsx";
	public static String testData = "";

	/**
	 * Performs click on the element
	 * 
	 * @param objLocator:     Location of the element to receive click
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_Click(By objLocator, String strLocatorName) throws Throwable {
		try {
			WebElement element = driver.findElement(objLocator);
			element.click();
			Thread.sleep(lWait_Medium);
			Reporters.successReport("Click on " + strLocatorName, "Successfully clicked on " + strLocatorName);
		} catch (Exception e) {
			Reporters.failureReport("Click on " + strLocatorName, "Failed to click on " + strLocatorName);
			e.printStackTrace();
		}
	}

	/**
	 * Performs click on the element but doesn't update the report
	 * 
	 * @param objLocator: Location of the element to receive click
	 * @throws Throwable the throwable
	 */
	public static void gf_ClickNoReport(By objLocator) throws Throwable {
		try {
			WebElement element = driver.findElement(objLocator);
			element.click();
			Thread.sleep(lWait_Medium);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Enters data in the element
	 * 
	 * @param objLocator:     Location of the element to enter text
	 * @param strTestdata:    Data to enter in the field
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_Type(By objLocator, String strTestdata, String strLocatorName) throws Throwable {
		try {
			WebElement element = driver.findElement(objLocator);
			element.clear();
			element.sendKeys(strTestdata);
			Thread.sleep(lWait_Medium);
			Reporters.successReport("Enter data in " + strLocatorName,
					"Data entered successfully in " + strLocatorName + ".");
		} catch (Exception e) {
			Reporters.failureReport("Enter data in " + strLocatorName,
					"Failed to enter data in" + strLocatorName + ".");
			e.printStackTrace();
		}
	}

	/**
	 * Enters data in the element but doesn't update the report
	 * 
	 * @param objLocator:  Location of the element to enter text
	 * @param strTestdata: Data to enter in the field
	 * @throws Throwable the throwable
	 */
	public static void gf_TypeNoReport(By objLocator, String strTestdata) throws Throwable {
		try {
			WebElement element = driver.findElement(objLocator);
			element.clear();
			element.sendKeys(strTestdata);
			Thread.sleep(lWait_Medium);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Enters data in the element without clearing the text in the element
	 * 
	 * @param objLocator:     Location of the element to enter text
	 * @param strTestdata:    Data to enter in the field
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_TypeWithoutClear(By objLocator, String strTestdata, String strLocatorName) throws Throwable {
		try {
			WebElement element = driver.findElement(objLocator);
			element.sendKeys(strTestdata);
			Thread.sleep(lWait_Medium);
			Reporters.successReport("Enter data in " + strLocatorName,
					"Data '" + strTestdata + "' entered successfully.");
		} catch (Exception e) {
			Reporters.failureReport("Enter data in " + strLocatorName, "Failed to enter data.");
			e.printStackTrace();
		}
	}

	/**
	 * Enters data in the element and verifies the text entered
	 * 
	 * @param objLocator:     Location of the element to enter text
	 * @param strTestdata:    Data to enter in the field
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_TypeAndVerify(By objLocator, String strTestdata, String strLocatorName) throws Throwable {
		try {
			WebElement element = driver.findElement(objLocator);
			element.clear();
			element.sendKeys(strTestdata);
			Thread.sleep(lWait_Medium);
			if (strTestdata.trim().equalsIgnoreCase(driver.findElement(objLocator).getAttribute("value").trim()))
				Reporters.successReport("Enter data in " + strLocatorName,
						"Data '" + strTestdata + "' entered successfully.");
		} catch (Exception e) {
			Reporters.failureReport("Enter data in " + strLocatorName, "Failed to enter data.");
			e.printStackTrace();
		}
	}

	/**
	 * Hovers the element
	 * 
	 * @param objLocator:     Location of the element to hover
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_MouseHover(By objLocator, String strLocatorName) throws Throwable {
		try {
			WebElement element = driver.findElement(objLocator);

//			List<WebElement> elements = driver.findElements(By.id(""));

//			if (elements.size() > 0) {
//				elements.get(0).sendKeys("");
//			}

			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Reporters.successReport("Mouse hover on " + strLocatorName,
					"Successfully mouse hovered on " + strLocatorName + ".");
		} catch (Exception e) {
			Reporters.failureReport("Mouse hover on " + strLocatorName,
					"Failed to mouse hover on " + strLocatorName + ".");
			e.printStackTrace();
		}
	}

	/**
	 * Drags the source element to the tar element
	 * 
	 * @param objSource:      Location of the source element to drag
	 * @param objTar:         Location of the tar element to drop
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_DragAndDrop(By objSource, By objTar, String strLocatorName) throws Throwable {
		try {
			WebElement from_element = driver.findElement(objSource);
			WebElement to_element = driver.findElement(objTar);
			Actions actions = new Actions(driver);
			actions.dragAndDrop(from_element, to_element).build().perform();
			Reporters.successReport("Element drag and drop " + strLocatorName,
					"Successfully dragged and dropped the element.");
		} catch (Exception e) {
			Reporters.failureReport("Element drag and drop " + strLocatorName, "Failed to drag the element.");
			e.printStackTrace();
		}
	}

	/**
	 * Slides the element to the provided X and Y co-ordinates
	 * 
	 * @param objSlider:      Location of the element to slide
	 * @param xCoordinate:    X co-ordinate of the element to slide
	 * @param yCoordinate:    Y co-ordinate of the element to slide
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_Slider(By objSlider, int xCoordinate, int yCoordinate, String strLocatorName)
			throws Throwable {
		try {
			WebElement dragitem = driver.findElement(objSlider);
			Actions actions = new Actions(driver);
			actions.dragAndDropBy(dragitem, xCoordinate, yCoordinate).build().perform();
			Thread.sleep(lWait_Medium);
			Reporters.successReport("Element sliding " + strLocatorName, "Successfully element slided");
		} catch (Exception e) {
			Reporters.failureReport("Element sliding " + strLocatorName, "Failed to slide element.");
			e.printStackTrace();
		}
	}

	/**
	 * Right clicks the element
	 * 
	 * @param objLocator:     Location of the element to right click
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_RightClick(By objLocator, String strLocatorName) throws Throwable {
		try {
			WebElement elementToRightClick = driver.findElement(objLocator);
			Actions actions = new Actions(driver);
			actions.contextClick(elementToRightClick).build().perform();
			Reporters.successReport("Right click" + strLocatorName, "Successfully right clicked the element.");
		} catch (Exception e) {
			Reporters.failureReport("Right click" + strLocatorName, "Failed to right click the element.");
			e.printStackTrace();
		}
	}

	/**
	 * Verified whether the actual text contains the expected text
	 * 
	 * @param strActualText:   Actual text to verify
	 * @param strExpectedText: Expected text to verify
	 * @throws Throwable the throwable
	 * @return true, if successful
	 */
	public static boolean gf_IsContainsText(String strActualText, String strExpectedText) throws Throwable {
		boolean flag = false;
		try {
			if (strActualText.trim().contains(strExpectedText.trim())) {
				flag = true;
				Reporters.successReport(ReadResourceData.getResourceData("CS_005", "Desc", ""),
						ReadResourceData.getResourceData("CS_005", "Pass", strExpectedText));
			}
		} catch (Exception e) {
			Reporters.failureReport(ReadResourceData.getResourceData("CS_005", "Desc", ""),
					ReadResourceData.getResourceData("CS_005", "Fail", strExpectedText));
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Selects the element from the drop down based on the index provided
	 * 
	 * @param objLocator:     Location of the drop down to to select
	 * @param intIndex:       Index of the element to to select
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_SelectByIndex(By objLocator, int intIndex, String strLocatorName) throws Throwable {
		try {
			Select dd = new Select(driver.findElement(objLocator));
			dd.selectByIndex(intIndex);
			Reporters.successReport("Select value from " + strLocatorName + " drop down",
					"Successfully selected value from the " + strLocatorName + " drop down");
		} catch (Exception e) {
			Reporters.failureReport("Select value from " + strLocatorName + " drop down",
					"Failed to select value from the dropdown.");
			e.printStackTrace();
		}
	}

	/**
	 * Select the element from the drop down based on the value provided
	 * 
	 * @param objLocator:     Location of the drop down to to select
	 * @param strValue:       Value of the element to to select
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_SelectByValue(By objLocator, String strValue, String strLocatorName) throws Throwable {
		try {
			Select dd = new Select(driver.findElement(objLocator));
			dd.selectByValue(strValue);
			Reporters.successReport("Select value from " + strLocatorName + " drop down",
					"Successfully selected " + strValue + " from the " + strLocatorName + " drop down");
		} catch (Exception e) {
			Reporters.failureReport("Select value from drop down " + strLocatorName,
					"Failed to selectvalue from the dropdown.");
			e.printStackTrace();
		}
	}

	/**
	 * Selects all the options from the drop down that matches with the visible text
	 * 
	 * @param objLocator:     Location of the drop down to to select
	 * @param strValue:       Value of the element to to select
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_SelectByVisibleText(By objLocator, String strVisibletext, String strLocatorName)
			throws Throwable {
		try {
			Select dd = new Select(driver.findElement(objLocator));
			dd.selectByVisibleText(strVisibletext);
			Reporters.successReport("Select value from " + strLocatorName + " drop down",
					"Successfully selected " + strVisibletext + " from the " + strLocatorName + " drop down");
		} catch (Exception e) {
			Reporters.failureReport("Select value from drop down " + strLocatorName,
					"Failed to selectvalue from the dropdown.");
			e.printStackTrace();
		}
	}

	/**
	 * Verifies whether the element is enabled or not
	 * 
	 * @param objLocator:     Location of the element to verify
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 * @return true, if enabled
	 */
	public static boolean gf_IsEnabled(By objLocator, String strLocatorName) throws Throwable {
		boolean flag = false;
		try {
			if (driver.findElement(objLocator).isEnabled())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Verifies whether the element is displayed or not
	 * 
	 * @param objLocator:     Location of the element to verify
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 * @return true, if displayed
	 */
	public static boolean gf_IsDisplayed(By objLocator, String strLocatorName) throws Throwable {
		boolean flag = false;
		try {
			if (driver.findElement(objLocator).isDisplayed())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Verifies whether the element is selected or not
	 * 
	 * @param objLocator:     Location of the element to verify
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 * @return true, if selected
	 */
	public static boolean gf_IsSelected(By objLocator, String strLocatorName) throws Throwable {
		boolean flag = false;
		try {
			if (driver.findElement(objLocator).isSelected())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * s the text for the specified element
	 * 
	 * @param objLocator: Location of the element to the text
	 * @throws Throwable the throwable
	 * @return text of the element
	 */
	public static String gf_Text(By objLocator) throws Throwable {
		String text = "";
		try {
			WebElement element = driver.findElement(objLocator);
			if (element.isDisplayed())
				text = element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * Verifies the text present or not
	 * 
	 * @param objLocator: Location of the element to verify
	 * @throws Throwable the throwable
	 */
	public static void gf_VerifyText(By objLocator, String expectedText) throws Throwable {
		try {
			String actualText = gf_Text(objLocator).trim();
			if (actualText.equals(expectedText.trim()))
				Reporters.successReport("Verify " + expectedText + " text present or not",
						"Successfully verified the " + expectedText);
		} catch (Exception e) {
			Reporters.failureReport("Verify " + expectedText + " text present or not",
					"Verification of " + expectedText + " failed.");
			e.printStackTrace();
		}
	}

	/**
	 * Verifies the current window title
	 * 
	 * @param expectedTitle: Expected title to verify
	 * @throws Throwable the throwable
	 */
	public static void gf_VerifyTitle(String expectedTitle) throws Throwable {
		try {
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle))
				Reporters.successReport("Verify browser title",
						"Successfully verified the title with " + expectedTitle);
			else {
				Reporters.failureReport("Verify browser title", "Verification of title failed.");
				Assert.fail("Verificationn of title failed");
			}
		} catch (Exception e) {
			Reporters.failureReport("Verify browser title", "Verification of " + expectedTitle + " failed.");
			e.printStackTrace();
		}
	}

	/**
	 * Verifies 404 error
	 * 
	 * @throws Throwable the throwable
	 */
	public static void gf_Verify404() throws Throwable {
		if (driver.getPageSource().contains("404")) {
			Reporters.failureReport("Verification of 404 error", "404 error present in the page");
			Assert.fail("404 error present in the page");
		} else
			Reporters.successReport("Verification of 404 error", "404 error is not present in the page");
	}

	/**
	 * Returns the list of web elements
	 * 
	 * @param locator: used to locate the element
	 * @throws Throwable the throwable
	 */

	public static List<WebElement> gf_Elements(By locator) throws Throwable {
		List<WebElement> list = null;
		try {
			list = driver.findElements(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Takes the screenshot
	 * 
	 * @param fileName: Stores the screenshot with this name
	 * @throws Throwable the throwable
	 */
	public static void gf_ScreenShot(String fileName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hovers to the specified element using Java Script
	 * 
	 * @param objLocator:     used to locate the element to hover
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_MouseHoverByJavaScript(By objLocator, String strLocatorName) throws Throwable {
		try {
			WebElement mo = driver.findElement(objLocator);
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			//js.executeScript(javaScript, mo);
			Reporters.successReport("Mouse hover on " + strLocatorName, "Successfully hovered to element ");
		} catch (Exception e) {
			Reporters.failureReport("Mouse over on " + strLocatorName, "Mouse hover failed.");
			e.printStackTrace();
		}
	}

	/**
	 * Clicks the specified element using Java Script
	 * 
	 * @param objLocator:     used to locate the element to hover
	 * @param strLocatorName: Locator name to update in the report
	 * @throws Throwable the throwable
	 */
	public static void gf_JsClick(By objLocator, String strLocatorName) throws Throwable {

		try {
			//js.executeScript("arguments[0].click();", driver.findElement(objLocator));
			Reporters.successReport("Click on " + strLocatorName, "Successfully clicked on " + strLocatorName);
		} catch (Exception e) {
			Reporters.failureReport("Click on " + strLocatorName, "Failed to click on " + strLocatorName);
			e.printStackTrace();
		}
	}

	/**
	 * Switches to the frame based on the index provided
	 * 
	 * @param intIndex:       used to locate the index of the frame
	 * @param strLocatorName: Locator name to update in the report
	 */
	public static void gf_SwitchToFrameByIndex(int intIndex) {
		try {
			driver.switchTo().frame(intIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switches to the frame based on the name provided
	 * 
	 * @param frameName:      used to locate the name of the frame
	 * @param strLocatorName: Locator name to update in the report
	 */
	public static void gf_SwitchToFrameByName(String frameName) {

		try {
			driver.switchTo().frame(frameName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits for the specific time
	 * 
	 * @param waitTime: used to specify the wait time in milliseconds
	 */
	public static void wait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits/polls for the specified element till it is visible
	 * 
	 * @param objLocator: used to locate the element to wait for
	 */
	public static void gf_WaitForElementVisible(By objLocator) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(explicitwait1m).pollingEvery(explicitwait2Sec).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(objLocator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits/polls for the specified element till it is invisible
	 * 
	 * @param objLocator: used to locate the element to wait for
	 */
	public static void gf_WaitForInVisibilityOfElement(By objLocator) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(explicitwait1m).pollingEvery(explicitwait2Sec).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.invisibilityOfElementLocated(objLocator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits/polls for the specified element till it is clickable
	 * 
	 * @param objLocator: used to locate the element to wait for
	 */
	public void gf_WaitForElementToBeClickable(By objLocator) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(explicitwait1m).pollingEvery(explicitwait2Sec).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(objLocator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits/polls for the specified element till it is clickable and clicks it
	 * 
	 * @param objLocator: used to locate the element to wait/click for
	 */

	public static void waitForElementAndClick(By objLocator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(explicitwait1m).ignoring(NoSuchElementException.class).pollingEvery(explicitwait2Sec)
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(objLocator)).click();
	}

	/**
	 * Scrolls down the page using Java Script
	 * 
	 * @param scrollDownPixel: Number of pixels to scroll down
	 */
	public void gf_JSScrollDown(int scrollDownPixel) {
		try {
			//js.executeScript("window.scrollBy(0," + scrollDownPixel + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scrolls to the visibility of the element using Java Script
	 * 
	 * @param objLocator: used to locate the element to scroll
	 */
	public void gf_JSScrollToElement(By objLocator) {
		try {
			//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(objLocator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scrolls to the visibility of the element using Java Script
	 * 
	 * @param objLocator: used to locate the element to scroll
	 */
	public void gf_JSScrollBottomOfThePage(By objLocator) {
		try {
			//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clicks on the particular list item
	 * 
	 * @param objLocator:        used to locate list
	 * @param particularElement: particular element to click
	 */
	public void gf_ClickOnParticularElementInList(By objLocator, String particularElement, String strLocatorName)
			throws Throwable {
		try {
			List<WebElement> listItems = driver.findElements(objLocator);
			int listItemsSize = listItems.size();
			if (listItemsSize > 0) {
				for (WebElement item : listItems) {
					if (item.getText().trim().equals(particularElement)) {
						item.click();
						Reporters.successReport("Click on " + strLocatorName,
								"Successfully clicked on " + strLocatorName);
						break;
					} else {
						Reporters.failureReport("Click on " + strLocatorName, "Did not find " + strLocatorName);
						Assert.fail("Did not find the specified element in the " + strLocatorName);
					}
				}
			} else {
				Reporters.failureReport("Click on " + strLocatorName, "No items present in " + strLocatorName);
				Assert.fail("No items present in the " + strLocatorName);
			}
		} catch (Exception e) {

			Reporters.failureReport("Click on " + strLocatorName, "Failed to click on " + strLocatorName);
			e.printStackTrace();
		}
	}

	/**
	 * Returns the current date with the specified format
	 * 
	 * @param strFormat: specific date format to the date
	 */
	public static String gf_CurrentDate(String strFormat) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(strFormat);
			Date dateObj = new Date();
			return dateFormat.format(dateObj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns the previous date with the specified number of previous days
	 * 
	 * @param strFormat:            specific date format to the date
	 * 
	 * @param numberOfPreviousDays: number of previous days
	 */
	public static String gf_PreviousDate(String strFormat, int numberOfPreviousDays) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(strFormat);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -numberOfPreviousDays);
			return dateFormat.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns the previous date with the specified number of next days
	 * 
	 * @param strFormat:        specific date format to the date
	 * 
	 * @param numberOfNextDays: number of next days
	 */
	public static String gf_NextDate(String strFormat, int numberOfNextDays) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(strFormat);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, numberOfNextDays);
			return dateFormat.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns the test data from the excel
	 * 
	 * @param sheetName:     specific sheet to search for the test data
	 * 
	 * @param testDataValue: test data value to compare with
	 */

	@SuppressWarnings("resource")
	public static String TestData(String sheetName, String testDataValue) {
		try {
			FileInputStream file = new FileInputStream(new File(testDataFile));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.toString().equals(testDataValue)) {
						testData = cellIterator.next().toString();
						break;
					}
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;

	}

	public static void gf_launchUrl(String strURL) throws Throwable {

		try {
			driver.get(strURL);
			driver.manage().window().maximize();
			Reporters.successReport("Launch Application URL", "Successfully launched URL : " + strURL);
		} catch (Exception e) {
			e.printStackTrace();
			Reporters.failureReport("Launch Application URL", "Failed to launch URL.");
		}
	}
}