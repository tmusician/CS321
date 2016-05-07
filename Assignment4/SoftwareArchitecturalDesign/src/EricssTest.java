import java.io.FileNotFoundException;

public class tester {

	public static void main(String[] args) {
		Day day = new Day();
		
		// test day getters
//		System.out.println(day.getDoubAvail());
//		System.out.println(day.getSingAvail());
//		System.out.println(day.getResIDs());
//		
		// test incrementors 
	
//		System.out.print(day.getDoubAvail());
//		System.out.println(", " +day.getSingAvail());
//		
//		for (int i = 0; i < 10; i++){
//			day.incDoubAvail();
//			System.out.print(day.getDoubAvail());
//			day.incSingAvail();
//			System.out.println(", " + day.getSingAvail());
//		}
//		
//		for (int i = 0; i < 10; i++){
//			day.decDoubAvail();
//			System.out.print(day.getDoubAvail());
//			day.decSingAvail();
//			System.out.println(", " + day.getSingAvail());
//		}
		
		// test reservation add and remove
		
//		Reservation res = new Reservation();
//		
//		System.out.println("Size before add " + day.getResIDs().size()); 
//		
//		day.addReservation(0);
//		
//		System.out.println("After add " + day.getResIDs().size()); 
//		
//		System.out.println("Size before remove " + day.getResIDs().size()); 
//		
//		day.removeReservation(0);
//		
//		System.out.println("After remove " + day.getResIDs().size()); 
		
		
		// test checkIn
		
		try {
			Framework.init(args[0]);
		} catch (Exception e) {
			System.out.println("oops");
		}
		Calendar.init();
		Rooms.init();
		
		Customer cust = new Customer();
		Reservation res = new Reservation();
		
		cust.setName("Judy");
		cust.setAddress("508 S Buckton Rd, Muddletown PA");
		cust.setCCType("Visa");
		cust.setCCExpiration("7/19");
		cust.setCCNumber("123456");
		cust.setCustomerID(1);
		res.setCustomerID(1);
		res.setNumOccupants(2);
		res.setGuaranteed(1);
		res.setReservationID(1);
		res.setRoomType(2);
		res.setStartDate(2);
		res.setEndDate(3);
		res.setStatus(0);
		
		int custID=Framework.storeCustomer(cust);
		  res.setCustomerID(custID);
		  
		  int resID=Framework.storeReservation(res);
		  //finally add reservation since everything has passed
		  Calendar.addReservation(2, 3, 2, resID);
		
		Calendar.addReservation(res.getStartDate(), res.getEndDate(), res.getRoomType(), res.getReservationID());
		
		
		String[] s = {"@2", "Judy"};
		
		System.out.println(CheckIn.checkIn(s));
		
		Calendar.nextDay();
		
		System.out.println(CheckIn.checkIn(s));
		
		
		
		
		
		
	}

}
