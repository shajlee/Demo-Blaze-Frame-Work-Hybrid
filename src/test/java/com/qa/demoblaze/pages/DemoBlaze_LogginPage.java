package com.qa.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlaze_LogginPage {
	public WebDriver driver;
	
	@FindBy(id = "login2")
	private WebElement loginLink;
	
	@FindBy(id = "loginusername")
	private WebElement userNameTextBox;
	
	@FindBy(id = "loginpassword")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement logInButton;
	
	@FindBy(css = "a#nameofuser")
	private WebElement nameOfAccountHolder;
	
	public DemoBlaze_LogginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void enterUserName(String usernameText) {
		userNameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(String passowrdText) {
		passwordTextBox.sendKeys(passowrdText);
	}
	public void clickOnLogInButton() {
		logInButton.click();
	}
	public WebElement AccountHolderName() {
		return nameOfAccountHolder;
	}
	
	

}
