package geometry;

public class Line extends OneDimensionalShape {
  private Point p1, p2;
  
  Line(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  @Override
  public String toString() {
    return "(" + p1.toString() + " " + p2.toString() + ") " + super.toString();
  }

  @Override
  public double getLength() {
    Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) 
            + Math.pow(p2.getY() - p1.getY(), 2) 
            + Math.pow(p2.getZ() - p1.getZ(), 2));
    
    return 1;
  }

  @Override
  public void move(int x, int y, int z) {
    p1.move(x, y, z);
    p2.move(x, y, z);
  }
  
  
}
