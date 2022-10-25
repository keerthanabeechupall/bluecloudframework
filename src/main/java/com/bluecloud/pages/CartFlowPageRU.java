package com.bluecloud.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bluecloud.frameworkRU.Actiondriver;
	public class CartFlowPageRU extends Actiondriver {
		public String username="8688843032";
		public String password="keerthi@456";
	  		
	// for launch URL

	public void launchflipkart() throws Throwable {
		try {
			String URL="https://www.flipkart.com";

			gf_launchUrl(URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// for user name

	public void enterUserName() throws Throwable {
		try {
		
			By userName = By.xpath("//span[text()='Enter Email/Mobile number']/../..//input");
			gf_Type(userName, username, "flipkart User Name");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//for password

	public void enterPassword() throws Throwable {
		try {
			By PassWord = By.xpath("//span[text()='Enter Password']/../..//input");
			
			gf_Type(PassWord, password, " flipkart password");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// for login button
	public void loginButton() throws Throwable {
		try {
		   By loginButton = By.xpath("//span[text()='Login']/../..//button");
			gf_Click(loginButton, "LoginButton");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// Mouse over on Electronics

	public void mouseOverOnElectronics() throws Throwable {
		try {

			By ElectronicsLocator = By.xpath("//*[text()='Electronics']");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(ElectronicsLocator)).click();
			gf_MouseHover(ElectronicsLocator, "Mouseover on Electronics");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// Mouse over on Gaming

	public void mouseOverOnGaming() throws Throwable {
		try {
			
			By GamingLocator = By.xpath("//*[text()='Gaming']");
			wait.until(ExpectedConditions.elementToBeClickable(GamingLocator)).click();
			gf_MouseHover(GamingLocator, "Mouse over on gaming ");
		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}

	// Click on Gaming Mouse
	public void clickOnGamingMouse() throws Throwable {
		try {
			By GamingMouseLocator = By.xpath("//a[text()='Gaming Mouse']");
			wait.until(ExpectedConditions.elementToBeClickable(GamingMouseLocator)).click();
			gf_Click(GamingMouseLocator, "Click on gaming mouse");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// For scrolling up to mouse
	public void scrollingUptoMouse() throws Throwable {
		try {
			By scrollMouseLocator = By.xpath("(//*[text()='Mouse'])[3]");
			wait.until(ExpectedConditions.elementToBeClickable(scrollMouseLocator)).click();
			gf_JSScrollToElement(scrollMouseLocator);
		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}
	// For item1

	public void item1() throws Throwable {
		try {
			By Item1Locator = By.xpath("(//div[@class='_13oc-S']/div)[3]");
			wait.until(ExpectedConditions.elementToBeClickable(Item1Locator)).click();
			gf_Click(Item1Locator, " For Item1");
			gf_Text(Item1Locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// for window switch
	public void childWindow1() throws Throwable {
		try {
			Set<String> win1=driver.getWindowHandles();
			 System.out.println(win1);
			 for(String string:win1)
			 {
				 driver.switchTo().window(string);
			 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// item1 Add to cart
	public void item1Cart() throws Throwable {
		try {
			
			By item1CartLocator = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
			wait.until(ExpectedConditions.elementToBeClickable(item1CartLocator)).click();
			gf_Click(item1CartLocator, "item1 is added to cart");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// For driver back navigation
	public void driverBack1() throws Throwable{
		try {
			driver.navigate().back();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// switch to main window
	public void mainWindow1() {
		try {
	        String mainWindow1= driver.getWindowHandle();
	        System.out.println(mainWindow1);
	        driver.switchTo().window(mainWindow1);
	        System.out.println("back to main window");
	        Thread.sleep(3000);
	        

		}
		catch(Exception e)
		{
			e.printStackTrace();
	
		}
	}
	
	

	// for scrolling up to similar products
	public void scrollUptoSimilarProducts() throws Throwable {

		try {
			gf_JSScrollDown(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// For item2
	public void item2() throws Throwable {
		try {
			By Item2Locator = By.xpath("(//div[@class='_3YgSsQ _2Xkgrw']/div)[1]");
			wait.until(ExpectedConditions.elementToBeClickable(Item2Locator)).click();
			gf_Click(Item2Locator, " For Item2");
			gf_Text(Item2Locator);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// for window switch
	public void childWindow2() {
		try {
			 Set<String> win2=driver.getWindowHandles();
			 System.out.println(win2);
			 for(String string:win2)
			 {
				 driver.switchTo().window(string);
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
			
		}


	//// item2 Add to cart
	public void item2Cart() throws Throwable {
		try {
			By item2CartLocator = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
			wait.until(ExpectedConditions.elementToBeClickable(item2CartLocator)).click();
			gf_Click(item2CartLocator, "item2 is added to cart");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// for driver back navigation
	public void driverBack2() throws Throwable{
		try {
			driver.navigate().back();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// switch to main window
	public void mainWindow2() {
		try {
	        String mainWindow1= driver.getWindowHandle();
	        System.out.println(mainWindow1);
	        driver.switchTo().window(mainWindow1);
	        System.out.println("back to main window");
	        Thread.sleep(3000);
	        

		}
		catch(Exception e)
		{
			e.printStackTrace();
	
		}
	}

	

	// for scrolling up to similar products

	public void scrollUptoSimilarProducts1() throws Throwable {

		try {
			gf_JSScrollDown(6000);
		}

		catch (Exception e)

		{
			e.printStackTrace();
		}

	}

	// For item3
	public void item3() throws Throwable {
		try {
			By Item3Locator = By.xpath("(//div[@class='_3YgSsQ _2Xkgrw']/div)[3]");
			gf_Click(Item3Locator, " For Item3");
			gf_Text(Item3Locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// for window switch
	

	// item3 Add to cart
	public void item3Cart() throws Throwable {
		try {
			By item3CartLocator = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
			wait.until(ExpectedConditions.elementToBeClickable(item3CartLocator)).click();
			gf_Click(item3CartLocator, "item3 is added to cart");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// for driver back navigation
	public void driverBack3() throws Throwable{
		try {
			driver.navigate().back();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	// switch to main window
	public void mainWindow3() {
		try {
	        String mainWindow1= driver.getWindowHandle();
	        System.out.println(mainWindow1);
	        driver.switchTo().window(mainWindow1);
	        System.out.println("back to main window");
	        Thread.sleep(3000);
	        

		}
		catch(Exception e)
		{
			e.printStackTrace();
	
		}
	}

	

	// for scrolling up to similar products

	public void scrollUptoSimilarProducts2() throws Throwable {

		try {
			gf_JSScrollDown(6000);
		}

		catch (Exception e)

		{
			e.printStackTrace();
		}
	}

	// For click on cart
	public void cart() throws Throwable {
		try {
			By cartLocator = By.xpath("//span[text()='Cart']");
			wait.until(ExpectedConditions.elementToBeClickable(cartLocator)).click();
			gf_Click(cartLocator, " click on cart");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// for to get a item1 text in add to cart
	public void item1TextInCart() throws Throwable {
		try {
			By item1CarttextLocator = By.xpath("(//*[@class='_2Kn22P gBNbID'])[1]");
			wait.until(ExpectedConditions.elementToBeClickable(item1CarttextLocator)).click();
			gf_Text(item1CarttextLocator);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// for to get a item2 text in add to cart
	public void item2TextInCart() throws Throwable {
		try {
			By item2CarttextLocator = By.xpath("(//*[@class='_2Kn22P gBNbID'])[2]");
			wait.until(ExpectedConditions.elementToBeClickable(item2CarttextLocator)).click();
			gf_Text(item2CarttextLocator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// for to get a item3 text in add to cart
	public void item3TextInCart() throws Throwable {
		try {
			By item3CarttextLocator = By.xpath("(//*[@class='_2Kn22P gBNbID'])[3]");
			wait.until(ExpectedConditions.elementToBeClickable(item3CarttextLocator)).click();
			gf_Text(item3CarttextLocator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void placeorder() throws Throwable {
		try {
			By placeorderLocator = By.xpath("");
			wait.until(ExpectedConditions.elementToBeClickable(placeorderLocator)).click();
			gf_Click(placeorderLocator, "item1 is added to cart");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// for scrolling up to similar products
	public void scrollUptoSimilarProducts3() throws Throwable {

		try {
			gf_JSScrollDown(300);
		}

		catch (Exception e)

		{
			e.printStackTrace();
		}
	}

	// Remove item1 from cart
	public void removeItem1FromCart() throws Throwable {
		try {
			String Item1RemoveFromcart = TestData("flipkart", "Item1removexpath");
			By Item1RemoveFromcartLocator = By.xpath(Item1RemoveFromcart);
			wait.until(ExpectedConditions.elementToBeClickable(Item1RemoveFromcartLocator)).click();
			gf_Click(Item1RemoveFromcartLocator, "item1 is removed from cart");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Remove item2 from cart
	public void removeItem2FromCart() throws Throwable {
		try {
			String Item2RemoveFromcart = TestData("flipkart", "Item2removexpath");
			By Item2RemoveFromcartLocator = By.xpath(Item2RemoveFromcart);
			wait.until(ExpectedConditions.elementToBeClickable(Item2RemoveFromcartLocator)).click();
			gf_Click(Item2RemoveFromcartLocator, "item2 is removed from cart");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Remove item3 from cart
	public void removeItem3FromCart() throws Throwable {
		try {
			By Item3RemoveFromcartLocator = By.xpath("//span[text()='Place Order']");
			wait.until(ExpectedConditions.elementToBeClickable(Item3RemoveFromcartLocator)).click();
			gf_Click(Item3RemoveFromcartLocator, "item3 is removed from cart");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void closeAllWindows()
	{
		driver.quit();
	}
 


}
