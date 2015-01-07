package com.testGenerate.utilities.Common;

import java.util.HashMap;
import java.util.logging.Logger;

public class TestAttribute {
	public static String testName;
	public static Integer numberOfTestCases;
	public static TestCase objTestCaseLine = new TestCase();  // declared here 
	public static HashMap<String, String> objtestAttr = new HashMap<String, String>();
	public static Logger mylogger = Logger.getLogger("MyLog");
}
