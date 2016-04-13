import java.util.ArrayList;

public class Calendar {
	private static int curDay=1;
	private static ArrayList<Day> dayInfo=new ArrayList<Day>();
	
	public static void init(){
		for(int i=0; i<31; i++){
			dayInfo.add(new Day(Framework.NUM_DOUBLE_DAYS,Framework.NUM_SINGLE_DAYS));
		}
	}
	
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
	
	public static boolean addReservation(int start, int end, int type){
		if(type==1){
			for(int i=0; i<=end-start; i++){
				dayInfo.get(start+i).decSingAvail();
			}
		}
		else if(type==2){
			for(int i=0; i<=end-start; i++){
				dayInfo.get(start+i).decDoubAvail();
			}
		}
		return true;
	}
	
	public static int nextDay(){
		curDay++;
		return curDay;
	}
	public static Day getInfo(){
		return dayInfo.get(curDay);
	}
}

