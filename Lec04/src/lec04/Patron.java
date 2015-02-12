package lec04;

public class Patron {
  String name;
  private int accountBalance;
  
  public static void main(String[] args) {
    Patron good = new Patron();
    
    System.out.println("good's accountBalance is " + good.accountBalance);
    System.out.println("good's name is " + good.name);
  }
}
