import java.util.*;
import java.io.*;
public class ReservationSystem{
	public static void main(String[] args){
		//need calander for day
		try{
			Framework.init(args[0]);
			PrintWriter pw = new PrintWriter(new File("HRSLog_InputFileName.txt"));
			Calendar.init();
			Rooms.init();
			while(Framework.hasNextInstruction){
					String[] instructions=Framework.nextInstruction();
					int next = instructions[0];
					switch(next){
						case 1: //call  make reservation
								break;
						case 2: //call check in
								break;
						case 3: //call check out
								break;
						case 4: //call print management report
								break;
						case 5: //day change
								break;
						case 6: //6pm alarm
								break;
					}
			}
			pw.close;
		}
		catch(Exception IOException){
			System.out.println("No such file found");
		}
	}
	
	public void print_to_Log(String send_to_log){
		pw.print(send_to_log);
	}
	
}
