
public class MakeReservation {
	private static void main(){
		String x=Framework.getNextInstruction();
		Customer newCust= new Customer();
		Reservation newRes= new Reservation();
		newCust.setName(x);
		x=Framework.getNextInstruction();
		newCust.setAddress(x);
		x=Framework.getNextInstruction();
		int startDate=Integer.parseInt(x);
		//check with calendar
		newRes.setStartDate(startDate);
	}
}
