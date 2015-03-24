
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {

  public static void main(String[] args) {
    ComparablePoint cp = new ComparablePoint();
    cp.setX(5);

    ComparablePoint cp2 = new ComparablePoint();
    cp2.setX(3);

    ArrayList<ComparablePoint> list = new ArrayList<>();
    list.add(cp);
    list.add(cp2);
    Collections.sort(list);
    System.out.println(list);
    
    list.sort(new PointComparator());
    list.sort(new Comparator<ComparablePoint>() {
        @Override
        public int compare(ComparablePoint p1, ComparablePoint p2) {
          return p1.getX() - p2.getX();
        }
    });

    System.out.println(list);

//    ComparablePoint.InnerPoint ip = new ComparablePoint.InnerPoint();
  }
}
