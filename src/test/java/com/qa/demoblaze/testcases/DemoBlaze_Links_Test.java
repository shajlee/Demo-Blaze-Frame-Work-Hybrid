package com.qa.demoblaze.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.DemoBlaze_LinksPage;

public class DemoBlaze_Links_Test extends DemoBlaze_TestBase {

	public DemoBlaze_Links_Test() throws Exception {
		super();
	}
	@BeforeMethod
	public void setUpAndLaunchUrl() {
		driver = initializeBrowserAndLaunchApplication(prop.getProperty("browserName1"));
	}
	@Test(priority=1)
	public void linkTests() {
		DemoBlaze_LinksPage linksPage = new DemoBlaze_LinksPage(driver);
		linksPage.clickOnPhonesLink();
		WebElement SamsungPhone = linksPage.SamsungPhone();
		softassert.assertTrue(SamsungPhone.isDisplayed(), "SamsungPhone is not displayed");
		
		driver.navigate().back();
		
		linksPage.clickOnLaptopsLink();
		WebElement SonyLaptop = linksPage.SonyLaptop();
		softassert.assertTrue(SonyLaptop.isDisplayed(), "SonyLaptop is not displayed");
		
		driver.navigate().back();
		
		linksPage.clickOnMonitorsLink();
		WebElement AppleMonitor = linksPage.AppleMonitor();
		softassert.assertTrue(AppleMonitor.isDisplayed(), "AppleMonitor is not displayed");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	}

}
