
public class SixPmAlarm {

	public static String run(String[] args) {
		
		StringBuilder pm = new StringBuilder();
		pm.append("6PM Signal:\n");
		int[] reservations = (Calendar.getInfo()).getResIDs();
		
		for(int i=0; i<reservations.length; i++){
			Reservation temp = Framework.getReservationByID(reservations[i]);
			if (temp.getGuaranteed()==0){
				pm.append("Cancelled Reservation for "+((Framework.getCustomerByID(temp.getCustomerID())).getName())+"\n");
				Framework.deleteReservation(reservations[i]);
				(Calendar.getInfo()).removeReservation(temp.getReservationID());
			}continue;
		}
		
	}

}
