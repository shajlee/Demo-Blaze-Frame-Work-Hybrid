package com.qa.demoblaze.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.DemoBlaze_LogOutPage;

public class DemoBlaze_LogOut_Test extends DemoBlaze_TestBase {

	public DemoBlaze_LogOut_Test() throws Exception {
		super();
	}
	@BeforeMethod
	public void setUpAndLaunchUrl() throws Exception {
		driver = initializeBrowserAndLaunchApplication(prop.getProperty("browserName1"));
		DemoBlaze_LogOutPage logOutPage = new DemoBlaze_LogOutPage(driver);
		logOutPage.clickOnLoginLink();
		logOutPage.enterUserName(prop.getProperty("validUsername"));
		logOutPage.enterPassword(prop.getProperty("validPassword"));
		logOutPage.clickOnLogInButton();
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void logOutAndBannerDisplay() throws Exception {
		DemoBlaze_LogOutPage logOutPage = new DemoBlaze_LogOutPage(driver);
		logOutPage.clickOnLogOutButton();
		Thread.sleep(2000);
		
		WebElement productStoreBanner = logOutPage.ProductStoreBanner();
		softassert.assertTrue(productStoreBanner.isDisplayed(), "productStoreBanner is not displayed");
		softassert.assertAll();
		
		if(productStoreBanner.isDisplayed()) {
			System.out.println("LogOut Link is functional");
		}else {
			System.out.println("LogOut Link is not functional");
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		}
		
		
		
		
		
	}
	


