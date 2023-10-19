package com.qa.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlaze_RegistrationPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//a[text() = 'Sign up']")
	private WebElement signUpLink;
	
	@FindBy(css = "input#sign-username")
	private WebElement usernameTextBox;
	
	@FindBy(css = "input#sign-password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[text() = 'Sign up']")
	private WebElement signUpButton;
	
	public DemoBlaze_RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignUpLink() {
		signUpLink.click();
	}
	public void enterUsername(String username) {
		usernameTextBox.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	public void clickOnSignUpButton() {
		signUpButton.click();
	}
	
	}
	


