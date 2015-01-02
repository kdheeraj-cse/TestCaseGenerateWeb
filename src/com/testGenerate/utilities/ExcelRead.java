/*
 * This class reads the input excel sheet and stores the data in server memory
 * 
 * 
 * */

package com.testGenerate.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.testGenerate.utilities.ExcelColumn;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelRead {

	Sheet objSheet;
	Workbook objWorkbook = null;
	public static ArrayList<ExcelColumn> objExcelColumns = new ArrayList<ExcelColumn>();

	public void setAndInitiateInputExcelFile(String inputFilePath)
			throws BiffException, IOException {
		File inputWorkbook = new File(inputFilePath);
		objWorkbook = Workbook.getWorkbook(inputWorkbook);
		objSheet = objWorkbook.getSheet(0);
		TestAttribute.mylogger.info("Excel file path set to "+inputFilePath);
		
	}

	public String removeSpaceAndConvertUpper(String input) {
		input = input.trim().toUpperCase().replaceAll(" ", "");
		return input;
	}

	public ArrayList<ExcelColumn> readExcelSheet(String inputFilePath)
			throws IOException, BiffException {
		setAndInitiateInputExcelFile(inputFilePath);
		int i = 0, j = 0;
		TestAttribute.mylogger.info("Entered readExcelSheet in ExcelRead");
		ExcelColumn objColumn;
		TestAttribute.numberOfTestCases = objSheet.getRows() - 1;
		for (j = 0; j < objSheet.getColumns(); j++) {
			objColumn = new ExcelColumn();
			for (i = 0; i < objSheet.getRows(); i++) {
				Cell cell = objSheet.getCell(j, i);
				if (i == 0)
					objColumn.setColumnName(removeSpaceAndConvertUpper(cell
							.getContents()));
				else
					objColumn.setColumnValues(cell.getContents());
			}
			objExcelColumns.add(objColumn);
		}
		TestAttribute.mylogger
				.info("Done with excel sheet read, Total read was " + i
						+ " rows and " + j + " columns");
		return objExcelColumns;
	}

	public String getNamedColumnValueByIndex(String ColumnName, Integer index) {
		String valueAtIndex = null;

		for (int i = 0; i < objExcelColumns.size(); i++) {
			if (objExcelColumns.get(i).getColumnName()
					.equalsIgnoreCase(ColumnName)) {
				valueAtIndex = objExcelColumns.get(i).getColumnValues(index);
			}
		}
		return valueAtIndex;
	}

	public void closeExcelFile() {
		objWorkbook.close();
	}

}
