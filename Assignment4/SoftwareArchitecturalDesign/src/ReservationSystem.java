import java.util.*;
import java.io.*;
public class ReservationSystem{
 public static void main(String[] args){
  //need calander for day
  try{
   Framework.init(args[0]);
   Calendar.init();
   Rooms.init();
   PrintWriter pw = new PrintWriter(new File("HRSLog_InputFileName.txt"));
   pw.append("==================January "+Calendar.get_cur_Day()+", 2016==================\n");
   while(Framework.hasNextInstruction()){
     String[] instructions=Framework.nextInstruction();
     int next = Integer.parseInt(instructions[0]);
     switch(next){
      case 1: pw.print(MakeReservation.run(instructions));
        break;
      case 2: pw.print(CheckIn.checkIn(instructions));
        break;
      case 3: pw.print(CheckOut.checkOut(instructions));
        break;
      case 4: pw.print(PrintManagementReport.viewReport(instructions));
        break;
      case 5: pw.print(DayChange.change_day(instructions));
        break;
      case 6: pw.print(SixPmAlarm.run(instructions));
        break;
     }
   }
   pw.close();
  }
  catch(Exception IOException){
   System.out.println("No such file found");
  }
 }
 
}
