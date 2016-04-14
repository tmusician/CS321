
public class PrintManagementReport {
	
	public static String viewReport(String[] args) {
	
		int date = args[1];
		//compare date against current day.
		
		Day cur = Calendar.getInfo();      //need to get DATE!
		
		int num_SR_reserved = Framework.NUM_SINGLE_ROOMS - cur.getSingAvail();
		int num_DR_reserved = Framework.NUM_DOUBLE_ROOMS - cur.getDoubAvail();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Management Report for day:   \n");                                       //Add DATE here!!!!!!
		sb.append("Number of Reservations: "+(num_SR_reserved+num_DR_reserved)+"\n");
		sb.append("Single Rooms Reserved: "+ num_SR_reserved +"\n");
		sb.append("Double Rooms Reserved: "+ num_DR_reserved +"\n");
		sb.append("Occupancy Rate:"+int((Report.get_Occupancy/((double)(Framework.NUM_SINGLE_ROOMS+Framework.NUM_DOUBLE_ROOMS)))*100)+"\n");
		sb.append("Total Revenue: $"+String.format("%0.2d",(double)report.get_income())+"\n");
		
		return sb.toString();
	}
}
