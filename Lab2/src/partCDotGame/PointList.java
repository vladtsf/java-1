package partCDotGame;
import java.util.ArrayList;
import java.awt.Point;

public class PointList {
  private ArrayList<Point> points;
//  private ArrayList<Point> toggledPoints;
  private ArrayList<Line> connections = new ArrayList<>();;
  
  PointList(ArrayList<Point> points) {
    this.points = points;
  }
  
  public void togglePoint(Point point) {
    for (Line connection : connections) {
      if(connection.touches(point)) {
        connection.toggle();
      }
    }
  }
  
  public ArrayList<Line> getConnections() {
    return connections;
  }
  
  public ArrayList<Line> getVisibleConnections() {
    ArrayList<Line> result = new ArrayList<>();
    
    for (Line connection : connections) {
      if(connection.isShown()) {
        result.add(connection);
      }
    }
    
    return result;
  }
  
  public void rebuildConnections(boolean closedMode) {
    Point lastPoint = null;
    connections.clear();
    
    for (Point point : points) {
      if(lastPoint != null) {
        connections.add(new Line(lastPoint, point));
      }
      
      lastPoint = point;
    }
    
    if(closedMode) {
      for (int i = 0; i < points.size(); i++) {
        Point p1 = points.get(i);
        Point p2;
        
        for (int j = i + 2; j < points.size(); j++) {
          p2 = points.get(j);
          
          Line connection = new Line(p1, p2);
          connection.toggle(false);
          connections.add(connection);
        }
      }
      
      connections.get(points.size()).toggle(true);
    }
  }
}
