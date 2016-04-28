/* CLASS INTERFACE SPECIFICATION: 
 * 
 * Information Hiding Class : Report:
 * Author: Krishna Kanakapura.
 * 
 * Operations Provided:
 * 
 * -inc_Occupancy:
 *    -function: increment the hotels total occupancy.
 *    -precondition: Systm is initiated.
 *    -postcondition: hotels occupancy has been incremented.
 *    -input parameters: none.
 *    -output parameters: none.
 * 
 * -dec_Occupancy:
 *    -function: decrement the hotels total occupancy.
 *    -precondition: Systm is initiated.
 *    -postcondition: hotels occupancy has been decremented.
 *    -input parameters: none.
 *    -output parameters: none.
 * 
 * -incIncome:
 *    -function: increment the hotels revenue by the given amount.
 *    -precondition: System is initiated.
 *    -postcondition: the hotels revenue is incremented by the given amount.
 *    -input paramenters: int amount.
 *    -output paramenters: none.
 * 
 * -day_change():
 *    -function: creates todays report and resets the static int income.
 *    -precondition: system is initiated.
 *    -postcondition: todays report is created and stored.
 *    -input parameters:none.
 *    -output parameters: none.
 * 
 * -get_report(date):
 *    -function: return previous day(s) reports.
 *    -precondition: system has been running for at least one complete day.
 *    -postconditon: a previous report is returned.
 *    -input parameters: int date.
 *    -output parameters: String report.
 * 
 * -makeReport_curDay():
 *    -function: create and store the management report for today.
 *    -precondition: System is functional and running.
 *    -postcondition: A report has been created successfully.
 *    -input parameters: int date.
 *    -output parameters: String report.
 */
import java.util.*;
public class Report{
  
  private static int income = 0;
  private static int Occupancy = 0;
  private static HashMap<Integer,String> History = new HashMap<Integer,String>();
  
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
    sb.append("Occupancy Rate:"+String.format("%2.0f%%",((Occupancy/((double)(Framework.NUM_SINGLE_ROOMS+Framework.NUM_DOUBLE_ROOMS)))*100))+"\n");
    sb.append("Total Revenue: $"+String.format("%.2f",(double)get_income())+"\n");
    
    return sb.toString();
  }
  
  public static String get_report(int date){
    return History.get(date);
  }
  
}
