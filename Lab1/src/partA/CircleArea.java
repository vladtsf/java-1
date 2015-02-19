package partA;

import java.util.Scanner;
        
public class CircleArea {
  private float r;

  public static void main(String[] args) {
   
    CircleArea ca = new CircleArea(performInput());
    
    System.out.println("For a circle:");
    System.out.format("\tcircumference = %.2f%n", ca.getCircumference());
    System.out.format("\tarea = %.2f%n", ca.getArea());
    
    System.out.println("For a sphere:");
    System.out.format("\tvolume = %.2f%n", ca.getVolume());
    System.out.format("\tsurface area = %.2f%n", ca.getSurfaceArea());
  }
  
  public static float performInput() {
    float val;
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Please specify the radius: ");
    
    try {
      val = scanner.nextFloat();
      if(val >= 0) {
        return val;
      } else {
        System.err.println("Radius value could not be negative");
        return performInput();
      }
    } catch (Exception e) {
      System.err.println("This is unacceptable value!");
      return performInput();
    }
  }
  
  public CircleArea(float radius) {
    r = radius;
  }
  
  public double getCircumference() {
    double circumference = 2 * Math.PI * r;
    return circumference;
  }
  
  public double getArea() {
    double area = Math.PI * Math.pow(r, 2);
    return area;
  }
  
  public double getVolume() {
    double volume = 4 * Math.PI * Math.pow(r, 3) / 3;
    return volume;
  }
  
  public double getSurfaceArea() {
    double area = 4 * Math.PI * Math.pow(r, 2);
    return area;
  }  
}

/* SAMPLE RUN
Please specify the radius: 7.5
For a circle:
	circumference = 47.12
	area = 176.71
For a sphere:
	volume = 1767.15
	surface area = 706.86
*/