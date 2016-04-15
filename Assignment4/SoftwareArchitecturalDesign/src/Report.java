/* CLASS INTERFACE SPECIFICATION: 
 * Information Hiding Class : Report:
 * Author: Krishna Kanakapura.
 * Operations Provided:
 *  -increment and decrement total Occupancy of the Hotel.
 *  -Create management report for current day and store it.
 
 */
import java.util.*;
public class Report{
  
  private static int income;
  private static int Occupancy;
  private static HashMap<Integer,String> History;
  
  public static void main(String[] args){
    income = 0;
    Occupancy = 0;
    History = new HashMap<Integer,String>();
  }
  
  public static void inc_Occupancy(){ Occupancy++; }
  public static void dec_Occupancy(){ Occupancy--; }
  
  public static void incIncome(int inc){ income += inc; }
  
  public static int get_Occupancy(){ return Occupancy; }
  
  public static int get_income(){ return income; }
  
  public static void day_change(){
    History.put(Calendar.get_cur_Day(),makeReport_curDay());
    income = 0;
  }
  
  public static String makeReport_curDay() {
    
    Day cur = Calendar.getInfo();      
    
    int num_SR_reserved = Framework.NUM_SINGLE_ROOMS - cur.getSingAvail();
    int num_DR_reserved = Framework.NUM_DOUBLE_ROOMS - cur.getDoubAvail();
    
    StringBuilder sb = new StringBuilder();
    
    sb.append("Management Report for 1/"+Calendar.get_cur_Day()+"/2016:\n");                                       
    sb.append("Number of Reservations: "+(num_SR_reserved+num_DR_reserved)+"\n");
    sb.append("Single Rooms Reserved: "+ num_SR_reserved +"\n");
    sb.append("Double Rooms Reserved: "+ num_DR_reserved +"\n");
    sb.append("Occupancy Rate:"+String.format("%2d",((Occupancy/((double)(Framework.NUM_SINGLE_ROOMS+Framework.NUM_DOUBLE_ROOMS)))*100))+"\n");
    sb.append("Total Revenue: $"+String.format("%0.2d",(double)get_income())+"\n");
    
    return sb.toString();
  }
  
  public static String get_report(int date){
    return History.get(date);
  }
  
}
