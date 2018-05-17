
public class ScheduleUserInputParser implements UserInputParser {
	
	private int scheduleUpdateDay;
	private String scheduleUpdateEntry;
	private int currentElementPosition;

	private int UNDEFINED_DAY = -1;
	private String EMPTY_ENTRY = "";
	private ScheduleUserInputParser() {
		this.scheduleUpdateDay = UNDEFINED_DAY;
		this.scheduleUpdateEntry = EMPTY_ENTRY;
	}

	public static ScheduleUserInputParser createEmptyParser() {
		ScheduleUserInputParser newScheduleUserInputParser = new ScheduleUserInputParser();
		return newScheduleUserInputParser;
	}

	public int getScheduleUpdateDay() {
		return this.scheduleUpdateDay;
	}

	public String getScheduleUpdateEntry() {
		return this.scheduleUpdateEntry;
	}

	public void parseUserInput(String userInputText) {
		this.currentElementPosition = 0;
		for(String element : userInputText.split(",")) {
			parseElement(element);
			this.currentElementPosition++;
		}
	}

		private void parseElement(String element) {
			if(elementPositionIsDayPosition()) {
				parseDayElement(element);
			} else
			if(elementPositionIsEntryPosition()) {
				parseEntryElement(element);
			} else {/*NOTHING*/}
		}

			private boolean elementPositionIsDayPosition() {
				return (this.currentElementPosition%2 == 0);
			}

			private boolean elementPositionIsEntryPosition() {
				return (this.currentElementPosition%2 == 1);
			}

			private void parseDayElement(String integerAsString) {
				int parsedDay = Integer.parseInt(integerAsString);
				this.scheduleUpdateDay = parsedDay;
			}

			private void parseEntryElement(String entryElement) {
				this.scheduleUpdateEntry = entryElement;
			}
}