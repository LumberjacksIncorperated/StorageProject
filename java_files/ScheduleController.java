
public class ScheduleController implements UserInputListener {

	private Schedule schedule;
	private Display display;
	private UserInteractionWindow userWindow;
	private ScheduleUserInputParser scheduleUserInputParser; // for "UserInputListener"

	private ScheduleController() {
		this.schedule = Schedule.createNewSchedule();
		this.display = Display.createNewDisplay();
		this.userWindow = UserInteractionWindow.createWithUserInputListener(this);
		this.scheduleUserInputParser = ScheduleUserInputParser.createEmptyParser();
	}

	public void start() {
		this.display.startWindowDisplay();
		this.userWindow.startWindowDisplay();
	}

	public static ScheduleController createScheduleController() {
		ScheduleController newScheduleController = new ScheduleController();
		return newScheduleController;
	}

	//----------------------------------------------------------------------------------
	// USER_INPUT_LISTENER INTERFACE IMPLEMENTATION
	//----------------------------------------------------------------------------------
	public void userInputParserReceieved(UserInputParser userInputParser) {
		updateScheduleWithUserInput(userInputParser);
		sendUpdateInformationToDisplay();
	}

		private void updateScheduleWithUserInput(UserInputParser userInputParser) {
			ScheduleUserInputParser scheduleUserInputParser = (ScheduleUserInputParser) userInputParser;
			int scheduleUpdateDay = scheduleUserInputParser.getScheduleUpdateDay();
			String scheduleUpdateEntry = scheduleUserInputParser.getScheduleUpdateEntry();
			schedule.updateScheduleForDayAndEntry(scheduleUpdateDay, scheduleUpdateEntry);
		}

		private void sendUpdateInformationToDisplay() {
			ScheduleDisplayInformation scheduleDisplayInformation = ScheduleDisplayInformation.createScheduleDisplayInformation();
			fillScheduleDisplayInformationWithCurrentSchedule(this.schedule, scheduleDisplayInformation);
			this.display.updateDisplayWithDisplayInformation(scheduleDisplayInformation);
		}

			public final int NUMBER_OF_DAYS = 7;
			private void fillScheduleDisplayInformationWithCurrentSchedule(Schedule schedule, ScheduleDisplayInformation scheduleDisplayInformation) {
				for(int dayIndex = 0; dayIndex < NUMBER_OF_DAYS; dayIndex++) {
					fillDisplayInforamtionWithScheduleEntryForDay(dayIndex, scheduleDisplayInformation);
				}
			}

				private void fillDisplayInforamtionWithScheduleEntryForDay(int day, ScheduleDisplayInformation scheduleDisplayInformation) {
					String entry = this.schedule.getScheduleEntryForDay(day);
					scheduleDisplayInformation.updateScheduleInformationWithLineForDay(entry, day);
				}

	public UserInputParser getUserInputParser() {
		return (UserInputParser) this.scheduleUserInputParser;
	}
}