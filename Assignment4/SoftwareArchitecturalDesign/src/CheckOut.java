public class CheckOut {

 public static String checkOut(String[] instr) {
  //initalize variables
  Customer cust=Framework.getCustomerByName(instr[1]); // the customer data retrieved by customer's name
  Reservation userRes= Framework.getReservationByCID(cust.getCustomerID()); // the reservation for the customer retrieved by customer ID
  boolean checkedOut = false; // keeps track if customer has necessary information to check out
  String output = "";

  //update the money based on start_Date and end_date rates (rate differs by single and double rates)
  //charge credit card
  int days = userRes.getEndDate() - userRes.getStartDate();
  int rate = (userRes.getRoomType() == 1)?Framework.SINGLE_RATE:Framework.DOUBLE_RATE; //single_rate or double_rate
  int charge = days * rate;
  //check card through proxy
  if(Proxy.validateCard(cust.getCCNumber) == false){
   return "Invalid Card.";
  }
  else{
  // UserRes.chargeCard(charge);
  }
  

  //assign room# to res, 0-MAX_singles is singles and max singles-max doubles is doubles
  int roomNum = userRes.getRoomNumber();
  Rooms.emptyRoom(roomNum);
  userRes.emptyRoom(roomNum);
  
  //update Report to free the room and add money to report object
  Report.dec_Occupancy();
  //report.addRevenue(charge);
  
  userRes.setStatus(1); // change status of reservation to checked out
  checkedOut = true;
  
  // finish checking in the customer if they have provided sufficient information
  if (checkedOut) {
   Reservation res = userRes;
   output = output + cust.getName() + " was successfully checked out.\n\nCheckout Statement:" +
    "\nCustomer Name: " + cust.getName() + "\nCustomer Address: " + cust.getAddress() +
    "\nRoom Type: " + res.getRoomType() + "\nNights Reserved: " + 
    (res.getEndDate() - res.getStartDate()) + "\nCharge per night: " + 
    ((res.getRoomType() == 1)?Framework.SINGLE_RATE:Framework.DOUBLE_RATE) + "\nAmount payable: " + 
    ((res.getRoomType() == 1)?Framework.SINGLE_RATE:Framework.DOUBLE_RATE);
  }
  else {
   output = output + cust.getName() + " was not successfully checked out.";
  }  
  
  return output;
 }
}
