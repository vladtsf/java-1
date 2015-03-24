import java.util.Comparator;

public class PointComparator implements Comparator<ComparablePoint> {
  
  @Override
  public int compare(ComparablePoint o1, ComparablePoint o2) {
    return o1.getX() - o2.getX();
  }
}
