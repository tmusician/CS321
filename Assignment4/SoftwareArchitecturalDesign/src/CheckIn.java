// business logic class used to check in a customer 
public class CheckIn {

	// checks in customer dictated by an instruction list
	public static void checkIn(String[] instr) {
		// initialize variables 
		Customer cust=Framework.getCustomerByName(instr[1]); // the customer data retrieved by customer's name
		Reservation userRes= Framework.getReservationByCID(cust.getCustomerID()); // the reservation for the customer retrieved by customer ID
		boolean checkedIn = false; // keeps track if customer has necessary information to check in
		String output = "";
		
		// if a credit type is given then update the credit card information 
		if (instr.length == 5){				// if instruction does not include 5 arguemtns, then no credit type was given (it's the only option value
			cust.setCCType(instr[2]);
			cust.setCCExpiration(instr[3]);
			cust.setCCNumber(instr[4]);
			
			checkedIn = true;
		}
		
		// if credit type is not given then check if reservation is guaranteed and compare credit information to the reservation
		else if(instr.length == 4 && userRes.getGuaranteed()==0 && cust.getCCExpiration() == instr[instr.length - 2] && cust.getCCNumber() == instr[instr.length - 1])
				checkedIn = true;
		
		// finish checking in the customer if they have provided sufficient information
		if (checkedIn) {
			userRes.setStatus(Framework.STATUS_CHECKED_IN); // change status of reservation to checked in                                    ////!!!!!!!!!!!!!!!!!!!!!!!!!!
			//assign room# to res, 0-MAX_singles is singles and max singles-max doubles is doubles
			int roomNum= Rooms.getEmpty(userRes.getRoomType());
			Rooms.fillRoom(roomNum);
			userRes.setRoomNumber(roomNum);
			Report.inc_Occupancy();
			
			output = output + cust.getName() + " was successfully checked in.\n\nCheck In Statement:" +
				"\nCustomer Name: " + cust.getName() + "\nCustomer Address: " + cust.getAddress() +
				"\nRoom Type: " + res.getRoomType() + "\nNights Reserved: " + 
				res.getEndDate() - res.getStartDate() + "\nNightlyRate: " + 
				(res.getRoomType() == 1)?Framework.SINGLE_RATE:DOUBLE_RATE + "\nCheck In: " + 
				res.getStartDate() + "\nCheck Out: " + res.getEndDate();
		}
		else {
			output = output + cust.getName() + " was not successfully checked in.";
		}
		
		// OUTPUT GOES HERE
		
		return output;
	}

}
