package com.bluecloud.RunnerClasses;

import org.testng.annotations.Test;

import com.bluecloud.pages.CartFlowPageRU;



public class Flipkart extends CartFlowPageRU {

	@Test
	public void cartFlow() throws Throwable {
		
		launchflipkart();
        enterUserName();
	    enterPassword();
	    loginButton();
	    mouseOverOnElectronics();
	    mouseOverOnGaming();
	    clickOnGamingMouse();
	    scrollingUptoMouse();
	    item1();
	    childWindow1();
	    item1Cart();
	    driverBack1();
	    mainWindow1();
	    scrollUptoSimilarProducts();
	    item2();
	    childWindow2();
	    item2Cart();
	    driverBack2();
	    mainWindow2();
	    scrollUptoSimilarProducts1();
	    item3();
	    item3Cart();
	    driverBack3();
	    mainWindow3();
	    scrollUptoSimilarProducts2();
	    cart();
	    item1TextInCart();
	    item2TextInCart();
	    item3TextInCart();
	    placeorder();
	    removeItem1FromCart();
	    removeItem2FromCart();
	    removeItem3FromCart();
	    closeAllWindows();

	   
	}
}
