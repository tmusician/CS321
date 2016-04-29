/*CLASS INTERFACE SPECIFICATION
 * 
 Information Hiding Class: SixPmAlarm 
 Author: Krishna Kanakapura
 
 Operations provided:
   -run(String[] args)
     -Function: cancels non guaranteed reservations and charge noshows. 
     -Precondition: Calendar has been init
     -Input Parameters: None
     -Post Condition: Reservations are charged if noshows and removed
     -Output parameters: String of canceled reservations
*/
import java.util.*;
public class SixPmAlarm {

 public static String run(String[] args) {
  
  StringBuilder pm = new StringBuilder();
  pm.append("\n6PM Signal:\n");
  
  ArrayList<Integer> reservations = (Calendar.getInfo()).getResIDs();
  
  for(int i=reservations.size()-1; i>=0; i--){
   Reservation temp = Framework.getReservationByID(reservations.get(i));
   if (temp.getGuaranteed()==0){
    pm.append("Cancelled Reservation for "+((Framework.getCustomerByID(temp.getCustomerID())).getName())+"\n");
    Calendar.removeReservation(temp.getReservationID());
   }
  }
  return pm.toString();
 }

}
