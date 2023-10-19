package com.qa.demoblaze.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.DemoBlaze_LandingPage;

public class DemoBlaze_Landing_Test extends DemoBlaze_TestBase {
	public DemoBlaze_Landing_Test() throws Exception {
		super();

	}

	@BeforeMethod
	public void setUpAndLaunchUrl() {
		driver = initializeBrowserAndLaunchApplication(prop.getProperty("browserName1"));

	}

	@Test(priority = 1)
	public void CurrentUrlAndActualTitle() {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		String actualCurrentUrl = prop.getProperty("actualCurrentUrl");
		String expectedCurrentUrl = driver.getCurrentUrl();

		String actualTitle = prop.getProperty("actualTitle");
		String expectedTitle = driver.getTitle();

		if (actualCurrentUrl.equals(expectedCurrentUrl) && actualTitle.equals(expectedTitle)) {
			System.out.println("DemoBlaze Landing Page is Valid and Functional");
		} else {
			System.out.println("DemoBlaze Landing Page is not Valid and Functional");
		}
	}

	@Test(priority = 2)
	public void PresenceOfProductStoreBanner() {
		DemoBlaze_LandingPage landingPage = new DemoBlaze_LandingPage(driver);
		WebElement ProductStoreBanner = landingPage.ProductStoreBanner();
		softassert.assertTrue(ProductStoreBanner.isDisplayed(), "ProductStoreBanner is not displayed");

		if (ProductStoreBanner.isDisplayed()) {
			System.out.println("DemoBlaze's Product Store Banner is displayed making the landing page valid");
		} else {
			System.out.println("DemoBlaze's Product Store Banner is not displayed making the landing page invalid");
			softassert.assertAll();

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
