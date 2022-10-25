package com.bluecloud.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bluecloud.frameworkRU.Actiondriver;

public class CartFlowPageRUQA extends Actiondriver {
	String fullName = "Keerthana Beechupally";
	String email = "keerthana123@gmail.com";
	String currentAddress = "sr nagar";
	String permanentAddress = "Karimnagar";

	// for browser launch
	public void launchBrowser() throws Throwable {
		try {
			String URL = "https://demoqa.com/text-box";
			gf_launchUrl(URL);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// for enter full name
	public void fullName() throws Throwable {
		try {

			By fullNameLocator = By.id("userName");//
			gf_Type(fullNameLocator, fullName, "Full name");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// for enter email address
	public void Email() throws Throwable {

		try {
			By emailLocator = By.id("userEmail");
			gf_Type(emailLocator, email, "User email");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// For enter current address
	
	public void currentAddress() throws Throwable {

		try {
			By currentAddressLocator = By.id("currentAddress");
			gf_Type(currentAddressLocator, currentAddress, "Current address");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// for enter permanent address
	public void permentAddress() throws Throwable {

		try {
			By PermanentAddressLocator = By.id("permanentAddress");
			gf_Type(PermanentAddressLocator, permanentAddress, "Permanent address");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// for scroll down
	public void scrollUptoSubmit() throws Throwable {

		try {
			gf_JSScrollDown(300);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

//Click on submit button
	public void submitButton() throws Throwable {
		try {
			By submitButton = By.id("submit");
			wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
			gf_Click(submitButton, "submit Button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click on check box tab
	public void checkBox() throws Throwable {
		try {
			By checkBox = By.xpath("//span[text()='Check Box']");
			wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
			gf_Click(checkBox, "Checkbox");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// for click on home check box
	public void homeCheckBox() throws Throwable {
		try {
			By homeCheckBox = By.xpath("//span[text()='Home']");
			wait.until(ExpectedConditions.elementToBeClickable(homeCheckBox)).click();
			gf_Click(homeCheckBox, " Click on Home Checkbox");
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

	// for click on radio button tab
	public void radioButton() throws Throwable {
		try {
			By radioButton = By.xpath("//span[text()='Radio Button']");
			wait.until(ExpectedConditions.elementToBeClickable(radioButton)).click();
			gf_Click(radioButton, "radio Button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
	// click on yes button
	public void yesButton() throws Throwable {
		try {
			By yesButton = By.xpath("//label[@for='yesRadio']");
			wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
			gf_Click(yesButton, "yesButton");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// For click on impressive button
	public void impressiveButton() throws Throwable {
		try {
			By impressiveButton = By.xpath("//label[@for='impressiveRadio']");
			wait.until(ExpectedConditions.elementToBeClickable(impressiveButton)).click();
			gf_Click(impressiveButton, "Impressive Button");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//For click on web table
	public void webTable() throws Throwable {
		try {
			By webTable = By.xpath("//span[text()='Web Tables']");
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.elementToBeClickable(webTable)).click();
			gf_Click(webTable, "WebTable");
		} catch (Exception e) {
			e.printStackTrace();
		}
      
	}

	

}
