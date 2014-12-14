package operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.OrderedJSONObject;

import utilities.TestAttribute;

public class JavaJSON {
	static int i=0;
	
	OrderedJSONObject readAndCreateJSONObject() throws IOException, JSONException
	{
		File inputFile = new File(TestAttribute.inputJSONFile);
		FileReader inputFileReader = new FileReader(inputFile);
		OrderedJSONObject objJsonObject = new OrderedJSONObject(inputFileReader);
		return objJsonObject;
	}

	@SuppressWarnings("unchecked")
	void jsonread(Object objJsonObject) throws JSONException
	{
		System.out.println("function called recursive "+i);
		for (Iterator<String> iter = ((OrderedJSONObject)(objJsonObject)).getOrder(); iter.hasNext();) {
			String string = (String) iter.next();
			Object obj2 = ((OrderedJSONObject)(objJsonObject)).get(string);
			if(obj2 instanceof OrderedJSONObject)
			{
				i++;
				System.out.println("Recursing for key "+string);
				
				jsonread(obj2);
				
			}
			else {
				System.out.println("Key is "+string+" value is "+obj2);
			}
		}
		System.out.println("function recursion ends");
	}
	
	
	
	
	
	public static void main(String[] args) {
	
		OrderedJSONObject objJsonObject = null;
		JavaJSON objJavaJSON = new JavaJSON();
		try {
			objJsonObject = objJavaJSON.readAndCreateJSONObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objJavaJSON.jsonread(objJsonObject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
