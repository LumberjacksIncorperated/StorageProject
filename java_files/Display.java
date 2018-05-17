import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display extends JFrame {

	private JTextArea outputTextArea;

	private Display() {
		setupOutputTextField();
    	attachTextFieldToFrame();
	}

    	private void setupOutputTextField() {
        	outputTextArea = new JTextArea();
        	outputTextArea.setColumns(10);
        	outputTextArea.setRows(7);
        	outputTextArea.setWrapStyleWord(true);
        	outputTextArea.setEditable( false );	
    	}

    	private void attachTextFieldToFrame() {
        	Container framePanel = getContentPane();
        	framePanel.setLayout(new GridBagLayout());
        	addTextFieldToPanel(framePanel);
   	 	}

   	 		private void addTextFieldToPanel(Container panel) {
   	 			GridBagConstraints constraints = new GridBagConstraints();
   	 			panel.add(outputTextArea, constraints);
   	 		}

	public static Display createNewDisplay() {
		Display newDisplay = new Display();
		return newDisplay;
	}

    public void startWindowDisplay() {
    	this.setResizable( true );    	
    	this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.pack();
        this.setLocationRelativeTo( null );
		this.setVisible(true);
    }

    public void updateTextDisplay(String updatedDisplayText) {
    	this.outputTextArea.setText(updatedDisplayText);
    }

    public final int NUMBER_OF_DAYS = 7;
    public void updateDisplayWithDisplayInformation(DisplayInformation displayInformation) {
		String displayString = "";
		for(int dayIndex = 0; dayIndex < NUMBER_OF_DAYS; dayIndex++) {
			displayString += (displayInformation.getLineToDisplay(dayIndex) + "\n");
		}
		this.updateTextDisplay(displayString);
	}
}