package operations;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Node;

import utilities.TestAttribute;


public class InputJsonRead {
	static final String BoldStart = "[b]";
	static final String BoldEnd = "[/b]";
	static final String OrderedListStart = "[ol]";
	static final String OrderedListEnd = "[/ol]";
	static final String ListElementStart = "[li]";
	static final String ListElementEnd = "[/li]";
	
	
	void setTestAttribute(JSONObject objJsonObject)
	{
		if(objJsonObject.get("TestType")!=null)
		{
			TestAttribute.testName = (String) objJsonObject.get("TestType"); 
		}
		
		if(objJsonObject.get("Category")!=null)
		{
			TestAttribute.objtestAttr.put("Category", (String) objJsonObject.get("Category")); 
		}
		
		if(objJsonObject.get("Priority")!=null)
		{
			TestAttribute.objtestAttr.put("Priority", (String) objJsonObject.get("Priority")); 
		}		
	}
	
	JSONObject readAndCreateJSONObject() throws IOException, ParseException
	{
		JSONParser objJsonParser = new JSONParser();
		File inputFile = new File(TestAttribute.inputJSONFile);
		FileReader inputFileReader = new FileReader(inputFile);
		Object obj = objJsonParser.parse(inputFileReader);
		JSONObject objJsonObject = (JSONObject)obj;
		return objJsonObject;
	}
	
	
	ArrayList<String> processAttributeWithSeparator(JSONObject object,String key, String separatorStart, String separatorEnd)
	{
		ArrayList<String> returnList = new ArrayList<>();
		returnList.add(separatorStart);
		if(key.equals("TestCaseDescription"))
		{
			returnList.addAll(processStepsAddHTML(object));
		}
		else {
//			System.out.println("Adding" + (String) object.get(key));
			returnList.add((String) object.get(key));
		}
		returnList.add(separatorEnd);
		return returnList;
	}
	
	
	@SuppressWarnings("unchecked")
	ArrayList<String> processStepsAddHTML(JSONObject object)
	{
		JSONObject objectIN = (JSONObject) object.get("TestCaseDescription");
		JSONObject stepObj;
		ArrayList<String> returnList = new ArrayList<>();
		String tempModifiedStr = null;
		
		
		Set<String> inputKey = objectIN.keySet();
			for (String string : inputKey) {
				if (objectIN.get(string)!=null) {
					tempModifiedStr = BoldStart + string + BoldEnd;
					returnList.add(tempModifiedStr);
					stepObj=(JSONObject)objectIN.get(string);
					
					
					
					
					
					Set<String> step = stepObj.keySet();
					tempModifiedStr = OrderedListStart;
					returnList.add(tempModifiedStr);
					for (String string2 : step) {
						tempModifiedStr = ListElementStart + stepObj.get(string2) + ListElementEnd;
						returnList.add(tempModifiedStr);
					}
					tempModifiedStr = OrderedListEnd;
					returnList.add(tempModifiedStr);
				}
			}
		return returnList;
	}

	ArrayList<String> processJSONtoList() throws IOException, ParseException
	{
		
		JSONObject objJsonObject = readAndCreateJSONObject();
		setTestAttribute(objJsonObject);

		
		
		TestAttribute.mylogger.info("Entered processJSONtoList");
		ArrayList<String> testparameterList = new ArrayList<String>();
		
		if(objJsonObject.get("Path")!=null)
		{
			testparameterList.addAll(processAttributeWithSeparator(objJsonObject,"Path", "PATHSTART","PATHEND")); 
		}
		
		if(objJsonObject.get("TestCaseName")!=null)
		{
			testparameterList.addAll(processAttributeWithSeparator(objJsonObject, "TestCaseName", "TCNAMESTART","TCNAMEEND")); 
		}
		
		if(objJsonObject.get("TestCaseDescription")!=null)
		{
			testparameterList.addAll(processAttributeWithSeparator(objJsonObject, "TestCaseDescription", "TCDDESCRIPTIONSTART","TCDDESCRIPTIONEND"));
		}
		
		return testparameterList;
		
	}
	/*
	public static void main(String[] args) {
		InputJsonRead objInputJsonRead = new InputJsonRead();
		try {
			
			for (String string : objInputJsonRead.processJSONtoList()) {
				
				System.out.println(string);
			}
			
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	*/
	
}
