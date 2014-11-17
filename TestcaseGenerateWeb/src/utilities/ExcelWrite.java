package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class ExcelWrite {

	private WritableCellFormat timesBold;
	private WritableCellFormat times;
	WritableSheet excelSheet;
	WritableWorkbook workbook;
	Integer count = 0;
	//AppFrame objAppFrame = new AppFrame("Test Factory");
	public boolean initiateSheet(String outputPath) throws IOException {
		File file = new File(outputPath);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet(TestAttribute.testName, 0);
		// output file
		excelSheet = workbook.getSheet(0);
		TestAttribute.mylogger.info("Output excel sheet is initiated with path"+outputPath);
		try {

			createLabel(excelSheet);
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(file.exists())
			return true;
			else {
				return false;
			}
	}

	public void write(String category, String priority, String inputPath,
			String prereq, String desc, String testCaseName, int row,
			String testSteps) throws IOException, WriteException, InterruptedException {
		;

		createContent(excelSheet, category, priority, inputPath, prereq, desc,
				testCaseName, row, testSteps);

		// inputWorkbook.write();
		count++;
		
		
		System.out.println("DONE " + count.toString());
		//Thread.sleep(5);
		//AppFrame.setExecMessage("DONE*********************** ");
		
	}

	private void createLabel(WritableSheet sheet) throws WriteException {
		// Lets create a times font
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		// Define the cell format
		times = new WritableCellFormat(times10pt);
		// Lets automatically wrap the cells
		// times.setWrap(true);

		// create create a bold font with underlines
		WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 10,
				WritableFont.BOLD, false);
		timesBold = new WritableCellFormat(times10ptBold);
		// Lets automatically wrap the cells
		timesBold.setWrap(true);
		timesBold.getAlignment();

		CellView cv = new CellView();
		cv.setFormat(times);
		cv.setFormat(timesBold);
		cv.setAutosize(true);

	}

	private void createContent(WritableSheet sheet, String category,
			String priority, String path, String prerequisite,
			String description, String test, int row, String testSteps)
			throws WriteException, RowsExceededException {
		addString(sheet, row, 0, category);
		addString(sheet, row, 1, "1");
		addString(sheet, row, 2, priority);
		addString(sheet, row, 4, path);
		addString(sheet, row, 5, prerequisite);
		addString(sheet, row, 6, description);
		addString(sheet, row, 7, "1");
		addString(sheet, row, 8, test);
		addString(sheet, row, 9, testSteps);

	}

	private void addString(WritableSheet sheet, int row, int column, String str)
			throws WriteException, RowsExceededException {

		Label label;
		label = new Label(column, row, str, timesBold);
		sheet.addCell(label);

	}

	public void writeAndClose() throws IOException {

		try {
			workbook.write();
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
