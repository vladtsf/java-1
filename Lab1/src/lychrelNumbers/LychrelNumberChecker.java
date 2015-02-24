package lychrelNumbers;
import java.math.BigInteger;

public class LychrelNumberChecker {
  private final int number;
  private static final int NUMBER_OF_ATTEMPTS = 100;
  
  LychrelNumberChecker(int number) {
    this.number = number;
  }
  
  private static boolean isPolindrome(String number) {
    return number.equals(reverse(number));
  }
  
  private static String reverse(String number) {
    return new StringBuilder(number).reverse().toString();
  }
  
  private static String addUpBigNumbers(String left, String right) {
    return new BigInteger(left).add(new BigInteger(right)).toString();
  }
  
  public boolean isLychrel() {
    String lastNumber = "" + number;
    
    for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
      lastNumber = addUpBigNumbers(lastNumber, reverse(lastNumber));
      
      if(isPolindrome(lastNumber)) {
        return false;
      }
    }
    
    return true;
  }
}