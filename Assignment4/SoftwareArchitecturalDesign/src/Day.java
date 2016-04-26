/*
Information Hiding Class: Day
Author: Eric Miller
Operations provided:
getResIDs()
 Function: retrieve the list of reservation IDs
 Input Parameters: none
 Output parameters: int[]
 Precondition: reservationIds has been initialized
 Postcondition: none
getDoubAvail()
 Function: retrieve the number of double rooms available
 Input Parameters: none
 Output parameters: int
 Precondition: doubAvail has been initialized
 Postcondition: none
getSingAvail()
 Function: retrieve the number of single rooms available
 Input Parameters: none
 Output Parameters: int
 Precondition: SingAvail has been initialized
 Postcondition: none
decDoubAvail()
 Function: subtract 1 from doubAvail
 Input Parameters: none
 Output Parameters: none
 Precondition: DoubAvail has been initialized
 Postcondition: doubAvail equals 1 less than previously value
decSingAvail()
 Function: subtract 1 from singAvail
 Input Parameters: none
 Output Parameters: none
 Precondition: singAvail has been initialized
 Postcondition: singAvail equals 1 less than previously value
incDoubAvail()
 Function: add 1 to doubAvail
 Input Parameters: none
 Output Parameters: none
 Precondition: DoubAvail has been initialized
 Postcondition: doubAvail equals 1 more than previously value
incSingAvail()
 Function: add 1 to doubAvail
 Input Parameters: none
 Output Parameters: none
 Precondition: DoubAvail has been initialized
 Postcondition: doubAvail equals 1 more than previously value
addReservation(int resID)
 Function: add a reservation ID to the list of reservation IDs
 Input Parameters: resID: a number corresponding to a unique reservation
 Output Parameters: none
 Precondition: resIDs has been initialized
 Postcondition: resIDs has one more value stored in it
removeReservation(int resId)
 Function: remove a reservation from the list of reservation IDs
 Input Parameters: resID: a number corresponding to a unique reservation
 Output Parameters: none
 Precondition: resIDs has been initialized
 Postcondition: resIDs has one less value stored in it
 */

import java.util.*;
public class Day {

 //////////////////////////
 // FIELDS
 /////////////////////////
 
 private ArrayList<Integer> resIDs; // list of reservations for the day by ID
 private int doubAvail;      // number of double rooms available for the day
 private int singAvail;      // number of single rooms available for the day
 
 
 /////////////////////////
 // CONSTRUCTOR(S)
 ////////////////////////
 
 // default constructor 
 public Day() {
  // initialize fields
  this.doubAvail = 0;
  this.singAvail = 0;
  this.resIDs = new ArrayList<Integer>();
 }
 
 // constructor to set available rooms to the given total number of rooms
 public Day( int numDoubRooms,  int numSingRooms) {
  // initialize rooms available to total number of rooms
  this.doubAvail = numDoubRooms;
  this.singAvail = numSingRooms;
  
  //initialize reservation IDs to empty list
  this.resIDs = new ArrayList<Integer>();
 }
 
 
 //////////////////////////////
 // GETTERS & SETTERS
 /////////////////////////////
 
 // returns reservation IDs in an array
 public  ArrayList<Integer> getResIDs() {
    return this.resIDs;

 }

 // returns number of double rooms available
 public int getDoubAvail() {
  return this.doubAvail; 
 }

 // returns number of single rooms available 
 public int getSingAvail() {
  return this.singAvail;
 }
 
 
 /////////////////////////
 // METHODS
 /////////////////////////
 
 // decrements number of double rooms available
 public void decDoubAvail() {
  this.doubAvail--;
 }
 
 // decrements number of single rooms available
 public void decSingAvail() {
  this.singAvail--;
 }
 
 // increments number of double rooms available
 public void incDoubAvail() {
  this.doubAvail++;
 }
 
 // increments number of single rooms available 
 public void incSingAvail() {
  this.singAvail++;
 }
 
 // add a new reservation by ID
 public void addReservation(int resID) {
  this.resIDs.add(resID);
  Reservation res = Framework.getReservationByID(resID);
  //if (res.getRoomType() == 1)
   //this.incSingAvail();
  //else
   //this.incDoubAvail();
 }
 
 // remove a reservation by ID
 public void removeReservation(int resID) {
  this.resIDs.remove(resID);
  Reservation res = Framework.getReservationByID(resID);
  //if (res.getRoomType() == 1)
   //this.decSingAvail();
  //else
   //this.decDoubAvail();
 }

}
