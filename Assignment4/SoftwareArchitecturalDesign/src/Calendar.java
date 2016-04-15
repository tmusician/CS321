import java.util.ArrayList;

public class Calendar {
 private static int curDay=1;
 private static ArrayList<Day> dayInfo=new ArrayList<Day>();
 
 //Initializes static class to hold reservations, current day, and days
 public static void init(){
  for(int i=0; i<31; i++){
   dayInfo.add(new Day(Framework.NUM_DOUBLE_ROOMS,Framework.NUM_SINGLE_ROOMS));
  }
 }
 
 //Check if requested reservation is a valid choice, or if days are full
 public static boolean checkDays(int start, int end, int roomType){
  if(start>end){
   return false;
  }
  if(start<curDay || end>31){
   return false;
  }
  if(roomType==1){
   for(int i=0; i<=end-start; i++){
    if(dayInfo.get(start+i).getSingAvail()==0){
     return false;
    }
   }
  }
  else if(roomType==2){
   for(int i=0; i<=end-start; i++){
    if(dayInfo.get(start+i).getDoubAvail()==0){
     return false;
    }
   }
  }
  return true;
 }
 
 //add a reservation start to the proper day so it can be charged if needed
 public static boolean addReservation(int start, int end, int type, int resID){
  //if single room
  if(type==1){
   for(int i=0; i<=end-start; i++){
    dayInfo.get(start+i).decSingAvail();
   }
  }
  //if double room
  else if(type==2){
   for(int i=0; i<=end-start; i++){
    dayInfo.get(start+i).decDoubAvail();
   }
  }
  dayInfo.get(start).addReservation(resID);
  return true;
 }
 
 //increments day
 public static int nextDay(){
  curDay++;
  return curDay;
 }
 
 //returns the day object of current day
 public static Day getInfo(){
  return dayInfo.get(curDay-1);
 }
 //returns current date
 public static int get_cur_Day(){
  return curDay;
 }
}

