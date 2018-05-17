import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInteractionWindow extends JFrame {

	private UserInputListener userInputListener;
    private JTextField inputTextField;
    private JTextArea outputTextArea;

	private UserInteractionWindow(UserInputListener userInputListener) {
		this.userInputListener = userInputListener;
		setupTextFields();
    	attachTextFieldToFrame();
	}

    	private void setupTextFields() {
        	setupInputTextField();
        	setupOutputTextField();
    	}

   	 		private void setupInputTextField() {
        		inputTextField = new JTextField(20);
        		inputTextField.setEditable( true );
        		inputTextField.setHorizontalAlignment(JTextField.LEFT);
    		}

    		private void setupOutputTextField() {
    			setupOutputTextFieldParameters();
    			setupOutputTextFieldText();
    		}

    			private void setupOutputTextFieldParameters() {
    				outputTextArea = new JTextArea();
        			outputTextArea.setColumns(20);
        			outputTextArea.setRows(1);
        			outputTextArea.setWrapStyleWord(true);
        			outputTextArea.setEditable( false );	
    			}

    			private final String USER_MESSAGE = "Enter: <DAY>,<ENTRY>";
    			private void setupOutputTextFieldText() {
    				outputTextArea.setText(USER_MESSAGE);
    			}

    	private void attachTextFieldToFrame() {
        	Container framePanel = getContentPane();
        	framePanel.setLayout(new GridBagLayout());
        	addTextFieldsToPanel(framePanel);
   	 	}

   	 		private void addTextFieldsToPanel(Container panel) {
   	 			GridBagConstraints constraints = new GridBagConstraints();
   	 			addOutputTextFieldToPanelUnderConstrains(panel, constraints);
        		addInputTextFieldToPanelUnderConstraints(panel, constraints);
   	 		}

   	 			private void addInputTextFieldToPanelUnderConstraints(Container panel, GridBagConstraints constraints) {
        			constraints.gridy++;
        			panel.add(this.inputTextField, constraints);
   	 			}

   	 			private void addOutputTextFieldToPanelUnderConstrains(Container panel, GridBagConstraints constraints) {
   	 				constraints.gridx = 0;
        			constraints.gridy = 0;
        			constraints.anchor = GridBagConstraints.WEST;
        			constraints.insets = new Insets(4, 4, 4, 4);
        			panel.add(outputTextArea, constraints);
   	 			}

	public static UserInteractionWindow createWithUserInputListener(UserInputListener userInputListener) {
		UserInteractionWindow newUserInteractionWindow = new UserInteractionWindow(userInputListener);
		return newUserInteractionWindow;
	}

    public void startWindowDisplay() {
    	startWindowListeners();
    	turnWindowDisplayOn();
    }

    	private void startWindowListeners() {
			this.inputTextField.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e)
    			{
    				UserInteractionWindow.this.sendParsedUserInputToListener();
    			}
			});
		}

			private void sendParsedUserInputToListener() {
				UserInputParser userInputParser = this.userInputListener.getUserInputParser();
				String textFieldText = this.inputTextField.getText();
    			userInputParser.parseUserInput(textFieldText);
  				this.userInputListener.userInputParserReceieved(userInputParser);
			}

    	private void turnWindowDisplayOn() {
    		this.setResizable( true );    	
    		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        	this.pack();
        	this.setLocationRelativeTo( null );
			this.setVisible(true);
    	}

    public void updateTextDisplay(String updatedDisplayText) {
    	this.outputTextArea.setText(updatedDisplayText);
    }
}