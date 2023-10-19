package com.qa.demoblaze.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoBlaze_ExtentReport {
	public static ExtentReports generateExtentReport() throws Exception {
		ExtentReports extentreport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\\\ExtentReports\\\\extentReport.html");
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extentReportFile);
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("DemoBlaze Hybrid Framework Test Results");
		sparkreporter.config().setDocumentTitle("DemoBlaze Hybrid Framework Test Designs Done By Golam Shajlee Adeeb Chowdhury");
		sparkreporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkreporter);
		Properties configprop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\qa\\demoblaze\\configurations\\configurations.properties");
		configprop.load(ip);
		
		extentreport.setSystemInfo("Application URL", configprop.getProperty("url"));
		extentreport.setSystemInfo("Project Browser1", configprop.getProperty("browserName1"));
		extentreport.setSystemInfo("Project Browser2", configprop.getProperty("browserName2"));
		extentreport.setSystemInfo("Project Browser3", configprop.getProperty("browserName3"));
		extentreport.setSystemInfo("Operating System Name:", System.getProperty("os.name"));
		extentreport.setSystemInfo("Operating System Version:", System.getProperty("os.version"));
		extentreport.setSystemInfo("Operating Java Version:", System.getProperty("java.version"));
		extentreport.setSystemInfo("Operating Java Home:", System.getProperty("java.home"));
		extentreport.setSystemInfo("Operating Java Vendor::", System.getProperty("java.vendor"));
		extentreport.setSystemInfo("Operating User Name:", System.getProperty("user.name"));
		extentreport.setSystemInfo("Operating User Country:", System.getProperty("user.country"));
		extentreport.setSystemInfo("Operating User Language:", System.getProperty("user.language"));
		
		return extentreport;

}
}
