public class Proxy {
 public static boolean validateCard(String[] args) {
  //initialize variables
  int num = Integer.parseInt(args[0]);
  int expDate = Integer.parseInt(args[1]);
  
  // if credit card number is odd then return false, else return true
  return num % 2 != 0;
 }
}
