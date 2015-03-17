package geometry;

public class Point extends ZeroDimensionalShape {
  private int x, y, z;
  
  Point(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  @Override
  public String toString() {
    return String.format("(%d,%d,%d)", x, y, z) + " " + super.toString();
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public int getZ() {
    return z;
  }
  
  public void setX(int value) {
    x = value;
  }
  
  public void setY(int value) {
    y = value;
  }
  
  public void setZ(int value) {
    z = value;
  }

  @Override
  public void move(int x, int y, int z) {
    this.x += x;
    this.y += y;
    this.z += z;
  }
  
}
