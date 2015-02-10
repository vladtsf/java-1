package lines;

// Line class with points stored.
// You should change this to use an internal representation of *slope* and 
//  *y-intercept*.  So, the instance variables will change, and some or all
//  of the method declarations.
public class Line2 {

    int b;
    double m;

//    // returns the slope of the line.  This is a ratio of rise over run.
    double slope() {
      return m;
    }
//    
    // returns true if the point given as parameters is on the line
    // algorithm: check that the lines between this point and our 
    //   other points have the same slope.
    boolean pointOnLine(int x, int y) {
      Line1 l1 = new Line1();
      l1.x1 = 0;
      l1.y1 = 0;
      l1.x2 = x;
      l1.y2 = y;
      
      return (l1.slope()==slope());
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
        System.out.println("testing Line2");
        // Set myLine to contain a reference to a new line object.
        Line2 myLine = new Line2();
        // Initialize myLine to have a slope of 1 and a y-intercept of 5.  This
        //  is the same line you initialized in Line1
        myLine.m = 1;
        myLine.b = 5;
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
