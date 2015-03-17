package geometry;

public abstract class Shape {
  private static int lastShapeID;
  protected int shapeID;
  
  Shape() {
    shapeID = lastShapeID++;
  }
  
  public int getID() {
    return shapeID;
  }
  
  @Override
  public String toString() {
    return String.format("type: %s, id: %s", this.getClass(), shapeID);
  }
  
  public abstract void move(int x, int y, int z);
}
