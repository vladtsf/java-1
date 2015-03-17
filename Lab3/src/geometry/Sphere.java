package geometry;

public class Sphere extends ThreeDimensionalShape {
  private Point center;
  private int r;
  
  Sphere(Point center, int r) {
    this.center = center;
    this.r = r;
  }

  @Override
  public String toString() {
    return "(" + center.toString() + ", " + r + ") " + super.toString();
  }

  @Override
  public double getArea() {
    return 4 * Math.PI * Math.pow(r, 2);
  }

  @Override
  public double getVolume() {
    return (4 * Math.PI * Math.pow(r, 3)) / 3;
  }

  @Override
  public void move(int x, int y, int z) {
    center.move(x, y, z);
  }
}
