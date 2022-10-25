package com.bluecloud.RunnerClasses;

import org.testng.annotations.Test;

import com.bluecloud.pages.CartFlowPageRUQA;

public class QAapplication extends CartFlowPageRUQA{
	@Test
	public void textAndCheckBox() throws Throwable {
		//For browser launch
		launchBrowser();
		//For Enter full name
		fullName();
		//For Enter email
		Email();
		//For Enter current address
		currentAddress();
		//For Enter permanent address
		permentAddress();
		//For Scroll up to submit button 
		scrollUptoSubmit();
		// for Click on submit button 
		submitButton();
		//For Click on check box
		checkBox();
		//For select home check box
		homeCheckBox();
		//For click on radio buttons
		radioButton();
		//For click on yes button
		yesButton();
		//For click on impressive button
		impressiveButton();
		
	
		
	}

}
