
public class CheckIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x=Framework.getNextInstruction();
		Customer cust=Framework.getCustomerByName(x);
		Reservation userRes= Framework.getReservationByCID(cust.getCustomerID());
		
		if(userRes.getGuaranteed()==0){
			x=Framework.getNextInstruction();
			cust.setCCType(x);
			
			x=Framework.getNextInstruction();
			cust.setCCExpiration(x);
			
			x=Framework.getNextInstruction();
			cust.setCCNumber(x);
		}
		userRes.setStatus(2);
		//assign room# to res, 0-MAX_singles is singles and max singles-max doubles is doubles
		int roomNum= Rooms.getEmpty(userRes.getRoomType());
		room.fillRoom(roomNum);
	}

}
