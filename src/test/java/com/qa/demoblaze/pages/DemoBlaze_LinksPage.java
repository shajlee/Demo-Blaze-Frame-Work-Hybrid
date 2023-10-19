package com.qa.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlaze_LinksPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//a[text() ='Phones']")
	private WebElement phoneLink;
	
	@FindBy(xpath = "//a[text() = 'Samsung galaxy s6']")
	private WebElement samsunPhone;
	
	@FindBy(xpath = "//a[text() ='Laptops']")
	private WebElement laptopsLink;
	
	@FindBy(xpath = "//a[text() = 'Sony vaio i5']")
	private WebElement sonyLaptop;
	
	@FindBy(xpath = "//a[text() ='Monitors']")
	private WebElement monitorsLink;
	
	@FindBy(xpath = "//a[text() = 'Apple monitor 24']")
	private WebElement appleMonitors;
	
	public DemoBlaze_LinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnPhonesLink() {
		phoneLink.click();
	}
	public WebElement SamsungPhone() {
		return samsunPhone;
	}
	public void clickOnLaptopsLink() {
		laptopsLink.click();
	}
	public WebElement SonyLaptop() {
		return sonyLaptop;
	}
	public void clickOnMonitorsLink() {
		monitorsLink.click();
	}
	public WebElement AppleMonitor() {
		return appleMonitors;
	}
	
	
	
	

}
