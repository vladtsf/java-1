package geometry;

import java.util.ArrayList;

public class ShapeTester {
  public static void main(String[] args) {
    ArrayList<Shape> shapes = new ArrayList<>();
    
    shapes.add(new Point(0, 0, 0));
    shapes.add(new Line(new Point(0, 0, 0), new Point(5, 5, 5)));
    shapes.add(new Circle(new Point(0, 0, 0), 2));
    shapes.add(new Sphere(new Point(0, 0, 0), 2));
    
    for (Shape shape : shapes) {
      testShape(shape);
      shape.move(1, 2, 3);
      testShape(shape);
    }
  }
  
  public static void testShape(Shape shape) {
    if(shape instanceof ZeroDimensionalShape) {
      System.out.println(shape);
    } if(shape instanceof OneDimensionalShape) {
      System.out.printf("%s length is %f\n", shape, 
              ((OneDimensionalShape) shape).getLength());
    } else if(shape instanceof TwoDimensionalShape) {
      System.out.printf("%s area is %f\n", shape, 
              ((TwoDimensionalShape) shape).getArea());
    } else if(shape instanceof ThreeDimensionalShape) {
      System.out.printf("%s area is %f\n", shape, 
              ((ThreeDimensionalShape) shape).getArea());

      System.out.printf("%s volume is %f\n", shape, 
              ((ThreeDimensionalShape) shape).getVolume());
    }
  }
}
