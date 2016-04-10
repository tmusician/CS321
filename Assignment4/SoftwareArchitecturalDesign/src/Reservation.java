
public class Reservation {
	
	///////////////////////////////////////////////////////////////
	// FIELDS
	///////////////////////////////////////////////////////////////
	
	private int reservationID; // A unique identifier for the reservation, assigned by the Framework
	private int status;			// The status of the reservation: 1 for reserved, 2 for checked in, 3 for checked out, 4 for no show, 5 for must pay
	private int startDate;		// The start date of the reservation (1-31)
	private int endDate;		// The end date of the reservation (1-31)
	private int roomType;		// The room type (1 for single, 2 for double)
	private int numOccupants;	// The number of occupants in the room
	private boolean guaranteed; // True if the reservation is guaranteed with a credit card, false if not guaranteed
	private int roomNumber;		// The room number assigned to this reservation
	private int customerID;		// The customer ID for the customer who made this reservation
	
	
	/////////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////
	
	// Default constructor
	Reservation(){
		reservationID = status = startDate = endDate = roomType = numOccupants = roomNumber = customerID = 0;
		guaranteed = false;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// SETTERS & GETTERS
	///////////////////////////////////////////////////////////////
	
	// Sets reservationID for this object to the value of the parameter �id�.
	void setReservationID(int reservationID){
		this.reservationID=reservationID;
		return;
	} // STUB
	
	// Sets status for this object to the value of the parameter �status�
	void setStatus(int status){
		this.status=status;
		return;
	} // STUB
	
	// Sets startDate for this object to the value of parameter �startDate�.
	void setStartDate(int startDate){
		this.startDate=startDate;
		return;
	} // STUB
	
	// Sets endDate for this object to the value of parameter �endDate�.
	void setEndDate(int endDate){
		this.endDate=endDate;
		return;
	} // STUB
	
	// Sets roomType for this object to the value of parameter �roomType�.
	void setRoomType(int roomType){
		this.roomType=roomType;
		return;
	} // STUB
	
	// Sets numOccupants for this object to the value of parameter �numOccupants�.
	void setNumOccupants(int numOccupants){
		this.numOccupants=numOccupants;
		return;
	} // STUB
	
	// Sets guaranteed for this object to the value of parameter ��. 
	// (I copied these descriptions. this one seems a little confused about what it's doing)
	void setGuaranteed(int guaranteed){
		if(guaranteed==1){
			this.guaranteed=true;
		}
		else{
			this.guaranteed=false;
		}
		return;
	} // STUB
	
	// Sets roomNumber for this object to the value of parameter �roomNum�.
	void setRoomNumber(int roomNum){
		this.roomNumber=roomNum;
		return;
	} // STUB
	
	// Sets customerID for this object to the value of parameter �customerID�.
	void setCustomerID(int customerID){
		this.customerID=customerID;
		return;
	} // STUB
	
	// Retrieves the instance variable �reservationID� for this object.
	int getReservationID(){
		return this.reservationID;} // STUB
	
	// Retrieves the instance variable �status� for this object.
	int getStatus(){
		return this.status;} // STUB	
	
	// Retrieves the instance variable �startDate� for this object.
	int getStartDate(){
		return this.startDate;} // STUB
	
	// Retrieves the instance variable �endDate� for this object.
	int getEndDate(){return this.endDate;} // STUB
	
	// Retrieves the instance variable �roomType� for this object.
	int getRoomType(){return this.roomType;} // STUB
	
	// Retrieves the instance variable �numOccupants� for this object.
	int getNumOccupants(){return this.numOccupants;} // STUB
	
	// Retrieves the instance variable �guaranteed� for this object.
	int getGuaranteed(){
		if(this.guaranteed==true){
			return 1;
		}
		else{
			return 0;// STUB
		}
	}
	
	// Retrieves the instance variable �roomNumber� for this object.
	int getRoomNumber(){return this.roomNumber;} // STUB
	
	// Retrieves the instance variable �customerID� for this object.
	int getCustomerID(){return this.customerID;} // STUB

}
	