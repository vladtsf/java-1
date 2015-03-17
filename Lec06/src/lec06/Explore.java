package lec06;

import java.awt.Point;
import java.util.ArrayList;

public class Explore {
  public static void main(String[] args) {
    test1();
  }
  
  public static void test1() {
    ArrayList<Object> a = new ArrayList<>();
    a.add(new Object());
    a.add(new String("hello there"));
    a.add(new Point(4,5));
    
    for (Object o : a) {
      System.out.println(o.toString());
    }
    
    Point p2 = (Point) a.get(2);
    p2.move(2,3);
//    a.get(2).move(3,4);
  }
}
