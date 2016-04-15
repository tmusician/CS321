/*
Information Hiding Class: Proxy
Author: Trenton Eliopoulos.
 Operations provided:
validateCard(int cardNo)
 Function : validate whether or not a credit card number is valid.
 Input Parameters : cardNo : credit card number to be validated.
 Output Parameters : Boolean value ( 1 = successful, 0 = unsuccessful).
*/
public class Proxy {
 public static boolean validateCard(String[] args) {
  //initialize variables
  int num = Integer.parseInt(args[0]);
  int expDate = Integer.parseInt(args[1]);
  
  // if credit card number is odd then return false, else return true
  return num % 2 != 0;
 }
}
