package frame;

import java.awt.*;
import java.awt.event.*;

import classes.MainStart;

public class InitFrame extends Frame implements WindowListener, ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label topMessageOne;
	Label topMessageTwo;
     Label InputXmlFileStatus;
     Label isXMLFilePresent;
     Label ExcelFileStatus;
     Label isExcelFilePresent;
     Button CheckFileButton;
     Button GenerateTestButton;
     Label currentStatusMessage;
     Label footer;
     MainStart objMainStart = new MainStart();
     
   public InitFrame()
   {
     this.setLayout(null);	
     setupGUI();
   }
   void setupGUI()
   {
    topMessageOne = new Label();
	topMessageOne.setLocation(39,44);
	topMessageOne.setSize(468,26);
	topMessageOne.setBackground(Color.WHITE);
	topMessageOne.setText("                Hi "+System.getProperty("user.name")+", Please see Readme file to know how to use this application.");
	
	add(topMessageOne);

	topMessageTwo = new Label();
	topMessageTwo.setLocation(39,69);
	topMessageTwo.setSize(468,28);
	topMessageTwo.setBackground(Color.WHITE);
	topMessageTwo.setText("                                    Made your TestCase  writing process very Easy");
	
	add(topMessageTwo);


	InputXmlFileStatus = new Label();
	InputXmlFileStatus.setLocation(74,122);
	InputXmlFileStatus.setSize(104,26);
	InputXmlFileStatus.setBackground(Color.LIGHT_GRAY);
	InputXmlFileStatus.setText("XML File Status");
	add(InputXmlFileStatus);

	isXMLFilePresent = new Label();
	isXMLFilePresent.setLocation(243,122);
	isXMLFilePresent.setSize(251,26);
	isXMLFilePresent.setBackground( Color.LIGHT_GRAY );
	isXMLFilePresent.setText("Click on Check file button to check status");
	add(isXMLFilePresent);

	ExcelFileStatus = new Label();
	ExcelFileStatus.setLocation(74,155);
	ExcelFileStatus.setSize(104,26);
	ExcelFileStatus.setBackground( Color.LIGHT_GRAY );
	ExcelFileStatus.setText("Excel File Status");
	add(ExcelFileStatus);

	isExcelFilePresent = new Label();
	isExcelFilePresent.setLocation(243,155);
	isExcelFilePresent.setSize(251,26);
	isExcelFilePresent.setBackground(Color.LIGHT_GRAY );
	isExcelFilePresent.setText("Click on Check file button to check status");
	add(isExcelFilePresent);

	CheckFileButton = new Button();
	CheckFileButton.setLocation(109,230);
	CheckFileButton.setSize(100,50);
	CheckFileButton.setBackground(Color.GRAY);
	CheckFileButton.setLabel("Check file");
	CheckFileButton.addActionListener(this);
	add(CheckFileButton);

	GenerateTestButton = new Button();
	GenerateTestButton.setLocation(297,231);
	GenerateTestButton.setSize(100,50);
	GenerateTestButton.setBackground(Color.GRAY);
	GenerateTestButton.setLabel("Generate Test");
	GenerateTestButton.addActionListener(this);
	add(GenerateTestButton);

	currentStatusMessage = new Label();
	currentStatusMessage.setLocation(86,308);
	currentStatusMessage.setSize(356,25);
	currentStatusMessage.setText("");
	add(currentStatusMessage);

	footer = new Label();
	footer.setLocation(287,404);
	
	footer.setSize(361,46);
	footer.setBackground(Color.LIGHT_GRAY);
	footer.setText("              Copyright  @ CPF Test Team 2014");
	add(footer);

	setTitle("Test Factory - Pairwise Testcase writing made easy ");
	setSize(561,470);
	setForeground(Color.BLACK);
	setBackground(Color.LIGHT_GRAY);
	setVisible(true);
	setResizable(false);
	GenerateTestButton.disable();
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	});
	
   }
   
	public void setExecMessage(String message)
	{
		
		currentStatusMessage.setText(message);
			
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Generate Test")) {
			try {
			//	String inputTime = timeInMinutes.getSelectedItem();
				
				setExecMessage("Starting Test Genration");
				Thread.sleep(1000);
				setExecMessage("Starting in one second");
				Thread.sleep(1000);
				setExecMessage("Running");
			Thread.sleep(1000);
				//-------------------------
				
				/*
				 * CAll OTHER FILES
				 * 
				 * */
				setExecMessage("Generating test cases");
				objMainStart.mainFunction();
				
				
				//------------------------------
				
				setExecMessage("Complete - Please check the excel sheet in same folder");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}
		if (e.getActionCommand().equals("Check file")) {
			boolean isXMLPresent = objMainStart.isXMLPresent();
			boolean isExcelPresent = objMainStart.isEXCELPresent();
			
			if(isXMLPresent&&isExcelPresent)
			{
				//set messgae both present
				isExcelFilePresent.setText("EXCEL SHEET IS PRESENT");
				isXMLFilePresent.setText("XML SHEET IS PRESENT");
				GenerateTestButton.enable();
				
			}
			else if (isXMLPresent&&!isExcelPresent) {
				//set message
				isExcelFilePresent.setText("EXCEL SHEET IS NOT PRESENT");
				isXMLFilePresent.setText("XML SHEET IS PRESENT");
			}
			else if (!isXMLPresent&&isExcelPresent) {
				//setmessage
				isExcelFilePresent.setText("EXCEL SHEET IS PRESENT");
				isXMLFilePresent.setText("XML SHEET IS NOT PRESENT");
			}
			else {
				//set message
				isExcelFilePresent.setText("EXCEL SHEET IS NOT PRESENT");
				isXMLFilePresent.setText("XML SHEET IS NOT PRESENT");
			}
			
			
			
			

		}

	}
   public static void main( String args[] )
   {
     new InitFrame();
     
     
     
   }
@Override
public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosing(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeiconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowOpened(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
}  