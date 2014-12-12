package operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import utilities.TestAttribute;

public class JavaJSON {
	
	JSONObject objJsonObject;
	
	JSONObject readAndCreateJSONObject() throws IOException, ParseException
	{
		JSONParser objJsonParser = new JSONParser();
		File inputFile = new File(TestAttribute.inputJSONFile);
		FileReader inputFileReader = new FileReader(inputFile);
		Object obj = objJsonParser.parse(inputFileReader);
		objJsonObject = (JSONObject)obj;
		return objJsonObject;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	void jsonread(Object objJsonObject)
	{

		Set<String> keys = ((JSONObject)(objJsonObject)).keySet();
		
		System.out.println(keys);
		
		for (String string : keys) {
			
			Object obj2 = ((JSONObject)(objJsonObject)).get(string);
			System.out.println(obj2);
			if(obj2 instanceof JSONObject)
			{
				System.out.println("object is a simple json object");
				Object objectJsonObject = ((JSONObject) obj2).get(string);
				jsonread(objJsonObject);
			}
			else if (obj2 instanceof JSONArray) {
				System.out.println("object is a simple json ARRAY");
			}
			else {
				System.out.println("Nothing");
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		JSONObject objJsonObject = null;
		
		
		JavaJSON objJavaJSON = new JavaJSON();
		try {
			objJsonObject = objJavaJSON.readAndCreateJSONObject();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		objJavaJSON.jsonread(objJsonObject);
		
		
	}

}
