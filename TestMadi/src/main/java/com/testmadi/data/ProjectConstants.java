package com.testmadi.data;

import java.io.File;

public class ProjectConstants {
	public static final String appURL="http://store.demoqa.com/products-page/your-account/";
	public static final String testDataFilePath= System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "testdata"
			+ File.separator;
	public static final String GECKO_DRIVER_PATH=System.getProperty("user.dir") + File.separator + "drivers"
			+ File.separator + "geckodriver";
	
	/**
	 * Method is used to print a string value in the console
	 * @param value
	 */
	public static void print(String value){
		System.out.println(value);
	}
}
