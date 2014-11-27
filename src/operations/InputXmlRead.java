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
	static String BoldStart = "[b]";
	static String BoldEnd = "[/b]";
	static String OrderedListStart = "[ol]";
	static String OrderedListEnd = "[/ol]";
	static String ListElementStart = "[li]";
	static String ListElementEnd = "[/li]";

	ArrayList<String> processXMltoList() {
		String tempModifiedString = null;
		TestAttribute.mylogger.info("Entered processXMltoList");
		ArrayList<String> testparameterList = new ArrayList<String>();
		try {
			File fXmlFile = new File(TestAttribute.testStepsXmlInputPath);
			TestAttribute.mylogger.info("XML File Path is set to "+TestAttribute.testStepsXmlInputPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
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
						testparameterList.add("PATHSTART");
						testparameterList.add(HeadingNode.getTextContent());
						testparameterList.add("PATHEND");
						System.out.println("pathPut");
					}

					if (HeadingNode.getNodeName().equalsIgnoreCase(
							"TestCaseName")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.add("TCNAMESTART");
						testparameterList.add(HeadingNode.getTextContent());
						testparameterList.add("TCNAMEEND");
						System.out.println("TCaseNamePut");
					}

					if (HeadingNode.getNodeName().equalsIgnoreCase(
							"Prerequisite")) {
						// Mark start of Prerequisite
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.add("PREREQUISITESTART");
						NodeList preNodeList = HeadingNode.getChildNodes();
						for (int j = 0; j < preNodeList.getLength(); j++) {
							Node pcdNode = preNodeList.item(j);

							if (pcdNode.getNodeType() == Node.ELEMENT_NODE) {
								/*
								 * System.out.println(stepNode .getNodeName() +
								 * " contains " + stepNode.getTextContent());
								 */
								tempModifiedString = ListElementStart
										+ pcdNode.getTextContent()
										+ ListElementEnd;
								testparameterList.add(tempModifiedString);
							}
//							if (pcdNode.hasChildNodes())// more child node
//							{
//								NodeList preChildNodeList = pcdNode
//										.getChildNodes();
//
//								tempModifiedString = OrderedListStart;
//								testparameterList.add(tempModifiedString);
//								for (int k = 0; k < preChildNodeList
//										.getLength(); k++) {
//									Node preChildNode = preChildNodeList
//											.item(k);
//									if (preChildNode.getNodeType() == Node.ELEMENT_NODE) {
//										tempModifiedString = ListElementStart
//												+ preChildNode.getTextContent()
//												+ ListElementEnd;
//										testparameterList
//												.add(tempModifiedString);
//									}
//								}
//								tempModifiedString = OrderedListEnd;
//								testparameterList.add(tempModifiedString);
//							}

						}
						testparameterList.add("PREREQUISITEEND");

					}

					if (HeadingNode.getNodeName().equalsIgnoreCase(
							"Description")) {
						TestAttribute.mylogger.info("XML element found "+HeadingNode.getNodeName());
						testparameterList.add("DESCRIPTIONSTART");
						NodeList descNodeList = HeadingNode.getChildNodes();
						for (int j = 0; j < descNodeList.getLength(); j++) {
							Node descNode = descNodeList.item(j);
							if (descNode.getNodeType() == Node.ELEMENT_NODE) {
								/*
								 * System.out.println(stepNode .getNodeName() +
								 * " contains " + stepNode.getTextContent());
								 */
								tempModifiedString = ListElementStart
										+ descNode.getTextContent()
										+ ListElementEnd;
								testparameterList.add(tempModifiedString);
							}
						}
						testparameterList.add("DESCRIPTIONEND");

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