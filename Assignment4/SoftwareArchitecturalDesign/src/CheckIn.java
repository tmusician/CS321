/*
Information Hiding Class: CheckIn 
Author: Eric Miller
Information Hidden: Encapsulates Customer, Reservation, Room, Calendar, and Report attributes
and their current values
Class structuring criterion: Data abstraction class
Assumptions: customer name, credit card type, number, and expiration date are included in a list of strings 
Anticipated changes:
Superclass: none
Inherited operations: none
Operations provided:
checkIn(String[] instr)
  Function: compares customer credit card information to the reservation credit card information and updates status of reservation
  Precondition: Customer and Reservation exist for the given customer name.
  Postcondition: Customer is either checked in or denied.
  Input Parameters: instr: a list of strings that form a instruction message for check in, which include instuction type, customer name, 
    credit card type, credit card number, and credit card expiration
*/


// business logic class used to check in a customer 
public class CheckIn {

 // checks in customer dictated by an instruction list
 public static String checkIn(String[] instr) {
  // initialize variables 
  Customer cust=Framework.getCustomerByName(instr[1]); // the customer data retrieved by customer's name
  Reservation userRes= null; // the reservation for the customer retrieved by customer ID
  boolean checkedIn = false; // keeps track if customer has necessary information to check in
  String output = "";
  
  Day dayInfo = Calendar.getInfo();
  
  for (int i = 0; i < dayInfo.getResIDs().size(); i++){
	  Reservation r = Framework.getReservationByID(dayInfo.getResIDs().get(i));
	  if (r.getCustomerID() == cust.getCustomerID()) {
		  userRes = r;
		  break;
	  }
	  
  }
  if (userRes == null){
	  output = output + instr[1] + " was not successfully checked in.";
	  return output;
  }
  
  
  // if a credit type is given then update the credit card information 
  if (instr.length == 5){    // if instruction does not include 5 arguemtns, then no credit type was given (it's the only option value
   cust.setCCType(instr[2]);
   cust.setCCExpiration(instr[3]);
   cust.setCCNumber(instr[4]);
   
   checkedIn = true;
  }
  
  // if credit type is not given then check if reservation is guaranteed and compare credit information to the reservation
  else if(instr.length == 4 && userRes.getGuaranteed()==0 && cust.getCCExpiration().equals(instr[instr.length - 2]) && cust.getCCNumber().equals(instr[instr.length - 1]))
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
    "\nRoom Type: " + userRes.getRoomType() + "\nNights Reserved: " + 
    (userRes.getEndDate() - userRes.getStartDate()) + "\nNightlyRate: " + 
    ((userRes.getRoomType() == 1)?Framework.SINGLE_RATE:Framework.DOUBLE_RATE) + "\nCheck In: " + 
    userRes.getStartDate() + "\nCheck Out: " + userRes.getEndDate();
  }
  else {
   output = output + cust.getName() + " was not successfully checked in.";
  }
  
  // OUTPUT GOES HERE
  
  return output;
 }

}
