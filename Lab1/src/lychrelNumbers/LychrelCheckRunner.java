package lychrelNumbers;

public class LychrelCheckRunner {
  private static final int FIRST_N_NUMBERS = 1000;
  private static LychrelNumberChecker checker;
  
  public static void main(String[] args) {
    // starting from 1 because checking whether 0 is lychrel does not make any sense
    // the programm will print the numbers between 1 and 1000
    for (int i = 1; i <= FIRST_N_NUMBERS; i++) {
      checker = new LychrelNumberChecker(i);
      System.out.println(i + ": " + checker.isLychrel());
    }
  }
}