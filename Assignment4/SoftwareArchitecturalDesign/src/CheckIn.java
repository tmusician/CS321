

public class CheckIn {

	public static void run(String[] instr) {
		// TODO Auto-generated method stub
		Customer cust=Framework.getCustomerByName(instr[1]);
		Reservation userRes= Framework.getReservationByCID(cust.getCustomerID());
		boolean checkedIn = false;
		
		if (instr[2] != null){
			userRes.setStatus(2);
			
			cust.setCCType(instr[2]);
			cust.setCCExpiration(instr[3]);
			cust.setCCNumber(instr[4]);
			
			checkedIn = true;
		}
		
		else if(userRes.getGuaranteed()==0){

			if (cust.getCCExpiration() == instr[3] && cust.getCCNumber() == instr[4]){
				userRes.setStatus(2);	
				checkedIn = true;
			}
		}
		if (checkedIn) {
			//assign room# to res, 0-MAX_singles is singles and max singles-max doubles is doubles
			int roomNum= Rooms.getEmpty(userRes.getRoomType());
			Rooms.fillRoom(roomNum);
			userRes.setRoomNumber(roomNum);
		}
	}

}
