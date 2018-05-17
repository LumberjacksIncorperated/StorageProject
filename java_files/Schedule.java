
public class Schedule {
	
	private String[] weeklyScheduleList;

	private final int NUMBER_OF_DAYS_OF_WEEK = 7;
	private Schedule() {
		this.weeklyScheduleList = new String[NUMBER_OF_DAYS_OF_WEEK];
		initializeEmptyWeeklySchedule();
	}

		private void initializeEmptyWeeklySchedule() {
			for(int dayIndex = 0; dayIndex < NUMBER_OF_DAYS_OF_WEEK; dayIndex++) {
				this.weeklyScheduleList[dayIndex] = "";
			}
		}

	public static Schedule createNewSchedule() {
		Schedule newSchedule = new Schedule();
		return newSchedule;
	}

	public void updateScheduleForDayAndEntry(int day, String entry) {
		this.weeklyScheduleList[day] = entry;
	}

	public String getScheduleEntryForDay(int day) {
		String entryForGivenDay = this.weeklyScheduleList[day];
		return entryForGivenDay;
	}
}