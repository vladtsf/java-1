package lines;

import java.awt.*;

public class Line3 {

    Point p1, p2;

    // returns the slope of the line.  This is a ratio of rise over run.
    double slope() {
      double slope = (p1.y - p2.y)/(p1.x - p2.x);
      return slope;
    }
    
    // returns true if the point given as parameters is on the line
    // algorithm: check that the lines between this point and our 
    //   other points have the same slope.
    boolean pointOnLine(int x, int y) {
      // first slope is between the passed in point and x1,y1
      double slope1 = (y-p1.y)/(x-p1.x);
      // slope between parameter point and x2,y2
      double slope2 = (y-p2.y)/(x-p2.x);
      // if the slopes are equal, then the point is on the line
      return (slope1==slope2);
    }
    
    
    // who remembers this stuff?  http://planetmath.org/anglebetweentwolines does.
    double angleTo(Line1 otherLine) {
      double differenceInSlopes = slope() - otherLine.slope();
      double denominator = 1 + ( slope() * otherLine.slope() );
      double angleInDegrees = Math.abs( differenceInSlopes / denominator );
      return angleInDegrees;
    }

    
    
    // Use main() to test your Line1 class
    public static void main(String[] args) {
        System.out.println("testing Line3");
        // Set myLine to contain a reference to a new line object.
        Line3 myLine = new Line3();
        // Initialize myLine's x1 and y1 to the point (5, 10),
        // and initialize myLine's x2 and y2 to the point (45, 50).
        myLine.p1 = new Point(5, 10);
        myLine.p2 = new Point(45, 50);
        // Print the line's slope, which should be 1 (or, 45 degrees).
        System.out.println("the slope is " + myLine.slope());
        // check that (10,15) is on the line
        System.out.println("is (10,15) on the line? " + myLine.pointOnLine(10, 15));
        // check that the angle between this line and another line
        //  defined by (5,10) and (10,20) is about 1/3
        Line1 anotherLine = new Line1();
        anotherLine.x1 = 5;
        anotherLine.y1 = 10;
        anotherLine.x2 = 10;
        anotherLine.y2 = 20;
        System.out.println("the angle between this line and [(5,10), (10,20)] is " + myLine.angleTo(anotherLine));
    }
}