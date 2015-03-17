package geometry;

public class Circle extends TwoDimensionalShape {
  private Point center;
  private int r;
  
  Circle(Point center, int r) {
    this.center = center;
    this.r = r;
  }

  @Override
  public String toString() {
    return "(" + center.toString() + ", " + r + ") " + super.toString();
  }

  @Override
  public double getArea() {
    return Math.PI * Math.pow(r, 2);
  }

  @Override
  public void move(int x, int y, int z) {
    center.move(x, y, z);
  }
}
