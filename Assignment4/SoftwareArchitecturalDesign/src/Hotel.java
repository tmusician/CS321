public class Hotel {
	private int singleRoom=Framework.NUM_SINGLE_ROOMS;
	private int doubleRoom=Framework.NUM_DOUBLE_ROOMS;
	private ArrayList<Integer> reservationIDs=new ArrayList<Integer>();
	
	//constructor
	
	
	public void addReservation(int id){
		//add reservation id
	}
	public boolean addSingleRoom(){
		//count down check if 0
		return true;
	}
	public boolean addDoubleRoom(){
		//count down check if 0
		return true;
	}
	public ArrayList<Integer> getReservationIDs(){
		return reservationIDs;
	}
	public int getSingleRoom(){
		return singleRoom;
	}
	public int getDoubleRoom(){
		return doubleRoom;
	}
}
