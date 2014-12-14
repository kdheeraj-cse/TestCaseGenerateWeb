package operations;
import utilities.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.wink.json4j.JSONException;
import org.json.simple.parser.ParseException;


public class InputTestStepsProcess {
	Character delimitCharacter = '$';
	FileReader objFileReader = null;
	
	InputJsonRead objInputJsonRead = new InputJsonRead();
	public void openAndReadXmlFile() throws IOException, ParseException, JSONException {    
		TestAttribute.mylogger.info("Entered openAndReadXmlFile and delimiter charcter is "+delimitCharacter);
		String testLine = null;
		
			ArrayList<String> inputTestSteps = new ArrayList<String>();
			inputTestSteps = objInputJsonRead.processJSONToList();
			TestAttribute.mylogger.info("Done with JSON file read, and return value is "+ !inputTestSteps.isEmpty());
			for (int i = 0; i < inputTestSteps.size(); i++) {
				testLine = inputTestSteps.get(i);
				System.out.println("testline"+testLine);
				findPositionToChange(testLine.trim());
			}
	}


	
	//this function Test case class initialize once .. All the test steps are stored and delimiting character position also stored ,
	//this is one time operation as for each test cases the steps pattern will be same.3 
	
	
	void findPositionToChange(String inputTestLine) {
		TestAttribute.mylogger.info("In function findPositionToChange with input "+inputTestLine);
		if(inputTestLine.contains("$$"))
		{
			TestAttribute.mylogger.info("input string is not in good format So terminating the execution");
			System.exit(0);
		}
		ArrayList<Integer> arrayForQuotesPosition = new ArrayList<Integer>();
		// objTestCaseLine = new TestCaseLine();
		char[] testLine = inputTestLine.toCharArray();
		TestAttribute.objTestCaseLine.setObjTestSteps(inputTestLine);  //save the test line in Test class variable
		for (int i = 0; i < testLine.length; i++) {
			if (testLine[i] == delimitCharacter) {
				if (i % 2 == 0)
					arrayForQuotesPosition.add(i);
				else
					arrayForQuotesPosition.add(i);
			}

		}
		if (arrayForQuotesPosition.size() % 2 != 0) {
			TestAttribute.mylogger.info("input string is not in good format So terminating the execution");
			System.exit(0);
		} else {
			TestAttribute.objTestCaseLine.objArrayListoftestStep.add(arrayForQuotesPosition);
		}
	}
	

	
	
	public void SetHashMap(Integer testCaseNumber) {
		
		ArrayList<String> objectForTestSteps = TestAttribute.objTestCaseLine.getObjTestSteps();
		Integer numberOfSteps = objectForTestSteps.size();
		int indexForTestSteps = 0;
		while (indexForTestSteps < numberOfSteps)
		{
			
			if(objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("PATHSTART"))
			{	indexForTestSteps++;
				String formattedPath=null;
				while (!objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("PATHEND")) {
				formattedPath=formatTestCaseLine(testCaseNumber,objectForTestSteps.get(indexForTestSteps),indexForTestSteps);
					indexForTestSteps++;
				}
				TestAttribute.objtestAttr.put("Path", formattedPath);
				
			}
			if(objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("TESTCASENAMESTART"))
			{
				indexForTestSteps++;
				String formattedTestName = null;
				while (!objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("TESTCASENAMEEND")) {
					formattedTestName=formatTestCaseLine(testCaseNumber,objectForTestSteps.get(indexForTestSteps),indexForTestSteps);
					TestAttribute.objtestAttr.put("TestCaseName", formattedTestName);
					indexForTestSteps++;
				}
				TestAttribute.objtestAttr.put("Path",TestAttribute.objtestAttr.get("Path").toString()+"/"+formattedTestName);
				
			}
			if(objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("PREREQUISITESTART"))
			{
				indexForTestSteps++;
				StringBuilder preReqOneLine = new StringBuilder();
				while (!objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("PREREQUISITEEND")) {
					preReqOneLine.append(formatTestCaseLine(testCaseNumber, objectForTestSteps.get(indexForTestSteps), indexForTestSteps));
					indexForTestSteps++;
				}
				TestAttribute.objtestAttr.put("Prerequisite", preReqOneLine.toString());
			}
			
			if(objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("DESCRIPTIONSTART"))
			{
				indexForTestSteps++;
				StringBuilder descOneLine = new StringBuilder();
				while (!objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("DESCRIPTIONEND")) {
					descOneLine.append(formatTestCaseLine(testCaseNumber, objectForTestSteps.get(indexForTestSteps), indexForTestSteps));
					indexForTestSteps++;
				}
				TestAttribute.objtestAttr.put("Description", descOneLine.toString());
			}
			if(objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("TESTCASEDESCRIPTIONSTART"))
			{
				indexForTestSteps++;
				StringBuilder stepOneLine = new StringBuilder();
				while (!objectForTestSteps.get(indexForTestSteps).equalsIgnoreCase("TESTCASEDESCRIPTIONEND")) {
					stepOneLine.append(formatTestCaseLine(testCaseNumber, objectForTestSteps.get(indexForTestSteps), indexForTestSteps));
					indexForTestSteps++;
				}
				TestAttribute.objtestAttr.put("TestCaseDescription", stepOneLine.toString());
			}
			
			
			
			
//	
//			if(indexForTestSteps==0)
//			{
//				//forPath
//				String formattedPath=formatTestCaseLine(testCaseNumber,objectForTestSteps.get(indexForTestSteps),indexForTestSteps);
//				TestAttribute.objtestAttr.put("Path", formattedPath);
//			}
//			else if(indexForTestSteps==1)
//			{
//				//forTestName
//				String formattedTestName=formatTestCaseLine(testCaseNumber,objectForTestSteps.get(indexForTestSteps),indexForTestSteps);
//				TestAttribute.objtestAttr.put("TestCaseName", formattedTestName);
//				TestAttribute.objtestAttr.put("Path",TestAttribute.objtestAttr.get("Path").toString()+"/"+formattedTestName);
//			}
			indexForTestSteps++;
			
		}
		TestAttribute.mylogger.info("Hash map set for test case number :" + testCaseNumber);
	}
	
	
	
	
	

	
	
	public String formatTestCaseLine(Integer testCaseNumber, String iptoFormat, int indexForParameterBound) {
		StringBuilder objStringBuilder = new StringBuilder();
		ArrayList<Integer> obj = null;
		ExcelRead objExcelOperations = new ExcelRead();
			String formatString = null;
			int indexForParse = 0;
				obj = TestAttribute.objTestCaseLine.objArrayListoftestStep
						.get(indexForParameterBound);
				int temp = 0;
				for (indexForParse = 0; indexForParse < obj.size(); indexForParse += 2) {
					objStringBuilder.append(
							iptoFormat.substring(temp, obj.get(indexForParse)))
							.append(" ");
					String valueToSearch = iptoFormat.substring(
							obj.get(indexForParse) + 1,
							obj.get(indexForParse + 1));
					objStringBuilder.append(objExcelOperations
							.getNamedColumnValueByIndex(objExcelOperations.removeSpaceAndConvertUpper(valueToSearch),
									testCaseNumber));
					temp = obj.get(indexForParse + 1) + 1;
				}
				if(obj.size()==0)
				{
					objStringBuilder.append(iptoFormat);
				}
				else{
				objStringBuilder.append(iptoFormat.substring(obj.get(indexForParse-1)+1,iptoFormat.length()));
				}
				formatString = objStringBuilder.toString();
				//System.out.println(formatString);
				objStringBuilder.setLength(0);
		return formatString;
	}
}
