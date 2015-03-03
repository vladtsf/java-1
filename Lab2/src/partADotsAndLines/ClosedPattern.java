package partADotsAndLines;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class ClosedPattern extends DotsAndLines {
  public static void main(String[] args) {
    DotsAndLines me = new ClosedPattern();
  }
  
  protected boolean isClosed = false;
  private double maxDistance = 0;

  // checks if a new point makes the graph closed
  private boolean makesClosed(Point p) {
    if(points.size() < 2) {
      return false;
    }
    
    return closeTo(points.get(0), p);
  };
  
  // this helps make connections brighter
  private void calculateMaxPointDistance() {
    for (int i = 0; i<points.size(); i++) {
      for (int j = i + 2; j < points.size(); j++) {
        Point p1 = points.get(i), p2 = points.get(j);
        double dist = distanceBetween(p1, p2);
        
        if(dist > maxDistance) {
          maxDistance = dist;
        }
      }
    }
  }
  
  // calculates the color associated with a distance
  private Color getDistanceColor(double distance) {
    int shade = (int) (( distance / maxDistance ) * 254);
    return new Color(shade, 50, 50);
  }
  
  // This gets called whenever the user presses their mouse button in the window
  @Override
  public void mousePressed(MouseEvent event) {
    if(isClosed) {
      return;
    }
    
    // where did the user click?
    Point p_clicked = new Point(event.getX(), event.getY());

    if(!makesClosed(p_clicked)) {
      super.mousePressed(event);
    } else {
      isClosed = true;
      calculateMaxPointDistance();
      repaint();
    }
  }
  
  // This gets called whenever Java needs to draw to the window.  
  //   Basic method: first erase the window, then redraw it.  Simple!
  @Override
  public void paintComponent(Graphics g) {
    // erase the window
    erase(g);

    if(isClosed) {        
      for (int i = 0; i<points.size(); i++) {
        for (int j = i + 2; j < points.size(); j++) {
          Point p1 = points.get(i), p2 = points.get(j);
          drawLine(g, p1, p2, getDistanceColor(distanceBetween(p1, p2)));
        }
      }

      drawLine(g, points.get(0), points.get(points.size() - 1), Color.BLACK);
    }

    // draw everything
    int lastIndex = points.size() - 1;

    for (int i = 0; i<points.size(); i++) {
        Point p = points.get(i);
        drawPoint(g, p, Color.red);
        if (i != lastIndex) {
            drawLine(g, p, points.get(i+1), Color.BLACK);
        }
    }
  }
}
