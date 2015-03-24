public class ComparablePoint implements Comparable<ComparablePoint> {

  private int x, y;
  
  public class InnerPoint {
    
  }
  
  public int getX() {
    return x;
  }
  
  public void setX(int val) {
    x = val;
  }
  
  public void setY(int val) {
    y = val;
  }
  
  public String toString() {
    return "" + x;
  }
  
  @Override
  public int compareTo(ComparablePoint p) {
    return this.x - p.x;
  }
  
  
}
