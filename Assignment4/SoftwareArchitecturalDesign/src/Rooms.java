/*
Information Hiding Class: Rooms
Author: Trenton Eliopoulos 
Operations:
init()
 Function: initializes all fields
 Input Parameters: none
 Output Parameters: none
 Precondition: none
 Postcondition: all fields have values.
fillRoom(int roomNum)
 Function: adds room number to list of rooms in use by its room type
 Input Parameters: roomNum: a number representing the room
 Output Parameters: none
 Precondition: room is not already filled
 Postcondition: room has been added to the proper list
emptyRoom(int roomNum)
 Function: removes room number from list of rooms in use by its room type
 Input Parameters: roomNum: a number representing the room
 Output Parameters: none
 Precondition: room is already filled
 Postcondition: room has been removed to the proper list 
getEmpty(int roomType)
 Function: retrieves a room that is not filled
 Input Parameters: roomType: a number representing the either single or double room type
 Output Parameters: int roomNum: the number of a room that is not filled
 Precondition: fields have been initialized
 Postcondition: none
*/

import java.util.ArrayList;

//hold what rooms are in use
public class Rooms {
 //list of rooms, location in array goes to room #. Double is location+size of singles 
 private static ArrayList<Integer> sigRoomsInUse = new ArrayList<Integer>();
 private static ArrayList<Integer> doubRoomsInUse = new ArrayList<Integer>();
 private static int numSig;
 private static int numDob;
 
 public static void init(){
  numSig=Framework.NUM_SINGLE_ROOMS;
  numDob=Framework.NUM_DOUBLE_ROOMS;
  //set all to 0, meaning empty
  for(int i=0; i<numSig;i++){
   sigRoomsInUse.add(0);
  }
  for(int x=0; x<numDob;x++){
   doubRoomsInUse.add(0);
  }
 }
 
 public static void fillRoom(int roomNum) {
  if(roomNum>numSig){
   doubRoomsInUse.set(roomNum-numSig-1, 1);
  }
  else{
   sigRoomsInUse.set(roomNum-1, 1);
  }
 }

 public static int getEmpty(int roomType) {
  // TODO Auto-generated method stub
  if(roomType==1){
   for(int i=0; i<numSig; i++){
    int t=sigRoomsInUse.get(i);
    if(t==0){
     return i+1;
    }
   }
  }
  else{
   for(int i=0; i<numDob; i++){
    int t=doubRoomsInUse.get(i);
    if(t==0){
     return i+numSig+1;
    }
   }
  }
  return 0;
 }
 
 public static void emptyRoom(int room){
  if(room>numSig){
   doubRoomsInUse.set(room-numSig-1, 0);
  }
  else{
   sigRoomsInUse.set(room-1, 0);
  }
 }
}
