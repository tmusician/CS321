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
  String num = args[0];
  String expDate = args[1];
  
  // if credit card number is odd then return false, else return true
  return ((num.endsWith("0"))||(num.endsWith("2"))||(num.endsWith("4"))||(num.endsWith("6"))||(num.endsWith("8")))?true:false ;
 }
 
 public static boolean chargeCard(String cardNumber, int charge){
  //if charge is odd then return false, else return true
  return (charge % 2 == 0);
}
}
