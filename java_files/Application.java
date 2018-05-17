
public class Application {
	
	//------------------------------------------------------
	// MAIN
	//------------------------------------------------------
	public static void main(String[] args) {
		ScheduleController scheduleController =  ScheduleController.createScheduleController();
		scheduleController.start();
	}
}