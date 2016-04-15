public class MakeReservation {
 public static String run(String [] list){
  
  boolean success=true; 
  String printStr="Make Reservation request for";
  String x=list[1];
  Customer newCust= new Customer();
  
  Reservation newRes= new Reservation();
  newCust.setName(x);
  printStr=printStr+x+":\n";
    
  x=list[2];
  newCust.setAddress(x);
  printStr=printStr+x;
    
  x=list[3];
  int startDate=Integer.parseInt(x);
  x=list[4];
  int stopDate=Integer.parseInt(x);
  x=list[5];
  int roomType=Integer.parseInt(x);
  //check with calendar
  if(!Calendar.checkDays(startDate,stopDate,roomType)){
   success=false;
  }
  //if succeed the check 
  if(success){
   printStr=printStr+"Reservation: Success\n";
  }
  //if check failed, returned that it failed
  else{
   printStr=printStr+"Reservation failed\n";
   return printStr;
  }
  
  //update newRes
  x=list[6];
  int numOccs=Integer.parseInt(x);
  newRes.setNumOccupants(numOccs);
  
  x=list[7];
  int guaranteed=Integer.parseInt(x);
  newRes.setGuaranteed(guaranteed);
  
  //check guaranteedt
  if(guaranteed==1){
   String[] array= new String[2];
   array[0]=list[10];
   array[1]=list[9];
   if(!Proxy.validateCard(array)){
    printStr=printStr+"Reservation failed\n";
    return printStr;
   }
   printStr=printStr+"Guaranteed: True\n";
   
   x=list[8];
   newCust.setCCType(x);
   
   x=list[9];
   newCust.setCCExpiration(x);
   
   x=list[10];
   newCust.setCCNumber(x);
  }
  
  else{
   printStr=printStr+"Guaranteed: False\n";
  }
  //more addition to reservation
  newRes.setStartDate(startDate);
  newRes.setEndDate(stopDate);
  newRes.setRoomType(roomType);
  
  printStr=printStr+"Check In: "+"January "+startDate+", 2015\n";
  printStr=printStr+"Check Out: "+"January "+stopDate+", 2015\n";
  //customer ID and Res ID
  int custID=Framework.storeCustomer(newCust);
  newRes.setCustomerID(custID);
  
  int resID=Framework.storeReservation(newRes);
  //finally add reservation since everything has passed
  Calendar.addReservation(startDate, stopDate, roomType, resID);
  return printStr;
 }
}
