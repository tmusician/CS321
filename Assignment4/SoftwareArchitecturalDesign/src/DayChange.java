
public class DayChange {

	public static String change_day(String[] args) {
		
		StringBuilder op = new StringBuilder();
		//print no show guranteed reservations.
		Report.day_change();
		Calendar.nextDay();
		op.append("==================January "+Calendar.get_cur_Day()+", 2015==================");
		
		return op.toString();
	}

}
