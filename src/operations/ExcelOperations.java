package operations;

import java.io.IOException;
import java.util.ArrayList;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import utilities.ExcelColumn;
import utilities.ExcelRead;
import utilities.ExcelWrite;
import utilities.TestAttribute;

public class ExcelOperations {
	ExcelRead objExcelRead = new ExcelRead();
	ExcelWrite objExcelWrite = new ExcelWrite();
	Integer testCaseCount = 0;

	ArrayList<ExcelColumn> objList = new ArrayList<ExcelColumn>();
	ExcelColumn objColumn = new ExcelColumn();

	public void excelSheetRead(String inputExcelPath) throws BiffException,
			IOException {
		TestAttribute.mylogger.info("Entered excelSheetRead function in ExcelOperations");
		objList = objExcelRead.readExcelSheet(inputExcelPath);
		objExcelRead.closeExcelFile();
	}

	public void xlSheetInitForWrite(String OutputPath) throws IOException {
		TestAttribute.mylogger.info("Initiating Excel sheet for writing");
		boolean outputFileStatus=objExcelWrite.initiateSheet(OutputPath);
		TestAttribute.mylogger.info("Initiating Excel sheet for writing done with status " + outputFileStatus);
	}

	public void writeTestCasesCSV(Integer testCaseNumber)
			throws WriteException, IOException, InterruptedException {

		objExcelWrite
				.write(TestAttribute.objtestAttr.get("Category").toString(),
						TestAttribute.objtestAttr.get("Priority").toString(),
						TestAttribute.objtestAttr.get("Path").toString(),
						TestAttribute.objtestAttr.get("Prerequisite").toString(),
						TestAttribute.objtestAttr.get("Description").toString(),
						TestAttribute.objtestAttr.get("TestCaseName")
								.toString(), testCaseNumber,
						TestAttribute.objtestAttr.get("TestCaseDescription")
								.toString());

	}

	public void finalWriteAndClose() throws IOException {
		objExcelWrite.writeAndClose();
		
	}

}
