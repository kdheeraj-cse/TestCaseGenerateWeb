package utilities;

import java.util.HashMap;
import java.util.logging.Logger;

public class TestAttribute {
	public static String testName;
	public static String testStepsXmlInputPath = "FileFolder/TestCase.xml";
	public static String testParameterExcelInputPath = "FileFolder/Data.xls";
	public static String outputExcelPath = "FileFolder/Output.xls";
	public static Integer numberOfTestCases;
	public static TestCase objTestCaseLine = new TestCase();  // declared here 
	public static HashMap<String, String> objtestAttr = new HashMap<String, String>();
	public static Logger mylogger = Logger.getLogger("MyLog");
	public static String logPath = "FileFolder/Logs/log";
	public final static String inputJSONFile = "FileFolder/TestCase.json";

}
