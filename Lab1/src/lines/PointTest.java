package lines;

import java.awt.*;

public class PointTest {

  public static void main(String[] args) {
    Point p1 = new Point();
    p1.x = 1;
    p1.y = 2;
    // state 0
    Point p2 = new Point();
    p2.x = 3;
    p2.y = 4;
    // state 1
    p2.x = p1.y;
    // state 2
    p1 = p2;
    // state 3
    p2.x = p1.y;
    // state 4
    System.out.println(p1.x + " " + p1.y
            + " " + p2.x + " " + p2.y);
  }
}
