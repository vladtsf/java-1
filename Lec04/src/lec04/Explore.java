package lec04;

import java.util.Random;
import java.math.BigInteger;

public class Explore {
  static double i = 3;
  
  static {
    i = 10;
    System.out.println("the static block is being called " + i);
  }
  
  public static void main(String[] args) {
    System.out.println("the main() method gets called");
    System.out.println(Explore.i);
    Explore e = new Explore();
    e.trythis(1.0, 1);
    e.trythis(1, 1.1);
    
    
    Random rnd = new Random();
    System.out.println(rnd.nextInt(10));
    System.out.println(rnd.nextBoolean());
    
    System.out.println(new Integer(10).intValue());
    
    Double price = 327.50;
    price = price * 1.086;
    System.out.println(price);
    
    System.out.println(Integer.parseInt("10"));
    BigInteger bi = BigInteger.ONE;
    System.out.println(bi);
  }
  
  public void trythis(int a, double b) {
    System.out.println("trythis: int double");
  }
  
  public void trythis(double a, int b) {
    System.out.println("trythis: double int");
  }
}
