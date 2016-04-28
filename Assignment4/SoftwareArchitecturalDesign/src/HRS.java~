/*
 Information Hiding Class: ReservationSystem
 Author: Krishna Kanakapura.
 
 Operations provided:
 
 main(String[] args)
 -Function: Instantiation point for the system. Reads instructions from a file and passes the instructions 
 to respective business logic classes.
 -Input Parameters : args: command line arguments
 -Output Parameters : Strings responses from business logic objects.
 -Precondition: none
 -Postcondition: program has completed successfully.
 */

import java.util.*;
import java.io.*;
public class HRS{
  public static void main(String[] args) throws IOException{
//    try{
      
      Framework.init(args[0]);
      
      Calendar.init();
      Rooms.init();
      PrintWriter pw = new PrintWriter(new File("HRSLog_"+args[0]));
      pw.print("==================January "+Calendar.get_cur_Day()+", 2016==================\n\n");
      while(Framework.hasNextInstruction()){
        String[] instructions=Framework.nextInstruction();
        int next = Integer.parseInt(instructions[0]);
        switch(next){
          case 1: pw.print(MakeReservation.run(instructions)+"\n");
          break;
          case 2: pw.print(CheckIn.checkIn(instructions)+"\n");
          break;
          case 3: pw.print(CheckOut.checkOut(instructions)+"\n");
          break;
          case 4: pw.print(PrintManagementReport.viewReport(instructions)+"\n");
          break;
          case 5: pw.print(DayChange.change_day(instructions)+"\n");
          break;
          case 6: pw.print(SixPmAlarm.run(instructions)+"\n");
          break;
        }
      }
      pw.close();
//    }
//    catch(Exception IOException){
//      System.out.println("No such file found");
//    }
  }
  
}
