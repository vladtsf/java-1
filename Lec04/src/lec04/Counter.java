package lec04;

public class Counter {
  int myCount = 0;
  static int numInstances = 0;
  
  Counter() {
    numInstances++;
  }
  
  public static void main(String[] args) {
    Counter c1 = new Counter();
//    c1.increment();
    Counter c2 = new Counter();
    c1.myCount = c2.myCount;
    System.out.println(Counter.numInstances);
  }
}
