package operations;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.OrderedJSONObject;

import utilities.Constant;
import utilities.TestAttribute;

public class InputJsonRead {
	
	public static Logger log = Logger.getLogger("InputJsonRead.class");
	static ArrayList<String> testparameterList = new ArrayList<String>();
	OrderedJSONObject readAndCreateJSONObject() throws IOException, JSONException{
		log.info("readAndCreateJSONObject() - Entry");
		File inputFile = new File(TestAttribute.inputJSONFile);
		FileReader inputFileReader = new FileReader(inputFile);
		OrderedJSONObject objJsonObject = new OrderedJSONObject(inputFileReader);
		log.info("readAndCreateJSONObject() - Exit with return "+objJsonObject);
		return objJsonObject;
	}
	
	@SuppressWarnings("unchecked")
	void jsonread(Object objJsonObject) throws JSONException
	{
		log.info("jsonread(objJsonObject="+objJsonObject+") - Entry");
		for (Iterator<String> iter = ((OrderedJSONObject)(objJsonObject)).getOrder(); iter.hasNext();) {
			String string = (String) iter.next();
			Object obj2 = ((OrderedJSONObject)(objJsonObject)).get(string);
			if(obj2 instanceof OrderedJSONObject){
				testparameterList.add(Constant.NewLine);
				testparameterList.add(Constant.BoldStart+string+Constant.BoldEnd);
				if(!(string.equals("StepsToExecute")||string.equals("SubStep")||string.equals("ExpectedResult")||string.equals("FinalExpectedResult"))){
				testparameterList.add(string.toUpperCase()+"START");
				}
				testparameterList.add(Constant.OrderedListStart);
				log.info("Calling jsonread in recursion");
				jsonread(obj2);
				log.info("Called jsonread in recursion");
				if(!(string.equals("StepsToExecute")||string.equals("SubStep")||string.equals("ExpectedResult")||string.equals("FinalExpectedResult"))){
				testparameterList.add(string.toUpperCase()+"END");
				}
			}
			else {
				if(string.equals("TestType")){
					TestAttribute.testName = obj2.toString();
				}
				else if (string.equals("Category")||string.equals("Priority")) {
					TestAttribute.objtestAttr.put(string, obj2.toString());
				}
				else {
					if(string.equals("Path")||string.equals("TestCaseName")){
						testparameterList.add(string.toUpperCase()+"START");
						testparameterList.add(obj2.toString());
						testparameterList.add(string.toUpperCase()+"END");
					}
					else {
						testparameterList.add(Constant.ListElementStart + obj2.toString() + Constant.ListElementEnd);
					}
				}
			}
		}
		log.info("jsonread() - Exit");
		testparameterList.add(Constant.OrderedListEnd);
	}
	
	ArrayList<String> processJSONToList() throws IOException, JSONException{
		log.info("processJSONToList() - Entry");
		InputJsonRead objInputJsonRead = new InputJsonRead();
		OrderedJSONObject objOrderedJSONObject = null ;
		objOrderedJSONObject = objInputJsonRead.readAndCreateJSONObject();
		objInputJsonRead.jsonread(objOrderedJSONObject);
		log.info("processJSONToList() - Exit with testparameterList of size" + testparameterList.size());
		return testparameterList;
	}
	
	/*public static void main(String[] args) {
		InputJsonRead objInputJsonRead = new InputJsonRead();
		OrderedJSONObject objOrderedJSONObject = null ;
		try {
			objOrderedJSONObject = objInputJsonRead.readAndCreateJSONObject();
			objInputJsonRead.jsonread(objOrderedJSONObject);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		for (String string : testparameterList ) {
			System.out.println(string);
		}
		
	}*/
	}
	
