package com.qa.demoblaze.utilities;

import java.util.Date;

public class DemoBlaze_Utilities {

	public static String generateEmailWithDateAndTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace("", "_").replace(":", "_");
		return "chowdhurygs" + emailTimeStamp + "@gmail.com";
	}

	public static String generatePasswordWithDateAndTimeStamp() {
		Date date1 = new Date();
		CharSequence passwordTimeStamp = date1.toString().replace("", "_").replace(":", "_");
		return "Shajlee" + passwordTimeStamp;
	}

	public static final int implicit_wait_time = 10;
	public static final int pageload_wait_time = 10;
	public static final int scriptload_wait_time = 10;

}
