package com.qa.demoblaze.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.DemoBlaze_LogginPage;
import com.qa.demoblaze.testdata.DemoBlaze_SupplyTestData;
import com.qa.demoblaze.utilities.DemoBlaze_Utilities;

public class DemoBlaze_LogIn_Test extends DemoBlaze_TestBase {

	public DemoBlaze_LogIn_Test() throws Exception {
		super();

	}

	@BeforeMethod
	public void setUpAndLaunchUrl() {
		driver = initializeBrowserAndLaunchApplication(prop.getProperty("browserName1"));
		DemoBlaze_LogginPage loginPage = new DemoBlaze_LogginPage(driver);
		loginPage.clickOnLoginLink();

	}

	@Test(priority = 1, dataProvider = "DemoBlazeCrendtialsExcelSheetWithDataProviderSupply", dataProviderClass = DemoBlaze_SupplyTestData.class)
	public void loginWithValidCredentials(String username, String password) throws Exception {
		DemoBlaze_LogginPage loginPage = new DemoBlaze_LogginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		Thread.sleep(2000);
		loginPage.clickOnLogInButton();
		Thread.sleep(4000);
		
		WebElement nameOfAccountHolder = loginPage.AccountHolderName();
		softassert.assertTrue(nameOfAccountHolder.isDisplayed(), "nameOfAccountHolder is not displayed");
		softassert.assertAll();

		if (nameOfAccountHolder.isDisplayed()) {
			System.out.println("Login with valid valid credentials is working and functional");
		} else {
			System.out.println("Login with valid valid credentials is not working and functional");

		}
	}

	@Test(priority = 2)
	public void loginWithInvalidCredentials() throws Exception {
		DemoBlaze_LogginPage loginPage = new DemoBlaze_LogginPage(driver);
		loginPage.enterUserName(DemoBlaze_Utilities.generateEmailWithDateAndTimeStamp());
		loginPage.enterPassword(DemoBlaze_Utilities.generatePasswordWithDateAndTimeStamp());
		loginPage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualInvalidCredentialsMessage = prop.getProperty("actualInvalidCredentialsMessage");
		String expectedInvalidCredentialsMessage = alert.getText();

		softassert.assertTrue(actualInvalidCredentialsMessage.equals(expectedInvalidCredentialsMessage));
		if (actualInvalidCredentialsMessage.equals(expectedInvalidCredentialsMessage)) {
			System.out.println("Login with invalid credentials is beaving as expected");
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void loginWithInvalidUsernameAndValidPasswoord() throws Exception {
		DemoBlaze_LogginPage loginPage = new DemoBlaze_LogginPage(driver);
		loginPage.enterUserName(DemoBlaze_Utilities.generateEmailWithDateAndTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualInvalidCredentialsMessage = prop.getProperty("actualInvalidCredentialsMessage");
		String expectedInvalidCredentialsMessage = alert.getText();

		softassert.assertTrue(actualInvalidCredentialsMessage.equals(expectedInvalidCredentialsMessage));
		if (actualInvalidCredentialsMessage.equals(expectedInvalidCredentialsMessage)) {
			System.out.println("Login with invalid username and valid password is beaving as expected");
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void loginWithValidUsernameInvalidPassword() throws Exception {
		DemoBlaze_LogginPage loginPage = new DemoBlaze_LogginPage(driver);
		loginPage.enterUserName(prop.getProperty("validUsername"));
		loginPage.enterPassword(DemoBlaze_Utilities.generatePasswordWithDateAndTimeStamp());
		loginPage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualInvalidPasswordMessage = prop.getProperty("actualInvalidPasswordMessage");
		String expectedInvalidPasswordMessage = alert.getText();

		softassert.assertTrue(actualInvalidPasswordMessage.equals(expectedInvalidPasswordMessage));
		if (actualInvalidPasswordMessage.equals(expectedInvalidPasswordMessage)) {
			System.out.println("Login with valid username and invalid password is beaving as expected");
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void loginWithNoCredentials() throws Exception {
		DemoBlaze_LogginPage loginPage = new DemoBlaze_LogginPage(driver);
		loginPage.clickOnLogInButton();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualNoCrendtialsMessage = prop.getProperty("actualNoCredentialsMessage");
		String expectedNoCredentialsMessage = alert.getText();

		softassert.assertTrue(actualNoCrendtialsMessage.equals(expectedNoCredentialsMessage));
		if (actualNoCrendtialsMessage.equals(expectedNoCredentialsMessage)) {
			System.out.println("Login with no credentials is behaving as expected");
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
