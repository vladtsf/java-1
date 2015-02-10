package lines;

import java.awt.*;

public class Line3 {

    Point p1, p2;

    // returns the slope of the line.  This is a ratio of rise over run.
    double slope() {

        
    }
    
    // returns true if the point given as parameters is on the line
    // algorithm: check that the lines between this point and our 
    //   other points have the same slope.
    boolean pointOnLine(int x, int y) {

    }
    
    
    // who remembers this stuff?  http://planetmath.org/anglebetweentwolines does.
    double angleTo(Line1 otherLine) {

    }

    
    
    // Use main() to test your Line1 class
    public static void main(String[] args) {
        System.out.println("testing Line3");
        // Set myLine to contain a reference to a new line object.
        Line3 myLine = new Line3();
        // Initialize myLine's x1 and y1 to the point (5, 10),
        // and initialize myLine's x2 and y2 to the point (45, 40).

        // Print the line's slope, which should be 1 (or, 45 degrees).

        // check that (10,15) is on the line

        // check that the angle between this line and another line
        //  defined by (5,10) and (10,20) is about 1/3
    }
}
