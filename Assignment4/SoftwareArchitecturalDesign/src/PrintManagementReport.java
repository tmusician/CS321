
public class PrintManagementReport {
	
	public static String viewReport(String[] args) {
	
		int date = args[1];
		//compare date against current day.
		
		Day cur = Calendar.getInfo();      //need to get DATE!
		
		int num_SR_reserved = Framework.NUM_SINGLE_ROOMS - cur.getSingAvail();
		int num_DR_reserved = Framework.NUM_DOUBLE_ROOMS - cur.getDoubAvail();
		
		StringBuilder sb = new StringBuilder();
		
	}
}
