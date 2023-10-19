package com.qa.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlaze_LandingPage {
	public WebDriver driver;
	
	@FindBy(id = "nava")
	private WebElement productStoreBanner;
	
	public DemoBlaze_LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement ProductStoreBanner() {
		return productStoreBanner;
	}
	public boolean ProductStoreBannerIsDisplayed() {
		boolean displayStatus = productStoreBanner.isDisplayed();
		return displayStatus;
	}
	
	

}
