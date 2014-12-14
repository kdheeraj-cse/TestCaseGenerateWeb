package classes;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import org.apache.wink.json4j.JSONException;

import operations.*;
import utilities.TestAttribute;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class MainStart {
	public MainStart() {
		FileHandler fh = null;
		try {
			fh = new FileHandler(TestAttribute.logPath);
		} catch (SecurityException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		TestAttribute.mylogger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		TestAttribute.mylogger.info("********************************************");
		TestAttribute.mylogger.info("LOG FILE Intialized and start");
	}

	public boolean isXMLPresent() {
		File file = new File(TestAttribute.inputJSONFile);
		if (file.exists()) {
			TestAttribute.mylogger.info("Input Test XML file found");
			return true;
		} else {
			return false;
		}
	}

	public boolean isEXCELPresent() {
		File file = new File(TestAttribute.testParameterExcelInputPath);
		if (file.exists()) {
			TestAttribute.mylogger.info("Input Excel Data file found");
			return true;
		} else {
			return false;
		}
	}

	public void mainFunction() throws InterruptedException {
		ExcelOperations objExcelOperations = new ExcelOperations();
		InputTestStepsProcess objInputTestStepsProcess = new InputTestStepsProcess();
		try {
			objExcelOperations
					.excelSheetRead(TestAttribute.testParameterExcelInputPath);
		} catch (BiffException e1) {
			TestAttribute.mylogger.info(e1.getMessage());
			e1.printStackTrace();
		} catch (IOException e1) {
			TestAttribute.mylogger.info(e1.getMessage());
		}

		// ------------------------------------------------------------
		// ----------------------------------- One value is stored then open the
		// xml and prcess and changes the steps

		try {
			objInputTestStepsProcess.openAndReadXmlFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ---------------------------------------------------------------

		// ----------------- Write CSV

		try {
			objExcelOperations
					.xlSheetInitForWrite(TestAttribute.outputExcelPath);
		} catch (IOException e) {
			TestAttribute.mylogger.info(e.getMessage());
		}
		int indexTest=0;
		
		for (indexTest = 0; indexTest < TestAttribute.numberOfTestCases; indexTest++) {
			
			objInputTestStepsProcess.SetHashMap(indexTest);
			try {
				objExcelOperations.writeTestCasesCSV(indexTest);
			} catch (WriteException | IOException e) {
				// TODO Auto-generated catch block
				TestAttribute.mylogger.info(e.getMessage());
			}

		}
		TestAttribute.mylogger.info("Total cases wrote : "+indexTest);
		
		try {
			objExcelOperations.finalWriteAndClose();
			TestAttribute.mylogger.info("Test cases Generated");
			TestAttribute.mylogger.info("********************************************");
		} catch (IOException e) {
			TestAttribute.mylogger.info(e.getMessage());
		}
	}
}
