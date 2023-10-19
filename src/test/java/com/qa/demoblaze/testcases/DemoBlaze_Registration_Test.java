package com.qa.demoblaze.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.DemoBlaze_RegistrationPage;
import com.qa.demoblaze.utilities.DemoBlaze_Utilities;

public class DemoBlaze_Registration_Test extends DemoBlaze_TestBase {

	public DemoBlaze_Registration_Test() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUpAndLaunchApplication() throws Exception {
		driver = initializeBrowserAndLaunchApplication(prop.getProperty("browserName1"));
		DemoBlaze_RegistrationPage registrationPage = new DemoBlaze_RegistrationPage(driver);
		registrationPage.clickOnSignUpLink();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void successfullRegistration() throws Exception {
		DemoBlaze_RegistrationPage registrationPage = new DemoBlaze_RegistrationPage(driver);
		registrationPage.enterUsername(DemoBlaze_Utilities.generateEmailWithDateAndTimeStamp());
		registrationPage.enterPassword(DemoBlaze_Utilities.generatePasswordWithDateAndTimeStamp());
		registrationPage.clickOnSignUpButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualSuccessfullRegistrationMessage = prop.getProperty("SuccessfullRegistrationMessage");
		String expectedSuccessfullRegistrationMessage = alert.getText();

		if (actualSuccessfullRegistrationMessage.equals(expectedSuccessfullRegistrationMessage)) {
			System.out.println("Registration Page is functional.");
			alert.accept();
		} else {
			alert.dismiss();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
