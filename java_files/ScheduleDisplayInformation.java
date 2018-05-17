
public class ScheduleDisplayInformation implements DisplayInformation {

	private final int NUMBER_OF_LINES_TO_DISPLAY = 7;
	
	private String[] linesToDisplay;
	
	private ScheduleDisplayInformation() {
		this.linesToDisplay = new String[NUMBER_OF_LINES_TO_DISPLAY];
		initializeEmptyLinesToDisplay();
	}

		private void initializeEmptyLinesToDisplay() {
			for(int lineNumber = 0; lineNumber < NUMBER_OF_LINES_TO_DISPLAY; lineNumber++) {
				this.linesToDisplay[lineNumber] = "";
			}
		}

	public static ScheduleDisplayInformation createScheduleDisplayInformation() {
		ScheduleDisplayInformation newScheduleDisplayInformation = new ScheduleDisplayInformation();
		return newScheduleDisplayInformation;
	}

	public void updateScheduleInformationWithLineForDay(String entry, int day) {
		this.linesToDisplay[day] = entry;
	}

	public String getLineToDisplay(int lineNumber) {
		String lineToDisplay = linesToDisplay[lineNumber];
		return lineToDisplay;
	}

	public int getNumberOfLinesToDisplay() {
		return this.NUMBER_OF_LINES_TO_DISPLAY;
	}
}