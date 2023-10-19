package com.qa.demoblaze.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.asserts.SoftAssert;

import com.qa.demoblaze.utilities.DemoBlaze_Utilities;

public class DemoBlaze_TestBase {
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static SoftAssert softassert = new SoftAssert();
	public static Properties prop;
	public static Properties dataProp;
	public static FileInputStream ip;
	public static FileInputStream ip1;

	public DemoBlaze_TestBase() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\demoblaze\\configurations\\configurations.properties");
		prop.load(ip);
		
		dataProp = new Properties();
		ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\demoblaze\\configurations\\testData.properties");
		dataProp.load(ip1);
		
		
	}

	public WebDriver initializeBrowserAndLaunchApplication(String browserName) {
		if (browserName.equalsIgnoreCase(prop.getProperty("browserName1"))) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			driver = new ChromeDriver(optionsC);
			optionsC.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase(prop.getProperty("browserName2"))) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			driver = new FirefoxDriver(optionsF);
			optionsF.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase(prop.getProperty("browserName3"))) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			driver = new EdgeDriver(optionsE);
			optionsE.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DemoBlaze_Utilities.implicit_wait_time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DemoBlaze_Utilities.pageload_wait_time));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(DemoBlaze_Utilities.scriptload_wait_time));
		driver.manage().deleteAllCookies();
		return driver;

	}

}
