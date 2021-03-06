package operations;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import utilities.TestAttribute;

import java.io.File;
import java.util.ArrayList;

public class InputXmlRead {
	static final String BoldStart = "[b]";
	static final String BoldEnd = "[/b]";
	static final String OrderedListStart = "[ol]";
	static final String OrderedListEnd = "[/ol]";
	static final String ListElementStart = "[li]";
	static final String ListElementEnd = "[/li]";
//
//	String processStepsToExecute(ArrayList<String>)
//	{
//		
//		
//		
//		return "";
//	}
	
	ArrayList<String> processNodeWithNoChild(Node inputNode, String separatorStart, String separatorEnd)
	{
		ArrayList<String> returnList = new ArrayList<>();
		if(!separatorStart.equalsIgnoreCase("")){
			returnList.add(separatorStart);
			}
		
		returnList.add(inputNode.getTextContent());
		if(!separatorEnd.equals("")){
			returnList.add(separatorEnd);
		}
		return returnList;
	}
	
	ArrayList<String> processNodeWithChild(Node inputNode, String separatorStart, String separatorEnd)
	{
		
		
		ArrayList<String> returnList = new ArrayList<>();
		
		if(!separatorStart.equals("")){
		returnList.add(separatorStart);
		}
		returnList.add(OrderedListStart);
		
		NodeList objNodeList = inputNode.getChildNodes();
		System.out.println("Number of child node is "+objNodeList.getLength());
		for (int j = 0; j < objNodeList.getLength(); j++) {
			Node pcdNode = objNodeList.item(j);
			pcdNode.getTextContent().trim();
			if(pcdNode.hasChildNodes())
			{
				System.out.println("Node "+pcdNode.getNodeName()+" has child node");
				returnList.addAll(processNodeWithChild(pcdNode, "", ""));
			}
			
			if(pcdNode.getNodeType() == Node.ELEMENT_NODE) {
				returnList.add(ListElementStart+ pcdNode.getTextContent()+ ListElementEnd);
			}
		}
		if(!separatorEnd.equals("")){
		returnList.add(separatorEnd);
		}
		returnList.add(OrderedListEnd);
		return returnList;
	}
	

	
	
	
	ArrayList<String> processXMltoList() {
		String tempModifiedString = null;
		TestAttribute.mylogger.info("Entered processXMltoList");
		ArrayList<String> testparameterList = new ArrayList<String>();
		try {
			File fXmlFile = new File(TestAttribute.testStepsXmlInputPath);
			TestAttribute.mylogger.info("XML File Path is set to "+TestAttribute.testStepsXmlInputPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			dbFactory.setIgnoringElementContentWhitespace(true);
			//dbFactory.setSchema(schema);
			dbFactory.setNamespaceAware(true);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Node rootNode = doc.getDocumentElement();
			TestAttribute.mylogger.info("Root element :" + rootNode.getNodeName());
			TestAttribute.testName=rootNode.getNodeName();
			// testparameterList.add(rootNode.getNodeName()); // first element
			// is
			// testcase name

			NodeList listOfNodes = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < listOfNodes.getLength(); i++) {
				Node HeadingNode = listOfNodes.item(i);
				if (HeadingNode.getNodeType() == Node.ELEMENT_NODE) {
					if (HeadingNode.getNodeName().equalsIgnoreCase("Category")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						TestAttribute.objtestAttr.put("Category",
								HeadingNode.getTextContent());
						System.out.println("CategoryPut");
					}
					if (HeadingNode.getNodeName().equalsIgnoreCase("Priority")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						TestAttribute.objtestAttr.put("Priority",
								HeadingNode.getTextContent());
						System.out.println("priorityPut");
					}
					if (HeadingNode.getNodeName().equalsIgnoreCase("Path")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.addAll(processNodeWithNoChild(HeadingNode,"PATHSTART","PATHEND"));						
						System.out.println("pathPut");
					}

					if (HeadingNode.getNodeName().equalsIgnoreCase(
							"TestCaseName")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.addAll(processNodeWithNoChild(HeadingNode,"TCNAMESTART","TCNAMEEND"));
						System.out.println("TCaseNamePut");
					}

					if (HeadingNode.getNodeName().equalsIgnoreCase(
							"Prerequisite")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.addAll(processNodeWithChild(HeadingNode, "PREREQUISITESTART", "PREREQUISITEEND"));
					}

					if (HeadingNode.getNodeName().equalsIgnoreCase(
							"Description")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.addAll(processNodeWithChild(HeadingNode, "DESCRIPTIONSTART", "DESCRIPTIONEND"));
					}

					if (HeadingNode.getNodeName().equalsIgnoreCase(
							"TestCaseDescription")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.add("TCDDESCRIPTIONSTART");

						NodeList tcdNodeList = HeadingNode.getChildNodes();

						for (int j = 0; j < tcdNodeList.getLength(); j++) {
							Node tcdNode = tcdNodeList.item(j);
							if (tcdNode.getNodeName().equalsIgnoreCase(
									"StepsToExecute")) {

								tempModifiedString = BoldStart
										+ tcdNode.getNodeName() + BoldEnd;
								testparameterList.add(tempModifiedString);
								tempModifiedString = OrderedListStart;
								testparameterList.add(tempModifiedString);
								NodeList listOfSteps = tcdNode.getChildNodes();
								for (int j1 = 0; j1 < listOfSteps.getLength(); j1++) {
									Node stepNode = listOfSteps.item(j1);

									if (stepNode.getNodeType() == Node.ELEMENT_NODE) {
										/*
										 * System.out.println(stepNode
										 * .getNodeName() + " contains " +
										 * stepNode.getTextContent());
										 */
										tempModifiedString = ListElementStart
												+ stepNode.getTextContent()
												+ ListElementEnd;
										testparameterList
												.add(tempModifiedString);
									}
								}
								tempModifiedString = OrderedListEnd;
								testparameterList.add(tempModifiedString);

							}

							if (tcdNode.getNodeName().equalsIgnoreCase(
									"ExpectedResult")) {
								tempModifiedString = BoldStart
										+ tcdNode.getNodeName() + BoldEnd;
								testparameterList.add(tempModifiedString);
								tempModifiedString = OrderedListStart;
								testparameterList.add(tempModifiedString);

								NodeList expectedList = tcdNode.getChildNodes();
								for (int j1 = 0; j1 < expectedList.getLength(); j1++) {
									Node expectedNode = expectedList.item(j1);
									if (expectedNode.getNodeType() == Node.ELEMENT_NODE) {
										/*
										 * System.out
										 * .println(expectedList.item(j)
										 * .getNodeName() + " contains " +
										 * expectedList.item(j)
										 * .getTextContent());
										 */
										tempModifiedString = ListElementStart
												+ expectedNode.getTextContent()
												+ ListElementEnd;
										testparameterList
												.add(tempModifiedString);

									}
								}
								tempModifiedString = OrderedListEnd;
								testparameterList.add(tempModifiedString); // list
																			// ends
							}

							if (tcdNode.getNodeName().equalsIgnoreCase(
									"FinalExpectedResult")) {
								tempModifiedString = BoldStart
										+ tcdNode.getNodeName() + BoldEnd;
								testparameterList.add(tempModifiedString);
								tempModifiedString = OrderedListStart;
								testparameterList.add(tempModifiedString);

								NodeList expectedList = tcdNode.getChildNodes();
								for (int j1 = 0; j1 < expectedList.getLength(); j1++) {
									Node expectedNode = expectedList.item(j1);
									if (expectedNode.getNodeType() == Node.ELEMENT_NODE) {
										/*
										 * System.out
										 * .println(expectedList.item(j)
										 * .getNodeName() + " contains " +
										 * expectedList.item(j)
										 * .getTextContent());
										 */
										tempModifiedString = ListElementStart
												+ expectedNode.getTextContent()
												+ ListElementEnd;
										testparameterList
												.add(tempModifiedString);

									}
								}
								tempModifiedString = OrderedListEnd;
								testparameterList.add(tempModifiedString); // list
																			// ends
							}

						}
						testparameterList.add("TCDDESCRIPTIONEND");
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return testparameterList;
	}

}